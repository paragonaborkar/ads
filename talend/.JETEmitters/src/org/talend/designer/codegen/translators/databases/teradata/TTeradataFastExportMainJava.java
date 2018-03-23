package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TTeradataFastExportMainJava
{
  protected static String nl;
  public static synchronized TTeradataFastExportMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataFastExportMainJava result = new TTeradataFastExportMainJava();
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
  protected final String TEXT_29 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_30 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_31 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_33 = " - Uses an existing connection ";
  protected final String TEXT_34 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_36 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_37 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_38 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\tconn_";
  protected final String TEXT_41 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_42 = ", dbUser_";
  protected final String TEXT_43 = ", dbPwd_";
  protected final String TEXT_44 = ");" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\tconn_";
  protected final String TEXT_46 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\tconn_";
  protected final String TEXT_48 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\tconn_";
  protected final String TEXT_50 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\tconn_";
  protected final String TEXT_52 = ".setAutoCommit(";
  protected final String TEXT_53 = ");" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\tlog.";
  protected final String TEXT_55 = "(\"";
  protected final String TEXT_56 = " - \" + ";
  protected final String TEXT_57 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t    \t\tlog.";
  protected final String TEXT_59 = "(\"";
  protected final String TEXT_60 = "\");" + NL + "\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_62 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_64 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_65 = ": pstmt_";
  protected final String TEXT_66 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_67 = " += (countEach_";
  protected final String TEXT_68 = " < 0 ? 0 : ";
  protected final String TEXT_69 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_70 = NL + "   String runtimeFileSep_";
  protected final String TEXT_71 = " = System.getProperty(\"file.separator\");" + NL + "   String runtimeLineSep_";
  protected final String TEXT_72 = " = System.getProperty(\"line.separator\");" + NL + "   boolean runOnWindows_";
  protected final String TEXT_73 = " = \"\\\\\".equals(runtimeFileSep_";
  protected final String TEXT_74 = ");" + NL + "" + NL + "   java.util.Map<String,String> fileSeparatorMapping_";
  protected final String TEXT_75 = " = new java.util.HashMap<>();" + NL + "   fileSeparatorMapping_";
  protected final String TEXT_76 = ".put(\"\\\\\", \"/\");" + NL + "   fileSeparatorMapping_";
  protected final String TEXT_77 = ".put(\"/\", \"\\\\\");" + NL + "" + NL + "   String scriptPath_";
  protected final String TEXT_78 = " = ";
  protected final String TEXT_79 = ";" + NL + "   String exportedFile_";
  protected final String TEXT_80 = " = ";
  protected final String TEXT_81 = ";" + NL + "   String errorFile_";
  protected final String TEXT_82 = " = ";
  protected final String TEXT_83 = ";" + NL + "   if(!(scriptPath_";
  protected final String TEXT_84 = ".endsWith(\"\\\\\") || scriptPath_";
  protected final String TEXT_85 = ".endsWith(\"/\"))){" + NL + "       scriptPath_";
  protected final String TEXT_86 = " = scriptPath_";
  protected final String TEXT_87 = " + java.io.File.separator;" + NL + "   }" + NL + "   scriptPath_";
  protected final String TEXT_88 = " = scriptPath_";
  protected final String TEXT_89 = ".replace(" + NL + "                                                         fileSeparatorMapping_";
  protected final String TEXT_90 = ".get(runtimeFileSep_";
  protected final String TEXT_91 = ")" + NL + "                                                         , runtimeFileSep_";
  protected final String TEXT_92 = ");" + NL + "   exportedFile_";
  protected final String TEXT_93 = " = exportedFile_";
  protected final String TEXT_94 = ".replace(" + NL + "                                                         fileSeparatorMapping_";
  protected final String TEXT_95 = ".get(runtimeFileSep_";
  protected final String TEXT_96 = ")" + NL + "                                                         , runtimeFileSep_";
  protected final String TEXT_97 = ");" + NL + "   errorFile_";
  protected final String TEXT_98 = " = errorFile_";
  protected final String TEXT_99 = ".replace(" + NL + "                                                         fileSeparatorMapping_";
  protected final String TEXT_100 = ".get(runtimeFileSep_";
  protected final String TEXT_101 = ")" + NL + "                                                         , runtimeFileSep_";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "         java.nio.file.Path pathScriptDir_";
  protected final String TEXT_104 = " = java.nio.file.FileSystems.getDefault().getPath(scriptPath_";
  protected final String TEXT_105 = ");" + NL + "         if(!java.nio.file.Files.exists(pathScriptDir_";
  protected final String TEXT_106 = ", java.nio.file.LinkOption.NOFOLLOW_LINKS)){" + NL + "            java.nio.file.Files.createDirectories(pathScriptDir_";
  protected final String TEXT_107 = ");" + NL + "         }" + NL + "" + NL + "         java.nio.file.Path pathExportedFile_";
  protected final String TEXT_108 = " = java.nio.file.FileSystems.getDefault().getPath(exportedFile_";
  protected final String TEXT_109 = ");" + NL + "         if(!java.nio.file.Files.exists(pathExportedFile_";
  protected final String TEXT_110 = ", java.nio.file.LinkOption.NOFOLLOW_LINKS)){" + NL + "            java.nio.file.Files.createDirectories(pathExportedFile_";
  protected final String TEXT_111 = ".getParent());" + NL + "         }" + NL + "" + NL + "         java.nio.file.Path pathErrorFile_";
  protected final String TEXT_112 = " = java.nio.file.FileSystems.getDefault().getPath(errorFile_";
  protected final String TEXT_113 = ");" + NL + "         if(!java.nio.file.Files.exists(pathErrorFile_";
  protected final String TEXT_114 = ", java.nio.file.LinkOption.NOFOLLOW_LINKS)){" + NL + "            java.nio.file.Files.createDirectories(pathErrorFile_";
  protected final String TEXT_115 = ".getParent());" + NL + "         }";
  protected final String TEXT_116 = NL;
  protected final String TEXT_117 = NL + "    String tableFullName_";
  protected final String TEXT_118 = " = ";
  protected final String TEXT_119 = " + \".\" + ";
  protected final String TEXT_120 = ";" + NL + "    String generatedScriptPath_";
  protected final String TEXT_121 = " = scriptPath_";
  protected final String TEXT_122 = " + ";
  protected final String TEXT_123 = " +\".script\";" + NL + "    java.io.File file_";
  protected final String TEXT_124 = " = new java.io.File(generatedScriptPath_";
  protected final String TEXT_125 = ");" + NL + "try{" + NL + "    java.io.FileWriter fw_";
  protected final String TEXT_126 = " = new java.io.FileWriter(file_";
  protected final String TEXT_127 = ");" + NL + "    StringBuilder script_";
  protected final String TEXT_128 = " = new StringBuilder();" + NL + "    fw_";
  protected final String TEXT_129 = ".write(\".LOGTABLE \"+";
  protected final String TEXT_130 = "+\".\"+";
  protected final String TEXT_131 = "+\";\" + runtimeLineSep_";
  protected final String TEXT_132 = ");" + NL;
  protected final String TEXT_133 = NL;
  protected final String TEXT_134 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_135 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_138 = " = ";
  protected final String TEXT_139 = "; ";
  protected final String TEXT_140 = NL + NL + "    fw_";
  protected final String TEXT_141 = ".write(\".LOGON \"+";
  protected final String TEXT_142 = "+\"/\"";
  protected final String TEXT_143 = " \"\" ";
  protected final String TEXT_144 = "+";
  protected final String TEXT_145 = "+\",\"+decryptedPassword_";
  protected final String TEXT_146 = "+\";\"+ runtimeLineSep_";
  protected final String TEXT_147 = ");" + NL;
  protected final String TEXT_148 = NL + "    fw_";
  protected final String TEXT_149 = ".write(\".BEGIN EXPORT SESSIONS 8;\"+runtimeLineSep_";
  protected final String TEXT_150 = ");";
  protected final String TEXT_151 = NL + "        fw_";
  protected final String TEXT_152 = ".write(\"SELECT ";
  protected final String TEXT_153 = "CAST(('' ||";
  protected final String TEXT_154 = "\"+runtimeLineSep_";
  protected final String TEXT_155 = ");";
  protected final String TEXT_156 = NL + "                    fw_";
  protected final String TEXT_157 = ".write(\"TRIM(COALESCE(CAST(";
  protected final String TEXT_158 = " AS CHAR(";
  protected final String TEXT_159 = ")),'')) || '\"+";
  protected final String TEXT_160 = "+\"' ||\"+runtimeLineSep_";
  protected final String TEXT_161 = ");";
  protected final String TEXT_162 = NL + "                    fw_";
  protected final String TEXT_163 = ".write(\"cast( ";
  protected final String TEXT_164 = " as CHAR(";
  protected final String TEXT_165 = ")),\"+runtimeLineSep_";
  protected final String TEXT_166 = ");";
  protected final String TEXT_167 = NL + "                    fw_";
  protected final String TEXT_168 = ".write(\"TRIM(COALESCE(CAST(";
  protected final String TEXT_169 = " AS VARCHAR(";
  protected final String TEXT_170 = ")),''))) AS CHAR(";
  protected final String TEXT_171 = "))\"+runtimeLineSep_";
  protected final String TEXT_172 = ");";
  protected final String TEXT_173 = NL + "                    fw_";
  protected final String TEXT_174 = ".write(\"cast( ";
  protected final String TEXT_175 = " as CHAR(";
  protected final String TEXT_176 = "))\"+runtimeLineSep_";
  protected final String TEXT_177 = ");";
  protected final String TEXT_178 = NL + NL + "        fw_";
  protected final String TEXT_179 = ".write(\"FROM \"+ ";
  protected final String TEXT_180 = " + \".\" + ";
  protected final String TEXT_181 = "+\";\"+runtimeLineSep_";
  protected final String TEXT_182 = ");";
  protected final String TEXT_183 = NL + "        fw_";
  protected final String TEXT_184 = ".write(";
  protected final String TEXT_185 = " +\";\"+runtimeLineSep_";
  protected final String TEXT_186 = ");";
  protected final String TEXT_187 = NL;
  protected final String TEXT_188 = NL + "    fw_";
  protected final String TEXT_189 = ".write(\".EXPORT OUTFILE \\\"\"+ exportedFile_";
  protected final String TEXT_190 = " +\"\\\" FORMAT TEXT mode record;\"+runtimeLineSep_";
  protected final String TEXT_191 = ");" + NL + "    fw_";
  protected final String TEXT_192 = ".write(\".END EXPORT;\"+runtimeLineSep_";
  protected final String TEXT_193 = ");" + NL + "    fw_";
  protected final String TEXT_194 = ".write(\".LOGOFF;\"+runtimeLineSep_";
  protected final String TEXT_195 = ");" + NL;
  protected final String TEXT_196 = NL + "    fw_";
  protected final String TEXT_197 = ".close();" + NL;
  protected final String TEXT_198 = NL + "    String[] strArr_";
  protected final String TEXT_199 = " = new String[3];" + NL + "    String expCmd_";
  protected final String TEXT_200 = " = null;" + NL + "    if(runOnWindows_";
  protected final String TEXT_201 = "){" + NL + "        expCmd_";
  protected final String TEXT_202 = " = \"fexp < \\\"\"+ generatedScriptPath_";
  protected final String TEXT_203 = " + \"\\\" > \\\"\"+errorFile_";
  protected final String TEXT_204 = "+\"\\\" 2>&1\";" + NL + "        strArr_";
  protected final String TEXT_205 = "[0] = \"cmd\";" + NL + "        strArr_";
  protected final String TEXT_206 = "[1] = \"/c\";" + NL + "    }else{" + NL + "        expCmd_";
  protected final String TEXT_207 = " = \"fexp < \"+ generatedScriptPath_";
  protected final String TEXT_208 = " + \" > \\\"\"+errorFile_";
  protected final String TEXT_209 = "+\"\\\" 2>&1\";" + NL + "        strArr_";
  protected final String TEXT_210 = "[0] = \"sh\";" + NL + "        strArr_";
  protected final String TEXT_211 = "[1] = \"-c\";" + NL + "    }" + NL + "        strArr_";
  protected final String TEXT_212 = "[2] = expCmd_";
  protected final String TEXT_213 = ";" + NL;
  protected final String TEXT_214 = NL + "        log.info(\"";
  protected final String TEXT_215 = " - Executing command '\" + expCmd_";
  protected final String TEXT_216 = " + \"'.\");";
  protected final String TEXT_217 = NL + "    final Process process_";
  protected final String TEXT_218 = " = Runtime.getRuntime().exec(strArr_";
  protected final String TEXT_219 = ");" + NL + "" + NL + "    Thread normal_";
  protected final String TEXT_220 = " = new Thread() {" + NL + "        public void run() {" + NL + "            try {" + NL + "                java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_221 = ".getInputStream()));" + NL + "                String line = \"\";" + NL + "" + NL + "                try {" + NL + "                    while((line = reader.readLine()) != null) {" + NL + "                        System.out.println(line);" + NL + "                    }" + NL + "                } finally {" + NL + "                     reader.close();" + NL + "                }" + NL + "            }catch(java.io.IOException ioe) {";
  protected final String TEXT_222 = NL + "                ioe.printStackTrace();" + NL + "            }" + NL + "        }" + NL + "    };" + NL + "    normal_";
  protected final String TEXT_223 = ".start();" + NL + "" + NL + "    Thread error_";
  protected final String TEXT_224 = " = new Thread() {" + NL + "        public void run() {" + NL + "            try {" + NL + "                java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_225 = ".getErrorStream()));" + NL + "                String line = \"\";" + NL + "                try {" + NL + "                    while((line = reader.readLine()) != null) {" + NL + "                        System.err.println(line);" + NL + "                    }" + NL + "                } finally {" + NL + "                    reader.close();" + NL + "                }" + NL + "            } catch(java.io.IOException ioe) {";
  protected final String TEXT_226 = NL + "               ioe.printStackTrace();" + NL + "            }" + NL + "        }" + NL + "    };" + NL + "    error_";
  protected final String TEXT_227 = ".start();" + NL + "    process_";
  protected final String TEXT_228 = ".waitFor();" + NL + "    normal_";
  protected final String TEXT_229 = ".interrupt();" + NL + "    error_";
  protected final String TEXT_230 = ".interrupt();" + NL;
  protected final String TEXT_231 = NL + "           if(process_";
  protected final String TEXT_232 = ".exitValue() != 0){" + NL + "                throw new RuntimeException(\"The subprocess terminated unnormally.\");" + NL + "           }";
  protected final String TEXT_233 = NL;
  protected final String TEXT_234 = NL + "        log.info(\"";
  protected final String TEXT_235 = " - Excute '\" + expCmd_";
  protected final String TEXT_236 = " + \"' has finished.\");";
  protected final String TEXT_237 = NL + "}finally{" + NL + "    file_";
  protected final String TEXT_238 = ".delete();" + NL + "}";
  protected final String TEXT_239 = NL;

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
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    if (cid.startsWith("tImpala") || cid.startsWith("tHive")) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_34);
    } else {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
			connect_end();
		}

		public void connect_begin(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"debug",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"debug",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_53);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_54);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_57);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_58);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_60);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_69);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String host = ElementParameterParser.getValue(node, "__HOST__");
