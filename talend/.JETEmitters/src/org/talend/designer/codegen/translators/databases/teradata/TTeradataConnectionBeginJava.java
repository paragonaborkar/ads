package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.sql.Statement;

public class TTeradataConnectionBeginJava
{
  protected static String nl;
  public static synchronized TTeradataConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataConnectionBeginJava result = new TTeradataConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tString driverClass_";
  protected final String TEXT_2 = " = \"";
  protected final String TEXT_3 = "\";" + NL + "\t\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = NL + "\t\t\tSharedDBConnectionLog4j.initLogger(log,\"";
  protected final String TEXT_6 = "\");";
  protected final String TEXT_7 = NL + "\t\t\tString sharedConnectionName_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";" + NL + "\t\t\tconn_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ".getDBConnection(\"";
  protected final String TEXT_12 = "\",url_";
  protected final String TEXT_13 = ",dbUser_";
  protected final String TEXT_14 = " , dbPwd_";
  protected final String TEXT_15 = " , sharedConnectionName_";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\t\tconn_";
  protected final String TEXT_18 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_19 = ",dbUser_";
  protected final String TEXT_20 = ",dbPwd_";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_23 = " - Connection is set auto commit to '";
  protected final String TEXT_24 = "'.\");";
  protected final String TEXT_25 = NL + "\t\t\tconn_";
  protected final String TEXT_26 = ".setAutoCommit(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + "                if(log.is";
  protected final String TEXT_31 = "Enabled())";
  protected final String TEXT_32 = NL + "            log.";
  protected final String TEXT_33 = "(\"";
  protected final String TEXT_34 = " - \" ";
  protected final String TEXT_35 = " + (";
  protected final String TEXT_36 = ") ";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "    \tclass BytesLimit65535_";
  protected final String TEXT_39 = "{" + NL + "    \t\tpublic void limitLog4jByte() throws Exception{" + NL + "    \t\t\t";
  protected final String TEXT_40 = NL + "            StringBuilder ";
  protected final String TEXT_41 = " = new StringBuilder();";
  protected final String TEXT_42 = NL + "            ";
  protected final String TEXT_43 = ".append(\"Parameters:\");";
  protected final String TEXT_44 = NL + "                    ";
  protected final String TEXT_45 = ".append(\"";
  protected final String TEXT_46 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_47 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_48 = NL + "                    ";
  protected final String TEXT_49 = ".append(\"";
  protected final String TEXT_50 = "\" + \" = \" + ";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "                ";
  protected final String TEXT_53 = ".append(\" | \");";
  protected final String TEXT_54 = NL + "    \t\t}" + NL + "    \t}" + NL + "    \t" + NL + "        new BytesLimit65535_";
  protected final String TEXT_55 = "().limitLog4jByte();";
  protected final String TEXT_56 = NL + "            StringBuilder ";
  protected final String TEXT_57 = " = new StringBuilder();    ";
  protected final String TEXT_58 = NL + "                    ";
  protected final String TEXT_59 = ".append(";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL + "                    if(";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = " == null){";
  protected final String TEXT_65 = NL + "                        ";
  protected final String TEXT_66 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_67 = NL + "                        ";
  protected final String TEXT_68 = ".append(";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = ");" + NL + "                    }   ";
  protected final String TEXT_71 = NL + "                ";
  protected final String TEXT_72 = ".append(\"|\");";
  protected final String TEXT_73 = NL;
  protected final String TEXT_74 = NL + "\t\tString dbProperties_";
  protected final String TEXT_75 = " = ";
  protected final String TEXT_76 = ";" + NL + "\t\tString url_";
  protected final String TEXT_77 = " = null;" + NL + "\t\tif(dbProperties_";
  protected final String TEXT_78 = " == null || dbProperties_";
  protected final String TEXT_79 = ".trim().length() == 0) {" + NL + "\t\t\turl_";
  protected final String TEXT_80 = " = \"jdbc:teradata://\" + ";
  protected final String TEXT_81 = " + \"/DATABASE=\" + ";
  protected final String TEXT_82 = ";" + NL + "\t\t} else {" + NL + "\t\t    url_";
  protected final String TEXT_83 = " = \"jdbc:teradata://\" + ";
  protected final String TEXT_84 = " + \"/DATABASE=\" + ";
  protected final String TEXT_85 = " + \",\" + ";
  protected final String TEXT_86 = ";" + NL + "\t\t}";
  protected final String TEXT_87 = NL + NL + "\t";
  protected final String TEXT_88 = NL + NL + "\tString dbUser_";
  protected final String TEXT_89 = " = ";
  protected final String TEXT_90 = ";";
  protected final String TEXT_91 = NL + "\t" + NL + "\t";
  protected final String TEXT_92 = NL + "\t\tString dbPwd_";
  protected final String TEXT_93 = " = null;" + NL + "\t";
  protected final String TEXT_94 = NL + "\t\t";
  protected final String TEXT_95 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_96 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_99 = " = ";
  protected final String TEXT_100 = "; ";
  protected final String TEXT_101 = NL + "\t\tString dbPwd_";
  protected final String TEXT_102 = " = decryptedPassword_";
  protected final String TEXT_103 = ";" + NL + "\t";
  protected final String TEXT_104 = NL + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_105 = " = null;" + NL + "\t";
  protected final String TEXT_106 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_107 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_109 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_110 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_112 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_113 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_115 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_116 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_118 = " - Written records count: \" + nb_line_";
  protected final String TEXT_119 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_121 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_123 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_124 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_126 = " - Writing the record \" + nb_line_";
  protected final String TEXT_127 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_129 = " - Processing the record \" + nb_line_";
  protected final String TEXT_130 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_132 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_133 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_134 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_135 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_136 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_138 = " - Uses an existing connection ";
  protected final String TEXT_139 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_141 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_142 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_143 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_145 = NL + "\t\t\tconn_";
  protected final String TEXT_146 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_147 = ", dbUser_";
  protected final String TEXT_148 = ", dbPwd_";
  protected final String TEXT_149 = ");" + NL + "\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\tconn_";
  protected final String TEXT_151 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\tconn_";
  protected final String TEXT_153 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_154 = NL + "\t\t\tconn_";
  protected final String TEXT_155 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_156 = NL + "\t\t\t\tconn_";
  protected final String TEXT_157 = ".setAutoCommit(";
  protected final String TEXT_158 = ");" + NL + "\t\t\t";
  protected final String TEXT_159 = NL + "\t\t\t\tlog.";
  protected final String TEXT_160 = "(\"";
  protected final String TEXT_161 = " - \" + ";
  protected final String TEXT_162 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_163 = NL + "\t    \t\tlog.";
  protected final String TEXT_164 = "(\"";
  protected final String TEXT_165 = "\");" + NL + "\t\t\t";
  protected final String TEXT_166 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_167 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_168 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_169 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_170 = ": pstmt_";
  protected final String TEXT_171 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_172 = " += (countEach_";
  protected final String TEXT_173 = " < 0 ? 0 : ";
  protected final String TEXT_174 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_175 = NL + "\t";
  protected final String TEXT_176 = NL + "\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_177 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\tif (dataSources_";
  protected final String TEXT_178 = " == null) {";
  protected final String TEXT_179 = NL + "\t\t";
  protected final String TEXT_180 = NL + "\t\t";
  protected final String TEXT_181 = NL + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_182 = "\", conn_";
  protected final String TEXT_183 = ");";
  protected final String TEXT_184 = NL + "\t} else {" + NL + "\t\tString dsAlias_";
  protected final String TEXT_185 = " = ";
  protected final String TEXT_186 = ";" + NL + "\t\tif (dataSources_";
  protected final String TEXT_187 = ".get(dsAlias_";
  protected final String TEXT_188 = ") == null) {" + NL + "   \t\t\tthrow new Exception(\"No DataSource with alias: \" + dsAlias_";
  protected final String TEXT_189 = " + \" available!\");" + NL + "      \t}" + NL + "\t\tconn_";
  protected final String TEXT_190 = " = dataSources_";
  protected final String TEXT_191 = ".get(dsAlias_";
  protected final String TEXT_192 = ").getConnection();" + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_193 = "\", conn_";
  protected final String TEXT_194 = ");" + NL + "\t}";
  protected final String TEXT_195 = NL + "\tif (null != conn_";
  protected final String TEXT_196 = ") {" + NL + "\t\t";
  protected final String TEXT_197 = NL + "\t}";
  protected final String TEXT_198 = NL + NL + "\tglobalMap.put(\"conn_\" + \"";
  protected final String TEXT_199 = "\",conn_";
  protected final String TEXT_200 = ");" + NL + "\tglobalMap.put(\"host_";
  protected final String TEXT_201 = "\", ";
  protected final String TEXT_202 = ");" + NL + "\tglobalMap.put(\"dbname_";
  protected final String TEXT_203 = "\", ";
  protected final String TEXT_204 = ");" + NL + "\tglobalMap.put(\"username_";
  protected final String TEXT_205 = "\", dbUser_";
  protected final String TEXT_206 = ");" + NL + "\tglobalMap.put(\"password_";
  protected final String TEXT_207 = "\", dbPwd_";
  protected final String TEXT_208 = ");" + NL + "\tglobalMap.put(\"url_";
  protected final String TEXT_209 = "\", url_";
  protected final String TEXT_210 = ");";
  protected final String TEXT_211 = NL;
  protected final String TEXT_212 = NL + "             boolean currentAutoCommitMode";
  protected final String TEXT_213 = " =  conn_";
  protected final String TEXT_214 = ".getAutoCommit();" + NL + "             conn_";
  protected final String TEXT_215 = ".setAutoCommit(true);" + NL + "             try{";
  protected final String TEXT_216 = NL + "                           try{" + NL + "                               conn_";
  protected final String TEXT_217 = ".createStatement().execute(\"BEGIN QUERY LOGGING WITH SQL,OBJECTS ON \" + ";
  protected final String TEXT_218 = ");" + NL + "                           }catch(Exception e){" + NL + "                                 System.err.println(e.getMessage());" + NL + "                           }";
  protected final String TEXT_219 = NL + "                 conn_";
  protected final String TEXT_220 = ".createStatement().execute(" + NL + "              \"SET QUERY_BAND='\" +";
  protected final String TEXT_221 = NL + "               ";
  protected final String TEXT_222 = " + \"=\" + ";
  protected final String TEXT_223 = " + \";\" +";
  protected final String TEXT_224 = " \"' FOR SESSION\"" + NL + "           );" + NL + "              }catch(Exception e){" + NL + "               System.err.println(e.getMessage());" + NL + "      }" + NL + "      conn_";
  protected final String TEXT_225 = ".setAutoCommit(currentAutoCommitMode";
  protected final String TEXT_226 = ");";
  protected final String TEXT_227 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	class DefaultConnectionUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    protected boolean isLog4jEnabled;
	    
	    public void beforeComponentProcess(INode node){
	    }
	    
		public void createURL(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
		
		public void classForName(INode node){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
		}
		
		public void useShareConnection(INode node) {
			String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");
			String shareDBClass = "SharedDBConnection";
			if(isLog4jEnabled){
				shareDBClass = "SharedDBConnectionLog4j";

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(shareDBClass);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
		}
		
		public void createConnection(INode node) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
		}
		
		public void setAutoCommit(INode node) {
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_24);
    
			}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_27);
    
		}
		
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultUtil class
	
