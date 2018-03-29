package com.netapp.ads.services;

import javax.servlet.http.HttpServletResponse;

import com.netapp.ads.util.Report;

public interface JasperReportService {

	Report generateReport(Integer pageNo,Integer recordsPerPage, String reportName, String adsModule);

	void downloadExcelReport(String reportName, String adsModule, HttpServletResponse response);

}
