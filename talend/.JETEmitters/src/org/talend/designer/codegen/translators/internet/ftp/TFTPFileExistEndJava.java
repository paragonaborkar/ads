package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPFileExistEndJava
{
  protected static String nl;
  public static synchronized TFTPFileExistEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPFileExistEndJava result = new TFTPFileExistEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\tlog.info(\"";
  protected final String TEXT_3 = " - Closing the connection to the server.\");" + NL + "\t";
  protected final String TEXT_4 = NL + "\tsession_";
  protected final String TEXT_5 = ".disconnect(); " + NL + "\t";
  protected final String TEXT_6 = NL + "\t\tlog.info(\"";
  protected final String TEXT_7 = " - Connection to the server closed.\");" + NL + "\t";
  protected final String TEXT_8 = NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Closing the connection to the server.\");" + NL + "\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\tftp_";
  protected final String TEXT_12 = ".quit();" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Connection to the server closed.\");" + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "      \t\t} catch(java.net.SocketException se_";
  protected final String TEXT_16 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_18 = " - \" + se_";
  protected final String TEXT_19 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_20 = NL + "        \t\t//ignore failure" + NL + "      \t\t}";
  protected final String TEXT_21 = NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_23 = " - Closing the connection to the server.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "      \t\tftp_";
  protected final String TEXT_25 = ".quit();" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Connection to the server closed.\");" + NL + "\t\t\t";
  protected final String TEXT_28 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String remoteDir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String ignoreFailureAtQuit= ElementParameterParser.getValue(node,"__IGNORE_FAILURE_AT_QUIT__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean sftp = false;

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
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

if (sftp && !("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_1);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    }
    
} else {
	if (!("true").equals(useExistingConn)) {
		if (("true").equals(ignoreFailureAtQuit)) {
    
    stringBuffer.append(TEXT_8);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    
    	} else {
    
    stringBuffer.append(TEXT_21);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    }
    
		}
	}
}

    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
