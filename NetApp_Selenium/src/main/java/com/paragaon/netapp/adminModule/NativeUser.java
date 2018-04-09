package com.paragaon.netapp.adminModule;

import java.sql.ResultSet;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.paragon.netapp.projectUtils.DatabaseManager;

public class NativeUser {
	
	/**
	 * @param driver
	 * @param username
	 * @param firstname
	 * @param lastname
	 * @param password
	 * @param confirmpassword
	 * @param email
	 * @param role
	 * @param enabled
	 * @throws Exception
	 * 
	 * Method for Creating a new User in Admin User management using excel utility Test data.
	 * Verifying in DB with each record added.
	 */
	public static void newUserCreation(WebDriver driver, String username, String firstname, String lastname,
			String password, String confirmpassword, String email, String role, String enabled) throws Exception {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='adminDropdown']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Admin User Management']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Add User']")).click();

		Thread.sleep(5000);
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys(username);
		Thread.sleep(5000);
		driver.findElement(By.name("firstName")).clear();
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		Thread.sleep(5000);
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		Thread.sleep(5000);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.name("passwordConfirm")).clear();
		driver.findElement(By.name("passwordConfirm")).sendKeys(confirmpassword);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);
		Select dropdown = new Select(driver.findElement(By.name("userRole")));
		dropdown.selectByVisibleText(role);
		Select dropdown1 = new Select(driver.findElement(By.name("user.enabled")));
		dropdown1.selectByVisibleText(enabled);

		driver.findElement(By.xpath("//*[@class='modal-footer']//*[text()='Create User']")).click();

		Thread.sleep(5000);

		ResultSet rs = DatabaseManager.verifyUserinDB(username);

		while (rs.next()) {
			System.out.println("xl------------------------>DB");
			System.out.println(username + "------------------->" + rs.getString("user_name"));
			System.out.println(firstname + "------------------->" + rs.getString("first_name"));
			System.out.println(lastname + "------------------->" + rs.getString("last_name"));
			System.out.println(role + "------------------->" + rs.getString("user_role_id"));
			System.out.println(enabled + "------------------->" + rs.getString("enabled"));
			System.out.println(email + "------------------->" + rs.getString("email"));

			// Verifying in DB with each record added.
			if (username.equals(rs.getString("user_name")) && firstname.equals(rs.getString("first_name"))
					&& lastname.equals(rs.getString("last_name")) && role.equals(rs.getString("user_role_id"))
					&& enabled.equals(rs.getString("enabled")) && email.equals(rs.getString("email"))) {
				System.out.println("*********************Created User is present in Database**********************");
				break;
				
			} else {
				Assert.assertTrue(false);
			
			}
		}
	}
}
