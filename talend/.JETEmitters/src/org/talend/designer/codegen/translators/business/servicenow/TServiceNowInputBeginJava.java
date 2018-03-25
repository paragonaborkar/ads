package org.talend.designer.codegen.translators.business.servicenow;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TServiceNowInputBeginJava
{
  protected static String nl;
  public static synchronized TServiceNowInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TServiceNowInputBeginJava result = new TServiceNowInputBeginJava();
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
  protected final String TEXT_45 = NL + "int nb_line_";
  protected final String TEXT_46 = " = 0;";
  protected final String TEXT_47 = NL + "String ";
  protected final String TEXT_48 = "_domain = null;" + NL + "String ";
  protected final String TEXT_49 = "_URL = null;";
  protected final String TEXT_50 = NL + "    ";
  protected final String TEXT_51 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_52 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = "; ";
  protected final String TEXT_57 = NL + "  ";
  protected final String TEXT_58 = "_URL = StringHandling.EREPLACE(";
  protected final String TEXT_59 = ", \"(/$)\", \"\");";
  protected final String TEXT_60 = NL + "  ";
  protected final String TEXT_61 = "_domain = ";
  protected final String TEXT_62 = "_URL.replaceAll(\"https?://\", \"\");" + NL + "  org.apache.http.auth.UsernamePasswordCredentials ";
  protected final String TEXT_63 = "_usernamePasswordCredentials = new org.apache.http.auth.UsernamePasswordCredentials(";
  protected final String TEXT_64 = ", decryptedPassword_";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "  ";
  protected final String TEXT_67 = "_URL = ((String)globalMap.get(";
  protected final String TEXT_68 = "));";
  protected final String TEXT_69 = NL + "  ";
  protected final String TEXT_70 = "_domain = ";
  protected final String TEXT_71 = "_URL.replaceAll(\"https?://\", \"\");" + NL + "  org.apache.http.auth.UsernamePasswordCredentials ";
  protected final String TEXT_72 = "_usernamePasswordCredentials = new org.apache.http.auth.UsernamePasswordCredentials((String)globalMap.get(";
  protected final String TEXT_73 = "), (String)globalMap.get(";
  protected final String TEXT_74 = "));";
  protected final String TEXT_75 = NL + "//Credential def" + NL + "org.apache.http.client.CredentialsProvider ";
  protected final String TEXT_76 = "_credsProvider = new org.apache.http.impl.client.BasicCredentialsProvider();";
  protected final String TEXT_77 = NL;
  protected final String TEXT_78 = "_credsProvider.setCredentials(" + NL + "  new org.apache.http.auth.AuthScope(new org.apache.http.HttpHost(";
  protected final String TEXT_79 = "_domain)), new org.apache.http.auth.UsernamePasswordCredentials(";
  protected final String TEXT_80 = NL + "    ";
  protected final String TEXT_81 = "_usernamePasswordCredentials.getUserName(), ";
  protected final String TEXT_82 = "_usernamePasswordCredentials.getPassword()" + NL + "    )" + NL + "  );" + NL + "org.apache.http.impl.client.CloseableHttpClient ";
  protected final String TEXT_83 = "_httpclient = org.apache.http.impl.client.HttpClients.custom()" + NL + ".setDefaultCredentialsProvider(";
  protected final String TEXT_84 = "_credsProvider)" + NL + ".build();" + NL;
  protected final String TEXT_85 = NL + "\troutines.system.Dynamic dynamic_";
  protected final String TEXT_86 = " = new routines.system.Dynamic();" + NL + "\t" + NL + "\torg.talend.servicenow.Util util_";
  protected final String TEXT_87 = " = new org.talend.servicenow.Util(";
  protected final String TEXT_88 = "_httpclient, ";
  protected final String TEXT_89 = "_URL);" + NL + "\tjava.util.Map<String, org.talend.servicenow.Util.ColumnMetadata> metadata_";
  protected final String TEXT_90 = " = util_";
  protected final String TEXT_91 = ".getMetadata(";
  protected final String TEXT_92 = ");" + NL + "\t" + NL + "\tjava.util.List<String> unDynamicCols_";
  protected final String TEXT_93 = " = java.util.Arrays.asList(\"";
  protected final String TEXT_94 = "\".split(\",\"));" + NL + "\t" + NL + "\tfor (java.util.Map.Entry<String, org.talend.servicenow.Util.ColumnMetadata> entry_";
  protected final String TEXT_95 = " : metadata_";
  protected final String TEXT_96 = ".entrySet()) {" + NL + "\t\tString columnname_";
  protected final String TEXT_97 = " = entry_";
  protected final String TEXT_98 = ".getKey();" + NL + "\t\t" + NL + "\t\tif(unDynamicCols_";
  protected final String TEXT_99 = ".contains(columnname_";
  protected final String TEXT_100 = ")) {" + NL + "\t\t\tcontinue;" + NL + "\t\t}" + NL + "\t\t" + NL + "    \troutines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_101 = " = new routines.system.DynamicMetadata();" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_102 = ".setName(columnname_";
  protected final String TEXT_103 = ");" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_104 = ".setDbName(columnname_";
  protected final String TEXT_105 = ");" + NL + "    \t" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_106 = ".setType(entry_";
  protected final String TEXT_107 = ".getValue().getType());" + NL + "    \tint maxlength_";
  protected final String TEXT_108 = " = entry_";
  protected final String TEXT_109 = ".getValue().getMaxLength();" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_110 = ".setLength(maxlength_";
  protected final String TEXT_111 = ">256 ? 256 : maxlength_";
  protected final String TEXT_112 = ");" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_113 = ".setFormat(entry_";
  protected final String TEXT_114 = ".getValue().getPattern());" + NL + "    \t" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_115 = ".setDbType(\"VARCHAR\");" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_116 = ".setPrecision(0);" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_117 = ".setNullable(true);" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_118 = ".setKey(false);" + NL + "    \tdynamicMetadata_";
  protected final String TEXT_119 = ".setSourceType(routines.system.DynamicMetadata.sourceTypes.servicenow);" + NL + "    \tdynamic_";
  protected final String TEXT_120 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_121 = ");" + NL + "    }";
  protected final String TEXT_122 = NL + NL + "//Query paramiter builder" + NL + "String ";
  protected final String TEXT_123 = "_conditions = \"\";" + NL + "String ";
  protected final String TEXT_124 = "_conditionValues = \"\";" + NL + "int ";
  protected final String TEXT_125 = "_obj_line = 0;";
  protected final String TEXT_126 = NL + "      ";
  protected final String TEXT_127 = "_obj_line ++;" + NL + "      if(";
  protected final String TEXT_128 = "_obj_line == 1) {";
  protected final String TEXT_129 = NL + "        ";
  protected final String TEXT_130 = "_conditions += \"&sysparm_query=\";" + NL + "      }" + NL + "      if(";
  protected final String TEXT_131 = "_obj_line > 1) {";
  protected final String TEXT_132 = NL + "        ";
  protected final String TEXT_133 = "_conditions += java.net.URLEncoder.encode(\"^\",\"utf-8\");" + NL + "      }";
  protected final String TEXT_134 = NL + "      ";
  protected final String TEXT_135 = "_conditions += \"";
  protected final String TEXT_136 = "\";" + NL + "      if (!\"=\".equals(\"";
  protected final String TEXT_137 = "\")) {";
  protected final String TEXT_138 = NL + "        ";
  protected final String TEXT_139 = "_conditions += java.net.URLEncoder.encode(\"";
  protected final String TEXT_140 = "\",\"utf-8\");" + NL + "      } else {";
  protected final String TEXT_141 = NL + "        ";
  protected final String TEXT_142 = "_conditions += \"";
  protected final String TEXT_143 = "\";" + NL + "      }";
  protected final String TEXT_144 = NL + "      ";
  protected final String TEXT_145 = "_conditionValues = \"\\\"\" + ";
  protected final String TEXT_146 = " + \"\\\"\";";
  protected final String TEXT_147 = NL + "      ";
  protected final String TEXT_148 = "_conditionValues = ";
  protected final String TEXT_149 = "_conditionValues.replaceAll(\"\\\"\", \"\");" + NL + "      if (!";
  protected final String TEXT_150 = "_conditionValues.contains(\" \")) {";
  protected final String TEXT_151 = NL + "        ";
  protected final String TEXT_152 = "_conditionValues = ";
  protected final String TEXT_153 = "_conditionValues.replaceAll(\" \", \"+\");" + NL + "      }";
  protected final String TEXT_154 = NL + "      ";
  protected final String TEXT_155 = "_conditions += java.net.URLEncoder.encode(";
  protected final String TEXT_156 = "_conditionValues,\"utf-8\");";
  protected final String TEXT_157 = NL + "\tString ";
  protected final String TEXT_158 = "_fields = \"\";";
  protected final String TEXT_159 = NL + "    \t";
  protected final String TEXT_160 = "_fields += ";
  protected final String TEXT_161 = "_fields.isEmpty() ? \"&sysparm_fields=\" + \"";
  protected final String TEXT_162 = "\" : \",\" + \"";
  protected final String TEXT_163 = "\";" + NL + "      \t";
  protected final String TEXT_164 = NL + "//Set limit";
  protected final String TEXT_165 = NL + "  int limit_";
  protected final String TEXT_166 = " = ";
  protected final String TEXT_167 = ";               ";
  protected final String TEXT_168 = NL + "//URL builder" + NL + "org.apache.http.client.methods.HttpGet ";
  protected final String TEXT_169 = "_httpget = new org.apache.http.client.methods.HttpGet(";
  protected final String TEXT_170 = NL + "  ";
  protected final String TEXT_171 = "_URL" + NL + "  + \"/api/now/table/\"" + NL + "  + ";
  protected final String TEXT_172 = NL + "  + \"?sysparm_exclude_reference_link=true&sysparm_limit=\"" + NL + "  + limit_";
  protected final String TEXT_173 = NL + "  + ";
  protected final String TEXT_174 = "_conditions";
  protected final String TEXT_175 = NL + "  + ";
  protected final String TEXT_176 = "_fields";
  protected final String TEXT_177 = NL + "  );" + NL + "//Header builder";
  protected final String TEXT_178 = NL;
  protected final String TEXT_179 = "_httpget.setHeader(\"Accept\", \"application/json\");" + NL + "//activate Cookie header only if unreliable connection" + NL + "//";
  protected final String TEXT_180 = "_httpget.setHeader(\"Cookie\", \"BIGipServerpool_sandbox=440453642.33598.0000; JSESSIONID=4100538B6BBF00B5568DF143FF815AF7; _ga=GA1.2.1976595674.1437483024; __CJ_tabs2_list_sys_user=%220%22; __CJ_g_startTime=%221437483102682%22; glide_user_route=glide.a1e7d977b734181b528e29363f053207\");";
  protected final String TEXT_181 = NL + "  log.info(\"";
  protected final String TEXT_182 = " - Executing method '\" + ";
  protected final String TEXT_183 = "_httpget.getRequestLine().getMethod() + \"'\");";
  protected final String TEXT_184 = NL + "//Get" + NL + "org.apache.http.client.methods.CloseableHttpResponse ";
  protected final String TEXT_185 = "_response = ";
  protected final String TEXT_186 = "_httpclient.execute(";
  protected final String TEXT_187 = "_httpget);";
  protected final String TEXT_188 = NL + "  log.info(\"";
  protected final String TEXT_189 = " - Execution code '\" + ";
  protected final String TEXT_190 = "_response.getStatusLine().getStatusCode() + \"'\");";
  protected final String TEXT_191 = NL + "try {" + NL + "  String ";
  protected final String TEXT_192 = "_responseBody;" + NL + "  org.json.JSONObject ";
  protected final String TEXT_193 = "_json;" + NL + "  org.json.JSONArray ";
  protected final String TEXT_194 = "_resultArray;" + NL + "  int ";
  protected final String TEXT_195 = "_responseLength, ";
  protected final String TEXT_196 = "_i;" + NL + "  org.json.JSONObject ";
  protected final String TEXT_197 = "_result = null;" + NL + "  try {";
  protected final String TEXT_198 = NL + "    ";
  protected final String TEXT_199 = "_responseBody = org.apache.http.util.EntityUtils.toString(";
  protected final String TEXT_200 = "_response.getEntity());";
  protected final String TEXT_201 = NL + "    ";
  protected final String TEXT_202 = "_json = new org.json.JSONObject(";
  protected final String TEXT_203 = "_responseBody);" + NL + "" + NL + "    if (";
  protected final String TEXT_204 = "_response.getStatusLine().getStatusCode() == 200) {" + NL + "//Store result as JSON";
  protected final String TEXT_205 = NL + "      ";
  protected final String TEXT_206 = "_resultArray = (org.json.JSONArray) ";
  protected final String TEXT_207 = "_json.get(\"result\");";
  protected final String TEXT_208 = NL + "      ";
  protected final String TEXT_209 = "_responseLength = ";
  protected final String TEXT_210 = "_resultArray.length();" + NL + "//Pass values to output" + NL + "      for (";
  protected final String TEXT_211 = "_i = 0; ";
  protected final String TEXT_212 = "_i < ";
  protected final String TEXT_213 = "_responseLength; ";
  protected final String TEXT_214 = "_i++) {";
  protected final String TEXT_215 = NL;

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

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
String connectionURL = "\"httpHost_conn_" + connection + "\"";
String connectionUsername = "\"username_conn_" + connection + "\"";
String connectionPassword = "\"password_conn_" + connection + "\"";

String tablename = ElementParameterParser.getValue(node, "__TABLENAME__").trim().toLowerCase();
String customTablename = ElementParameterParser.getValue(node, "__CUSTOM_TABLE__").trim().toLowerCase();
tablename = "custom_table".equals(tablename) ? customTablename : "\""+tablename+"\"";

String limit = ElementParameterParser.getValue(node, "__LIMIT__").trim(); //result limit
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String valueFilter = "?sysparm_limit="; //An encoded query string used to filter the results
//Connection method def
String httpHost = ElementParameterParser.getValue(node,"__SERVICENOWURL__").trim();
String username = ElementParameterParser.getValue(node,"__USERNAME__").trim();

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
if(!"true".equals(useExistingConn)) {
  String passwordFieldName = "__PASSWORD__";
  
    stringBuffer.append(TEXT_50);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_53);
    } else {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(httpHost);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
} else {
  
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(connectionURL);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(connectionUsername);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(connectionPassword);
    stringBuffer.append(TEXT_74);
    
}

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas == null) || metadatas.isEmpty()) {
	return stringBuffer.toString();
}

