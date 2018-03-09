package com.netapp.ads.rules.rules;
/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/

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
import com.netapp.ads.repos.QtreeRepository;

@Rule(name = "Controller Root", description = "Rule to determine if a volume is a controller root volume")
@Service
public class ControllerRootRule {
	private static final Logger logger = LoggerFactory.getLogger(ControllerRootRule.class);

	@Value("${ads.rule.controller_root_rule.root_vol_name}")
	private String rootVolumeName;
	
	@Value("${ads.rule.controller_root_rule.disposition}")
	private String disposition;
	
	@Value("${ads.rule.controller_root_rule.justification}")
	private String justification;
	
	@Value("${ads.rule.controller_root_rule.priority}")
	private int priority;
	
	@Autowired
	QtreeRepository qtreeRepository;

	@Priority
	public int getPriority() {
		return priority;
	}

	@Condition
	public boolean when(@Fact("nasVolume") NasVolume nasVolume) {
		logger.debug("Condition: [ENTER]");
		logger.debug("Condition: nasVolume: " + nasVolume.getId());

		String volName = nasVolume.getVolumeName();
		if (volName != null && volName.length() > 3 && (volName.startsWith(rootVolumeName) || volName.endsWith(rootVolumeName))) {
			logger.debug("Condition: satisfied");
			return true;
		}
		logger.debug("Condition: NOT satisfied");
		logger.debug("Condition: [EXIT]");
		return false;
	}

	@Action(order = 1)
	public void then(@Fact("nasVolume") NasVolume nasVolume) {
		logger.debug("Action: [ENTER]");
		logger.debug("Action: nasVolume:" + nasVolume.getId());

		for(Qtree qtree : nasVolume.getQtrees()) {
			qtree.setDisposition(disposition);
			qtree.setJustification(justification);
			qtreeRepository.save(qtree);
		}
		logger.debug("Action: [EXIT]");
	}
}

