package org.talend.designer.codegen.translators.databases.amazon.redshift;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TRedshiftOutputBulkBeginJava
{
  protected static String nl;
  public static synchronized TRedshiftOutputBulkBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRedshiftOutputBulkBeginJava result = new TRedshiftOutputBulkBeginJava();
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
  protected final String TEXT_45 = NL + "\tint nb_line_";
  protected final String TEXT_46 = " = 0;" + NL + "\tString rowSeparator_";
  protected final String TEXT_47 = " = \"\\n\";" + NL + "\tString fieldSeparator_";
  protected final String TEXT_48 = " = ";
  protected final String TEXT_49 = NL + "\t\",\";";
  protected final String TEXT_50 = NL + "\tString.valueOf(";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + NL + "\tchar textEnclosure_";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = NL + "\t'\\0';" + NL + "\t" + NL + "\tString escapedFieldSeparator_";
  protected final String TEXT_55 = " = \"\\\\\" + fieldSeparator_";
  protected final String TEXT_56 = ";";
  protected final String TEXT_57 = NL + "\t'\"';";
  protected final String TEXT_58 = NL + "\tString.valueOf(";
  protected final String TEXT_59 = ").charAt(0);";
  protected final String TEXT_60 = NL + "\tString textEnclosureReplaced_";
  protected final String TEXT_61 = " = \"\" + textEnclosure_";
  protected final String TEXT_62 = ";" + NL + "\tString textEnclosureReplacement_";
  protected final String TEXT_63 = " = \"\" + textEnclosure_";
  protected final String TEXT_64 = " + textEnclosure_";
  protected final String TEXT_65 = ";" + NL + "\t" + NL + "\tjava.io.File file_";
  protected final String TEXT_66 = " = new java.io.File(";
  protected final String TEXT_67 = ");\t\t" + NL + "" + NL + "\t";
  protected final String TEXT_68 = NL + "    java.io.File parentFile_";
  protected final String TEXT_69 = " = file_";
  protected final String TEXT_70 = ".getParentFile();" + NL + "    if(parentFile_";
  protected final String TEXT_71 = " != null && !parentFile_";
  protected final String TEXT_72 = ".exists()){" + NL + "        String absolutePath_";
  protected final String TEXT_73 = " = parentFile_";
  protected final String TEXT_74 = ".getAbsolutePath();";
  protected final String TEXT_75 = NL + "        if(parentFile_";
  protected final String TEXT_76 = ".mkdirs()){";
  protected final String TEXT_77 = NL + "            System.out.println(\"The directory '\"+absolutePath_";
  protected final String TEXT_78 = "+\"' has been created successfully.\");" + NL + "        }else{";
  protected final String TEXT_79 = NL + "            System.err.println(\"Fail to create directory '\"+absolutePath_";
  protected final String TEXT_80 = "+\"'.\");" + NL + "        }" + NL + "    }" + NL + "\t";
  protected final String TEXT_81 = NL + "\t";
  protected final String TEXT_82 = NL + "\t\tString filePath_";
  protected final String TEXT_83 = " = file_";
  protected final String TEXT_84 = ".getAbsolutePath().replace(\"\\\\\",\"/\");" + NL + "\t\tString gzPath_";
  protected final String TEXT_85 = " = filePath_";
  protected final String TEXT_86 = " + \".gz\";" + NL + "\t\tfile_";
  protected final String TEXT_87 = " = new java.io.File(gzPath_";
  protected final String TEXT_88 = ");" + NL + "\t\t" + NL + "\t\tjava.io.BufferedWriter csvWriter_";
  protected final String TEXT_89 = " = " + NL + "\t\t\tnew java.io.BufferedWriter(" + NL + "\t\t\t\tnew java.io.OutputStreamWriter(" + NL + "\t\t\t\t\tnew java.util.zip.GZIPOutputStream(" + NL + "\t\t\t\t\t\tnew java.io.FileOutputStream(file_";
  protected final String TEXT_90 = ") " + NL + "\t\t\t\t\t)," + NL + "\t\t\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\t)" + NL + "\t\t\t);";
  protected final String TEXT_92 = NL + "\tjava.io.BufferedWriter csvWriter_";
  protected final String TEXT_93 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "    \tnew java.io.FileOutputStream(file_";
  protected final String TEXT_94 = ", ";
  protected final String TEXT_95 = "), ";
  protected final String TEXT_96 = "));";
  protected final String TEXT_97 = NL + "    resourceMap.put(\"csvWriter_";
  protected final String TEXT_98 = "\", csvWriter_";
  protected final String TEXT_99 = ");";
  protected final String TEXT_100 = NL + "\tresourceMap.put(\"file_";
  protected final String TEXT_101 = "\", file_";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "   ";

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
	LogUtil logtpl = new LogUtil(node);
	String cid = node.getUniqueName();
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas==null)||(metadatas.isEmpty())) {
		return "";
	}
	
	IMetadataTable metadata = metadatas.get(0);
	if (metadata==null) {
		return "";
	}
	
	String filepath = ElementParameterParser.getValue(node,"__FILE__");
	
	String fieldSeparator = ElementParameterParser.getValue(node,"__FIELDSEPARATOR__");
	
	String textEnclosure = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
	
	String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
	if(encoding!=null) {
		encoding = encoding.replace("UTF16LE","UTF-16LE").replace("UTF16BE","UTF-16BE");
	}
	
	boolean isAppend = "true".equals(ElementParameterParser.getValue(node,"__APPEND__"));
	
	boolean isCreateDir = "true".equals(ElementParameterParser.getValue(node,"__CREATE__"));

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
	if(fieldSeparator.trim().isEmpty()) {

    stringBuffer.append(TEXT_49);
    
	} else {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(fieldSeparator.trim());
    stringBuffer.append(TEXT_51);
    
	}

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
	if("EMPTY".equals(textEnclosure)) {

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    
	} else if("DOUBLE_QUOTE".equals(textEnclosure)) {

    stringBuffer.append(TEXT_57);
    
	} else {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(textEnclosure);
    stringBuffer.append(TEXT_59);
    
	}

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(filepath );
    stringBuffer.append(TEXT_67);
    if(isCreateDir) {
    stringBuffer.append(TEXT_68);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_74);
     logtpl.info("\"The directory '\"",logtpl.var("absolutePath"),"\"' doesn't exist,try to create it.\""); 
    stringBuffer.append(TEXT_75);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_76);
     logtpl.info("\"The directory '\"",logtpl.var("absolutePath"),"\"' has been created successfully.\""); 
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
     logtpl.error("\"Fail to create directory '\"",logtpl.var("absolutePath"),"\"'.\""); 
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    
	boolean compress = "true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"));
	boolean delete = "true".equals(ElementParameterParser.getValue(node,"__DELETE_LOCALFILE__"));
	if((delete || !isAppend) && compress) {
		String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_91);
    
	} else {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append((!delete && isAppend) );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_96);
    
    }

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
	if(delete) {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    
	}

    stringBuffer.append(TEXT_103);
    return stringBuffer.toString();
  }
}
