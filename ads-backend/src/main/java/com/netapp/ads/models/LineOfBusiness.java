package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the line_of_business database table.
 * 
 */
@Entity
@Table(name="line_of_business")
public class LineOfBusiness implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="liason_contact_number", nullable=true, length=255)
	private String liasonContactNumber;

	@Column(name="liason_email", nullable=true, length=255)
	private String liasonEmail;

	@Column(name="liason_first_name", nullable=true, length=255)
	private String liasonFirstName;

	@Column(name="liason_last_name", nullable=true, length=255)
	private String liasonLastName;

	@Column(name="liason_user_name", nullable=true, length=255)
	private String liasonUserName;

	@Column(name="lob_name", nullable=false, length=255)
	private String lobName;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	//bi-directional many-to-one association to Export
	@OneToMany(mappedBy="lineOfBusiness")
	private List<Export> exports = new ArrayList<Export>();

	//bi-directional many-to-many association to Activity
	@ManyToMany
	@JoinTable(
		name="activity_lob_x_ref"
		, joinColumns={
			@JoinColumn(name="lob_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="activity_id", nullable=false)
			}
		)
	private List<Activity> activitiesLobXRef = new ArrayList<Activity>();

	//bi-directional many-to-many association to Activity
	@ManyToMany
	@JoinTable(
		name="activity_presumed_lob_x_ref"
		, joinColumns={
			@JoinColumn(name="lob_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="activity_id", nullable=false)
			}
		)
	private List<Activity> activitiesPresumedLobXRef = new ArrayList<Activity>();

	//bi-directional many-to-many association to Application
	@ManyToMany
	@JoinTable(
		name="application_lob_x_ref"
		, joinColumns={
			@JoinColumn(name="lob_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="application_id", nullable=false)
			}
		)
	private List<Application> applications = new ArrayList<Application>();

	public LineOfBusiness() {
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

	public String getLiasonContactNumber() {
		return this.liasonContactNumber;
	}

	public void setLiasonContactNumber(String liasonContactNumber) {
		this.liasonContactNumber = liasonContactNumber;
	}

	public String getLiasonEmail() {
		return this.liasonEmail;
	}

	public void setLiasonEmail(String liasonEmail) {
		this.liasonEmail = liasonEmail;
	}

	public String getLiasonFirstName() {
		return this.liasonFirstName;
	}

	public void setLiasonFirstName(String liasonFirstName) {
		this.liasonFirstName = liasonFirstName;
	}

	public String getLiasonLastName() {
		return this.liasonLastName;
	}

	public void setLiasonLastName(String liasonLastName) {
		this.liasonLastName = liasonLastName;
	}

	public String getLiasonUserName() {
		return this.liasonUserName;
	}

	public void setLiasonUserName(String liasonUserName) {
		this.liasonUserName = liasonUserName;
	}

	public String getLobName() {
		return this.lobName;
	}

	public void setLobName(String lobName) {
		this.lobName = lobName;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<Export> getExports() {
		return this.exports;
	}

	public void setExports(List<Export> exports) {
		this.exports = exports;
	}

	public Export addExport(Export export) {
		getExports().add(export);
		export.setLineOfBusiness(this);

		return export;
	}

	public Export removeExport(Export export) {
		getExports().remove(export);
		export.setLineOfBusiness(null);

		return export;
	}

	public List<Activity> getActivitiesLobXRef() {
		return this.activitiesLobXRef;
	}

	public void setActivitiesLobXRef(List<Activity> activities) {
		this.activitiesLobXRef = activities;
	}
	
	public Activity addActivity(Activity activity) {
		getActivitiesLobXRef().add(activity);
		return activity;
	}

	public Activity removeActivity(Activity activity) {
		getActivitiesLobXRef().remove(activity);
		return activity;
	}	

	public List<Activity> getActivitiesPresumedLobXRef() {
		return this.activitiesPresumedLobXRef;
	}

	public void setActivitiesPresumedLobXRef(List<Activity> activities) {
		this.activitiesPresumedLobXRef = activities;
	}

	public List<Application> getApplications() {
		return this.applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Application addApplication(Application application) {
		getApplications().add(application);
		return application;
	}

	public Application removeApplication(Application application) {
		getApplications().remove(application);
		return application;
	}

}