package com.netapp.ads.repos;

import com.netapp.ads.models.Controller;
import com.netapp.ads.models.ControllerTargetsAvailable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ControllerTargetsAvailableRepository extends JpaRepository<ControllerTargetsAvailable, Integer>, JpaSpecificationExecutor<ControllerTargetsAvailable> {

	Page findByProcessed(@Param("processed") boolean processed, Pageable p);

//	List<ControllerTargetsAvailable> findByControllerControllerNameContaining(@Param("controllerNameContains") String controllerNameContains);
	
}
