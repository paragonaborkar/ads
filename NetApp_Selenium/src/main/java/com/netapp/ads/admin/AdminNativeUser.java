package com.netapp.ads.admin;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
		log.debug("Refreshing page");
		//driver.navigate().refresh();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("adminDropdown")));
		driver.findElement(By.id("adminDropdown")).click();
		driver.findElement(By.id("admin-user-mgmt")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("admin-btn-add-user")));
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
	public boolean createNativeUser(WebDriver driver, String username, String firstname, String lastname, String password, String confirmpassword, String email, String role, String enabled) throws Exception {
		log.debug("Clicking Add");
		driver.findElement(By.id("admin-btn-add-user")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("txtUserName")));
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
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("admin-btn-add-user")));
		log.debug("Checking if user was created successfully");
		WebElement webElement = ProjectUtility.findRowInDataTable(driver, email);
		return (webElement != null);
		//WebElement rowWithName = name.findElement(By.xpath("./.."));//Select the parent node, i.e., tr, of the td with text NAME
		////datatable-row-wrapper[8]/datatable-body-row/div[2]/datatable-body-cell/div
/*		ResultSet rs = DatabaseManager.verifyUserinDB(username);
		while (rs.next()) {
			// Verifying in DB with each record added.
			if (username.equals(rs.getString("user_name")) && firstname.equals(rs.getString("first_name"))
					&& lastname.equals(rs.getString("last_name")) && role.equals(rs.getString("user_role_id"))
					&& enabled.equals(rs.getString("enabled")) && email.equals(rs.getString("email"))) {
				System.out.println("*********************Created User is present in Database**********************");
				break;
				
			} else {
				Assert.assertTrue(false);
			
			}
		}*/
	}
	
	/**
	 * @param driver
	 * @param changename
	 * @throws Exception
	 * @author Singprad To edit User Details under Admin/User Management.
	 */
	public boolean editNativeUser(WebDriver driver, String changename) throws Exception {

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
		return true;
	}

	/**
	 * @param driver
	 * @param changename
	 * @throws Exception
	 * @author Singprad: Method is for Password Changes in admin native User module.
	 */
	public boolean changeNativeUserPassword(WebDriver driver, String changename) throws Exception {
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
		return true;
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
		log.debug("Number of rows before: " + ProjectUtility.getTableRowCount(driver));
		try { 
			row = ProjectUtility.findRowInDataTable(driver, userToDelete);	
		} catch(org.openqa.selenium.StaleElementReferenceException ex) {
			row = ProjectUtility.findRowInDataTable(driver, userToDelete);
		}
		
		if(row != null) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//datatable-footer//a[contains(@aria-label,'go to next page')]")));
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
				//new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//native-user-delete//button[@class='btn btn-primary']")));
				//WebElement deleteButton = driver.findElement(By.xpath("//native-user-delete//button[@class='btn btn-primary']"));
				WebElement deleteButton = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("btnNativeUserDeleteConfirmed")));
				deleteButton.click();
				WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//datatable-footer//a[contains(@aria-label,'go to next page')]")));
				log.debug("Displayed: " + element.isDisplayed() + ", Enabled: " + element.isEnabled());
				log.debug("Number of rows after: " + ProjectUtility.getTableRowCount(driver));
				log.debug("Delete hit. Now checking if user was removed");
			}
			
			WebElement deletedRow = ProjectUtility.findRowInDataTable(driver, userToDelete);
			
			return (deletedRow == null);
		} else {
			return false;
		}
		 
	}
}
