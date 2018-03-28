package com.netapp.ads.hhcc.vo;

import java.io.Serializable;

public class NADataSource implements Serializable {

	String id;
    String self;
    String impactIndex;
    String name;
    String status;
    String statusText;
    String pollStatus;
    String vendor;
    String model;
	String foundationIp;
    String lastSuccessfullyAcquired;
    String resumeTime; 
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getImpactIndex() {
		return impactIndex;
	}
	public void setImpactIndex(String impactIndex) {
		this.impactIndex = impactIndex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusText() {
		return statusText;
	}
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}
	public String getPollStatus() {
		return pollStatus;
	}
	public void setPollStatus(String pollStatus) {
		this.pollStatus = pollStatus;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFoundationIp() {
		return foundationIp;
	}
	public void setFoundationIp(String foundationIp) {
		this.foundationIp = foundationIp;
	}
	public String getLastSuccessfullyAcquired() {
		return lastSuccessfullyAcquired;
	}
	public void setLastSuccessfullyAcquired(String lastSuccessfullyAcquired) {
		this.lastSuccessfullyAcquired = lastSuccessfullyAcquired;
	}
	public String getResumeTime() {
		return resumeTime;
	}
	public void setResumeTime(String resumeTime) {
		this.resumeTime = resumeTime;
	}

    	
}
