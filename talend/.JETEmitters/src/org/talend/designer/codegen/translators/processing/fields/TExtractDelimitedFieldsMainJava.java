package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.BlockCode;
import java.util.List;
import java.util.ArrayList;

public class TExtractDelimitedFieldsMainJava
{
  protected static String nl;
  public static synchronized TExtractDelimitedFieldsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractDelimitedFieldsMainJava result = new TExtractDelimitedFieldsMainJava();
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
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = " = null;";
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = NL;
  protected final String TEXT_33 = " = new ";
  protected final String TEXT_34 = "Struct();";
  protected final String TEXT_35 = NL + "\tString field_";
  protected final String TEXT_36 = " = ";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ";" + NL + "\tString[] newFields_";
  protected final String TEXT_39 = " = new String[0];";
  protected final String TEXT_40 = NL + "\tif(field_";
  protected final String TEXT_41 = "!=null){// C_01" + NL + "\t\ttry{" + NL + "\t\t\tnewFields_";
  protected final String TEXT_42 = " = field_";
  protected final String TEXT_43 = ".split(";
  protected final String TEXT_44 = ",-1);";
  protected final String TEXT_45 = NL + "\ttry{" + NL + "\t\tif(field_";
  protected final String TEXT_46 = "!=null){// C_01" + NL + "\t\t\tnewFields_";
  protected final String TEXT_47 = " = field_";
  protected final String TEXT_48 = ".split(";
  protected final String TEXT_49 = ",-1);" + NL + "\t\t}";
  protected final String TEXT_50 = NL + "\t\tint length_";
  protected final String TEXT_51 = " = newFields_";
  protected final String TEXT_52 = ".length;";
  protected final String TEXT_53 = NL + "\t\tfor(int i_";
  protected final String TEXT_54 = " = 0;i_";
  protected final String TEXT_55 = " < length_";
  protected final String TEXT_56 = ";i_";
  protected final String TEXT_57 = "++){" + NL + "\t\t\tnewFields_";
  protected final String TEXT_58 = "[i_";
  protected final String TEXT_59 = "] = newFields_";
  protected final String TEXT_60 = "[i_";
  protected final String TEXT_61 = "].trim();" + NL + "\t\t}";
  protected final String TEXT_62 = NL + "\t\toptimizedCodeUtil_";
  protected final String TEXT_63 = ".putOirginalValue_";
  protected final String TEXT_64 = "(";
  protected final String TEXT_65 = ",";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "\t\t";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = " = ";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = " ;";
  protected final String TEXT_72 = NL + "\tString temp_";
  protected final String TEXT_73 = " = null;";
  protected final String TEXT_74 = NL + "\t\toptimizedCodeUtil_";
  protected final String TEXT_75 = ".putExtractValue_";
  protected final String TEXT_76 = "(";
  protected final String TEXT_77 = ",";
  protected final String TEXT_78 = ",length_";
  protected final String TEXT_79 = ",newFields_";
  protected final String TEXT_80 = ",temp_";
  protected final String TEXT_81 = " );";
  protected final String TEXT_82 = NL + "\t";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = ">=length_";
  protected final String TEXT_86 = "?\"\":newFields_";
  protected final String TEXT_87 = "[";
  protected final String TEXT_88 = "];";
  protected final String TEXT_89 = NL + "\ttemp_";
  protected final String TEXT_90 = " = ";
  protected final String TEXT_91 = ">=length_";
  protected final String TEXT_92 = "?\"\":newFields_";
  protected final String TEXT_93 = "[";
  protected final String TEXT_94 = "];" + NL + "\tif(temp_";
  protected final String TEXT_95 = ".length() > 0) {";
  protected final String TEXT_96 = NL + "\t\t";
  protected final String TEXT_97 = ".";
  protected final String TEXT_98 = " = temp_";
  protected final String TEXT_99 = ".getBytes();";
  protected final String TEXT_100 = NL + "\t\t";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_103 = ", ";
  protected final String TEXT_104 = ", false);";
  protected final String TEXT_105 = NL + "\t\t";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_108 = ", ";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + "\t\t";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = " = ParserUtils.parseTo_";
  protected final String TEXT_113 = "(ParserUtils.parseTo_Number(temp_";
  protected final String TEXT_114 = ", ";
  protected final String TEXT_115 = ", ";
  protected final String TEXT_116 = "));";
  protected final String TEXT_117 = NL + "\t\t";
  protected final String TEXT_118 = ".";
  protected final String TEXT_119 = " = ParserUtils.parseTo_";
  protected final String TEXT_120 = "(temp_";
  protected final String TEXT_121 = ");";
  protected final String TEXT_122 = NL + "\t} else {\t\t\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_124 = "' in '";
  protected final String TEXT_125 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_126 = NL + "\t\t";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = " = ";
  protected final String TEXT_129 = ";";
  protected final String TEXT_130 = NL + "\t}";
  protected final String TEXT_131 = NL + "\t int filedsum_";
  protected final String TEXT_132 = " = newFields_";
  protected final String TEXT_133 = ".length;" + NL + "\t if(filedsum_";
  protected final String TEXT_134 = " < ";
  protected final String TEXT_135 = "){" + NL + "\t \tthrow new RuntimeException(\"Column(s) missing\");" + NL + "\t } else if(filedsum_";
  protected final String TEXT_136 = " > ";
  protected final String TEXT_137 = ") {" + NL + "\t \tthrow new RuntimeException(\"Too many columns\");" + NL + "\t }     ";
  protected final String TEXT_138 = NL + "\t";
  protected final String TEXT_139 = " = null;";
  protected final String TEXT_140 = NL + "\tnb_line_";
  protected final String TEXT_141 = "++;";
  protected final String TEXT_142 = NL + "}catch(java.lang.Exception ex_";
  protected final String TEXT_143 = "){";
  protected final String TEXT_144 = NL + "\tthrow(ex_";
  protected final String TEXT_145 = ");";
  protected final String TEXT_146 = NL + "\t";
  protected final String TEXT_147 = " = new ";
  protected final String TEXT_148 = "Struct();";
  protected final String TEXT_149 = NL + "\toptimizedCodeUtil_";
  protected final String TEXT_150 = ".putRejectValue_";
  protected final String TEXT_151 = "(";
  protected final String TEXT_152 = ",";
  protected final String TEXT_153 = ");";
  protected final String TEXT_154 = NL + "    ";
  protected final String TEXT_155 = ".";
  protected final String TEXT_156 = " = ";
  protected final String TEXT_157 = ".";
  protected final String TEXT_158 = ";";
  protected final String TEXT_159 = "    ";
  protected final String TEXT_160 = NL + "    ";
  protected final String TEXT_161 = ".errorMessage = ex_";
  protected final String TEXT_162 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_163 = ";";
  protected final String TEXT_164 = NL + "    ";
  protected final String TEXT_165 = " = null;";
  protected final String TEXT_166 = NL + "\tlog.error(\"";
  protected final String TEXT_167 = " - \" + ex_";
  protected final String TEXT_168 = ".getMessage());";
  protected final String TEXT_169 = NL + "    System.err.println(ex_";
  protected final String TEXT_170 = ".getMessage());";
  protected final String TEXT_171 = NL + "    ";
  protected final String TEXT_172 = " = null;";
  protected final String TEXT_173 = NL + "\t";
  protected final String TEXT_174 = ".errorMessage = ex_";
  protected final String TEXT_175 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_176 = ";";
  protected final String TEXT_177 = NL + "}";
  protected final String TEXT_178 = NL + NL;
  protected final String TEXT_179 = NL;

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

String field = ElementParameterParser.getValue(node, "__FIELD__");
boolean ignoreSourceNull="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__IGNORE_SOURCE_NULL__"));
String separator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

