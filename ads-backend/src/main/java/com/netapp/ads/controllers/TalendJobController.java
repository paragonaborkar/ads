package com.netapp.ads.controllers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.netapp.ads.converters.TalendConstants;

@RestController
@RequestMapping("/talendJobs")
public class TalendJobController {

	String batchScriptsLoc = TalendConstants.BATCH_SCRIPTS_LOC;
	
	@RequestMapping(value = "userRoles", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public @ResponseBody ResponseEntity<?>  loadUserRoles(@RequestParam("file") MultipartFile inputFile) {

		System.out.println(inputFile.toString());
		System.out.println(inputFile.getOriginalFilename());
		
		String batchScript = getBatchScript(TalendConstants.JOB_NAME_USER_ROLES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_USER_ROLES);

		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript);
		return new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "userNatives", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadUserNatives(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_USER_NATIVES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_USER_NATIVES);
		
		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "auditEvents", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadAuditEvents(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_AUDIT_EVENTS);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_AUDIT_EVENTS);

		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "auditReasonCodes", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadAuditReasonCodes(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_AUDIT_REASON_CODES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_AUDIT_REASON_CODES);

		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "applications", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadApplications(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_APPLICATIONS);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_APPLICATIONS);

		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "sysConfigPropertyTypes", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadSysConfigPropertyTypes(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_SYSCONFIG_PROPERTY_TYPES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_SYSCONFIG_PROPERTY_TYPES);

		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "migrationTimes", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadMigrationTimes(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_MIGRATION_TIMES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_MIGRATION_TIMES);

		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript);
		return new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "mstEmailTypes", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadMstEmailTypes(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_MST_EMAIL_TYPES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_MST_EMAIL_TYPES);

		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "schedules", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadSchedules(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_SCHEDULES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_SCHEDULES);

		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}
	
	@RequestMapping(value = "hosts", method = RequestMethod.POST)
	public ResponseEntity<?> loadHosts() {
		
		String batchScript = getBatchScript(TalendConstants.JOB_NAME_HOSTS);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_HOSTS);

		System.out.println("batchScript**" + batchScript);
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD);

		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "storage", method = RequestMethod.POST)
	public ResponseEntity<?> loadStorage() {
		
		String batchScript = getBatchScript(TalendConstants.JOB_NAME_STORAGE);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_STORAGE);

		System.out.println("batchScript**" + batchScript);
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD);

		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "dataCenters", method = RequestMethod.POST)
	public ResponseEntity<?> loadDataCenters() {
		
		String batchScript = getBatchScript(TalendConstants.JOB_NAME_DATACENTERS);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_DATACENTERS);

		System.out.println("batchScript**" + batchScript);
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD);

		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}
	
	@RequestMapping(value = "controllers", method = RequestMethod.POST)
	public ResponseEntity<?> loadControllers() {
		
		String batchScript = getBatchScript(TalendConstants.JOB_NAME_CONTROLLERS);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_CONTROLLERS);

		System.out.println("batchScript**" + batchScript);
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD);

		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}
	
	@RequestMapping(value = "aggregates", method = RequestMethod.POST)
	public ResponseEntity<?> loadAggregates() {
		
		String batchScript = getBatchScript(TalendConstants.JOB_NAME_AGGREGATES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_AGGREGATES);

		System.out.println("batchScript**" + batchScript);
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD);

		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}
	
	@RequestMapping(value = "nasVolumes", method = RequestMethod.POST)
	public ResponseEntity<?> loadNasVolumes() {
		
		String batchScript = getBatchScript(TalendConstants.JOB_NAME_NAS_VOLUMES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_NAS_VOLUMES);

		System.out.println("batchScript**" + batchScript);
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD);

		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}
		
	@RequestMapping(value = "qtrees", method = RequestMethod.POST)
	public ResponseEntity<?> loadQTrees() {
		
		String batchScript = getBatchScript(TalendConstants.JOB_NAME_QTREES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_QTREES);

		System.out.println("batchScript**" + batchScript);
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD);

		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}	
	
	@RequestMapping(value = "shares", method = RequestMethod.POST)
	public ResponseEntity<?> loadShares() {
		
		String batchScript = getBatchScript(TalendConstants.JOB_NAME_SHARES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_SHARES);

	
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD);
		System.out.println("batchScript**" + batchScript);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
		
		
	}		
	public String getJobInstanceName(String jobName) {
		
		return jobName+ TalendConstants.UNDERSCORE + System.currentTimeMillis();
	}
	public String getTempLocation() {

		System.out.println("Temp Location***********" + System.getProperty("java.io.tmpdir"));
		String tempLocation = System.getProperty(TalendConstants.TEMP_ATTR_NAME);
		return tempLocation;
	}
	
	public void runADSJob(String jobName, @RequestParam("file") MultipartFile inputFile, String batchScript) {
		
		if (!inputFile.isEmpty()) {

			String originalFilename = inputFile.getOriginalFilename();
			File destinationFile = new File(getTempLocation() + File.separator + originalFilename);

			try {
				inputFile.transferTo(destinationFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			runTalendJob(jobName, originalFilename, batchScript, TalendConstants.JOB_TYPE_ADS_SETUP);
			System.out.println("DESTINATION FILE Exists:" + destinationFile.getAbsolutePath());
		}
		
	}
	public void runTalendJob(String jobName, String originalFilename, String batchScript,
			String jobType) {

		CommandLine command = null;
		if (TalendConstants.JOB_TYPE_ADS_SETUP.equalsIgnoreCase(jobType)) {
			command = getCommandLine(batchScript, originalFilename, jobType);
		} else if (TalendConstants.JOB_TYPE_OCI_LOAD.equalsIgnoreCase(jobType)) {
			command = getCommandLine(batchScript, null, jobType);
			System.out.println("OCI LOAD COMMAND***********:" + command.toString());
		}

		try {
			DefaultExecutor executor = new DefaultExecutor();
			executor.setStreamHandler(new PumpStreamHandler());
			executor.execute(command, new DefaultExecuteResultHandler());
		} catch (ExecuteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CommandLine getCommandLine(String batchScript, String originalFilename, String jobType) {

		CommandLine command = new CommandLine(batchScript);
		if (TalendConstants.JOB_TYPE_ADS_SETUP.equalsIgnoreCase(jobType)) {
			command.parse(TalendConstants.CONTEXT_PARAM+ TalendConstants.LOAD_FILES_LOC + "=" + getTempLocation());
			command.parse(TalendConstants.CONTEXT_PARAM+ TalendConstants.ADS_SETUP_LOADSHEET_USER_ROLES_XLSX + "=" + originalFilename);
		}
		return command;
	}


	public String getBatchScript(String jobName) {

		String batchScript = batchScriptsLoc + File.separator + jobName+ File.separator + jobName + "_run.bat";

		return batchScript;
	}
}
