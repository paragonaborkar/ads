package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import java.util.Map;

public class TMDMReadConfBeginJava
{
  protected static String nl;
  public static synchronized TMDMReadConfBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMReadConfBeginJava result = new TMDMReadConfBeginJava();
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
  protected final String TEXT_45 = NL + NL + "                int nb_line_";
  protected final String TEXT_46 = " = 0;";
  protected final String TEXT_47 = NL + "                    String murl_";
  protected final String TEXT_48 = " = ";
  protected final String TEXT_49 = ";" + NL + "                    if(murl_";
  protected final String TEXT_50 = ".endsWith(\"?wsdl\")) {" + NL + "                       murl_";
  protected final String TEXT_51 = " = murl_";
  protected final String TEXT_52 = ".substring(0, murl_";
  protected final String TEXT_53 = ".length() - 5);" + NL + "                    }";
  protected final String TEXT_54 = NL + "                    org.talend.mdm.webservice.TMDMService_Service service_service_";
  protected final String TEXT_55 = " = new org.talend.mdm.webservice.TMDMService_Service(null);" + NL + "                    org.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_56 = " = service_service_";
  protected final String TEXT_57 = ".getTMDMPort();" + NL + "                    javax.xml.ws.BindingProvider stub_";
  protected final String TEXT_58 = " = (javax.xml.ws.BindingProvider) service_";
  protected final String TEXT_59 = ";" + NL + "                    java.util.Map<String, Object> context_";
  protected final String TEXT_60 = " = stub_";
  protected final String TEXT_61 = ".getRequestContext();" + NL + "                    context_";
  protected final String TEXT_62 = ".put(javax.xml.ws.BindingProvider.SESSION_MAINTAIN_PROPERTY, false);" + NL + "                    context_";
  protected final String TEXT_63 = ".put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, ";
  protected final String TEXT_64 = ");" + NL + "                    context_";
  protected final String TEXT_65 = ".put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, murl_";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = "    ";
  protected final String TEXT_68 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_69 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_72 = " = ";
  protected final String TEXT_73 = "; ";
  protected final String TEXT_74 = NL + "                    context_";
  protected final String TEXT_75 = ".put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, decryptedPassword_";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = NL + "                    String connKey_";
  protected final String TEXT_78 = " = \"";
  protected final String TEXT_79 = "_\" + Thread.currentThread().getThreadGroup().getName();" + NL + "                    String transKey_";
  protected final String TEXT_80 = " = \"";
  protected final String TEXT_81 = "_\" + Thread.currentThread().getThreadGroup().getName();" + NL + "                    org.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_82 = " = (org.talend.mdm.webservice.TMDMService)globalMap.get(connKey_";
  protected final String TEXT_83 = ");" + NL + "                    if(service_";
  protected final String TEXT_84 = " == null){" + NL + "                        String murl_";
  protected final String TEXT_85 = " = (String)globalMap.get(\"mdmUrl_";
  protected final String TEXT_86 = "\");" + NL + "                        if(murl_";
  protected final String TEXT_87 = ".endsWith(\"?wsdl\")) {" + NL + "                            murl_";
  protected final String TEXT_88 = " = murl_";
  protected final String TEXT_89 = ".substring(0, murl_";
  protected final String TEXT_90 = ".length() - 5);" + NL + "                        }" + NL + "                        String username_";
  protected final String TEXT_91 = " = (String)globalMap.get(\"username_";
  protected final String TEXT_92 = "\");" + NL + "                        String password_";
  protected final String TEXT_93 = " = (String)globalMap.get(\"password_";
  protected final String TEXT_94 = "\");" + NL;
  protected final String TEXT_95 = NL + "                        org.talend.mdm.webservice.TMDMService_Service service_service_";
  protected final String TEXT_96 = " = new org.talend.mdm.webservice.TMDMService_Service(null);" + NL + "                        service_";
  protected final String TEXT_97 = " = service_service_";
  protected final String TEXT_98 = ".getTMDMPort();" + NL + "                        javax.xml.ws.BindingProvider stub_";
  protected final String TEXT_99 = " = (javax.xml.ws.BindingProvider) service_";
  protected final String TEXT_100 = ";" + NL + "                        java.util.Map<String, Object> context_";
  protected final String TEXT_101 = " = stub_";
  protected final String TEXT_102 = ".getRequestContext();" + NL + "                        context_";
  protected final String TEXT_103 = ".put(javax.xml.ws.BindingProvider.SESSION_MAINTAIN_PROPERTY, true);" + NL + "                        context_";
  protected final String TEXT_104 = ".put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, murl_";
  protected final String TEXT_105 = ");" + NL + "                        context_";
  protected final String TEXT_106 = ".put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, username_";
  protected final String TEXT_107 = ");" + NL + "                        context_";
  protected final String TEXT_108 = ".put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, password_";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + NL + "                        if((Boolean)globalMap.get(\"useTransaction_";
  protected final String TEXT_111 = "\")) {" + NL + "                            String turl_";
  protected final String TEXT_112 = " = com.talend.mdm.transaction.client.MDMTransactionClient.getMDMTransactionURL(murl_";
  protected final String TEXT_113 = ", true);" + NL + "                            com.talend.mdm.transaction.client.MDMTransaction mdmTransaction_";
  protected final String TEXT_114 = " = (com.talend.mdm.transaction.client.MDMTransaction)globalMap.get(transKey_";
  protected final String TEXT_115 = ");" + NL + "                            if(mdmTransaction_";
  protected final String TEXT_116 = " == null){" + NL + "                                if((Boolean)globalMap.get(\"useClientTranId_";
  protected final String TEXT_117 = "\")){" + NL + "                                    String sessionID_";
  protected final String TEXT_118 = " = com.talend.mdm.transaction.client.MDMTransactionClient.getSessionID(turl_";
  protected final String TEXT_119 = ",username_";
  protected final String TEXT_120 = ",password_";
  protected final String TEXT_121 = ");" + NL + "                                    mdmTransaction_";
  protected final String TEXT_122 = " = new com.talend.mdm.transaction.client.MDMTransaction();" + NL + "                                    mdmTransaction_";
  protected final String TEXT_123 = ".setUrl(turl_";
  protected final String TEXT_124 = ");" + NL + "                                    mdmTransaction_";
  protected final String TEXT_125 = ".setId(\"";
  protected final String TEXT_126 = "_\" + java.util.UUID.randomUUID());" + NL + "                                    mdmTransaction_";
  protected final String TEXT_127 = ".setUsername(username_";
  protected final String TEXT_128 = ");" + NL + "                                    mdmTransaction_";
  protected final String TEXT_129 = ".setPassword(password_";
  protected final String TEXT_130 = ");" + NL + "                                    mdmTransaction_";
  protected final String TEXT_131 = ".setSessionId(sessionID_";
  protected final String TEXT_132 = ");" + NL + "                                }else{";
  protected final String TEXT_133 = NL + "                                    mdmTransaction_";
  protected final String TEXT_134 = " = com.talend.mdm.transaction.client.MDMTransactionClient.newTransaction(turl_";
  protected final String TEXT_135 = ",username_";
  protected final String TEXT_136 = ",password_";
  protected final String TEXT_137 = ");" + NL + "                                }" + NL + "                                java.util.List<org.apache.cxf.headers.Header> soapHeaders_";
  protected final String TEXT_138 = " = new java.util.ArrayList<org.apache.cxf.headers.Header>();" + NL + "                                javax.xml.namespace.QName qName_";
  protected final String TEXT_139 = " = new javax.xml.namespace.QName(\"http://www.talend.com/mdm\", \"transaction-id\");" + NL + "                                org.apache.cxf.databinding.DataBinding dataBinding_";
  protected final String TEXT_140 = " = new org.apache.cxf.jaxb.JAXBDataBinding(String.class);" + NL + "                                soapHeaders_";
  protected final String TEXT_141 = ".add(new org.apache.cxf.headers.Header(qName_";
  protected final String TEXT_142 = ", mdmTransaction_";
  protected final String TEXT_143 = ".getId(), dataBinding_";
  protected final String TEXT_144 = "));" + NL + "                                context_";
  protected final String TEXT_145 = ".put(org.apache.cxf.headers.Header.HEADER_LIST, soapHeaders_";
  protected final String TEXT_146 = ");" + NL + "" + NL + "                                java.util.Map<String, java.util.List<String>> httpHeaders_";
  protected final String TEXT_147 = " = new java.util.HashMap<String, java.util.List<String>>();" + NL + "                                String cookie_";
  protected final String TEXT_148 = " = com.talend.mdm.transaction.client.MDMTransaction.getStickySession() + \"=\" + mdmTransaction_";
  protected final String TEXT_149 = ".getSessionId();" + NL + "                                httpHeaders_";
  protected final String TEXT_150 = ".put(\"Cookie\", java.util.Arrays.asList(cookie_";
  protected final String TEXT_151 = "));" + NL + "                                context_";
  protected final String TEXT_152 = ".put(org.apache.cxf.message.Message.PROTOCOL_HEADERS, httpHeaders_";
  protected final String TEXT_153 = ");" + NL + "" + NL + "                                globalMap.put(transKey_";
  protected final String TEXT_154 = ", mdmTransaction_";
  protected final String TEXT_155 = ");";
  protected final String TEXT_156 = NL + "                            }" + NL + "                        }" + NL + "                        service_";
  protected final String TEXT_157 = ".ping(new org.talend.mdm.webservice.WSPing());";
  protected final String TEXT_158 = NL + "                        globalMap.put(connKey_";
  protected final String TEXT_159 = ", service_";
  protected final String TEXT_160 = ");" + NL + "                    }";
  protected final String TEXT_161 = NL + NL + "                String suffix_";
  protected final String TEXT_162 = " = \"\";" + NL + "                if(true ==";
  protected final String TEXT_163 = ") {" + NL + "                    suffix_";
  protected final String TEXT_164 = " = \"#STAGING\";" + NL + "                }" + NL + "                org.talend.mdm.webservice.WSDataClusterPK dataCluster_";
  protected final String TEXT_165 = " = new org.talend.mdm.webservice.WSDataClusterPK(";
  protected final String TEXT_166 = " + suffix_";
  protected final String TEXT_167 = ");" + NL;
  protected final String TEXT_168 = NL + "                    List<String> ids_";
  protected final String TEXT_169 = " = new java.util.ArrayList<String>(); " + NL;
  protected final String TEXT_170 = NL + "                    ids_";
  protected final String TEXT_171 = ".add(";
  protected final String TEXT_172 = ");";
  protected final String TEXT_173 = NL + NL + "                    org.talend.mdm.webservice.WSGetItem wsitem_";
  protected final String TEXT_174 = " = new org.talend.mdm.webservice.WSGetItem(new org.talend.mdm.webservice.WSItemPK(";
  protected final String TEXT_175 = ",ids_";
  protected final String TEXT_176 = ", dataCluster_";
  protected final String TEXT_177 = "));" + NL + "                    String ";
  protected final String TEXT_178 = "_xml = \"\";" + NL + "                    try {" + NL + "                        org.talend.mdm.webservice.WSItem item_";
  protected final String TEXT_179 = "=service_";
  protected final String TEXT_180 = ".getItem(wsitem_";
  protected final String TEXT_181 = ");";
  protected final String TEXT_182 = NL + "                        ";
  protected final String TEXT_183 = "_xml = item_";
  protected final String TEXT_184 = ".getContent();" + NL + "                    } catch(java.lang.Exception e) {";
  protected final String TEXT_185 = NL + "                          throw e;";
  protected final String TEXT_186 = NL + "                          System.err.println(e.getMessage());";
  protected final String TEXT_187 = NL + "                    }" + NL + "                    nb_line_";
  protected final String TEXT_188 = " ++;";
  protected final String TEXT_189 = NL + "                    org.talend.mdm.webservice.WSWhereCondition wc_";
  protected final String TEXT_190 = " = null;" + NL + "                    java.util.List<org.talend.mdm.webservice.WSWhereItem> conditions_";
  protected final String TEXT_191 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSWhereItem>();";
  protected final String TEXT_192 = NL + NL + "                        wc_";
  protected final String TEXT_193 = " =new org.talend.mdm.webservice.WSWhereCondition(";
  protected final String TEXT_194 = NL + "                            ";
  protected final String TEXT_195 = "," + NL + "                            org.talend.mdm.webservice.WSWhereOperator.";
  protected final String TEXT_196 = ", ";
  protected final String TEXT_197 = NL + "                            ";
  protected final String TEXT_198 = ", " + NL + "                            false," + NL + "                            org.talend.mdm.webservice.WSStringPredicate.";
  protected final String TEXT_199 = ");" + NL + "" + NL + "                        org.talend.mdm.webservice.WSWhereItem wsItem_";
  protected final String TEXT_200 = "_";
  protected final String TEXT_201 = "=new org.talend.mdm.webservice.WSWhereItem(null,wc_";
  protected final String TEXT_202 = ",null);" + NL + "                        conditions_";
  protected final String TEXT_203 = ".add(wsItem_";
  protected final String TEXT_204 = "_";
  protected final String TEXT_205 = ");";
  protected final String TEXT_206 = NL + NL + "                    org.talend.mdm.webservice.WSWhereItem wsItem_";
  protected final String TEXT_207 = " = null;" + NL + "                    if(conditions_";
  protected final String TEXT_208 = ".size() > 0){";
  protected final String TEXT_209 = NL + "                        org.talend.mdm.webservice.WSWhereAnd whereAnd_";
  protected final String TEXT_210 = " = new org.talend.mdm.webservice.WSWhereAnd(conditions_";
  protected final String TEXT_211 = "); " + NL + "                        wsItem_";
  protected final String TEXT_212 = " =new org.talend.mdm.webservice.WSWhereItem(whereAnd_";
  protected final String TEXT_213 = ",null,null);";
  protected final String TEXT_214 = NL + "                        org.talend.mdm.webservice.WSWhereOr whereOr_";
  protected final String TEXT_215 = " = new org.talend.mdm.webservice.WSWhereOr(conditions_";
  protected final String TEXT_216 = "); " + NL + "                        wsItem_";
  protected final String TEXT_217 = " =new org.talend.mdm.webservice.WSWhereItem(null,null,whereOr_";
  protected final String TEXT_218 = ");";
  protected final String TEXT_219 = NL + "                    }" + NL + "" + NL + "                    int limit_";
  protected final String TEXT_220 = " = ";
  protected final String TEXT_221 = ";" + NL + "                    int recordsPerPage_";
  protected final String TEXT_222 = " = ";
  protected final String TEXT_223 = ";" + NL + "                    int skip_";
  protected final String TEXT_224 = " = ";
  protected final String TEXT_225 = ";" + NL + "" + NL + "                    if (skip_";
  protected final String TEXT_226 = " < 0)" + NL + "                        skip_";
  protected final String TEXT_227 = " = 0;" + NL + "" + NL + "                    if (recordsPerPage_";
  protected final String TEXT_228 = " <= 0)" + NL + "                        recordsPerPage_";
  protected final String TEXT_229 = " = -1;// read whole records in one time" + NL + "" + NL + "                    if (limit_";
  protected final String TEXT_230 = " <= 0)" + NL + "                        limit_";
  protected final String TEXT_231 = " = -1;// no limit" + NL + "" + NL + "                    int retrievedCount_";
  protected final String TEXT_232 = " = 0;" + NL + "                       int readRecordsSize_";
  protected final String TEXT_233 = " = limit_";
  protected final String TEXT_234 = " == -1 ? recordsPerPage_";
  protected final String TEXT_235 = " : (recordsPerPage_";
  protected final String TEXT_236 = " == -1 ? limit_";
  protected final String TEXT_237 = " : (recordsPerPage_";
  protected final String TEXT_238 = " > limit_";
  protected final String TEXT_239 = " ? limit_";
  protected final String TEXT_240 = NL + "                    : recordsPerPage_";
  protected final String TEXT_241 = "));" + NL + "" + NL + "                    org.talend.mdm.webservice.WSGetItems getitems_";
  protected final String TEXT_242 = "=null;" + NL + "" + NL + "                    boolean continueFlag_";
  protected final String TEXT_243 = " = true;" + NL + "                    int totalCount_";
  protected final String TEXT_244 = " = -1;";
  protected final String TEXT_245 = NL + "                    int totalPage_";
  protected final String TEXT_246 = " = -1;" + NL + "                    int pageNumber_";
  protected final String TEXT_247 = " = 0;" + NL + "                    while (continueFlag_";
  protected final String TEXT_248 = ") {" + NL + "                        pageNumber_";
  protected final String TEXT_249 = "++;" + NL + "                        getitems_";
  protected final String TEXT_250 = "=new org.talend.mdm.webservice.WSGetItems(";
  protected final String TEXT_251 = NL + "                                            ";
  protected final String TEXT_252 = ", " + NL + "                                            readRecordsSize_";
  protected final String TEXT_253 = "," + NL + "                                            skip_";
  protected final String TEXT_254 = " + recordsPerPage_";
  protected final String TEXT_255 = "*(pageNumber_";
  protected final String TEXT_256 = "-1),";
  protected final String TEXT_257 = NL + "                                            ";
  protected final String TEXT_258 = ",  //spell Threshold" + NL + "                                            true," + NL + "                                            wsItem_";
  protected final String TEXT_259 = "," + NL + "                                            dataCluster_";
  protected final String TEXT_260 = ");" + NL + "" + NL + "" + NL + "                        String[] items_";
  protected final String TEXT_261 = " = {};" + NL + "                        try {";
  protected final String TEXT_262 = NL + "                            items_";
  protected final String TEXT_263 = " = service_";
  protected final String TEXT_264 = ".getItems(getitems_";
  protected final String TEXT_265 = ").getStrings().toArray(new String[0]);" + NL + "" + NL + "                            if(totalCount_";
  protected final String TEXT_266 = " < 0){ " + NL + "                                totalCount_";
  protected final String TEXT_267 = " = Integer.valueOf(items_";
  protected final String TEXT_268 = "[0].replaceAll(\"<totalCount>\", \"\").replaceAll(\"</totalCount>\", \"\"));";
  protected final String TEXT_269 = NL + "                                totalPage_";
  protected final String TEXT_270 = " = totalCount_";
  protected final String TEXT_271 = "/recordsPerPage_";
  protected final String TEXT_272 = " +1;" + NL + "                            }" + NL + "                        } catch(java.lang.Exception e) {";
  protected final String TEXT_273 = NL + "                                 throw e;";
  protected final String TEXT_274 = NL + "                                 System.err.println(e.getMessage());";
  protected final String TEXT_275 = NL + "                        }" + NL + "                        retrievedCount_";
  protected final String TEXT_276 = " += (items_";
  protected final String TEXT_277 = ".length - 1);" + NL + "                        if (totalCount_";
  protected final String TEXT_278 = " == retrievedCount_";
  protected final String TEXT_279 = " || recordsPerPage_";
  protected final String TEXT_280 = " == -1 || (items_";
  protected final String TEXT_281 = ".length - 1) < 1 || pageNumber_";
  protected final String TEXT_282 = " == totalPage_";
  protected final String TEXT_283 = " || limit_";
  protected final String TEXT_284 = " == retrievedCount_";
  protected final String TEXT_285 = ") {" + NL + "                            continueFlag_";
  protected final String TEXT_286 = " = false;" + NL + "                        } else if (limit_";
  protected final String TEXT_287 = " != -1 && limit_";
  protected final String TEXT_288 = " < retrievedCount_";
  protected final String TEXT_289 = " + readRecordsSize_";
  protected final String TEXT_290 = ") {" + NL + "                            readRecordsSize_";
  protected final String TEXT_291 = " = limit_";
  protected final String TEXT_292 = " - retrievedCount_";
  protected final String TEXT_293 = ";" + NL + "                        }" + NL + "" + NL + "                        for(int i_";
  protected final String TEXT_294 = " = 1, itemsLength_";
  protected final String TEXT_295 = " = items_";
  protected final String TEXT_296 = ".length; i_";
  protected final String TEXT_297 = " < itemsLength_";
  protected final String TEXT_298 = "; i_";
  protected final String TEXT_299 = "++){" + NL + "                            nb_line_";
  protected final String TEXT_300 = " ++;" + NL + "                            String ";
  protected final String TEXT_301 = "_xml = items_";
  protected final String TEXT_302 = "[i_";
  protected final String TEXT_303 = "];    " + NL;

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
LogUtil logUtil = new LogUtil(node);
String cid = node.getUniqueName();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
if(destination!=null && !"".equals(destination)){
    cid = destination;
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {//1
    IMetadataTable metadata = metadatas.get(0);

    if (metadata != null) {//2
        List<IMetadataColumn> columnList = metadata.getListColumns();
        List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

        // if output columns are defined
        if (outgoingConns != null && outgoingConns.size() > 0){//3

            IConnection outgoingConn = outgoingConns.get(0);
            if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { //4
                boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

                String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
                String conn = "TMDMService_" + connection;
                String trans = "mdmTrans_" + connection;
                String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
                String username = ElementParameterParser.getValue(node, "__USERNAME__");

                String concept = ElementParameterParser.getValue(node, "__CONCEPT__");
                String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
                boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));

                boolean isSingle = ("true").equals(ElementParameterParser.getValue(node, "__USE_ITEMS__"));
                List<Map<String, String>> ids = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__IDS__");
                List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");

                String spellThrehold = ElementParameterParser.getValue(node, "__SPELLTHREHOLD__");
                String skip = ElementParameterParser.getValue(node, "__SKIP__");
                String bufferSize = ElementParameterParser.getValue(node, "__FETCHSIZE__");
                String limit = ElementParameterParser.getValue(node, "__MAXVALUE__");
                if(spellThrehold==null || ("").equals(spellThrehold)){
                    spellThrehold = "0";
                }
                if(skip==null || ("").equals(skip)){
                    skip = "0";
                } 
                if(limit==null || ("").equals(limit)){
                    limit = "0";
                }
                
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    if(!useExistingConn){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
     logUtil.debug("\"Initializing web service from URL: \" + murl_" + cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
     String passwordFieldName = "__PASSWORD__"; 
    stringBuffer.append(TEXT_67);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_70);
    } else {
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    }else{
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(trans);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_94);
     logUtil.debug("\"Initializing web service from URL: \" + murl_" + cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
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
     logUtil.debug("\"Got service successfully with key=\" + connKey_" + cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(connection );
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
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
     logUtil.debug("\"Attempt to get a remote transaction from url: \" + murl_" + cid);
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
    stringBuffer.append(cid);
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
     logUtil.debug("\"Got transaction successfully with key=\" + transKey_" + cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    //For TDI-26109
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    }
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(isStaging );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    if(!isSingle){//item
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    
                    for(int i=0; i<ids.size(); i++){//for
                        Map<String, String> map = ids.get(i);
                        String idValue = map.get("IDVALUE");
                    
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(idValue );
    stringBuffer.append(TEXT_172);
    
                    }//for
                    
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(concept );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
     logUtil.error("\"Unexpected error:\"+e.getMessage()");
    if(dieOnError) {
    stringBuffer.append(TEXT_185);
     } else { 
    stringBuffer.append(TEXT_186);
     } 
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    
                }else{//items
                
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    
                    boolean isOnlyOrPredicate=true;
                    for(int i=0; i < operations.size(); i++){
                        Map<String, String> map= operations.get(i);
                        String xpath=map.get("XPATH");
                        String operator=map.get("FUNCTION");
                        String value = map.get("VALUE");
                        String predicate = map.get("PREDICATE");
                        if((i < operations.size()-1) && (!"OR".equals(predicate))){
                            isOnlyOrPredicate = false;
                        }
                        
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(xpath );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(operator );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(TEXT_197);
    stringBuffer.append("EMPTY_NULL".equals(operator)? null:value );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(predicate );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    
                    }//for
                    
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    
                    if(!isOnlyOrPredicate){
                    
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    
                    }else{
                    
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    
                    }
                    
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(bufferSize);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(skip);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    //For TDI-26039
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(concept);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(spellThrehold);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
     logUtil.debug("\"Attempt to get items .\"");
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
     logUtil.info("\"Total items retrieved:\"+totalCount_"+cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
     logUtil.error("\"Unexpected error:\"+e.getMessage()");
    if(dieOnError) {
    stringBuffer.append(TEXT_273);
     } else { 
    stringBuffer.append(TEXT_274);
     } 
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    
                }//end items
                
    
            }//4
        }//3
    }//2
}//1

    return stringBuffer.toString();
  }
}
