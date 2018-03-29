package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TGSListBeginJava
{
  protected static String nl;
  public static synchronized TGSListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSListBeginJava result = new TGSListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_4 = " = null;" + NL + "\ttry {" + NL + "\t";
  protected final String TEXT_5 = NL + "\t\tservice_";
  protected final String TEXT_6 = " = (org.jets3t.service.impl.rest.httpclient.GoogleStorageService)globalMap.get(\"service_";
  protected final String TEXT_7 = "\");" + NL + "\t\t";
  protected final String TEXT_8 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Get an free connection from \" + \"";
  protected final String TEXT_10 = "\" + \".\");" + NL + "\t\t";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + NL + "\t   ";
  protected final String TEXT_13 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "; ";
  protected final String TEXT_19 = NL + NL + "\t\torg.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_20 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_21 = ",decryptedPassword_";
  protected final String TEXT_22 = ");" + NL + "\t" + NL + "\t\tservice_";
  protected final String TEXT_23 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_24 = ",jobName+\"/\"+jobVersion+\" (GPN:Talend)\",null);" + NL + "\t\tservice_";
  protected final String TEXT_25 = ".getAccountOwner();" + NL + "\t";
  protected final String TEXT_26 = NL + "\t\t\torg.jets3t.service.model.GSBucket[] buckets_";
  protected final String TEXT_27 = "=service_";
  protected final String TEXT_28 = ".listAllBuckets(";
  protected final String TEXT_29 = ");" + NL + "\t\t";
  protected final String TEXT_30 = NL + "\t\t\torg.jets3t.service.model.GSBucket[] buckets_";
  protected final String TEXT_31 = "=service_";
  protected final String TEXT_32 = ".listAllBuckets();" + NL + "\t\t";
  protected final String TEXT_33 = NL + "\t\tfor (org.jets3t.service.model.GSBucket bucket_";
  protected final String TEXT_34 = " : buckets_";
  protected final String TEXT_35 = ") {" + NL + "\t\t\tString currentBucketName_";
  protected final String TEXT_36 = " = bucket_";
  protected final String TEXT_37 = ".getName();" + NL + "\t\t\torg.jets3t.service.model.GSObject[] objects_";
  protected final String TEXT_38 = " = service_";
  protected final String TEXT_39 = ".listObjects(currentBucketName_";
  protected final String TEXT_40 = "," + NL + "\t\t\t";
  protected final String TEXT_41 = " null ";
  protected final String TEXT_42 = "," + NL + "\t\t\t";
  protected final String TEXT_43 = " null ";
  protected final String TEXT_44 = NL + "\t\t\t);" + NL + "\t";
  protected final String TEXT_45 = NL + "\t\tjava.util.List<java.util.Map<String,String>> list_";
  protected final String TEXT_46 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "\t\t";
  protected final String TEXT_47 = NL + "\t\t\tjava.util.Map<String,String> map_";
  protected final String TEXT_48 = "_";
  protected final String TEXT_49 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\tmap_";
  protected final String TEXT_50 = "_";
  protected final String TEXT_51 = ".put(\"BUCKET_NAME\",";
  protected final String TEXT_52 = ");" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\tmap_";
  protected final String TEXT_54 = "_";
  protected final String TEXT_55 = ".put(\"OBJECT_PREFIX\",";
  protected final String TEXT_56 = ");" + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\tmap_";
  protected final String TEXT_58 = "_";
  protected final String TEXT_59 = ".put(\"OBJECT_DELIMITER\",";
  protected final String TEXT_60 = ");" + NL + "\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\tlist_";
  protected final String TEXT_62 = ".add(map_";
  protected final String TEXT_63 = "_";
  protected final String TEXT_64 = ");" + NL + "\t\t";
  protected final String TEXT_65 = NL + "\t\tfor (java.util.Map<String, String> map_";
  protected final String TEXT_66 = ": list_";
  protected final String TEXT_67 = ") {" + NL + "\t\t\tString currentBucketName_";
  protected final String TEXT_68 = "=map_";
  protected final String TEXT_69 = ".get(\"BUCKET_NAME\");" + NL + "\t\t\torg.jets3t.service.model.GSObject[] objects_";
  protected final String TEXT_70 = " =new org.jets3t.service.model.GSObject[0];" + NL + "\t\t\ttry {" + NL + "\t\t\t\tobjects_";
  protected final String TEXT_71 = " = service_";
  protected final String TEXT_72 = ".listObjects(currentBucketName_";
  protected final String TEXT_73 = ",map_";
  protected final String TEXT_74 = ".get(\"OBJECT_PREFIX\"),map_";
  protected final String TEXT_75 = ".get(\"OBJECT_DELIMITER\"));" + NL + "\t\t\t}catch(org.jets3t.service.ServiceException e_";
  protected final String TEXT_76 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\tthrow(e_";
  protected final String TEXT_78 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_80 = " - Exception in component ";
  protected final String TEXT_81 = ":\" + e_";
  protected final String TEXT_82 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_84 = ":\");" + NL + "\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_85 = ".getMessage());" + NL + "\t\t\t\t\tif(e_";
  protected final String TEXT_86 = ".getErrorCode()!=null){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_88 = " - \" + e_";
  protected final String TEXT_89 = ".getErrorCode());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_91 = ".getErrorCode());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(e_";
  protected final String TEXT_92 = ".getErrorMessage()!=null){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_94 = " - \" + e_";
  protected final String TEXT_95 = ".getErrorMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_97 = ".getErrorMessage());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t}" + NL + "\t";
  protected final String TEXT_99 = NL + "\t\tfor (org.jets3t.service.model.GSObject objectSummary_";
  protected final String TEXT_100 = " : objects_";
  protected final String TEXT_101 = ") {" + NL + "\t\t\tnb_line_";
  protected final String TEXT_102 = "++;" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_103 = "_CURRENT_BUCKET\", currentBucketName_";
  protected final String TEXT_104 = ");" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_105 = "_CURRENT_KEY\", objectSummary_";
  protected final String TEXT_106 = ".getKey());" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	boolean isSpecifyprojectID=("true").equals(ElementParameterParser.getValue(node,"__SPECIFY_PROJECT__"));
	String projectID=ElementParameterParser.getValue(node,"__PROJECT_ID__");
	String delimiter=ElementParameterParser.getValue(node,"__DELIMITER__");
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_7);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_10);
    
		}
	}else{
	
    stringBuffer.append(TEXT_11);
    
       String passwordFieldName = "__SECRET_KEY__";
       
    stringBuffer.append(TEXT_12);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    } else {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    		
	}
	List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");
	boolean listInBucketList = "true".equals(ElementParameterParser.getValue(node,"__LIST_IN_BUCKET_LIST__"));
	if(!listInBucketList){
		String objects_prefix=ElementParameterParser.getValue(node,"__OBJECTS_PREFIX__");
		if(isSpecifyprojectID){
		
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(projectID);
    stringBuffer.append(TEXT_29);
    
		}else{
		
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
		}
		
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    if(objects_prefix!=null && objects_prefix.trim().length()>0){
    stringBuffer.append(objects_prefix);
     }else{
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    if(delimiter!=null && delimiter.trim().length()>0){
    stringBuffer.append(delimiter);
     }else{
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    
	} else if(buckets.size()>0){
	
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
		for(int i=0;i<buckets.size();i++){
			Map<String, String> map=buckets.get(i);
			String bucket_name =map.get("BUCKET_NAME");
			String object_prefix =map.get("OBJECT_PREFIX");
			String object_delimiter =map.get("OBJECT_DELIMITER");
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(bucket_name);
    stringBuffer.append(TEXT_52);
    
			if(object_prefix!=null && object_prefix.trim().length()>0){
			
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(object_prefix);
    stringBuffer.append(TEXT_56);
    
			}
			if(object_delimiter!=null && object_delimiter.trim().length()>0){
			
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(object_delimiter);
    stringBuffer.append(TEXT_60);
    
			}
			
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_64);
    
		}
		
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
				if (("true").equals(dieOnError)) {
				
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
				} else {
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
					}
					
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
						}
						
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
						}
						
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
				}
				
    stringBuffer.append(TEXT_98);
    
	}
	if(!listInBucketList || buckets.size()>0){
	
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
	}
	
    return stringBuffer.toString();
  }
}
