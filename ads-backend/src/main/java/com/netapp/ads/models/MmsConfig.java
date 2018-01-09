package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mms_config database table.
 * 
 */
@Entity
@Table(name="mms_config")
@NamedQuery(name="MmsConfig.findAll", query="SELECT m FROM MmsConfig m")
public class MmsConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="component_name")
	private String componentName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	private byte encrypted;

	@Column(name="environment_name")
	private String environmentName;

	@Temporal(TemporalType.DATE)
	private Date expiration;

	@Column(name="last_update_user")
	private String lastUpdateUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_ts")
	private Date lastUpdatedTs;

	@Column(name="property_name")
	private String propertyName;

	@Column(name="property_type_id")
	private int propertyTypeId;

	@Column(name="property_value")
	private String propertyValue;

	@Column(name="subcomponent_name")
	private String subcomponentName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public MmsConfig() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComponentName() {
		return this.componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public byte getEncrypted() {
		return this.encrypted;
	}

	public void setEncrypted(byte encrypted) {
		this.encrypted = encrypted;
	}

	public String getEnvironmentName() {
		return this.environmentName;
	}

	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}

	public Date getExpiration() {
		return this.expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getLastUpdateUser() {
		return this.lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Date getLastUpdatedTs() {
		return this.lastUpdatedTs;
	}

	public void setLastUpdatedTs(Date lastUpdatedTs) {
		this.lastUpdatedTs = lastUpdatedTs;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public int getPropertyTypeId() {
		return this.propertyTypeId;
	}

	public void setPropertyTypeId(int propertyTypeId) {
		this.propertyTypeId = propertyTypeId;
	}

	public String getPropertyValue() {
		return this.propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getSubcomponentName() {
		return this.subcomponentName;
	}

	public void setSubcomponentName(String subcomponentName) {
		this.subcomponentName = subcomponentName;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}