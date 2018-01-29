package com.netapp.ads.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.netapp.ads.models.Controller;
import com.netapp.ads.repos.ControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ControllersQuery implements GraphQLQueryResolver {
    @Autowired
    private ControllerRepository controllerRepository;

    public List<Controller> getAllControllers() {
        return controllerRepository.findAll();
    }

    public List<Controller> getControllersByDataCenterIdAndStorageId(Integer dataCenterId, Integer storageId) {
        return controllerRepository.findAll();
    }
}
