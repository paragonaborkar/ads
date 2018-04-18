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
			SpringApplication.run(IntegrationAndBatchProcessingApplication.class, args);
			log.info("Started ADS Integration and Batch Processing Application");
		} else {
			throw new IllegalArgumentException("ADS License is not valid. Not starting server.");
		}
		
	}
}
