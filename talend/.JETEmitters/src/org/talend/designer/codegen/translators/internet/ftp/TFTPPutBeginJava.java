package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TFTPPutBeginJava
{
  protected static String nl;
  public static synchronized TFTPPutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPPutBeginJava result = new TFTPPutBeginJava();
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
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + "                if(log.is";
  protected final String TEXT_31 = "Enabled())";
  protected final String TEXT_32 = NL + "            log.";
  protected final String TEXT_33 = "(\"";
  protected final String TEXT_34 = " - \" ";
  protected final String TEXT_35 = " + (";
  protected final String TEXT_36 = ") ";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "    \tclass BytesLimit65535_";
  protected final String TEXT_39 = "{" + NL + "    \t\tpublic void limitLog4jByte() throws Exception{" + NL + "    \t\t\t";
  protected final String TEXT_40 = NL + "            StringBuilder ";
  protected final String TEXT_41 = " = new StringBuilder();";
  protected final String TEXT_42 = NL + "            ";
  protected final String TEXT_43 = ".append(\"Parameters:\");";
  protected final String TEXT_44 = NL + "                    ";
  protected final String TEXT_45 = ".append(\"";
  protected final String TEXT_46 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_47 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_48 = NL + "                    ";
  protected final String TEXT_49 = ".append(\"";
  protected final String TEXT_50 = "\" + \" = \" + ";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "                ";
  protected final String TEXT_53 = ".append(\" | \");";
  protected final String TEXT_54 = NL + "    \t\t}" + NL + "    \t}" + NL + "    \t" + NL + "        new BytesLimit65535_";
  protected final String TEXT_55 = "().limitLog4jByte();";
  protected final String TEXT_56 = NL + "            StringBuilder ";
  protected final String TEXT_57 = " = new StringBuilder();    ";
  protected final String TEXT_58 = NL + "                    ";
  protected final String TEXT_59 = ".append(";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL + "                    if(";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = " == null){";
  protected final String TEXT_65 = NL + "                        ";
  protected final String TEXT_66 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_67 = NL + "                        ";
  protected final String TEXT_68 = ".append(";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = ");" + NL + "                    }   ";
  protected final String TEXT_71 = NL + "                ";
  protected final String TEXT_72 = ".append(\"|\");";
  protected final String TEXT_73 = NL + "  java.util.Properties props_";
  protected final String TEXT_74 = " = System.getProperties();" + NL + "  props_";
  protected final String TEXT_75 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_76 = ");" + NL + "  props_";
  protected final String TEXT_77 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_78 = ");" + NL + "  props_";
  protected final String TEXT_79 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_80 = ");" + NL + "  ";
  protected final String TEXT_81 = " " + NL + "  String decryptedProxyPassword_";
  protected final String TEXT_82 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL + "  String decryptedProxyPassword_";
  protected final String TEXT_85 = " = ";
  protected final String TEXT_86 = "; ";
  protected final String TEXT_87 = NL + NL + "  props_";
  protected final String TEXT_88 = ".put(\"java.net.socks.password\",decryptedProxyPassword_";
  protected final String TEXT_89 = ");        ";
  protected final String TEXT_90 = NL + "int nb_file_";
  protected final String TEXT_91 = " = 0;" + NL;
  protected final String TEXT_92 = "// *** sftp *** //" + NL + "" + NL + "\tclass MyProgressMonitor_";
  protected final String TEXT_93 = " implements com.jcraft.jsch.SftpProgressMonitor {" + NL + "\t\tpublic void init(int op, String src, String dest, long max) {}" + NL + "    \tpublic boolean count(long count) { return true;}" + NL + "    \tpublic void end() {}" + NL + "  \t}" + NL + "" + NL + "\t";
  protected final String TEXT_94 = NL + "    \tcom.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_95 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_96 = "\");" + NL + "\t\t";
  protected final String TEXT_97 = NL + "\t\t\tif(c_";
  protected final String TEXT_98 = "!=null && c_";
  protected final String TEXT_99 = ".getSession()!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_100 = " - Uses an existing connection. Connection username \" + c_";
  protected final String TEXT_101 = ".getSession().getUserName() + \", Connection hostname: \" + c_";
  protected final String TEXT_102 = ".getSession().getHost() + \", Connection port: \" + c_";
  protected final String TEXT_103 = ".getSession().getPort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_104 = NL + "    \tif(c_";
  protected final String TEXT_105 = ".getHome()!=null && !c_";
  protected final String TEXT_106 = ".getHome().equals(c_";
  protected final String TEXT_107 = ".pwd())){" + NL + "  \t\t\tc_";
  protected final String TEXT_108 = ".cd(c_";
  protected final String TEXT_109 = ".getHome());" + NL + "  \t\t}" + NL + "\t";
  protected final String TEXT_110 = "    " + NL + "\t\tclass MyUserInfo_";
  protected final String TEXT_111 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "\t\t" + NL + "     \t   ";
  protected final String TEXT_112 = " " + NL + "          \t\tString decryptedPassphrase_";
  protected final String TEXT_113 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = NL + "          \t\tString decryptedPassphrase_";
  protected final String TEXT_116 = " = ";
  protected final String TEXT_117 = "; ";
  protected final String TEXT_118 = NL + "\t\t" + NL + "\t\t\tString passphrase_";
  protected final String TEXT_119 = " = decryptedPassphrase_";
  protected final String TEXT_120 = ";" + NL + "\t\t\tpublic String getPassphrase() { return passphrase_";
  protected final String TEXT_121 = "; }" + NL + "\t\t\tpublic String getPassword() { return null; } " + NL + "\t\t\tpublic boolean promptPassword(String arg0) { return true; } " + NL + "\t\t\tpublic boolean promptPassphrase(String arg0) { return true; } " + NL + "\t\t\tpublic boolean promptYesNo(String arg0) { return true; } " + NL + "      \t\tpublic void showMessage(String arg0) { } " + NL + "      " + NL + "\t\t\tpublic String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "        \tboolean[] echo) {" + NL + "        \t" + NL + "        \t";
  protected final String TEXT_122 = " " + NL + "        \t" + NL + "        \t";
  protected final String TEXT_123 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_124 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_127 = " = ";
  protected final String TEXT_128 = "; ";
  protected final String TEXT_129 = NL + "        \t" + NL + "        \t\tString[] password_";
  protected final String TEXT_130 = " = {decryptedPassword_";
  protected final String TEXT_131 = "};" + NL + "        \t\treturn password_";
  protected final String TEXT_132 = ";" + NL + "      \t\t}" + NL + "\t\t};" + NL + "\t\tfinal com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_133 = " = new MyUserInfo_";
  protected final String TEXT_134 = "();" + NL + "\t\tcom.jcraft.jsch.JSch jsch_";
  protected final String TEXT_135 = "=new com.jcraft.jsch.JSch(); " + NL + "" + NL + "\t\t";
  protected final String TEXT_136 = NL + "\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_138 = " - SFTP authentication using a public key.\");" + NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_139 = " - Private key: '\" + ";
  protected final String TEXT_140 = " + \"'.\");" + NL + "\t \t\t ";
  protected final String TEXT_141 = NL + "      \t\tjsch_";
  protected final String TEXT_142 = ".addIdentity(";
  protected final String TEXT_143 = ", defaultUserInfo_";
  protected final String TEXT_144 = ".getPassphrase());" + NL + "\t\t";
  protected final String TEXT_145 = NL + "\t\t" + NL + "\t\tcom.jcraft.jsch.Session session_";
  protected final String TEXT_146 = "=jsch_";
  protected final String TEXT_147 = ".getSession(";
  protected final String TEXT_148 = ", ";
  protected final String TEXT_149 = ", ";
  protected final String TEXT_150 = ");" + NL + "\t\tsession_";
  protected final String TEXT_151 = ".setConfig(\"PreferredAuthentications\", \"publickey,password,keyboard-interactive,gssapi-with-mic\");" + NL + "" + NL + "\t\t";
  protected final String TEXT_152 = NL + "\t\t\t";
  protected final String TEXT_153 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_154 = " - SFTP authentication using a password.\");" + NL + "\t\t\t";
  protected final String TEXT_155 = NL + "\t\t\t" + NL + "        \t";
  protected final String TEXT_156 = " " + NL + "        \t" + NL + "        \t";
  protected final String TEXT_157 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_158 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_159 = ");";
  protected final String TEXT_160 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_161 = " = ";
  protected final String TEXT_162 = "; ";
  protected final String TEXT_163 = NL + "        \t" + NL + "\t\t\tsession_";
  protected final String TEXT_164 = ".setPassword(decryptedPassword_";
  protected final String TEXT_165 = "); " + NL + "\t\t";
  protected final String TEXT_166 = NL + "\t\tsession_";
  protected final String TEXT_167 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_168 = "); " + NL + "\t\t";
  protected final String TEXT_169 = NL + "\t\tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "\t\t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_170 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "\t\t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "\t\t\t\tproxy_";
  protected final String TEXT_171 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t\t}" + NL + "\t\t\tsession_";
  protected final String TEXT_172 = ".setProxy(proxy_";
  protected final String TEXT_173 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_174 = NL + "\t\t";
  protected final String TEXT_175 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_176 = " - Attempt to connect to '\" + ";
  protected final String TEXT_177 = " + \"' with username '\" + ";
  protected final String TEXT_178 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_179 = NL + "    \tsession_";
  protected final String TEXT_180 = ".connect();" + NL + "    \tcom.jcraft.jsch. Channel channel_";
  protected final String TEXT_181 = "=session_";
  protected final String TEXT_182 = ".openChannel(\"sftp\");" + NL + "    \tchannel_";
  protected final String TEXT_183 = ".connect();" + NL + "\t\t";
  protected final String TEXT_184 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_185 = " - Connect to '\" + ";
  protected final String TEXT_186 = " + \" has succeeded.\" );" + NL + "\t\t";
  protected final String TEXT_187 = NL + "    \tcom.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_188 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_189 = ";" + NL + "    \t" + NL + "    \t";
  protected final String TEXT_190 = NL + "\t\t\tc_";
  protected final String TEXT_191 = ".setFilenameEncoding(";
  protected final String TEXT_192 = ");" + NL + "\t\t";
  protected final String TEXT_193 = NL + "\t\t" + NL + "\t";
  protected final String TEXT_194 = NL + "\t// becasue there is not the same method in JSch class as FTPClient class, define a list here" + NL + "\tjava.util.List<String> msg_";
  protected final String TEXT_195 = " = new java.util.ArrayList<String>();" + NL + "\tcom.jcraft.jsch.SftpProgressMonitor monitor";
  protected final String TEXT_196 = " = new MyProgressMonitor_";
  protected final String TEXT_197 = "();" + NL + "\tjava.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_198 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "  ";
  protected final String TEXT_199 = NL + "\t\t\tjava.util.Map<String,String> map";
  protected final String TEXT_200 = " = new java.util.HashMap<String,String>();" + NL + "\t\t    map";
  protected final String TEXT_201 = ".put(";
  protected final String TEXT_202 = ", ";
  protected final String TEXT_203 = ");    " + NL + "\t\t    list";
  protected final String TEXT_204 = ".add(map";
  protected final String TEXT_205 = ");       ";
  protected final String TEXT_206 = "  " + NL + "\tString localdir";
  protected final String TEXT_207 = " = ";
  protected final String TEXT_208 = ";" + NL + "\t";
  protected final String TEXT_209 = NL + "\t\tlog.info(\"";
  protected final String TEXT_210 = " - Putting file to the server.\");" + NL + "\t";
  protected final String TEXT_211 = NL + "\tfor (java.util.Map<String, String> map";
  protected final String TEXT_212 = " : list";
  protected final String TEXT_213 = ") {" + NL;
  protected final String TEXT_214 = " // *** ftp *** //" + NL + "\t\tcom.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_215 = " =null;" + NL;
  protected final String TEXT_216 = NL + "\t\t\tftp_";
  protected final String TEXT_217 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_218 = "\");" + NL + "\t  \t\t";
  protected final String TEXT_219 = NL + "\t\t  \t\tString rootDir_";
  protected final String TEXT_220 = " = ftp_";
  protected final String TEXT_221 = ".pwd();" + NL + "\t  \t\t";
  protected final String TEXT_222 = NL + "\t\t\t";
  protected final String TEXT_223 = NL + "\t\t\t\tif(ftp_";
  protected final String TEXT_224 = "!=null) {" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_225 = " - Uses an existing connection. Connection hostname: \" + ftp_";
  protected final String TEXT_226 = ".getRemoteHost() + \", Connection port: \" + ftp_";
  protected final String TEXT_227 = ".getRemotePort() + \".\"); " + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_228 = NL + "  \t\t";
  protected final String TEXT_229 = NL + "   \t\t\tftp_";
  protected final String TEXT_230 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "\t\t\tftp_";
  protected final String TEXT_231 = ".setRemoteHost(";
  protected final String TEXT_232 = ");" + NL + "\t\t\tftp_";
  protected final String TEXT_233 = ".setRemotePort(";
  protected final String TEXT_234 = ");" + NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_235 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_236 = " - \" + ";
  protected final String TEXT_237 = ");" + NL + "\t\t\t";
  protected final String TEXT_238 = NL + NL + "\t\t    ";
  protected final String TEXT_239 = NL + "\t\t\t\tftp_";
  protected final String TEXT_240 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);" + NL + "\t\t    ";
  protected final String TEXT_241 = NL + "\t\t\t\tftp_";
  protected final String TEXT_242 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);" + NL + "\t\t    ";
  protected final String TEXT_243 = NL + "    \t\tftp_";
  protected final String TEXT_244 = ".setControlEncoding(";
  protected final String TEXT_245 = ");" + NL + "\t\t\t";
  protected final String TEXT_246 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_247 = " - Attempt to connect to '\" + ";
  protected final String TEXT_248 = " + \"' with username '\" +";
  protected final String TEXT_249 = "+ \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_250 = NL + "\t\t    ftp_";
  protected final String TEXT_251 = ".connect();  " + NL + "\t\t    " + NL + "        \t";
  protected final String TEXT_252 = " " + NL + "        \t" + NL + "        \t";
  protected final String TEXT_253 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_254 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_255 = ");";
  protected final String TEXT_256 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_257 = " = ";
  protected final String TEXT_258 = "; ";
  protected final String TEXT_259 = NL + "\t\t    " + NL + "\t\t    ftp_";
  protected final String TEXT_260 = ".login(";
  protected final String TEXT_261 = ", decryptedPassword_";
  protected final String TEXT_262 = ");" + NL + "\t\t\t";
  protected final String TEXT_263 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_264 = " - Connect to '\" + ";
  protected final String TEXT_265 = " +  \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_266 = " " + NL + "\t\t";
  protected final String TEXT_267 = "  " + NL + "" + NL + "\t\t// msg_";
  protected final String TEXT_268 = " likes a String[] to save the message from transfer.  " + NL + "\t\tcom.enterprisedt.net.ftp.TransferCompleteStrings msg_";
  protected final String TEXT_269 = " = ftp_";
  protected final String TEXT_270 = ".getTransferCompleteMessages();" + NL + "\t\tmsg_";
  protected final String TEXT_271 = ".clearAll();" + NL + "\t\tjava.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_272 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL;
  protected final String TEXT_273 = "    " + NL + "\t\t\tjava.util.Map<String,String> map";
  protected final String TEXT_274 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\tmap";
  protected final String TEXT_275 = ".put(";
  protected final String TEXT_276 = ",";
  protected final String TEXT_277 = ");  " + NL + "\t\t\tlist";
  protected final String TEXT_278 = ".add(map";
  protected final String TEXT_279 = ");       ";
  protected final String TEXT_280 = "  " + NL + "\t\tString remotedir";
  protected final String TEXT_281 = " = ";
  protected final String TEXT_282 = ";" + NL + "\t\tftp_";
  protected final String TEXT_283 = ".chdir(remotedir";
  protected final String TEXT_284 = ");" + NL + "" + NL + "\t\t";
  protected final String TEXT_285 = "  " + NL + "\t\t\tftp_";
  protected final String TEXT_286 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.BINARY);" + NL + "\t\t";
  protected final String TEXT_287 = "  " + NL + "\t\t\tftp_";
  protected final String TEXT_288 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.ASCII);" + NL + "\t\t";
  protected final String TEXT_289 = NL + "\t\tString localdir";
  protected final String TEXT_290 = "  = ";
  protected final String TEXT_291 = ";" + NL + "" + NL + "\t\t";
  protected final String TEXT_292 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_293 = " - Uploading files to the server.\");" + NL + "\t\t";
  protected final String TEXT_294 = NL + "\t\tfor (java.util.Map<String, String> map";
  protected final String TEXT_295 = " : list";
  protected final String TEXT_296 = ") {";
  protected final String TEXT_297 = NL + "    \t\tclass TalendTrust_";
  protected final String TEXT_298 = "{ " + NL + "\t            private javax.net.ssl.TrustManager[] getTrustManagers()  " + NL + "\t                throws java.security.KeyStoreException, java.security.NoSuchAlgorithmException,  " + NL + "\t                java.security.cert.CertificateException, java.security.UnrecoverableKeyException, " + NL + "\t                java.io.FileNotFoundException, java.io.IOException{ " + NL + "\t                java.security.KeyStore ks = java.security.KeyStore.getInstance(\"JKS\"); " + NL + "\t                " + NL + "    \t\t\t\t";
  protected final String TEXT_299 = " " + NL + "                  \tString decryptedKeyStorePassword_";
  protected final String TEXT_300 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_301 = ");";
  protected final String TEXT_302 = NL + "                  \tString decryptedKeyStorePassword_";
  protected final String TEXT_303 = " = ";
  protected final String TEXT_304 = "; ";
  protected final String TEXT_305 = NL + "                    " + NL + "\t                ks.load(new java.io.FileInputStream(";
  protected final String TEXT_306 = "), decryptedKeyStorePassword_";
  protected final String TEXT_307 = ".toCharArray()); " + NL + "\t                javax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm()); " + NL + "\t                tmf.init(ks); " + NL + "\t                return tmf.getTrustManagers(); " + NL + "\t            } " + NL + "    \t\t} " + NL + "        \tTalendTrust_";
  protected final String TEXT_308 = " talendTrust_";
  protected final String TEXT_309 = "= null; ";
  protected final String TEXT_310 = " " + NL + "\t    javax.net.ssl.SSLContext sslContext_";
  protected final String TEXT_311 = " = null; " + NL + "\t    javax.net.ssl.TrustManager[] trustManager_";
  protected final String TEXT_312 = " = null; " + NL + "\t    javax.net.ssl.SSLSocketFactory sslSocketFactory_";
  protected final String TEXT_313 = " = null; " + NL + "\t    it.sauronsoftware.ftp4j.FTPClient ftp_";
  protected final String TEXT_314 = " =null; " + NL + "\t    String remotedir_";
  protected final String TEXT_315 = " = null;" + NL + "\t    String rootDir_";
  protected final String TEXT_316 = " = null;" + NL + "\t    try{ ";
  protected final String TEXT_317 = " " + NL + "\t\t        sslContext_";
  protected final String TEXT_318 = " = javax.net.ssl.SSLContext.getInstance(\"SSL\"); " + NL + "\t\t        talendTrust_";
  protected final String TEXT_319 = " = new TalendTrust_";
  protected final String TEXT_320 = "(); " + NL + "\t\t        trustManager_";
  protected final String TEXT_321 = " = talendTrust_";
  protected final String TEXT_322 = ".getTrustManagers(); " + NL + "\t\t        sslContext_";
  protected final String TEXT_323 = ".init(null, trustManager_";
  protected final String TEXT_324 = ", new java.security.SecureRandom()); " + NL + "\t\t        sslSocketFactory_";
  protected final String TEXT_325 = " = sslContext_";
  protected final String TEXT_326 = ".getSocketFactory(); " + NL + "\t                ftp_";
  protected final String TEXT_327 = " = new it.sauronsoftware.ftp4j.FTPClient(); " + NL + "\t                ftp_";
  protected final String TEXT_328 = ".setSSLSocketFactory(sslSocketFactory_";
  protected final String TEXT_329 = ");" + NL + "\t                ftp_";
  protected final String TEXT_330 = ".setCharset(";
  protected final String TEXT_331 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_332 = " " + NL + "\t\t               \t\tftp_";
  protected final String TEXT_333 = ".setSecurity(it.sauronsoftware.ftp4j.FTPClient.SECURITY_FTPS); " + NL + "\t\t\t\t\t";
  protected final String TEXT_334 = " " + NL + "\t\t\t\t        \tftp_";
  protected final String TEXT_335 = ".setSecurity(it.sauronsoftware.ftp4j.FTPClient.SECURITY_FTPES); " + NL + "\t\t\t\t\t";
  protected final String TEXT_336 = "  " + NL + "\t\t\t\t  \t";
  protected final String TEXT_337 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_338 = " - FTPS security Mode is (";
  protected final String TEXT_339 = ").\");" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_340 = " - Attempt to connect to '\" + ";
  protected final String TEXT_341 = " + \"' with username '\" + ";
  protected final String TEXT_342 = "+ \"'.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_343 = NL + "\t                ftp_";
  protected final String TEXT_344 = ".connect(";
  protected final String TEXT_345 = ",";
  protected final String TEXT_346 = "); " + NL + "\t\t\t\t\t";
  protected final String TEXT_347 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_348 = " - Connect to '\" + ";
  protected final String TEXT_349 = " +  \"' has succeeded.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_350 = " " + NL + "\t\t\t\t\t" + NL + "\t\t\t        ";
  protected final String TEXT_351 = " " + NL + "                \t" + NL + "                \t";
  protected final String TEXT_352 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_353 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_354 = ");";
  protected final String TEXT_355 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_356 = " = ";
  protected final String TEXT_357 = "; ";
  protected final String TEXT_358 = NL + "\t\t\t\t\t" + NL + "\t                ftp_";
  protected final String TEXT_359 = ".login(";
  protected final String TEXT_360 = ", decryptedPassword_";
  protected final String TEXT_361 = "); ";
  protected final String TEXT_362 = " " + NL + "                ftp_";
  protected final String TEXT_363 = " = (it.sauronsoftware.ftp4j.FTPClient)globalMap.get(\"";
  protected final String TEXT_364 = "\"); " + NL + "\t\t\t\t";
  protected final String TEXT_365 = NL + "\t\t\t\t\tif(ftp_";
  protected final String TEXT_366 = "!=null) {" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_367 = " - Uses an existing connection. Connection hostname: \" + ftp_";
  protected final String TEXT_368 = ".getHost() + \", Connection port: \" + ftp_";
  protected final String TEXT_369 = ".getPort() + \".\"); " + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_370 = NL + "\t\t\t\t\trootDir_";
  protected final String TEXT_371 = " = ftp_";
  protected final String TEXT_372 = ".currentDirectory();";
  protected final String TEXT_373 = " " + NL + "            remotedir_";
  protected final String TEXT_374 = " = ";
  protected final String TEXT_375 = "; " + NL + "            ftp_";
  protected final String TEXT_376 = ".changeDirectory(remotedir_";
  protected final String TEXT_377 = "); " + NL + "\t\t    } catch (java.lang.IllegalStateException e) { " + NL + "\t\t        e.printStackTrace();" + NL + "\t\t        String errMsg_";
  protected final String TEXT_378 = " = e.getMessage();" + NL + "\t\t        ";
  protected final String TEXT_379 = " " + NL + "\t\t    } catch (java.io.IOException e) { " + NL + "\t\t        e.printStackTrace();" + NL + "\t\t        String errMsg_";
  protected final String TEXT_380 = " = e.getMessage();" + NL + "\t\t        ";
  protected final String TEXT_381 = " " + NL + "\t\t    } catch (it.sauronsoftware.ftp4j.FTPIllegalReplyException e) { " + NL + "\t\t        e.printStackTrace(); " + NL + "\t\t        String errMsg_";
  protected final String TEXT_382 = " = e.getMessage();" + NL + "\t\t        ";
  protected final String TEXT_383 = NL + "\t\t    } catch (it.sauronsoftware.ftp4j.FTPException e) { " + NL + "\t\t        e.printStackTrace();" + NL + "\t\t        String errMsg_";
  protected final String TEXT_384 = " = e.getMessage();" + NL + "\t\t        ";
  protected final String TEXT_385 = " " + NL + "\t\t    } " + NL + "  \t\t\tjava.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_386 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "  " + NL + "  \t\t\t";
  protected final String TEXT_387 = NL + "    \t\tjava.util.Map<String,String> map";
  protected final String TEXT_388 = " = new java.util.HashMap<String,String>();" + NL + "   \t\t\t map";
  protected final String TEXT_389 = ".put(";
  protected final String TEXT_390 = ", ";
  protected final String TEXT_391 = ");    " + NL + "    \t\t\tlist";
  protected final String TEXT_392 = ".add(map";
  protected final String TEXT_393 = ");       " + NL + "  \t\t\t";
  protected final String TEXT_394 = "  " + NL + "\t\t\tString localdir";
  protected final String TEXT_395 = " = ";
  protected final String TEXT_396 = ";" + NL + "\t\t\t";
  protected final String TEXT_397 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_398 = " - Uploading files to the server.\");" + NL + "\t\t\t";
  protected final String TEXT_399 = NL + "\t     \tfor (java.util.Map<String, String> map";
  protected final String TEXT_400 = " : list";
  protected final String TEXT_401 = ") {";
  protected final String TEXT_402 = NL;

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
            
    stringBuffer.append(TEXT_30);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_31);
    
            }
            
    stringBuffer.append(TEXT_32);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_34);
    for(String message : messages){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    
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
    
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
       			 if(log4jEnabled){
       			 
    stringBuffer.append(TEXT_40);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_43);
    
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
                    
    stringBuffer.append(TEXT_44);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_47);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    
    stringBuffer.append(TEXT_48);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_51);
    
                }   
                
    stringBuffer.append(TEXT_52);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_53);
    
            }
        }
		debug(var("log4jParamters"));
		
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_56);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_57);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_58);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_61);
    
                }else{
                
    stringBuffer.append(TEXT_62);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_70);
    
                }
                
    stringBuffer.append(TEXT_71);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_72);
    
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
LogUtil commonLog = new LogUtil(node);
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");

