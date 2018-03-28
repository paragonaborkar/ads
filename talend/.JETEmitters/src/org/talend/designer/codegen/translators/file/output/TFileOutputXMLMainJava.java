package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnection;
import org.talend.core.utils.TalendQuoteUtils;

public class TFileOutputXMLMainJava
{
  protected static String nl;
  public static synchronized TFileOutputXMLMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputXMLMainJava result = new TFileOutputXMLMainJava();
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
  protected final String TEXT_30 = NL + "String tempSt_";
  protected final String TEXT_31 = " = null;" + NL + "" + NL + "boolean flag_";
  protected final String TEXT_32 = " = true;" + NL + " " + NL + "groupby_new_";
  protected final String TEXT_33 = " = 0;" + NL;
  protected final String TEXT_34 = "tempSt_";
  protected final String TEXT_35 = " = \"<\"+";
  protected final String TEXT_36 = "+\" \"+";
  protected final String TEXT_37 = "+\"=\\\"\"+";
  protected final String TEXT_38 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_39 = "), ";
  protected final String TEXT_40 = ", ";
  protected final String TEXT_41 = ")";
  protected final String TEXT_42 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = "), ";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = ")";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = "((";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = " == null)?\"\":(";
  protected final String TEXT_51 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_52 = "FormatterUtils.format_Date(";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = ", ";
  protected final String TEXT_55 = ")";
  protected final String TEXT_56 = ")";
  protected final String TEXT_57 = "TalendString.replaceSpecialCharForXML(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = ")).toString())";
  protected final String TEXT_60 = "TalendString.replaceSpecialCharForXML(String.valueOf(";
  protected final String TEXT_61 = "))";
  protected final String TEXT_62 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = ")";
  protected final String TEXT_65 = "))";
  protected final String TEXT_66 = "+\"\\\">\";" + NL + "" + NL + "if(!groupby_";
  protected final String TEXT_67 = "[";
  protected final String TEXT_68 = "][0].equals(tempSt_";
  protected final String TEXT_69 = ")){" + NL + "\t" + NL + "\tif(flag_";
  protected final String TEXT_70 = "){" + NL + "\t" + NL + "\t\tgroupby_new_";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = ";" + NL + "" + NL + "\t\tflag_";
  protected final String TEXT_73 = " = false;" + NL + "\t\t" + NL + "\t\tfor(int i_";
  protected final String TEXT_74 = " = ";
  protected final String TEXT_75 = "; i_";
  protected final String TEXT_76 = " >= groupby_new_";
  protected final String TEXT_77 = " && start_";
  protected final String TEXT_78 = "; i_";
  protected final String TEXT_79 = "--){" + NL + "" + NL + "\t\t\tout_";
  protected final String TEXT_80 = ".write(groupby_";
  protected final String TEXT_81 = "[i_";
  protected final String TEXT_82 = "][1]);" + NL + "\t" + NL + "\t\t\tout_";
  protected final String TEXT_83 = ".newLine();" + NL + "\t" + NL + "\t\t}\t" + NL + "\t}" + NL + "" + NL + "\tgroupby_";
  protected final String TEXT_84 = "[";
  protected final String TEXT_85 = "][0] = tempSt_";
  protected final String TEXT_86 = ";" + NL + "\t" + NL + "\tout_";
  protected final String TEXT_87 = ".write(tempSt_";
  protected final String TEXT_88 = ");" + NL + "" + NL + "\tout_";
  protected final String TEXT_89 = ".newLine();" + NL + "\t" + NL + "\tif(!start_";
  protected final String TEXT_90 = "){" + NL + "\t\t\t" + NL + "\t\tstart_";
  protected final String TEXT_91 = " = true;" + NL + "\t\t\t" + NL + "\t}" + NL + "\t\t" + NL + "}else if(!flag_";
  protected final String TEXT_92 = "){" + NL + "\t" + NL + "\tout_";
  protected final String TEXT_93 = ".write(tempSt_";
  protected final String TEXT_94 = ");" + NL + "\t" + NL + "\tout_";
  protected final String TEXT_95 = ".newLine();" + NL + "\t" + NL + "\tif(!start_";
  protected final String TEXT_96 = "){" + NL + "\t\t\t" + NL + "\t\tstart_";
  protected final String TEXT_97 = " = true;" + NL + "\t\t\t" + NL + "\t}" + NL + "\t" + NL + "}" + NL;
  protected final String TEXT_98 = "StringBuilder tempRes_";
  protected final String TEXT_99 = " = new StringBuilder(\"<\"+";
  protected final String TEXT_100 = ");" + NL;
  protected final String TEXT_101 = "tempRes_";
  protected final String TEXT_102 = ".append(\" \"+";
  protected final String TEXT_103 = "+\"=\\\"\"+";
  protected final String TEXT_104 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_105 = "), ";
  protected final String TEXT_106 = ", ";
  protected final String TEXT_107 = ")";
  protected final String TEXT_108 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = "), ";
  protected final String TEXT_111 = ", ";
  protected final String TEXT_112 = ")";
  protected final String TEXT_113 = ".";
  protected final String TEXT_114 = "((";
  protected final String TEXT_115 = ".";
  protected final String TEXT_116 = " == null)?\"\":(";
  protected final String TEXT_117 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_118 = "FormatterUtils.format_Date(";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = ", ";
  protected final String TEXT_121 = ")";
  protected final String TEXT_122 = ")";
  protected final String TEXT_123 = "TalendString.replaceSpecialCharForXML(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = ")).toString())";
  protected final String TEXT_126 = "TalendString.replaceSpecialCharForXML(String.valueOf(";
  protected final String TEXT_127 = "))";
  protected final String TEXT_128 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_129 = ".";
  protected final String TEXT_130 = ")";
  protected final String TEXT_131 = "))";
  protected final String TEXT_132 = "+\"\\\"\");" + NL;
  protected final String TEXT_133 = "tempRes_";
  protected final String TEXT_134 = ".append(\">\");" + NL;
  protected final String TEXT_135 = "tempRes_";
  protected final String TEXT_136 = ".append(\"/>\");" + NL;
  protected final String TEXT_137 = "out_";
  protected final String TEXT_138 = ".write(tempRes_";
  protected final String TEXT_139 = ".toString());" + NL + "" + NL + "out_";
  protected final String TEXT_140 = ".newLine();" + NL;
  protected final String TEXT_141 = "out_";
  protected final String TEXT_142 = ".write(\"<\"+";
  protected final String TEXT_143 = "+\">\"+";
  protected final String TEXT_144 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_145 = "), ";
  protected final String TEXT_146 = ", ";
  protected final String TEXT_147 = ")";
  protected final String TEXT_148 = "FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_149 = ".";
  protected final String TEXT_150 = "), ";
  protected final String TEXT_151 = ", ";
  protected final String TEXT_152 = ")";
  protected final String TEXT_153 = ".";
  protected final String TEXT_154 = "((";
  protected final String TEXT_155 = ".";
  protected final String TEXT_156 = " == null)?\"\":(";
  protected final String TEXT_157 = "TalendString.checkCDATAForXML(";
  protected final String TEXT_158 = "FormatterUtils.format_Date(";
  protected final String TEXT_159 = ".";
  protected final String TEXT_160 = ", ";
  protected final String TEXT_161 = ")";
  protected final String TEXT_162 = ")";
  protected final String TEXT_163 = "TalendString.checkCDATAForXML(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = ")).toString())";
  protected final String TEXT_166 = "TalendString.checkCDATAForXML(String.valueOf(";
  protected final String TEXT_167 = "))";
  protected final String TEXT_168 = "TalendString.checkCDATAForXML(";
  protected final String TEXT_169 = ".";
  protected final String TEXT_170 = ")";
  protected final String TEXT_171 = ".getDocument().getRootElement().asXML()";
  protected final String TEXT_172 = "TalendString.checkCDATAForXML(";
  protected final String TEXT_173 = ".";
  protected final String TEXT_174 = ")";
  protected final String TEXT_175 = "))";
  protected final String TEXT_176 = "+\"</\"+";
  protected final String TEXT_177 = "+\">\");" + NL + "" + NL + "out_";
  protected final String TEXT_178 = ".newLine();" + NL;
  protected final String TEXT_179 = "out_";
  protected final String TEXT_180 = ".write(\"</\"+";
  protected final String TEXT_181 = "+\">\");" + NL + "" + NL + "out_";
  protected final String TEXT_182 = ".newLine();" + NL;
  protected final String TEXT_183 = NL;
  protected final String TEXT_184 = NL + "    if(nb_line_";
  protected final String TEXT_185 = "%";
  protected final String TEXT_186 = " == 0) {" + NL + "    out_";
  protected final String TEXT_187 = ".flush();" + NL + "    }";
  protected final String TEXT_188 = NL + "nb_line_";
  protected final String TEXT_189 = "++;";
  protected final String TEXT_190 = NL + "currentRowCount_";
  protected final String TEXT_191 = "++;" + NL + "if(currentRowCount_";
  protected final String TEXT_192 = " == ";
  protected final String TEXT_193 = "){";
  protected final String TEXT_194 = NL + "out_";
  protected final String TEXT_195 = ".write(groupby_";
  protected final String TEXT_196 = "[";
  protected final String TEXT_197 = "][1]);" + NL + "out_";
  protected final String TEXT_198 = ".newLine();\t\t";
  protected final String TEXT_199 = NL + "out_";
  protected final String TEXT_200 = ".write(footers_";
  protected final String TEXT_201 = "[";
  protected final String TEXT_202 = "]);" + NL + "out_";
  protected final String TEXT_203 = ".newLine();";
  protected final String TEXT_204 = "\t" + NL + "\tout_";
  protected final String TEXT_205 = ".close();" + NL + "\tcurrentFileCount_";
  protected final String TEXT_206 = "++;\t" + NL + "" + NL + "    sb_";
  protected final String TEXT_207 = " = new StringBuffer(canonicalPath_";
  protected final String TEXT_208 = ");" + NL + "    lastIndexOf_";
  protected final String TEXT_209 = " = canonicalPath_";
  protected final String TEXT_210 = ".lastIndexOf('.');" + NL + "    position_";
  protected final String TEXT_211 = " = lastIndexOf_";
  protected final String TEXT_212 = " > -1 ? lastIndexOf_";
  protected final String TEXT_213 = " : canonicalPath_";
  protected final String TEXT_214 = ".length();" + NL + "    sb_";
  protected final String TEXT_215 = ".insert(position_";
  protected final String TEXT_216 = ", currentFileCount_";
  protected final String TEXT_217 = ");" + NL + "    " + NL + "    fileName_";
  protected final String TEXT_218 = " = sb_";
  protected final String TEXT_219 = ".toString();" + NL + "    file_";
  protected final String TEXT_220 = " = new java.io.File(fileName_";
  protected final String TEXT_221 = ");" + NL + "    " + NL + "\tout_";
  protected final String TEXT_222 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file_";
  protected final String TEXT_223 = "), ";
  protected final String TEXT_224 = "));    " + NL;
  protected final String TEXT_225 = NL + "\tstart_";
  protected final String TEXT_226 = " = false;  ";
  protected final String TEXT_227 = "\t" + NL + "\tout_";
  protected final String TEXT_228 = ".write(headers_";
  protected final String TEXT_229 = "[";
  protected final String TEXT_230 = "]);" + NL + "\tout_";
  protected final String TEXT_231 = ".newLine();";
  protected final String TEXT_232 = "\t" + NL + "\tgroupby_";
  protected final String TEXT_233 = "[";
  protected final String TEXT_234 = "][0] = \"\";";
  protected final String TEXT_235 = "\t" + NL + "    currentRowCount_";
  protected final String TEXT_236 = " = 0;" + NL + "}";
  protected final String TEXT_237 = NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_238 = "++;" + NL + "\t\t\t\t\twriter_";
  protected final String TEXT_239 = ".write(";
  protected final String TEXT_240 = ".";
  protected final String TEXT_241 = ".getDocument());" + NL + "\t\t\t\t\t";
  protected final String TEXT_242 = NL;

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
	
    stringBuffer.append(TEXT_29);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean inputIsDocument = "true".equals(ElementParameterParser.getValue(node, "__INPUT_IS_DOCUMENT__"));
