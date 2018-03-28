package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TPOPBeginJava
{
  protected static String nl;
  public static synchronized TPOPBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPOPBeginJava result = new TPOPBeginJava();
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
  protected final String TEXT_30 = "  " + NL + "\tString server_";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = ";" + NL + "\tString mbox_";
  protected final String TEXT_33 = " = \"INBOX\";" + NL + "\tString user_";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ";" + NL + "\t";
  protected final String TEXT_36 = NL + "    ";
  protected final String TEXT_37 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_38 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = "; ";
  protected final String TEXT_43 = NL + NL + "\tString password_";
  protected final String TEXT_44 = " = decryptedPassword_";
  protected final String TEXT_45 = ";" + NL + "\tint port_";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = ";" + NL + "\tint nb_email_";
  protected final String TEXT_48 = " = 0;" + NL + "\tjavax.mail.Folder folder_";
  protected final String TEXT_49 = ";" + NL + "\tjavax.mail.Session session_";
  protected final String TEXT_50 = ";" + NL + "\tjavax.mail.Store store_";
  protected final String TEXT_51 = ";" + NL + "\tjavax.mail.URLName url_";
  protected final String TEXT_52 = ";" + NL + "\tjava.util.Properties props_";
  protected final String TEXT_53 = ";" + NL + "" + NL + "\ttry {" + NL + "  \t\tprops_";
  protected final String TEXT_54 = " = System.getProperties();" + NL + "\t} catch (SecurityException sex) {" + NL + "\t\t";
  protected final String TEXT_55 = NL + "\t\t\tlog.warn(\"";
  protected final String TEXT_56 = " - \" + sex.getMessage());" + NL + "\t\t";
  protected final String TEXT_57 = NL + "  \t\tprops_";
  protected final String TEXT_58 = " = new java.util.Properties();" + NL + "\t}";
  protected final String TEXT_59 = NL + "\t\t    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());" + NL + "\t\t    props_";
  protected final String TEXT_60 = ".setProperty(\"mail.pop3.socketFactory.class\", \"javax.net.ssl.SSLSocketFactory\");      " + NL + "\t\t    props_";
  protected final String TEXT_61 = ".setProperty(\"mail.pop3.socketFactory.fallback\", \"false\");" + NL + "\t\t    props_";
  protected final String TEXT_62 = ".setProperty(\"mail.pop3.socketFactory.port\", port_";
  protected final String TEXT_63 = " + \"\");";
  protected final String TEXT_64 = NL + "\t\t    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());" + NL + "\t\t    props_";
  protected final String TEXT_65 = ".setProperty(\"mail.imap.socketFactory.class\", \"javax.net.ssl.SSLSocketFactory\");" + NL + "\t\t    props_";
  protected final String TEXT_66 = ".setProperty(\"mail.imap.socketFactory.fallback\", \"false\");" + NL + "\t\t    props_";
  protected final String TEXT_67 = ".setProperty(\"mail.imap.socketFactory.port\", port_";
  protected final String TEXT_68 = " + \"\");    ";
  protected final String TEXT_69 = NL + "  \t\tsession_";
  protected final String TEXT_70 = " = javax.mail.Session.getInstance(props_";
  protected final String TEXT_71 = ", null);" + NL + "  \t\tstore_";
  protected final String TEXT_72 = " = session_";
  protected final String TEXT_73 = ".getStore(\"";
  protected final String TEXT_74 = "\");" + NL + "\t\t";
  protected final String TEXT_75 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_76 = " - Connection attempt to '\" + server_";
  protected final String TEXT_77 = " + \"' as '\" + user_";
  protected final String TEXT_78 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_79 = NL + "  \t\tstore_";
  protected final String TEXT_80 = ".connect(server_";
  protected final String TEXT_81 = ", port_";
  protected final String TEXT_82 = ", user_";
  protected final String TEXT_83 = ", password_";
  protected final String TEXT_84 = ");" + NL + "\t\t";
  protected final String TEXT_85 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_86 = " - Connection to '\" + server_";
  protected final String TEXT_87 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_88 = NL + "  \t\tfolder_";
  protected final String TEXT_89 = " = store_";
  protected final String TEXT_90 = ".getDefaultFolder();" + NL + "" + NL + "  \t\tif (folder_";
  protected final String TEXT_91 = " == null) {" + NL + "    \t\tthrow new RuntimeException(\"No default folder\");" + NL + "  \t\t}" + NL + "\t\t// its INBOX" + NL + "\t\tfolder_";
  protected final String TEXT_92 = " = folder_";
  protected final String TEXT_93 = ".getFolder(mbox_";
  protected final String TEXT_94 = ");" + NL + "" + NL + "  \t\tif (folder_";
  protected final String TEXT_95 = " == null){" + NL + "\t\t    throw new RuntimeException(\"No POP3 INBOX\");" + NL + "\t\t}";
  protected final String TEXT_96 = NL + "\t\t\tmbox_";
  protected final String TEXT_97 = " = ";
  protected final String TEXT_98 = ";";
  protected final String TEXT_99 = NL + "\t\turl_";
  protected final String TEXT_100 = " = new javax.mail.URLName(\"";
  protected final String TEXT_101 = "\", server_";
  protected final String TEXT_102 = ", -1, mbox_";
  protected final String TEXT_103 = ", user_";
  protected final String TEXT_104 = ", password_";
  protected final String TEXT_105 = ");" + NL + "\t\tsession_";
  protected final String TEXT_106 = " = javax.mail.Session.getInstance(props_";
  protected final String TEXT_107 = ", null);" + NL + "\t\tstore_";
  protected final String TEXT_108 = " = new com.sun.mail.imap.IMAPStore(session_";
  protected final String TEXT_109 = ", url_";
  protected final String TEXT_110 = ");" + NL + "\t\t";
  protected final String TEXT_111 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_112 = " - Connection attempt to '\" + server_";
  protected final String TEXT_113 = " + \"' as '\" + user_";
  protected final String TEXT_114 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_115 = NL + "  \t\tstore_";
  protected final String TEXT_116 = ".connect();" + NL + "\t\t";
  protected final String TEXT_117 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_118 = " - Connection to '\" + server_";
  protected final String TEXT_119 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_120 = NL + "\t\tfolder_";
  protected final String TEXT_121 = " = store_";
  protected final String TEXT_122 = ".getFolder(mbox_";
  protected final String TEXT_123 = ");";
  protected final String TEXT_124 = " " + NL + "" + NL + "\ttry {" + NL + "\t\tfolder_";
  protected final String TEXT_125 = ".open(javax.mail.Folder.READ_WRITE);" + NL + "\t} catch (java.lang.Exception e){" + NL + "\t\t";
  protected final String TEXT_126 = NL + "\t\t\tlog.warn(\"";
  protected final String TEXT_127 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_128 = NL + "\t\tfolder_";
  protected final String TEXT_129 = ".open(javax.mail.Folder.READ_ONLY);" + NL + "\t}" + NL + "\t";
  protected final String TEXT_130 = NL + "\t\tint folderSize_";
  protected final String TEXT_131 = " = folder_";
  protected final String TEXT_132 = ".getMessageCount();" + NL + "\t\tjavax.mail.Message[] msgs_";
  protected final String TEXT_133 = " = folder_";
  protected final String TEXT_134 = ".getMessages(Math.max(0,folderSize_";
  protected final String TEXT_135 = "-";
  protected final String TEXT_136 = ")+1,folderSize_";
  protected final String TEXT_137 = ");" + NL + "\t";
  protected final String TEXT_138 = NL + "\t\tjavax.mail.Message[] msgs_";
  protected final String TEXT_139 = " = folder_";
  protected final String TEXT_140 = ".getMessages();" + NL + "\t";
  protected final String TEXT_141 = NL + "\t" + NL + "\t" + NL + "" + NL + "\t";
  protected final String TEXT_142 = NL + "\t\tlog.info(\"";
  protected final String TEXT_143 = " - Retrieving mails from server.\");" + NL + "\t";
  protected final String TEXT_144 = NL + "\tfor (int counter_";
  protected final String TEXT_145 = " = 0; counter_";
  protected final String TEXT_146 = " < msgs_";
  protected final String TEXT_147 = ".length; counter_";
  protected final String TEXT_148 = "++) {" + NL + "\t\t";
  protected final String TEXT_149 = NL + "\t\t\tif(nb_email_";
  protected final String TEXT_150 = " >= ";
  protected final String TEXT_151 = ") break; " + NL + "\t\t";
  protected final String TEXT_152 = NL + "\t\tjavax.mail.Message message_";
  protected final String TEXT_153 = " = msgs_";
  protected final String TEXT_154 = "[counter_";
  protected final String TEXT_155 = "];" + NL + "  " + NL + "\t\ttry {" + NL + "\t\t\tboolean isMatch_";
  protected final String TEXT_156 = " = ";
  protected final String TEXT_157 = ";" + NL + "  ";
  protected final String TEXT_158 = NL + "\t\t\t        java.util.regex.Pattern pattern_";
  protected final String TEXT_159 = "_";
  protected final String TEXT_160 = " = java.util.regex.Pattern.compile(";
  protected final String TEXT_161 = ");" + NL + "\t\t\t        java.util.regex.Matcher matcher_";
  protected final String TEXT_162 = "_";
  protected final String TEXT_163 = " = pattern_";
  protected final String TEXT_164 = "_";
  protected final String TEXT_165 = ".matcher(message_";
  protected final String TEXT_166 = ".getSubject()==null?\"\":message_";
  protected final String TEXT_167 = ".getSubject());" + NL + "\t\t\t        isMatch_";
  protected final String TEXT_168 = " = isMatch_";
  protected final String TEXT_169 = " ";
  protected final String TEXT_170 = " matcher_";
  protected final String TEXT_171 = "_";
  protected final String TEXT_172 = ".find();";
  protected final String TEXT_173 = NL + "\t\t\t        java.util.regex.Pattern pattern_";
  protected final String TEXT_174 = "_";
  protected final String TEXT_175 = " = java.util.regex.Pattern.compile(";
  protected final String TEXT_176 = ");" + NL + "\t\t\t        java.util.regex.Matcher matcher_";
  protected final String TEXT_177 = "_";
  protected final String TEXT_178 = " = pattern_";
  protected final String TEXT_179 = "_";
  protected final String TEXT_180 = ".matcher(message_";
  protected final String TEXT_181 = ".getFrom()[0]==null?\"\":message_";
  protected final String TEXT_182 = ".getFrom()[0].toString());" + NL + "\t\t\t        isMatch_";
  protected final String TEXT_183 = " = isMatch_";
  protected final String TEXT_184 = " ";
  protected final String TEXT_185 = " matcher_";
  protected final String TEXT_186 = "_";
  protected final String TEXT_187 = ".find();";
  protected final String TEXT_188 = NL + "\t\t\t        java.util.regex.Pattern pattern_";
  protected final String TEXT_189 = "_";
  protected final String TEXT_190 = " = java.util.regex.Pattern.compile(";
  protected final String TEXT_191 = ");" + NL + "\t\t\t        java.util.regex.Matcher matcher_";
  protected final String TEXT_192 = "_";
  protected final String TEXT_193 = " = null;" + NL + "\t\t\t\t\tjavax.mail.Address[] addr_";
  protected final String TEXT_194 = "_";
  protected final String TEXT_195 = " = message_";
  protected final String TEXT_196 = ".getAllRecipients();" + NL + "\t\t\t\t\tboolean matcherFind_";
  protected final String TEXT_197 = "_";
  protected final String TEXT_198 = " = false;" + NL + "\t\t\t\t\tfor(int matcher_";
  protected final String TEXT_199 = " = 0;matcher_";
  protected final String TEXT_200 = " < addr_";
  protected final String TEXT_201 = "_";
  protected final String TEXT_202 = ".length;matcher_";
  protected final String TEXT_203 = "++){" + NL + "\t\t\t\t\t\tmatcher_";
  protected final String TEXT_204 = "_";
  protected final String TEXT_205 = " = pattern_";
  protected final String TEXT_206 = "_";
  protected final String TEXT_207 = ".matcher(addr_";
  protected final String TEXT_208 = "_";
  protected final String TEXT_209 = "[matcher_";
  protected final String TEXT_210 = "]==null?\"\":addr_";
  protected final String TEXT_211 = "_";
  protected final String TEXT_212 = "[matcher_";
  protected final String TEXT_213 = "].toString());" + NL + "\t\t\t\t\t\tmatcherFind_";
  protected final String TEXT_214 = "_";
  protected final String TEXT_215 = " = matcher_";
  protected final String TEXT_216 = "_";
  protected final String TEXT_217 = ".find()||matcherFind_";
  protected final String TEXT_218 = "_";
  protected final String TEXT_219 = ";" + NL + "\t\t\t\t\t\tif(matcherFind_";
  protected final String TEXT_220 = "_";
  protected final String TEXT_221 = "){" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t        isMatch_";
  protected final String TEXT_222 = " = isMatch_";
  protected final String TEXT_223 = " ";
  protected final String TEXT_224 = " matcherFind_";
  protected final String TEXT_225 = "_";
  protected final String TEXT_226 = ";";
  protected final String TEXT_227 = NL + "    \t\t\t\tjava.util.Date date_";
  protected final String TEXT_228 = "_";
  protected final String TEXT_229 = " = null;" + NL + "  " + NL + "\t\t\t        try {" + NL + "\t\t\t          date_";
  protected final String TEXT_230 = "_";
  protected final String TEXT_231 = " = ParserUtils.parseTo_Date(";
  protected final String TEXT_232 = ", \"dd-MM-yyyy HH:mm:ss\");" + NL + "\t\t\t        } catch (java.lang.Exception e){" + NL + "\t\t\t          date_";
  protected final String TEXT_233 = "_";
  protected final String TEXT_234 = " = ParserUtils.parseTo_Date(";
  protected final String TEXT_235 = ", \"dd-MM-yyyy\");" + NL + "\t\t\t        }" + NL + "\t\t\t  " + NL + "\t\t\t        if (date_";
  protected final String TEXT_236 = "_";
  protected final String TEXT_237 = " != null) {" + NL + "\t\t\t          isMatch_";
  protected final String TEXT_238 = " = isMatch_";
  protected final String TEXT_239 = " ";
  protected final String TEXT_240 = " (message_";
  protected final String TEXT_241 = ".getSentDate()!=null && message_";
  protected final String TEXT_242 = ".getSentDate().";
  protected final String TEXT_243 = "before";
  protected final String TEXT_244 = "after";
  protected final String TEXT_245 = "(date_";
  protected final String TEXT_246 = "_";
  protected final String TEXT_247 = "));" + NL + "\t\t\t        }";
  protected final String TEXT_248 = NL + "\t\t\t\tif (isMatch_";
  protected final String TEXT_249 = ") {";
  protected final String TEXT_250 = NL + "\t\t\t    String filename_";
  protected final String TEXT_251 = " = ";
  protected final String TEXT_252 = ";" + NL + "\t\t\t    java.io.File file_";
  protected final String TEXT_253 = " = new java.io.File(";
  protected final String TEXT_254 = ", filename_";
  protected final String TEXT_255 = ");" + NL + "\t\t\t    java.io.OutputStream os_";
  protected final String TEXT_256 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_257 = ");" + NL + "\t    ";
  protected final String TEXT_258 = " " + NL + "\t\t\t    message_";
  protected final String TEXT_259 = ".writeTo(os_";
  protected final String TEXT_260 = ");" + NL + "\t\t\t    os_";
  protected final String TEXT_261 = ".close();" + NL + "\t\t\t\t" + NL + "\t";
  protected final String TEXT_262 = " " + NL + "     \t\t\tmessage_";
  protected final String TEXT_263 = ".setFlag(javax.mail.Flags.Flag.DELETED, true);";
  protected final String TEXT_264 = NL + NL + NL + "\t\t\t    nb_email_";
  protected final String TEXT_265 = "++;" + NL + "\t\t\t    globalMap.put(\"";
  protected final String TEXT_266 = "_CURRENT_FILE\", filename_";
  protected final String TEXT_267 = ");" + NL + "\t\t\t    globalMap.put(\"";
  protected final String TEXT_268 = "_CURRENT_FILEPATH\", file_";
  protected final String TEXT_269 = ".getAbsolutePath());";
  protected final String TEXT_270 = NL;

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
String username = ElementParameterParser.getValue(node, "__USERNAME__");

String port = ElementParameterParser.getValue(node, "__PORT__");
String outputDirectory = ElementParameterParser.getValue(node, "__OUTPUT_DIRECTORY__");
String filenamePattern = ElementParameterParser.getValue(node, "__FILENAME_PATTERN__");
String allEmails = ElementParameterParser.getValue(node, "__ALL_EMAILS__");
String maxEmails = ElementParameterParser.getValue(node, "__MAX_EMAILS__");
boolean bDeleteFromServer = "true".equals(ElementParameterParser.getValue(node, "__DELETE_FROM_SERVER__"));
String protocol = ElementParameterParser.getValue(node, "__PROTOCOL__");
List<Map<String, String>> filterList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_FILTER__");
String condition = ElementParameterParser.getValue(node, "__FILTER_RELATION__");
boolean useSSL = "true".equals(ElementParameterParser.getValue(node, "__USE_SSL__"));
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
boolean isNewerEmailFirst = ("true").equals(ElementParameterParser.getValue(node, "__NEWER_EMAILS__"));

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_35);
    
    String passwordFieldName = "__PASSWORD__";
    
    stringBuffer.append(TEXT_36);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_39);
    } else {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
	if (useSSL) {
		if ("pop3".equals(protocol)){
  
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
		} else {
  
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
		}
	}

	if ("pop3".equals(protocol)){

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(protocol);
    stringBuffer.append(TEXT_74);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    }
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
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    
	} else {
		if ("true".equals(ElementParameterParser.getValue(node, "__SPECIFY_MAIL_FOLDER__"))){
  
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MAIL_FOLDER__"));
    stringBuffer.append(TEXT_98);
    
		}
  
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(protocol);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
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
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
	}

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    if("false".equals(allEmails)&&(isNewerEmailFirst)){
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
    stringBuffer.append(maxEmails);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    } else {
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    if ("false".equals(allEmails)) {
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(maxEmails);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(("&&").equals(condition) ? "true" : "false");
    stringBuffer.append(TEXT_157);
    
			for (int i = 0;i < filterList.size(); i++) {
				String filterItem = filterList.get(i).get("FILTER_TIEM");
				String filterptn = filterList.get(i).get("PATTERN");
  
				if ("Subject".equals(filterItem)) {
      
    stringBuffer.append(TEXT_158);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(filterptn);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(condition);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    
  				} else if ("From".equals(filterItem)) {
      
    stringBuffer.append(TEXT_173);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(filterptn);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(condition);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    
				} else if ("To".equals(filterItem)) {
      
    stringBuffer.append(TEXT_188);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(filterptn);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(condition);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    
  				} else {
      
    stringBuffer.append(TEXT_227);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(filterptn);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(filterptn);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(condition);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    if ("BeforeDate".equals(filterItem)){
    stringBuffer.append(TEXT_243);
    }else if("AfterDate".equals(filterItem)){
    stringBuffer.append(TEXT_244);
    }
    stringBuffer.append(TEXT_245);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    
				}
			}
          
    		if (filterList.size()>0){
    
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    
    		}
    
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(filenamePattern );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(outputDirectory );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    
   				 //for bug TDI-21323

    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    
    		if (bDeleteFromServer){
    
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    
    		}
    
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
    stringBuffer.append(TEXT_270);
    return stringBuffer.toString();
  }
}
