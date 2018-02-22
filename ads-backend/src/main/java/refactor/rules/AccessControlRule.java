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
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

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
import com.netapp.ads.models.NasVolume;
import com.netapp.ads.models.Share;
import com.netapp.ads.repos.AggregateRepository;
import com.netapp.ads.repos.ControllerRepository;

import refactor.services.ImpactService;
import refactor.services.ShareService;
import refactor.services.VolumeService;

@Rule (name = "Access Control List", description = "Rule to determine if a volume still has host which access to it")
@Service
public class AccessControlRule{
	
	private static final Logger logger = LoggerFactory.getLogger(AccessControlRule.class);
	
	private final static String ROOT_VOL_NAME="vol0";
	private final static String NFSDISPOSITION="NFS-Orphan";
	private final static String NFSJUSTIFICATION="ACL- Meets customer's NFS ACL Orphan rule";
	private final static String CIFSNFSDISPOSITION="NFS-Orphan w/CIFS";
	private final static String CIFSNFSJUSTIFICATION="ACL- Meets customer's NFS ACL Orphan rule and no host connection to CIFS shares";
	private final static String CIFSDISPOSITION="CIFS-Orphan";
	private final static String CIFSJUSTIFICATION="CIFS Orphan- No hosts connected";
	
	private NasVolume volume;

	public void setVolume(NasVolume volume) {
		this.volume = volume;
	}
	
	@Autowired
	VolumeService volService;
	@Autowired
	ShareService shareService;
	@Autowired
	ImpactService impactService;
	
	@Autowired
	ControllerRepository contService;
	
	@Autowired
	AggregateRepository aggrService;
	
	@Priority
	public int getPriority(){
		return 20;
	}
	
	@Condition
	public boolean when() {
		logger.debug("In Access Control Rule");
		int volId = volume.getId();//some value get from volume entity used to get host list
		String volName = volume.getVolumeName();
		
		if (volName!=null&&volName.length()>3&&(volName.substring(0,4).equalsIgnoreCase(ROOT_VOL_NAME)||volName.substring(volName.length()-4,volName.length()).equalsIgnoreCase(ROOT_VOL_NAME))) 
		{
			logger.debug("Access Rule root control catch : "+volume.getId());
			return false;
		}
			
		try{
			if(shareService.getHostCountByVol(volId)>0){
				logger.debug("Access Rule host count>0 catch : "+volume.getId());
				return false;
			}
		}
		catch (NetAppAdsException e) {
			logger.error(e.getMessage());
		}
			
		try{
			List<Share> shareList = shareService.getByVol(volId);
			if(shareList!=null&&!shareList.isEmpty()){
				List<String> hostList;
				for(Share share:shareList){
					String shareType = share.getShareType();
					
					if (shareType.contains("CIFS") ) {
						return false;
					}
					
					hostList = impactService.getHostsByShare(share.getShareName());
					if(hostList!=null&&!hostList.isEmpty()){
						for (String host:hostList){
			
							if(host.equals("*")){
								logger.debug("Access Rule hostName=* catch : "+volume.getId());
								return false;
							}
							else if(isReachable(host)){	
								logger.debug("Access Rule is reachable catch : "+volume.getId());
								return false;
							}
						}
					}
				}
			}
		}catch(NetAppAdsException e){
			logger.error(e.getMessage(),e);
		}catch(Exception e)	{
			logger.error(e.getMessage(),e);
		}

		return true;
	}
	
