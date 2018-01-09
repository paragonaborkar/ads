package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the line_of_business database table.
 * 
 */
@Entity
@Table(name="line_of_business")
@NamedQuery(name="LineOfBusiness.findAll", query="SELECT l FROM LineOfBusiness l")
public class LineOfBusiness implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="liason_contact_number")
	private String liasonContactNumber;

	@Column(name="liason_email")
	private String liasonEmail;

	@Column(name="liason_first_name")
	private String liasonFirstName;

	@Column(name="liason_last_name")
	private String liasonLastName;

	@Column(name="liason_user_name")
	private String liasonUserName;

	@Column(name="lob_name")
	private String lobName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public LineOfBusiness() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
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

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}