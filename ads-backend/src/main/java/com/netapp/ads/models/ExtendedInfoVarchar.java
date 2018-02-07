package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the extended_info_varchar database table.
 * 
 */
@Entity
@Table(name="extended_info_varchar")
public class ExtendedInfoVarchar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="field_value", length=255)
	private String fieldValue;

	@Column(name="row_id")
	private Integer rowId;

	@Column(name="table_name", length=45)
	private String tableName;

	@Column(name="update_time")
	private Timestamp updateTime;

	//bi-directional many-to-one association to ExtendedInfoVarcharSetting
	@ManyToOne
	@JoinColumn(name="field_id")
	private ExtendedInfoVarcharSetting extendedInfoVarcharSetting;

	public ExtendedInfoVarchar() {
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

	public String getFieldValue() {
		return this.fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public Integer getRowId() {
		return this.rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public ExtendedInfoVarcharSetting getExtendedInfoVarcharSetting() {
		return this.extendedInfoVarcharSetting;
	}

	public void setExtendedInfoVarcharSetting(ExtendedInfoVarcharSetting extendedInfoVarcharSetting) {
		this.extendedInfoVarcharSetting = extendedInfoVarcharSetting;
	}

}