package com.netapp.ads.controllers.discover;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.WebContext;

import com.netapp.ads.batch.MigrationKeyService;
import com.netapp.ads.email.EmailService;
import com.netapp.ads.models.Activity;
import com.netapp.ads.models.Controller;
import com.netapp.ads.models.ControllerRelease;
import com.netapp.ads.models.ControllerWorkPackage;
import com.netapp.ads.models.MigrationKey;
import com.netapp.ads.models.NasVolume;
import com.netapp.ads.models.UserCorporate;
import com.netapp.ads.pojo.ApplicationOwnerPojo;
import com.netapp.ads.pojo.ApplicationPojo;
import com.netapp.ads.pojo.ApplicationsPojo;
import com.netapp.ads.repos.ActivityRepository;
import com.netapp.ads.repos.ControllerReleaseRepository;
import com.netapp.ads.repos.ControllerWorkPackageRepository;
import com.netapp.ads.repos.QtreeDispositionRepository;
import com.netapp.ads.repos.QtreeRepository;
import com.netapp.ads.rules.engine.ExceptionRuleService;
import com.netapp.ads.rules.engine.QtreeDispositionService;
import com.netapp.ads.services.OwnerIdentificationService;

@RestController
public class DiscoverProcessingController {

	private static final Logger log = LoggerFactory.getLogger(DiscoverProcessingController.class);

	@Value("#{sysConfigRepository.findByPropertyName('ads.rules.discovery_rule.disposition').getPropertyValue()}")
	public String discoveryDisposition;
	
	@Value("#{sysConfigRepository.findByPropertyName('ads.email.logoUrl').getPropertyValue()}")
	public String logoUrl;
	
	@Value("#{sysConfigRepository.findByPropertyName('ads.email.viewAllTasks').getPropertyValue()}")
	public String viewAllTasks;
	
	@Value("#{sysConfigRepository.findByPropertyName('ads.email.adsQtreeOwnerUrl').getPropertyValue()}")
	public String adsQtreeOwnerUrl;
	
	@Value("#{sysConfigRepository.findByPropertyName('ads.email.adsSupportUrl').getPropertyValue()}")
	public String adsSupportUrl;

				
	@Autowired
	EmailService emailService;

	@Autowired
	QtreeDispositionService qtreeDispositionService;

	@Autowired
	ExceptionRuleService exceptionRuleService;

	@Autowired
	ControllerReleaseRepository controllerReleaseRepository;

	@Autowired
	ControllerWorkPackageRepository controllerWorkPackageRepository;

	@Autowired
	MigrationKeyService migrationKeyService;

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	QtreeRepository qtreeRepository;
	
	@Autowired
	QtreeDispositionRepository qtreeDispositionRepository;
	
	@Autowired
	private OwnerIdentificationService ownerIdentificationService;

	/*	
 	For testing populateActivites perform following database clean-up
 	Run following before testing to cleanup DB
 	update controller_release set processed = 0;
	update qtree set justification = NULL, disposition = NULL where justification is not null;
	delete from activity where create_time > '2018-01-01'; //yyyy-mm-dd

	AND/OR.....
	SET FOREIGN_KEY_CHECKS=0;
	update controller_release set processed = 0;
	update qtree set justification = NULL, disposition = NULL where justification is not null;
	delete from activity;
	delete from activity_response;
	delete from user_corporate;
	SET FOREIGN_KEY_CHECKS=1;
	INSERT INTO `ads_dev`.`share` (`id`, `qtree_id`, `share_name`, `host_id`) VALUES ('1', '3420', '/test/123', '1');
	UPDATE `ads_dev`.`host` SET `ip_addr`='10.216.49.26' WHERE  `id`=1;	
	INSERT INTO `ads_dev`.`migration_key` (`migration_key`, `user_corporate_id`, `create_time`) VALUES ('ABC', '9', '2018-03-14 12:31:18');
	INSERT INTO `ads_dev`.`activity_migration_key_x_ref` (`activity_id`) VALUES ('222');

	Sequence is 
	populate ControllerRelease -> populate Activity -> populate Application/Corp Users/Activity Response -->
	generate Migration Keys -> Send emails 
	 */
	/**
	 * Populates activities based on 
	 * 1. the controller release which have not been processed
	 * For each controller release, fint the qtrees
	 * For each qtree run disposition and exception rules 
	 * 
	 * 2. TODO The metered batch release process? IS THIS GOING TO BE A SEPERATE CONTROLLER? OR A MODE-STYLE FLAG?
	 * 
	 * @return
	 */
	@RequestMapping(value = "/populateActivity", method = RequestMethod.POST)
	public Integer populateActivities() {
		log.debug("populateActivities: CALLED"); 
		List<ControllerRelease> controllerReleases = controllerReleaseRepository.findByProcessedFalse();
		log.debug("populateActivities: controllerReleases: " + controllerReleases.size());
		for(ControllerRelease controllerRelease : controllerReleases) {
			Controller controller = controllerRelease.getSrcController();
			log.debug("populateActivities: Controller: " + controller.getId() + ", nasVolumes: " + controller.getNasVolumes().size());
			for(NasVolume nasVolume : controller.getNasVolumes()) {
				qtreeDispositionService.executeQtreeDispositionRules(nasVolume.getQtrees());
				exceptionRuleService.executeQtreeExceptionRules(nasVolume.getQtrees());
			}

			// Set the ControllerRelease Processed to true so it cannot be processed by this job again.
			controllerRelease.setProcessed(true);
			controllerReleaseRepository.save(controllerRelease);

			// Set the WorkPackage Processed to true so it cannot be used again.
			ControllerWorkPackage controllerWorkPackage = controller.getControllerWorkPackage();
			controllerWorkPackage.setProcessed(true);
			controllerWorkPackageRepository.save(controllerWorkPackage);
		}
		log.debug("populateActivities: COMPLETED");
		return 0;
	}

