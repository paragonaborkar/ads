package com.netapp.ads.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.batch.MigrationKeyService;
import com.netapp.ads.models.Activity;
import com.netapp.ads.models.Controller;
import com.netapp.ads.models.ControllerRelease;
import com.netapp.ads.models.ControllerWorkPackage;
import com.netapp.ads.models.NasVolume;
import com.netapp.ads.repos.ActivityRepository;
import com.netapp.ads.repos.ControllerReleaseRepository;
import com.netapp.ads.repos.ControllerWorkPackageRepository;
import com.netapp.ads.repos.MigrationKeyRepository;
import com.netapp.ads.repos.QtreeRepository;
import com.netapp.ads.rules.engine.ExceptionRuleService;
import com.netapp.ads.rules.engine.QtreeDispositionService;
import com.netapp.ads.services.OwnerIdentificationService;

@RestController
public class MigrationKeyController {

	private static final Logger log = LoggerFactory.getLogger(MigrationKeyController.class);

	@Autowired
	MigrationKeyRepository migKeyRepo;

	/**
	 * Validate Migration Key with Corporate User
	 * @param migrationKey
	 * @param userCorporateId
	 * @return
	 */
	@PreAuthorize("hasAuthority('CORP_USER')")
	@RequestMapping(value = "/validate-migration-key/{migrationKey}/{userCorporateId}", method = RequestMethod.GET)
	public boolean validateMigKey(@PathVariable(name = "migrationKey") String migrationKey,
			@PathVariable(name = "userCorporateId") int userCorporateId) {
		return migKeyRepo.isMigrationKeyExists(migrationKey, userCorporateId);
	}


	@Autowired
	QtreeDispositionService qtreeDispositionService;
	
	@Autowired
	ExceptionRuleService exceptionRuleService;
	
	@Autowired
	ControllerReleaseRepository controllerReleaseRepository;
	
	@Autowired
	ControllerWorkPackageRepository controllerWorkPackageRepository;
	
	@Autowired
	OwnerIdentificationService ownerIdentificationService;
	
	@Autowired
	MigrationKeyService migrationKeyService;
	
	@Autowired
	ActivityRepository activityRepository;
	
	@Autowired
	QtreeRepository qtreeRepository;
	
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
	 * HOST IP Address should exist in Verum
	 * 
	 * @return
	 */
	@RequestMapping(value = "/identifyOwners", method = RequestMethod.POST)
	public Integer identifyOwners() {
		log.debug("identifyOwners: [ENTER]");
		ownerIdentificationService.identifyOwner();
		log.debug("identifyOwners: [EXIT]");
		return 0;
	}	
	
	@RequestMapping(value = "/generateMigrationKeys", method = RequestMethod.POST)
	public Integer generateMigrationKeys() {
		//Add DiscoverOwner clause
		List<Activity> activities = activityRepository.findAll();
		migrationKeyService.generateMigrationKeys(activities);
		return 0;
	}

}
