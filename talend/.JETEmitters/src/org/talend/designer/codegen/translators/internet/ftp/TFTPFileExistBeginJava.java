package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TFTPFileExistBeginJava
{
  protected static String nl;
  public static synchronized TFTPFileExistBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPFileExistBeginJava result = new TFTPFileExistBeginJava();
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
  protected final String TEXT_30 = NL + "  java.util.Properties props_";
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
  protected final String TEXT_46 = ");        ";
  protected final String TEXT_47 = NL + "\t\tclass MyUserInfo_";
  protected final String TEXT_48 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "\t\t";
  protected final String TEXT_49 = " " + NL + "          \t\tString decryptedPassphrase_";
  protected final String TEXT_50 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "          \t\tString decryptedPassphrase_";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = "; ";
  protected final String TEXT_55 = NL + "            " + NL + "\t\t\tString passphrase_";
  protected final String TEXT_56 = " = decryptedPassphrase_";
  protected final String TEXT_57 = ";" + NL + "" + NL + "\t\t\tpublic String getPassphrase() { return passphrase_";
  protected final String TEXT_58 = "; }" + NL + "" + NL + "\t\t\tpublic String getPassword() { return null; } " + NL + "" + NL + "\t\t\tpublic boolean promptPassword(String arg0) { return true; } " + NL + "" + NL + "\t\t\tpublic boolean promptPassphrase(String arg0) { return true; } " + NL + "" + NL + "\t\t\tpublic boolean promptYesNo(String arg0) { return true; } " + NL + "" + NL + "\t\t\tpublic void showMessage(String arg0) { } " + NL + "" + NL + "\t\t\tpublic String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "\t\t\tboolean[] echo) {" + NL + "\t\t\t";
  protected final String TEXT_59 = " " + NL + "    \t" + NL + "\t\t\t";
  protected final String TEXT_60 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_61 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_64 = " = ";
  protected final String TEXT_65 = "; ";
  protected final String TEXT_66 = NL + "\t\t\t" + NL + "\t\t\t\tString[] password_";
  protected final String TEXT_67 = " = {decryptedPassword_";
  protected final String TEXT_68 = "};" + NL + "\t\t\t\treturn password_";
  protected final String TEXT_69 = ";" + NL + "\t\t\t}" + NL + "\t\t}; " + NL + "    \tfinal com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_70 = " = new MyUserInfo_";
  protected final String TEXT_71 = "();" + NL + "    \tcom.jcraft.jsch.JSch jsch_";
  protected final String TEXT_72 = "=new com.jcraft.jsch.JSch(); " + NL + "" + NL + "    \t";
  protected final String TEXT_73 = NL + "\t  \t\t";
  protected final String TEXT_74 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_75 = " - SFTP authentication using a public key.\");" + NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_76 = " - Private key: '\" + ";
  protected final String TEXT_77 = " + \"'.\");" + NL + "\t  \t\t";
  protected final String TEXT_78 = NL + "      \t\tjsch_";
  protected final String TEXT_79 = ".addIdentity(";
  protected final String TEXT_80 = ", defaultUserInfo_";
  protected final String TEXT_81 = ".getPassphrase());" + NL + "    \t";
  protected final String TEXT_82 = NL + "    \t" + NL + "    \tcom.jcraft.jsch.Session session_";
  protected final String TEXT_83 = "=jsch_";
  protected final String TEXT_84 = ".getSession(";
  protected final String TEXT_85 = ", ";
  protected final String TEXT_86 = ", ";
  protected final String TEXT_87 = ");" + NL + "    \tsession_";
  protected final String TEXT_88 = ".setConfig(\"PreferredAuthentications\", \"publickey,password,keyboard-interactive,gssapi-with-mic\");" + NL + "" + NL + "    \t";
  protected final String TEXT_89 = " " + NL + "\t  \t\t";
  protected final String TEXT_90 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_91 = " - SFTP authentication using a password.\");" + NL + "\t  \t\t";
  protected final String TEXT_92 = NL + "\t  \t\t" + NL + "\t\t\t";
  protected final String TEXT_93 = " " + NL + "    \t" + NL + "\t\t\t";
  protected final String TEXT_94 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_95 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_96 = ");";
  protected final String TEXT_97 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_98 = " = ";
  protected final String TEXT_99 = "; ";
  protected final String TEXT_100 = NL + "\t  \t\t" + NL + "      \t\tsession_";
  protected final String TEXT_101 = ".setPassword(decryptedPassword_";
  protected final String TEXT_102 = "); " + NL + "    \t";
  protected final String TEXT_103 = NL + "    \tsession_";
  protected final String TEXT_104 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_105 = "); " + NL + "\t\t";
  protected final String TEXT_106 = NL + "\t  \t\tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "\t\t  \t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_107 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "  \t\t\t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "  \t\t\t\t\tproxy_";
  protected final String TEXT_108 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t\t\t}" + NL + "  \t\t\t\tsession_";
  protected final String TEXT_109 = ".setProxy(proxy_";
  protected final String TEXT_110 = ");" + NL + "  \t\t\t}" + NL + "\t\t";
  protected final String TEXT_111 = NL + "\t\t";
  protected final String TEXT_112 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_113 = " - Attempt to connect to '\" + ";
  protected final String TEXT_114 = " + \"' with username '\" + ";
  protected final String TEXT_115 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_116 = NL + "    \tsession_";
  protected final String TEXT_117 = ".connect();" + NL + "\t\tcom.jcraft.jsch. Channel channel_";
  protected final String TEXT_118 = "=session_";
  protected final String TEXT_119 = ".openChannel(\"sftp\");" + NL + "    \tchannel_";
  protected final String TEXT_120 = ".connect();" + NL + "\t\t";
  protected final String TEXT_121 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_122 = " - Connect to '\" + ";
  protected final String TEXT_123 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_124 = NL + "    \tcom.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_125 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_126 = ";" + NL + "    \t" + NL + "    \t";
  protected final String TEXT_127 = NL + "    \t\tc_";
  protected final String TEXT_128 = ".setFilenameEncoding(";
  protected final String TEXT_129 = ");" + NL + "    \t";
  protected final String TEXT_130 = "    " + NL + "\t    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_131 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_132 = "\");" + NL + "\t\t";
  protected final String TEXT_133 = NL + "\t\t\tif(c_";
  protected final String TEXT_134 = "!=null && c_";
  protected final String TEXT_135 = ".getSession()!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_136 = " - Use an existing connection.  Connection username: \" + c_";
  protected final String TEXT_137 = ".getSession().getUserName() + \", Connection hostname: \" + c_";
  protected final String TEXT_138 = ".getSession().getHost() + \", Connection port: \" + c_";
  protected final String TEXT_139 = ".getSession().getPort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_140 = NL + "\t    if(c_";
  protected final String TEXT_141 = ".getHome()!=null && !c_";
  protected final String TEXT_142 = ".getHome().equals(c_";
  protected final String TEXT_143 = ".pwd())){" + NL + "\t  \t\tc_";
  protected final String TEXT_144 = ".cd(c_";
  protected final String TEXT_145 = ".getHome());" + NL + "\t  \t}";
  protected final String TEXT_146 = NL + "\tcom.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_147 = " = null;" + NL + "" + NL + "\t";
  protected final String TEXT_148 = NL + "\t\tftp_";
  protected final String TEXT_149 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_150 = "\");" + NL + "\t\t";
  protected final String TEXT_151 = NL + "\t\t\tif(ftp_";
  protected final String TEXT_152 = "!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_153 = " - Use an existing connection. Connection hostname: \" + ftp_";
  protected final String TEXT_154 = ".getRemoteHost() + \", Connection port: \" + ftp_";
  protected final String TEXT_155 = ".getRemotePort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_156 = NL + "  \t";
  protected final String TEXT_157 = "    " + NL + "\t   \tftp_";
  protected final String TEXT_158 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "\t   \tftp_";
  protected final String TEXT_159 = ".setRemoteHost(";
  protected final String TEXT_160 = ");" + NL + "\t   \tftp_";
  protected final String TEXT_161 = ".setRemotePort(";
  protected final String TEXT_162 = ");" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_163 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_164 = " - \" + ";
  protected final String TEXT_165 = ");" + NL + "\t\t";
  protected final String TEXT_166 = NL + NL + "\t    ";
  protected final String TEXT_167 = NL + "\t      ftp_";
  protected final String TEXT_168 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);" + NL + "\t    ";
  protected final String TEXT_169 = NL + "\t      ftp_";
  protected final String TEXT_170 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);" + NL + "\t    ";
  protected final String TEXT_171 = NL + "\t    ftp_";
  protected final String TEXT_172 = ".setControlEncoding(";
  protected final String TEXT_173 = ");" + NL + "\t\t";
  protected final String TEXT_174 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_175 = " - Attempt to connect to '\" + ";
  protected final String TEXT_176 = " + \"' with username: '\" +";
  protected final String TEXT_177 = "+ \"'.\");" + NL + "\t\t";
  protected final String TEXT_178 = NL + "\t    ftp_";
  protected final String TEXT_179 = ".connect();  " + NL + "\t    " + NL + "\t\t";
  protected final String TEXT_180 = " " + NL + "\t" + NL + "\t\t";
  protected final String TEXT_181 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_182 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_183 = ");";
  protected final String TEXT_184 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_185 = " = ";
  protected final String TEXT_186 = "; ";
  protected final String TEXT_187 = NL + NL + "\t    ftp_";
  protected final String TEXT_188 = ".login(";
  protected final String TEXT_189 = ", decryptedPassword_";
  protected final String TEXT_190 = ");" + NL + "\t\t";
  protected final String TEXT_191 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_192 = " - Connect to '\" + ";
  protected final String TEXT_193 = "  + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_194 = NL + "\t  ";
  protected final String TEXT_195 = NL;

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
String host=ElementParameterParser.getValue(node, "__HOST__");
String port=ElementParameterParser.getValue(node, "__PORT__");
String username=ElementParameterParser.getValue(node, "__USERNAME__");

