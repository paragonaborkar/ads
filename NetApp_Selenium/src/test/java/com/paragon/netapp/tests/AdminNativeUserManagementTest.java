package com.paragon.netapp.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.netapp.ads.admin.AdminNativeUser;
import com.netapp.ads.utils.XLUtility;

public class AdminNativeUserManagementTest extends LoginTest {

	AdminNativeUser adminNativeUser = new AdminNativeUser();
	
	/**
	 * @param username
	 * @param firstname
	 * @param lastname
	 * @param password
	 * @param confirmpassword
	 * @param email
	 * @param role
	 * @param enabled
	 * @throws Exception
	 *             Methods Called here for User Creation
	 * 
	 */
	//@Test(dataProvider = "CreateNativeUsers", priority=5)
	public void createNativeUser(String username, String firstname, String lastname, String password, String confirmpassword, String email, String role, String enabled) throws Exception {
		adminNativeUser.pageReach(driver);
		boolean returnVal = adminNativeUser.createNativeUser(driver, username, firstname, lastname, password, confirmpassword, email, role, enabled);
		Assert.assertEquals(returnVal, true);
	}

	@DataProvider(name = "CreateNativeUsers")
	public String[][] getCreateUserData() throws Exception {
		String[][] data = XLUtility.getData("CreateNativeUsers", "TestData.xls");
		return data;
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
}