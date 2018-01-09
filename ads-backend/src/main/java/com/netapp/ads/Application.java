package com.netapp.ads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/*import com.netapp.sdgenerator.support.maker.builder.ObjectBuilder;
import com.cmeza.sdgenerator.support.maker.builder.ObjectStructure;
import com.cmeza.sdgenerator.support.maker.values.ObjectTypeValues;
import com.cmeza.sdgenerator.support.maker.values.ScopeValues;
import com.cmeza.sdgenerator.util.*;



@SDGenerator(
        entityPackage = "com.acme.model",
        repositoryPackage = "com.acme.repositories",
        managerPackage = "com.acme.managers",
        repositoryPostfix = "Repository",
        managerPostfix = "Manager",
        onlyAnnotations = false,
        debug = false,
        overwrite = false
)*/

@SpringBootApplication
@Import(ADSConfiguration.class)
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("Started SpringBoot");

    }

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http
                    // .httpBasic().and()
                    .authorizeRequests().antMatchers("/**").permitAll();
            // .antMatchers("/index.html", "/", "/login", "/message", "/home").permitAll()
            // .anyRequest().authenticated()
            // .and()
            http.csrf().disable();
            // .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            // .and()
            // .cors();
            // @formatter:on
        }
    }

}
