package com.netapp.ads.controllers.discover;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
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
import com.netapp.ads.models.ActivityResponse;
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
import com.netapp.ads.repos.ActivityResponseRepository;
import com.netapp.ads.repos.ControllerReleaseRepository;
import com.netapp.ads.repos.ControllerWorkPackageRepository;
import com.netapp.ads.repos.QtreeDispositionRepository;
import com.netapp.ads.repos.QtreeRepository;
import com.netapp.ads.rules.engine.ExceptionRuleService;
import com.netapp.ads.rules.engine.QtreeDispositionService;
import com.netapp.ads.services.OwnerIdentificationService;
import com.netapp.ads.util.DateUtils;

@RestController
@RequestMapping(value = "/api")
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
	ActivityResponseRepository activityResponseRepository;

	@Autowired
	QtreeRepository qtreeRepository;

	@Autowired
	QtreeDispositionRepository qtreeDispositionRepository;

	@Autowired
	private OwnerIdentificationService ownerIdentificationService;

	@Autowired
	private DateUtils dateUtils;

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
	public ResponseEntity<?> sendOwnerFirstEmail(HttpServletRequest request,  HttpServletResponse response) {
		// FIXME: Allow this it called by REST

		// FIXME: But also convert this it a servive that runs once a day. Configuration in the application properties, if possible. 
		HashMap<UserCorporate, ArrayList<MigrationKey>> emailsToSend = new HashMap<UserCorporate, ArrayList<MigrationKey>>();

		// We cannot assume a previous set of emails was sent out. It could have failed. So search for Activities where emails have not been sent for it.
		List<ActivityResponse> activityResponses = activityResponseRepository.findByEmailCount(0);

		for(ActivityResponse activityResponse : activityResponses) {
			Activity activity = activityResponse.getActivity();
			//			for(Activity activity : response.getActivity()) {
			// Get the activity to mig key x_ref mapping... a list of migration_key_id's...

			List<MigrationKey> migKeys = activity.getMigrationKeys();

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
			//			}
		}

		Iterator<Map.Entry<UserCorporate, ArrayList<MigrationKey>>> it = emailsToSend.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<UserCorporate, ArrayList<MigrationKey>> pair = (Map.Entry<UserCorporate, ArrayList<MigrationKey>>) it.next();
			UserCorporate corpUser = (UserCorporate) pair.getKey();
			ArrayList<MigrationKey> migKeys = (ArrayList<MigrationKey>) pair.getValue();	        

			log.debug("Sending email to:"  + corpUser.getEmail());
			log.debug("migKeys.size() for "+ corpUser.getEmail() + " " + migKeys.size());

			boolean resultOfSend = sendEmail(request,  response, "QtreeMultiOwnerNoSchedule/email", corpUser, migKeys);
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

		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", "Email sent!"), HttpStatus.OK);
	}



	@RequestMapping(value="/sendOwnerReminderEmail", method=RequestMethod.POST)
	public ResponseEntity<?> sendOwnerReminderEmail(HttpServletRequest request,  HttpServletResponse response) {

		// FIXME: Allow this it called by REST

		// FIXME: But also convert this it a servive that runs once a day. Configuration in the application properties, if possible. 
		HashMap<UserCorporate, ArrayList<MigrationKey>> emailsToSend = new HashMap<UserCorporate, ArrayList<MigrationKey>>();

		// We cannot assume a previous set of emails was sent out. It could have failed. So search for Activities where emails have not been sent for it.
		List<ActivityResponse> activityResponses = activityResponseRepository.findByIsOwnerAndIsPresumed(false, true);  				// ***************** THIS LINE IS DIFFERENT FROM THE FIRST EMAIL

		for(ActivityResponse activityResponse : activityResponses) {
			Activity activity = activityResponse.getActivity();
			//			for(Activity activity : response.getActivity()) {
			// Get the activity to mig key x_ref mapping... a list of migration_key_id's...

			List<MigrationKey> migKeys = activity.getMigrationKeys();

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
			//			}
		}

		Iterator<Map.Entry<UserCorporate, ArrayList<MigrationKey>>> it = emailsToSend.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<UserCorporate, ArrayList<MigrationKey>> pair = (Map.Entry<UserCorporate, ArrayList<MigrationKey>>) it.next();
			UserCorporate corpUser = (UserCorporate) pair.getKey();
			ArrayList<MigrationKey> migKeys = (ArrayList<MigrationKey>) pair.getValue();	        

			log.debug("Sending email to:"  + corpUser.getEmail());
			log.debug("migKeys.size() for "+ corpUser.getEmail() + " " + migKeys.size());

			boolean resultOfSend = sendEmail(request,  response, "QtreeOwnerReminderNoSchedule/email", corpUser, migKeys); 				// ***************** THIS LINE IS DIFFERENT FROM THE FIRST EMAIL
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
							// activityResponse.setEmailDate((Timestamp) dateUtils.convertToUtc());// ***************** THIS LINE IS DIFFERENT FROM THE FIRST EMAIL - COMMENTED OUT
							activityResponseRepository.save(activityResponse);
						}
					}

				}
			}
		}

		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", "Email sent!"), HttpStatus.OK);
	}



	// FIXME: Move to service....
	public boolean sendEmail(HttpServletRequest request,  HttpServletResponse response, String emailFolderAndTemplateFileName, UserCorporate corpUser, ArrayList<MigrationKey> migKeys) {

		final WebContext context = new WebContext(request, response, request.getServletContext());

		context.setVariable("firstName", corpUser.getFirstName());

		context.setVariable("logoFullUrl", logoUrl);  					
		context.setVariable("viewAllTasksFullUrl", viewAllTasks); 
		context.setVariable("adsQtreeOwnerFullUrl", adsQtreeOwnerUrl);  
		context.setVariable("adsSupportFullUrl", adsSupportUrl);  		

		//FIXME: Need to generate links for each of the migKeys. There could be more than 1.
		context.setVariable("migKey", "RANDOM_REPLACE");

		try {
			String emailTo = corpUser.getEmail();

			Map<String, Resource> inlineResources = new HashMap<String, Resource>();
			if(emailFolderAndTemplateFileName == "QtreeMultiOwnerNoSchedule/email") {
				inlineResources.put("imageLogo1", new ClassPathResource("templates/QtreeMultiOwnerNoSchedule/na_logo_hrz_1c-rev_rgb_lrg.png"));
				
				//FIXME: Make subject configurable using a Application Property from the DB
				emailService.sendTemplatedMail(emailTo, "Muti", emailFolderAndTemplateFileName, context, inlineResources);
			}

			if(emailFolderAndTemplateFileName == "QtreeSingleOwnerNoSchedule/email") {
				inlineResources.put("imageLogo1", new ClassPathResource("templates/QtreeSingleOwnerNoSchedule/na_logo_hrz_1c-rev_rgb_lrg.png"));
				//FIXME: Make subject configurable using a Application Property from the DB
				emailService.sendTemplatedMail(emailTo, "Single", emailFolderAndTemplateFileName, context, inlineResources);
			}

			if(emailFolderAndTemplateFileName == "QtreeOwnerReminderNoSchedule/email") {
				inlineResources.put("imageLogo1", new ClassPathResource("templates/QtreeOwnerReminderNoSchedule/na_logo_hrz_1c-rev_rgb_lrg.png"));
				//FIXME: Make subject configurable using a Application Property from the DB
				emailService.sendTemplatedMail(emailTo, "Reminder", emailFolderAndTemplateFileName, context, inlineResources);
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




	// This is the URL that Talend will call once it gets the CMDB information.
	@RequestMapping(value = "/identifyOwners", method = RequestMethod.POST)
	public ResponseEntity<?> identifyOwners() {

		ownerIdentificationService.identifyOwner();
		log.debug("Owner Identification Controller [EXIST]");

		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", "identifyOwners"), HttpStatus.OK);
	}

	// This is the URL that Talend will call once it gets the CMDB information. But here, we send the json in the body to test the serialization of the object.
	/*@RequestMapping(value = "/identifyOwnersTester", method = RequestMethod.POST)
	 public ResponseEntity<?> identifyOwnersTester(@RequestBody ApplicationsPojo applications) {
		 log.debug("Owner Identification Controller [ENTER]");
		 log.debug("Owner Identification Controller applicationWrapper: " + applications);
		 for(ApplicationPojo applicationPojo: applications.getApplications()) {
		 		log.debug("Owner Identification applicationPojo: " + applicationPojo);
		 		for(ApplicationOwnerPojo owner : applicationPojo.getOwner()) {
		 			log.debug("Owner Identification owner: " + owner.getUserName());
		 		}
		 }
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", "identifyOwnersTester"), HttpStatus.OK);
	}*/
}
