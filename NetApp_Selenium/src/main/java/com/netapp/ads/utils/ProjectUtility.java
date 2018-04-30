package com.netapp.ads.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectUtility
{
	private static Logger log = LoggerFactory.getLogger(ProjectUtility.class);
	private static Properties props;
	
	/**
	 * @param key
	 * @return
	 * Get the data from Property File attached with Projecta
	 * 
	 */
	public static String getProperty(String key) {
		if(props == null) {
			InputStream inputStream = null;
			try {
				inputStream = ProjectUtility.class.getClassLoader().getResourceAsStream("config.properties");
				props = new Properties();
				props.load(inputStream);
			} catch (FileNotFoundException e) {
				//FIXME - Need logger
				e.printStackTrace();
			} catch (IOException e) {
				//FIXME - Need logger
				e.printStackTrace();
			} finally {
				if(inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
					}
				}
			}
		}
		return props.getProperty(key);		
	}
	
	public static int getTableRowCount(WebDriver driver) {
		//List<WebElement> rows = driver.findElements(By.xpath("//datatable-row-wrapper//datatable-body-row"));
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//datatable-pager")));
			WebElement firstPage = driver.findElement(By.xpath("//datatable-footer//a[contains(@aria-label,'go to first page')]"));
			if(firstPage != null && firstPage.isEnabled() && isElementEnabledByClass(driver, firstPage)) {
				firstPage.click();
			}
		} catch(NoSuchElementException e) {}
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//datatable-pager")));
		List<WebElement> rows = driver.findElements(By.xpath("//datatable-row-wrapper"));
		int rowCount = rows.size();
		
		boolean hasNextPage = true;
		while(hasNextPage) {
			try {
				WebElement nextPage = driver.findElement(By.xpath("//datatable-footer//a[contains(@aria-label,'go to next page')]"));
				if(nextPage.isDisplayed() && nextPage.isEnabled() && isElementEnabledByClass(driver, nextPage)) {
					nextPage.click();
					//log.debug("Waiting for datatable body to be ready");
					new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//datatable-pager")));
					List<WebElement> moreRows = driver.findElements(By.xpath("//datatable-row-wrapper"));
					rowCount = rowCount + moreRows.size();
				} else {
					//log.debug("No more pages to navigate.");
					hasNextPage = false;
				}
			} catch(NoSuchElementException nsee) {
				//log.debug("No pagination so .... No more pages to navigate. Row not found");
				hasNextPage = false;
			}
		}
		return rowCount;
	}
	
	public static WebElement findRowInDataTable(WebDriver driver, String valueToFind) {
		WebElement returnElement = null;
		//log.debug("Finding value in 1st page: {}", valueToFind);
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//datatable-pager")));
		List<WebElement> rows = driver.findElements(By.xpath("//datatable-row-wrapper//datatable-body-row"));
		//log.debug("Waiting for datatable body to be ready");
		for(WebElement row: rows) {
			List<WebElement> bodyCells = row.findElements(By.xpath(".//datatable-body-cell"));
			for(WebElement bodyCell: bodyCells) {
				if(bodyCell.getText().equals(valueToFind)) {
					returnElement = row;
					//log.debug("Row found.." + row.getAttribute("innerHTML"));
					log.debug("---------------------------------------------");
					break;
				}
			}
		}
		
		//log.debug("Trying to find in other pages");
		if(returnElement == null) {
			boolean hasNextPage = true;
			while(hasNextPage) {
				try {
					WebElement nextPage = driver.findElement(By.xpath("//datatable-footer//a[contains(@aria-label,'go to next page')]"));
					if(nextPage.isDisplayed() && nextPage.isEnabled() && isElementEnabledByClass(driver, nextPage)) {
						//log.debug("Paginating to next page");
						nextPage.click();
						//log.debug("Waiting for datatable body to be ready");
						new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//datatable-pager")));
						//new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@aria-label,'go to next page')]")));
						List<WebElement> moreRows = driver.findElements(By.xpath("//datatable-row-wrapper//datatable-body-row"));
						for(WebElement row: moreRows) {
							
							List<WebElement> bodyCells = null;
							try {
								bodyCells = row.findElements(By.xpath(".//datatable-body-cell"));
							} catch(StaleElementReferenceException e) {
								int i=1;
								while(i<20) {
									bodyCells = row.findElements(By.xpath(".//datatable-body-cell"));
									i++;
								}
							}
	
							for(WebElement bodyCell: bodyCells) {
								String str = bodyCell.getText();
								if(bodyCell.getText().equals(valueToFind)) {
									returnElement = row;
									hasNextPage = false;
									//log.debug("Row found.." + row.getAttribute("innerHTML"));
									log.debug("---------------------------------------------");
									break;
								}
							}
						}
					} else {
						//log.debug("No more pages to navigate. Row not found");
						hasNextPage = false;
					}
				} catch(NoSuchElementException nsee) {
					//log.debug("No pagination so .... No more pages to navigate. Row not found");
					hasNextPage = false;
				}
			}
		}
		return returnElement;
	}
	
	public static boolean isClickable(WebDriver driver, WebElement element) {
		try {
		   WebDriverWait wait = new WebDriverWait(driver, 5);
		   wait.until(ExpectedConditions.elementToBeClickable(element));
		   return true;
		} catch (Exception e) {
		  return false;
		}
	}
	
	public static boolean isElementEnabledByClass(WebDriver driver, WebElement element) {
		WebElement parent = element.findElement(By.xpath(".."));
		return !parent.getAttribute("class").equals("disabled");
	}
}
