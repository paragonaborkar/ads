package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the change_management database table.
 * 
 */
@Entity
@Table(name="change_management")
public class ChangeManagement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Lob
	@Column(name="assets_impacted")
	private String assetsImpacted;

	@Column(name="change_management_number", length=60)
	private String changeManagementNumber;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(length=1024)
	private String description;

	@Lob
	private String note;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-one association to MigrationCutoverEvent
	@ManyToOne
	@JoinColumn(name="migration_cutover_event_id", nullable=false)
	private MigrationCutoverEvent migrationCutoverEvent;

	//bi-directional many-to-one association to Cutover
	@OneToMany(mappedBy="changeManagement")
	private List<Cutover> cutovers;

	public ChangeManagement() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public List<Cutover> getCutovers() {
		return this.cutovers;
	}

	public void setCutovers(List<Cutover> cutovers) {
		this.cutovers = cutovers;
	}

	public Cutover addCutover(Cutover cutover) {
		getCutovers().add(cutover);
		cutover.setChangeManagement(this);

		return cutover;
	}

	public Cutover removeCutover(Cutover cutover) {
		getCutovers().remove(cutover);
		cutover.setChangeManagement(null);

		return cutover;
	}

}