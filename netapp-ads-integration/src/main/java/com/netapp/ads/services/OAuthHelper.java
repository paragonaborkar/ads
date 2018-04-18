package com.netapp.ads.services;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Service;

@Service
public class OAuthHelper {
	
	@Value("#{sysConfigRepository.findByPropertyName('security.jwt.client-id').getPropertyValue()}")
	private String clientId;

	@Value("#{sysConfigRepository.findByPropertyName('security.jwt.client-secret').getPropertyValue()}")
	private String clientSecret;
	
	@Value("#{sysConfigRepository.findByPropertyName('security.discover.jobs.user').getPropertyValue()}")
	private String jobUser;
	
	@Value("#{sysConfigRepository.findByPropertyName('security.discover.jobs.password').getPropertyValue()}")
	private String jobPassword;
	
	private ClientDetailsService clientDetailsService;
	private JwtAccessTokenConverter jwtAccessTokenConverter;
	private AuthorizationServerTokenServices tokenservice;
	
	@Autowired
	public OAuthHelper(ClientDetailsService clientDetailsService, JwtAccessTokenConverter jwtAccessTokenConverter, AuthorizationServerTokenServices tokenservice) {
		this.clientDetailsService = clientDetailsService;
		this.jwtAccessTokenConverter = jwtAccessTokenConverter;
		this.tokenservice = tokenservice;
	}
	
	 public OAuth2AccessToken createAccessToken() {
	        ClientDetails client = clientDetailsService.loadClientByClientId(clientId);
	        Collection<GrantedAuthority> authorities = client.getAuthorities();
	        Set<String> resourceIds = client.getResourceIds();
	        Set<String> scopes = client.getScope();

	        Map<String, String> requestParameters = Collections.emptyMap();
	        boolean approved = true;
	        String redirectUrl = null;
	        Set<String> responseTypes = Collections.emptySet();
	        Map<String, Serializable> extensionProperties = Collections.emptyMap();

	        OAuth2Request oAuth2Request = new OAuth2Request(requestParameters, clientId, authorities, approved, scopes, resourceIds, redirectUrl, responseTypes, extensionProperties);

	        
	        User userPrincipal = new User(jobUser, jobPassword, true, true, true, true, authorities);
	        
	        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal, null, authorities);
	        OAuth2Authentication auth = new OAuth2Authentication(oAuth2Request, authenticationToken);
	        return jwtAccessTokenConverter.enhance(tokenservice.createAccessToken(auth), auth);
	 }
}
