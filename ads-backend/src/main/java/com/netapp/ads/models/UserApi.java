package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_api database table.
 * 
 */
@Entity
@Table(name="user_api")
public class UserApi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="client_id", length=45)
	private String clientId;

	@Column(name="client_secret", length=45)
	private String clientSecret;

	@Column(name="create_time")
	private Timestamp createTime;

	private boolean enabled;

	@Column(length=255)
	private String purpose;

	@Column(name="update_time")
	private Timestamp updateTime;

	public UserApi() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return this.clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}