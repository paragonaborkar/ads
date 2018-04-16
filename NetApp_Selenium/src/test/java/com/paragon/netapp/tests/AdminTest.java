package com.paragon.netapp.tests;

import org.testng.annotations.Test;

import com.netapp.ads.admin.AdminReport;
import com.netapp.ads.admin.ApplicationProperties;
import com.netapp.ads.admin.ManualFunctions;
import com.netapp.ads.admin.PropertyPreferences;

/**
 * @author Singprad
 * 
 * All Methods called here from Admin Module for further executions.
 *
 */
public class AdminTest extends BaseTest{

	
	 @Test(priority=7)
		 
		 public void ApplicationAdmin() throws InterruptedException {
			 
			 ApplicationProperties.ApplicationProp(driver);
		 }
		 
	 @Test(priority=8)
	 
	 public void PropertyAdmin() throws InterruptedException {
		 
		 PropertyPreferences.PropertyPref(driver);
	 }
		 
	 
 @Test(priority=9)
	 
	 public void ManualAdmin() throws InterruptedException {
		 
		ManualFunctions.ManualAdmin(driver);
	 }
		 
@Test(priority=10)
		
public void ReportAdmin() throws InterruptedException
{
	AdminReport.Reportexcel(driver);
}
	}
	

