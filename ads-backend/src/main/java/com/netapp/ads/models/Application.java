package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the application database table.
 * 
 */
@Entity
@NamedQuery(name="Application.findAll", query="SELECT a FROM Application a")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="application_code")
	private String applicationCode;

	@Column(name="application_name")
	private String applicationName;

	private String archtype;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="information_owner")
	private String informationOwner;

	@Column(name="owner_user_corporate_id")
	private int ownerUserCorporateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public Application() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApplicationCode() {
		return this.applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public String getApplicationName() {
		return this.applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getArchtype() {
		return this.archtype;
	}

	public void setArchtype(String archtype) {
		this.archtype = archtype;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getInformationOwner() {
		return this.informationOwner;
	}

	public void setInformationOwner(String informationOwner) {
		this.informationOwner = informationOwner;
	}

	public int getOwnerUserCorporateId() {
		return this.ownerUserCorporateId;
	}

	public void setOwnerUserCorporateId(int ownerUserCorporateId) {
		this.ownerUserCorporateId = ownerUserCorporateId;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}