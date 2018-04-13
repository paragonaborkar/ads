package com.netapp.ads.repos;


import com.netapp.ads.models.Activity;
import com.netapp.ads.models.ActivityResponse;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityResponseRepository extends JpaRepository<ActivityResponse, Integer>, JpaSpecificationExecutor<ActivityResponse> {

	List<ActivityResponse> findByEmailCount(@Param("emailCount") Integer emailCount);
	
	ActivityResponse findByOwnerUserCorporateIdAndActivityId(@Param("ownerUserCorporateId") Integer ownerUserCorporateId, @Param("activityId") Integer activityId);
	
}