IMetadataTable metadata = metadatas.get(0);
if (metadata == null) {
	return stringBuffer.toString();
}

List<IMetadataColumn> columnList = metadata.getListColumns();
List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
if(columnList==null || columnList.isEmpty() || outgoingConns == null || outgoingConns.isEmpty()){
	return stringBuffer.toString();
}

IConnection outgoingConn = outgoingConns.get(0);

boolean hasDynamic = false;
String dynamicColName = "";
StringBuilder unDynamicCols = new StringBuilder();
for(IMetadataColumn column : columnList) {
    if(column.getTalendType().equals("id_Dynamic")){
        hasDynamic = true;
        dynamicColName = column.getLabel();
    } else {
    	unDynamicCols.append(column.getLabel());
    	unDynamicCols.append(",");
    }
}

if(unDynamicCols.lastIndexOf(",")>-1){
	unDynamicCols.deleteCharAt(unDynamicCols.lastIndexOf(","));
}

if(hasDynamic) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(tablename);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(unDynamicCols);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
}

    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
List<Map<String, String>> keyColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONDITIONS__");
if(keyColumns.size() > 0 ) {
  for(Map<String, String> keyColumn:keyColumns) {
    
    
    if(!("").equals(keyColumn.get("RVALUE"))) {
      
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(keyColumn.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(keyColumn.get("OPERATOR"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(keyColumn.get("OPERATOR"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(keyColumn.get("OPERATOR"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(keyColumn.get("RVALUE"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
    }
  }
}
//Return Field builder
if(!hasDynamic) {

    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
    for (int i = 0; i < columnList.size(); i++) {
    	IMetadataColumn column = columnList.get(i);
      	
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_163);
    
    }
}

    stringBuffer.append(TEXT_164);
    
if(!("").equals(limit)) {
  
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_167);
    
}

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(tablename);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
if(!hasDynamic) {

    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
}

    stringBuffer.append(TEXT_177);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    
if(isLog4jEnabled){
  
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
}

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    
if(isLog4jEnabled){
  
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
}

    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(TEXT_215);
    return stringBuffer.toString();
  }
}
