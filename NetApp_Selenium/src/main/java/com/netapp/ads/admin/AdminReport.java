package com.netapp.ads.admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminReport {

	/**
	 * @param driver
	 * @throws InterruptedException
	 *             For the Admin Module to generate reports For the native user
	 *             created Pagination checked
	 */
	public static void Reportexcel(WebDriver driver) throws InterruptedException {

		driver.findElement(By.xpath(".//*[@id='adminDropdown']")).click();
		driver.findElement(By.xpath("(//*[text()='Reports'])[3]")).click();
		driver.findElement(By.xpath(".//*[text()='User Native Report']")).click();
		driver.findElement(By.xpath(".//*[@class='btn btn-outline-secondary pull-left']")).click();
		driver.findElement(By.xpath(".//*[text()='User Native Report']")).click();
		List<WebElement> nextpage = driver.findElements(By.xpath(".//*[text()='Next']"));
		// find pagination link exists.

		if (nextpage.size() > 0) {
			System.out.println("pagination exists");
			// click on pagination link

			for (int i = 0; i < nextpage.size(); i++) {
				nextpage.get(i).click();
			}
		} else {
			System.out.println("pagination exists");
		}

	}

}
