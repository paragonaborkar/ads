package com.netapp.ads.dynamicreport;

import java.util.List;

import com.netapp.ads.models.AdsReportDetail;

import ar.com.fdvs.dj.domain.AutoText;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.builders.StyleBuilder;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;

public class DynamicJasper {

	/**
	 * Add columns and styling in Report
	 * 
	 * @param reportColumns
	 * @param reportTitle
	 * @return
	 * @throws Exception
	 */
	public DynamicReport generateColumns(List<AdsReportDetail> reportColumns, String reportTitle) throws Exception {

		Style detailStyle = new Style();
		Style headerStyle = new Style();

		Style subtitleStyle = new Style();
		Style amountStyle = new Style();
		amountStyle.setHorizontalAlign(HorizontalAlign.RIGHT);

		Font font = new Font(16, "Arial", true, false, false);
		Style titleStyle = new StyleBuilder(false).setFont(font).build();
		titleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
		Font font1 = new Font(12, "Arial", true, false, false);
		Style titleStyle1 = new StyleBuilder(false).setFont(font1).build();

		/**
		 * Creates the DynamicReportBuilder and sets the basic options for the report
		 */
		DynamicReportBuilder drb = new DynamicReportBuilder();
		drb.setTitle(reportTitle).setDetailHeight(15) // defines the height for each record of the report
				.setMargins(30, 20, 30, 15) // define the margin space for each side (top, bottom, left and right)
				.setDefaultStyles(titleStyle, subtitleStyle, headerStyle, detailStyle).setColumnsPerPage(1);
		drb.addAutoText(AutoText.AUTOTEXT_PAGE_X_OF_Y, AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_RIGHT);

		/**
		 * Column definitions. We use a new ColumnBuilder instance for each column, the
		 * ColumnBuilder.getNew() method returns a new instance of the builder
		 */
		for (AdsReportDetail obj : reportColumns) {

			AbstractColumn column = ColumnBuilder.getNew().setColumnProperty(obj.getColumnName(), obj.getColumnType())
					.setTitle(obj.getColumnLabel()).setHeaderStyle(titleStyle1).setWidth(150).build();

			drb.addColumn(column);
		}

		/**
		 * add some more options to the report (through the builder)
		 */
		drb.setUseFullPageWidth(true);

		DynamicReport dr = drb.build();

		return dr;
	}

	/**
	 * Add Columns for Download Report
	 * 
	 * @param reportColumns
	 * @return
	 */
	public DynamicReport downloadReport(List<AdsReportDetail> reportColumns) {

		Font font = new Font(10, "Calibri", false, false, false);
		Style titleStyle = new StyleBuilder(false).setFont(font).build();
		Style subTitleStyle = new StyleBuilder(false).setFont(font).build();
		Style detailStyle = new StyleBuilder(false).setFont(font).build();
		Style headerStyle = new StyleBuilder(false).setFont(font).build();

		/**
		 * Creates the DynamicReportBuilder and sets the basic options for the report
		 */
		DynamicReportBuilder drb = new DynamicReportBuilder();
		drb.setIgnorePagination(true);
		drb.setUseFullPageWidth(true);
		drb.setMargins(0, 0, 0, 0);
		drb.setDefaultStyles(titleStyle, subTitleStyle, headerStyle, detailStyle);
		drb.setHeaderHeight(15);

		/**
		 * Column definitions. We use a new ColumnBuilder instance for each column, the
		 * ColumnBuilder.getNew() method returns a new instance of the builder
		 */
		for (AdsReportDetail obj : reportColumns) {

			AbstractColumn column = ColumnBuilder.getNew().setColumnProperty(obj.getColumnName(), obj.getColumnType())
					.setTitle(obj.getColumnLabel()).setStyle(headerStyle).setWidth(130).build();

			drb.addColumn(column);

		}

		DynamicReport dr = drb.build();

		return dr;
	}

}
