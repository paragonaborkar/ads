package com.netapp.ads.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.netapp.ads.models.ControllerRelease;


@Repository
public interface ControllerReleaseRepository extends JpaRepository<ControllerRelease, Integer>, JpaSpecificationExecutor<ControllerRelease> {

	List<ControllerRelease> findByProcessedTrue();
	
	List<ControllerRelease> findByProcessedFalse();
	
	Page findByProcessed(@Param("processed") boolean processed, Pageable p);
	
}
