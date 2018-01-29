package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the activity_lob_x_ref database table.
 * 
 */
@Embeddable
public class ActivityLobXRefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="activity_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int activityId;

	@Column(name="lob_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int lobId;

	public ActivityLobXRefPK() {
	}
	
	public ActivityLobXRefPK(int activityId, int lobId) {
		super();
		this.activityId = activityId;
		this.lobId = lobId;
	}



	public int getActivityId() {
		return this.activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public int getLobId() {
		return this.lobId;
	}
	public void setLobId(int lobId) {
		this.lobId = lobId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ActivityLobXRefPK)) {
			return false;
		}
		ActivityLobXRefPK castOther = (ActivityLobXRefPK)other;
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