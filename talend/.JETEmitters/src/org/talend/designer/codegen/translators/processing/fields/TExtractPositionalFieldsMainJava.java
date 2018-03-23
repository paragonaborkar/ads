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
import java.util.Map;

public class TExtractPositionalFieldsMainJava
{
  protected static String nl;
  public static synchronized TExtractPositionalFieldsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractPositionalFieldsMainJava result = new TExtractPositionalFieldsMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = " = null;";
  protected final String TEXT_33 = NL + "\t//String field_";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ";" + NL + "\tString field_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ";";
  protected final String TEXT_40 = NL + "\tif(field_";
  protected final String TEXT_41 = "==null){" + NL + "\t\tfield_";
  protected final String TEXT_42 = "=\"\";" + NL + "\t}";
  protected final String TEXT_43 = NL + "\tif(field_";
  protected final String TEXT_44 = "!=null){// C_01";
  protected final String TEXT_45 = NL + "try{" + NL + "\t";
  protected final String TEXT_46 = " = new ";
  protected final String TEXT_47 = "Struct();";
  protected final String TEXT_48 = NL + "\t\t\t\t";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = ";";
  protected final String TEXT_53 = NL + "\tjava.util.Map<String,String> newFields_";
  protected final String TEXT_54 = " = new java.util.HashMap<String,String>();";
  protected final String TEXT_55 = NL + "\tnewFields_";
  protected final String TEXT_56 = ".put(\"";
  protected final String TEXT_57 = "\", TalendString.talendTrim(field_";
  protected final String TEXT_58 = ".substring(0," + NL + "\t\tindexs_";
  protected final String TEXT_59 = "[";
  protected final String TEXT_60 = "]>field_";
  protected final String TEXT_61 = ".length()||indexs_";
  protected final String TEXT_62 = "[";
  protected final String TEXT_63 = "]<0?field_";
  protected final String TEXT_64 = ".length():indexs_";
  protected final String TEXT_65 = "[";
  protected final String TEXT_66 = "])";
  protected final String TEXT_67 = "," + NL + "     \t\t\t";
  protected final String TEXT_68 = ", ";
  protected final String TEXT_69 = "));";
  protected final String TEXT_70 = NL + "\tif(";
  protected final String TEXT_71 = "<indexs_";
  protected final String TEXT_72 = ".length && indexs_";
  protected final String TEXT_73 = "[";
  protected final String TEXT_74 = "]>=0 && indexs_";
  protected final String TEXT_75 = "[";
  protected final String TEXT_76 = "]<= field_";
  protected final String TEXT_77 = ".length()){" + NL + "    \tnewFields_";
  protected final String TEXT_78 = ".put(\"";
  protected final String TEXT_79 = "\"," + NL + "     \t\tTalendString.talendTrim(field_";
  protected final String TEXT_80 = ".substring(indexs_";
  protected final String TEXT_81 = "[";
  protected final String TEXT_82 = "]," + NL + "     \t\t\tindexs_";
  protected final String TEXT_83 = "[";
  protected final String TEXT_84 = "]>field_";
  protected final String TEXT_85 = ".length()||indexs_";
  protected final String TEXT_86 = "[";
  protected final String TEXT_87 = "]<0?field_";
  protected final String TEXT_88 = ".length():indexs_";
  protected final String TEXT_89 = "[";
  protected final String TEXT_90 = "])";
  protected final String TEXT_91 = "," + NL + "     \t\t\t";
  protected final String TEXT_92 = ", ";
  protected final String TEXT_93 = "));" + NL + " \t}";
  protected final String TEXT_94 = NL + "\tnewFields_";
  protected final String TEXT_95 = ".put(\"";
  protected final String TEXT_96 = "\", field_";
  protected final String TEXT_97 = ".substring(0," + NL + "\t\tindexs_";
  protected final String TEXT_98 = "[";
  protected final String TEXT_99 = "]>field_";
  protected final String TEXT_100 = ".length()||indexs_";
  protected final String TEXT_101 = "[";
  protected final String TEXT_102 = "]<0?field_";
  protected final String TEXT_103 = ".length():indexs_";
  protected final String TEXT_104 = "[";
  protected final String TEXT_105 = "])";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = NL + "\tif(";
  protected final String TEXT_108 = "<indexs_";
  protected final String TEXT_109 = ".length && indexs_";
  protected final String TEXT_110 = "[";
  protected final String TEXT_111 = "]>=0 && indexs_";
  protected final String TEXT_112 = "[";
  protected final String TEXT_113 = "]<= field_";
  protected final String TEXT_114 = ".length()){" + NL + "    \tnewFields_";
  protected final String TEXT_115 = ".put(\"";
  protected final String TEXT_116 = "\",field_";
  protected final String TEXT_117 = ".substring(indexs_";
  protected final String TEXT_118 = "[";
  protected final String TEXT_119 = "]," + NL + "     \t\tindexs_";
  protected final String TEXT_120 = "[";
  protected final String TEXT_121 = "]>field_";
  protected final String TEXT_122 = ".length()||indexs_";
  protected final String TEXT_123 = "[";
  protected final String TEXT_124 = "]<0?field_";
  protected final String TEXT_125 = ".length():indexs_";
  protected final String TEXT_126 = "[";
  protected final String TEXT_127 = "])";
  protected final String TEXT_128 = ");" + NL + " \t}";
  protected final String TEXT_129 = NL + "\tString temp_";
  protected final String TEXT_130 = " = null;";
  protected final String TEXT_131 = NL + "\t";
  protected final String TEXT_132 = ".";
  protected final String TEXT_133 = " = newFields_";
  protected final String TEXT_134 = ".get(\"";
  protected final String TEXT_135 = "\");";
  protected final String TEXT_136 = NL + "\ttemp_";
  protected final String TEXT_137 = " = newFields_";
  protected final String TEXT_138 = ".get(\"";
  protected final String TEXT_139 = "\");" + NL + "\tif(temp_";
  protected final String TEXT_140 = "!=null && temp_";
  protected final String TEXT_141 = ".length() > 0) {";
  protected final String TEXT_142 = NL + "\t\t";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = " = temp_";
  protected final String TEXT_145 = ".getBytes();";
  protected final String TEXT_146 = NL + "\t\t";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_149 = ", ";
  protected final String TEXT_150 = ", false);";
  protected final String TEXT_151 = NL + "\t\t";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_154 = ", ";
  protected final String TEXT_155 = ");";
  protected final String TEXT_156 = NL + "\t\t";
  protected final String TEXT_157 = ".";
  protected final String TEXT_158 = " = ParserUtils.parseTo_";
  protected final String TEXT_159 = "(ParserUtils.parseTo_Number(temp_";
  protected final String TEXT_160 = ", ";
  protected final String TEXT_161 = ", ";
  protected final String TEXT_162 = "));";
  protected final String TEXT_163 = NL + "\t\t";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = " = ParserUtils.parseTo_";
  protected final String TEXT_166 = "(temp_";
  protected final String TEXT_167 = ");";
  protected final String TEXT_168 = NL + "\t} else {\t\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_170 = "' in '";
  protected final String TEXT_171 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_172 = NL + "\t\t";
  protected final String TEXT_173 = ".";
  protected final String TEXT_174 = " = ";
  protected final String TEXT_175 = ";";
  protected final String TEXT_176 = NL + "\t}";
  protected final String TEXT_177 = NL + "\t int filedsum_";
  protected final String TEXT_178 = " = newFields_";
  protected final String TEXT_179 = ".size();" + NL + "\t if(filedsum_";
  protected final String TEXT_180 = " < ";
  protected final String TEXT_181 = "){" + NL + "\t \tthrow new RuntimeException(\"Column(s) missing\");" + NL + "\t } else if(filedsum_";
  protected final String TEXT_182 = " > ";
  protected final String TEXT_183 = ") {" + NL + "\t \tthrow new RuntimeException(\"Too many columns\");" + NL + "\t }";
  protected final String TEXT_184 = NL + "\t";
  protected final String TEXT_185 = " = null;";
  protected final String TEXT_186 = NL + "\tnb_line_";
  protected final String TEXT_187 = "++;";
  protected final String TEXT_188 = NL + "}catch(java.lang.Exception ex_";
  protected final String TEXT_189 = "){";
  protected final String TEXT_190 = NL + "\tthrow(ex_";
  protected final String TEXT_191 = ");";
  protected final String TEXT_192 = NL + "\t";
  protected final String TEXT_193 = " = new ";
  protected final String TEXT_194 = "Struct();";
  protected final String TEXT_195 = NL + "    ";
  protected final String TEXT_196 = ".";
  protected final String TEXT_197 = " = ";
  protected final String TEXT_198 = ".";
  protected final String TEXT_199 = ";";
  protected final String TEXT_200 = "    ";
  protected final String TEXT_201 = NL + "    ";
  protected final String TEXT_202 = ".errorMessage = ex_";
  protected final String TEXT_203 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_204 = ";";
  protected final String TEXT_205 = NL + "    ";
  protected final String TEXT_206 = " = null;";
  protected final String TEXT_207 = NL + "\tlog.error(\"";
  protected final String TEXT_208 = " - \" + ex_";
  protected final String TEXT_209 = ".getMessage());";
  protected final String TEXT_210 = NL + "    System.err.println(ex_";
  protected final String TEXT_211 = ".getMessage());";
  protected final String TEXT_212 = NL + "    ";
  protected final String TEXT_213 = " = null;";
  protected final String TEXT_214 = NL + "\t";
  protected final String TEXT_215 = ".errorMessage = ex_";
  protected final String TEXT_216 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_217 = ";";
  protected final String TEXT_218 = NL + "}";
  protected final String TEXT_219 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_30);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

