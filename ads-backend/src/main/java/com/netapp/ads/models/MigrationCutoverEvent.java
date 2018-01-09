package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the migration_cutover_event database table.
 * 
 */
@Entity
@Table(name="migration_cutover_event")
@NamedQuery(name="MigrationCutoverEvent.findAll", query="SELECT m FROM MigrationCutoverEvent m")
public class MigrationCutoverEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="app_owner_user_corporate_id")
	private int appOwnerUserCorporateId;

	@Column(name="application_id")
	private int applicationId;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="high_over_write")
	private byte highOverWrite;

	@Column(name="lob_id")
	private int lobId;

	@Column(name="migrate_day")
	private int migrateDay;

	@Column(name="migrate_time")
	private String migrateTime;

	@Temporal(TemporalType.DATE)
	@Column(name="migrate_week")
	private Date migrateWeek;

	@Column(name="migration_approved")
	private byte migrationApproved;

	@Column(name="update_time")
	private Timestamp updateTime;

	//bi-directional many-to-one association to ChangeManagement
	@OneToMany(mappedBy="migrationCutoverEvent")
	private List<ChangeManagement> changeManagements;

	//bi-directional many-to-one association to CutoverMountPoint
	@OneToMany(mappedBy="migrationCutoverEvent")
	private List<CutoverMountPoint> cutoverMountPoints;

	//bi-directional many-to-one association to Ical
	@OneToMany(mappedBy="migrationCutoverEvent")
	private List<Ical> icals;

	//bi-directional many-to-one association to MigrationCutoverSrcToTgt
	@OneToMany(mappedBy="migrationCutoverEvent")
	private List<MigrationCutoverSrcToTgt> migrationCutoverSrcToTgts;

	public MigrationCutoverEvent() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAppOwnerUserCorporateId() {
		return this.appOwnerUserCorporateId;
	}

	public void setAppOwnerUserCorporateId(int appOwnerUserCorporateId) {
		this.appOwnerUserCorporateId = appOwnerUserCorporateId;
	}

	public int getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public byte getHighOverWrite() {
		return this.highOverWrite;
	}

	public void setHighOverWrite(byte highOverWrite) {
		this.highOverWrite = highOverWrite;
	}

	public int getLobId() {
		return this.lobId;
	}

	public void setLobId(int lobId) {
		this.lobId = lobId;
	}

	public int getMigrateDay() {
		return this.migrateDay;
	}

	public void setMigrateDay(int migrateDay) {
		this.migrateDay = migrateDay;
	}

	public String getMigrateTime() {
		return this.migrateTime;
	}

	public void setMigrateTime(String migrateTime) {
		this.migrateTime = migrateTime;
	}

	public Date getMigrateWeek() {
		return this.migrateWeek;
	}

	public void setMigrateWeek(Date migrateWeek) {
		this.migrateWeek = migrateWeek;
	}

	public byte getMigrationApproved() {
		return this.migrationApproved;
	}

	public void setMigrationApproved(byte migrationApproved) {
		this.migrationApproved = migrationApproved;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<ChangeManagement> getChangeManagements() {
		return this.changeManagements;
	}

	public void setChangeManagements(List<ChangeManagement> changeManagements) {
		this.changeManagements = changeManagements;
	}

	public ChangeManagement addChangeManagement(ChangeManagement changeManagement) {
		getChangeManagements().add(changeManagement);
		changeManagement.setMigrationCutoverEvent(this);

		return changeManagement;
	}

	public ChangeManagement removeChangeManagement(ChangeManagement changeManagement) {
		getChangeManagements().remove(changeManagement);
		changeManagement.setMigrationCutoverEvent(null);

		return changeManagement;
	}

	public List<CutoverMountPoint> getCutoverMountPoints() {
		return this.cutoverMountPoints;
	}

	public void setCutoverMountPoints(List<CutoverMountPoint> cutoverMountPoints) {
		this.cutoverMountPoints = cutoverMountPoints;
	}

	public CutoverMountPoint addCutoverMountPoint(CutoverMountPoint cutoverMountPoint) {
		getCutoverMountPoints().add(cutoverMountPoint);
		cutoverMountPoint.setMigrationCutoverEvent(this);

		return cutoverMountPoint;
	}

	public CutoverMountPoint removeCutoverMountPoint(CutoverMountPoint cutoverMountPoint) {
		getCutoverMountPoints().remove(cutoverMountPoint);
		cutoverMountPoint.setMigrationCutoverEvent(null);

		return cutoverMountPoint;
	}

	public List<Ical> getIcals() {
		return this.icals;
	}

	public void setIcals(List<Ical> icals) {
		this.icals = icals;
	}

	public Ical addIcal(Ical ical) {
		getIcals().add(ical);
		ical.setMigrationCutoverEvent(this);

		return ical;
	}

	public Ical removeIcal(Ical ical) {
		getIcals().remove(ical);
		ical.setMigrationCutoverEvent(null);

		return ical;
	}

	public List<MigrationCutoverSrcToTgt> getMigrationCutoverSrcToTgts() {
		return this.migrationCutoverSrcToTgts;
	}

	public void setMigrationCutoverSrcToTgts(List<MigrationCutoverSrcToTgt> migrationCutoverSrcToTgts) {
		this.migrationCutoverSrcToTgts = migrationCutoverSrcToTgts;
	}

	public MigrationCutoverSrcToTgt addMigrationCutoverSrcToTgt(MigrationCutoverSrcToTgt migrationCutoverSrcToTgt) {
		getMigrationCutoverSrcToTgts().add(migrationCutoverSrcToTgt);
		migrationCutoverSrcToTgt.setMigrationCutoverEvent(this);

		return migrationCutoverSrcToTgt;
	}

	public MigrationCutoverSrcToTgt removeMigrationCutoverSrcToTgt(MigrationCutoverSrcToTgt migrationCutoverSrcToTgt) {
		getMigrationCutoverSrcToTgts().remove(migrationCutoverSrcToTgt);
		migrationCutoverSrcToTgt.setMigrationCutoverEvent(null);

		return migrationCutoverSrcToTgt;
	}

}