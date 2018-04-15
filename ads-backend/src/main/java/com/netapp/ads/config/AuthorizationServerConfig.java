package com.netapp.ads.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Value("#{sysConfigRepository.findByPropertyName('security.jwt.client-id').getPropertyValue()}")
	private String clientId;

	@Value("#{sysConfigRepository.findByPropertyName('security.jwt.client-secret').getPropertyValue()}")
	private String clientSecret;

	@Value("#{sysConfigRepository.findByPropertyName('security.jwt.grant-type').getPropertyValue()}")
	private String grantType;

	@Value("#{sysConfigRepository.findByPropertyName('security.jwt.scope-read').getPropertyValue()}")
	private String scopeRead;

	@Value("#{sysConfigRepository.findByPropertyName('security.jwt.scope-write').getPropertyValue()}")
	private String scopeWrite = "write";

	@Value("#{sysConfigRepository.findByPropertyName('security.jwt.resource-ids').getPropertyValue()}")
	private String resourceIds;

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	/**
	 * Setting Client Id and Client Secret in URL
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		configurer
		        .inMemory()
		        .withClient(clientId)
		        .secret(clientSecret)
		        .authorizedGrantTypes(grantType)
		        .scopes(scopeRead, scopeWrite)
		        .resourceIds(resourceIds);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
		enhancerChain.setTokenEnhancers(Arrays.asList(adsTokenEnhancer(), accessTokenConverter));
		
		endpoints.tokenStore(tokenStore)
				.tokenEnhancer(adsTokenEnhancer())
		        .accessTokenConverter(accessTokenConverter)
		        .tokenEnhancer(enhancerChain)
		        .authenticationManager(authenticationManager);
	}
	
	@Bean
    @Primary
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenEnhancer(adsTokenEnhancer());
        return tokenServices;
    }


    @Bean
    public TokenEnhancer adsTokenEnhancer() {
        return new AdsTokenEnhancer();
    }


}
