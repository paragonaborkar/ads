package com.netapp.ads.selenium.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netapp.ads.discover.DiscoverReports;

/**
 * @author Singprad All below Methods called for Discover Module Reports
 *         Handling and generating to local drive.
 */
public class DiscoverReportTest extends LoginTest {
	
	private Logger log = LoggerFactory.getLogger(DiscoverReportTest.class);
	DiscoverReports discoverReports = new DiscoverReports();

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
}
