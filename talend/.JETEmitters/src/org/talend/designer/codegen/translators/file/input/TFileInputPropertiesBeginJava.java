package org.talend.designer.codegen.translators.file.input;

import java.util.List;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileInputPropertiesBeginJava
{
  protected static String nl;
  public static synchronized TFileInputPropertiesBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputPropertiesBeginJava result = new TFileInputPropertiesBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\tjava.io.File file_";
  protected final String TEXT_30 = " = new java.io.File(";
  protected final String TEXT_31 = ");" + NL + "\tint nb_line_";
  protected final String TEXT_32 = " = 0;";
  protected final String TEXT_33 = NL + "\tjava.util.Properties properties_";
  protected final String TEXT_34 = " = new java.util.Properties();" + NL + "\tjava.io.FileInputStream fis_";
  protected final String TEXT_35 = "=new java.io.FileInputStream(file_";
  protected final String TEXT_36 = ");" + NL + "   \ttry{" + NL + "\t\tproperties_";
  protected final String TEXT_37 = ".load(fis_";
  protected final String TEXT_38 = ");" + NL + "\t\tjava.util.Enumeration enumeration_";
  protected final String TEXT_39 = " = properties_";
  protected final String TEXT_40 = ".propertyNames();" + NL + "\t\twhile (enumeration_";
  protected final String TEXT_41 = ".hasMoreElements()) {" + NL + "\t\t\tnb_line_";
  protected final String TEXT_42 = "++;";
  protected final String TEXT_43 = NL + "\t\t\t";
  protected final String TEXT_44 = ".key = (String)enumeration_";
  protected final String TEXT_45 = ".nextElement();" + NL + "\t\t\t";
  protected final String TEXT_46 = ".value = (String)properties_";
  protected final String TEXT_47 = ".getProperty(";
  protected final String TEXT_48 = ".key);";
  protected final String TEXT_49 = NL + "\t\t\tenumeration_";
  protected final String TEXT_50 = ".nextElement();";
  protected final String TEXT_51 = NL + "    org.ini4j.Wini ini_";
  protected final String TEXT_52 = " = new org.ini4j.Wini(new java.io.InputStreamReader(new java.io.FileInputStream(";
  protected final String TEXT_53 = "),";
  protected final String TEXT_54 = "));";
  protected final String TEXT_55 = NL + "\t\tfor(org.ini4j.Profile.Section section_";
  protected final String TEXT_56 = " : ini_";
  protected final String TEXT_57 = ".values()){" + NL + "\t    \tfor(String key_";
  protected final String TEXT_58 = " : section_";
  protected final String TEXT_59 = ".keySet()){" + NL + "\t    \t\tnb_line_";
  protected final String TEXT_60 = "++;";
  protected final String TEXT_61 = NL + "\t\t\t\t";
  protected final String TEXT_62 = ".key = key_";
  protected final String TEXT_63 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_64 = ".value = section_";
  protected final String TEXT_65 = ".get(key_";
  protected final String TEXT_66 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_67 = ".section = section_";
  protected final String TEXT_68 = ".getName();";
  protected final String TEXT_69 = NL + "\t\tfor(String names_";
  protected final String TEXT_70 = " : ini_";
  protected final String TEXT_71 = ".keySet()){" + NL + "\t\t\tnb_line_";
  protected final String TEXT_72 = "++;";
  protected final String TEXT_73 = NL + "\t\t    ";
  protected final String TEXT_74 = ".section = names_";
  protected final String TEXT_75 = ";";
  protected final String TEXT_76 = NL + "\t    org.ini4j.Profile.Section section_";
  protected final String TEXT_77 = " = ini_";
  protected final String TEXT_78 = ".get(";
  protected final String TEXT_79 = ");" + NL + "\t    if(section_";
  protected final String TEXT_80 = "!=null){" + NL + "\t    for(String key_";
  protected final String TEXT_81 = " : section_";
  protected final String TEXT_82 = ".keySet()){" + NL + "\t    \tnb_line_";
  protected final String TEXT_83 = "++;";
  protected final String TEXT_84 = NL + "\t\t\t";
  protected final String TEXT_85 = ".key = key_";
  protected final String TEXT_86 = ";" + NL + "\t\t\t";
  protected final String TEXT_87 = ".value = section_";
  protected final String TEXT_88 = ".get(key_";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String fileFormat = ElementParameterParser.getValue(node,"__FILE_FORMAT__");
String filename = ElementParameterParser.getValue(node,"__FILENAME__");
String outConnName = null;
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
List< ? extends IConnection> outConns = node.getOutgoingConnections();
boolean isGenerateCode=false;
for(IConnection conn : outConns){
	if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.USE_ITERATE)){
		isGenerateCode=true;
	}
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		outConnName = conn.getName();
		isGenerateCode=true;
	}
}
if(!isGenerateCode){
	return "";//output conn only onsubjob_ok
}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
log4jFileUtil.startRetriveDataInfo();

if(("PROPERTIES_FORMAT").equals(fileFormat)){

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
		log4jFileUtil.debugRetriveData(node);
		
		if(outConnName!=null){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_48);
    
		}else{

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
		}
}else if(("INI_FORMAT").equals(fileFormat)){
	String sectionName = ElementParameterParser.getValue(node,"__SECTION_NAME__");
	String retriveMode = ElementParameterParser.getValue(node,"__RETRIVE_MODE__");

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_54);
    
	if(("RETRIVE_ALL").equals(retriveMode)){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
		log4jFileUtil.debugRetriveData(node);
		
		if(outConnName!=null){

    stringBuffer.append(TEXT_61);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
		}
	}else if(("RETRIVE_SECTIONS").equals(retriveMode)){

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
		log4jFileUtil.debugRetriveData(node);
		
		if(outConnName!=null){

    stringBuffer.append(TEXT_73);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
		}
	}else if(("RETRIVE_BY_SECTION").equals(retriveMode)){

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(sectionName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
		log4jFileUtil.debugRetriveData(node);
		
		if(outConnName!=null){

    stringBuffer.append(TEXT_84);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
		}
	}
}

    stringBuffer.append(TEXT_90);
    return stringBuffer.toString();
  }
}
