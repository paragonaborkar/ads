package com.netapp.ads.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping(value = "/api")
public class JasperReportControllers {

	@Autowired
	private JasperReportService jasperReportService;

	/**
	 * Get html report by page index
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @param num
	 * @return {@link Report}
	 * @throws IOException
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
	 * Download a report of excel sheet
	 * 
	 * @param request
	 * @param response
	 * @param model
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
