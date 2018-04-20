package com.paragon.netapp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netapp.ads.login.LoginPage;
import com.netapp.ads.utils.XLUtility;

/**
 * @author Singprad
 *
 */
public class LoginTest extends BaseTest {
	
	/**
	 * @param iusername
	 * @param ipassword
	 * @param username
	 * @param password
	 * @throws Exception
	 *             for login to the application as a TestCase01...............
	 */
	@Test(dataProvider = "LoginUsers", priority = 1)
	public void testLogin(String iusername, String ipassword, String username, String password) throws Exception {
		LoginPage.loginToApp(driver, iusername, ipassword);
		driver.navigate().refresh();
		LoginPage.loginToApp(driver, username, password);
		WebElement homeLink = driver.findElement(By.id("nav-bar-home"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(homeLink));
	}

	@DataProvider(name = "LoginUsers")
	public String[][] getData() throws Exception {
		String[][] data = XLUtility.getData("LoginUsers", "TestData.xls");
		return data;
	}
}