	DefaultConnectionUtil connUtil = new DefaultConnectionUtil();

    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_30);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_31);
    
            }
            
    stringBuffer.append(TEXT_32);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_34);
    for(String message : messages){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        debug(str("Start to work."));
    }
    
    public void endWork(){
        debug(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
    
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
       			 if(log4jEnabled){
       			 
    stringBuffer.append(TEXT_40);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_43);
    
            java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
            ignoredParamsTypes.addAll(
                java.util.Arrays.asList(
                    org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                    org.talend.core.model.process.EParameterFieldType.LABEL,
                    org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                    org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                    org.talend.core.model.process.EParameterFieldType.IMAGE,
                    org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                    org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                    org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                    org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                    org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                    org.talend.core.model.process.EParameterFieldType.VERSION,
                    org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                    org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                    org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                    org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                    org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                    org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                    org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                    )
            );
            for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                    continue;
                }
                String name = ep.getName();
                if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                    String epName = "__" + name + "__";
                    String password = "";
                    if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                        password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                    }else{
                        String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                        if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                            passwordValue = "\"\"";
                        } 
                        password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                    } 
                    
    stringBuffer.append(TEXT_44);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_47);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    
    stringBuffer.append(TEXT_48);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_51);
    
                }   
                
    stringBuffer.append(TEXT_52);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_53);
    
            }
        }
		debug(var("log4jParamters"));
		
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_56);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_57);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_58);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_61);
    
                }else{
                
    stringBuffer.append(TEXT_62);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_70);
    
                }
                
    stringBuffer.append(TEXT_71);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_72);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    stringBuffer.append(TEXT_73);
    
