package com.netapp.ads.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the activity_migration_key_x_ref database table.
 * 
 */
@Embeddable
public class ActivityMigrationKeyXRefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="activity_id", unique=true, nullable=false)
	private Integer activityId;

	@Column(name="migration_key_id", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer migrationKeyId;

	public ActivityMigrationKeyXRefPK() {
	}
	
	public ActivityMigrationKeyXRefPK(Integer activityId, Integer migrationKeyId) {
		super();
		this.activityId = activityId;
		this.migrationKeyId = migrationKeyId;
	}



	public Integer getActivityId() {
		return this.activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public Integer getMigrationKeyId() {
		return this.migrationKeyId;
	}
	public void setMigrationKeyId(Integer migrationKeyId) {
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