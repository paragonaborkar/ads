package com.netapp.ads.interceptor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.netapp.ads.exception.NetAppAdsException;
import com.netapp.ads.models.AuditEvent;
import com.netapp.ads.models.AuditTrailApi;
import com.netapp.ads.models.AuditTrailCorporateUser;
import com.netapp.ads.models.AuditTrailNativeUser;
import com.netapp.ads.models.UserApi;
import com.netapp.ads.models.UserNative;
import com.netapp.ads.repos.AuditEventRepository;
import com.netapp.ads.repos.AuditTrailApiRepository;
import com.netapp.ads.repos.AuditTrailNativeUserRepository;
import com.netapp.ads.repos.UserApiRepository;
import com.netapp.ads.repos.UserNativeRepository;
import com.netapp.ads.util.DateUtils;

@Component
public class AuditInterceptor extends EmptyInterceptor {

	private static final Logger log = LoggerFactory.getLogger(AuditInterceptor.class);

	boolean isMainEntity = false;
	Object deleteObj, oldUpdate;

	DateUtils dateUtils = new DateUtils();

	/**
	 * Method is called when record is added
	 */
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		if (!(entity instanceof AuditEvent) && !(entity instanceof AuditTrailApi)
				&& !(entity instanceof AuditTrailNativeUser) && !(entity instanceof AuditTrailCorporateUser)) {

			isMainEntity = true;
			return true;
		}
		isMainEntity = false;
		return isMainEntity;

	}

	/**
	 * Method is called when record is updated
	 */
	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) throws CallbackException {

		if (!(entity instanceof AuditEvent) && !(entity instanceof AuditTrailApi)
				&& !(entity instanceof AuditTrailNativeUser) && !(entity instanceof AuditTrailCorporateUser)) {

			oldUpdate = previousState;
			isMainEntity = true;
			return true;
		}
		isMainEntity = false;
		return isMainEntity;
	}

	/**
	 * Method is called when record is deleted
	 */
	@Override
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		deleteObj = entity;
		isMainEntity = true;
	}

	/**
	 * Called after committed into database
	 */
	@Override
	public void postFlush(Iterator entities) {

		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		String url = request.getRequestURI();
		String resourcePattern = url.substring(1).split("/")[0];
		String userName = request.getUserPrincipal().getName();
		String method = request.getMethod();
		Object currentObject;

		if (isMainEntity) {
			if ("POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method)) {
				currentObject = entities.next();
			} else {
				currentObject = null;
			}
			
			ApplicationContext ctx = AppContext.getApplicationContext();
			UserApiRepository userApiRepo = ctx.getBean(UserApiRepository.class);
			UserNativeRepository userNativeRepo = ctx.getBean(UserNativeRepository.class);

			AuditTrailApiRepository auditTrailApiRepositories = ctx.getBean(AuditTrailApiRepository.class);
			AuditTrailNativeUserRepository auditTrailNativeUserRepositories = ctx
					.getBean(AuditTrailNativeUserRepository.class);

			AuditEventRepository auditEventRepositories = ctx.getBean(AuditEventRepository.class);

			// Finding Audit Event
			List<AuditEvent> auditEvent = auditEventRepositories.findByHttpMethodAndResourcePattern(method,
					resourcePattern);

			if (!auditEvent.isEmpty()) {
				AuditEvent audit = auditEvent.get(0);
				int auditId = audit.getId();

				List<UserApi> newUserApi = userApiRepo.findByClientId(userName);
				List<UserNative> newUserNative = userNativeRepo.findByUserName(userName);

				if (!newUserNative.isEmpty()) {
					log.debug("***: " + getClass().getName() + ": postFlush: in first if");
					UserNative userNative = newUserNative.get(0);

					AuditTrailNativeUser auditTrailNativeUser = new AuditTrailNativeUser();
					// AuditTrailNativeUserPK auditTrailNativeUserPK = new AuditTrailNativeUserPK();
					// auditTrailNativeUserPK.setAuditEventId(auditId);
					// auditTrailNativeUser.setId(auditTrailNativeUserPK);
					auditTrailNativeUser.setAuditEvent(auditEventRepositories.findOne(auditId));
					auditTrailNativeUser.setCreateTime((Timestamp) dateUtils.convertToUtc());
					auditTrailNativeUser.setUserNativeId(userNative.getId());
					if ("POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method)) {
						auditTrailNativeUser.setAuditComment(convertObjectToString(currentObject));
					}
					if ("DELETE".equalsIgnoreCase(method)) {
						auditTrailNativeUser.setOldValues(convertObjectToString(deleteObj));
					}
					if ("PUT".equalsIgnoreCase(method)) {
						auditTrailNativeUser.setOldValues(convertObjectToString(oldUpdate));
					}

					auditTrailNativeUser.setAuditedResource(url);
					auditTrailNativeUserRepositories.saveAndFlush(auditTrailNativeUser);
				} else if (!newUserApi.isEmpty()) {
					UserApi userApi = newUserApi.get(0);

					AuditTrailApi auditTrailApi = new AuditTrailApi();
					// AuditTrailApiPK auditTrailApiPK = new AuditTrailApiPK();
					// auditTrailApiPK.setAuditEventId(auditId);
					// auditTrailApi.setId(auditTrailApiPK);
					auditTrailApi.setAuditEvent(auditEventRepositories.findOne(auditId));
					auditTrailApi.setCreateTime((Timestamp) dateUtils.convertToUtc());
					auditTrailApi.setUserApiId(userApi.getId());

					if ("POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method)) {
						auditTrailApi.setAuditComment(convertObjectToString(currentObject));
					}
					if ("DELETE".equalsIgnoreCase(method)) {
						auditTrailApi.setOldValues(convertObjectToString(deleteObj));
					}
					if ("PUT".equalsIgnoreCase(method)) {
						auditTrailApi.setOldValues(convertObjectToString(oldUpdate));
					}
					auditTrailApi.setAuditedResource(url);
					auditTrailApiRepositories.saveAndFlush(auditTrailApi);
				}
				isMainEntity = false;
			}
		}
	}

	public String convertObjectToString(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		Hibernate5Module hibernate5Module = new Hibernate5Module();
		mapper.registerModule(hibernate5Module);
		try {
		    String response= mapper.writeValueAsString(object);
			return response;
		} catch (JsonProcessingException e) {
			throw new NetAppAdsException("Error while parsing Object To Json");
		}
	}

}
