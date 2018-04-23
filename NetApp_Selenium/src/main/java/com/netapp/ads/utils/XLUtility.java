package com.netapp.ads.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class XLUtility {
	/**
	 * @param sheetname
	 * @param filename
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 * @Get the data from XL Utility to run regression testing with ready test data.
	 */
	@SuppressWarnings({ "deprecation", "null" })
	public static String[][] getData(String sheetname, String filename) throws IOException {
		InputStream fis = XLUtility.class.getClassLoader().getResourceAsStream(filename);
		HSSFWorkbook wb = null; 
		String[][] data = null;
		try {
			wb = new HSSFWorkbook(fis);
			HSSFSheet sheet = wb.getSheet(sheetname);
			int lastRowNum = sheet.getLastRowNum();
			int lastCellNum = sheet.getRow(1).getLastCellNum();
			data = new String[lastRowNum][lastCellNum];
			HSSFCell cell;
			String strCellValue = "";
			int k;
			for (int i = 1; i <= lastRowNum; i++) {
				for (int j = 0; j < lastCellNum; j++) {
					cell = sheet.getRow(i).getCell(j);
					if(cell != null) {
						if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							k = (int) cell.getNumericCellValue();
							strCellValue = String.valueOf(k);
						} else {
							strCellValue = cell.toString();
						}
					}
					data[i - 1][j] = strCellValue;
				}
			}
		} finally {
			if(wb != null) {
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}
	
	public static void main(String[] args) throws IOException {
		getData("CreateNativeUsers", "TestData.xls");
	}

}