package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;

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


	@Column(name="field_name", length=255)
	private String fieldName;

	@Column(name="field_prop", length=255)
	private String fieldProp;
	
	@Column(name="field_order")
	private Integer fieldOrder;

	@Column(name="field_visible", length=255)
	private Integer fieldVisible;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;
	
	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;


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

	
	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public String getFieldProp() {
		return this.fieldProp;
	}

	public void setFieldProp(String fieldProp) {
		this.fieldProp = fieldProp;
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

	public Preference getPreference() {
		return this.preference;
	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}

}