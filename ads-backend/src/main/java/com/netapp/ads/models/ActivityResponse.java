package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the activity_response database table.
 * 
 */
@Entity
@Table(name="activity_response")
@NamedQuery(name="ActivityResponse.findAll", query="SELECT a FROM ActivityResponse a")
public class ActivityResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ActivityResponsePK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="is_owner")
	private byte isOwner;

	@Column(name="is_presumed")
	private byte isPresumed;

	@Column(name="owner_user_corporate_id")
	private int ownerUserCorporateId;

	@Column(name="suggested_owner_user_corporate_id")
	private int suggestedOwnerUserCorporateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public ActivityResponse() {
	}

	public ActivityResponsePK getId() {
		return this.id;
	}

	public void setId(ActivityResponsePK id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public byte getIsOwner() {
		return this.isOwner;
	}

	public void setIsOwner(byte isOwner) {
		this.isOwner = isOwner;
	}

	public byte getIsPresumed() {
		return this.isPresumed;
	}

	public void setIsPresumed(byte isPresumed) {
		this.isPresumed = isPresumed;
	}

	public int getOwnerUserCorporateId() {
		return this.ownerUserCorporateId;
	}

	public void setOwnerUserCorporateId(int ownerUserCorporateId) {
		this.ownerUserCorporateId = ownerUserCorporateId;
	}

	public int getSuggestedOwnerUserCorporateId() {
		return this.suggestedOwnerUserCorporateId;
	}

	public void setSuggestedOwnerUserCorporateId(int suggestedOwnerUserCorporateId) {
		this.suggestedOwnerUserCorporateId = suggestedOwnerUserCorporateId;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}