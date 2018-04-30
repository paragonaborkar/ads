package com.netapp.ads.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.netapp.ads.discover.DiscoverReports;

public class AdminReport {

	public void pageReach(WebDriver driver) {
		driver.navigate().refresh();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("adminDropdown"))).click();
		driver.findElement(By.id("admin-reports")).click();
	}
	
	/**
	 * @param driver
	 * @throws InterruptedException
	 *             For the Admin Module to generate reports For the native user
	 *             created Pagination checked
	 */
	public boolean testNativeUserReport(WebDriver driver) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='User Admin Report']"))).click();
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
		return DiscoverReports.commonElements(driver);
	}
}