class DBConnLogUtil extends BasicLogUtil{
	
	private DBConnLogUtil(){}
	
	protected DBConnLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logJDBCDriver(String driverClass){
		debug(str("Driver ClassName: "), driverClass, str("."));
	}
	
	public void connTry(String url, String dbUser){
		if(dbUser != null){
			debug(str("Connection attempts to '"), url, str("' with the username '"), dbUser, str("'."));
		}else{
			debug(str("Connection attempts to '"), url, str("'."));
		}
	}
	
	public void connDone(String url){
		debug(str("Connection to '"), url, str("' has succeeded."));
	}
	
	public void useExistConn(String url, String dbUser){
		if(dbUser != null){
			debug(str("Uses an existing connection with username '"), dbUser, str("'. Connection URL: "), url, str("."));
		}else{
			debug(str("Uses an existing connection. Connection URL: "), url, str("."));
		}
	}
	
	public void closeTry(String connCompID){
		if(connCompID == null){
			debug(str("Closing the connection to the database."));
		}else{
			debug(str("Closing the connection "), connCompID, str(" to the database."));
		}
	}
	
	public void closeDone(String connCompID){
		if(connCompID == null){
			debug(str("Connection to the database has closed."));	
		}else{
			debug(str("Connection "), connCompID, str(" to the database has closed."));
		}
	}
}