final boolean isLog4jEnabled = "true".equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

String field = ElementParameterParser.getValue(node, "__FIELD__");
boolean ignoreSourceNull="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__IGNORE_SOURCE_NULL__"));
String pattern = ElementParameterParser.getValue(node, "__PATTERN__");
boolean advanced = ("true").equals(ElementParameterParser.getValue(node, "__ADVANCED_OPTION__"));
List<Map<String, String>> formats =
	(List<Map<String,String>>)ElementParameterParser.getObjectValue( node, "__FORMATS__");

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

boolean trim = ("true").equals(ElementParameterParser.getValue(node, "__TRIM__"));

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;

String checkNumStr = ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__");
boolean checkNum = (checkNumStr!=null&&!("").equals(checkNumStr))?("true").equals(checkNumStr):false; 

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

IConnection outConn = null;
String firstConnName = "";
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

    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_32);
    
    	}
    }
}

//get field column
if(inConn!=null){
	IMetadataTable inputMetadataTable = inConn.getMetadataTable();
	for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
		if(inputCol.getLabel().equals(field)){

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(field);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(field);
    stringBuffer.append(TEXT_39);
    
			if(!ignoreSourceNull){

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
			}else{

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
				List<BlockCode> blockCodes = new java.util.ArrayList<BlockCode>(1);
				blockCodes.add(new BlockCode("C_01"));
				((org.talend.core.model.process.AbstractNode) node).setBlocksCodeToClose(blockCodes);
			}
			break;
		}
	}
}

