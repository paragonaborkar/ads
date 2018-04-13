package com.netapp.ads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.netapp.ads.util.LicenseUtil;

@SpringBootApplication
public class ADSBackendApplication {
    private static final Logger log = LoggerFactory.getLogger(ADSBackendApplication.class);

    // FIXME:  THIS IS ONLY A TEMPORANY SOLUTION SO WE CAN LOGIN AS MANY CORP USERS
    public static String ssoWorkAroundId = "";
    
    public static void main(String[] args) throws Exception {
		// If the Date and At Least 1 Active Module checks are done correctly, an error will be thrown and we will never get to this point.		
		boolean isActive = LicenseUtil.isLicenseActive();
		if (isActive) {
			SpringApplication.run(ADSBackendApplication.class, args);
			log.info("Started ADS Backend Application");
		} else {
			throw new IllegalArgumentException("ADS License is not valid. Not starting server.");
		}
	}
}
