package refactor.rules;
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
import org.jeasy.rules.api.Facts;
//import org.easyrules.core.BasicRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.exception.NetAppAdsException;
import com.netapp.ads.models.NasVolume;
import refactor.services.VolumeService;

@Rule (name = "Discover Owner", description = "Rule to determine if a volume was for dicovery")
@Service
public class DiscoveryRule {
	
	private static final Logger logger = LoggerFactory.getLogger(DiscoveryRule.class);
	//commented below since we want to get this from facts
	//private NasVolume volume;
	private String  volDisposition;
	private boolean response;
	private final static String DISCOVER_OWNER="DiscoverOwner";
	private final static String JUSTIFICATION="No Rules Matched";
	
	//This is probably not needed as we are injecting RulesEasy Facts
	//commented this since we want to fetch this from facts
	//public void setVolume(NasVolume volume) {
	//	this.volume = volume;
	//}

	@Autowired
	VolumeService volService;
	
	@Priority
	public int getPriority(){
		return 100;
	}
	
	@Condition
	//public boolean when(Facts facts) {
	//added this annotation parameter so the fact added is recieved here
	public boolean when(@Fact("nasVolume") NasVolume nasVolume) {
		//use the above nasVolume instead of the one from setVolume
		logger.debug("In Discover Rule");
		//volDisposition  = volume.getDisposition();
		volDisposition  = nasVolume.getDisposition();
		if (volDisposition==null||volDisposition.isEmpty()) {
			response=true;
		} else {
			response=false;
		}
		return response;
	}
	
	////added this annotation parameter so the fact added is recieved here
	@Action (order=1)
	public void then(@Fact("nasVolume") NasVolume nasVolume) {
		//logger.debug("In Discover Rule catch 2:"+volume.getId());
		//volume.setDisposition(DISCOVER_OWNER);
		//volume.setJustification(JUSTIFICATION);
		logger.debug("In Discover Rule catch 2:"+nasVolume.getId());
		nasVolume.setDisposition(DISCOVER_OWNER);
		nasVolume.setDisposition(JUSTIFICATION);
		try{
			//volService.updateDispositionById(volume.getId(), volume.getDisposition(),volume.getJustification());
			volService.updateDispositionById(nasVolume.getId(), nasVolume.getDisposition(),nasVolume.getJustification());
		} catch (NetAppAdsException e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}		
		//logger.debug("Discover Rule disposition : "+volume.getId()+":"+volume.getDisposition());
		logger.debug("Discover Rule disposition : "+nasVolume.getId()+":"+nasVolume.getDisposition());
	}
}
