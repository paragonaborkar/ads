package com.netapp.ads.converters;

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
	public final static String  BATCH_SCRIPTS_LOC="C:\\projects\\Spring Jobs\\ADS_DATA\\";
	public static String  FLDR_SEPERATOR="\\";
	
	public final static String JOB_TYPE_ADS_SETUP="ADS_Setup";
	public final static String JOB_TYPE_OCI_LOAD="OCI_Load";
	
	public final static String LOAD_FILES_LOC="LOAD_FILES_LOC";
	public final static String ADS_SETUP_LOADSHEET_USER_ROLES_XLSX="ADS_CONFIGS_LOADSHEET_USER_ROLES_XLSX";
	
	public final static String JOB_VERSION_NO="0.1";
	public final static String UNDERSCORE="_";
	public final static String TEMP_ATTR_NAME="java.io.tmpdir";
	public final static String CONTEXT_PARAM="--context_param ";
	
	public TalendConstants() {
		
	}
	
	public static void main(String[] args) {
		
		String operatingSystem = System.getProperty("os.name").toLowerCase();
		if(operatingSystem.indexOf("win") >= 0) {
			FLDR_SEPERATOR="\\";
		} else if(operatingSystem.indexOf("nix") >= 0 || operatingSystem.indexOf("nux") >= 0 || operatingSystem.indexOf("aix") > 0 ) {
			FLDR_SEPERATOR="/";
		}
	}
}
