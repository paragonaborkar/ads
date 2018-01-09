package com.netapp.ads.controllers;


import com.netapp.ads.models.Controller;
import com.netapp.ads.models.ControllerPK;
import com.netapp.ads.repos.ControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ControllersController {
    @Autowired
    private ControllerRepository controllerRepository;

    @RequestMapping(value = "/controllers/{storageId}/{dataCenterId}", method = RequestMethod.GET)
    public List<Controller> getControllersWithControllerPK(@PathVariable Integer storageId, @PathVariable Integer dataCenterId) {
        ControllerPK controllerPK = new ControllerPK();
        controllerPK.setStorageId(storageId);;
        controllerPK.setDataCenterId(dataCenterId);
        List<Controller> controllers = controllerRepository.findAll(Arrays.asList(controllerPK));
        return controllers;
    }
}
