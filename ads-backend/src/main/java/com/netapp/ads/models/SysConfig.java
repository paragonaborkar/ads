package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sys_config database table.
 * 
 */
@Entity
@Table(name="sys_config")
public class SysConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(nullable=false)
	private boolean encrypted;

	@Column(name="property_name", nullable=false, length=255)
	private String propertyName;

	@Column(name="property_value", nullable=false, length=255)
	private String propertyValue;

	@Column(name="update_time")
	private Timestamp updateTime;

	//bi-directional many-to-one association to SysConfigPropertyType
	@ManyToOne
	@JoinColumn(name="property_type_id")
	private SysConfigPropertyType sysConfigPropertyType;

	public SysConfig() {
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

	public boolean getEncrypted() {
		return this.encrypted;
	}

	public void setEncrypted(boolean encrypted) {
		this.encrypted = encrypted;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyValue() {
		return this.propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public SysConfigPropertyType getSysConfigPropertyType() {
		return this.sysConfigPropertyType;
	}

	public void setSysConfigPropertyType(SysConfigPropertyType sysConfigPropertyType) {
		this.sysConfigPropertyType = sysConfigPropertyType;
	}

}