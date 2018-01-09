package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the exports_host_x_ref database table.
 * 
 */
@Embeddable
public class ExportsHostXRefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="host_id")
	private int hostId;

	@Column(name="exports_id")
	private int exportsId;

	public ExportsHostXRefPK() {
	}
	public int getHostId() {
		return this.hostId;
	}
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	public int getExportsId() {
		return this.exportsId;
	}
	public void setExportsId(int exportsId) {
		this.exportsId = exportsId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ExportsHostXRefPK)) {
			return false;
		}
		ExportsHostXRefPK castOther = (ExportsHostXRefPK)other;
		return 
			(this.hostId == castOther.hostId)
			&& (this.exportsId == castOther.exportsId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hostId;
		hash = hash * prime + this.exportsId;
		
		return hash;
	}
}