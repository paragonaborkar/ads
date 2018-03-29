package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPFileExistMainJava
{
  protected static String nl;
  public static synchronized TFTPFileExistMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPFileExistMainJava result = new TFTPFileExistMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tString remoteDir_";
  protected final String TEXT_2 = " = ";
  protected final String TEXT_3 = ".replaceAll(\"\\\\\\\\\",\"/\");" + NL + "  " + NL + "\ttry{" + NL + "\t\tif (c_";
  protected final String TEXT_4 = ".stat(";
  protected final String TEXT_5 = " + \"/\" + ";
  protected final String TEXT_6 = ").getAtimeString() != null) {" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_8 = " - '\" + ";
  protected final String TEXT_9 = " + \"' exists in the remote directory '\"+ ";
  protected final String TEXT_10 = " + \"' .\");" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "      \t\tglobalMap.put(\"";
  protected final String TEXT_12 = "_EXISTS\", true);" + NL + "\t\t}" + NL + "\t} catch (java.lang.Exception e) {" + NL + "\t\t";
  protected final String TEXT_13 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_14 = " - '\" + ";
  protected final String TEXT_15 = " + \"' doesn't exist in the remote directory '\"+ ";
  protected final String TEXT_16 = " + \"' .\");" + NL + "\t\t";
  protected final String TEXT_17 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_18 = "_EXISTS\", false);" + NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_19 = "_FILENAME\", ";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\tString remoteDir_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ".replaceAll(\"\\\\\\\\\",\"/\");" + NL + "" + NL + "\tif (ftp_";
  protected final String TEXT_24 = ".exists(";
  protected final String TEXT_25 = " + \"/\" + ";
  protected final String TEXT_26 = ")) {" + NL + "\t\t";
  protected final String TEXT_27 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_28 = " - '\" + ";
  protected final String TEXT_29 = " + \"' exists in the remote directory '\"+ ";
  protected final String TEXT_30 = " + \"' .\");" + NL + "\t\t";
  protected final String TEXT_31 = NL + "    \tglobalMap.put(\"";
  protected final String TEXT_32 = "_EXISTS\", true);" + NL + "\t} else {" + NL + "\t\t";
  protected final String TEXT_33 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_34 = " - '\" + ";
  protected final String TEXT_35 = " + \"' doesn't exist in the remote directory '\"+ ";
  protected final String TEXT_36 = " + \"' .\");" + NL + "\t\t";
  protected final String TEXT_37 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_38 = "_EXISTS\", false);" + NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_39 = "_FILENAME\", ";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String remoteDir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String filename = ElementParameterParser.getValue(node, "__FILENAME__");
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

if (sftp) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_6);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_20);
    } else {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_26);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}
