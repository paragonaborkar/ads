package com.netapp.ads.pojo;

import java.sql.Timestamp;

public class SystemProperty {

	private Integer id;
	private Timestamp createTime;

	private boolean encrypted;

	private String propertyName;

	private String propertyValue;

	private Timestamp updateTime;

	private String grouping;

	private String sysConfigPropertyType;

	public SystemProperty(Integer id, Timestamp createTime, boolean encrypted, String propertyName,
			String propertyValue, Timestamp updateTime, String grouping, String sysConfigPropertyType) {
		super();
		this.id = id;
		this.createTime = createTime;
		this.encrypted = encrypted;
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
		this.updateTime = updateTime;
		this.grouping = grouping;
		this.sysConfigPropertyType = sysConfigPropertyType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public boolean isEncrypted() {
		return encrypted;
	}

	public void setEncrypted(boolean encrypted) {
		this.encrypted = encrypted;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getGrouping() {
		return grouping;
	}

	public void setGrouping(String grouping) {
		this.grouping = grouping;
	}

	public String getSysConfigPropertyType() {
		return sysConfigPropertyType;
	}

	public void setSysConfigPropertyType(String sysConfigPropertyType) {
		this.sysConfigPropertyType = sysConfigPropertyType;
	}
	
}
