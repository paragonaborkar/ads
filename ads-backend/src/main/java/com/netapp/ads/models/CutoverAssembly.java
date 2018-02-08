package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cutover_assembly database table.
 * 
 */
@Entity
@Table(name="cutover_assembly")
public class CutoverAssembly implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="changed_mount")
	private boolean changedMount;

	@Column(name="completed_replication")
	private boolean completedReplication;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="cutover_complete")
	private boolean cutoverComplete;

	@Column(name="started_app")
	private boolean startedApp;

	@Column(name="started_database")
	private boolean startedDatabase;

	@Column(name="stopped_app")
	private boolean stoppedApp;

	@Column(name="stopped_db")
	private boolean stoppedDb;

	@Column(name="unmount_volume")
	private boolean unmountVolume;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="validated_database")
	private boolean validatedDatabase;

	@Column(name="validation_complete")
	private boolean validationComplete;

	//bi-directional many-to-one association to Cutover
	@ManyToOne
	@JoinColumn(name="cutover_id", nullable=false)
	private Cutover cutover;

	//bi-directional many-to-one association to CutoverMountPoint
	@ManyToOne
	@JoinColumn(name="cutover_mount_point_id")
	private CutoverMountPoint cutoverMountPoint;

	//bi-directional many-to-one association to MigrationCutoverEvent
	@ManyToOne
	@JoinColumn(name="migration_cutover_event_id")
	private MigrationCutoverEvent migrationCutoverEvent;

	//bi-directional many-to-one association to CutoverTime
	@OneToMany(mappedBy="cutoverAssembly")
	private List<CutoverTime> cutoverTimes;

	public CutoverAssembly() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean getChangedMount() {
		return this.changedMount;
	}

	public void setChangedMount(boolean changedMount) {
		this.changedMount = changedMount;
	}

	public boolean getCompletedReplication() {
		return this.completedReplication;
	}

	public void setCompletedReplication(boolean completedReplication) {
		this.completedReplication = completedReplication;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public boolean getCutoverComplete() {
		return this.cutoverComplete;
	}

	public void setCutoverComplete(boolean cutoverComplete) {
		this.cutoverComplete = cutoverComplete;
	}

	public boolean getStartedApp() {
		return this.startedApp;
	}

	public void setStartedApp(boolean startedApp) {
		this.startedApp = startedApp;
	}

	public boolean getStartedDatabase() {
		return this.startedDatabase;
	}

	public void setStartedDatabase(boolean startedDatabase) {
		this.startedDatabase = startedDatabase;
	}

	public boolean getStoppedApp() {
		return this.stoppedApp;
	}

	public void setStoppedApp(boolean stoppedApp) {
		this.stoppedApp = stoppedApp;
	}

	public boolean getStoppedDb() {
		return this.stoppedDb;
	}

	public void setStoppedDb(boolean stoppedDb) {
		this.stoppedDb = stoppedDb;
	}

	public boolean getUnmountVolume() {
		return this.unmountVolume;
	}

	public void setUnmountVolume(boolean unmountVolume) {
		this.unmountVolume = unmountVolume;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public boolean getValidatedDatabase() {
		return this.validatedDatabase;
	}

	public void setValidatedDatabase(boolean validatedDatabase) {
		this.validatedDatabase = validatedDatabase;
	}

	public boolean getValidationComplete() {
		return this.validationComplete;
	}

	public void setValidationComplete(boolean validationComplete) {
		this.validationComplete = validationComplete;
	}

	public Cutover getCutover() {
		return this.cutover;
	}

	public void setCutover(Cutover cutover) {
		this.cutover = cutover;
	}

	public CutoverMountPoint getCutoverMountPoint() {
		return this.cutoverMountPoint;
	}

	public void setCutoverMountPoint(CutoverMountPoint cutoverMountPoint) {
		this.cutoverMountPoint = cutoverMountPoint;
	}

	public MigrationCutoverEvent getMigrationCutoverEvent() {
		return this.migrationCutoverEvent;
	}

	public void setMigrationCutoverEvent(MigrationCutoverEvent migrationCutoverEvent) {
		this.migrationCutoverEvent = migrationCutoverEvent;
	}

	public List<CutoverTime> getCutoverTimes() {
		return this.cutoverTimes;
	}

	public void setCutoverTimes(List<CutoverTime> cutoverTimes) {
		this.cutoverTimes = cutoverTimes;
	}

	public CutoverTime addCutoverTime(CutoverTime cutoverTime) {
		getCutoverTimes().add(cutoverTime);
		cutoverTime.setCutoverAssembly(this);

		return cutoverTime;
	}

	public CutoverTime removeCutoverTime(CutoverTime cutoverTime) {
		getCutoverTimes().remove(cutoverTime);
		cutoverTime.setCutoverAssembly(null);

		return cutoverTime;
	}

}