package org.talend.designer.codegen.translators.business.alfresco_deprecated_;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;

public class TAlfrescoOutputBeginJava
{
  protected static String nl;
  public static synchronized TAlfrescoOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAlfrescoOutputBeginJava result = new TAlfrescoOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "        " + NL + "      fr.openwide.talendalfresco.acpxml.TalendAcpXmlWriter talendAcpXmlWriter_";
  protected final String TEXT_3 = " = new fr.openwide.talendalfresco.acpxml.TalendAcpXmlWriter();" + NL + "      boolean whetherReject_";
  protected final String TEXT_4 = " = false;" + NL + "    \t";
  protected final String TEXT_5 = NL + "      talendAcpXmlWriter_";
  protected final String TEXT_6 = ".setRestEncoding(";
  protected final String TEXT_7 = ");" + NL + "      " + NL + "      talendAcpXmlWriter_";
  protected final String TEXT_8 = ".setAlfrescoType(\"";
  protected final String TEXT_9 = "\");" + NL + "      talendAcpXmlWriter_";
  protected final String TEXT_10 = ".setAlfrescoAspects(new java.util.ArrayList<String>() { {";
  protected final String TEXT_11 = NL + "\t         add(\"";
  protected final String TEXT_12 = "\");" + NL + "\t         ";
  protected final String TEXT_13 = NL + "         } });" + NL + "      if (";
  protected final String TEXT_14 = ") {" + NL + "      \ttalendAcpXmlWriter_";
  protected final String TEXT_15 = ".setContainerType(\"";
  protected final String TEXT_16 = "\");" + NL + "      \ttalendAcpXmlWriter_";
  protected final String TEXT_17 = ".setContainerChildAssociationType(\"";
  protected final String TEXT_18 = "\");" + NL + "      }" + NL + "      talendAcpXmlWriter_";
  protected final String TEXT_19 = ".setConfigurePermission(";
  protected final String TEXT_20 = ");" + NL + "      if (";
  protected final String TEXT_21 = ") {" + NL + "\t      talendAcpXmlWriter_";
  protected final String TEXT_22 = ".setPermissionOnDocumentAndNotContainer(";
  protected final String TEXT_23 = ");" + NL + "\t      talendAcpXmlWriter_";
  protected final String TEXT_24 = ".setInheritPermissions(";
  protected final String TEXT_25 = ");" + NL + "      }" + NL + "      " + NL + "      try {" + NL + "         talendAcpXmlWriter_";
  protected final String TEXT_26 = ".start();";
  protected final String TEXT_27 = " " + NL + "\t         talendAcpXmlWriter_";
  protected final String TEXT_28 = ".writeNamespace(\"";
  protected final String TEXT_29 = "\", \"";
  protected final String TEXT_30 = "\");" + NL + "\t         ";
  protected final String TEXT_31 = " " + NL + "      } catch (fr.openwide.talendalfresco.acpxml.AcpXmlException e) {" + NL + "         throw new fr.openwide.talendalfresco.rest.client.RestClientException(\"Error creating XML result\", e);" + NL + "      }" + NL + "      " + NL + "\t  fr.openwide.talendalfresco.rest.client.AlfrescoRestClient alfrescoRestClient_";
  protected final String TEXT_32 = " = null;" + NL + "      try {" + NL + "\t      alfrescoRestClient_";
  protected final String TEXT_33 = " = new fr.openwide.talendalfresco.rest.client.AlfrescoRestClient(";
  protected final String TEXT_34 = ", ";
  protected final String TEXT_35 = ");" + NL + "\t      alfrescoRestClient_";
  protected final String TEXT_36 = ".setTimeout(5000);" + NL + "\t      // default server : localhost" + NL + "\t      ";
  protected final String TEXT_37 = NL + "        ";
  protected final String TEXT_38 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_39 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = "; ";
  protected final String TEXT_44 = NL + "\t\t\t      " + NL + "\t      " + NL + "          alfrescoRestClient_";
  protected final String TEXT_45 = ".login(";
  protected final String TEXT_46 = ", decryptedPassword_";
  protected final String TEXT_47 = ");" + NL + "      } catch (fr.openwide.talendalfresco.rest.client.RestClientException e) {" + NL + "         throw new fr.openwide.talendalfresco.rest.client.RestClientException(\"Error initing client\", e);" + NL + "      }" + NL + "      " + NL + "      int nbLine_";
  protected final String TEXT_48 = " = 0;" + NL + "\t  int nb_line_rejected_";
  protected final String TEXT_49 = " = 0;" + NL + "            ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// 1. in begin.javajet, we output the part of the acp xml up to its documents (i.e. rows)

CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    
    	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
    	
