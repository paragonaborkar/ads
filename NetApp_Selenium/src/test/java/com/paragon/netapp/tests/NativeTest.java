package com.paragon.netapp.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paragaon.netapp.adminModule.EditDeletePassChange;
import com.paragaon.netapp.adminModule.NativeUser;
import com.paragon.netapp.projectUtils.XLUtility;

public class NativeTest extends BaseTest {

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
	@Test(dataProvider = "TestUserScenarios")
	public void userTest(String username, String firstname, String lastname, String password, String confirmpassword,
			String email, String role, String enabled) throws Exception {

		NativeUser.newUserCreation(driver, username, firstname, lastname, password, confirmpassword, email, role,
				enabled);

	}

	@DataProvider(name = "TestUserScenarios")
	public String[][] getData1() throws Exception {
		String[][] data = XLUtility.getData("TestUserScenarios", "TestData.xls");
		return data;
	}

	/**
	 * @param changename
	 * @throws Exception
	 *             To Edit the User Details from native user management..
	 */
	@Test(dataProvider = "EditData")
	public void editTest(String changename) throws Exception {
		Thread.sleep(5000);
		EditDeletePassChange.editUserdetails(driver, changename);
		Thread.sleep(5000);

	}

	/**
	 * @param changename
	 * @throws Exception
	 *             * To change the Password from native user management.
	 */
	@Test(dataProvider = "EditData")
	public void passwordTest(String changename) throws Exception {
		Thread.sleep(5000);
		EditDeletePassChange.passwordDetails(driver, changename);
		Thread.sleep(5000);

	}

	/**
	 * @param changename
	 * @throws Exception
	 *             To Delete specified user from native user management.
	 */
	@Test(dataProvider = "EditData", priority = 3)
	public void deleteTest(String changename) throws Exception {
		Thread.sleep(5000);
		EditDeletePassChange.deleteUserdetails(driver, changename);
		Thread.sleep(5000);
	}

	@DataProvider(name = "EditData")
	public String[][] getData2() throws Exception {
		String[][] data = XLUtility.getData("EditData", "TestData.xls");

		return data;
	}
}