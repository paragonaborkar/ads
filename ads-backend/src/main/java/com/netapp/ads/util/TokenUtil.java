package com.netapp.ads.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

public class TokenUtil {

	public static String checkCookieFromResponse(HttpServletResponse response) {
		if (response.getHeader("SET-COOKIE") != null) {
			String header = new String(response.getHeader("SET-COOKIE").getBytes());
			return header.substring(header.indexOf("=") + 1,
					(header.indexOf(";") != -1 ? header.indexOf(";") : header.length()));
		}
		return null;
	}

	public static String getToken(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String token = request.getHeader("X-API-TOKEN");
		if (StringUtils.isEmpty(token)) {
			return checkCookie(request);
		} else {
			return token;
		}
	}

	public static String checkCookie(HttpServletRequest request) {
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals("JSESSIONID")) {
					return cookie.getValue();
				}
			}
		}

		return null;
	}
}
