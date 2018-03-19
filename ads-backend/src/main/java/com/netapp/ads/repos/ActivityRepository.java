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

	// This was used to troubleshoot some issues. Not used in app:
//	Activity findById(@Param("id") Integer id);
	
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
    
    
//  AND qtd.disposition = :disposition
    //, @Param("disposition") String disposition
    
    // a.adminOverride as getAdminOverride, a.qtree as qtree

	
	// @Query("Select a.adminOverride as getAdminOverride From Activity a LEFT JOIN a.activityMigrationKeyXRefs x LEFT JOIN x.migrationKey m WHERE m.migrationKey=:migKey AND m.userCorporateId=:corpUserId AND a.disposition=:disposition")
    // List<ActivityProjection> getActivitiesFromMigrationKeyAndCorpUserId(@Param("migKey") String migKey, @Param("corpUserId") Integer corpUserId, @Param("disposition") String disposition);
    
    // NOT USED IN APP:
//    @Query(value = "Select a.id From Activity a LEFT JOIN a.activityMigrationKeyXRefs x LEFT JOIN x.migrationKey m WHERE m.migrationKey=:migKey AND m.userCorporateId=:corpUserId AND a.disposition=:disposition")
//    public String[] getIdOfActivitiesFromMigrationKeyAndCorpUserId(@Param("migKey") String migKey, @Param("corpUserId") Integer corpUserId, @Param("disposition") String disposition);

}
