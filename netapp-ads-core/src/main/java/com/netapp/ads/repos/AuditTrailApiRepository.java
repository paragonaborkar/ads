package com.netapp.ads.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.netapp.ads.models.AuditTrailApi;

/**
* Generated by Spring Data Generator on 28/01/2018
*/
@Repository
public interface AuditTrailApiRepository extends JpaRepository<AuditTrailApi, Integer>, JpaSpecificationExecutor<AuditTrailApi> {

}
