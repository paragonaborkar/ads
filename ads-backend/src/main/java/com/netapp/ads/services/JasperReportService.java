package com.netapp.ads.services;

import javax.servlet.http.HttpServletResponse;

import com.netapp.ads.util.Report;

public interface JasperReportService {
	
	/**
	 * Generate HTML Report.
	 * 
	 * @param pageNo
	 * @param recordsPerPage
	 * @param reportName
	 * @param adsModule
	 * @return
	 */
	Report generateReport(Integer pageNo,Integer recordsPerPage, String reportName, String adsModule);

	/**
	 * Download Excel Report.
	 * 
	 * @param reportName
	 * @param adsModule
	 * @param response
	 */
	void downloadExcelReport(String reportName, String adsModule, HttpServletResponse response);

}
