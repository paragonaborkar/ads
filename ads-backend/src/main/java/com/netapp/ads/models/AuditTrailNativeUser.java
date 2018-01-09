package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the audit_trail_native_user database table.
 * 
 */
@Entity
@Table(name="audit_trail_native_user")
@NamedQuery(name="AuditTrailNativeUser.findAll", query="SELECT a FROM AuditTrailNativeUser a")
public class AuditTrailNativeUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AuditTrailNativeUserPK id;

	@Column(name="audit_comment")
	private String auditComment;

	@Column(name="audited_resource")
	private String auditedResource;

	@Column(name="create_time")
	private Timestamp createTime;

	@Lob
	@Column(name="old_values")
	private String oldValues;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="user_native_id")
	private int userNativeId;

	//bi-directional many-to-one association to AuditEvent
	@ManyToOne
	@JoinColumn(name="audit_event_id", insertable = false, updatable = false)
	private AuditEvent auditEvent;

	public AuditTrailNativeUser() {
	}

	public AuditTrailNativeUserPK getId() {
		return this.id;
	}

	public void setId(AuditTrailNativeUserPK id) {
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

	public int getUserNativeId() {
		return this.userNativeId;
	}

	public void setUserNativeId(int userNativeId) {
		this.userNativeId = userNativeId;
	}

	public AuditEvent getAuditEvent() {
		return this.auditEvent;
	}

	public void setAuditEvent(AuditEvent auditEvent) {
		this.auditEvent = auditEvent;
	}

}