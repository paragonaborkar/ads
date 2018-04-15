package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the data_center database table.
 * 
 */
@Entity
@Table(name="data_center")
public class DataCenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=255)
	private String city;

	@Column(length=255)
	private String country;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="data_center_full_name", length=1024)
	private String dataCenterFullName;

	@Column(name="data_center_name", nullable=false, length=24)
	private String dataCenterName;

	@Column(name="data_geo_location")
	private String dataGeoLocation;

	@Column(nullable=false, length=60)
	private String region;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-one association to Controller
	@OneToMany(mappedBy="dataCenter")
	private List<Controller> controllers;

	//bi-directional many-to-one association to Replication
	@OneToMany(mappedBy="targetVaultDataCenter")
	private List<Replication> targetVaultDataCenterReplications;

	//bi-directional many-to-one association to Replication
	@OneToMany(mappedBy="targetMirroDataCenter")
	private List<Replication> targetMirroDataCenterReplications;

	public DataCenter() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getDataCenterFullName() {
		return this.dataCenterFullName;
	}

	public void setDataCenterFullName(String dataCenterFullName) {
		this.dataCenterFullName = dataCenterFullName;
	}

	public String getDataCenterName() {
		return this.dataCenterName;
	}

	public void setDataCenterName(String dataCenterName) {
		this.dataCenterName = dataCenterName;
	}

	public String getDataGeoLocation() {
		return this.dataGeoLocation;
	}

	public void setDataGeoLocation(String dataGeoLocation) {
		this.dataGeoLocation = dataGeoLocation;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
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
		controller.setDataCenter(this);

		return controller;
	}

	public Controller removeController(Controller controller) {
		getControllers().remove(controller);
		controller.setDataCenter(null);

		return controller;
	}

	public List<Replication> getTargetVaultDataCenterReplications() {
		return this.targetVaultDataCenterReplications;
	}

	public void setTargetVaultDataCenterReplications(List<Replication> targetVaultDataCenterReplications) {
		this.targetVaultDataCenterReplications = targetVaultDataCenterReplications;
	}

	public Replication addTargetVaultDataCenterReplication(Replication replication) {
		getTargetVaultDataCenterReplications().add(replication);
		replication.setTargetVaultDataCenter(this);

		return replication;
	}

	public Replication removeTargetVaultDataCenterReplication(Replication replication) {
		getTargetVaultDataCenterReplications().remove(replication);
		replication.setTargetVaultDataCenter(null);

		return replication;
	}

	public List<Replication> getTargetMirroDataCenterReplications() {
		return this.targetMirroDataCenterReplications;
	}

	public void setTargetMirroDataCenterReplications(List<Replication> replications) {
		this.targetMirroDataCenterReplications = replications;
	}

	public Replication addReplications2(Replication replication) {
		getTargetMirroDataCenterReplications().add(replication);
		replication.setTargetMirrorDataCenter(this);

		return replication;
	}

	public Replication removeReplications2(Replication replication) {
		getTargetMirroDataCenterReplications().remove(replication);
		replication.setTargetMirrorDataCenter(null);

		return replication;
	}

}