package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSOAPBeginJava
{
  protected static String nl;
  public static synchronized TSOAPBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSOAPBeginJava result = new TSOAPBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "final";
  protected final String TEXT_2 = " org.talend.soap.SOAPUtil soapUtil_";
  protected final String TEXT_3 = " = new org.talend.soap.SOAPUtil();";
  protected final String TEXT_4 = "   " + NL + "System.setProperty(\"java.protocol.handler.pkgs\", \"com.sun.net.ssl.internal.www.protocol\");" + NL + "System.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_5 = ");" + NL;
  protected final String TEXT_6 = NL + "    ";
  protected final String TEXT_7 = " " + NL + "    \tfinal String decryptedPwd_";
  protected final String TEXT_8 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "    \tfinal String decryptedPwd_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = "; ";
  protected final String TEXT_13 = NL + NL + "System.setProperty(\"javax.net.ssl.trustStorePassword\", decryptedPwd_";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_18 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = "; ";
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = NL + "soapUtil_";
  protected final String TEXT_25 = ".setBasicAuth(";
  protected final String TEXT_26 = ",decryptedPassword_";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "soapUtil_";
  protected final String TEXT_29 = ".setNTLMAuth(";
  protected final String TEXT_30 = ",";
  protected final String TEXT_31 = ",decryptedPassword_";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "\t//Enforcing NTLM authentication credentials." + NL + "\tsoapUtil_";
  protected final String TEXT_34 = ".enforceNtlmCredentials();" + NL + "\t";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = NL + "    ";
  protected final String TEXT_37 = " " + NL + "    \tfinal String decryptedProxyPwd_";
  protected final String TEXT_38 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "    \tfinal String decryptedProxyPwd_";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = "; ";
  protected final String TEXT_43 = NL + NL + "soapUtil_";
  protected final String TEXT_44 = ".setProxy(";
  protected final String TEXT_45 = ",";
  protected final String TEXT_46 = ",";
  protected final String TEXT_47 = ",decryptedProxyPwd_";
  protected final String TEXT_48 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean useNTLM = ("true").equals(ElementParameterParser.getValue(node,"__USE_NTLM__"));
String domain = ElementParameterParser.getValue(node,"__NTLM_DOMAIN__");
        
boolean needAuth = ("true").equals(ElementParameterParser.getValue(node,"__NEED_AUTH__"));
String username = ElementParameterParser.getValue(node,"__AUTH_USERNAME__");
String password = ElementParameterParser.getValue(node,"__AUTH_PASSWORD__");

boolean enforceNtlm = ("true").equals(ElementParameterParser.getValue(node,"__ENFORCE_NTLM__"));

boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");
        
boolean needSSLtoTrustServer = ("true").equals(ElementParameterParser.getValue(node,"__NEED_SSL_TO_TRUSTSERVER__"));
String trustStoreFile = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_TRUSTSTORE__");
String trustStorePassword = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_PASSWORD__");

boolean useKerberos = ("true").equals(ElementParameterParser.getValue(node,"__USE_KERBEROS__"));
String kerberosConfiguration = ElementParameterParser.getValue(node,"__KERBEROS_CONFIGURATION__");

String passwordFieldName = "";

    if(useKerberos){
    stringBuffer.append(TEXT_1);
    }
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    		
if(needSSLtoTrustServer){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(trustStoreFile );
    stringBuffer.append(TEXT_5);
    
    passwordFieldName = "__SSL_TRUSTSERVER_PASSWORD__";
    
    stringBuffer.append(TEXT_6);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_9);
    } else {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
     
}

    stringBuffer.append(TEXT_15);
    
passwordFieldName = "__AUTH_PASSWORD__";

    stringBuffer.append(TEXT_16);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_19);
    } else {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    
if(needAuth&&!useNTLM){

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
}
if(needAuth&&useNTLM){

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
	if(enforceNtlm) {
	
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
	}
}
if(useProxy){

    stringBuffer.append(TEXT_35);
    
    passwordFieldName = "__PROXY_PASSWORD__";
    
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
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(proxyUser);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
}

    return stringBuffer.toString();
  }
}
