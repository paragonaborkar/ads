package com.netapp.ads.discover;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DiscoverReports {
	

	public WebDriverWait wait;

	
	// Discover page Reach
	public void pageReach(WebDriver driver) throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("home"))).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("discoverDropdown"))).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("discover-reports"))).click();
	}

	// Callme Report Test
	/**
	 * @param driver
	 * @throws InterruptedException
	 * @Method to Handle Call Me Report module regression testing.
	 */
	public boolean callMeReport(WebDriver driver) throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Call Me Report']"))).click();
		// set preference to download the file in C:\Temp file
		// Waiting for the element Export to excel 
//		WebElement wb = driver.findElement(By.xpath("//button[@class='btn btn-outline-primary']"));
//		wait.until(ExpectedConditions.elementToBeClickable(wb));
//		 
//		// once the element Export to excel is visible, click on it .
//		wb.click();
//		
//		// Directory check  for file downloaded location 
//		// Directory check  for file downloaded location 
//		boolean fileDownloaded = this.isFileDownloaded_Ext("C:\\Users\\rajrajm\\Downloads\\", "xls");
//
//		// if file is downloaded then find the lates file 
//		if(fileDownloaded) {
//			File latestFilefromDir = this.getLatestFilefromDir("C:\\Users\\rajrajm\\Downloads\\");
//			System.out.println(latestFilefromDir);
//		}
		return commonElements(driver);
	}
	
	// UnknownOwnerReport Test
	/**
	 * @param driver
	 * @throws InterruptedException
	 * @Method to Handle unknownOwnerReport Report module regression testing.
	 */
	public boolean unknownOwnerReport(WebDriver driver) throws InterruptedException{
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Unknown Owner Report']"))).click();
		// set preference to download the file in C:\Temp file
		// Waiting for the element Export to excel 
//		WebElement wb = driver.findElement(By.xpath("//button[@class='btn btn-outline-primary']"));
//		wait.until(ExpectedConditions.elementToBeClickable(wb));
//		
//		// once the element Export to excel is visible, click on it .
//		wb.click();
//		
//		// Directory check  for file downloaded location 
//		boolean fileDownloaded = this.isFileDownloaded_Ext("C:\\Users\\rajrajm\\Downloads\\", "xls");
//
//		
//		// if file is downloaded then find the lates file 
//		if(fileDownloaded) {
//			File latestFilefromDir = this.getLatestFilefromDir("C:\\Users\\rajrajm\\Downloads\\");
//			System.out.println(latestFilefromDir);
//		}
		return commonElements(driver);
	}
	
	
	//Voulume DecomissionReport Test
	/**
	 * @param driver
	 * @throws InterruptedException
	 * @Method to Handle unknownOwnerReport Report module regression testing.
	 * 
	 */
	public boolean volumeDecommision(WebDriver driver ) throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Volume Decommission Report']"))).click();
		// set preference to download the file in C:\Temp file
		// Waiting for the element Export to excel 
//		WebElement wb = driver.findElement(By.xpath("//button[@class='btn btn-outline-primary']"));
//		wait.until(ExpectedConditions.elementToBeClickable(wb));
//		
//		// once the element Export to excel is visible, click on it .
//		wb.click();
//		
//		// Directory check  for file downloaded location 
//		boolean fileDownloaded = this.isFileDownloaded_Ext("C:\\Users\\rajrajm\\Downloads\\", "xls");
//
//		
//		// if file is downloaded then find the lates file 
//		if(fileDownloaded) {
//			File latestFilefromDir = this.getLatestFilefromDir("C:\\Users\\rajrajm\\Downloads\\");
//			System.out.println(latestFilefromDir);
//		}
		return commonElements(driver);
	}
	
	// Multiowner report test
	/**
	 * @param driver
	 * @throws InterruptedException
	 * @Method to Handle multiOwner Report module regression testing.
	 */
	public boolean multiOwner(WebDriver driver) throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Multi Owner Report']"))).click();
		// set preference to download the file in C:\Temp file
		// Waiting for the element Export to excel 
