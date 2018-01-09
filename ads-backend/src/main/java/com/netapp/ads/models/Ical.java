package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the ical database table.
 * 
 */
@Entity
@NamedQuery(name="Ical.findAll", query="SELECT i FROM Ical i")
public class Ical implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IcalPK id;

	@Lob
	private String attendees;

	private String bridge;

	@Column(name="change_mgmt_url")
	private String changeMgmtUrl;

	@Column(name="create_time")
	private Timestamp createTime;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_meeting")
	private Date dateOfMeeting;

	private String description;

	@Column(name="meeting_url")
	private String meetingUrl;

	private String notes;

	@Column(name="sender_email")
	private String senderEmail;

	@Column(name="time_of_meeting")
	private Time timeOfMeeting;

	@Column(name="update_time")
	private Timestamp updateTime;

	//bi-directional many-to-one association to MigrationCutoverEvent
	@ManyToOne
	@JoinColumn(name="migration_cutover_event_id", insertable = false, updatable = false)
	private MigrationCutoverEvent migrationCutoverEvent;

	public Ical() {
	}

	public IcalPK getId() {
		return this.id;
	}

	public void setId(IcalPK id) {
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

	public MigrationCutoverEvent getMigrationCutoverEvent() {
		return this.migrationCutoverEvent;
	}

	public void setMigrationCutoverEvent(MigrationCutoverEvent migrationCutoverEvent) {
		this.migrationCutoverEvent = migrationCutoverEvent;
	}

}