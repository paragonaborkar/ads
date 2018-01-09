package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the system_admin database table.
 * 
 */
@Entity
@Table(name="system_admin")
@NamedQuery(name="SystemAdmin.findAll", query="SELECT s FROM SystemAdmin s")
public class SystemAdmin implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SystemAdminPK id;

	@Column(name="contact_type")
	private String contactType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="mailing_list")
	private String mailingList;

	private String note;

	@Column(name="system_admin")
	private String systemAdmin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public SystemAdmin() {
	}

	public SystemAdminPK getId() {
		return this.id;
	}

	public void setId(SystemAdminPK id) {
		this.id = id;
	}

	public String getContactType() {
		return this.contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMailingList() {
		return this.mailingList;
	}

	public void setMailingList(String mailingList) {
		this.mailingList = mailingList;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getSystemAdmin() {
		return this.systemAdmin;
	}

	public void setSystemAdmin(String systemAdmin) {
		this.systemAdmin = systemAdmin;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}