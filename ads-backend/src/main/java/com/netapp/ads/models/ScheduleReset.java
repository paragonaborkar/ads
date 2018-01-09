package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the schedule_reset database table.
 * 
 */
@Entity
@Table(name="schedule_reset")
@NamedQuery(name="ScheduleReset.findAll", query="SELECT s FROM ScheduleReset s")
public class ScheduleReset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="host_count")
	private int hostCount;

	@Column(name="jsession_id")
	private String jsessionId;

	@Column(name="schedule_id")
	private int scheduleId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	@Column(name="user_corporate_id")
	private int userCorporateId;

	public ScheduleReset() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getHostCount() {
		return this.hostCount;
	}

	public void setHostCount(int hostCount) {
		this.hostCount = hostCount;
	}

	public String getJsessionId() {
		return this.jsessionId;
	}

	public void setJsessionId(String jsessionId) {
		this.jsessionId = jsessionId;
	}

	public int getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getUserCorporateId() {
		return this.userCorporateId;
	}

	public void setUserCorporateId(int userCorporateId) {
		this.userCorporateId = userCorporateId;
	}

}