package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TGSGetBeginJava
{
  protected static String nl;
  public static synchronized TGSGetBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSGetBeginJava result = new TGSGetBeginJava();
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
  protected final String TEXT_47 = NL + "\t\t\t\tjava.util.Map<String,String> map_";
  protected final String TEXT_48 = "_";
  protected final String TEXT_49 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\t\tmap_";
  protected final String TEXT_50 = "_";
  protected final String TEXT_51 = ".put(\"BUCKET_NAME\",";
  protected final String TEXT_52 = ");" + NL + "\t\t\t\tmap_";
  protected final String TEXT_53 = "_";
  protected final String TEXT_54 = ".put(\"OBJECT_KEY\",";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\tmap_";
  protected final String TEXT_57 = "_";
  protected final String TEXT_58 = ".put(\"OBJECT_NEWNAME\",";
  protected final String TEXT_59 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\tmap_";
  protected final String TEXT_61 = "_";
  protected final String TEXT_62 = ".put(\"OBJECT_NEWNAME\",";
  protected final String TEXT_63 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\tlist_";
  protected final String TEXT_65 = ".add(map_";
  protected final String TEXT_66 = "_";
  protected final String TEXT_67 = ");" + NL + "\t\t";
  protected final String TEXT_68 = NL + "\t\tjava.util.List<java.util.Map<String,String>> list_";
  protected final String TEXT_69 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\t\tjava.util.Map<String,String> map_";
  protected final String TEXT_71 = "_";
  protected final String TEXT_72 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\tmap_";
  protected final String TEXT_73 = "_";
  protected final String TEXT_74 = ".put(\"BUCKET_NAME\",";
  protected final String TEXT_75 = ");" + NL + "\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\tmap_";
  protected final String TEXT_77 = "_";
  protected final String TEXT_78 = ".put(\"OBJECT_PREFIX\",";
  protected final String TEXT_79 = ");" + NL + "\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\tmap_";
  protected final String TEXT_81 = "_";
  protected final String TEXT_82 = ".put(\"OBJECT_DELIMITER\",";
  protected final String TEXT_83 = ");" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\tlist_";
  protected final String TEXT_85 = ".add(map_";
  protected final String TEXT_86 = "_";
  protected final String TEXT_87 = ");" + NL + "\t\t";
  protected final String TEXT_88 = NL + "\t\tfor (java.util.Map<String, String> map_";
  protected final String TEXT_89 = ": list_";
  protected final String TEXT_90 = ") {" + NL + "\t\t\tString currentBucketName_";
  protected final String TEXT_91 = "=map_";
  protected final String TEXT_92 = ".get(\"BUCKET_NAME\");" + NL + "\t\t\torg.jets3t.service.model.GSObject[] objects_";
  protected final String TEXT_93 = " =new org.jets3t.service.model.GSObject[0];" + NL + "\t\t\ttry {" + NL + "\t\t\t\tobjects_";
  protected final String TEXT_94 = " = service_";
  protected final String TEXT_95 = ".listObjects(currentBucketName_";
  protected final String TEXT_96 = ",map_";
  protected final String TEXT_97 = ".get(\"OBJECT_PREFIX\"),map_";
  protected final String TEXT_98 = ".get(\"OBJECT_DELIMITER\"));" + NL + "\t\t\t}catch(org.jets3t.service.ServiceException e_";
  protected final String TEXT_99 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\t\tthrow(e_";
  protected final String TEXT_101 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_103 = " - Exception in component ";
  protected final String TEXT_104 = ":\" + e_";
  protected final String TEXT_105 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_107 = ":\");" + NL + "\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_108 = ".getMessage());" + NL + "\t\t\t\t\tif(e_";
  protected final String TEXT_109 = ".getErrorCode()!=null){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_111 = " - \" + e_";
  protected final String TEXT_112 = ".getErrorCode());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_114 = ".getErrorCode());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(e_";
  protected final String TEXT_115 = ".getErrorMessage()!=null){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_117 = " - \" + e_";
  protected final String TEXT_118 = ".getErrorMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_120 = ".getErrorMessage());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\t}" + NL + "\t";
  protected final String TEXT_122 = NL + "\t\t\tfor (org.jets3t.service.model.GSObject objectSummary_";
  protected final String TEXT_123 = " : objects_";
  protected final String TEXT_124 = ") {" + NL + "\t\t\t\tString objkey_";
  protected final String TEXT_125 = " = objectSummary_";
  protected final String TEXT_126 = ".getKey();" + NL + "\t\t\t\tjava.io.File file_";
  protected final String TEXT_127 = " = new java.io.File(";
  protected final String TEXT_128 = "+objkey_";
  protected final String TEXT_129 = ");" + NL + "\t\t\t\torg.jets3t.service.model.GSObject obj_";
  protected final String TEXT_130 = " = service_";
  protected final String TEXT_131 = ".getObject(currentBucketName_";
  protected final String TEXT_132 = ", objkey_";
  protected final String TEXT_133 = ");" + NL + "\t\t";
  protected final String TEXT_134 = NL + "\t\t\tfor (java.util.Map<String, String> map_";
  protected final String TEXT_135 = ": list_";
  protected final String TEXT_136 = ") {" + NL + "\t\t\t\tString currentBucketName_";
  protected final String TEXT_137 = "=map_";
  protected final String TEXT_138 = ".get(\"BUCKET_NAME\");" + NL + "\t\t\t\tjava.io.File file_";
  protected final String TEXT_139 = " = new java.io.File(";
  protected final String TEXT_140 = "+map_";
  protected final String TEXT_141 = ".get(\"OBJECT_NEWNAME\"));" + NL + "\t\t\t\torg.jets3t.service.model.GSObject obj_";
  protected final String TEXT_142 = " =null;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tobj_";
  protected final String TEXT_143 = " = service_";
  protected final String TEXT_144 = ".getObject(currentBucketName_";
  protected final String TEXT_145 = ", map_";
  protected final String TEXT_146 = ".get(\"OBJECT_KEY\"));" + NL + "\t\t\t\t}catch(org.jets3t.service.ServiceException e_";
  protected final String TEXT_147 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_148 = NL + "\t\t\t\t\t\tthrow(e_";
  protected final String TEXT_149 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_151 = " - Exception in component ";
  protected final String TEXT_152 = ":\" + e_";
  protected final String TEXT_153 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_154 = NL + "\t\t\t\t\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_155 = ":\");" + NL + "\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_156 = ".getMessage());" + NL + "\t\t\t\t\t\tif(e_";
  protected final String TEXT_157 = ".getErrorCode()!=null){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_159 = " - \" + e_";
  protected final String TEXT_160 = ".getErrorCode());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_162 = ".getErrorCode());" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(e_";
  protected final String TEXT_163 = ".getErrorMessage()!=null){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_165 = " - \" + e_";
  protected final String TEXT_166 = ".getErrorMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_168 = ".getErrorMessage());" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t}" + NL + "\t\t";
  protected final String TEXT_170 = NL + "\t\tif(obj_";
  protected final String TEXT_171 = "!=null){" + NL + "\t\t\tnb_line_";
  protected final String TEXT_172 = "++;" + NL + "\t\t\tboolean isDirectory_";
  protected final String TEXT_173 = "=false;" + NL + "\t\t\tString fileName_";
  protected final String TEXT_174 = " =file_";
  protected final String TEXT_175 = " .getAbsolutePath();" + NL + "\t\t\tfileName_";
  protected final String TEXT_176 = " =fileName_";
  protected final String TEXT_177 = " .replace(\"\\\\\", \"/\");" + NL + "\t\t\tString createDir_";
  protected final String TEXT_178 = "=\"\";" + NL + "\t\t\tif(obj_";
  protected final String TEXT_179 = ".isDirectoryPlaceholder()){" + NL + "\t\t\t\tcreateDir_";
  protected final String TEXT_180 = " = fileName_";
  protected final String TEXT_181 = ";" + NL + "\t\t\t}else{" + NL + "\t\t\t\tcreateDir_";
  protected final String TEXT_182 = "=\tfileName_";
  protected final String TEXT_183 = ".substring(0,fileName_";
  protected final String TEXT_184 = ".indexOf(\"/\"));" + NL + "\t\t\t}" + NL + "\t\t\tif (!\"\".equals(createDir_";
  protected final String TEXT_185 = ")) {" + NL + "\t\t\t\tjava.io.File parentDir_";
  protected final String TEXT_186 = "=new java.io.File(createDir_";
  protected final String TEXT_187 = ");" + NL + "\t\t\t\tif(!parentDir_";
  protected final String TEXT_188 = ".exists()){" + NL + "\t\t\t\t\tparentDir_";
  protected final String TEXT_189 = ".mkdirs();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tif(!obj_";
  protected final String TEXT_190 = ".isDirectoryPlaceholder()){" + NL + "\t\t\t\tjava.io.File parentDir_";
  protected final String TEXT_191 = "=new java.io.File(file_";
  protected final String TEXT_192 = ".getParent());" + NL + "\t\t\t\tif(!parentDir_";
  protected final String TEXT_193 = ".exists()){" + NL + "\t\t\t\t\tparentDir_";
  protected final String TEXT_194 = ".mkdirs();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tjava.io.InputStream input_";
  protected final String TEXT_195 = " = obj_";
  protected final String TEXT_196 = ".getDataInputStream();" + NL + "\t\t\t\tbyte bytes_";
  protected final String TEXT_197 = "[] = new byte[4 * 1024];" + NL + "\t\t\t\tint len_";
  protected final String TEXT_198 = " = -1;" + NL + "\t\t\t\tjava.io.FileOutputStream out_";
  protected final String TEXT_199 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_200 = ");" + NL + "\t" + NL + "\t\t\t\twhile ((len_";
  protected final String TEXT_201 = " = input_";
  protected final String TEXT_202 = ".read(bytes_";
  protected final String TEXT_203 = ")) != -1) {" + NL + "\t\t\t\t\tout_";
  protected final String TEXT_204 = ".write(bytes_";
  protected final String TEXT_205 = ", 0, len_";
  protected final String TEXT_206 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tout_";
  protected final String TEXT_207 = ".flush();" + NL + "\t\t\t\tinput_";
  protected final String TEXT_208 = ".close(); " + NL + "\t\t\t\tout_";
  protected final String TEXT_209 = ".close(); " + NL + "\t\t\t}" + NL + "\t\t\tobj_";
  protected final String TEXT_210 = ".closeDataInputStream();";

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
	List<Map<String, String>> keys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__KEYS__");
	String objects_prefix=ElementParameterParser.getValue(node,"__OBJECTS_PREFIX__");
	String delimiter=ElementParameterParser.getValue(node,"__DELIMITER__");
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String outputsDir = ElementParameterParser.getValue(node, "__DIRECTORY__");
	List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");
	
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
	boolean getList = "true".equals(ElementParameterParser.getValue(node,"__GETLIST__"));
	boolean useKeysList = "true".equals(ElementParameterParser.getValue(node,"__USE_KEYS_LIST__"));
	if(!getList && !useKeysList){
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
    
	}else if(useKeysList && keys.size()>0){
	
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
		for(int i=0;i<keys.size();i++){
			Map<String, String> objKey=keys.get(i);
			String bucket_name =objKey.get("BUCKET_NAME");
			String key =objKey.get("KEY");
			String newName =objKey.get("NEW_NAME");
			if(key!=null && key.trim().length()>0){
			
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_55);
    
				if(newName!=null && !"".equals(newName.trim()) && !"\"\"".equals(newName.trim())){
				
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(newName);
    stringBuffer.append(TEXT_59);
    
				}else{
				
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_63);
    
				}
			}
			
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_67);
    
		}
	} else if(getList && buckets.size()>0){
	
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
		for(int i=0;i<buckets.size();i++){
			Map<String, String> map=buckets.get(i);
			String bucket_name =map.get("BUCKET_NAME");
			String object_prefix =map.get("OBJECT_PREFIX");
			String object_delimiter =map.get("OBJECT_DELIMITER");
			
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(bucket_name);
    stringBuffer.append(TEXT_75);
    
			if(object_prefix!=null && object_prefix.trim().length()>0){
			
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(object_prefix);
    stringBuffer.append(TEXT_79);
    
			}
			if(object_delimiter!=null && object_delimiter.trim().length()>0){
			
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(object_delimiter);
    stringBuffer.append(TEXT_83);
    
			}
			
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_87);
    
		}
		
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
				if (("true").equals(dieOnError)) {
				
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
				} else {
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
					}
					
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
						}
						
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
						}
						
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
				}
				
    stringBuffer.append(TEXT_121);
    
	}
	if((!getList && !useKeysList) || (useKeysList && keys.size()>0) || (getList && buckets.size()>0)){
		if(!useKeysList){
		
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(outputsDir);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
		}else{
		
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(outputsDir);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    
					if (("true").equals(dieOnError)) {
					
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
					} else {
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
						}
						
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
							if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
							}
							
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
							if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
							}
							
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
					}
					
    stringBuffer.append(TEXT_169);
    
		}
		
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    
	}

    return stringBuffer.toString();
  }
}
