package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
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
	private List<ActivityMigrationKeyXRef> activityMigrationKeyXRefs = new ArrayList<ActivityMigrationKeyXRef>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "activity_migration_key_x_ref",
	        joinColumns = {
	                @JoinColumn(name = "migration_key_id",
	                        nullable = false,
	                        updatable = false) },
	        inverseJoinColumns = {
	                @JoinColumn(name = "activity_id",
	                        nullable = false,
	                        updatable = false) }
	        )
	private List<Activity> activities = new ArrayList<Activity>();
	
	private Integer runNo;

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

	/**
	 * @return the activities
	 */
	public List<Activity> getActivities() {
		return activities;
	}

	/**
	 * @param activities the activities to set
	 */
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
	public Activity addActivity(Activity activity) {
		getActivities().add(activity);
		//activity.addMigrationKey(this);
		return activity;
	}

	public Activity removeActivity(Activity activity) {
		getActivities().remove(activity);
		//activity.removeMigrationKey(this);
		return activity;
	}

	/**
	 * @return the runNo
	 */
	public Integer getRunNo() {
		return runNo;
	}

	/**
	 * @param runNo the runNo to set
	 */
	public void setRunNo(Integer runNo) {
		this.runNo = runNo;
	}
	
}