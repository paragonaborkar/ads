package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mst_emailing_date database table.
 * 
 */
@Entity
@Table(name="mst_emailing_date")
@NamedQuery(name="MstEmailingDate.findAll", query="SELECT m FROM MstEmailingDate m")
public class MstEmailingDate implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MstEmailingDatePK id;

	@Column(name="app_owner_user_corporate_id")
	private int appOwnerUserCorporateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="mailing_date_time")
	private Date mailingDateTime;

	@Temporal(TemporalType.DATE)
	@Column(name="migrate_week")
	private Date migrateWeek;

	@Column(name="system_admin_id")
	private int systemAdminId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public MstEmailingDate() {
	}

	public MstEmailingDatePK getId() {
		return this.id;
	}

	public void setId(MstEmailingDatePK id) {
		this.id = id;
	}

	public int getAppOwnerUserCorporateId() {
		return this.appOwnerUserCorporateId;
	}

	public void setAppOwnerUserCorporateId(int appOwnerUserCorporateId) {
		this.appOwnerUserCorporateId = appOwnerUserCorporateId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getMailingDateTime() {
		return this.mailingDateTime;
	}

	public void setMailingDateTime(Date mailingDateTime) {
		this.mailingDateTime = mailingDateTime;
	}

	public Date getMigrateWeek() {
		return this.migrateWeek;
	}

	public void setMigrateWeek(Date migrateWeek) {
		this.migrateWeek = migrateWeek;
	}

	public int getSystemAdminId() {
		return this.systemAdminId;
	}

	public void setSystemAdminId(int systemAdminId) {
		this.systemAdminId = systemAdminId;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}