package com.netapp.ads.repos;

import com.netapp.ads.models.CutoverTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.netapp.ads.models.CutoverTimePK;

/**
* Generated by Spring Data Generator on 22/12/2017
*/
@Repository
public interface CutoverTimeRepository extends JpaRepository<CutoverTime, CutoverTimePK>, JpaSpecificationExecutor<CutoverTime> {

}
