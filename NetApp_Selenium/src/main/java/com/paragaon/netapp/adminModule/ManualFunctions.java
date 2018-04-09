package com.paragaon.netapp.adminModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManualFunctions {
	
	/**
	 * @param driver
	 * @throws InterruptedException
	 * Manual Function Functionality under Admin module From Admin Menu.....
	 */
	public static void ManualAdmin(WebDriver driver) throws InterruptedException {
		
        driver.findElement(By.xpath(".//*[@id='adminDropdown']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[text()='Manual Functions ']")).click();
        Thread.sleep(5000);
        WebElement myfile = driver.findElement(By.xpath("(.//*[@name='myFile'])[1]"));
        myfile.submit();
        myfile.sendKeys("C:\\Users\\manmhari\\Desktop\\Controller_WorkPackages.docx");
        driver.findElement(By.xpath("(.//button[@class='btn btn-primary'])[1]")).submit();
        Thread.sleep(5000);


		
	}

}
