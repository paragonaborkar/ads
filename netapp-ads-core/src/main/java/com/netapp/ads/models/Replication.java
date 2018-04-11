package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the replication database table.
 * 
 */
@Entity
@Table(name="replication")
public class Replication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="src_mirror_aggregate_name", length=225)
	private String srcMirrorAggregateName;

	@Column(name="src_mirror_controller_name", length=225)
	private String srcMirrorControllerName;

	@Column(name="src_mirror_data_center_name", length=60)
	private String srcMirrorDataCenterName;

	@Column(name="src_mirror_qtree_name", length=225)
	private String srcMirrorQtreeName;

	@Column(name="src_mirror_volume_name", length=225)
	private String srcMirrorVolumeName;

	@Column(name="src_prod_data_center_name", length=60)
	private String srcProdDataCenterName;

	@Column(name="src_vault_aggregate_name", length=225)
	private String srcVaultAggregateName;

	@Column(name="src_vault_controller_name", length=225)
	private String srcVaultControllerName;

	@Column(name="src_vault_data_center_name", length=60)
	private String srcVaultDataCenterName;

	@Column(name="src_vault_qtree_name", length=225)
	private String srcVaultQtreeName;

	@Column(name="src_vault_volume_name", length=225)
	private String srcVaultVolumeName;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-one association to Aggregate
	@ManyToOne
	@JoinColumn(name="tgt_vault_aggregate_id")
	private Aggregate targetVaultAggregate;

	//bi-directional many-to-one association to Aggregate
	@ManyToOne
	@JoinColumn(name="tgt_mirror_aggregate_id")
	private Aggregate targetMirrorAggregate;

	//bi-directional many-to-one association to DataCenter
	@ManyToOne
	@JoinColumn(name="tgt_vault_data_center_id")
	private DataCenter targetVaultDataCenter;

	//bi-directional many-to-one association to DataCenter
	@ManyToOne
	@JoinColumn(name="tgt_mirror_data_center_id")
	private DataCenter targetMirroDataCenter;

	//bi-directional many-to-one association to MigrationCutoverSrcToTgt
	@ManyToOne
	@JoinColumn(name="migration_cutover_src_to_tgt_id", nullable=false)
	private MigrationCutoverSrcToTgt migrationCutoverSrcToTgt;

	//bi-directional many-to-one association to Storage
	@ManyToOne
	@JoinColumn(name="tgt_vault_storage_id")
	private Storage targetVaultStorage;

	//bi-directional many-to-one association to Storage
	@ManyToOne
	@JoinColumn(name="tgt_mirror_storage_id")
	private Storage targetMirrorStorage;

	public Replication() {
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

	public String getSrcMirrorAggregateName() {
		return this.srcMirrorAggregateName;
	}

	public void setSrcMirrorAggregateName(String srcMirrorAggregateName) {
		this.srcMirrorAggregateName = srcMirrorAggregateName;
	}

	public String getSrcMirrorControllerName() {
		return this.srcMirrorControllerName;
	}

	public void setSrcMirrorControllerName(String srcMirrorControllerName) {
		this.srcMirrorControllerName = srcMirrorControllerName;
	}

	public String getSrcMirrorDataCenterName() {
		return this.srcMirrorDataCenterName;
	}

	public void setSrcMirrorDataCenterName(String srcMirrorDataCenterName) {
		this.srcMirrorDataCenterName = srcMirrorDataCenterName;
	}

	public String getSrcMirrorQtreeName() {
		return this.srcMirrorQtreeName;
	}

	public void setSrcMirrorQtreeName(String srcMirrorQtreeName) {
		this.srcMirrorQtreeName = srcMirrorQtreeName;
	}

	public String getSrcMirrorVolumeName() {
		return this.srcMirrorVolumeName;
	}

	public void setSrcMirrorVolumeName(String srcMirrorVolumeName) {
		this.srcMirrorVolumeName = srcMirrorVolumeName;
	}

	public String getSrcProdDataCenterName() {
		return this.srcProdDataCenterName;
	}

	public void setSrcProdDataCenterName(String srcProdDataCenterName) {
		this.srcProdDataCenterName = srcProdDataCenterName;
	}

	public String getSrcVaultAggregateName() {
		return this.srcVaultAggregateName;
	}

	public void setSrcVaultAggregateName(String srcVaultAggregateName) {
		this.srcVaultAggregateName = srcVaultAggregateName;
	}

	public String getSrcVaultControllerName() {
		return this.srcVaultControllerName;
	}

	public void setSrcVaultControllerName(String srcVaultControllerName) {
		this.srcVaultControllerName = srcVaultControllerName;
	}

	public String getSrcVaultDataCenterName() {
		return this.srcVaultDataCenterName;
	}

	public void setSrcVaultDataCenterName(String srcVaultDataCenterName) {
		this.srcVaultDataCenterName = srcVaultDataCenterName;
	}

	public String getSrcVaultQtreeName() {
		return this.srcVaultQtreeName;
	}

	public void setSrcVaultQtreeName(String srcVaultQtreeName) {
		this.srcVaultQtreeName = srcVaultQtreeName;
	}

	public String getSrcVaultVolumeName() {
		return this.srcVaultVolumeName;
	}

	public void setSrcVaultVolumeName(String srcVaultVolumeName) {
		this.srcVaultVolumeName = srcVaultVolumeName;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Aggregate getTargetVaultAggregate() {
		return this.targetVaultAggregate;
	}

	public void setTargetVaultAggregate(Aggregate targetVaultAggregate) {
		this.targetVaultAggregate = targetVaultAggregate;
	}

	public Aggregate getTargetMirrorAggregate() {
		return this.targetMirrorAggregate;
	}

	public void setTargetMirrorAggregate(Aggregate targetMirrorAggregate) {
		this.targetMirrorAggregate = targetMirrorAggregate;
	}

	public DataCenter getTargetVaultDataCenter() {
		return this.targetVaultDataCenter;
	}

	public void setTargetVaultDataCenter(DataCenter dataCenter) {
		this.targetVaultDataCenter = dataCenter;
	}

	public DataCenter getTargetMirrorDataCenter() {
		return this.targetMirroDataCenter;
	}

	public void setTargetMirrorDataCenter(DataCenter dataCenter) {
		this.targetMirroDataCenter = dataCenter;
	}

	public MigrationCutoverSrcToTgt getMigrationCutoverSrcToTgt() {
		return this.migrationCutoverSrcToTgt;
	}

	public void setMigrationCutoverSrcToTgt(MigrationCutoverSrcToTgt migrationCutoverSrcToTgt) {
		this.migrationCutoverSrcToTgt = migrationCutoverSrcToTgt;
	}

	public Storage getTargetVaultStorage() {
		return this.targetVaultStorage;
	}

	public void setTargetVaultStorage(Storage targetVaultStorage) {
		this.targetVaultStorage = targetVaultStorage;
	}

	public Storage getTargetMirrorStorage() {
		return this.targetMirrorStorage;
	}

	public void setTargetMirrorStorage(Storage targetMirrorStorage) {
		this.targetMirrorStorage = targetMirrorStorage;
	}

}