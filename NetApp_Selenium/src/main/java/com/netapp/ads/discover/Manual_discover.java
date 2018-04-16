package com.netapp.ads.discover;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Manual_discover {

	/**
	 * @param driver
	 * @param Workpack
	 * @param SourceController
	 * @param Assettag
	 * @param InstallDate
	 * @throws InterruptedException
	 * Method to handle Controller WorkPackage in Discover Module....
	 */
	public static void Workpack(WebDriver driver, String Workpack, String SourceController, String Assettag,
			String InstallDate) throws InterruptedException {

		driver.findElement(By.linkText("Discover")).click();

		driver.findElement(By.partialLinkText("Controller Work Packages")).click();

		driver.findElement(By.xpath(".//div/div/div[1]/div[2]/div/button")).click();



		driver.findElement(By.name("workPackageName")).sendKeys(Workpack);

		WebElement ControllerWork = driver.findElement(By.name("controllerName"));

		ControllerWork.sendKeys(SourceController);

		ControllerWork.sendKeys(Keys.TAB);

		driver.findElement(By.name("assetNumber")).sendKeys(Assettag);

		driver.findElement(By.name("controllerInstalledDate")).sendKeys(InstallDate);

		Select priority = new Select(driver.findElement(By.name("priority")));

		priority.selectByIndex(1);



		driver.findElement(By.xpath(".//*[@class='btn btn-primary' and text()='Create']")).click();



	}

	public static void DeleteController(WebDriver driver, String SourceController) throws InterruptedException {

		driver.findElement(By.linkText("Discover")).click();

		driver.findElement(By.partialLinkText("Controller Work Packages")).click();
		List<WebElement> allNames = driver
				.findElements(By.xpath(".//datatable-body-row/div[2]/datatable-body-cell[1]/div"));
		WebElement wb = driver.findElement(By.xpath("//a[contains(@aria-label,'go to next page')]"));

		boolean found = false;
		while (wb.isEnabled()) {
			for (int j = 0; j < allNames.size(); j++) {
				Thread.sleep(1000);
				if (allNames.get(j).getText().equalsIgnoreCase(SourceController)) {
					System.out.println("inside true part");

					j = j + 1;
			
					driver.findElement(By.xpath("(.//*[@class='btn btn-sm btn-warning'])[" + j + "]")).click();
			
					found = true;
			
					driver.findElement(By.xpath("//*[@class='modal-footer']//*[text()='Delete']")).click();
			
					break;

				}

			}

			if (found == false) {
				wb.click();
			}

		}
	}

}
