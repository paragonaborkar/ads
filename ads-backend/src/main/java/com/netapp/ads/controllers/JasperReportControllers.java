package com.netapp.ads.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.exception.NetAppAdsException;
import com.netapp.ads.models.UserNative;
import com.netapp.ads.repos.UserNativeRepository;
import com.netapp.ads.util.Report;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

@SuppressWarnings("deprecation")
@RestController
public class JasperReportControllers {

	private static final Logger log = LoggerFactory.getLogger(JasperReportControllers.class);
	
	@Autowired
	private UserNativeRepository userNativeRepository;

	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER') or hasAuthority('USER') or hasAuthority('USER_TYPE') or hasAuthority('CLIENT')")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Iterable<UserNative> getUser() {
		return userNativeRepository.findAll();
	}

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
	@RequestMapping(value = "/htmlReport/{num}", method = RequestMethod.GET)
	public Report htmlReport(HttpServletRequest request, HttpServletResponse response, ModelMap map,
			@PathVariable Integer num) throws IOException {

		Report reportOut = new Report();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ReportTitle", "User Report");
		parameters.put("Author", "");

		try {

			File jrxmlFile = new ClassPathResource("/jasper/Simple_Blue_2.jrxml").getFile();
			JasperCompileManager.compileReportToFile(jrxmlFile.getPath());
			File file = new ClassPathResource("/jasper/Simple_Blue_2.jasper").getFile();

			ArrayList<UserNative> dataList = (ArrayList<UserNative>) userNativeRepository.findAll();

			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList, false);

			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, beanColDataSource);

			HtmlExporter exporter = new HtmlExporter();
			exporter.setParameter(JRExporterParameter.PAGE_INDEX, num - 1);
			exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporter.setParameter(JRHtmlExporterParameter.IS_WRAP_BREAK_WORD, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS, Boolean.TRUE);
			
			StringBuffer sb = new StringBuffer();
			exporter.setParameter(JRHtmlExporterParameter.SIZE_UNIT, JRHtmlExporterParameter.SIZE_UNIT_POINT);
			exporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, sb);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.exportReport();
			reportOut.setReport(sb.toString());
			reportOut.setTotalPages(jasperPrint.getPages().size());

			return reportOut;
		} catch (JRException e) {
			throw new NetAppAdsException("Error in Generating Report");
		}
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
	public void downXL(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model)
			throws Exception {

		File jrxmlFile = new ClassPathResource("/jasper/UserNative.jrxml").getFile();
		JasperCompileManager.compileReportToFile(jrxmlFile.getPath());
		File jasperFile = new ClassPathResource("/jasper/UserNative.jasper").getFile();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ReportTitle", "User Report");
		parameters.put("Author", "");

		ArrayList<UserNative> dataList = (ArrayList<UserNative>) userNativeRepository.findAll();
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dataList);

		try {

			JasperPrint xlsPrint = JasperFillManager.fillReport(jasperFile.getPath(), parameters,
					beanCollectionDataSource);

			JRXlsExporter xlsExporter = new JRXlsExporter();

			File file = new File("Report.xls");

			xlsExporter.setExporterInput(new SimpleExporterInput(xlsPrint));
			xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file));
			SimpleXlsReportConfiguration xlsReportConfiguration = new SimpleXlsReportConfiguration();
			xlsReportConfiguration.setOnePagePerSheet(false);
			xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
			xlsReportConfiguration.setDetectCellType(false);
			xlsReportConfiguration.setWhitePageBackground(false);

			xlsExporter.setConfiguration(xlsReportConfiguration);
			xlsExporter.exportReport();
			InputStream in = new FileInputStream(file);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
			FileCopyUtils.copy(in, response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();
			response.flushBuffer();
		}

		catch (JRException e) {
			throw new NetAppAdsException("Error in Generating Report");
		}
	}

}
