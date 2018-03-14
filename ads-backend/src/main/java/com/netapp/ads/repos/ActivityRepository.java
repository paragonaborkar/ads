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
	

	/*	SIMLIAR TO: 
 	select * from activity
	LEFT JOIN activity_migration_key_x_ref
		ON activity.id = activity_migration_key_x_ref.activity_id
	LEFT JOIN migration_key
		ON activity_migration_key_x_ref.migration_key_id = migration_key.id
	WHERE migration_key.migration_key = 'ABC' 
	AND migration_key.user_corporate_id = 9 
	AND activity.disposition = 'DiscoverOwner'*/
    @Query("Select a From Activity a LEFT JOIN a.activityMigrationKeyXRefs x LEFT JOIN x.migrationKey m WHERE m.migrationKey=:migKey AND m.userCorporateId=:corpUserId AND a.disposition=:disposition")
    List<Activity> getActivitiesFromMigrationKeyAndCorpUserId(@Param("migKey") String migKey, @Param("corpUserId") Integer corpUserId, @Param("disposition") String disposition);

}