	/**
	 * Calls the migration key service to generate migration keys for
	 * only those activities which don't have a key
	 * 
	 * @return
	 */
	@RequestMapping(value = "/generateMigrationKeys", method = RequestMethod.POST)
	public Integer generateMigrationKeys() {
		//Add DiscoverOwner clause
		List<Activity> activities = activityRepository.findActivitiesWithoutMigrationKeys(discoveryDisposition);
		log.debug("Number of activities to generate migration keys: {}", activities.size());
		migrationKeyService.generateMigrationKeys(activities);
		return 0;
	}


	@RequestMapping(value="/sendOwnerFirstEmail", method=RequestMethod.POST)
	public String sendOwnerFirstEmail() {

		HashMap<UserCorporate, ArrayList<String>> emailsToSend = new HashMap<UserCorporate, ArrayList<String>>();
		
//		String emailTo = "szemanick@consultparagon.com";
//		String subject  = "ActivityResponse:" + ar.getId();
//		String templateName = "Newsletter/newsletter";

		// Activity activities = activityRepository.getOne(101);

		// We cannot assume a previous set of emails was sent out. It could have failed. So search for Activities where emails have not been sent for it.
		List<Activity> activities = activityRepository.findByMailCount(0);

		for(Activity activity : activities) {
			// Get the activity to mig key x_ref mapping... a list of migration_key_id's...
			List<MigrationKey> migKeys = activity.getMigrationKeys();
			for(MigrationKey migKey : migKeys) {
				
				System.out.println(migKey.getMigrationKey() + " " + migKey.getUserCorporate().getLastName());
  
				if (emailsToSend.containsKey(migKey.getUserCorporate())) {
					ArrayList<String> migKeysForUser = emailsToSend.get(migKey.getUserCorporate());
					migKeysForUser.add(migKey.getMigrationKey());
					emailsToSend.put(migKey.getUserCorporate(), migKeysForUser);
				} else {
					ArrayList<String> migKeysForUser = new ArrayList<>();
					migKeysForUser.add(migKey.getMigrationKey());
					emailsToSend.put(migKey.getUserCorporate(), migKeysForUser);
				}
					
			}
		}
		
		// REMOVE THIS.... FOR DEBUGGING:
		Iterator it = emailsToSend.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry) it.next();
	        UserCorporate u = (UserCorporate) pair.getKey();
	        ArrayList<String> mKeys = (ArrayList<String>) pair.getValue();	        
	        System.out.println(u.getLastName() + " = " + mKeys.toString());
	    }
				

