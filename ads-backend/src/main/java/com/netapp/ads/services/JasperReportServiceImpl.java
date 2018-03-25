package com.netapp.ads.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.netapp.ads.dynamicreport.DynamicJasper;
import com.netapp.ads.exception.NetAppAdsException;
import com.netapp.ads.models.AdsReport;
import com.netapp.ads.repos.AdsReportRepository;
import com.netapp.ads.util.Report;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.core.layout.LayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

@Service
public class JasperReportServiceImpl implements JasperReportService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private AdsReportRepository adsReportRepository;

	/**
	 * This method is called to generate Report
	 */
	@SuppressWarnings("deprecation")
	@Override
	public Report generateReport(Integer pageNo, Integer recordsPerPage, String reportName, String adsModule) {
		DynamicJasper dj = new DynamicJasper();

		AdsReport adsReport = adsReportRepository.findByReportNameAndAdsModule(reportName, adsModule);

		double count = jdbcTemplate.queryForObject("select count(*) from " + adsReport.getViewOrTableName(),
				Double.class);

		int totalPages = (int) Math.ceil(count / Double.valueOf(recordsPerPage));
		int offset = (pageNo - 1) * recordsPerPage;

		List<Map<String, Object>> list = jdbcTemplate.queryForList(
				"select * from " + adsReport.getViewOrTableName() + " LIMIT " + offset + "," + recordsPerPage);

		Report reportOut = new Report();
		try {
			DynamicReport dr = dj.generateColumns(adsReport.getAdsReportDetail(), adsReport.getReportTitle());
			JRDataSource ds = new JRBeanCollectionDataSource(list);

			Map<String, Object> params = new HashMap<>();

			JasperReport jr = DynamicJasperHelper.generateJasperReport(dr, getLayoutManager(), null);

			JasperPrint jp;

			jp = JasperFillManager.fillReport(jr, params, ds);

			HtmlExporter exporter = new HtmlExporter();
			exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporter.setParameter(JRHtmlExporterParameter.IS_WRAP_BREAK_WORD, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS, Boolean.TRUE);

			StringBuffer sb = new StringBuffer();
			exporter.setParameter(JRHtmlExporterParameter.SIZE_UNIT, JRHtmlExporterParameter.SIZE_UNIT_POINT);
			exporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, sb);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);

			exporter.exportReport();
			reportOut.setReport(sb.toString());
			reportOut.setTotalPages(totalPages);
		} catch (JRException e) {
			throw new NetAppAdsException("Error in Generating Report");
		} catch (Exception e) {
			throw new NetAppAdsException("Error in Generating Columns");
		}
		return reportOut;
	}

	/**
	 * This method is called to download Report
	 */
	@Override
	public void downloadExcelReport(String reportName, String adsModule, HttpServletResponse response) {
		DynamicJasper dj = new DynamicJasper();

		try {

			AdsReport adsReport = adsReportRepository.findByReportNameAndAdsModule(reportName, adsModule);

			List<Map<String, Object>> list = jdbcTemplate
					.queryForList("select * from " + adsReport.getViewOrTableName());

			DynamicReport dr = dj.downloadReport(adsReport.getAdsReportDetail());
			JRDataSource ds = new JRBeanCollectionDataSource(list);

			Map<String, Object> params = new HashMap<>();

			JasperReport jr = DynamicJasperHelper.generateJasperReport(dr, getLayoutManager(), params);

			JasperPrint jp;

			jp = JasperFillManager.fillReport(jr, params, ds);

			JRXlsExporter xlsExporter = new JRXlsExporter();

			File file = new File("Report.xls");

			xlsExporter.setExporterInput(new SimpleExporterInput(jp));
			xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file));
			SimpleXlsReportConfiguration xlsReportConfiguration = new SimpleXlsReportConfiguration();
			xlsReportConfiguration.setOnePagePerSheet(false);
			xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
			xlsReportConfiguration.setDetectCellType(true);
			xlsReportConfiguration.setWhitePageBackground(false);
			xlsReportConfiguration.setIgnoreGraphics(true);
			xlsReportConfiguration.setIgnorePageMargins(true);

			xlsExporter.setConfiguration(xlsReportConfiguration);
			xlsExporter.exportReport();

			InputStream in = new FileInputStream(file);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
			FileCopyUtils.copy(in, response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();
			response.flushBuffer();
		} catch (Exception e) {
			throw new NetAppAdsException("Error in Downloading Report");
		}

	}

	public static LayoutManager getLayoutManager() {
		return new ClassicLayoutManager();
	}

}
