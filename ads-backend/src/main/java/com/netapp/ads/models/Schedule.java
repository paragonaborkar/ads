package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the schedule database table.
 * 
 */
@Entity
@NamedQuery(name="Schedule.findAll", query="SELECT s FROM Schedule s")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="host_connection_booked")
	private int hostConnectionBooked;

	@Column(name="host_connection_limit")
	private int hostConnectionLimit;

	@Column(name="host_connection_pending")
	private int hostConnectionPending;

	@Column(name="migration_booked")
	private int migrationBooked;

	@Column(name="migration_limit")
	private int migrationLimit;

	@Column(name="migration_pending")
	private int migrationPending;

	@Column(name="schedule_status")
	private String scheduleStatus;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Temporal(TemporalType.DATE)
	@Column(name="week_date")
	private Date weekDate;

	public Schedule() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getHostConnectionBooked() {
		return this.hostConnectionBooked;
	}

	public void setHostConnectionBooked(int hostConnectionBooked) {
		this.hostConnectionBooked = hostConnectionBooked;
	}

	public int getHostConnectionLimit() {
		return this.hostConnectionLimit;
	}

	public void setHostConnectionLimit(int hostConnectionLimit) {
		this.hostConnectionLimit = hostConnectionLimit;
	}

	public int getHostConnectionPending() {
		return this.hostConnectionPending;
	}

	public void setHostConnectionPending(int hostConnectionPending) {
		this.hostConnectionPending = hostConnectionPending;
	}

	public int getMigrationBooked() {
		return this.migrationBooked;
	}

	public void setMigrationBooked(int migrationBooked) {
		this.migrationBooked = migrationBooked;
	}

	public int getMigrationLimit() {
		return this.migrationLimit;
	}

	public void setMigrationLimit(int migrationLimit) {
		this.migrationLimit = migrationLimit;
	}

	public int getMigrationPending() {
		return this.migrationPending;
	}

	public void setMigrationPending(int migrationPending) {
		this.migrationPending = migrationPending;
	}

	public String getScheduleStatus() {
		return this.scheduleStatus;
	}

	public void setScheduleStatus(String scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Date getWeekDate() {
		return this.weekDate;
	}

	public void setWeekDate(Date weekDate) {
		this.weekDate = weekDate;
	}

}