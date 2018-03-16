package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the activity database table.
 * 
 */
@Entity
@Table(name="activity")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="admin_override", nullable=false)
	private boolean adminOverride;

	@Column(name="app_name_list", length=1024)
	private String appNameList;

	@Column(name="archive_candidate", nullable=false)
	private boolean archiveCandidate;

	@Column(name="best_number", length=100)
	private String bestNumber;

	@Column(name="call_me", nullable=false)
	private boolean callMe;

	@Column(name="call_reason", length=2048)
	private String callReason;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Temporal(TemporalType.DATE)
	@Column(name="delete_date")
	private Date deleteDate;

	@Column(length=255)
	private String disposition;

	@Column(name="is_latest", nullable=false)
	private boolean isLatest;

	@Column(name="mail_count")
	private Integer mailCount;

	@Temporal(TemporalType.DATE)
	@Column(name="mailing_date")
	private Date mailingDate;

	@Column(name="migrate_day")
	private Integer migrateDay;

	@Temporal(TemporalType.DATE)
	@Column(name="migrate_week")
	private Date migrateWeek;

	@Column(length=1024)
	private String note;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	@Column(length=255)
	private String vserver;

	@Column(name="will_delete", nullable=false)
	private boolean willDelete;

	@Column(name="will_migrate", nullable=false)
	private boolean willMigrate;

	//bi-directional many-to-one association to MigrationTime
	@ManyToOne
	@JoinColumn(name="migration_time_id")
	private MigrationTime migrationTime;

	//bi-directional many-to-one association to Qtree
	@ManyToOne
	@JoinColumn(name="qtree_id")
	private Qtree qtree;

	//bi-directional many-to-one association to ActivityResponse
	@OneToMany(mappedBy="activity")
	private List<ActivityResponse> activityResponses;

	//bi-directional many-to-many association to LineOfBusiness
	@ManyToMany(mappedBy="activitiesLobXRef")
	private List<LineOfBusiness> lineOfBusinessesXRefActivities;

	//bi-directional many-to-many association to LineOfBusiness
	@ManyToMany(mappedBy="activitiesPresumedLobXRef")
	private List<LineOfBusiness> lineOfBusinessesXRefPresumedActivities;
	
	//bi-directional many-to-one association to ActivityMigrationKeyXRef
	@OneToMany(mappedBy="activity")
	private List<ActivityMigrationKeyXRef> activityMigrationKeyXRefs;
	
	@ManyToMany(fetch = FetchType.LAZY,
	        mappedBy = "activities")
	private List<MigrationKey> migrationKeys;

	public Activity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean getAdminOverride() {
		return this.adminOverride;
	}

	public void setAdminOverride(boolean adminOverride) {
		this.adminOverride = adminOverride;
	}

	public String getAppNameList() {
		return this.appNameList;
	}

	public void setAppNameList(String appNameList) {
		this.appNameList = appNameList;
	}

	public boolean getArchiveCandidate() {
		return this.archiveCandidate;
	}

	public void setArchiveCandidate(boolean archiveCandidate) {
		this.archiveCandidate = archiveCandidate;
	}

	public String getBestNumber() {
		return this.bestNumber;
	}

	public void setBestNumber(String bestNumber) {
		this.bestNumber = bestNumber;
	}

	public boolean getCallMe() {
		return this.callMe;
	}

	public void setCallMe(boolean callMe) {
		this.callMe = callMe;
	}

	public String getCallReason() {
		return this.callReason;
	}

	public void setCallReason(String callReason) {
		this.callReason = callReason;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Date getDeleteDate() {
		return this.deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getDisposition() {
		return this.disposition;
	}

	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}

	public boolean getIsLatest() {
		return this.isLatest;
	}

	public void setIsLatest(boolean isLatest) {
		this.isLatest = isLatest;
	}

	public Integer getMailCount() {
		return this.mailCount;
	}

	public void setMailCount(Integer mailCount) {
		this.mailCount = mailCount;
	}

	public Date getMailingDate() {
		return this.mailingDate;
	}

	public void setMailingDate(Date mailingDate) {
		this.mailingDate = mailingDate;
	}

	public Integer getMigrateDay() {
		return this.migrateDay;
	}

	public void setMigrateDay(Integer migrateDay) {
		this.migrateDay = migrateDay;
	}

	public Date getMigrateWeek() {
		return this.migrateWeek;
	}

	public void setMigrateWeek(Date migrateWeek) {
		this.migrateWeek = migrateWeek;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getVserver() {
		return this.vserver;
	}

	public void setVserver(String vserver) {
		this.vserver = vserver;
	}

	public boolean getWillDelete() {
		return this.willDelete;
	}

	public void setWillDelete(boolean willDelete) {
		this.willDelete = willDelete;
	}

	public boolean getWillMigrate() {
		return this.willMigrate;
	}

	public void setWillMigrate(boolean willMigrate) {
		this.willMigrate = willMigrate;
	}

	public MigrationTime getMigrationTime() {
		return this.migrationTime;
	}

	public void setMigrationTime(MigrationTime migrationTime) {
		this.migrationTime = migrationTime;
	}

	public Qtree getQtree() {
		return this.qtree;
	}

	public void setQtree(Qtree qtree) {
		this.qtree = qtree;
	}

	public List<ActivityResponse> getActivityResponses() {
		return this.activityResponses;
	}

	public void setActivityResponses(List<ActivityResponse> activityResponses) {
		this.activityResponses = activityResponses;
	}

	public ActivityResponse addActivityRespons(ActivityResponse activityRespons) {
		getActivityResponses().add(activityRespons);
		activityRespons.setActivity(this);

		return activityRespons;
	}

	public ActivityResponse removeActivityRespons(ActivityResponse activityRespons) {
		getActivityResponses().remove(activityRespons);
		activityRespons.setActivity(null);

		return activityRespons;
	}

	public List<LineOfBusiness> getLineOfBusinessesXRefActivities() {
		return this.lineOfBusinessesXRefActivities;
	}

	public void setLineOfBusinessesXRefActivities(List<LineOfBusiness> lineOfBusinessesXRefActivities) {
		this.lineOfBusinessesXRefActivities = lineOfBusinessesXRefActivities;
	}

	public List<LineOfBusiness> getLineOfBusinessesXRefPresumedActivities() {
		return this.lineOfBusinessesXRefPresumedActivities;
	}

	public void setLineOfBusinessesXRefPresumedActivities(List<LineOfBusiness> lineOfBusinessesXRefPresumedActivities) {
		this.lineOfBusinessesXRefPresumedActivities = lineOfBusinessesXRefPresumedActivities;
	}
	
	public List<MigrationKey> getMigrationKeys() {
		return this.migrationKeys;
	}

	public void setMigrationKeys(List<MigrationKey> migrationKeys) {
		this.migrationKeys = migrationKeys;
	}

	public MigrationKey addMigrationKey(MigrationKey migrationKey) {
		getMigrationKeys().add(migrationKey);
		migrationKey.addActivity(this);
		return migrationKey;
	}

	public MigrationKey removeMigrationKey(MigrationKey migrationKey) {
		getMigrationKeys().remove(migrationKey);
		migrationKey.removeActivity(this);
		return migrationKey;
	}



}