class DBTableActionLogUtil extends BasicLogUtil{
	private DBTableActionLogUtil(){}
	
	protected DBTableActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void dropTry(String tableName){
		tableActionTry(tableName, str("Dropping"));
	}
	
	public void dropDone(String tableName){
		tableActionDone(tableName, str("Drop"));
	}
	
	public void createTry(String tableName){
		tableActionTry(tableName, str("Creating"));
	}
	
	public void createDone(String tableName){
		tableActionDone(tableName, str("Create"));
	}
	
	public void clearTry(String tableName){
		tableActionTry(tableName, str("Clearing"));
	}
	
	public void clearDone(String tableName){
		tableActionDone(tableName, str("Clear"));
	}
	
	public void truncateTry(String tableName){
		tableActionTry(tableName, str("Truncating"));
	}
	
	public void truncateDone(String tableName){
		tableActionDone(tableName, str("Truncate"));
	}
	
	public void truncateReuseStorageTry(String tableName){
		tableActionTry(tableName, str("Truncating reuse storage"));
	}
	
	public void truncateReuseStorageDone(String tableName){
		tableActionDone(tableName, str("Truncate reuse stroage"));
	}
	
	private void tableActionTry(String tableName, String action){
		debug(action, str(" table '"), tableName, str("'."));
	}
	
	private void tableActionDone(String tableName, String action){
		debug(action, str(" table '"), tableName, str("' has succeeded."));
	}
}

class DBCommitLogUtil extends BasicLogUtil{
	private DBCommitLogUtil(){}
	
