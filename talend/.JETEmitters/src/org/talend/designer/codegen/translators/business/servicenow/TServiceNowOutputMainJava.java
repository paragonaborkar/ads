package org.talend.designer.codegen.translators.business.servicenow;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TServiceNowOutputMainJava
{
  protected static String nl;
  public static synchronized TServiceNowOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TServiceNowOutputMainJava result = new TServiceNowOutputMainJava();
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
  protected final String TEXT_45 = NL + "\t\t";
  protected final String TEXT_46 = " = null;            " + NL + "\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\twhetherReject_";
  protected final String TEXT_48 = " = false;" + NL + "\t\t\t\t//Set json" + NL + "\t\t\t\torg.json.JSONObject ";
  protected final String TEXT_49 = "_Payload = new org.json.JSONObject();" + NL + "\t\t\t\torg.json.JSONArray ";
  protected final String TEXT_50 = "_PayloadArray= new org.json.JSONArray();" + NL + "\t\t\t\torg.json.JSONObject ";
  protected final String TEXT_51 = "_SysId = new org.json.JSONObject();" + NL + "\t\t\t\torg.json.JSONObject ";
  protected final String TEXT_52 = "_ob = new org.json.JSONObject();" + NL + "\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = " != null) {//6" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = ";" + NL + "\t\t\t\t\t\t\tfor (int j_";
  protected final String TEXT_60 = " = 0; j_";
  protected final String TEXT_61 = " < dynamic_";
  protected final String TEXT_62 = ".getColumnCount(); j_";
  protected final String TEXT_63 = "++) {" + NL + "                                if (dynamic_";
  protected final String TEXT_64 = ".getColumnValue(j_";
  protected final String TEXT_65 = ") != null) {" + NL + "                                    routines.system.DynamicMetadata metadata_";
  protected final String TEXT_66 = " = dynamic_";
  protected final String TEXT_67 = ".getColumnMetadata(j_";
  protected final String TEXT_68 = ");" + NL + "                                    if (\"sys_id\".equals(metadata_";
  protected final String TEXT_69 = ".getName())) {" + NL + "                                    \t";
  protected final String TEXT_70 = "_SysId.put(metadata_";
  protected final String TEXT_71 = ".getName(), ";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = ".getColumnValue(metadata_";
  protected final String TEXT_74 = ".getName()));" + NL + "                                    } else {" + NL + "                                    \t";
  protected final String TEXT_75 = "_ob.put(metadata_";
  protected final String TEXT_76 = ".getName(), ";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = ".getColumnValue(metadata_";
  protected final String TEXT_79 = ".getName()));" + NL + "                                    }" + NL + "                                }" + NL + "                            }" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_81 = "_SysId.put(\"";
  protected final String TEXT_82 = "\", ";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_86 = "_ob.put(\"";
  protected final String TEXT_87 = "\", ";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\t\t}//6" + NL + "\t\t\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\t";
  protected final String TEXT_92 = "_PayloadArray.put(";
  protected final String TEXT_93 = "_ob);" + NL + "\t\t\t\t";
  protected final String TEXT_94 = "_Payload.put(\"data\",";
  protected final String TEXT_95 = "_PayloadArray);" + NL + "\t\t\t\t";
  protected final String TEXT_96 = "log.info(\"";
  protected final String TEXT_97 = " - Payload: '\" + ";
  protected final String TEXT_98 = "_Payload + \"'.\");";
  protected final String TEXT_99 = "globalMap.put(\"";
  protected final String TEXT_100 = "_PAYLOAD\", ";
  protected final String TEXT_101 = "_Payload);";
  protected final String TEXT_102 = NL + "\t\t\t\ttry {//7" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_103 = "++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_104 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_105 = "_httpPost = new org.apache.http.client.methods.HttpPost(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_106 = "_URL + " + NL + "\t\t\t\t\t\t\t\"/api/now/table/\" + " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\t\t\t\t\t);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_108 = "_httpPost.setHeader(\"Accept\", \"application/json\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_109 = "_httpPost.setHeader(\"Content-Type\", \"application/json\");" + NL + "\t//activate Cookie header only if unreliable connection" + NL + "\t\t\t\t\t\t//";
  protected final String TEXT_110 = "_httpPost.setHeader(\"Cookie\", ";
  protected final String TEXT_111 = "_cookie); " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_112 = "_entity = new org.apache.http.entity.StringEntity(";
  protected final String TEXT_113 = "_PayloadArray.get(0).toString());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_114 = "_httpPost.setEntity(";
  protected final String TEXT_115 = "_entity);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_117 = " - Executing '\" + \"";
  protected final String TEXT_118 = "\".toUpperCase() + \"' request.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_120 = "_response = ";
  protected final String TEXT_121 = "_httpclient.execute(";
  protected final String TEXT_122 = "_httpPost);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_123 = "_responseBody = org.apache.http.util.EntityUtils.toString(";
  protected final String TEXT_124 = "_response.getEntity());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_125 = "_responseCode = ";
  protected final String TEXT_126 = "_response.getStatusLine().getStatusCode();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_127 = "_jsonResponse = new org.json.JSONObject(";
  protected final String TEXT_128 = "_responseBody);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_129 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_130 = "_httpPut = new org.apache.http.client.methods.HttpPut(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_131 = "_URL + " + NL + "\t\t\t\t\t\t\t\"/api/now/table/\" + " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_132 = " + " + NL + "\t\t\t\t\t\t\t\"/\" + " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_133 = "_SysId.get(\"sys_id\")" + NL + "\t\t\t\t\t\t\t);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_134 = "_httpPut.setHeader(\"Accept\", \"application/json\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_135 = "_httpPut.setHeader(\"Content-Type\", \"application/json\");" + NL + "\t//activate Cookie header only if unreliable connection " + NL + "\t\t\t\t\t\t//";
  protected final String TEXT_136 = "_httpPut.setHeader(\"Cookie\", ";
  protected final String TEXT_137 = "_cookie);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_138 = "_entity = new org.apache.http.entity.StringEntity(";
  protected final String TEXT_139 = "_PayloadArray.get(0).toString());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_140 = "_httpPut.setEntity(";
  protected final String TEXT_141 = "_entity);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_143 = " - Executing '\" + \"";
  protected final String TEXT_144 = "\".toUpperCase() + \"' request.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_145 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_146 = "_response = ";
  protected final String TEXT_147 = "_httpclient.execute(";
  protected final String TEXT_148 = "_httpPut);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_149 = "_responseBody = org.apache.http.util.EntityUtils.toString(";
  protected final String TEXT_150 = "_response.getEntity());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_151 = "_responseCode = ";
  protected final String TEXT_152 = "_response.getStatusLine().getStatusCode();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_153 = "_jsonResponse = new org.json.JSONObject(";
  protected final String TEXT_154 = "_responseBody);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_155 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_156 = "_responseCode != 201) {" + NL + "\t\t\t\t\t\t\tnb_line_rejected_";
  protected final String TEXT_157 = "++;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_158 = "_response.close();" + NL + "\t\t\t\t\t\t\tthrow new org.apache.http.HttpException(";
  protected final String TEXT_159 = "_jsonResponse.getJSONObject(\"error\").getString(\"message\"));" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tnb_line_inserted_";
  protected final String TEXT_160 = "++;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_162 = "_responseCode != 200) {" + NL + "\t\t\t\t\t\t\tnb_line_rejected_";
  protected final String TEXT_163 = "++;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_164 = "_response.close();" + NL + "\t\t\t\t\t\t\tthrow new org.apache.http.HttpException(";
  protected final String TEXT_165 = "_jsonResponse.getJSONObject(\"error\").getString(\"message\"));" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tnb_line_update_";
  protected final String TEXT_166 = "++;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_168 = " - Execution code '\" + ";
  protected final String TEXT_169 = "_responseCode + \"'.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_170 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_171 = NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_172 = " - Response: '\" + ";
  protected final String TEXT_173 = "_responseBody + \"'.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_174 = NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_175 = "_RESPONSE\", ";
  protected final String TEXT_176 = "_responseBody);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_177 = NL + "\t\t\t\t\t// ";
  protected final String TEXT_178 = "_response.close();" + NL + "\t\t\t\t} //7" + NL + "\t\t\t\tcatch(java.lang.Exception e_";
  protected final String TEXT_179 = ") {//9" + NL + "\t\t\t\t\twhetherReject_";
  protected final String TEXT_180 = " = true;" + NL + "\t\t\t\t\t";
  protected final String TEXT_181 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_182 = " = new ";
  protected final String TEXT_183 = "Struct();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = " = ";
  protected final String TEXT_187 = ".";
  protected final String TEXT_188 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_189 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_190 = ".action = \"";
  protected final String TEXT_191 = "\";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_192 = ".errorCode = Integer.valueOf(";
  protected final String TEXT_193 = "_responseCode).toString();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_194 = ".errorMessage = e_";
  protected final String TEXT_195 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_196 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_197 = NL + NL + NL + "\t\t\t\t\t\tthrow new java.lang.RuntimeException(\"Could not execute \" + e_";
  protected final String TEXT_198 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_199 = NL + "\t\t\t\t}//9" + NL + "\t\t\t\t";
  protected final String TEXT_200 = NL + "\t\t\t\t\tif(!whetherReject_";
  protected final String TEXT_201 = ") {//11" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_202 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_203 = " = new ";
  protected final String TEXT_204 = "Struct();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_205 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_206 = ".";
  protected final String TEXT_207 = " = ";
  protected final String TEXT_208 = ".";
  protected final String TEXT_209 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_210 = NL + "\t\t\t\t\t}//11" + NL + "\t\t\t\t\t";
  protected final String TEXT_211 = NL;
  protected final String TEXT_212 = NL;

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

String tablename = ElementParameterParser.getValue(node, "__TABLENAME__").trim().toLowerCase();
String customTablename = ElementParameterParser.getValue(node, "__CUSTOM_TABLE__").trim().toLowerCase();
tablename = "custom_table".equals(tablename) ? customTablename : "\""+tablename+"\"";

String dataAction = ElementParameterParser.getValue(node,"__ACTION__");
boolean isEnablePayloadDebug = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_PAYLOAD_DEBUG_MODE__"));
boolean isEnableResponseDebug = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_RESPONSE_DEBUG_MODE__"));

log = new LogUtil(node);
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

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
for(IConnection conn : outgoingConns) {
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		
    stringBuffer.append(TEXT_45);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_46);
    
	}
}
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
	IMetadataTable metadata = metadatas.get(0);
	List<IMetadataColumn> columnList = metadata.getListColumns();
	int nbSchemaColumns = columnList.size();
	List< ? extends IConnection> conns = node.getIncomingConnections();
	for(IConnection conn:conns) {//2
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {//3
			String firstConnName = conn.getName();
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
				
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
				for(IMetadataColumn column:columnList) {//5
					
    stringBuffer.append(TEXT_53);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_55);
    
						if("id_Dynamic".equals(column.getTalendType())) {
						
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
						} else if ("sys_id".equals(column.getLabel())) {
						
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_84);
    
						} else {
						
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_89);
    
						}
						
    stringBuffer.append(TEXT_90);
    
				}//5
				
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
				if (isEnablePayloadDebug) {//9
					if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
					}
					
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
				}//9
				
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
					if(("insert").equals(dataAction)) {
						
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(tablename);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_118);
    
						}
						
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
					} else {
						
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(tablename);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
						if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_144);
    
						}
						
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
					}
					if("insert".equals(dataAction)) {
						
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
					}
					if("update".equals(dataAction)) {
						
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
					}
					if(isLog4jEnabled) {
						
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
					}
					if (isEnableResponseDebug) {
						
    stringBuffer.append(TEXT_170);
    
						if(isLog4jEnabled) {
							
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
						}
						
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
					}
					
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    
					if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
						
    stringBuffer.append(TEXT_181);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_183);
    
						for(IMetadataColumn column : columnList) {
							
    stringBuffer.append(TEXT_184);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_188);
    
						}
						
    stringBuffer.append(TEXT_189);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_196);
    
					} else {
						
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    
					}
					
    stringBuffer.append(TEXT_199);
    
				if(outgoingConns != null && outgoingConns.size() > 0) {//10
					
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    
						for(IConnection outgoingConn : outgoingConns) {//12
							if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {//13
								if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//14
									
    stringBuffer.append(TEXT_202);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_203);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_204);
    
									for(IMetadataColumn column : columnList) {//15
										
    stringBuffer.append(TEXT_205);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_206);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_207);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_209);
     
									}//15
								}//14
							}//13
						}//12
						
    stringBuffer.append(TEXT_210);
    
				}//10
			}//4
		}//3
	}//2
}//1

    stringBuffer.append(TEXT_211);
    stringBuffer.append(TEXT_212);
    return stringBuffer.toString();
  }
}
