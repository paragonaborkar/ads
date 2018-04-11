package com.netapp.ads.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opensaml.saml2.metadata.provider.MetadataProviderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.saml.SAMLEntryPoint;
import org.springframework.security.saml.context.SAMLMessageContext;
import org.springframework.security.saml.websso.WebSSOProfileOptions;

public class AdsSAMLEntryPoint extends SAMLEntryPoint {
	
	private static final Logger log = LoggerFactory.getLogger(AdsSAMLEntryPoint.class);

	private String relayState;
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
		String relayState = request.getParameter("RelayState");
		log.debug("Recieved parameter is {}", relayState);
		setRelayState(relayState);
		super.commence(request, response, e);
	}
	
	@Override
	protected WebSSOProfileOptions getProfileOptions(SAMLMessageContext samlMessageContext, AuthenticationException exception) throws MetadataProviderException {
		samlMessageContext.setRelayState(getRelayState());
		WebSSOProfileOptions webSSOProfileOptions = super.getProfileOptions(samlMessageContext, exception);
		webSSOProfileOptions.setRelayState(getRelayState());
		return webSSOProfileOptions;
	}
	
	private void setRelayState(String relayState) {
		this.relayState = relayState;
	}
	
	private String getRelayState() {
		return this.relayState;
	}
	
}
