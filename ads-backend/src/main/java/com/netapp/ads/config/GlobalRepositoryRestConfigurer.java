package com.netapp.ads.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class GlobalRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.getCorsRegistry().addMapping("/**")
			.allowCredentials(true)
			.allowedHeaders("*")
			.allowedMethods("*")
			.allowedOrigins("*");
	}
}
