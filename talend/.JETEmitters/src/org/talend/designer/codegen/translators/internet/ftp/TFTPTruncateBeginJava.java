package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TFTPTruncateBeginJava
{
  protected static String nl;
  public static synchronized TFTPTruncateBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPTruncateBeginJava result = new TFTPTruncateBeginJava();
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
  protected final String TEXT_30 = NL + "\tjava.util.Properties props_";
  protected final String TEXT_31 = " = System.getProperties();" + NL + "\tprops_";
  protected final String TEXT_32 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_33 = ");" + NL + "\tprops_";
  protected final String TEXT_34 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_35 = ");" + NL + "\tprops_";
  protected final String TEXT_36 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_37 = ");" + NL + "\t";
  protected final String TEXT_38 = " " + NL + "  String decryptedProxyPassword_";
  protected final String TEXT_39 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "  String decryptedProxyPassword_";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = "; ";
  protected final String TEXT_44 = NL + "\t" + NL + "\tprops_";
  protected final String TEXT_45 = ".put(\"java.net.socks.password\", decryptedProxyPassword_";
  protected final String TEXT_46 = ");        ";
  protected final String TEXT_47 = NL + "\tint nb_file_";
  protected final String TEXT_48 = " = 0;" + NL;
  protected final String TEXT_49 = NL + "\t\tclass MyUserInfo_";
  protected final String TEXT_50 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_51 = " " + NL + "          \t\tString decryptedPassphrase_";
  protected final String TEXT_52 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "          \t\tString decryptedPassphrase_";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = "; ";
  protected final String TEXT_57 = NL + "\t\t" + NL + "\t\t\tString passphrase_";
  protected final String TEXT_58 = " = decryptedPassphrase_";
  protected final String TEXT_59 = ";" + NL + "\t\t\tpublic String getPassphrase() { return passphrase_";
  protected final String TEXT_60 = "; }" + NL + "" + NL + "\t\t\tpublic String getPassword() { return null; } " + NL + "\t\t\tpublic boolean promptPassword(String arg0) { return true; } " + NL + "\t\t\tpublic boolean promptPassphrase(String arg0) { return true; } " + NL + "\t\t\tpublic boolean promptYesNo(String arg0) { return true; } " + NL + "\t\t\tpublic void showMessage(String arg0) { } " + NL + "" + NL + "\t\t\tpublic String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "\t\t\t\tboolean[] echo) {" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_61 = " " + NL + "    \t" + NL + "\t\t\t";
  protected final String TEXT_62 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_63 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = "; ";
  protected final String TEXT_68 = NL + "\t\t\t" + NL + "\t\t\t\tString[] password_";
  protected final String TEXT_69 = " = {decryptedPassword_";
  protected final String TEXT_70 = "};" + NL + "\t\t\t\treturn password_";
  protected final String TEXT_71 = ";" + NL + "\t\t\t}" + NL + "\t\t}; " + NL + "\t\tfinal com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_72 = " = new MyUserInfo_";
  protected final String TEXT_73 = "();" + NL + "\t\tcom.jcraft.jsch.JSch jsch_";
  protected final String TEXT_74 = "=new com.jcraft.jsch.JSch(); " + NL + "" + NL + "\t\t";
  protected final String TEXT_75 = NL + "\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_77 = " - SFTP authentication using a public key.\");" + NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_78 = " - Private key: '\" + ";
  protected final String TEXT_79 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\tjsch_";
  protected final String TEXT_81 = ".addIdentity(";
  protected final String TEXT_82 = ", defaultUserInfo_";
  protected final String TEXT_83 = ".getPassphrase());" + NL + "    \t";
  protected final String TEXT_84 = NL + "    \t" + NL + "\t\tcom.jcraft.jsch.Session session_";
  protected final String TEXT_85 = "=jsch_";
  protected final String TEXT_86 = ".getSession(";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = ");" + NL + "\t\tsession_";
  protected final String TEXT_90 = ".setConfig(\"PreferredAuthentications\", \"publickey,password,keyboard-interactive,gssapi-with-mic\");" + NL + "" + NL + "\t\t";
  protected final String TEXT_91 = " " + NL + "\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_93 = " - SFTP authentication using a password.\");" + NL + "\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_95 = " " + NL + "    \t" + NL + "\t\t\t";
  protected final String TEXT_96 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_97 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_98 = ");";
  protected final String TEXT_99 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = "; ";
  protected final String TEXT_102 = NL + "\t\t\t" + NL + "      \t\tsession_";
  protected final String TEXT_103 = ".setPassword(decryptedPassword_";
  protected final String TEXT_104 = "); " + NL + "    \t";
  protected final String TEXT_105 = NL + "\t\tsession_";
  protected final String TEXT_106 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_107 = "); " + NL + "\t\t";
  protected final String TEXT_108 = NL + "\t\t\tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "\t\t\t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_109 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "\t\t\t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "\t\t\t\t\tproxy_";
  protected final String TEXT_110 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "\t\t\t\t}" + NL + "\t\t\t\tsession_";
  protected final String TEXT_111 = ".setProxy(proxy_";
  protected final String TEXT_112 = ");" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_113 = NL + "\t\t";
  protected final String TEXT_114 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_115 = " - Attempt to connect to '\" + ";
  protected final String TEXT_116 = " + \"' with username '\" + ";
  protected final String TEXT_117 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_118 = NL + "\t    session_";
  protected final String TEXT_119 = ".connect();" + NL + "\t    com.jcraft.jsch. Channel channel_";
  protected final String TEXT_120 = "=session_";
  protected final String TEXT_121 = ".openChannel(\"sftp\");" + NL + "\t    channel_";
  protected final String TEXT_122 = ".connect();" + NL + "\t\t";
  protected final String TEXT_123 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_124 = " - Connect to '\" + ";
  protected final String TEXT_125 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_126 = NL + "\t    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_127 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_128 = ";" + NL + "\t    " + NL + "\t    ";
  protected final String TEXT_129 = NL + "\t    \tc_";
  protected final String TEXT_130 = ".setFilenameEncoding(";
  protected final String TEXT_131 = ");" + NL + "\t    ";
  protected final String TEXT_132 = NL + "\t";
  protected final String TEXT_133 = "    " + NL + "\t    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_134 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_135 = "\");" + NL + "\t\t";
  protected final String TEXT_136 = NL + "\t\t\tif(c_";
  protected final String TEXT_137 = "!=null && c_";
  protected final String TEXT_138 = ".getSession()!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_139 = " - Use an existing connection.Connection username: \" + c_";
  protected final String TEXT_140 = ".getSession().getUserName() + \", Connection hostname: \" + c_";
  protected final String TEXT_141 = ".getSession().getHost() + \", Connection port: \" + c_";
  protected final String TEXT_142 = ".getSession().getPort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_143 = NL + "\t    if(c_";
  protected final String TEXT_144 = ".getHome()!=null && !c_";
  protected final String TEXT_145 = ".getHome().equals(c_";
  protected final String TEXT_146 = ".pwd())){" + NL + "\t  \t\tc_";
  protected final String TEXT_147 = ".cd(c_";
  protected final String TEXT_148 = ".getHome());" + NL + "\t  \t}" + NL + "\t";
  protected final String TEXT_149 = " " + NL + "\tjava.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_150 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "" + NL + "\t";
  protected final String TEXT_151 = "    " + NL + "\t    java.util.Map<String,String> map";
  protected final String TEXT_152 = " = new java.util.HashMap<String,String>();" + NL + "\t    map";
  protected final String TEXT_153 = ".put(";
  protected final String TEXT_154 = ",\"\");" + NL + "\t    list";
  protected final String TEXT_155 = ".add(map";
  protected final String TEXT_156 = ");" + NL + "\t";
  protected final String TEXT_157 = NL;
  protected final String TEXT_158 = NL + "    \tlog.info(\"";
  protected final String TEXT_159 = " - Truncating file from the server.\");";
  protected final String TEXT_160 = NL + "\tfor (java.util.Map<String, String> map";
  protected final String TEXT_161 = " : list";
  protected final String TEXT_162 = ") {" + NL;
  protected final String TEXT_163 = NL + "\tcom.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_164 = " = null;" + NL + "" + NL + "\t";
  protected final String TEXT_165 = NL + "\t\tftp_";
  protected final String TEXT_166 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_167 = "\");" + NL + "\t\t";
  protected final String TEXT_168 = NL + "\t\t\tif(ftp_";
  protected final String TEXT_169 = "!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_170 = " - Use an existing connection. Connection hostname: \" + ftp_";
  protected final String TEXT_171 = ".getRemoteHost() + \", Connection port: \" + ftp_";
  protected final String TEXT_172 = ".getRemotePort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_173 = NL + "\t\t";
  protected final String TEXT_174 = NL + "\t\t  String rootDir_";
  protected final String TEXT_175 = " = ftp_";
  protected final String TEXT_176 = ".pwd();" + NL + "\t\t";
  protected final String TEXT_177 = NL + "\t";
  protected final String TEXT_178 = "    " + NL + "\t    ftp_";
  protected final String TEXT_179 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "\t    ftp_";
  protected final String TEXT_180 = ".setRemoteHost(";
  protected final String TEXT_181 = ");" + NL + "\t    ftp_";
  protected final String TEXT_182 = ".setRemotePort(";
  protected final String TEXT_183 = ");" + NL + "" + NL + "\t    ";
  protected final String TEXT_184 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_185 = " - \" + ";
  protected final String TEXT_186 = ");" + NL + "\t\t";
  protected final String TEXT_187 = NL + "\t    ";
  protected final String TEXT_188 = NL + "\t      ftp_";
  protected final String TEXT_189 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);" + NL + "\t    ";
  protected final String TEXT_190 = NL + "\t      ftp_";
  protected final String TEXT_191 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);" + NL + "\t    ";
  protected final String TEXT_192 = NL + "    \tftp_";
  protected final String TEXT_193 = ".setControlEncoding(";
  protected final String TEXT_194 = ");" + NL + "\t\t";
  protected final String TEXT_195 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_196 = " - Attempt to connect to '\" + ";
  protected final String TEXT_197 = " + \"' with username '\" +";
  protected final String TEXT_198 = "+ \"'.\");" + NL + "\t\t";
  protected final String TEXT_199 = NL + "\t    ftp_";
  protected final String TEXT_200 = ".connect();" + NL + "\t    " + NL + "\t    ";
  protected final String TEXT_201 = " " + NL + "\t" + NL + "\t\t";
  protected final String TEXT_202 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_203 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_204 = ");";
  protected final String TEXT_205 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_206 = " = ";
  protected final String TEXT_207 = "; ";
  protected final String TEXT_208 = NL + "\t\t\t" + NL + "\t    ftp_";
  protected final String TEXT_209 = ".login(";
  protected final String TEXT_210 = ", decryptedPassword_";
  protected final String TEXT_211 = ");" + NL + "\t\t";
  protected final String TEXT_212 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_213 = " - Connect to '\" + ";
  protected final String TEXT_214 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_215 = "   " + NL + "  \t";
  protected final String TEXT_216 = " " + NL + "\tjava.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_217 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "" + NL + "\t";
  protected final String TEXT_218 = "    " + NL + "\t\tjava.util.Map<String,String> map";
  protected final String TEXT_219 = " = new java.util.HashMap<String,String>();" + NL + "\t\tmap";
  protected final String TEXT_220 = ".put(";
  protected final String TEXT_221 = ",\"\");" + NL + "\t\tlist";
  protected final String TEXT_222 = ".add(map";
  protected final String TEXT_223 = ");       " + NL + "\t";
  protected final String TEXT_224 = NL + "\tString remotedir";
  protected final String TEXT_225 = " = ";
  protected final String TEXT_226 = ";" + NL + "\tftp_";
  protected final String TEXT_227 = ".chdir(remotedir";
  protected final String TEXT_228 = ");" + NL + "\tString root";
  protected final String TEXT_229 = " = ftp_";
  protected final String TEXT_230 = ".pwd();" + NL + "" + NL + "\t";
  protected final String TEXT_231 = NL + "\t\tlog.info(\"";
  protected final String TEXT_232 = " - Truncating file from the server.\");" + NL + "\t";
  protected final String TEXT_233 = NL + "\tfor (java.util.Map<String, String> map";
  protected final String TEXT_234 = " : list";
  protected final String TEXT_235 = ") {";
  protected final String TEXT_236 = NL;

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
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");

