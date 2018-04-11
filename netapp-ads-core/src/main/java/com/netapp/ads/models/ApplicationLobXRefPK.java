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

	@Column(name="application_id", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer applicationId;

	@Column(name="lob_id", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer lobId;

	public ApplicationLobXRefPK() {
	}
	
	public ApplicationLobXRefPK(Integer applicationId, Integer lobId) {
		super();
		this.applicationId = applicationId;
		this.lobId = lobId;
	}

	public Integer getApplicationId() {
		return this.applicationId;
	}
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	public Integer getLobId() {
		return this.lobId;
	}
	public void setLobId(Integer lobId) {
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