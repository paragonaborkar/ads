package com.netapp.ads.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.MigrationKey;
import com.netapp.ads.models.UserNative;

@Repository
public interface MigrationKeyRepository extends JpaRepository<MigrationKey, Integer>, JpaSpecificationExecutor<MigrationKey> {
	
	@Query("select count(e)>0 from MigrationKey e where e.migrationKey=:migrationKey and e.userCorporateId=:userCorporateId")
	boolean isMigrationKeyExists(@Param("migrationKey") String migrationKey, @Param("userCorporateId") Integer userCorporateId);

	MigrationKey findFirstByMigrationKeyAndUserCorporateId(@Param("migrationKey") String migrationKey, @Param("userCorporateId") int userCorporateId);
	
	List<MigrationKey> findByActivities(@Param("activity") Activity activity);
	
	MigrationKey findByUserCorporateId(@Param("userCorporateId") Integer userCorporateId);
	
	
	/**
	 * Find if a Migration Key exists for a combination of Corporate User ID and Run no.
	 * This is used during Migration Key generation to generate a unique migration key for a 
	 * combination of each run and corporate user  
	 * 
	 * @param userCorporateId
	 * @param runNo
	 * @return
	 */
	MigrationKey findByUserCorporateIdAndRunNo(@Param("userCorporateId") Integer userCorporateId, @Param("runNo") Integer runNo);
	
	/**
	 * Find an existing migration key
	 * @param migrationKey
	 * @return
	 */
	/**
	 * @param migrationKey
	 * @return
	 */
	MigrationKey findByMigrationKey(@Param("migrationKey") String migrationKey);
	
	/**
	 * Get the max run no. This is specifically used during migration key generation
	 * so we can increment this and use it for the next run
	 * 
	 * @return
	 */
	@Query("SELECT MAX(m.runNo) from MigrationKey m")
    Integer getMaxRunNo();
	
	/*	SIMLIAR TO: 
 	select * from activity
	LEFT JOIN activity_migration_key_x_ref
		ON activity.id = activity_migration_key_x_ref.activity_id
	LEFT JOIN migration_key
		ON activity_migration_key_x_ref.migration_key_id = migration_key.id
	WHERE migration_key.migration_key = 'ABC' 
	AND migration_key.user_corporate_id = 9 
	AND activity.disposition = 'DiscoverOwner'*/
    @Query("Select m from MigrationKey m  "
    		+ "JOIN m.activityMigrationKeyXRefs x "
    		+ "JOIN x.activity a "
    		+ "JOIN a.activityResponses ar WHERE m.userCorporateId=:corpUserId AND ar.isPresumed = 1")
    List<MigrationKey> getActivitiesResponsesPending(@Param("corpUserId") Integer corpUserId);
  
}
