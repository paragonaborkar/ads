package com.netapp.ads.discover;

import static com.netapp.ads.utils.ProjectUtility.getProperty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QtreeOwner {
	
	private static Logger log = LoggerFactory.getLogger(QtreeOwner.class);
	
	public void pageReach(WebDriver driver, String user, String password) {
		log.debug("Performing SSO Circle authentication");
		
		//sso circle login
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("IDToken1"))).sendKeys(user);
		driver.findElement(By.id("IDToken2")).sendKeys(password);
		driver.findElement(By.name("Login.Submit")).click();
		
		//back to ADS
		new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe(getProperty("discover.owner.sso.url")));
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("respondButton"))).click();
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("isOwnerTrue"))).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("decommissionFalse"))).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("migrationTeamContactMeFalse"))).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("saveResponse"))).click();
		
		//new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("discoverDropdown"))).click();
		//driver.findElement(By.id("discoverDropdown")).click();
		//driver.findElement(By.id("discover-manual-functions")).click();
		//new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("btnRunManualFunction")));
	}
}


