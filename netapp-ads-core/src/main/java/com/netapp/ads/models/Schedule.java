package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the schedule database table.
 * 
 */
@Entity
@Table(name="schedule")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="host_connection_booked", nullable=false)
	private Integer hostConnectionBooked;

	@Column(name="host_connection_limit")
	private Integer hostConnectionLimit;

	@Column(name="host_connection_pending")
	private Integer hostConnectionPending;

	@Column(name="migration_booked")
	private Integer migrationBooked;

	@Column(name="migration_limit")
	private Integer migrationLimit;

	@Column(name="migration_pending")
	private Integer migrationPending;

	@Column(name="schedule_status", length=45)
	private String scheduleStatus;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	@Temporal(TemporalType.DATE)
	@Column(name="week_date", nullable=false)
	private Date weekDate;

	//bi-directional many-to-one association to Cutover
	@OneToMany(mappedBy="schedule")
	private List<Cutover> cutovers;

	//bi-directional many-to-one association to ScheduleReset
	@OneToMany(mappedBy="schedule")
	private List<ScheduleReset> scheduleResets;

	public Schedule() {
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

	public Integer getHostConnectionBooked() {
		return this.hostConnectionBooked;
	}

	public void setHostConnectionBooked(Integer hostConnectionBooked) {
		this.hostConnectionBooked = hostConnectionBooked;
	}

	public Integer getHostConnectionLimit() {
		return this.hostConnectionLimit;
	}

	public void setHostConnectionLimit(Integer hostConnectionLimit) {
		this.hostConnectionLimit = hostConnectionLimit;
	}

	public Integer getHostConnectionPending() {
		return this.hostConnectionPending;
	}

	public void setHostConnectionPending(Integer hostConnectionPending) {
		this.hostConnectionPending = hostConnectionPending;
	}

	public Integer getMigrationBooked() {
		return this.migrationBooked;
	}

	public void setMigrationBooked(Integer migrationBooked) {
		this.migrationBooked = migrationBooked;
	}

	public Integer getMigrationLimit() {
		return this.migrationLimit;
	}

	public void setMigrationLimit(Integer migrationLimit) {
		this.migrationLimit = migrationLimit;
	}

	public Integer getMigrationPending() {
		return this.migrationPending;
	}

	public void setMigrationPending(Integer migrationPending) {
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

	public List<Cutover> getCutovers() {
		return this.cutovers;
	}

	public void setCutovers(List<Cutover> cutovers) {
		this.cutovers = cutovers;
	}

	public Cutover addCutover(Cutover cutover) {
		getCutovers().add(cutover);
		cutover.setSchedule(this);

		return cutover;
	}

	public Cutover removeCutover(Cutover cutover) {
		getCutovers().remove(cutover);
		cutover.setSchedule(null);

		return cutover;
	}

	public List<ScheduleReset> getScheduleResets() {
		return this.scheduleResets;
	}

	public void setScheduleResets(List<ScheduleReset> scheduleResets) {
		this.scheduleResets = scheduleResets;
	}

	public ScheduleReset addScheduleReset(ScheduleReset scheduleReset) {
		getScheduleResets().add(scheduleReset);
		scheduleReset.setSchedule(this);

		return scheduleReset;
	}

	public ScheduleReset removeScheduleReset(ScheduleReset scheduleReset) {
		getScheduleResets().remove(scheduleReset);
		scheduleReset.setSchedule(null);

		return scheduleReset;
	}

}