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

	@Column(name="host_id", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer hostId;

	@Column(name="exports_id", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer exportsId;

	public ExportsHostXRefPK() {
	}
	
	public ExportsHostXRefPK(Integer hostId, Integer exportsId) {
		super();
		this.hostId = hostId;
		this.exportsId = exportsId;
	}

	public Integer getHostId() {
		return this.hostId;
	}
	public void setHostId(Integer hostId) {
		this.hostId = hostId;
	}
	public Integer getExportsId() {
		return this.exportsId;
	}
	public void setExportsId(Integer exportsId) {
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