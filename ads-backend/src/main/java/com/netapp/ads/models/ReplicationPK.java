package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the replication database table.
 * 
 */
@Embeddable
public class ReplicationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="migration_cutover_src_to_tgt_id")
	private int migrationCutoverSrcToTgtId;

	public ReplicationPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReplicationPK)) {
			return false;
		}
		ReplicationPK castOther = (ReplicationPK)other;
		return 
			(this.id == castOther.id)
			&& (this.migrationCutoverSrcToTgtId == castOther.migrationCutoverSrcToTgtId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.migrationCutoverSrcToTgtId;
		
		return hash;
	}
}