String colDoc = ElementParameterParser.getValue(node, "__DOCUMENT_COL__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

if(!inputIsDocument) {
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__")); 
    String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");       
    String split = ElementParameterParser.getValue(node, "__SPLIT__");
	String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
	List rootTags = (List)ElementParameterParser.getObjectValue(node, "__ROOT_TAGS__");
    int footers = rootTags.size();
    List<Map<String, String>> columnMapping = 
    		(List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__MAPPING__"
            );
    String useDynamicGrouping = ElementParameterParser.getValue(
            node,
            "__USE_DYNAMIC_GROUPING__"
        );
    List<Map<String, String>> groupBys =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__GROUP_BY__"
            );
            
    String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
	boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
	String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
	String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
	
    if (("false").equals(useDynamicGrouping)) {
        groupBys.clear();
    }
    if (encoding!=null) {
        if (("").equals(encoding)) {
                encoding = "ISO-8859-15";
        }
    }
    String groupby[][] = new String[groupBys.size()][3];
    for(int i = 0; i < groupBys.size(); i++){
    	groupby[i][0] = groupBys.get(i).get("COLUMN");
    	groupby[i][1] = groupBys.get(i).get("LABEL");
    }
    int atts = 0;
    int tags = 0;
    outter1:
    for(int i = 0; i < columnMapping.size(); i++){
    	Map<String, String> map = columnMapping.get(i);
    	String col = metadata.getListColumns().get(i).getLabel();
    	for(int j = 0; j < groupby.length; j++){
    		if(groupby[j][0].equals(col)){
    			if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
    				groupby[j][2] = col;
    				groupby[j][2] = TalendQuoteUtils.addQuotes(groupby[j][2]);
    			}else{
    				groupby[j][2] = map.get("LABEL");
    			}
    			continue outter1;
    		}
    	}
    	if(("true").equals(map.get("AS_ATTRIBUTE"))){
    		atts ++;
    	}else{
    		tags ++;
    	}
    }
    String[][] attribute = new String[atts][2];
    String[][] tag = new String[tags][2];
    int ia=0;
    int it=0;
    outter2:
    for(int i = 0; i < columnMapping.size(); i++){
    	Map<String, String> map = columnMapping.get(i);
    	String col = metadata.getListColumns().get(i).getLabel();
    	for(int j = 0; j < groupby.length; j++){
    		if(groupby[j][0].equals(col)){
    			continue outter2;
    		}
    	}
    	if(("true").equals(map.get("AS_ATTRIBUTE"))){
    		if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
    			attribute[ia][1] = col;
    			attribute[ia][1] = TalendQuoteUtils.addQuotes(attribute[ia][1]);
    		}else{
    			attribute[ia][1] = map.get("LABEL");
    		}
    		attribute[ia++][0] = col;
    	}else{
    		if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
    			tag[it][1] = col;
    			tag[it][1] = TalendQuoteUtils.addQuotes(tag[it][1]);
    		}else{
    			tag[it][1] = map.get("LABEL");
    		}
    	    tag[it++][0] = col;
    	}
    }
	if(groupby.length>0){

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
	}

    
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns!=null && conns.size()>0){
		IConnection conn = conns.get(0);
		for(int i = 0; i < groupby.length; i++){
			boolean needReplace = false;
			boolean isDate = false;
			boolean isByteArray = false;
			String pattern = null;
			boolean isPrimitive = false;
			boolean isBigDecimal = false;
			boolean isAdvancedSeparator = false;
			Integer precision = null;
			for(IMetadataColumn column:metadata.getListColumns()) {
				if(column.getLabel().equals(groupby[i][0])){
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.STRING){
						needReplace = true;
					}
					if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.DATE){
						pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if(pattern != null && (pattern.contains("&") || pattern.contains("<") || pattern.contains(">") || pattern.contains("'") || pattern.contains("\""))){
							needReplace = true;
						}
						isDate = true;
					}
					if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BYTE_ARRAY){
						isByteArray = true;
					}else if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BIGDECIMAL){
						isBigDecimal = true;
					}
					isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
					
					isAdvancedSeparator = advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable());
					
					precision = column.getPrecision();
					break;
				}
			}

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(groupby[i][2] );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(groupby[i][1] );
    stringBuffer.append(TEXT_37);
    
							if(isAdvancedSeparator){
								if(isBigDecimal){
								
    stringBuffer.append(TEXT_38);
    stringBuffer.append(precision == null? conn.getName() + "." + groupby[i][0] : conn.getName() + "." + groupby[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_41);
    
								}else {
								
    stringBuffer.append(TEXT_42);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_44);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_46);
    
								}
							}else if(isPrimitive){
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(groupby[i][0] );
    
							}else{
								
    stringBuffer.append(TEXT_48);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_50);
    
									if(isDate && pattern != null){
									
    if(needReplace){
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_55);
    if(needReplace){
    stringBuffer.append(TEXT_56);
    }
    
									}else if(isByteArray){
									
    stringBuffer.append(TEXT_57);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_59);
    
									}else if(isBigDecimal){
									
    stringBuffer.append(TEXT_60);
    stringBuffer.append(precision == null? conn.getName() + "." + tag[i][0] : conn.getName() + "." + tag[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_61);
    
									}else{
									
    if(needReplace){
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(groupby[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_64);
    }
    
									}
    stringBuffer.append(TEXT_65);
    
							}
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(groupby.length-1 );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    
		}

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_TAG__"));
    stringBuffer.append(TEXT_100);
    
