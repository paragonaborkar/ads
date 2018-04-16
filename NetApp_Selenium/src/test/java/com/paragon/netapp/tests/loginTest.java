package com.paragon.netapp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netapp.ads.login.LoginPage;
import com.netapp.ads.utils.XLUtility;

/**
 * @author Singprad
 *
 */
public class loginTest extends BaseTest

{
	/**
	 * @param iusername
	 * @param ipassword
	 * @param username
	 * @param password
	 * @throws Exception
	 *             for login to the application as a TestCase01...............
	 */

	@Test(dataProvider = "LoginTest", priority = 1)
	public void TestCase01(String iusername, String ipassword, String username, String password) throws Exception {
		LoginPage.loginToApp(driver, iusername, ipassword);

		driver.navigate().refresh();

		LoginPage.loginToApp(driver, username, password);

		WebElement wb = driver.findElement(By.partialLinkText("Home"));

		wait.until(ExpectedConditions.elementToBeClickable(wb));

	}

	@DataProvider(name = "LoginTest")
	public String[][] getData() throws Exception {
		String[][] data = XLUtility.getData("loginTest", "TestData.xls");

		return data;
	}
}
