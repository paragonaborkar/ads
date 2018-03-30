package com.netapp.ads.aop;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.netapp.ads.models.AuditEvent;
import com.netapp.ads.models.AuditTrailApi;
import com.netapp.ads.models.AuditTrailNativeUser;
import com.netapp.ads.models.UserApi;
import com.netapp.ads.models.UserNative;
import com.netapp.ads.repos.AuditEventRepository;
import com.netapp.ads.repos.AuditTrailApiRepository;
import com.netapp.ads.repos.AuditTrailNativeUserRepository;
import com.netapp.ads.repos.UserApiRepository;
import com.netapp.ads.repos.UserNativeRepository;
import com.netapp.ads.util.DateUtils;
import com.netapp.ads.util.RequestUtils;

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

		// Check whether the URL has token end point.
		// If the URL has token end point, we have User's email otherwise User's username.
		if (!isLogin(urlInfo)) {
			userName = requestUtils.currentUserName(httpRequest);
			url = urlInfo.substring(1).split("/")[0];
		} else {
			userName = (String) jp.getArgs()[0];
			url = urlInfo.substring(1);
		}

		AuditEvent auditEvent = auditEventRepository.findByHttpMethodAndResourcePattern(method, url);
		if (auditEvent != null) {
			int auditId = auditEvent.getId();
			UserNative userNative;
			UserApi userApi = userApiRepository.findByClientId(userName);

			// Check the URL and find the User based on email or username.
			if (!isLogin(urlInfo)) {
				userNative = userNativeRepository.findByUserName((userName));
			} else {
				userNative = userNativeRepository.findFirstByEmail((userName));
			}

			if (userApi != null) {
				AuditTrailApi auditTrailApi = new AuditTrailApi();
				auditTrailApi.setAuditEvent(auditEventRepository.findOne(auditId));
				auditTrailApi.setUserApiId(userApi.getId());
				// Convert time to UTC.
				auditTrailApi.setCreateTime((Timestamp) dateUtils.convertToUtc());
				auditTrailApi.setAuditedResource(urlInfo);
				
				// Check the URL and audit based on URL.
				if (isLogin(urlInfo)) {
					// Get the password from parameters.
					String[] paramValues = httpRequest.getParameterValues("password");
					String pwd = null;
					if (paramValues.length > 0) {
						pwd = paramValues[0];
					}
					// Encode the User entered password to BCrypt and check it with the one in database.
					// To verify successful or failure login.
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

			} else if (userNative != null) {
				AuditTrailNativeUser auditTrailNativeUser = new AuditTrailNativeUser();
				auditTrailNativeUser.setAuditEvent(auditEventRepository.findOne(auditId));
				auditTrailNativeUser.setUserNativeId(userNative.getId());
				auditTrailNativeUser.setAuditedResource(urlInfo);
				// Convert Time to UTC.
				auditTrailNativeUser.setCreateTime((Timestamp) dateUtils.convertToUtc());
				
				// Check the URL and audit based on URL.
				if (isLogin(urlInfo)) {
					// Get the password from parameters.
					String[] paramValues = httpRequest.getParameterValues("password");
					String pwd = null;
					if (paramValues.length > 0) {
						pwd = paramValues[0];
					}
					// Encode the User entered password to BCrypt and check it with the one in database.
					// To verify successful or failure login.
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
