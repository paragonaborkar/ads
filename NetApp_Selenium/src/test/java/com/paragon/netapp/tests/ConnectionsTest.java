package com.paragon.netapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netapp.ads.connections.ConnectionsManualFunctions;;;

/**
 * @author Singprad
 * To validate Discover Controller Release and Controller WorkPackage.
 */
public class ConnectionsTest extends LoginTest {

	ConnectionsManualFunctions connectionsManualFunctions = new ConnectionsManualFunctions();
	
	/**
	 * @throws InterruptedException
	 */
	@Test(priority = 14)
	public void testRunHostConnections() throws InterruptedException {
		connectionsManualFunctions.pageReach(driver);
		for(int i=1; i<=3; i++) {
			boolean retVal = connectionsManualFunctions.runHostConnections(driver, i);
			Assert.assertEquals(retVal, true);
		}
	}
}
