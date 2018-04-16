package com.netapp.ads.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage

{
	/**
	 * @param driver
	 * @param username
	 * @param password
	 * @return
	 * @throws InterruptedException
	 * Method to Login to Application with Valid and Invalid test data credentials.
	 */
	public static String loginToApp(WebDriver driver, String username, String password) throws InterruptedException {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.id("pwd1")).clear();
		driver.findElement(By.id("pwd1")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		boolean displayed;
		try {
			displayed = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).isDisplayed();
		} catch (Exception e) {
			displayed = false;
		}
		if (displayed) {
			return "Fail";

		} else {
			return "Pass";
		}
	}

	public static void logoutFromApp(WebDriver driver) throws InterruptedException {


		driver.findElement(By.xpath("//i[@class='fa fa-sign-out']")).click();

		driver.close();

	}

}
