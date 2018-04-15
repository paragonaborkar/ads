package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the audit_event database table.
 * 
 */
@Entity
@Table(name="audit_event")
public class AuditEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="event_name", nullable=false, length=45)
	private String eventName;

	@Column(name="http_method", nullable=false, length=1)
	private String httpMethod;

	@Column(name="resource_pattern", nullable=false, length=255)
	private String resourcePattern;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-one association to AuditReasonCode
	@OneToMany(mappedBy="auditEvent")
	private List<AuditReasonCode> auditReasonCodes;

	//bi-directional many-to-one association to AuditTrailApi
	@OneToMany(mappedBy="auditEvent")
	private List<AuditTrailApi> auditTrailApis;

	//bi-directional many-to-one association to AuditTrailCorporateUser
	@OneToMany(mappedBy="auditEvent")
	private List<AuditTrailCorporateUser> auditTrailCorporateUsers;

	//bi-directional many-to-one association to AuditTrailNativeUser
	@OneToMany(mappedBy="auditEvent")
	private List<AuditTrailNativeUser> auditTrailNativeUsers;

	public AuditEvent() {
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

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getHttpMethod() {
		return this.httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getResourcePattern() {
		return this.resourcePattern;
	}

	public void setResourcePattern(String resourcePattern) {
		this.resourcePattern = resourcePattern;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<AuditReasonCode> getAuditReasonCodes() {
		return this.auditReasonCodes;
	}

	public void setAuditReasonCodes(List<AuditReasonCode> auditReasonCodes) {
		this.auditReasonCodes = auditReasonCodes;
	}

	public AuditReasonCode addAuditReasonCode(AuditReasonCode auditReasonCode) {
		getAuditReasonCodes().add(auditReasonCode);
		auditReasonCode.setAuditEvent(this);

		return auditReasonCode;
	}

	public AuditReasonCode removeAuditReasonCode(AuditReasonCode auditReasonCode) {
		getAuditReasonCodes().remove(auditReasonCode);
		auditReasonCode.setAuditEvent(null);

		return auditReasonCode;
	}

	public List<AuditTrailApi> getAuditTrailApis() {
		return this.auditTrailApis;
	}

	public void setAuditTrailApis(List<AuditTrailApi> auditTrailApis) {
		this.auditTrailApis = auditTrailApis;
	}

	public AuditTrailApi addAuditTrailApi(AuditTrailApi auditTrailApi) {
		getAuditTrailApis().add(auditTrailApi);
		auditTrailApi.setAuditEvent(this);

		return auditTrailApi;
	}

	public AuditTrailApi removeAuditTrailApi(AuditTrailApi auditTrailApi) {
		getAuditTrailApis().remove(auditTrailApi);
		auditTrailApi.setAuditEvent(null);

		return auditTrailApi;
	}

	public List<AuditTrailCorporateUser> getAuditTrailCorporateUsers() {
		return this.auditTrailCorporateUsers;
	}

	public void setAuditTrailCorporateUsers(List<AuditTrailCorporateUser> auditTrailCorporateUsers) {
		this.auditTrailCorporateUsers = auditTrailCorporateUsers;
	}

	public AuditTrailCorporateUser addAuditTrailCorporateUser(AuditTrailCorporateUser auditTrailCorporateUser) {
		getAuditTrailCorporateUsers().add(auditTrailCorporateUser);
		auditTrailCorporateUser.setAuditEvent(this);

		return auditTrailCorporateUser;
	}

	public AuditTrailCorporateUser removeAuditTrailCorporateUser(AuditTrailCorporateUser auditTrailCorporateUser) {
		getAuditTrailCorporateUsers().remove(auditTrailCorporateUser);
		auditTrailCorporateUser.setAuditEvent(null);

		return auditTrailCorporateUser;
	}

	public List<AuditTrailNativeUser> getAuditTrailNativeUsers() {
		return this.auditTrailNativeUsers;
	}

	public void setAuditTrailNativeUsers(List<AuditTrailNativeUser> auditTrailNativeUsers) {
		this.auditTrailNativeUsers = auditTrailNativeUsers;
	}

	public AuditTrailNativeUser addAuditTrailNativeUser(AuditTrailNativeUser auditTrailNativeUser) {
		getAuditTrailNativeUsers().add(auditTrailNativeUser);
		auditTrailNativeUser.setAuditEvent(this);

		return auditTrailNativeUser;
	}

	public AuditTrailNativeUser removeAuditTrailNativeUser(AuditTrailNativeUser auditTrailNativeUser) {
		getAuditTrailNativeUsers().remove(auditTrailNativeUser);
		auditTrailNativeUser.setAuditEvent(null);

		return auditTrailNativeUser;
	}

}