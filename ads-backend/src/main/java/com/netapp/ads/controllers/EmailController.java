package com.netapp.ads.controllers;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import com.netapp.ads.email.EmailService;

@RestController
public class EmailController {
	//private static final Logger log = LoggerFactory.getLogger(EmailController.class);
	
    @Autowired
    private EmailService emailService;
    
    @RequestMapping(value="sendSimpleMail", method=RequestMethod.GET)
    public String sendSimpleMail(@RequestParam String emailTo, @RequestParam String subject, @RequestParam String body) {
    	//final Context context = new Context(Locale.ENGLISH);
    	emailService.sendSimpleMail(emailTo, subject, body);
    	//emailService.sendTemplatedMail("ADS - Controllers Details", "simple-announcement.html", context);
        return "Email sent!";
    }

//    @RequestMapping(value="sendTemplateMail", method=RequestMethod.GET)
//    public String sendTemplateMail(@RequestParam String emailTo, @RequestParam String subject, @RequestParam String templateName) {
//    	final Context context = new Context(Locale.ENGLISH);
//    	try {
//    		if(templateName != null) {
//				Map<String, Resource> inlineResources = new HashMap<String, Resource>();
//				String emailTemplate = null;
//    			if(templateName.equals("newsletter")) {
//    				emailTemplate = "Newsletter/newsletter";
//    				inlineResources.put("imageLogo1", new ClassPathResource("templates/Newsletter/logo-1.jpg"));
//    				inlineResources.put("imageHero1", new ClassPathResource("templates/Newsletter/hero-1.jpg"));
//    				inlineResources.put("imageNews1", new ClassPathResource("templates/Newsletter/news-1.jpg"));
//    				inlineResources.put("imageNews2", new ClassPathResource("templates/Newsletter/news-2.jpg"));
//    				inlineResources.put("imageNews3", new ClassPathResource("templates/Newsletter/news-3.jpg"));
//    				inlineResources.put("imageNews4", new ClassPathResource("templates/Newsletter/news-4.jpg"));
//    				inlineResources.put("imageCalendar", new ClassPathResource("templates/Newsletter/calendar.png"));
//    			}
//				emailService.sendTemplatedMail(emailTo, subject, emailTemplate, context, inlineResources);
//    		}
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//    	//emailService.sendTemplatedMail("ADS - Controllers Details", "simple-announcement.html", context);
//        return "Email sent!";
//    }

}
