package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the activity_response database table.
 * 
 */
@Embeddable
public class ActivityResponsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="activity_id")
	private int activityId;

	private int id;

	public ActivityResponsePK() {
	}
	public int getActivityId() {
		return this.activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ActivityResponsePK)) {
			return false;
		}
		ActivityResponsePK castOther = (ActivityResponsePK)other;
		return 
			(this.activityId == castOther.activityId)
			&& (this.id == castOther.id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.activityId;
		hash = hash * prime + this.id;
		
		return hash;
	}
}