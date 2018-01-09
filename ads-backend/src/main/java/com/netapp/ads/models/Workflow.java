package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the workflow database table.
 * 
 */
@Entity
@NamedQuery(name="Workflow.findAll", query="SELECT w FROM Workflow w")
public class Workflow implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WorkflowPK id;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="error_code")
	private String errorCode;

	@Column(name="error_description")
	private String errorDescription;

	@Column(name="job_type")
	private String jobType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	private Date startTime;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="wfa_job_id")
	private String wfaJobId;

	@Column(name="wfa_uuid")
	private String wfaUuid;

	@Column(name="workflow_status")
	private String workflowStatus;

	//bi-directional many-to-one association to MigrationCutoverSrcToTgt
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="migration_cutover_src_to_tgt_id", referencedColumnName="id", insertable = false, updatable = false),
		@JoinColumn(name="migration_cutover_src_to_tgt_migration_cutover_event_id", referencedColumnName="migration_cutover_event_id", insertable = false, updatable = false)
		})
	private MigrationCutoverSrcToTgt migrationCutoverSrcToTgt;

	public Workflow() {
	}

	public WorkflowPK getId() {
		return this.id;
	}

	public void setId(WorkflowPK id) {
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

	public MigrationCutoverSrcToTgt getMigrationCutoverSrcToTgt() {
		return this.migrationCutoverSrcToTgt;
	}

	public void setMigrationCutoverSrcToTgt(MigrationCutoverSrcToTgt migrationCutoverSrcToTgt) {
		this.migrationCutoverSrcToTgt = migrationCutoverSrcToTgt;
	}

}