	    // getting useful parameters
	    String alfrescoServerUrl = ElementParameterParser.getValue(node, "__ALFRESCO_SERVER_URL__");
	    String alfrescoUserLogin = ElementParameterParser.getValue(node, "__ALFRESCO_USER_LOGIN__");
    	
        String restEncodingString = ElementParameterParser.getValue(node, "__REST_ENCODING__");
        
	    
	    List<Map<String, String>> alfrescoNamespaces = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__AVAILABLE_ALFRESCO_NAMESPACES__");
	    String alfrescoType = ElementParameterParser.getValue(node, "__ALFRESCO_TYPE_NAME__");
	    List<Map<String, String>> alfrescoAspects = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ALFRESCO_ASPECT_NAMES__");
	    
	    boolean configureTargetLocationContainer = Boolean.valueOf(ElementParameterParser.getValue(node, "__CONFIGURE_TARGET_LOCATION_CONTAINER__"));
	    String targetLocationContainerType = ElementParameterParser.getValue(node, "__TARGET_LOCATION_CONTAINER_TYPE__");
	    String targetLocationChildAssociationType = ElementParameterParser.getValue(node, "__TARGET_LOCATION_CHILD_ASSOCIATION_TYPE__");
	    
	    boolean configurePermissions = Boolean.valueOf(ElementParameterParser.getValue(node, "__CONFIGURE_PERMISSIONS__"));
	    String permissionsTarget = ElementParameterParser.getValue(node, "__PERMISSIONS_TARGET__");
	    boolean permissionOnDocumentAndNotContainer = "Document".equals(permissionsTarget);
	    boolean inheritPermissions = Boolean.valueOf(ElementParameterParser.getValue(node, "__INHERIT_PERMISSIONS__"));
	    
        
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(restEncodingString);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(alfrescoType);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
         for (Map<String, String> alfrescoAspect : alfrescoAspects) {
             String alfrescoAspectName = alfrescoAspect.get("NAME");
	         
    stringBuffer.append(TEXT_11);
    stringBuffer.append(alfrescoAspectName);
    stringBuffer.append(TEXT_12);
    
         }
         
    stringBuffer.append(TEXT_13);
    stringBuffer.append(configureTargetLocationContainer);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(targetLocationContainerType);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(targetLocationChildAssociationType);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(configurePermissions);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(configurePermissions);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(permissionOnDocumentAndNotContainer);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(inheritPermissions);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
         for (Map<String, String> alfrescoNamespace : alfrescoNamespaces) {
            String contentNsPrefix = alfrescoNamespace.get("PREFIX");
            String contentNsUri = alfrescoNamespace.get("URI");
	         
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(contentNsPrefix);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(contentNsUri);
    stringBuffer.append(TEXT_30);
    
         }
         
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(alfrescoServerUrl);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(restEncodingString);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
          String passwordFieldName = "__ALFRESCO_USER_PASSWORD__";
          
    stringBuffer.append(TEXT_37);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_40);
    } else {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(alfrescoUserLogin);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
        
        
    }
}

    return stringBuffer.toString();
  }
}
