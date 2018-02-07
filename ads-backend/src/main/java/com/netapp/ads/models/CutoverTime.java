package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the cutover_time database table.
 * 
 */
@Entity
@Table(name="cutover_time")
public class CutoverTime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="change_mount_begin_time")
	private Date changeMountBeginTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="change_mount_end_time")
	private Date changeMountEndTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="complete_replication_begin_time")
	private Date completeReplicationBeginTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="complete_replication_end_time")
	private Date completeReplicationEndTime;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_app_begin_time")
	private Date startAppBeginTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_app_end_time")
	private Date startAppEndTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_db_begin_time")
	private Date startDbBeginTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_db_end_time")
	private Date startDbEndTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="stop_app_begin_time")
	private Date stopAppBeginTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="stop_app_end_time")
	private Date stopAppEndTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="stop_db_begin_time")
	private Date stopDbBeginTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="stop_db_end_time")
	private Date stopDbEndTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="unmount_volume_begin_time")
	private Date unmountVolumeBeginTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="unmount_volume_end_time")
	private Date unmountVolumeEndTime;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="validate_complete_begin_time")
	private Date validateCompleteBeginTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="validate_complete_end_time")
	private Date validateCompleteEndTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="validate_db_begin_time")
	private Date validateDbBeginTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="validate_db_end_time")
	private Date validateDbEndTime;

	//bi-directional many-to-one association to CutoverAssembly
	@ManyToOne
	@JoinColumn(name="cutover_assembly_id", nullable=false)
	private CutoverAssembly cutoverAssembly;

	public CutoverTime() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getChangeMountBeginTime() {
		return this.changeMountBeginTime;
	}

	public void setChangeMountBeginTime(Date changeMountBeginTime) {
		this.changeMountBeginTime = changeMountBeginTime;
	}

	public Date getChangeMountEndTime() {
		return this.changeMountEndTime;
	}

	public void setChangeMountEndTime(Date changeMountEndTime) {
		this.changeMountEndTime = changeMountEndTime;
	}

	public Date getCompleteReplicationBeginTime() {
		return this.completeReplicationBeginTime;
	}

	public void setCompleteReplicationBeginTime(Date completeReplicationBeginTime) {
		this.completeReplicationBeginTime = completeReplicationBeginTime;
	}

	public Date getCompleteReplicationEndTime() {
		return this.completeReplicationEndTime;
	}

	public void setCompleteReplicationEndTime(Date completeReplicationEndTime) {
		this.completeReplicationEndTime = completeReplicationEndTime;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Date getStartAppBeginTime() {
		return this.startAppBeginTime;
	}

	public void setStartAppBeginTime(Date startAppBeginTime) {
		this.startAppBeginTime = startAppBeginTime;
	}

	public Date getStartAppEndTime() {
		return this.startAppEndTime;
	}

	public void setStartAppEndTime(Date startAppEndTime) {
		this.startAppEndTime = startAppEndTime;
	}

	public Date getStartDbBeginTime() {
		return this.startDbBeginTime;
	}

	public void setStartDbBeginTime(Date startDbBeginTime) {
		this.startDbBeginTime = startDbBeginTime;
	}

	public Date getStartDbEndTime() {
		return this.startDbEndTime;
	}

	public void setStartDbEndTime(Date startDbEndTime) {
		this.startDbEndTime = startDbEndTime;
	}

	public Date getStopAppBeginTime() {
		return this.stopAppBeginTime;
	}

	public void setStopAppBeginTime(Date stopAppBeginTime) {
		this.stopAppBeginTime = stopAppBeginTime;
	}

	public Date getStopAppEndTime() {
		return this.stopAppEndTime;
	}

	public void setStopAppEndTime(Date stopAppEndTime) {
		this.stopAppEndTime = stopAppEndTime;
	}

	public Date getStopDbBeginTime() {
		return this.stopDbBeginTime;
	}

	public void setStopDbBeginTime(Date stopDbBeginTime) {
		this.stopDbBeginTime = stopDbBeginTime;
	}

	public Date getStopDbEndTime() {
		return this.stopDbEndTime;
	}

	public void setStopDbEndTime(Date stopDbEndTime) {
		this.stopDbEndTime = stopDbEndTime;
	}

	public Date getUnmountVolumeBeginTime() {
		return this.unmountVolumeBeginTime;
	}

	public void setUnmountVolumeBeginTime(Date unmountVolumeBeginTime) {
		this.unmountVolumeBeginTime = unmountVolumeBeginTime;
	}

	public Date getUnmountVolumeEndTime() {
		return this.unmountVolumeEndTime;
	}

	public void setUnmountVolumeEndTime(Date unmountVolumeEndTime) {
		this.unmountVolumeEndTime = unmountVolumeEndTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Date getValidateCompleteBeginTime() {
		return this.validateCompleteBeginTime;
	}

	public void setValidateCompleteBeginTime(Date validateCompleteBeginTime) {
		this.validateCompleteBeginTime = validateCompleteBeginTime;
	}

	public Date getValidateCompleteEndTime() {
		return this.validateCompleteEndTime;
	}

	public void setValidateCompleteEndTime(Date validateCompleteEndTime) {
		this.validateCompleteEndTime = validateCompleteEndTime;
	}

	public Date getValidateDbBeginTime() {
		return this.validateDbBeginTime;
	}

	public void setValidateDbBeginTime(Date validateDbBeginTime) {
		this.validateDbBeginTime = validateDbBeginTime;
	}

	public Date getValidateDbEndTime() {
		return this.validateDbEndTime;
	}

	public void setValidateDbEndTime(Date validateDbEndTime) {
		this.validateDbEndTime = validateDbEndTime;
	}

	public CutoverAssembly getCutoverAssembly() {
		return this.cutoverAssembly;
	}

	public void setCutoverAssembly(CutoverAssembly cutoverAssembly) {
		this.cutoverAssembly = cutoverAssembly;
	}

}