package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the exports_host_x_ref database table.
 * 
 */
@Entity
@Table(name="exports_host_x_ref")
public class ExportsHostXRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ExportsHostXRefPK id;

	//bi-directional many-to-one association to Export
	@ManyToOne
	@JoinColumn(name="exports_id", nullable=false, insertable=false, updatable=false)
	private Export export;

	public ExportsHostXRef() {
	}

	public ExportsHostXRefPK getId() {
		return this.id;
	}

	public void setId(ExportsHostXRefPK id) {
		this.id = id;
	}

	public Export getExport() {
		return this.export;
	}

	public void setExport(Export export) {
		this.export = export;
	}

}