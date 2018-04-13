package com.netapp.ads.repos;

import com.netapp.ads.models.ControllerRelease;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ControllerReleaseRepository extends JpaRepository<ControllerRelease, Integer>, JpaSpecificationExecutor<ControllerRelease> {

	List<ControllerRelease> findByProcessedTrue();
	
	List<ControllerRelease> findByProcessedFalse();
	
	Page findByProcessed(@Param("processed") boolean processed, Pageable p);
	
}
