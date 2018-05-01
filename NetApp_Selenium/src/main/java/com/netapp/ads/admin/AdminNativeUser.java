package com.netapp.ads.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netapp.ads.utils.ProjectUtility;

public class AdminNativeUser {
	
	private static Logger log = LoggerFactory.getLogger(AdminNativeUser.class);
	
	// Discover page Reach
	public void pageReach(WebDriver driver) throws InterruptedException {
		log.debug("Navigating to admin page for Native Users");
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("adminDropdown"))).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("admin-user-mgmt"))).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("admin-btn-add-user")));
	}
	
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
	public boolean createNativeUser(WebDriver driver, String username, String firstname, String lastname, String password, String confirmpassword, String email, String role, String enabled) {
		String before = driver.findElement(By.xpath("//div[@class='page-count']")).getText();
		log.debug("Before adding users: {}", before);
		log.debug("Clicking Add");
		driver.findElement(By.id("admin-btn-add-user")).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("txtUserName")));
		log.debug("Adding user data");
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys(username);
		driver.findElement(By.id("txtFirstName")).clear();
		driver.findElement(By.id("txtFirstName")).sendKeys(firstname);
		driver.findElement(By.id("txtLastName")).clear();
		driver.findElement(By.id("txtLastName")).sendKeys(lastname);
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("txtConfirmPassword")).clear();
		driver.findElement(By.id("txtConfirmPassword")).sendKeys(confirmpassword);
		driver.findElement(By.id("txtEmail")).clear();
		driver.findElement(By.id("txtEmail")).sendKeys(email);
		Select roleDropdown = new Select(driver.findElement(By.id("selRole")));
		roleDropdown.selectByVisibleText(role);
		Select enabledDropdown = new Select(driver.findElement(By.id("selEnabled")));
		enabledDropdown.selectByVisibleText(enabled);
		driver.findElement(By.id("btnSubmit")).click();
		log.debug("Hit Save!");
		driver.navigate().refresh();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("admin-btn-add-user")));
		log.debug("Checking if user was created successfully");
		String after = driver.findElement(By.xpath("//div[@class='page-count']")).getText();
		log.debug("After adding users: {}", after);
		//WebElement webElement = ProjectUtility.findRowInDataTable(driver, email);
		return (!before.equals(after));
	}

	/**
	 * @param driver
	 * @param changename
	 * @throws Exception
	 *             To Delete user details from records in Admin User management.
	 * 
	 */
	public boolean deleteNativeUser(WebDriver driver, String userToDelete) throws Exception {
		log.debug("Delete user...Trying to find user");

		WebElement row = null;
		String before = driver.findElement(By.xpath("//div[@class='page-count']")).getText();
		log.debug("Before deleting users: {}", before);
		try { 
			row = ProjectUtility.findRowInDataTable(driver, userToDelete);	
		} catch(org.openqa.selenium.StaleElementReferenceException ex) {
			row = ProjectUtility.findRowInDataTable(driver, userToDelete);
		}
		
		if(row != null) {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//datatable-footer//a[contains(@aria-label,'go to next page')]")));
			//WebElement trashIcon = row.findElement(By.cssSelector(".btn.btn-sm.btn-danger"));
			//WebElement trashIcon = row.findElement(By.xpath(".//button[@class='btn btn-sm btn-danger']"));
 			WebElement trashIcon = null;
 			try {
 				trashIcon = row.findElement(By.id("btnNativeUserDelete"));
 			} catch(NoSuchElementException nsee) {
 				Thread.sleep(2000);
 				trashIcon = row.findElement(By.id("btnNativeUserDelete"));
 			}
			if(trashIcon != null) {
				log.debug("Hitting Trash icon");
				trashIcon.click();
				//WebElement deleteDialog = driver.switchTo().activeElement();
				//new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//native-user-delete//button[@class='btn btn-primary']")));
				//WebElement deleteButton = driver.findElement(By.xpath("//native-user-delete//button[@class='btn btn-primary']"));
				WebElement deleteButton = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("btnNativeUserDeleteConfirmed")));
				deleteButton.click();
				log.debug("Delete hit. Now checking if user was removed");
				driver.navigate().refresh();
				new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("admin-btn-add-user")));
			}
			String after = driver.findElement(By.xpath("//div[@class='page-count']")).getText();
			log.debug("After deleting users: {}", after);
			//WebElement deletedRow = ProjectUtility.findRowInDataTable(driver, userToDelete);
			
			return (!before.equals(after));
		} else {
			return false;
		}
		 
	}
}
