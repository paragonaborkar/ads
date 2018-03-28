package org.talend.designer.codegen.translators.cloud.googledrive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeParamsHelper;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TGoogleDrivePutBeginJava
{
  protected static String nl;
  public static synchronized TGoogleDrivePutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleDrivePutBeginJava result = new TGoogleDrivePutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "com.google.api.services.drive.Drive ";
  protected final String TEXT_2 = "_client;";
  protected final String TEXT_3 = NL + "{";
  protected final String TEXT_4 = NL + NL + "\tjavax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory" + NL + "\t\t.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());" + NL + "\t" + NL + "\tjava.io.FileInputStream fis = new java.io.FileInputStream(";
  protected final String TEXT_5 = ");" + NL + "\tjava.security.KeyStore ks = java.security.KeyStore.getInstance(java.security.KeyStore.getDefaultType());";
  protected final String TEXT_6 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = "; ";
  protected final String TEXT_12 = NL + "                       " + NL + "\tks.load(fis, decryptedPassword_";
  protected final String TEXT_13 = ".toCharArray());" + NL + "\tfis.close();" + NL + "\ttmf.init(ks);" + NL + "\tjavax.net.ssl.SSLContext sslContext = javax.net.ssl.SSLContext.getInstance(";
  protected final String TEXT_14 = ");" + NL + "\t\tsslContext.init(null, tmf.getTrustManagers(), new java.security.SecureRandom());";
  protected final String TEXT_15 = NL + "\tcom.google.api.client.http.HttpTransport httpTransport = new com.google.api.client.http.javanet.NetHttpTransport.Builder()";
  protected final String TEXT_16 = NL + "\t\t.setProxy(new java.net.Proxy(java.net.Proxy.Type.HTTP, java.net.InetSocketAddress.createUnresolved(";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = ")))";
  protected final String TEXT_19 = NL + "\t\t.setSslSocketFactory(sslContext.getSocketFactory())";
  protected final String TEXT_20 = NL + "\t\t.build();" + NL + "" + NL + "\tcom.google.api.client.googleapis.auth.oauth2.GoogleCredential credential = new com.google.api.client.googleapis.auth.oauth2.GoogleCredential().setAccessToken(";
  protected final String TEXT_21 = ");" + NL + "\t";
  protected final String TEXT_22 = "_client = new  com.google.api.services.drive.Drive.Builder(httpTransport, new com.google.api.client.json.jackson2.JacksonFactory(), credential)" + NL + "\t\t.setApplicationName(";
  protected final String TEXT_23 = "+\" \"+jobName+\"/\"+jobVersion+\" (GPN:Talend)\").build();" + NL + "}";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = "_client = (com.google.api.services.drive.Drive)globalMap.get(";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "java.io.ByteArrayOutputStream ";
  protected final String TEXT_28 = "_uploader_output = new java.io.ByteArrayOutputStream();" + NL + "java.io.ByteArrayInputStream ";
  protected final String TEXT_29 = "_uploader_input = null;" + NL + "globalMap.put(\"";
  protected final String TEXT_30 = "_OUTPUTSTREAM\", ";
  protected final String TEXT_31 = "_uploader_output);";
  protected final String TEXT_32 = NL + "try" + NL + "{";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		NodeParamsHelper helper = new NodeParamsHelper(node);

		boolean useExistingConn = helper.getBoolParam("__USE_EXISTING_CONNECTION__");
		String connection = helper.getStringParam("__CONNECTION__");
	    String connectionKey = "\"conn_" + connection+"\"";


		String outputFile = helper.getStringParam("__OUTPUT__");

		boolean dieOnError = helper.getBoolParam("__DIE_ON_ERROR__");

	    boolean exposeOutput = helper.getBoolParam("__EXPOSE_OUTPUT_STREAM__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
		if(!useExistingConn){

    stringBuffer.append(TEXT_3);
    
	    	boolean useSSL = helper.getBoolParam("__USE_SSL__");
	    	boolean useProxy = helper.getBoolParam("__USE_PROXY__");
	    	if(useSSL) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(helper.getStringParam("__SSL_TRUST_STORE__"));
    stringBuffer.append(TEXT_5);
    String passwordFieldName = "__SSL_TRUST_STORE_PASSWORD__";
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    } else {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(helper.getStringParam("__SSL_ALGORITHM__"));
    stringBuffer.append(TEXT_14);
    
			}

    stringBuffer.append(TEXT_15);
    
			if(useProxy) {
				String proxyHost = helper.getStringParam("__PROXY_HOST__");
				String proxyPort = helper.getStringParam("__PROXY_PORT__");

    stringBuffer.append(TEXT_16);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_18);
    
			}if(useSSL) {

    stringBuffer.append(TEXT_19);
    
			}

    stringBuffer.append(TEXT_20);
    stringBuffer.append(helper.getStringParam("__ACCESS_TOKEN__"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(helper.getStringParam("__APPLICATION_NAME__"));
    stringBuffer.append(TEXT_23);
    
		}else {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(connectionKey);
    stringBuffer.append(TEXT_26);
    
		}
		if(exposeOutput){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
		}

    stringBuffer.append(TEXT_32);
    return stringBuffer.toString();
  }
}
