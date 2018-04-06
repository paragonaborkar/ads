package com.paragaon.netapp.adminModule;

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
        Thread.sleep(5000);
        Select selectfromlist = new Select(driver.findElement(By.xpath("//*[@name='selectedPreferenceId']")));
        // dropdown.selectByVisibleText(selectedPreference);
        Thread.sleep(5000);
        selectfromlist.selectByIndex(1);
        
        Thread.sleep(5000);
        selectfromlist.selectByIndex(2);
        
        Thread.sleep(5000);
        selectfromlist.selectByIndex(3);
        
        Thread.sleep(5000);
        selectfromlist.selectByIndex(4);
        
        Thread.sleep(5000);
        selectfromlist.selectByIndex(5);
 
        Thread.sleep(5000);
        

	}
	
}
