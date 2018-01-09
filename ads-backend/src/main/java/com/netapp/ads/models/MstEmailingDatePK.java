package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the mst_emailing_date database table.
 * 
 */
@Embeddable
public class MstEmailingDatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="email_type_id")
	private int emailTypeId;

	private int id;

	public MstEmailingDatePK() {
	}
	public int getEmailTypeId() {
		return this.emailTypeId;
	}
	public void setEmailTypeId(int emailTypeId) {
		this.emailTypeId = emailTypeId;
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
		if (!(other instanceof MstEmailingDatePK)) {
			return false;
		}
		MstEmailingDatePK castOther = (MstEmailingDatePK)other;
		return 
			(this.emailTypeId == castOther.emailTypeId)
			&& (this.id == castOther.id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.emailTypeId;
		hash = hash * prime + this.id;
		
		return hash;
	}
}