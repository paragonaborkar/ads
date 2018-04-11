package com.netapp.ads.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private ResourceServerTokenServices tokenServices;

    @Value("#{sysConfigRepository.findByPropertyName('security.jwt.resource-ids').getPropertyValue()}")
    private String resourceIds;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }
    
    /**
     * Securing REST API's
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
                http
                	.requestMatchers()
                .and()
                	.authorizeRequests()
                		.antMatchers("/saml/**").permitAll()
                		.antMatchers("/oauth/**").permitAll()
                		.antMatchers("/api/**").authenticated()
                		.antMatchers("/**").permitAll().and().securityContext().securityContextRepository(new TokenSecurityContextRepository());
    }

}
