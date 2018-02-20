package com.netapp.ads.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Value("${sso.idp.url}")
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
	
	@RequestMapping(value = "/sso", method = RequestMethod.GET)
	public void loginRedirect(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws ServletException, IOException {
			response.sendRedirect(ssoIdpURL);
	}
}
