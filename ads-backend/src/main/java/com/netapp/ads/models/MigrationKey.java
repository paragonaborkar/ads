package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the migration_key database table.
 * 
 */
@Entity
@Table(name="migration_key")
@NamedQuery(name="MigrationKey.findAll", query="SELECT m FROM MigrationKey m")
public class MigrationKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="migration_key")
	private String migrationKey;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	@Column(name="user_corporate_id")
	private int userCorporateId;

	public MigrationKey() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMigrationKey() {
		return this.migrationKey;
	}

	public void setMigrationKey(String migrationKey) {
		this.migrationKey = migrationKey;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getUserCorporateId() {
		return this.userCorporateId;
	}

	public void setUserCorporateId(int userCorporateId) {
		this.userCorporateId = userCorporateId;
	}

}