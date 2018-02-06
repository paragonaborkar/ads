package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cutover database table.
 * 
 */
@Entity
@Table(name="cutover")
public class Cutover implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="cutover_name", nullable=false, length=60)
	private String cutoverName;

	@Column(name="day_of_week", nullable=false)
	private Integer dayOfWeek;

	@Column(name="migrate_time", nullable=false, length=36)
	private String migrateTime;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-one association to ChangeManagement
	@ManyToOne
	@JoinColumn(name="change_management_id")
	private ChangeManagement changeManagement;

	//bi-directional many-to-one association to Ical
	@ManyToOne
	@JoinColumn(name="cutover_ical_id")
	private Ical cutoverIcal;

	//bi-directional many-to-one association to Ical
	@ManyToOne
	@JoinColumn(name="prep_meeting_ical_id")
	private Ical prepMeetingIcal;

	//bi-directional many-to-one association to Schedule
	@ManyToOne
	@JoinColumn(name="schedule_id", nullable=false)
	private Schedule schedule;

	//bi-directional many-to-one association to UserNative
	@ManyToOne
	@JoinColumn(name="mig_spec_user_native_id")
	private UserNative userNative;

	//bi-directional many-to-one association to CutoverAssembly
	@OneToMany(mappedBy="cutover")
	private List<CutoverAssembly> cutoverAssemblies;

	public Cutover() {
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

	public String getCutoverName() {
		return this.cutoverName;
	}

	public void setCutoverName(String cutoverName) {
		this.cutoverName = cutoverName;
	}

	public Integer getDayOfWeek() {
		return this.dayOfWeek;
	}

	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getMigrateTime() {
		return this.migrateTime;
	}

	public void setMigrateTime(String migrateTime) {
		this.migrateTime = migrateTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public ChangeManagement getChangeManagement() {
		return this.changeManagement;
	}

	public void setChangeManagement(ChangeManagement changeManagement) {
		this.changeManagement = changeManagement;
	}

	public Ical getCutoverIcal() {
		return this.cutoverIcal;
	}

	public void setCutoverIcal(Ical cutoverIcal) {
		this.cutoverIcal = cutoverIcal;
	}

	public Ical getPrepMeetingIcal() {
		return this.prepMeetingIcal;
	}

	public void setPrepMeetingIcal(Ical prepMeetingIcal) {
		this.prepMeetingIcal = prepMeetingIcal;
	}

	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public UserNative getUserNative() {
		return this.userNative;
	}

	public void setUserNative(UserNative userNative) {
		this.userNative = userNative;
	}

	public List<CutoverAssembly> getCutoverAssemblies() {
		return this.cutoverAssemblies;
	}

	public void setCutoverAssemblies(List<CutoverAssembly> cutoverAssemblies) {
		this.cutoverAssemblies = cutoverAssemblies;
	}

	public CutoverAssembly addCutoverAssembly(CutoverAssembly cutoverAssembly) {
		getCutoverAssemblies().add(cutoverAssembly);
		cutoverAssembly.setCutover(this);

		return cutoverAssembly;
	}

	public CutoverAssembly removeCutoverAssembly(CutoverAssembly cutoverAssembly) {
		getCutoverAssemblies().remove(cutoverAssembly);
		cutoverAssembly.setCutover(null);

		return cutoverAssembly;
	}

}