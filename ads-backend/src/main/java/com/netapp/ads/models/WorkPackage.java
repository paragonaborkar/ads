package com.netapp.ads.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the work_package database table.
 * 
 */
@Entity
@Table(name="work_package")
@NamedQuery(name="WorkPackage.findAll", query="SELECT w FROM WorkPackage w")
public class WorkPackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="asset_number")
	private String assetNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="controller_installed_date")
	private Date controllerInstalledDate;

	@Column(name="create_time")
	private Timestamp createTime;

	private int priority;

	private byte processed;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="work_package_name")
	private String workPackageName;

	//bi-directional many-to-one association to Storage
	@JsonBackReference
	@OneToMany(mappedBy="workPackage")
	private List<Storage> storages;

	public WorkPackage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssetNumber() {
		return this.assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public Date getControllerInstalledDate() {
		return this.controllerInstalledDate;
	}

	public void setControllerInstalledDate(Date controllerInstalledDate) {
		this.controllerInstalledDate = controllerInstalledDate;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public byte getProcessed() {
		return this.processed;
	}

	public void setProcessed(byte processed) {
		this.processed = processed;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getWorkPackageName() {
		return this.workPackageName;
	}

	public void setWorkPackageName(String workPackageName) {
		this.workPackageName = workPackageName;
	}

	public List<Storage> getStorages() {
		return this.storages;
	}

	public void setStorages(List<Storage> storages) {
		this.storages = storages;
	}

	public Storage addStorage(Storage storage) {
		getStorages().add(storage);
		storage.setWorkPackage(this);

		return storage;
	}

	public Storage removeStorage(Storage storage) {
		getStorages().remove(storage);
		storage.setWorkPackage(null);

		return storage;
	}

}