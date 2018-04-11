package com.netapp.ads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netapp.ads.util.LicenseUtil;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    // FIXME:  THIS IS ONLY A TEMPORANY SOLUTION SO WE CAN LOGIN AS MANY CORP USERS
    public static String ssoWorkAroundId = "";
    
    public static void main(String[] args) throws Exception {
    	
    	//TO BE REMOVED. Just for Talend testing
/*    	File dumpDir = new File("target/drools-dump-dir");
    	if (dumpDir.exists()) {
            FileUtils.deleteQuietly(dumpDir);
        }
        dumpDir.mkdirs();
    	System.setProperty(DumpDirOption.PROPERTY_NAME, "target/drools-dump-dir");*/
    	
		// If the Date and At Least 1 Active Module checks are done correctly, an error will be thrown and we will never get to this point.		
		boolean isActive = LicenseUtil.isLicenseActive();
		if (isActive) {
			SpringApplication.run(Application.class, args);
			log.info("Started SpringBoot");
		} else {
			throw new IllegalArgumentException("ADS License is not valid. Not starting server.");
		}

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
