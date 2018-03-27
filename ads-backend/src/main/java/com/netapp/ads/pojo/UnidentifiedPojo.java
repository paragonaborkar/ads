package com.netapp.ads.pojo;



public class UnidentifiedPojo {
	private static final long serialVersionUID = 1L;
	
	private int activityId;
	private String activityResourceUrl;
	
	private int currentUserCorporateId;
	
	private String reasonCode;
	private String reason;
	
	private int requestedByUserCorporateId;
	private String requestedByUserCorporateResourceUrl;
	

	public UnidentifiedPojo() {
	}

	public Integer getCurrentUserCorporateId() {
		return this.currentUserCorporateId;
	}

	public void setCurrentUserCorporateId(Integer currentUserCorporateId) {
		this.currentUserCorporateId = currentUserCorporateId;
	}
	
	public String getActivityResourceUrl() {
		return this.activityResourceUrl;
	}

	public void setActivityResourceUrl(String activityResourceUrl) {
		this.activityResourceUrl = activityResourceUrl;
	}
	
	
	public String getReasonCode() {
		return this.reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	public int getRequestedByUserCorporateId() {
		return this.requestedByUserCorporateId;
	}

	public void setRequestedByUserCorporateId(int requestedByUserCorporateId) {
		this.requestedByUserCorporateId = requestedByUserCorporateId;
	}
	
	public String getRequestedByUserCorporateResourceUrl() {
		return this.requestedByUserCorporateResourceUrl;
	}

	public void getRequestedByUserCorporateResourceUrl(String requestedByUserCorporateResourceUrl) {
		this.requestedByUserCorporateResourceUrl = requestedByUserCorporateResourceUrl;
	}
	
	public Integer getActivityId() {
		return this.activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	

	
	

}