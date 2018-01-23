package com.netapp.ads.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RemoteLogController {
    
    @RequestMapping(value = "/remoteLog", method = RequestMethod.POST)
    public void getControllersWithControllerPK(@RequestBody Object obj) {
    	System.out.println("GOT LOG FROM USER'S BROWSER");
        System.out.println(obj);
        return;
    }
}
