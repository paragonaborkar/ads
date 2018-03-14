package com.netapp.ads.services;

import javax.servlet.http.HttpServletResponse;

import com.netapp.ads.util.Report;

public interface JasperReportService {

	Report generateReport(Integer pageNo, String reportName);

	void downloadExcelReport(String reportName, HttpServletResponse response);

}
