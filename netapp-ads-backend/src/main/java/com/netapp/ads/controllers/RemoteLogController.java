package com.netapp.ads.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@BasePathAwareController
@RestController
@RequestMapping(value = "/api")
public class RemoteLogController {
    
	private static final Logger log = LoggerFactory.getLogger(RemoteLogController.class);
	
    @RequestMapping(value = "/remoteLog", method = RequestMethod.POST)
    public void getControllersWithControllerPK(@RequestBody Object obj) {
    	log.error("GOT LOG FROM USER'S BROWSER");
    	log.error(obj.toString());
        return;
    }
}