String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser= ElementParameterParser.getValue(node, "__USER__");

String table= ElementParameterParser.getValue(node, "__TABLE__");
String logDB = ElementParameterParser.getValue(node, "__LOG_DB__");
String logTable = ElementParameterParser.getValue(node, "__LOG_TABLE__");

boolean needHost = ("".equals(host) || "\"\"".equals(host)) ? false : true;
        logDB = ("".equals(logDB) || "\"\"".equals(logDB)) ? dbname : logDB;
        logTable = ("".equals(logTable) || "\"\"".equals(logTable)) ? table + "+\"_lt\"" : logTable;

boolean useQuery = "true".equals(ElementParameterParser.getValue(node, "__USE_QUERY__"));
String query = ElementParameterParser.getValue(node, "__QUERY__");
       query = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(query);

String scriptPath= ElementParameterParser.getValue(node, "__SCRIPT_PATH__");
String exportedFile= ElementParameterParser.getValue(node, "__EXPORTED_FILE__");
String separator= ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");
String errorFile= ElementParameterParser.getValue(node, "__ERROR_FILE__");

boolean createDirsWhenNeeded = "true".equals(ElementParameterParser.getValue(node, "__CREATE_DIRECTORIES_WHEN_NEEDED__"));
boolean dieWhenUnnormalTerminated = "true".equals(ElementParameterParser.getValue(node, "__DIE_WHEN_UNNORMAL_TERMINATED__"));


    stringBuffer.append(TEXT_70);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append( scriptPath );
    stringBuffer.append(TEXT_79);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( exportedFile );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append( errorFile );
    stringBuffer.append(TEXT_83);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_102);
    
      if(createDirsWhenNeeded){
      
    stringBuffer.append(TEXT_103);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_115);
    
      }
      
    stringBuffer.append(TEXT_116);
    
