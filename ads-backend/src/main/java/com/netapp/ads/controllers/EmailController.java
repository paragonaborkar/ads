package com.netapp.ads.controllers;

import com.netapp.ads.mail.EmailService;
import com.netapp.ads.models.Controller;
import com.netapp.ads.models.ControllerPK;
import com.netapp.ads.repos.ControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

@RestController
public class EmailController {
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
            System.out.println(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "Greetings from Spring Boot!";
    }

}
