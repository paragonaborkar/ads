package com.netapp.ads;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		
		// TODO: Make this a configuration during the build process. But ensure it's secure.
//		response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");   // http://localhost:3000
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");   // http://localhost:3000
		
		// TODO: Finalize the methods allowed. May need to do this by resource.
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		
//		response.setHeader("Access-Control-Max-Age", "3600");
		
		//TODO: Finalize the headers allowed.
		response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Header, Origin, X-Requested-With, Content-Type, Accept");
				
		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}

}