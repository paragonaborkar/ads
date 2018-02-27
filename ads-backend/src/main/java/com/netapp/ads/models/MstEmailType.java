package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the mst_email_type database table.
 * 
 */
@Entity
@Table(name="mst_email_type")
public class MstEmailType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="email_type", nullable=false, length=45)
	private String emailType;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-one association to MstEmailingDate
	@OneToMany(mappedBy="mstEmailType")
	private List<MstEmailingDate> mstEmailingDates;

	public MstEmailType() {
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

	public String getEmailType() {
		return this.emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<MstEmailingDate> getMstEmailingDates() {
		return this.mstEmailingDates;
	}

	public void setMstEmailingDates(List<MstEmailingDate> mstEmailingDates) {
		this.mstEmailingDates = mstEmailingDates;
	}

	public MstEmailingDate addMstEmailingDate(MstEmailingDate mstEmailingDate) {
		getMstEmailingDates().add(mstEmailingDate);
		mstEmailingDate.setMstEmailType(this);

		return mstEmailingDate;
	}

	public MstEmailingDate removeMstEmailingDate(MstEmailingDate mstEmailingDate) {
		getMstEmailingDates().remove(mstEmailingDate);
		mstEmailingDate.setMstEmailType(null);

		return mstEmailingDate;
	}

}