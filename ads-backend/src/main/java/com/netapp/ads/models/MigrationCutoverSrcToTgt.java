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
public class MigrationCutoverSrcToTgt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="app_owner_user_corporate_id")
	private Integer appOwnerUserCorporateId;

	@Column(name="application_id", nullable=false)
	private Integer applicationId;

	private boolean completed;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="host_id_list", length=1024)
	private String hostIdList;

	@Column(nullable=false)
	private boolean processed;

	private boolean provisioned;

	private boolean replication;

	@Column(name="src_aggregate_id", nullable=false)
	private Integer srcAggregateId;

	@Column(name="src_controller_id", nullable=false)
	private Integer srcControllerId;

	@Column(name="src_data_center_id", nullable=false)
	private Integer srcDataCenterId;

	@Column(name="src_qtree_id", nullable=false)
	private Integer srcQtreeId;

	@Column(name="src_volume_id", nullable=false)
	private Integer srcVolumeId;

	@Column(name="tgt_aggregate_id", nullable=false)
	private Integer tgtAggregateId;

	@Column(name="tgt_capacity")
	private boolean tgtCapacity;

	@Column(name="tgt_controller_id", nullable=false)
	private Integer tgtControllerId;

	@Column(name="tgt_data_center_id", nullable=false)
	private Integer tgtDataCenterId;

	@Column(name="tgt_qtree_id", nullable=false)
	private Integer tgtQtreeId;

	@Column(name="tgt_status", length=1)
	private String tgtStatus;

	@Column(name="tgt_volume_id", nullable=false)
	private Integer tgtVolumeId;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-one association to DataProtectionPolicy
	@ManyToOne
	@JoinColumn(name="data_protection_policy_id", nullable=false)
	private DataProtectionPolicy dataProtectionPolicy;

	//bi-directional many-to-one association to MigrationCutoverEvent
	@ManyToOne
	@JoinColumn(name="migration_cutover_event_id", unique=true, nullable=false)
	private MigrationCutoverEvent migrationCutoverEvent;

	//bi-directional one-to-one association to MigrationCutoverTeam
	@OneToOne
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private MigrationCutoverTeam migrationCutoverTeam;

	//bi-directional many-to-one association to MigrationCutoverTeam
	@OneToMany(mappedBy="migrationCutoverSrcToTgt")
	private List<MigrationCutoverTeam> migrationCutoverTeams;

	//bi-directional many-to-one association to Replication
	@OneToMany(mappedBy="migrationCutoverSrcToTgt")
	private List<Replication> replications;

	//bi-directional many-to-one association to Workflow
	@OneToMany(mappedBy="migrationCutoverSrcToTgt")
	private List<Workflow> migrationCutoverSrcToTgtWorkflows;

	//bi-directional many-to-one association to Workflow
	@OneToMany(mappedBy="migrationCutoverSrcToTgtMigrationCutoverEvent")
	private List<Workflow> migrationCutoverSrcToTgtMigrationCutoverEventWorkflows;

	public MigrationCutoverSrcToTgt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAppOwnerUserCorporateId() {
		return this.appOwnerUserCorporateId;
	}

	public void setAppOwnerUserCorporateId(Integer appOwnerUserCorporateId) {
		this.appOwnerUserCorporateId = appOwnerUserCorporateId;
	}

	public Integer getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public boolean getCompleted() {
		return this.completed;
	}

	public void setCompleted(boolean completed) {
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

	public boolean getProcessed() {
		return this.processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public boolean getProvisioned() {
		return this.provisioned;
	}

	public void setProvisioned(boolean provisioned) {
		this.provisioned = provisioned;
	}

	public boolean getReplication() {
		return this.replication;
	}

	public void setReplication(boolean replication) {
		this.replication = replication;
	}

	public Integer getSrcAggregateId() {
		return this.srcAggregateId;
	}

	public void setSrcAggregateId(Integer srcAggregateId) {
		this.srcAggregateId = srcAggregateId;
	}

	public Integer getSrcControllerId() {
		return this.srcControllerId;
	}

	public void setSrcControllerId(Integer srcControllerId) {
		this.srcControllerId = srcControllerId;
	}

	public Integer getSrcDataCenterId() {
		return this.srcDataCenterId;
	}

	public void setSrcDataCenterId(Integer srcDataCenterId) {
		this.srcDataCenterId = srcDataCenterId;
	}

	public Integer getSrcQtreeId() {
		return this.srcQtreeId;
	}

	public void setSrcQtreeId(Integer srcQtreeId) {
		this.srcQtreeId = srcQtreeId;
	}

	public Integer getSrcVolumeId() {
		return this.srcVolumeId;
	}

	public void setSrcVolumeId(Integer srcVolumeId) {
		this.srcVolumeId = srcVolumeId;
	}

	public Integer getTgtAggregateId() {
		return this.tgtAggregateId;
	}

	public void setTgtAggregateId(Integer tgtAggregateId) {
		this.tgtAggregateId = tgtAggregateId;
	}

	public boolean getTgtCapacity() {
		return this.tgtCapacity;
	}

	public void setTgtCapacity(boolean tgtCapacity) {
		this.tgtCapacity = tgtCapacity;
	}

	public Integer getTgtControllerId() {
		return this.tgtControllerId;
	}

	public void setTgtControllerId(Integer tgtControllerId) {
		this.tgtControllerId = tgtControllerId;
	}

	public Integer getTgtDataCenterId() {
		return this.tgtDataCenterId;
	}

	public void setTgtDataCenterId(Integer tgtDataCenterId) {
		this.tgtDataCenterId = tgtDataCenterId;
	}

	public Integer getTgtQtreeId() {
		return this.tgtQtreeId;
	}

	public void setTgtQtreeId(Integer tgtQtreeId) {
		this.tgtQtreeId = tgtQtreeId;
	}

	public String getTgtStatus() {
		return this.tgtStatus;
	}

	public void setTgtStatus(String tgtStatus) {
		this.tgtStatus = tgtStatus;
	}

	public Integer getTgtVolumeId() {
		return this.tgtVolumeId;
	}

	public void setTgtVolumeId(Integer tgtVolumeId) {
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

	public List<MigrationCutoverTeam> getMigrationCutoverTeams() {
		return this.migrationCutoverTeams;
	}

	public void setMigrationCutoverTeams(List<MigrationCutoverTeam> migrationCutoverTeams) {
		this.migrationCutoverTeams = migrationCutoverTeams;
	}

	public MigrationCutoverTeam addMigrationCutoverTeam(MigrationCutoverTeam migrationCutoverTeam) {
		getMigrationCutoverTeams().add(migrationCutoverTeam);
		migrationCutoverTeam.setMigrationCutoverSrcToTgt(this);

		return migrationCutoverTeam;
	}

	public MigrationCutoverTeam removeMigrationCutoverTeam(MigrationCutoverTeam migrationCutoverTeam) {
		getMigrationCutoverTeams().remove(migrationCutoverTeam);
		migrationCutoverTeam.setMigrationCutoverSrcToTgt(null);

		return migrationCutoverTeam;
	}

	public List<Replication> getReplications() {
		return this.replications;
	}

	public void setReplications(List<Replication> replications) {
		this.replications = replications;
	}

	public Replication addReplication(Replication replication) {
		getReplications().add(replication);
		replication.setMigrationCutoverSrcToTgt(this);

		return replication;
	}

	public Replication removeReplication(Replication replication) {
		getReplications().remove(replication);
		replication.setMigrationCutoverSrcToTgt(null);

		return replication;
	}

	public List<Workflow> getMigrationCutoverSrcToTgtWorkflows() {
		return this.migrationCutoverSrcToTgtWorkflows;
	}

	public void setMigrationCutoverSrcToTgtWorkflows(List<Workflow> workflows) {
		this.migrationCutoverSrcToTgtWorkflows = workflows;
	}

	public Workflow addWorkflows1(Workflow workflow) {
		getMigrationCutoverSrcToTgtWorkflows().add(workflow);
		workflow.setMigrationCutoverSrcToTgt(this);

		return workflow;
	}

	public Workflow removeWorkflows1(Workflow workflow) {
		getMigrationCutoverSrcToTgtWorkflows().remove(workflow);
		workflow.setMigrationCutoverSrcToTgt(null);

		return workflow;
	}

	public List<Workflow> getMigrationCutoverSrcToTgtMigrationCutoverEventWorkflows() {
		return this.migrationCutoverSrcToTgtMigrationCutoverEventWorkflows;
	}

	public void setMigrationCutoverSrcToTgtMigrationCutoverEventWorkflows(List<Workflow> workflows) {
		this.migrationCutoverSrcToTgtMigrationCutoverEventWorkflows = workflows;
	}

	public Workflow addMigrationCutoverSrcToTgtMigrationCutoverEventWorkflow(Workflow workflow) {
		getMigrationCutoverSrcToTgtMigrationCutoverEventWorkflows().add(workflow);
		workflow.setMigrationCutoverSrcToTgtMigrationCutoverEvent(this);

		return workflow;
	}

	public Workflow removeMigrationCutoverSrcToTgtMigrationCutoverEventWorkflow(Workflow workflow) {
		getMigrationCutoverSrcToTgtMigrationCutoverEventWorkflows().remove(workflow);
		workflow.setMigrationCutoverSrcToTgtMigrationCutoverEvent(null);

		return workflow;
	}

}