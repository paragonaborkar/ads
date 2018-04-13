package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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

	@Column(name="owner_user_corporate_id", insertable=false, updatable=false)
	private Integer ownerUserCorporateId;
		
	@Column(name="email_count")
	private Integer emailCount;
	
	@Column(name="email_date")
	private Timestamp emailDate;

	
	@ManyToOne
	@JoinColumn(name="owner_user_corporate_id", nullable=true)
	private UserCorporate ownerUserCorporate;


	@ManyToOne
	@JoinColumn(name="suggested_owner_user_corporate_id", nullable=true)
	private UserCorporate suggestedOwnerUserCorporate;
		
		

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

//	public void setOwnerUserCorporateId(Integer ownerUserCorporateId) {
//		this.ownerUserCorporateId = ownerUserCorporateId;
//	}
	
	public UserCorporate getOwnerUserCorporate() {
		return this.ownerUserCorporate;
	}

	public void setOwnerUserCorporate(UserCorporate ownerUserCorporate) {
		this.ownerUserCorporate = ownerUserCorporate;
	}

/*	public Integer getSuggestedOwnerUserCorporateId() {
		return this.suggestedOwnerUserCorporateId;
	}

	public void setSuggestedOwnerUserCorporateId(Integer suggestedOwnerUserCorporateId) {
		this.suggestedOwnerUserCorporateId = suggestedOwnerUserCorporateId;
	}*/
	
	public UserCorporate getSuggestedOwnerUserCorporate() {
		return this.suggestedOwnerUserCorporate;
	}

	public void setSuggestedOwnerUserCorporate(UserCorporate suggestedOwnerUserCorporate) {
		this.suggestedOwnerUserCorporate = suggestedOwnerUserCorporate;
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

	public Integer getEmailCount() {
		return this.emailCount;
	}

	public void setEmailCount(Integer emailCount) {
		this.emailCount = emailCount;
	}
	
	public Timestamp getEmailDate() {
		return this.emailDate;
	}

	public void setEmailDate(Timestamp emailDate) {
		this.emailDate = emailDate;
	}
	
}