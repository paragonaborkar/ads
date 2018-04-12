package com.netapp.ads.pojo;

import java.sql.Timestamp;


public class QtreeOwnerPojo {
	private static final long serialVersionUID = 1L;
	
	private boolean isMultiOwner;
	private boolean callMe;
	private boolean isOwner;
	private boolean	isPresumed;
	private boolean	dontKnowOwner;
	private boolean	decommissionVolume;
	

	private int ownerUserCorporateId;
	private int currentUserCorporateId;
	private int suggestedOwnerUserCorporateId;
	private String suggestedOwnerUserCorporateResourceUrl;
	
	private int activityResponseId;
	

	private Timestamp decommissionByDate;
	
	public QtreeOwnerPojo() {
	}

	public Timestamp getDecommissionByDate() {
		return this.decommissionByDate;
	}

	public void setDecommissionByDate(Timestamp decommissionByDate) {
		this.decommissionByDate = decommissionByDate;
	}
	
	public boolean getIsMultiOwner() {
		return this.isMultiOwner;
	}

	public void setIsMultiOwner(boolean isMultiOwner) {
		this.isMultiOwner = isMultiOwner;
	}

	public boolean getIsOwner() {
		return this.isOwner;
	}

	public void setIsOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	public boolean getDecommissionVolume() {
		return this.decommissionVolume;
	}

	public void setDecommissionVolume(boolean decommissionVolume) {
		this.decommissionVolume = decommissionVolume;
	}
	
	
	public boolean getIsPresumed() {
		return this.isPresumed;
	}

	public void setIsPresumed(boolean isPresumed) {
		this.isPresumed = isPresumed;
	}
	
	public boolean getDontKnowOwner() {
		return this.dontKnowOwner;
	}

	public void setDontKnowOwner(boolean dontKnowOwner) {
		this.dontKnowOwner = dontKnowOwner;
	}
	
	
	public Integer getCurrentUserCorporateId() {
		return this.currentUserCorporateId;
	}

	public void setCurrentUserCorporateId(Integer currentUserCorporateId) {
		this.currentUserCorporateId = currentUserCorporateId;
	}
	
	public Integer getOwnerUserCorporateId() {
		return this.ownerUserCorporateId;
	}

	public void setOwnerUserCorporateId(Integer ownerUserCorporateId) {
		this.ownerUserCorporateId = ownerUserCorporateId;
	}

	public int getSuggestedOwnerUserCorporateId() {
		return this.suggestedOwnerUserCorporateId;
	}

	public void setSuggestedOwnerUserCorporateId(int suggestedOwnerUserCorporateId) {
		this.suggestedOwnerUserCorporateId = suggestedOwnerUserCorporateId;
	}
	
	public String getSuggestedOwnerUserCorporateResourceUrl() {
		return this.suggestedOwnerUserCorporateResourceUrl;
	}

	public void setSuggestedOwnerUserCorporateResourceUrl(String suggestedOwnerUserCorporateResourceUrl) {
		this.suggestedOwnerUserCorporateResourceUrl = suggestedOwnerUserCorporateResourceUrl;
	}
	
	public Integer getActivityResponseId() {
		return this.activityResponseId;
	}

	public void setActivityResponseId(Integer activityResponseId) {
		this.activityResponseId = activityResponseId;
	}

	
	public boolean getCallMe() {
		return this.callMe;
	}

	public void setCallMe(boolean callMe) {
		this.callMe = callMe;
	}

	
	

}