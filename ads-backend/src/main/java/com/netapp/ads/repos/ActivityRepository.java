package com.netapp.ads.repos;

import com.netapp.ads.models.Activity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>, JpaSpecificationExecutor<Activity> {

	// Paged list of activities
	Page findByDisposition(@Param("disposition") String disposition,  Pageable p);
	
	@RestResource(path="findActivitiesByDisposition")
	//Select a From ActivityEntity a where a.disposition=:disposition AND a.unidentifiedReason IS NULL
	List<Activity> findByDisposition(@Param("disposition") String disposition);
	
	@Query("Select a From Activity a JOIN a.activityMigrationKeyXRefs x JOIN x.migrationKey m WHERE m.migrationKey='ABC' AND m.userCorporateId=9")
	List<Activity> getActivitiesFromMigrationKey();
}
