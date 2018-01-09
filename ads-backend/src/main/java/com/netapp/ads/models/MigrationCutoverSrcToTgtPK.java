package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the migration_cutover_src_to_tgt database table.
 * 
 */
@Embeddable
public class MigrationCutoverSrcToTgtPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int id;

	@Column(name="migration_cutover_event_id", insertable=false, updatable=false)
	private int migrationCutoverEventId;

	public MigrationCutoverSrcToTgtPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMigrationCutoverEventId() {
		return this.migrationCutoverEventId;
	}
	public void setMigrationCutoverEventId(int migrationCutoverEventId) {
		this.migrationCutoverEventId = migrationCutoverEventId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MigrationCutoverSrcToTgtPK)) {
			return false;
		}
		MigrationCutoverSrcToTgtPK castOther = (MigrationCutoverSrcToTgtPK)other;
		return 
			(this.id == castOther.id)
			&& (this.migrationCutoverEventId == castOther.migrationCutoverEventId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.migrationCutoverEventId;
		
		return hash;
	}
}