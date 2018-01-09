package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the schema_version database table.
 * 
 */
@Entity
@Table(name="schema_version")
@NamedQuery(name="SchemaVersion.findAll", query="SELECT s FROM SchemaVersion s")
public class SchemaVersion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="installed_rank")
	private int installedRank;

	private int checksum;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	private String description;

	@Column(name="execution_time")
	private int executionTime;

	@Column(name="installed_by")
	private String installedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="installed_on")
	private Date installedOn;

	private String script;

	private byte success;

	private String type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	private String version;

	public SchemaVersion() {
	}

	public int getInstalledRank() {
		return this.installedRank;
	}

	public void setInstalledRank(int installedRank) {
		this.installedRank = installedRank;
	}

	public int getChecksum() {
		return this.checksum;
	}

	public void setChecksum(int checksum) {
		this.checksum = checksum;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExecutionTime() {
		return this.executionTime;
	}

	public void setExecutionTime(int executionTime) {
		this.executionTime = executionTime;
	}

	public String getInstalledBy() {
		return this.installedBy;
	}

	public void setInstalledBy(String installedBy) {
		this.installedBy = installedBy;
	}

	public Date getInstalledOn() {
		return this.installedOn;
	}

	public void setInstalledOn(Date installedOn) {
		this.installedOn = installedOn;
	}

	public String getScript() {
		return this.script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public byte getSuccess() {
		return this.success;
	}

	public void setSuccess(byte success) {
		this.success = success;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}