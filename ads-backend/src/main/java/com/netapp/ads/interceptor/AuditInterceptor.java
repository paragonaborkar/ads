package com.netapp.ads.interceptor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Iterator;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(AuditInterceptor.class);

	boolean isMainEntity = false;
	Object deleteObj, oldUpdate;

	DateUtils dateUtils = new DateUtils();

	/**
	 * Method is called when record is added
	 */
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		if (!(entity instanceof AuditEvent) && !(entity instanceof AuditTrailApi) && !(entity instanceof AuditTrailNativeUser) && !(entity instanceof AuditTrailCorporateUser)) {
			isMainEntity = true;
		} else {
			isMainEntity = false;
		}
		return isMainEntity;

	}

	/**
	 * Method is called when record is updated
	 */
	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) throws CallbackException {

		if (!(entity instanceof AuditEvent) && !(entity instanceof AuditTrailApi) && !(entity instanceof AuditTrailNativeUser) && !(entity instanceof AuditTrailCorporateUser)) {
			oldUpdate = previousState;
			isMainEntity = true;
		} else {
			isMainEntity = false;			
		}
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

		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
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
			// Used ApplicationContext as Autowiring isn't working.
			ApplicationContext ctx = AppContext.getApplicationContext();
			AuditEventRepository auditEventRepositories = ctx.getBean(AuditEventRepository.class);

			// Finding Audit Event based on method and resource pattern.
			AuditEvent auditEvent = auditEventRepositories.findByHttpMethodAndResourcePattern(method, resourcePattern);

			if (auditEvent != null) {
				int auditId = auditEvent.getId();
				UserNativeRepository userNativeRepo = ctx.getBean(UserNativeRepository.class);
				UserApiRepository userApiRepo = ctx.getBean(UserApiRepository.class);
				UserNative userNative = userNativeRepo.findByUserName(userName);
				// Check if which user has performed the action.
				if (userNative != null) {
					AuditTrailNativeUser auditTrailNativeUser = new AuditTrailNativeUser();
					auditTrailNativeUser.setAuditEvent(auditEventRepositories.findOne(auditId));
					// Convert time to UTC.
					auditTrailNativeUser.setCreateTime((Timestamp) dateUtils.convertToUtc());
					auditTrailNativeUser.setUserNativeId(userNative.getId());
					if ("POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method)) {
						// Add new value after adding or updating.
						auditTrailNativeUser.setAuditComment(convertObjectToString(currentObject));
					}
					if ("DELETE".equalsIgnoreCase(method)) {
						// Add deleted value.
						auditTrailNativeUser.setOldValues(convertObjectToString(deleteObj));
					}
					if ("PUT".equalsIgnoreCase(method)) {
						// Add old value after updating.
						auditTrailNativeUser.setOldValues(convertObjectToString(oldUpdate));
					}

					auditTrailNativeUser.setAuditedResource(url);
					AuditTrailNativeUserRepository auditTrailNativeUserRepositories = ctx.getBean(AuditTrailNativeUserRepository.class);
					auditTrailNativeUserRepositories.saveAndFlush(auditTrailNativeUser);
				} else if (userApiRepo != null) {
					UserApi userApi = userApiRepo.findByClientId(userName);
					AuditTrailApi auditTrailApi = new AuditTrailApi();
					auditTrailApi.setAuditEvent(auditEventRepositories.findOne(auditId));
					// Convert time to UTC.
					auditTrailApi.setCreateTime((Timestamp) dateUtils.convertToUtc());
					auditTrailApi.setUserApiId(userApi.getId());
					if ("POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method)) {
						// Add new value after adding or updating.
						auditTrailApi.setAuditComment(convertObjectToString(currentObject));
					}
					if ("DELETE".equalsIgnoreCase(method)) {
						// Add deleted value.
						auditTrailApi.setOldValues(convertObjectToString(deleteObj));
					}
					if ("PUT".equalsIgnoreCase(method)) {
						// Add old value after updating.
						auditTrailApi.setOldValues(convertObjectToString(oldUpdate));
					}
					auditTrailApi.setAuditedResource(url);
					AuditTrailApiRepository auditTrailApiRepositories = ctx.getBean(AuditTrailApiRepository.class);
					auditTrailApiRepositories.saveAndFlush(auditTrailApi);
				}
				isMainEntity = false;
			}
		}
	}

	/**
	 * Convert Object to String.
	 * 
	 * @param object
	 * @return
	 */
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
