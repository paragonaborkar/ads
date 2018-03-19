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
import org.springframework.util.StringUtils;

import com.netapp.ads.models.NasVolume;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.QtreeDisposition;
import com.netapp.ads.repos.QtreeDispositionRepository;
import com.netapp.ads.repos.QtreeRepository;

@Rule(name = "Discover Owner", description = "Rule to determine if a volume was for dicovery")
@Service
public class DiscoveryRule {

	private static final Logger logger = LoggerFactory.getLogger(DiscoveryRule.class);

	@Value("${ads.rule.discovery_rule.disposition}")
	private String disposition;
	
	@Value("${ads.rule.discovery_rule.justification}")
	private String justification;
	
	@Value("${ads.rule.discovery_rule.priority}")
	private int priority;

	@Autowired
	QtreeDispositionRepository qtreeDispositionRepository;

	@Priority
	public int getPriority() {
		return priority;
	}

	@Condition
	public boolean when(@Fact("nasVolume") NasVolume nasVolume, @Fact("qtree") Qtree qtree) {
		logger.debug("Condition: [ENTER]");
		logger.debug("Condition: qtree: " + qtree.getId());
		if (StringUtils.isEmpty(qtree.getQtreeDisposition().isEmpty())) {
			logger.debug("Condition: Satisfied");
			logger.debug("Condition: [EXIT]");
			return true;
		} else {
			logger.debug("Condition: NOT Satisfied");
			logger.debug("Condition: [EXIT]");
			return false;
		}
	}

	@Action(order = 1)
	public void then(@Fact("nasVolume") NasVolume nasVolume, @Fact("qtree") Qtree qtree) {
		logger.debug("Action: [ENTER]");
		logger.debug("Action: qtree: " + qtree.getId());
		QtreeDisposition qtreeDisposition = new QtreeDisposition();
		qtreeDisposition.setQtree(qtree);
		qtreeDisposition.setDisposition(disposition);
		qtreeDisposition.setJustification(justification);
		qtreeDispositionRepository.save(qtreeDisposition);
		logger.debug("Action: [EXIT]");
	}
}
