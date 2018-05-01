package com.netapp.ads.selenium.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netapp.ads.discover.ControllerRelease;
import com.netapp.ads.discover.DiscoverManualFunctions;
import com.netapp.ads.discover.DiscoverReports;
import com.netapp.ads.discover.DiscoverWorkPackages;
import com.netapp.ads.utils.XLUtility;;;

/**
 * @author Singprad
 * To validate Discover Controller Release and Controller WorkPackage.
 */
public class DiscoverTest extends LoginTest {

	private Logger log = LoggerFactory.getLogger(DiscoverTest.class);
	DiscoverWorkPackages discoverWorkPackages = new DiscoverWorkPackages();
	ControllerRelease controllerRelease = new ControllerRelease();
	DiscoverManualFunctions discoverManualFunctions = new DiscoverManualFunctions();
	DiscoverReports discoverReports = new DiscoverReports();
	
	/**
	 * @throws InterruptedException
	 */
	@Test(priority = 6)
	public void testOCIDataLoadAllJobs() {
		discoverManualFunctions.pageReach(driver);
		for(int i=1; i<=8; i++) {
			boolean retVal = discoverManualFunctions.ociDataLoadRunJob(driver, i);
			Assert.assertEquals(retVal, true);
		}
	}
	
	/**
	 * @param Workpack
	 * @param SourceController
	 * @param Assettag
	 * @param InstallDate
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "ControllerWorkPackage", priority = 8)
	public void testCreateWorkPackage(String workPackage, String sourceController, String assetTag, String installDate) {
		discoverWorkPackages.pageReach(driver);
		boolean retVal = discoverWorkPackages.createWorkPackage(driver, workPackage, sourceController, assetTag, installDate);
		Assert.assertEquals(retVal, true);
	}

	/**
	 * @param SourceController
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "ControllerRelease", priority = 10)
	public void testCreateControllerRelease(String sourceController) {
		controllerRelease.pageReach(driver);
		boolean retVal = controllerRelease.createControllerRelease(driver, sourceController);
		Assert.assertEquals(retVal, true);
	}
	
	/**
	 * @throws InterruptedException
	 */
	@Test(priority = 12)
	public void testLoadActivitiesAndApplications() {
		discoverManualFunctions.pageReach(driver);
		int indexOfMessageText = 1;	//If we are also running OCI Data Load then this will be same as i. If not this will be 1
		for(int i=9; i<=12; i++,indexOfMessageText++) {
			boolean retVal = discoverManualFunctions.loadActivitiesAndApplications(driver, i, indexOfMessageText);
			Assert.assertEquals(retVal, true);
		}
	}
	
	@Test (priority=18)
	public void callMeTest() throws InterruptedException {
		log.info("Running test for Discover: Call Me Report");
		discoverReports.pageReach(driver);
		boolean returnVal = discoverReports.callMeReport(driver);
		Assert.assertEquals(returnVal, true);
	}

	/**
	 * @throws InterruptedException
	 * uknownOwnerReport
	 */
	@Test (priority=20)
	public void uknownOwnerReport() throws InterruptedException {
		log.info("Running test for Discover: Unknown Report");
		discoverReports.pageReach(driver);
		boolean returnVal = discoverReports.unknownOwnerReport(driver);
		Assert.assertEquals(returnVal, true);
	}

	/**
	 * @throws InterruptedException
	 * volumeDecommisionReport
	 */
	@Test (priority=22)
	public void volumeDecommisionReport() throws InterruptedException {
		log.info("Running test for Discover: Volume Decommission Report");
		discoverReports.pageReach(driver);
		boolean returnVal = discoverReports.volumeDecommision(driver);
		Assert.assertEquals(returnVal, true);
	}

	/**
	 * @throws InterruptedException
	 * activityReport
	 */
	@Test (priority=24)
	public void multiOwnerReport() throws InterruptedException {
		log.info("Running test for Discover: Multi Owner Report");
		discoverReports.pageReach(driver);
		boolean returnVal = discoverReports.multiOwner(driver);
		Assert.assertEquals(returnVal, true);
	}

	/**
	 * @throws InterruptedException
	 * activityReport
	 */
	@Test (priority=26)
	public void activityReport() throws InterruptedException {
		log.info("Running test for Discover: Activity Report");
		discoverReports.pageReach(driver);
		boolean returnVal = discoverReports.activityReport(driver);
		Assert.assertEquals(returnVal, true);
	}

	/**
	 * @throws InterruptedException
	 * applicationDetailReport
	 */
	@Test (priority = 28)
	public void applicationDetailReport() throws InterruptedException {
		log.info("Running test for Discover: Application Report");
		discoverReports.pageReach(driver);
		boolean returnVal = discoverReports.applicationDetail(driver);
		Assert.assertEquals(returnVal, true);
	}
	
	/**
	 * SKIPPING TESTING THIS
	 * 
	 * @param SourceController
	 * @throws InterruptedException
	 */
	//@Test(dataProvider = "ControllerRelease", priority = 10)
	public void testDeleteControllerRelease(String sourceController) {
		controllerRelease.pageReach(driver);
		boolean retVal = controllerRelease.deleteControllerRelease(driver, sourceController);
		Assert.assertEquals(retVal, true);
	}


	/**
	 * SKIPPING TESTING THIS
	 * 
	 * @param SourceController
	 * @throws InterruptedException
	 */
	//@Test(dataProvider = "ControllerWorkPackage", priority = 12)
	public void testDeleteWorkPackage(String workPackage, String sourceController, String assetTag, String installDate) {
		discoverWorkPackages.pageReach(driver);
		boolean retVal = discoverWorkPackages.deleteWorkPackage(driver, workPackage, sourceController, assetTag, installDate);
		Assert.assertEquals(retVal, true);
	}
	
	@DataProvider(name = "ControllerWorkPackage")
	public String[][] getControllerWorkPackageData() throws Exception {
		String[][] data = XLUtility.getData("ControllerWorkPackage", "TestData.xls");
		return data;
	}

	@DataProvider(name = "ControllerRelease")
	public String[][] getControllerReleaseData() throws Exception {
		String[][] data = XLUtility.getData("ControllerRelease", "TestData.xls");
		return data;
	}
}
