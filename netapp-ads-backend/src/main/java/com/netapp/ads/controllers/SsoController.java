package com.netapp.ads.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value = "/api") // DO NOT ADD API HERE!
public class SsoController {
	private static final Logger log = LoggerFactory.getLogger(SsoController.class);
	
	/*
    QTree Owner - with Key "ABC"
    Email with link: http://localhost:4200/owner/ABC

    if not Auth
        Then build URL to redirect to which is a backend URL:
            http://localhost:8080/saml/sso?RelayState=http://localhost:4200/login?redirectTo=owner/ABC
        
        Need backend contoller to build redirect URL. Params:
            1. redirectTo
            2. Get automatically: Calling URL (http://localhost:4200/)
            3. Get by Backend Config - SSO provider URL (https://idp.ssocircle.com/sso/saml2/jsp/idpSSOInit.jsp?metaAlias=/publicidp&spEntityID=com:paragon:ads:sp&)


        https://idp.ssocircle.com/sso/saml2/jsp/idpSSOInit.jsp?metaAlias=/publicidp&spEntityID=com:paragon:ads:sp&RelayState=http://localhost:4200/login?redirectTo=owner/ABC

		http://localhost:4200/index
	 */

	@Value("#{sysConfigRepository.findByPropertyName('ads.sso.backend.url').getPropertyValue()}")
	private String adsSsoBackendUrl;

	public final static String STR_SSO_REDIRECT_URL = "{\"ssoRedirectUrl\":\"PLACEHOLDER\"}"; 
		
	@RequestMapping(value="/ssoUrl/{owner}/{migKey}/{userId}", method=RequestMethod.GET)
	public  ResponseEntity<?>  ssoUrl(HttpServletRequest request,  HttpServletResponse response, 
//			@RequestParam(name = "redirectTo", required = true) String redirectTo, @RequestParam(name = "userId", required = false) String userId) {
		@PathVariable(name = "owner", required = true) String owner, 
		@PathVariable(name = "migKey", required = true) String migKey, 
		@PathVariable(name = "userId", required = true) String userId) {

		String referrer = request.getHeader(HttpHeaders.REFERER); 

//		String url = adsSsoBackendUrl + "?relayState=" + referrer + "?redirectTo=" + redirectTo + "&userId=" + userId;
//		String url = adsSsoBackendUrl + "?relayState=" + referrer + "&userId=" + userId;
		String url = adsSsoBackendUrl + "/" + userId + "?relayState=" + referrer;
		
		log.debug("url:" + url);
		
		return new ResponseEntity(STR_SSO_REDIRECT_URL.replaceFirst("PLACEHOLDER", url), HttpStatus.OK);	

    }



}
