package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the migration_cutover_src_to_tgt database table.
 * 
 */
@Entity
@Table(name="migration_cutover_src_to_tgt")
@NamedQuery(name="MigrationCutoverSrcToTgt.findAll", query="SELECT m FROM MigrationCutoverSrcToTgt m")
public class MigrationCutoverSrcToTgt implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MigrationCutoverSrcToTgtPK id;

	@Column(name="app_owner_user_corporate_id")
	private int appOwnerUserCorporateId;

	@Column(name="application_id")
	private int applicationId;

	private byte completed;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="host_id_list")
	private String hostIdList;

	private byte processed;

	private byte provisioned;

	private byte replication;

	@Column(name="src_aggregate_id")
	private int srcAggregateId;

	@Column(name="src_controller_id")
	private int srcControllerId;

	@Column(name="src_data_center_id")
	private int srcDataCenterId;

	@Column(name="src_qtree_id")
	private int srcQtreeId;

	@Column(name="src_volume_id")
	private int srcVolumeId;

	@Column(name="tgt_aggregate_id")
	private int tgtAggregateId;

	@Column(name="tgt_capacity")
	private byte tgtCapacity;

	@Column(name="tgt_controller_id")
	private int tgtControllerId;

	@Column(name="tgt_data_center_id")
	private int tgtDataCenterId;

	@Column(name="tgt_qtree_id")
	private int tgtQtreeId;

	@Column(name="tgt_status")
	private String tgtStatus;

	@Column(name="tgt_volume_id")
	private int tgtVolumeId;

	@Column(name="update_time")
	private Timestamp updateTime;

	//bi-directional many-to-one association to DataProtectionPolicy
	@ManyToOne
	@JoinColumn(name="data_protection_policy_id")
	private DataProtectionPolicy dataProtectionPolicy;

	//bi-directional many-to-one association to MigrationCutoverEvent
	@ManyToOne
	@JoinColumn(name="migration_cutover_event_id", insertable = false, updatable = false)
	private MigrationCutoverEvent migrationCutoverEvent;

	//bi-directional many-to-one association to MigrationCutoverTeam
	@ManyToOne
	@JoinColumn(name="id", insertable = false, updatable = false)
	private MigrationCutoverTeam migrationCutoverTeam;

	//bi-directional many-to-one association to Workflow
	@OneToMany(mappedBy="migrationCutoverSrcToTgt")
	private List<Workflow> workflows;

	public MigrationCutoverSrcToTgt() {
	}

	public MigrationCutoverSrcToTgtPK getId() {
		return this.id;
	}

	public void setId(MigrationCutoverSrcToTgtPK id) {
		this.id = id;
	}

	public int getAppOwnerUserCorporateId() {
		return this.appOwnerUserCorporateId;
	}

	public void setAppOwnerUserCorporateId(int appOwnerUserCorporateId) {
		this.appOwnerUserCorporateId = appOwnerUserCorporateId;
	}

	public int getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public byte getCompleted() {
		return this.completed;
	}

	public void setCompleted(byte completed) {
		this.completed = completed;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getHostIdList() {
		return this.hostIdList;
	}

	public void setHostIdList(String hostIdList) {
		this.hostIdList = hostIdList;
	}

	public byte getProcessed() {
		return this.processed;
	}

	public void setProcessed(byte processed) {
		this.processed = processed;
	}

	public byte getProvisioned() {
		return this.provisioned;
	}

	public void setProvisioned(byte provisioned) {
		this.provisioned = provisioned;
	}

	public byte getReplication() {
		return this.replication;
	}

	public void setReplication(byte replication) {
		this.replication = replication;
	}

	public int getSrcAggregateId() {
		return this.srcAggregateId;
	}

	public void setSrcAggregateId(int srcAggregateId) {
		this.srcAggregateId = srcAggregateId;
	}

	public int getSrcControllerId() {
		return this.srcControllerId;
	}

	public void setSrcControllerId(int srcControllerId) {
		this.srcControllerId = srcControllerId;
	}

	public int getSrcDataCenterId() {
		return this.srcDataCenterId;
	}

	public void setSrcDataCenterId(int srcDataCenterId) {
		this.srcDataCenterId = srcDataCenterId;
	}

	public int getSrcQtreeId() {
		return this.srcQtreeId;
	}

	public void setSrcQtreeId(int srcQtreeId) {
		this.srcQtreeId = srcQtreeId;
	}

	public int getSrcVolumeId() {
		return this.srcVolumeId;
	}

	public void setSrcVolumeId(int srcVolumeId) {
		this.srcVolumeId = srcVolumeId;
	}

	public int getTgtAggregateId() {
		return this.tgtAggregateId;
	}

	public void setTgtAggregateId(int tgtAggregateId) {
		this.tgtAggregateId = tgtAggregateId;
	}

	public byte getTgtCapacity() {
		return this.tgtCapacity;
	}

	public void setTgtCapacity(byte tgtCapacity) {
		this.tgtCapacity = tgtCapacity;
	}

	public int getTgtControllerId() {
		return this.tgtControllerId;
	}

	public void setTgtControllerId(int tgtControllerId) {
		this.tgtControllerId = tgtControllerId;
	}

	public int getTgtDataCenterId() {
		return this.tgtDataCenterId;
	}

	public void setTgtDataCenterId(int tgtDataCenterId) {
		this.tgtDataCenterId = tgtDataCenterId;
	}

	public int getTgtQtreeId() {
		return this.tgtQtreeId;
	}

	public void setTgtQtreeId(int tgtQtreeId) {
		this.tgtQtreeId = tgtQtreeId;
	}

	public String getTgtStatus() {
		return this.tgtStatus;
	}

	public void setTgtStatus(String tgtStatus) {
		this.tgtStatus = tgtStatus;
	}

	public int getTgtVolumeId() {
		return this.tgtVolumeId;
	}

	public void setTgtVolumeId(int tgtVolumeId) {
		this.tgtVolumeId = tgtVolumeId;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public DataProtectionPolicy getDataProtectionPolicy() {
		return this.dataProtectionPolicy;
	}

	public void setDataProtectionPolicy(DataProtectionPolicy dataProtectionPolicy) {
		this.dataProtectionPolicy = dataProtectionPolicy;
	}

	public MigrationCutoverEvent getMigrationCutoverEvent() {
		return this.migrationCutoverEvent;
	}

	public void setMigrationCutoverEvent(MigrationCutoverEvent migrationCutoverEvent) {
		this.migrationCutoverEvent = migrationCutoverEvent;
	}

	public MigrationCutoverTeam getMigrationCutoverTeam() {
		return this.migrationCutoverTeam;
	}

	public void setMigrationCutoverTeam(MigrationCutoverTeam migrationCutoverTeam) {
		this.migrationCutoverTeam = migrationCutoverTeam;
	}

	public List<Workflow> getWorkflows() {
		return this.workflows;
	}

	public void setWorkflows(List<Workflow> workflows) {
		this.workflows = workflows;
	}

	public Workflow addWorkflow(Workflow workflow) {
		getWorkflows().add(workflow);
		workflow.setMigrationCutoverSrcToTgt(this);

		return workflow;
	}

	public Workflow removeWorkflow(Workflow workflow) {
		getWorkflows().remove(workflow);
		workflow.setMigrationCutoverSrcToTgt(null);

		return workflow;
	}

}