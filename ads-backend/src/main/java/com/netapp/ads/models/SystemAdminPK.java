package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the system_admin database table.
 * 
 */
@Embeddable
public class SystemAdminPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="user_corporate_id")
	private int userCorporateId;

	public SystemAdminPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserCorporateId() {
		return this.userCorporateId;
	}
	public void setUserCorporateId(int userCorporateId) {
		this.userCorporateId = userCorporateId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SystemAdminPK)) {
			return false;
		}
		SystemAdminPK castOther = (SystemAdminPK)other;
		return 
			(this.id == castOther.id)
			&& (this.userCorporateId == castOther.userCorporateId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.userCorporateId;
		
		return hash;
	}
}