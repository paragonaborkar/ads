package com.netapp.ads.models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the host_application_x_ref database table.
 * 
 */
@Entity
@Table(name="host_application_x_ref")
public class HostApplicationXRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HostApplicationXRefPK id;

	public HostApplicationXRef() {
	}

	public HostApplicationXRefPK getId() {
		return this.id;
	}

	public void setId(HostApplicationXRefPK id) {
		this.id = id;
	}

}