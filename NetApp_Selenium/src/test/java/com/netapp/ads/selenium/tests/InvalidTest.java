package com.netapp.ads.selenium.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netapp.ads.admin.InvalidScenario;
import com.netapp.ads.utils.XLUtility;

/**
 * @author Singprad Methods called to Validate invalid scenario.
 *
 */
public class InvalidTest extends BaseTest {

	/**
	 * @param username
	 * @param firstname
	 * @param lastname
	 * @param password
	 * @param confirmpassword
	 * @param email
	 * @param role
	 * @param enabled
	 * @throws InterruptedException
	 */
	//@Test(dataProvider = "invalidData")
	public void InvalidScenario(String username, String firstname, String lastname, String password,
			String confirmpassword, String email, String role, String enabled) throws InterruptedException {

		InvalidScenario.WithoutValues(driver);
		InvalidScenario.WithSomeData(driver, username, firstname, lastname);
		InvalidScenario.InValidData(driver, username, firstname, lastname, email, role, enabled);
		InvalidScenario.ExistingDataCreate(driver, username, firstname, lastname, password, confirmpassword, email,
				role, enabled);
		InvalidScenario.ExistingDataVerify(driver, username, firstname, lastname, password, confirmpassword, email,
				role, enabled);

	}

	//@DataProvider(name = "invalidData")
	public String[][] getData1() throws Exception {
		String[][] data = XLUtility.getData("InvalidData", "TestData.xls");

		return data;

	}

}
