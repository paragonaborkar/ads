package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the share database table.
 * 
 */
@Entity
@NamedQuery(name="Share.findAll", query="SELECT s FROM Share s")
public class Share implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SharePK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="owner_user_corporate_id")
	private int ownerUserCorporateId;

	@Column(name="qtree_id")
	private int qtreeId;

	@Column(name="share_name")
	private String shareName;

	@Column(name="share_type")
	private String shareType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public Share() {
	}

	public SharePK getId() {
		return this.id;
	}

	public void setId(SharePK id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getOwnerUserCorporateId() {
		return this.ownerUserCorporateId;
	}

	public void setOwnerUserCorporateId(int ownerUserCorporateId) {
		this.ownerUserCorporateId = ownerUserCorporateId;
	}

	public int getQtreeId() {
		return this.qtreeId;
	}

	public void setQtreeId(int qtreeId) {
		this.qtreeId = qtreeId;
	}

	public String getShareName() {
		return this.shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

	public String getShareType() {
		return this.shareType;
	}

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}