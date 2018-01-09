package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the exports_host_x_ref database table.
 * 
 */
@Entity
@Table(name="exports_host_x_ref")
@NamedQuery(name="ExportsHostXRef.findAll", query="SELECT e FROM ExportsHostXRef e")
public class ExportsHostXRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ExportsHostXRefPK id;

	public ExportsHostXRef() {
	}

	public ExportsHostXRefPK getId() {
		return this.id;
	}

	public void setId(ExportsHostXRefPK id) {
		this.id = id;
	}

}