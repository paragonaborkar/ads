package com.netapp.ads.repos;

import com.netapp.ads.models.AuditTrailCorporateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.netapp.ads.models.AuditTrailCorporateUserPK;

/**
* Generated by Spring Data Generator on 22/12/2017
*/
@Repository
public interface AuditTrailCorporateUserRepository extends JpaRepository<AuditTrailCorporateUser, AuditTrailCorporateUserPK>, JpaSpecificationExecutor<AuditTrailCorporateUser> {

}
