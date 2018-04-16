package com.netapp.ads.admin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Singprad
 *
 */
public class EditDeletePassChange {

	/**
	 * @param driver
	 * @param changename
	 * @throws Exception
	 * @author Singprad To edit User Details under Admin/User Management.
	 */
	public static void editUserdetails(WebDriver driver, String changename) throws Exception {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='adminDropdown']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Admin User Management']")).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement wb = driver.findElement(By.xpath("//a[contains(@aria-label,'go to next page')]"));
		boolean found = false;
		while (wb.isEnabled()) {
			List<WebElement> allNames = driver
					.findElements(By.xpath(".//datatable-body-row/div[2]/datatable-body-cell[1]/div"));

			for (int i = 0; i < allNames.size(); i++) {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				System.out.println(allNames.get(i).getText());

				if (allNames.get(i).getText().equals(changename)) {

					i = i + 1;
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.findElement(By.xpath("(.//button[@class='btn btn-sm btn-primary'])[" + i + "]")).click();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.findElement(By.name("lastName")).clear();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.findElement(By.name("lastName")).sendKeys("smith1");
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.findElement(By.name("email")).clear();
					driver.findElement(By.name("email")).sendKeys("smith@gmail.com");

					System.out.println("*************************data edited");
					driver.findElement(By.xpath("//button[text()='Save']")).click();
					found = true;
					break;

				}

			}

			if (found == false) {
				wb.click();

			} else if (found == true) {
				break;
			}
		}

	}

	/**
	 * @param driver
	 * @param changename
	 * @throws Exception
	 * @author Singprad: Method is for Password Changes in admin native User module.
	 */
	public static void passwordDetails(WebDriver driver, String changename) throws Exception {
		driver.findElement(By.xpath(".//*[@id='adminDropdown']")).click();
		driver.findElement(By.xpath("//*[text()='Admin User Management']")).click();

		// Clicking on pagination right button(datatable-icon-right).
		WebElement wb = driver.findElement(By.xpath("//a[contains(@aria-label,'go to next page')]"));
		boolean found = false;

		while (!found) // While Not Found.
		{
			while (wb.isEnabled()) // and 'datatable-icon-right' arrow is enabled means still item are left in
									// right side.
			{
				List<WebElement> allNames = driver
						.findElements(By.xpath(".//datatable-body-row/div[2]/datatable-body-cell[1]/div"));

				for (int i = 0; i < allNames.size(); i++) {
					// System.out.println(allNames.get(i).getText());

					if (allNames.get(i).getText().equals(changename)) {

						i = i + 1;
						driver.findElement(By.xpath("(.//*[@class='btn btn-sm btn-warning'])[" + i + "]")).click();
						driver.findElement(By.name("password")).sendKeys("45678");
						driver.findElement(By.name("passwordConfirm")).sendKeys("45678");
						driver.findElement(By.xpath(".//button[@class='btn btn-primary' and text()='Change Password']"))
								.submit();
						found = true;
						break;
					}

				}

				if (found == false) {
					wb.click();
				}

				else if (found == true) {
					break;
				}

			}

		}

	}

	/**
	 * @param driver
	 * @param changename
	 * @throws Exception
	 *             To Delete user details from records in Admin User management.
	 * 
	 */
	public static void deleteUserdetails(WebDriver driver, String changename) throws Exception {
		driver.findElement(By.xpath(".//*[@id='adminDropdown']")).click();
		driver.findElement(By.xpath("//*[text()='Admin User Management']")).click();
		driver.navigate().refresh();
		// Clicking on pagination right button(datatable-icon-right).
		WebElement wb = driver.findElement(By.xpath("//a[contains(@aria-label,'go to next page')]"));
		boolean found = false;

		while (!found) // While Not Found.
		{
			while (wb.isEnabled()) // and 'datatable-icon-right' arrow is enabled means still item are left in
									// right side.
			{
				List<WebElement> allNames = driver
						.findElements(By.xpath(".//datatable-body-row/div[2]/datatable-body-cell[1]/div"));

				for (int i = 0; i < allNames.size(); i++) {
					if (allNames.get(i).getText().equals(changename)) {
						i = i + 1;
						driver.findElement(By.xpath("(.//*[@class='btn btn-sm btn-danger'])[" + i + "]")).click();
						System.out.println("*************************click on delete icon");
						driver.findElement(By.xpath("//button[text()='Delete']")).click();
						found = true;
						break;
					}

				}

				if (found == false) {
					wb.click();
				}

				else if (found == true) {
					break;
				}

			}

		}

	}
}

/*
 * ResultSet rs = DatabaseManager.verifyUserinDB(); if (rs.next()) {
 * System.out.println("Something went wrong"); } else {
 * System.out.println("No Record found in Database"); }
 * 
 * }
 */