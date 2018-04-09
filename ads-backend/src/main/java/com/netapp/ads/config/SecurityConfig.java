package com.netapp.ads.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.velocity.app.VelocityEngine;
import org.opensaml.saml2.metadata.provider.HTTPMetadataProvider;
import org.opensaml.saml2.metadata.provider.MetadataProvider;
import org.opensaml.saml2.metadata.provider.MetadataProviderException;
import org.opensaml.xml.parse.ParserPool;
import org.opensaml.xml.parse.StaticBasicParserPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.providers.ExpiringUsernameAuthenticationToken;
import org.springframework.security.saml.SAMLAuthenticationProvider;
import org.springframework.security.saml.SAMLBootstrap;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.SAMLDiscovery;
import org.springframework.security.saml.SAMLEntryPoint;
import org.springframework.security.saml.SAMLLogoutFilter;
import org.springframework.security.saml.SAMLLogoutProcessingFilter;
import org.springframework.security.saml.SAMLProcessingFilter;
import org.springframework.security.saml.SAMLRelayStateSuccessHandler;
import org.springframework.security.saml.SAMLWebSSOHoKProcessingFilter;
import org.springframework.security.saml.context.SAMLContextProviderImpl;
import org.springframework.security.saml.key.JKSKeyManager;
import org.springframework.security.saml.key.KeyManager;
import org.springframework.security.saml.log.SAMLDefaultLogger;
import org.springframework.security.saml.metadata.CachingMetadataManager;
import org.springframework.security.saml.metadata.ExtendedMetadata;
import org.springframework.security.saml.metadata.ExtendedMetadataDelegate;
import org.springframework.security.saml.metadata.MetadataDisplayFilter;
import org.springframework.security.saml.metadata.MetadataGenerator;
import org.springframework.security.saml.metadata.MetadataGeneratorFilter;
import org.springframework.security.saml.parser.ParserPoolHolder;
import org.springframework.security.saml.processor.HTTPArtifactBinding;
import org.springframework.security.saml.processor.HTTPPAOS11Binding;
import org.springframework.security.saml.processor.HTTPPostBinding;
import org.springframework.security.saml.processor.HTTPRedirectDeflateBinding;
import org.springframework.security.saml.processor.HTTPSOAP11Binding;
import org.springframework.security.saml.processor.SAMLBinding;
import org.springframework.security.saml.processor.SAMLProcessorImpl;
import org.springframework.security.saml.trust.httpclient.TLSProtocolConfigurer;
import org.springframework.security.saml.trust.httpclient.TLSProtocolSocketFactory;
import org.springframework.security.saml.util.VelocityFactory;
import org.springframework.security.saml.websso.ArtifactResolutionProfile;
import org.springframework.security.saml.websso.ArtifactResolutionProfileImpl;
import org.springframework.security.saml.websso.SingleLogoutProfile;
import org.springframework.security.saml.websso.SingleLogoutProfileImpl;
import org.springframework.security.saml.websso.WebSSOProfile;
import org.springframework.security.saml.websso.WebSSOProfileConsumer;
import org.springframework.security.saml.websso.WebSSOProfileConsumerHoKImpl;
import org.springframework.security.saml.websso.WebSSOProfileConsumerImpl;
import org.springframework.security.saml.websso.WebSSOProfileECPImpl;
import org.springframework.security.saml.websso.WebSSOProfileImpl;
import org.springframework.security.saml.websso.WebSSOProfileOptions;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.netapp.ads.Application;
import com.netapp.ads.filter.CORSFilter;
import com.netapp.ads.services.SAMLUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);

	@Value("#{sysConfigRepository.findByPropertyName('sso.sp.entityId').getPropertyValue()}")
	private String ssoSpEntityId;

	@Value("#{sysConfigRepository.findByPropertyName('security.signing-key').getPropertyValue()}")
	private String signingKey;

	@Value("#{sysConfigRepository.findByPropertyName('security.encoding-strength').getPropertyValue()}")
	private Integer encodingStrength;

	@Value("#{sysConfigRepository.findByPropertyName('security.security-realm').getPropertyValue()}")
	private String securityRealm;

	@Value("#{sysConfigRepository.findByPropertyName('sso.success.redirect.url').getPropertyValue()}")
	private String successRedirectURL;

	@Value("#{sysConfigRepository.findByPropertyName('sso.token.endpoint.url').getPropertyValue()}")
	private String tokenEndPointURL;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private SAMLUserDetailsServiceImpl samlUserDetailsServiceImpl;

	@Autowired
	private CORSFilter corsFilter;

	@Autowired
	private RestTemplate restTemplate;

	private Timer backgroundTaskTimer;
	private MultiThreadedHttpConnectionManager multiThreadedHttpConnectionManager;
	public static Map<String, String> authAssertionIdUserNameCache = new HashMap<>();

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	// Initialization of OpenSAML library
	@Bean
	public static SAMLBootstrap sAMLBootstrap() {
		return new SAMLBootstrap();
	}

	/**
	 * Encodes password to BCrypt
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

		auth.authenticationProvider(samlAuthenticationProvider());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
		web.ignoring().antMatchers("/saml/**");
		web.ignoring().antMatchers("/sso");
		web.ignoring().antMatchers("/ssoUrl");
		web.ignoring().antMatchers("/favicon.ico");
		web.ignoring().antMatchers("/remoteLog");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.addFilterBefore(corsFilter, ChannelProcessingFilter.class).httpBasic().realmName(securityRealm).and()
				.csrf().disable().securityContext().securityContextRepository(tokenSecurityContextRepository());

		http.antMatcher("/saml/**").httpBasic()
				.authenticationEntryPoint(samlEntryPoint()).and().csrf().disable()
				.addFilterBefore(metadataGeneratorFilter(), ChannelProcessingFilter.class)
				.addFilterAfter(samlFilter(), BasicAuthenticationFilter.class).authorizeRequests().anyRequest()
				.authenticated();

	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(signingKey);
		return converter;
	}

	@Bean
	public SecurityContextRepository tokenSecurityContextRepository() {
		return new TokenSecurityContextRepository();
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Primary // Making this primary to avoid any accidental duplication with another token
				// service instance of the same name
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setSupportRefreshToken(true);
		return defaultTokenServices;
	}

	@PostConstruct
	public void init() {
		this.backgroundTaskTimer = new Timer(true);
		this.multiThreadedHttpConnectionManager = new MultiThreadedHttpConnectionManager();
	}

	@PreDestroy
	public void destroy() {
		this.backgroundTaskTimer.purge();
		this.backgroundTaskTimer.cancel();
		this.multiThreadedHttpConnectionManager.shutdown();
	}

	// Initialization of the velocity engine
	@Bean
	public VelocityEngine velocityEngine() {
		return VelocityFactory.getEngine();
	}

	// XML parser pool needed for OpenSAML parsing
	@Bean(initMethod = "initialize")
	public StaticBasicParserPool parserPool() {
		return new StaticBasicParserPool();
	}

	@Bean(name = "parserPoolHolder")
	public ParserPoolHolder parserPoolHolder() {
		return new ParserPoolHolder();
	}

	// Bindings, encoders and decoders used for creating and parsing messages
	@Bean
	public HttpClient httpClient() {
		return new HttpClient(this.multiThreadedHttpConnectionManager);
	}

	// SAML Authentication Provider responsible for validating of received SAML
	// messages
	@Bean
	public SAMLAuthenticationProvider samlAuthenticationProvider() {
		SAMLAuthenticationProvider samlAuthenticationProvider = new SAMLAuthenticationProvider();
		samlAuthenticationProvider.setUserDetails(samlUserDetailsServiceImpl);
		samlAuthenticationProvider.setForcePrincipalAsString(false);
		return samlAuthenticationProvider;
	}

	// Provider of default SAML Context
	@Bean
	public SAMLContextProviderImpl contextProvider() {
		return new SAMLContextProviderImpl();
	}

	// Logger for SAML messages and events
	@Bean
	public SAMLDefaultLogger samlLogger() {
		return new SAMLDefaultLogger();
	}

	// SAML 2.0 WebSSO Assertion Consumer
	@Bean
	public WebSSOProfileConsumer webSSOprofileConsumer() {
		return new WebSSOProfileConsumerImpl();
	}

	// SAML 2.0 Holder-of-Key WebSSO Assertion Consumer
	@Bean
	public WebSSOProfileConsumerHoKImpl hokWebSSOprofileConsumer() {
		return new WebSSOProfileConsumerHoKImpl();
	}

	// SAML 2.0 Web SSO profile
	@Bean
	public WebSSOProfile webSSOprofile() {
		return new WebSSOProfileImpl();
	}

	// SAML 2.0 Holder-of-Key Web SSO profile
	@Bean
	public WebSSOProfileConsumerHoKImpl hokWebSSOProfile() {
		return new WebSSOProfileConsumerHoKImpl();
	}

	// SAML 2.0 ECP profile
	@Bean
	public WebSSOProfileECPImpl ecpprofile() {
		return new WebSSOProfileECPImpl();
	}

	@Bean
	public SingleLogoutProfile logoutprofile() {
		return new SingleLogoutProfileImpl();
	}

	// Central storage of cryptographic keys
	@Bean
	public KeyManager keyManager() {
		DefaultResourceLoader loader = new DefaultResourceLoader();
		Resource storeFile = loader.getResource("classpath:/saml/samlKeystore.jks");
		String storePass = "nalle123";
		Map<String, String> passwords = new HashMap<String, String>();
		passwords.put("apollo", "nalle123");
		String defaultKey = "apollo";
		return new JKSKeyManager(storeFile, storePass, passwords, defaultKey);
	}

	// Setup TLS Socket Factory
	@Bean
	public TLSProtocolConfigurer tlsProtocolConfigurer() {
		return new TLSProtocolConfigurer();
	}

	@Bean
	public ProtocolSocketFactory socketFactory() {
		return new TLSProtocolSocketFactory(keyManager(), null, "default");
	}

	@Bean
	public Protocol socketFactoryProtocol() {
		return new Protocol("https", socketFactory(), 443);
	}

	@Bean
	public MethodInvokingFactoryBean socketFactoryInitialization() {
		MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
		methodInvokingFactoryBean.setTargetClass(Protocol.class);
		methodInvokingFactoryBean.setTargetMethod("registerProtocol");
		Object[] args = { "https", socketFactoryProtocol() };
		methodInvokingFactoryBean.setArguments(args);
		return methodInvokingFactoryBean;
	}

	@Bean
	public WebSSOProfileOptions defaultWebSSOProfileOptions() {
		WebSSOProfileOptions webSSOProfileOptions = new WebSSOProfileOptions();
		webSSOProfileOptions.setIncludeScoping(false);
		return webSSOProfileOptions;
	}

	// Entry point to initialize authentication, default values taken from
	// properties file
	@Bean
	public SAMLEntryPoint samlEntryPoint() {
		SAMLEntryPoint samlEntryPoint = new SAMLEntryPoint();
		samlEntryPoint.setDefaultProfileOptions(defaultWebSSOProfileOptions());
		return samlEntryPoint;
	}

	// Setup advanced info about metadata
	@Bean
	public ExtendedMetadata extendedMetadata() {
		ExtendedMetadata extendedMetadata = new ExtendedMetadata();
		extendedMetadata.setIdpDiscoveryEnabled(true);
		extendedMetadata.setSignMetadata(false);
		return extendedMetadata;
	}

	// IDP Discovery Service
	@Bean
	public SAMLDiscovery samlIDPDiscovery() {
		SAMLDiscovery idpDiscovery = new SAMLDiscovery();
		idpDiscovery.setIdpSelectionPath("/saml/idpSelection");
		return idpDiscovery;
	}

	@Bean
	@Qualifier("idp-ssocircle")
	public ExtendedMetadataDelegate ssoCircleExtendedMetadataProvider() throws MetadataProviderException {
		String idpSSOCircleMetadataURL = "http://idp.ssocircle.com/idp-meta.xml";
		HTTPMetadataProvider httpMetadataProvider = new HTTPMetadataProvider(this.backgroundTaskTimer, httpClient(),
				idpSSOCircleMetadataURL);
		httpMetadataProvider.setParserPool(parserPool());
		ExtendedMetadataDelegate extendedMetadataDelegate = new ExtendedMetadataDelegate(httpMetadataProvider,
				extendedMetadata());
		extendedMetadataDelegate.setMetadataTrustCheck(true);
		extendedMetadataDelegate.setMetadataRequireSignature(false);
		backgroundTaskTimer.purge();
		return extendedMetadataDelegate;
	}

	// IDP Metadata configuration - paths to metadata of IDPs in circle of trust
	// is here
	// Do no forget to call iniitalize method on providers
	@Bean
	@Qualifier("metadata")
	public CachingMetadataManager metadata() throws MetadataProviderException {
		List<MetadataProvider> providers = new ArrayList<MetadataProvider>();
		providers.add(ssoCircleExtendedMetadataProvider());
		return new CachingMetadataManager(providers);
	}

	// Filter automatically generates default SP metadata
	@Bean
	public MetadataGenerator metadataGenerator() {
		MetadataGenerator metadataGenerator = new MetadataGenerator();
		metadataGenerator.setEntityId(ssoSpEntityId);
		metadataGenerator.setExtendedMetadata(extendedMetadata());
		metadataGenerator.setIncludeDiscoveryExtension(true);
		metadataGenerator.setKeyManager(keyManager());
		return metadataGenerator;
	}

	// The filter is waiting for connections on URL suffixed with filterSuffix
	// and presents SP metadata there
	@Bean
	public MetadataDisplayFilter metadataDisplayFilter() {
		return new MetadataDisplayFilter();
	}

	// Handler deciding where to redirect user after successful login
	@Bean
	public SAMLRelayStateSuccessHandler successHandler() {
		
		SAMLRelayStateSuccessHandler sAMLRelayStateSuccessHandler = new SAMLRelayStateSuccessHandler() {
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication auth) throws ServletException, IOException {
				Object credentials = auth.getCredentials();
		        if (credentials instanceof SAMLCredential) {
		            SAMLCredential samlCredential = (SAMLCredential) credentials;
		            String relayStateURL = getTargetURL(samlCredential.getRelayState());
		            String token = null;
		            	try {
							token = generateTokenForSAML(auth);
						} catch (Exception e) {
							response.sendRedirect(successRedirectURL + "&error=" + "Error in SSO Login");
						}
		            	log.debug("successHandler(): token: {}", token);
		            	if (token != null) {
							final byte[] authBytes = token.getBytes(StandardCharsets.UTF_8);
							final String encodedToken = Base64.getEncoder().encodeToString(authBytes);
							if(relayStateURL != null) {
								String url = relayStateURL + "&response=" + encodedToken;
								log.debug("relayStateURL:" + url);
								response.sendRedirect(url);
							} else {
								String url = successRedirectURL + "&response=" + encodedToken;
								log.debug("successRedirectURL:" + url);
								response.sendRedirect(url);
							}
							SecurityContextHolder.clearContext();
						}
		            }
		        }
			
		};
		return sAMLRelayStateSuccessHandler;
		
	}

	// Handler deciding where to redirect user after failed login
	@Bean
	public SimpleUrlAuthenticationFailureHandler authenticationFailureHandler() {
		SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();
		failureHandler.setUseForward(true);
		failureHandler.setDefaultFailureUrl("/error");
		return failureHandler;
	}

	@Bean
	public SAMLWebSSOHoKProcessingFilter samlWebSSOHoKProcessingFilter() throws Exception {
		SAMLWebSSOHoKProcessingFilter samlWebSSOHoKProcessingFilter = new SAMLWebSSOHoKProcessingFilter();
		samlWebSSOHoKProcessingFilter.setAuthenticationSuccessHandler(successHandler());
		samlWebSSOHoKProcessingFilter.setAuthenticationManager(authenticationManager());
		samlWebSSOHoKProcessingFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
		return samlWebSSOHoKProcessingFilter;
	}

	// Processing filter for WebSSO profile messages
	@Bean
	public SAMLProcessingFilter samlWebSSOProcessingFilter() throws Exception {
		SAMLProcessingFilter samlWebSSOProcessingFilter = new SAMLProcessingFilter();
		samlWebSSOProcessingFilter.setAuthenticationManager(authenticationManager());
		samlWebSSOProcessingFilter.setAuthenticationSuccessHandler(successHandler());
		samlWebSSOProcessingFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
		return samlWebSSOProcessingFilter;
	}

	@Bean
	public MetadataGeneratorFilter metadataGeneratorFilter() {
		return new MetadataGeneratorFilter(metadataGenerator());
	}

	// Handler for successful logout
	@Bean
	public SimpleUrlLogoutSuccessHandler successLogoutHandler() {
		SimpleUrlLogoutSuccessHandler successLogoutHandler = new SimpleUrlLogoutSuccessHandler();
		successLogoutHandler.setDefaultTargetUrl("/");
		return successLogoutHandler;
	}

	// Logout handler terminating local session
	@Bean
	public SecurityContextLogoutHandler logoutHandler() {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.setInvalidateHttpSession(true);
		logoutHandler.setClearAuthentication(true);
		return logoutHandler;
	}

	// Filter processing incoming logout messages
	// First argument determines URL user will be redirected to after successful
	// global logout
	@Bean
	public SAMLLogoutProcessingFilter samlLogoutProcessingFilter() {
		return new SAMLLogoutProcessingFilter(successLogoutHandler(), logoutHandler());
	}

	// Overrides default logout processing filter with the one processing SAML
	// messages
	@Bean
	public SAMLLogoutFilter samlLogoutFilter() {
		return new SAMLLogoutFilter(successLogoutHandler(), new LogoutHandler[] { logoutHandler() },
				new LogoutHandler[] { logoutHandler() });
	}

	// Bindings
	private ArtifactResolutionProfile artifactResolutionProfile() {
		final ArtifactResolutionProfileImpl artifactResolutionProfile = new ArtifactResolutionProfileImpl(httpClient());
		artifactResolutionProfile.setProcessor(new SAMLProcessorImpl(soapBinding()));
		return artifactResolutionProfile;
	}

	@Bean
	public HTTPArtifactBinding artifactBinding(ParserPool parserPool, VelocityEngine velocityEngine) {
		return new HTTPArtifactBinding(parserPool, velocityEngine, artifactResolutionProfile());
	}

	@Bean
	public HTTPSOAP11Binding soapBinding() {
		return new HTTPSOAP11Binding(parserPool());
	}

	@Bean
	public HTTPPostBinding httpPostBinding() {
		return new HTTPPostBinding(parserPool(), velocityEngine());
	}

	@Bean
	public HTTPRedirectDeflateBinding httpRedirectDeflateBinding() {
		return new HTTPRedirectDeflateBinding(parserPool());
	}

	@Bean
	public HTTPSOAP11Binding httpSOAP11Binding() {
		return new HTTPSOAP11Binding(parserPool());
	}

	@Bean
	public HTTPPAOS11Binding httpPAOS11Binding() {
		return new HTTPPAOS11Binding(parserPool());
	}

	// Processor
	@Bean
	public SAMLProcessorImpl processor() {
		Collection<SAMLBinding> bindings = new ArrayList<SAMLBinding>();
		bindings.add(httpRedirectDeflateBinding());
		bindings.add(httpPostBinding());
		bindings.add(artifactBinding(parserPool(), velocityEngine()));
		bindings.add(httpSOAP11Binding());
		bindings.add(httpPAOS11Binding());
		return new SAMLProcessorImpl(bindings);
	}

	/**
	 * Define the security filter chain in order to support SSO Auth by using SAML
	 * 2.0
	 * 
	 * @return Filter chain proxy
	 * @throws Exception
	 */
	@Bean
	public FilterChainProxy samlFilter() throws Exception {
		List<SecurityFilterChain> chains = new ArrayList<SecurityFilterChain>();
		chains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/saml/login/**"), samlEntryPoint()));
		chains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/saml/logout/**"), samlLogoutFilter()));
		chains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/saml/metadata/**"),
				metadataDisplayFilter()));
		chains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/saml/SSO/**"),
				samlWebSSOProcessingFilter()));
		chains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/saml/SSOHoK/**"),
				samlWebSSOHoKProcessingFilter()));
		chains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/saml/SingleLogout/**"),
				samlLogoutProcessingFilter()));
		chains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/saml/discovery/**"), samlIDPDiscovery()));
		return new FilterChainProxy(chains);
	}

	/**
	 * Generate JWT Token for SSO Login
	 * 
	 * @param auth
	 * @return
	 */
	public String generateTokenForSAML(Authentication auth) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// This value is similar/same as the client id and secret in the application.properties file.
		// FIX ME: make this configurable
		headers.add("Authorization", "Basic dGVzdGp3dGNsaWVudGlkOlhZN2ttem9OemwxMDA=");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		authAssertionIdUserNameCache.put(((SAMLCredential) auth.getCredentials()).getAuthenticationAssertion().getID(),
				((SAMLCredential) auth.getCredentials()).getNameID().getValue());
		map.add("grant_type", "password");
		map.add("username", "SSO" + "-" + ((SAMLCredential) auth.getCredentials()).getAuthenticationAssertion().getID()
				+ "-" + ((SAMLCredential) auth.getCredentials()).getNameID().getValue());
		map.add("password", ((SAMLCredential) auth.getCredentials()).getAuthenticationAssertion().getID());

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<String> response = restTemplate.postForEntity(tokenEndPointURL, request, String.class);

		
		
		return response.getBody();
	}

}
