package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the share database table.
 * 
 */
@Embeddable
public class SharePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="host_id")
	private int hostId;

	private int id;

	public SharePK() {
	}
	public int getHostId() {
		return this.hostId;
	}
	public void setHostId(int hostId) {
		this.hostId = hostId;
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
		if (!(other instanceof SharePK)) {
			return false;
		}
		SharePK castOther = (SharePK)other;
		return 
			(this.hostId == castOther.hostId)
			&& (this.id == castOther.id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hostId;
		hash = hash * prime + this.id;
		
		return hash;
	}
}