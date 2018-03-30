package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TFTPConnectionBeginJava
{
  protected static String nl;
  public static synchronized TFTPConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPConnectionBeginJava result = new TFTPConnectionBeginJava();
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
  protected final String TEXT_30 = "  " + NL + "  java.util.Properties props_";
  protected final String TEXT_31 = " = System.getProperties();" + NL + "  props_";
  protected final String TEXT_32 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_33 = ");" + NL + "  props_";
  protected final String TEXT_34 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_35 = ");" + NL + "  props_";
  protected final String TEXT_36 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_37 = ");" + NL + "  ";
  protected final String TEXT_38 = " " + NL + "  String decryptedProxyPassword_";
  protected final String TEXT_39 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "  String decryptedProxyPassword_";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = "; ";
  protected final String TEXT_44 = NL + NL + "  props_";
  protected final String TEXT_45 = ".put(\"java.net.socks.password\", decryptedProxyPassword_";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_48 = " - \" + ";
  protected final String TEXT_49 = ");" + NL + "\t";
  protected final String TEXT_50 = NL + "\tcom.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_51 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "\tftp_";
  protected final String TEXT_52 = ".setRemoteHost(";
  protected final String TEXT_53 = ");" + NL + "\tftp_";
  protected final String TEXT_54 = ".setRemotePort(";
  protected final String TEXT_55 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_56 = NL + "    \tftp_";
  protected final String TEXT_57 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);" + NL + "\t";
  protected final String TEXT_58 = NL + "    \tftp_";
  protected final String TEXT_59 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);" + NL + "\t";
  protected final String TEXT_60 = NL + "\tftp_";
  protected final String TEXT_61 = ".setControlEncoding(";
  protected final String TEXT_62 = ");" + NL + "\t";
  protected final String TEXT_63 = NL + "\t\tlog.info(\"";
  protected final String TEXT_64 = " - Attempt to connect to '\" + ";
  protected final String TEXT_65 = " + \"' with username '\" +";
  protected final String TEXT_66 = "+ \"'.\");" + NL + "\t";
  protected final String TEXT_67 = NL + "\tftp_";
  protected final String TEXT_68 = ".connect();  " + NL + "\t" + NL + "\t";
  protected final String TEXT_69 = " " + NL + "\t\t        " + NL + "\t";
  protected final String TEXT_70 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_71 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_74 = " = ";
  protected final String TEXT_75 = "; ";
  protected final String TEXT_76 = NL + "   \t" + NL + "\tftp_";
  protected final String TEXT_77 = ".login(";
  protected final String TEXT_78 = ", decryptedPassword_";
  protected final String TEXT_79 = ");  " + NL + "  \t";
  protected final String TEXT_80 = NL + "\t\tlog.info(\"";
  protected final String TEXT_81 = " - Connect to '\" + ";
  protected final String TEXT_82 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_83 = NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_84 = "\",ftp_";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = NL + "\tclass MyUserInfo implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "\t";
  protected final String TEXT_87 = " " + NL + "      \t\tString decryptedPassphrase_";
  protected final String TEXT_88 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "      \t\tString decryptedPassphrase_";
  protected final String TEXT_91 = " = ";
  protected final String TEXT_92 = "; ";
  protected final String TEXT_93 = NL + NL + "\t\tString passphrase_";
  protected final String TEXT_94 = " = decryptedPassphrase_";
  protected final String TEXT_95 = ";" + NL + "" + NL + "\t\tpublic String getPassphrase() { return passphrase_";
  protected final String TEXT_96 = "; }" + NL + "" + NL + "\t\tpublic String getPassword() { return null; } " + NL + "" + NL + "\t\tpublic boolean promptPassword(String arg0) { return true; } " + NL + "" + NL + "\t\tpublic boolean promptPassphrase(String arg0) { return true; } " + NL + "" + NL + "\t\tpublic boolean promptYesNo(String arg0) { return true; } " + NL + "" + NL + "\t\tpublic void showMessage(String arg0) { } " + NL + "" + NL + "\t\tpublic String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "\t\tboolean[] echo) {" + NL + "\t\t" + NL + "    \t";
  protected final String TEXT_97 = " " + NL + "    \t" + NL + "    \t";
  protected final String TEXT_98 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_99 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_100 = ");";
  protected final String TEXT_101 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_102 = " = ";
  protected final String TEXT_103 = "; ";
  protected final String TEXT_104 = NL + "    \t" + NL + "\t\t\tString[] password_";
  protected final String TEXT_105 = " = {decryptedPassword_";
  protected final String TEXT_106 = "};" + NL + "\t\t\treturn password_";
  protected final String TEXT_107 = ";" + NL + "\t\t}" + NL + "\t};" + NL + "\tfinal com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_108 = " = new MyUserInfo();" + NL + "\tcom.jcraft.jsch.JSch jsch_";
  protected final String TEXT_109 = " = new com.jcraft.jsch.JSch(); " + NL + "" + NL + "\t";
  protected final String TEXT_110 = NL + "\t\t";
  protected final String TEXT_111 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_112 = " - SFTP authentication using a public key.\");" + NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_113 = " - Private key: '\" + ";
  protected final String TEXT_114 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_115 = NL + "\t\tjsch_";
  protected final String TEXT_116 = ".addIdentity(";
  protected final String TEXT_117 = ", defaultUserInfo_";
  protected final String TEXT_118 = ".getPassphrase());" + NL + "\t";
  protected final String TEXT_119 = NL + "\t" + NL + "\tcom.jcraft.jsch.Session session_";
  protected final String TEXT_120 = " = jsch_";
  protected final String TEXT_121 = ".getSession(";
  protected final String TEXT_122 = ", ";
  protected final String TEXT_123 = ", ";
  protected final String TEXT_124 = ");" + NL + "\tsession_";
  protected final String TEXT_125 = ".setConfig(\"PreferredAuthentications\", \"publickey,password,keyboard-interactive,gssapi-with-mic\");" + NL + "\t" + NL + "\t";
  protected final String TEXT_126 = " " + NL + "\t\t";
  protected final String TEXT_127 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_128 = " - SFTP authentication using a password.\");" + NL + "\t\t";
  protected final String TEXT_129 = NL + "\t        " + NL + "\t\t";
  protected final String TEXT_130 = NL + "    \t\t" + NL + "\t\t";
  protected final String TEXT_131 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_132 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_133 = ");";
  protected final String TEXT_134 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_135 = " = ";
  protected final String TEXT_136 = "; ";
  protected final String TEXT_137 = NL + "\t   \t" + NL + "\t\tsession_";
  protected final String TEXT_138 = ".setPassword(decryptedPassword_";
  protected final String TEXT_139 = "); " + NL + "\t";
  protected final String TEXT_140 = NL + NL + "\tsession_";
  protected final String TEXT_141 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_142 = "); " + NL + "\t";
  protected final String TEXT_143 = NL + "\t\tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "\t\t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_144 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "\t\t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "\t\t\t\tproxy_";
  protected final String TEXT_145 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "\t\t\t}" + NL + "\t\t\tsession_";
  protected final String TEXT_146 = ".setProxy(proxy_";
  protected final String TEXT_147 = ");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_148 = NL + "  \t";
  protected final String TEXT_149 = NL + "\t\tlog.info(\"";
  protected final String TEXT_150 = " - Attempt to connect to  '\" + ";
  protected final String TEXT_151 = " + \"' with username '\" + ";
  protected final String TEXT_152 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_153 = NL + "\tsession_";
  protected final String TEXT_154 = ".connect();" + NL + "\tcom.jcraft.jsch. Channel channel_";
  protected final String TEXT_155 = " = session_";
  protected final String TEXT_156 = ".openChannel(\"sftp\"); " + NL + "\tchannel_";
  protected final String TEXT_157 = ".connect();" + NL + "  \t";
  protected final String TEXT_158 = NL + "\t\tlog.info(\"";
  protected final String TEXT_159 = " - Connect to '\" + ";
  protected final String TEXT_160 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_161 = NL + "\tcom.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_162 = " = (com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_163 = ";" + NL + "\t" + NL + "\t";
  protected final String TEXT_164 = NL + "\t\tc_";
  protected final String TEXT_165 = ".setFilenameEncoding(";
  protected final String TEXT_166 = ");" + NL + "\t";
  protected final String TEXT_167 = NL + "\t" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_168 = "\", c_";
  protected final String TEXT_169 = ");";
  protected final String TEXT_170 = NL + "\tclass MyTrust_";
  protected final String TEXT_171 = "{" + NL + "" + NL + "\t\tprivate javax.net.ssl.TrustManager[] getTrustManagers() " + NL + "\t\tthrows java.security.KeyStoreException, java.security.NoSuchAlgorithmException, " + NL + "\t\t\tjava.security.cert.CertificateException, java.security.UnrecoverableKeyException," + NL + "\t\t\tjava.io.FileNotFoundException, java.io.IOException{" + NL + "      \t\tjava.security.KeyStore ks = java.security.KeyStore.getInstance(\"JKS\");" + NL + "      \t\t\t        ";
  protected final String TEXT_172 = " " + NL + "              String decryptedKeyStorePassword_";
  protected final String TEXT_173 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_174 = ");";
  protected final String TEXT_175 = NL + "              String decryptedKeyStorePassword_";
  protected final String TEXT_176 = " = ";
  protected final String TEXT_177 = "; ";
  protected final String TEXT_178 = NL + "\t        " + NL + "     \t\tks.load(new java.io.FileInputStream(";
  protected final String TEXT_179 = "), decryptedKeyStorePassword_";
  protected final String TEXT_180 = ".toCharArray());" + NL + "      \t\tjavax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());" + NL + "      \t\ttmf.init(ks);" + NL + "      \t\treturn tmf.getTrustManagers();" + NL + "    \t}" + NL + "\t}" + NL + "\tjavax.net.ssl.SSLContext sslContext = null;" + NL + "\tjavax.net.ssl.TrustManager[] trustManager = null;" + NL + "\tjavax.net.ssl.SSLSocketFactory sslSocketFactory = null;" + NL + "\tit.sauronsoftware.ftp4j.FTPClient ftp_";
  protected final String TEXT_181 = " =null;" + NL + "\tMyTrust_";
  protected final String TEXT_182 = " myTrust_";
  protected final String TEXT_183 = " = null;" + NL + "" + NL + "\ttry {" + NL + "\t\tsslContext = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "\t\tmyTrust_";
  protected final String TEXT_184 = " = new MyTrust_";
  protected final String TEXT_185 = "();" + NL + "\t\ttrustManager = myTrust_";
  protected final String TEXT_186 = ".getTrustManagers();" + NL + "\t\tsslContext.init(null, trustManager, new java.security.SecureRandom());" + NL + "\t\tsslSocketFactory = sslContext.getSocketFactory();" + NL + "\t\tftp_";
  protected final String TEXT_187 = " = new it.sauronsoftware.ftp4j.FTPClient();" + NL + "\t\tftp_";
  protected final String TEXT_188 = ".setSSLSocketFactory(sslSocketFactory);" + NL + "\t\tftp_";
  protected final String TEXT_189 = ".setCharset(";
  protected final String TEXT_190 = ");";
  protected final String TEXT_191 = NL + "\t\t\tftp_";
  protected final String TEXT_192 = ".setSecurity(it.sauronsoftware.ftp4j.FTPClient.SECURITY_FTPS);";
  protected final String TEXT_193 = NL + "\t\t\tftp_";
  protected final String TEXT_194 = ".setSecurity(it.sauronsoftware.ftp4j.FTPClient.SECURITY_FTPES);";
  protected final String TEXT_195 = NL + "\t\t";
  protected final String TEXT_196 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_197 = " -FTPS security Mode is ";
  protected final String TEXT_198 = ".\");" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_199 = " - Attempt to connect to '\" + ";
  protected final String TEXT_200 = " + \"' with username '\" + ";
  protected final String TEXT_201 = "+ \"'.\");" + NL + "\t\t";
  protected final String TEXT_202 = NL + "    \tftp_";
  protected final String TEXT_203 = ".connect(";
  protected final String TEXT_204 = ",";
  protected final String TEXT_205 = ");" + NL + "  \t\t";
  protected final String TEXT_206 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_207 = " - Connect to '\" + ";
  protected final String TEXT_208 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_209 = NL + "\t        " + NL + "\t\t";
  protected final String TEXT_210 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_211 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_212 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_213 = ");";
  protected final String TEXT_214 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_215 = " = ";
  protected final String TEXT_216 = "; ";
  protected final String TEXT_217 = NL + "\t   \t" + NL + "    \tftp_";
  protected final String TEXT_218 = ".login(";
  protected final String TEXT_219 = ", decryptedPassword_";
  protected final String TEXT_220 = ");" + NL + "  \t} catch (java.lang.IllegalStateException e) {" + NL + "\t\t";
  protected final String TEXT_221 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_222 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_223 = NL + "    \te.printStackTrace();" + NL + "\t} catch (java.io.IOException e) {" + NL + "\t\t";
  protected final String TEXT_224 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_225 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_226 = NL + "\t\te.printStackTrace();" + NL + "\t} catch (it.sauronsoftware.ftp4j.FTPIllegalReplyException e) {" + NL + "\t\t";
  protected final String TEXT_227 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_228 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_229 = NL + "\t\te.printStackTrace();" + NL + "\t} catch (it.sauronsoftware.ftp4j.FTPException e) {" + NL + "\t\t";
  protected final String TEXT_230 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_231 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_232 = NL + "\t\te.printStackTrace();" + NL + "\t}" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_233 = "\", ftp_";
  protected final String TEXT_234 = ");";
  protected final String TEXT_235 = NL;

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
String user = ElementParameterParser.getValue(node, "__USER__");
boolean use_encoding = "true".equals(ElementParameterParser.getValue(node, "__USE_ENCODING__"));

String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");
boolean sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");
boolean ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__"));
String keystoreFile = ElementParameterParser.getValue(node, "__KEYSTORE_FILE__");
String sEncoding = ElementParameterParser.getValue(node, "__ENCODING__");
String securityMode = ElementParameterParser.getValue(node, "__SECURITY_MODE__");

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String passwordFieldName = "";

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

if (!sftp && !ftps) { // *** ftp *** //
  	if(isLog4jEnabled){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_55);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    } else {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(sEncoding);
    stringBuffer.append(TEXT_62);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
	passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_69);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_72);
    } else {
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_75);
    }
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    
} else if (!ftps) { // *** sftp *** //

    stringBuffer.append(TEXT_86);
    
        passwordFieldName = "__PASSPHRASE__";
        if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
        
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_89);
    } else {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    
    	passwordFieldName = "__PASS__";
    	
    stringBuffer.append(TEXT_97);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_100);
    } else {
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
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
    if (("PUBLICKEY").equals(authMethod)){
    stringBuffer.append(TEXT_110);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(privateKey);
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_126);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    }
    stringBuffer.append(TEXT_129);
    
		passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_130);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_133);
    } else {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    if (!useProxy) {
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
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_152);
    }
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_160);
    }
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    if(use_encoding) {
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(sEncoding);
    stringBuffer.append(TEXT_166);
    }
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
} else {  // *** ftps *** //

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    
            passwordFieldName = "__KEYSTORE_PASS__";
            if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
            
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_174);
    } else {
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    stringBuffer.append(keystoreFile);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(sEncoding);
    stringBuffer.append(TEXT_190);
    
		if("IMPLICIT".equals(securityMode)){

    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    
		}else if("EXPLICIT".equals(securityMode)){

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    
		}

    stringBuffer.append(TEXT_195);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(securityMode);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_201);
    }
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_205);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_208);
    }
    stringBuffer.append(TEXT_209);
    
		passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_210);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_213);
    } else {
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_216);
    }
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    }
    stringBuffer.append(TEXT_223);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    }
    stringBuffer.append(TEXT_226);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    }
    stringBuffer.append(TEXT_229);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    }
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    
}

    stringBuffer.append(TEXT_235);
    return stringBuffer.toString();
  }
}
