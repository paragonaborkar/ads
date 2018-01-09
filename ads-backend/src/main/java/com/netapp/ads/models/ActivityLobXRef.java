package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the activity_lob_x_ref database table.
 * 
 */
@Entity
@Table(name="activity_lob_x_ref")
@NamedQuery(name="ActivityLobXRef.findAll", query="SELECT a FROM ActivityLobXRef a")
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