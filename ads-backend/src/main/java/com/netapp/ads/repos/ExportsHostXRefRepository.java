package com.netapp.ads.repos;

import com.netapp.ads.models.ExportsHostXRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.netapp.ads.models.ExportsHostXRefPK;

/**
* Generated by Spring Data Generator on 28/01/2018
*/
@Repository
public interface ExportsHostXRefRepository extends JpaRepository<ExportsHostXRef, ExportsHostXRefPK>, JpaSpecificationExecutor<ExportsHostXRef> {

}
