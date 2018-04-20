package com.paragon.netapp.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
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
public class AdminTest extends LoginTest {

	private Logger log = LoggerFactory.getLogger(AdminTest.class);
	
	//@Test(priority=7)
	public void applicationProperties() throws InterruptedException {
		log.info("Running test for Admin: Application Properties");
		ApplicationProperties.ApplicationProp(driver);
	}
		 
	//@Test(priority=8) 
	public void propertyPreferences() throws InterruptedException {
		log.info("Running test for Admin: Property Preferences");
		PropertyPreferences.PropertyPref(driver);
	}
		  
	//@Test(priority=9) 
	public void manualFunctions() throws InterruptedException {
		log.info("Running test for Admin: Manual Functions");
		ManualFunctions.ManualAdmin(driver);
	}
		 
	@Test(priority=10)	
	public void adminReports() throws InterruptedException {
		log.info("Running test for Admin: Reports");
		AdminReport adminReport = new AdminReport();
		adminReport.pageReach(driver);
		boolean retVal = adminReport.testReport(driver);
		Assert.assertEquals(retVal, true);
	}
}
	

