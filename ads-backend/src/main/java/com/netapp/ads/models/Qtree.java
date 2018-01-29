package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the qtree database table.
 * 
 */
@Entity
@Table(name="qtree")
public class Qtree implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="qtree_name", length=225)
	private String qtreeName;

	@Column(name="qtree_status", length=225)
	private String qtreeStatus;

	@Column(name="qtree_type", length=1)
	private String qtreeType;

	@Column(name="quota_hard_capacity_limit_mb")
	private BigInteger quotaHardCapacityLimitMb;

	@Column(name="quota_soft_capacity_limit_mb")
	private BigInteger quotaSoftCapacityLimitMb;

	@Column(name="quota_used_capacity_limit_mb")
	private BigInteger quotaUsedCapacityLimitMb;

	@Column(name="security_style", length=1)
	private String securityStyle;

	@Column(name="update_time")
	private Timestamp updateTime;

	//bi-directional many-to-one association to Activity
	@OneToMany(mappedBy="qtree")
	private List<Activity> activities;

	//bi-directional many-to-one association to NasVolume
	@ManyToOne
	@JoinColumn(name="nas_volume_id", nullable=false)
	private NasVolume nasVolume;

	//bi-directional many-to-one association to Share
	@OneToMany(mappedBy="qtree")
	private List<Share> shares;

	public Qtree() {
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

	public String getQtreeName() {
		return this.qtreeName;
	}

	public void setQtreeName(String qtreeName) {
		this.qtreeName = qtreeName;
	}

	public String getQtreeStatus() {
		return this.qtreeStatus;
	}

	public void setQtreeStatus(String qtreeStatus) {
		this.qtreeStatus = qtreeStatus;
	}

	public String getQtreeType() {
		return this.qtreeType;
	}

	public void setQtreeType(String qtreeType) {
		this.qtreeType = qtreeType;
	}

	public BigInteger getQuotaHardCapacityLimitMb() {
		return this.quotaHardCapacityLimitMb;
	}

	public void setQuotaHardCapacityLimitMb(BigInteger quotaHardCapacityLimitMb) {
		this.quotaHardCapacityLimitMb = quotaHardCapacityLimitMb;
	}

	public BigInteger getQuotaSoftCapacityLimitMb() {
		return this.quotaSoftCapacityLimitMb;
	}

	public void setQuotaSoftCapacityLimitMb(BigInteger quotaSoftCapacityLimitMb) {
		this.quotaSoftCapacityLimitMb = quotaSoftCapacityLimitMb;
	}

	public BigInteger getQuotaUsedCapacityLimitMb() {
		return this.quotaUsedCapacityLimitMb;
	}

	public void setQuotaUsedCapacityLimitMb(BigInteger quotaUsedCapacityLimitMb) {
		this.quotaUsedCapacityLimitMb = quotaUsedCapacityLimitMb;
	}

	public String getSecurityStyle() {
		return this.securityStyle;
	}

	public void setSecurityStyle(String securityStyle) {
		this.securityStyle = securityStyle;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public Activity addActivity(Activity activity) {
		getActivities().add(activity);
		activity.setQtree(this);

		return activity;
	}

	public Activity removeActivity(Activity activity) {
		getActivities().remove(activity);
		activity.setQtree(null);

		return activity;
	}

	public NasVolume getNasVolume() {
		return this.nasVolume;
	}

	public void setNasVolume(NasVolume nasVolume) {
		this.nasVolume = nasVolume;
	}

	public List<Share> getShares() {
		return this.shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public Share addShare(Share share) {
		getShares().add(share);
		share.setQtree(this);

		return share;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setQtree(null);

		return share;
	}

}