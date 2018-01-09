package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the replication database table.
 * 
 */
@Entity
@NamedQuery(name="Replication.findAll", query="SELECT r FROM Replication r")
public class Replication implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReplicationPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="src_mirror_aggregate_name")
	private String srcMirrorAggregateName;

	@Column(name="src_mirror_controller_name")
	private String srcMirrorControllerName;

	@Column(name="src_mirror_data_center_name")
	private String srcMirrorDataCenterName;

	@Column(name="src_mirror_qtree_name")
	private String srcMirrorQtreeName;

	@Column(name="src_mirror_volume_name")
	private String srcMirrorVolumeName;

	@Column(name="src_prod_data_center_name")
	private String srcProdDataCenterName;

	@Column(name="src_vault_aggregate_name")
	private String srcVaultAggregateName;

	@Column(name="src_vault_controller_name")
	private String srcVaultControllerName;

	@Column(name="src_vault_data_center_name")
	private String srcVaultDataCenterName;

	@Column(name="src_vault_qtree_name")
	private String srcVaultQtreeName;

	@Column(name="src_vault_volume_name")
	private String srcVaultVolumeName;

	@Column(name="tgt_mirror_aggregate_id")
	private int tgtMirrorAggregateId;

	@Column(name="tgt_mirror_data_center_id")
	private int tgtMirrorDataCenterId;

	@Column(name="tgt_mirror_storage_id")
	private int tgtMirrorStorageId;

	@Column(name="tgt_vault_aggregate_id")
	private int tgtVaultAggregateId;

	@Column(name="tgt_vault_data_center_id")
	private int tgtVaultDataCenterId;

	@Column(name="tgt_vault_storage_id")
	private int tgtVaultStorageId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public Replication() {
	}

	public ReplicationPK getId() {
		return this.id;
	}

	public void setId(ReplicationPK id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
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

	public int getTgtMirrorAggregateId() {
		return this.tgtMirrorAggregateId;
	}

	public void setTgtMirrorAggregateId(int tgtMirrorAggregateId) {
		this.tgtMirrorAggregateId = tgtMirrorAggregateId;
	}

	public int getTgtMirrorDataCenterId() {
		return this.tgtMirrorDataCenterId;
	}

	public void setTgtMirrorDataCenterId(int tgtMirrorDataCenterId) {
		this.tgtMirrorDataCenterId = tgtMirrorDataCenterId;
	}

	public int getTgtMirrorStorageId() {
		return this.tgtMirrorStorageId;
	}

	public void setTgtMirrorStorageId(int tgtMirrorStorageId) {
		this.tgtMirrorStorageId = tgtMirrorStorageId;
	}

	public int getTgtVaultAggregateId() {
		return this.tgtVaultAggregateId;
	}

	public void setTgtVaultAggregateId(int tgtVaultAggregateId) {
		this.tgtVaultAggregateId = tgtVaultAggregateId;
	}

	public int getTgtVaultDataCenterId() {
		return this.tgtVaultDataCenterId;
	}

	public void setTgtVaultDataCenterId(int tgtVaultDataCenterId) {
		this.tgtVaultDataCenterId = tgtVaultDataCenterId;
	}

	public int getTgtVaultStorageId() {
		return this.tgtVaultStorageId;
	}

	public void setTgtVaultStorageId(int tgtVaultStorageId) {
		this.tgtVaultStorageId = tgtVaultStorageId;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}