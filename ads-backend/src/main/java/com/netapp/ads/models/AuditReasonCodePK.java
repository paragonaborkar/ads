package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the audit_reason_code database table.
 * 
 */
@Embeddable
public class AuditReasonCodePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="audit_event_id")
	private int auditEventId;

	private int id;

	public AuditReasonCodePK() {
	}
	public int getAuditEventId() {
		return this.auditEventId;
	}
	public void setAuditEventId(int auditEventId) {
		this.auditEventId = auditEventId;
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
		if (!(other instanceof AuditReasonCodePK)) {
			return false;
		}
		AuditReasonCodePK castOther = (AuditReasonCodePK)other;
		return 
			(this.auditEventId == castOther.auditEventId)
			&& (this.id == castOther.id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.auditEventId;
		hash = hash * prime + this.id;
		
		return hash;
	}
}