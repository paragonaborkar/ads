package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputRegexBeginJava
{
  protected static String nl;
  public static synchronized TFileInputRegexBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputRegexBeginJava result = new TFileInputRegexBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
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
  protected final String TEXT_30 = NL + "\t";
  protected final String TEXT_31 = NL + "\t\tint nb_line_";
  protected final String TEXT_32 = " = 0;" + NL + "        " + NL + "        int footer_";
  protected final String TEXT_33 = "  = ";
  protected final String TEXT_34 = ";" + NL + "        boolean removeEmptyRow";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = ";" + NL + "        Object source_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ";" + NL + "        " + NL + "        org.talend.fileprocess.TOSDelimitedReader in";
  protected final String TEXT_39 = "=null;" + NL + "        if(source_";
  protected final String TEXT_40 = " instanceof String || source_";
  protected final String TEXT_41 = " instanceof java.io.InputStream){" + NL + "        \tin";
  protected final String TEXT_42 = " = new org.talend.fileprocess.TOSDelimitedReader(";
  protected final String TEXT_43 = ", ";
  protected final String TEXT_44 = ", \"\", ";
  protected final String TEXT_45 = ", removeEmptyRow";
  protected final String TEXT_46 = ");" + NL + "        }else{" + NL + "        \tthrow new java.lang.Exception(\"The source data should be specified as File Path or InputStream or java.io.Reader!\");" + NL + "        }" + NL + "        String str";
  protected final String TEXT_47 = ";" + NL + "        int totalLine";
  protected final String TEXT_48 = "=0,currentLine";
  protected final String TEXT_49 = "=0,beginLine";
  protected final String TEXT_50 = "=0,lastLine";
  protected final String TEXT_51 = "=-1,validRowCount";
  protected final String TEXT_52 = "=0;" + NL + "        int limit";
  protected final String TEXT_53 = "=";
  protected final String TEXT_54 = ";" + NL + "        ";
  protected final String TEXT_55 = NL + "\t\tint header";
  protected final String TEXT_56 = " = ";
  protected final String TEXT_57 = ";" + NL + "\t\tif(header";
  protected final String TEXT_58 = " > 0){" + NL + "\t\t\tbeginLine";
  protected final String TEXT_59 = "=header";
  protected final String TEXT_60 = "+1;" + NL + "\t\t}" + NL + "    \t" + NL + "        if(footer_";
  protected final String TEXT_61 = " > 0){" + NL + "\t\t\twhile (in";
  protected final String TEXT_62 = ".readRecord()) {" + NL + "                str";
  protected final String TEXT_63 = " =in";
  protected final String TEXT_64 = ".getRowRecord();        " + NL + "\t\t\t\ttotalLine";
  protected final String TEXT_65 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tint lastLineTemp";
  protected final String TEXT_66 = " = totalLine";
  protected final String TEXT_67 = " - footer_";
  protected final String TEXT_68 = "   < 0? 0 : totalLine";
  protected final String TEXT_69 = " - footer_";
  protected final String TEXT_70 = " ;" + NL + "\t\t\tif(lastLine";
  protected final String TEXT_71 = " > 0){" + NL + "\t\t\t\tlastLine";
  protected final String TEXT_72 = " = lastLine";
  protected final String TEXT_73 = " < lastLineTemp";
  protected final String TEXT_74 = " ? lastLine";
  protected final String TEXT_75 = " : lastLineTemp";
  protected final String TEXT_76 = "; " + NL + "\t\t\t}else {" + NL + "\t\t\t\tlastLine";
  protected final String TEXT_77 = " = lastLineTemp";
  protected final String TEXT_78 = ";" + NL + "\t\t\t}" + NL + "\t\t  \tin";
  protected final String TEXT_79 = ".close();" + NL + "        \tin";
  protected final String TEXT_80 = " = new org.talend.fileprocess.TOSDelimitedReader(";
  protected final String TEXT_81 = ", ";
  protected final String TEXT_82 = ", \"\", ";
  protected final String TEXT_83 = ", removeEmptyRow";
  protected final String TEXT_84 = ");" + NL + "\t\t}" + NL + "        java.util.StringTokenizer strToken";
  protected final String TEXT_85 = ";" + NL + "        java.util.regex.Pattern pattern";
  protected final String TEXT_86 = " = java.util.regex.Pattern.compile(";
  protected final String TEXT_87 = ");" + NL + "        java.util.regex.Matcher matcher";
  protected final String TEXT_88 = " = null;" + NL + "        ";
  protected final String TEXT_89 = NL + "        " + NL + "        while (in";
  protected final String TEXT_90 = ".readRecord()) {" + NL + "            str";
  protected final String TEXT_91 = " =in";
  protected final String TEXT_92 = ".getRowRecord(); " + NL + "        \t" + NL + "       \t\tcurrentLine";
  protected final String TEXT_93 = "++;" + NL + "        \tif(currentLine";
  protected final String TEXT_94 = " < beginLine";
  protected final String TEXT_95 = ") {" + NL + "        \t\tcontinue;" + NL + "        \t}" + NL + "        \tif(lastLine";
  protected final String TEXT_96 = " > -1 && currentLine";
  protected final String TEXT_97 = " > lastLine";
  protected final String TEXT_98 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \tif(removeEmptyRow";
  protected final String TEXT_99 = " && (\"\").equals(str";
  protected final String TEXT_100 = ")){" + NL + "        \t\tcontinue;" + NL + "        \t}" + NL + "        \tif(limit";
  protected final String TEXT_101 = "!=-1&& validRowCount";
  protected final String TEXT_102 = " >= limit";
  protected final String TEXT_103 = "){" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "        \tmatcher";
  protected final String TEXT_104 = " = pattern";
  protected final String TEXT_105 = ".matcher(str";
  protected final String TEXT_106 = ");" + NL + "        \tint groupCount";
  protected final String TEXT_107 = " = 0;" + NL + "        \tboolean isMatch";
  protected final String TEXT_108 = " = matcher";
  protected final String TEXT_109 = ".find(); " + NL + "        \tif(isMatch";
  protected final String TEXT_110 = "){" + NL + "        \tgroupCount";
  protected final String TEXT_111 = "=matcher";
  protected final String TEXT_112 = ".groupCount();" + NL + "\t\t\t}";
  protected final String TEXT_113 = NL + "    \t\t";
  protected final String TEXT_114 = " = null;\t\t\t";
  protected final String TEXT_115 = "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tboolean lineIsEmpty";
  protected final String TEXT_116 = " = str";
  protected final String TEXT_117 = ".length() == 0;" + NL + "\t\t\t" + NL + "\t\t\tString[] value";
  protected final String TEXT_118 = " = new String[";
  protected final String TEXT_119 = "];" + NL + "\t\t\tString frontChar";
  protected final String TEXT_120 = ",behindChar";
  protected final String TEXT_121 = ";" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_122 = ";i++){" + NL + "\t\t\t\tvalue";
  protected final String TEXT_123 = "[i] = \"\";" + NL + "\t\t\t\tif(lineIsEmpty";
  protected final String TEXT_124 = "){" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(i < groupCount";
  protected final String TEXT_125 = "){" + NL + "\t\t\t\t\tvalue";
  protected final String TEXT_126 = "[i] = matcher";
  protected final String TEXT_127 = ".group(i+1);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tvalidRowCount";
  protected final String TEXT_128 = "++;" + NL + "\t\t\t" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_129 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_130 = " = new ";
  protected final String TEXT_131 = "Struct();" + NL + "\t\t\ttry {\t\t\t" + NL + "\t\t\tif(!isMatch";
  protected final String TEXT_132 = "){//line data not matched with given regex parameter" + NL + "        \t\tthrow new java.lang.Exception(\"Line doesn't match: \" + str";
  protected final String TEXT_133 = ");" + NL + "        \t}" + NL + "\t\t\t";
  protected final String TEXT_134 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\tif(value";
  protected final String TEXT_135 = "[";
  protected final String TEXT_136 = "]!=null && value";
  protected final String TEXT_137 = "[";
  protected final String TEXT_138 = "].length() > 0) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_139 = ".";
  protected final String TEXT_140 = " = value";
  protected final String TEXT_141 = "[";
  protected final String TEXT_142 = "];";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = " = ParserUtils.parseTo_Date(value";
  protected final String TEXT_145 = "[";
  protected final String TEXT_146 = "], ";
  protected final String TEXT_147 = ");";
  protected final String TEXT_148 = ".";
  protected final String TEXT_149 = " = value";
  protected final String TEXT_150 = "[";
  protected final String TEXT_151 = "].getBytes(";
  protected final String TEXT_152 = ");";
  protected final String TEXT_153 = ".";
  protected final String TEXT_154 = " = ParserUtils.parseTo_";
  protected final String TEXT_155 = "(value";
  protected final String TEXT_156 = "[";
  protected final String TEXT_157 = "]);";
  protected final String TEXT_158 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_159 = "throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_160 = "' in '";
  protected final String TEXT_161 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_162 = ".";
  protected final String TEXT_163 = " = ";
  protected final String TEXT_164 = ";";
  protected final String TEXT_165 = "}" + NL + "\t";
  protected final String TEXT_166 = NL + "\t\t\t\t\t";
  protected final String TEXT_167 = " ";
  protected final String TEXT_168 = " = null; ";
  protected final String TEXT_169 = "\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_170 = " = true;";
  protected final String TEXT_171 = NL + "            if(isMatch";
  protected final String TEXT_172 = "){" + NL + "            \tthrow(e);" + NL + "            }else{" + NL + "\t    \t\t";
  protected final String TEXT_173 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_174 = " - \" +e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_175 = NL + "\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_176 = NL + "          \t\tcontinue;" + NL + "            }";
  protected final String TEXT_177 = NL + "                    ";
  protected final String TEXT_178 = " = new ";
  protected final String TEXT_179 = "Struct();";
  protected final String TEXT_180 = NL + "                    ";
  protected final String TEXT_181 = ".";
  protected final String TEXT_182 = " = ";
  protected final String TEXT_183 = ".";
  protected final String TEXT_184 = ";";
  protected final String TEXT_185 = NL + "                ";
  protected final String TEXT_186 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_187 = ";";
  protected final String TEXT_188 = NL + "                ";
  protected final String TEXT_189 = " = null;";
  protected final String TEXT_190 = NL + "        \t\tlog.error(\"";
  protected final String TEXT_191 = " - \" +e.getMessage());" + NL + "\t        \t";
  protected final String TEXT_192 = NL + "                    \tif(isMatch";
  protected final String TEXT_193 = "){" + NL + "                    \t\tSystem.err.println(e.getMessage());" + NL + "                    \t}";
  protected final String TEXT_194 = NL + "                    \tSystem.err.println(e.getMessage());";
  protected final String TEXT_195 = NL + "                ";
  protected final String TEXT_196 = " = null;";
  protected final String TEXT_197 = NL + "            \t";
  protected final String TEXT_198 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_199 = ";";
  protected final String TEXT_200 = NL + "    }\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t";
  protected final String TEXT_202 = "if(!whetherReject_";
  protected final String TEXT_203 = ") { ";
  protected final String TEXT_204 = "      " + NL + "             if(";
  protected final String TEXT_205 = " == null){ " + NL + "            \t ";
  protected final String TEXT_206 = " = new ";
  protected final String TEXT_207 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_208 = NL + "\t    \t ";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = " = ";
  protected final String TEXT_211 = ".";
  protected final String TEXT_212 = ";    \t\t\t\t";
  protected final String TEXT_213 = NL + "\t\t";
  protected final String TEXT_214 = " } ";
  protected final String TEXT_215 = "\t";
  protected final String TEXT_216 = NL + "\t\t\tnb_line_";
  protected final String TEXT_217 = "++;";
  protected final String TEXT_218 = NL;

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
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {

	
	String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
    String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    String myHeader = ElementParameterParser.getValue(node, "__HEADER__");
    String myLimit = ElementParameterParser.getValue(node, "__LIMIT__");
    String row_separator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
    String regex = ElementParameterParser.getValue(node, "__REGEX__");
    boolean ignoreUnmatchedError = ("true").equals(ElementParameterParser.getValue(node, "__IGNORE_ERROR_MESSAGE__"));
	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;  
	
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	log4jFileUtil.componentStartInfo(node);

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
     String myFooter = ElementParameterParser.getValue(node, "__FOOTER__"); if (("").equals(myFooter)) myFooter = "0"; 
    stringBuffer.append(myFooter);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__") );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_43);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(row_separator);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    if (("").equals(myLimit)) {myLimit = "-1";}
    stringBuffer.append(myLimit );
    stringBuffer.append(TEXT_54);
     
         	if (("").equals(myHeader)) myHeader = "0"; 
        
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(myHeader );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
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
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(row_separator);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( regex );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_88);
    log4jFileUtil.startRetriveDataInfo();
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_112);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

    String rejectConnName = "";
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();      
    }

    	if (conns!=null) {
    		if (conns.size()>0) {
    			for (int i=0;i<conns.size();i++) {
    				IConnection connTemp = conns.get(i);
    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_114);
    
    				}
    			}
    		}
    	}
    	
	String firstConnName = "";
	if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			firstConnName = conn.getName();
			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    stringBuffer.append(TEXT_115);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    	
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int sizeListColumns = listColumns.size();
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

					
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_138);
    
							if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
								/** end **/
								
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_142);
    
								/** begin **/
							} else if(javaType == JavaTypesManager.DATE) { 
								/** end **/
								
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_146);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_147);
    
								/** begin **/
							} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 
								/** end **/
								
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_152);
    
								/** begin **/
							} else {
								/** end **/
								
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_154);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_157);
    
								/** begin **/
							}
								/** end **/
						
    stringBuffer.append(TEXT_158);
    
							/** begin **/
							String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
							if(defaultValue == null) {
							/** end **/
								
    stringBuffer.append(TEXT_159);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_161);
    
							/** begin **/
							} else {
							/** end **/
								
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_164);
    
							/** begin **/
							}
							/** end **/
						
						
    stringBuffer.append(TEXT_165);
    					
	/** begin **/
					}
					
					log4jFileUtil.debugRetriveData(node,false);
	
    stringBuffer.append(TEXT_166);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_167);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    
	    		if(!ignoreUnmatchedError && isLog4jEnabled){
	    		
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
				}
				if(!ignoreUnmatchedError && !isLog4jEnabled){
				
    stringBuffer.append(TEXT_175);
    
				}
				
    stringBuffer.append(TEXT_176);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_177);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_179);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_180);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_184);
    
                }
                
    stringBuffer.append(TEXT_185);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_189);
    
            } else if(("").equals(rejectConnName)){
	        	if(isLog4jEnabled && !ignoreUnmatchedError){
	        	
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    
	        	}
	        	if(!isLog4jEnabled){
    	        	if(ignoreUnmatchedError){
                    
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    
                    }else{
                    
    stringBuffer.append(TEXT_194);
    
                    }
                }
                
    stringBuffer.append(TEXT_195);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_196);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_197);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_199);
    }
        } 
        
    stringBuffer.append(TEXT_200);
    
				}
			}
		}
		
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_201);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_204);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_207);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_208);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_212);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_213);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_214);
     } 
    stringBuffer.append(TEXT_215);
    
		}
	/** end **/
		

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    
		}
	}

    stringBuffer.append(TEXT_218);
    return stringBuffer.toString();
  }
}
