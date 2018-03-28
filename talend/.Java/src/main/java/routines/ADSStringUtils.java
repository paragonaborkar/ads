package routines;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import jdk.nashorn.internal.runtime.Context;

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
public class ADSStringUtils {

 
    public static int getLastIndexOf(String strValue,String strToFind) {
    	
    	int lastIndex=strValue.lastIndexOf(strToFind);
    	return lastIndex;
    }
    
    public static String getIdFromRestURL(String restURL) {
    	
    	String strId=restURL.substring(restURL.lastIndexOf("/")+1);
    	return strId;
    }
    
    public static boolean getBooleanForString(String strValue) {
    	
    	boolean boolValue=strValue.equalsIgnoreCase("TRUE")?true:false;
    	
    	return boolValue;
    }
    
    public static String getRestURLForId(String baseURL,String nodeName,String id) {
    	
    	String restURL=baseURL+"/"+nodeName+"/"+id;
    	System.out.println(restURL);
    	return restURL;
    }

    
    public static List<String> convertStringToList(String line,String delimiter) {
    	
    	return Arrays.asList(line.split(delimiter));
    }
    
    public static String getEndPointURL(String baseURL,String endPointName) {
    	
    	String restURL=baseURL+"/"+endPointName;
    	System.out.println(restURL);
    	return restURL;
    }
    
    
    public static boolean isIdNull(String id) {
    	
    	if(id==null || id.equalsIgnoreCase("null")||id.trim().equalsIgnoreCase(""))
    		return true;
    	else 
    		return false;
    	
/*    	if(strLogType.equalsIgnoreCase(ADSConstants.LOGTYPE_PRE))
    		return true;
    	else
    		return false;
*/    }

    public static boolean isPostJobLog(String strLogType) {
    	
    	if(strLogType.equalsIgnoreCase(ADSConstants.LOGTYPE_POST))
    		return true;
    	else
    		return false;
    }

    public static String getCurrentTimeInRestFormat() {
    	
    	LocalDateTime date = LocalDateTime.now();
    	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    	
    	String str = date.format(fmt);
    	System.out.println(str);
    	return str;
    }
    
    public static String getJobInstanceName(String jobName, String jobRunName) {  	
    	String returnValue = "";
    	
    	if (jobRunName.trim().length() == 0)
    		returnValue= (jobName+"_"+System.currentTimeMillis());
    	else 
    		returnValue= (jobRunName);
    	
    	return returnValue;
    }
    
    public static String getJobInstanceName(String jobName) {  		
   		return (jobName+"_"+System.currentTimeMillis());
    
    }
}
