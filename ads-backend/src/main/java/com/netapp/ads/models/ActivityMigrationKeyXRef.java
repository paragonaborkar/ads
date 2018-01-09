package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the activity_migration_key_x_ref database table.
 * 
 */
@Entity
@Table(name="activity_migration_key_x_ref")
@NamedQuery(name="ActivityMigrationKeyXRef.findAll", query="SELECT a FROM ActivityMigrationKeyXRef a")
public class ActivityMigrationKeyXRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ActivityMigrationKeyXRefPK id;

	public ActivityMigrationKeyXRef() {
	}

	public ActivityMigrationKeyXRefPK getId() {
		return this.id;
	}

	public void setId(ActivityMigrationKeyXRefPK id) {
		this.id = id;
	}

}