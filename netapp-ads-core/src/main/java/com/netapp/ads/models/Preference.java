package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the preference database table.
 * 
 */
@Entity
@Table(name="preference")
public class Preference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;
	
	@Column(name="corp_user_id")
	private Integer corpUserId;

	@Column(name="native_user_id")
	private Integer nativeUserId;
	

	@Column(name="page_name", length=255)
	private String pageName;

	@Column(name="preference_type", length=255)
	private String preferenceType;

	
	
	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;
	
	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;
	

	//bi-directional many-to-one association to PreferenceDetail
	@OneToMany(mappedBy="preference")
	private List<PreferenceDetail> preferenceDetails;

	public Preference() {
	}

	public Integer getId() {
		return this.id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCorpUserId() {
		return this.corpUserId;
	}

	public void setCorpUserId(Integer corpUserId) {
		this.corpUserId = corpUserId;
	}
	
	public Integer getNativeUserId() {
		return this.nativeUserId;
	}

	public void setNativeUserId(Integer nativeUserId) {
		this.nativeUserId = nativeUserId;
	}



	public String getPageName() {
		return this.pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPreferenceType() {
		return this.preferenceType;
	}

	public void setPreferenceType(String preferenceType) {
		this.preferenceType = preferenceType;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	public List<PreferenceDetail> getPreferenceDetails() {
		return this.preferenceDetails;
	}

	public void setPreferenceDetails(List<PreferenceDetail> preferenceDetails) {
		this.preferenceDetails = preferenceDetails;
	}

	public PreferenceDetail addPreferenceDetail(PreferenceDetail preferenceDetail) {
		getPreferenceDetails().add(preferenceDetail);
		preferenceDetail.setPreference(this);

		return preferenceDetail;
	}

	public PreferenceDetail removePreferenceDetail(PreferenceDetail preferenceDetail) {
		getPreferenceDetails().remove(preferenceDetail);
		preferenceDetail.setPreference(null);

		return preferenceDetail;
	}

}