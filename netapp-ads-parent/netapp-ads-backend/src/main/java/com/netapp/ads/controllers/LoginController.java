package com.netapp.ads.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.Application;

@RestController
public class LoginController {

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
	
	@RequestMapping(value = "/sso", method = RequestMethod.GET)
	public void loginRedirect(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws ServletException, IOException {
		
		System.out.println(request.getParameter("userId"));
		if (request.getParameter("userId") != null) {
			// FIXME:  THIS IS ONLY A TEMPORANY SOLUTION SO WE CAN LOGIN AS MANY CORP USERS
			Log.error("THIS IS ONLY A TEMPORANY SOLUTION SO WE CAN LOGIN AS MANY CORP USERS");
			Application.ssoWorkAroundId = request.getParameter("userId");
		}
		
			response.sendRedirect(ssoIdpURL);
	}
}
