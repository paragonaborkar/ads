package com.netapp.ads.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.Application;

@RestController
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

	private static final String userIdParam = "userId";
	
	@RequestMapping(value = "/sso", method = RequestMethod.GET)
	public void loginRedirect(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws ServletException, IOException {

		log.debug("User ID to use for SSO:" + request.getParameter(userIdParam));

		if (request.getParameter(userIdParam) != null) {
			// FIXME:  THIS IS ONLY A TEMPORANY SOLUTION SO WE CAN LOGIN AS MANY CORP USERS
			log.error("THIS IS ONLY A TEMPORANY SOLUTION SO WE CAN LOGIN AS MANY CORP USERS");
			Application.ssoWorkAroundId = request.getParameter(userIdParam);
		}
		log.debug("Redirecting to:" + ssoIdpURL);
		response.sendRedirect(ssoIdpURL);
	}
}