for(int i = 0; i < attribute.length; i++){
	boolean needReplace = false;
	boolean isDate = false;
	boolean isByteArray = false;
	String pattern = null;
	boolean isPrimitive = false;
	boolean isBigDecimal = false;
	boolean isAdvancedSeparator = false;
	Integer precision = null;
	for(IMetadataColumn column:metadata.getListColumns()) {
		if(column.getLabel().equals(attribute[i][0])){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.STRING){
				needReplace = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.DATE){
				pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				if(pattern != null && (pattern.contains("&") || pattern.contains("<") || pattern.contains(">") || pattern.contains("'") || pattern.contains("\""))){
					needReplace = true;
				}
				isDate = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BYTE_ARRAY){
				isByteArray = true;
			}else if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BIGDECIMAL){
				isBigDecimal = true;
			}
			isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
			
			isAdvancedSeparator = advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable());
			
			precision = column.getPrecision();
			break;
		}
	}

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(attribute[i][1] );
    stringBuffer.append(TEXT_103);
    
							if(isAdvancedSeparator){
								if(isBigDecimal){
								
    stringBuffer.append(TEXT_104);
    stringBuffer.append(precision == null? conn.getName() + "." + attribute[i][0] : conn.getName() + "." + attribute[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_105);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_106);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_107);
    
								}else {
								
    stringBuffer.append(TEXT_108);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_112);
    
								}
							}else if(isPrimitive){
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(attribute[i][0] );
    
							}else{
								
    stringBuffer.append(TEXT_114);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_116);
    
									if(isDate && pattern != null){
									
    if(needReplace){
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_121);
    if(needReplace){
    stringBuffer.append(TEXT_122);
    }
    
									}else if(isByteArray){
									
    stringBuffer.append(TEXT_123);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_125);
    
									}else if(isBigDecimal){
									
    stringBuffer.append(TEXT_126);
    stringBuffer.append(precision == null? conn.getName() + "." + tag[i][0] : conn.getName() + "." + tag[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_127);
    
									}else{
									
    if(needReplace){
    stringBuffer.append(TEXT_128);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(attribute[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_130);
    }
    
									}
    stringBuffer.append(TEXT_131);
    
							}
    stringBuffer.append(TEXT_132);
    
}

    
if(tags > 0){

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    
}else{

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    
}

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    
for(int i = 0; i < tag.length; i++){
	boolean needReplace = false;
	boolean isDate = false;
	boolean isByteArray = false;
	String pattern = null;
	boolean isPrimitive = false;
	boolean isBigDecimal = false;
	boolean isAdvancedSeparator = false;
	boolean isDocument = false;
	Integer precision = null;
	for(IMetadataColumn column:metadata.getListColumns()) {
		if(column.getLabel().equals(tag[i][0])){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.STRING){
				needReplace = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.DATE){
				pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				if(pattern != null && (pattern.contains("&") || pattern.contains("<") || pattern.contains(">") || pattern.contains("'") || pattern.contains("\""))){
					needReplace = true;
				}
				isDate = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BYTE_ARRAY){
				isByteArray = true;
			}else if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BIGDECIMAL){
				isBigDecimal = true;
			}
			isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
			isAdvancedSeparator = advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable());
						
			precision = column.getPrecision();

			isDocument = "id_Document".equals(column.getTalendType());
			break;
		}
	}

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(tag[i][1]);
    stringBuffer.append(TEXT_143);
    
							if(isAdvancedSeparator){
								if(isBigDecimal){
								
    stringBuffer.append(TEXT_144);
    stringBuffer.append(precision == null? conn.getName() + "." + tag[i][0] : conn.getName() + "." + tag[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_145);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_146);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_147);
    
								}else {
								
    stringBuffer.append(TEXT_148);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_150);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_151);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_152);
    
								}
							}else if(isPrimitive){
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(tag[i][0] );
    
							}else{
								
    stringBuffer.append(TEXT_154);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_156);
    
									if(isDate && pattern != null){
									
    if(needReplace){
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_161);
    if(needReplace){
    stringBuffer.append(TEXT_162);
    }
    
									}else if(isByteArray){
									
    stringBuffer.append(TEXT_163);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_165);
    
									}else if(isBigDecimal){
									
    stringBuffer.append(TEXT_166);
    stringBuffer.append(precision == null? conn.getName() + "." + tag[i][0] : conn.getName() + "." + tag[i][0] + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_167);
    
									}else if(isDocument){
									
    if(needReplace){
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(tag[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_170);
    }
    stringBuffer.append(TEXT_171);
    
									}else{
									
    if(needReplace){
    stringBuffer.append(TEXT_172);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(tag[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_174);
    }
    
									}
    stringBuffer.append(TEXT_175);
    
							}
    stringBuffer.append(TEXT_176);
    stringBuffer.append(tag[i][1]);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    
	if(i == tag.length -1){

    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_TAG__"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    
	}
}

    stringBuffer.append(TEXT_183);
     if(flushOnRow) { 
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    
	}

    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    log4jFileUtil.debugWriteData(node);
    
    if(("true").equals(split)){

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SPLIT_EVERY__") );
    stringBuffer.append(TEXT_193);
    
		for(int i = groupby.length - 1; i >=0; i--){

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    
		}
		for(int i = footers - 1; i >= 0 ;i--){

    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    
		}

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_224);
    
	if(groupby.length > 0){

    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    
	}
	for(int i = 0; i <= footers;i++){

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    
	}
	for(int i = 0; i < groupby.length; i++){

    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_234);
    
	}

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    
	}
		}
	}
}
} else {
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			List< ? extends IConnection> conns = node.getIncomingConnections();
			if(conns!=null && conns.size()>0){
				IConnection conn = conns.get(0);

    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(colDoc);
    stringBuffer.append(TEXT_241);
    log4jFileUtil.debugWriteData(node);
    
			}
		}
	}
}

    stringBuffer.append(TEXT_242);
    return stringBuffer.toString();
  }
}
