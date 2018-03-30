package com.netapp.ads.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.services.JasperReportService;
import com.netapp.ads.util.Report;

@RestController
public class JasperReportControllers {

	private static final Logger log = LoggerFactory.getLogger(JasperReportControllers.class);

	@Autowired
	private JasperReportService jasperReportService;

	/**
	 * Generate HTML Report based on Page Number, Records per page
	 * Report Name and Report Module
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @param pageNo
	 * @param recordsPerPage
	 * @param reportName
	 * @param adsModule
	 * @return
	 * @throws Exception
	 */
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER') or hasAuthority('USER') or hasAuthority('USER_TYPE') or hasAuthority('CLIENT')")
	@RequestMapping(value = "/generateReport", method = RequestMethod.GET)
	public Report generateReport(HttpServletRequest request, HttpServletResponse response, ModelMap map,
			@RequestParam(name = "pageNo", required = true) Integer pageNo,
			@RequestParam(name = "recordsPerPage", required = true) Integer recordsPerPage,
			@RequestParam(name = "reportName", required = true) String reportName,
			@RequestParam(name = "reportModule", required = true) String adsModule) throws Exception {

		return jasperReportService.generateReport(pageNo,recordsPerPage, reportName, adsModule);

	}

	/**
	 * Download Excel Report based on Report Name and Report Module.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param reportName
	 * @param adsModule
	 * @throws Exception
	 */
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER') or hasAuthority('USER') or hasAuthority('USER_TYPE') or hasAuthority('CLIENT')")
	@RequestMapping(value = "/downloadReport", method = RequestMethod.GET)
	public void downloadReport(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model,
			@RequestParam(name = "reportName", required = true) String reportName,
			@RequestParam(name = "reportModule", required = true) String adsModule) throws Exception {

		jasperReportService.downloadExcelReport(reportName, adsModule, response);
	}

}
