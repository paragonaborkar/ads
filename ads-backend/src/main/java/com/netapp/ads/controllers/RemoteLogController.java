package com.netapp.ads.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoteLogController {
    
	private static final Logger logger = LoggerFactory.getLogger(RemoteLogController.class);
	
    @RequestMapping(value = "/remoteLog", method = RequestMethod.POST)
    public void getControllersWithControllerPK(@RequestBody Object obj) {
        logger.info("GOT LOG FROM USER'S BROWSER");
        logger.info(obj.toString());
        return;
    }
}
