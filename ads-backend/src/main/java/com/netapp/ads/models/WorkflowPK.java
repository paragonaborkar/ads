package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the workflow database table.
 * 
 */
@Embeddable
public class WorkflowPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="migration_cutover_src_to_tgt_id", insertable=false, updatable=false)
	private int migrationCutoverSrcToTgtId;

	@Column(name="migration_cutover_src_to_tgt_migration_cutover_event_id", insertable=false, updatable=false)
	private int migrationCutoverSrcToTgtMigrationCutoverEventId;

	public WorkflowPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMigrationCutoverSrcToTgtId() {
		return this.migrationCutoverSrcToTgtId;
	}
	public void setMigrationCutoverSrcToTgtId(int migrationCutoverSrcToTgtId) {
		this.migrationCutoverSrcToTgtId = migrationCutoverSrcToTgtId;
	}
	public int getMigrationCutoverSrcToTgtMigrationCutoverEventId() {
		return this.migrationCutoverSrcToTgtMigrationCutoverEventId;
	}
	public void setMigrationCutoverSrcToTgtMigrationCutoverEventId(int migrationCutoverSrcToTgtMigrationCutoverEventId) {
		this.migrationCutoverSrcToTgtMigrationCutoverEventId = migrationCutoverSrcToTgtMigrationCutoverEventId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof WorkflowPK)) {
			return false;
		}
		WorkflowPK castOther = (WorkflowPK)other;
		return 
			(this.id == castOther.id)
			&& (this.migrationCutoverSrcToTgtId == castOther.migrationCutoverSrcToTgtId)
			&& (this.migrationCutoverSrcToTgtMigrationCutoverEventId == castOther.migrationCutoverSrcToTgtMigrationCutoverEventId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.migrationCutoverSrcToTgtId;
		hash = hash * prime + this.migrationCutoverSrcToTgtMigrationCutoverEventId;
		
		return hash;
	}
}