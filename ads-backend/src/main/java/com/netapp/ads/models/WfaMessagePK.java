package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the wfa_message database table.
 * 
 */
@Embeddable
public class WfaMessagePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="workflow_id")
	private int workflowId;

	public WfaMessagePK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWorkflowId() {
		return this.workflowId;
	}
	public void setWorkflowId(int workflowId) {
		this.workflowId = workflowId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof WfaMessagePK)) {
			return false;
		}
		WfaMessagePK castOther = (WfaMessagePK)other;
		return 
			(this.id == castOther.id)
			&& (this.workflowId == castOther.workflowId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.workflowId;
		
		return hash;
	}
}