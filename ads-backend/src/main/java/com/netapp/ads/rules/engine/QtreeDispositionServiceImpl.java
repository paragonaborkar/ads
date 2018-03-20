package com.netapp.ads.rules.engine;
/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/


import java.util.Date;
import java.util.List;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.NasVolume;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.repos.ActivityRepository;
import com.netapp.ads.rules.rules.AccessControlRule;
import com.netapp.ads.rules.rules.AgedAccessRule;
import com.netapp.ads.rules.rules.ControllerRootRule;
import com.netapp.ads.rules.rules.DiscoveryRule;

/**
 * This is the engine hold all the rules to run
 * @author sofiaz
 *
 */
@Service
public class QtreeDispositionServiceImpl implements QtreeDispositionService {

	private static final Logger logger = LoggerFactory.getLogger(QtreeDispositionServiceImpl.class);
	
	@Autowired
	ControllerRootRule controllerRootRule;
	
	@Autowired
	AgedAccessRule agedAccessRule;
	
	@Autowired
	AccessControlRule accessControlRule;
	
	@Autowired
	DiscoveryRule discoveryRule;
	
	@Autowired
	ActivityRepository activityRepository;
	
	public void executeQtreeDispositionRules(List<Qtree> qtrees) {

		logger.info("executeQtreeDispositionRules: [ENTER]");
		logger.info("executeQtreeDispositionRules: qtrees: " + qtrees.size());
		
		if(! qtrees.isEmpty()) {
			Rules rules = new Rules();
			rules.register(controllerRootRule);
			rules.register(agedAccessRule);
			rules.register(accessControlRule);
			rules.register(discoveryRule);
			
			//Engine parameters { skipOnFirstAppliedRule = false, skipOnFirstNonTriggeredRule = false, skipOnFirstFailedRule = false, priorityThreshold = 2147483647 }
			RulesEngine rulesEngine = new DefaultRulesEngine();
			NasVolume nasVolume = qtrees.get(0).getNasVolume();
			for(Qtree qtree : qtrees) {
				Facts facts = new Facts();
				facts.put("nasVolume", nasVolume);
				facts.put("qtree", qtree);
				rulesEngine.fire(rules, facts);
				populateActivity(nasVolume, qtree);
			}
		}
		
		logger.info("executeQtreeDispositionRules: [EXIT]");
	}
	
	public boolean populateActivity(NasVolume nasVolume, Qtree qtree) {
		//Not sure why we iterate through all the qtrees. Can we filter this based on the disposition and justification we set earlier in the rules engine
		Activity activity = new Activity();
		activity.setQtree(qtree);		
		//activity.setDisposition(qtree.getDisposition());
		// activity.setMailingDate(new Date()); //What should this be? Should be set to NULL
		activity.setWillDelete(false);  // This is set when QTree Owners confirm ownership
		activity.setWillMigrate(false); // This is set when QTree Owners confirm ownership
		//activity.setCallMe(true);
		activity.setAdminOverride(false);
		activityRepository.save(activity);
		logger.info("populateActivity: Created Activity: " + activity.getId());
		return true;
	}
	
}