	@Action (order=1)
	public void then()  {
		Integer volId = volume.getId();
		logger.debug("In Access Rule catch: {}" , volId);
		Integer cifsCounter = 0;
		Integer nfsCounter = 0;
		
		String disposition = volume.getDisposition();	
		String justificaton = volume.getJustification();
		
		try {
			List<Share> shareList = shareService.getByVol(volId);
			if(shareList!=null&&!shareList.isEmpty()) {
				for(Share share:shareList){
					String shareType = share.getShareType();
					if (shareType.equals("CIFS")) {
						cifsCounter++;
					}
					if (shareType.equals("NFS")) {
						nfsCounter++;
					}
				}
			}
		} catch (NetAppAdsException e1) {
			logger.error(e1.getMessage(),e1);
		}
		
		if (cifsCounter == 0) {
			if (disposition == null || disposition.isEmpty()) {
				volume.setDisposition(NFSDISPOSITION);
			} else{
				if(!disposition.contains(NFSDISPOSITION)){
					StringBuilder sbDisposition=new StringBuilder(disposition);
					sbDisposition.append(","+NFSDISPOSITION);
					volume.setDisposition(sbDisposition.toString());
				}
			}
			
			if (justificaton == null || justificaton.isEmpty()) {
				volume.setJustification(NFSJUSTIFICATION);
			} else{
				
				if(!justificaton.contains(NFSJUSTIFICATION)){
					StringBuilder sbJustification=new StringBuilder(justificaton);
					sbJustification.append(","+NFSJUSTIFICATION);
					volume.setJustification(sbJustification.toString());
				}
			}
		} else if ( cifsCounter > 0 && nfsCounter > 0){
			if (disposition == null || disposition.isEmpty()) {
				volume.setDisposition(CIFSNFSDISPOSITION);
			} else{
				if(!disposition.contains(CIFSNFSDISPOSITION)){
					StringBuilder sbDisposition=new StringBuilder(disposition);
					sbDisposition.append(","+CIFSNFSDISPOSITION);
					volume.setDisposition(sbDisposition.toString());
				}
			}
			
			if (justificaton == null || justificaton.isEmpty()) {
				volume.setJustification(CIFSNFSJUSTIFICATION);
			} else{
				
				if(!justificaton.contains(CIFSNFSJUSTIFICATION)){
					StringBuilder sbJustification=new StringBuilder(justificaton);
					sbJustification.append(","+CIFSNFSJUSTIFICATION);
					volume.setJustification(sbJustification.toString());
				}
			}
		} else {
			if (disposition == null || disposition.isEmpty()) {
				volume.setDisposition(CIFSDISPOSITION);
			} else{
				if(!disposition.contains(CIFSDISPOSITION)){
					StringBuilder sbDisposition=new StringBuilder(disposition);
					sbDisposition.append(","+CIFSDISPOSITION);
					volume.setDisposition(sbDisposition.toString());
				}
			}
			
			if (justificaton == null || justificaton.isEmpty()) {
				volume.setJustification(CIFSJUSTIFICATION);
			} else{
				
				if(!justificaton.contains(CIFSJUSTIFICATION)){
					StringBuilder sbJustification=new StringBuilder(justificaton);
					sbJustification.append(","+CIFSJUSTIFICATION);
					volume.setJustification(sbJustification.toString());
				}
			}
		}
		
		try{
			volService.updateDispositionById(volume.getId(), volume.getDisposition(),volume.getJustification());
		} catch (NetAppAdsException e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}		
		logger.debug("Access Rule End : "+volume.getId()+":"+volume.getDisposition());
//		getInfo();
		
	}

    public Boolean isReachable(String ipaddress) {
        try {
            final InetAddress host = InetAddress.getByName(ipaddress);

            try {
                return host.isReachable(3000);
            } catch (IOException e) {
            	logger.error(e.getMessage(),e);
            }
        } catch (UnknownHostException e) {
        	logger.error(e.getMessage(),e);
            return false;
        }
        return false;
    }
    
	/*private void getInfo () {
		ControllerEntity cont = null;
		AggregateEntity aggr = null;
		String contName = null;
		String aggrName = null;
		String volName;
		Integer contId;
		Integer aggrId;
		
		contId = volume.getContId();
		aggrId = volume.getAggrId();
		volName = volume.getVolName();
		
		try {
			cont = contService.getById(contId);
			contName = cont.getControllerName();
		} catch (NetAppAdsException e) {
			logger.error(e.getMessage(),e);
		}
		
		
		try {
			aggr = aggrService.getById(aggrId);
			aggrName = aggr.getName();
		} catch (NetAppAdsException e) {
			logger.error(e.getMessage(),e);
		}
		
		logger.info("{}:{}:{} is an NFS orphan volume",contName,aggrName,volName);
	}*/
}
