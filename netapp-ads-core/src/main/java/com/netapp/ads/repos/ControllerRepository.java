package com.netapp.ads.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.netapp.ads.models.Controller;

@Repository
public interface ControllerRepository extends JpaRepository<Controller, Integer>, JpaSpecificationExecutor<Controller> {
	
	List<Controller> findByControllerNameContaining(@Param("controllerNameContains") String controllerNameContains);

	@Query("SELECT c  FROM Controller c WHERE c NOT IN (SELECT t.controller FROM  ControllerWorkPackage t)  AND c.controllerName LIKE %:controllerNameContains%")
	List<Controller> findByControllerByNameContainingWithoutExistingWorkPackage(@Param("controllerNameContains") String controllerNameContains);

	@Query("SELECT c  FROM Controller c, ControllerWorkPackage t WHERE c.id = t.controller AND c NOT IN (SELECT r.srcController FROM  ControllerRelease r) AND c.controllerName LIKE %:controllerNameContains%")
	List<Controller> findByControllerTargetsAvailableWithControllerNameContaining(@Param("controllerNameContains") String controllerNameContains);
}
