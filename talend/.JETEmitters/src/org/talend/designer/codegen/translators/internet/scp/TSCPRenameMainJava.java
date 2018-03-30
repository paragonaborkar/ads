package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSCPRenameMainJava
{
  protected static String nl;
  public static synchronized TSCPRenameMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPRenameMainJava result = new TSCPRenameMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t" + NL + "\t//initial the command" + NL + "\tStringBuilder command_";
  protected final String TEXT_3 = " = new StringBuilder();" + NL + "    command_";
  protected final String TEXT_4 = ".append(\"mv \\\"\").append(";
  protected final String TEXT_5 = ").append(\"\\\" \\\"\").append(";
  protected final String TEXT_6 = ").append(\"\\\"\");" + NL + "\t/* Create a session */" + NL + "\tch.ethz.ssh2.Session sess_";
  protected final String TEXT_7 = " = conn_";
  protected final String TEXT_8 = ".openSession();" + NL + "\t" + NL + "\t//execute the command" + NL + "\tsess_";
  protected final String TEXT_9 = ".execCommand((command_";
  protected final String TEXT_10 = ").toString());\t\t" + NL + "\t" + NL + "\t//get the return info" + NL + "\t" + NL + "\tjava.io.InputStream stderr_";
  protected final String TEXT_11 = " = sess_";
  protected final String TEXT_12 = ".getStderr();" + NL + "    java.io.BufferedReader breer_";
  protected final String TEXT_13 = "= new java.io.BufferedReader(new java.io.InputStreamReader(stderr_";
  protected final String TEXT_14 = "));" + NL + "    String line_err_";
  protected final String TEXT_15 = " = \"\";" + NL + "    StringBuilder stringStderr_";
  protected final String TEXT_16 = " =new StringBuilder();" + NL + "\twhile((line_err_";
  protected final String TEXT_17 = " = breer_";
  protected final String TEXT_18 = ".readLine()) != null) {" + NL + "\t\tstringStderr_";
  protected final String TEXT_19 = ".append(line_err_";
  protected final String TEXT_20 = " + \"\\n\");" + NL + "\t}" + NL + "\tbreer_";
  protected final String TEXT_21 = ".close();" + NL + "\tstderr_";
  protected final String TEXT_22 = ".close();" + NL + "\t" + NL + "\t /* Close this session */\t\t\t" + NL + "\tsess_";
  protected final String TEXT_23 = ".close();" + NL + "\t" + NL + "\tif((\"\").equals(stringStderr_";
  protected final String TEXT_24 = ".toString()) || (stringStderr_";
  protected final String TEXT_25 = ".toString() == null)){" + NL + "\t\t";
  protected final String TEXT_26 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Rename '\" + ";
  protected final String TEXT_28 = " + \"'  to '\" + ";
  protected final String TEXT_29 = " + \"' successfully.\");" + NL + "\t\t";
  protected final String TEXT_30 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_31 = "_STATUS\",\"File rename OK\");" + NL + "\t}else{" + NL + "\t\t";
  protected final String TEXT_32 = NL + "\t\t\tlog.warn(\"";
  protected final String TEXT_33 = " - Fail to rename '\" + ";
  protected final String TEXT_34 = " + \"' to '\" + ";
  protected final String TEXT_35 = " + \"':\" + stringStderr_";
  protected final String TEXT_36 = ".toString());" + NL + "\t\t";
  protected final String TEXT_37 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_38 = "_STATUS\",stringStderr_";
  protected final String TEXT_39 = ".toString());" + NL + "\t}";
  protected final String TEXT_40 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
   	String fromName = ElementParameterParser.getValue(node, "__FROMNAME__");
   	String toName = ElementParameterParser.getValue(node,"__TONAME__");
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(fromName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(toName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(fromName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(toName);
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(fromName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(toName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}
