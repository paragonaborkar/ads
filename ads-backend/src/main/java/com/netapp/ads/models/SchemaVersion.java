package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the schema_version database table.
 * 
 */
@Entity
@Table(name="schema_version")
public class SchemaVersion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="installed_rank", unique=true, nullable=false)
	private Integer installedRank;

	private Integer checksum;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="execution_time", nullable=false)
	private Integer executionTime;

	@Column(name="installed_by", nullable=false, length=100)
	private String installedBy;

	@Column(name="installed_on", nullable=false)
	private Timestamp installedOn;

	@Column(nullable=false, length=1000)
	private String script;

	@Column(nullable=false)
	private boolean success;

	@Column(nullable=false, length=20)
	private String type;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(length=50)
	private String version;

	public SchemaVersion() {
	}

	public Integer getInstalledRank() {
		return this.installedRank;
	}

	public void setInstalledRank(Integer installedRank) {
		this.installedRank = installedRank;
	}

	public Integer getChecksum() {
		return this.checksum;
	}

	public void setChecksum(Integer checksum) {
		this.checksum = checksum;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getExecutionTime() {
		return this.executionTime;
	}

	public void setExecutionTime(Integer executionTime) {
		this.executionTime = executionTime;
	}

	public String getInstalledBy() {
		return this.installedBy;
	}

	public void setInstalledBy(String installedBy) {
		this.installedBy = installedBy;
	}

	public Timestamp getInstalledOn() {
		return this.installedOn;
	}

	public void setInstalledOn(Timestamp installedOn) {
		this.installedOn = installedOn;
	}

	public String getScript() {
		return this.script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public boolean getSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}