package refactor.rules;
/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/


import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Priority;
import org.easyrules.annotation.Rule;
//import org.easyrules.core.BasicRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.exception.NetAppAdsException;
import com.netapp.ads.models.Aggregate;
import com.netapp.ads.models.Controller;
import com.netapp.ads.models.NasVolume;
import com.netapp.ads.repos.AggregateRepository;
import com.netapp.ads.repos.ControllerRepository;


import refactor.services.VolumeService;

@Rule (name = "Controller Root", description = "Rule to determine if a volume is a controller root volume")
@Service
public class ControllerRootRule{
	private static final Logger logger = LoggerFactory.getLogger(ControllerRootRule.class);	
	private NasVolume volume;
	private String volName;
	
	private final static String ROOT_VOL_NAME="vol0";
	private final static String CONTROLLER_ROOT="NetApp";
	private final static String JUSTIFICATION="Netapp System Volume";
	
	public void setVolume(NasVolume volume) {
		this.volume = volume;
	}
	@Autowired
	ControllerRepository contService;

	@Autowired
	VolumeService volService;
	
	@Autowired
	AggregateRepository aggrService;
	
	@Priority
	public int getPriority(){
		return 1;
	}
	
	@Condition
	public boolean when() {
		logger.debug("In control rule ");
		volName=volume.getVolumeName();
		if (volName!=null&&volName.length()>3&&(volName.substring(0,4).equalsIgnoreCase(ROOT_VOL_NAME)||volName.substring(volName.length()-4,volName.length()).equalsIgnoreCase(ROOT_VOL_NAME))) 
		{
			return true;
		}
		return false;
	}
	
	@Action (order=1)
	public void then() {
		logger.debug("In Controll Rule catch:"+volume.getId());
		
		volume.setDisposition(CONTROLLER_ROOT);
		volume.setJustification(JUSTIFICATION);
		try{
			volService.updateDispositionById(volume.getId(), volume.getDisposition(),volume.getJustification());
		} catch (NetAppAdsException e) {
			logger.error(e.getMessage(),e);
		}
		
		logger.debug("In Controll Rule disposition: {}: {}",volume.getId(), volume.getDisposition());

		// getInfo();

	}
	
	
/*	private void getInfo() {
		Controller cont = null;
		Aggregate aggr = null;
		String contName = null;
		String aggrName = null;
		String volName=volume.getVolumeName();
		
		try {
			cont = contService.getById(volume.getContId());
			contName = cont.getControllerName();
		} catch (NetAppAdsException e) {
			logger.error(e.getMessage(),e);
		}
		
		
		try {
			aggr = aggrService.getById(volume.getAggrId());
			aggrName = aggr.getAggregateName();
		} catch (NetAppAdsException e) {
			logger.error(e.getMessage(),e);
		}
		logger.info("{}:{}:{} is a NetApp volume",contName,aggrName,volName);
	}*/
}
