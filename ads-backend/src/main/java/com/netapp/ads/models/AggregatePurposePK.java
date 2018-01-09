package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the aggregate_purpose database table.
 * 
 */
@Embeddable
public class AggregatePurposePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="aggregate_id")
	private int aggregateId;

	private int id;

	public AggregatePurposePK() {
	}
	public int getAggregateId() {
		return this.aggregateId;
	}
	public void setAggregateId(int aggregateId) {
		this.aggregateId = aggregateId;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AggregatePurposePK)) {
			return false;
		}
		AggregatePurposePK castOther = (AggregatePurposePK)other;
		return 
			(this.aggregateId == castOther.aggregateId)
			&& (this.id == castOther.id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.aggregateId;
		hash = hash * prime + this.id;
		
		return hash;
	}
}