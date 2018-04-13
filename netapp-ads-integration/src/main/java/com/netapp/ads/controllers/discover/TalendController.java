package com.netapp.ads.controllers.discover;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.netapp.ads.services.OwnerIdentificationService;


@RestController
@RequestMapping("/api/talendJobs")
public class TalendController {

	private static final Logger log = LoggerFactory.getLogger(TalendController.class);

	@Autowired
	private OwnerIdentificationService ownerIdentificationService;

	@Value("#{sysConfigRepository.findByPropertyName('ads.talendjobs.loc').getPropertyValue()}")
	public String batchScriptsLoc;  




	@RequestMapping(value = "userRoles", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public @ResponseBody ResponseEntity<?>  loadUserRoles(@RequestParam("file") MultipartFile inputFile) {
		String jobName = runADSJob(TalendConstants.JOB_NAME_USER_ROLES, inputFile, TalendConstants.ADS_SETUP_LOADSHEET_USER_ROLES_XLSX);
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);
	}

	@RequestMapping(value = "userNatives", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadUserNatives(@RequestParam("file") MultipartFile inputFile) {

		String jobName = runADSJob(TalendConstants.JOB_NAME_USER_NATIVES, inputFile, TalendConstants.ADS_SETUP_LOADSHEET_USER_NATIVES_XLSX);
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);	
	}

	@RequestMapping(value = "auditEvents", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadAuditEvents(@RequestParam("file") MultipartFile inputFile) {
		String jobName = runADSJob(TalendConstants.JOB_NAME_USER_NATIVES, inputFile, TalendConstants.ADS_SETUP_LOADSHEET_AUDIT_EVENT_XLSX);
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);	
	}

	@RequestMapping(value = "auditReasonCodes", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadAuditReasonCodes(@RequestParam("file") MultipartFile inputFile) {
		String jobName = runADSJob(TalendConstants.JOB_NAME_USER_NATIVES, inputFile, TalendConstants.ADS_SETUP_LOADSHEET_AUDIT_REASON_CODE_XLSX);
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);	
	}

	@RequestMapping(value = "applications", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadApplications(@RequestParam("file") MultipartFile inputFile) {
		String jobName = runADSJob(TalendConstants.JOB_NAME_USER_NATIVES, inputFile, TalendConstants.ADS_SETUP_LOADSHEET_APPLICATION_XLSX);
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);	
	}

	@RequestMapping(value = "sysConfigPropertyTypes", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadSysConfigPropertyTypes(@RequestParam("file") MultipartFile inputFile) {
		String jobName = runADSJob(TalendConstants.JOB_NAME_USER_NATIVES, inputFile, TalendConstants.ADS_SETUP_LOADSHEET_SYS_CONFIG_PROPERTY_TYPE_XLSX);
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);	
	}

	@RequestMapping(value = "migrationTimes", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadMigrationTimes(@RequestParam("file") MultipartFile inputFile) {
		String jobName = runADSJob(TalendConstants.JOB_NAME_USER_NATIVES, inputFile, TalendConstants.ADS_SETUP_LOADSHEET_MIGRATION_TIME_XLSX);
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);	
	}

	@RequestMapping(value = "mstEmailTypes", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadMstEmailTypes(@RequestParam("file") MultipartFile inputFile) {

		String jobName = runADSJob(TalendConstants.JOB_NAME_USER_NATIVES, inputFile, TalendConstants.ADS_SETUP_LOADSHEET_MST_EMAIL_TYPE_XLSX);
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);	
	}

	@RequestMapping(value = "schedules", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadSchedules(@RequestParam("file") MultipartFile inputFile) {

		String jobName = runADSJob(TalendConstants.JOB_NAME_USER_NATIVES, inputFile, TalendConstants.ADS_SETUP_LOADSHEET_SCHEDULE_XLSX);
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);		
	}


