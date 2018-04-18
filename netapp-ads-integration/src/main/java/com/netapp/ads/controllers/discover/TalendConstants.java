package com.netapp.ads.controllers.discover;

public class TalendConstants {
	
	public static final String  JOB_NAME_USER_ROLES =  "ADS_Setup_1_UserRoles";
	public static final String  JOB_NAME_USER_NATIVES =  "ADS_Setup_2_UserNatives";
	public static final String  JOB_NAME_AUDIT_EVENTS =  "ADS_Setup_3_AuditEvents";
	public static final String  JOB_NAME_AUDIT_REASON_CODES =  "ADS_Setup_4_AuditReasonCodes";
	public static final String  JOB_NAME_APPLICATIONS =  "ADS_Setup_5_Applications";
	public static final String  JOB_NAME_SYSCONFIG_PROPERTY_TYPES =  "ADS_Setup_6_SysConfigPropertyTypes";
	public static final String  JOB_NAME_MIGRATION_TIMES =  "ADS_Setup_7_MigrationTimes";
	public static final String  JOB_NAME_MST_EMAIL_TYPES =  "ADS_Setup_8_MstEmailType";
	public static final String  JOB_NAME_SCHEDULES =  "ADS_Setup_9_Schedules";
	public static final String  JOB_NAME_HOSTS =  "OCI_Load_1_Hosts";
	public static final String  JOB_NAME_STORAGE =  "OCI_Load_2_Storage";
	public static final String  JOB_NAME_DATACENTERS =  "OCI_Load_3_DataCenters";
	public static final String  JOB_NAME_CONTROLLERS =  "OCI_Load_4_Controllers";
	public static final String  JOB_NAME_AGGREGATES =  "OCI_Load_5_Aggregates";
	public static final String  JOB_NAME_NAS_VOLUMES =  "OCI_Load_6_NasVolumes";
	public static final String  JOB_NAME_QTREES =  "OCI_Load_7_QTrees";
	public static final String  JOB_NAME_SHARES =  "OCI_Load_8_Shares";
	
	public static final String  JOB_NAME_GENERATE_ACTIVITY =  "Generate Activity";
	public static final String  JOB_NAME_GENERATE_APPLICATIONS =  "Generate Applications";
	public static final String  JOB_NAME_GENERATE_MIGRATION_KEYS =  "Generate Migration Keys";
	public static final String  SYSTEM =  "SYSTEM";

	public static String  FLDR_SEPERATOR="\\";
	
	public static final String JOB_TYPE_ADS_SETUP="ADS_Setup";
	public static final String JOB_TYPE_OCI_LOAD="OCI_Load";
	
	public static final String LOAD_FILES_LOC="LOAD_FILES_LOC";
	public static final String JOB_SUBMITTED_BY="JOB_SUBMITTED_BY";
	public static final String JOB_RUN_NAME="JOB_NAME";
	
	
	public static final String ADS_SETUP_LOADSHEET_USER_ROLES_XLSX = "ADS_SETUP_LOADSHEET_USER_ROLES_XLSX";
	public static final String ADS_SETUP_LOADSHEET_USER_NATIVES_XLSX = "ADS_SETUP_LOADSHEET_USER_NATIVES_XLSX";
	public static final String ADS_SETUP_LOADSHEET_APPLICATION_XLSX = "ADS_SETUP_LOADSHEET_APPLICATION_XLSX";
	public static final String ADS_SETUP_LOADSHEET_AUDIT_EVENT_XLSX = "ADS_SETUP_LOADSHEET_AUDIT_EVENT_XLSX";
	public static final String ADS_SETUP_LOADSHEET_AUDIT_REASON_CODE_XLSX = "ADS_SETUP_LOADSHEET_AUDIT_REASON_CODE_XLSX";
	public static final String ADS_SETUP_LOADSHEET_SYS_CONFIG_PROPERTY_TYPE_XLSX = "ADS_SETUP_LOADSHEET_SYS_CONFIG_PROPERTY_TYPE_XLSX";
	public static final String ADS_SETUP_LOADSHEET_MST_EMAIL_TYPE_XLSX = "ADS_SETUP_LOADSHEET_MST_EMAIL_TYPE_XLSX";
	public static final String ADS_SETUP_LOADSHEET_SCHEDULE_XLSX = "ADS_SETUP_LOADSHEET_SCHEDULE_XLSX";
	public static final String ADS_SETUP_LOADSHEET_MIGRATION_TIME_XLSX = "ADS_SETUP_LOADSHEET_MIGRATION_TIME_XLSX";
 
	
	public static final String JOB_VERSION_NO="0.1";
	public static final String UNDERSCORE="_";
	public static final String TEMP_ATTR_NAME="java.io.tmpdir";
	public static final String CONTEXT_PARAM="--context_param ";
	public static final String ENV_CONTEXT_FILE_PARAM_NAME="ENV_CONTEXT_FILE";
	public static final String ENV_CONTEXT_FILE_NAME="ads_local_context.properties";
	
	public static final String STR_AUTH_TOKEN="OAUTH_BEARER_TOKEN";
	public static final String STR_AUTHORIZATION="authorization";
	// Capital B... not lower case for Bearer.
    public static final String STR_BEARER="Bearer";
	public static final String STR_OS_NAME="os.name";
	public static final String STR_OS_WINDOWS="win";
	public static final String STR_CD="cd ";
	public static final String STR_BAT_EXT=".bat";
	public static final String STR_SH_EXT=".sh";
	public static final String STR_SET_ROOT="ROOT_PATH=`pwd`";   
	public static final String STR_JAVA="java";
	
	// We MUST return a JSON string in our REST Controller!
	public static final String STR_JOB_SUBMITTED = "{\"message\":\"Running Job.\", \"jobName\":\"PLACEHOLDER\"}"; 

}
