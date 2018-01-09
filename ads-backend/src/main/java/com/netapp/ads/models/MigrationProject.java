package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the migration_project database table.
 * 
 */
@Entity
@Table(name="migration_project")
@NamedQuery(name="MigrationProject.findAll", query="SELECT m FROM MigrationProject m")
public class MigrationProject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Column(name="migration_project_name")
	private String migrationProjectName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	public MigrationProject() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getMigrationProjectName() {
		return this.migrationProjectName;
	}

	public void setMigrationProjectName(String migrationProjectName) {
		this.migrationProjectName = migrationProjectName;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}