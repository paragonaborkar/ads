package com.netapp.ads.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.models.MigrationKey;
import com.netapp.ads.repos.MigrationKeyRepository;
import com.netapp.ads.util.RandomString;

@Service
public class UniqueKeyService {
	private static final Logger log = LoggerFactory.getLogger(UniqueKeyService.class);
	
	@Autowired
	MigrationKeyRepository migrationKeyRepository;
	
	
	public String createMigKey() {
		RandomString randomString = new RandomString(8);
		String key = randomString.nextString();
		log.debug("createMigKey(): key: {}", key);

		// Check for uniqueness in the DB
		while (keyExists(key) == true) {
			createMigKey();
		}
		
		return key;
	}
	
	
	/**
	 * return true if unique
	 */
	public boolean keyExists(String key) {
		MigrationKey migrationKey = migrationKeyRepository.findByMigrationKey(key);
		boolean keyExists = (migrationKey == null) ? false : true;
		return keyExists;
	}	
}
