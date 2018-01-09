package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the audit_reason_code database table.
 * 
 */
@Entity
@Table(name="audit_reason_code")
@NamedQuery(name="AuditReasonCode.findAll", query="SELECT a FROM AuditReasonCode a")
public class AuditReasonCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AuditReasonCodePK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	private String reason;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public AuditReasonCode() {
	}

	public AuditReasonCodePK getId() {
		return this.id;
	}

	public void setId(AuditReasonCodePK id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}