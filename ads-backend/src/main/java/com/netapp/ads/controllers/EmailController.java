package com.netapp.ads.controllers;

import com.netapp.ads.converters.ExportHostXRefIDConverter;
import com.netapp.ads.email.EmailService;
import com.netapp.ads.models.Controller;
import com.netapp.ads.repos.ControllerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

@RestController
public class EmailController {
	private static final Logger log = LoggerFactory.getLogger(EmailController.class);
	
    @Autowired
    private EmailService emailService;
    @Autowired
    private ControllerRepository controllerRepository;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String index() {
        try {
            final Context context = new Context(Locale.ENGLISH);
            List<Controller> controllers = controllerRepository.findAll();
            context.setVariable("controllers", controllers);
            emailService.sendMail("ADS - Controllers Details", "simple-announcement.html", context);
        } catch (MessagingException e) {
        	// FIXME: no sys out's
            log.debug(e.getMessage());
        } catch (UnsupportedEncodingException e) {
        	// FIXME: Handle this correctly
            e.printStackTrace();
        }
        return "Greetings from Spring Boot!";
    }

}
