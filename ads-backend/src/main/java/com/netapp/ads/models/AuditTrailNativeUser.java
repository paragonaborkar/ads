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
public class AuditTrailNativeUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="audit_comment", length=1024)
	private String auditComment;

	@Column(name="audited_resource", length=255)
	private String auditedResource;

	@Column(name="create_time")
	private Timestamp createTime;

	@Lob
	@Column(name="old_values")
	private String oldValues;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="user_native_id", nullable=false)
	private Integer userNativeId;

	//bi-directional many-to-one association to AuditEvent
	@ManyToOne
	@JoinColumn(name="audit_event_id", nullable=false)
	private AuditEvent auditEvent;

	public AuditTrailNativeUser() {
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

	public Integer getUserNativeId() {
		return this.userNativeId;
	}

	public void setUserNativeId(Integer userNativeId) {
		this.userNativeId = userNativeId;
	}

	public AuditEvent getAuditEvent() {
		return this.auditEvent;
	}

	public void setAuditEvent(AuditEvent auditEvent) {
		this.auditEvent = auditEvent;
	}

}