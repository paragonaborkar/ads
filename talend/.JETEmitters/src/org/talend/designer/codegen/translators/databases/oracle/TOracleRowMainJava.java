package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class TOracleRowMainJava
{
  protected static String nl;
  public static synchronized TOracleRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleRowMainJava result = new TOracleRowMainJava();
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
  protected final String TEXT_70 = NL + "\t\t";
  protected final String TEXT_71 = " = null;" + NL + "\t\t";
  protected final String TEXT_72 = NL + "query_";
  protected final String TEXT_73 = " = ";
  protected final String TEXT_74 = ";" + NL + "whetherReject_";
  protected final String TEXT_75 = " = false;";
  protected final String TEXT_76 = NL + "globalMap.put(\"";
  protected final String TEXT_77 = "_QUERY\",query_";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "\tjava.sql.ResultSet rs_";
  protected final String TEXT_80 = " = null;" + NL + "\t";
  protected final String TEXT_81 = NL + "try {";
  protected final String TEXT_82 = NL + "\t\t\t\tif((";
  protected final String TEXT_83 = "==null))" + NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\tpstmt_";
  protected final String TEXT_84 = ".setNull(";
  protected final String TEXT_85 = ", java.sql.Types.TIMESTAMP);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\telse{" + NL + "\t\t\t\t\tpstmt_";
  protected final String TEXT_86 = ".setTimestamp(";
  protected final String TEXT_87 = ",new java.sql.Timestamp(";
  protected final String TEXT_88 = ".getTime()));" + NL + "\t\t\t\t\t}";
  protected final String TEXT_89 = NL + "\t\t\tpstmt_";
  protected final String TEXT_90 = ".set";
  protected final String TEXT_91 = "(";
  protected final String TEXT_92 = ",";
  protected final String TEXT_93 = ");";
  protected final String TEXT_94 = NL + "\t\trs_";
  protected final String TEXT_95 = " = pstmt_";
  protected final String TEXT_96 = ".executeQuery();";
  protected final String TEXT_97 = NL + "\t\tpstmt_";
  protected final String TEXT_98 = ".execute();" + NL + "\t\t";
  protected final String TEXT_99 = NL + "\t\trs_";
  protected final String TEXT_100 = " = stmt_";
  protected final String TEXT_101 = ".executeQuery(query_";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "\t\tstmt_";
  protected final String TEXT_104 = ".execute(query_";
  protected final String TEXT_105 = ");" + NL + "\t\t";
  protected final String TEXT_106 = NL + "\t\tnb_line_inserted_";
  protected final String TEXT_107 = " += pstmt_";
  protected final String TEXT_108 = ".getUpdateCount();";
  protected final String TEXT_109 = NL + "\t\tnb_line_update_";
  protected final String TEXT_110 = " += pstmt_";
  protected final String TEXT_111 = ".getUpdateCount();";
  protected final String TEXT_112 = NL + "\t\tnb_line_deleted_";
  protected final String TEXT_113 = " += pstmt_";
  protected final String TEXT_114 = ".getUpdateCount();";
  protected final String TEXT_115 = NL + "\t\tnb_line_inserted_";
  protected final String TEXT_116 = " += stmt_";
  protected final String TEXT_117 = ".getUpdateCount();";
  protected final String TEXT_118 = NL + "\t\tnb_line_update_";
  protected final String TEXT_119 = " += stmt_";
  protected final String TEXT_120 = ".getUpdateCount();";
  protected final String TEXT_121 = NL + "\t\tnb_line_deleted_";
  protected final String TEXT_122 = " += stmt_";
  protected final String TEXT_123 = ".getUpdateCount();";
  protected final String TEXT_124 = NL + "\t} catch (java.lang.Exception e) {" + NL + "\t\twhetherReject_";
  protected final String TEXT_125 = " = true;" + NL + "\t\t";
  protected final String TEXT_126 = NL + "\t\t\tthrow(e);" + NL + "\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\t";
  protected final String TEXT_128 = " = new ";
  protected final String TEXT_129 = "Struct();" + NL + "\t\t\t\t";
  protected final String TEXT_130 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_131 = ".";
  protected final String TEXT_132 = " = ";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\t";
  protected final String TEXT_136 = ".errorCode = ((java.sql.SQLException)e).getSQLState();" + NL + "\t\t\t\t";
  protected final String TEXT_137 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_138 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\t\tSystem.err.print(e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_140 = NL + "\t}" + NL + "\t";
  protected final String TEXT_141 = NL + "\tif(!whetherReject_";
  protected final String TEXT_142 = ") {" + NL + "\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\t\t";
  protected final String TEXT_144 = " = new ";
  protected final String TEXT_145 = "Struct();" + NL + "\t\t\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " = rs_";
  protected final String TEXT_149 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = " = ";
  protected final String TEXT_153 = ".";
  protected final String TEXT_154 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_155 = NL + "\t}" + NL + "\t";
  protected final String TEXT_156 = NL + "\t\tcommitCounter_";
  protected final String TEXT_157 = "++;" + NL + "\t\tif(commitEvery_";
  protected final String TEXT_158 = " <= commitCounter_";
  protected final String TEXT_159 = ") {" + NL + "\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\tcommitCounter_";
  protected final String TEXT_161 = "=0;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_162 = NL;

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
String cid =  node.getUniqueName();
String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
String propagateRecordset = ElementParameterParser.getValue(node,"__PROPAGATE_RECORD_SET__");
String recordsetColumn = ElementParameterParser.getValue(node,"__RECORD_SET_COLUMN__");
boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
List<Map<String, String>> prepareStatementParameters = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SET_PREPAREDSTATEMENT_PARAMETERS__");
String use_NB_Line = ElementParameterParser.getValue(node, "__USE_NB_LINE__");
String incomingConnName = null;
Set<String> inputCols = new HashSet<String>();
List<IMetadataColumn> columnList = null;
String rejectConnName = null;
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
List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
boolean hasOutgoingDataConnection = false;
for(IConnection conn : outgoingConns) {
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		if(!hasOutgoingDataConnection){
			hasOutgoingDataConnection = true;
		}
		
    stringBuffer.append(TEXT_70);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_71);
    
	}
}
log4jCodeGenerateUtil.query(node);

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		List< ? extends IConnection> conns = node.getIncomingConnections();
		columnList = metadata.getListColumns();
		if(conns != null && conns.size()>0){
			IConnection conn = conns.get(0);
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				incomingConnName = conn.getName();
				IMetadataTable inputMetadataTable = conn.getMetadataTable();
				for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
					inputCols.add(inputCol.getLabel());
				}
			}
		}//end of connection size.
	}//end of metadatas
}
if(!hasOutgoingDataConnection || columnList == null || columnList.size() < 1){
	propagateRecordset = "false";
}

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    
if(("true").equals(propagateRecordset)){
	
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    
}

    stringBuffer.append(TEXT_81);
    
	if (usePrepareStatement) {
		log4jCodeGenerateUtil.logInfo(node,"debug",cid+" - | Prameter Index | Prameter Type | Parameter Value |");
		for (Map<String, String> param : prepareStatementParameters) {
			log4jCodeGenerateUtil.logInfo(node,"debug",cid+" - | "+param.get("PARAMETER_INDEX")+" | "+param.get("PARAMETER_TYPE")+" | \"+"+param.get("PARAMETER_VALUE")+"+\" |");
			if ("Date".equals(param.get("PARAMETER_TYPE"))) {

    stringBuffer.append(TEXT_82);
    stringBuffer.append(param.get("PARAMETER_VALUE"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(param.get("PARAMETER_INDEX"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(param.get("PARAMETER_INDEX"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(param.get("PARAMETER_VALUE"));
    stringBuffer.append(TEXT_88);
    
			} else {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(param.get("PARAMETER_TYPE"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(param.get("PARAMETER_INDEX"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(param.get("PARAMETER_VALUE"));
    stringBuffer.append(TEXT_93);
    
			}
		}
		if(("true").equals(propagateRecordset)){

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    
		} else {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    
		}
	} else {
		if(("true").equals(propagateRecordset)){

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    
		} else {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    
		}
	}
	log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Execute the query: '\" + "+dbquery +" + \"' has finished.");

    	//feature 0010425
	if(usePrepareStatement){
		if ("NB_LINE_INSERTED".equals(use_NB_Line)) {

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    
		} else if ("NB_LINE_UPDATED".equals(use_NB_Line)) {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    
		} else if ("NB_LINE_DELETED".equals(use_NB_Line)) {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    
		}
	} else {
		if ("NB_LINE_INSERTED".equals(use_NB_Line)) {

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
		} else if ("NB_LINE_UPDATED".equals(use_NB_Line)) {

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    
		} else if ("NB_LINE_DELETED".equals(use_NB_Line)) {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    
		}
	}//end feature 0010425

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
		if (("true").equals(dieOnError)) {
			
    stringBuffer.append(TEXT_126);
    
		} else {
			log4jCodeGenerateUtil.logError(node,"error");
			if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
				
    stringBuffer.append(TEXT_127);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_129);
    
				if(incomingConnName!=null){
					for(IMetadataColumn column : columnList) {
						if (inputCols.contains(column.getLabel())) {
						
    stringBuffer.append(TEXT_130);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_134);
    
						}
					}
				}
				
    stringBuffer.append(TEXT_135);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_138);
    
			} else {
				
    stringBuffer.append(TEXT_139);
    
			}
		}
		
    stringBuffer.append(TEXT_140);
    
if(outgoingConns != null && outgoingConns.size() > 0) {
	
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
		for(IConnection outgoingConn : outgoingConns) {
			if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
				if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					
    stringBuffer.append(TEXT_143);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_145);
    
					for(IMetadataColumn column : columnList) {
						if(("true").equals(propagateRecordset) && column.getLabel().equals(recordsetColumn)){
							
    stringBuffer.append(TEXT_146);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    
						} else {
							if(incomingConnName!=null){
								if (inputCols.contains(column.getLabel())) {
						
    stringBuffer.append(TEXT_150);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_154);
    
								}
							}
						}
					}
				}
			}
		}
		
    stringBuffer.append(TEXT_155);
    
}
if(!("true").equals(useExistingConn)) {
	if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
		
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
			log4jCodeGenerateUtil.commit(node);
			
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
	}
}

    stringBuffer.append(TEXT_162);
    return stringBuffer.toString();
  }
}
