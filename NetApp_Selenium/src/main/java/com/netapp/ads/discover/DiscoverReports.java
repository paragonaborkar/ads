package com.netapp.ads.discover;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DiscoverReports {
	

	public WebDriverWait wait;
	// Discover page Reach
	public void pageReach(WebDriver driver) throws InterruptedException {
		
				driver.findElement(By.linkText("Discover")).click();
				
		// Go to Reports 
				driver.findElement(By.linkText("Reports")).click();
				
		
	}
	// Callme Report Test
	/**
	 * @param driver
	 * @throws InterruptedException
	 * @Method to Handle Call Me Report module regression testing.
	 */
	public void callMeReport(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Call Me Report']")).click();
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
		driver.findElement(By.xpath("//button[@class='btn btn-outline-secondary']")).click();
		
	}
	
	
	// UnknownOwnerReport Test
	/**
	 * @param driver
	 * @throws InterruptedException
	 * @Method to Handle unknownOwnerReport Report module regression testing.
	 */
	public void unknownOwnerReport(WebDriver driver) throws InterruptedException{
		System.out.println("Unknown Owner report is called ");

		driver.findElement(By.xpath("//*[text()='Unknown Owner Report']")).click();

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
		driver.findElement(By.xpath("//button[@class='btn btn-outline-secondary pull-left']")).click();
		
	}
	
	
	//Voulume DecomissionReport Test
	/**
	 * @param driver
	 * @throws InterruptedException
	 * @Method to Handle unknownOwnerReport Report module regression testing.
	 * 
	 */
	public void volumeDecommision(WebDriver driver ) throws InterruptedException {
		System.out.println("Voulme Decommision report is called ");

		driver.findElement(By.xpath("//*[text()='Volume Decommission Report']")).click();

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
		driver.findElement(By.xpath("//button[@class='btn btn-outline-secondary']")).click();
		
	
	}
	
	// Multiowner report test
	/**
	 * @param driver
	 * @throws InterruptedException
	 * @Method to Handle multiOwner Report module regression testing.
	 */
	public void multiOwner(WebDriver driver) throws InterruptedException {
		System.out.println("MultiOwner report is called ");

		driver.findElement(By.xpath("//*[text()='Multi Owner Report']")).click();

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
		driver.findElement(By.xpath("//button[@class='btn btn-outline-secondary']")).click();
		
	}
	
	// Activity report test
	/**
	 * @param driver
	 * @throws InterruptedException
	 * @Method to Handle activityReport Report module regression testing.
	 */
	public void activityReport(WebDriver driver) throws InterruptedException {
		System.out.println("Activity report is called ");

		driver.findElement(By.xpath("//*[text()='Activity Report']")).click();

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
		driver.findElement(By.xpath("//button[@class='btn btn-outline-secondary pull-left']")).click();
		
	}
	
	// Application detail report
	
	/**
	 * @param driver
	 * @throws InterruptedException
	 * @Method to Handle applicationDetail Report module regression testing.

	 */
	public void applicationDetail(WebDriver driver) throws InterruptedException {
		System.out.println("Application Detail report is called ");

		driver.findElement(By.xpath("//*[text()='Application Detail Report']")).click();

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
		driver.findElement(By.xpath("//button[@class='btn btn-outline-secondary pull-left']")).click();
		
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
