package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSetKeystoreMainJava
{
  protected static String nl;
  public static synchronized TSetKeystoreMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSetKeystoreMainJava result = new TSetKeystoreMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t" + NL + "\t";
  protected final String TEXT_3 = NL + "    System.setProperty(\"java.protocol.handler.pkgs\", \"com.sun.net.ssl.internal.www.protocol\");" + NL + "    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(" + NL + "    \tnew javax.net.ssl.HostnameVerifier(){" + NL + "      \t\tpublic boolean verify(String hostName,javax.net.ssl.SSLSession session)" + NL + "       \t\t\t{" + NL + "       \t\t\t\treturn true;" + NL + "       \t\t\t}" + NL + "     \t}" + NL + "    );";
  protected final String TEXT_4 = NL + "    System.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_5 = ");" + NL + "    System.setProperty(\"javax.net.ssl.trustStoreType\", \"";
  protected final String TEXT_6 = "\");" + NL + "    ";
  protected final String TEXT_7 = NL + "    ";
  protected final String TEXT_8 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = "; ";
  protected final String TEXT_14 = NL + "    " + NL + "    " + NL + "    System.setProperty(\"javax.net.ssl.trustStorePassword\", decryptedPassword_";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tSystem.setProperty(\"javax.net.ssl.keyStore\", ";
  protected final String TEXT_17 = ");" + NL + "    System.setProperty(\"javax.net.ssl.keyStoreType\", \"";
  protected final String TEXT_18 = "\");" + NL + "    ";
  protected final String TEXT_19 = NL + "    ";
  protected final String TEXT_20 = " " + NL + "\tString decryptedPwd_";
  protected final String TEXT_21 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_22 = ");" + NL + "\t";
  protected final String TEXT_23 = NL + "\tString decryptedPwd_";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = "; " + NL + "\t";
  protected final String TEXT_26 = NL + "    " + NL + "    System.setProperty(\"javax.net.ssl.keyStorePassword\",decryptedPwd_";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\tSystem.clearProperty(\"javax.net.ssl.keyStore\");" + NL + "\tSystem.clearProperty(\"javax.net.ssl.keyStoreType\");" + NL + "\tSystem.clearProperty(\"javax.net.ssl.keyStorePassword\");";
  protected final String TEXT_29 = NL + "\t        ";
  protected final String TEXT_30 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    // component id
   String cid = node.getUniqueName();
   
   String trustStoreType = ElementParameterParser.getValue(node,"__TRUSTSTORE_TYPE__");
   String trustStorePath = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_TRUSTSTORE__");
   String trustStorePwd = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_PASSWORD__");
   boolean needClientAuth = "true".equals(ElementParameterParser.getValue(node,"__NEED_CLIENT_AUTH__"));
   String keyStoreType = ElementParameterParser.getValue(node,"__KEYSTORE_TYPE__");
   String keyStorePath = ElementParameterParser.getValue(node,"__SSL_KEYSTORE__");
   String keyStorePwd = ElementParameterParser.getValue(node,"__SSL_KEYSTORE_PASSWORD__");
   boolean verifyName = ("true").equals(ElementParameterParser.getValue(node,"__VERIFY_NAME__"));

    stringBuffer.append(TEXT_2);
    if(!verifyName){
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(trustStorePath );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(trustStoreType );
    stringBuffer.append(TEXT_6);
    
    String passwordFieldName = "__SSL_TRUSTSERVER_PASSWORD__";
    
    stringBuffer.append(TEXT_7);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    } else {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    if(needClientAuth){
    stringBuffer.append(TEXT_16);
    stringBuffer.append(keyStorePath );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(keyStoreType);
    stringBuffer.append(TEXT_18);
    
    passwordFieldName = "__SSL_KEYSTORE_PASSWORD__";
    
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    }else{
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}
