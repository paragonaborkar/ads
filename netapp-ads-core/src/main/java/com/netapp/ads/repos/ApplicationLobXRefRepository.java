package com.netapp.ads.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.netapp.ads.models.ApplicationLobXRef;
import com.netapp.ads.models.ApplicationLobXRefPK;

/**
* Generated by Spring Data Generator on 28/01/2018
*/
@Repository
public interface ApplicationLobXRefRepository extends JpaRepository<ApplicationLobXRef, ApplicationLobXRefPK>, JpaSpecificationExecutor<ApplicationLobXRef> {

}