List<IMetadataColumn> columnList = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        columnList = metadata.getListColumns();
    }
}
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_120);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(logDB);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(logTable);
    stringBuffer.append(TEXT_131);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_132);
    
    String passwordFieldName = "__PASS__";
    
    stringBuffer.append(TEXT_133);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_136);
    } else {
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    if(needHost) {
    stringBuffer.append(host);
    stringBuffer.append(TEXT_142);
    } else {
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_147);
    //Layout---------------------------------------------------------------
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_150);
    if(!useQuery) {
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    if(separator.length()>0 && !"\"\"".equals(separator)){
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_155);
    
        if(columnList!=null){
            int counter = 1;
            int columnsLength = 0;
            for(IMetadataColumn column:columnList){
                if( columnList.size() != counter){
                    if(separator.length()>0 && !"\"\"".equals(separator)){
                        columnsLength+=(column.getLength()==null?0:column.getLength())+separator.length();
                
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_160);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_161);
    }else{
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_164);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_165);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_166);
    }
    
                } else {
                    if(separator.length()>0 && !"\"\"".equals(separator)){
                        columnsLength+=(column.getLength()==null?0:column.getLength())+1;
            
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_169);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(columnsLength);
    stringBuffer.append(TEXT_171);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_172);
    }else{
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_176);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_177);
    }
     }
                counter++;
            }
        }
        
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_181);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_182);
    } else {
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_185);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
    //Export file----------------------------------------------------------
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_195);
    //write script to file-------------------------------------------------
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    //run fexp command----------------------------------------------------
    stringBuffer.append(TEXT_198);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_213);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_216);
    }
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    log4jCodeGenerateUtil.logError(node,"error","ioe");
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    log4jCodeGenerateUtil.logError(node,"error","ioe");
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    
        if(dieWhenUnnormalTerminated){
        
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    
        }
     
    stringBuffer.append(TEXT_233);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_236);
    }
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(TEXT_239);
    return stringBuffer.toString();
  }
}
