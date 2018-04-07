package com.paragon.netapp.projectUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class XLUtility {
	/**
	 * @param sheetname
	 * @param filename
	 * @return
	 * @throws Exception
	 * @Get the data from XL Utility to run regression testing with ready test data.
	 */
	@SuppressWarnings({ "deprecation", "null" })
	public static String[][] getData(String sheetname, String filename) throws Exception
	// public static void main(String args[]) throws Exception
	{

		// String filename="TestData.xls",sheetname="loginTest";

		String filePath = ".\\src\\test\\resources\\" + filename;

		FileInputStream fis = new FileInputStream(new File(filePath));

		HSSFWorkbook wb = new HSSFWorkbook(fis);

		HSSFSheet sheet = wb.getSheet(sheetname);

		int lastRowNum = sheet.getLastRowNum();

		int lastCellNum = sheet.getRow(1).getLastCellNum();

		String[][] data = new String[lastRowNum][lastCellNum];

		HSSFCell cell;
		String strCellValue = null;
		int k;

		for (int i = 1; i <= lastRowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {

				cell = sheet.getRow(i).getCell(j);

				if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					k = (int) cell.getNumericCellValue();
					strCellValue = String.valueOf(k);
				}

				else {
					strCellValue = cell.toString();
				}

				System.out.println(strCellValue);

				data[i - 1][j] = strCellValue;
			}

		}
		return data;

	}

}