//			We don't need the responses. 
//			List<ActivityResponse> allResponses = activity.getActivityResponses();
//			for(ActivityResponse response : allResponses) {}
		
		
		/*		final Context context = new Context(Locale.ENGLISH);
		try {
			if(templateName != null) {
				Map<String, Resource> inlineResources = new HashMap<String, Resource>();
				String emailTemplate = null;

				emailTemplate = "Newsletter/newsletter";
				inlineResources.put("imageLogo1", new ClassPathResource("templates/Newsletter/logo-1.jpg"));
				inlineResources.put("imageHero1", new ClassPathResource("templates/Newsletter/hero-1.jpg"));
				inlineResources.put("imageNews1", new ClassPathResource("templates/Newsletter/news-1.jpg"));
				inlineResources.put("imageNews2", new ClassPathResource("templates/Newsletter/news-2.jpg"));
				inlineResources.put("imageNews3", new ClassPathResource("templates/Newsletter/news-3.jpg"));
				inlineResources.put("imageNews4", new ClassPathResource("templates/Newsletter/news-4.jpg"));
				inlineResources.put("imageCalendar", new ClassPathResource("templates/Newsletter/calendar.png"));

				emailService.sendTemplatedMail(emailTo, subject, emailTemplate, context, inlineResources);
			}
		} catch (UnsupportedEncodingException e) {
			//FIXME: bad error handeling
			e.printStackTrace();
		} catch (MessagingException e) {
			//FIXME: bad error handeling
			e.printStackTrace();
		}*/

		return "Email sent!";
	}
	
	@RequestMapping(value="/sendTestEmail", method=RequestMethod.POST)
	public String testEe(HttpServletRequest request,  HttpServletResponse response) {

		String emailFolderAndTemplateFileName = "QtreeOwnerReminderNoSchedule/email";
		
		String emailTo = "szemanick@consultparagon.com";
		String subject = "Heres the test";
		
		final WebContext context = new WebContext(request, response, request.getServletContext());
		
		try {
			Map<String, Resource> inlineResources = new HashMap<String, Resource>();
			
			if(emailFolderAndTemplateFileName == "QtreeMultiOwnerNoSchedule/email") {
				inlineResources.put("imageLogo1", new ClassPathResource("templates/QtreeMultiOwnerNoSchedule/na_logo_hrz_1c-rev_rgb_lrg.png"));
				
				context.setVariable("logoFullUrl", logoUrl);  				
				context.setVariable("viewAllTasksFullUrl", viewAllTasks); 
				context.setVariable("adsQtreeOwnerFullUrl", adsQtreeOwnerUrl);
				context.setVariable("adsSupportFullUrl", adsSupportUrl);  
				context.setVariable("migKey", "RANDOM_REPLACE");
							
				context.setVariable("firstName", "Steve");
				
				emailService.sendTemplatedMail(emailTo, subject, emailFolderAndTemplateFileName, context, inlineResources);
			}
			
			if(emailFolderAndTemplateFileName == "QtreeSingleOwnerNoSchedule/email") {
				inlineResources.put("imageLogo1", new ClassPathResource("templates/QtreeSingleOwnerNoSchedule/na_logo_hrz_1c-rev_rgb_lrg.png"));
				
				context.setVariable("logoFullUrl", logoUrl);  					
				context.setVariable("viewAllTasksFullUrl", viewAllTasks); 
				context.setVariable("adsQtreeOwnerFullUrl", adsQtreeOwnerUrl);  
				context.setVariable("adsSupportFullUrl", adsSupportUrl);  		
				context.setVariable("migKey", "RANDOM_REPLACE");
							
				context.setVariable("firstName", "Steve");
				
				emailService.sendTemplatedMail(emailTo, subject, emailFolderAndTemplateFileName, context, inlineResources);
			}
			
			if(emailFolderAndTemplateFileName == "QtreeOwnerReminderNoSchedule/email") {
				inlineResources.put("imageLogo1", new ClassPathResource("templates/QtreeOwnerReminderNoSchedule/na_logo_hrz_1c-rev_rgb_lrg.png"));
				
				context.setVariable("logoFullUrl", logoUrl);  					
				context.setVariable("viewAllTasksFullUrl", viewAllTasks); 
				context.setVariable("adsQtreeOwnerFullUrl", adsQtreeOwnerUrl);  
				context.setVariable("adsSupportFullUrl", adsSupportUrl);  		
				context.setVariable("migKey", "RANDOM_REPLACE");
							
				context.setVariable("firstName", "Steve");
				
				emailService.sendTemplatedMail(emailTo, subject, emailFolderAndTemplateFileName, context, inlineResources);
			}
				
			
		} catch (UnsupportedEncodingException e) {
			//FIXME: bad error handeling
			e.printStackTrace();
		} catch (MessagingException e) {
			//FIXME: bad error handeling
			e.printStackTrace();
		}

		return "Email sent!";
	}

	// This is the URL that Talend will call once it gets the CMDB information.
	@RequestMapping(value = "/identifyOwners", method = RequestMethod.POST)
	// public ResponseEntity<?> identifyOwners(@RequestBody ApplicationsPojo applications) {
	public ResponseEntity<?> identifyOwners(@RequestBody ApplicationsPojo applications) {
		
		// log.debug("Owner Identification Controller [ENTER]");
		// log.debug("Owner Identification Controller applicationWrapper: " + applications);
		// for(ApplicationPojo applicationPojo: applications.getApplications()) {
		// 		log.debug("Owner Identification applicationPojo: " + applicationPojo);
		// 		for(ApplicationOwnerPojo owner : applicationPojo.getOwner()) {
		// 			log.debug("Owner Identification owner: " + owner.getUserName());
		// 		}
		// }

		ownerIdentificationService.identifyOwner();
		log.debug("Owner Identification Controller [EXIST]");
		// Step 1. Validate entire JSON file and every field. If anything is invalid or missing. Fail for all applications and do not process any.
		
		// Step 2. Save the Applications and Owners
/*		
		List<ApplicationPojo> apps = data.getApps();
		System.out.println("Apps length:" +apps.size());
		for (ApplicationPojo application: apps) {
			System.out.println("App getAppName:" + application.getAppName());
		}		*/
		
		// Step 3. If #2 was successful Run Mig Key if needed... Could be a parameter or different REST call?
		
		return new ResponseEntity("OK", HttpStatus.OK);
	}
}
