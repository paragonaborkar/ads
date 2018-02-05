package com.netapp.ads;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.bouncycastle.openpgp.PGPException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import com.javax0.license3j.licensor.License;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static HashMap<String, Boolean> ACTIVE_MODULES; 
    
    public static void main(String[] args) throws Exception {

		HashMap<String, HashMap> completeLicenseInfo = checkLicense();

		// Store the active modules in memory. Each time a user logs in to ADS, a REST call will need to provide modules available.
		// Likely this will be done during a successful login.
		ACTIVE_MODULES = completeLicenseInfo.get("modules");
		HashMap<String, String> licenseInfo = completeLicenseInfo.get("licenseInfo");

		// FIXME: no sys out's
		log.debug("The following ADS modules are enabled:");
		boolean noActiveModules = true;
		for (Map.Entry<String, Boolean> entry : ACTIVE_MODULES.entrySet()) {
			String key = entry.getKey();
			boolean value = entry.getValue();

			// Check if at least 1 module is active. Otherwise server shouldn't start up. 
			if (value)
				noActiveModules = false;

			// FIXME: Print this out using a logger.
			// FIXME: no sys out's
			log.debug(key + ":" + value);
		}

		if (noActiveModules) {
			throw new IllegalArgumentException("No ADS modules are enabled. Not starting server.");
		}

		// If the Date and At Least 1 Active Module checks are done correctly, an error will be thrown and we will never get to this point.		
		boolean isActive = Boolean.parseBoolean(licenseInfo.get("license_active"));
		if (isActive) {
			SpringApplication.run(Application.class, args);
			log.info("Started SpringBoot");
		} else {
			throw new IllegalArgumentException("ADS License is not valid. Not starting server.");
		}

	}


    public static HashMap<String, HashMap>  checkLicense() throws Exception {

    	Resource licenseFileResource = new ClassPathResource("license/license.out");
    	String licenseFileContent = null;
		try {
			licenseFileContent = StreamUtils.copyToString(licenseFileResource.getInputStream(), StandardCharsets.UTF_8);
		} catch (Exception ex) {
			throw new IllegalArgumentException("ADS license not found.");
		}
		
		if(licenseFileContent == null) {
			throw new Exception("ADS license not found.");
		}

		//		 ---KEY RING DIGEST START
		byte [] digest = new byte[] {
				(byte)0xF6, 
				(byte)0x62, (byte)0xAF, (byte)0xBE, (byte)0x6D, (byte)0xF8, (byte)0x11, (byte)0x69, (byte)0x8C, 
				(byte)0x1C, (byte)0xD9, (byte)0x5A, (byte)0xE0, (byte)0xD7, (byte)0xB2, (byte)0xD7, (byte)0x02, 
				(byte)0xA6, (byte)0x44, (byte)0xD3, (byte)0x10, (byte)0x09, (byte)0x3B, (byte)0x45, (byte)0x89, 
				(byte)0x71, (byte)0x7B, (byte)0x5A, (byte)0xA6, (byte)0x1F, (byte)0x20, (byte)0x07, (byte)0xBB, 
				(byte)0xD1, (byte)0x62, (byte)0x39, (byte)0x11, (byte)0x47, (byte)0xEE, (byte)0x5C, (byte)0x93, 
				(byte)0xA5, (byte)0xF0, (byte)0x87, (byte)0x87, (byte)0xC3, (byte)0x94, (byte)0x39, (byte)0x62, 
				(byte)0xBB, (byte)0xF7, (byte)0xC4, (byte)0xCB, (byte)0x98, (byte)0x79, (byte)0xFA, (byte)0x0D, 
				(byte)0x4C, (byte)0x5E, (byte)0x39, (byte)0xAF, (byte)0x8D, (byte)0xFC, (byte)0x4C, 
				};
		//		 ---KEY RING DIGEST END

		License lic = new License();
		try {
			// FIXME: must use a digest in production. Not sure if this should be loaded from a text file or if it needs to be in the code.
			// See: https://github.com/verhas/License3j/wiki/sample
//			 lic.loadKeyRingFromResource("license/pubring.gpg", digest);
			Resource keyRingResource = new ClassPathResource("license/pubring.gpg");
			lic.loadKeyRing(keyRingResource.getInputStream(), null);
			lic.setLicenseEncoded(licenseFileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PGPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean licenseActive = checkDateAndVersionValidity(lic.getFeature("issued_date"), lic.getFeature("valid_until"));

		HashMap<String, String> licenseInfo = new HashMap<String, String>();
		licenseInfo.put("license_active", licenseActive+"");
		licenseInfo.put("valid_until", lic.getFeature("valid_until"));
		licenseInfo.put("edition", lic.getFeature("edition"));

		HashMap<String, Boolean> modules = new HashMap<String, Boolean>();
		modules.put("connections", Boolean.parseBoolean(lic.getFeature("module_host_connections")));
		modules.put("discover", Boolean.parseBoolean(lic.getFeature("module_discover")));
		modules.put("reports", Boolean.parseBoolean(lic.getFeature("module_reports")));
		modules.put("schedule", Boolean.parseBoolean(lic.getFeature("module_schedule")));
		modules.put("planning", Boolean.parseBoolean(lic.getFeature("module_planning")));
		modules.put("execute", Boolean.parseBoolean(lic.getFeature("module_execute")));

		HashMap<String, HashMap> completeLicenseInfo = new HashMap<String, HashMap>();
		completeLicenseInfo.put("modules", modules);
		completeLicenseInfo.put("licenseInfo", licenseInfo);

		return completeLicenseInfo;
	}

	protected static boolean checkDateAndVersionValidity(String issuedDateStr, String activeUntilDateStr) {

		String expectedPattern = "yyyy.MM.dd";
		SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);

		Date issuedDate = null;
		Date activeUntilDate = null;
		
		try {
			issuedDate = formatter.parse(issuedDateStr);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Date license was issued is not provided.");
		}

		try {
			activeUntilDate = formatter.parse(activeUntilDateStr);
		} catch (ParseException e) {
			throw new IllegalArgumentException("License Active Until Date is not provided.");
		}


		Date today = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 today = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			throw new IllegalArgumentException("Could not get the current date to check license.");
		}
		
		// Check Issued Date first... no funny business
		if (issuedDate.compareTo(today) > 0) {
            throw new IllegalArgumentException("License is not valid. Issue date is too late, probably tampered system time");
        } 
		
		// Check Active Until Date for expiration
		if (activeUntilDate.compareTo(today) < 0) {
			throw new IllegalArgumentException("License expired. Active until:" + activeUntilDate);
        }
		
		return true;
	}
}
