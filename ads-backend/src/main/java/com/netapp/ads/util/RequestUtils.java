package com.netapp.ads.util;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class RequestUtils {

	public String currentUserName(HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		return principal.getName();
	}

	public String currentUrlInfo(HttpServletRequest request) {
		return request.getRequestURI().toString();
	}
	
	public String currentMethod(HttpServletRequest request) {
		return request.getMethod();
	}
}
