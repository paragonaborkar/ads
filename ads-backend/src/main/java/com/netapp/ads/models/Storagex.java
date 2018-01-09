package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the storagex database table.
 * 
 */
@Entity
@NamedQuery(name="Storagex.findAll", query="SELECT s FROM Storagex s")
public class Storagex implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StoragexPK id;

	private byte completed;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	private String description;

	@Column(name="policy_name")
	private String policyName;

	@Column(name="source_path")
	private String sourcePath;

	private byte submitted;

	@Column(name="target_path")
	private String targetPath;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public Storagex() {
	}

	public StoragexPK getId() {
		return this.id;
	}

	public void setId(StoragexPK id) {
		this.id = id;
	}

	public byte getCompleted() {
		return this.completed;
	}

	public void setCompleted(byte completed) {
		this.completed = completed;
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

	public String getPolicyName() {
		return this.policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getSourcePath() {
		return this.sourcePath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	public byte getSubmitted() {
		return this.submitted;
	}

	public void setSubmitted(byte submitted) {
		this.submitted = submitted;
	}

	public String getTargetPath() {
		return this.targetPath;
	}

	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}