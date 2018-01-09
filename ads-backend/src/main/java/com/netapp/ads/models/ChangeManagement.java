package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the change_management database table.
 * 
 */
@Entity
@Table(name="change_management")
@NamedQuery(name="ChangeManagement.findAll", query="SELECT c FROM ChangeManagement c")
public class ChangeManagement implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChangeManagementPK id;

	@Lob
	@Column(name="assets_impacted")
	private String assetsImpacted;

	@Column(name="change_management_number")
	private String changeManagementNumber;

	@Column(name="create_time")
	private Timestamp createTime;

	private String description;

	@Lob
	private String note;

	@Column(name="update_time")
	private Timestamp updateTime;

	//bi-directional many-to-one association to MigrationCutoverEvent
	@ManyToOne
	@JoinColumn(name="migration_cutover_event_id", insertable = false, updatable = false)
	private MigrationCutoverEvent migrationCutoverEvent;

	public ChangeManagement() {
	}

	public ChangeManagementPK getId() {
		return this.id;
	}

	public void setId(ChangeManagementPK id) {
		this.id = id;
	}

	public String getAssetsImpacted() {
		return this.assetsImpacted;
	}

	public void setAssetsImpacted(String assetsImpacted) {
		this.assetsImpacted = assetsImpacted;
	}

	public String getChangeManagementNumber() {
		return this.changeManagementNumber;
	}

	public void setChangeManagementNumber(String changeManagementNumber) {
		this.changeManagementNumber = changeManagementNumber;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public MigrationCutoverEvent getMigrationCutoverEvent() {
		return this.migrationCutoverEvent;
	}

	public void setMigrationCutoverEvent(MigrationCutoverEvent migrationCutoverEvent) {
		this.migrationCutoverEvent = migrationCutoverEvent;
	}

}