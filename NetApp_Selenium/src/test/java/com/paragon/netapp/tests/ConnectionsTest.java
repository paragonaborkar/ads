package com.paragon.netapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netapp.ads.connections.ConnectionsManualFunctions;;;

/**
 * @author Singprad
 * 
 */
public class ConnectionsTest extends LoginTest {

	ConnectionsManualFunctions connectionsManualFunctions = new ConnectionsManualFunctions();
	
	/**
	 * @throws InterruptedException
	 */
	@Test(priority = 6)
	public void testRunHostConnections() throws InterruptedException {
		connectionsManualFunctions.pageReach(driver);
		for(int i=1; i<=3; i++) {
			boolean retVal = connectionsManualFunctions.runHostConnections(driver, i);
			Assert.assertEquals(retVal, true);
		}
	}
}
