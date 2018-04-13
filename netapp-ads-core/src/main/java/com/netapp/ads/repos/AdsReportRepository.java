package com.netapp.ads.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.netapp.ads.models.AdsReport;

@RepositoryRestResource
public interface AdsReportRepository extends JpaRepository<AdsReport, Integer>, JpaSpecificationExecutor<AdsReport> {

	AdsReport findByReportNameAndAdsModule(@Param("report_name") String reportName, @Param("ads_module") String adsModule);

	List<AdsReport> findByAdsModule(@Param("adsModule") String adsModule);

}
