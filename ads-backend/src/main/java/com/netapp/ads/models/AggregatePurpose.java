package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the aggregate_purpose database table.
 * 
 */
@Entity
@Table(name="aggregate_purpose")
@NamedQuery(name="AggregatePurpose.findAll", query="SELECT a FROM AggregatePurpose a")
public class AggregatePurpose implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AggregatePurposePK id;

	@Column(name="aggregate_function")
	private String aggregateFunction;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="service_level")
	private String serviceLevel;

	@Column(name="storage_type")
	private String storageType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public AggregatePurpose() {
	}

	public AggregatePurposePK getId() {
		return this.id;
	}

	public void setId(AggregatePurposePK id) {
		this.id = id;
	}

	public String getAggregateFunction() {
		return this.aggregateFunction;
	}

	public void setAggregateFunction(String aggregateFunction) {
		this.aggregateFunction = aggregateFunction;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getServiceLevel() {
		return this.serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public String getStorageType() {
		return this.storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}