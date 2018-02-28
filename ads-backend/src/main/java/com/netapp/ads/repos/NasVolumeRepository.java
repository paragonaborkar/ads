package com.netapp.ads.repos;

import com.netapp.ads.models.NasVolume;
import com.netapp.ads.models.projections.NasVolumeProjection;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NasVolumeRepository extends JpaRepository<NasVolume, Integer> {
	
	//@Query("SELECT n FROM NasVolume n JOIN n.controller c JOIN c.dataCenter d WHERE n.id = :id")
	//List<NasVolume> findControllerAndDataCenter(@Param("id") Integer id);

	// FUTURE USE: Populate Activity table
	@Query("SELECT COUNT(*) FROM share s JOIN qtree	ON qtree.id = s.qtree_id JOIN nas_volume ON qtree.nas_volume_id = nas_volume.id WHERE nas_volume.id = :nasVolumeId")
    Long countOfSharesForOneVolume(@Param("nasVolumeId") int nasVolumeId);
	
	Long countByControllerId(@Param("controllerId") int controllerId);
}
