package com.netapp.ads.discover;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DiscoverManualFunctions {
	
	private static Logger log = LoggerFactory.getLogger(DiscoverManualFunctions.class);
	
	// Discover page Reach
	public void pageReach(WebDriver driver) throws InterruptedException {
		log.debug("Navigating to discover page for Manual Functions");
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("discoverDropdown"))).click();
		//driver.findElement(By.id("discoverDropdown")).click();
		driver.findElement(By.id("discover-manual-functions")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("btnRunManualFunction")));
	}
	
	public boolean ociDataLoadRunJob(WebDriver driver, int indexOfRunButton) {
		log.debug("Running OCI Data Load for element: {}", indexOfRunButton);
		WebElement runButton = driver.findElement(By.xpath("(//button[@id='btnRunManualFunction'])[" + indexOfRunButton + "]"));
		runButton.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='divRunSuccess'])[" + indexOfRunButton + "]")),
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='divRunErrored'])[" + indexOfRunButton + "]"))
				) );
		return true;
	}	
	
	public boolean loadActivitiesAndApplications(WebDriver driver, int indexOfRunButton, int indexOfMessageText) {
		log.debug("Running Load Activities & Applications for element: {}", indexOfRunButton);
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("app-tab"))).click();
		WebElement runButton = new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='btnRunManualFunction'])[" + indexOfRunButton + "]")));
		runButton.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='divRunSuccess'])[" + indexOfMessageText + "]")),
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='divRunErrored'])[" + indexOfMessageText + "]"))
				) );
		return true;
	}	
}


