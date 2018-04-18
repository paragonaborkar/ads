package com.netapp.ads.controllers.discover;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.ActivityResponse;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.QtreeDisposition;
import com.netapp.ads.models.UserCorporate;
import com.netapp.ads.pojo.QtreeOwnerPojo;
import com.netapp.ads.repos.ActivityRepository;
import com.netapp.ads.repos.ActivityResponseRepository;
import com.netapp.ads.repos.MigrationKeyRepository;
import com.netapp.ads.repos.QtreeDispositionRepository;
import com.netapp.ads.repos.QtreeRepository;
import com.netapp.ads.repos.UserCorporateRepository;

@RestController
@RequestMapping(value = "/api")
@BasePathAwareController
public class OwnerController {

	private static final Logger log = LoggerFactory.getLogger(OwnerController.class);

	public final static String OK = "{\"message\":\"OK\"}";
	public final static String USER_ID_NO_MATCH = "{\"message\":\"This activity response is not for the current user\"}";
	public final static String BAD_DISPOSITION = "{\"message\":\"This QTree Disposition value indicates that this Qtree had been associated with an Owner already.\"}";
	public final static String OWNER_ALREADY_DISCOVERED_NO_DECOMMISSION = "{\"message\":\"This QTree had been previously associated with an Owner. They have not requested a decommission.\"}";
	public final static String OWNER_ALREADY_DISCOVERED_DECOMMISSION = "{\"message\":\"This QTree had been previously associated with an Owner. They have requested a decommission.\"}";

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	ActivityResponseRepository activityResponseRepository;

	@Autowired
	QtreeRepository qtreeRepository;

	@Autowired
	QtreeDispositionRepository  qtreeDispositionRepository;


	@Autowired
	UserCorporateRepository  userCorporateRepository;

	@Autowired
	MigrationKeyRepository migKeyRepo;

	/**
	 * Validate Migration Key with Corporate User
	 * @param migrationKey
	 * @param userCorporateId
	 * @return
	 */
	//	@PreAuthorize("hasAuthority('CORP_USER')")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@RequestMapping(value = "/validateMigrationKey/{migrationKey}/{userCorporateId}", method = RequestMethod.GET)
	public boolean validateMigKey(@PathVariable(name = "migrationKey") String migrationKey,
			@PathVariable(name = "userCorporateId") int userCorporateId) {
		return migKeyRepo.isMigrationKeyExists(migrationKey, userCorporateId);
	}


	public boolean activityHasOneOwner(List<ActivityResponse> allResponses, ActivityResponse currentActivityResponse) {

		int ownerCount = 0;
		int presumedCount = 0; // Unprocessed by Owners

		for(ActivityResponse ar : allResponses) {
			// Is another user responded that they are the Owner OR there are presumed Owners that didn't respond yet. 
			// Then we are not in a situation where multiple potential owner existed that are reduced to 1 Owner.
			if (ar.getIsOwner() && !ar.getIsPresumed())
				ownerCount++;

			if (!ar.getIsOwner() && ar.getIsPresumed())
				presumedCount++;
		}

		if (presumedCount > 0) // Pending Owner responses!
			return false;

		if (ownerCount > 1)	// Too many Owners!
			return false;

		return true;
	}

	/**
	 * @param ownerResponse
	 * @return
	 */
	@RequestMapping(value = "/saveQtreeOwner", method = RequestMethod.PATCH)
	public ResponseEntity<?> saveQtreeOwner(@RequestBody QtreeOwnerPojo ownerResponse) {

		// Get the activity response and check to ensure the owner Id's match. Just as a precaution.
		ActivityResponse arToUpdate = activityResponseRepository.getOne(ownerResponse.getActivityResponseId());
		if (arToUpdate.getOwnerUserCorporateId() == ownerResponse.getCurrentUserCorporateId()) {

			Activity activity = arToUpdate.getActivity();
			List<ActivityResponse> allResponses = activity.getActivityResponses();
			Qtree qtree = activity.getQtree();
			QtreeDisposition qtreeDisposition = qtreeDispositionRepository.findOneByDispositionAndQtree("DiscoverOwner", qtree);

			log.debug("qtreeDisposition.getDisposition():"+qtreeDisposition.getDisposition() + "-" + qtreeDisposition.getId());
			log.debug("activity id:"+activity.getId());

			if (qtreeDisposition.getDisposition() != "OwnerDiscover") {

				log.debug("ar.getCallMe():" + ownerResponse.getCallMe());
				log.debug("ar.getIsOwner():" + ownerResponse.getIsOwner());
				log.debug("ar.getIsPresumed():" + ownerResponse.getIsPresumed());

				// We will always have information for these fields:
				arToUpdate.setCallMe(ownerResponse.getCallMe());
				arToUpdate.setIsOwner(ownerResponse.getIsOwner());
				arToUpdate.setIsPresumed(false);

				if (ownerResponse.getIsOwner()) {
					if (ownerResponse.getDecommissionVolume()) {
						// FAIL SAFE Check - Ensures we don't set the QTree to be deleted if there are multiple people claiming they are the owners.
						// Go through all actvitiyResponses and ensure that no owner already said they want to delete this qtree or if they didn't want to delete the qtree.
						for(ActivityResponse ar : allResponses) {
							if (arToUpdate != ar && ar.getIsOwner()) {
								if (activity.getWillDecommission())
									return new ResponseEntity(OWNER_ALREADY_DISCOVERED_DECOMMISSION, HttpStatus.CONFLICT);
								else
									return new ResponseEntity(OWNER_ALREADY_DISCOVERED_NO_DECOMMISSION, HttpStatus.CONFLICT);
							}
						}

						// This wasn't set in the original version of MMS. 
						// In the UI the question is in regards to decommisioning the QTree.
						activity.setWillDecommission(true);
						activity.setDecommisionDate(ownerResponse.getDecommissionByDate());
						activityRepository.save(activity);
					}

				} else {
					// If NOT the OWNER, set different fields
					if (!ownerResponse.getDontKnowOwner() && ownerResponse.getSuggestedOwnerUserCorporateId() > 0) {
						UserCorporate suggestedOwner = userCorporateRepository.findOne(ownerResponse.getSuggestedOwnerUserCorporateId());

						if (suggestedOwner != null)
							arToUpdate.setSuggestedOwnerUserCorporate(suggestedOwner);
					}
				}

				if (activityHasOneOwner(allResponses, arToUpdate)) {
					// DiscoverOwner to "Discovered"
					log.debug("qtreeDisposition:" + qtreeDisposition.getDisposition() + qtreeDisposition.getId());
					qtreeDisposition.setDisposition("Discovered");
					qtreeDispositionRepository.save(qtreeDisposition);
				}

				activityResponseRepository.save(arToUpdate);
			} else {
				return new ResponseEntity(BAD_DISPOSITION, HttpStatus.NOT_FOUND);
			}


		} else {
			return new ResponseEntity(USER_ID_NO_MATCH, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(OK, HttpStatus.OK);
	}

}
