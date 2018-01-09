package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the host_application_x_ref database table.
 * 
 */
@Entity
@Table(name="host_application_x_ref")
@NamedQuery(name="HostApplicationXRef.findAll", query="SELECT h FROM HostApplicationXRef h")
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