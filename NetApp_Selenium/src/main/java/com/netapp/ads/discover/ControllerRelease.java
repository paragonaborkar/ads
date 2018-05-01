package com.netapp.ads.discover;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netapp.ads.utils.ProjectUtility;

public class ControllerRelease {

	private static Logger log = LoggerFactory.getLogger(ControllerRelease.class);
	
	public void pageReach(WebDriver driver) {
		log.debug("Navigating to discover page for CR");
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("discoverDropdown"))).click();
		driver.findElement(By.id("discover-ctrl-release")).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("btnCreateControllerRelease")));
	}
	
	public boolean createControllerRelease(WebDriver driver, String sourceController) {
		//int rowCountBefore = ProjectUtility.getTableRowCount(driver);
		//log.debug("Total CR before adding: " + rowCountBefore);
		String before = driver.findElement(By.xpath("//div[@class='page-count']")).getText();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("btnCreateControllerRelease"))).click();

		WebElement controller = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("controllerName")));
		controller.sendKeys(sourceController);
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("typeahead-container")));
		controller.sendKeys(Keys.ENTER);
		controller.sendKeys(Keys.TAB);
		
		driver.findElement(By.id("btnSaveControllerRelease")).click();
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.invisibilityOfElementLocated(By.id("divSuccessMsg")));

		//try {
		//	Thread.sleep(2000);
		//} catch (InterruptedException e) {
		//}
		//int rowCountAfter = ProjectUtility.getTableRowCount(driver);
		//log.debug("Total CR after adding: " + rowCountAfter);
		
		//return (rowCountAfter > rowCountBefore);
		String after = driver.findElement(By.xpath("//div[@class='page-count']")).getText();
		//return true;
		return (!before.equals(after));
	}

	public boolean deleteControllerRelease(WebDriver driver, String sourceController) {
		//int rowCountBefore = ProjectUtility.getTableRowCount(driver);
		//log.debug("Total CR before deleting: " + rowCountBefore);
		String before = driver.findElement(By.xpath("//div[@class='page-count']")).getText();
		WebElement rowToDelete = ProjectUtility.findRowInDataTable(driver, sourceController);
		//log.debug("Row to delete: " + rowToDelete.getAttribute("innerHTML"));
		WebElement trashIcon =  rowToDelete.findElement(By.id("btnTrashCR"));
		log.debug("About to delete CR");
		trashIcon.click();
		
		driver.switchTo().activeElement();
		WebElement deleteButton = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("btnDeleteCR")));
		deleteButton.click();
		log.debug("Delete hit. Now checking if CR was removed");
		//try {
		//	Thread.sleep(2000);
		//} catch (InterruptedException e) {
		//}
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//datatable-footer")));
		
		//int rowCountAfter = ProjectUtility.getTableRowCount(driver);
		//log.debug("Total CR after deleting: " + rowCountAfter);
		//return (rowCountAfter < rowCountBefore);
		String after = driver.findElement(By.xpath("//div[@class='page-count']")).getText();
		return (!before.equals(after));
	}
}
