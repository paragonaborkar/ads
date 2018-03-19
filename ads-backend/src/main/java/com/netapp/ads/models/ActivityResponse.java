package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Link;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;


/**
 * The persistent class for the activity_response database table.
 * 
 */
@Entity
@Table(name="activity_response")
public class ActivityResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	@Autowired
//	RepositoryEntityLinks entityLinks;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="is_owner", nullable=false)
	private boolean isOwner;

	@Column(name="is_presumed", nullable=false)
	private boolean isPresumed;

	@Column(name="owner_user_corporate_id", nullable=false)
	private Integer ownerUserCorporateId;

	@Column(name="suggested_owner_user_corporate_id")
	private Integer suggestedOwnerUserCorporateId;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;
	
	@Column(name="best_number", length=100)
	private String bestNumber;

	@Column(name="call_me", nullable=false)
	private boolean callMe;

	@Column(name="call_reason", length=2048)
	private String callReason;

	//bi-directional many-to-one association to Activity
	@ManyToOne
	@JoinColumn(name="activity_id", nullable=false)
	private Activity activity;

	public ActivityResponse() {
	}
	
/*	@Transient
	private String linkToSelf;
	
	@Transient
	public String getLinkToSelf() {
		return this.linkToSelf.toString();
	}
	@Transient
	public void setLinkToSelf() {
		this.linkToSelf = entityLinks.linkToSingleResource(ActivityResponse.class, this.getId()).toString();
	}*/
	

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

	public boolean getIsOwner() {
		return this.isOwner;
	}

	public void setIsOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	public boolean getIsPresumed() {
		return this.isPresumed;
	}

	public void setIsPresumed(boolean isPresumed) {
		this.isPresumed = isPresumed;
	}

	public Integer getOwnerUserCorporateId() {
		return this.ownerUserCorporateId;
	}

	public void setOwnerUserCorporateId(Integer ownerUserCorporateId) {
		this.ownerUserCorporateId = ownerUserCorporateId;
	}

	public Integer getSuggestedOwnerUserCorporateId() {
		return this.suggestedOwnerUserCorporateId;
	}

	public void setSuggestedOwnerUserCorporateId(Integer suggestedOwnerUserCorporateId) {
		this.suggestedOwnerUserCorporateId = suggestedOwnerUserCorporateId;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	public String getBestNumber() {
		return this.bestNumber;
	}

	public void setBestNumber(String bestNumber) {
		this.bestNumber = bestNumber;
	}

	public boolean getCallMe() {
		return this.callMe;
	}

	public void setCallMe(boolean callMe) {
		this.callMe = callMe;
	}

	public String getCallReason() {
		return this.callReason;
	}

	public void setCallReason(String callReason) {
		this.callReason = callReason;
	}	

}