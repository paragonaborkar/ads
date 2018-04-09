package com.paragaon.netapp.dicoverModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ControlRelease {

	/**
	 * @param driver
	 * @param SourceController
	 * @throws InterruptedException
	 * @author Singprad: Method to handle create Controller WorkPackage functionality from Discover Module.
	 * 
	 */
	public static void ControlBatch(WebDriver driver, String SourceController) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Discover")).click();
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Controller Release")).click();

		driver.findElement(By.xpath(".//div/div/div[1]/div[2]/div/button")).click();

		Thread.sleep(5000);

		WebElement autoOptions = driver.findElement(By.name("controllerName"));

		autoOptions.sendKeys(SourceController);
		Thread.sleep(5000);
		autoOptions.sendKeys(Keys.TAB);

		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@class='btn btn-primary' and text()='Create']")).click();

		Thread.sleep(5000);

	}

	/**
	 * @param driver
	 * @param SourceController
	 * @throws InterruptedException
	 * @author Singprad: Method to handle Delete Controller Release functionality from Discover Module.
	 * 
	 */
	public static void DeleteRelease(WebDriver driver, String SourceController) throws InterruptedException {

		driver.findElement(By.linkText("Discover")).click();
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Controller Release")).click();
		Thread.sleep(10000);

		List<WebElement> allNames = driver
				.findElements(By.xpath(".//datatable-body-row/div[2]/datatable-body-cell[1]/div"));
		WebElement wb = driver.findElement(By.xpath("//a[contains(@aria-label,'go to next page')]"));

		boolean found = false;
		while (wb.isEnabled()) {
			for (int j = 0; j < allNames.size(); j++) {
				Thread.sleep(1000);
				if (allNames.get(j).getText().equalsIgnoreCase(SourceController)) {
					System.out.println("inside true part");

					j = j + 1;
					Thread.sleep(10000);
					driver.findElement(By.xpath("(.//*[@class='btn btn-sm btn-warning'])[" + j + "]")).click();
					Thread.sleep(5000);
					found = true;
					Thread.sleep(10000);
					driver.findElement(By.xpath("//*[@class='modal-footer']//*[text()='Delete']")).click();
					Thread.sleep(10000);
					break;

				}

			}

			if (found == false) {
				wb.click();
			}

		}
	}

}
