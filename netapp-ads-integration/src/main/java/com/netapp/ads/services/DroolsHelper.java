package com.netapp.ads.services;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.models.Host;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.QtreeDisposition;
import com.netapp.ads.models.Share;
import com.netapp.ads.repos.QtreeDispositionRepository;
import com.netapp.ads.util.DateUtils;

@Service
public class DroolsHelper {
	
	private static final Logger log = LoggerFactory.getLogger(DroolsHelper.class);
	
	@Autowired
	QtreeDispositionRepository qtreeDispositionRepository;
	
	/**
	 * Returns true if shares associated with this qtree have at least one host
	 * 
	 * @param qtree
	 * @return
	 */
	public boolean isQtreeAssociatedWithAtleastOneHost(Qtree qtree) {
		boolean returnVal = false;
		List<Share> shares = qtree.getShares();
		for(Share share : shares) {
			if(share.getHost() != null) {
				returnVal = true;
				break;
			}
		}
		return returnVal;
	}
	
	public boolean qtreeAnyShareIsOfType(Qtree qtree, String shareType) {
		List<Share> shareList = qtree.getShares();
		for(Share share : shareList) {
			if(share.getShareType().contains(shareType)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean qtreeAnyHostNameIs(Qtree qtree, String hostNameToCheck) {
		List<Share> shareList = qtree.getShares();
		for(Share share : shareList) {
			Host host = share.getHost();
			if(host.getHostName().equals(hostNameToCheck)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean qtreeAnyHostIsReacheable(Qtree qtree) {
		List<Share> shareList = qtree.getShares();
		for(Share share : shareList) {
			Host host = share.getHost();
			if(isReachable(host.getHostName())) {
				return true;
			}
		}
		return false;
	}
	
	public int qtreeDurationBetweenLastAccessedAndNow(Qtree qtree) {
		LocalDateTime dateNow = LocalDateTime.now();
		LocalDateTime lastAccessed = DateUtils.asLocalDateTime(qtree.getLastAccessed());
		if (lastAccessed != null) {
			int duration = (int) ChronoUnit.MONTHS.between(lastAccessed.toLocalDate(), dateNow.toLocalDate());
			return duration;
		}
		return 0;
	}
	
	public Boolean isReachable(String hostName) {
		try {
			final InetAddress host = InetAddress.getByName(hostName);
			try {
				return host.isReachable(3000);
			} catch (IOException e) {
			}
		} catch (UnknownHostException e) {
			return false;
		}
		return false;
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
	
	public int getCountOfDispositions(Qtree qtree) {
		List<QtreeDisposition> qtreeDispositions = qtreeDispositionRepository.findByQtree(qtree);
		if(qtreeDispositions.isEmpty())
			return 0;
		else
			return qtreeDispositions.size();
	}
}
