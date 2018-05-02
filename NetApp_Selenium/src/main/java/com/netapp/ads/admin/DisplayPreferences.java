package com.netapp.ads.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisplayPreferences {
	
	private static Logger log = LoggerFactory.getLogger(DisplayPreferences.class);
	
	// Discover page Reach
	public void pageReach(WebDriver driver) {
		log.debug("Navigating to Display Preferences page");
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("adminDropdown"))).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("admin-disp-prefs"))).click();
	}
	
	/**
	 * @param driver
	 * @throws InterruptedException
	 * Property Preferences functionality in Admin Module
	 */
	public boolean setDisplayPreferences(WebDriver driver) {
		Select selectPage = new Select(new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("selectedPreferenceId"))));
		selectPage.selectByIndex(1);

		WebElement draggableElement = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='divVisibleCardBody']//div[@draggable='true'][2]")));
		WebElement targetElement = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='divHiddenCardBody']//bs-sortable")));
		Actions builder = new Actions(driver);
		Action action = builder
				.clickAndHold(draggableElement)
				.moveToElement(targetElement)
				.release(draggableElement)
				.build();
		action.perform();
		//action.perform();
		//Action dragnDrop = builder.dragAndDrop(draggableElement, targetElement).build();
		//dragnDrop.perform();
		return true;

	}
	
}