	protected DBCommitLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logAutoCommit(String autoCommit){
		debug(str("Connection is set auto commit to '"), autoCommit, str("'."));
	}

	public void commitTry(String connCompID, String commitCount){
		if(commitCount == null && connCompID == null){
			debug(str("Connection starting to commit."));
		}else if(commitCount == null){
			debug(str("Connection "), connCompID, str(" starting to commit."));	
		}else if(connCompID == null){
			debug(str("Connection starting to commit "), commitCount, str(" record(s)."));
		}else{
			debug(str("Connection "), connCompID, str(" starting to commit "), commitCount, str(" record(s)."));
		}
	}
	
	public void commitDone(String connCompID){
		if(connCompID == null){
			debug(str("Connection commit has succeeded."));
		}else{
			debug(str("Connection "), connCompID, (" commit has succeeded."));
		}
	}
}

class DBBatchLogUtil extends BasicLogUtil{
	private DBBatchLogUtil(){}
	
	protected DBBatchLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void executeTry(String action){
		debug(str("Executing the "), action, str(" batch."));
	}
	
	public void executeDone(String action){
		debug(str("The "), action, str(" batch execution has succeeded."));
	}
}

class DBDataActionLogUtil extends BasicLogUtil{
	private DBDataActionLogUtil(){}
	
	protected DBDataActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void inserting(String nbline){
		sqlAction(nbline, str("Inserting"));
	}
	
	public void deleting(String nbline){
		sqlAction(nbline, str("Deleting"));
	}
	
	public void updating(String nbline){
		sqlAction(nbline, str("Updating"));
	}
	
	public void replacing(String nbline){
		sqlAction(nbline, str("Replacing"));
	}
	
	public void insertingOnDuplicateKeyUpdating(String nbline){
		sqlAction(nbline, str("Inserting on duplicate key updating"));
	}
	
	public void insertingIgnore(String nbline){
		sqlAction(nbline, str("Inserting ignore"));
	}
	
	private void sqlAction(String nbline, String action){
		if(nbline == null){
			debug(action, str(" the record."));
		}else{
			debug(action, str(" the record "), nbline, str("."));
		}
	}
	
	public void sqlExecuteTry(String sql){
		debug(str("Executing '"), sql, str("'."));
	}
	
	public void sqlExecuteDone(String sql){
		debug(str("Execute '"), sql, str("' has succeeded."));
	}

	public void addingToBatch(String nbline, String batchAction){
		debug(str("Adding the record "), nbline, str(" to the "), batchAction, str(" batch."));
	}
}

class DBStateLogUtil extends BasicLogUtil{
	private DBStateLogUtil(){}
	
	protected DBStateLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logInsertedLines(String nbline){
		logFinishedLines(nbline, str("inserted"));
	}
	
	public void logUpdatedLines(String nbline){
		logFinishedLines(nbline, str("updated"));
	}
	
	public void logDeletedLines(String nbline){
		logFinishedLines(nbline, str("deleted"));
	}
	
	public void logRejectedLines(String nbline){
		logFinishedLines(nbline, str("rejected"));
	}
	
	private void logFinishedLines(String nbline, String action){
		debug(str("Has "), action, str(" "), nbline, str(" record(s)."));
	}
}	
class DBLogUtil extends LogUtil{
	DBConnLogUtil conn = null;
	DBTableActionLogUtil table = null;
	DBCommitLogUtil commit = null;
	DBBatchLogUtil batch = null;
	DBDataActionLogUtil data = null;
	DBStateLogUtil state = null;
	private DBLogUtil(){}
	
	protected DBLogUtil(org.talend.core.model.process.INode node){
		super(node);
		conn = new DBConnLogUtil(node);
    	table = new DBTableActionLogUtil(node);
    	commit = new DBCommitLogUtil(node);
    	batch = new DBBatchLogUtil(node);
    	data = new DBDataActionLogUtil(node);
    	state = new DBStateLogUtil(node);
	}
	
	public DBConnLogUtil conn(){
		return conn;
	}
	
