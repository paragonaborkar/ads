package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the mst_emailing_date database table.
 * 
 */
@Entity
@Table(name="mst_emailing_date")
public class MstEmailingDate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="app_owner_user_corporate_id")
	private Integer appOwnerUserCorporateId;

	@Column(name="create_time")
	private Timestamp createTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="mailing_date_time", nullable=false)
	private Date mailingDateTime;

	@Temporal(TemporalType.DATE)
	@Column(name="migrate_week", nullable=false)
	private Date migrateWeek;

	@Column(name="system_admin_id")
	private Integer systemAdminId;

	@Column(name="update_time")
	private Timestamp updateTime;

	//bi-directional many-to-one association to MstEmailType
	@ManyToOne
	@JoinColumn(name="email_type_id", nullable=false)
	private MstEmailType mstEmailType;

	public MstEmailingDate() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAppOwnerUserCorporateId() {
		return this.appOwnerUserCorporateId;
	}

	public void setAppOwnerUserCorporateId(Integer appOwnerUserCorporateId) {
		this.appOwnerUserCorporateId = appOwnerUserCorporateId;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
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

	public MstEmailType getMstEmailType() {
		return this.mstEmailType;
	}

	public void setMstEmailType(MstEmailType mstEmailType) {
		this.mstEmailType = mstEmailType;
	}

}