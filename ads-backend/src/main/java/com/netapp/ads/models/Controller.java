package com.netapp.ads.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the controller database table.
 * 
 */
@Entity
@NamedQuery(name="Controller.findAll", query="SELECT c FROM Controller c")
public class Controller implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ControllerPK id;

	@Column(name="controller_name")
	private String controllerName;

	@Column(name="create_time")
	private Timestamp createTime;

	@Temporal(TemporalType.DATE)
	@Column(name="date_available")
	private Date dateAvailable;

	@Column(name="exports_id")
	private int exportsId;

	@Column(name="serial_number")
	private String serialNumber;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="volume_tally")
	private int volumeTally;

	//bi-directional many-to-one association to DataCenter
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="data_center_id", insertable = false, updatable = false)
	private DataCenter dataCenter;

	//bi-directional many-to-one association to Storage
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="storage_id", insertable = false, updatable = false)
	private Storage storage;

	public Controller() {
	}

	public ControllerPK getId() {
		return this.id;
	}

	public void setId(ControllerPK id) {
		this.id = id;
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

	public Date getDateAvailable() {
		return this.dateAvailable;
	}

	public void setDateAvailable(Date dateAvailable) {
		this.dateAvailable = dateAvailable;
	}

	public int getExportsId() {
		return this.exportsId;
	}

	public void setExportsId(int exportsId) {
		this.exportsId = exportsId;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public int getVolumeTally() {
		return this.volumeTally;
	}

	public void setVolumeTally(int volumeTally) {
		this.volumeTally = volumeTally;
	}

	public DataCenter getDataCenter() {
		return this.dataCenter;
	}

	public void setDataCenter(DataCenter dataCenter) {
		this.dataCenter = dataCenter;
	}

	public Storage getStorage() {
		return this.storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Controller controller = (Controller) obj;
		return this.controllerName.equalsIgnoreCase(controller.controllerName);
	}

}