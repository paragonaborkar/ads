package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.Map;
import java.util.List;
import org.talend.core.model.utils.TalendTextUtils;

public class TWebServiceInputBeginJava
{
  protected static String nl;
  public static synchronized TWebServiceInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWebServiceInputBeginJava result = new TWebServiceInputBeginJava();
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
  protected final String TEXT_45 = NL + "\t\t\t\t/////////////////////////////////// " + NL + "\t\t        System.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "\t\t        Object[] params_";
  protected final String TEXT_46 = " = new Object[] {" + NL + "\t\t\t        ";
  protected final String TEXT_47 = ", " + NL + "\t\t\t        ";
  protected final String TEXT_48 = ",      " + NL + "\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t    \t    ";
  protected final String TEXT_50 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_51 = "      " + NL + "\t\t        };" + NL + "\t\t\t\t";
  protected final String TEXT_52 = "   " + NL + "\t\t\t        System.setProperty(\"java.protocol.handler.pkgs\", \"com.sun.net.ssl.internal.www.protocol\");" + NL + "\t\t\t" + NL + "\t\t\t\t\tSystem.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_53 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_54 = NL + "                    ";
  protected final String TEXT_55 = " " + NL + "                    \tfinal String decryptedPwd_";
  protected final String TEXT_56 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "                    \tfinal String decryptedPwd_";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = "; ";
  protected final String TEXT_61 = "\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tSystem.setProperty(\"javax.net.ssl.trustStorePassword\", decryptedPwd_";
  protected final String TEXT_62 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t";
  protected final String TEXT_65 = NL + "                ";
  protected final String TEXT_66 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_67 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_70 = " = ";
  protected final String TEXT_71 = "; ";
  protected final String TEXT_72 = NL + "\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_73 = "        \t   " + NL + "\t        \t\torg.talend.DynamicInvoker.setAuth(true, ";
  protected final String TEXT_74 = ", decryptedPassword_";
  protected final String TEXT_75 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\torg.talend.DynamicInvoker.setWINAuth(true, ";
  protected final String TEXT_78 = ", decryptedPassword_";
  protected final String TEXT_79 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_80 = "\t" + NL + "\t\t\t\t";
  protected final String TEXT_81 = "  " + NL + "\t\t\t\t";
  protected final String TEXT_82 = NL + "                    ";
  protected final String TEXT_83 = " " + NL + "                    \tfinal String decryptedProxyPwd_";
  protected final String TEXT_84 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = NL + "                    \tfinal String decryptedProxyPwd_";
  protected final String TEXT_87 = " = ";
  protected final String TEXT_88 = "; ";
  protected final String TEXT_89 = "\t\t\t\t" + NL + "\t\t\t\t" + NL + "\t\t\t\t\torg.talend.DynamicInvoker.setHttpProxy(true, ";
  protected final String TEXT_90 = ", ";
  protected final String TEXT_91 = ", ";
  protected final String TEXT_92 = ", decryptedProxyPwd_";
  protected final String TEXT_93 = ");" + NL + "\t\t\t\t\tSystem.setProperty(\"http.proxyHost\", ";
  protected final String TEXT_94 = ");" + NL + "\t\t\t\t\tSystem.setProperty(\"http.proxyPort\", ";
  protected final String TEXT_95 = ");" + NL + "\t\t\t\t\tSystem.setProperty(\"http.proxyUser\", ";
  protected final String TEXT_96 = ");" + NL + "\t\t\t\t\tSystem.setProperty(\"http.proxyPassword\", decryptedProxyPwd_";
  protected final String TEXT_97 = ");" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\tjava.net.Authenticator.setDefault(" + NL + "\t\t\t\t\tnew java.net.Authenticator() {" + NL + "\t\t\t\t\t\tpublic java.net.PasswordAuthentication getPasswordAuthentication() {" + NL + "\t\t\t\t\t\t\treturn new java.net.PasswordAuthentication(" + NL + "\t\t\t\t\t\t\t   ";
  protected final String TEXT_98 = ", decryptedProxyPwd_";
  protected final String TEXT_99 = ".toCharArray());" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t);" + NL + "\t\t\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\t";
  protected final String TEXT_101 = " " + NL + "\t\t\t\torg.talend.DynamicInvoker.setTimeOut(";
  protected final String TEXT_102 = ");" + NL + "\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t \t\torg.talend.DynamicInvoker.main(params_";
  protected final String TEXT_104 = ");" + NL + "\t\t \t\tjava.util.Map result_";
  protected final String TEXT_105 = " = org.talend.DynamicInvoker.getResult();" + NL + "\t\t        " + NL + "\t\t        Object[] results_";
  protected final String TEXT_106 = " = null;" + NL + "\t\t\t    int nb_line_";
  protected final String TEXT_107 = " = 0;" + NL + "\t\t\t" + NL + "\t\t        for (Object key_";
  protected final String TEXT_108 = " : result_";
  protected final String TEXT_109 = ".keySet()) {" + NL + "\t        " + NL + "\t\t           results_";
  protected final String TEXT_110 = " = new Object[";
  protected final String TEXT_111 = "];" + NL + "\t\t            " + NL + "\t\t           Object value_";
  protected final String TEXT_112 = " = result_";
  protected final String TEXT_113 = ".get(key_";
  protected final String TEXT_114 = ");" + NL + "\t\t           if (value_";
  protected final String TEXT_115 = " instanceof Object[]){" + NL + "\t\t                Object[] objArr_";
  protected final String TEXT_116 = " = (Object[])value_";
  protected final String TEXT_117 = ";" + NL + "\t\t                int len_";
  protected final String TEXT_118 = " = Math.min(objArr_";
  protected final String TEXT_119 = ".length, results_";
  protected final String TEXT_120 = ".length);" + NL + "\t\t                int k_";
  protected final String TEXT_121 = " = 0;" + NL + "\t\t                for (int i_";
  protected final String TEXT_122 = " = 0; i_";
  protected final String TEXT_123 = " < len_";
  protected final String TEXT_124 = "; i_";
  protected final String TEXT_125 = "++ ) {" + NL + "\t\t                    results_";
  protected final String TEXT_126 = "[k_";
  protected final String TEXT_127 = "] = objArr_";
  protected final String TEXT_128 = "[k_";
  protected final String TEXT_129 = "];" + NL + "\t\t                }" + NL + "\t                " + NL + "\t\t\t        } else if (value_";
  protected final String TEXT_130 = " instanceof java.util.List) {" + NL + "\t\t\t        \tjava.util.List list_";
  protected final String TEXT_131 = " = (java.util.List)value_";
  protected final String TEXT_132 = ";" + NL + "\t\t\t            int len_";
  protected final String TEXT_133 = " = Math.min(list_";
  protected final String TEXT_134 = ".size(), results_";
  protected final String TEXT_135 = ".length);" + NL + "\t\t\t            int k_";
  protected final String TEXT_136 = " = 0;" + NL + "\t\t\t            for (java.util.Iterator iter_";
  protected final String TEXT_137 = " = list_";
  protected final String TEXT_138 = ".iterator(); iter_";
  protected final String TEXT_139 = ".hasNext() && k_";
  protected final String TEXT_140 = " < len_";
  protected final String TEXT_141 = "; k_";
  protected final String TEXT_142 = "++) {" + NL + "\t\t\t            \tresults_";
  protected final String TEXT_143 = "[k_";
  protected final String TEXT_144 = "] = iter_";
  protected final String TEXT_145 = ".next();" + NL + "\t\t\t            }" + NL + "\t                                " + NL + "\t           \t\t} else if (value_";
  protected final String TEXT_146 = " instanceof java.util.Map) {                " + NL + "\t\t\t\t\t\tjava.util.Map map_";
  protected final String TEXT_147 = " = (java.util.Map)value_";
  protected final String TEXT_148 = ";" + NL + "\t\t                java.util.Collection values_";
  protected final String TEXT_149 = " = map_";
  protected final String TEXT_150 = ".values();" + NL + "\t\t                int len_";
  protected final String TEXT_151 = " = Math.min(values_";
  protected final String TEXT_152 = ".size(), results_";
  protected final String TEXT_153 = ".length);" + NL + "\t\t                int k_";
  protected final String TEXT_154 = " = 0;" + NL + "\t\t                for (java.util.Iterator iter_";
  protected final String TEXT_155 = " = values_";
  protected final String TEXT_156 = ".iterator(); iter_";
  protected final String TEXT_157 = ".hasNext() && k_";
  protected final String TEXT_158 = " < len_";
  protected final String TEXT_159 = "; k_";
  protected final String TEXT_160 = "++) {" + NL + "\t\t                    results_";
  protected final String TEXT_161 = "[k_";
  protected final String TEXT_162 = "] = iter_";
  protected final String TEXT_163 = ".next();" + NL + "\t\t                }" + NL + "\t" + NL + "\t            \t} else if (value_";
  protected final String TEXT_164 = " instanceof org.w3c.dom.Element) {" + NL + "\t                \tresults_";
  protected final String TEXT_165 = "[0] = org.apache.axis.utils.XMLUtils.ElementToString((org.w3c.dom.Element)value_";
  protected final String TEXT_166 = ");" + NL + "\t                " + NL + "\t\t            }else if (value_";
  protected final String TEXT_167 = " instanceof org.apache.axis.types.Schema){" + NL + "\t\t                org.apache.axis.types.Schema schema_";
  protected final String TEXT_168 = " = (org.apache.axis.types.Schema) value_";
  protected final String TEXT_169 = ";" + NL + "\t\t                org.apache.axis.message.MessageElement[] _any_";
  protected final String TEXT_170 = " = schema_";
  protected final String TEXT_171 = ".get_any();" + NL + "\t\t                for (int s_";
  protected final String TEXT_172 = " = 0; s_";
  protected final String TEXT_173 = " < _any_";
  protected final String TEXT_174 = ".length; s_";
  protected final String TEXT_175 = "++) {" + NL + "\t\t                    results_";
  protected final String TEXT_176 = "[s_";
  protected final String TEXT_177 = "] = _any_";
  protected final String TEXT_178 = "[s_";
  protected final String TEXT_179 = "].toString();" + NL + "\t\t                }\t" + NL + "\t\t                " + NL + "\t\t            } else {" + NL + "\t\t\t\t\t    results_";
  protected final String TEXT_180 = "[0] = value_";
  protected final String TEXT_181 = ";" + NL + "\t\t            }" + NL + "\t            " + NL + "\t\t\t";
  protected final String TEXT_182 = NL + "\t\t        Object[] results_";
  protected final String TEXT_183 = " = null;" + NL + "\t\t\t    int nb_line_";
  protected final String TEXT_184 = " = 0;" + NL + "\t\t\t    " + NL + "\t\t\t    org.talend.TalendJobHTTPClientConfiguration clientConfig_";
  protected final String TEXT_185 = " = new org.talend.TalendJobHTTPClientConfiguration();" + NL + "\t\t\t\tclientConfig_";
  protected final String TEXT_186 = ".setTimeout(";
  protected final String TEXT_187 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_188 = NL + "\t\t        org.talend.TalendJob talendJob_";
  protected final String TEXT_189 = " = new org.talend.TalendJobProxy(";
  protected final String TEXT_190 = ");" + NL + "\t\t\t\ttalendJob_";
  protected final String TEXT_191 = ".setClientConfig(clientConfig_";
  protected final String TEXT_192 = ");\t        " + NL + "\t\t        String[][] runJob_";
  protected final String TEXT_193 = " = talendJob_";
  protected final String TEXT_194 = ".runJob(new String[]{" + NL + "\t\t\t\t";
  protected final String TEXT_195 = NL + "\t        \t\t";
  protected final String TEXT_196 = "," + NL + "\t\t\t\t";
  protected final String TEXT_197 = " " + NL + "\t        \t});" + NL + "\t\t        for (String[] item_";
  protected final String TEXT_198 = " : runJob_";
  protected final String TEXT_199 = ") {" + NL + "\t\t\t\t\tresults_";
  protected final String TEXT_200 = " = item_";
  protected final String TEXT_201 = ";" + NL + "\t\t\t";
  protected final String TEXT_202 = "            " + NL + "\t\t" + NL + "\t        nb_line_";
  protected final String TEXT_203 = "++;" + NL + "\t\t       " + NL + "\t\t\t// for output" + NL + "\t\t\t";
  protected final String TEXT_204 = NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tif(";
  protected final String TEXT_205 = " < results_";
  protected final String TEXT_206 = ".length && results_";
  protected final String TEXT_207 = "[";
  protected final String TEXT_208 = "]!=null){\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_209 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = " = results_";
  protected final String TEXT_212 = "[";
  protected final String TEXT_213 = "];\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_214 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_215 = ".";
  protected final String TEXT_216 = " = results_";
  protected final String TEXT_217 = "[";
  protected final String TEXT_218 = "].toString();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_219 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tif(results_";
  protected final String TEXT_220 = "[";
  protected final String TEXT_221 = "] instanceof java.util.GregorianCalendar) {" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_222 = ".";
  protected final String TEXT_223 = " = ((java.util.GregorianCalendar)results_";
  protected final String TEXT_224 = "[";
  protected final String TEXT_225 = "]).getTime();" + NL + "\t\t\t\t                   \t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = " = ParserUtils.parseTo_Date(results_";
  protected final String TEXT_228 = "[";
  protected final String TEXT_229 = "].toString(), ";
  protected final String TEXT_230 = ");" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_231 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_232 = ".";
  protected final String TEXT_233 = " = results_";
  protected final String TEXT_234 = "[";
  protected final String TEXT_235 = "].toString().getBytes();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_236 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_237 = ".";
  protected final String TEXT_238 = " = ParserUtils.parseTo_";
  protected final String TEXT_239 = "(results_";
  protected final String TEXT_240 = "[";
  protected final String TEXT_241 = "].toString());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_242 = NL + "\t\t\t\t\t\t\t} else { " + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_243 = ".";
  protected final String TEXT_244 = " = ";
  protected final String TEXT_245 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_246 = NL + "\t\t\t      \t\t\t\t\t";
  protected final String TEXT_247 = ".";
  protected final String TEXT_248 = " = ";
  protected final String TEXT_249 = ".";
  protected final String TEXT_250 = ";" + NL + "\t\t\t\t\t\t\t \t";
  protected final String TEXT_251 = NL + "\t\t///////////////////////////////////       " + NL + "\t\t";
  protected final String TEXT_252 = NL + " ";
  protected final String TEXT_253 = NL + NL + "\t";
  protected final String TEXT_254 = NL + "\t\t\tint nb_line_";
  protected final String TEXT_255 = " = 0;" + NL + "\t\t\t" + NL + "\t\t    ";
  protected final String TEXT_256 = NL + "\t    " + NL + "\t    \tnb_line_";
  protected final String TEXT_257 = "++;" + NL + "\t\t";
  protected final String TEXT_258 = NL;
  protected final String TEXT_259 = " ";
  protected final String TEXT_260 = NL;

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
// component id
String cid = node.getUniqueName();

log = new LogUtil(node);

if(("false").equals(ElementParameterParser.getValue(node,"__ADVANCED_USE__"))) {
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata!=null) {
	     
	        List<IMetadataColumn> listColumns = metadata.getListColumns(); 
	        
	        List<Map<String, String>> params = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__PARAMS__");
	        
	        boolean needAuth = ("true").equals(ElementParameterParser.getValue(node,"__NEED_AUTH__"));
	        String username = ElementParameterParser.getValue(node,"__AUTH_USERNAME__");
	        String password = ElementParameterParser.getValue(node,"__AUTH_PASSWORD__");
	        
	        boolean winAuth = ("true").equals(ElementParameterParser.getValue(node,"__WIN_AUTH__"));
	        String domain = ElementParameterParser.getValue(node,"__DOMAIN__");
	        
	        boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__UES_PROXY__"));
	        String proxuHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
	        String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
	        String proxuUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
	        String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");
	        
	        boolean needSSLtoTrustServer = ("true").equals(ElementParameterParser.getValue(node,"__NEED_SSL_TO_TRUSTSERVER__"));
	        String trustStoreFile = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_TRUSTSTORE__");
	        String trustStorePassword = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_PASSWORD__");
	        
	        
	        String timeoutStr = ElementParameterParser.getValue(node,"__TIMEOUT__");
			String timeout = (timeoutStr!=null&&!("").equals(timeoutStr))?timeoutStr:"20";
			
	        String endpoint = ElementParameterParser.getValue(node,"__ENDPOINT__");
	        String method = ElementParameterParser.getValue(node,"__METHOD__");
	        
	        String passwordFieldName = "";
	        
	        if(method != null && !("\"runJob\"").equals(method.trim())) {
			
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(endpoint );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(method );
    stringBuffer.append(TEXT_48);
    
			        for (int i = 0; i < params.size(); i++) {
			            Map<String, String> line = params.get(i);
						
    stringBuffer.append(TEXT_49);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_50);
    
			        }
					
    stringBuffer.append(TEXT_51);
     
				if (needSSLtoTrustServer) {
				
    stringBuffer.append(TEXT_52);
    stringBuffer.append(trustStoreFile );
    stringBuffer.append(TEXT_53);
    
                    passwordFieldName = "__SSL_TRUSTSERVER_PASSWORD__";
                    
    stringBuffer.append(TEXT_54);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_57);
    } else {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    log.info(log.str("Set ssl."));
    stringBuffer.append(TEXT_63);
     
				}
				
    stringBuffer.append(TEXT_64);
    
                passwordFieldName = "__AUTH_PASSWORD__";
                
    stringBuffer.append(TEXT_65);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_68);
    } else {
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    
				if (needAuth&&!winAuth) {
				
    stringBuffer.append(TEXT_73);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    log.info(log.str("Set username and password."));
    stringBuffer.append(TEXT_76);
    
	  			}
	  			if (needAuth&&winAuth){
	  				String domain_username = "\""+TalendTextUtils.removeQuotes(domain)+"\\\\"+TalendTextUtils.removeQuotes(username)+"\"";
					
    stringBuffer.append(TEXT_77);
    stringBuffer.append(domain_username );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    log.info(log.str("Set username, password and domain."));
    stringBuffer.append(TEXT_80);
    
	  			}
				if (useProxy) {
				
    stringBuffer.append(TEXT_81);
    
                    passwordFieldName = "__PROXY_PASSWORD__";
                    
    stringBuffer.append(TEXT_82);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_85);
    } else {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    stringBuffer.append(proxuHost );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(proxuUser );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(proxuHost );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(proxuUser );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(proxuUser );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    log.info(log.str("Set proxy."));
    stringBuffer.append(TEXT_100);
    
	  			}
				
    stringBuffer.append(TEXT_101);
    stringBuffer.append(timeout );
    stringBuffer.append(TEXT_102);
    log.info(log.str("Sending soap request to endpoint."));
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
    stringBuffer.append(listColumns.size()==0? 1 : listColumns.size());
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
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
    } else {
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(timeout );
    stringBuffer.append(TEXT_187);
    log.info(log.str("Invoking talend webservice job."));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(endpoint );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
		        for (int i = 0; i < params.size(); i++) {
		            Map<String, String> line = params.get(i);
					
    stringBuffer.append(TEXT_195);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_196);
    
	        	}
				
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    }
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    
			List<? extends IConnection> conns = node.getOutgoingSortedConnections();
			String firstConnName = "";
			if (conns!=null) {//1
				if (conns.size()>0) {//2
					IConnection conn = conns.get(0); //the first connection
					firstConnName = conn.getName();			
					if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3
		
						List<IMetadataColumn> columns=metadata.getListColumns();
						int columnSize = columns.size();
						for (int i=0;i<columnSize;i++) {//4
							IMetadataColumn column=columns.get(i);
							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
    stringBuffer.append(TEXT_204);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_208);
    
								if(javaType == JavaTypesManager.OBJECT){//Object
								
    stringBuffer.append(TEXT_209);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_213);
    
								}else if(javaType == JavaTypesManager.STRING) { //String 
								
    stringBuffer.append(TEXT_214);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_218);
    
								} else if(javaType == JavaTypesManager.DATE) { //Date
								
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_229);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_230);
    
								} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]
								
