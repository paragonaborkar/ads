package com.netapp.ads.controllers;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.Controller;
import com.netapp.ads.models.NasVolume;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.Schedule;
import com.netapp.ads.repos.ActivityRepository;
import com.netapp.ads.repos.ControllerRepository;
import com.netapp.ads.repos.MigrationKeyRepository;
import com.netapp.ads.repos.ScheduleRepository;
import com.netapp.vitae.model.VolumeEntity;
import com.netapp.vitae.ruleEngine.ExceptionRuleService;

import refactor.ruleEngine.VolumeDispositionService;


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
	ActivityRepository activityRepo;

	@Autowired
	ScheduleRepository scheduleRepo;

	@Autowired
	ControllerRepository controllerRepo;

	@Autowired
	VolumeDispositionService volumeDispositionService;

	@Autowired
	ExceptionRuleService exceptionRuleService;

	@RequestMapping(value = "/populate-activity", method = RequestMethod.GET)
	public boolean populateActivity() {

		// BELOW is from the *.batch package. 
		// This is from the manual functions:
		/*//get unique proId list 
		//walk through this list and kick off the engine with the migProjId
		migProjIdList = scheduleService.getAllUniqueMigProjId();

		for (Integer s:migProjIdList){

			if(!filterService.populateActivity(s.intValue())){
				message="No Data to Work On";
				logger.debug(message);
			}
		}
		//call jpmc api to populate preassumed owner id for activity table
		identificationService.identifyOwner();*/

		// FIXME: Get from DB
		// QUESTION: Manual function does not start by processing any "weeks". why?
		int leadWeeks=8; // Integer.parseInt(config.getProperty("schedule.migrate.filter.weeks"));

		LocalDate today = new LocalDate();
		LocalDate migrateDate = today.plusWeeks(leadWeeks);

		//get schedule list that weekdate is N weeks later and both volume and host is less than limit
		//walk through this list and kick of the engine with the migProjId

		// Old: scheduleList=scheduleService.getByWeekDate(migrateDate);
		// FIXME: Old code used LocalDate, not Date. What's the difference?
		List<Schedule> scheduleList= scheduleRepo.findByWeekDate(migrateDate.toDate());

		for (Schedule s : scheduleList){
			// In MMS, migProjId was a column on Schedule. Schedule's weekDate, when
			// In MMS, migProjId was a column on ctrl_release, which is responsible for listing controllers 
			// populateActivity(s.getMigProjId());
			populateActivity(0);
		}

		//call jpmc api to populate preassumed owner id for activity table
		identificationService.identifyOwner();

		return true;
	}

	/**
	 * Run the engine to filter the data in Volume and populated the activity
	 * @param int migProjId
	 * @return boolean (true means success)
	 */
	public boolean populateActivity(int migProjId){
		log.info("Start Fetching populateActivity");

		boolean result=false;
		if(kickOffEngine(migProjId)){
			// We do not have CtrlRelease in ADS
			//			for (CtrlReleaseEntity ctrl : ctrlReleaseList){
			// FIXME: Process all Controllers - What tells us if a controller is a source?
			for (Controller ctrl : controllerRepo.findAll()){
				//				List<NasVolume> tempVolList=pullVolumes(ctrl.getSrcControllerId());  // pullVolumes just gets the volumes for each controller. n:1
				List<NasVolume> tempVolList=ctrl.getNasVolumes();
				for(NasVolume vol : tempVolList){

					for(Qtree qtree : vol.getQtrees()){		// We are doing Qtree migration, not volume like MMS.

						Activity a=new Activity();
						a.setQtree(qtree);
						a.setDisposition(vol.getDisposition());		// We may need to change VolumeDispositionService to a QTree disposition service.

						//						a.setAggrName(vol.getAggregateEntity().getName());
						//						a.setVolName(vol.getVolumeName()));
						//					a.setMigProjId(ctrl.getMigProjId()); 		// Migration Project removed from ADS
						//						a.setVolId(vol.getIntVolId());
						//						a.setAggrId(vol.getAggrId());
						//						a.setMigKeyId("Not Assigned");
						//					a.setMailingDate(new LocalDate("1000-01-01"));
						//					a.setCreationDate(new LocalDate());
						//Below need come back to check for performance
						/*try{
							a.setCtrlName(controllerService.getById(vol.getContId()).getControllerName());
							activityService.create(a);
						} catch( Exception e )
						{
							log.error( e.getMessage(),e);
						}*/
					}
				}
			}
			result=true;
		}

		log.info("End Fetching populateActivity");
		return result;
	}

	public boolean kickOffEngine(int migProjId){
		log.info("Enter kickoffEngine");
		boolean result=false;

		// pullCtrlReleases(migProjId); // No longer used for MMS

		List<NasVolume> volList = new ArrayList<NasVolume>();
		// FIXME: In ADS how do we not process all controllers at once? Could be overload on the users.		
		//		for (CtrlReleaseEntity ctrl : ctrlReleaseList){
		for (Controller ctrl : controllerRepo.findAll()){
			// QUESTION: How do we know what the source controllers are?
			// tempVolList=pullVolumes(ctrl.getSrcControllerId());   // pullVolumes just gets the volumes for each controller. n:1
			// tempVolList=ctrl.getNasVolumes(); // Add directly in next line without using a temp variable.
			volList.addAll(ctrl.getNasVolumes());
		}

		// This uses: https://github.com/j-easy/easy-rules
		volumeDispositionService.volDisposition(volList);

		// Check for exceptions
		//		exceptionRuleService.exceptionRule(ctrlReleaseList);
		exceptionRuleService.exceptionRule(controllerRepo.findAll());

		result=true;

		return result;
	}


	// No longer used for MMS
	/*public List<CtrlReleaseEntity> pullCtrlReleases(int migrationId){
		log.debug("In pullCtrlReleases");

		try {
			ctrlReleaseList=ctrlReleaseService.getByMigProjId(migrationId);
			//mark the ctrlrelease to be processed
			ctrlReleaseService.markProcessed(migrationId);

		} catch( Exception e ) {
			log.error( e.getMessage(),e);
		}		
		return ctrlReleaseList;
	}*/
}
