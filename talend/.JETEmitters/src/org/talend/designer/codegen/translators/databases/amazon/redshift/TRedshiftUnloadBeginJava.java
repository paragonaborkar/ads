package org.talend.designer.codegen.translators.databases.amazon.redshift;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.MappingTypeRetriever;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TRedshiftUnloadBeginJava
{
  protected static String nl;
  public static synchronized TRedshiftUnloadBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRedshiftUnloadBeginJava result = new TRedshiftUnloadBeginJava();
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
  protected final String TEXT_71 = " = null;";
  protected final String TEXT_72 = NL + "\t \tconn_";
  protected final String TEXT_73 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_74 = "\");";
  protected final String TEXT_75 = NL + "\t\tString driverClass_";
  protected final String TEXT_76 = " = \"com.amazon.redshift.jdbc41.Driver\";" + NL + "\t\tClass.forName(driverClass_";
  protected final String TEXT_77 = ").newInstance();" + NL + "\t\t";
  protected final String TEXT_78 = NL + "\t\t\tString url_";
  protected final String TEXT_79 = " = \"jdbc:redshift://\" + ";
  protected final String TEXT_80 = " + \":\" + ";
  protected final String TEXT_81 = " + \"/\" + ";
  protected final String TEXT_82 = ";" + NL + "\t\t";
  protected final String TEXT_83 = NL + "\t\t\tString url_";
  protected final String TEXT_84 = " = \"jdbc:redshift://\" + ";
  protected final String TEXT_85 = " + \":\" + ";
  protected final String TEXT_86 = " + \"/\" + ";
  protected final String TEXT_87 = " + \"?\" + ";
  protected final String TEXT_88 = ";" + NL + "\t\t";
  protected final String TEXT_89 = NL + "\t\t";
  protected final String TEXT_90 = " " + NL + "\t\tfinal String decryptedPass_";
  protected final String TEXT_91 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_92 = ");" + NL + "\t\t";
  protected final String TEXT_93 = NL + "\t\tfinal String decryptedPass_";
  protected final String TEXT_94 = " = ";
  protected final String TEXT_95 = "; " + NL + "\t\t";
  protected final String TEXT_96 = NL + "\t\tString dbUser_";
  protected final String TEXT_97 = " = ";
  protected final String TEXT_98 = ";" + NL + "\t\tString dbPwd_";
  protected final String TEXT_99 = " = decryptedPass_";
  protected final String TEXT_100 = ";" + NL + "\t\t";
  protected final String TEXT_101 = NL + "\tStringBuilder command_";
  protected final String TEXT_102 = " = new StringBuilder();";
  protected final String TEXT_103 = NL + "\t\tchar fieldSeparator_";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = NL + "\t\t',';";
  protected final String TEXT_106 = NL + "\t\tString.valueOf(";
  protected final String TEXT_107 = ").charAt(0);";
  protected final String TEXT_108 = NL + "\tcommand_";
  protected final String TEXT_109 = ".append(\"UNLOAD ('\").append(";
  protected final String TEXT_110 = ").append(\"') TO \");";
  protected final String TEXT_111 = NL + "\t";
  protected final String TEXT_112 = " " + NL + "\tfinal String decryptedPwd_";
  protected final String TEXT_113 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_114 = ");" + NL + "\t";
  protected final String TEXT_115 = NL + "\tfinal String decryptedPwd_";
  protected final String TEXT_116 = " = ";
  protected final String TEXT_117 = "; " + NL + "\t";
  protected final String TEXT_118 = NL + "\tcommand_";
  protected final String TEXT_119 = ".append(\"'s3://\").append(";
  protected final String TEXT_120 = ").append(\"/\").append(";
  protected final String TEXT_121 = ").append(\"' \")" + NL + "\t.append(\"credentials 'aws_access_key_id=\").append(";
  protected final String TEXT_122 = ").append(\";aws_secret_access_key=\").append(decryptedPwd_";
  protected final String TEXT_123 = ")";
  protected final String TEXT_124 = NL + "\t\t.append(\";master_symmetric_key=\").append(";
  protected final String TEXT_125 = ")";
  protected final String TEXT_126 = NL + "\t.append(\"' \")";
  protected final String TEXT_127 = NL + "\t\t.append(\"ENCRYPTED \")";
  protected final String TEXT_128 = NL + "\t\t.append(\"ADDQUOTES \")";
  protected final String TEXT_129 = NL + "\t\t.append(\"DELIMITER '\").append(fieldSeparator_";
  protected final String TEXT_130 = ").append(\"' \")";
  protected final String TEXT_131 = NL + "\t\t.append(\"FIXEDWIDTH '\").append(";
  protected final String TEXT_132 = ").append(\"' \")";
  protected final String TEXT_133 = NL + "\t\t.append(\"";
  protected final String TEXT_134 = " \")";
  protected final String TEXT_135 = NL + "\t\t.append(\"ESCAPE \")";
  protected final String TEXT_136 = NL + "\t\t.append(\"ALLOWOVERWRITE \")";
  protected final String TEXT_137 = NL + "\t\t.append(\"PARALLEL OFF \")";
  protected final String TEXT_138 = NL + "\t\t.append(\"NULL '\").append(";
  protected final String TEXT_139 = ").append(\"' \")";
  protected final String TEXT_140 = NL + "\t;" + NL + "\t" + NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_141 = "=conn_";
  protected final String TEXT_142 = ".createStatement();" + NL + "\tstmt_";
  protected final String TEXT_143 = ".execute(command_";
  protected final String TEXT_144 = ".toString());" + NL + "\t";
  protected final String TEXT_145 = NL + "\t\tlog.info(\"";
  protected final String TEXT_146 = " - Finish unloading data to s3.\");" + NL + "\t";
  protected final String TEXT_147 = NL;

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
	String port = ElementParameterParser.getValue(node, "__PORT__");
	String dbName = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String table = ElementParameterParser.getValue(node, "__TABLE__");
	String userName = ElementParameterParser.getValue(node, "__USER__");
	
	String dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
	
	String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
	
	boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
	if(useExistingConnection) {
		String conn = "conn_" + ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_74);
    
		log4jCodeGenerateUtil.useExistConnection(node);
	} else {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
		if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {
		
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(dbName);
    stringBuffer.append(TEXT_82);
    
		} else {
		
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dbName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_88);
    
		}
		String passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_89);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_92);
    } else {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_95);
    }
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
		log4jCodeGenerateUtil.connect(node);
	}
	
	boolean	log4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String fieldSeparator = ElementParameterParser.getValue(node,"__FIELDSEPARATOR__");
	String exportType = ElementParameterParser.getValue(node, "__EXPORT_TYPE__");

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
	if("DELIMITED_OR_CSV".equals(exportType)) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    
		if(fieldSeparator.trim().isEmpty()) {

    stringBuffer.append(TEXT_105);
    
		} else {

    stringBuffer.append(TEXT_106);
    stringBuffer.append(fieldSeparator.trim());
    stringBuffer.append(TEXT_107);
    
		}
	}

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_110);
    
	String bucket = ElementParameterParser.getValue(node,"__BUCKET__");
    String keyPrefix = ElementParameterParser.getValue(node,"__OBJECTS_PREFIX__");
    String access_key = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
    String passwordFieldKey = "__SECRET_KEY__";

    stringBuffer.append(TEXT_111);
    if (ElementParameterParser.canEncrypt(node, passwordFieldKey)) {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldKey));
    stringBuffer.append(TEXT_114);
    } else {
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldKey));
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(keyPrefix);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(access_key);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
	boolean encrypt = "true".equals(ElementParameterParser.getValue(node, "__ENCRYPT__"));
	if(encrypt) {
		String encryptedKey = ElementParameterParser.getValue(node,"__ENCRYPTED_KEY__");

    stringBuffer.append(TEXT_124);
    stringBuffer.append(encryptedKey);
    stringBuffer.append(TEXT_125);
    
	}

    stringBuffer.append(TEXT_126);
    
	if(encrypt) {

    stringBuffer.append(TEXT_127);
    
	}
	
	if("DELIMITED_OR_CSV".equals(exportType)) {
		if("DOUBLE_QUOTE".equals(ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__"))) {

    stringBuffer.append(TEXT_128);
    
		}

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
	} else if("FIXEDWIDTH".equals(exportType)) {
		String mapping = ElementParameterParser.getValue(node, "__FIXEDWIDTH_MAPPING__");

    stringBuffer.append(TEXT_131);
    stringBuffer.append(mapping);
    stringBuffer.append(TEXT_132);
    
	}
	
	boolean compressed = "true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"));
	if(compressed) {
		String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");

    stringBuffer.append(TEXT_133);
    stringBuffer.append(compression);
    stringBuffer.append(TEXT_134);
    
	}
	
	boolean escape = "true".equals(ElementParameterParser.getValue(node, "__ESCAPE__"));
	if(escape) {

    stringBuffer.append(TEXT_135);
    
	}
	
	boolean allowOverwrite = "true".equals(ElementParameterParser.getValue(node, "__ALLOWOVERWRITE__"));
	if(allowOverwrite) {

    stringBuffer.append(TEXT_136);
    
	}
	
	boolean parallel = "true".equals(ElementParameterParser.getValue(node, "__PARALLEL__"));
	if(!parallel) {

    stringBuffer.append(TEXT_137);
    
	}
	
	boolean specifyNullString = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_NULL_STRING__"));
	if(specifyNullString) {
		String nullString = ElementParameterParser.getValue(node, "__NULL_STRING__");

    stringBuffer.append(TEXT_138);
    stringBuffer.append(nullString);
    stringBuffer.append(TEXT_139);
    
	}

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    if(log4jEnabled){
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    }
    
	if(!useExistingConnection) {
		log4jCodeGenerateUtil.close(node);
	}

    stringBuffer.append(TEXT_147);
    return stringBuffer.toString();
  }
}
