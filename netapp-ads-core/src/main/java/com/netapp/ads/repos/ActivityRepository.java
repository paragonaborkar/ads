package com.netapp.ads.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.netapp.ads.models.Activity;


@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>, JpaSpecificationExecutor<Activity> {

	// owner_user_corporate_id cannot be null or 0. It's a foreign key to user_corporate
	// Is it more likely that an ActivityResponse won't be created if we do not have a valid User to set? If so, then I think we will need a mismatch query.
	@Query("Select a From Activity a  "
    		+ "JOIN a.qtree q " 
    		+ "JOIN q.qtreeDisposition qd ON qd.disposition = 'DiscoverOwner' "
    		+ "LEFT JOIN a.activityResponses ar WHERE ar.id IS NULL AND a.adminOverride = false")
	Page<Activity> findUnidentifiedOwners(Pageable p);
	

    @Query("Select a From Activity a  "
    		+ "JOIN a.qtree q " 
    		+ "JOIN q.qtreeDisposition qd ON qd.disposition = :disposition "
    		+ "JOIN a.activityResponses ar ON ar.ownerUserCorporateId=:corpUserId AND ar.isPresumed = 1"
    		+ "JOIN a.activityMigrationKeyXRefs x "
    		+ "JOIN x.migrationKey m ON m.migrationKey=:migKey AND m.userCorporateId=:corpUserId ")
    List<Activity> getActivitiesFromMigrationKeyAndCorpUserId(@Param("migKey") String migKey, @Param("corpUserId") Integer corpUserId , @Param("disposition") String disposition);
    

	@Query("Select a From Activity a  "
    		+ "JOIN a.qtree q "
    		+ "JOIN q.qtreeDisposition qd ON qd.disposition = :disposition "
    		+ "Where a.activityMigrationKeyXRefs is empty")
	List<Activity> findActivitiesWithoutMigrationKeys(@Param("disposition") String disposition);

}
