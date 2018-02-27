package com.netapp.ads.config;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.providers.ExpiringUsernameAuthenticationToken;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;

import com.netapp.ads.util.TokenUtil;


@Service
public class TokenSecurityContextRepository implements SecurityContextRepository {

	public static ConcurrentHashMap<String, SecurityContext> mapCache = new ConcurrentHashMap<>();

	/**
	 * Get Authenticated Object after Login to SSO
	 */
	@Override
	public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
		if (this.containsContext(requestResponseHolder.getRequest())) {
			String token = TokenUtil.getToken(requestResponseHolder.getRequest());

			SecurityContext context = (SecurityContext) mapCache.get(token);
			if(context != null)
				SecurityContextHolder.getContext().setAuthentication(context.getAuthentication());
			return context;
		} else
			return SecurityContextHolder.getContext();
	}

	@Override
	public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = context.getAuthentication();
		if (auth != null && auth.isAuthenticated() &&  auth instanceof ExpiringUsernameAuthenticationToken) {
			String sessionId = TokenUtil.getToken(request);
			if(mapCache.get(sessionId) == null) {
				mapCache.put(sessionId, context);
			}
		}
	}

	@Override
	public boolean containsContext(HttpServletRequest request) {
		String token = TokenUtil.getToken(request);
		if (token != null) {
			SecurityContext context = (SecurityContext) mapCache.get(token);
			if(context != null)
				SecurityContextHolder.getContext().setAuthentication(context.getAuthentication());
			return context != null;
		} else {
			return false;
		}
	}

}
