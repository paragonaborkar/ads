package com.netapp.ads.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

@Component
public class EmailService {
	
    @Value("${mail.from}")
    private String EMAIL_FROM;
    @Value("${mail.from.alias}")
    private String EMAIL_FROM_ALIAS;
    @Value("${mail.to}")
    private String EMAIL_TO;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    public JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendMail(String subject, final String emailTemplateName, final Context context) throws MessagingException, UnsupportedEncodingException {


        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.emailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
        message.setSubject(subject);
        message.setFrom(EMAIL_FROM, EMAIL_FROM_ALIAS);
        String email_to[] = EMAIL_TO.split(",");
        message.setTo(email_to);

        // Create the HTML body using Thymeleaf
        final String htmlContent = this.templateEngine.process(emailTemplateName, context);
        message.setText(htmlContent, true /* isHtml */);

        // Send email
        this.emailSender.send(mimeMessage);
    }
}