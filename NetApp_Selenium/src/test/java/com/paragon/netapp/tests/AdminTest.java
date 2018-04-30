package com.paragon.netapp.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netapp.ads.admin.AdminNativeUser;
import com.netapp.ads.admin.AdminReport;
import com.netapp.ads.admin.ApplicationProperties;
import com.netapp.ads.admin.DisplayPreferences;
import com.netapp.ads.admin.OperationalOverride;
import com.netapp.ads.utils.XLUtility;

/**
 * @author Singprad
 * 
 * All Methods called here from Admin Module for further executions.
 *
 */
public class AdminTest extends LoginTest {

	private Logger log = LoggerFactory.getLogger(AdminTest.class);
	ApplicationProperties appProperties = new ApplicationProperties();
	AdminNativeUser adminNativeUser = new AdminNativeUser();
	
	@Test(priority=6) 
	public void testOperationalOverride() {
		log.info("Running test for Admin: Operational Override");
		OperationalOverride operationalOverride = new OperationalOverride();
		operationalOverride.pageReach(driver);
		operationalOverride.operationalOverride(driver);
	}
	
	@Test(dataProvider = "CreateNativeUsers", priority=8)
	public void createNativeUser(String username, String firstname, String lastname, String password, String confirmpassword, String email, String role, String enabled) throws Exception {
		adminNativeUser.pageReach(driver);
		boolean returnVal = adminNativeUser.createNativeUser(driver, username, firstname, lastname, password, confirmpassword, email, role, enabled);
		Assert.assertEquals(returnVal, true);
	}

	/**
	 * @param changename
	 * @throws Exception
	 *             To Delete specified user from native user management.
	 */
	@Test(dataProvider = "CreateNativeUsers", priority=10)
	public void deleteNativeUser(String username, String firstname, String lastname, String password, String confirmpassword, String email, String role, String enabled) throws Exception {
		adminNativeUser.pageReach(driver);
		boolean returnVal = adminNativeUser.deleteNativeUser(driver, email);
		Assert.assertEquals(returnVal, true);
	}
	
	@DataProvider(name = "CreateNativeUsers")
	public String[][] getCreateUserData() throws Exception {
		String[][] data = XLUtility.getData("CreateNativeUsers", "TestData.xls");
		return data;
	}
	
	//@Test(priority=12) 
	public void testDisplayPreferences() {
		log.info("Running test for Admin: Property Preferences");
		DisplayPreferences dispPrefs = new DisplayPreferences();
		dispPrefs.pageReach(driver);
		boolean retVal = dispPrefs.setDisplayPreferences(driver);
	}
	
	@Test(priority=14)
	public void testApplicationProperties() {
		log.info("Running test for Admin: Application Properties");
		appProperties.pageReach(driver);
		boolean retVal = appProperties.updateApplicationProperty(driver);
		Assert.assertEquals(retVal, true);
	}
		  
	@Test(priority=16)	
	public void testAdminReports() {
		log.info("Running test for Admin: Reports");
		AdminReport adminReport = new AdminReport();
		adminReport.pageReach(driver);
		boolean retVal = adminReport.testNativeUserReport(driver);
		Assert.assertEquals(retVal, true);
	}
}
	