boolean use_encoding = "true".equals(ElementParameterParser.getValue(node, "__USE_ENCODING__"));

String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");  
String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");

List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");  
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");

String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean moveToCurrentDir = ("true").equals(ElementParameterParser.getValue(node, "__MOVE_TO_THE_CURRENT_DIRECTORY__"));
boolean sftp = false;
boolean ftps = false; 

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String passwordFieldName = "";

if (("true").equals(useExistingConn)) {
  List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();

  for (INode n : nodeList) {
    if (n.getUniqueName().equals(connection)) {
      sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
      ftps = ("true").equals(ElementParameterParser.getValue(n, "__FTPS__")); 
    }
  }
} else {
  sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
  ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__")); 
}  

//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.
if (useProxy) {

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_80);
    
passwordFieldName = "__PROXY_PASSWORD__";
if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_83);
    } else {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_86);
    }
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    if (sftp) {
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    if (("true").equals(useExistingConn)) {
    	String conn= "conn_" + connection;
    
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_96);
    if(isLog4jEnabled){
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
    }
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
    } else {
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    
            passwordFieldName = "__PASSPHRASE__";
            if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
            
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_114);
    } else {
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    
        	passwordFieldName = "__PASSWORD__";
        	
    stringBuffer.append(TEXT_122);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_125);
    } else {
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_128);
    }
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_136);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(privateKey);
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    }
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_152);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    }
    stringBuffer.append(TEXT_155);
    
        	passwordFieldName = "__PASSWORD__";
        	
    stringBuffer.append(TEXT_156);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_159);
    } else {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    if (!useProxy) {
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_178);
    }
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    if(use_encoding) {
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_192);
    }
    stringBuffer.append(TEXT_193);
    }
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    
	for (int i = 0; i < files.size(); i++) {
    	Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_201);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_202);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_205);
    
	}
  
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_208);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    }
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    } else if (!ftps) {
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    
		if (("true").equals(useExistingConn)) {
			String conn= "conn_" + connection;
    
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_218);
    if(!moveToCurrentDir){
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    }
    stringBuffer.append(TEXT_222);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    }
    stringBuffer.append(TEXT_228);
    } else {
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_234);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_237);
    }
    stringBuffer.append(TEXT_238);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    } else {
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    }
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_245);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_249);
    }
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    
        	passwordFieldName = "__PASSWORD__";
        	
    stringBuffer.append(TEXT_252);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_255);
    } else {
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_258);
    }
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_265);
    }
    stringBuffer.append(TEXT_266);
    }
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    
		for (int i = 0; i < files.size(); i++) {
			Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_275);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_276);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_279);
    
		}
  
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    if ("binary".equalsIgnoreCase(ElementParameterParser.getValue(node, "__MODE__"))) {
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    } else { 
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    }
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_291);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    }
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    
}else{ // *** ftps *** // 
		String keystoreFile = ElementParameterParser.getValue(node,"__KEYSTORE_FILE__"); 

		String securityMode = ElementParameterParser.getValue(node, "__SECURITY_MODE__");
        if(("false").equals(useExistingConn)){ 

    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    
                    passwordFieldName = "__KEYSTORE_PASS__";
                    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
                    
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_301);
    } else {
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_304);
    }
    stringBuffer.append(TEXT_305);
    stringBuffer.append(keystoreFile);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
           
        }

    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
           
        	if(("false").equals(useExistingConn)){ 

    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_331);
     
				        if("IMPLICIT".equals(securityMode)){ 
					
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
     
				        }else if("EXPLICIT".equals(securityMode)){ 
					
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
     
					    } 
					
    stringBuffer.append(TEXT_336);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(securityMode);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_342);
    }
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_346);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_349);
    }
    stringBuffer.append(TEXT_350);
    
                	passwordFieldName = "__PASSWORD__";
                	
    stringBuffer.append(TEXT_351);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_354);
    } else {
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_357);
    }
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
           
        	}else{ 
                String conn= "conn_" + connection; 

    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_364);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    }
           
				if(!moveToCurrentDir){

    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    
				}
        	} 

    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_378);
     commonLog.logPrintedException(commonLog.var("errMsg")); 
    stringBuffer.append(TEXT_379);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_380);
     commonLog.logPrintedException(commonLog.var("errMsg")); 
    stringBuffer.append(TEXT_381);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_382);
     commonLog.logPrintedException(commonLog.var("errMsg")); 
    stringBuffer.append(TEXT_383);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_384);
     commonLog.logPrintedException(commonLog.var("errMsg")); 
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_386);
    
  			for (int i = 0; i < files.size(); i++) {
    			Map<String, String> line = files.get(i);
    		
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_389);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_390);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_393);
    
 			 }
  			
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_396);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    }
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    }
    stringBuffer.append(TEXT_402);
    return stringBuffer.toString();
  }
}
