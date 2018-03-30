package org.talend.designer.codegen.translators.cloud.googledrive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.NodeParamsHelper;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TGoogleDriveCreateMainJava
{
  protected static String nl;
  public static synchronized TGoogleDriveCreateMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleDriveCreateMainJava result = new TGoogleDriveCreateMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "com.google.api.services.drive.Drive ";
  protected final String TEXT_2 = "_client;";
  protected final String TEXT_3 = NL + "{";
  protected final String TEXT_4 = NL + " \tjavax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory" + NL + "\t.getInstance(javax.net.ssl.TrustManagerFactory" + NL + "\t\t\t.getDefaultAlgorithm());" + NL + "" + NL + "\tjava.io.FileInputStream fis = new java.io.FileInputStream(" + NL + "\t\t\t";
  protected final String TEXT_5 = ");" + NL + "\tjava.security.KeyStore ks = java.security.KeyStore" + NL + "\t\t\t.getInstance(java.security.KeyStore.getDefaultType());" + NL + "\t";
  protected final String TEXT_6 = NL + "\t";
  protected final String TEXT_7 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_8 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = "; ";
  protected final String TEXT_13 = NL + "                       " + NL + "\tks.load(fis, decryptedPassword_";
  protected final String TEXT_14 = ".toCharArray());" + NL + "\tfis.close();" + NL + "\ttmf.init(ks);" + NL + "\tjavax.net.ssl.SSLContext sslContext = javax.net.ssl.SSLContext.getInstance(";
  protected final String TEXT_15 = ");" + NL + "\tsslContext.init(null, tmf.getTrustManagers(), new java.security.SecureRandom());";
  protected final String TEXT_16 = NL + "com.google.api.client.http.HttpTransport httpTransport = new com.google.api.client.http.javanet.NetHttpTransport.Builder()";
  protected final String TEXT_17 = NL + "\t\t.setProxy(new java.net.Proxy(java.net.Proxy.Type.HTTP, java.net.InetSocketAddress.createUnresolved(";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = ")))";
  protected final String TEXT_20 = NL + "\t.setSslSocketFactory(sslContext.getSocketFactory())";
  protected final String TEXT_21 = NL + "\t.build();" + NL + "" + NL + "\tcom.google.api.client.googleapis.auth.oauth2.GoogleCredential credential = new com.google.api.client.googleapis.auth.oauth2.GoogleCredential().setAccessToken(";
  protected final String TEXT_22 = ");" + NL + "\t";
  protected final String TEXT_23 = "_client = new  com.google.api.services.drive.Drive.Builder(httpTransport, new com.google.api.client.json.jackson2.JacksonFactory(), credential)" + NL + "\t.setApplicationName(";
  protected final String TEXT_24 = "+\" \"+jobName+\"/\"+jobVersion+\" (GPN:Talend)\").build();" + NL + "}\t";
  protected final String TEXT_25 = NL + "\t";
  protected final String TEXT_26 = "_client = (com.google.api.services.drive.Drive)globalMap.get(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\t\tString parentFolder_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = ";" + NL + "\t\tif(parentFolder_";
  protected final String TEXT_31 = " == null || \"\".equals(parentFolder_";
  protected final String TEXT_32 = ".trim()))" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"Parent Folder Name can not be null\");" + NL + "\t\t}" + NL + "" + NL + "        com.google.api.services.drive.model.File ";
  protected final String TEXT_33 = "_createdFolder = new com.google.api.services.drive.model.File();" + NL + "\t\tcom.google.api.services.drive.model.File ";
  protected final String TEXT_34 = "_resultFile = null;" + NL + "\t\tcom.google.api.services.drive.Drive.Files.List ";
  protected final String TEXT_35 = "_listRequest =  ";
  protected final String TEXT_36 = "_client.files().list();" + NL + "\t\tString parentFolderId_";
  protected final String TEXT_37 = " = \"root\";" + NL + "\t\t";
  protected final String TEXT_38 = NL + "\t\t";
  protected final String TEXT_39 = "_listRequest.setQ(\"title = '\" + ";
  protected final String TEXT_40 = " + \"' and mimeType = 'application/vnd.google-apps.folder'\");" + NL + "\t\tcom.google.api.services.drive.model.FileList ";
  protected final String TEXT_41 = "_files = ";
  protected final String TEXT_42 = "_listRequest.execute();" + NL + "\t\t" + NL + "\t\tif (";
  protected final String TEXT_43 = "_files.getItems().size() > 1)" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"More than one folder found with name \\\"\" + ";
  protected final String TEXT_44 = " + \"\\\" \");" + NL + "\t\t}" + NL + "\t\telse if (";
  protected final String TEXT_45 = "_files.getItems().isEmpty())" + NL + "\t\t{" + NL + "\t\t\tSystem.out.println(\"No folder found with name \\\"\" + ";
  protected final String TEXT_46 = " + \"\\\",the folder will be created in the default root folder.\");" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\tcom.google.api.services.drive.model.File newParentFolder_";
  protected final String TEXT_48 = " = new com.google.api.services.drive.model.File();" + NL + "\t\t    newParentFolder_";
  protected final String TEXT_49 = ".setParents(new java.util.ArrayList<com.google.api.services.drive.model.ParentReference>());" + NL + "\t\t    newParentFolder_";
  protected final String TEXT_50 = ".setMimeType(\"application/vnd.google-apps.folder\"); " + NL + "\t\t\tnewParentFolder_";
  protected final String TEXT_51 = ".setTitle(";
  protected final String TEXT_52 = ");" + NL + "\t\t\t";
  protected final String TEXT_53 = "_resultFile = ";
  protected final String TEXT_54 = "_client.files().insert(newParentFolder_";
  protected final String TEXT_55 = ").execute();" + NL + "\t\t\tparentFolderId_";
  protected final String TEXT_56 = " = ";
  protected final String TEXT_57 = "_resultFile.getId();" + NL + "\t\t}" + NL + "" + NL + "\t\tif(null == parentFolderId_";
  protected final String TEXT_58 = "){" + NL + "\t\t\tparentFolderId_";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = "_files.getItems().get(0).getId();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_61 = NL + "\t\t" + NL + "\t\tString subFolderId_";
  protected final String TEXT_62 = " = null;" + NL + "\t\tString subFolderName_";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = ";" + NL + "\t\tif(null != subFolderName_";
  protected final String TEXT_65 = " && !\"\".equals(subFolderName_";
  protected final String TEXT_66 = ".trim())){" + NL + "\t\t\t";
  protected final String TEXT_67 = NL + "\t        ";
  protected final String TEXT_68 = "_createdFolder.setParents(java.util.Arrays.asList(new com.google.api.services.drive.model.ParentReference().setId(parentFolderId_";
  protected final String TEXT_69 = ")));" + NL + "\t        ";
  protected final String TEXT_70 = "_createdFolder.setMimeType(\"application/vnd.google-apps.folder\"); " + NL + "\t    \t";
  protected final String TEXT_71 = "_createdFolder.setTitle(subFolderName_";
  protected final String TEXT_72 = "); " + NL + "" + NL + "\t        ";
  protected final String TEXT_73 = "_resultFile = ";
  protected final String TEXT_74 = "_client.files().insert(";
  protected final String TEXT_75 = "_createdFolder).execute();" + NL + "\t        subFolderId_";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = "_resultFile.getId();" + NL + "\t\t}";
  protected final String TEXT_78 = NL + "\t\t\t";
  protected final String TEXT_79 = ".parentFolderID = parentFolderId_";
  protected final String TEXT_80 = ";" + NL + "\t\t\t";
  protected final String TEXT_81 = ".newFolderID = subFolderId_";
  protected final String TEXT_82 = ";";
  protected final String TEXT_83 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_84 = "_PARENTFOLDERID\", parentFolderId_";
  protected final String TEXT_85 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_86 = "_NEWFOLDERID\", subFolderId_";
  protected final String TEXT_87 = ");" + NL;
  protected final String TEXT_88 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
NodeParamsHelper helper = new NodeParamsHelper(node);

String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
String accessToken = helper.getStringParam("__ACCESS_TOKEN__");
String folderName = helper.getStringParam("__FOLDER_NAME__");
boolean useProxy = helper.getBoolParam("__USE_PROXY__");
boolean useSSL = helper.getBoolParam("__USE_SSL__");

String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
String connectionKey = "\"conn_" + connection+"\"";

List<? extends IConnection> outputConnections = node.getOutgoingSortedConnections();

String dataOutputConnection = null;
    for(IConnection conn : outputConnections) {
        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        	dataOutputConnection = conn.getName();
        	break;
        }
    }


String newFolderName = ElementParameterParser.getValue(node, "__NEW_FOLDER_NAME__");

boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
if(!"true".equals(useExistingConn)){

    stringBuffer.append(TEXT_3);
    
if(useSSL) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(helper.getStringParam("__SSL_TRUST_STORE__"));
    stringBuffer.append(TEXT_5);
    String passwordFieldName = "__SSL_TRUST_STORE_PASSWORD__";
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
    stringBuffer.append(helper.getStringParam("__SSL_ALGORITHM__"));
    stringBuffer.append(TEXT_15);
    	
}

    stringBuffer.append(TEXT_16);
    if(useProxy){
String proxyHost = helper.getStringParam("__PROXY_HOST__");
String proxyPort = helper.getStringParam("__PROXY_PORT__");

    stringBuffer.append(TEXT_17);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_19);
    }
  if(useSSL) {

    stringBuffer.append(TEXT_20);
    
  }

    stringBuffer.append(TEXT_21);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(helper.getStringParam("__APPLICATION_NAME__"));
    stringBuffer.append(TEXT_24);
    
} else {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(connectionKey);
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(folderName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_37);
     if (!folderName.equals("\"root\"")) { 
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(folderName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(folderName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(folderName);
    stringBuffer.append(TEXT_46);
     /* Create the parent folder in the default root folder. */ 
    stringBuffer.append(TEXT_47);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( folderName );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
     }
    stringBuffer.append(TEXT_61);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( newFolderName );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_66);
     /* Create a sub folder in the specified parent folder.*/ 
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
		if(dataOutputConnection != null) {
        
    stringBuffer.append(TEXT_78);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_79);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_81);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(TEXT_88);
    return stringBuffer.toString();
  }
}
