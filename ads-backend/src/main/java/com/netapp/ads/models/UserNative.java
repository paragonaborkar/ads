package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user_native database table.
 * 
 */
@Entity
@Table(name="user_native")
public class UserNative implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(nullable=false, length=255)
	private String email;

	@Column(nullable=false)
	private boolean enabled;

	@Column(name="first_name", length=45)
	private String firstName;

	@Column(name="last_name", length=45)
	private String lastName;

	@JsonIgnore
	@Column(nullable=false, length=64)
	private String password;

	@Column(length=64)
	private String salt;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="user_name", nullable=false, length=100)
	private String userName;

	//bi-directional many-to-one association to Cutover
	@OneToMany(mappedBy="userNative")
	private List<Cutover> cutovers;

	//bi-directional many-to-one association to UserRole
	@ManyToOne
	@JoinColumn(name="user_role_id")
	private UserRole userRole;

	//bi-directional one-to-one association to UserRole
	//@OneToOne(mappedBy="userNative")
	//private UserRole userRole2;

	public UserNative() {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
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

	public List<Cutover> getCutovers() {
		return this.cutovers;
	}

	public void setCutovers(List<Cutover> cutovers) {
		this.cutovers = cutovers;
	}

	public Cutover addCutover(Cutover cutover) {
		getCutovers().add(cutover);
		cutover.setUserNative(this);

		return cutover;
	}

	public Cutover removeCutover(Cutover cutover) {
		getCutovers().remove(cutover);
		cutover.setUserNative(null);

		return cutover;
	}

	public UserRole getUserRole() {
		return this.userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

/*	public UserRole getUserRole2() {
		return this.userRole2;
	}

	public void setUserRole2(UserRole userRole2) {
		this.userRole2 = userRole2;
	}*/

}