package com.netapp.ads.discover;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netapp.ads.utils.ProjectUtility;

public class DiscoverWorkPackages {
	
	private static Logger log = LoggerFactory.getLogger(DiscoverWorkPackages.class);
	
	// Discover page Reach
	public void pageReach(WebDriver driver) {
		log.debug("Navigating to discover page for WP");
		//driver.navigate().refresh();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("discoverDropdown"))).click();
		//driver.findElement(By.id("discoverDropdown")).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("discover-ctrl-workpackage"))).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("btnCreateControllerWP")));
	}

	/**
	 * @param driver
	 * @param Workpack
	 * @param SourceController
	 * @param Assettag
	 * @param InstallDate
	 * @throws InterruptedException
	 * Method to handle Controller WorkPackage in Discover Module....
	 */
	public boolean createWorkPackage(WebDriver driver, String workPackageName, String sourceController, String assetTag, String installDate) {
		String before = null;
		try {
			 before = driver.findElement(By.xpath("//div[@class='page-count']")).getText();
		} catch(NoSuchElementException e) {
			before = "0";
		}
		log.debug("Total WP before adding: " + before);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("btnCreateControllerWP"))).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("txtWPName"))).sendKeys(workPackageName);
		
		WebElement controller = driver.findElement(By.name("controllerName"));
		controller.sendKeys(sourceController);
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("typeahead-container")));
		controller.sendKeys(Keys.ENTER);
		controller.sendKeys(Keys.TAB);
		
		driver.findElement(By.id("txtAssetNumber")).sendKeys(assetTag);
		driver.findElement(By.id("txtControllerInstalledDate")).sendKeys(installDate);
		log.debug("Install Date: " + installDate);
		Select priority = new Select(driver.findElement(By.id("selPriority")));
		priority.selectByIndex(1);

		driver.findElement(By.id("btnSubmitCreateWP")).click();
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.invisibilityOfElementLocated(By.id("divSuccessMsg")));
		
		String after = driver.findElement(By.xpath("//div[@class='page-count']")).getText();
		log.debug("Total WP after adding: " + after);
		
		return (!before.equals(after));
	}

	
	public boolean deleteWorkPackage(WebDriver driver, String workPackage, String sourceController, String assetTag, String installDate) {
		boolean bRet = false;
		WebElement rowToDelete = null;
		
		try {
			String before = driver.findElement(By.xpath("//div[@class='page-count']")).getText();
			log.debug("Total rows before deleting: " + before);
			rowToDelete = ProjectUtility.findRowInDataTable(driver, sourceController);
			WebElement trashIcon =  rowToDelete.findElement(By.id("btnTrashWP"));
			log.debug("About to delete WP");
			trashIcon.click();
			
			driver.switchTo().activeElement();
			WebElement deleteButton = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("btnDeleteWorkPackage")));
			deleteButton.click();
			log.debug("Delete hit. Now checking if WP was removed");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//datatable-footer")));
			String after = driver.findElement(By.xpath("//div[@class='page-count']")).getText();
			log.debug("Total rows after deleting: " + after);
			bRet = !before.equals(after);
		} catch (NoSuchElementException e) {
			bRet = true;
		}
		return bRet;
	}
}
