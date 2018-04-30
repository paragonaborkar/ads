package com.netapp.ads.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public static boolean loginToApp(WebDriver driver, String username, String password) throws InterruptedException {
		//WebElement userNameElement = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("username")));
		WebElement userNameElement = driver.findElement(By.id("username"));
		userNameElement.clear();
		userNameElement.sendKeys(username);
		
		WebElement passwordElement = driver.findElement(By.id("pwd1"));
		passwordElement.clear();
		passwordElement.sendKeys(password);
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		boolean displayed;
		try {
			displayed = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).isDisplayed();
		} catch (Exception e) {
			displayed = false;
		}
		if (displayed) {
			return false;
		} else {
			return true;
		}
	}

	public static void logoutFromApp(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//i[@class='fa fa-sign-out']")).click();
		driver.close();
	}

}
