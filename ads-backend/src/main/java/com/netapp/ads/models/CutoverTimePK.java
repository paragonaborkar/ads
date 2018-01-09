package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the cutover_time database table.
 * 
 */
@Embeddable
public class CutoverTimePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cutover_assembly_id")
	private int cutoverAssemblyId;

	private int id;

	public CutoverTimePK() {
	}
	public int getCutoverAssemblyId() {
		return this.cutoverAssemblyId;
	}
	public void setCutoverAssemblyId(int cutoverAssemblyId) {
		this.cutoverAssemblyId = cutoverAssemblyId;
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
		if (!(other instanceof CutoverTimePK)) {
			return false;
		}
		CutoverTimePK castOther = (CutoverTimePK)other;
		return 
			(this.cutoverAssemblyId == castOther.cutoverAssemblyId)
			&& (this.id == castOther.id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cutoverAssemblyId;
		hash = hash * prime + this.id;
		
		return hash;
	}
}