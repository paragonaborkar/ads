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

public class TGoogleDriveCopyMainJava
{
  protected static String nl;
  public static synchronized TGoogleDriveCopyMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleDriveCopyMainJava result = new TGoogleDriveCopyMainJava();
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
  protected final String TEXT_28 = NL + NL + "\t\tcom.google.api.services.drive.Drive.Files.List ";
  protected final String TEXT_29 = "_listRequest =  ";
  protected final String TEXT_30 = "_client.files().list();" + NL + "        String destFolderName_";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + "        String fileName_";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ";" + NL + "        if(fileName_";
  protected final String TEXT_36 = " == null || \"\".equals(fileName_";
  protected final String TEXT_37 = ".trim()) || destFolderName_";
  protected final String TEXT_38 = " == null || \"\".equals(destFolderName_";
  protected final String TEXT_39 = ".trim()) )" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"File/folder name can not be null\");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_40 = "_listRequest.setQ(\"trashed = false and title = '\" + ";
  protected final String TEXT_41 = " + \"' and mimeType != 'application/vnd.google-apps.folder'\");";
  protected final String TEXT_42 = NL + "\t\tString sourceFolder_";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = "; " + NL + "\t\tif(sourceFolder_";
  protected final String TEXT_45 = " == null || \"\".equals(sourceFolder_";
  protected final String TEXT_46 = ".trim()) || destFolderName_";
  protected final String TEXT_47 = " == null || \"\".equals(destFolderName_";
  protected final String TEXT_48 = ".trim()) )" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"File/folder name can not be null\");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_49 = "_listRequest.setQ(\"trashed = false and title = '\" + sourceFolder_";
  protected final String TEXT_50 = " + \"' and mimeType = 'application/vnd.google-apps.folder'\");";
  protected final String TEXT_51 = NL + "\t\tcom.google.api.services.drive.model.FileList ";
  protected final String TEXT_52 = "_files = ";
  protected final String TEXT_53 = "_listRequest.execute();" + NL + "\t\tif (";
  protected final String TEXT_54 = "_files.getItems().size() > 1)" + NL + "\t\t{";
  protected final String TEXT_55 = NL + "\t\t\tthrow new Exception(\"More than one file found with name \\\"\" + ";
  protected final String TEXT_56 = " + \"\\\" \");";
  protected final String TEXT_57 = NL + "\t\t\tthrow new Exception(\"More than one folder found with name \\\"\" + ";
  protected final String TEXT_58 = " + \"\\\" \");";
  protected final String TEXT_59 = NL + "\t\t}" + NL + "\t\telse if (";
  protected final String TEXT_60 = "_files.getItems().isEmpty())" + NL + "\t\t{";
  protected final String TEXT_61 = NL + "\t\t\tthrow new Exception(\"No file found with name \\\"\" + ";
  protected final String TEXT_62 = " + \"\\\" \");";
  protected final String TEXT_63 = NL + "\t\t\tthrow new Exception(\"No folder found with name \\\"\" + ";
  protected final String TEXT_64 = " + \"\\\" \");";
  protected final String TEXT_65 = NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\tcom.google.api.services.drive.model.File ";
  protected final String TEXT_66 = "_sourceFile = ";
  protected final String TEXT_67 = "_files.getItems().get(0);" + NL + "\t\t\tString ";
  protected final String TEXT_68 = "_fileId = ";
  protected final String TEXT_69 = "_sourceFile.getId();" + NL + "        \tcom.google.api.services.drive.model.File file = ";
  protected final String TEXT_70 = "_client.files().get(";
  protected final String TEXT_71 = "_fileId).execute();" + NL + "\t\t\tcom.google.api.services.drive.model.File resultFile = new com.google.api.services.drive.model.File();" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_72 = "_listRequest =  ";
  protected final String TEXT_73 = "_client.files().list();" + NL + "\t\t\tcom.google.api.services.drive.model.FileList ";
  protected final String TEXT_74 = "_destFolders = null;" + NL + "\t\t\tString ";
  protected final String TEXT_75 = "_destFolderId = \"root\";" + NL + "\t\t";
  protected final String TEXT_76 = NL + "\t\t\t";
  protected final String TEXT_77 = "_listRequest.setQ(\"trashed = false and title = '\" + ";
  protected final String TEXT_78 = " + \"' and mimeType = 'application/vnd.google-apps.folder'\");" + NL + "\t\t\t";
  protected final String TEXT_79 = "_destFolders = ";
  protected final String TEXT_80 = "_listRequest.execute();" + NL + "\t\t\tif (";
  protected final String TEXT_81 = "_destFolders.getItems().size() > 1)" + NL + "\t\t\t{" + NL + "\t\t\t\tthrow new Exception(\"More than one folder found with name \\\"\" + ";
  protected final String TEXT_82 = " + \"\\\" \");" + NL + "\t\t\t}" + NL + "\t\t\telse if (";
  protected final String TEXT_83 = "_destFolders.getItems().isEmpty())" + NL + "\t\t\t{" + NL + "\t\t\t\tthrow new Exception(\"No folder found with name \\\"\" + ";
  protected final String TEXT_84 = " + \"\\\" \");" + NL + "\t\t\t}" + NL + "\t\t\telse" + NL + "\t\t\t{" + NL + "\t\t\t";
  protected final String TEXT_85 = "_destFolderId = ";
  protected final String TEXT_86 = "_destFolders.getItems().get(0).getId();" + NL + "\t\t";
  protected final String TEXT_87 = " " + NL + "\t\t        com.google.api.services.drive.model.File copiedFile = new com.google.api.services.drive.model.File();" + NL + "\t\t        ";
  protected final String TEXT_88 = NL + "\t\t\t\t\tcopiedFile.setTitle(";
  protected final String TEXT_89 = "); " + NL + "\t\t        ";
  protected final String TEXT_90 = NL + "\t\t        copiedFile.setParents(java.util.Arrays.asList(new com.google.api.services.drive.model.ParentReference().setId(";
  protected final String TEXT_91 = "_destFolderId)));" + NL + "\t\t\t    resultFile = ";
  protected final String TEXT_92 = "_client.files().copy(";
  protected final String TEXT_93 = "_fileId, copiedFile).execute();" + NL + "\t\t        ";
  protected final String TEXT_94 = NL + "\t\t\t\t     ";
  protected final String TEXT_95 = "_client.files().delete(";
  protected final String TEXT_96 = "_fileId).execute();" + NL + "\t\t        ";
  protected final String TEXT_97 = NL + "\t\t\t\t   com.google.api.services.drive.model.File filePatch = new com.google.api.services.drive.model.File();" + NL + "                   filePatch.setTitle(";
  protected final String TEXT_98 = ");" + NL + "                   com.google.api.services.drive.Drive.Files.Patch patchRequest = ";
  protected final String TEXT_99 = "_client.files().patch(";
  protected final String TEXT_100 = "_fileId, filePatch);" + NL + "                   patchRequest.setFields(\"title\");" + NL + "                   patchRequest.execute();" + NL + "\t\t        ";
  protected final String TEXT_101 = NL + "\t\t        if (";
  protected final String TEXT_102 = "_sourceFile.getParents().size() > 1)" + NL + "\t\t        {" + NL + "\t\t        \tthrow new Exception(\"Failed to delete (this folder has more than one parent)\");" + NL + "\t\t        }" + NL + "\t\t\t\tString ";
  protected final String TEXT_103 = "_sourceFolderId = ";
  protected final String TEXT_104 = "_sourceFile.getParents().get(0).getId();" + NL + "               \t";
  protected final String TEXT_105 = "_client.parents().insert(";
  protected final String TEXT_106 = "_fileId, new com.google.api.services.drive.model.ParentReference().setId(";
  protected final String TEXT_107 = "_destFolderId)).execute();" + NL + "\t\t\t   \t";
  protected final String TEXT_108 = "_client.parents().delete(";
  protected final String TEXT_109 = "_fileId, ";
  protected final String TEXT_110 = "_sourceFolderId).execute();" + NL + "\t\t\t   \tresultFile = file;" + NL + "\t\t";
  protected final String TEXT_111 = NL + "\t\t\t";
  protected final String TEXT_112 = ".sourceFileID = ";
  protected final String TEXT_113 = "_fileId;" + NL + "\t\t\t";
  protected final String TEXT_114 = ".destinationFileID =  resultFile.getId();";
  protected final String TEXT_115 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_116 = "_SOURCE_FILEID\", ";
  protected final String TEXT_117 = "_fileId);" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_118 = "_DESTINATION_FILEID\", resultFile.getId());" + NL + "\t";
  protected final String TEXT_119 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_120 = NL + "\t}" + NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
NodeParamsHelper helper = new NodeParamsHelper(node);

String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
String accessToken = helper.getStringParam("__ACCESS_TOKEN__");
String folderID = helper.getStringParam("__FOLDERID__");
boolean useProxy = helper.getBoolParam("__USE_PROXY__");
boolean useSSL = helper.getBoolParam("__USE_SSL__");
boolean isFile = helper.getBoolParam("__FILE_MODE__");

String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
String connectionKey = "\"conn_" + connection+"\"";

List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
		
String dataOutputConnection = null;	
for(IConnection conn : outputConnections) {
    if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    	dataOutputConnection = conn.getName();
    	break;
    } // if(conn) end
} // for(conns) end


String fileName = ElementParameterParser.getValue(node, "__FILE_NAME__");
String folderName = ElementParameterParser.getValue(node, "__FOLDER_NAME__");
String dest_folderName = ElementParameterParser.getValue(node, "__DESTINATION_FOLDER_NAME__");
String dest_fieName = ElementParameterParser.getValue(node,  "__DESTINATION_FILE_NAME__");

boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
boolean rename = "true".equals(ElementParameterParser.getValue(node, "__RENAME__"));
boolean remove = "true".equals(ElementParameterParser.getValue(node, "__REMOVE_SOURCE_FILE__"));


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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(dest_folderName);
    stringBuffer.append(TEXT_32);
    
   if (isFile) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_41);
    } else {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(folderName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    if (isFile) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_56);
    } else {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(folderName);
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    if (isFile) {

    stringBuffer.append(TEXT_61);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_62);
    } else {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(folderName);
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
     if(!dest_folderName.equals("\"root\"")) { 
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(dest_folderName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(dest_folderName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(dest_folderName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
     } 
    
        if (isFile) {
        
    stringBuffer.append(TEXT_87);
    
					if (rename) {
		        
    stringBuffer.append(TEXT_88);
    stringBuffer.append(dest_fieName);
    stringBuffer.append(TEXT_89);
    
				}
		        
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
				if (remove) {
		        
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
				}
		}else{
			    if (rename) {
		        
    stringBuffer.append(TEXT_97);
    stringBuffer.append(dest_fieName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
				}
		        
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    }	

		if(dataOutputConnection != null) {
        
    stringBuffer.append(TEXT_111);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
     if(!dest_folderName.equals("\"root\"")) { 
    stringBuffer.append(TEXT_119);
     } 
    stringBuffer.append(TEXT_120);
    return stringBuffer.toString();
  }
}
