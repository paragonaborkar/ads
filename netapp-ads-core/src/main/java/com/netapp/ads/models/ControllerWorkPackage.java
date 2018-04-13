package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the controller_targets_available database table.
 * 
 */
@Entity
@Table(name="controller_work_package")
public class ControllerWorkPackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	//uni-directional one-to-one association to Controller
	@OneToOne
	@JoinColumn(name = "controller_id", unique=true)
	private Controller controller;

	@Column(name="asset_number", length=60)
	private String assetNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="controller_installed_date", nullable=false)
	private Date controllerInstalledDate;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	private Integer priority;

	private boolean processed;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	@Column(name="work_package_name", nullable=false, length=255)
	private String workPackageName;


	public ControllerWorkPackage() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public boolean getProcessed() {
		return this.processed;
	}

	public void setProcessed(boolean processed) {
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


	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	

}