boolean use_encoding = "true".equals(ElementParameterParser.getValue(node, "__USE_ENCODING__"));

String remoteDir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String filename = ElementParameterParser.getValue(node, "__FILENAME__");
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");

String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");
String pass = ElementParameterParser.getValue(node, "__PASSWORD__");
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");

String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String conn= "conn_" + connection;
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean sftp = false;

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
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

if (sftp) {
	if (("false").equals(useExistingConn)) {
  
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
            passwordFieldName = "__PASSPHRASE__";
            if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
            
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_51);
    } else {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
			passwordFieldName = "__PASSWORD__";
			
    stringBuffer.append(TEXT_59);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_62);
    } else {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_65);
    }
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_73);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_89);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    
			passwordFieldName = "__PASSWORD__";
			
    stringBuffer.append(TEXT_93);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_96);
    } else {
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_99);
    }
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    if (!useProxy) {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_115);
    }
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_123);
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    if(use_encoding) {
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_129);
    }
    
  	} else {
  
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_132);
    if(isLog4jEnabled){
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
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    
	}
} else {
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
     if (("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_150);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    }
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_162);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    } else {
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    }
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_173);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    
		passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_180);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_183);
    } else {
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_193);
    }
    stringBuffer.append(TEXT_194);
      
	}
}
    stringBuffer.append(TEXT_195);
    return stringBuffer.toString();
  }
}
