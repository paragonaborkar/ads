package com.netapp.ads.batch;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.ActivityResponse;
import com.netapp.ads.models.MigrationKey;
import com.netapp.ads.repos.MigrationKeyRepository;
import com.netapp.ads.services.UniqueKeyService;

@Service
public class MigrationKeyService {
	private static final Logger log = LoggerFactory.getLogger(MigrationKeyService.class);
	
	@Autowired
	MigrationKeyRepository migrationKeyRepository;
	
	@Autowired
	UniqueKeyService uniqueKeyService;
	
	/**
	 * Generate migration keys for this run.
	 * One migration key is generated for each run for each combination User i.e.
	 * Same migration key is reused for the same user for multiple activities that are part of this method call/run
	 * 
	 * @param activities
	 * @return
	 */
	public void generateMigrationKeys(List<Activity> activities) {
		log.debug("generateMigrationKeys: [ENTER]");
		log.debug("generateMigrationKeys: activities: {}", activities.size());
		Set<String> migrationKeysGenerated = new HashSet<String>();
		Integer maxRunNo = migrationKeyRepository.getMaxRunNo();
		Integer currentRunNo = maxRunNo == null ? 1 : new AtomicInteger(maxRunNo).incrementAndGet();
		for(Activity activity: activities) {
			//Only generate migration keys for this activity if not previously generated
			if(activity.getMigrationKeys().isEmpty()) {
				log.debug("generateMigrationKeys: Generating migration keys for activity: {} ", activity.getId());
				//activity response
				List<ActivityResponse> activityResponses = activity.getActivityResponses();
				for(ActivityResponse activityResponse: activityResponses) {
					Integer userCorporateId = activityResponse.getOwnerUserCorporateId();
					log.debug("generateMigrationKeys: activity: {}, userCorporateId: {} ", activity.getId(), userCorporateId);
					
					//check if migration key exists for this user
					//check if it was generated 
					MigrationKey migrationKey = migrationKeyExists(userCorporateId, currentRunNo);
					if(migrationKey == null) {
						migrationKey = new MigrationKey();
						migrationKey.setMigrationKey(uniqueKeyService.createMigKey());
						migrationKey.setUserCorporate(activityResponse.getOwnerUserCorporate());
						migrationKey.setRunNo(currentRunNo);
					}
					
					migrationKey.addActivity(activity);	
					migrationKeyRepository.save(migrationKey);
					migrationKeysGenerated.add(migrationKey.getMigrationKey());
					log.debug("migrationKey: {}", migrationKey);
				}
			} else {
				log.info("Migration Keys already generated for activity: {}", activity.getId());
			}
		}
		log.debug("generateMigrationKeys: [EXIT]");
	}

	public MigrationKey migrationKeyExists(Integer userCorporateId, Integer runNo) {
		MigrationKey migrationKey = migrationKeyRepository.findByUserCorporateIdAndRunNo(userCorporateId, runNo); 
		return migrationKey;  
	}
}
