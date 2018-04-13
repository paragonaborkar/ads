package com.netapp.ads.models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the activity_presumed_lob_x_ref database table.
 * 
 */
@Entity
@Table(name="activity_presumed_lob_x_ref")
public class ActivityPresumedLobXRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ActivityPresumedLobXRefPK id;

	public ActivityPresumedLobXRef() {
	}

	public ActivityPresumedLobXRefPK getId() {
		return this.id;
	}

	public void setId(ActivityPresumedLobXRefPK id) {
		this.id = id;
	}

}