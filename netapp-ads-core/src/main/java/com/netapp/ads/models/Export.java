package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the exports database table.
 * 
 */
@Entity
@Table(name="exports")
public class Export implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="access_type", nullable=false, length=255)
	private String accessType;

	@Column(nullable=false, length=255)
	private String contact;

	@Column(name="controller_name", nullable=false, length=255)
	private String controllerName;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="impact_status", nullable=false, length=255)
	private String impactStatus;

	@Column(name="peregrine_queue", nullable=false, length=255)
	private String peregrineQueue;

	@Column(nullable=false, length=255)
	private String reason;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	@Column(name="user_corporate_id")
	private Integer userCorporateId;

	@Column(name="volume_path", nullable=false, length=255)
	private String volumePath;

	//bi-directional many-to-one association to Controller
	@OneToMany(mappedBy="export")
	private List<Controller> controllers;

	//bi-directional many-to-one association to LineOfBusiness
	@ManyToOne
	@JoinColumn(name="lob_id", nullable=false)
	private LineOfBusiness lineOfBusiness;

	//bi-directional many-to-one association to ExportsHostXRef
	@OneToMany(mappedBy="export")
	private List<ExportsHostXRef> exportsHostXRefs;

	//bi-directional many-to-many association to Host
	@ManyToMany(mappedBy="exports")
	private List<Host> hosts;

	public Export() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccessType() {
		return this.accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getControllerName() {
		return this.controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getImpactStatus() {
		return this.impactStatus;
	}

	public void setImpactStatus(String impactStatus) {
		this.impactStatus = impactStatus;
	}

	public String getPeregrineQueue() {
		return this.peregrineQueue;
	}

	public void setPeregrineQueue(String peregrineQueue) {
		this.peregrineQueue = peregrineQueue;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public String getVolumePath() {
		return this.volumePath;
	}

	public void setVolumePath(String volumePath) {
		this.volumePath = volumePath;
	}

	public List<Controller> getControllers() {
		return this.controllers;
	}

	public void setControllers(List<Controller> controllers) {
		this.controllers = controllers;
	}

	public Controller addController(Controller controller) {
		getControllers().add(controller);
		controller.setExport(this);

		return controller;
	}

	public Controller removeController(Controller controller) {
		getControllers().remove(controller);
		controller.setExport(null);

		return controller;
	}

	public LineOfBusiness getLineOfBusiness() {
		return this.lineOfBusiness;
	}

	public void setLineOfBusiness(LineOfBusiness lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}

	public List<ExportsHostXRef> getExportsHostXRefs() {
		return this.exportsHostXRefs;
	}

	public void setExportsHostXRefs(List<ExportsHostXRef> exportsHostXRefs) {
		this.exportsHostXRefs = exportsHostXRefs;
	}

	public ExportsHostXRef addExportsHostXRef(ExportsHostXRef exportsHostXRef) {
		getExportsHostXRefs().add(exportsHostXRef);
		exportsHostXRef.setExport(this);

		return exportsHostXRef;
	}

	public ExportsHostXRef removeExportsHostXRef(ExportsHostXRef exportsHostXRef) {
		getExportsHostXRefs().remove(exportsHostXRef);
		exportsHostXRef.setExport(null);

		return exportsHostXRef;
	}

	public List<Host> getHosts() {
		return this.hosts;
	}

	public void setHosts(List<Host> hosts) {
		this.hosts = hosts;
	}

}