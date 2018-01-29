package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the share database table.
 * 
 */
@Entity
@Table(name="share")
public class Share implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="owner_user_corporate_id", nullable=false)
	private Integer ownerUserCorporateId;

	@Column(name="share_name", nullable=false, length=255)
	private String shareName;

	@Column(name="share_type", nullable=false, length=20)
	private String shareType;

	@Column(name="update_time")
	private Timestamp updateTime;

	//bi-directional many-to-one association to Host
	@ManyToOne
	@JoinColumn(name="host_id", nullable=false)
	private Host host;

	//bi-directional many-to-one association to Qtree
	@ManyToOne
	@JoinColumn(name="qtree_id", nullable=false)
	private Qtree qtree;

	public Share() {
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

	public Integer getOwnerUserCorporateId() {
		return this.ownerUserCorporateId;
	}

	public void setOwnerUserCorporateId(Integer ownerUserCorporateId) {
		this.ownerUserCorporateId = ownerUserCorporateId;
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

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Host getHost() {
		return this.host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	public Qtree getQtree() {
		return this.qtree;
	}

	public void setQtree(Qtree qtree) {
		this.qtree = qtree;
	}

}