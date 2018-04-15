package com.netapp.ads.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.netapp.ads.models.ControllerWorkPackage;


@Repository
public interface ControllerWorkPackageRepository extends JpaRepository<ControllerWorkPackage, Integer>, JpaSpecificationExecutor<ControllerWorkPackage> {

	Page findByProcessed(@Param("processed") boolean processed, Pageable p);

}