boolean trim = ("true").equals(ElementParameterParser.getValue(node, "__TRIM__"));

String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;

String checkNumStr = ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__");
boolean checkNum = (checkNumStr!=null&&!("").equals(checkNumStr))?("true").equals(checkNumStr):false; 

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;

boolean isLog4jEnabled = "true".equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

IConnection inConn = null;
List< ? extends IConnection> inConns = node.getIncomingConnections();
if(inConns!=null){
    for (IConnection conn : inConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		inConn = conn;
    		break;
    	}
    }
}

String rejectConnName = "";
List<IMetadataColumn> rejectColumnList = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
    IConnection rejectConn = rejectConns.get(0);
    rejectColumnList = rejectConn.getMetadataTable().getListColumns();
    rejectConnName = rejectConn.getName();
}

String firstConnName = "";
IConnection outConn = null;
List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
if(outConns!=null){
    for (IConnection conn : outConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		outConn = conn;
    		firstConnName = outConn.getName();
    		break;
    	}
    }
}

if(outConns!=null){
    for (IConnection conn : outConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_30);
    
    	}
    }
}

//get field column
if(outConn!=null && inConn!=null){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_34);
    
	IMetadataTable inputMetadataTable = inConn.getMetadataTable();
	for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
		if(inputCol.getLabel().equals(field)){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(field);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
	if(ignoreSourceNull){

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_44);
    
		List<BlockCode> blockCodes = new java.util.ArrayList<BlockCode>(1);
		blockCodes.add(new BlockCode("C_01"));
		((org.talend.core.model.process.AbstractNode) node).setBlocksCodeToClose(blockCodes);
	}else{

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_49);
    
	}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
			if(trim){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
			}
			break;
		}
	}