//		WebElement wb = driver.findElement(By.xpath("//button[@class='btn btn-outline-primary']"));
//		wait.until(ExpectedConditions.elementToBeClickable(wb));
//		
//		// once the element Export to excel is visible, click on it .
//		wb.click();
//		
//		// Directory check  for file downloaded location 
//		boolean fileDownloaded = this.isFileDownloaded_Ext("C:\\Users\\rajrajm\\Downloads\\", "xls");
//
//		
//		// if file is downloaded then find the lates file 
//		if(fileDownloaded) {
//			File latestFilefromDir = this.getLatestFilefromDir("C:\\Users\\rajrajm\\Downloads\\");
//			System.out.println(latestFilefromDir);
//		}
		return commonElements(driver);
	}
	
	// Activity report test
	/**
	 * @param driver
	 * @throws InterruptedException
	 * @Method to Handle activityReport Report module regression testing.
	 */
	public boolean activityReport(WebDriver driver) throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Activity Report']"))).click();
		// set preference to download the file in C:\Temp file
		// Waiting for the element Export to excel 
//		WebElement wb = driver.findElement(By.xpath("//button[@class='btn btn-outline-primary']"));
//		wait.until(ExpectedConditions.elementToBeClickable(wb));
//		
//		// once the element Export to excel is visible, click on it .
//		wb.click();
//		
//		// Directory check  for file downloaded location 
//		boolean fileDownloaded = this.isFileDownloaded_Ext("C:\\Users\\rajrajm\\Downloads\\", "xls");
//
//		
//		// if file is downloaded then find the lates file 
//		if(fileDownloaded) {
//			File latestFilefromDir = this.getLatestFilefromDir("C:\\Users\\rajrajm\\Downloads\\");
//			System.out.println(latestFilefromDir);
//		}
		return commonElements(driver);
	}
	
	// Application detail report
	
	/**
	 * @param driver
	 * @throws InterruptedException
	 * @Method to Handle applicationDetail Report module regression testing.

	 */
	public boolean applicationDetail(WebDriver driver) throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Application Detail Report']"))).click();
		// set preference to download the file in C:\Temp file
		// Waiting for the element Export to excel 
//		WebElement wb = driver.findElement(By.xpath("//button[@class='btn btn-outline-primary']"));
//		wait.until(ExpectedConditions.elementToBeClickable(wb));
//		
//		// once the element Export to excel is visible, click on it .
//		wb.click();
//		
//		// Directory check  for file downloaded location 
//		boolean fileDownloaded = this.isFileDownloaded_Ext("C:\\Users\\rajrajm\\Downloads\\", "xls");
//
//		
//		// if file is downloaded then find the lates file 
//		if(fileDownloaded) {
//			File latestFilefromDir = this.getLatestFilefromDir("C:\\Users\\rajrajm\\Downloads\\");
//			System.out.println(latestFilefromDir);
//		}
		return commonElements(driver);
	}
	
	public static boolean commonElements(WebDriver driver) {
		boolean returnTrue = false;
		try {
			WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("reports-page-num")));
			//driver.findElement(By.id("report-export-to-excel")).isDisplayed();
			if(element != null)
				returnTrue = true;
		} catch(NoSuchElementException nsee) {
		} catch(TimeoutException te) {
		}
		
		try {
			WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("numPages2")));
			if(element != null)
				returnTrue = true;
		} catch(NoSuchElementException nsee) {
		} catch(TimeoutException te) {
		}			
		
		if(!returnTrue) {
			try {
				WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'There are no results to display.')]"));
				if(element != null)
					returnTrue = true;
			} catch(NoSuchElementException nsee) {
			}
		}
		return returnTrue;
	}
	
	/**
	 * @param dirPath
	 * @param ext
	 * @return
	 * Check the file from a specific directory with extension
	 */
	private boolean isFileDownloaded_Ext(String dirPath, String ext){
		boolean flag=false;
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        flag = false;
	    }
	    
	    for (int i = 1; i < files.length; i++) {
	    	if(files[i].getName().contains(ext)) {
	    		flag=true;
	    	}
	    }
	    return flag;
	}
	
	
	
	/**
	 * @param dirPath
	 * @return
	 * Get the latest file from a specific directory (getLatestFilefromDir)
	 */
	private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
}
