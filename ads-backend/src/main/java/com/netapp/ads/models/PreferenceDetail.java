package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the preference_details database table.
 * 
 */
@Entity
@Table(name="preference_details")
@NamedQuery(name="PreferenceDetail.findAll", query="SELECT p FROM PreferenceDetail p")
public class PreferenceDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="corp_user_id")
	private Integer corpUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Column(name="field_name")
	private String fieldName;

	@Column(name="field_order")
	private Integer fieldOrder;

	@Column(name="field_visible")
	private byte fieldVisible;

	@Column(name="native_user_id")
	private Integer nativeUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-one association to Preference
	@ManyToOne
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

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
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

	public byte getFieldVisible() {
		return this.fieldVisible;
	}

	public void setFieldVisible(byte fieldVisible) {
		this.fieldVisible = fieldVisible;
	}

	public Integer getNativeUserId() {
		return this.nativeUserId;
	}

	public void setNativeUserId(Integer nativeUserId) {
		this.nativeUserId = nativeUserId;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Preference getPreference() {
		return this.preference;
	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}

}