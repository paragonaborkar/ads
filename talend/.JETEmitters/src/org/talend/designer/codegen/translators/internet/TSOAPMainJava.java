package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;

public class TSOAPMainJava
{
  protected static String nl;
  public static synchronized TSOAPMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSOAPMainJava result = new TSOAPMainJava();
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
  protected final String TEXT_45 = NL + "\tif(true)" + NL + "\t\tthrow new java.lang.Exception(\"There is no incoming connection or the incoming schema is empty\");";
  protected final String TEXT_46 = NL + "\t\tclass TalendPrivilegedAction implements java.security.PrivilegedAction{" + NL + "\t\t\tString soapVersion;" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t";
  protected final String TEXT_48 = "Struct ";
  protected final String TEXT_49 = ";" + NL + "" + NL + "\t\t\t\tpublic TalendPrivilegedAction(";
  protected final String TEXT_50 = "Struct rowArg, String soapVersionArg){" + NL + "\t\t\t\t\tthis.";
  protected final String TEXT_51 = " = rowArg;" + NL + "\t\t\t\t\tthis.soapVersion = soapVersionArg;" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\tpublic TalendPrivilegedAction(String soapVersionArg){" + NL + "\t\t\t\t\tthis.soapVersion = soapVersionArg;" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\tString document;" + NL + "\t\t\t\tpublic Object run(){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tthis.document = soapUtil_";
  protected final String TEXT_54 = ".extractContentAsDocument(org.talend.soap.SOAPUtil.";
  protected final String TEXT_55 = ",";
  protected final String TEXT_56 = ",";
  protected final String TEXT_57 = ",";
  protected final String TEXT_58 = ");" + NL + "\t\t\t\t\t}catch(java.lang.Exception ex){" + NL + "\t\t\t\t\t\tex.printStackTrace();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\tpublic Object run(){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tsoapUtil_";
  protected final String TEXT_60 = ".invokeSOAP(org.talend.soap.SOAPUtil.";
  protected final String TEXT_61 = ",";
  protected final String TEXT_62 = ",";
  protected final String TEXT_63 = ",";
  protected final String TEXT_64 = ");" + NL + "\t\t\t\t\t}catch(java.lang.Exception ex){" + NL + "\t\t\t\t\t\tex.printStackTrace();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_65 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_66 = NL + "\t\t\tfinal String soapVersion_";
  protected final String TEXT_67 = " = org.talend.soap.SOAPUtil.SOAP12;" + NL + "\t\t";
  protected final String TEXT_68 = NL + "\t\t\tfinal String soapVersion_";
  protected final String TEXT_69 = " = org.talend.soap.SOAPUtil.SOAP11;" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\tjavax.security.auth.Subject subject_";
  protected final String TEXT_71 = " = (javax.security.auth.Subject)globalMap.get(\"kerberos_subject_";
  protected final String TEXT_72 = "\");" + NL + "\t\tif(subject_";
  protected final String TEXT_73 = "==null){" + NL + "\t\t\tSystem.err.println(\"Subject for Kerberos is null!\");" + NL + "\t\t\t";
  protected final String TEXT_74 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_75 = NL + "\t\tTalendPrivilegedAction talendPrivilegedAction_";
  protected final String TEXT_76 = " = new TalendPrivilegedAction(";
  protected final String TEXT_77 = "soapVersion_";
  protected final String TEXT_78 = ");" + NL + "\t\tjavax.security.auth.Subject.doAs(subject_";
  protected final String TEXT_79 = ",talendPrivilegedAction_";
  protected final String TEXT_80 = ");" + NL + "\t\t";
  protected final String TEXT_81 = NL + "\t\t";
  protected final String TEXT_82 = NL + "\t\t\tString document_";
  protected final String TEXT_83 = " = talendPrivilegedAction_";
  protected final String TEXT_84 = ".document;" + NL + "\t\t";
  protected final String TEXT_85 = NL + "\t";
  protected final String TEXT_86 = NL + "\t\t";
  protected final String TEXT_87 = NL + "\t\t";
  protected final String TEXT_88 = NL + "\t\t\tString document_";
  protected final String TEXT_89 = " = soapUtil_";
  protected final String TEXT_90 = ".extractContentAsDocument(org.talend.soap.SOAPUtil.";
  protected final String TEXT_91 = ",";
  protected final String TEXT_92 = ",";
  protected final String TEXT_93 = ",";
  protected final String TEXT_94 = ");" + NL + "\t\t";
  protected final String TEXT_95 = NL + "\t\t\tsoapUtil_";
  protected final String TEXT_96 = ".invokeSOAP(org.talend.soap.SOAPUtil.";
  protected final String TEXT_97 = ",";
  protected final String TEXT_98 = ",";
  protected final String TEXT_99 = ",";
  protected final String TEXT_100 = ");" + NL + "\t\t";
  protected final String TEXT_101 = NL + "\t\t";
  protected final String TEXT_102 = NL + "\t";
  protected final String TEXT_103 = NL + NL + "\t// for output" + NL + "\t";
  protected final String TEXT_104 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_105 = " = new ";
  protected final String TEXT_106 = "Struct();" + NL + "\t\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\t\t\t";
  protected final String TEXT_108 = ".Soap = ParserUtils.parseTo_Document(document_";
  protected final String TEXT_109 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\t\t";
  protected final String TEXT_111 = ".Header = soapUtil_";
  protected final String TEXT_112 = ".getReHeaderMessage();" + NL + "\t\t\t\t\tif(soapUtil_";
  protected final String TEXT_113 = ".hasFault()){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_114 = ".Fault = soapUtil_";
  protected final String TEXT_115 = ".getReFaultMessage();" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_116 = ".Body = soapUtil_";
  protected final String TEXT_117 = ".getReBodyMessage();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_118 = NL + "        " + NL;
  protected final String TEXT_119 = NL;

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
String cid = node.getUniqueName();
log = new LogUtil(node);
String endpoint = ElementParameterParser.getValue(node,"__ENDPOINT__");
String action = ElementParameterParser.getValue(node,"__ACTION__");
String soapMessageStr = ElementParameterParser.getValue(node,"__SOAPMESSAGE__");
soapMessageStr = soapMessageStr.replaceAll("[\r\n]", " ");
        
String soapVersion = ElementParameterParser.getValue(node,"__SOAP_VERSION__");

boolean useKerberos = ("true").equals(ElementParameterParser.getValue(node,"__USE_KERBEROS__"));
String kerberosConfiguration = ElementParameterParser.getValue(node,"__KERBEROS_CONFIGURATION__");
boolean useMessageFromSchema = "true".equals(ElementParameterParser.getValue(node, "__USE_MESSAGE_FROM_SCHEMA__"));
boolean outputDocument = "true".equals(ElementParameterParser.getValue(node, "__OUTPUT_DOCUMENT__"));
String soapMessageColumn = ElementParameterParser.getValue(node,"__SOAPMESSAGE_FROM_SCHEMA__");
String connName = null;
boolean schemaEmpty = false;
if(node.getIncomingConnections().size() > 0){
	IConnection conn = node.getIncomingConnections().get(0);
	if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
		connName = conn.getName();
		schemaEmpty = conn.getMetadataTable().getListColumns().size()==0;
	}
}
if(useMessageFromSchema && (connName==null || schemaEmpty)){

    stringBuffer.append(TEXT_45);
    
}else{
	if(useKerberos){
	
    stringBuffer.append(TEXT_46);
    
			if(useMessageFromSchema){
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_51);
    
			}else{
			
    stringBuffer.append(TEXT_52);
    
			}
			if(outputDocument){
			
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(soapVersion.toUpperCase());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(action);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(useMessageFromSchema?connName+"."+soapMessageColumn+".toString()":soapMessageStr);
    stringBuffer.append(TEXT_58);
    
			}else{
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(soapVersion.toUpperCase());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(action);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(useMessageFromSchema?connName+"."+soapMessageColumn+".toString()":soapMessageStr);
    stringBuffer.append(TEXT_64);
    
			}
			
    stringBuffer.append(TEXT_65);
    if("Soap12".equals(soapVersion)){
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    }else{
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(kerberosConfiguration);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    log.logPrintedException(log.str("Subject for Kerberos is null!"));
    stringBuffer.append(TEXT_74);
    log.info(log.str("Prepare to send soap request to endpoint."));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(useMessageFromSchema?connName+", ":"");
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    log.info(log.str("Have sent soap request to endpoint."));
    stringBuffer.append(TEXT_81);
    
		if(outputDocument){
		
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
		}
		
    stringBuffer.append(TEXT_85);
    
	}else{	
	
    stringBuffer.append(TEXT_86);
    log.info(log.str("Prepare to send soap request to endpoint."));
    stringBuffer.append(TEXT_87);
    
		if(outputDocument){
		
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(soapVersion.toUpperCase());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(action);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(useMessageFromSchema?connName+"."+soapMessageColumn+".toString()":soapMessageStr);
    stringBuffer.append(TEXT_94);
    
		}else{
		
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(soapVersion.toUpperCase());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(action);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(useMessageFromSchema?connName+"."+soapMessageColumn+".toString()":soapMessageStr);
    stringBuffer.append(TEXT_100);
    
		}
		
    stringBuffer.append(TEXT_101);
    log.info(log.str("Have sent soap request to endpoint."));
    stringBuffer.append(TEXT_102);
    
	}
	
    stringBuffer.append(TEXT_103);
    
	List<? extends IConnection> conns = node.getOutgoingSortedConnections();
	if(conns!=null){//1
		if(conns.size()>0){//2
			IConnection conn = conns.get(0); //the first connection
			if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){//3
				IMetadataTable metadata = conn.getMetadataTable();
				List<IMetadataColumn> columnList = metadata.getListColumns();
				
    stringBuffer.append(TEXT_104);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_106);
    if(outputDocument){
    stringBuffer.append(TEXT_107);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    }else{
    stringBuffer.append(TEXT_110);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    		
				}
			}//3
		}//2
	}//1
} // if(!useMessageFromSchema || connName!=null){

    stringBuffer.append(TEXT_118);
    stringBuffer.append(TEXT_119);
    return stringBuffer.toString();
  }
}
