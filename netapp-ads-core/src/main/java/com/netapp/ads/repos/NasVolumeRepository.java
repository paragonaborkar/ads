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
	
	Long countByControllerId(@Param("controllerId") int controllerId);
}