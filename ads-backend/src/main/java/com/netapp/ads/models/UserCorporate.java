package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user_corporate database table.
 * 
 */
@Entity
@Table(name="user_corporate")
public class UserCorporate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="best_phone", length=45)
	private String bestPhone;

	@Column(length=100)
	private String costCenter;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(nullable=false, length=255)
	private String email;

	@Column(name="first_name", nullable=false, length=45)
	private String firstName;

	@Column(name="last_name", nullable=false, length=45)
	private String lastName;

	@Column(length=255)
	private String location;

	@Column(name="middle_name", length=45)
	private String middleName;

	@Column(name="mobile_phone", length=45)
	private String mobilePhone;

	@Column(length=45)
	private String timezone;

	@Column(length=255)
	private String title;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="user_name", nullable=false, length=45)
	private String userName;

	@Column(name="work_phone", length=45)
	private String workPhone;

	//bi-directional many-to-one association to UserCorporate
	@ManyToOne
	@JoinColumn(name="manager_user_corporate_id")
	private UserCorporate userCorporate;

	//bi-directional many-to-one association to UserCorporate
	@OneToMany(mappedBy="userCorporate")
	private List<UserCorporate> userCorporates;

	public UserCorporate() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBestPhone() {
		return this.bestPhone;
	}

	public void setBestPhone(String bestPhone) {
		this.bestPhone = bestPhone;
	}

	public String getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public UserCorporate getUserCorporate() {
		return this.userCorporate;
	}

	public void setUserCorporate(UserCorporate userCorporate) {
		this.userCorporate = userCorporate;
	}

	public List<UserCorporate> getUserCorporates() {
		return this.userCorporates;
	}

	public void setUserCorporates(List<UserCorporate> userCorporates) {
		this.userCorporates = userCorporates;
	}

	public UserCorporate addUserCorporate(UserCorporate userCorporate) {
		getUserCorporates().add(userCorporate);
		userCorporate.setUserCorporate(this);

		return userCorporate;
	}

	public UserCorporate removeUserCorporate(UserCorporate userCorporate) {
		getUserCorporates().remove(userCorporate);
		userCorporate.setUserCorporate(null);

		return userCorporate;
	}

}