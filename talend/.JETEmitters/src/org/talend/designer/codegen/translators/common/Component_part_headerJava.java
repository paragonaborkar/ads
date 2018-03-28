package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.INode;
import org.talend.core.model.temp.ECodePart;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Component_part_headerJava
{
  protected static String nl;
  public static synchronized Component_part_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Component_part_headerJava result = new Component_part_headerJava();
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
  protected final String TEXT_45 = NL + "\t" + NL + "\t/**" + NL + "\t * [";
  protected final String TEXT_46 = " ";
  protected final String TEXT_47 = " ] start" + NL + "\t */" + NL + "" + NL + "\t";
  protected final String TEXT_48 = NL + "\t\t\t\tTalendThreadPool mtp_";
  protected final String TEXT_49 = " = new TalendThreadPool(";
  protected final String TEXT_50 = ");" + NL + "" + NL + "\t\t\t\tglobalMap.put(\"lockWrite_";
  protected final String TEXT_51 = "\", new Object[0]);" + NL + "\t\t\t\tint threadIdCounter_";
  protected final String TEXT_52 = " =0;" + NL + "\t\t\t";
  protected final String TEXT_53 = "\t\t\t" + NL + "\t\t\tint NB_ITERATE_";
  protected final String TEXT_54 = " = 0; //for statistics" + NL + "\t\t\t";
  protected final String TEXT_55 = NL + NL + "\t";
  protected final String TEXT_56 = NL + "\t\t";
  protected final String TEXT_57 = NL + "\t\t\tglobalMap.put(\"ENABLE_TRACES_CONNECTION_";
  protected final String TEXT_58 = "\",Boolean.FALSE);" + NL + "\t\t";
  protected final String TEXT_59 = NL + "\t\tok_Hash.put(\"";
  protected final String TEXT_60 = "\", false);" + NL + "\t\tstart_Hash.put(\"";
  protected final String TEXT_61 = "\", System.currentTimeMillis());" + NL + "\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t";
  protected final String TEXT_63 = ".addMessage(\"begin\",\"";
  protected final String TEXT_64 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_65 = "Process(globalMap);" + NL + "\t\t\t";
  protected final String TEXT_66 = NL + "    \t\t\t\t";
  protected final String TEXT_67 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_68 = ".addLineToRow(\"";
  protected final String TEXT_69 = "_count\");" + NL + "    \t\t\t\t\t";
  protected final String TEXT_70 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_71 = ".addLineToRow(\"";
  protected final String TEXT_72 = "_count\");" + NL + "    \t\t\t\t\t";
  protected final String TEXT_73 = NL + "\t";
  protected final String TEXT_74 = NL + "\t\tcurrentVirtualComponent = \"";
  protected final String TEXT_75 = "\";" + NL + "\t";
  protected final String TEXT_76 = NL + "\tcurrentComponent=\"";
  protected final String TEXT_77 = "\";" + NL + "" + NL + "\t";
  protected final String TEXT_78 = NL + "\t\t\tif (execStat) {" + NL + "\t\t\t\tif(resourceMap.get(\"inIterateVComp\") == null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\t    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap_";
  protected final String TEXT_80 = " = (java.util.concurrent.ConcurrentHashMap) globalMap.get(\"concurrentHashMap\");" + NL + "\t\t\t\t\t\tconcurrentHashMap_";
  protected final String TEXT_81 = ".putIfAbsent(\"";
  protected final String TEXT_82 = "\" + iterateLoop,new java.util.concurrent.atomic.AtomicInteger(0));" + NL + "\t\t\t\t\t\tjava.util.concurrent.atomic.AtomicInteger stats_";
  protected final String TEXT_83 = " = (java.util.concurrent.atomic.AtomicInteger) concurrentHashMap_";
  protected final String TEXT_84 = ".get(\"";
  protected final String TEXT_85 = "\" + iterateLoop);" + NL + "\t\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_86 = "\" + iterateId, stats_";
  protected final String TEXT_87 = ".incrementAndGet()<=1?0:1, 0);" + NL + "\t\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_89 = "\" + iterateId, 0, 0);" + NL + "\t\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\t}" + NL + "\t\t\t} " + NL + "" + NL + "\t\t";
  protected final String TEXT_91 = NL + NL + "\t\t\t//";
  protected final String TEXT_92 = NL + "\t\t\t//";
  protected final String TEXT_93 = NL + NL + NL + "\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\tif(execStat){" + NL + "\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_95 = "\"+iterateId,1, 1);" + NL + "\t\t\t\t} " + NL + "\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\tif(execStat){" + NL + "\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_97 = "\"+iterateId,1, 1);" + NL + "\t\t\t\t} " + NL + "\t\t\t";
  protected final String TEXT_98 = NL + NL + "\t\t";
  protected final String TEXT_99 = NL + "    \t\t\tif(log.isTraceEnabled()){" + NL + "    \t\t\t\tlog.trace(\"";
  protected final String TEXT_100 = " - \" + (";
  protected final String TEXT_101 = "==null? \"\": ";
  protected final String TEXT_102 = ".toLogString()));" + NL + "    \t\t\t}" + NL + "    \t\t";
  protected final String TEXT_103 = NL + "\t\tint tos_count_";
  protected final String TEXT_104 = " = 0;" + NL + "\t\t";
  protected final String TEXT_105 = NL + "\t\t\t\tif(execStat){" + NL + "\t\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\t\t\t\t\tjava.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap_";
  protected final String TEXT_108 = " = (java.util.concurrent.ConcurrentHashMap) globalMap.get(\"concurrentHashMap\");" + NL + "\t\t\t\t\t\t\tconcurrentHashMap_";
  protected final String TEXT_109 = ".putIfAbsent(\"";
  protected final String TEXT_110 = "\" + iterateLoop,new java.util.concurrent.atomic.AtomicInteger(0));" + NL + "\t\t\t\t\t\t\tjava.util.concurrent.atomic.AtomicInteger stats_";
  protected final String TEXT_111 = " = (java.util.concurrent.atomic.AtomicInteger) concurrentHashMap_";
  protected final String TEXT_112 = ".get(\"";
  protected final String TEXT_113 = "\" + iterateLoop);" + NL + "\t\t\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_114 = "\" + iterateId, stats_";
  protected final String TEXT_115 = ".incrementAndGet()<=1?0:1, 0);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_117 = "\" + iterateId, 0, 0);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_118 = NL + "\t\t\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\tresourceMap.put(\"inIterateVComp\", true);" + NL + "\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\t\tresourceMap.remove(\"inIterateVComp\");" + NL + "\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\t\t\t\tresourceMap.remove(\"inIterateVComp\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\t\t\t\t\tresourceMap.put(\"inIterateVComp\", true);" + NL + "\t\t\t\t\t";
  protected final String TEXT_124 = NL;

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
	log = new LogUtil(node);
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	boolean containsTPartitioner = node.getProcess().getNodesOfType("tPartitioner").size() > 0 ? true : false;
	String startNodeCid=node.getDesignSubjobStartNode().getUniqueName();
	ECodePart codePart = codeGenArgument.getCodePart();
	boolean trace = codeGenArgument.isTrace();
	boolean stat = codeGenArgument.isStatistics();
	Set<IConnection> connSet =  new HashSet<IConnection>();
	connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MAIN));
	connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MERGE));
	String incomingName = codeGenArgument.getIncomingName();
	
	Set<IConnection> iterateConnSet =  new HashSet<IConnection>();
	iterateConnSet.addAll(node.getOutgoingConnections(EConnectionType.ITERATE));
	
	List<IConnection> allSubProcessConnection = codeGenArgument.getAllMainSubTreeConnections();

    stringBuffer.append(TEXT_45);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(codePart );
    stringBuffer.append(TEXT_47);
    
    //This part in order to feedback with the iterate_subprocess_header.javajet and iterate_subprocess_footer.javajet
    
	if (codePart.equals(ECodePart.BEGIN)) {
		boolean parallelIterate = false;
		boolean hasParallelIterate = false;
		for (IConnection iterateConn : iterateConnSet) { 
			parallelIterate = "true".equals(ElementParameterParser.getValue(iterateConn, "__ENABLE_PARALLEL__"));
			String iterateNodeName = iterateConn.getTarget().getUniqueName();
	        if (parallelIterate) {
			
    stringBuffer.append(TEXT_48);
    stringBuffer.append(iterateConn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(ElementParameterParser.getValue(iterateConn,"__NUMBER_PARALLEL__") );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(iterateNodeName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(iterateNodeName);
    stringBuffer.append(TEXT_52);
    
			}
			
    stringBuffer.append(TEXT_53);
    stringBuffer.append(iterateNodeName );
    stringBuffer.append(TEXT_54);
    			
			continue;
		}
	}	
	
    stringBuffer.append(TEXT_55);
    
	if (codePart.equals(ECodePart.BEGIN)) {
	
    stringBuffer.append(TEXT_56);
    
		if(trace){ 
		
    stringBuffer.append(TEXT_57);
    stringBuffer.append(startNodeCid);
    stringBuffer.append(TEXT_58);
    
		}
		
    stringBuffer.append(TEXT_59);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_61);
    
		String statCatcher = ElementParameterParser.getValue(node,"__TSTATCATCHER_STATS__");
		if ((node.getProcess().getNodesOfType("tStatCatcher").size() > 0) && (statCatcher.equals("true"))) {
			for (INode statCatcherNode : node.getProcess().getNodesOfType("tStatCatcher")) {
			
    stringBuffer.append(TEXT_62);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(statCatcherNode.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_65);
    
			}
		}
	}
	if(codePart.equals(ECodePart.MAIN)) {
		List<INode> meterCatchers = (List<INode>)node.getProcess().getNodesOfType("tFlowMeterCatcher");	
	    if ((node.getProcess().getNodesOfType("tFlowMeter").size() > 0)){
        	for(IConnection temp_conn : node.getIncomingConnections(EConnectionType.FLOW_MAIN)){
        	    String name_conn = temp_conn.getUniqueName();
        	    if(temp_conn.isUseByMetter()){ 	    	
				
    stringBuffer.append(TEXT_66);
    
		            if (meterCatchers != null) {
		        		for (INode meterCatcher : meterCatchers) {
    					
    stringBuffer.append(TEXT_67);
    stringBuffer.append(meterCatcher.getUniqueName() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(name_conn);
    stringBuffer.append(TEXT_69);
    
		        		}
		        	}
				}
			}
			
			for(IConnection temp_conn : node.getIncomingConnections(EConnectionType.FLOW_MERGE)){
        	    String name_conn = temp_conn.getUniqueName();
        	    if(name_conn == incomingName && temp_conn.isUseByMetter()){ 	    	
            		if (meterCatchers != null) {
		        		for (INode meterCatcher : meterCatchers) {
    					
    stringBuffer.append(TEXT_70);
    stringBuffer.append(meterCatcher.getUniqueName() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(name_conn);
    stringBuffer.append(TEXT_72);
    
		        		}
		        	}
				}
			}			
	    }
	}
	
    stringBuffer.append(TEXT_73);
    
	if(node.isVirtualGenerateNode()){
	
    stringBuffer.append(TEXT_74);
    stringBuffer.append(NodeUtil.getVirtualUniqueName(node));
    stringBuffer.append(TEXT_75);
    
	}
	
    stringBuffer.append(TEXT_76);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_77);
    
	connSet =  new HashSet<IConnection>();
	connSet.addAll(node.getIncomingConnections(EConnectionType.FLOW_MAIN));
	connSet.addAll(node.getIncomingConnections(EConnectionType.FLOW_MERGE));

	if ((codePart.equals(ECodePart.BEGIN))&&(stat)&&connSet.size()>0) {
		for(IConnection con:connSet){
		
    stringBuffer.append(TEXT_78);
    if(containsTPartitioner){
    stringBuffer.append(TEXT_79);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_87);
    }else{
    stringBuffer.append(TEXT_88);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    
		}
	}
	
	if((codePart.equals(ECodePart.MAIN))&&(stat)&&connSet.size()>0){
		for(IConnection con:connSet){
		
    stringBuffer.append(TEXT_91);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append((String)codeGenArgument.getIncomingName());
    stringBuffer.append(TEXT_93);
    if (!node.getComponent().useMerge()) {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_95);
    
			} else if(con.getUniqueName().equals((String)codeGenArgument.getIncomingName())){
			
    stringBuffer.append(TEXT_96);
    stringBuffer.append(con.getUniqueName() );
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    
		}
	}
	Set<IConnection> connSetForLog =  new HashSet<IConnection>();
	connSetForLog.addAll(node.getIncomingConnections(EConnectionType.FLOW_MAIN));
	connSetForLog.addAll(node.getIncomingConnections(EConnectionType.FLOW_MERGE));
	if((codePart.equals(ECodePart.MAIN)) && isLog4jEnabled && connSetForLog.size()>0){
		if(!(node.isVirtualGenerateNode() && node.getVirtualLinkTo()==null)){//ignore the connector in virtual component
    		for(IConnection con:connSetForLog){
    		
    stringBuffer.append(TEXT_99);
    stringBuffer.append(con.getUniqueName());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(con.getName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(con.getName());
    stringBuffer.append(TEXT_102);
    
    		}
    	}
	}
	if(codePart.equals(ECodePart.BEGIN)){ 
	
    stringBuffer.append(TEXT_103);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_104);
    
		log.startWork();
		log.logCompSetting();
	}
	if(stat){
		boolean iterateInVFComp = (node.getVirtualLinkTo() != null && node.getVirtualLinkTo() == EConnectionType.ITERATE);
		if(iterateInVFComp){
			if(codePart.equals(ECodePart.BEGIN)){
				List<String> needToStartConnNames = new ArrayList<String>();
				INode nextNode = node.getOutgoingConnections(EConnectionType.ITERATE).get(0).getTarget();
				NodeUtil.fillConnectionsForStat(needToStartConnNames, nextNode);
				
    stringBuffer.append(TEXT_105);
    
					for(String connName : needToStartConnNames){
					
    stringBuffer.append(TEXT_106);
    if(containsTPartitioner){
    stringBuffer.append(TEXT_107);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_115);
    }else{
    stringBuffer.append(TEXT_116);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    	
					}
					
    stringBuffer.append(TEXT_119);
    
			}else if(codePart.equals(ECodePart.MAIN)){ 
			
    stringBuffer.append(TEXT_120);
    
			}else if(codePart.equals(ECodePart.END)){
			
    stringBuffer.append(TEXT_121);
    
			} 
		}else{
			IConnection preIterate = (node.getIncomingConnections(EConnectionType.ITERATE) != null && node.getIncomingConnections(EConnectionType.ITERATE).size() == 1) ? node.getIncomingConnections(EConnectionType.ITERATE).get(0) : null;
			if(preIterate != null){
				boolean iterateInVSComp = (preIterate.getSource().getVirtualLinkTo() != null && preIterate.getSource().getVirtualLinkTo() == EConnectionType.ITERATE);
				if(iterateInVSComp){
					if(codePart.equals(ECodePart.BEGIN)){ 
					
    stringBuffer.append(TEXT_122);
    
					}else if(codePart.equals(ECodePart.END)){
					
    stringBuffer.append(TEXT_123);
    
					}
				}
			}	
		}
	}
	
    stringBuffer.append(TEXT_124);
    return stringBuffer.toString();
  }
}
