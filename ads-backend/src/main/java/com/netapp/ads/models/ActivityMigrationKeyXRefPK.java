package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the activity_migration_key_x_ref database table.
 * 
 */
@Embeddable
public class ActivityMigrationKeyXRefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="activity_id")
	private int activityId;

	@Column(name="migration_key_id")
	private int migrationKeyId;

	public ActivityMigrationKeyXRefPK() {
	}
	public int getActivityId() {
		return this.activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public int getMigrationKeyId() {
		return this.migrationKeyId;
	}
	public void setMigrationKeyId(int migrationKeyId) {
		this.migrationKeyId = migrationKeyId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ActivityMigrationKeyXRefPK)) {
			return false;
		}
		ActivityMigrationKeyXRefPK castOther = (ActivityMigrationKeyXRefPK)other;
		return 
			(this.activityId == castOther.activityId)
			&& (this.migrationKeyId == castOther.migrationKeyId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.activityId;
		hash = hash * prime + this.migrationKeyId;
		
		return hash;
	}
}