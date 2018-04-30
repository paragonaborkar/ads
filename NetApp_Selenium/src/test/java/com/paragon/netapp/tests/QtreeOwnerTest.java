package com.paragon.netapp.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.netapp.ads.discover.QtreeOwner;
import static com.netapp.ads.utils.ProjectUtility.getProperty;

/**
 * @author Singprad
 * To validate Discover Controller Release and Controller WorkPackage.
 */
public class QtreeOwnerTest extends BaseTest {
	
	QtreeOwner qtreeOwner = new QtreeOwner();
	
	@Override
	@BeforeTest
	public void launchApp() {
		String qtreeOwnerUrl = getProperty("discover.owner.sso.url");
		driver.get(qtreeOwnerUrl);
	}

	@Test(priority = 8)
	public void testQtreeOwnerShip() {
		qtreeOwner.pageReach(driver, getProperty("sso.username"), getProperty("sso.password"));
	}
}
