package com.paragon.netapp.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.netapp.ads.utils.ProjectUtility;

public class BaseTest {
	public static WebDriver driver;
	//public WebDriverWait wait;

	/**
	 * @throws Exception
	 * @author Singprad
	 * This is a Base Method to Launch any of the Web Browser as user need.
	 */
	@BeforeSuite
	public void launchBrowser() {
		String browser = ProjectUtility.getProperty("Browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setProxy(null);
			System.setProperty("webdriver.chrome.driver",
					".\\src\\main\\resources\\com\\paragon\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(options);
			//driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new InternetExplorerDriver();
		}
	}

	/**
	 * @throws Exception
	 * To launch the Application Under Test
	 */
	@BeforeTest
	public void launchApp() {
		String APPURL = ProjectUtility.getProperty("URL");
		driver.get(APPURL);
	}

	/**
	 * @throws InterruptedException
	 * To logout from the Application Under Test.
	 * @author Singprad
	 */
	@AfterSuite
	public void logout() {
		try {
			driver.findElement(By.xpath("//i[@class='fa fa-sign-out']")).click();
		} catch(NoSuchElementException nsee) {
		} finally {
			driver.close();
			driver.quit();
		}
	}
}