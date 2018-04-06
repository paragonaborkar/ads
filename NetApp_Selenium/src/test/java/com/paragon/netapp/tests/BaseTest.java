package com.paragon.netapp.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.paragon.netapp.modules.LoginPage;
import com.paragon.netapp.projectUtils.ProjectUtility;

public class BaseTest {
	public static WebDriver driver;
	public WebDriverWait wait;

	/**
	 * @throws Exception
	 * @author Singprad
	 * This is a Base Method to Launch any of the Web Browser as user need.
	 */
	@BeforeSuite
	public void launchBrowser() throws Exception {
		String browser = ProjectUtility.getProperty("Browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setProxy(null);

			System.setProperty("webdriver.chrome.driver",
					".\\src\\main\\resources\\com\\paragon\\resources\\drivers\\chromedriver.exe");

			driver = new ChromeDriver(options);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new InternetExplorerDriver();
		}

		wait = new WebDriverWait(driver, 30);

	}

	/**
	 * @throws Exception
	 * To launch the Application Under Test
	 */
	@BeforeTest
	public void launchApp() throws Exception {
		String APPURL = ProjectUtility.getProperty("URL");
		driver.get(APPURL);
	}

	/**
	 * @throws InterruptedException
	 * To logout from the Application Under Test.
	 * @author Singprad
	 */
	@AfterSuite
	public void logout() throws InterruptedException {
		LoginPage.logoutFromApp(driver);
	}
}