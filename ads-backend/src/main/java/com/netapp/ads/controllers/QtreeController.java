package com.netapp.ads.controllers;

import java.util.List;
import java.util.Map;

import org.jeasy.rules.api.Facts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.Application;
import com.netapp.ads.models.Host;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.Share;
import com.netapp.ads.models.ext.QtreeOwner;
import com.netapp.ads.models.verum.application.OSI;
import com.netapp.ads.models.verum.esource.EmployeeProfile;
import com.netapp.ads.models.verum.person.Person;
import com.netapp.ads.repos.ActivityRepository;
import com.netapp.ads.repos.AdsReportRepository;
import com.netapp.ads.services.ApplicationService;

@RestController
public class QtreeController {

	@Autowired
	private ActivityRepository activityRepository;
	
	@RequestMapping(value="qtreeOwner", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<QtreeOwner> getVerumApp() {  			    // @RequestParam(name="ip", required=true) String ipAddress
		// INPUT: user_corp_id, migKey
		String migKey = "ABC";
		int corpUserId = 9;
		
		QtreeOwner qto = new QtreeOwner();

		// Get List of Activities that need to be processed 
		List<Activity> activityList = activityRepository.getActivitiesFromMigrationKeyAndCorpUserId(migKey, corpUserId, "DiscoverOwner");
		
		int hostCount = 0;
		int shareCount = 0;
		
		
		
		System.out.println("activityList:"+activityList.size());
		
		for(Activity activity : activityList) {
			// Activity to Qtree are 1:1
			Qtree qt = activity.getQtree();
			System.out.println("qt:"+qt.getQtreeName());
//			qto.setQtree(qt);
			
	/*		// 1 or more Shares for 1 Qtree
			List<Share> shareList = qt.getShares();
			shareCount = shareCount + shareList.size();
			for(Share share : shareList) {
				// Each share has 1 Host (Many shares can be on 1 host)
				Host host = share.getHost();
				qto.setHost(host);
				hostCount++;
			}*/
			
		}
		
		qto.setQtreeName("test");
		
		qto.setHostCount(hostCount);
		qto.setShareCount(shareCount);
		
//		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from " + adsReport.getViewOrTableName());
		
		// OUTPUT
		// Array of:
		
		
		return new ResponseEntity(qto, HttpStatus.OK);
	}    


}
