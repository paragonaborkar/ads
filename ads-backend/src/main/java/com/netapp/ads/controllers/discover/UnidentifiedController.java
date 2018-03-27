package com.netapp.ads.controllers.discover;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.AuditTrailCorporateUser;
import com.netapp.ads.models.UserCorporate;
import com.netapp.ads.pojo.UnidentifiedPojo;
import com.netapp.ads.repos.ActivityRepository;
import com.netapp.ads.repos.AuditTrailCorporateUserRepository;
import com.netapp.ads.repos.QtreeDispositionRepository;
import com.netapp.ads.repos.QtreeRepository;
import com.netapp.ads.repos.UserCorporateRepository;

@RestController
public class UnidentifiedController {

	private static final Logger log = LoggerFactory.getLogger(UnidentifiedController.class);

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	AuditTrailCorporateUserRepository auditTrailCorpUserRepository;

	@Autowired
	QtreeRepository qtreeRepository;

	@Autowired
	QtreeDispositionRepository  qtreeDispositionRepository;


	@Autowired
	UserCorporateRepository  userCorporateRepository;

	public final static String OK = "{\"message\":\"OK\"}";
	public final static String NO_ACTIVITY_FOUND = "{\"message\":\"The activity was not found.\"}";
	public final static String NO_USER_FOUND = "{\"message\":\"The current User was not found.\"}";

	@RequestMapping(value = "/resubmitUnidentified", method = RequestMethod.POST)
	public ResponseEntity<?> resubmitUnidentified(@RequestBody UnidentifiedPojo unidentifiedResponse) {

		// Get the activity response
		Activity activity = activityRepository.getOne(unidentifiedResponse.getActivityId());
		// Get the User and validate they exist.
		UserCorporate currentUser = userCorporateRepository.getOne(unidentifiedResponse.getCurrentUserCorporateId());
		if (currentUser == null) {
			return new ResponseEntity(NO_USER_FOUND, HttpStatus.NOT_FOUND);
		}

		if (activity != null) {
			// Audit before the save
			AuditTrailCorporateUser audit = new AuditTrailCorporateUser();
			audit.setOldValues("{\"adminOverride\":" + activity.getAdminOverride() + "}" );
			audit.setUserCorporateId(unidentifiedResponse.getCurrentUserCorporateId());
			audit.setAuditedResource(unidentifiedResponse.getActivityResourceUrl());

			String auditComment = "{\"reasons\":\"" + unidentifiedResponse.getReason() + "\"";
			auditComment = auditComment + "\"reasonCode\":\"" + unidentifiedResponse.getReasonCode() + "\"";
			auditComment = auditComment + "\"userCorporateResourceUr\":\"" + unidentifiedResponse.getRequestedByUserCorporateResourceUrl() + "\"";
			auditComment = auditComment + "\"userCorporateFirstAndLastName\":\"" +currentUser.getFirstName() + " " + currentUser.getLastName() + "\"";

			audit.setAuditComment(auditComment);
			auditTrailCorpUserRepository.save(audit);

			try {
				// Set adminOverride = 1 to re-process the Owner for the activity.			
				activity.setAdminOverride(true);
				activityRepository.save(activity);
			} catch (Exception e) {
				// Remove the audit entry if we didn't save the update.
				auditTrailCorpUserRepository.delete(audit);
				log.error("Cannot save the request to resubmit an unidentified owner.");
				throw e;
			}

		} else {
			return new ResponseEntity(NO_ACTIVITY_FOUND, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(OK, HttpStatus.OK);
	}

}
