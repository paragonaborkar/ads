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

public class TDropboxDeleteMainJava
{
  protected static String nl;
  public static synchronized TDropboxDeleteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDropboxDeleteMainJava result = new TDropboxDeleteMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\tcom.dropbox.core.DbxRequestConfig.Builder configBuilder_";
  protected final String TEXT_4 = " = com.dropbox.core.DbxRequestConfig.newBuilder(\"";
  protected final String TEXT_5 = "\");" + NL + "\t\tString localeName_";
  protected final String TEXT_6 = " = java.util.Locale.getDefault().toString();" + NL + "\t\tconfigBuilder_";
  protected final String TEXT_7 = ".withUserLocale(localeName_";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\t\t\tjava.net.InetSocketAddress socketAddress_";
  protected final String TEXT_10 = " = new java.net.InetSocketAddress(";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = ");" + NL + "\t\t\tjava.net.Proxy proxy_";
  protected final String TEXT_13 = " = new java.net.Proxy(java.net.Proxy.Type.HTTP, socketAddress_";
  protected final String TEXT_14 = ");" + NL + "\t\t\tcom.dropbox.core.http.StandardHttpRequestor.Config config_";
  protected final String TEXT_15 = " = com.dropbox.core.http.StandardHttpRequestor.Config.builder().withNoConnectTimeout().withProxy(proxy_";
  protected final String TEXT_16 = ").build();" + NL + "\t\t\tcom.dropbox.core.http.HttpRequestor httpRequestor_";
  protected final String TEXT_17 = " = new com.dropbox.core.http.StandardHttpRequestor(config_";
  protected final String TEXT_18 = ");" + NL + "\t\t\tconfigBuilder_";
  protected final String TEXT_19 = ".withHttpRequestor(httpRequestor_";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\tcom.dropbox.core.DbxRequestConfig dbxConfig_";
  protected final String TEXT_22 = " = configBuilder_";
  protected final String TEXT_23 = ".build();" + NL + "\t\tcom.dropbox.core.v2.DbxClientV2 client_";
  protected final String TEXT_24 = " = new com.dropbox.core.v2.DbxClientV2(dbxConfig_";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\t\tcom.dropbox.core.v2.DbxClientV2 client_";
  protected final String TEXT_28 = " = (com.dropbox.core.v2.DbxClientV2) globalMap.get(\"";
  protected final String TEXT_29 = "\");";
  protected final String TEXT_30 = NL + "\tcom.dropbox.core.v2.files.DbxUserFilesRequests filesClient_";
  protected final String TEXT_31 = " = client_";
  protected final String TEXT_32 = ".files();" + NL + "\ttry {" + NL + "\t\tfilesClient_";
  protected final String TEXT_33 = ".delete(";
  protected final String TEXT_34 = ");" + NL + "\t} catch (com.dropbox.core.v2.files.DeleteErrorException e_";
  protected final String TEXT_35 = ") {" + NL + "\t\tthrow new Exception(";
  protected final String TEXT_36 = " + \" is not a valid file path on Dropbox\");" + NL + "\t}";

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
		String path = ElementParameterParser.getValue(node, "__PATH__");

    stringBuffer.append(TEXT_2);
    
	if (!"true".equals(useExistingConn)) {

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
		if ("true".equals(useProxy)) {
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
    
	} else {

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
    stringBuffer.append(path);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}
