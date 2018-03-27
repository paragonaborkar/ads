package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TFileOutputExcelMainJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelMainJava result = new TFileOutputExcelMainJava();
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
  protected final String TEXT_29 = NL + "    \t\t\t\tnb_line_";
  protected final String TEXT_30 = " = nb_line_";
  protected final String TEXT_31 = " + excelDynamicUtil_";
  protected final String TEXT_32 = ".writeHeaderToExcelFile(writableSheet_";
  protected final String TEXT_33 = ",";
  protected final String TEXT_34 = "," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_35 = "startRowNum_";
  protected final String TEXT_36 = "+nb_line_";
  protected final String TEXT_37 = "nb_line_";
  protected final String TEXT_38 = ",";
  protected final String TEXT_39 = ",fitWidth_";
  protected final String TEXT_40 = ");" + NL + "    \t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_42 = ".putValue_";
  protected final String TEXT_43 = "(";
  protected final String TEXT_44 = ",writableSheet_";
  protected final String TEXT_45 = "," + NL + "\t\t\t\t\tstartRowNum_";
  protected final String TEXT_46 = ",nb_line_";
  protected final String TEXT_47 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_48 = "format_";
  protected final String TEXT_49 = "null";
  protected final String TEXT_50 = ",fitWidth_";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "\t\t\t\t";
  protected final String TEXT_53 = "\t\t\t\t";
  protected final String TEXT_54 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\t" + NL + "//modif start" + NL + "\t\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_59 = " = excelDynamicUtil_";
  protected final String TEXT_60 = ".getDynamicColCount()+";
  protected final String TEXT_61 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_65 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\t\t\t\tjxl.write.WritableCell existingCell_";
  protected final String TEXT_68 = "_";
  protected final String TEXT_69 = " = writableSheet_";
  protected final String TEXT_70 = ".getWritableCell(columnIndex_";
  protected final String TEXT_71 = " + ";
  protected final String TEXT_72 = ", startRowNum_";
  protected final String TEXT_73 = " + nb_line_";
  protected final String TEXT_74 = ") ;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_76 = "_";
  protected final String TEXT_77 = " = new jxl.write.";
  protected final String TEXT_78 = "(columnIndex_";
  protected final String TEXT_79 = " + ";
  protected final String TEXT_80 = ", startRowNum_";
  protected final String TEXT_81 = " + nb_line_";
  protected final String TEXT_82 = " ," + NL + "\t\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_84 = "_";
  protected final String TEXT_85 = " = new jxl.write.";
  protected final String TEXT_86 = "(columnIndex_";
  protected final String TEXT_87 = ", startRowNum_";
  protected final String TEXT_88 = " + nb_line_";
  protected final String TEXT_89 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_90 = NL + "//modif end";
  protected final String TEXT_91 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_92 = ".";
  protected final String TEXT_93 = ", cell_format_";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = NL + "\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = ")";
  protected final String TEXT_98 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = ".toString()";
  protected final String TEXT_101 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_102 = ".";
  protected final String TEXT_103 = ")).toString()";
  protected final String TEXT_104 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_106 = "), ";
  protected final String TEXT_107 = ", ";
  protected final String TEXT_108 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = "), ";
  protected final String TEXT_112 = ", ";
  protected final String TEXT_113 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_114 = "\t\t" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_115 = ").doubleValue()";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = NL + "\t\t\t\t\t\t,format_";
  protected final String TEXT_119 = NL + "\t\t\t\t\t\t\t);" + NL + "//modif start\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t//If we keep the cell format from the existing cell in sheet" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\t\t\t\t\tif(existingCell_";
  protected final String TEXT_121 = "_";
  protected final String TEXT_122 = ".getCellFormat()!=null)" + NL + "\t\t\t\t\t\t\t\t\tcell_";
  protected final String TEXT_123 = "_";
  protected final String TEXT_124 = ".setCellFormat( existingCell_";
  protected final String TEXT_125 = "_";
  protected final String TEXT_126 = ".getCellFormat());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_127 = NL + "//modif ends\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\twritableSheet_";
  protected final String TEXT_128 = ".addCell(cell_";
  protected final String TEXT_129 = "_";
  protected final String TEXT_130 = ");";
  protected final String TEXT_131 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_132 = "_";
  protected final String TEXT_133 = " = String.valueOf(((jxl.write.Number)cell_";
  protected final String TEXT_134 = "_";
  protected final String TEXT_135 = ").getValue()).trim().length();" + NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_136 = "_";
  protected final String TEXT_137 = "=currentWith_";
  protected final String TEXT_138 = "_";
  protected final String TEXT_139 = ">10?10:currentWith_";
  protected final String TEXT_140 = "_";
  protected final String TEXT_141 = ";";
  protected final String TEXT_142 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_143 = "_";
  protected final String TEXT_144 = " = cell_";
  protected final String TEXT_145 = "_";
  protected final String TEXT_146 = ".getContents().trim().length();";
  protected final String TEXT_147 = NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_148 = "[";
  protected final String TEXT_149 = "]=fitWidth_";
  protected final String TEXT_150 = "[";
  protected final String TEXT_151 = "]>currentWith_";
  protected final String TEXT_152 = "_";
  protected final String TEXT_153 = "?fitWidth_";
  protected final String TEXT_154 = "[";
  protected final String TEXT_155 = "]:currentWith_";
  protected final String TEXT_156 = "_";
  protected final String TEXT_157 = "+2;";
  protected final String TEXT_158 = NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_159 = "_";
  protected final String TEXT_160 = "=";
  protected final String TEXT_161 = ";" + NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_162 = "[";
  protected final String TEXT_163 = "]=fitWidth_";
  protected final String TEXT_164 = "[";
  protected final String TEXT_165 = "]>currentWith_";
  protected final String TEXT_166 = "_";
  protected final String TEXT_167 = "?fitWidth_";
  protected final String TEXT_168 = "[";
  protected final String TEXT_169 = "]:currentWith_";
  protected final String TEXT_170 = "_";
  protected final String TEXT_171 = "+2;";
  protected final String TEXT_172 = NL + "\t\t\t\t\t\texcelDynamicUtil_";
  protected final String TEXT_173 = ".writeValuesToExcelFile(";
  protected final String TEXT_174 = ".";
  protected final String TEXT_175 = ", writableSheet_";
  protected final String TEXT_176 = ",columnIndex_";
  protected final String TEXT_177 = "+";
  protected final String TEXT_178 = ",startRowNum_";
  protected final String TEXT_179 = " + nb_line_";
  protected final String TEXT_180 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_181 = NL + "\t\t\t\t\t\t\texcelDynamicUtil_";
  protected final String TEXT_182 = ".autoDynamicColumnSize(writableSheet_";
  protected final String TEXT_183 = ",columnIndex_";
  protected final String TEXT_184 = "+";
  protected final String TEXT_185 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_186 = NL + "\t    \t\t\t\t} " + NL + "\t\t\t\t\t";
  protected final String TEXT_187 = NL + "    \t\t\tnb_line_";
  protected final String TEXT_188 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_189 = NL + "    \t\t\t\tnb_line_";
  protected final String TEXT_190 = " = nb_line_";
  protected final String TEXT_191 = " + excelDynamicUtil_";
  protected final String TEXT_192 = ".writeHeaderToExcelFile(";
  protected final String TEXT_193 = ", xlsxTool_";
  protected final String TEXT_194 = ", nb_line_";
  protected final String TEXT_195 = ");" + NL + "    \t\t\t";
  protected final String TEXT_196 = NL + "\t\t\t\txlsxTool_";
  protected final String TEXT_197 = ".addRow();";
  protected final String TEXT_198 = NL + "   \t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_199 = ".putValue_";
  protected final String TEXT_200 = "(";
  protected final String TEXT_201 = ",xlsxTool_";
  protected final String TEXT_202 = ");";
  protected final String TEXT_203 = NL + "\t\t\t\t";
  protected final String TEXT_204 = "\t\t\t\t\t";
  protected final String TEXT_205 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_206 = ".";
  protected final String TEXT_207 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_208 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_209 = ".addCellValue(";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = ", ";
  protected final String TEXT_212 = ");";
  protected final String TEXT_213 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_214 = ".addCellValue(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_215 = ".";
  protected final String TEXT_216 = ")).toString());";
  protected final String TEXT_217 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_218 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_219 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_220 = "), ";
  protected final String TEXT_221 = ", ";
  protected final String TEXT_222 = "));\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_223 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_224 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_225 = ".";
  protected final String TEXT_226 = "), ";
  protected final String TEXT_227 = ", ";
  protected final String TEXT_228 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_229 = "\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_230 = ".addCellValue((";
  protected final String TEXT_231 = ").doubleValue());";
  protected final String TEXT_232 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_233 = ".addCellValue(";
  protected final String TEXT_234 = ".";
  protected final String TEXT_235 = ");";
  protected final String TEXT_236 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_237 = ".addCellValue(";
  protected final String TEXT_238 = ".";
  protected final String TEXT_239 = ");";
  protected final String TEXT_240 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_241 = ".addCellValue(Double.parseDouble(String.valueOf(";
  protected final String TEXT_242 = ".";
  protected final String TEXT_243 = ")));";
  protected final String TEXT_244 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_245 = ".addCellValue(String.valueOf(";
  protected final String TEXT_246 = ".";
  protected final String TEXT_247 = "));";
  protected final String TEXT_248 = NL + "\t\t\t\t\t\texcelDynamicUtil_";
  protected final String TEXT_249 = ".writeValuesToExcelFile(";
  protected final String TEXT_250 = ".";
  protected final String TEXT_251 = ", xlsxTool_";
  protected final String TEXT_252 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_253 = NL + "\t\t\t\t\t\t\texcelDynamicUtil_";
  protected final String TEXT_254 = ".autoDynamicColumnSize(xlsxTool_";
  protected final String TEXT_255 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_256 = NL + "\t    \t\t\t\t} else {" + NL + "\t    \t\t\t\t\txlsxTool_";
  protected final String TEXT_257 = ".addCellNullValue();" + NL + "\t    \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_258 = NL + "    \t\t\tnb_line_";
  protected final String TEXT_259 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_260 = NL + "\t\t\t\t\tbufferCount_";
  protected final String TEXT_261 = "++;" + NL + "\t\t\t\t\tif(bufferCount_";
  protected final String TEXT_262 = " >= flushRowNum_";
  protected final String TEXT_263 = "){" + NL + "    \t\t\t\t\txlsxTool_";
  protected final String TEXT_264 = ".flushRowInMemory();" + NL + "    \t\t\t\t\tbufferCount_";
  protected final String TEXT_265 = "=0;" + NL + "    \t\t\t\t}";

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
boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
String font = ElementParameterParser.getValue(node, "__FONT__"); 
boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
//modif start
boolean firstCellYAbsolute = ("true").equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
String firstCellXStr = ElementParameterParser.getValue(node, "__FIRST_CELL_X__");
String firstCellYStr = ElementParameterParser.getValue(node, "__FIRST_CELL_Y__");
//modif end
boolean keepCellFormating =  ElementParameterParser.getValue(node, "__KEEP_CELL_FORMATING__").equals("true");
boolean flushOnRow=("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__" ));
boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
boolean isAppendFile = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_FILE__" ));

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

boolean isAllColumnAutoSize = ("true").equals(ElementParameterParser.getValue(node, "__IS_ALL_AUTO_SZIE__" ));
List<Map<String, String>> autoSizeList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__AUTO_SZIE_SETTING__");
Map<String,String> autColSizeMaping=new HashMap<String,String>();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
		List<IMetadataColumn> columns = metadata.getListColumns();
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		
		boolean hasDynamic = false;
		int dynamic_index = 0;
		String datePattern = "\"dd-MM-yyyy\"";
		for(int i=0; columns!=null && i< columns.size(); i++) {
			IMetadataColumn column = columns.get(i);
	        if(!hasDynamic && column.getTalendType().equals("id_Dynamic")){
	            dynamic_index = i+1;
	            hasDynamic = true;
	            datePattern= column.getPattern();
	        }
	        if(isAllColumnAutoSize){
	        	autColSizeMaping.put(column.getLabel(),"true");
	        }else{
	        	autColSizeMaping.put(column.getLabel(),autoSizeList.get(i).get("IS_AUTO_SIZE"));
	        	
	        }
		}
		if(!version07){//version judgement
    	
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			if(hasDynamic && isIncludeHeader){
    			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(firstCellYAbsolute?firstCellXStr:"0");
    stringBuffer.append(TEXT_34);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
    			}
    			int sizeColumns = columns.size();
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
    				if(sizeColumns > schemaOptNum) {
    					if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    if (font !=null && font.length()!=0) {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
    					}
    					continue;
    				}

    stringBuffer.append(TEXT_52);
    stringBuffer.append(TEXT_53);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_54);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_56);
    
    				} 
    				
    stringBuffer.append(TEXT_57);
    
					//Detect the format required for the cell
					String jxlWriteType;
    				int staticWidth = 0;
    				boolean isNumber = false;
					if(javaType == JavaTypesManager.BOOLEAN){
						staticWidth=5;
						jxlWriteType="Boolean";
					}else if(javaType == JavaTypesManager.DATE){
						jxlWriteType="DateTime";
				    }else if(javaType == JavaTypesManager.STRING||
				    		 javaType == JavaTypesManager.CHARACTER||
				    		 javaType == JavaTypesManager.BYTE_ARRAY||
				    		 javaType == JavaTypesManager.LIST||
				    		 javaType == JavaTypesManager.OBJECT||
				    		 column.getTalendType().equals("id_Dynamic")||
				    		 (advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable()))
				    		 ){
				    	jxlWriteType="Label";
					}else{
						isNumber=true;
						jxlWriteType="Number";
					};
					if(hasDynamic && i+1>dynamic_index){
					
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_61);
    
					}else{
					
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_64);
    
					}
					if(!column.getTalendType().equals("id_Dynamic")){
   				
    stringBuffer.append(TEXT_65);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_66);
    if(keepCellFormating){
    stringBuffer.append(TEXT_67);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    }
    stringBuffer.append(TEXT_75);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    }else{
    stringBuffer.append(TEXT_83);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
						staticWidth = pattern.trim().length();

    stringBuffer.append(TEXT_91);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append( cid);
    
					} else {
						if(javaType == JavaTypesManager.CHARACTER) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    
						} else if(javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_98);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_100);
    
						} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_101);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_103);
    
						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_104);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_106);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_107);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_108);
     } else { 
    stringBuffer.append(TEXT_109);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_112);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_113);
     } 
    
						} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_115);
    
					}else {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(column.getLabel() );
    				
					}
					if(font !=null && font.length()!=0){ 

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    
					}
				}

    stringBuffer.append(TEXT_119);
    if(keepCellFormating && firstCellYAbsolute){
    stringBuffer.append(TEXT_120);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
							}
							
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
					if(isNumber){

    stringBuffer.append(TEXT_131);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
					}else{

    stringBuffer.append(TEXT_142);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
					}
					if(staticWidth ==0){

    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
					}else{

    stringBuffer.append(TEXT_158);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(staticWidth);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    
					}
					}else{
					
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(firstCellYAbsolute?firstCellXStr:"0");
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    
						if("true".equalsIgnoreCase(autColSizeMaping.get(column.getLabel()))){
						
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(firstCellYAbsolute?firstCellXStr:"0");
    stringBuffer.append(TEXT_185);
    
						}
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_186);
    
    				} 
    			
    
				}

    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    log4jFileUtil.debugWriteData(node);
    
    		}
    	}
    	}else{ //version judgement /***excel 2007 xlsx*****/

		List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			if(hasDynamic && isIncludeHeader){
    			
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    
    			}
    			int sizeColumns = columns.size();

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
    				if(sizeColumns > schemaOptNum) {
    					if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
    					}
    					continue;
	        		}

    stringBuffer.append(TEXT_203);
    stringBuffer.append(TEXT_204);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_205);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_207);
    
    				} 
    				
    
					if(!column.getTalendType().equals("id_Dynamic")){
					
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_212);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_216);
    
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_217);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_220);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_221);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_222);
     } else { 
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_226);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_227);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_228);
     } 
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_231);
    
					}else if (javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_235);
    
					}else if (javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_239);
    					}else if(JavaTypesManager.isNumberType(javaType)){

    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_243);
    
					}else{	

    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_247);
    				
					}
					}else{
					
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    
						if("true".equalsIgnoreCase(autColSizeMaping.get(column.getLabel()))){
						
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    
						}
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    
    				} 
    				
    
    			}
    			
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    log4jFileUtil.debugWriteData(node);
    
				if(flushOnRow && (useStream || !isAppendFile)){

    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    
				}
    		}
    	}

    	}
    }
}

    return stringBuffer.toString();
  }
}
