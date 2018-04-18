package com.netapp.ads.util;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.netapp.ads.models.JobData;
import com.netapp.ads.repos.JobDataRepository;

@Service
public class JobUtils {
	
	private static final Logger log = LoggerFactory.getLogger(JobUtils.class);
	
	@Autowired
	JobDataRepository jobDataRepository;
	
	public JobData startJob(String jobName, String submittedBy) {
		JobData jobData = new JobData();
		jobData.setName(jobName);
		jobData.setStartTime(new Timestamp(System.currentTimeMillis()));
		jobData.setStatus(JobStatus.IN_PROGRESS.getStatus());
		jobData.setSubmissionTime(jobData.getStartTime());
		jobData.setSubmittedBy(submittedBy);
		jobData = jobDataRepository.save(jobData);
		log.debug("Started Job: {}", jobData);
		return jobData;
	}

	public JobData endJob(JobData jobData, String additionalMessage) {
		jobData.setEndTime(new Timestamp(System.currentTimeMillis()));
		jobData.setStatus(JobStatus.FINISHED.getStatus());
		if(StringUtils.isEmpty(additionalMessage)) {
			jobData.setAdditionalDetails("Job completed successfully");
		} else {
			jobData.setAdditionalDetails(additionalMessage);
		}
		log.debug("Finished Job: {}", jobData);
		return jobDataRepository.save(jobData);
	}
}
