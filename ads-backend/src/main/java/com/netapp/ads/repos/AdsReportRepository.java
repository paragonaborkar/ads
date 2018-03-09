package com.netapp.ads.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.netapp.ads.models.AdsReport;

@RepositoryRestResource
public interface AdsReportRepository extends JpaRepository<AdsReport, Integer>, JpaSpecificationExecutor<AdsReport> {

	AdsReport findByReportName(@Param("report_name") String reportName);

}
