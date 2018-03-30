package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TLDAPRenameEntryBeginJava
{
  protected static String nl;
  public static synchronized TLDAPRenameEntryBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPRenameEntryBeginJava result = new TLDAPRenameEntryBeginJava();
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
  protected final String TEXT_33 = ".put(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");// \"none\",\"simple\",\"strong\"";
  protected final String TEXT_34 = NL + "    env_";
  protected final String TEXT_35 = ".put(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_36 = ");" + NL + "    " + NL + "\t";
  protected final String TEXT_37 = NL + "        " + NL + "\t";
  protected final String TEXT_38 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_39 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = "; ";
  protected final String TEXT_44 = NL + NL + "    env_";
  protected final String TEXT_45 = ".put(javax.naming.Context.SECURITY_CREDENTIALS, decryptedPassword_";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\tenv_";
  protected final String TEXT_48 = ".put(javax.naming.Context.REFERRAL, \"";
  protected final String TEXT_49 = "\");" + NL + "\tenv_";
  protected final String TEXT_50 = ".put(\"java.naming.ldap.derefAliases\",\"";
  protected final String TEXT_51 = "\");";
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
  protected final String TEXT_82 = "\t\t\t\t" + NL + "    \t\t\t\t" + NL + "\t\t\t\ttalend.ssl.AdvancedSocketFactory.setCertStorePassword(decryptedPwd_";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL + "\t";
  protected final String TEXT_85 = NL + "\t\tlog.info(\"";
  protected final String TEXT_86 = " - Connection attempt to '\"+ ";
  protected final String TEXT_87 = ");" + NL + "\t";
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
  protected final String TEXT_98 = NL + "\t\tlog.info(\"";
  protected final String TEXT_99 = " - Connection to '\"+";
  protected final String TEXT_100 = "+\"' has succeeded.\");";
  protected final String TEXT_101 = NL + "javax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_102 = " = (javax.naming.ldap.InitialLdapContext)globalMap.get(\"";
  protected final String TEXT_103 = "\");" + NL + "\t";
  protected final String TEXT_104 = NL + "\t\tif(ctx_";
  protected final String TEXT_105 = "!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_106 = " - Uses an existing connection ,connection URL is: '\" + ctx_";
  protected final String TEXT_107 = ".getEnvironment().get(javax.naming.Context.PROVIDER_URL) + \"'.\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_108 = NL + "boolean whetherReject_";
  protected final String TEXT_109 = " = false;" + NL + "class LDAPRenameEntryUtil_";
  protected final String TEXT_110 = " {" + NL + "\t" + NL + "\tprivate java.util.Map<String, javax.naming.directory.Attributes> childs = new java.util.HashMap();" + NL + "\tprivate java.util.List<String> paths = new java.util.ArrayList();" + NL + "\t" + NL + "\tpublic void renameWithChilds(String oldName, String newName, javax.naming.ldap.InitialLdapContext ldapCtx) throws java.lang.Exception {" + NL + "\t\tthis.list(oldName, ldapCtx);" + NL + "\t\t" + NL + "\t\tthis.destroySubcontext(paths, ldapCtx);" + NL + "\t\t" + NL + "\t\ttry {" + NL + "\t\t\tldapCtx.rename(oldName, newName);" + NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\tthis.createSubcontext(paths, paths, childs, ldapCtx);" + NL + "\t\t\t" + NL + "\t\t\tthrow e;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tjava.util.List<String> newPaths = new java.util.ArrayList();" + NL + "\t\tfor (String childName : paths) {" + NL + "\t\t\tnewPaths.add(childName.replaceAll(oldName, newName));" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tthis.createSubcontext(newPaths, paths, childs, ldapCtx);" + NL + "\t}" + NL + "\tpublic void list(String rootName, javax.naming.ldap.InitialLdapContext ldapCtx) throws java.lang.Exception {" + NL + "\t\tjavax.naming.NamingEnumeration nern =ldapCtx.list(rootName);" + NL + "\t\twhile(nern.hasMore()){" + NL + "\t\t\tjavax.naming.NameClassPair nameCP= (javax.naming.NameClassPair)nern.next();" + NL + "\t\t\tchilds.put(nameCP.getName()+\",\"+rootName, ldapCtx.getAttributes(nameCP.getName()+\",\"+rootName));" + NL + "\t\t\tlist(nameCP.getName()+\",\"+rootName, ldapCtx);" + NL + "\t\t\tpaths.add(nameCP.getName()+\",\"+rootName);" + NL + "\t\t} " + NL + "\t}" + NL + "\t" + NL + "\tpublic void destroySubcontext(java.util.List<String> paths, javax.naming.ldap.InitialLdapContext ldapCtx)throws java.lang.Exception {" + NL + "\t\tfor (String childName : paths) {" + NL + "\t\t\tldapCtx.destroySubcontext(childName);" + NL + "\t\t}" + NL + "\t}" + NL + "\t\t" + NL + "\tpublic void createSubcontext(java.util.List<String> newPaths, java.util.List<String> oldPaths," + NL + "\t\t\t\t\t\t\t java.util.Map<String, javax.naming.directory.Attributes> childs, " + NL + "\t\t\t\t\t\t\tjavax.naming.ldap.InitialLdapContext ldapCtx)throws java.lang.Exception {" + NL + "\t\tfor (int i=newPaths.size(); i>0; i-- ) {" + NL + "\t\t\tldapCtx.createSubcontext(newPaths.get(i-1), childs.get(oldPaths.get(i-1)));" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "}" + NL + NL + NL + NL;
  protected final String TEXT_111 = NL;

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
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if(("false").equals(useExistingConn)){
	String host=ElementParameterParser.getValue(node, "__HOST__");
	String port=ElementParameterParser.getValue(node, "__PORT__");
	String protocol=ElementParameterParser.getValue(node, "__PROTOCOL__");
	String advanced=ElementParameterParser.getValue(node, "__ADVANCEDCA__");
	boolean alwaysTrust = ("true").equals(ElementParameterParser.getValue(node, "__ALWAYS_TRUST__"));
	String storepath=ElementParameterParser.getValue(node, "__STORECA__");
	String storepwd = ElementParameterParser.getValue(node, "__STORECAPWD__");
	String authen =ElementParameterParser.getValue(node, "__AUTHENTIFICATION__");
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
    
    if(("true").equals(authen)){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_36);
    
    String passwordFieldName = "__PASS__";
    
    stringBuffer.append(TEXT_37);
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
    stringBuffer.append(referrals);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(aliases);
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
    
                    String passwordFieldName = "__STORECAPWD__";
                    
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
	if(isLog4jEnabled){

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_100);
    
	}
}else{

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(exConn);
    stringBuffer.append(TEXT_103);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    }
    
}

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(TEXT_111);
    return stringBuffer.toString();
  }
}