	public DBTableActionLogUtil table(){
		return table;
	}
	
	public DBCommitLogUtil commit(){
		return commit;
	}
	
	public DBBatchLogUtil batch(){
		return batch;
	}
	
	public DBDataActionLogUtil data(){
		return data;
	}
	
	public DBStateLogUtil state(){
		return state;
	}
}
DBLogUtil dbLog = null;

    
   	 CodeGeneratorArgument codeGenArgumentX = (CodeGeneratorArgument) argument;
	 INode nodeX = (INode)codeGenArgumentX.getArgument();
	 dbLog = new DBLogUtil(nodeX);
  
    
	class ConnectionUtil extends DefaultConnectionUtil{

		public void createURL(INode node) {
			super.createURL(node);

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_86);
    
		}

		public String getDirverClassName(INode node){
			return "com.teradata.jdbc.TeraDriver";
		}

	}//end class
	connUtil = new ConnectionUtil();

    //----------------------------component codes-----------------------------------------
    stringBuffer.append(TEXT_87);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    if(dbschema == null||dbschema.trim().length()==0) {
    	 dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
    }
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");
    String dbpass = ElementParameterParser.getValue(node, "__PASS__");
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    
	boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_SHARED_CONNECTION__"));

    
	connUtil.beforeComponentProcess(node);
	connUtil.createURL(node);

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append((dbuser != null && dbuser.trim().length() == 0)? "null":dbuser);
    stringBuffer.append(TEXT_90);
    //the tSQLiteConnection component not contain user and pass return null
    stringBuffer.append(TEXT_91);
    if(dbpass != null && dbpass.trim().length() == 0) {
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    } else {
		String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_94);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_97);
    } else {
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_100);
    }
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
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
			
    stringBuffer.append(TEXT_106);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_107);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_108);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_111);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_114);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_117);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_122);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_124);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_125);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_128);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_131);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    
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
			
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    if (cid.startsWith("tImpala") || cid.startsWith("tHive")) {
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_139);
    } else {
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
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
			
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
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
			
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
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
			
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_158);
    
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
	    	
    stringBuffer.append(TEXT_159);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_162);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_163);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_165);
    
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
			
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_174);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	if(isUseSharedConnection){

    stringBuffer.append(TEXT_175);
    connUtil.useShareConnection(node);
    
	} else {
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    
		}

    stringBuffer.append(TEXT_179);
    connUtil.classForName(node);
    stringBuffer.append(TEXT_180);
    
		log4jCodeGenerateUtil.debugConnectionParams(node);
		log4jCodeGenerateUtil.connect_begin();
		connUtil.createConnection(node);
		log4jCodeGenerateUtil.connect_end();
		
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
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
    
		}
	}

    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    connUtil.setAutoCommit(node);
    stringBuffer.append(TEXT_197);
    
	connUtil.afterComponentProcess(node);

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(dbname);
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
    //only for log4j
    stringBuffer.append(TEXT_211);
    
      boolean queryBand = "true".equals(ElementParameterParser.getValue(node, "__QUERY_BAND__"));
      boolean activateQueryLogging = "true".equals(ElementParameterParser.getValue(node, "__ACTIVATE_QUERY_LOGGING__"));
      String usrName = ElementParameterParser.getValue(node, "__USER__");
      List<Map<String, String>> queryBandList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__QUERY_BAND_PARAMETERS__");
      if(queryBand){
    stringBuffer.append(TEXT_212);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
                    if(activateQueryLogging){
                        
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append( usrName );
    stringBuffer.append(TEXT_218);
    
                    }
                  
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
            for(Map<String, String> map : queryBandList) {

    stringBuffer.append(TEXT_221);
    stringBuffer.append( map.get("KEY") );
    stringBuffer.append(TEXT_222);
    stringBuffer.append( map.get("VALUE") );
    stringBuffer.append(TEXT_223);
    
            }

    stringBuffer.append(TEXT_224);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_226);
    }
    stringBuffer.append(TEXT_227);
    return stringBuffer.toString();
  }
}