    stringBuffer.append(TEXT_231);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_235);
    
								} else  { //other
								
    stringBuffer.append(TEXT_236);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_238);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_241);
    
								}
								
    stringBuffer.append(TEXT_242);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_245);
    		
						} //4
						log.debug(log.str("Retrieving the record "), log.var("nb_line"), log.str("."));
					}//3
					if (conns.size()>1) {
						for (int i=1;i<conns.size();i++) {
							IConnection conn2 = conns.get(i);
							if ((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
						    	for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_246);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_250);
    
							 	}
							}
						}
					}
				}//2
			}//1
			
    stringBuffer.append(TEXT_251);
    
	  	}
	}  
 	
    stringBuffer.append(TEXT_252);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{//the following is the use the wsdl2java
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append(TEXT_253);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata!=null) {
	        String code = ElementParameterParser.getValue(node, "__CODE__");
	        
	        // we give a default value to prevComponentName so that no error
	        // occur when the user tries to generated Java code while no input
	        // component was linked to our tJavaRow.        
	        String outputRowName = new String("output_row");
	        
	        List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
	        if (outConns != null && !outConns.isEmpty()) {
	            IConnection outConn = outConns.get(0);
	            outputRowName = outConn.getName();
	        }
	
	        // In case the user would make some tricky Java things, he can use
	        // the arrays as a whole.
	
	        code = code.replaceAll(
	            "output_row",
	            outputRowName
	        );
			
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(code);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    
	    }
	}
	
    stringBuffer.append(TEXT_258);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

    stringBuffer.append(TEXT_259);
    stringBuffer.append(TEXT_260);
    return stringBuffer.toString();
  }
}
