package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TLDAPInputBeginJava
{
  protected static String nl;
  public static synchronized TLDAPInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPInputBeginJava result = new TLDAPInputBeginJava();
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
  protected final String TEXT_29 = NL + " ";
  protected final String TEXT_30 = NL + "String baseDN_";
  protected final String TEXT_31 = " = \"\";" + NL + "\tint ";
  protected final String TEXT_32 = "_NB_LINE = 0;";
  protected final String TEXT_33 = NL + "\tjava.util.Hashtable env_";
  protected final String TEXT_34 = " = new java.util.Hashtable();" + NL + "\tenv_";
  protected final String TEXT_35 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, \"com.sun.jndi.ldap.LdapCtxFactory\");" + NL + "    env_";
  protected final String TEXT_36 = ".put(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");// \"none\",\"simple\",\"strong\"" + NL + "\tenv_";
  protected final String TEXT_37 = ".put(javax.naming.Context.REFERRAL, \"";
  protected final String TEXT_38 = "\");" + NL + "\tenv_";
  protected final String TEXT_39 = ".put(\"java.naming.ldap.derefAliases\",\"";
  protected final String TEXT_40 = "\");";
  protected final String TEXT_41 = NL + "\tenv_";
  protected final String TEXT_42 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_43 = "+\":\"+";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "\tenv_";
  protected final String TEXT_46 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_47 = "+\":\"+";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "    env_";
  protected final String TEXT_50 = ".put(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_51 = ");" + NL + "    " + NL + "\t";
  protected final String TEXT_52 = NL + "        " + NL + "\t";
  protected final String TEXT_53 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_54 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = "; ";
  protected final String TEXT_59 = NL + "    " + NL + "    env_";
  protected final String TEXT_60 = ".put(javax.naming.Context.SECURITY_CREDENTIALS, decryptedPassword_";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL + "\tenv_";
  protected final String TEXT_63 = ".put(javax.naming.Context.SECURITY_PROTOCOL, \"ssl\");" + NL + "\tenv_";
  protected final String TEXT_64 = ".put(\"java.naming.ldap.factory.socket\", \"talend.ssl.AdvancedSocketFactory\");";
  protected final String TEXT_65 = NL + "\t\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_67 = " - Adnanced CA trusting all certs.\");" + NL + "\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\ttalend.ssl.AdvancedSocketFactory.alwaysTrust();";
  protected final String TEXT_69 = NL + "\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_71 = " - Advanced CA using a store CA file and Keystore password.\");" + NL + "\t\t\t\t\tlog.debug(\"Store CA : '\" + ";
  protected final String TEXT_72 = " + \"'.\");" + NL + "\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\ttalend.ssl.AdvancedSocketFactory.setCertStorePath(";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "\t\t\t\t";
  protected final String TEXT_76 = NL + "            ";
  protected final String TEXT_77 = " " + NL + "                    \tfinal String decryptedPwd_";
  protected final String TEXT_78 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_79 = ");";
  protected final String TEXT_80 = NL + "                    \tfinal String decryptedPwd_";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = "; ";
  protected final String TEXT_83 = "\t\t\t\t" + NL + "\t\t\t\t" + NL + "\t\t\t\t\ttalend.ssl.AdvancedSocketFactory.setCertStorePassword(decryptedPwd_";
  protected final String TEXT_84 = ");";
  protected final String TEXT_85 = NL + "   " + NL + "   \tjavax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_86 = " = null;" + NL + "\ttry{" + NL + "\t";
  protected final String TEXT_87 = NL + "\t\tlog.info(\"";
  protected final String TEXT_88 = " - Connection attempt to '\"+ ";
  protected final String TEXT_89 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_90 = NL + "\tctx_";
  protected final String TEXT_91 = " = new javax.naming.ldap.InitialLdapContext(env_";
  protected final String TEXT_92 = ", null);";
  protected final String TEXT_93 = NL + "\tjavax.naming.ldap.StartTlsRequest tldsReq_";
  protected final String TEXT_94 = " = new javax.naming.ldap.StartTlsRequest();" + NL + "    javax.naming.ldap.StartTlsResponse tls_";
  protected final String TEXT_95 = " =(javax.naming.ldap.StartTlsResponse)ctx_";
  protected final String TEXT_96 = ".extendedOperation(tldsReq_";
  protected final String TEXT_97 = ");" + NL + "    javax.net.ssl.SSLSession session_";
  protected final String TEXT_98 = " = tls_";
  protected final String TEXT_99 = ".negotiate((javax.net.ssl.SSLSocketFactory)talend.ssl.AdvancedSocketFactory.getDefault());";
  protected final String TEXT_100 = NL + "\t\tlog.info(\"";
  protected final String TEXT_101 = " - Connection to '\"+";
  protected final String TEXT_102 = "+\"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_103 = NL + "\ttry{" + NL + "\tjavax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_104 = " = (javax.naming.ldap.InitialLdapContext)globalMap.get(\"";
  protected final String TEXT_105 = "\");" + NL + "\t";
  protected final String TEXT_106 = NL + "\t\tif(ctx_";
  protected final String TEXT_107 = "!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_108 = " - Uses an existing connection ,connection URL is: '\" + ctx_";
  protected final String TEXT_109 = ".getEnvironment().get(javax.naming.Context.PROVIDER_URL) + \"'.\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_110 = NL + "\tbaseDN_";
  protected final String TEXT_111 = " = (String)globalMap.get(\"";
  protected final String TEXT_112 = "\");";
  protected final String TEXT_113 = NL + "\t" + NL + "\tjavax.naming.directory.SearchControls searchCtls_";
  protected final String TEXT_114 = " = new javax.naming.directory.SearchControls();" + NL + "    searchCtls_";
  protected final String TEXT_115 = ".setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);";
  protected final String TEXT_116 = NL + "        routines.system.Dynamic dcg_";
  protected final String TEXT_117 = " =  new routines.system.Dynamic();";
  protected final String TEXT_118 = NL + "    searchCtls_";
  protected final String TEXT_119 = ".setReturningAttributes(new String[]{";
  protected final String TEXT_120 = NL + "\t\t\"";
  protected final String TEXT_121 = "\",";
  protected final String TEXT_122 = "    " + NL + "    });";
  protected final String TEXT_123 = NL + "    searchCtls_";
  protected final String TEXT_124 = ".setTimeLimit(";
  protected final String TEXT_125 = "*1000);" + NL + "    searchCtls_";
  protected final String TEXT_126 = ".setCountLimit(";
  protected final String TEXT_127 = ");";
  protected final String TEXT_128 = NL + "\t//get basce dn" + NL + "\tjavax.naming.directory.Attributes attrsNaming_";
  protected final String TEXT_129 = " = ctx_";
  protected final String TEXT_130 = ".getAttributes(\"\",new String[] {\"namingContexts\"});" + NL + "    javax.naming.directory.Attribute aNaming_";
  protected final String TEXT_131 = " = attrsNaming_";
  protected final String TEXT_132 = ".get(\"namingContexts\");" + NL + "    if(aNaming_";
  protected final String TEXT_133 = " == null)" + NL + "    {" + NL + "        aNaming_";
  protected final String TEXT_134 = " =attrsNaming_";
  protected final String TEXT_135 = ".get(\"namingcontexts\");" + NL + "    }" + NL + "\t\tbaseDN_";
  protected final String TEXT_136 = " = ((aNaming_";
  protected final String TEXT_137 = " == null) || ((aNaming_";
  protected final String TEXT_138 = " != null)" + NL + "                    && (aNaming_";
  protected final String TEXT_139 = ".get().toString() != null)" + NL + "                    && (aNaming_";
  protected final String TEXT_140 = ".get().toString().length() > 0) && (Character" + NL + "                    .isIdentifierIgnorable(aNaming_";
  protected final String TEXT_141 = ".get().toString().charAt(0))))) ? \"\"" + NL + "                    : aNaming_";
  protected final String TEXT_142 = ".get().toString();";
  protected final String TEXT_143 = NL + "\t\tbaseDN_";
  protected final String TEXT_144 = " = ";
  protected final String TEXT_145 = ";";
  protected final String TEXT_146 = NL + "\t\tString binaryColumns_";
  protected final String TEXT_147 = " = \"";
  protected final String TEXT_148 = "\";";
  protected final String TEXT_149 = NL + "\t\tString[] columnsInSchema_";
  protected final String TEXT_150 = " = \"";
  protected final String TEXT_151 = "\".split(\",\");" + NL + "\t\tjava.util.Arrays.sort(columnsInSchema_";
  protected final String TEXT_152 = ");" + NL + "    \tjavax.naming.directory.Attributes attrsDyn_";
  protected final String TEXT_153 = " = null;" + NL + "    \tjavax.naming.NamingEnumeration answerDyn_";
  protected final String TEXT_154 = " = ctx_";
  protected final String TEXT_155 = ".search(";
  protected final String TEXT_156 = "baseDN_";
  protected final String TEXT_157 = "\"\"";
  protected final String TEXT_158 = ", ";
  protected final String TEXT_159 = ", searchCtls_";
  protected final String TEXT_160 = ");" + NL + "\t\t";
  protected final String TEXT_161 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_162 = " - Retrieving records from the service.\");" + NL + "\t\t";
  protected final String TEXT_163 = NL + "    \twhile (answerDyn_";
  protected final String TEXT_164 = " .hasMoreElements()) {" + NL + "    \t\tjavax.naming.directory.SearchResult srDyn_";
  protected final String TEXT_165 = "  = (javax.naming.directory.SearchResult) answerDyn_";
  protected final String TEXT_166 = ".next();" + NL + "            attrsDyn_";
  protected final String TEXT_167 = " = srDyn_";
  protected final String TEXT_168 = ".getAttributes();" + NL + "            javax.naming.NamingEnumeration ne_";
  protected final String TEXT_169 = " =attrsDyn_";
  protected final String TEXT_170 = ".getAll();" + NL + "\t\t\twhile(ne_";
  protected final String TEXT_171 = ".hasMoreElements()){" + NL + "\t\t\t\tString element_";
  protected final String TEXT_172 = " = ne_";
  protected final String TEXT_173 = ".nextElement().toString();" + NL + "\t\t\t\tint splitorIndex_";
  protected final String TEXT_174 = " = element_";
  protected final String TEXT_175 = ".indexOf(\":\");" + NL + "\t\t\t\tif(splitorIndex_";
  protected final String TEXT_176 = ">0){" + NL + "\t\t\t\t\tString columnName_";
  protected final String TEXT_177 = " = element_";
  protected final String TEXT_178 = ".substring(0,splitorIndex_";
  protected final String TEXT_179 = ");" + NL + "\t\t\t\t\tif(java.util.Arrays.binarySearch(columnsInSchema_";
  protected final String TEXT_180 = ",columnName_";
  protected final String TEXT_181 = ") < 0 || \"";
  protected final String TEXT_182 = "\".equals(columnName_";
  protected final String TEXT_183 = ")){" + NL + "\t\t\t\t\t\tDynamicMetadata dm_";
  protected final String TEXT_184 = " = new DynamicMetadata();" + NL + "\t\t\t\t\t\tdm_";
  protected final String TEXT_185 = ".setName(columnName_";
  protected final String TEXT_186 = ");" + NL + "\t\t\t\t\t\tdm_";
  protected final String TEXT_187 = ".setDbName(columnName_";
  protected final String TEXT_188 = ");" + NL + "\t\t\t\t\t\tdm_";
  protected final String TEXT_189 = ".setType(\"id_String\");" + NL + "\t\t\t\t\t\tif(!dcg_";
  protected final String TEXT_190 = ".metadatas.contains(dm_";
  protected final String TEXT_191 = ")){" + NL + "\t\t\t\t\t\t\tdcg_";
  protected final String TEXT_192 = ".metadatas.add(dm_";
  protected final String TEXT_193 = ");";
  protected final String TEXT_194 = NL + "\t\t\t\t\t\t\t\t\tif(binaryColumns_";
  protected final String TEXT_195 = ".length()>0){" + NL + "\t\t\t\t\t\t\t\t\t\tbinaryColumns_";
  protected final String TEXT_196 = "+=\" \";" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_197 = NL + "\t\t\t\t\t\t\t\t\tbinaryColumns_";
  protected final String TEXT_198 = "+=\" \";";
  protected final String TEXT_199 = NL + "\t\t\t\t\t\t\t\tbinaryColumns_";
  protected final String TEXT_200 = "+=columnName_";
  protected final String TEXT_201 = ";";
  protected final String TEXT_202 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "    \t}";
  protected final String TEXT_203 = NL + "    // Set the page size and initialize the cookie that we pass back in subsequent pages" + NL + "    int pageSize_";
  protected final String TEXT_204 = " = ";
  protected final String TEXT_205 = ";" + NL + "    byte[] cookie_";
  protected final String TEXT_206 = " = null;" + NL + "    // Request the paged results control" + NL + "    javax.naming.ldap.Control[] ctls_";
  protected final String TEXT_207 = " = new javax.naming.ldap.Control[] { new javax.naming.ldap.PagedResultsControl(pageSize_";
  protected final String TEXT_208 = ", true) };" + NL + "    ctx_";
  protected final String TEXT_209 = ".setRequestControls(ctls_";
  protected final String TEXT_210 = ");" + NL + "    " + NL + "do {";
  protected final String TEXT_211 = NL + "\t\tif(binaryColumns_";
  protected final String TEXT_212 = ".length()>0){" + NL + "\t\t\tjava.util.Hashtable orignal_env_";
  protected final String TEXT_213 = "= ctx_";
  protected final String TEXT_214 = ".getEnvironment();" + NL + "\t\t\torignal_env_";
  protected final String TEXT_215 = ".put(\"java.naming.ldap.attributes.binary\",binaryColumns_";
  protected final String TEXT_216 = ");" + NL + "\t\t\tctx_";
  protected final String TEXT_217 = " = new javax.naming.ldap.InitialLdapContext(orignal_env_";
  protected final String TEXT_218 = ", null);" + NL + "\t\t}";
  protected final String TEXT_219 = NL + NL + "    javax.naming.NamingEnumeration answer_";
  protected final String TEXT_220 = " = ctx_";
  protected final String TEXT_221 = ".search(";
  protected final String TEXT_222 = "baseDN_";
  protected final String TEXT_223 = "\"\"";
  protected final String TEXT_224 = ", ";
  protected final String TEXT_225 = ", searchCtls_";
  protected final String TEXT_226 = ");" + NL + "\t";
  protected final String TEXT_227 = NL + "\t\tlog.info(\"";
  protected final String TEXT_228 = " - Retrieving records from the service.\");" + NL + "\t";
  protected final String TEXT_229 = NL + "    while (answer_";
  protected final String TEXT_230 = " .hasMoreElements()) {//a";
  protected final String TEXT_231 = NL + "    \t\t";
  protected final String TEXT_232 = " = null;\t\t\t";
  protected final String TEXT_233 = NL + "    \t";
  protected final String TEXT_234 = "_NB_LINE++;" + NL + "    \tjavax.naming.directory.Attributes attrs_";
  protected final String TEXT_235 = " = null;";
  protected final String TEXT_236 = NL + "\t\t";
  protected final String TEXT_237 = " = new ";
  protected final String TEXT_238 = "Struct(); " + NL + "\ttry{";
  protected final String TEXT_239 = NL + NL + "            javax.naming.directory.SearchResult sr_";
  protected final String TEXT_240 = "  = (javax.naming.directory.SearchResult) answer_";
  protected final String TEXT_241 = ".next();" + NL + "    \t\tglobalMap.put(\"";
  protected final String TEXT_242 = "_RESULT_NAME\",sr_";
  protected final String TEXT_243 = ".getName());" + NL + "            attrs_";
  protected final String TEXT_244 = " = sr_";
  protected final String TEXT_245 = ".getAttributes();" + NL + "     \t\t// for output";
  protected final String TEXT_246 = "          " + NL + "        if (attrs_";
  protected final String TEXT_247 = " != null) {//b";
  protected final String TEXT_248 = NL + "\t\t\t\t\t\t\tif(attrs_";
  protected final String TEXT_249 = ".get(\"";
  protected final String TEXT_250 = "\") !=null){" + NL + "                            \t";
  protected final String TEXT_251 = ".";
  protected final String TEXT_252 = " = (byte[])attrs_";
  protected final String TEXT_253 = ".get(\"";
  protected final String TEXT_254 = "\").get();" + NL + "    \t\t\t\t\t\t} else {" + NL + "                           \t\t";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = " = null;" + NL + "    \t\t\t\t\t\t}";
  protected final String TEXT_257 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_258 = ".";
  protected final String TEXT_259 = " = (\"\".equals(sr_";
  protected final String TEXT_260 = ".getName())?sr_";
  protected final String TEXT_261 = ".getName():(sr_";
  protected final String TEXT_262 = ".getName()+ \",\")) + baseDN_";
  protected final String TEXT_263 = ";";
  protected final String TEXT_264 = NL + "\t\t\t\t\t\t\t\tdcg_";
  protected final String TEXT_265 = ".clearColumnValues();" + NL + "\t\t\t\t\t\t\t\tfor(DynamicMetadata dm_";
  protected final String TEXT_266 = " :dcg_";
  protected final String TEXT_267 = ".metadatas){" + NL + "\t\t\t\t\t\t\t\t\tjavax.naming.directory.Attribute attr_";
  protected final String TEXT_268 = "_";
  protected final String TEXT_269 = " = attrs_";
  protected final String TEXT_270 = ".get(dm_";
  protected final String TEXT_271 = ".getDbName());" + NL + "\t\t\t\t\t\t\t\t\tif(attr_";
  protected final String TEXT_272 = "_";
  protected final String TEXT_273 = " != null){" + NL + "\t\t\t\t\t\t\t\t\t\tStringBuilder attrStr_";
  protected final String TEXT_274 = " = new StringBuilder();" + NL + "\t\t\t\t\t\t    \t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_275 = " = attr_";
  protected final String TEXT_276 = "_";
  protected final String TEXT_277 = ".getAll(); e_";
  protected final String TEXT_278 = ".hasMore();){" + NL + "\t\t\t\t\t\t    \t\t\t\tif(attrStr_";
  protected final String TEXT_279 = ".length()>0){" + NL + "\t\t\t\t\t\t    \t\t\t\t\tattrStr_";
  protected final String TEXT_280 = ".append(";
  protected final String TEXT_281 = ");" + NL + "\t\t\t\t\t\t    \t\t\t\t}" + NL + "\t\t\t\t\t\t    \t\t\t\tattrStr_";
  protected final String TEXT_282 = ".append(e_";
  protected final String TEXT_283 = ".next().toString());" + NL + "\t\t\t\t\t\t    \t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\tdcg_";
  protected final String TEXT_284 = ".addColumnValue(attrStr_";
  protected final String TEXT_285 = ".toString());" + NL + "\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\tdcg_";
  protected final String TEXT_286 = ".addColumnValue(null);" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_287 = ".";
  protected final String TEXT_288 = " = dcg_";
  protected final String TEXT_289 = ";";
  protected final String TEXT_290 = NL + "\t\t\t\t\t\t\t\tjavax.naming.directory.Attribute attr_";
  protected final String TEXT_291 = "_";
  protected final String TEXT_292 = " = attrs_";
  protected final String TEXT_293 = ".get(\"";
  protected final String TEXT_294 = "\");" + NL + "\t\t\t\t\t\t\t\tif(attr_";
  protected final String TEXT_295 = "_";
  protected final String TEXT_296 = " != null){";
  protected final String TEXT_297 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\tList list_";
  protected final String TEXT_298 = " = new java.util.ArrayList();" + NL + "\t\t\t\t\t\t\t\t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_299 = " = attr_";
  protected final String TEXT_300 = "_";
  protected final String TEXT_301 = ".getAll(); e_";
  protected final String TEXT_302 = ".hasMore();){" + NL + "\t\t\t\t\t    \t\t\t\t \tlist_";
  protected final String TEXT_303 = ".add(e_";
  protected final String TEXT_304 = ".next());" + NL + "    \t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t    \t\t\t\t";
  protected final String TEXT_305 = ".";
  protected final String TEXT_306 = " = list_";
  protected final String TEXT_307 = ";";
  protected final String TEXT_308 = NL + "    \t\t\t\t\t\t\t\t\tStringBuilder attrStr_";
  protected final String TEXT_309 = " = new StringBuilder();" + NL + "\t\t\t\t\t\t    \t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_310 = " = attr_";
  protected final String TEXT_311 = "_";
  protected final String TEXT_312 = ".getAll(); e_";
  protected final String TEXT_313 = ".hasMore();){" + NL + "\t\t\t\t\t    \t\t\t\tif(attrStr_";
  protected final String TEXT_314 = ".length()>0){" + NL + "    \t\t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_315 = ".append(";
  protected final String TEXT_316 = ");" + NL + "\t\t\t\t\t    \t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_317 = ".append(e_";
  protected final String TEXT_318 = ".next().toString());" + NL + "\t\t\t\t\t    \t\t\t}" + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_319 = ".";
  protected final String TEXT_320 = " = attrStr_";
  protected final String TEXT_321 = ".toString();";
  protected final String TEXT_322 = "\t\t\t" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_323 = ".";
  protected final String TEXT_324 = " = null;" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_325 = NL + "\t\t}//b" + NL + "\t} catch (java.lang.Exception e) {" + NL;
  protected final String TEXT_326 = NL + "        \tthrow(e);";
  protected final String TEXT_327 = "                    " + NL + "        \t\t";
  protected final String TEXT_328 = " = new ";
  protected final String TEXT_329 = "Struct();";
  protected final String TEXT_330 = NL + "       \t\t\t\t";
  protected final String TEXT_331 = ".";
  protected final String TEXT_332 = " = ";
  protected final String TEXT_333 = ".";
  protected final String TEXT_334 = ";";
  protected final String TEXT_335 = NL + "                ";
  protected final String TEXT_336 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_337 = ";";
  protected final String TEXT_338 = NL + "                ";
  protected final String TEXT_339 = " = null;";
  protected final String TEXT_340 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_341 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_342 = " - \" + e.getMessage());";
  protected final String TEXT_343 = NL + "                ";
  protected final String TEXT_344 = " = null;";
  protected final String TEXT_345 = NL + "            \t";
  protected final String TEXT_346 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_347 = ";";
  protected final String TEXT_348 = NL + "    }";
  protected final String TEXT_349 = NL + "///////////////////////////////////        ";
  protected final String TEXT_350 = NL;

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
	
    stringBuffer.append(TEXT_29);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	List<Map<String, String>> fieldOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_OPTIONS__");
	boolean useFieldOptions = ("true").equals(ElementParameterParser.getValue(node, "__USE_FIELD_OPTIONS__"));
	List<IMetadataTable> metadatas = node.getMetadataList();
	    if ((metadatas!=null)&&(metadatas.size()>0)) {
	        IMetadataTable metadata = metadatas.get(0);	        
	        if(metadata!=null) {

				List<IMetadataColumn> columnList = metadata.getListColumns();
				String cid = node.getUniqueName();
				String filter=ElementParameterParser.getValue(node, "__FILTER__");
				String separator=ElementParameterParser.getValue(node, "__MULTI_VALUE_SEPARATOR__");
				boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));	
				boolean paging =("true").equals(ElementParameterParser.getValue(node, "__ISPAGING__"));	
				String pageSize =ElementParameterParser.getValue(node, "__PAGESIZE__");
				String limit =ElementParameterParser.getValue(node, "__LIMIT__");
				String timeout =ElementParameterParser.getValue(node, "__TIMEOUT__");
				String baseDN=ElementParameterParser.getValue(node, "__BASEDN__");
				
				String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
				String exConn= "conn_" + connection;
				String exConnBaseDN = "connBaseDN_" + connection;
				String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
				boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
if(("false").equals(useExistingConn)){
	String host=ElementParameterParser.getValue(node, "__HOST__");
	String port=ElementParameterParser.getValue(node, "__PORT__");
	String protocol=ElementParameterParser.getValue(node, "__PROTOCOL__");
	String advanced=ElementParameterParser.getValue(node, "__ADVANCEDCA__");
	String storepath=ElementParameterParser.getValue(node, "__STORECA__");
	String storepwd = ElementParameterParser.getValue(node, "__STORECAPWD__");
	boolean alwaysTrust = ("true").equals(ElementParameterParser.getValue(node, "__ALWAYS_TRUST__"));
	String referrals=ElementParameterParser.getValue(node, "__REFERRALS__");
	String aliases=ElementParameterParser.getValue(node, "__ALIASES__");
	String authen =ElementParameterParser.getValue(node, "__AUTHENTIFICATION__");
	String user =ElementParameterParser.getValue(node, "__USER__");


    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(referrals);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(aliases);
    stringBuffer.append(TEXT_40);
    	
	if(baseDN == null || baseDN.length()<=2){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_44);
    
	}else{

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_48);
    
	}
    if(("true").equals(authen)){

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_51);
    
    String passwordFieldName = "__PASS__";
    
    stringBuffer.append(TEXT_52);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_55);
    } else {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
    }
    if(("LDAPS").equals(protocol)){

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
	}
	if(("LDAPS").equals(protocol) || ("TLS").equals(protocol)){
		if(("true").equals(advanced)){
			if(alwaysTrust) {

    stringBuffer.append(TEXT_65);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    
			} else {

    stringBuffer.append(TEXT_69);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(storepath );
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    stringBuffer.append(storepath);
    stringBuffer.append(TEXT_74);
    
				if(storepwd !=null && storepwd.length() !=0 ){
    stringBuffer.append(TEXT_75);
    
                    String passwordFieldName = "__STORECAPWD__";
                    
    stringBuffer.append(TEXT_76);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_79);
    } else {
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
				}
			}
		}
    }

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
	if(("TLS").equals(protocol)){

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
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
    
	}
	if(isLog4jEnabled){
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_102);
    }
}else{

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(exConn);
    stringBuffer.append(TEXT_105);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(exConnBaseDN);
    stringBuffer.append(TEXT_112);
    
}

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
	boolean isDynamic = metadata.isDynamicSchema();
    if(isDynamic){

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
	}else{

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
					for(IMetadataColumn column:columnList){		

    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_121);
    
                	}

    stringBuffer.append(TEXT_122);
    
	}

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_127);
    
				if(("false").equals(useExistingConn)){
					if(baseDN == null || baseDN.length()<=2){

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
					}else{

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(baseDN);
    stringBuffer.append(TEXT_145);
    
					}
				}

    
	String binaryColumns = "";
	boolean hasDynamicBinary=false;
	if(useFieldOptions){
		for(int i = 0;i<fieldOptions.size();i++){// search in the configuration table
			Map<String, String> line = fieldOptions.get(i);
			String columnName = line.get("SCHEMA_COLUMN");
			Boolean isBinary = "true".equals(line.get("BINARY"));
			if(isBinary){
				IMetadataColumn column = columnList.get(i);
				if(!column.getTalendType().equals("id_Dynamic")){
					if(binaryColumns.length()>0){
						binaryColumns+=" ";
					}
					binaryColumns+=column.getOriginalDbColumnName();
				}else{
					hasDynamicBinary = true;
				}
			}
		}
	}
	boolean hasBinaryColumn = binaryColumns.length()>0 || hasDynamicBinary;
	if(hasBinaryColumn){

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(binaryColumns);
    stringBuffer.append(TEXT_148);
    
	}
    if(isDynamic){
    	String columnsStr = "";
		for(IMetadataColumn column:columnList){
			columnsStr += column.getOriginalDbColumnName() + ",";
		}

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(columnsStr);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    if(("false").equals(useExistingConn)){
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    stringBuffer.append(filter);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(metadata.getDynamicColumn().getOriginalDbColumnName());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    
							if(hasDynamicBinary){
								if(binaryColumns.length()==0){

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
								}else{

    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    
								}

    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    
							}

    stringBuffer.append(TEXT_202);
    
	}

    if(paging){
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(pageSize );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    }
    
	if(hasBinaryColumn){

    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
	}

    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    if(("false").equals(useExistingConn)){
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    stringBuffer.append(filter);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    }
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
	List< ? extends IConnection> conns = node.getOutgoingConnections(EConnectionType.FLOW_MAIN);
	if(conns.size() == 0){
		conns = node.getOutgoingConnections(EConnectionType.FLOW_MERGE);
	}
    String rejectConnName = "";
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
    
    String firstConnName = "";
	if (conns!=null) {
        if (conns.size()>0) {
        	for (int i=0;i<conns.size();i++) {
        		IConnection connTemp = conns.get(i);
        		if(i==0){
        			firstConnName = connTemp.getName();
        		}
        		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_231);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_232);
    
				}
			}
		}
	}

    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    
	if(firstConnName.length()>0){

    stringBuffer.append(TEXT_236);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_238);
    
	}

    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    
            if (conns!=null) {//1
                if (conns.size()>0) {//2
                    IConnection conn = conns.get(0); //the first connection
                    firstConnName = conn.getName();         
                    if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3
                        
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    
					for(IMetadataColumn column:columnList){//5		
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_250);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_254);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_256);
    
						}else{
							if("dn".equals(column.getLabel().toLowerCase())){

    stringBuffer.append(TEXT_257);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_258);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    
							}else{

    
							if("id_Dynamic".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    
							}else{

    stringBuffer.append(TEXT_290);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_294);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    
									if(javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    				
									} else {

    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    
								}

    stringBuffer.append(TEXT_322);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_324);
    
								}
							}
						}
                	}//5

    stringBuffer.append(TEXT_325);
    
        if (dieOnError) {

    stringBuffer.append(TEXT_326);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_327);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_329);
    
                for(IMetadataColumn column : metadata.getListColumns()) {

    stringBuffer.append(TEXT_330);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_332);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_334);
    
                }

    stringBuffer.append(TEXT_335);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_339);
    
            } else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_340);
    
				if(isLog4jEnabled){

    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    
				}

    stringBuffer.append(TEXT_343);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_344);
    
            } else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_345);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_347);
    
			}
        }

    stringBuffer.append(TEXT_348);
    
        }//3
    }//2
    
}//1


    stringBuffer.append(TEXT_349);
    
  }
}  
 
    stringBuffer.append(TEXT_350);
    return stringBuffer.toString();
  }
}
