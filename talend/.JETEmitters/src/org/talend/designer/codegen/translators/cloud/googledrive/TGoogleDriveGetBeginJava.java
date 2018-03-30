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

public class TGoogleDriveGetBeginJava
{
  protected static String nl;
  public static synchronized TGoogleDriveGetBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleDriveGetBeginJava result = new TGoogleDriveGetBeginJava();
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
  protected final String TEXT_27 = NL + "\t\tcom.google.api.services.drive.Drive.Files.List ";
  protected final String TEXT_28 = "_listRequest =  ";
  protected final String TEXT_29 = "_client.files().list();" + NL + "\t\t";
  protected final String TEXT_30 = "_listRequest.setQ(\"trashed = false and title = '\" + ";
  protected final String TEXT_31 = " + \"' and mimeType != 'application/vnd.google-apps.folder'\");" + NL + "\t\tcom.google.api.services.drive.model.FileList ";
  protected final String TEXT_32 = "_files = ";
  protected final String TEXT_33 = "_listRequest.execute();" + NL + "\t\tif (";
  protected final String TEXT_34 = "_files.getItems().size() > 1)" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"More than one file found with name \\\"\" + ";
  protected final String TEXT_35 = " + \"\\\" \");" + NL + "\t\t}" + NL + "\t\telse if (";
  protected final String TEXT_36 = "_files.getItems().isEmpty())" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"No file found with name \\\"\" + ";
  protected final String TEXT_37 = " + \"\\\" \");" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\tString ";
  protected final String TEXT_38 = "_fileId = ";
  protected final String TEXT_39 = "_files.getItems().get(0).getId();" + NL + "\t\t\tcom.google.api.services.drive.model.File ";
  protected final String TEXT_40 = "_file = ";
  protected final String TEXT_41 = "_client.files().get(";
  protected final String TEXT_42 = "_fileId).execute();" + NL + "\t\t\tcom.google.api.client.http.HttpResponse resp = ";
  protected final String TEXT_43 = "_client.getRequestFactory().buildGetRequest(new com.google.api.client.http.GenericUrl(";
  protected final String TEXT_44 = "_file.getDownloadUrl())).execute();";
  protected final String TEXT_45 = NL + "\t\t\tjava.io.File ";
  protected final String TEXT_46 = "_outputFile = new java.io.File(";
  protected final String TEXT_47 = ");" + NL + "\t\t\tjava.io.FileOutputStream ";
  protected final String TEXT_48 = "_outputStream = new java.io.FileOutputStream(";
  protected final String TEXT_49 = "_outputFile);" + NL + "\t\t\tresp.download(";
  protected final String TEXT_50 = "_outputStream);";
  protected final String TEXT_51 = NL + "\t\t\t";
  protected final String TEXT_52 = ".content = ";
  protected final String TEXT_53 = NL + "\t\t\t\tnew java.io.FileInputStream(";
  protected final String TEXT_54 = "_outputFile);";
  protected final String TEXT_55 = NL + "\t\t\t\tresp.getContent();";
  protected final String TEXT_56 = NL + "\t\t}";

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

		String fileName = helper.getStringParam("__FILE_NAME__");

		boolean storeToLocal = helper.getBoolParam("__STORE_TO_LOCAL__");
		String outputFile = helper.getStringParam("__OUTPUT__");

		boolean dieOnError = helper.getBoolParam("__DIE_ON_ERROR__");
		
        String dataOutputConnection = null;
	    
		List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
	    for(IConnection conn : outputConnections) {
	        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	dataOutputConnection = conn.getName();
	        	break;
	        } // if(conn) end
	    } // for(conns) end

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

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
		if (storeToLocal){

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(outputFile);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
		}
		if(dataOutputConnection != null){

    stringBuffer.append(TEXT_51);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_52);
    
			if(storeToLocal){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
			}else{

    stringBuffer.append(TEXT_55);
    
			}
		}

    stringBuffer.append(TEXT_56);
    return stringBuffer.toString();
  }
}
