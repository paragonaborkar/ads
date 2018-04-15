package com.netapp.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

//@Component
//@EnableAuthorizationServer
public class OAuthHelper extends AuthorizationServerConfigurerAdapter {

	@Value("#{sysConfigRepository.findByPropertyName('security.jwt.client-id').getPropertyValue()}")
	//@Value("${security.jwt.client-id}")
	private String clientId;

	@Value("#{sysConfigRepository.findByPropertyName('security.jwt.client-secret').getPropertyValue()}")
	//@Value("${security.jwt.client-secret}")
	private String clientSecret;

	@Value("#{sysConfigRepository.findByPropertyName('security.signing-key').getPropertyValue()}")
	//@Value("${security.signing-key}")
	private String signingKey;

    //@Autowired
    AuthorizationServerTokenServices tokenservice;

    //@Autowired
    ClientDetailsService clientDetailsService;
    
    private MockHttpServletRequest mockServletRequest;
    
    private String bearerToken;
    
    public static final String AUTHORIZATION_HEADER = "Authorization";
    
	//@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(signingKey);
		return converter;
	}

	//TODO clean this to proper expression
    public RequestPostProcessor mockRequestBearerToken() {
    	if(mockServletRequest != null)
    		return (RequestPostProcessor) mockServletRequest;
        return mockRequest -> {
        	if(mockServletRequest == null) {
        		OAuth2AccessToken token = createAccessToken();
        		mockRequest.addHeader(AUTHORIZATION_HEADER, "Bearer " + token.getValue());
        		mockServletRequest = mockRequest;
        	}
        	return mockRequest;
        };
    }
    
	//TODO clean this to proper expression
    public String getBearerToken() {
    	if(bearerToken == null) {
       		OAuth2AccessToken token = createAccessToken();
       		bearerToken = "Bearer " + token.getValue();
        }
        return bearerToken;
    }    

    /**
     * Generate an OAuth Token
     * 
     * @return
     */
    OAuth2AccessToken createAccessToken() {
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

        User userPrincipal = new User("talend", "secret", true, true, true, true, authorities);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal, null, authorities);
        OAuth2Authentication auth = new OAuth2Authentication(oAuth2Request, authenticationToken);
        return accessTokenConverter().enhance(tokenservice.createAccessToken(auth), auth);
    }

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(clientId)
                .secret(clientSecret)
                .authorities("READ");
    }
    
	//@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}    

}