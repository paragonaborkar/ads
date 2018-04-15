package com.netapp.ads.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.netapp.ads.models.Export;


@Repository
public interface ExportRepository extends JpaRepository<Export, Integer>, JpaSpecificationExecutor<Export> {

	List<Export> findByVolumePath(@Param("volumePath") String volumePath);
}
