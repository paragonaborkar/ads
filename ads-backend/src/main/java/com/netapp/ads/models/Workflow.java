package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the workflow database table.
 * 
 */
@Entity
@Table(name="workflow")
public class Workflow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="error_code", length=60)
	private String errorCode;

	@Column(name="error_description", length=128)
	private String errorDescription;

	@Column(name="job_type", length=255)
	private String jobType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	private Date startTime;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	@Column(name="wfa_job_id", length=255)
	private String wfaJobId;

	@Column(name="wfa_uuid", length=255)
	private String wfaUuid;

	@Column(name="workflow_status", nullable=false, length=60)
	private String workflowStatus;

	//bi-directional many-to-one association to WfaData
	@OneToMany(mappedBy="workflow")
	private List<WfaData> wfaData;

	//bi-directional many-to-one association to WfaMessage
	@OneToMany(mappedBy="workflow")
	private List<WfaMessage> wfaMessages;

	//bi-directional many-to-one association to MigrationCutoverSrcToTgt
	@ManyToOne
	@JoinColumn(name="migration_cutover_src_to_tgt_id", nullable=false)
	private MigrationCutoverSrcToTgt migrationCutoverSrcToTgt;

	//bi-directional many-to-one association to MigrationCutoverSrcToTgt
	@ManyToOne
	@JoinColumn(name="migration_cutover_src_to_tgt_migration_cutover_event_id", nullable=false)
	private MigrationCutoverSrcToTgt migrationCutoverSrcToTgtMigrationCutoverEvent;

	public Workflow() {
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

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return this.errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getJobType() {
		return this.jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getWfaJobId() {
		return this.wfaJobId;
	}

	public void setWfaJobId(String wfaJobId) {
		this.wfaJobId = wfaJobId;
	}

	public String getWfaUuid() {
		return this.wfaUuid;
	}

	public void setWfaUuid(String wfaUuid) {
		this.wfaUuid = wfaUuid;
	}

	public String getWorkflowStatus() {
		return this.workflowStatus;
	}

	public void setWorkflowStatus(String workflowStatus) {
		this.workflowStatus = workflowStatus;
	}

	public List<WfaData> getWfaData() {
		return this.wfaData;
	}

	public void setWfaData(List<WfaData> wfaData) {
		this.wfaData = wfaData;
	}

	public WfaData addWfaData(WfaData wfaData) {
		getWfaData().add(wfaData);
		wfaData.setWorkflow(this);

		return wfaData;
	}

	public WfaData removeWfaData(WfaData wfaData) {
		getWfaData().remove(wfaData);
		wfaData.setWorkflow(null);

		return wfaData;
	}

	public List<WfaMessage> getWfaMessages() {
		return this.wfaMessages;
	}

	public void setWfaMessages(List<WfaMessage> wfaMessages) {
		this.wfaMessages = wfaMessages;
	}

	public WfaMessage addWfaMessage(WfaMessage wfaMessage) {
		getWfaMessages().add(wfaMessage);
		wfaMessage.setWorkflow(this);

		return wfaMessage;
	}

	public WfaMessage removeWfaMessage(WfaMessage wfaMessage) {
		getWfaMessages().remove(wfaMessage);
		wfaMessage.setWorkflow(null);

		return wfaMessage;
	}

	public MigrationCutoverSrcToTgt getMigrationCutoverSrcToTgt() {
		return this.migrationCutoverSrcToTgt;
	}

	public void setMigrationCutoverSrcToTgt(MigrationCutoverSrcToTgt migrationCutoverSrcToTgt) {
		this.migrationCutoverSrcToTgt = migrationCutoverSrcToTgt;
	}

	public MigrationCutoverSrcToTgt getMigrationCutoverSrcToTgtMigrationCutoverEvent() {
		return this.migrationCutoverSrcToTgtMigrationCutoverEvent;
	}

	public void setMigrationCutoverSrcToTgtMigrationCutoverEvent(MigrationCutoverSrcToTgt migrationCutoverSrcToTgt) {
		this.migrationCutoverSrcToTgtMigrationCutoverEvent = migrationCutoverSrcToTgt;
	}

}