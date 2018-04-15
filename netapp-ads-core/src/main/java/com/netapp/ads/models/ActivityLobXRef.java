package com.netapp.ads.models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the activity_lob_x_ref database table.
 * 
 */
@Entity
@Table(name="activity_lob_x_ref")
public class ActivityLobXRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ActivityLobXRefPK id;

	public ActivityLobXRef() {
	}

	public ActivityLobXRefPK getId() {
		return this.id;
	}

	public void setId(ActivityLobXRefPK id) {
		this.id = id;
	}

}