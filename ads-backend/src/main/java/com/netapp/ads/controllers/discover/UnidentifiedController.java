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
import com.netapp.ads.models.AuditEvent;
import com.netapp.ads.models.AuditTrailCorporateUser;
import com.netapp.ads.models.AuditTrailNativeUser;
import com.netapp.ads.models.UserCorporate;
import com.netapp.ads.models.UserNative;
import com.netapp.ads.pojo.UnidentifiedPojo;
import com.netapp.ads.repos.ActivityRepository;
import com.netapp.ads.repos.AuditEventRepository;
import com.netapp.ads.repos.AuditTrailCorporateUserRepository;
import com.netapp.ads.repos.AuditTrailNativeUserRepository;
import com.netapp.ads.repos.QtreeDispositionRepository;
import com.netapp.ads.repos.QtreeRepository;
import com.netapp.ads.repos.UserCorporateRepository;
import com.netapp.ads.repos.UserNativeRepository;

@RestController
public class UnidentifiedController {

	private static final Logger log = LoggerFactory.getLogger(UnidentifiedController.class);

	@Autowired
	ActivityRepository activityRepository;

	//	@Autowired
	//	AuditTrailCorporateUserRepository auditTrailCorpUserRepository;

	@Autowired
	AuditTrailNativeUserRepository auditTrailNativeUserRepository;

	@Autowired
	QtreeRepository qtreeRepository;

	@Autowired
	QtreeDispositionRepository  qtreeDispositionRepository;


	@Autowired
	UserCorporateRepository  userCorporateRepository;

	@Autowired
	UserNativeRepository  userNativeRepository;

	@Autowired
	AuditEventRepository  auditEventRepository;

	public final static String OK = "{\"message\":\"OK\"}";
	public final static String NO_ACTIVITY_FOUND = "{\"message\":\"The activity was not found.\"}";
	public final static String NO_USER_FOUND = "{\"message\":\"The current User was not found.\"}";

	@RequestMapping(value = "/resubmitUnidentified", method = RequestMethod.POST)
	public ResponseEntity<?> resubmitUnidentified(@RequestBody UnidentifiedPojo unidentifiedResponse) {

		AuditEvent event = auditEventRepository.findByEventName("unidentifiedOwner");

		// Get the activity response
		Activity activity = activityRepository.getOne(unidentifiedResponse.getActivityId());

		// Get the User and validate they exist.
		UserCorporate currentCorpUser = userCorporateRepository.getOne(unidentifiedResponse.getCurrentUserCorporateId());
		if (currentCorpUser == null) {
			return new ResponseEntity(NO_USER_FOUND, HttpStatus.NOT_FOUND);
		}

		// Get the User and validate they exist.
		// This is an Admin who is doing the resubmit
		UserNative currentNativeUser = userNativeRepository.getOne(unidentifiedResponse.getCurrentUserNativeId());
		if (currentNativeUser == null) {
			return new ResponseEntity(NO_USER_FOUND, HttpStatus.NOT_FOUND);
		}

		if (activity != null) {
			// Audit before the save

			AuditTrailNativeUser audit = new AuditTrailNativeUser();
			audit.setOldValues("{\"adminOverride\":" + activity.getAdminOverride() + "}" );
			audit.setAuditEvent(event);
			audit.setUserNativeId(currentNativeUser.getId());  // FIXME: This should really be just setNativeUser. No ID.
			audit.setAuditedResource(unidentifiedResponse.getActivityResourceUrl());

			String auditComment = "{\"reason\":\"" + unidentifiedResponse.getReason() + "\",";
			auditComment = auditComment + "\"reasonCode\":\"" + unidentifiedResponse.getReasonCode() + "\",";
			auditComment = auditComment + "\"requestedByName\":\"" +unidentifiedResponse.getRequestedByName()+ "\",";
			auditComment = auditComment + "\"requestedByUserCorporateResourceUrl\":\"" + unidentifiedResponse.getRequestedByUserCorporateResourceUrl() + "\",";
			auditComment = auditComment + "\"requestedByUserCorporateId\":\"" + unidentifiedResponse.getRequestedByUserCorporateId() + "\"" + "}";

			audit.setAuditComment(auditComment);
			auditTrailNativeUserRepository.save(audit);

			try {
				// Set adminOverride = 1 to re-process the Owner for the activity.			
				activity.setAdminOverride(true);
				activityRepository.save(activity);
			} catch (Exception e) {
				// Remove the audit entry if we didn't save the update.
				auditTrailNativeUserRepository.delete(audit);
				log.error("Cannot save the request to resubmit an unidentified owner.");
				throw e;
			}

		} else {
			return new ResponseEntity(NO_ACTIVITY_FOUND, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(OK, HttpStatus.OK);
	}

}
