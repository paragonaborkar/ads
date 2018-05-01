package com.netapp.ads.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OperationalOverride {
	
	public void pageReach(WebDriver driver) {
		driver.navigate().refresh();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("adminDropdown"))).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("admin-op-override"))).click();
	}
	
	public void operationalOverride(WebDriver driver) {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("btnReset"))).click();
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("requestedBy"))).sendKeys("SELENIUM-TEST");
			WebElement selectReasonCode = driver.findElement(By.xpath("//app-op-override-confirm//select[@formcontrolname='reasonCode']"));
			selectReasonCode.sendKeys(Keys.ARROW_DOWN);
			selectReasonCode.sendKeys(Keys.ENTER);
			driver.findElement(By.id("reason")).sendKeys("SELENIUM-TEST");
			driver.findElement(By.id("btnResubmit")).click();
		} catch(TimeoutException e) {
			
		}
	}
}
