package com.paragaon.netapp.adminModule;

import java.util.List;

import org.apache.log4j.chainsaw.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminReport {

	/**
	 * @param driver
	 * @throws InterruptedException
	 *             For the Admin Module to generate reports For the native user
	 *             created Pagination checked
	 */
	public static void Reportexcel(WebDriver driver) throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='adminDropdown']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("(//*[text()='Reports'])[3]")).click();
		driver.findElement(By.xpath(".//*[text()='User Native Report']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@class='btn btn-outline-secondary pull-left']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[text()='User Native Report']")).click();
		Thread.sleep(5000);

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
