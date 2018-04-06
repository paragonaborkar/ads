package com.paragaon.netapp.dicoverModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DiscovrManualFunctions {
	
	/**
	 * @param driver
	 * @throws InterruptedException
	 * Manual Functions Module inside Discover Menu.
	 */
	public static void manualFunctions(WebDriver driver) throws InterruptedException {
			// searching for Discover 
			driver.findElement(By.linkText("Discover")).click();
			
			// Go to Reports 
				driver.findElement(By.linkText("Manual Functions")).click();
				Thread.sleep(5000);
		    // click on load OCI date
				driver.findElement(By.id("oci-tab")).click();
				Thread.sleep(5000);
				
			// click on Run button .
			//click on first button)(in case of multiple clicks)
				driver.findElement(By.xpath("//*[@id=\"oci\"]/app-manual-function[1]/form/div/div[2]/button")).click();
				Thread.sleep(10000);// to check status completed
				
		   // click on second run button
				driver.findElement(By.xpath("//*[@id=\"oci\"]/app-manual-function[2]/form/div/div[2]/button")).click();
				Thread.sleep(10000);
		  // click on third run button
				/*driver.findElement(By.xpath("//*[@id=\"oci\"]/app-manual-function[3]/form/div/div[2]/button")).click();
				Thread.sleep(10000);
	   	// click on fourth run button
				driver.findElement(By.xpath("//*[@id=\"oci\"]/app-manual-function[4]/form/div/div[2]/button")).click();
				Thread.sleep(10000);
		// click on fifth run button
				driver.findElement(By.xpath("//*[@id=\"oci\"]/app-manual-function[5]/form/div/div[2]/button")).click();
				Thread.sleep(10000);
		// click on sixth run button
				driver.findElement(By.xpath("//*[@id=\"oci\"]/app-manual-function[6]/form/div/div[2]/button")).click();
				Thread.sleep(10000);
	    // click on 7 th run button
				driver.findElement(By.xpath("//*[@id=\"oci\"]/app-manual-function[7]/form/div/div[2]/button")).click();
				Thread.sleep(10000);
		// click on 8 th run button 
				driver.findElement(By.xpath("//*[@id=\"oci\"]/app-manual-function[8]/form/div/div[2]/button")).click();
				Thread.sleep(10000);*/
				
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// now click on next tab "populate activity and aplications
				Thread.sleep(10000);
				driver.findElement(By.id("app-tab")).click();
				Thread.sleep(10000);
				
				// click on Run button .
				//click on first button)(in case of multiple clicks)
					driver.findElement(By.xpath("//*[@id=\"app\"]/app-manual-function[1]/form/div/div[2]/button")).click();
					Thread.sleep(10000);// to check status completed
					//wait untill completed
                //					WebDriverWait wait = new WebDriverWait(driver, 30);
//					WebElement wb = driver.findElement(By.xpath("//*[@id=\"app\"]/app-manual-function[1]/form/div/div[3]"));
//					wait.until(ExpectedConditions.attributeContains(wb, "text", "Completed"));
					
//					driver.findElement(By.xpath("//*[@id=\"app\"]/app-manual-function[1]/form/div/div[3]")).getText().equals("Completed"));
					
			   // click on second run button
					driver.findElement(By.xpath("//*[@id=\"app\"]/app-manual-function[2]/form/div/div[2]/button")).click();
					Thread.sleep(10000);
			  // click on third run button
					driver.findElement(By.xpath("//*[@id=\"app\"]/app-manual-function[3]/form/div/div[2]/button")).click();
					Thread.sleep(10000);
		   	// click on fourth run button
					driver.findElement(By.xpath("//*[@id=\"app\"]/app-manual-function[4]/form/div/div[2]/button")).click();
					Thread.sleep(10000);
			// click on fifth run button
					driver.findElement(By.xpath("//*[@id=\"app\"]/app-manual-function[5]/form/div/div[2]/button")).click();
					Thread.sleep(10000);
			
	 }
}


