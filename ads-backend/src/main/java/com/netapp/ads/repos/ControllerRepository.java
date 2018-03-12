package com.netapp.ads.repos;

import com.netapp.ads.models.Controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ControllerRepository extends JpaRepository<Controller, Integer>, JpaSpecificationExecutor<Controller> {

	List<Controller> findByControllerNameContaining(@Param("controllerNameContains") String controllerNameContains);
	
//	List<Controller> findByControllerTargetsAvailable_ControllerNameContaining(@Param("controllerNameContains") String controllerNameContains);
	
	@Query("SELECT c  FROM Controller c, ControllerTargetsAvailable t WHERE c.id = t.controller AND c.controllerName LIKE %:controllerNameContains%")
	List<Controller> findByControllerTargetsAvailableWithControllerNameContaining(@Param("controllerNameContains") String controllerNameContains);
}
