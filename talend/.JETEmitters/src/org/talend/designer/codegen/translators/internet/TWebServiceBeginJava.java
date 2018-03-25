package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TWebServiceBeginJava
{
  protected static String nl;
  public static synchronized TWebServiceBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWebServiceBeginJava result = new TWebServiceBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "   long connTimeout_";
  protected final String TEXT_2 = " = (long)(Double.valueOf(";
  protected final String TEXT_3 = ") * 1000);";
  protected final String TEXT_4 = NL + "   long receiveTimeout_";
  protected final String TEXT_5 = " = (long)(Double.valueOf(";
  protected final String TEXT_6 = ") * 1000);";
  protected final String TEXT_7 = NL + "\tSystem.setProperty(\"javax.xml.transform.TransformerFactory\", \"org.apache.xalan.processor.TransformerFactoryImpl\");" + NL + "    System.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "" + NL + "    System.setProperty(\"javax.xml.accessExternalSchema\", \"all\");" + NL + "" + NL + "\t//shade the log level for DynamicClientFactory.class" + NL + "\tjava.util.logging.Logger LOG_";
  protected final String TEXT_8 = " = org.apache.cxf.common.logging.LogUtils.getL7dLogger(org.apache.cxf.endpoint.dynamic.DynamicClientFactory.class);" + NL + "\tLOG_";
  protected final String TEXT_9 = ".setLevel(java.util.logging.Level.WARNING);" + NL + "" + NL + "\torg.talend.webservice.helper.Utils util_";
  protected final String TEXT_10 = " = new org.talend.webservice.helper.Utils();" + NL + "" + NL + "    org.talend.webservice.helper.conf.ServiceHelperConfiguration config_";
  protected final String TEXT_11 = " = new org.talend.webservice.helper.conf.ServiceHelperConfiguration();" + NL + "" + NL + "\tconfig_";
  protected final String TEXT_12 = ".setConnectionTimeout(connTimeout_";
  protected final String TEXT_13 = ");" + NL + "\tconfig_";
  protected final String TEXT_14 = ".setReceiveTimeout(receiveTimeout_";
  protected final String TEXT_15 = ");" + NL + "" + NL + "\tconfig_";
  protected final String TEXT_16 = ".setKeyStoreFile(System.getProperty(\"javax.net.ssl.keyStore\"));" + NL + "\tconfig_";
  protected final String TEXT_17 = ".setKeyStoreType(System.getProperty(\"javax.net.ssl.keyStoreType\"));" + NL + "\tconfig_";
  protected final String TEXT_18 = ".setKeyStorePwd(System.getProperty(\"javax.net.ssl.keyStorePassword\"));" + NL;
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_21 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = "; ";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "    System.setProperty(\"java.protocol.handler.pkgs\", \"com.sun.net.ssl.internal.www.protocol\");" + NL + "" + NL + "\tSystem.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_28 = ");" + NL;
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + "    \tfinal String decryptedPwd_";
  protected final String TEXT_31 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "    \tfinal String decryptedPwd_";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ";";
  protected final String TEXT_36 = NL + NL + "\tSystem.setProperty(\"javax.net.ssl.trustStorePassword\", decryptedPwd_";
  protected final String TEXT_37 = ");" + NL;
  protected final String TEXT_38 = NL + "\tconfig_";
  protected final String TEXT_39 = ".setUsername(";
  protected final String TEXT_40 = ");" + NL + "\tconfig_";
  protected final String TEXT_41 = ".setPassword(decryptedPassword_";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\tconfig_";
  protected final String TEXT_44 = ".setProxyServer(";
  protected final String TEXT_45 = ");" + NL + "\tconfig_";
  protected final String TEXT_46 = ".setProxyPort(";
  protected final String TEXT_47 = ");" + NL + "    config_";
  protected final String TEXT_48 = ".setProxyUsername(";
  protected final String TEXT_49 = ");" + NL;
  protected final String TEXT_50 = NL;
  protected final String TEXT_51 = NL + "    \tfinal String decryptedProxyPwd_";
  protected final String TEXT_52 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "    \tfinal String decryptedProxyPwd_";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = ";";
  protected final String TEXT_57 = NL + NL + "    config_";
  protected final String TEXT_58 = ".setProxyPassword(decryptedProxyPwd_";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "\t";
  protected final String TEXT_61 = NL + "\tSystem.setProperty(\"http.auth.ntlm.domain\", ";
  protected final String TEXT_62 = ");" + NL + "\t";
  protected final String TEXT_63 = NL + "\tjava.net.Authenticator.setDefault(new java.net.Authenticator() {" + NL + "        public java.net.PasswordAuthentication getPasswordAuthentication() {" + NL + "            return new java.net.PasswordAuthentication(";
  protected final String TEXT_64 = ", decryptedPassword_";
  protected final String TEXT_65 = ".toCharArray());" + NL + "        }" + NL + "    });" + NL + "" + NL + "\tconfig_";
  protected final String TEXT_66 = ".setAllowChunking(false);";
  protected final String TEXT_67 = NL + "\torg.talend.webservice.helper.ServiceDiscoveryHelper serviceDiscoveryHelper_";
  protected final String TEXT_68 = " = null ;" + NL + "\torg.talend.webservice.helper.ServiceInvokerHelper serviceInvokerHelper_";
  protected final String TEXT_69 = " = null ;" + NL;
  protected final String TEXT_70 = NL + "\tjava.net.URI uri_";
  protected final String TEXT_71 = " = new java.net.URI(";
  protected final String TEXT_72 = ");" + NL + "    if (\"http\".equals(uri_";
  protected final String TEXT_73 = ".getScheme()) || \"https\".equals(uri_";
  protected final String TEXT_74 = ".getScheme())) {" + NL + "" + NL + "\t\tserviceInvokerHelper_";
  protected final String TEXT_75 = " = new org.talend.webservice.helper.ServiceInvokerHelper(";
  protected final String TEXT_76 = ",config_";
  protected final String TEXT_77 = ",";
  protected final String TEXT_78 = ");" + NL + "" + NL + "\t} else {";
  protected final String TEXT_79 = NL + "        serviceDiscoveryHelper_";
  protected final String TEXT_80 = " = new org.talend.webservice.helper.ServiceDiscoveryHelper(";
  protected final String TEXT_81 = ",";
  protected final String TEXT_82 = ");" + NL + "    \tserviceInvokerHelper_";
  protected final String TEXT_83 = " = new org.talend.webservice.helper.ServiceInvokerHelper(serviceDiscoveryHelper_";
  protected final String TEXT_84 = ",config_";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = NL + "\t}";
  protected final String TEXT_87 = NL + NL + "\tjavax.xml.namespace.QName serviceName_";
  protected final String TEXT_88 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_89 = "\", \"";
  protected final String TEXT_90 = "\");" + NL + "\tjavax.xml.namespace.QName portName_";
  protected final String TEXT_91 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_92 = "\", \"";
  protected final String TEXT_93 = "\");" + NL + "" + NL + "\tjava.util.Map<String,Object> inMap_";
  protected final String TEXT_94 = " = null;";
  protected final String TEXT_95 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String endpoint = ElementParameterParser.getValue(node,"__ENDPOINT__");

String serviceNS = ElementParameterParser.getValue(node,"__SERVICE_NS__");
String serviceName = ElementParameterParser.getValue(node,"__SERVICE_NAME__");
String portNS = ElementParameterParser.getValue(node,"__PORT_NS__");
String portName = ElementParameterParser.getValue(node,"__PORT_NAME__");

String soapAction = ElementParameterParser.getValue(node,"__SOAPACTION__");
String methodNS = ElementParameterParser.getValue(node,"__METHOD_NS__");

boolean useNTLM = ("true").equals(ElementParameterParser.getValue(node,"__USE_NTLM__"));
String domain = ElementParameterParser.getValue(node,"__NTLM_DOMAIN__");
String host = ElementParameterParser.getValue(node,"__NTLM_HOST__");

boolean needAuth = ("true").equals(ElementParameterParser.getValue(node,"__NEED_AUTH__"));
String username = ElementParameterParser.getValue(node,"__AUTH_USERNAME__");

boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");

boolean needSSLtoTrustServer = ("true").equals(ElementParameterParser.getValue(node,"__NEED_SSL_TO_TRUSTSERVER__"));
String trustStoreFile = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_TRUSTSTORE__");

String connTimeout = ElementParameterParser.getValue(node,"__CONNECTION_TIMEOUT__");
    if(connTimeout == null || "".equals(connTimeout) || "\"\"".equals(connTimeout)){
        connTimeout = "20";
    }

    stringBuffer.append(TEXT_1);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( connTimeout );
    stringBuffer.append(TEXT_3);
    

String receiveTimeout = ElementParameterParser.getValue(node,"__RECEIVE_TIMEOUT__");
    if(receiveTimeout == null || "".equals(receiveTimeout) || "\"\"".equals(receiveTimeout)){
        receiveTimeout = "20";
    }

    stringBuffer.append(TEXT_4);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( receiveTimeout );
    stringBuffer.append(TEXT_6);
    

String tempPath = ElementParameterParser.getValue(node,"__TMPPATH__");

String passwordFieldName = "";

if("".equals(tempPath))tempPath="\"\"";


    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
passwordFieldName = "__AUTH_PASSWORD__";

    stringBuffer.append(TEXT_19);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_22);
    } else {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    
if (needSSLtoTrustServer) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(trustStoreFile );
    stringBuffer.append(TEXT_28);
    
    passwordFieldName = "__SSL_TRUSTSERVER_PASSWORD__";
    
    stringBuffer.append(TEXT_29);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_32);
    } else {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
}if(needAuth&&!useNTLM){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
}if(useProxy){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_49);
    
    passwordFieldName = "__PROXY_PASSWORD__";
    
    stringBuffer.append(TEXT_50);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
}if(useNTLM){

    stringBuffer.append(TEXT_60);
    if(!"\"\"".equals(domain)){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
}

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    if(!useNTLM){
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    if(!useNTLM){
    stringBuffer.append(TEXT_86);
    }
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(serviceNS);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(serviceName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(portNS);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(TEXT_95);
    return stringBuffer.toString();
  }
}
