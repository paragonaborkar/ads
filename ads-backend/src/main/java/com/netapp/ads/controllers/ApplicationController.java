package com.netapp.ads.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.models.verum.application.OSI;
import com.netapp.ads.models.verum.esource.EmployeeProfile;
import com.netapp.ads.models.verum.person.Person;
import com.netapp.ads.services.ApplicationService;

@RestController
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	
    @RequestMapping(value="getVerumApp", method = RequestMethod.GET)
    public OSI getVerumApp(@RequestParam(name="ip", required=true) String ipAddress) {
    	return applicationService.getVerumApp(ipAddress);
    }    
	
    @RequestMapping(value="getVerumPerson", method = RequestMethod.GET)
    public Person getVerumPerson(@RequestParam(name="sid", required=true) String sid) {
    	return applicationService.getVerumPerson(sid);
    }
    
    @RequestMapping(value="getEmployeeProfile", method = RequestMethod.GET)
    public EmployeeProfile getEmployeeProfile(@RequestParam(name="sid", required=true) String sid) {
    	return applicationService.getEmployeeProfile(sid);
    }      
    
}
