package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the extended_info_varchar_settings database table.
 * 
 */
@Entity
@Table(name="extended_info_varchar_settings")
public class ExtendedInfoVarcharSetting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="field_name", length=45)
	private String fieldName;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-one association to ExtendedInfoVarchar
	@OneToMany(mappedBy="extendedInfoVarcharSetting")
	private List<ExtendedInfoVarchar> extendedInfoVarchars;

	public ExtendedInfoVarcharSetting() {
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

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<ExtendedInfoVarchar> getExtendedInfoVarchars() {
		return this.extendedInfoVarchars;
	}

	public void setExtendedInfoVarchars(List<ExtendedInfoVarchar> extendedInfoVarchars) {
		this.extendedInfoVarchars = extendedInfoVarchars;
	}

	public ExtendedInfoVarchar addExtendedInfoVarchar(ExtendedInfoVarchar extendedInfoVarchar) {
		getExtendedInfoVarchars().add(extendedInfoVarchar);
		extendedInfoVarchar.setExtendedInfoVarcharSetting(this);

		return extendedInfoVarchar;
	}

	public ExtendedInfoVarchar removeExtendedInfoVarchar(ExtendedInfoVarchar extendedInfoVarchar) {
		getExtendedInfoVarchars().remove(extendedInfoVarchar);
		extendedInfoVarchar.setExtendedInfoVarcharSetting(null);

		return extendedInfoVarchar;
	}

}