package com.netapp.ads.email;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.ActivityResponse;
import com.netapp.ads.models.MigrationKey;
import com.netapp.ads.models.UserCorporate;
import com.netapp.ads.repos.ActivityRepository;
import com.netapp.ads.repos.ActivityResponseRepository;
import com.netapp.ads.util.DateUtils;

@Service
public class EmailService {
	
	private Logger log = LoggerFactory.getLogger(EmailService.class);
	
	@Value("#{sysConfigRepository.findByPropertyName('ads.email.from').getPropertyValue()}")
    private String EMAIL_FROM;
    
	@Value("#{sysConfigRepository.findByPropertyName('ads.email.from.alias').getPropertyValue()}")
    private String EMAIL_FROM_ALIAS;
	
	@Value("#{sysConfigRepository.findByPropertyName('ads.email.logoUrl').getPropertyValue()}")
	public String logoUrl;
	
	@Value("#{sysConfigRepository.findByPropertyName('ads.email.viewAllTasks').getPropertyValue()}")
	public String viewAllTasks;

	@Value("#{sysConfigRepository.findByPropertyName('ads.email.adsQtreeOwnerUrl').getPropertyValue()}")
	public String adsQtreeOwnerUrl;

	@Value("#{sysConfigRepository.findByPropertyName('ads.email.adsSupportUrl').getPropertyValue()}")
	public String adsSupportUrl;
	
	@Autowired
	ActivityResponseRepository activityResponseRepository;
	
	@Autowired
	ActivityRepository activityRepository;
	
	@Autowired
	private DateUtils dateUtils;
	
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

