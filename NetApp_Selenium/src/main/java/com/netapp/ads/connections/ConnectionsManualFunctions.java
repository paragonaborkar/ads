package com.netapp.ads.connections;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConnectionsManualFunctions {
	
	private static Logger log = LoggerFactory.getLogger(ConnectionsManualFunctions.class);
	
	public void pageReach(WebDriver driver) throws InterruptedException {
		log.debug("Navigating to connections page for Manual Functions");
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("connectionDropdown"))).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("connection-manual-functions"))).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("btnRunManualFunction")));
	}
	
	public boolean runHostConnections(WebDriver driver, int indexOfRunButton) {
		log.debug("Running HHCC for element: {}", indexOfRunButton);
		WebElement runButton = driver.findElement(By.xpath("(//button[@id='btnRunManualFunction'])[" + indexOfRunButton + "]"));
		runButton.click();
/*		new WebDriverWait(driver, 30).until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='divRunSuccess'])[" + indexOfRunButton + "]")),
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='divRunErrored'])[" + indexOfRunButton + "]"))
				) );*/
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='divRunSuccess'])[" + indexOfRunButton + "]")));
		return true;
	}	
}


