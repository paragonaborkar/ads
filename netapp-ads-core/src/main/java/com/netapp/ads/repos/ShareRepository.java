package com.netapp.ads.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.netapp.ads.models.Share;


@Repository
public interface ShareRepository extends JpaRepository<Share, Integer>, JpaSpecificationExecutor<Share> {

	@Query("SELECT COUNT(s) FROM Share s JOIN s.qtree q JOIN q.nasVolume n WHERE n.id = :nasVolumeId")
    Long countOfSharesForOneVolume(@Param("nasVolumeId") int nasVolumeId);
	
}
