package org.talend.designer.codegen.translators.cloud.googledrive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeParamsHelper;

public class TGoogleDriveConnectionBeginJava
{
  protected static String nl;
  public static synchronized TGoogleDriveConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleDriveConnectionBeginJava result = new TGoogleDriveConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "{";
  protected final String TEXT_2 = NL + " \tjavax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory" + NL + "\t.getInstance(javax.net.ssl.TrustManagerFactory" + NL + "\t\t\t.getDefaultAlgorithm());" + NL + "" + NL + "\tjava.io.FileInputStream fis = new java.io.FileInputStream(" + NL + "\t\t\t";
  protected final String TEXT_3 = ");" + NL + "\tjava.security.KeyStore ks = java.security.KeyStore" + NL + "\t\t\t.getInstance(java.security.KeyStore.getDefaultType());" + NL + "\t";
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_6 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = "; ";
  protected final String TEXT_11 = NL + "                       " + NL + "\tks.load(fis, decryptedPassword_";
  protected final String TEXT_12 = ".toCharArray());" + NL + "\tfis.close();" + NL + "\ttmf.init(ks);" + NL + "\tjavax.net.ssl.SSLContext sslContext = javax.net.ssl.SSLContext.getInstance(";
  protected final String TEXT_13 = ");" + NL + "\tsslContext.init(null, tmf.getTrustManagers(), new java.security.SecureRandom());";
  protected final String TEXT_14 = NL + "com.google.api.client.http.HttpTransport httpTransport = new com.google.api.client.http.javanet.NetHttpTransport.Builder()";
  protected final String TEXT_15 = NL + "\t\t.setProxy(new java.net.Proxy(java.net.Proxy.Type.HTTP, java.net.InetSocketAddress.createUnresolved(";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = ")))";
  protected final String TEXT_18 = NL + "\t.setSslSocketFactory(sslContext.getSocketFactory())";
  protected final String TEXT_19 = NL + "\t.build();" + NL + "" + NL + "\tcom.google.api.client.googleapis.auth.oauth2.GoogleCredential credential = new com.google.api.client.googleapis.auth.oauth2.GoogleCredential().setAccessToken(";
  protected final String TEXT_20 = ");" + NL + "\t com.google.api.services.drive.Drive ";
  protected final String TEXT_21 = "_client = new  com.google.api.services.drive.Drive.Builder(httpTransport, new com.google.api.client.json.jackson2.JacksonFactory(), credential)" + NL + "\t.setApplicationName(";
  protected final String TEXT_22 = "+\" \"+jobName+\"/\"+jobVersion+\" (GPN:Talend)\").build();" + NL + "\t" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_23 = "\",  ";
  protected final String TEXT_24 = "_client);" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
NodeParamsHelper helper = new NodeParamsHelper(node);
String accessToken = helper.getStringParam("__ACCESS_TOKEN__");

boolean useProxy = helper.getBoolParam("__USE_PROXY__");
boolean useSSL = helper.getBoolParam("__USE_SSL__");


String clientIdentifier = "\""+cid+"\"";

String localeName = "\""+java.util.Locale.getDefault().toString()+"\"";

if(useSSL) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(helper.getStringParam("__SSL_TRUST_STORE__"));
    stringBuffer.append(TEXT_3);
    String passwordFieldName = "__SSL_TRUST_STORE_PASSWORD__";
    stringBuffer.append(TEXT_4);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_7);
    } else {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(helper.getStringParam("__SSL_ALGORITHM__"));
    stringBuffer.append(TEXT_13);
    	
}

    stringBuffer.append(TEXT_14);
    if(useProxy){
String proxyHost = helper.getStringParam("__PROXY_HOST__");
String proxyPort = helper.getStringParam("__PROXY_PORT__");

    stringBuffer.append(TEXT_15);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_17);
    }
  if(useSSL) {

    stringBuffer.append(TEXT_18);
    
  }

    stringBuffer.append(TEXT_19);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(helper.getStringParam("__APPLICATION_NAME__"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