//set original columns
List<IMetadataColumn> newColumnList = new ArrayList<IMetadataColumn>();
List<IMetadataColumn> oirginalColumnsList = new ArrayList<IMetadataColumn>();
IMetadataTable outputMetadataTable = outConn.getMetadataTable();
int sizeColumns=outputMetadataTable.getListColumns().size();

	for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
		boolean isOirginalColumn = false;
		for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
			if( outputCol.getLabel().equals( inputCol.getLabel()) ){
				isOirginalColumn = true;
				oirginalColumnsList.add(outputCol);
				break;
			}
		}
		if(!isOirginalColumn){
			if(!("").equals(rejectConnName)&&rejectConnName.equals(firstConnName)
				&& (outputCol.getLabel().equals("errorMessage") || outputCol.getLabel().equals("errorCode"))){
			}else{
				newColumnList.add(outputCol);
			}
		}
	}
	for(int i=0; i<oirginalColumnsList.size();i++){
		IMetadataColumn column = oirginalColumnsList.get(i);
		if(sizeColumns> schemaOptNum){//D1
			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_66);
    
			}
		}else{

    stringBuffer.append(TEXT_67);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_71);
    
		}//D1
	}

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
	for(int i=0; i<newColumnList.size();i++){
		IMetadataColumn column = newColumnList.get(i);
		String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    
		if(sizeColumns> schemaOptNum){//D2
			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
			}
		}else{
		  if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_82);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_88);
    
		  }else{ 

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    
			if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_96);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    
			}else if(javaType == JavaTypesManager.DATE) {
				if(checkNum || checkDate){

    stringBuffer.append(TEXT_100);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_104);
    
				}else{

    stringBuffer.append(TEXT_105);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_109);
    
				}
			}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_110);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_115);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_116);
    
			} else {

    stringBuffer.append(TEXT_117);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    
			}

    stringBuffer.append(TEXT_122);
    
			String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
			if(defaultValue == null) {

    stringBuffer.append(TEXT_123);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_125);
    
			} else {

    stringBuffer.append(TEXT_126);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_129);
    
			}

    stringBuffer.append(TEXT_130);
    
		 }
		}
	}
	
	if(checkNum) {

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(newColumnList.size() );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(newColumnList.size() );
    stringBuffer.append(TEXT_137);
    
	}
	
	if(!("").equals(rejectConnName) && rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_138);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_139);
    
	}

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
	log4jFileUtil.logCurrentRowNumberInfo();

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    
	if(dieOnError){

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    
	}else{
		if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_146);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_148);
    
			for(int i=0; i<sizeColumns;i++){
				IMetadataColumn column = outputMetadataTable.getListColumns().get(i);
				if(sizeColumns> schemaOptNum){//D1
					if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_153);
    
					}
				}else{

    stringBuffer.append(TEXT_154);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_158);
    
				}
			}

    stringBuffer.append(TEXT_159);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_165);
    
		} else if(("").equals(rejectConnName)){
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    
			}

    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_172);
    
		} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_173);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_176);
    
		}
	}

    stringBuffer.append(TEXT_177);
    
}

    stringBuffer.append(TEXT_178);
    stringBuffer.append(TEXT_179);
    return stringBuffer.toString();
  }
}
