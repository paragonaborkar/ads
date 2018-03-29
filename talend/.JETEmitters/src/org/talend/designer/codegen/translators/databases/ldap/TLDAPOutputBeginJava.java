package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TLDAPOutputBeginJava
{
  protected static String nl;
  public static synchronized TLDAPOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPOutputBeginJava result = new TLDAPOutputBeginJava();
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
  protected final String TEXT_30 = NL + "\tjava.util.Hashtable env_";
  protected final String TEXT_31 = " = new java.util.Hashtable();" + NL + "\tenv_";
  protected final String TEXT_32 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, \"com.sun.jndi.ldap.LdapCtxFactory\");" + NL + "    env_";
  protected final String TEXT_33 = ".put(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");// \"none\",\"simple\",\"strong\"" + NL + "    env_";
  protected final String TEXT_34 = ".put(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_35 = ");" + NL + "    " + NL + "\t";
  protected final String TEXT_36 = NL + "        " + NL + "\t";
  protected final String TEXT_37 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_38 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = "; ";
  protected final String TEXT_43 = NL + NL + "    env_";
  protected final String TEXT_44 = ".put(javax.naming.Context.SECURITY_CREDENTIALS, decryptedPassword_";
  protected final String TEXT_45 = ");" + NL + "\tenv_";
  protected final String TEXT_46 = ".put(javax.naming.Context.REFERRAL, \"";
  protected final String TEXT_47 = "\");" + NL + "\tenv_";
  protected final String TEXT_48 = ".put(\"java.naming.ldap.derefAliases\",\"";
  protected final String TEXT_49 = "\");" + NL + "\tString baseDN_";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = ";";
  protected final String TEXT_52 = NL + "\tenv_";
  protected final String TEXT_53 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_54 = "+\":\"+";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\tenv_";
  protected final String TEXT_57 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_58 = "+\":\"+";
  protected final String TEXT_59 = "+\"/\"+";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\tenv_";
  protected final String TEXT_62 = ".put(javax.naming.Context.SECURITY_PROTOCOL, \"ssl\");" + NL + "\tenv_";
  protected final String TEXT_63 = ".put(\"java.naming.ldap.factory.socket\", \"talend.ssl.AdvancedSocketFactory\");";
  protected final String TEXT_64 = NL + "\t\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_66 = " - Adnanced CA trusting all certs.\");" + NL + "\t\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\ttalend.ssl.AdvancedSocketFactory.alwaysTrust();";
  protected final String TEXT_68 = NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_70 = " - Advanced CA using a store CA file and Keystore password.\");" + NL + "\t\t\t\t\tlog.debug(\"Store CA : '\" + ";
  protected final String TEXT_71 = " + \"'.\");" + NL + "\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\ttalend.ssl.AdvancedSocketFactory.setCertStorePath(";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "\t\t\t\t";
  protected final String TEXT_75 = NL + "            ";
  protected final String TEXT_76 = " " + NL + "                    \tfinal String decryptedPwd_";
  protected final String TEXT_77 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "                    \tfinal String decryptedPwd_";
  protected final String TEXT_80 = " = ";
  protected final String TEXT_81 = "; ";
  protected final String TEXT_82 = "\t\t\t\t" + NL + "\t\t\t\t" + NL + "\t\t\t\ttalend.ssl.AdvancedSocketFactory.setCertStorePassword(decryptedPwd_";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL + "\t";
  protected final String TEXT_85 = NL + "\t\tlog.info(\"";
  protected final String TEXT_86 = " - Connection attempt to '\"+ ";
  protected final String TEXT_87 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_88 = NL + "    javax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_89 = " = new javax.naming.ldap.InitialLdapContext(env_";
  protected final String TEXT_90 = ", null);";
  protected final String TEXT_91 = NL + "\tjavax.naming.ldap.StartTlsRequest tldsReq_";
  protected final String TEXT_92 = " = new javax.naming.ldap.StartTlsRequest();" + NL + "    javax.naming.ldap.StartTlsResponse tls_";
  protected final String TEXT_93 = " =(javax.naming.ldap.StartTlsResponse)ctx_";
  protected final String TEXT_94 = ".extendedOperation(tldsReq_";
  protected final String TEXT_95 = ");" + NL + "    javax.net.ssl.SSLSession session_";
  protected final String TEXT_96 = " = tls_";
  protected final String TEXT_97 = ".negotiate((javax.net.ssl.SSLSocketFactory)talend.ssl.AdvancedSocketFactory.getDefault());";
  protected final String TEXT_98 = NL + "\t";
  protected final String TEXT_99 = NL + "\t\tlog.info(\"";
  protected final String TEXT_100 = " - Connection to '\"+";
  protected final String TEXT_101 = "+\"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_102 = NL + "\tjavax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_103 = " = (javax.naming.ldap.InitialLdapContext)globalMap.get(\"";
  protected final String TEXT_104 = "\");" + NL + "\t";
  protected final String TEXT_105 = NL + "\t\tif(ctx_";
  protected final String TEXT_106 = "!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_107 = " - Uses an existing connection ,connection URL is: '\" + ctx_";
  protected final String TEXT_108 = ".getEnvironment().get(javax.naming.Context.PROVIDER_URL) + \"'.\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_109 = NL + "    String baseDN_";
  protected final String TEXT_110 = " = (String)globalMap.get(\"";
  protected final String TEXT_111 = "\");";
  protected final String TEXT_112 = NL + "boolean whetherReject_";
  protected final String TEXT_113 = " = false;" + NL + "int nb_line_";
  protected final String TEXT_114 = " = 0;" + NL + "int nb_line_rejected_";
  protected final String TEXT_115 = " = 0;";
  protected final String TEXT_116 = NL + "\t\ttalend.ssl.ldap.LdapAction ldap_";
  protected final String TEXT_117 = " = new talend.ssl.ldap.LdapAction();";
  protected final String TEXT_118 = NL + "\t//check is base64 begin\t" + NL + "\tclass CheckBase64_";
  protected final String TEXT_119 = "{" + NL + "\t\tpublic void checkByteArray(boolean isBase64,String columnName,javax.naming.directory.Attributes entry,byte[] bytearray) throws com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException{" + NL + "\t\t\tif(isBase64){" + NL + "\t\t\t\tentry.put(columnName,com.sun.org.apache.xml.internal.security.utils.Base64.decode(bytearray));" + NL + "\t\t\t}" + NL + "\t\t\telse{" + NL + "\t\t\t\tentry.put(columnName,bytearray);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic void checkString(boolean isBase64,String columnName,javax.naming.directory.Attributes entry,String inputValue) throws com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException{" + NL + "\t\t\tif(isBase64){" + NL + "\t\t\t\tentry.put(columnName,com.sun.org.apache.xml.internal.security.utils.Base64.decode(inputValue));" + NL + "\t\t\t}" + NL + "\t\t\telse{" + NL + "\t\t\t\tentry.put(columnName,inputValue);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic void addToAttribute(boolean isBase64,javax.naming.directory.Attribute attr,String inputValue) throws com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException{" + NL + "\t\t\tif(isBase64){" + NL + "  \t\t\t\tattr.add(com.sun.org.apache.xml.internal.security.utils.Base64.decode(inputValue));" + NL + "\t\t\t}else{" + NL + "\t\t\t\tattr.add(inputValue);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic void checkByteArrayUpdate(boolean isBase64,String columnName,List<javax.naming.directory.Attribute> forUpate,byte[] bytearray) throws com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException{" + NL + "\t\t\tif(isBase64){" + NL + "\t\t\t\tforUpate.add(new javax.naming.directory.BasicAttribute(columnName, com.sun.org.apache.xml.internal.security.utils.Base64.decode(bytearray)));" + NL + "\t\t\t}else{" + NL + "\t\t\t\tforUpate.add(new javax.naming.directory.BasicAttribute(columnName, bytearray));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tpublic void checkStringUpdate(boolean isBase64,String columnName,List<javax.naming.directory.Attribute> forUpate,String inputValue) throws com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException{" + NL + "\t\t\tif(isBase64){" + NL + "\t\t\t\tforUpate.add(new javax.naming.directory.BasicAttribute(columnName, com.sun.org.apache.xml.internal.security.utils.Base64.decode(inputValue)));" + NL + "\t\t\t}else{" + NL + "\t\t\t\tforUpate.add(new javax.naming.directory.BasicAttribute(columnName, inputValue));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic void checkStringUpdateAttr(boolean isBase64,String columnName,javax.naming.directory.Attribute attrForUpdate,String inputValue) throws com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException{" + NL + "\t\t\tif(isBase64){" + NL + "\t\t\t\tattrForUpdate.add(com.sun.org.apache.xml.internal.security.utils.Base64.decode(inputValue));" + NL + "\t\t\t}else{" + NL + "\t\t\t\tattrForUpdate.add(inputValue);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_120 = NL + "\t\tpublic String filterNullElement(String srcData,String splitStr){" + NL + "\t\t\tString result = \"\";" + NL + "\t\t\tString[] tempArr = routines.system.StringUtils.splitNotRegex(srcData,splitStr);";
  protected final String TEXT_121 = NL + "\t\t\tfor (int i = 0 ; i < tempArr.length; i++) {" + NL + "\t\t\t\tif(tempArr[i] !=null && !\"\".equals(tempArr[i].trim())) {" + NL + "\t\t\t\t\tif(!\"\".equals(result)) {" + NL + "\t\t\t\t\t\tresult = result + splitStr;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tresult = result + tempArr[i];" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "\tCheckBase64_";
  protected final String TEXT_122 = " base64_";
  protected final String TEXT_123 = " = new CheckBase64_";
  protected final String TEXT_124 = "();" + NL + "\t//check is base64 end";

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
	String baseDN=ElementParameterParser.getValue(node, "__BASEDN__");

	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String exConn= "conn_" + connection;
	String exConnBaseDN = "connBaseDN_" + connection;
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	String insertMode =ElementParameterParser.getValue(node, "__INSERT_MODE__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if(("false").equals(useExistingConn)){
	String host=ElementParameterParser.getValue(node, "__HOST__");
	String port=ElementParameterParser.getValue(node, "__PORT__");
	String protocol=ElementParameterParser.getValue(node, "__PROTOCOL__");
	String advanced=ElementParameterParser.getValue(node, "__ADVANCEDCA__");
	String storepath=ElementParameterParser.getValue(node, "__STORECA__");
	String storepwd = ElementParameterParser.getValue(node, "__STORECAPWD__");
	boolean alwaysTrust = ("true").equals(ElementParameterParser.getValue(node, "__ALWAYS_TRUST__"));
	String user =ElementParameterParser.getValue(node, "__USER__");

	String referrals=ElementParameterParser.getValue(node, "__REFERRALS__");
	String aliases=ElementParameterParser.getValue(node, "__ALIASES__");

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_35);
    
    String passwordFieldName = "__PASS__";
    
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(referrals);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(aliases);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(baseDN);
    stringBuffer.append(TEXT_51);
    
	if(baseDN == null || baseDN.length()<=2){

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_55);
    
	}else{

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(baseDN);
    stringBuffer.append(TEXT_60);
    
	}
    if(("LDAPS").equals(protocol)){

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
	}
	if(("LDAPS").equals(protocol) || ("TLS").equals(protocol)){
		if(("true").equals(advanced)){
			if(alwaysTrust) {

    stringBuffer.append(TEXT_64);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    
			} else {

    stringBuffer.append(TEXT_68);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(storepath );
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(storepath);
    stringBuffer.append(TEXT_73);
    
				if(storepwd !=null && storepwd.length() !=0 ){
    stringBuffer.append(TEXT_74);
    
                    passwordFieldName = "__STORECAPWD__";
                    
    stringBuffer.append(TEXT_75);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_78);
    } else {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
				}
			}
		}
    }

    stringBuffer.append(TEXT_84);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
	if(("TLS").equals(protocol)){

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
	}

    stringBuffer.append(TEXT_98);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_101);
    }
    
}else{

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(exConn);
    stringBuffer.append(TEXT_104);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(exConnBaseDN);
    stringBuffer.append(TEXT_111);
    
}

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    	if(("DELETE").equals(insertMode)){ 
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    	}
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
		//for bug TDI-19611,filter "" or null element

    stringBuffer.append(TEXT_120);
    //For TDI-28021
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    return stringBuffer.toString();
  }
}