//set original columns
List<IMetadataColumn> newColumnList = new ArrayList<IMetadataColumn>();
if(outConn!=null && inConn!=null){

    stringBuffer.append(TEXT_45);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_47);
    
	IMetadataTable outputMetadataTable = outConn.getMetadataTable();
	IMetadataTable inputMetadataTable = inConn.getMetadataTable();
	for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
		if(outputCol.getLabel().equals(field)){
			continue;
		}
		boolean isOirginalColumn = false;
		for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
			JavaType stringType =  JavaTypesManager.getJavaTypeFromId(inputCol.getTalendType());
			if( outputCol.getLabel().equals( inputCol.getLabel()) ){
				isOirginalColumn = true;
				

    stringBuffer.append(TEXT_48);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(outputCol.getLabel());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(inputCol.getLabel());
    stringBuffer.append(TEXT_52);
    
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


    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
	if(advanced){
		for(int i=0; i<formats.size(); i++){
			Map<String,String> tmp = formats.get(i);
			if(i==0){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(tmp.get("COLUMN"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_67);
    stringBuffer.append(tmp.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(tmp.get("ALIGN"));
    stringBuffer.append(TEXT_69);
    
			}else{

    stringBuffer.append(TEXT_70);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(tmp.get("COLUMN"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_91);
    stringBuffer.append(tmp.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(tmp.get("ALIGN"));
    stringBuffer.append(TEXT_93);
    
			}
		}
	}else{
		for(int i=0;i<newColumnList.size();i++){
			IMetadataColumn tmp = newColumnList.get(i);
			if(i==0){

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(tmp.getLabel());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_106);
    
			}else{

    stringBuffer.append(TEXT_107);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(tmp.getLabel());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_128);
    
			}
		}
	}

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
	for(IMetadataColumn column:newColumnList){
		String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    
		if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_131);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_135);
    
		}else{ 

    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    
			if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_142);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    
			}else if(javaType == JavaTypesManager.DATE) {
				if(checkNum){

    stringBuffer.append(TEXT_146);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_150);
    
				}else{

    stringBuffer.append(TEXT_151);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_155);
    
				}
			}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_156);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_161);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_162);
    
			} else {

    stringBuffer.append(TEXT_163);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    
			}

    stringBuffer.append(TEXT_168);
    
			String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
			if(defaultValue == null) {

    stringBuffer.append(TEXT_169);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_171);
    
			} else {

    stringBuffer.append(TEXT_172);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_175);
    
			}

    stringBuffer.append(TEXT_176);
    
		}
	}
	
	if(checkNum) {

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(newColumnList.size() );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(newColumnList.size() );
    stringBuffer.append(TEXT_183);
    
	}
	
	if(!("").equals(rejectConnName) && rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_184);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_185);
    
	}

    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    
	log4jFileUtil.logCurrentRowNumberInfo();

    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    
	if(dieOnError){

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    
	}else{
		if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_192);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_194);
    
            for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {

    stringBuffer.append(TEXT_195);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_199);
    
			}

    stringBuffer.append(TEXT_200);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_206);
    
		} else if(("").equals(rejectConnName)){
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    
			}

    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_213);
    
		} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_214);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_217);
    
		}
	}

    stringBuffer.append(TEXT_218);
    
}

    stringBuffer.append(TEXT_219);
    return stringBuffer.toString();
  }
}
