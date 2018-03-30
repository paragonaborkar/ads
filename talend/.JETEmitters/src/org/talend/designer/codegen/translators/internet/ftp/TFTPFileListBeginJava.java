package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TFTPFileListBeginJava
{
  protected static String nl;
  public static synchronized TFTPFileListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPFileListBeginJava result = new TFTPFileListBeginJava();
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
  protected final String TEXT_30 = NL + "\tjava.util.List<String> maskList_";
  protected final String TEXT_31 = " = new java.util.ArrayList<String>();" + NL;
  protected final String TEXT_32 = NL + "\tmaskList_";
  protected final String TEXT_33 = ".add(\"*\");";
  protected final String TEXT_34 = " " + NL + "\t\tmaskList_";
  protected final String TEXT_35 = ".add(";
  protected final String TEXT_36 = "); ";
  protected final String TEXT_37 = NL + "\tjava.util.Properties props_";
  protected final String TEXT_38 = " = System.getProperties();" + NL + "\tprops_";
  protected final String TEXT_39 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_40 = ");" + NL + "\tprops_";
  protected final String TEXT_41 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_42 = ");" + NL + "\tprops_";
  protected final String TEXT_43 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_44 = ");" + NL + "\t";
  protected final String TEXT_45 = " " + NL + "\tString decryptedProxyPassword_";
  protected final String TEXT_46 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + " \tString decryptedProxyPassword_";
  protected final String TEXT_49 = " = ";
  protected final String TEXT_50 = "; ";
  protected final String TEXT_51 = NL + NL + "\tprops_";
  protected final String TEXT_52 = ".put(\"java.net.socks.password\", decryptedProxyPassword_";
  protected final String TEXT_53 = ");        ";
  protected final String TEXT_54 = NL + "\t\tclass MyUserInfo_";
  protected final String TEXT_55 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "\t\t";
  protected final String TEXT_56 = " " + NL + "          \t\tString decryptedPassphrase_";
  protected final String TEXT_57 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "          \t\tString decryptedPassphrase_";
  protected final String TEXT_60 = " = ";
  protected final String TEXT_61 = "; ";
  protected final String TEXT_62 = NL + "            " + NL + "\t\t\tString passphrase_";
  protected final String TEXT_63 = " = decryptedPassphrase_";
  protected final String TEXT_64 = ";" + NL + "" + NL + "\t\t\tpublic String getPassphrase() { return passphrase_";
  protected final String TEXT_65 = "; }" + NL + "" + NL + "\t\t\tpublic String getPassword() { return null; } " + NL + "" + NL + "\t\t\tpublic boolean promptPassword(String arg0) { return true; } " + NL + "" + NL + "\t\t\tpublic boolean promptPassphrase(String arg0) { return true; } " + NL + "" + NL + "\t\t\tpublic boolean promptYesNo(String arg0) { return true; } " + NL + "" + NL + "\t\t\tpublic void showMessage(String arg0) { } " + NL + "" + NL + "\t\t\tpublic String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "\t\t\tboolean[] echo) {" + NL + "\t\t\t";
  protected final String TEXT_66 = " " + NL + "    \t" + NL + "    \t\t";
  protected final String TEXT_67 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_68 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = "; ";
  protected final String TEXT_73 = NL + "    \t\t" + NL + "\t\t\t\tString[] password_";
  protected final String TEXT_74 = " = {decryptedPassword_";
  protected final String TEXT_75 = "};" + NL + "\t\t\t\treturn password_";
  protected final String TEXT_76 = ";" + NL + "\t\t\t}" + NL + "\t\t}; " + NL + "\t\tfinal com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_77 = " = new MyUserInfo_";
  protected final String TEXT_78 = "();" + NL + "\t\tcom.jcraft.jsch.JSch jsch_";
  protected final String TEXT_79 = "=new com.jcraft.jsch.JSch(); " + NL + "" + NL + "\t\t";
  protected final String TEXT_80 = NL + "\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_82 = " - SFTP authentication using a public key.\");" + NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_83 = " - Private key: '\" + ";
  protected final String TEXT_84 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\tjsch_";
  protected final String TEXT_86 = ".addIdentity(";
  protected final String TEXT_87 = ", defaultUserInfo_";
  protected final String TEXT_88 = ".getPassphrase());" + NL + "\t\t";
  protected final String TEXT_89 = NL + "\t\t" + NL + "\t\tcom.jcraft.jsch.Session session_";
  protected final String TEXT_90 = "=jsch_";
  protected final String TEXT_91 = ".getSession(";
  protected final String TEXT_92 = ", ";
  protected final String TEXT_93 = ", ";
  protected final String TEXT_94 = ");" + NL + "\t\tsession_";
  protected final String TEXT_95 = ".setConfig(\"PreferredAuthentications\", \"publickey,password,keyboard-interactive,gssapi-with-mic\");" + NL + "" + NL + "\t\t";
  protected final String TEXT_96 = NL + "\t\t\t";
  protected final String TEXT_97 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_98 = " - SFTP authentication using a password.\");" + NL + "\t  \t\t";
  protected final String TEXT_99 = " " + NL + "\t  \t\t" + NL + "\t  \t\t";
  protected final String TEXT_100 = " " + NL + "    \t" + NL + "\t\t\t";
  protected final String TEXT_101 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_102 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_103 = ");";
  protected final String TEXT_104 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = "; ";
  protected final String TEXT_107 = NL + "\t  \t\t" + NL + "      \t\tsession_";
  protected final String TEXT_108 = ".setPassword(decryptedPassword_";
  protected final String TEXT_109 = "); " + NL + "\t\t";
  protected final String TEXT_110 = NL + "\t\tsession_";
  protected final String TEXT_111 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_112 = "); " + NL + "\t\t";
  protected final String TEXT_113 = NL + "\t\tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "\t\t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_114 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "  \t\t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "  \t\t\t\tproxy_";
  protected final String TEXT_115 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t\t}" + NL + "  \t\t\tsession_";
  protected final String TEXT_116 = ".setProxy(proxy_";
  protected final String TEXT_117 = ");" + NL + "  \t\t}" + NL + "\t\t";
  protected final String TEXT_118 = NL + "\t\t";
  protected final String TEXT_119 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_120 = " - Attempt to connect to '\" + ";
  protected final String TEXT_121 = " + \"' with username '\" + ";
  protected final String TEXT_122 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_123 = NL + "\t\tsession_";
  protected final String TEXT_124 = ".connect();" + NL + "\t\tcom.jcraft.jsch. Channel channel_";
  protected final String TEXT_125 = "=session_";
  protected final String TEXT_126 = ".openChannel(\"sftp\");" + NL + "\t\tchannel_";
  protected final String TEXT_127 = ".connect();" + NL + "\t\t";
  protected final String TEXT_128 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_129 = " - Connect to '\" + ";
  protected final String TEXT_130 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_131 = NL + "\t\tcom.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_132 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_133 = ";" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_134 = NL + "    \t\tc_";
  protected final String TEXT_135 = ".setFilenameEncoding(";
  protected final String TEXT_136 = ");" + NL + "    \t";
  protected final String TEXT_137 = NL;
  protected final String TEXT_138 = "    " + NL + "    \tcom.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_139 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_140 = "\");" + NL + "\t\t";
  protected final String TEXT_141 = NL + "\t\t\tif(c_";
  protected final String TEXT_142 = "!=null && c_";
  protected final String TEXT_143 = ".getSession()!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_144 = " - Use an existing connection. Connection username: \" + c_";
  protected final String TEXT_145 = ".getSession().getUserName() + \", Connection hostname: \" + c_";
  protected final String TEXT_146 = ".getSession().getHost() + \", Connection port: \" + c_";
  protected final String TEXT_147 = ".getSession().getPort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_148 = NL + "\t    if(c_";
  protected final String TEXT_149 = ".getHome()!=null && !c_";
  protected final String TEXT_150 = ".getHome().equals(c_";
  protected final String TEXT_151 = ".pwd())){" + NL + "\t  \t\tc_";
  protected final String TEXT_152 = ".cd(c_";
  protected final String TEXT_153 = ".getHome());" + NL + "\t  \t}";
  protected final String TEXT_154 = NL + "\tString remotedir_";
  protected final String TEXT_155 = " = ";
  protected final String TEXT_156 = ".replaceAll(\"\\\\\\\\\", \"/\");" + NL + "\tjava.util.Vector<com.jcraft.jsch.ChannelSftp.LsEntry> vector_";
  protected final String TEXT_157 = " = c_";
  protected final String TEXT_158 = ".ls(remotedir_";
  protected final String TEXT_159 = ");" + NL + "\tcom.jcraft.jsch.ChannelSftp.LsEntry[] sftpFiles_";
  protected final String TEXT_160 = " = vector_";
  protected final String TEXT_161 = ".toArray(new com.jcraft.jsch.ChannelSftp.LsEntry[0]);" + NL + "\tint nb_file_";
  protected final String TEXT_162 = " = 0;  " + NL + "\tList<String> fileListTemp_";
  protected final String TEXT_163 = " = new java.util.ArrayList<String>();" + NL + "" + NL + "\tfor (String filemask_";
  protected final String TEXT_164 = " : maskList_";
  protected final String TEXT_165 = ") {" + NL + "\t\tjava.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_166 = " = java.util.regex.Pattern.compile(filemask_";
  protected final String TEXT_167 = ".replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\"));" + NL + "    " + NL + "\t\tfor (com.jcraft.jsch.ChannelSftp.LsEntry filemaskTemp_";
  protected final String TEXT_168 = " : sftpFiles_";
  protected final String TEXT_169 = ") {" + NL + "\t\t\tif (fileNamePattern_";
  protected final String TEXT_170 = ".matcher(filemaskTemp_";
  protected final String TEXT_171 = ".getFilename()).matches()) {" + NL + "\t\t\t\tfileListTemp_";
  protected final String TEXT_172 = ".add(filemaskTemp_";
  protected final String TEXT_173 = ".getFilename());" + NL + "      \t\t}" + NL + "    \t}" + NL + "  \t}    " + NL + "" + NL + "\t";
  protected final String TEXT_174 = NL + "\t\tlog.info(\"";
  protected final String TEXT_175 = " - Listing files from server.\");" + NL + "\t";
  protected final String TEXT_176 = NL + "\tfor (String sftpFile_";
  protected final String TEXT_177 = " : fileListTemp_";
  protected final String TEXT_178 = ") {" + NL + "" + NL + "    if ((\".\").equals(sftpFile_";
  protected final String TEXT_179 = ") || (\"..\").equals(sftpFile_";
  protected final String TEXT_180 = ")) {" + NL + "      continue;" + NL + "    }" + NL + "    String currentFileName_";
  protected final String TEXT_181 = " = sftpFile_";
  protected final String TEXT_182 = "; " + NL + "    String currentFilePath_";
  protected final String TEXT_183 = " = remotedir_";
  protected final String TEXT_184 = " + \"/\" + sftpFile_";
  protected final String TEXT_185 = ";" + NL + "\t";
  protected final String TEXT_186 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_187 = " - List file : '\" + currentFilePath_";
  protected final String TEXT_188 = " + \"' .\");" + NL + "\t";
  protected final String TEXT_189 = " " + NL + "    globalMap.put(\"";
  protected final String TEXT_190 = "_CURRENT_FILE\", currentFileName_";
  protected final String TEXT_191 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_192 = "_CURRENT_FILEPATH\", currentFilePath_";
  protected final String TEXT_193 = ");" + NL + "    nb_file_";
  protected final String TEXT_194 = "++;" + NL;
  protected final String TEXT_195 = NL + "  \tint nb_file_";
  protected final String TEXT_196 = " = 0;" + NL + "\tcom.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_197 = " =null;" + NL + "" + NL + "  \t";
  protected final String TEXT_198 = NL + "\t    ftp_";
  protected final String TEXT_199 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_200 = "\");" + NL + "\t\t";
  protected final String TEXT_201 = NL + "\t\t\tif(ftp_";
  protected final String TEXT_202 = "!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_203 = " - Use an existing connection. Connection hostname: \" + ftp_";
  protected final String TEXT_204 = ".getRemoteHost() + \", Connection port: \" + ftp_";
  protected final String TEXT_205 = ".getRemotePort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_206 = NL + "\t  \t";
  protected final String TEXT_207 = NL + "\t  \t\tString rootDir_";
  protected final String TEXT_208 = " = ftp_";
  protected final String TEXT_209 = ".pwd();" + NL + "\t  \t";
  protected final String TEXT_210 = NL + "\t";
  protected final String TEXT_211 = "    " + NL + "\t    ftp_";
  protected final String TEXT_212 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "\t    ftp_";
  protected final String TEXT_213 = ".setRemoteHost(";
  protected final String TEXT_214 = ");" + NL + "\t    ftp_";
  protected final String TEXT_215 = ".setRemotePort(";
  protected final String TEXT_216 = ");" + NL + "    " + NL + "\t\t";
  protected final String TEXT_217 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_218 = " - \" + ";
  protected final String TEXT_219 = ");" + NL + "\t\t";
  protected final String TEXT_220 = NL + "\t    ";
  protected final String TEXT_221 = NL + "\t      ftp_";
  protected final String TEXT_222 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);" + NL + "\t    ";
  protected final String TEXT_223 = NL + "\t      ftp_";
  protected final String TEXT_224 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);" + NL + "\t    ";
  protected final String TEXT_225 = NL + "\t\t";
  protected final String TEXT_226 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_227 = " - Attempt to connect to '\" + ";
  protected final String TEXT_228 = " + \"' with username '\" +";
  protected final String TEXT_229 = "+ \"'.\");" + NL + "\t\t";
  protected final String TEXT_230 = NL + "\t    ftp_";
  protected final String TEXT_231 = ".setControlEncoding(";
  protected final String TEXT_232 = ");" + NL + "\t    ftp_";
  protected final String TEXT_233 = ".connect();  " + NL + "\t    " + NL + "\t    ";
  protected final String TEXT_234 = " " + NL + "    \t" + NL + "\t\t";
  protected final String TEXT_235 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_236 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_237 = ");";
  protected final String TEXT_238 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_239 = " = ";
  protected final String TEXT_240 = "; ";
  protected final String TEXT_241 = NL + "\t\t" + NL + "\t    ftp_";
  protected final String TEXT_242 = ".login(";
  protected final String TEXT_243 = ", decryptedPassword_";
  protected final String TEXT_244 = "); " + NL + "\t\t";
  protected final String TEXT_245 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_246 = " - Connect to '\" + ";
  protected final String TEXT_247 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_248 = "  " + NL + "\t";
  protected final String TEXT_249 = "      " + NL + "\tString remotedir_";
  protected final String TEXT_250 = " = ";
  protected final String TEXT_251 = ";" + NL + "\tftp_";
  protected final String TEXT_252 = ".chdir(remotedir_";
  protected final String TEXT_253 = ");" + NL + "\tString[] fileList_";
  protected final String TEXT_254 = ";" + NL + "" + NL + "\tif (";
  protected final String TEXT_255 = ") {" + NL + "\t\tfileList_";
  protected final String TEXT_256 = " = ftp_";
  protected final String TEXT_257 = ".dir(null, true);" + NL + "\t} else {" + NL + "\t\tfileList_";
  protected final String TEXT_258 = " = ftp_";
  protected final String TEXT_259 = ".dir(null, false);" + NL + "\t}";
  protected final String TEXT_260 = NL + "  \t\t\tftp_";
  protected final String TEXT_261 = ".chdir(rootDir_";
  protected final String TEXT_262 = ");";
  protected final String TEXT_263 = NL + "\tList<String> fileListTemp_";
  protected final String TEXT_264 = " = new java.util.ArrayList<String>();" + NL + "" + NL + "\tfor (String filemask_";
  protected final String TEXT_265 = " : maskList_";
  protected final String TEXT_266 = ") {" + NL + "\t\tjava.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_267 = " = java.util.regex.Pattern.compile(filemask_";
  protected final String TEXT_268 = ".replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\"));" + NL + "\t" + NL + "\t    for (String filemaskTemp_";
  protected final String TEXT_269 = " : fileList_";
  protected final String TEXT_270 = ") {" + NL + "\t\t\tif (fileNamePattern_";
  protected final String TEXT_271 = ".matcher(filemaskTemp_";
  protected final String TEXT_272 = ").matches()) {" + NL + "\t        \tfileListTemp_";
  protected final String TEXT_273 = ".add(filemaskTemp_";
  protected final String TEXT_274 = ");" + NL + "\t      \t}" + NL + "\t\t}" + NL + "\t}    " + NL + "\tint i_";
  protected final String TEXT_275 = " = -1;" + NL + "" + NL + "\t";
  protected final String TEXT_276 = NL + "\t\tlog.info(\"";
  protected final String TEXT_277 = " - Listing files from server.\");" + NL + "\t";
  protected final String TEXT_278 = " " + NL + "\twhile (++i_";
  protected final String TEXT_279 = " < fileListTemp_";
  protected final String TEXT_280 = ".size()) {" + NL + "\t    String currentFileName_";
  protected final String TEXT_281 = " = fileListTemp_";
  protected final String TEXT_282 = ".get(i_";
  protected final String TEXT_283 = "); " + NL + "\t    String currentFilePath_";
  protected final String TEXT_284 = " = remotedir_";
  protected final String TEXT_285 = " + \"/\" + fileListTemp_";
  protected final String TEXT_286 = ".get(i_";
  protected final String TEXT_287 = ");" + NL + "\t\t";
  protected final String TEXT_288 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_289 = " - List file : '\" + currentFilePath_";
  protected final String TEXT_290 = " + \"' .\");" + NL + "\t\t";
  protected final String TEXT_291 = " " + NL + "\t    globalMap.put(\"";
  protected final String TEXT_292 = "_CURRENT_FILE\", currentFileName_";
  protected final String TEXT_293 = ");" + NL + "\t    globalMap.put(\"";
  protected final String TEXT_294 = "_CURRENT_FILEPATH\", currentFilePath_";
  protected final String TEXT_295 = ");" + NL + "\t    nb_file_";
  protected final String TEXT_296 = "++;";
  protected final String TEXT_297 = NL;

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
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");

boolean use_encoding = "true".equals(ElementParameterParser.getValue(node, "__USE_ENCODING__"));

String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
boolean dirFull = ("true").equals(ElementParameterParser.getValue(node, "__DIR_FULL__"));
String cid = node.getUniqueName();
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");

boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");

String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");  
List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String conn= "conn_" + connection;
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean moveToCurrentDir = ("true").equals(ElementParameterParser.getValue(node, "__MOVE_TO_THE_CURRENT_DIRECTORY__"));
boolean sftp = false;

if (("true").equals(useExistingConn)) {
  List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();

  for (INode n : nodeList) {
    if (n.getUniqueName().equals(connection)) {
      sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
    }
  }
} else {
  sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
}
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String passwordFieldName = "";


    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
if (files.size() == 0) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
} else {
  for (int i = 0; i < files.size(); i++) {
    Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_36);
    
  }
}

