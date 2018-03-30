package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ical database table.
 * 
 */
@Entity
@Table(name="ical")
public class Ical implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Lob
	private String attendees;

	@Column(length=120)
	private String bridge;

	@Column(name="change_mgmt_url", length=255)
	private String changeMgmtUrl;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_meeting", nullable=false)
	private Date dateOfMeeting;

	@Column(length=1024)
	private String description;

	@Column(name="meeting_url", length=255)
	private String meetingUrl;

	@Column(length=255)
	private String notes;

	@Column(name="sender_email", nullable=false, length=255)
	private String senderEmail;

	@Column(name="time_of_meeting", nullable=false)
	private Time timeOfMeeting;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-one association to Cutover
	@OneToMany(mappedBy="cutoverIcal")
	private List<Cutover> iCalCutovers;

	//bi-directional many-to-one association to Cutover
	@OneToMany(mappedBy="prepMeetingIcal")
	private List<Cutover> prepMeetingIcalCutovers;

	//bi-directional many-to-one association to MigrationCutoverEvent
	@ManyToOne
	@JoinColumn(name="migration_cutover_event_id", nullable=false)
	private MigrationCutoverEvent migrationCutoverEvent;

	public Ical() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAttendees() {
		return this.attendees;
	}

	public void setAttendees(String attendees) {
		this.attendees = attendees;
	}

	public String getBridge() {
		return this.bridge;
	}

	public void setBridge(String bridge) {
		this.bridge = bridge;
	}

	public String getChangeMgmtUrl() {
		return this.changeMgmtUrl;
	}

	public void setChangeMgmtUrl(String changeMgmtUrl) {
		this.changeMgmtUrl = changeMgmtUrl;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Date getDateOfMeeting() {
		return this.dateOfMeeting;
	}

	public void setDateOfMeeting(Date dateOfMeeting) {
		this.dateOfMeeting = dateOfMeeting;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeetingUrl() {
		return this.meetingUrl;
	}

	public void setMeetingUrl(String meetingUrl) {
		this.meetingUrl = meetingUrl;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getSenderEmail() {
		return this.senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public Time getTimeOfMeeting() {
		return this.timeOfMeeting;
	}

	public void setTimeOfMeeting(Time timeOfMeeting) {
		this.timeOfMeeting = timeOfMeeting;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<Cutover> getICalCutovers() {
		return this.iCalCutovers;
	}

	public void setICalCutovers(List<Cutover> cutovers) {
		this.iCalCutovers = cutovers;
	}

	public Cutover addICalCutover(Cutover cutover) {
		getICalCutovers().add(cutover);
		cutover.setCutoverIcal(this);

		return cutover;
	}

	public Cutover removeICalCutover(Cutover cutover) {
		getICalCutovers().remove(cutover);
		cutover.setCutoverIcal(null);

		return cutover;
	}

	public List<Cutover> getPrepMeetingIcalCutovers() {
		return this.prepMeetingIcalCutovers;
	}

	public void setPrepMeetingIcalCutovers(List<Cutover> cutovers) {
		this.prepMeetingIcalCutovers = cutovers;
	}

	public Cutover addCutovers2(Cutover cutover) {
		getPrepMeetingIcalCutovers().add(cutover);
		cutover.setPrepMeetingIcal(this);

		return cutover;
	}

	public Cutover removeCutovers2(Cutover cutover) {
		getPrepMeetingIcalCutovers().remove(cutover);
		cutover.setPrepMeetingIcal(null);

		return cutover;
	}

	public MigrationCutoverEvent getMigrationCutoverEvent() {
		return this.migrationCutoverEvent;
	}

	public void setMigrationCutoverEvent(MigrationCutoverEvent migrationCutoverEvent) {
		this.migrationCutoverEvent = migrationCutoverEvent;
	}

}