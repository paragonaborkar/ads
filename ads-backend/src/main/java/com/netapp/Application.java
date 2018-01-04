package com.netapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.netapp.models.DataCenter;
import com.netapp.models.Host;
import com.netapp.repos.DataCenterRepository;
import com.netapp.repos.HostRepository;

@SpringBootApplication
//@Controller
public class Application {
	 private static final Logger log = LoggerFactory.getLogger(Application.class);
	 

	// Match everything without a suffix (so not a static resource)
/*	@RequestMapping(value = "/{path:[^\\.]*}")
	public String redirect() {
		// Forward to home page so that route is preserved.
		return "forward:/";
	}

	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal user) {
		return user;
	}

	@RequestMapping("/resource")
	@ResponseBody
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("name", "Hello World");
		
	
		return model;
	}*/
	
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("Started SpringBoot");
	
	}
	
	@Bean
	public CommandLineRunner demo(DataCenterRepository dcr, HostRepository hr) {
		return (args) -> {
			// save a couple of customers
			
			DataCenter d = new DataCenter();
			d.setId(1);
			d.setDataCenterName("DC-1");
			dcr.save(d);
			
			Host host = new Host();
			host.setDataCenter(d);
			
//			dcr.save(new DataCenter("DC-1"));
//			hr.save(new Host("Host-DC1-1"));
//			hr.save(new Host("Host-DC1-2"));
//			
//			dcr.save(new DataCenter("DC-2"));		
//			hr.save(new Host("Host-DC2-1"));
//			hr.save(new Host("Host-DC2-2"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (DataCenter customer : dcr.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			
		};
	}
	
	

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http
				// .httpBasic().and()
				.authorizeRequests()
				.antMatchers("/**").permitAll();
//					.antMatchers("/index.html", "/", "/login", "/message", "/home").permitAll()
//					.anyRequest().authenticated()
//					.and()
				http.csrf()
					.disable();
					//.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				//.and()
				//.cors();
			// @formatter:on
		}
	}

}
