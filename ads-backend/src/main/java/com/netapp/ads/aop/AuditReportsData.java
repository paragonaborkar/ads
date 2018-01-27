package com.netapp.ads.aop;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.netapp.ads.models.AuditEvent;
import com.netapp.ads.models.AuditTrailApi;
import com.netapp.ads.models.AuditTrailApiPK;
import com.netapp.ads.models.AuditTrailNativeUser;
import com.netapp.ads.models.AuditTrailNativeUserPK;
import com.netapp.ads.models.UserApi;
import com.netapp.ads.models.UserNative;
import com.netapp.ads.repos.AuditEventRepository;
import com.netapp.ads.repos.AuditTrailApiRepository;
import com.netapp.ads.repos.AuditTrailNativeUserRepository;
import com.netapp.ads.repos.UserApiRepository;
import com.netapp.ads.repos.UserNativeRepository;
import com.netapp.ads.util.RequestUtils;
import com.netapp.ads.util.DateUtils;

@Component
public class AuditReportsData {

	@Autowired
	private AuditTrailNativeUserRepository auditTrailNativeUserRepository;

	@Autowired
	private AuditTrailApiRepository auditTrailApiRepository;

	@Autowired
	private UserApiRepository userApiRepository;

	@Autowired
	private UserNativeRepository userNativeRepository;

	@Autowired
	private RequestUtils requestUtils;

	@Autowired
	private DateUtils dateUtils;

	@Autowired
	private AuditEventRepository auditEventRepository;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	/**
	 * Auditing specific to Login, Jasper Reports and Email
	 * 
	 * @param jp
	 */
	public void auditData(JoinPoint jp) {
		HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		String urlInfo = requestUtils.currentUrlInfo(httpRequest);
		String method = requestUtils.currentMethod(httpRequest);
		String userName, url;

		if (!isLogin(urlInfo)) {
			userName = requestUtils.currentUserName(httpRequest);
			url = urlInfo.substring(1).split("/")[0];

		} else {
			userName = (String) jp.getArgs()[0];
			url = urlInfo.substring(1);
		}

		List<AuditEvent> auditEvent = auditEventRepository.findByHttpMethodAndResourcePattern(method, url);
		if (!auditEvent.isEmpty()) {
			AuditEvent audit = auditEvent.get(0);
			int auditId = audit.getId();

			List<UserNative> firstUserNative;
			List<UserApi> firstUserApi = userApiRepository.findByClientId(userName);

			if (!isLogin(urlInfo)) {
				firstUserNative = userNativeRepository.findByUserName((userName));
			} else {
				firstUserNative = userNativeRepository.findByEmail((userName));
			}

			if (!firstUserApi.isEmpty()) {
				UserApi userApi = firstUserApi.get(0);
				AuditTrailApi auditTrailApi = new AuditTrailApi();
				AuditTrailApiPK auditTrailApiPK = new AuditTrailApiPK();
				auditTrailApiPK.setAuditEventId(auditId);
				auditTrailApi.setId(auditTrailApiPK);
				auditTrailApi.setUserApiId(userApi.getId());
				auditTrailApi.setCreateTime((Timestamp) dateUtils.convertToUtc());
				auditTrailApi.setAuditedResource(urlInfo);

				if (isLogin(urlInfo)) {
					String[] paramValues = httpRequest.getParameterValues("password");
					String pwd = null;
					if (paramValues.length > 0) {
						pwd = paramValues[0];
					}
					if (bcryptPasswordEncoder.matches(pwd, userApi.getClientSecret())) {
						auditTrailApi.setAuditComment("Login Success");
					} else {
						auditTrailApi.setAuditComment("Login Failure");
					}
				} else if (urlInfo.contains("htmlReport") || urlInfo.contains("downloadReport")) {
					auditTrailApi.setAuditComment("Report Generated");
				} else if (urlInfo.contains("hello")) {
					auditTrailApi.setAuditComment("Email Sent");
				}
				auditTrailApiRepository.saveAndFlush(auditTrailApi);

			} else if (!firstUserNative.isEmpty()) {

				UserNative userNative = firstUserNative.get(0);
				AuditTrailNativeUser auditTrailNativeUser = new AuditTrailNativeUser();
				AuditTrailNativeUserPK auditTrailNativeUserPK = new AuditTrailNativeUserPK();
				auditTrailNativeUserPK.setAuditEventId(auditId);
				auditTrailNativeUser.setId(auditTrailNativeUserPK);
				auditTrailNativeUser.setUserNativeId(userNative.getId());
				auditTrailNativeUser.setAuditedResource(urlInfo);
				auditTrailNativeUser.setCreateTime((Timestamp) dateUtils.convertToUtc());

				if (isLogin(urlInfo)) {
					String[] paramValues = httpRequest.getParameterValues("password");
					String pwd = null;
					if (paramValues.length > 0) {
						pwd = paramValues[0];
					}
					if (bcryptPasswordEncoder.matches(pwd, userNative.getPassword())) {
						auditTrailNativeUser.setAuditComment("Login Success");
					} else {
						auditTrailNativeUser.setAuditComment("Login Failure");
					}
				} else if (urlInfo.contains("htmlReport") || urlInfo.contains("downloadReport")) {
					auditTrailNativeUser.setAuditComment("Report Generated");
				} else if (urlInfo.contains("hello")) {
					auditTrailNativeUser.setAuditComment("Email Sent");
					auditTrailNativeUser.setAuditedResource("audit resource ");
				}
				auditTrailNativeUserRepository.saveAndFlush(auditTrailNativeUser);
			}
		}
	}

	public boolean isLogin(String url) {
		return url.contains("oauth/token");
	}
}
