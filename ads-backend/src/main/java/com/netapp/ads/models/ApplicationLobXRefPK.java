package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the application_lob_x_ref database table.
 * 
 */
@Embeddable
public class ApplicationLobXRefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="application_id")
	private int applicationId;

	@Column(name="lob_id")
	private int lobId;

	public ApplicationLobXRefPK() {
	}
	public int getApplicationId() {
		return this.applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public int getLobId() {
		return this.lobId;
	}
	public void setLobId(int lobId) {
		this.lobId = lobId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ApplicationLobXRefPK)) {
			return false;
		}
		ApplicationLobXRefPK castOther = (ApplicationLobXRefPK)other;
		return 
			(this.applicationId == castOther.applicationId)
			&& (this.lobId == castOther.lobId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.applicationId;
		hash = hash * prime + this.lobId;
		
		return hash;
	}
}