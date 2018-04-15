package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the sys_field_value database table.
 * 
 */
@Entity
@Table(name = "sys_field_value")
public class SysFieldValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;


	@Column(name = "field_name", nullable = true, length = 50)
	private String fieldName;
		
	@Column(name = "field_value", nullable = true, length = 50)
	private String fieldValue;

	@Column(name = "field_cascade_name", nullable = true, length = 50)
	private String fieldCascadeName;
	
	@Column(name = "field_cascade_value", nullable = true, length = 50)
	private String fieldCascadeValue;
	

	public SysFieldValue() {
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

	public void setPropertyName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	
	public String getFieldValue() {
		return this.fieldValue;
	}

	public void setPropertyValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	
	public String getFieldCascadeName() {
		return this.fieldCascadeName;
	}

	public void setFieldCascadeName(String fieldCascadeName) {
		this.fieldCascadeName = fieldCascadeName;
	}
	
	public String getFieldCascadeValue() {
		return this.fieldCascadeValue;
	}

	public void setFieldCascadeValue(String fieldCascadeValue) {
		this.fieldCascadeValue = fieldCascadeValue;
	}


}