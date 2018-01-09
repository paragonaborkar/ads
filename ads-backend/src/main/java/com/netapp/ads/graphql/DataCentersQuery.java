package com.netapp.ads.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.netapp.ads.models.DataCenter;
import com.netapp.ads.repos.DataCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataCentersQuery implements GraphQLQueryResolver {

    @Autowired
    private DataCenterRepository dataCenterRepository;

    public List<DataCenter> getAllDataCenters() {
        return dataCenterRepository.findAll();
    }

    public DataCenter getAllControllersByDataCenterId(Integer dataCenterId) {
        return dataCenterRepository.findOne(dataCenterId);
    }
}