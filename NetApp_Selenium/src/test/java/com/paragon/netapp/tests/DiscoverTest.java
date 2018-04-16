package com.paragon.netapp.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netapp.ads.discover.ControlRelease;
import com.netapp.ads.discover.DiscovrManualFunctions;
import com.netapp.ads.discover.Manual_discover;
import com.netapp.ads.utils.XLUtility;;;

/**
 * @author Singprad
 * To validate Discover Controller Release and Controller WorkPackage.
 */
public class DiscoverTest extends BaseTest {

	/**
	 * @param Workpack
	 * @param SourceController
	 * @param Assettag
	 * @param InstallDate
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "ControllerWorkPackage", priority = 2)

	public void discoverModule(String Workpack, String SourceController, String Assettag, String InstallDate)
			throws InterruptedException {

		Manual_discover.Workpack(driver, Workpack, SourceController, Assettag, InstallDate);


	}

	/**
	 * @param SourceController
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "ControllerRelease", priority = 3)
	public void Control(String SourceController) throws InterruptedException {

		ControlRelease.ControlBatch(driver, SourceController);

		ControlRelease.DeleteRelease(driver, SourceController);
	}

	/**
	 * @param SourceController
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "ControllerRelease", priority = 4)
	public void DeleteWorkpack(String SourceController) throws InterruptedException {

		Manual_discover.DeleteController(driver, SourceController);

	}

	/**
	 * @throws InterruptedException
	 */
	@Test(priority = 5)
	public void discoverManual() throws InterruptedException {

		DiscovrManualFunctions.manualFunctions(driver);

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
