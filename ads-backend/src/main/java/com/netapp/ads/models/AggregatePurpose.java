package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the aggregate_purpose database table.
 * 
 */
@Entity
@Table(name="aggregate_purpose")
public class AggregatePurpose implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="aggregate_function", length=16)
	private String aggregateFunction;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="service_level", length=16)
	private String serviceLevel;

	@Column(name="storage_type", length=16)
	private String storageType;

	@Column(name="update_time")
	private Timestamp updateTime;

	//bi-directional many-to-one association to Aggregate
	@ManyToOne
	@JoinColumn(name="aggregate_id", nullable=false)
	private Aggregate aggregate;

	public AggregatePurpose() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAggregateFunction() {
		return this.aggregateFunction;
	}

	public void setAggregateFunction(String aggregateFunction) {
		this.aggregateFunction = aggregateFunction;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
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

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Aggregate getAggregate() {
		return this.aggregate;
	}

	public void setAggregate(Aggregate aggregate) {
		this.aggregate = aggregate;
	}

}