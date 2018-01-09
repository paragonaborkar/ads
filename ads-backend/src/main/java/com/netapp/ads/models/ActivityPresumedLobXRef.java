package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the activity_presumed_lob_x_ref database table.
 * 
 */
@Entity
@Table(name="activity_presumed_lob_x_ref")
@NamedQuery(name="ActivityPresumedLobXRef.findAll", query="SELECT a FROM ActivityPresumedLobXRef a")
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