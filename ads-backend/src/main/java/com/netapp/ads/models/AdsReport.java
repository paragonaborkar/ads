package com.netapp.ads.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "ads_report")
public class AdsReport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(name = "report_name")
	private String reportName;

	@Column(name = "report_title")
	private String reportTitle;

	@Column(name = "ads_module")
	private String adsModule;

	@Column(name = "view_or_table_name")
	private String viewOrTableName;

	@OneToMany(mappedBy = "adsReport")
	@OrderBy("columnSequence ASC")
	private List<AdsReportDetail> adsReportDetail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getAdsModule() {
		return adsModule;
	}

	public void setAdsModule(String adsModule) {
		this.adsModule = adsModule;
	}

	public String getViewOrTableName() {
		return viewOrTableName;
	}

	public void setViewOrTableName(String viewOrTableName) {
		this.viewOrTableName = viewOrTableName;
	}

	public List<AdsReportDetail> getAdsReportDetail() {
		return adsReportDetail;
	}

	public void setAdsReportDetail(List<AdsReportDetail> adsReportDetail) {
		this.adsReportDetail = adsReportDetail;
	}

}
