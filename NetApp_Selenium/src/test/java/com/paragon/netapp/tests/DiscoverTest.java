package com.paragon.netapp.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netapp.ads.discover.ControllerRelease;
import com.netapp.ads.discover.DiscoverWorkPackages;
import com.netapp.ads.discover.DiscoverManualFunctions;
import com.netapp.ads.utils.XLUtility;;;

/**
 * @author Singprad
 * To validate Discover Controller Release and Controller WorkPackage.
 */
public class DiscoverTest extends LoginTest {

	DiscoverWorkPackages discoverWorkPackages = new DiscoverWorkPackages();
	ControllerRelease controllerRelease = new ControllerRelease();
	DiscoverManualFunctions discoverManualFunctions = new DiscoverManualFunctions();
	
	/**
	 * @param Workpack
	 * @param SourceController
	 * @param Assettag
	 * @param InstallDate
	 * @throws InterruptedException
	 */
	//@Test(dataProvider = "ControllerWorkPackage", priority = 6)
	public void testCreateWorkPackage(String workPackage, String sourceController, String assetTag, String installDate) throws InterruptedException {
		discoverWorkPackages.pageReach(driver);
		boolean retVal = discoverWorkPackages.createWorkPackage(driver, workPackage, sourceController, assetTag, installDate);
		Assert.assertEquals(retVal, true);
	}

	/**
	 * @param SourceController
	 * @throws InterruptedException
	 */
	//@Test(dataProvider = "ControllerRelease", priority = 8)
	public void testCreateControllerRelease(String sourceController) throws InterruptedException {
		controllerRelease.pageReach(driver);
		boolean retVal = controllerRelease.createControllerRelease(driver, sourceController);
		Assert.assertEquals(retVal, true);
	}
	
	/**
	 * @param SourceController
	 * @throws InterruptedException
	 */
	//@Test(dataProvider = "ControllerRelease", priority = 10)
	public void testDeleteControllerRelease(String sourceController) throws InterruptedException {
		controllerRelease.pageReach(driver);
		boolean retVal = controllerRelease.deleteControllerRelease(driver, sourceController);
		Assert.assertEquals(retVal, true);
	}


	/**
	 * @param SourceController
	 * @throws InterruptedException
	 */
	//@Test(dataProvider = "ControllerWorkPackage", priority = 12)
	public void testDeleteWorkPackage(String workPackage, String sourceController, String assetTag, String installDate) throws InterruptedException {
		discoverWorkPackages.pageReach(driver);
		boolean retVal = discoverWorkPackages.deleteWorkPackage(driver, workPackage, sourceController, assetTag, installDate);
		Assert.assertEquals(retVal, true);
	}
	
	/**
	 * @throws InterruptedException
	 */
	//@Test(priority = 5)
	public void testOCIDataLoadAllJobs() throws InterruptedException {
		discoverManualFunctions.pageReach(driver);
		for(int i=1; i<=8; i++) {
			boolean retVal = discoverManualFunctions.ociDataLoadRunJob(driver, i);
			Assert.assertEquals(retVal, true);
		}
	}
	
	/**
	 * @throws InterruptedException
	 */
	@Test(priority = 14)
	public void testLoadActivitiesAndApplications() throws InterruptedException {
		discoverManualFunctions.pageReach(driver);
		int indexOfMessageText = 1;	//If we are also running OCI Data Load then this will be same as i. If not this will be 1
		for(int i=9; i<=12; i++,indexOfMessageText++) {
			boolean retVal = discoverManualFunctions.loadActivitiesAndApplications(driver, i, indexOfMessageText);
			Assert.assertEquals(retVal, true);
		}
	}

	@DataProvider(name = "ControllerWorkPackage")
	public String[][] getData2() throws Exception {
		String[][] data = XLUtility.getData("ControllerWorkPackage", "TestData.xls");
		return data;
	}

	@DataProvider(name = "ControllerRelease")
	public String[][] getData3() throws Exception {
		String[][] data = XLUtility.getData("ControllerRelease", "TestData.xls");
		return data;
	}

}
