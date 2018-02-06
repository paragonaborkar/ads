package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the migration_key database table.
 * 
 */
@Entity
@Table(name="migration_key")
public class MigrationKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="migration_key", nullable=false, length=100)
	private String migrationKey;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	@Column(name="user_corporate_id", nullable=false)
	private Integer userCorporateId;

	//bi-directional many-to-one association to ActivityMigrationKeyXRef
	@OneToMany(mappedBy="migrationKey")
	private List<ActivityMigrationKeyXRef> activityMigrationKeyXRefs;

	public MigrationKey() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getMigrationKey() {
		return this.migrationKey;
	}

	public void setMigrationKey(String migrationKey) {
		this.migrationKey = migrationKey;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUserCorporateId() {
		return this.userCorporateId;
	}

	public void setUserCorporateId(Integer userCorporateId) {
		this.userCorporateId = userCorporateId;
	}

	public List<ActivityMigrationKeyXRef> getActivityMigrationKeyXRefs() {
		return this.activityMigrationKeyXRefs;
	}

	public void setActivityMigrationKeyXRefs(List<ActivityMigrationKeyXRef> activityMigrationKeyXRefs) {
		this.activityMigrationKeyXRefs = activityMigrationKeyXRefs;
	}

	public ActivityMigrationKeyXRef addActivityMigrationKeyXRef(ActivityMigrationKeyXRef activityMigrationKeyXRef) {
		getActivityMigrationKeyXRefs().add(activityMigrationKeyXRef);
		activityMigrationKeyXRef.setMigrationKey(this);

		return activityMigrationKeyXRef;
	}

	public ActivityMigrationKeyXRef removeActivityMigrationKeyXRef(ActivityMigrationKeyXRef activityMigrationKeyXRef) {
		getActivityMigrationKeyXRefs().remove(activityMigrationKeyXRef);
		activityMigrationKeyXRef.setMigrationKey(null);

		return activityMigrationKeyXRef;
	}

}