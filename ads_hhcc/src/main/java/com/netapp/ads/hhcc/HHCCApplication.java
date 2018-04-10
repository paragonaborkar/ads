package com.netapp.ads.hhcc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.netapp.ads.hhcc.main.CIFSSessionCollector;
import com.netapp.ads.hhcc.main.NFSDataCollectorAndImporter;
import com.netapp.ads.hhcc.main.ShowmountDataCollectorAndImporter;

@SpringBootApplication
@EnableScheduling
public class HHCCApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HHCCApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(HHCCApplication.class, args);
		log.info("Application started");
		//CIFSSessionCollector cifsSessionCollector = appContext.getBean(CIFSSessionCollector.class);
		//cifsSessionCollector.collectCFSSessions(false, false, false);
		
		//ShowmountDataCollectorAndImporter showMountDataCollector = appContext.getBean(ShowmountDataCollectorAndImporter.class);
		//showMountDataCollector.collectShowmountData();
		
		//NFSDataCollectorAndImporter nfsDataCollectorAndImporter = appContext.getBean(NFSDataCollectorAndImporter.class);
		//nfsDataCollectorAndImporter.collectCurrentNFSConnectedHostsAndStatistics(false);
	}
}