//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.
if (useProxy) {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_44);
    
passwordFieldName = "__PROXY_PASSWORD__";
if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_47);
    } else {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
}

if (sftp) {// *** sftp *** //

	if (("false").equals(useExistingConn)) {
	
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
            passwordFieldName = "__PASSPHRASE__";
            if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
            
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_58);
    } else {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    
			passwordFieldName = "__PASSWORD__";
			
    stringBuffer.append(TEXT_66);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_69);
    } else {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_80);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(privateKey);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_96);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    }
    stringBuffer.append(TEXT_99);
    
			passwordFieldName = "__PASSWORD__";
			
    stringBuffer.append(TEXT_100);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_103);
    } else {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    if (!useProxy) {
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_122);
    }
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    if(use_encoding) {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    
	} else {
  
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_140);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    }
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
    
	}
  
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
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
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    }
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    }
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
} else {// *** ftp *** //

    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    if (("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_200);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    }
    stringBuffer.append(TEXT_206);
    if(!moveToCurrentDir){
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    }
    stringBuffer.append(TEXT_210);
    } else {
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_216);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_219);
    }
    stringBuffer.append(TEXT_220);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    } else {
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    }
    stringBuffer.append(TEXT_225);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_229);
    }
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    
		passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_234);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_237);
    } else {
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_240);
    }
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_247);
    }
    stringBuffer.append(TEXT_248);
    }
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(dirFull );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    
	if (("true").equals(useExistingConn)) {
		if(!moveToCurrentDir){

    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    	
		}
	}

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    }
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    }
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    }
    stringBuffer.append(TEXT_297);
    return stringBuffer.toString();
  }
}
