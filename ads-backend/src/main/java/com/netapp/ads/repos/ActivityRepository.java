package com.netapp.ads.repos;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.projections.ActivityWithQtree;

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

	List<Activity> findByMailCount(@Param("mailCount") Integer mailCount);
	
	// owner_user_corporate_id cannot be null or 0. It's a foreign key to user_corporate
	// Is it more likely that an ActivityResponse won't be created if we do not have a valid User to set? If so, then I think we will need a mismatch query.
	@Query("Select a From Activity a  "
    		+ "JOIN a.qtree q " 
    		+ "JOIN q.qtreeDisposition qd ON qd.disposition = 'DiscoverOwner' "
    		+ "LEFT JOIN a.activityResponses ar WHERE ar.id IS NULL")
	Page<Activity> findUnidentifiedOwners(Pageable p);
	
	/*	SIMLIAR TO: 
 	select * from activity
	LEFT JOIN activity_migration_key_x_ref
		ON activity.id = activity_migration_key_x_ref.activity_id
	LEFT JOIN migration_key
		ON activity_migration_key_x_ref.migration_key_id = migration_key.id
	WHERE migration_key.migration_key = 'ABC' 
	AND migration_key.user_corporate_id = 9 
	AND activity.disposition = 'DiscoverOwner'*/
    @Query("Select a From Activity a  "
    		+ "JOIN a.qtree q " 
    		+ "JOIN q.qtreeDisposition qd ON qd.disposition = :disposition "
    		+ "JOIN a.activityResponses ar ON ar.ownerUserCorporateId=:corpUserId AND ar.isPresumed = 1"
    		+ "JOIN a.activityMigrationKeyXRefs x "
    		+ "JOIN x.migrationKey m ON m.migrationKey=:migKey AND m.userCorporateId=:corpUserId ")
    List<Activity> getActivitiesFromMigrationKeyAndCorpUserId(@Param("migKey") String migKey, @Param("corpUserId") Integer corpUserId , @Param("disposition") String disposition);
    

}
