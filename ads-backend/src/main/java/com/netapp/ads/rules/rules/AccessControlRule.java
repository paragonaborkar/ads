package com.netapp.ads.rules.rules;
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
import java.util.ArrayList;
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
import org.springframework.util.StringUtils;

import com.netapp.ads.exception.NetAppAdsException;
import com.netapp.ads.models.Host;
import com.netapp.ads.models.NasVolume;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.Share;
import com.netapp.ads.repos.QtreeRepository;

@Rule(name = "Access Control List", description = "Rule to determine if a volume still has host which access to it")
@Service
public class AccessControlRule {

	private static final Logger logger = LoggerFactory.getLogger(AccessControlRule.class);
	
	public static final String SHARE_TYPE_CIFS = "CIFS";
	
	public static final String SHARE_TYPE_NFS = "NFS";

	@Value("${ads.rule.access_control_rule.priority}")
	private int priority;

	@Value("${ads.rule.access_control_rule.root_vol_name}")
	private String rootVolName;

	@Value("${ads.rule.access_control_rule.nfs_disposition}")
	private String nfsDisposition;

	@Value("${ads.rule.access_control_rule.nfs_justification}")
	private String nfsJustification;

	@Value("${ads.rule.access_control_rule.cifs_nfs_disposition}")
	private String cifsNfsDisposition;

	@Value("${ads.rule.access_control_rule.cifs_nfs_justification}")
	private String cifsNfsJustification;

	@Value("${ads.rule.access_control_rule.cifs_disposition}")
	private String cifsDisposition;

	@Value("${ads.rule.access_control_rule.cifs_justification}")
	private String cifsJustification;

	@Autowired
	QtreeRepository qtreeRepository;

	@Priority
	public int getPriority() {
		return priority;
	}

	@Condition
	public boolean when(@Fact("nasVolume") NasVolume nasVolume, @Fact("qtree") Qtree qtree) {
		logger.debug("Condition: [ENTER]");
		logger.debug("Condition: qtree: " + qtree.getId());
		
		String volName = nasVolume.getVolumeName();
		if (volName != null && volName.length() > 3 && (volName.startsWith(rootVolName) || volName.endsWith(rootVolName))) {
			return false;
		}

		boolean isQtreeAssociatedWithAtleastOneHost = isQtreeAssociatedWithAtleastOneHost(qtree);
		logger.debug("Condition: isQtreeAssociatedWithAtleastOneHost: " + isQtreeAssociatedWithAtleastOneHost);
		if(isQtreeAssociatedWithAtleastOneHost) {
			logger.debug("Condition: NOT Satisfied");
			logger.debug("Condition: [EXIT]");
			return false;
		}

		try {
			List<Share> shareList = qtree.getShares();
			for(Share share : shareList) {
				if(share.getShareType().contains(SHARE_TYPE_CIFS)) {
					logger.debug("Condition: ShareType: " + share.getShareType());
					logger.debug("Condition: NOT Satisfied");
					logger.debug("Condition: [EXIT]");
					return false;
				}
				
				Host host = share.getHost();
				if(host.getHostName().equals("*")) {
					logger.debug("Condition: Hostname is *: " + host.getHostName());
					logger.debug("Condition: NOT Satisfied");
					logger.debug("Condition: [EXIT]");
					return false;
				} else if(isReachable(host.getHostName())) {
					logger.debug("Condition: Hostname is reacheable");
					logger.debug("Condition: NOT Satisfied");
					logger.debug("Condition: [EXIT]");
					return false;
				}
			}
		} catch (NetAppAdsException e) {
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.debug("Condition: Satisfied");
		logger.debug("Condition: [EXIT]");
		return true;
	}

	@Action(order = 1)
	public void then(@Fact("nasVolume") NasVolume nasVolume, @Fact("qtree") Qtree qtree) {
		logger.debug("Action: [ENTER]");

		int cifsCount = 0;
		int nfsCount = 0;

		List<Share> shares = qtree.getShares();
		for(Share share : shares) {
			if(share.getShareType().equals(SHARE_TYPE_CIFS))
				cifsCount++;
			else if(share.getShareType().equals(SHARE_TYPE_NFS))
				nfsCount++;
		}
		
		logger.debug("Action: cifsCount: " + cifsCount + ", nfsCount: " + nfsCount);
		
		if(cifsCount == 0) {
			if (StringUtils.isEmpty(qtree.getDisposition())) {
				qtree.setDisposition(nfsDisposition);
			} else {
				if (!qtree.getDisposition().contains(nfsDisposition)) {
					qtree.setDisposition(new StringBuilder(qtree.getDisposition()).append(",").append(nfsDisposition).toString());
				}
			}

			if (StringUtils.isEmpty(qtree.getJustification())) {
				qtree.setJustification(nfsJustification);
			} else {
				if (!qtree.getJustification().contains(nfsJustification)) {
					qtree.setJustification(new StringBuilder(qtree.getJustification()).append(",").append(nfsJustification).toString());
				}
			}
			
		} else if (cifsCount > 0 && nfsCount > 0) {
			if (StringUtils.isEmpty(qtree.getDisposition())) {
				qtree.setDisposition(cifsNfsDisposition);
			} else {
				if (!qtree.getDisposition().contains(cifsNfsDisposition)) {
					qtree.setDisposition(new StringBuilder(qtree.getDisposition()).append(",").append(cifsNfsDisposition).toString());
				}
			}

			if (StringUtils.isEmpty(qtree.getJustification())) {
				qtree.setJustification(cifsNfsJustification);
			} else {

				if (!qtree.getJustification().contains(cifsNfsJustification)) {
					qtree.setJustification(new StringBuilder(qtree.getJustification()).append(",").append(cifsNfsJustification).toString());
				}
			}
		} else {
			if (StringUtils.isEmpty(qtree.getDisposition())) {
				qtree.setDisposition(cifsDisposition);
			} else {
				if (!qtree.getDisposition().contains(cifsDisposition)) {
					qtree.setDisposition(new StringBuilder(qtree.getDisposition()).append(",").append(cifsDisposition).toString());
				}
			}

			if (StringUtils.isEmpty(qtree.getJustification())) {
				qtree.setJustification(cifsJustification);
			} else {
				if (!qtree.getJustification().contains(cifsJustification)) {
					nasVolume.setJustification(new StringBuilder(qtree.getJustification()).append(",").append(cifsJustification).toString());
				}
			}
		}

		qtreeRepository.save(qtree);
		logger.debug("Action: [EXIT]");
	}
	
	public List<Share> getSharesByNasVolue(NasVolume nasVolume) {
		List<Share> shareList = new ArrayList<Share>();
		for(Qtree qtree : nasVolume.getQtrees()) {
			shareList.addAll(qtree.getShares());
		}
		return shareList;
	}
	
	public boolean isQtreeAssociatedWithAtleastOneHost(Qtree qtree) {
		boolean returnVal = false;
		List<Share> shares = qtree.getShares();
		for(Share share : shares) {
			if(!StringUtils.isEmpty(share.getHost())) {
				returnVal = true;
				break;
			}
		}
		return returnVal;
	}

	public Boolean isReachable(String hostName) {
		try {
			final InetAddress host = InetAddress.getByName(hostName);

			try {
				return host.isReachable(3000);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		} catch (UnknownHostException e) {
			logger.error(e.getMessage(), e);
			return false;
		}
		return false;
	}
}
