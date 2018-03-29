package org.talend.designer.codegen.translators.databases.ms_sql_server;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TMSSqlColumnListBeginJava
{
  protected static String nl;
  public static synchronized TMSSqlColumnListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMSSqlColumnListBeginJava result = new TMSSqlColumnListBeginJava();
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
  protected final String TEXT_70 = NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_71 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_72 = "\");";
  protected final String TEXT_73 = NL + NL + "\tString db_";
  protected final String TEXT_74 = " = (String)globalMap.get(\"";
  protected final String TEXT_75 = "\");" + NL + "" + NL + "\tString table_";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = ";" + NL + "" + NL + "\tString dbSchema_";
  protected final String TEXT_78 = " = (String)globalMap.get(\"";
  protected final String TEXT_79 = "\");" + NL + "" + NL + "\tString query_";
  protected final String TEXT_80 = " = \"\";" + NL + "" + NL + "\tif(dbSchema_";
  protected final String TEXT_81 = " != null && dbSchema_";
  protected final String TEXT_82 = ".length() > 0){" + NL + "\t\tquery_";
  protected final String TEXT_83 = " = \"SELECT t.COLUMN_NAME, t.COLUMN_DEFAULT, t.IS_NULLABLE, t.DATA_TYPE, t.CHARACTER_MAXIMUM_LENGTH, \" +" + NL + "\t\t\t\t\"t.CHARACTER_OCTET_LENGTH, t.NUMERIC_PRECISION, t.NUMERIC_PRECISION_RADIX, t.NUMERIC_SCALE, t.DATETIME_PRECISION,\" +" + NL + "\t\t\t\t\" c.COLUMN_NAME, t.ORDINAL_POSITION FROM (SELECT * FROM information_schema.columns WHERE TABLE_CATALOG='\" +" + NL + "\t\t\t\tdb_";
  protected final String TEXT_84 = " + \"' AND TABLE_SCHEMA='\" + dbSchema_";
  protected final String TEXT_85 = " + \"' AND TABLE_NAME='\" + table_";
  protected final String TEXT_86 = " +" + NL + "\t\t\t\t\"') AS t  LEFT OUTER JOIN (SELECT isK.COLUMN_NAME,isK.CONSTRAINT_NAME FROM information_schema.KEY_COLUMN_USAGE isK,\" +" + NL + "\t\t\t\t\"information_schema.TABLE_CONSTRAINTS isT WHERE isK.TABLE_CATALOG='\" + db_";
  protected final String TEXT_87 = " + " + NL + "\t\t\t\t\"' AND isK.TABLE_SCHEMA='\" + dbSchema_";
  protected final String TEXT_88 = " + \"' AND isK.TABLE_NAME='\" + table_";
  protected final String TEXT_89 = "+ " + NL + "\t\t\t\t\"' AND isT.CONSTRAINT_TYPE='PRIMARY KEY'AND isK.CONSTRAINT_NAME=isT.CONSTRAINT_NAME) \" +" + NL + "\t\t\t\t\"AS c ON t.COLUMN_NAME=c.COLUMN_NAME ORDER BY t.ORDINAL_POSITION\";" + NL + "\t" + NL + "\t}else{" + NL + "\t\tquery_";
  protected final String TEXT_90 = " = \"SELECT t.COLUMN_NAME, t.COLUMN_DEFAULT, t.IS_NULLABLE, t.DATA_TYPE, \" +" + NL + "\t\t\t\"t.CHARACTER_MAXIMUM_LENGTH, t.CHARACTER_OCTET_LENGTH, t.NUMERIC_PRECISION, \" + " + NL + "\t\t\t\"t.NUMERIC_PRECISION_RADIX, t.NUMERIC_SCALE, t.DATETIME_PRECISION, c.COLUMN_NAME, \" + " + NL + "\t\t\t\"t.ORDINAL_POSITION FROM (SELECT * FROM information_schema.columns WHERE TABLE_CATALOG='\" + db_";
  protected final String TEXT_91 = " + " + NL + "\t\t\t\"' AND TABLE_NAME='\" + table_";
  protected final String TEXT_92 = " +\"') AS t LEFT OUTER JOIN (SELECT isK.COLUMN_NAME,isK.CONSTRAINT_NAME FROM information_schema.KEY_COLUMN_USAGE isK,\" +" + NL + "\t\t\t\"information_schema.TABLE_CONSTRAINTS isT WHERE isK.TABLE_CATALOG='\" + db_";
  protected final String TEXT_93 = " + " + NL + "\t\t\t\"' AND isK.TABLE_NAME='\" + table_";
  protected final String TEXT_94 = "+ " + NL + "\t\t\t\"' AND isT.CONSTRAINT_TYPE='PRIMARY KEY'AND isK.CONSTRAINT_NAME=isT.CONSTRAINT_NAME) AS c ON t.COLUMN_NAME=c.COLUMN_NAME ORDER BY t.ORDINAL_POSITION\";\t" + NL + "\t}" + NL + "" + NL + "\tint nb_column_";
  protected final String TEXT_95 = " = 0;" + NL + "\t" + NL + "\tjava.sql.Statement stmt2_";
  protected final String TEXT_96 = " = conn_";
  protected final String TEXT_97 = ".createStatement();" + NL + "\t" + NL + "\t";
  protected final String TEXT_98 = NL + "\t\tlog.info(\"";
  protected final String TEXT_99 = " - Query:'\"+query_";
  protected final String TEXT_100 = "+\"'.\");" + NL + "\t";
  protected final String TEXT_101 = NL + "\tjava.sql.ResultSet rs_";
  protected final String TEXT_102 = " = stmt2_";
  protected final String TEXT_103 = ".executeQuery(query_";
  protected final String TEXT_104 = ");" + NL + "\t" + NL + "\t" + NL + "\twhile (rs_";
  protected final String TEXT_105 = ".next()) {" + NL + "\t" + NL + "\t\tString currentColumnName_";
  protected final String TEXT_106 = " = rs_";
  protected final String TEXT_107 = ".getString(1);" + NL + "\t\t" + NL + "\t\tString columnDefault_";
  protected final String TEXT_108 = " = rs_";
  protected final String TEXT_109 = ".getString(2);" + NL + "\t\t" + NL + "\t\tString isNullable_";
  protected final String TEXT_110 = " = rs_";
  protected final String TEXT_111 = ".getString(3);" + NL + "\t\t" + NL + "\t\tString dataType_";
  protected final String TEXT_112 = " = rs_";
  protected final String TEXT_113 = ".getString(4);" + NL + "\t\t" + NL + "\t\tString characterMaximumLength_";
  protected final String TEXT_114 = " = rs_";
  protected final String TEXT_115 = ".getString(5);" + NL + "\t\t" + NL + "\t\tString characterOctetLength_";
  protected final String TEXT_116 = " = rs_";
  protected final String TEXT_117 = ".getString(6);" + NL + "\t\t" + NL + "\t\tString numericPrecision_";
  protected final String TEXT_118 = " = rs_";
  protected final String TEXT_119 = ".getString(7);" + NL + "\t" + NL + "\t\tString numericPrecisionRadix_";
  protected final String TEXT_120 = " = rs_";
  protected final String TEXT_121 = ".getString(8);" + NL + "\t\t" + NL + "\t\tString numericScale_";
  protected final String TEXT_122 = " = rs_";
  protected final String TEXT_123 = ".getString(9);" + NL + "\t\t" + NL + "\t\tString dateTimePrecision_";
  protected final String TEXT_124 = " = rs_";
  protected final String TEXT_125 = ".getString(10);" + NL + "\t\t" + NL + "\t\tString columKey_";
  protected final String TEXT_126 = " = \"NO\";" + NL + "\t\t" + NL + "\t\tif(rs_";
  protected final String TEXT_127 = ".getString(11) != null){" + NL + "\t\t\tcolumKey_";
  protected final String TEXT_128 = " = \"YES\";" + NL + "\t\t}" + NL + "\t" + NL + "\t\tnb_column_";
  protected final String TEXT_129 = "++;" + NL + "\t        " + NL + "\t\t";
  protected final String TEXT_130 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_131 = " - Retrieving the column \"+nb_column_";
  protected final String TEXT_132 = "+\".\");" + NL + "\t\t\tStringBuffer logSB_";
  protected final String TEXT_133 = " = new StringBuffer(\"";
  protected final String TEXT_134 = " - Name of column \"+nb_column_";
  protected final String TEXT_135 = "+\":\"+currentColumnName_";
  protected final String TEXT_136 = "+\" | \");" + NL + "\t\t\tlogSB_";
  protected final String TEXT_137 = ".append(\"Default value of column \"+nb_column_";
  protected final String TEXT_138 = "+\":\"+columnDefault_";
  protected final String TEXT_139 = "+\" | \")" + NL + "\t\t\t.append(\"Is nullable of column \"+nb_column_";
  protected final String TEXT_140 = "+\":\"+isNullable_";
  protected final String TEXT_141 = "+\" | \")" + NL + "\t\t\t.append(\"Data type of column \"+nb_column_";
  protected final String TEXT_142 = "+\":\"+dataType_";
  protected final String TEXT_143 = "+\" | \")" + NL + "\t\t\t.append(\"Character maximum length of column \"+nb_column_";
  protected final String TEXT_144 = "+\":\"+characterMaximumLength_";
  protected final String TEXT_145 = "+\" | \")" + NL + "\t\t\t.append(\"Character octet length of column \"+nb_column_";
  protected final String TEXT_146 = "+\":\"+characterOctetLength_";
  protected final String TEXT_147 = "+\" | \")" + NL + "\t\t\t.append(\"Numeric precision of column \"+nb_column_";
  protected final String TEXT_148 = "+\":\"+numericPrecision_";
  protected final String TEXT_149 = "+\" | \")" + NL + "\t\t\t.append(\"Numeric precision radix of column \"+nb_column_";
  protected final String TEXT_150 = "+\":\"+numericPrecisionRadix_";
  protected final String TEXT_151 = "+\" | \")" + NL + "\t\t\t.append(\"Numeric scale of column \"+nb_column_";
  protected final String TEXT_152 = "+\":\"+numericScale_";
  protected final String TEXT_153 = "+\" | \")" + NL + "\t\t\t.append(\"Datetime precision of column \"+nb_column_";
  protected final String TEXT_154 = "+\":\"+dateTimePrecision_";
  protected final String TEXT_155 = "+\" | \")" + NL + "\t\t\t.append(\"Column key of column \"+nb_column_";
  protected final String TEXT_156 = "+\":\"+columKey_";
  protected final String TEXT_157 = "+\" |\");" + NL + "\t\t\tlog.trace(logSB_";
  protected final String TEXT_158 = ".toString());" + NL + "\t\t";
  protected final String TEXT_159 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_160 = "_COLUMN_NAME\", currentColumnName_";
  protected final String TEXT_161 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_162 = "_COLUMN_DEFAULT\", columnDefault_";
  protected final String TEXT_163 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_164 = "_IS_NULLABLE\", isNullable_";
  protected final String TEXT_165 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_166 = "_DATA_TYPE\", dataType_";
  protected final String TEXT_167 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_168 = "_CHARACTER_MAXIMUM_LENGTH\", characterMaximumLength_";
  protected final String TEXT_169 = ");" + NL + "\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_170 = "_CHARACTER_OCTET_LENGTH\", characterOctetLength_";
  protected final String TEXT_171 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_172 = "_NUMERIC_PRECISION\", numericPrecision_";
  protected final String TEXT_173 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_174 = "_NUMERIC_PRECISION_RADIX\", numericPrecisionRadix_";
  protected final String TEXT_175 = ");" + NL + "\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_176 = "_NUMERIC_SCALE\", numericScale_";
  protected final String TEXT_177 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_178 = "_DATETIME_PRECISION\", dateTimePrecision_";
  protected final String TEXT_179 = ");" + NL + "\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_180 = "_COLUMN_KEY\", columKey_";
  protected final String TEXT_181 = ");";
  protected final String TEXT_182 = NL;

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
    
    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
    
    String conn = "conn_" + connection;
    
    String db = "db_" + connection;
    
    String dbSchema = "dbschema_" + connection;
    
    String table = ElementParameterParser.getValue(node,"__TABLE_NAME__");
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_72);
    	log4jCodeGenerateUtil.useExistConnection(node);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(db );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(table );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(dbSchema );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    
	}
	
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
		}
		
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(TEXT_182);
    return stringBuffer.toString();
  }
}
