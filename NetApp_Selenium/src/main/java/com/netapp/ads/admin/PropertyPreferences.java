package com.netapp.ads.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PropertyPreferences {
	
	/**
	 * @param driver
	 * @throws InterruptedException
	 * Property Preferences functionality in Admin Module
	 */
	public static void PropertyPref(WebDriver driver) throws InterruptedException {
		
	
		driver.findElement(By.xpath(".//*[@id='adminDropdown']")).click();
		driver.findElement(By.xpath("//*[text()='Property Preferences']")).click();
        Select selectfromlist = new Select(driver.findElement(By.xpath("//*[@name='selectedPreferenceId']")));
        // dropdown.selectByVisibleText(selectedPreference);
        selectfromlist.selectByIndex(1);
        selectfromlist.selectByIndex(2);
        selectfromlist.selectByIndex(3);
        selectfromlist.selectByIndex(4);
        selectfromlist.selectByIndex(5);
	}
	
}
