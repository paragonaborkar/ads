package com.netapp.ads.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter{

	public CORSFilter () {
	    super();
	}

	@Override
	public final void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
	    final HttpServletResponse response = (HttpServletResponse) res;
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.setHeader("Access-Control-Allow-Methods", "*");
	    response.setHeader("Access-Control-Allow-Headers", "*");
	
	    final HttpServletRequest request = (HttpServletRequest) req;
	    if (!request.getMethod().equals("OPTIONS")) {
	        chain.doFilter(req, res);
	    } else {
	    	response.setStatus(HttpServletResponse.SC_OK);
	    }
	}

	@Override
	public void destroy() {
	
	} 
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {       
	}
	
}