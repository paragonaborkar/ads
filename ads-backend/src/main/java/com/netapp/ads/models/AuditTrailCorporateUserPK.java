package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the audit_trail_corporate_user database table.
 * 
 */
@Embeddable
public class AuditTrailCorporateUserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="audit_event_id", insertable=false, updatable=false)
	private int auditEventId;

	public AuditTrailCorporateUserPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuditEventId() {
		return this.auditEventId;
	}
	public void setAuditEventId(int auditEventId) {
		this.auditEventId = auditEventId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AuditTrailCorporateUserPK)) {
			return false;
		}
		AuditTrailCorporateUserPK castOther = (AuditTrailCorporateUserPK)other;
		return 
			(this.id == castOther.id)
			&& (this.auditEventId == castOther.auditEventId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.auditEventId;
		
		return hash;
	}
}