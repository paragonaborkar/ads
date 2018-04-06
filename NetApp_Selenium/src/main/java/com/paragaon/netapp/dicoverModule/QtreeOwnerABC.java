package com.paragaon.netapp.dicoverModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QtreeOwnerABC {

	
	

	       /**
	     * @param driver
	     * @throws InterruptedException
	     * Methode to handle Qtree Owner Key ABC in Discover Module.
	     */
	    public static void QtreeOwnerKeyABC(WebDriver driver) throws InterruptedException {

	              Thread.sleep(5000);
	              driver.findElement(By.xpath(".//*[@id='discoverDropdown']")).click();
	              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	              driver.findElement(By.xpath(".//*[text()='QTrees Owner (Key: ABC) (temp)']")).click();

	       }
	}


