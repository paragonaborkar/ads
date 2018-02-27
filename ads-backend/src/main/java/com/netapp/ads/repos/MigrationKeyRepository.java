package com.netapp.ads.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.netapp.ads.models.MigrationKey;
import com.netapp.ads.models.UserNative;

@Repository
public interface MigrationKeyRepository extends JpaRepository<MigrationKey, Integer>, JpaSpecificationExecutor<MigrationKey> {
	
	@Query("select count(e)>0 from MigrationKey e where e.migrationKey=:migrationKey and e.userCorporateId=:userCorporateId")
	boolean isMigrationKeyExists(@Param("migrationKey") String migrationKey, @Param("userCorporateId") int userCorporateId);

	MigrationKey findFirstByMigrationKeyAndUserCorporateId(@Param("migrationKey") String migrationKey, @Param("userCorporateId") int userCorporateId);
}
