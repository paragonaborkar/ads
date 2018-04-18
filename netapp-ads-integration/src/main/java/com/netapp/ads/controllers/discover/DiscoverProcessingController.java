package com.netapp.ads.controllers.discover;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.batch.MigrationKeyService;
import com.netapp.ads.email.EmailService;
import com.netapp.ads.services.ActivityService;
import com.netapp.ads.services.OwnerIdentificationService;

@RestController
@BasePathAwareController
@RequestMapping(value = "/api")
public class DiscoverProcessingController {

	private static final Logger log = LoggerFactory.getLogger(DiscoverProcessingController.class);

	@Autowired
	EmailService emailService;

	@Autowired
	MigrationKeyService migrationKeyService;
	
	@Autowired
	ActivityService activityService;

	@Autowired
	OwnerIdentificationService ownerIdentificationService;

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
		return activityService.populateActivities();
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
		migrationKeyService.generateMigrationKeys();
		return 0;
	}

	@RequestMapping(value="/sendOwnerFirstEmail", method=RequestMethod.POST)
	public ResponseEntity<?> sendOwnerFirstEmail(HttpServletRequest request,  HttpServletResponse response) {
		log.debug("Sending first emails...");
		emailService.sendOwnerFirstEmail();
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", "Email sent!"), HttpStatus.OK);
	}

	@RequestMapping(value="/sendOwnerReminderEmail", method=RequestMethod.POST)
	public ResponseEntity<?> sendOwnerReminderEmail(HttpServletRequest request,  HttpServletResponse response) {
		log.debug("Sending reminder emails...");
		emailService.sendOwnerReminderEmail();
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", "Email sent!"), HttpStatus.OK);
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