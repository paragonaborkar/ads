package org.talend.designer.codegen.translators.business.alfresco_deprecated_;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;

public class TAlfrescoOutputEndJava
{
  protected static String nl;
  public static synchronized TAlfrescoOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAlfrescoOutputEndJava result = new TAlfrescoOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        " + NL + "      try {" + NL + "         talendAcpXmlWriter_";
  protected final String TEXT_3 = ".close();" + NL + "      } catch (fr.openwide.talendalfresco.acpxml.AcpXmlException e) {";
  protected final String TEXT_4 = NL + "         throw new fr.openwide.talendalfresco.rest.client.RestClientException(\"Error creating XML result\", e);";
  protected final String TEXT_5 = NL + "\t\t System.err.println(\"Error creating XML result.\");";
  protected final String TEXT_6 = NL + "      }" + NL + "      " + NL + "      String content_";
  protected final String TEXT_7 = " = talendAcpXmlWriter_";
  protected final String TEXT_8 = ".toString();" + NL + "      ByteArrayInputStream acpXmlIs_";
  protected final String TEXT_9 = " = new ByteArrayInputStream(content_";
  protected final String TEXT_10 = ".getBytes());" + NL + "      " + NL + "      fr.openwide.talendalfresco.rest.client.ClientImportCommand importCmd_";
  protected final String TEXT_11 = " = new fr.openwide.talendalfresco.rest.client.ClientImportCommand(\"";
  protected final String TEXT_12 = "\", acpXmlIs_";
  protected final String TEXT_13 = ");" + NL + "      importCmd_";
  protected final String TEXT_14 = ".setDocumentMode(\"";
  protected final String TEXT_15 = "\");" + NL + "      importCmd_";
  protected final String TEXT_16 = ".setContainerMode(\"";
  protected final String TEXT_17 = "\");" + NL + "   " + NL + "      // Execute the command." + NL + "      try {" + NL + "      \talfrescoRestClient_";
  protected final String TEXT_18 = ".execute(importCmd_";
  protected final String TEXT_19 = ");" + NL + "      } catch (fr.openwide.talendalfresco.rest.client.RestClientException e_";
  protected final String TEXT_20 = ") {";
  protected final String TEXT_21 = NL + "         throw new fr.openwide.talendalfresco.rest.client.RestClientException(\"Error execute import command\", e_";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\t\t System.err.println(\"Error execute import command.\");";
  protected final String TEXT_24 = NL + "      }" + NL + "    " + NL + "      // logout" + NL + "      try {" + NL + "      \talfrescoRestClient_";
  protected final String TEXT_25 = ".logout();" + NL + "      } catch (fr.openwide.talendalfresco.rest.client.RestClientException e) {";
  protected final String TEXT_26 = NL + "         throw new fr.openwide.talendalfresco.rest.client.RestClientException(\"Error initing client\", e);";
  protected final String TEXT_27 = NL + "\t\t System.err.println(\"Error initing client.\");";
  protected final String TEXT_28 = NL + "      }" + NL + "      " + NL + "      // setting global var NB_LINE for further components" + NL + "      globalMap.put(\"";
  protected final String TEXT_29 = "_NB_LINE\", nbLine_";
  protected final String TEXT_30 = ");" + NL + "      globalMap.put(\"";
  protected final String TEXT_31 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_32 = ");" + NL + "      " + NL + "      // handling result logs" + NL + "      System.out.println(importCmd_";
  protected final String TEXT_33 = ".toString() + \" \" + importCmd_";
  protected final String TEXT_34 = ".getResultMessage() + \" \" + importCmd_";
  protected final String TEXT_35 = ".getResultError());" + NL + "      " + NL + "    java.io.File resultLogFile_";
  protected final String TEXT_36 = " = new java.io.File(";
  protected final String TEXT_37 = ");" + NL + "    java.io.BufferedWriter resultLogOut_";
  protected final String TEXT_38 = " = new java.io.BufferedWriter(" + NL + "            new java.io.OutputStreamWriter(new java.io.FileOutputStream(resultLogFile_";
  protected final String TEXT_39 = ")));" + NL + "      for (String[] resultLog_";
  protected final String TEXT_40 = " : importCmd_";
  protected final String TEXT_41 = ".getResultLogs()) {" + NL + "         String successOrError_";
  protected final String TEXT_42 = " = resultLog_";
  protected final String TEXT_43 = "[0];" + NL + "         resultLogOut_";
  protected final String TEXT_44 = ".write(successOrError_";
  protected final String TEXT_45 = "); // success or error" + NL + "         resultLogOut_";
  protected final String TEXT_46 = ".write(\";\");" + NL + "         resultLogOut_";
  protected final String TEXT_47 = ".write(resultLog_";
  protected final String TEXT_48 = "[1]); // namepath" + NL + "         resultLogOut_";
  protected final String TEXT_49 = ".write(\";\");" + NL + "         String message_";
  protected final String TEXT_50 = " = resultLog_";
  protected final String TEXT_51 = "[2];" + NL + "         if (message_";
  protected final String TEXT_52 = " != null) {" + NL + "         \tif (!\"success\".equals(successOrError_";
  protected final String TEXT_53 = ")) {" + NL + "         \t\tmessage_";
  protected final String TEXT_54 = " = message_";
  protected final String TEXT_55 = ".replaceAll(\";\", \",\").replaceAll(\"\\n\", \"   \");" + NL + "         \t}" + NL + "         \tresultLogOut_";
  protected final String TEXT_56 = ".write(message_";
  protected final String TEXT_57 = "); // message" + NL + "         \tresultLogOut_";
  protected final String TEXT_58 = ".write(\";\");" + NL + "         }" + NL + "         resultLogOut_";
  protected final String TEXT_59 = ".write(resultLog_";
  protected final String TEXT_60 = "[3]); // date" + NL + "         resultLogOut_";
  protected final String TEXT_61 = ".write(\";\");" + NL + "         if (resultLog_";
  protected final String TEXT_62 = "[4] != null) {" + NL + "         \tresultLogOut_";
  protected final String TEXT_63 = ".write(resultLog_";
  protected final String TEXT_64 = "[4]); // noderef" + NL + "         \tresultLogOut_";
  protected final String TEXT_65 = ".write(\";\");" + NL + "         }" + NL + "         if (resultLog_";
  protected final String TEXT_66 = "[5] != null) {" + NL + "         \tresultLogOut_";
  protected final String TEXT_67 = ".write(resultLog_";
  protected final String TEXT_68 = "[5]); // doctype" + NL + "         }" + NL + "         resultLogOut_";
  protected final String TEXT_69 = ".write(\"\\n\");" + NL + "      }" + NL + "    resultLogOut_";
  protected final String TEXT_70 = ".close();" + NL + "    " + NL + "    System.out.println(\"Result (log file \" + ";
  protected final String TEXT_71 = " + \") :\\n\");" + NL + "    java.io.BufferedReader resultLogIn_";
  protected final String TEXT_72 = " = new java.io.BufferedReader(" + NL + "            new java.io.InputStreamReader(new java.io.FileInputStream(resultLogFile_";
  protected final String TEXT_73 = ")));" + NL + "    String resultLogInLine_";
  protected final String TEXT_74 = ";" + NL + "    while  ((resultLogInLine_";
  protected final String TEXT_75 = " = resultLogIn_";
  protected final String TEXT_76 = ".readLine()) != null) {" + NL + "    \tSystem.out.println(resultLogInLine_";
  protected final String TEXT_77 = ");" + NL + "    }" + NL + "    resultLogIn_";
  protected final String TEXT_78 = ".close();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// 3. in end.javajet, we output the last part of the acp xml after to its documents (i.e. rows),
// then call the alfresco server with it as a parameter, then handle the returned result
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        
        // getting useful parameters
	    String targetLocationBase = ElementParameterParser.getValue(node, "__TARGET_LOCATION_BASE__");
	    
	    String documentMode = ElementParameterParser.getValue(node, "__DOCUMENT_MODE__");
	    String containerMode = ElementParameterParser.getValue(node, "__CONTAINER_MODE__");
        
	    String resultLogFilenameString = ElementParameterParser.getValue(node, "__RESULT_LOG_FILENAME__");
	    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
        
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_4);
    
		} else {

    stringBuffer.append(TEXT_5);
    
		}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(targetLocationBase);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(documentMode);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(containerMode);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
		} else {

    stringBuffer.append(TEXT_23);
    
		}

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_26);
    
		} else {

    stringBuffer.append(TEXT_27);
    
		}

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(resultLogFilenameString);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
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
    stringBuffer.append(resultLogFilenameString);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
        
        
    }
}

    return stringBuffer.toString();
  }
}
