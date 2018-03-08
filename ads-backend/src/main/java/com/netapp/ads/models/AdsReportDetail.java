package com.netapp.ads.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ads_report_detail")
public class AdsReportDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;
	
	@Column(name="column_name")
	private String columnName;
	
	@Column(name="column_type")
	private String columnType;
	
	@Column(name="column_label")
	private String columnLabel;
	
	@Column(name="column_sequence")
	private String columnSequence;
	
	@ManyToOne
	@JoinColumn(name="ads_report_id")
	private AdsReport adsReport;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnLabel() {
		return columnLabel;
	}

	public void setColumnLabel(String columnLabel) {
		this.columnLabel = columnLabel;
	}

	public String getColumnSequence() {
		return columnSequence;
	}

	public void setColumnSequence(String columnSequence) {
		this.columnSequence = columnSequence;
	}

	public AdsReport getAdsReport() {
		return adsReport;
	}

	public void setAdsReport(AdsReport adsReport) {
		this.adsReport = adsReport;
	}
	
	
	
	
	
	
	

}
