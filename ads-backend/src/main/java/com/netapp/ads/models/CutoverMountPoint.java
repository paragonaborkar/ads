package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cutover_mount_point database table.
 * 
 */
@Entity
@Table(name="cutover_mount_point")
@NamedQuery(name="CutoverMountPoint.findAll", query="SELECT c FROM CutoverMountPoint c")
public class CutoverMountPoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="fwd_mount_label")
	private String fwdMountLabel;

	@Column(name="fwd_unmount_label")
	private String fwdUnmountLabel;

	@Lob
	@Column(name="host_list")
	private String hostList;

	@Column(name="rev_mount_label")
	private String revMountLabel;

	@Column(name="rev_unmount_label")
	private String revUnmountLabel;

	@Column(name="update_time")
	private Timestamp updateTime;

	//bi-directional many-to-one association to MigrationCutoverEvent
	@ManyToOne
	@JoinColumn(name="migration_cutover_event_id")
	private MigrationCutoverEvent migrationCutoverEvent;

	public CutoverMountPoint() {
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

	public String getFwdMountLabel() {
		return this.fwdMountLabel;
	}

	public void setFwdMountLabel(String fwdMountLabel) {
		this.fwdMountLabel = fwdMountLabel;
	}

	public String getFwdUnmountLabel() {
		return this.fwdUnmountLabel;
	}

	public void setFwdUnmountLabel(String fwdUnmountLabel) {
		this.fwdUnmountLabel = fwdUnmountLabel;
	}

	public String getHostList() {
		return this.hostList;
	}

	public void setHostList(String hostList) {
		this.hostList = hostList;
	}

	public String getRevMountLabel() {
		return this.revMountLabel;
	}

	public void setRevMountLabel(String revMountLabel) {
		this.revMountLabel = revMountLabel;
	}

	public String getRevUnmountLabel() {
		return this.revUnmountLabel;
	}

	public void setRevUnmountLabel(String revUnmountLabel) {
		this.revUnmountLabel = revUnmountLabel;
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