    public void sendTemplatedMail(String to, String subject, String emailTemplateName, Context context, Map<String, Resource> inlineResources) throws MessagingException, UnsupportedEncodingException {
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
    
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public HashMap<UserCorporate, ArrayList<MigrationKey>> getEmailsToSend(List<ActivityResponse> activityResponses) {
		HashMap<UserCorporate, ArrayList<MigrationKey>> emailsToSend = new HashMap<UserCorporate, ArrayList<MigrationKey>>();
		for(ActivityResponse activityResponse : activityResponses) {
			Activity activity = activityResponse.getActivity();
			//			for(Activity activity : response.getActivity()) {
			// Get the activity to mig key x_ref mapping... a list of migration_key_id's...

			//List<MigrationKey> migKeys = activity.getMigrationKeys();
			List<MigrationKey> migKeys = activityRepository.getActivityWithMigrationKeys(activity.getId()).getMigrationKeys();
			log.debug("Number of migration keys for activity {}: {}", activity.getId(), migKeys);

			for(MigrationKey migKey : migKeys) {
				if (emailsToSend.containsKey(migKey.getUserCorporate())) {
					ArrayList<MigrationKey> migKeysForUser = emailsToSend.get(migKey.getUserCorporate());
					if (!migKeysForUser.contains(migKey)) {
						migKeysForUser.add(migKey);
						emailsToSend.put(migKey.getUserCorporate(), migKeysForUser);
					}
				} else {
					ArrayList<MigrationKey> migKeysForUser = new ArrayList<>();
					migKeysForUser.add(migKey);
					emailsToSend.put(migKey.getUserCorporate(), migKeysForUser);
				}
			}
		}
		return emailsToSend;
	}
	
	public boolean sendEmail(String emailFolderAndTemplateFileName, UserCorporate corpUser, ArrayList<MigrationKey> migKeys) {

		Context context = new Context();
		context.setVariable("firstName", corpUser.getFirstName());
		context.setVariable("logoFullUrl", logoUrl);  					
		context.setVariable("viewAllTasksFullUrl", viewAllTasks); 
		context.setVariable("adsQtreeOwnerFullUrl", adsQtreeOwnerUrl);  
		context.setVariable("adsSupportFullUrl", adsSupportUrl);  		
	
		//FIXME: Need to generate links for each of the migKeys. There could be more than 1.
		context.setVariable("migKeys", migKeys);
		

		try {
			String emailTo = corpUser.getEmail();

			Map<String, Resource> inlineResources = new HashMap<String, Resource>();
			if(emailFolderAndTemplateFileName == "QtreeMultiOwnerNoSchedule/email") {
				inlineResources.put("imageLogo1", new ClassPathResource("templates/QtreeMultiOwnerNoSchedule/na_logo_hrz_1c-rev_rgb_lrg.png"));
				
				//FIXME: Make subject configurable using a Application Property from the DB
				sendTemplatedMail(emailTo, "Muti", emailFolderAndTemplateFileName, context, inlineResources);
			}

			if(emailFolderAndTemplateFileName == "QtreeSingleOwnerNoSchedule/email") {
				inlineResources.put("imageLogo1", new ClassPathResource("templates/QtreeSingleOwnerNoSchedule/na_logo_hrz_1c-rev_rgb_lrg.png"));
				//FIXME: Make subject configurable using a Application Property from the DB
				sendTemplatedMail(emailTo, "Single", emailFolderAndTemplateFileName, context, inlineResources);
			}

			if(emailFolderAndTemplateFileName == "QtreeOwnerReminderNoSchedule/email") {
				inlineResources.put("imageLogo1", new ClassPathResource("templates/QtreeOwnerReminderNoSchedule/na_logo_hrz_1c-rev_rgb_lrg.png"));
				//FIXME: Make subject configurable using a Application Property from the DB
				sendTemplatedMail(emailTo, "Reminder", emailFolderAndTemplateFileName, context, inlineResources);
			}

			return true;

		} catch (UnsupportedEncodingException e) {
			//FIXME: bad error handling
			e.printStackTrace();
		} catch (MessagingException e) {
			//FIXME: bad error handling
			e.printStackTrace();
		} 

		return false;

	}
	
	@Scheduled(cron = "#{sysConfigRepository.findByPropertyName('ads.email.sendowner.first').getPropertyValue()}")
	public void sendOwnerFirstEmail() {
		List<ActivityResponse> activityResponses = activityResponseRepository.findByEmailCount(0);
		log.debug("activityResponses size:" + activityResponses.size());
		sendEmailAndUpdateActivityResponses("QtreeMultiOwnerNoSchedule/email", activityResponses);
	}
	
	@Scheduled(cron = "#{sysConfigRepository.findByPropertyName('ads.email.sendowner.reminder').getPropertyValue()}")
	public void sendOwnerReminderEmail() {
		List<ActivityResponse> activityResponses = activityResponseRepository.findByIsOwnerAndIsPresumed(false, true);
		log.debug("activityResponses size:" + activityResponses.size());
		sendEmailAndUpdateActivityResponses("QtreeOwnerReminderNoSchedule/email", activityResponses);
	}
	
	public void sendEmailAndUpdateActivityResponses(String emailFolderAndTemplateFileName, List<ActivityResponse> activityResponses) {
		HashMap<UserCorporate, ArrayList<MigrationKey>> emailsToSend = getEmailsToSend(activityResponses);
		Iterator<Map.Entry<UserCorporate, ArrayList<MigrationKey>>> it = emailsToSend.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<UserCorporate, ArrayList<MigrationKey>> pair = (Map.Entry<UserCorporate, ArrayList<MigrationKey>>) it.next();
			UserCorporate corpUser = (UserCorporate) pair.getKey();
			ArrayList<MigrationKey> migKeys = (ArrayList<MigrationKey>) pair.getValue();	        

			log.debug("Sending email to:"  + corpUser.getEmail());
			log.debug("migKeys.size() for "+ corpUser.getEmail() + " " + migKeys.size());

			boolean resultOfSend = sendEmail(emailFolderAndTemplateFileName, corpUser, migKeys);
			if (resultOfSend) {
				for(MigrationKey migKey : migKeys) {
					log.debug("Getting activities for key:" + migKey.getMigrationKey() + " for "+ corpUser.getEmail());
					log.debug("Activity Size:" + migKey.getActivities().size());
					for(Activity activity : migKey.getActivities()) {
						log.debug("Activity ID :" + activity.getId());
						ActivityResponse activityResponse = activityResponseRepository.findByOwnerUserCorporateIdAndActivityId(corpUser.getId(), activity.getId());
						if (activityResponse != null) {
							log.debug("Setting email count for ActivityResponse ID :" + activityResponse.getId());
							activityResponse.setEmailCount(activityResponse.getEmailCount() + 1);
							activityResponse.setEmailDate((Timestamp) dateUtils.convertToUtc()); 	// Only update the emailDate for the first time sending the email.
							activityResponseRepository.save(activityResponse);
						}
					}
				}
			}
		}
	}
	}