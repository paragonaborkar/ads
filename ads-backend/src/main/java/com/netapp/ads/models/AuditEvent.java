package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the audit_event database table.
 * 
 */
@Entity
@Table(name="audit_event")
@NamedQuery(name="AuditEvent.findAll", query="SELECT a FROM AuditEvent a")
public class AuditEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="event_name")
	private String eventName;

	@Column(name="http_method")
	private String httpMethod;

	@Column(name="resource_pattern")
	private String resourcePattern;

	@Column(name="update_time")
	private Timestamp updateTime;

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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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