package com.netapp.ads.models.ext;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netapp.ads.models.Host;
import com.netapp.ads.models.Qtree;

public class QtreeOwner {

	//		Activity RESOURCE
	// 		Activity_Response RESOURCE
	//    	Application Name
	//    	QTree Name
	//    	Last Accessed
	//    	Hosts (Count)
	//    	Shares (Count)
	// 		OTHER FIELDS????????

	private String applicationName;
	private String qtreeName;
	private Date qtreeLastAccessed;
	private Host host;
//	private List<Share> shares;
	private int hostCount;
	private int shareCount;
	private Qtree qtree;
	

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
	public String getQtreeName() {
		return qtreeName;
	}

	public void setQtreeName(String qtreeName) {
		this.qtreeName = qtreeName;
	}
	
		
	public Date getQtreeLastAccessed() {
		return qtreeLastAccessed;
	}

	public void setQtreeLastAccessed(Date qtreeLastAccessed) {
		this.qtreeLastAccessed = qtreeLastAccessed;
	}
	
	public int getHostCount() {
		return hostCount;
	}

	public void setHostCount(int hostCount) {
		this.hostCount = hostCount;
	}
	
	public int getShareCount() {
		return shareCount;
	}

	public void setShareCount(int shareCount) {
		this.hostCount = shareCount;
	}

	//@JsonIgnore
	public Qtree getQtree() {
		return qtree;
	}

	public void setQtree(Qtree qtree) {
		this.qtree = qtree;
	}
	
	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}
	
}