boolean use_encoding = "true".equals(ElementParameterParser.getValue(node, "__USE_ENCODING__"));

String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String authMethod = ElementParameterParser.getValue(node,"__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node,"__PRIVATEKEY__");

List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");  
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");

String connectMode = ElementParameterParser.getValue(node,"__CONNECT_MODE__");
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

//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.
if (useProxy) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_37);
    
passwordFieldName = "__PROXY_PASSWORD__";
if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_40);
    } else {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
      
if (sftp) {// *** sftp *** //

	if (("false").equals(useExistingConn)) {
	
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
            passwordFieldName = "__PASSPHRASE__";
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
			passwordFieldName = "__PASSWORD__";
			
    stringBuffer.append(TEXT_61);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_64);
    } else {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_75);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(privateKey);
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_91);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(TEXT_94);
    
			passwordFieldName = "__PASSWORD__";
			
    stringBuffer.append(TEXT_95);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_98);
    } else {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    if (!useProxy) {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_125);
    }
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    if(use_encoding) {
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    
	} else {
	
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_135);
    if(isLog4jEnabled){
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
    }
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
	}
	
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    for (int i = 0; i < files.size(); i++) {
    	Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_153);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_156);
    }
    stringBuffer.append(TEXT_157);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    }
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    
} else {// *** ftp *** //

    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    if (("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_167);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    }
    stringBuffer.append(TEXT_173);
    if(!moveToCurrentDir){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    }
    stringBuffer.append(TEXT_177);
    } else {
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_183);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
     if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    } else {
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    }
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_194);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_198);
    }
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    
		passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_201);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_204);
    } else {
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_207);
    }
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_214);
    }
    stringBuffer.append(TEXT_215);
    }
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    for (int i = 0; i < files.size(); i++) {
    	Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_220);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    }
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    }
    stringBuffer.append(TEXT_236);
    return stringBuffer.toString();
  }
}
