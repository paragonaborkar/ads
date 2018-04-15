package com.netapp.ads.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.messageresolver.IMessageResolver;
import org.thymeleaf.messageresolver.StandardMessageResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;


//@Configuration
public class ThymeleafConfiguration {
    private static final String EMAIL_TEMPLATE_ENCODING = "UTF-8";

   // @Autowired
    private ThymeleafDatabaseResourceResolver thymeleafDatabaseResourceResolver;
    
    

    //@Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver((ITemplateResolver) thymeleafDatabaseResourceResolver);
        return templateEngine;
    }
    
    
    private ITemplateResolver emailTemplateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setOrder(2);
        templateResolver.setPrefix("templates/Stationery/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding(EMAIL_TEMPLATE_ENCODING);
        templateResolver.setCacheable(false);
        return templateResolver;
    }
    
    
 
    @Bean
    public IMessageResolver messageResolver() {
        return new StandardMessageResolver();
    }


}
