package com.netapp.ads.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminReport {

	// Discover page Reach
	public void pageReach(WebDriver driver) throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(By.id("adminDropdown")).click();
		driver.findElement(By.id("admin-reports")).click();
	}
	
	/**
	 * @param driver
	 * @throws InterruptedException
	 *             For the Admin Module to generate reports For the native user
	 *             created Pagination checked
	 */
	public boolean testReport(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath(".//*[text()='User Admin Report']")).click();
	/*	List<WebElement> nextpage = driver.findElements(By.xpath(".//*[text()='Next']"));
		// find pagination link exists.
		if (nextpage.size() > 0) {
			// click on pagination link
			for (int i = 0; i < nextpage.size(); i++) {
				nextpage.get(i).click();
			}
		} else {
			System.out.println("pagination exists");
		}*/
		return commonElements(driver);
	}
	
	public boolean commonElements(WebDriver driver) {
		boolean returnTrue = false;
		try {
			WebElement element = driver.findElement(By.id("reports-page-num"));
			//driver.findElement(By.id("report-export-to-excel")).isDisplayed();
			if(element != null && element.isDisplayed())
				returnTrue = true;
		} catch(NoSuchElementException nsee) {
		}
		
		if(!returnTrue) {
			try {
				WebElement element = driver.findElement(By.cssSelector("h3.text-center"));
				//driver.findElement(By.id("report-export-to-excel")).isDisplayed();
				if(element != null && element.getText().equals("There are no results to display."))
					returnTrue = true;
			} catch(NoSuchElementException nsee) {
			}
		}
		return returnTrue;
	}

}
