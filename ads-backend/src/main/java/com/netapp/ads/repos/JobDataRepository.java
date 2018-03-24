package com.netapp.ads.repos;

import com.netapp.ads.models.JobData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface JobDataRepository extends JpaRepository<JobData, Integer>, JpaSpecificationExecutor<JobData> {
	JobData findOneByName(@Param("jobName") String jobName);
}
