package org.talend.designer.codegen.translators.cloud.dropbox;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TDropboxConnectionBeginJava
{
  protected static String nl;
  public static synchronized TDropboxConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDropboxConnectionBeginJava result = new TDropboxConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\tcom.dropbox.core.DbxRequestConfig.Builder configBuilder_";
  protected final String TEXT_3 = " = com.dropbox.core.DbxRequestConfig.newBuilder(";
  protected final String TEXT_4 = ");" + NL + "\tconfigBuilder_";
  protected final String TEXT_5 = ".withUserLocale(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\tjava.net.InetSocketAddress socketAddress_";
  protected final String TEXT_8 = " = new java.net.InetSocketAddress(";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ");" + NL + "\tjava.net.Proxy proxy_";
  protected final String TEXT_11 = " = new java.net.Proxy(java.net.Proxy.Type.HTTP, socketAddress_";
  protected final String TEXT_12 = ");" + NL + "\tcom.dropbox.core.http.StandardHttpRequestor.Config config_";
  protected final String TEXT_13 = " = com.dropbox.core.http.StandardHttpRequestor.Config.builder().withNoConnectTimeout().withProxy(proxy_";
  protected final String TEXT_14 = ").build();" + NL + "\tcom.dropbox.core.http.HttpRequestor httpRequestor_";
  protected final String TEXT_15 = " = new com.dropbox.core.http.StandardHttpRequestor(config_";
  protected final String TEXT_16 = ");" + NL + "\tconfigBuilder_";
  protected final String TEXT_17 = ".withHttpRequestor(httpRequestor_";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\tcom.dropbox.core.DbxRequestConfig dbxConfig_";
  protected final String TEXT_20 = " = configBuilder_";
  protected final String TEXT_21 = ".build();" + NL + "\tcom.dropbox.core.v2.DbxClientV2 client_";
  protected final String TEXT_22 = " = new com.dropbox.core.v2.DbxClientV2(dbxConfig_";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = ");" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_25 = "\", client_";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		
		String accessToken = ElementParameterParser.getValue(node, "__ACCESS_TOKEN__");
		
		String useProxy = ElementParameterParser.getValue(node, "__USE_PROXY__");
		String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
		String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
		
		String clientIdentifier = "\""+cid+"\"";
		
		String localeName = "\""+java.util.Locale.getDefault().toString()+"\"";
		

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(clientIdentifier);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(localeName);
    stringBuffer.append(TEXT_6);
    if ("true".equals(useProxy)) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
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
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(TEXT_27);
    return stringBuffer.toString();
  }
}
