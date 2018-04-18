package com.netapp.ads.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.Application;

@RestController
//Dont annotate this with /api
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Value("#{sysConfigRepository.findByPropertyName('sso.idp.url').getPropertyValue()}")
	private String ssoIdpURL;

	/**
	 * Redirects to SSO Login Page
	 * 
	 * @param request
	 * @param response
	 * @param auth
	 * @throws ServletException
	 * @throws IOException
	 */

//	private static final String USER_ID_PARAM = "userId";
	private static final String RELAY_STATE_PARAM = "relayState";
	
	@RequestMapping(value = "/sso/{userId}", method = RequestMethod.GET)
	public void loginRedirect(HttpServletRequest request, HttpServletResponse response, Authentication auth,
			@PathVariable(name = "userId", required = true) String userId)
			throws ServletException, IOException {

		log.debug("User ID to use for SSO:" +userId);
		Application.ssoWorkAroundId = userId;
				
		String url = ssoIdpURL + "&" + RELAY_STATE_PARAM + "=" + request.getParameter(RELAY_STATE_PARAM);
		
		log.debug("Redirecting to:" + url);
		response.sendRedirect(url);
	}
}
