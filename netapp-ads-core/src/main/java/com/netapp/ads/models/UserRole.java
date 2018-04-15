package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the user_roles database table.
 * 
 */
@Entity
@Table(name="user_roles")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	@Column(name="user_role", nullable=false, length=30)
	private String userRole;

	//bi-directional many-to-one association to UserNative
	@OneToMany(mappedBy="userRole")
	private List<UserNative> userNatives;

/*	//bi-directional one-to-one association to UserNative
	@OneToOne
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private UserNative userNative;
*/
	public UserRole() {
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

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public List<UserNative> getUserNatives() {
		return this.userNatives;
	}

	public void setUserNatives(List<UserNative> userNatives) {
		this.userNatives = userNatives;
	}

	public UserNative addUserNative(UserNative userNative) {
		getUserNatives().add(userNative);
		userNative.setUserRole(this);

		return userNative;
	}

	public UserNative removeUserNative(UserNative userNative) {
		getUserNatives().remove(userNative);
		userNative.setUserRole(null);

		return userNative;
	}
/*
	public UserNative getUserNative() {
		return this.userNative;
	}

	public void setUserNative(UserNative userNative) {
		this.userNative = userNative;
	}*/

}