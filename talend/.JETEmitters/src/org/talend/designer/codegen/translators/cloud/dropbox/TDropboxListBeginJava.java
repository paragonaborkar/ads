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

public class TDropboxListBeginJava
{
  protected static String nl;
  public static synchronized TDropboxListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDropboxListBeginJava result = new TDropboxListBeginJava();
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
  protected final String TEXT_30 = NL + "\tString dropboxPath_";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = ";" + NL + "\t// new API v2 expects root folder to be \"\", not \"/\" as was before in v1 API" + NL + "\tif (\"/\".equals(dropboxPath_";
  protected final String TEXT_33 = ")) {" + NL + "\t\tdropboxPath_";
  protected final String TEXT_34 = " = \"\";" + NL + "\t}" + NL + "" + NL + "\tcom.dropbox.core.v2.files.DbxUserFilesRequests filesClient_";
  protected final String TEXT_35 = " = client_";
  protected final String TEXT_36 = ".files();" + NL + "\tcom.dropbox.core.v2.files.ListFolderBuilder listBuilder_";
  protected final String TEXT_37 = " = filesClient_";
  protected final String TEXT_38 = ".listFolderBuilder(dropboxPath_";
  protected final String TEXT_39 = ").withRecursive(";
  protected final String TEXT_40 = ");" + NL + "\tcom.dropbox.core.v2.files.ListFolderResult listResult_";
  protected final String TEXT_41 = " = null;" + NL + "\ttry {" + NL + "\t\tlistResult_";
  protected final String TEXT_42 = " = listBuilder_";
  protected final String TEXT_43 = ".start();" + NL + "\t} catch (com.dropbox.core.v2.files.ListFolderErrorException e_";
  protected final String TEXT_44 = ") {" + NL + "\t\tthrow new Exception(\"No File or Directory found at \" + ";
  protected final String TEXT_45 = ");" + NL + "\t}" + NL + "\t" + NL + "\tfor (com.dropbox.core.v2.files.Metadata metadata_";
  protected final String TEXT_46 = " : listResult_";
  protected final String TEXT_47 = ".getEntries()) {" + NL + "\t\tif (metadata_";
  protected final String TEXT_48 = " instanceof com.dropbox.core.v2.files.FolderMetadata) {";
  protected final String TEXT_49 = NL + "\t\t\t\tcontinue;";
  protected final String TEXT_50 = "\t\t\t\t\t" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_51 = "_IS_FILE\", false);";
  protected final String TEXT_52 = NL + "        }" + NL + "\t\tif (metadata_";
  protected final String TEXT_53 = " instanceof com.dropbox.core.v2.files.FileMetadata) {";
  protected final String TEXT_54 = NL + "\t\t\t\tcontinue;";
  protected final String TEXT_55 = NL + "\t\t\t\tcom.dropbox.core.v2.files.FileMetadata file_";
  protected final String TEXT_56 = " = (com.dropbox.core.v2.files.FileMetadata) metadata_";
  protected final String TEXT_57 = ";" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_58 = "_LAST_MODIFIED\", file_";
  protected final String TEXT_59 = ".getServerModified().getTime());" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_60 = "_SIZE\", file_";
  protected final String TEXT_61 = ".getSize());" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_62 = "_IS_FILE\", true);";
  protected final String TEXT_63 = "\t\t\t" + NL + "        }" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_64 = "_NAME\", metadata_";
  protected final String TEXT_65 = ".getName());" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_66 = "_PATH\", metadata_";
  protected final String TEXT_67 = ".getPathDisplay());";

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
	String includeSubDir = ElementParameterParser.getValue(node, "__INCLUDSUBDIR__");
	String listMode = ElementParameterParser.getValue(node, "__LIST_MODE__");

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
    stringBuffer.append(path);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(includeSubDir);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
			if("FILES".equals(listMode)) {

    stringBuffer.append(TEXT_49);
    
			} else {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
			}

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
			if("DIRECTORIES".equals(listMode)) {

    stringBuffer.append(TEXT_54);
    
			} else {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
			}

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    return stringBuffer.toString();
  }
}
