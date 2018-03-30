package org.talend.designer.codegen.translators.databases.oledb;

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

public class TOleDbRowMainJava
{
  protected static String nl;
  public static synchronized TOleDbRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOleDbRowMainJava result = new TOleDbRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "                if(log.is";
  protected final String TEXT_3 = "Enabled())";
  protected final String TEXT_4 = NL + "            log.";
  protected final String TEXT_5 = "(\"";
  protected final String TEXT_6 = " - \" ";
  protected final String TEXT_7 = " + (";
  protected final String TEXT_8 = ") ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "    \tclass BytesLimit65535_";
  protected final String TEXT_11 = "{" + NL + "    \t\tpublic void limitLog4jByte() throws Exception{" + NL + "    \t\t\t";
  protected final String TEXT_12 = NL + "            StringBuilder ";
  protected final String TEXT_13 = " = new StringBuilder();";
  protected final String TEXT_14 = NL + "            ";
  protected final String TEXT_15 = ".append(\"Parameters:\");";
  protected final String TEXT_16 = NL + "                    ";
  protected final String TEXT_17 = ".append(\"";
  protected final String TEXT_18 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_19 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_20 = NL + "                    ";
  protected final String TEXT_21 = ".append(\"";
  protected final String TEXT_22 = "\" + \" = \" + ";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "                ";
  protected final String TEXT_25 = ".append(\" | \");";
  protected final String TEXT_26 = NL + "    \t\t}" + NL + "    \t}" + NL + "    \t" + NL + "        new BytesLimit65535_";
  protected final String TEXT_27 = "().limitLog4jByte();";
  protected final String TEXT_28 = NL + "            StringBuilder ";
  protected final String TEXT_29 = " = new StringBuilder();    ";
  protected final String TEXT_30 = NL + "                    ";
  protected final String TEXT_31 = ".append(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "                    if(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = " == null){";
  protected final String TEXT_37 = NL + "                        ";
  protected final String TEXT_38 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_39 = NL + "                        ";
  protected final String TEXT_40 = ".append(";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ");" + NL + "                    }   ";
  protected final String TEXT_43 = NL + "                ";
  protected final String TEXT_44 = ".append(\"|\");";
  protected final String TEXT_45 = NL + "    ";
  protected final String TEXT_46 = NL + "    ";
  protected final String TEXT_47 = " = null;            ";
  protected final String TEXT_48 = NL + "query_";
  protected final String TEXT_49 = " = ";
  protected final String TEXT_50 = ";" + NL + "whetherReject_";
  protected final String TEXT_51 = " = false;";
  protected final String TEXT_52 = NL + "    globalMap.put(\"";
  protected final String TEXT_53 = "_QUERY\",query_";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\torg.talend.net.Object rs_";
  protected final String TEXT_56 = " = null;";
  protected final String TEXT_57 = NL + "    try {";
  protected final String TEXT_58 = NL + "\torg.talend.net.Object param_";
  protected final String TEXT_59 = ";" + NL + "\tObject val_";
  protected final String TEXT_60 = ";" + NL + "\t";
  protected final String TEXT_61 = NL + "\t\t\t\t    param_";
  protected final String TEXT_62 = " = cmd_";
  protected final String TEXT_63 = ".invoke(\"CreateParameter\");" + NL + "                    val_";
  protected final String TEXT_64 = " = ";
  protected final String TEXT_65 = ";" + NL + "                    param_";
  protected final String TEXT_66 = ".mutateProperty(\"Value\",val_";
  protected final String TEXT_67 = ");" + NL + "                    cmd_";
  protected final String TEXT_68 = ".accessProperty(\"Parameters\",";
  protected final String TEXT_69 = ")" + NL + "                    \t.invoke(\"Add\",new java.lang.Object[] {";
  protected final String TEXT_70 = ", param_";
  protected final String TEXT_71 = " });" + NL + "\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\trs_";
  protected final String TEXT_73 = " = cmd_";
  protected final String TEXT_74 = ".invoke(\"ExecuteReader\");" + NL + "\t\t\tcmd_";
  protected final String TEXT_75 = ".accessProperty(\"Parameters\",";
  protected final String TEXT_76 = ")" + NL + "                    \t.invoke(\"Clear\");";
  protected final String TEXT_77 = NL + "    \t\tcmd_";
  protected final String TEXT_78 = ".invoke(\"ExecuteNonQuery\");" + NL + "    \t\tcmd_";
  protected final String TEXT_79 = ".accessProperty(\"Parameters\",";
  protected final String TEXT_80 = ")" + NL + "                    \t.invoke(\"Clear\");";
  protected final String TEXT_81 = NL + "\t\t\tcmd_";
  protected final String TEXT_82 = " = org.talend.net.Object.createInstance(";
  protected final String TEXT_83 = ", \"System.Data.OleDb.OleDbCommand\", new java.lang.Object[] { query_";
  protected final String TEXT_84 = ",conn_";
  protected final String TEXT_85 = " });" + NL + "\t\t\trs_";
  protected final String TEXT_86 = " = cmd_";
  protected final String TEXT_87 = ".invoke(\"ExecuteReader\");";
  protected final String TEXT_88 = NL + "\t\t\tcmd_";
  protected final String TEXT_89 = " = org.talend.net.Object.createInstance(";
  protected final String TEXT_90 = ", \"System.Data.OleDb.OleDbCommand\", new java.lang.Object[] { query_";
  protected final String TEXT_91 = ",conn_";
  protected final String TEXT_92 = " });" + NL + "    \t\tcmd_";
  protected final String TEXT_93 = ".invoke(\"ExecuteNonQuery\");";
  protected final String TEXT_94 = NL + "    } catch (java.lang.Exception e) {        " + NL + "\t\twhetherReject_";
  protected final String TEXT_95 = " = true;";
  protected final String TEXT_96 = NL + "            throw(e);";
  protected final String TEXT_97 = NL + "            ";
  protected final String TEXT_98 = " = new ";
  protected final String TEXT_99 = "Struct();";
  protected final String TEXT_100 = NL + "\t               ";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = " = ";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = ";";
  protected final String TEXT_105 = NL + "           \t";
  protected final String TEXT_106 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_107 = ";";
  protected final String TEXT_108 = NL + "\t\t\t";
  protected final String TEXT_109 = NL + "         \tSystem.err.print(e.getMessage());";
  protected final String TEXT_110 = NL + "    }" + NL + "\t";
  protected final String TEXT_111 = NL + "        if(!whetherReject_";
  protected final String TEXT_112 = ") {";
  protected final String TEXT_113 = NL + "                        ";
  protected final String TEXT_114 = " = new ";
  protected final String TEXT_115 = "Struct();";
  protected final String TEXT_116 = NL;
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = " = rs_";
  protected final String TEXT_119 = ";";
  protected final String TEXT_120 = NL;
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = " = ";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = ";";
  protected final String TEXT_125 = NL + "        }";
  protected final String TEXT_126 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_3);
    
            }
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_6);
    for(String message : messages){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
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
    
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
       			 if(log4jEnabled){
       			 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_15);
    
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
                    
    stringBuffer.append(TEXT_16);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_19);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    
    stringBuffer.append(TEXT_20);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_23);
    
                }   
                
    stringBuffer.append(TEXT_24);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_25);
    
            }
        }
		debug(var("log4jParamters"));
		
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_28);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_29);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_30);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_33);
    
                }else{
                
    stringBuffer.append(TEXT_34);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_42);
    
                }
                
    stringBuffer.append(TEXT_43);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_44);
    
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

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid =  node.getUniqueName();
LogUtil logtpl = new LogUtil(node);
String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
String propagateRecordset = ElementParameterParser.getValue(node,"__PROPAGATE_RECORD_SET__");
String recordsetColumn = ElementParameterParser.getValue(node,"__RECORD_SET_COLUMN__");
boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
		dbquery = dbquery.replaceAll("\n"," ");
		dbquery = dbquery.replaceAll("\r"," ");
