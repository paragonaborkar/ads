package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the host database table.
 * 
 */
@Entity
@Table(name="host")
public class Host implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="host_name", length=255)
	private String hostName;

	@Column(name="host_owner_user_corporate_id")
	private Integer hostOwnerUserCorporateId;

	@Column(name="ip_addr", length=255)
	private String ipAddr;

	@Column(length=255)
	private String note;

	@Column(name="system_admin_id")
	private Integer systemAdminId;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-many association to Application
	@ManyToMany
	@JoinTable(
		name="host_application_x_ref"
		, joinColumns={
			@JoinColumn(name="host_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="application_id", nullable=false)
			}
		)
	private List<Application> applications;

	//bi-directional many-to-many association to Export
	@ManyToMany
	@JoinTable(
		name="exports_host_x_ref"
		, joinColumns={
			@JoinColumn(name="host_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="exports_id", nullable=false)
			}
		)
	private List<Export> exports;

	//bi-directional many-to-one association to MountPoint
	@OneToMany(mappedBy="host")
	private List<MountPoint> mountPoints;

	//bi-directional many-to-one association to Share
	@OneToMany(mappedBy="host")
	private List<Share> shares;

	public Host() {
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

	public String getHostName() {
		return this.hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public Integer getHostOwnerUserCorporateId() {
		return this.hostOwnerUserCorporateId;
	}

	public void setHostOwnerUserCorporateId(Integer hostOwnerUserCorporateId) {
		this.hostOwnerUserCorporateId = hostOwnerUserCorporateId;
	}

	public String getIpAddr() {
		return this.ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getSystemAdminId() {
		return this.systemAdminId;
	}

	public void setSystemAdminId(Integer systemAdminId) {
		this.systemAdminId = systemAdminId;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<Application> getApplications() {
		return this.applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public List<Export> getExports() {
		return this.exports;
	}

	public void setExports(List<Export> exports) {
		this.exports = exports;
	}

	public List<MountPoint> getMountPoints() {
		return this.mountPoints;
	}

	public void setMountPoints(List<MountPoint> mountPoints) {
		this.mountPoints = mountPoints;
	}

	public MountPoint addMountPoint(MountPoint mountPoint) {
		getMountPoints().add(mountPoint);
		mountPoint.setHost(this);

		return mountPoint;
	}

	public MountPoint removeMountPoint(MountPoint mountPoint) {
		getMountPoints().remove(mountPoint);
		mountPoint.setHost(null);

		return mountPoint;
	}

	public List<Share> getShares() {
		return this.shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public Share addShare(Share share) {
		getShares().add(share);
		share.setHost(this);

		return share;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setHost(null);

		return share;
	}

}