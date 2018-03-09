package com.netapp.ads.rules.rules;
/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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
import com.netapp.ads.repos.QtreeRepository;
import com.netapp.ads.util.DateUtils;

@Rule(name = "Aged Access", description = "Rule to determine if a volume was last accessed before a number of days")
@Service
public class AgedAccessRule {

	private static final Logger logger = LoggerFactory.getLogger(AgedAccessRule.class);

	@Value("${ads.rule.aged_access_rule.root_vol_name}")
	private String rootVolName;
	
	@Value("${ads.rule.aged_access_rule.aged_limit_1}")
	private Integer agedDurationLimit1;
	
	@Value("${ads.rule.aged_access_rule.aged_3}")
	private String aged3; // disposition of volume accessed 3 months ago
	
	@Value("${ads.rule.aged_access_rule.aged_6}")
	private String aged6;
	
	@Value("${ads.rule.aged_access_rule.aged_13}")
	private String aged13;
	
	@Value("${ads.rule.aged_access_rule.justification_3}")
	private String justification3;
	
	@Value("${ads.rule.aged_access_rule.justification_6}")
	private String justification6;
	
	@Value("${ads.rule.aged_access_rule.justification_13}")
	private String justification13;
	
	@Value("${ads.rule.aged_access_rule.priority}")
	private int priority;

	@Autowired
	QtreeRepository qtreeRepository;

	@Priority
	public int getPriority() {
		return priority;
	}

	@Condition
	public boolean when(@Fact("nasVolume") NasVolume nasVolume, @Fact("qtree") Qtree qtree) {
		logger.debug("Condition: [ENTER]");
		logger.debug("Condition: nasVolume: " + nasVolume.getId());
		
		//Is this even needed as this is already tackled in controller root rule
		String volName = nasVolume.getVolumeName();
		if (volName != null && volName.length() > 3 && (volName.startsWith(rootVolName) || volName.endsWith(rootVolName))) {
			return false;
		}
		
		LocalDateTime dateNow = LocalDateTime.now();
		// LocalDateTime access = volume.getVolumeLastAccessed();
		// FIXME: Need to confirm this value is correct (more that it works)
		LocalDateTime lastAccessed = DateUtils.asLocalDateTime(qtree.getLastAccessed());
		if (lastAccessed != null) {
			int duration = (int) ChronoUnit.MONTHS.between(lastAccessed.toLocalDate(), dateNow.toLocalDate());
			logger.debug("Condition: lastAccessed: " + lastAccessed + ", dateNow: " + dateNow + ", duration: " + duration);
			if (duration >= agedDurationLimit1) {
				logger.debug("Condition: Satisfied");
				logger.debug("Condition: [EXIT]");
				return true;
			}
		}
		logger.debug("Condition: NOT satisfied");
		logger.debug("Condition: [EXIT]");
		return false;
	}

	@Action(order = 1)
	public void then(@Fact("nasVolume") NasVolume nasVolume, @Fact("qtree") Qtree qtree) {
		logger.debug("Action: [ENTER]");
		logger.debug("Action: qtree: " + qtree.getId());
		LocalDateTime dateNow = LocalDateTime.now();
		// FIXME:
		// LocalDateTime access = volume.getVolumeLastAccessed();
		// FIXME: Need to confirm this value is correct (more that it works)
		LocalDateTime lastAccessed = DateUtils.asLocalDateTime(qtree.getLastAccessed());;
		
		int duration = 0;
		if (lastAccessed != null) {
			duration = (int) ChronoUnit.MONTHS.between(lastAccessed.toLocalDate(), dateNow.toLocalDate());
		}
		logger.debug("Action: lastAccessed: " + lastAccessed + ", dateNow: " + dateNow + ", duration: " + duration);

		String newDisposition;
		String newJustification;

		if (duration >= 13) {
			newDisposition = aged13;
			newJustification = justification13;
		} else if (duration >= 6) {
			newDisposition = aged6;
			newJustification = justification6;
		} else {
			newDisposition = aged3;
			newJustification = justification3;
		}

		if (StringUtils.isEmpty(qtree.getDisposition())) {
			qtree.setDisposition(newDisposition);
		} else {
			if (!qtree.getDisposition().contains(newDisposition)) {
				qtree.setDisposition(new StringBuilder(qtree.getDisposition()).append(",").append(newDisposition).toString());
			}
		}

		if (StringUtils.isEmpty(qtree.getJustification())) {
			qtree.setJustification(newJustification);
		} else {
			if (!qtree.getJustification().contains(newJustification)) {
				qtree.setJustification(new StringBuilder(qtree.getJustification()).append(",").append(newJustification).toString());
			}
		}

		qtreeRepository.save(qtree);
		logger.debug("Action: [EXIT]");
	}
}
