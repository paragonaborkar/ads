package com.netapp.ads.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the data_center database table.
 * 
 */
@Entity
@Table(name="data_center")
@NamedQuery(name="DataCenter.findAll", query="SELECT d FROM DataCenter d")
public class DataCenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String city;

	private String country;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="data_center_full_name")
	private String dataCenterFullName;

	@Column(name="data_center_name")
	private String dataCenterName;

	@Column(name="data_geo_location")
	private String dataGeoLocation;

	private String region;

	@Column(name="update_time")
	private Timestamp updateTime;

	//bi-directional many-to-one association to Controller
	@JsonBackReference
	@OneToMany(mappedBy="dataCenter", fetch = FetchType.EAGER)
	private List<Controller> controllers;

	public DataCenter() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

}