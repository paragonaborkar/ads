package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mount_point database table.
 * 
 */
@Entity
@Table(name="mount_point")
@NamedQuery(name="MountPoint.findAll", query="SELECT m FROM MountPoint m")
public class MountPoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MountPointPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="inventory_number")
	private String inventoryNumber;

	@Column(name="mount_location")
	private String mountLocation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public MountPoint() {
	}

	public MountPointPK getId() {
		return this.id;
	}

	public void setId(MountPointPK id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getInventoryNumber() {
		return this.inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public String getMountLocation() {
		return this.mountLocation;
	}

	public void setMountLocation(String mountLocation) {
		this.mountLocation = mountLocation;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}