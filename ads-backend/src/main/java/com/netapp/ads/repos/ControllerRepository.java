package com.netapp.ads.repos;

import com.netapp.ads.models.Controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ControllerRepository extends JpaRepository<Controller, Integer>, JpaSpecificationExecutor<Controller> {

	List<Controller> findByControllerNameContaining(@Param("controllerNameContains") String controllerNameContains);
}
