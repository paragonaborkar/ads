package org.talend.designer.codegen.translators.elt.map.mysql;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.commons.utils.generation.CodeGenerationUtils;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class TELTMysqlOutputMainJava
{
  protected static String nl;
  public static synchronized TELTMysqlOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TELTMysqlOutputMainJava result = new TELTMysqlOutputMainJava();
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
  protected final String TEXT_70 = NL;
  protected final String TEXT_71 = NL + "\tString select_query = null;" + NL + "\tString selectQueryColumnsName = null;";
  protected final String TEXT_72 = NL + "\t\tselect_query = (String) globalMap.get(\"";
  protected final String TEXT_73 = "\"+\"QUERY\"+\"";
  protected final String TEXT_74 = "\");" + NL + "\t\tselectQueryColumnsName = (String) globalMap.get(\"";
  protected final String TEXT_75 = "\"+\"QUERY_COLUMNS_NAME\"+\"";
  protected final String TEXT_76 = "\");";
  protected final String TEXT_77 = NL;
  protected final String TEXT_78 = NL + "    java.sql.Connection conn_";
  protected final String TEXT_79 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_80 = "\");";
  protected final String TEXT_81 = NL + "    String driverClass_";
  protected final String TEXT_82 = " = \"";
  protected final String TEXT_83 = "\";" + NL + "    java.lang.Class.forName(driverClass_";
  protected final String TEXT_84 = ");" + NL + "    String url_";
  protected final String TEXT_85 = " = \"";
  protected final String TEXT_86 = "://\"+";
  protected final String TEXT_87 = "+\":\"+";
  protected final String TEXT_88 = "+\"/\"+";
  protected final String TEXT_89 = ";" + NL + "    String dbUser_";
  protected final String TEXT_90 = " = ";
  protected final String TEXT_91 = ";" + NL;
  protected final String TEXT_92 = NL;
  protected final String TEXT_93 = NL + "    ";
  protected final String TEXT_94 = "String decryptedPassword_";
  protected final String TEXT_95 = " = null;";
  protected final String TEXT_96 = " " + NL + "\tdecryptedPassword_";
  protected final String TEXT_97 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_98 = ");";
  protected final String TEXT_99 = NL + "\tdecryptedPassword_";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = "; ";
  protected final String TEXT_102 = NL + NL + "    String dbPwd_";
  protected final String TEXT_103 = " = decryptedPassword_";
  protected final String TEXT_104 = ";" + NL + "" + NL + "    java.sql.Connection conn_";
  protected final String TEXT_105 = " = null;    ";
  protected final String TEXT_106 = NL;
  protected final String TEXT_107 = NL + NL + "\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_108 = " =null;" + NL;
  protected final String TEXT_109 = "\t" + NL + "\t\tString insertQuery = \"INSERT INTO ";
  protected final String TEXT_110 = "(";
  protected final String TEXT_111 = ") (\"+select_query+\")\";";
  protected final String TEXT_112 = NL + "\t\tString insertQuery = \"INSERT INTO \"+";
  protected final String TEXT_113 = "+\"(";
  protected final String TEXT_114 = ") (\"+select_query+\")\";";
  protected final String TEXT_115 = NL + "\t\tpstmt_";
  protected final String TEXT_116 = " = conn_";
  protected final String TEXT_117 = ".prepareStatement(insertQuery);";
  protected final String TEXT_118 = NL + "\t\tString updateQuery = \"UPDATE ";
  protected final String TEXT_119 = "\";";
  protected final String TEXT_120 = NL + "\t\tString updateQuery = \"UPDATE \"+";
  protected final String TEXT_121 = ";";
  protected final String TEXT_122 = NL + "\t\tupdateQuery +=\" SET ";
  protected final String TEXT_123 = " \"";
  protected final String TEXT_124 = NL + "\t\t+\"  WHERE \" + ";
  protected final String TEXT_125 = NL + "\t\t;" + NL + "\t\tpstmt_";
  protected final String TEXT_126 = " = conn_";
  protected final String TEXT_127 = ".prepareStatement(updateQuery);" + NL;
  protected final String TEXT_128 = NL + "\t\tString deleteQuery = \"DELETE  FROM ";
  protected final String TEXT_129 = "\";";
  protected final String TEXT_130 = NL + "\t\tString deleteQuery = \"DELETE  FROM \"+";
  protected final String TEXT_131 = ";";
  protected final String TEXT_132 = NL + "\t\tdeleteQuery += \" WHERE EXISTS (\"+select_query+\")\"";
  protected final String TEXT_133 = NL + "\t\t+\"  AND \" + ";
  protected final String TEXT_134 = NL + "\t\t;" + NL + "\t\tpstmt_";
  protected final String TEXT_135 = " = conn_";
  protected final String TEXT_136 = ".prepareStatement(deleteQuery);";
  protected final String TEXT_137 = NL + "\tint nb_line_";
  protected final String TEXT_138 = " = 0;" + NL + "\tint nb_line_updated_";
  protected final String TEXT_139 = " = 0;" + NL + "\tint nb_line_inserted_";
  protected final String TEXT_140 = " = 0;" + NL + "\tint nb_line_deleted_";
  protected final String TEXT_141 = " = 0;";
  protected final String TEXT_142 = NL + "\t\tSystem.out.println(\"Inserting with : \\n\" + insertQuery + \"\\n\");";
  protected final String TEXT_143 = " " + NL + "\t\tnb_line_";
  protected final String TEXT_144 = " += nb_line_inserted_";
  protected final String TEXT_145 = " = pstmt_";
  protected final String TEXT_146 = ".executeUpdate();";
  protected final String TEXT_147 = NL + "\t\tSystem.out.println(\"--> \" + nb_line_inserted_";
  protected final String TEXT_148 = " + \" rows inserted. \\n\");";
  protected final String TEXT_149 = NL + "\t\tSystem.out.println(\"Updating with : \\n\" + updateQuery +\"\\n\");";
  protected final String TEXT_150 = " " + NL + "\t\tnb_line_";
  protected final String TEXT_151 = " += nb_line_updated_";
  protected final String TEXT_152 = " = pstmt_";
  protected final String TEXT_153 = ".executeUpdate();";
  protected final String TEXT_154 = NL + "\t\tSystem.out.println(\"--> \" + nb_line_updated_";
  protected final String TEXT_155 = " + \" rows updated. \\n\");";
  protected final String TEXT_156 = NL + "\t\tSystem.out.println(\"Deleting with : \\n\" + deleteQuery +\"\\n\");" + NL + "\t\t";
  protected final String TEXT_157 = " " + NL + "\t\tnb_line_";
  protected final String TEXT_158 = " += nb_line_deleted_";
  protected final String TEXT_159 = " = pstmt_";
  protected final String TEXT_160 = ".executeUpdate();" + NL + "\t\t";
  protected final String TEXT_161 = NL + "\t\tSystem.out.println(\"--> \" + nb_line_deleted_";
  protected final String TEXT_162 = " + \" rows deleted. \\n\");";
  protected final String TEXT_163 = NL + NL + "\tpstmt_";
  protected final String TEXT_164 = ".close();" + NL;
  protected final String TEXT_165 = NL + "    if(conn_";
  protected final String TEXT_166 = " != null && !conn_";
  protected final String TEXT_167 = ".isClosed()) {" + NL + "\t\t";
  protected final String TEXT_168 = NL + "    }";
  protected final String TEXT_169 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_170 = "_NB_LINE\",nb_line_";
  protected final String TEXT_171 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_172 = "_NB_LINE_UPDATED\",nb_line_updated_";
  protected final String TEXT_173 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_174 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_175 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_176 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_177 = ");" + NL;
  protected final String TEXT_178 = NL + "\tlog.info(\"";
  protected final String TEXT_179 = " - Has ";
  protected final String TEXT_180 = " records count: \" + nb_line_";
  protected final String TEXT_181 = "_";
  protected final String TEXT_182 = " + \".\");";
  protected final String TEXT_183 = NL;

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

    stringBuffer.append(TEXT_70);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();

	String dbtable = null;
	String uniqueNameConnection = null;
	INode previousNode = null;

    stringBuffer.append(TEXT_71);
    
	List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();
	if(connections != null && connections.size() > 0 && connections.get(0) != null) {
	    IConnection connection = connections.get(0);
	    previousNode = connection.getSource();
	    String previousComponentName = previousNode.getUniqueName();
		dbtable = connection.getName();
		uniqueNameConnection = connection.getUniqueName();

    stringBuffer.append(TEXT_72);
    stringBuffer.append(previousComponentName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(uniqueNameConnection);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(previousComponentName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(uniqueNameConnection);
    stringBuffer.append(TEXT_76);
    
	}
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");

    String dbhost = null;
    String dbport = null;
    String dbname = null;
    String dbuser = null;
    String dbVersion = "";
    boolean useExistingConn = false;
    if(previousNode != null) {
        dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
        dbport = ElementParameterParser.getValue(previousNode, "__PORT__");
        dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
        dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
        useExistingConn = ("true").equals(ElementParameterParser.getValue(previousNode, "__USE_EXISTING_CONNECTION__"));
        dbVersion = ElementParameterParser.getValue(previousNode, "__DB_VERSION__");
    }

	String differenttable = ElementParameterParser.getValue(node, "__DIFFERENT_TABLE_NAME__");
	String useDifferentTable = ElementParameterParser.getValue(node, "__USE_DIFFERENT_TABLE__");
        String whereClause = ElementParameterParser.getValue(node, "__WHERE_CLAUSE__");


    stringBuffer.append(TEXT_77);
    
	if(useExistingConn) {
	    String connection = ElementParameterParser.getValue(previousNode, "__CONNECTION__");
	    String conn = "conn_" + connection;

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_80);
    
	log4jCodeGenerateUtil.useExistConnection(node);
	} else {
		String drverClass= "org.gjt.mm.mysql.Driver";
		String jdbcURL = "jdbc:mysql";
		if("MARIADB".equals(dbVersion)){
			drverClass = "org.mariadb.jdbc.Driver";
			jdbcURL = "jdbc:mariadb";
		}

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(drverClass);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(jdbcURL);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_91);
    
    String passwordFieldName = "__PASS__";
    
    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    if (ElementParameterParser.canEncrypt(previousNode, passwordFieldName)) {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(previousNode, passwordFieldName));
    stringBuffer.append(TEXT_98);
    } else {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append( ElementParameterParser.getValue(previousNode, passwordFieldName));
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
	log4jCodeGenerateUtil.debugConnectionParams(node);
   	log4jCodeGenerateUtil.connect(node);
	}

    stringBuffer.append(TEXT_106);
    
	List<IMetadataColumn> columnList = null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if(metadatas !=null && metadatas.size()>0){
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null){
			columnList = metadata.getListColumns();
		}
	}

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    

	if(columnList != null && columnList.size()>0){

		class Column{
		
			IMetadataColumn column;
			
			String name;
			
			String sqlStmt;
			
			String value;
			
			boolean addCol;
			
			List<Column> replacement = new ArrayList<Column>();
			
			public Column(IMetadataColumn column){
				this.column = column;
				String columname = column.getOriginalDbColumnName();
				if(columname!=null && columname.trim().length()>0){
					this.name = columname;
				}else{
					this.name = column.getLabel();
				}
				this.sqlStmt = "=?";
				this.value = "?";
				this.addCol =false;
			}
			
			public boolean isReplaced(){
				return replacement.size()>0;
			}
			
			public List<Column> getReplacement(){
				return this.replacement;
			}
			
			public IMetadataColumn getColumn(){
				return this.column;
			}
		
			public String getName(){
				return this.name;
			}
			
			public boolean isAddCol(){
				return this.addCol;
			}
			
			public String getSqlStmt(){
				return this.sqlStmt;
			}
			
			public String getValue(){
				return this.value;
			}
		}
		
		StringBuilder insertColName = new StringBuilder();
		StringBuilder insertValueStmt = new StringBuilder();
		StringBuilder updateSetStmt = new StringBuilder();
		StringBuilder updateWhereStmt = new StringBuilder();
		List<Column> stmtStructure =  new LinkedList<Column>();

		for(IMetadataColumn column:columnList){
			stmtStructure.add(new Column(column));
		}

		int counterOuter =0;
		boolean firstKey = true;
		boolean firstNoneKey = true;
		
		for(Column colStmt:stmtStructure){
			String suffix = ",";
			
			if(colStmt.isReplaced()){		
				List<Column> replacedColumns = colStmt.getReplacement();
				int counterReplace = 0;
				if(counterOuter==(stmtStructure.size()-1) && counterReplace==(replacedColumns.size()-1) ){
					suffix = "";
				}
				for(Column replacement:replacedColumns){
					insertColName.append(replacement.getName()+suffix);
					insertValueStmt.append(replacement.getSqlStmt()+suffix);
					if(!colStmt.getColumn().isKey()){
						if(!firstNoneKey){
							updateSetStmt.append(",");
						}else{
							firstNoneKey = false;
						}
						updateSetStmt.append(replacement.getName());
						updateSetStmt.append(replacement.getSqlStmt());
					}else{
						if(!firstKey){
							updateWhereStmt.append(" AND ");
						}else{
							firstKey = false;
						}
						updateWhereStmt.append(replacement.getName());
						updateWhereStmt.append(replacement.getSqlStmt());
					}
					counterReplace++;
				}
			}else{
				if(counterOuter==(stmtStructure.size()-1)){
					suffix = "";
				}
				if(colStmt.isAddCol()){
					insertColName.append(colStmt.getName()+suffix);
					insertValueStmt.append(colStmt.getSqlStmt()+suffix);
					updateSetStmt.append(colStmt.getName());
					updateSetStmt.append(colStmt.getSqlStmt()+suffix);
				}else{
					insertColName.append(colStmt.getName()+suffix);
					insertValueStmt.append(colStmt.getValue()+suffix);
					updateSetStmt.append(colStmt.getName()+"=(\"+select_query.replaceFirst(java.util.regex.Pattern.quote(selectQueryColumnsName),routines.system.StringUtils.splitSQLColumns(selectQueryColumnsName)[ "+ counterOuter + "])+\")" +suffix);
					
					
				}
			}
			counterOuter ++;
		}

		if(("INSERT").equals(dataAction)){

    
		if("false".equals(useDifferentTable)) {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_111);
    } else {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(differenttable);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
		} else if (("UPDATE").equals(dataAction)) {

    
		if("false".equals(useDifferentTable)) {

    stringBuffer.append(TEXT_118);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_119);
    		} else {
    stringBuffer.append(TEXT_120);
    stringBuffer.append(differenttable);
    stringBuffer.append(TEXT_121);
    		}
    stringBuffer.append(TEXT_122);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_123);
    
			if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    
			}

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    		
		}else if (("DELETE").equals(dataAction)){

    
		if("false".equals(useDifferentTable)) {

    stringBuffer.append(TEXT_128);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_129);
    } else {
    stringBuffer.append(TEXT_130);
    stringBuffer.append(differenttable);
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    
			if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {

    stringBuffer.append(TEXT_133);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    
			}

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    		
		}

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
	
}
		if(dbtable != null && columnList != null){
			if(("INSERT").equals(dataAction)){

    stringBuffer.append(TEXT_142);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing SQL:\"+insertQuery+\"");
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
			}else if(("UPDATE").equals(dataAction)){

    stringBuffer.append(TEXT_149);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing SQL:\"+updateQuery+\"");
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
			}else if (("DELETE").equals(dataAction)){

    stringBuffer.append(TEXT_156);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing SQL:\"+deleteQuery+\"");
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    
			}
		}

	// END


    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    
		if(!useExistingConn) {

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    log4jCodeGenerateUtil.close(node);
    stringBuffer.append(TEXT_168);
    
		}

    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
if(isLog4jEnabled){
	Map<String,String> actionMap=new java.util.HashMap<String,String>();
	actionMap.put("INSERT","inserted");
	actionMap.put("UPDATE","updated");
	actionMap.put("DELETE","deleted");
	
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(actionMap.get(dataAction));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(actionMap.get(dataAction));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
}

    stringBuffer.append(TEXT_183);
    return stringBuffer.toString();
  }
}