	@RequestMapping(value = "hosts", method = RequestMethod.POST)
	public ResponseEntity<?> loadHosts() {

		String jobName = runTalendJob(TalendConstants.JOB_NAME_HOSTS, null, TalendConstants.JOB_TYPE_OCI_LOAD, null);

		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);	
	}

	@RequestMapping(value = "storage", method = RequestMethod.POST)
	public ResponseEntity<?> loadStorage() {
		String jobName = runTalendJob(TalendConstants.JOB_NAME_STORAGE, null,  TalendConstants.JOB_TYPE_OCI_LOAD,null);

		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);	
	}


	@RequestMapping(value = "dataCenters", method = RequestMethod.POST)
	public ResponseEntity<?> loadDataCenters() {

		String jobName = runTalendJob(TalendConstants.JOB_NAME_DATACENTERS, null,  TalendConstants.JOB_TYPE_OCI_LOAD,null);

		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);	
	}

	@RequestMapping(value = "controllers", method = RequestMethod.POST)
	public ResponseEntity<?> loadControllers() {

		String jobName = runTalendJob(TalendConstants.JOB_NAME_CONTROLLERS, null,  TalendConstants.JOB_TYPE_OCI_LOAD,null);

		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);	
	}

	@RequestMapping(value = "aggregates", method = RequestMethod.POST)
	public ResponseEntity<?> loadAggregates() {

		String jobName = runTalendJob(TalendConstants.JOB_NAME_AGGREGATES, null,  TalendConstants.JOB_TYPE_OCI_LOAD,null);

		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);	
	}

	@RequestMapping(value = "nasVolumes", method = RequestMethod.POST)
	public ResponseEntity<?> loadNasVolumes() {

		String jobName = runTalendJob(TalendConstants.JOB_NAME_NAS_VOLUMES, null, TalendConstants.JOB_TYPE_OCI_LOAD,null);

		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);	
	}

	@RequestMapping(value = "qtrees", method = RequestMethod.POST)
	public ResponseEntity<?> loadQTrees() {

		String jobName = runTalendJob(TalendConstants.JOB_NAME_QTREES, null, TalendConstants.JOB_TYPE_OCI_LOAD,null);

		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);	
	}	



	@RequestMapping(value = "shares", method = RequestMethod.POST)
	public ResponseEntity<?>  loadShares() {

		String jobName = runTalendJob(TalendConstants.JOB_NAME_SHARES, null, TalendConstants.JOB_TYPE_OCI_LOAD,null);
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", jobName), HttpStatus.OK);				

	}

	@RequestMapping(value = "runAllOci", method = RequestMethod.POST)
	public String loadAllOCIData() {

		// FIXME: We cannot launch the next job until the previous one completed!
		loadHosts();
		loadStorage();
		loadDataCenters();
		loadControllers();
		loadAggregates();
		loadNasVolumes();
		loadQTrees();
		loadShares();

		return TalendConstants.STR_JOB_SUBMITTED;
	}

	public String getJobInstanceName(String jobName, long currentTimeMillis) {

		return jobName + TalendConstants.UNDERSCORE + currentTimeMillis;
	}


	public String getTempLocation() {
		log.info("getTempLocation: java.io.tmpdir: {}", System.getProperty(TalendConstants.TEMP_ATTR_NAME));	
		String tempLocation = System.getProperty(TalendConstants.TEMP_ATTR_NAME);
		return tempLocation;
	}

	public String runADSJob(String jobId, @RequestParam("file") MultipartFile inputFile, String inputFileParamName) {

		long currentTimeMillis = System.currentTimeMillis();
		String batchScript = getBatchScript(jobId);

		log.info("runADSJob: batchScript: {}", batchScript);

		if (inputFile!=null && !inputFile.isEmpty()) {

			String originalFilename = inputFile.getOriginalFilename();
			String newFileName=getNewFileName(originalFilename, currentTimeMillis);
			//File destinationFile = new File(getTempLocation() + File.separator + originalFilename.replaceAll(" ", "")+System.);
			File destinationFile = new File(getTempLocation() + File.separator + newFileName);

			try {
				inputFile.transferTo(destinationFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			String jobName = runTalendJob(newFileName, batchScript, TalendConstants.JOB_TYPE_ADS_SETUP,inputFileParamName);
			log.info("runADSJob: DESTINATION FILE Exists: {}", destinationFile.getAbsolutePath());
			log.info("runADSJob: jobName: {}", jobName);
			return jobName;
		}

		return "No Job Name";

	}

	public String getNewFileName(String originalFilename, long currentTimeMillis) {


		String newFileName=(originalFilename.substring(0, originalFilename.indexOf("."))+"_"+currentTimeMillis+originalFilename.substring(originalFilename.indexOf("."))).replaceAll(" ", TalendConstants.UNDERSCORE);
		return newFileName;
	}


	public String runTalendJob(String jobId, String inputFileName, String jobType, String inputFileParamName) {
		long currentTimeMillis = System.currentTimeMillis(); // Keep
		String batchScript = getBatchScript(jobId);
		String jobName = getJobInstanceName(jobId, currentTimeMillis);

		log.info("runTalendJob: jobName: {}", jobName);

		CommandLine command = null;
		if (TalendConstants.JOB_TYPE_ADS_SETUP.equalsIgnoreCase(jobType)) {
			command = getCommandLine(batchScript, inputFileName, jobType,inputFileParamName,jobName);
		} else if (TalendConstants.JOB_TYPE_OCI_LOAD.equalsIgnoreCase(jobType)) {
			command = getCommandLine(batchScript, null, jobType,null,jobName);
		}

		try {
			DefaultExecutor executor = new DefaultExecutor();
			executor.setStreamHandler(new PumpStreamHandler());
			executor.execute(command, new DefaultExecuteResultHandler());
		} catch (ExecuteException e) {
			//e.printStackTrace();
			log.error("Error executing Talend job", e);
		} catch (IOException e) {
			//e.printStackTrace();
			log.error("Error executing Talend job", e);
		}
		return jobName;
	}

	public CommandLine getCommandLine(String batchScript, String inputFileName, String jobType,String inputFileParamName,String jobName) {

		StringBuilder commandString=new StringBuilder();

		String authorizationToken=getAuthorizationToken();
		String loginUserName=getLogInUserName();
		if (TalendConstants.JOB_TYPE_ADS_SETUP.equalsIgnoreCase(jobType)) {
			commandString.append(" "+TalendConstants.CONTEXT_PARAM+ TalendConstants.LOAD_FILES_LOC + "=" + getTempLocation());
			commandString.append(" "+TalendConstants.CONTEXT_PARAM+ inputFileParamName + "=" + inputFileName);
		}

		commandString.append(" "+TalendConstants.CONTEXT_PARAM+ TalendConstants.ENV_CONTEXT_FILE_PARAM_NAME + "=" + batchScriptsLoc+"/"+TalendConstants.ENV_CONTEXT_FILE_NAME);
		commandString.append(" "+TalendConstants.CONTEXT_PARAM+TalendConstants.STR_AUTH_TOKEN+ "=" + authorizationToken);
		commandString.append(" "+TalendConstants.CONTEXT_PARAM+TalendConstants.JOB_SUBMITTED_BY+ "=" + loginUserName);
		commandString.append(" "+TalendConstants.CONTEXT_PARAM+TalendConstants.JOB_RUN_NAME + "=" + jobName);

		CommandLine commandLine = createBatchScript(batchScript,commandString.toString(),jobName);

		log.info("runTalendJob: COMMAND: {}", commandLine.toString());
		return commandLine;
	}


	public String getAuthorizationToken() {

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		String token=attr.getRequest().getHeaders(TalendConstants.STR_AUTHORIZATION).nextElement();

		token=token.replace(TalendConstants.STR_BEARER, "");

		token=token.replaceAll(" ", "");
		log.info("getAuthorizationToken: TOKEN: {}", token);
		return token;
	}

	public String getLogInUserName() {

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		String loginUser=attr.getRequest().getUserPrincipal().getName();
		return loginUser;
	}	

	public String getBatchScript(String jobName) {

		String batchScript = batchScriptsLoc + File.separator + jobName+ File.separator + jobName + "_run.bat";

		return batchScript;
	}

	public String getNewBatchScript(String jobName, long currentTimeMillis) {

		String batchScript = batchScriptsLoc + File.separator + jobName+ File.separator + jobName+"_"+ currentTimeMillis + "_run.bat";

		return batchScript;
	}

	public CommandLine createBatchScript(String batchScript,String commandString,String jobName) {

		CommandLine commandLine=null;
		String OS = System.getProperty(TalendConstants.STR_OS_NAME).toLowerCase();
		if(OS.indexOf(TalendConstants.STR_OS_WINDOWS) >= 0) {

			commandLine= createWindowsBatchScript(batchScript, commandString, jobName);
		} else  {
			//if((OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ))

			commandLine= createLinuxBatchScript(batchScript, commandString, jobName);
		}
		return commandLine;
	}

	public CommandLine createWindowsBatchScript(String batchScript,String commandString,String jobName) {

		CommandLine command =null;
		try {

			File originalBatchScript=new File(batchScript);
			String javaBatchCommand=getJavaBatchCommand(originalBatchScript);
			String finalTalendJobCommand=javaBatchCommand+" "+commandString;

			finalTalendJobCommand=finalTalendJobCommand.replace('\\', '/');

			String parentFldr=originalBatchScript.getParent();
			log.info("createWindowsBatchScript: parentFldr: {}", parentFldr);

			String strNewBatchFile=parentFldr+File.separator+jobName+TalendConstants.STR_BAT_EXT;

			File newBatchFile=new File(strNewBatchFile ); 

			try (BufferedWriter bw=new BufferedWriter(new FileWriter(newBatchFile))) {
				bw.write(TalendConstants.STR_CD+parentFldr);
				bw.newLine();
				bw.write(finalTalendJobCommand);
			}

			command = CommandLine.parse(newBatchFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return command;
	}

	public CommandLine createLinuxBatchScript(String batchScript,String commandString,String jobName) {

		CommandLine command =null;
		try {

			File originalBatchScript=new File(batchScript);
			String javaBatchCommand=getJavaBatchCommand(originalBatchScript);
			String finalTalendJobCommand=javaBatchCommand+" "+commandString;

			finalTalendJobCommand=finalTalendJobCommand.replace('\\', '/');

			String parentFldr=originalBatchScript.getParent();
			log.info("createLinuxBatchScript: parentFldr: {}", parentFldr);

			String strNewBatchFile=parentFldr+File.separator+jobName+TalendConstants.STR_SH_EXT;

			File newBatchFile=new File(strNewBatchFile );
			boolean isExecutable = newBatchFile.setExecutable(true, false);
			log.debug("createLinuxBatchScript: isExecutable: {}", isExecutable);

			try (BufferedWriter bw=new BufferedWriter(new FileWriter(newBatchFile))) {
				bw.write(TalendConstants.STR_CD+parentFldr);
				bw.newLine();
				bw.write(TalendConstants.STR_SET_PWD);
				bw.newLine();
				bw.write(finalTalendJobCommand);
			}

			command = CommandLine.parse(newBatchFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return command;
	}

	public String getJavaBatchCommand(File originalBatchScript) {

		String line = null;
		try {
			try (BufferedReader br=new BufferedReader(new FileReader(originalBatchScript))) {
				while((line=br.readLine())!=null) {

					if(line.trim().startsWith(TalendConstants.STR_JAVA)) {
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			log.error("File not found!");
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error("IO expection");
			log.error(e.getMessage());
		}
		return line;
	}
}
