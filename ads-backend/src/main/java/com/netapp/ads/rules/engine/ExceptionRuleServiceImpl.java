/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/
package com.netapp.ads.rules.engine;

import java.util.List;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.models.NasVolume;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.rules.rules.MissingRootVolumeRule;

@Service
public class ExceptionRuleServiceImpl implements ExceptionRuleService {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionRuleServiceImpl.class);

	@Autowired
	MissingRootVolumeRule missingRootVolRule;

	public void executeQtreeExceptionRules(List<Qtree> qtrees) {
		
		logger.info("executeQtreeExceptionRules: [ENTER]");
		logger.info("executeQtreeExceptionRules: qtrees: " + qtrees.size());
		
		if(! qtrees.isEmpty()) {
			Rules rules = new Rules();
			rules.register(missingRootVolRule);
			
			//Engine parameters { skipOnFirstAppliedRule = false, skipOnFirstNonTriggeredRule = false, skipOnFirstFailedRule = false, priorityThreshold = 2147483647 }
			RulesEngine rulesEngine = new DefaultRulesEngine();
			NasVolume nasVolume = qtrees.get(0).getNasVolume();
			for(Qtree qtree : qtrees) {
				Facts facts = new Facts();
				facts.put("nasVolume", nasVolume);
				facts.put("qtree", qtree);
				rulesEngine.fire(rules, facts);
			}
		}
		logger.info("executeQtreeExceptionRules: [EXIT]");
	}
}
