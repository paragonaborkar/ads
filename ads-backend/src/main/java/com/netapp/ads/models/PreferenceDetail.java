package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the preference_detail database table.
 * 
 */
@Entity
@Table(name="preference_detail")
public class PreferenceDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="corp_user_id")
	private Integer corpUserId;

	@Column(name="create_time", insertable=false, updatable=false)
	private Date createTime;

	@Column(name="field_name", length=255)
	private String fieldName;

	@Column(name="field_order")
	private Integer fieldOrder;

	@Column(name="field_visible", length=255)
	private Integer fieldVisible;

	@Column(name="native_user_id")
	private Integer nativeUserId;

	@Column(name="update_time", insertable=false, updatable=false)
	private Date updateTime;

	//bi-directional many-to-one association to Preference
	@ManyToOne
	@JoinColumn(name="preference_id")
	private Preference preference;

	public PreferenceDetail() {
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

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createdOn) {
		this.createTime = createdOn;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Integer getFieldOrder() {
		return this.fieldOrder;
	}

	public void setFieldOrder(Integer fieldOrder) {
		this.fieldOrder = fieldOrder;
	}

	public int getFieldVisible() {
		return this.fieldVisible;
	}

	public void setFieldVisible(int fieldVisible) {
		this.fieldVisible = fieldVisible;
	}

	public Integer getNativeUserId() {
		return this.nativeUserId;
	}

	public void setNativeUserId(Integer nativeUserId) {
		this.nativeUserId = nativeUserId;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updatedOn) {
		this.updateTime = updatedOn;
	}

	public Preference getPreference() {
		return this.preference;
	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}

}