String assemblyName = ElementParameterParser.getValue(node,"__ASSEMBLY_NAME__");
String className = ElementParameterParser.getValue(node,"__CLASS_NAME__");
List<Map<String, String>> prepareStatementParameters = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SET_PREPAREDSTATEMENT_PARAMETERS__");
String incomingConnName = null;

Set<String> inputCols = new HashSet<String>();

String oleDbParamCollClassName = "\"System.Data.OleDb.OleDbParameterCollection, System.Data, "
    	+ "Version=2.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089\"";
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

    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
          }
}


    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
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
	
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    
	if(("true").equals(propagateRecordset)){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    
	}

    stringBuffer.append(TEXT_57);
    
	logtpl.info("\"Try to execute query.\"");
	logtpl.debug("\"Query string: \"",logtpl.var("query"),"\".\"");
	if (usePrepareStatement){
	
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
		for (Map<String, String> param : prepareStatementParameters){
			

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(param.get("PARAMETER_VALUE"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(oleDbParamCollClassName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(param.get("PARAMETER_INDEX"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
			
		}
		if(("true").equals(propagateRecordset)){

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(oleDbParamCollClassName);
    stringBuffer.append(TEXT_76);
    
		}else{

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(oleDbParamCollClassName);
    stringBuffer.append(TEXT_80);
    
		}
	}else{
		if(("true").equals(propagateRecordset)){

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(assemblyName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    
		}else{

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(assemblyName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    
		}
	}
	logtpl.info("\"Execute query successfully.\"");

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
	if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_96);
    
	} else {
        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_99);
    
            if(incomingConnName!=null){
	        	for(IMetadataColumn column : columnList) {
	        		if (inputCols.contains(column.getLabel())) {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_104);
    
					}
	            }
            }

    stringBuffer.append(TEXT_105);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_107);
    
         } else {

    stringBuffer.append(TEXT_108);
    logtpl.logPrintedException("e.getMessage()");
    stringBuffer.append(TEXT_109);
    
         }
	}

    stringBuffer.append(TEXT_110);
    
	
    if(outgoingConns != null && outgoingConns.size() > 0) {
        
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
            for(IConnection outgoingConn : outgoingConns) {
                if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                    if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
         
    stringBuffer.append(TEXT_113);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_115);
    
                        for(IMetadataColumn column : columnList) {
                        	if(("true").equals(propagateRecordset) && column.getLabel().equals(recordsetColumn)){

    stringBuffer.append(TEXT_116);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    
                        	}else{
                        		if(incomingConnName!=null){
                        			if (inputCols.contains(column.getLabel())) {
                            
    stringBuffer.append(TEXT_120);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_124);
    
									}
								}
							}
                        }
                    }
                }
            }
        
    stringBuffer.append(TEXT_125);
    
    }

    stringBuffer.append(TEXT_126);
    return stringBuffer.toString();
  }
}
