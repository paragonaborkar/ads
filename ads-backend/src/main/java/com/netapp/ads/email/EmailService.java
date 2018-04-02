package com.netapp.ads.email;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;

@Service
public class EmailService {
	
	private Logger log = LoggerFactory.getLogger(EmailService.class);
	
    @Value("${mail.from}")
    private String EMAIL_FROM;
    
    @Value("${mail.from.alias}")
    private String EMAIL_FROM_ALIAS;
    
    //@Autowired
    private TemplateEngine templateEngine;
    
    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    public EmailService(TemplateEngine templateEngine) {
    	this.templateEngine = templateEngine;
	}
    
    public void sendSimpleMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendTemplatedMail(String to, String subject, String emailTemplateName, WebContext context, Map<String, Resource> inlineResources) throws MessagingException, UnsupportedEncodingException {
        final MimeMessage mimeMessage = this.emailSender.createMimeMessage();
        final MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8"); //true for multipart
        messageHelper.setSubject(subject);
        messageHelper.setFrom(EMAIL_FROM, EMAIL_FROM_ALIAS);
        messageHelper.setTo(to.split(","));

        // Create the HTML body using Thymeleaf
        //final InputStreamSource imageSource = new ByteArrayResource(imageBytes);
        final String htmlContent = this.templateEngine.process(emailTemplateName, context);
        //setText has to come before addInline otherwise it wont work
        messageHelper.setText(htmlContent, true); //true for isHtml
        
        if(inlineResources != null && !inlineResources.isEmpty()) {
        	for (Entry<String, Resource> pair : inlineResources.entrySet()){
                messageHelper.addInline(pair.getKey(), pair.getValue());
            }
        }
        
        // Send email
        this.emailSender.send(mimeMessage);
    }
}