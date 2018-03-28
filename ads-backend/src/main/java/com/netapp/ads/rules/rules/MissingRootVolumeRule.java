package com.netapp.ads.rules.rules;
/*******************************************************************************

 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/

import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netapp.ads.models.NasVolume;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.QtreeDisposition;
import com.netapp.ads.repos.QtreeRepository;

@Rule(name = "Access Control List", description = "Rule to determine if a volume still has host which access to it")
@Service
public class MissingRootVolumeRule {

	private static final Logger logger = LoggerFactory.getLogger(MissingRootVolumeRule.class);
	
	@Value("${ads.rule.missing_root_vol.priority}")
	private int priority;

	@Value("${ads.rule.controller_root_rule.disposition}")
	private String controllerRootRuleDisposition;

	@Priority
	public int getPriority() {
		return priority;
	}

	@Condition
	public boolean when(@Fact("nasVolume") NasVolume nasVolume, @Fact("qtree") Qtree qtree) {
		logger.debug("Condition: [ENTER]");
		logger.debug("Condition: qtree: " + qtree.getId());
		
		if(dispositionExists(qtree, controllerRootRuleDisposition)) {
			return false;
		}
		
		logger.debug("Condition: Satisfied");
		logger.debug("Condition: [EXIT]");
		return true;
	}

	@Action(order = 1)
	public void then(@Fact("nasVolume") NasVolume nasVolume, @Fact("qtree") Qtree qtree) {
		logger.debug("Action: [ENTER]");

		logger.info("Action: Missing ROOT Volume for Controller: " + qtree.getNasVolume().getController().getId());

		logger.debug("Action: [EXIT]");
	}
	
	public boolean dispositionExists(Qtree qtree, String disposition) {
		List<QtreeDisposition> qDispositions = qtree.getQtreeDisposition();
		boolean returnVal = false;
		for(QtreeDisposition qtreeDisposition: qDispositions) {
			if(qtreeDisposition.getDisposition().equals(disposition)) {
				returnVal = true;
				break;
			}
		}
		return returnVal;
	}
}
