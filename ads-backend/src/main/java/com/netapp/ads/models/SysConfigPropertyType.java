package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the sys_config_property_type database table.
 * 
 */
@Entity
@Table(name="sys_config_property_type")
public class SysConfigPropertyType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="property_type", nullable=false, length=255)
	private String propertyType;

	@Column(name="update_time")
	private Timestamp updateTime;

	//bi-directional many-to-one association to SysConfig
	@OneToMany(mappedBy="sysConfigPropertyType")
	private List<SysConfig> sysConfigs;

	public SysConfigPropertyType() {
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

	public String getPropertyType() {
		return this.propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<SysConfig> getSysConfigs() {
		return this.sysConfigs;
	}

	public void setSysConfigs(List<SysConfig> sysConfigs) {
		this.sysConfigs = sysConfigs;
	}

	public SysConfig addSysConfig(SysConfig sysConfig) {
		getSysConfigs().add(sysConfig);
		sysConfig.setSysConfigPropertyType(this);

		return sysConfig;
	}

	public SysConfig removeSysConfig(SysConfig sysConfig) {
		getSysConfigs().remove(sysConfig);
		sysConfig.setSysConfigPropertyType(null);

		return sysConfig;
	}

}