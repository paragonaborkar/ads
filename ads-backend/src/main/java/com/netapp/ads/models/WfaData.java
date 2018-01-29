package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the wfa_data database table.
 * 
 */
@Entity
@Table(name="wfa_data")
public class WfaData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=255)
	private String app;

	@Column(name="change_management", length=60)
	private String changeManagement;

	@Column(name="change_number")
	private Integer changeNumber;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(length=255)
	private String desc;

	@Column(length=255)
	private String desc0;

	@Column(length=60)
	private String description;

	@Column(name="dominant_protocol", length=10)
	private String dominantProtocol;

	@Column(length=10)
	private String env;

	@Column(name="high_overwrite")
	private boolean highOverwrite;

	@Column(name="keep_global_ro")
	private boolean keepGlobalRo;

	@Column(length=255)
	private String lob;

	@Column(name="lob_information_owner", length=60)
	private String lobInformationOwner;

	private boolean migrationTarget;

	@Column(name="mirror_aggregate", length=128)
	private String mirrorAggregate;

	@Column(name="mirror_controller", length=128)
	private String mirrorController;

	@Column(name="mirror_data_center", length=128)
	private String mirrorDataCenter;

	@Column(name="mirror_source_controller", length=255)
	private String mirrorSourceController;

	@Column(name="mirror_source_qtree", length=255)
	private String mirrorSourceQtree;

	@Column(name="mirror_source_volume", length=255)
	private String mirrorSourceVolume;

	@Column(name="mirror_storage", length=255)
	private String mirrorStorage;

	@Column(name="nfs_export_rules", length=10)
	private String nfsExportRules;

	@Column(name="prod_aggregate", length=128)
	private String prodAggregate;

	@Column(name="prod_datacenter", length=128)
	private String prodDatacenter;

	@Column(name="prod_new_volume", length=255)
	private String prodNewVolume;

	@Column(name="prod_source_controller", length=255)
	private String prodSourceController;

	@Column(name="prod_source_qtree", length=255)
	private String prodSourceQtree;

	@Column(name="prod_source_volume", length=255)
	private String prodSourceVolume;

	@Column(name="prod_storage", length=255)
	private String prodStorage;

	@Column(name="prod_vserver", length=128)
	private String prodVserver;

	@Column(length=128)
	private String protection;

	@Column(name="protection_topology", length=60)
	private String protectionTopology;

	@Column(length=20)
	private String protocol;

	@Column(length=24)
	private String purpose;

	private Integer qos;

	@Column(length=24)
	private String region;

	@Column(name="shared_netgroup")
	private boolean sharedNetgroup;

	@Column(name="storagex_netgroup", length=128)
	private String storagexNetgroup;

	@Column(name="sub_lob", length=128)
	private String subLob;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="user_corporate_id")
	private Integer userCorporateId;

	@Column(name="vault_aggregate", length=128)
	private String vaultAggregate;

	@Column(name="vault_controller", length=128)
	private String vaultController;

	@Column(name="vault_data_center", length=128)
	private String vaultDataCenter;

	@Column(name="vault_source_controller", length=255)
	private String vaultSourceController;

	@Column(name="vault_source_qtree", length=255)
	private String vaultSourceQtree;

	@Column(name="vault_source_volume", length=255)
	private String vaultSourceVolume;

	@Column(name="vault_storage", length=255)
	private String vaultStorage;

	@Column(name="volume_size")
	private float volumeSize;

	//bi-directional many-to-one association to Workflow
	@ManyToOne
	@JoinColumn(name="workflow_id", nullable=false)
	private Workflow workflow;

	public WfaData() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApp() {
		return this.app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getChangeManagement() {
		return this.changeManagement;
	}

	public void setChangeManagement(String changeManagement) {
		this.changeManagement = changeManagement;
	}

	public Integer getChangeNumber() {
		return this.changeNumber;
	}

	public void setChangeNumber(Integer changeNumber) {
		this.changeNumber = changeNumber;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc0() {
		return this.desc0;
	}

	public void setDesc0(String desc0) {
		this.desc0 = desc0;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDominantProtocol() {
		return this.dominantProtocol;
	}

	public void setDominantProtocol(String dominantProtocol) {
		this.dominantProtocol = dominantProtocol;
	}

	public String getEnv() {
		return this.env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public boolean getHighOverwrite() {
		return this.highOverwrite;
	}

	public void setHighOverwrite(boolean highOverwrite) {
		this.highOverwrite = highOverwrite;
	}

	public boolean getKeepGlobalRo() {
		return this.keepGlobalRo;
	}

	public void setKeepGlobalRo(boolean keepGlobalRo) {
		this.keepGlobalRo = keepGlobalRo;
	}

	public String getLob() {
		return this.lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getLobInformationOwner() {
		return this.lobInformationOwner;
	}

	public void setLobInformationOwner(String lobInformationOwner) {
		this.lobInformationOwner = lobInformationOwner;
	}

	public boolean getMigrationTarget() {
		return this.migrationTarget;
	}

	public void setMigrationTarget(boolean migrationTarget) {
		this.migrationTarget = migrationTarget;
	}

	public String getMirrorAggregate() {
		return this.mirrorAggregate;
	}

	public void setMirrorAggregate(String mirrorAggregate) {
		this.mirrorAggregate = mirrorAggregate;
	}

	public String getMirrorController() {
		return this.mirrorController;
	}

	public void setMirrorController(String mirrorController) {
		this.mirrorController = mirrorController;
	}

	public String getMirrorDataCenter() {
		return this.mirrorDataCenter;
	}

	public void setMirrorDataCenter(String mirrorDataCenter) {
		this.mirrorDataCenter = mirrorDataCenter;
	}

	public String getMirrorSourceController() {
		return this.mirrorSourceController;
	}

	public void setMirrorSourceController(String mirrorSourceController) {
		this.mirrorSourceController = mirrorSourceController;
	}

	public String getMirrorSourceQtree() {
		return this.mirrorSourceQtree;
	}

	public void setMirrorSourceQtree(String mirrorSourceQtree) {
		this.mirrorSourceQtree = mirrorSourceQtree;
	}

	public String getMirrorSourceVolume() {
		return this.mirrorSourceVolume;
	}

	public void setMirrorSourceVolume(String mirrorSourceVolume) {
		this.mirrorSourceVolume = mirrorSourceVolume;
	}

	public String getMirrorStorage() {
		return this.mirrorStorage;
	}

	public void setMirrorStorage(String mirrorStorage) {
		this.mirrorStorage = mirrorStorage;
	}

	public String getNfsExportRules() {
		return this.nfsExportRules;
	}

	public void setNfsExportRules(String nfsExportRules) {
		this.nfsExportRules = nfsExportRules;
	}

	public String getProdAggregate() {
		return this.prodAggregate;
	}

	public void setProdAggregate(String prodAggregate) {
		this.prodAggregate = prodAggregate;
	}

	public String getProdDatacenter() {
		return this.prodDatacenter;
	}

	public void setProdDatacenter(String prodDatacenter) {
		this.prodDatacenter = prodDatacenter;
	}

	public String getProdNewVolume() {
		return this.prodNewVolume;
	}

	public void setProdNewVolume(String prodNewVolume) {
		this.prodNewVolume = prodNewVolume;
	}

	public String getProdSourceController() {
		return this.prodSourceController;
	}

	public void setProdSourceController(String prodSourceController) {
		this.prodSourceController = prodSourceController;
	}

	public String getProdSourceQtree() {
		return this.prodSourceQtree;
	}

	public void setProdSourceQtree(String prodSourceQtree) {
		this.prodSourceQtree = prodSourceQtree;
	}

	public String getProdSourceVolume() {
		return this.prodSourceVolume;
	}

	public void setProdSourceVolume(String prodSourceVolume) {
		this.prodSourceVolume = prodSourceVolume;
	}

	public String getProdStorage() {
		return this.prodStorage;
	}

	public void setProdStorage(String prodStorage) {
		this.prodStorage = prodStorage;
	}

	public String getProdVserver() {
		return this.prodVserver;
	}

	public void setProdVserver(String prodVserver) {
		this.prodVserver = prodVserver;
	}

	public String getProtection() {
		return this.protection;
	}

	public void setProtection(String protection) {
		this.protection = protection;
	}

	public String getProtectionTopology() {
		return this.protectionTopology;
	}

	public void setProtectionTopology(String protectionTopology) {
		this.protectionTopology = protectionTopology;
	}

	public String getProtocol() {
		return this.protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Integer getQos() {
		return this.qos;
	}

	public void setQos(Integer qos) {
		this.qos = qos;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public boolean getSharedNetgroup() {
		return this.sharedNetgroup;
	}

	public void setSharedNetgroup(boolean sharedNetgroup) {
		this.sharedNetgroup = sharedNetgroup;
	}

	public String getStoragexNetgroup() {
		return this.storagexNetgroup;
	}

	public void setStoragexNetgroup(String storagexNetgroup) {
		this.storagexNetgroup = storagexNetgroup;
	}

	public String getSubLob() {
		return this.subLob;
	}

	public void setSubLob(String subLob) {
		this.subLob = subLob;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUserCorporateId() {
		return this.userCorporateId;
	}

	public void setUserCorporateId(Integer userCorporateId) {
		this.userCorporateId = userCorporateId;
	}

	public String getVaultAggregate() {
		return this.vaultAggregate;
	}

	public void setVaultAggregate(String vaultAggregate) {
		this.vaultAggregate = vaultAggregate;
	}

	public String getVaultController() {
		return this.vaultController;
	}

	public void setVaultController(String vaultController) {
		this.vaultController = vaultController;
	}

	public String getVaultDataCenter() {
		return this.vaultDataCenter;
	}

	public void setVaultDataCenter(String vaultDataCenter) {
		this.vaultDataCenter = vaultDataCenter;
	}

	public String getVaultSourceController() {
		return this.vaultSourceController;
	}

	public void setVaultSourceController(String vaultSourceController) {
		this.vaultSourceController = vaultSourceController;
	}

	public String getVaultSourceQtree() {
		return this.vaultSourceQtree;
	}

	public void setVaultSourceQtree(String vaultSourceQtree) {
		this.vaultSourceQtree = vaultSourceQtree;
	}

	public String getVaultSourceVolume() {
		return this.vaultSourceVolume;
	}

	public void setVaultSourceVolume(String vaultSourceVolume) {
		this.vaultSourceVolume = vaultSourceVolume;
	}

	public String getVaultStorage() {
		return this.vaultStorage;
	}

	public void setVaultStorage(String vaultStorage) {
		this.vaultStorage = vaultStorage;
	}

	public float getVolumeSize() {
		return this.volumeSize;
	}

	public void setVolumeSize(float volumeSize) {
		this.volumeSize = volumeSize;
	}

	public Workflow getWorkflow() {
		return this.workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

}