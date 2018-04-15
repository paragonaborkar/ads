package com.netapp.ads.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the activity_presumed_lob_x_ref database table.
 * 
 */
@Embeddable
public class ActivityPresumedLobXRefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="activity_id", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer activityId;

	@Column(name="lob_id", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer lobId;

	public ActivityPresumedLobXRefPK() {
	}
	
	public ActivityPresumedLobXRefPK(Integer activityId, Integer lobId) {
		super();
		this.activityId = activityId;
		this.lobId = lobId;
	}

	public Integer getActivityId() {
		return this.activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public Integer getLobId() {
		return this.lobId;
	}
	public void setLobId(Integer lobId) {
		this.lobId = lobId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ActivityPresumedLobXRefPK)) {
			return false;
		}
		ActivityPresumedLobXRefPK castOther = (ActivityPresumedLobXRefPK)other;
		return 
			(this.activityId == castOther.activityId)
			&& (this.lobId == castOther.lobId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.activityId;
		hash = hash * prime + this.lobId;
		
		return hash;
	}
}