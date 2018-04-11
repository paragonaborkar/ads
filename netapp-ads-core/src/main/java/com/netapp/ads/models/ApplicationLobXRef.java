package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the application_lob_x_ref database table.
 * 
 */
@Entity
@Table(name="application_lob_x_ref")
public class ApplicationLobXRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ApplicationLobXRefPK id;

	public ApplicationLobXRef() {
	}

	public ApplicationLobXRefPK getId() {
		return this.id;
	}

	public void setId(ApplicationLobXRefPK id) {
		this.id = id;
	}

}