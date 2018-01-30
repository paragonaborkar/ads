package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the wfa_ocum_controller_data database table.
 * 
 */
@Entity
@Table(name="wfa_ocum_controller_data")
public class WfaOcumControllerData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="ocum_controller_name", nullable=false, length=225)
	private String ocumControllerName;

	@Column(name="ocum_controller_serial_number", nullable=false, length=225)
	private String ocumControllerSerialNumber;

	@Column(name="update_time")
	private Timestamp updateTime;

	//bi-directional many-to-one association to Controller
	@ManyToOne
	@JoinColumn(name="controller_id", nullable=false)
	private Controller controller;

	public WfaOcumControllerData() {
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

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Controller getController() {
		return this.controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

}