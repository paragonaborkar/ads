package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the storage database table.
 * 
 */
@Entity
@Table(name="storage")
public class Storage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(length=255)
	private String family;

	@Column(length=255)
	private String manufacturer;

	@Column(name="microcode_version", length=255)
	private String microcodeVersion;

	@Column(length=255)
	private String model;

	@Column(name="raw_capacity_mb")
	private BigInteger rawCapacityMb;

	@Column(name="storage_name", nullable=false, length=255)
	private String storageName;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-one association to Controller
	@OneToMany(mappedBy="storage")
	private List<Controller> controllers;

	//bi-directional many-to-one association to Replication
	@OneToMany(mappedBy="targetVaultStorage")
	private List<Replication> targetVaultStorageReplications;

	//bi-directional many-to-one association to Replication
	@OneToMany(mappedBy="targetMirrorStorage")
	private List<Replication> targetMirrorStorageReplications;

	//bi-directional many-to-one association to WorkPackage
	@ManyToOne
	@JoinColumn(name="work_package_id", nullable=false)
	private WorkPackage workPackage;

	public Storage() {
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

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getMicrocodeVersion() {
		return this.microcodeVersion;
	}

	public void setMicrocodeVersion(String microcodeVersion) {
		this.microcodeVersion = microcodeVersion;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigInteger getRawCapacityMb() {
		return this.rawCapacityMb;
	}

	public void setRawCapacityMb(BigInteger rawCapacityMb) {
		this.rawCapacityMb = rawCapacityMb;
	}

	public String getStorageName() {
		return this.storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<Controller> getControllers() {
		return this.controllers;
	}

	public void setControllers(List<Controller> controllers) {
		this.controllers = controllers;
	}

	public Controller addController(Controller controller) {
		getControllers().add(controller);
		controller.setStorage(this);

		return controller;
	}

	public Controller removeController(Controller controller) {
		getControllers().remove(controller);
		controller.setStorage(null);

		return controller;
	}

	public List<Replication> getTargetVaultStorageReplications() {
		return this.targetVaultStorageReplications;
	}

	public void setTargetVaultStorageReplications(List<Replication> replications) {
		this.targetVaultStorageReplications = replications;
	}

	public Replication addTargetVaultStorageReplication(Replication replication) {
		getTargetVaultStorageReplications().add(replication);
		replication.setTargetVaultStorage(this);

		return replication;
	}

	public Replication removeTargetVaultStorageReplication(Replication replication) {
		getTargetVaultStorageReplications().remove(replication);
		replication.setTargetVaultStorage(null);

		return replication;
	}

	public List<Replication> getTargetMirrorStorageReplications() {
		return this.targetMirrorStorageReplications;
	}

	public void setTargetMirrorStorageReplications(List<Replication> replications) {
		this.targetMirrorStorageReplications = replications;
	}

	public Replication addTargetMirrorStorageReplication(Replication replication) {
		getTargetMirrorStorageReplications().add(replication);
		replication.setTargetMirrorStorage(this);

		return replication;
	}

	public Replication removeTargetMirrorStorageReplication(Replication replication) {
		getTargetMirrorStorageReplications().remove(replication);
		replication.setTargetMirrorStorage(null);

		return replication;
	}

	public WorkPackage getWorkPackage() {
		return this.workPackage;
	}

	public void setWorkPackage(WorkPackage workPackage) {
		this.workPackage = workPackage;
	}

}