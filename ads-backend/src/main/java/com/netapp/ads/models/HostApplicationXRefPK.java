package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the host_application_x_ref database table.
 * 
 */
@Embeddable
public class HostApplicationXRefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="host_id")
	private int hostId;

	@Column(name="application_id")
	private int applicationId;

	public HostApplicationXRefPK() {
	}
	public int getHostId() {
		return this.hostId;
	}
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	public int getApplicationId() {
		return this.applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HostApplicationXRefPK)) {
			return false;
		}
		HostApplicationXRefPK castOther = (HostApplicationXRefPK)other;
		return 
			(this.hostId == castOther.hostId)
			&& (this.applicationId == castOther.applicationId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hostId;
		hash = hash * prime + this.applicationId;
		
		return hash;
	}
}