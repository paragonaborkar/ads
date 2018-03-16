package com.netapp.ads.controllers;

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

import com.netapp.ads.converters.TalendConstants;


@RestController
@RequestMapping("/talendJobs")
public class TalendJobController {


	@Value("${talendjobs.loc}") 
	public String batchScriptsLoc;  


	@RequestMapping(value = "userRoles", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public @ResponseBody ResponseEntity<?>  loadUserRoles(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_USER_ROLES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_USER_ROLES);

		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript,TalendConstants.ADS_SETUP_LOADSHEET_USER_ROLES_XLSX);
		return new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "userNatives", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadUserNatives(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_USER_NATIVES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_USER_NATIVES);

		System.out.println("batchScript**" + batchScript);


		runADSJob(jobName, inputFile, batchScript,TalendConstants.ADS_SETUP_LOADSHEET_USER_NATIVES_XLSX);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "auditEvents", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadAuditEvents(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_AUDIT_EVENTS);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_AUDIT_EVENTS);

		System.out.println("batchScript**" + batchScript);


		runADSJob(jobName, inputFile, batchScript,TalendConstants.ADS_SETUP_LOADSHEET_AUDIT_EVENT_XLSX);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "auditReasonCodes", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadAuditReasonCodes(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_AUDIT_REASON_CODES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_AUDIT_REASON_CODES);

		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript,TalendConstants.ADS_SETUP_LOADSHEET_AUDIT_REASON_CODE_XLSX);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "applications", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadApplications(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_APPLICATIONS);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_APPLICATIONS);

		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript,TalendConstants.ADS_SETUP_LOADSHEET_APPLICATION_XLSX);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "sysConfigPropertyTypes", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadSysConfigPropertyTypes(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_SYSCONFIG_PROPERTY_TYPES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_SYSCONFIG_PROPERTY_TYPES);

		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript,TalendConstants.ADS_SETUP_LOADSHEET_SYS_CONFIG_PROPERTY_TYPE_XLSX);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "migrationTimes", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadMigrationTimes(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_MIGRATION_TIMES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_MIGRATION_TIMES);

		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript,TalendConstants.ADS_SETUP_LOADSHEET_MIGRATION_TIME_XLSX);
		return new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "mstEmailTypes", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadMstEmailTypes(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_MST_EMAIL_TYPES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_MST_EMAIL_TYPES);

		System.out.println("batchScript**" + batchScript);

		runADSJob(jobName, inputFile, batchScript,TalendConstants.ADS_SETUP_LOADSHEET_MST_EMAIL_TYPE_XLSX);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "schedules", method = RequestMethod.POST, headers = ("content-type=multipart/*"))
	public ResponseEntity<?> loadSchedules(@RequestParam("file") MultipartFile inputFile) {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_SCHEDULES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_SCHEDULES);

		System.out.println("batchScript**" + batchScript);

		
		runADSJob(jobName, inputFile, batchScript,TalendConstants.ADS_SETUP_LOADSHEET_SCHEDULE_XLSX);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
		
	}

	@RequestMapping(value = "hosts", method = RequestMethod.POST)
	public ResponseEntity<?> loadHosts() {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_HOSTS);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_HOSTS);

		System.out.println("batchScript**" + batchScript);
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD,null);

		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "storage", method = RequestMethod.POST)
	public ResponseEntity<?> loadStorage() {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_STORAGE);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_STORAGE);

		System.out.println("batchScript**" + batchScript);
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD,null);

		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "dataCenters", method = RequestMethod.POST)
	public ResponseEntity<?> loadDataCenters() {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_DATACENTERS);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_DATACENTERS);

		System.out.println("batchScript**" + batchScript);
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD,null);

		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "controllers", method = RequestMethod.POST)
	public ResponseEntity<?> loadControllers() {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_CONTROLLERS);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_CONTROLLERS);

		System.out.println("batchScript**" + batchScript);
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD,null);

		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "aggregates", method = RequestMethod.POST)
	public ResponseEntity<?> loadAggregates() {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_AGGREGATES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_AGGREGATES);

		System.out.println("batchScript**" + batchScript);
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD,null);

		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "nasVolumes", method = RequestMethod.POST)
	public ResponseEntity<?> loadNasVolumes() {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_NAS_VOLUMES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_NAS_VOLUMES);

		System.out.println("batchScript**" + batchScript);
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD,null);

		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}

	@RequestMapping(value = "qtrees", method = RequestMethod.POST)
	public ResponseEntity<?> loadQTrees() {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_QTREES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_QTREES);

		System.out.println("batchScript**" + batchScript);
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD,null);

		return  new ResponseEntity("Running Job.", HttpStatus.OK);
	}	



	@RequestMapping(value = "shares", method = RequestMethod.POST)
	public ResponseEntity<?>  loadShares() {

		String batchScript = getBatchScript(TalendConstants.JOB_NAME_SHARES);
		String jobName = getJobInstanceName(TalendConstants.JOB_NAME_SHARES);

		System.out.println("batchScript**" + batchScript);
		
		runTalendJob(jobName, null, batchScript, TalendConstants.JOB_TYPE_OCI_LOAD,null);
		return  new ResponseEntity("Running Job.", HttpStatus.OK);
				

	}

	@RequestMapping(value = "runAllOciLoads", method = RequestMethod.POST)
	public String loadAllOCIData() {
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

	public String getJobInstanceName(String jobName) {

		return jobName+ TalendConstants.UNDERSCORE + System.currentTimeMillis();
	}
	public String getTempLocation() {

		System.out.println("Temp Location***********" + System.getProperty("java.io.tmpdir"));
		String tempLocation = System.getProperty(TalendConstants.TEMP_ATTR_NAME);
		return tempLocation;
	}

	public void runADSJob(String jobName, @RequestParam("file") MultipartFile inputFile, String batchScript,String inputFileParamName) {

		if (inputFile!=null && !inputFile.isEmpty()) {

			String originalFilename = inputFile.getOriginalFilename();
			String newFileName=getNewFileName(originalFilename);
			//File destinationFile = new File(getTempLocation() + File.separator + originalFilename.replaceAll(" ", "")+System.);
			File destinationFile = new File(getTempLocation() + File.separator + newFileName);

			try {
				inputFile.transferTo(destinationFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			runTalendJob(jobName, newFileName, batchScript, TalendConstants.JOB_TYPE_ADS_SETUP,inputFileParamName);
			System.out.println("DESTINATION FILE Exists:" + destinationFile.getAbsolutePath());
		}

	}

	public String getNewFileName(String originalFilename) {


		String newFileName=(originalFilename.substring(0, originalFilename.indexOf("."))+"_"+System.currentTimeMillis()+originalFilename.substring(originalFilename.indexOf("."))).replaceAll(" ", TalendConstants.UNDERSCORE);
		return newFileName;
	}
	public void runTalendJob(String jobName, String inputFileName, String batchScript,
			String jobType,String inputFileParamName) {

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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CommandLine getCommandLine(String batchScript, String inputFileName, String jobType,String inputFileParamName,String jobName) {

		StringBuilder commandString=new StringBuilder();

		String authorizationToken=getAuthorizationToken();
		if (TalendConstants.JOB_TYPE_ADS_SETUP.equalsIgnoreCase(jobType)) {
			commandString.append(" "+TalendConstants.CONTEXT_PARAM+ TalendConstants.LOAD_FILES_LOC + "=" + getTempLocation());
			commandString.append(" "+TalendConstants.CONTEXT_PARAM+ inputFileParamName + "=" + inputFileName);
		}

		commandString.append(" "+TalendConstants.CONTEXT_PARAM+ TalendConstants.ENV_CONTEXT_FILE_PARAM_NAME + "=" + batchScriptsLoc+"/"+TalendConstants.ENV_CONTEXT_FILE_NAME);
		commandString.append(" "+TalendConstants.CONTEXT_PARAM+TalendConstants.STR_AUTH_TOKEN+authorizationToken);
		CommandLine commandLine = createBatchScript(batchScript,commandString.toString(),jobName);

		System.out.println("COMMAND:"+commandLine.toString());
		return commandLine;
	}


	public String getAuthorizationToken() {

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		String token=attr.getRequest().getHeaders(TalendConstants.STR_AUTHORIZATION).nextElement();
		token=token.replace(TalendConstants.STR_BEARER, "");
		token=token.replaceAll(" ", "");
		System.out.println("TOKEN******"+token);	
		return token;
	}

	/*public static void main(String[] args) {

		StringBuilder sb=new StringBuilder("cd C:/netapp/talendjobs");

		CommandLine command = CommandLine.parse(sb.toString());

		//new TalendJobController().createWindowsBatchScript();
		//new TalendJobController().loadUserRoles(null);
		String str="java -Xms256M -Xmx1024M -cp .;../lib/routines.jar;../lib/activation.jar;../lib/advancedPersistentLookupLib-1.0.jar;../lib/aopalliance-1.0.jar;../lib/bcprov_1.51.0.jar;../lib/com.google.guava_15.0.0.v201403281430.jar;../lib/commons-beanutils-1.8.3.jar;../lib/commons-collections-3.2.2.jar;../lib/commons-collections4-4.1.jar;../lib/commons-lang-2.6.jar;../lib/commons-logging-1.1.1.jar;../lib/cryptacular-1.0.jar;../lib/cxf-core-3.1.11.jar;../lib/cxf-rt-bindings-soap-3.1.11.jar;../lib/cxf-rt-databinding-jaxb-3.1.11.jar;../lib/cxf-rt-frontend-jaxrs-3.1.11.jar;../lib/cxf-rt-rs-client-3.1.11.jar;../lib/cxf-rt-rs-extension-providers-3.1.11.jar;../lib/cxf-rt-security-3.1.11.jar;../lib/cxf-rt-security-saml-3.1.11.jar;../lib/cxf-rt-transports-http-3.1.11.jar;../lib/cxf-rt-ws-security-3.1.11.jar;../lib/cxf-rt-wsdl-3.1.11.jar;../lib/dom4j-1.6.1.jar;../lib/ehcache-2.10.3.jar;../lib/ezmorph-1.0.6.jar;../lib/geronimo-stax-api_1.0_spec-1.0.1.jar;../lib/jakarta-oro-2.0.8.jar;../lib/jasypt-1.9.2.jar;../lib/javax.annotation_1.2.0.v201401042248.jar;../lib/javax.ws.rs-api-2.0.1.jar;../lib/javax.wsdl_1.6.2.v201012040545.jar;../lib/jaxen-1.1.1.jar;../lib/jboss-serialization.jar;../lib/jettison-1.3.7.jar;../lib/joda-time-2.7.jar;../lib/json-lib-2.4-jdk15.jar;../lib/log4j-1.2.15.jar;../lib/log4j-1.2.16.jar;../lib/mail-1.4.jar;../lib/neethi-3.0.3.jar;../lib/opensaml-core-3.1.1.jar;../lib/opensaml-profile-api-3.1.1.jar;../lib/opensaml-saml-api-3.1.1.jar;../lib/opensaml-saml-impl-3.1.1.jar;../lib/opensaml-security-api-3.1.1.jar;../lib/opensaml-security-impl-3.1.1.jar;../lib/opensaml-soap-api-3.1.1.jar;../lib/opensaml-xacml-api-3.1.1.jar;../lib/opensaml-xacml-impl-3.1.1.jar;../lib/opensaml-xacml-saml-api-3.1.1.jar;../lib/opensaml-xacml-saml-impl-3.1.1.jar;../lib/opensaml-xmlsec-api-3.1.1.jar;../lib/opensaml-xmlsec-impl-3.1.1.jar;../lib/org.apache.commons.codec_1.6.0.v201305230611.jar;../lib/org.apache.commons.logging_1.2.0.jar;../lib/org.apache.log4j_1.2.15.v201012070815.jar;../lib/poi-3.16-20170419_modified_talend.jar;../lib/poi-ooxml-3.16-20170419_modified_talend.jar;../lib/poi-ooxml-schemas-3.16-20170419.jar;../lib/poi-scratchpad-3.16-20170419.jar;../lib/security-common-6.4.1.jar;../lib/slf4j-api-1.7.5.jar;../lib/slf4j-log4j12-1.7.5.jar;../lib/spring-aop-3.2.14.RELEASE.jar;../lib/spring-beans-3.2.14.RELEASE.jar;../lib/spring-context-3.2.14.RELEASE.jar;../lib/spring-core-3.2.14.RELEASE.jar;../lib/spring-expression-3.2.14.RELEASE.jar;../lib/stax-api-1.0.1.jar;../lib/stax2-api-3.1.4.jar;../lib/talend_file_enhanced_20070724.jar;../lib/talendcsv.jar;../lib/trove.jar;../lib/woodstox-core-asl-4.4.1.jar;../lib/wss4j-policy-2.1.9.jar;../lib/wss4j-ws-security-common-2.1.9.jar;../lib/wss4j-ws-security-dom-2.1.9.jar;../lib/wss4j-ws-security-policy-stax-2.1.9.jar;../lib/wss4j-ws-security-stax-2.1.9.jar;../lib/xmlbeans-2.6.0.jar;../lib/xmlschema-core-2.2.1.jar;../lib/xmlsec-2.0.8.jar;../lib/xom-1.2.7.jar;ads_setup_1_userroles_0_1.jar;adsload_subjob_sendemail_0_1.jar;postprocess_0_1.jar;logjobdetails_0_1.jar;adsload_subjob_rest_0_1.jar;deletetemporaryfiles_0_1.jar; ads_data.ads_setup_1_userroles_0_1.ADS_Setup_1_UserRoles --context_param, LOAD_FILES_LOC=C:\\Users\\bondmoha\\AppData\\Local\\Temp\\, --context_param, ADS_SETUP_LOADSHEET_USER_ROLES_XLSX=LoadSheet_UserRoles_Template.xlsx, --context_param, ENV_CONTEXT_FILE=C:/netapp/talendjobs//ads_local_context.properties, --context_param, OAUTH_BEARER_TOKEN=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoidGFsZW5kIiwiYWRzX21vZHVsZXMiOnsiZGlzY292ZXIiOnRydWUsInJlcG9ydHMiOmZhbHNlLCJzY2hlZHVsZSI6ZmFsc2UsInBsYW5uaW5nIjpmYWxzZSwiZXhlY3V0ZSI6ZmFsc2UsImNvbm5lY3Rpb25zIjp0cnVlfSwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTUyMTA3NDc3NSwiYXV0aG9yaXRpZXMiOlsiQ0xJRU5UIl0sImp0aSI6IjQwMzhmZDY1LTUyZjktNDMxOS04MTc4LTljMzk5NGM2ZDI1MiIsImNsaWVudF9pZCI6InRlc3Rqd3RjbGllbnRpZCJ9.-lJyyypn7hEgjZq4drW04f_pMTmyUTqdGnE0UfG9DvU  --context_param LOAD_FILES_LOC=C:\\Users\\bondmoha\\AppData\\Local\\Temp\\ --context_param ADS_SETUP_LOADSHEET_USER_ROLES_XLSX=LoadSheet_UserRoles_Template.xlsx --context_param ENV_CONTEXT_FILE=C:/netapp/talendjobs//ads_local_context.properties --context_param OAUTH_BEARER_TOKEN=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoidGFsZW5kIiwiYWRzX21vZHVsZXMiOnsiZGlzY292ZXIiOnRydWUsInJlcG9ydHMiOmZhbHNlLCJzY2hlZHVsZSI6ZmFsc2UsInBsYW5uaW5nIjpmYWxzZSwiZXhlY3V0ZSI6ZmFsc2UsImNvbm5lY3Rpb25zIjp0cnVlfSwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTUyMTA3NDc3NSwiYXV0aG9yaXRpZXMiOlsiQ0xJRU5UIl0sImp0aSI6IjQwMzhmZDY1LTUyZjktNDMxOS04MTc4LTljMzk5NGM2ZDI1MiIsImNsaWVudF9pZCI6InRlc3Rqd3RjbGllbnRpZCJ9.-lJyyypn7hEgjZq4drW04f_pMTmyUTqdGnE0UfG9DvU";
		System.out.println("old String: "+str);
		str=str.replace('\\', '/');
		System.out.println("new String: "+str);

		String OS = System.getProperty("os.name").toLowerCase();
		if(OS.indexOf("win") >= 0) {

			System.out.println("WINDOWS:"+OS);
		} else if((OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 )) {
			System.out.println("LINUX:"+OS);
		}

		System.out.println(new TalendJobController().getNewFileName("Test file wit spaces.xlsx"));


	}*/

	public String getBatchScript(String jobName) {

		String batchScript = batchScriptsLoc + File.separator + jobName+ File.separator + jobName + "_run.bat";

		return batchScript;
	}

	public String getNewBatchScript(String jobName) {

		String batchScript = batchScriptsLoc + File.separator + jobName+ File.separator + jobName+"_"+System.currentTimeMillis() + "_run.bat";

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
			System.out.println("Parent Folder"+parentFldr);

			String strNewBatchFile=parentFldr+File.separator+jobName+TalendConstants.STR_BAT_EXT;

			File newBatchFile=new File(strNewBatchFile ); 

			BufferedWriter bw=new BufferedWriter(new FileWriter(newBatchFile));
			bw.write(TalendConstants.STR_CD+parentFldr);
			bw.newLine();
			bw.write(finalTalendJobCommand);
			bw.close();

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
			System.out.println("Parent Folder"+parentFldr);

			String strNewBatchFile=parentFldr+File.separator+jobName+TalendConstants.STR_SH_EXT;

			File newBatchFile=new File(strNewBatchFile ); 

			BufferedWriter bw=new BufferedWriter(new FileWriter(newBatchFile));
			bw.write(TalendConstants.STR_CD+parentFldr);
			bw.newLine();
			bw.write(TalendConstants.STR_SET_PWD);
			bw.newLine();
			bw.write(finalTalendJobCommand);
			bw.close();

			command = CommandLine.parse(newBatchFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return command;
	}

	public String getJavaBatchCommand(File originalBatchScript) {

		String line = null;
		try {
			BufferedReader br=new BufferedReader(new FileReader(originalBatchScript));
			while((line=br.readLine())!=null) {

				if(line.trim().startsWith(TalendConstants.STR_JAVA)) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
}
