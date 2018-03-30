package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TOracleConnectionBeginJava
{
  protected static String nl;
  public static synchronized TOracleConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleConnectionBeginJava result = new TOracleConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\tString driverClass_";
  protected final String TEXT_3 = " = \"";
  protected final String TEXT_4 = "\";" + NL + "\t\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\t\t\tSharedDBConnectionLog4j.initLogger(log,\"";
  protected final String TEXT_7 = "\");";
  protected final String TEXT_8 = NL + "\t\t\tString sharedConnectionName_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = ";" + NL + "\t\t\tconn_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ".getDBConnection(\"";
  protected final String TEXT_13 = "\",url_";
  protected final String TEXT_14 = ",dbUser_";
  protected final String TEXT_15 = " , dbPwd_";
  protected final String TEXT_16 = " , sharedConnectionName_";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\tconn_";
  protected final String TEXT_19 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_20 = ",dbUser_";
  protected final String TEXT_21 = ",dbPwd_";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Connection is set auto commit to '";
  protected final String TEXT_25 = "'.\");";
  protected final String TEXT_26 = NL + "\t\t\tconn_";
  protected final String TEXT_27 = ".setAutoCommit(";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "        String url_";
  protected final String TEXT_30 = " = ";
  protected final String TEXT_31 = ";";
  protected final String TEXT_32 = NL + "        String url_";
  protected final String TEXT_33 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_34 = " + \":\" + ";
  protected final String TEXT_35 = " + \":\" + ";
  protected final String TEXT_36 = ";";
  protected final String TEXT_37 = NL + "        String url_";
  protected final String TEXT_38 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_39 = " + \")(port=\" + ";
  protected final String TEXT_40 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_41 = " + \")))\";";
  protected final String TEXT_42 = NL + "        String url_";
  protected final String TEXT_43 = " = \"jdbc:oracle:oci8:@\" + ";
  protected final String TEXT_44 = ";";
  protected final String TEXT_45 = NL + "\t\t\tString url_";
  protected final String TEXT_46 = "=";
  protected final String TEXT_47 = ";" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "    \tglobalMap.put(\"connectionType_\" + \"";
  protected final String TEXT_49 = "\", \"";
  protected final String TEXT_50 = "\");";
  protected final String TEXT_51 = NL + "\t\t\tSharedDBConnectionLog4j.initLogger(log,\"";
  protected final String TEXT_52 = "\");";
  protected final String TEXT_53 = NL + "\t\tString sharedConnectionName_";
  protected final String TEXT_54 = " = ";
  protected final String TEXT_55 = ";";
  protected final String TEXT_56 = NL + "\t\t\tconn_";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = ".getDBConnection(\"";
  protected final String TEXT_59 = "\",url_";
  protected final String TEXT_60 = ",sharedConnectionName_";
  protected final String TEXT_61 = ");" + NL;
  protected final String TEXT_62 = NL + NL + "\t\t\t\tconn_";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = ".getDBConnection(\"";
  protected final String TEXT_65 = "\",url_";
  protected final String TEXT_66 = ",dbUser_";
  protected final String TEXT_67 = " , dbPwd_";
  protected final String TEXT_68 = " , sharedConnectionName_";
  protected final String TEXT_69 = ");" + NL;
  protected final String TEXT_70 = NL + "\t\t\tconn_";
  protected final String TEXT_71 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + "\t\t\tconn_";
  protected final String TEXT_74 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_75 = ",dbUser_";
  protected final String TEXT_76 = ",dbPwd_";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = NL + "\t\t\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_79 = " = new java.util.Properties();" + NL + "\t\t\tatnParamsPrope_";
  protected final String TEXT_80 = ".put(\"user\",dbUser_";
  protected final String TEXT_81 = ");" + NL + "\t\t\tatnParamsPrope_";
  protected final String TEXT_82 = ".put(\"password\",dbPwd_";
  protected final String TEXT_83 = ");" + NL + "\t\t\tif(";
  protected final String TEXT_84 = " != null && !\"\\\"\\\"\".equals(";
  protected final String TEXT_85 = ") && !\"\".equals(";
  protected final String TEXT_86 = ")){" + NL + "                atnParamsPrope_";
  protected final String TEXT_87 = ".load(new java.io.ByteArrayInputStream(";
  protected final String TEXT_88 = ".replace(\"&\", \"\\n\").getBytes()));" + NL + "            }" + NL + "\t\t\tconn_";
  protected final String TEXT_89 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_90 = ", atnParamsPrope_";
  protected final String TEXT_91 = ");";
  protected final String TEXT_92 = NL + "        globalMap.put(\"localServiceName_\" + \"";
  protected final String TEXT_93 = "\",";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "        globalMap.put(\"rac_url_\" + \"";
  protected final String TEXT_96 = "\", ";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "        globalMap.put(\"host_\" + \"";
  protected final String TEXT_99 = "\",";
  protected final String TEXT_100 = ");" + NL + "        globalMap.put(\"port_\" + \"";
  protected final String TEXT_101 = "\",";
  protected final String TEXT_102 = ");" + NL + "        globalMap.put(\"dbname_\" + \"";
  protected final String TEXT_103 = "\",";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + NL + "\t";
  protected final String TEXT_106 = NL + NL + "\tString dbUser_";
  protected final String TEXT_107 = " = ";
  protected final String TEXT_108 = ";";
  protected final String TEXT_109 = NL + "\t" + NL + "\t";
  protected final String TEXT_110 = NL + "\t\tString dbPwd_";
  protected final String TEXT_111 = " = null;" + NL + "\t";
  protected final String TEXT_112 = NL + "\t\t";
  protected final String TEXT_113 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_114 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_115 = ");";
  protected final String TEXT_116 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_117 = " = ";
  protected final String TEXT_118 = "; ";
  protected final String TEXT_119 = NL + "\t\tString dbPwd_";
  protected final String TEXT_120 = " = decryptedPassword_";
  protected final String TEXT_121 = ";" + NL + "\t";
  protected final String TEXT_122 = NL + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_123 = " = null;" + NL + "\t";
  protected final String TEXT_124 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_125 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_127 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_128 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_129 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_130 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_131 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_132 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_133 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_134 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_136 = " - Written records count: \" + nb_line_";
  protected final String TEXT_137 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_139 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_141 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_142 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_144 = " - Writing the record \" + nb_line_";
  protected final String TEXT_145 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_147 = " - Processing the record \" + nb_line_";
  protected final String TEXT_148 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_149 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_150 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_151 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_153 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_154 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_155 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_156 = " - Uses an existing connection ";
  protected final String TEXT_157 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_159 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_160 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_161 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_162 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_163 = NL + "\t\t\tconn_";
  protected final String TEXT_164 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_165 = ", dbUser_";
  protected final String TEXT_166 = ", dbPwd_";
  protected final String TEXT_167 = ");" + NL + "\t\t\t";
  protected final String TEXT_168 = NL + "\t\t\tconn_";
  protected final String TEXT_169 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_170 = NL + "\t\t\tconn_";
  protected final String TEXT_171 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_172 = NL + "\t\t\tconn_";
  protected final String TEXT_173 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_174 = NL + "\t\t\t\tconn_";
  protected final String TEXT_175 = ".setAutoCommit(";
  protected final String TEXT_176 = ");" + NL + "\t\t\t";
  protected final String TEXT_177 = NL + "\t\t\t\tlog.";
  protected final String TEXT_178 = "(\"";
  protected final String TEXT_179 = " - \" + ";
  protected final String TEXT_180 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_181 = NL + "\t    \t\tlog.";
  protected final String TEXT_182 = "(\"";
  protected final String TEXT_183 = "\");" + NL + "\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_185 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_186 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_187 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_188 = ": pstmt_";
  protected final String TEXT_189 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_190 = " += (countEach_";
  protected final String TEXT_191 = " < 0 ? 0 : ";
  protected final String TEXT_192 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_193 = NL + "\t";
  protected final String TEXT_194 = NL + "\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_195 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\tif (dataSources_";
  protected final String TEXT_196 = " == null) {";
  protected final String TEXT_197 = NL + "\t\t";
  protected final String TEXT_198 = NL + "\t\t";
  protected final String TEXT_199 = NL + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_200 = "\", conn_";
  protected final String TEXT_201 = ");";
  protected final String TEXT_202 = NL + "\t} else {" + NL + "\t\tString dsAlias_";
  protected final String TEXT_203 = " = ";
  protected final String TEXT_204 = ";" + NL + "\t\tif (dataSources_";
  protected final String TEXT_205 = ".get(dsAlias_";
  protected final String TEXT_206 = ") == null) {" + NL + "   \t\t\tthrow new Exception(\"No DataSource with alias: \" + dsAlias_";
  protected final String TEXT_207 = " + \" available!\");" + NL + "      \t}" + NL + "\t\tconn_";
  protected final String TEXT_208 = " = dataSources_";
  protected final String TEXT_209 = ".get(dsAlias_";
  protected final String TEXT_210 = ").getConnection();" + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_211 = "\", conn_";
  protected final String TEXT_212 = ");" + NL + "\t}";
  protected final String TEXT_213 = NL + "\tif (null != conn_";
  protected final String TEXT_214 = ") {" + NL + "\t\t";
  protected final String TEXT_215 = NL + "\t}";
  protected final String TEXT_216 = NL + NL + "\tglobalMap.put(\"conn_\" + \"";
  protected final String TEXT_217 = "\",conn_";
  protected final String TEXT_218 = ");";
  protected final String TEXT_219 = NL + "  \tglobalMap.put(\"dbschema_\" + \"";
  protected final String TEXT_220 = "\",conn_";
  protected final String TEXT_221 = ".getMetaData().getUserName());";
  protected final String TEXT_222 = NL + "\tglobalMap.put(\"dbschema_\" + \"";
  protected final String TEXT_223 = "\", ";
  protected final String TEXT_224 = ");";
  protected final String TEXT_225 = NL + "\tglobalMap.put(\"username_\" + \"";
  protected final String TEXT_226 = "\",";
  protected final String TEXT_227 = ");" + NL + "\tglobalMap.put(\"password_\" + \"";
  protected final String TEXT_228 = "\",dbPwd_";
  protected final String TEXT_229 = ");";
  protected final String TEXT_230 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
		}
		
		public void useShareConnection(INode node) {
			String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");
			String shareDBClass = "SharedDBConnection";
			if(isLog4jEnabled){
				shareDBClass = "SharedDBConnectionLog4j";

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(shareDBClass);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		}
		
		public void createConnection(INode node) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
		}
		
		public void setAutoCommit(INode node) {
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_25);
    
			}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_28);
    
		}
		
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultUtil class
	
	DefaultConnectionUtil connUtil = new DefaultConnectionUtil();

    
	class ConnectionUtil extends DefaultConnectionUtil{

	public void createURL(INode node) {
			super.createURL(node);

    
    		String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
			String jdbcURL = ElementParameterParser.getValue(node, "__JDBC_URL__");
    		String localServiceName = ElementParameterParser.getValue(node, "__LOCAL_SERVICE_NAME__");
    		String rac_url = ElementParameterParser.getValue(node, "__RAC_URL__");
			if("ORACLE_RAC".equals(connectionType)) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(rac_url);
    stringBuffer.append(TEXT_31);
    
    		} else if(("ORACLE_SID").equals(connectionType)) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_36);
    
    		} else if(("ORACLE_SERVICE_NAME").equals(connectionType)) {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_41);
    
    		} else if(("ORACLE_OCI").equals(connectionType)) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(localServiceName);
    stringBuffer.append(TEXT_44);
    
			}else if(("ORACLE_WALLET").equals(connectionType)){
			
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(jdbcURL);
    stringBuffer.append(TEXT_47);
    
			}

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connectionType);
    stringBuffer.append(TEXT_50);
    
		}

		public String getDirverClassName(INode node){
			String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__");
			if("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_12".equals(dbVersion) ){
			    return "oracle.jdbc.OracleDriver";
			}else {
				return "oracle.jdbc.driver.OracleDriver";
			}
		}



		public void useShareConnection(INode node) {
		String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");
		String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
		String shareDBClass = "SharedDBConnection";
		if(isLog4jEnabled){
			shareDBClass = "SharedDBConnectionLog4j";

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
		}

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_55);
    
			if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(shareDBClass);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
			} else {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(shareDBClass);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
			}

    
		}

		public void createConnection(INode node) {
		//dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
		String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
			if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
			} else if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
			} else {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append( dbproperties );
    stringBuffer.append(TEXT_84);
    stringBuffer.append( dbproperties );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( dbproperties );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
			}

    
		}

		public void afterComponentProcess(INode node){

    
	    	String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
    		String localServiceName = ElementParameterParser.getValue(node, "__LOCAL_SERVICE_NAME__");
			if(("ORACLE_OCI").equals(connectionType)) {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(localServiceName);
    stringBuffer.append(TEXT_94);
    
    		} else if("ORACLE_RAC".equals(connectionType)){
	    		String rac_url = ElementParameterParser.getValue(node, "__RAC_URL__");

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(rac_url);
    stringBuffer.append(TEXT_97);
        		}else {

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_104);
    
    		}

    
	    }
	}//end class
	connUtil = new ConnectionUtil();

    //----------------------------component codes-----------------------------------------
    stringBuffer.append(TEXT_105);
    
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

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append((dbuser != null && dbuser.trim().length() == 0)? "null":dbuser);
    stringBuffer.append(TEXT_108);
    //the tSQLiteConnection component not contain user and pass return null
    stringBuffer.append(TEXT_109);
    if(dbpass != null && dbpass.trim().length() == 0) {
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    } else {
		String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_112);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_115);
    } else {
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    }
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
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
			
    stringBuffer.append(TEXT_124);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_125);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_126);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_129);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_132);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_135);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_140);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_142);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_143);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_146);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_149);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    
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
			
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    if (cid.startsWith("tImpala") || cid.startsWith("tHive")) {
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_157);
    } else {
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    
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
			
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    
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
			
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
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
			
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_176);
    
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
	    	
    stringBuffer.append(TEXT_177);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_180);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_181);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_183);
    
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
			
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_192);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	if(isUseSharedConnection){

    stringBuffer.append(TEXT_193);
    connUtil.useShareConnection(node);
    
	} else {
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
		}

    stringBuffer.append(TEXT_197);
    connUtil.classForName(node);
    stringBuffer.append(TEXT_198);
    
		log4jCodeGenerateUtil.debugConnectionParams(node);
		log4jCodeGenerateUtil.connect_begin();
		connUtil.createConnection(node);
		log4jCodeGenerateUtil.connect_end();
		
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    
		}
	}

    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    connUtil.setAutoCommit(node);
    stringBuffer.append(TEXT_215);
    
	connUtil.afterComponentProcess(node);

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
	String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
	if(("ORACLE_WALLET").equals(connectionType)&&(dbschema==null||"".equals(dbschema)||"\"\"".equals(dbschema))) {

    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    
	}else{

    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_224);
    
	}

    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(TEXT_230);
    return stringBuffer.toString();
  }
}
