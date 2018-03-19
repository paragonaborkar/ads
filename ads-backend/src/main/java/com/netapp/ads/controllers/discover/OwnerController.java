package com.netapp.ads.controllers.discover;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.converters.TalendConstants;
import com.netapp.ads.models.Activity;
import com.netapp.ads.models.ActivityResponse;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.QtreeDisposition;
import com.netapp.ads.pojo.QtreeOwnerPojo;
import com.netapp.ads.repos.ActivityRepository;
import com.netapp.ads.repos.ActivityResponseRepository;
import com.netapp.ads.repos.MigrationKeyRepository;
import com.netapp.ads.repos.QtreeDispositionRepository;
import com.netapp.ads.repos.QtreeRepository;
import com.netapp.ads.rules.engine.QtreeDispositionService;

@RestController
public class OwnerController {

	private static final Logger log = LoggerFactory.getLogger(OwnerController.class);

	public final static String OK = "{\"message\":\"OK\"}";
	public final static String USER_ID_NO_MATCH = "{\"message\":\"This activity response is not for the current user\"}";
	public final static String BAD_DISPOSITION = "{\"message\":\"This QTree Disposition value indicates that this Qtree had been associated with an Owner already.\"}";
	

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	ActivityResponseRepository activityResponseRepository;

	@Autowired
	QtreeRepository qtreeRepository;

	@Autowired
	QtreeDispositionRepository  qtreeDispositionRepository;


	/**
	 * @param ownerResponse
	 * @return
	 */
	@RequestMapping(value = "/saveQtreeOwner", method = RequestMethod.PATCH)
	public ResponseEntity<?> validateMigKey(@RequestBody QtreeOwnerPojo ownerResponse) {

		// Get the activity response and check to ensure the owner Id's match. Just as a precaution.
		ActivityResponse arToUpdate = activityResponseRepository.getOne(ownerResponse.getActivityResponseId());
		if (arToUpdate.getOwnerUserCorporateId() == ownerResponse.getCurrentUserCorporateId()) {

			Activity activity = arToUpdate.getActivity();
			Qtree qtree = activity.getQtree();
			QtreeDisposition qtreeDisposition = qtreeDispositionRepository.findOneByDispositionAndQtree("DiscoverOwner", qtree);

			if (qtreeDisposition.getDisposition() != "OwnerDiscover") {

				System.out.println("ar.getCallMe():" + ownerResponse.getCallMe());
				System.out.println("ar.getIsOwner():" + ownerResponse.getIsOwner());
				System.out.println("ar.getIsPresumed():" + ownerResponse.getIsPresumed());

				// We will always have information for these fields:
				arToUpdate.setCallMe(ownerResponse.getCallMe());
				arToUpdate.setIsOwner(ownerResponse.getIsOwner());
				arToUpdate.setIsPresumed(false);

				if (ownerResponse.getIsOwner()) {
					// 
					if (ownerResponse.getDecommissionVolume()) {
						// FIXME: This wasn't set for MMS. 
						// CHECKING WITH LEW ON WHAT TO SET HERE.
						activity.setArchiveCandidate(true);
						activity.setWillDelete(true);
						activity.setDeleteDate(ownerResponse.getDecommissionByDate());
						activityRepository.save(activity);

						// TODO: Update DiscoverOwner to "Discovered"?
						System.out.println("qtreeDisposition:" + qtreeDisposition.getDisposition() + qtreeDisposition.getId());
					}

				} else {
					// If NOT the OWNER set different fields
					if (!ownerResponse.getDontKnowOwner() && ownerResponse.getSuggestedOwnerUserCorporateId() > 0) {
						arToUpdate.setSuggestedOwnerUserCorporateId(ownerResponse.getSuggestedOwnerUserCorporateId());
					}
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
