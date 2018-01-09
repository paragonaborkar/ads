package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the wfa_ocum_controller_data database table.
 * 
 */
@Entity
@Table(name="wfa_ocum_controller_data")
@NamedQuery(name="WfaOcumControllerData.findAll", query="SELECT w FROM WfaOcumControllerData w")
public class WfaOcumControllerData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="controller_id")
	private int controllerId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="ocum_controller_name")
	private String ocumControllerName;

	@Column(name="ocum_controller_serial_number")
	private String ocumControllerSerialNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public WfaOcumControllerData() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getControllerId() {
		return this.controllerId;
	}

	public void setControllerId(int controllerId) {
		this.controllerId = controllerId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getOcumControllerName() {
		return this.ocumControllerName;
	}

	public void setOcumControllerName(String ocumControllerName) {
		this.ocumControllerName = ocumControllerName;
	}

	public String getOcumControllerSerialNumber() {
		return this.ocumControllerSerialNumber;
	}

	public void setOcumControllerSerialNumber(String ocumControllerSerialNumber) {
		this.ocumControllerSerialNumber = ocumControllerSerialNumber;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}