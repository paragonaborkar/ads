package refactor.rules;
/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/


import java.io.IOException;
import java.util.Properties;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Priority;
import org.easyrules.annotation.Rule;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.Months;
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
import com.netapp.ads.repos.NasVolumeRepository;


@Rule (name = "Aged Access", description = "Rule to determine if a volume was last accessed before a number of days")
@Service
public class AgedAccessRule{
	
	private static final Logger logger = LoggerFactory.getLogger(AgedAccessRule.class);
	
	private final static String ROOT_VOL_NAME="vol0";
	private final static String AGED_3="Aged_3"; //disposition of volume accessed 3 months ago
	private final static String AGED_6="Aged_6";
	private final static String AGED_13="Aged_13";
	private final static String JUSTIFICATION_3="Aged - No access in 3 months";
	private final static String JUSTIFICATION_6="Aged - No access in 6 months";
	private final static String JUSTIFICATION_13="Aged - No access in 13 months";
	
	private NasVolume volume;
	
	private Integer duration;

	//TODO: NEED TO MOVE ALL FINAL STATIC VARIABLES TO PROPERTIES FILE
	private Integer durLimit = 3;//default is 3 month
	
	public void setVolume(NasVolume volume) {
		this.volume = volume;
	}
	
	public void setDurLimit(Integer limit) {
		this.durLimit = limit;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}	
	@Autowired
	NasVolumeRepository volService;
	
	@Autowired
	ControllerRepository contService;
	
	@Autowired
	AggregateRepository aggrService;
	
	@Priority
	public int getPriority(){
		return 10;
	}
	
	@Condition
	public boolean when() {
		logger.debug("In Aged Access Rule");
		Properties prop = new Properties();

		try {
			prop.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}
		
		durLimit=Integer.parseInt(prop.getProperty("Aged.Limit1"));
		
		String volName = volume.getVolumeName();
		if (volName!=null&&volName.length()>3&&(volName.substring(0,4).equalsIgnoreCase(ROOT_VOL_NAME)||volName.substring(volName.length()-4,volName.length()).equalsIgnoreCase(ROOT_VOL_NAME))) 
		{
			return false;
		}
		LocalDateTime dateNow = LocalDateTime.now();
//		LocalDateTime access  = volume.getVolumeLastAccessed();
		//FIXME: Need to confirm this value is correct (more that it works)
		LocalDateTime access  = new LocalDateTime(volume.getVolumeLastAccessed());  
		if(access!=null){
			logger.debug("Last Access : "+access.toString());
			duration = Months.monthsBetween(access.toDateTime(DateTimeZone.UTC), dateNow.toDateTime(DateTimeZone.UTC)).getMonths();
			logger.debug("Duration : "+duration);
			if (duration >= durLimit) {
				return true;
			} 
		}
		return false;
	}
	
	@Action (order=1)
	public void then()  {
		LocalDateTime dateNow = LocalDateTime.now();
		// FIXME: 
//		LocalDateTime access  = volume.getVolumeLastAccessed();
		//FIXME: Need to confirm this value is correct (more that it works)
		LocalDateTime access  =  new LocalDateTime(volume.getVolumeLastAccessed());
		if(access!=null){
			logger.debug("Last Access : "+access.toString());
			duration = Months.monthsBetween(access.toDateTime(DateTimeZone.UTC), dateNow.toDateTime(DateTimeZone.UTC)).getMonths();
			logger.debug("Duration : "+duration);
		}
		logger.debug("In Aged Access Rule catch:"+volume.getId()+":"+duration);
		
		String disposition = volume.getDisposition();	
		String justificaton = volume.getJustification();
		
		String aged;
		String just;
		
		if(duration>=13){
			aged=AGED_13;
			just=JUSTIFICATION_13;
		}else if(duration>=6){
			aged=AGED_6;
			just=JUSTIFICATION_6;
		}else{
			aged=AGED_3;
			just=JUSTIFICATION_3;
		}
		
		if (disposition == null || disposition.isEmpty()) {
			volume.setDisposition(aged);
		} else{
			if(!disposition.contains(aged)){
				StringBuilder sbDisposition=new StringBuilder(disposition);
				sbDisposition.append(","+aged);
				volume.setDisposition(sbDisposition.toString());
			}
		}
		
		if (justificaton == null || justificaton.isEmpty()) {
			volume.setJustification(just);
		} else{
			
			if(!justificaton.contains(just)){
				StringBuilder sbJustification=new StringBuilder(justificaton);
				sbJustification.append(","+just);
				volume.setJustification(sbJustification.toString());
			}
		}

		try{
			// The following method just saves the values:
			// from MMS: private static final String UPDATE_DISPOSITION_BY_ID = "Update VolumeEntity a Set a.disposition=:disp, a.justification=:justification where a.intVolId=:intVolId";
//			volService.updateDispositionById(volume.getId(), volume.getDisposition(),volume.getJustification());
			// For ADS, we just need to save what was previously set (above code)...
			volService.save(volume);
						
		} catch (NetAppAdsException e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}		
		logger.debug("Aged Access Rule End : "+volume.getId()+":"+volume.getDisposition());
//		getInfo();
		
	}
	
	/*private void getInfo () {
		Controller cont = null;
		Aggregate  aggr = null;
		String contName = null;
		String aggrName = null;
		String volName;
		Integer contId;
		Integer aggrId;
		
		contId = volume.getContId();
		aggrId = volume.getAggrId();
		volName = volume.getVolName();
		
		try {
			cont = contService.getOne(contId);
			contName = cont.getControllerName();
		} catch (NetAppAdsException e) {
			logger.error(e.getMessage(),e);
		}
		
		
		try {
			aggr = aggrService.getOne(aggrId);
			aggrName = aggr.getAggregateName();
		} catch (NetAppAdsException e) {
			logger.error(e.getMessage(),e);
		}
		
		logger.info("{}:{}:{} is an aged orphan volume",contName,aggrName,volName);
	}*/
}
