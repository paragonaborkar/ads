package com.paragaon.netapp.adminModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class InvalidScenario {
	
	/**
	 * @param driver
	 * @throws InterruptedException
	 * ValidationWith no data in create user page
	 */
	public static void WithoutValues(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath(".//*[@id='adminDropdown']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Native User Management']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Add User']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("userName")).clear();
		Thread.sleep(3000);
		driver.findElement(By.name("firstName")).clear();
		Thread.sleep(3000);
		driver.findElement(By.name("lastName")).clear();
		Thread.sleep(3000);
		driver.findElement(By.name("password")).clear();
		Thread.sleep(3000);
		driver.findElement(By.name("passwordConfirm")).clear();
		Thread.sleep(5000);
		WebElement email = driver.findElement(By.name("email"));
		email.clear();
//		email.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		
			
		WebElement a= driver .findElement(By.xpath("(.//div[@class='invalid-feedback'])[2]"));
		
		Thread.sleep(5000);
		
		String text = a.getText();
			if(text.equalsIgnoreCase("Confirm Password is required")) 
		{
			
			Thread.sleep(5000);
			 driver.findElement(By.cssSelector("button.close.pull-right")).click();
			 Thread.sleep(5000);
			
			
		}
			
		}
		
		
	

/**
 * @param driver
 * @param username
 * @param firstname
 * @param lastname
 * @throws InterruptedException
 * To validate Add user page with some data
 */
public static void WithSomeData(WebDriver driver,String username, String firstname, String lastname) throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='adminDropdown']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Native User Management']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Add User']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.name("firstName")).clear();
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		Thread.sleep(3000);
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		Thread.sleep(3000);
		driver.findElement(By.name("password")).clear();
		Thread.sleep(3000);
		driver.findElement(By.name("passwordConfirm")).clear();
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.name("email"));
		email.clear();
//		email.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		
			
		WebElement a= driver .findElement(By.xpath("(.//div[@class='invalid-feedback'])[2]"));
		
		Thread.sleep(5000);
		
		String text = a.getText();
			if(text.equalsIgnoreCase("Confirm Password is required")) 
		{
			
			Thread.sleep(5000);
			 driver.findElement(By.cssSelector("button.close.pull-right")).click();
			 Thread.sleep(5000);
			
			
		}
			
		}
		
		



/**
 * @param driver
 * @param username
 * @param firstname
 * @param lastname
 * @param email
 * @param role
 * @param enabled
 * @throws InterruptedException
 * To validate Add user page with Invalid data
 */
public static void InValidData(WebDriver driver,String username, String firstname, String lastname,String email, String role, String enabled) throws InterruptedException {
	
	Thread.sleep(3000);
	driver.findElement(By.xpath(".//*[@id='adminDropdown']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[text()='Native User Management']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[text()='Add User']")).click();

	Thread.sleep(3000);
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
	driver.findElement(By.name("password")).sendKeys("12345");
	driver.findElement(By.name("passwordConfirm")).clear();
	driver.findElement(By.name("passwordConfirm")).sendKeys("#&^!#*&*!#");
	Thread.sleep(5000);
	driver.findElement(By.name("email")).clear();
	driver.findElement(By.name("email")).sendKeys(email);
	Select dropdown = new Select(driver.findElement(By.name("userRole")));
	dropdown.selectByVisibleText(role);
	Select dropdown1 = new Select(driver.findElement(By.name("user.enabled")));
	dropdown1.selectByVisibleText(enabled);

	//driver.findElement(By.xpath("//*[@class='modal-footer']//*[text()='Create User']")).click();

	Thread.sleep(3000);

	WebElement a= driver.findElement(By.xpath("(.//div[@class='invalid-feedback'])[1]"));
	
	Thread.sleep(5000);
	
	String text = a.getText();
		if(text.equalsIgnoreCase("Passwords must match")) 
	{
		
		Thread.sleep(5000);
		 driver.findElement(By.cssSelector("button.close.pull-right")).click();
		 Thread.sleep(5000);
		
		
	}
		
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
 * @throws InterruptedException
 * To validate Add user page with Existing data by creating
 */
public static void ExistingDataCreate(WebDriver driver, String username, String firstname, String lastname,
		String password, String confirmpassword, String email, String role, String enabled) throws InterruptedException {
	
	Thread.sleep(3000);
	driver.findElement(By.xpath(".//*[@id='adminDropdown']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[text()='Native User Management']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[text()='Add User']")).click();

	Thread.sleep(3000);
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
	driver.findElement(By.name("passwordConfirm")).clear();
	driver.findElement(By.name("passwordConfirm")).sendKeys(confirmpassword);
	Thread.sleep(5000);
	driver.findElement(By.name("email")).clear();
	driver.findElement(By.name("email")).sendKeys(email);
	Select dropdown = new Select(driver.findElement(By.name("userRole")));
	dropdown.selectByVisibleText(role);
	Select dropdown1 = new Select(driver.findElement(By.name("user.enabled")));
	dropdown1.selectByVisibleText(enabled);

	driver.findElement(By.xpath("//*[@class='modal-footer']//*[text()='Create User']")).click();


	Thread.sleep(5000);
	 driver.findElement(By.cssSelector("button.close.pull-right")).click();
	 Thread.sleep(5000);

	
	
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
 * @throws InterruptedException
 * To validate Add user page with Existing data
 */
public static void ExistingDataVerify(WebDriver driver, String username, String firstname, String lastname,
		String password, String confirmpassword, String email, String role, String enabled) throws InterruptedException {
	
	Thread.sleep(3000);
	driver.findElement(By.xpath(".//*[@id='adminDropdown']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[text()='Native User Management']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[text()='Add User']")).click();

	Thread.sleep(3000);
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
	driver.findElement(By.name("passwordConfirm")).clear();
	driver.findElement(By.name("passwordConfirm")).sendKeys(confirmpassword);
	Thread.sleep(5000);
	driver.findElement(By.name("email")).clear();
	driver.findElement(By.name("email")).sendKeys(email);
	Select dropdown = new Select(driver.findElement(By.name("userRole")));
	dropdown.selectByVisibleText(role);
	Select dropdown1 = new Select(driver.findElement(By.name("user.enabled")));
	dropdown1.selectByVisibleText(enabled);

	driver.findElement(By.xpath("//*[@class='modal-footer']//*[text()='Create User']")).click();

	Thread.sleep(3000);
	
	WebElement errorAlert=driver.findElement(By.xpath(".//div[@class='alert alert-danger']"));
Thread.sleep(5000);
	
	String text = errorAlert.getText();
		if(text.equalsIgnoreCase("Sorry,an application error has occured")) 
	{
		
		Thread.sleep(5000);
		 driver.findElement(By.cssSelector("button.close.pull-right")).click();
		 Thread.sleep(5000);
		
		
	}
		
	}
}



