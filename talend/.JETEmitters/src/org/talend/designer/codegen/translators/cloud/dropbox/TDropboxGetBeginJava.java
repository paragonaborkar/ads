package org.talend.designer.codegen.translators.cloud.dropbox;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TDropboxGetBeginJava
{
  protected static String nl;
  public static synchronized TDropboxGetBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDropboxGetBeginJava result = new TDropboxGetBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\tcom.dropbox.core.DbxRequestConfig.Builder configBuilder_";
  protected final String TEXT_4 = " = com.dropbox.core.DbxRequestConfig.newBuilder(\"";
  protected final String TEXT_5 = "\");" + NL + "\tString localeName_";
  protected final String TEXT_6 = " = java.util.Locale.getDefault().toString();" + NL + "\tconfigBuilder_";
  protected final String TEXT_7 = ".withUserLocale(localeName_";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\t\tjava.net.InetSocketAddress socketAddress_";
  protected final String TEXT_10 = " = new java.net.InetSocketAddress(";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = ");" + NL + "\t\tjava.net.Proxy proxy_";
  protected final String TEXT_13 = " = new java.net.Proxy(java.net.Proxy.Type.HTTP, socketAddress_";
  protected final String TEXT_14 = ");" + NL + "\t\tcom.dropbox.core.http.StandardHttpRequestor.Config config_";
  protected final String TEXT_15 = " = com.dropbox.core.http.StandardHttpRequestor.Config.builder().withNoConnectTimeout().withProxy(proxy_";
  protected final String TEXT_16 = ").build();" + NL + "\t\tcom.dropbox.core.http.HttpRequestor httpRequestor_";
  protected final String TEXT_17 = " = new com.dropbox.core.http.StandardHttpRequestor(config_";
  protected final String TEXT_18 = ");" + NL + "\t\tconfigBuilder_";
  protected final String TEXT_19 = ".withHttpRequestor(httpRequestor_";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\tcom.dropbox.core.DbxRequestConfig dbxConfig_";
  protected final String TEXT_22 = " = configBuilder_";
  protected final String TEXT_23 = ".build();" + NL + "\tcom.dropbox.core.v2.DbxClientV2 client_";
  protected final String TEXT_24 = " = new com.dropbox.core.v2.DbxClientV2(dbxConfig_";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\tcom.dropbox.core.v2.DbxClientV2 client_";
  protected final String TEXT_28 = " = (com.dropbox.core.v2.DbxClientV2) globalMap.get(\"";
  protected final String TEXT_29 = "\");";
  protected final String TEXT_30 = NL + "\t" + NL + "com.dropbox.core.v2.files.DbxUserFilesRequests filesClient_";
  protected final String TEXT_31 = " = client_";
  protected final String TEXT_32 = ".files();" + NL + "com.dropbox.core.DbxDownloader<com.dropbox.core.v2.files.FileMetadata> downloader_";
  protected final String TEXT_33 = " = null;" + NL + "try {" + NL + "\tdownloader_";
  protected final String TEXT_34 = " = filesClient_";
  protected final String TEXT_35 = ".download(";
  protected final String TEXT_36 = ");" + NL + "} catch (com.dropbox.core.v2.files.DownloadErrorException e_";
  protected final String TEXT_37 = ") {" + NL + "\tthrow new Exception(";
  protected final String TEXT_38 = " + \" is not a valid file path on Dropbox\");" + NL + "}";
  protected final String TEXT_39 = NL + "\tjava.io.File outputFile_";
  protected final String TEXT_40 = " = new java.io.File(";
  protected final String TEXT_41 = ");" + NL + "\tif(!outputFile_";
  protected final String TEXT_42 = ".getParentFile().exists()) {" + NL + "\t\toutputFile_";
  protected final String TEXT_43 = ".getParentFile().mkdirs();" + NL + "\t}" + NL + "\ttry (java.io.FileOutputStream fos_";
  protected final String TEXT_44 = " = new java.io.FileOutputStream(outputFile_";
  protected final String TEXT_45 = ")) {" + NL + "        downloader_";
  protected final String TEXT_46 = ".download(fos_";
  protected final String TEXT_47 = ");" + NL + "    }" + NL + "\t";
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = ".content = new java.io.FileInputStream(outputFile_";
  protected final String TEXT_50 = ");" + NL + "\t\t";
  protected final String TEXT_51 = ".fileName = downloader_";
  protected final String TEXT_52 = ".getResult().getName();" + NL + "\t";
  protected final String TEXT_53 = NL + "\t";
  protected final String TEXT_54 = NL + "\t\t";
  protected final String TEXT_55 = ".content = downloader_";
  protected final String TEXT_56 = ".getInputStream();" + NL + "\t\t";
  protected final String TEXT_57 = ".fileName = downloader_";
  protected final String TEXT_58 = ".getResult().getName();" + NL + "\t";
  protected final String TEXT_59 = "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		
		String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		String accessToken = ElementParameterParser.getValue(node,"__ACCESS_TOKEN__");
	    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	    String connectionKey = "conn_" + connection;
		String dropboxPath = ElementParameterParser.getValue(node, "__PATH__");
		String outputFile = ElementParameterParser.getValue(node, "__OUTPUT__");
		String store2Local = ElementParameterParser.getValue(node, "__STORE_TO_LOCAL__");
		
		List<IMetadataTable> metadatas = node.getMetadataList();
		IMetadataTable metadata = null;
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			metadata = metadatas.get(0);    
	    }
		
		List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
		
        String dataOutputConnection = null;	
	    for(IConnection conn : outputConnections) {
	        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	dataOutputConnection = conn.getName();
	        	break;
	        } // if(conn) end
	    } // for(conns) end

    stringBuffer.append(TEXT_2);
    
if(!"true".equals(useExistingConn)){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
	String useProxy = ElementParameterParser.getValue(node,"__USE_PROXY__");
	if("true".equals(useProxy)){
		String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
		String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
	}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_26);
    
}else{

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(connectionKey);
    stringBuffer.append(TEXT_29);
    
}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(dropboxPath);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(dropboxPath);
    stringBuffer.append(TEXT_38);
    
if ("true".equals(store2Local)) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(outputFile);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
	if (dataOutputConnection != null) {
	
    stringBuffer.append(TEXT_48);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
	}
	
    
} else {

    stringBuffer.append(TEXT_53);
    
	if (dataOutputConnection != null) {
	
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
	}
	
    stringBuffer.append(TEXT_59);
    
}

    return stringBuffer.toString();
  }
}
