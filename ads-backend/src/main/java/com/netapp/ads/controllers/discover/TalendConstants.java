package com.netapp.ads.controllers.discover;

public class TalendConstants {
	
	public final static String  JOB_NAME_USER_ROLES =  "ADS_Setup_1_UserRoles";
	public final static String  JOB_NAME_USER_NATIVES =  "ADS_Setup_2_UserNatives";
	public final static String  JOB_NAME_AUDIT_EVENTS =  "ADS_Setup_3_AuditEvents";
	public final static String  JOB_NAME_AUDIT_REASON_CODES =  "ADS_Setup_4_AuditReasonCodes";
	public final static String  JOB_NAME_APPLICATIONS =  "ADS_Setup_5_Applications";
	public final static String  JOB_NAME_SYSCONFIG_PROPERTY_TYPES =  "ADS_Setup_6_SysConfigPropertyTypes";
	public final static String  JOB_NAME_MIGRATION_TIMES =  "ADS_Setup_7_MigrationTimes";
	public final static String  JOB_NAME_MST_EMAIL_TYPES =  "ADS_Setup_8_MstEmailType";
	public final static String  JOB_NAME_SCHEDULES =  "ADS_Setup_9_Schedules";
	public final static String  JOB_NAME_HOSTS =  "OCI_Load_1_Hosts";
	public final static String  JOB_NAME_STORAGE =  "OCI_Load_2_Storage";
	public final static String  JOB_NAME_DATACENTERS =  "OCI_Load_3_DataCenters";
	public final static String  JOB_NAME_CONTROLLERS =  "OCI_Load_4_Controllers";
	public final static String  JOB_NAME_AGGREGATES =  "OCI_Load_5_Aggregates";
	public final static String  JOB_NAME_NAS_VOLUMES =  "OCI_Load_6_NasVolumes";
	public final static String  JOB_NAME_QTREES =  "OCI_Load_7_QTrees";
	public final static String  JOB_NAME_SHARES =  "OCI_Load_8_Shares";

	public static String  FLDR_SEPERATOR="\\";
	
	public final static String JOB_TYPE_ADS_SETUP="ADS_Setup";
	public final static String JOB_TYPE_OCI_LOAD="OCI_Load";
	
	public final static String LOAD_FILES_LOC="LOAD_FILES_LOC";
	public final static String JOB_SUBMITTED_BY="JOB_SUBMITTED_BY";
	public final static String JOB_RUN_NAME="JOB_NAME";
	
	
	public final static String ADS_SETUP_LOADSHEET_USER_ROLES_XLSX = "ADS_SETUP_LOADSHEET_USER_ROLES_XLSX";
	public final static String ADS_SETUP_LOADSHEET_USER_NATIVES_XLSX = "ADS_SETUP_LOADSHEET_USER_NATIVES_XLSX";
	public final static String ADS_SETUP_LOADSHEET_APPLICATION_XLSX = "ADS_SETUP_LOADSHEET_APPLICATION_XLSX";
	public final static String ADS_SETUP_LOADSHEET_AUDIT_EVENT_XLSX = "ADS_SETUP_LOADSHEET_AUDIT_EVENT_XLSX";
	public final static String ADS_SETUP_LOADSHEET_AUDIT_REASON_CODE_XLSX = "ADS_SETUP_LOADSHEET_AUDIT_REASON_CODE_XLSX";
	public final static String ADS_SETUP_LOADSHEET_SYS_CONFIG_PROPERTY_TYPE_XLSX = "ADS_SETUP_LOADSHEET_SYS_CONFIG_PROPERTY_TYPE_XLSX";
	public final static String ADS_SETUP_LOADSHEET_MST_EMAIL_TYPE_XLSX = "ADS_SETUP_LOADSHEET_MST_EMAIL_TYPE_XLSX";
	public final static String ADS_SETUP_LOADSHEET_SCHEDULE_XLSX = "ADS_SETUP_LOADSHEET_SCHEDULE_XLSX";
	public final static String ADS_SETUP_LOADSHEET_MIGRATION_TIME_XLSX = "ADS_SETUP_LOADSHEET_MIGRATION_TIME_XLSX";
 
	
	public final static String JOB_VERSION_NO="0.1";
	public final static String UNDERSCORE="_";
	public final static String TEMP_ATTR_NAME="java.io.tmpdir";
	public final static String CONTEXT_PARAM="--context_param ";
	public final static String ENV_CONTEXT_FILE_PARAM_NAME="ENV_CONTEXT_FILE";
	public final static String ENV_CONTEXT_FILE_NAME="ads_local_context.properties";
	
	public final static String STR_AUTH_TOKEN="OAUTH_BEARER_TOKEN";
	public final static String STR_AUTHORIZATION="authorization";
	// Capital B... not lower case for Bearer.
    public final static String STR_BEARER="Bearer";
	public final static String STR_OS_NAME="os.name";
	public final static String STR_OS_WINDOWS="win";
	public final static String STR_CD="cd ";
	public final static String STR_BAT_EXT=".bat";
	public final static String STR_SH_EXT=".sh";
	public final static String STR_SET_PWD="ROOT_PATH=`pwd`";   
	public final static String STR_JAVA="java";
	
	// We MUST return a JSON string in our REST Controller!
	public final static String STR_JOB_SUBMITTED = "{\"message\":\"Running Job.\", \"jobName\":\"PLACEHOLDER\"}"; 

}
