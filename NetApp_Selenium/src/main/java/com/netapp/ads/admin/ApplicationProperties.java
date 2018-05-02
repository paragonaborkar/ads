package com.netapp.ads.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netapp.ads.utils.ProjectUtility;

public class ApplicationProperties {

	private static Logger log = LoggerFactory.getLogger(AdminNativeUser.class);
	
	// Discover page Reach
	public void pageReach(WebDriver driver) {
		log.debug("Refreshing page");
		//driver.navigate().refresh();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("adminDropdown"))).click();
		//driver.findElement(By.id("adminDropdown")).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("admin-app-props"))).click();
	}
	
	/**
	 * @param driver
	 * @throws InterruptedException
	 * For Application Properties in Admin module.
	 */
	public boolean updateApplicationProperty(WebDriver driver) {
		log.debug("Updating application property for HHCC");
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.linkText("HHCC"))).click();
		WebElement rowToUpdate = ProjectUtility.findRowInDataTable(driver, "cifs.schedule.initial_delay");
		WebElement cellToUpdate = rowToUpdate.findElement(By.xpath(".//datatable-body-cell[2]"));
		String before = cellToUpdate.getText();
		log.debug("Before application property for cifs.schedule.initial_delay: " + before);
		//String editPath = "(.//span[@title='Double click to edit'])[1]";
		WebElement element = cellToUpdate.findElement(By.xpath(".//span[@title='Double click to edit']"));
		//((JavascriptExecutor) driver).executeScript("document.getElementById('map_container').dispatchEvent(new Event('dblclick'));"); 
		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick().sendKeys("2000").perform();
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("txtUpdateTableValue"))).sendKeys("1000");
		action.click(rowToUpdate);
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.invisibilityOfElementLocated(By.id("divSuccessMsg")));
		 cellToUpdate = rowToUpdate.findElement(By.xpath(".//datatable-body-cell[2]"));
		 String after = cellToUpdate.getText();
		 log.debug("After application property for cifs.schedule.initial_delay: " + after);
		return !before.equals(after);
	}
}