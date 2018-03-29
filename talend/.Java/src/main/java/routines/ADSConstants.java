package routines;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class ADSConstants {

	public static String NODE_CONTROLLERS="controllers";
	public static String NODE_STORAGES="storages";
	public static String NODE_DATA_CENTERS="dataCenters";
	public static String NODE_AGGREGATES="aggregates";
	public static String NODE_HOSTS="hosts";
	public static String NODE_QTREES="qtrees";
	public static String NODE_NASVOLUMES="nasVolumes";
	public static String NODE_ROLES="userRoles";
	
	

	public static String LOGTYPE_PRE="PreJobLog";
	public static String LOGTYPE_POST="PostJobLog";
	
	public static String LOG_JOB_STATUS_NEW="New";
	public static String LOG_JOB_STATUS_INPROGRESS="InProgress";
	public static String LOG_JOB_STATUS_FINISHED="Finished";
	
}
