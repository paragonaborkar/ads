package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TSendMailMainJava
{
  protected static String nl;
  public static synchronized TSendMailMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSendMailMainJava result = new TSendMailMainJava();
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
  protected final String TEXT_30 = NL + NL + "\tString smtpHost_";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + "        String smtpPort_";
  protected final String TEXT_34 = " = \"";
  protected final String TEXT_35 = "\";";
  protected final String TEXT_36 = NL + "        String smtpPort_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ";";
  protected final String TEXT_39 = NL + "\tString from_";
  protected final String TEXT_40 = " = (";
  protected final String TEXT_41 = ");" + NL + "    String to_";
  protected final String TEXT_42 = " = (";
  protected final String TEXT_43 = ").replace(\";\",\",\");" + NL + "    String cc_";
  protected final String TEXT_44 = " = ((";
  protected final String TEXT_45 = ")==null || \"\".equals(";
  protected final String TEXT_46 = "))?null:(";
  protected final String TEXT_47 = ").replace(\";\",\",\");" + NL + "    String bcc_";
  protected final String TEXT_48 = " = ((";
  protected final String TEXT_49 = ")==null || \"\".equals(";
  protected final String TEXT_50 = "))?null:(";
  protected final String TEXT_51 = ").replace(\";\",\",\");" + NL + "    String subject_";
  protected final String TEXT_52 = " = (";
  protected final String TEXT_53 = ");" + NL + "    " + NL + "\tjava.util.List<java.util.Map<String, String>> headers_";
  protected final String TEXT_54 = " = new java.util.ArrayList<java.util.Map<String,String>>();";
  protected final String TEXT_55 = NL + "\t\tjava.util.Map<String,String> headerMap_";
  protected final String TEXT_56 = "_";
  protected final String TEXT_57 = " = new java.util.HashMap<String,String>();" + NL + "\t\theaderMap_";
  protected final String TEXT_58 = "_";
  protected final String TEXT_59 = ".put(\"KEY\", ";
  protected final String TEXT_60 = ");" + NL + "\t\theaderMap_";
  protected final String TEXT_61 = "_";
  protected final String TEXT_62 = ".put(\"VALUE\", ";
  protected final String TEXT_63 = ");" + NL + "\t\theaders_";
  protected final String TEXT_64 = ".add(headerMap_";
  protected final String TEXT_65 = "_";
  protected final String TEXT_66 = ");\t";
  protected final String TEXT_67 = NL + "\tjava.util.List<String> attachments_";
  protected final String TEXT_68 = " = new java.util.ArrayList<String>();" + NL + "\tjava.util.List<String> contentTransferEncoding_";
  protected final String TEXT_69 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_70 = NL + "\t\tattachments_";
  protected final String TEXT_71 = ".add(";
  protected final String TEXT_72 = ");" + NL + "\t\tcontentTransferEncoding_";
  protected final String TEXT_73 = ".add(\"";
  protected final String TEXT_74 = "\");\t";
  protected final String TEXT_75 = NL + NL + "\tString message_";
  protected final String TEXT_76 = " = ((";
  protected final String TEXT_77 = ") == null || \"\".equals(";
  protected final String TEXT_78 = ")) ? \"\\\"\\\"\" : (";
  protected final String TEXT_79 = ") ;" + NL + "\tjava.util.Properties props_";
  protected final String TEXT_80 = " = System.getProperties();     " + NL + "\tprops_";
  protected final String TEXT_81 = ".put(\"mail.smtp.host\", smtpHost_";
  protected final String TEXT_82 = ");" + NL + "\tprops_";
  protected final String TEXT_83 = ".put(\"mail.smtp.port\", smtpPort_";
  protected final String TEXT_84 = ");";
  protected final String TEXT_85 = NL + "\t\tprops_";
  protected final String TEXT_86 = ".put(\"mail.smtp.localhost\", ";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "\t\tprops_";
  protected final String TEXT_89 = ".put(\"mail.mime.encodefilename\", \"true\");";
  protected final String TEXT_90 = NL + "\t\tprops_";
  protected final String TEXT_91 = ".put(\"mail.smtp.starttls.enable\",\"true\");";
  protected final String TEXT_92 = "  " + NL + "\t\tjava.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());" + NL + "\t\tprops_";
  protected final String TEXT_93 = ".put(\"mail.smtp.socketFactory.class\", \"javax.net.ssl.SSLSocketFactory\");" + NL + "\t\tprops_";
  protected final String TEXT_94 = ".put(\"mail.smtp.socketFactory.fallback\", \"false\");" + NL + "\t\tprops_";
  protected final String TEXT_95 = ".put(\"mail.smtp.socketFactory.port\", smtpPort_";
  protected final String TEXT_96 = ");";
  protected final String TEXT_97 = "     " + NL + "\ttry {" + NL + "\t\t";
  protected final String TEXT_98 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_99 = " - Connection attempt to '\" + smtpHost_";
  protected final String TEXT_100 = " +\"'.\");" + NL + "\t\t";
  protected final String TEXT_101 = NL + "\t\t";
  protected final String TEXT_102 = "  " + NL + "\t\t\tprops_";
  protected final String TEXT_103 = ".put(\"mail.smtp.auth\", \"false\");" + NL + "\t\t\tjavax.mail.Session session_";
  protected final String TEXT_104 = " = javax.mail.Session.getInstance(props_";
  protected final String TEXT_105 = ", null);    " + NL + "\t\t";
  protected final String TEXT_106 = NL + "\t\t\tprops_";
  protected final String TEXT_107 = ".put(\"mail.smtp.auth\", \"true\");" + NL + "\t\t\tjavax.mail.Session session_";
  protected final String TEXT_108 = " = javax.mail.Session.getInstance(props_";
  protected final String TEXT_109 = ", new javax.mail.Authenticator(){         " + NL + "\t\t\t\tprotected javax.mail.PasswordAuthentication getPasswordAuthentication() {" + NL + "\t\t\t\t";
  protected final String TEXT_110 = NL + "                ";
  protected final String TEXT_111 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_112 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_115 = " = ";
  protected final String TEXT_116 = "; ";
  protected final String TEXT_117 = NL + "\t\t\t\t" + NL + "\t\t\t\t" + NL + "\t\t\t\treturn new javax.mail.PasswordAuthentication(";
  protected final String TEXT_118 = ", decryptedPassword_";
  protected final String TEXT_119 = "); " + NL + "\t\t\t\t}         " + NL + "\t\t\t});   " + NL + "\t\t";
  protected final String TEXT_120 = NL + "\t\t";
  protected final String TEXT_121 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_122 = " - Connection to '\" + smtpHost_";
  protected final String TEXT_123 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_124 = NL + "\t\tjavax.mail.Message msg_";
  protected final String TEXT_125 = " = new javax.mail.internet.MimeMessage(session_";
  protected final String TEXT_126 = ");" + NL + "\t\tmsg_";
  protected final String TEXT_127 = ".setFrom(new javax.mail.internet.InternetAddress(from_";
  protected final String TEXT_128 = ", ";
  protected final String TEXT_129 = "));" + NL + "\t\tmsg_";
  protected final String TEXT_130 = ".setRecipients(javax.mail.Message.RecipientType.TO,javax.mail.internet.InternetAddress.parse(to_";
  protected final String TEXT_131 = ", false));" + NL + "\t\tif (cc_";
  protected final String TEXT_132 = " != null) msg_";
  protected final String TEXT_133 = ".setRecipients(javax.mail.Message.RecipientType.CC, javax.mail.internet.InternetAddress.parse(cc_";
  protected final String TEXT_134 = ", false));" + NL + "\t\tif (bcc_";
  protected final String TEXT_135 = " != null) msg_";
  protected final String TEXT_136 = ".setRecipients(javax.mail.Message.RecipientType.BCC, javax.mail.internet.InternetAddress.parse(bcc_";
  protected final String TEXT_137 = ", false));" + NL + "\t\tmsg_";
  protected final String TEXT_138 = ".setSubject(subject_";
  protected final String TEXT_139 = ");" + NL + "" + NL + "\t\tfor (int i_";
  protected final String TEXT_140 = " = 0; i_";
  protected final String TEXT_141 = " < headers_";
  protected final String TEXT_142 = ".size(); i_";
  protected final String TEXT_143 = "++) {" + NL + "\t\t\tjava.util.Map<String, String> header_";
  protected final String TEXT_144 = " = headers_";
  protected final String TEXT_145 = ".get(i_";
  protected final String TEXT_146 = ");" + NL + "\t\t\tmsg_";
  protected final String TEXT_147 = ".setHeader(header_";
  protected final String TEXT_148 = ".get(\"KEY\"), header_";
  protected final String TEXT_149 = ".get(\"VALUE\"));    " + NL + "\t\t}  " + NL + "\t\tmsg_";
  protected final String TEXT_150 = ".setSentDate(new Date());" + NL + "\t\tmsg_";
  protected final String TEXT_151 = ".setHeader(\"X-Priority\", \"";
  protected final String TEXT_152 = "\"); //High->1 Normal->3 Low->5" + NL + "\t\tjavax.mail.Multipart mp_";
  protected final String TEXT_153 = " = new javax.mail.internet.MimeMultipart();" + NL + "\t\tjavax.mail.internet.MimeBodyPart mbpText_";
  protected final String TEXT_154 = " = new javax.mail.internet.MimeBodyPart();" + NL + "\t\tmbpText_";
  protected final String TEXT_155 = ".setText(message_";
  protected final String TEXT_156 = ",";
  protected final String TEXT_157 = ", \"";
  protected final String TEXT_158 = "\");" + NL + "\t\tmp_";
  protected final String TEXT_159 = ".addBodyPart(mbpText_";
  protected final String TEXT_160 = ");" + NL + "  " + NL + "\t\tjavax.mail.internet.MimeBodyPart mbpFile_";
  protected final String TEXT_161 = " = null;" + NL + "" + NL + "\t\tfor (int i_";
  protected final String TEXT_162 = " = 0; i_";
  protected final String TEXT_163 = " < attachments_";
  protected final String TEXT_164 = ".size(); i_";
  protected final String TEXT_165 = "++){" + NL + "\t\t\tString filename_";
  protected final String TEXT_166 = " = attachments_";
  protected final String TEXT_167 = ".get(i_";
  protected final String TEXT_168 = ");" + NL + "\t\t\tjavax.activation.FileDataSource fds_";
  protected final String TEXT_169 = " = null;" + NL + "\t\t\tjava.io.File file_";
  protected final String TEXT_170 = " = new java.io.File(filename_";
  protected final String TEXT_171 = ");" + NL + "\t\t\t";
  protected final String TEXT_172 = NL + "\t\t\t\tif (!file_";
  protected final String TEXT_173 = ".exists()){" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_174 = NL + "    \t\tif (file_";
  protected final String TEXT_175 = ".isDirectory()){" + NL + "\t\t\t\tjava.io.File[] subFiles_";
  protected final String TEXT_176 = " = file_";
  protected final String TEXT_177 = ".listFiles();" + NL + "\t\t\t\tfor(java.io.File subFile_";
  protected final String TEXT_178 = " : subFiles_";
  protected final String TEXT_179 = "){" + NL + "\t\t\t\t\tif (subFile_";
  protected final String TEXT_180 = ".isFile()){" + NL + "\t\t\t\t\t\tfds_";
  protected final String TEXT_181 = " = new javax.activation.FileDataSource(subFile_";
  protected final String TEXT_182 = ".getAbsolutePath());" + NL + "\t\t\t\t\t\tmbpFile_";
  protected final String TEXT_183 = " = new javax.mail.internet.MimeBodyPart();" + NL + "\t\t\t\t\t\tmbpFile_";
  protected final String TEXT_184 = ".setDataHandler(new javax.activation.DataHandler(fds_";
  protected final String TEXT_185 = "));" + NL + "\t\t\t\t\t\tmbpFile_";
  protected final String TEXT_186 = ".setFileName(javax.mail.internet.MimeUtility.encodeText(fds_";
  protected final String TEXT_187 = ".getName()));" + NL + "\t\t\t\t\t\tif(contentTransferEncoding_";
  protected final String TEXT_188 = ".get(i_";
  protected final String TEXT_189 = ").equalsIgnoreCase(\"base64\")){" + NL + "\t\t\t\t\t\t\tmbpFile_";
  protected final String TEXT_190 = ".setHeader(\"Content-Transfer-Encoding\", \"base64\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tmp_";
  protected final String TEXT_191 = ".addBodyPart(mbpFile_";
  protected final String TEXT_192 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "    \t\t}else{" + NL + "\t\t\t\tmbpFile_";
  protected final String TEXT_193 = " = new javax.mail.internet.MimeBodyPart();" + NL + "\t\t\t\tfds_";
  protected final String TEXT_194 = " = new javax.activation.FileDataSource(filename_";
  protected final String TEXT_195 = ");" + NL + "\t\t\t\tmbpFile_";
  protected final String TEXT_196 = ".setDataHandler(new javax.activation.DataHandler(fds_";
  protected final String TEXT_197 = ")); " + NL + "\t\t\t\tmbpFile_";
  protected final String TEXT_198 = ".setFileName(javax.mail.internet.MimeUtility.encodeText(fds_";
  protected final String TEXT_199 = ".getName()));" + NL + "\t\t\t\tif(contentTransferEncoding_";
  protected final String TEXT_200 = ".get(i_";
  protected final String TEXT_201 = ").equalsIgnoreCase(\"base64\")){" + NL + "\t\t\t\t\tmbpFile_";
  protected final String TEXT_202 = ".setHeader(\"Content-Transfer-Encoding\", \"base64\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tmp_";
  protected final String TEXT_203 = ".addBodyPart(mbpFile_";
  protected final String TEXT_204 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t// -- set the content --" + NL + "\t\tmsg_";
  protected final String TEXT_205 = ".setContent(mp_";
  protected final String TEXT_206 = ");" + NL + "\t\t// add handlers for main MIME types" + NL + "\t\tjavax.activation.MailcapCommandMap mc_";
  protected final String TEXT_207 = " = ( javax.activation.MailcapCommandMap)javax.activation.CommandMap.getDefaultCommandMap();" + NL + "\t\tmc_";
  protected final String TEXT_208 = ".addMailcap(\"text/html;; x-java-content-handler=com.sun.mail.handlers.text_html\");" + NL + "\t\tmc_";
  protected final String TEXT_209 = ".addMailcap(\"text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml\");" + NL + "\t\tmc_";
  protected final String TEXT_210 = ".addMailcap(\"text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain\");" + NL + "\t\tmc_";
  protected final String TEXT_211 = ".addMailcap(\"multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed\");" + NL + "\t\tmc_";
  protected final String TEXT_212 = ".addMailcap(\"message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822\");" + NL + "\t\tjavax.activation.CommandMap.setDefaultCommandMap(mc_";
  protected final String TEXT_213 = ");" + NL + "\t\t// -- Send the message --" + NL + "\t\tjavax.mail.Transport.send(msg_";
  protected final String TEXT_214 = ");" + NL + "\t} catch(java.lang.Exception e){" + NL + "  \t\t";
  protected final String TEXT_215 = NL + "\t\t\tthrow(e);" + NL + "\t\t";
  protected final String TEXT_216 = NL + "\t\t\t";
  protected final String TEXT_217 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_218 = " - \" + e.toString());" + NL + "\t\t\t";
  protected final String TEXT_219 = NL + "  \t\t\tSystem.err.println(e.toString());" + NL + "\t\t";
  protected final String TEXT_220 = NL + "\t}finally{" + NL + "\t\tprops_";
  protected final String TEXT_221 = ".remove(\"mail.smtp.host\");" + NL + "\t\tprops_";
  protected final String TEXT_222 = ".remove(\"mail.smtp.port\");" + NL + "\t\t";
  protected final String TEXT_223 = NL + "\t\t\tprops_";
  protected final String TEXT_224 = ".remove(\"mail.smtp.localhost\");" + NL + "\t\t";
  protected final String TEXT_225 = NL + "\t\tprops_";
  protected final String TEXT_226 = ".remove(\"mail.mime.encodefilename\");" + NL + "\t\t";
  protected final String TEXT_227 = NL + "\t\t\tprops_";
  protected final String TEXT_228 = ".remove(\"mail.smtp.starttls.enable\");" + NL + "\t\t";
  protected final String TEXT_229 = "  " + NL + "\t\t\tprops_";
  protected final String TEXT_230 = ".remove(\"mail.smtp.socketFactory.class\");" + NL + "\t\t\tprops_";
  protected final String TEXT_231 = ".remove(\"mail.smtp.socketFactory.fallback\");" + NL + "\t\t\tprops_";
  protected final String TEXT_232 = ".remove(\"mail.smtp.socketFactory.port\");" + NL + "\t\t";
  protected final String TEXT_233 = NL + "\t\tprops_";
  protected final String TEXT_234 = ".remove(\"mail.smtp.auth\");     " + NL + "\t}";
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
String needAuth = ElementParameterParser.getValue(node, "__NEED_AUTH__");
String authUsername = ElementParameterParser.getValue(node, "__AUTH_USERNAME__");
String authPassword = ElementParameterParser.getValue(node, "__AUTH_PASSWORD__");
String message = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(ElementParameterParser.getValue(node, "__MESSAGE__"));
String importance = ElementParameterParser.getValue(node, "__IMPORTANCE__");
String priority = "Normal".equals(importance) ? "3" : (("High").equals(importance) ? "1" : "5");
boolean ifSSL = "true".equals(ElementParameterParser.getValue(node, "__SSL__"));
boolean startTLS = "true".equals(ElementParameterParser.getValue(node, "__STARTTLS__"));
boolean checkAttachementOnSend = "true".equals(ElementParameterParser.getValue(node, "__CHECK_ATTACHMENT__"));
boolean needPersonalName = "true".equals(ElementParameterParser.getValue(node, "__NEED_PERSONAL_NAME__"));
String personalName = needPersonalName ? ElementParameterParser.getValue(node, "__PERSONAL_NAME__") : null;
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String mimesubtype = ElementParameterParser.getValue(node, "__TEXT_SUBTYPE__");  
boolean setLocalhost = "true".equals(ElementParameterParser.getValue(node, "__SET_LOCALHOST__"));  
String localhost = ElementParameterParser.getValue(node, "__LOCALHOST__");  
boolean isDieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	//Bug12952, move all begin part to here below
	String smtpHost    = ElementParameterParser.getValue(node, "__SMTP_HOST__");
	String smtpPort    = ElementParameterParser.getValue(node, "__SMTP_PORT__");
	String to          = ElementParameterParser.getValue(node, "__TO__");
	String from        = ElementParameterParser.getValue(node, "__FROM__");
	String cc          = ElementParameterParser.getValue(node, "__CC__");
	String bcc          = ElementParameterParser.getValue(node, "__BCC__");
	String subject     = ElementParameterParser.getValue(node, "__SUBJECT__");
	
	List<Map<String, String>> tableValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ATTACHMENTS__");
	List<Map<String, String>> headers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HEADERS__");
	
	// component id
	to = to.replace(";",",");

	//in order to be compatible with TOS 2.4.1, @see:issue:6282
	if(cc == null || cc.trim().length()==0){
		cc = "\"\"";
	}
	if(bcc == null || bcc.trim().length()==0){
		bcc = "\"\"";
	}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(smtpHost );
    stringBuffer.append(TEXT_32);
    
    try {
        int port = Integer.parseInt(smtpPort);

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(smtpPort );
    stringBuffer.append(TEXT_35);
    
    } catch (java.lang.Exception e) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(smtpPort );
    stringBuffer.append(TEXT_38);
    
    }

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cc );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cc );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cc );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(bcc );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(bcc );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(bcc );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(subject );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    
	for (int i = 0; i < headers.size(); i++) {
   		Map<String, String> header = headers.get(i);

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(header.get("KEY"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(header.get("VALUE"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_66);
    
	}

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    
	for (int i = 0; i < tableValues.size(); i++) {
    	Map<String,String> attachment = tableValues.get(i);

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(attachment.get("FILE") );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(attachment.get("CONTENT_TRANSFER_ENCODING") );
    stringBuffer.append(TEXT_74);
    
	}
	//end of the former begin part

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(message );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(message );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(message );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
     
	if (setLocalhost){
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(localhost);
    stringBuffer.append(TEXT_87);
     }
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
     
	if (startTLS){
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    
	}
	if (ifSSL){

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    
	}

    stringBuffer.append(TEXT_97);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    }
    stringBuffer.append(TEXT_101);
    if ("false".equals(needAuth)) { 
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    } else{
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    
                String passwordFieldName = "__AUTH_PASSWORD__";
                
    stringBuffer.append(TEXT_110);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_113);
    } else {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    stringBuffer.append(authUsername );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(personalName);
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
    stringBuffer.append(priority );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(mimesubtype );
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
    if (!checkAttachementOnSend) {
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    }
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    if (isDieOnError){
    stringBuffer.append(TEXT_215);
    }else{
    stringBuffer.append(TEXT_216);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    }
    stringBuffer.append(TEXT_219);
    }
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
     
		if (setLocalhost){
		
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
     
		}
		
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
     
			if (startTLS){
		
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    
		}
		if (ifSSL){
		
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    
		}
		
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(TEXT_235);
    return stringBuffer.toString();
  }
}
