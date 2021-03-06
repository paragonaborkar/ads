package com.netapp.ads.repos;

import com.netapp.ads.models.ActivityLobXRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.netapp.ads.models.ActivityLobXRefPK;

/**
* Generated by Spring Data Generator on 22/12/2017
*/
@Repository
public interface ActivityLobXRefRepository extends JpaRepository<ActivityLobXRef, ActivityLobXRefPK>, JpaSpecificationExecutor<ActivityLobXRef> {

}
