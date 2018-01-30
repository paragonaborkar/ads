package com.netapp.ads.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.netapp.ads.util.RequestUtils;

@Aspect
@Component
public class AuditingAspect {

	@Autowired
	private AuditReportsData auditResportsData;
	
	@Autowired
	private RequestUtils requestUtils;
	
	/**
	 * Aspect called after completion of Jasper Controller Methods
	 * @param jp
	 */
	@AfterReturning("execution(* com.netapp.ads.controllers.JasperReportControllers.*(..))")
	public void afterExecution(JoinPoint jp) {
		auditResportsData.auditData(jp);
	}
	
	/**
	 * Aspect called after User Authentication
	 * @param jp
	 */
	@AfterReturning("execution(* com.netapp.ads.services.UserDetailsServiceImpl.*(..))")
	public void afterUserLoggedIn(JoinPoint jp) {
		HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String username = requestUtils.currentUserName(httpRequest);
		if(username != null) {
		auditResportsData.auditData(jp);
		}
	}
	
	/**
	 * Aspect called after completion of EMail Controller
	 * @param jp
	 */
	@AfterReturning("execution(* com.netapp.ads.controllers.EmailController.*(..))")
	public void afterEmail(JoinPoint jp) {
		auditResportsData.auditData(jp);
	}
	
}
