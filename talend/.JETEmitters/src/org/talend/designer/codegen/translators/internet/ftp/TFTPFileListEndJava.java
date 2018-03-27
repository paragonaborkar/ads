package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPFileListEndJava
{
  protected static String nl;
  public static synchronized TFTPFileListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPFileListEndJava result = new TFTPFileListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "}";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t\tlog.info(\"";
  protected final String TEXT_4 = " - Closing the connection to the server.\");" + NL + "\t";
  protected final String TEXT_5 = NL + "\tsession_";
  protected final String TEXT_6 = ".disconnect(); " + NL + "\t";
  protected final String TEXT_7 = NL + "\t\tlog.info(\"";
  protected final String TEXT_8 = " - Connection to the server closed.\");" + NL + "\t";
  protected final String TEXT_9 = "  ";
  protected final String TEXT_10 = NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_12 = " - Closing the connection to the server.\");" + NL + "\t\t\t\t";
  protected final String TEXT_13 = "      " + NL + "        \t\tftp_";
  protected final String TEXT_14 = ".quit();" + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_16 = " - Connection to the server closed.\");" + NL + "\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t} catch (java.net.SocketException se_";
  protected final String TEXT_18 = ") {" + NL + "\t        //ignore failure" + NL + "\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_20 = " - \" + se_";
  protected final String TEXT_21 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_22 = NL + "    \t\t}";
  protected final String TEXT_23 = NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_25 = " - Closing the connection to the server.\");" + NL + "\t\t\t";
  protected final String TEXT_26 = "    " + NL + "\t\t\tftp_";
  protected final String TEXT_27 = ".quit();" + NL + "\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_29 = " - Connection to the server closed.\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "globalMap.put(\"";
  protected final String TEXT_31 = "_NB_FILE\",nb_file_";
  protected final String TEXT_32 = ");" + NL;
  protected final String TEXT_33 = NL + "\tlog.info(\"";
  protected final String TEXT_34 = " - Listed files count: \" + nb_file_";
  protected final String TEXT_35 = "  + \".\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String ignoreFailureAtQuit= ElementParameterParser.getValue(node,"__IGNORE_FAILURE_AT_QUIT__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
boolean sftp = false;

if (("true").equals(useExistingConn)) {
  List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();

  for (INode n : nodeList) {
    if (n.getUniqueName().equals(connection)) {
      sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
    }
  }
} else {
  sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
}

if (sftp && !("true").equals(useExistingConn)) {// *** sftp *** //

    stringBuffer.append(TEXT_2);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
} else {// *** ftp *** //

	if (!("true").equals(useExistingConn)) {
		if (("true").equals(ignoreFailureAtQuit)) {
    
    stringBuffer.append(TEXT_10);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    
		} else {
    
    stringBuffer.append(TEXT_23);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    }
    
    	}
	}
}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    }
    return stringBuffer.toString();
  }
}
