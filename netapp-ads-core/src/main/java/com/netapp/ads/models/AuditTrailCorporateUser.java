package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the audit_trail_corporate_user database table.
 * 
 */
@Entity
@Table(name="audit_trail_corporate_user")
public class AuditTrailCorporateUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="audit_comment", length=1024)
	private String auditComment;

	@Column(name="audited_resource", length=255)
	private String auditedResource;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Lob
	@Column(name="old_values")
	private String oldValues;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	@Column(name="user_corporate_id", nullable=false)
	private Integer userCorporateId;

	//bi-directional many-to-one association to AuditEvent
	@ManyToOne
	@JoinColumn(name="audit_event_id", nullable=false)
	private AuditEvent auditEvent;

	public AuditTrailCorporateUser() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuditComment() {
		return this.auditComment;
	}

	public void setAuditComment(String auditComment) {
		this.auditComment = auditComment;
	}

	public String getAuditedResource() {
		return this.auditedResource;
	}

	public void setAuditedResource(String auditedResource) {
		this.auditedResource = auditedResource;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getOldValues() {
		return this.oldValues;
	}

	public void setOldValues(String oldValues) {
		this.oldValues = oldValues;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUserCorporateId() {
		return this.userCorporateId;
	}

	public void setUserCorporateId(Integer userCorporateId) {
		this.userCorporateId = userCorporateId;
	}

	public AuditEvent getAuditEvent() {
		return this.auditEvent;
	}

	public void setAuditEvent(AuditEvent auditEvent) {
		this.auditEvent = auditEvent;
	}

}