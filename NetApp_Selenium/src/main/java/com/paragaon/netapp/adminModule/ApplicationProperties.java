package com.paragaon.netapp.adminModule;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ApplicationProperties {

	/**
	 * @param driver
	 * @throws InterruptedException
	 * For Application Properties in Admin module.
	 */
	public static void ApplicationProp(WebDriver driver) throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='adminDropdown']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[text()='Application Properties']")).click();
		driver.switchTo().parentFrame();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='WFA']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Core']")).click();
		Thread.sleep(5000);

		// Verifying the Row Selected value is equals to or less than records display in
		// the WebTable.
		System.out.println("Testing get passed Ready to select Row********");
		WebElement allNamesList = driver.findElement(By.xpath(".//*[@name='pagesPerPage']"));
		// System.out.println("**********"+allNamesList.toString());
		Select selectrow = new Select(allNamesList);
		// dropdown.selectByVisibleText(selectedPreference);
		selectrow.selectByValue("10");
		Thread.sleep(5000);
		List<WebElement> allNames = driver
				.findElements(By.xpath(".//datatable-body-row/div[2]/datatable-body-cell[1]/div"));
		int size = allNames.size();
		System.out.println("*****************" + size);
		if (size <= 10) {
			System.out.println("Selected Row Value is matching-->Less than or equal to given number of items");
		} else
			System.out.println("More than the value-->Not Matching");

		// Verifying Record is able to edit from the WebTable.
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='WFA']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		String TestXpath = "(.//span[@title='Double click to edit'])[1]";
		WebElement element = driver.findElement(By.xpath(TestXpath));

		// Double click
		action.doubleClick(element).perform();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Core']")).click();
		Thread.sleep(5000);
		System.out.println("*******Record is edited and saved********");
	}
}