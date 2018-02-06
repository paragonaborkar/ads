package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the activity_migration_key_x_ref database table.
 * 
 */
@Entity
@Table(name="activity_migration_key_x_ref")
public class ActivityMigrationKeyXRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ActivityMigrationKeyXRefPK id;

	//bi-directional many-to-one association to MigrationKey
	@ManyToOne
	@JoinColumn(name="migration_key_id", nullable=false, insertable=false, updatable=false)
	private MigrationKey migrationKey;

	public ActivityMigrationKeyXRef() {
	}

	public ActivityMigrationKeyXRefPK getId() {
		return this.id;
	}

	public void setId(ActivityMigrationKeyXRefPK id) {
		this.id = id;
	}

	public MigrationKey getMigrationKey() {
		return this.migrationKey;
	}

	public void setMigrationKey(MigrationKey migrationKey) {
		this.migrationKey = migrationKey;
	}

}