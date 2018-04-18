package com.netapp.ads.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.models.Controller;
import com.netapp.ads.models.ControllerRelease;
import com.netapp.ads.models.ControllerWorkPackage;
import com.netapp.ads.models.NasVolume;
import com.netapp.ads.repos.ControllerReleaseRepository;
import com.netapp.ads.repos.ControllerWorkPackageRepository;
import com.netapp.ads.rules.engine.ExceptionRuleService;
import com.netapp.ads.rules.engine.QtreeDispositionService;

@Service
public class ActivityService {
	private static final Logger log = LoggerFactory.getLogger(ActivityService.class);
	
	@Autowired
	ControllerReleaseRepository controllerReleaseRepository;

	@Autowired
	QtreeDispositionService qtreeDispositionService;

	@Autowired
	ExceptionRuleService exceptionRuleService;
	
	@Autowired
	ControllerWorkPackageRepository controllerWorkPackageRepository;
	
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
		return 1;
	}
}
