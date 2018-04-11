package com.netapp.ads;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.netapp.ads.util.LicenseUtil;

@SpringBootApplication
@EnableScheduling
public class IntegrationAndBatchProcessingApplication {
    private static final Logger log = LoggerFactory.getLogger(IntegrationAndBatchProcessingApplication.class);
    public static HashMap<String, Boolean> ACTIVE_MODULES; 
    
    public static void main(String[] args) throws Exception {
		// If the Date and At Least 1 Active Module checks are done correctly, an error will be thrown and we will never get to this point.		
		boolean isActive = LicenseUtil.isLicenseActive();
		if (isActive) {
			if(LicenseUtil.ACTIVE_MODULES.get("discover").equals("true") && LicenseUtil.ACTIVE_MODULES.get("connections").equals("true")) {
				SpringApplication.run(IntegrationAndBatchProcessingApplication.class, args);
				log.info("Started ADS Integration and Batch Processing Application");
			} else {
				log.error("Sorry, cannot start ADS Integration and Batch Processing Application. Either 'Connections' or 'Discover' module is not licensed.");
				log.error("Update your license and restart the application.");
			}
		} else {
			throw new IllegalArgumentException("ADS License is not valid. Not starting server.");
		}
	}
}
