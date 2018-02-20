package com.netapp.ads.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.netapp.ads.Application;

public class AdsTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		AdsUser user = (AdsUser) authentication.getPrincipal(); // Need to get this as an AdsUser or com.netapp.ads.AdsUserDetails (latter doesn't make sense?)
		
		final Map<String, Object> additionalInfo = new HashMap<>();
		
		Collection<GrantedAuthority> auth = user.getAuthorities();
		
		// Add the modules to the response that the application is licensed to use.
		additionalInfo.put("ads_modules", Application.ACTIVE_MODULES);
		
		additionalInfo.put("email", user.getEmail());
		additionalInfo.put("firstName", user.getFirstName());
		additionalInfo.put("lastName", user.getLastName());
		additionalInfo.put("nativeUserId", user.getNativeUserId());
		additionalInfo.put("corpUserId", user.getCorpUserId());
		additionalInfo.put("userRole", user.getUserRole());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		
		
		return accessToken;
	}
}
