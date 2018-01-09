package com.netapp.ads.repos;

import com.netapp.ads.models.HostApplicationXRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.netapp.ads.models.HostApplicationXRefPK;

/**
* Generated by Spring Data Generator on 22/12/2017
*/
@Repository
public interface HostApplicationXRefRepository extends JpaRepository<HostApplicationXRef, HostApplicationXRefPK>, JpaSpecificationExecutor<HostApplicationXRef> {

}
