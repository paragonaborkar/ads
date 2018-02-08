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
public class MigrationCutoverEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="app_owner_user_corporate_id")
	private Integer appOwnerUserCorporateId;

	@Column(name="application_id", nullable=false)
	private Integer applicationId;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="high_over_write")
	private boolean highOverWrite;

	@Column(name="lob_id")
	private Integer lobId;

	@Column(name="migrate_day", nullable=false)
	private Integer migrateDay;

	@Column(name="migrate_time", nullable=false, length=60)
	private String migrateTime;

	@Temporal(TemporalType.DATE)
	@Column(name="migrate_week", nullable=false)
	private Date migrateWeek;

	@Column(name="migration_approved")
	private boolean migrationApproved;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-one association to ChangeManagement
	@OneToMany(mappedBy="migrationCutoverEvent")
	private List<ChangeManagement> changeManagements;

	//bi-directional many-to-one association to CutoverAssembly
	@OneToMany(mappedBy="migrationCutoverEvent")
	private List<CutoverAssembly> cutoverAssemblies;

	//bi-directional many-to-one association to CutoverMountPoint
	@OneToMany(mappedBy="migrationCutoverEvent")
	private List<CutoverMountPoint> cutoverMountPoints;

	//bi-directional many-to-one association to Ical
	@OneToMany(mappedBy="migrationCutoverEvent")
	private List<Ical> icals;

	//bi-directional many-to-one association to MigrationCutoverSrcToTgt
	@OneToMany(mappedBy="migrationCutoverEvent")
	private List<MigrationCutoverSrcToTgt> migrationCutoverSrcToTgts;

	//bi-directional many-to-one association to Storagex
	@OneToMany(mappedBy="migrationCutoverEvent")
	private List<Storagex> storagexs;

	public MigrationCutoverEvent() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAppOwnerUserCorporateId() {
		return this.appOwnerUserCorporateId;
	}

	public void setAppOwnerUserCorporateId(Integer appOwnerUserCorporateId) {
		this.appOwnerUserCorporateId = appOwnerUserCorporateId;
	}

	public Integer getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public boolean getHighOverWrite() {
		return this.highOverWrite;
	}

	public void setHighOverWrite(boolean highOverWrite) {
		this.highOverWrite = highOverWrite;
	}

	public Integer getLobId() {
		return this.lobId;
	}

	public void setLobId(Integer lobId) {
		this.lobId = lobId;
	}

	public Integer getMigrateDay() {
		return this.migrateDay;
	}

	public void setMigrateDay(Integer migrateDay) {
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

	public boolean getMigrationApproved() {
		return this.migrationApproved;
	}

	public void setMigrationApproved(boolean migrationApproved) {
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

	public List<CutoverAssembly> getCutoverAssemblies() {
		return this.cutoverAssemblies;
	}

	public void setCutoverAssemblies(List<CutoverAssembly> cutoverAssemblies) {
		this.cutoverAssemblies = cutoverAssemblies;
	}

	public CutoverAssembly addCutoverAssembly(CutoverAssembly cutoverAssembly) {
		getCutoverAssemblies().add(cutoverAssembly);
		cutoverAssembly.setMigrationCutoverEvent(this);

		return cutoverAssembly;
	}

	public CutoverAssembly removeCutoverAssembly(CutoverAssembly cutoverAssembly) {
		getCutoverAssemblies().remove(cutoverAssembly);
		cutoverAssembly.setMigrationCutoverEvent(null);

		return cutoverAssembly;
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

	public List<Storagex> getStoragexs() {
		return this.storagexs;
	}

	public void setStoragexs(List<Storagex> storagexs) {
		this.storagexs = storagexs;
	}

	public Storagex addStoragex(Storagex storagex) {
		getStoragexs().add(storagex);
		storagex.setMigrationCutoverEvent(this);

		return storagex;
	}

	public Storagex removeStoragex(Storagex storagex) {
		getStoragexs().remove(storagex);
		storagex.setMigrationCutoverEvent(null);

		return storagex;
	}

}