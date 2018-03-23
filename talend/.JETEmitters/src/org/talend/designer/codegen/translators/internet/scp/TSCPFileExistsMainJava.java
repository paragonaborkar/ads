package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSCPFileExistsMainJava
{
  protected static String nl;
  public static synchronized TSCPFileExistsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPFileExistsMainJava result = new TSCPFileExistsMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t" + NL + "\t\t//initial the command" + NL + "\t\tStringBuilder command_";
  protected final String TEXT_2 = " = new StringBuilder();" + NL + "        command_";
  protected final String TEXT_3 = ".append(\"ls \\\"\").append(";
  protected final String TEXT_4 = ").append(\"/\").append(";
  protected final String TEXT_5 = ").append(\"\\\"\");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_6 = "_FILENAME\", ";
  protected final String TEXT_7 = ");" + NL + "\t\t/* Create a session */" + NL + "\t\tch.ethz.ssh2.Session sess_";
  protected final String TEXT_8 = " = conn_";
  protected final String TEXT_9 = ".openSession();" + NL + "\t\t//execute the command" + NL + "\t\tsess_";
  protected final String TEXT_10 = ".execCommand((command_";
  protected final String TEXT_11 = ").toString());\t\t" + NL + "\t\t//get the return info" + NL + "\t\tjava.io.InputStream stdout_";
  protected final String TEXT_12 = " = sess_";
  protected final String TEXT_13 = ".getStdout();" + NL + "\t\tjava.io.BufferedReader brout_";
  protected final String TEXT_14 = "= new java.io.BufferedReader(new java.io.InputStreamReader(stdout_";
  protected final String TEXT_15 = "));" + NL + "        String line_out_";
  protected final String TEXT_16 = " = \"\";" + NL + "        StringBuilder stringStdout_";
  protected final String TEXT_17 = " =new StringBuilder();" + NL + "\t\twhile((line_out_";
  protected final String TEXT_18 = " = brout_";
  protected final String TEXT_19 = ".readLine()) != null) {" + NL + "\t\t\tstringStdout_";
  protected final String TEXT_20 = ".append(line_out_";
  protected final String TEXT_21 = " + \"\\n\");" + NL + "\t\t}\t\t" + NL + "\t    brout_";
  protected final String TEXT_22 = ".close();" + NL + "\t\tstdout_";
  protected final String TEXT_23 = ".close();" + NL + "\t\tjava.io.InputStream stderr_";
  protected final String TEXT_24 = " = sess_";
  protected final String TEXT_25 = ".getStderr();" + NL + "        java.io.BufferedReader breer_";
  protected final String TEXT_26 = "= new java.io.BufferedReader(new java.io.InputStreamReader(stderr_";
  protected final String TEXT_27 = "));" + NL + "        String line_err_";
  protected final String TEXT_28 = " = \"\";" + NL + "        StringBuilder stringStderr_";
  protected final String TEXT_29 = " =new StringBuilder();" + NL + "\t\twhile((line_err_";
  protected final String TEXT_30 = " = breer_";
  protected final String TEXT_31 = ".readLine()) != null) {" + NL + "\t\t\tstringStderr_";
  protected final String TEXT_32 = ".append(line_err_";
  protected final String TEXT_33 = " + \"\\n\");" + NL + "\t\t}" + NL + "\t\tbreer_";
  protected final String TEXT_34 = ".close();" + NL + "\t\tstderr_";
  protected final String TEXT_35 = ".close();" + NL + "\t\t /* Close this session */\t\t\t" + NL + "\t\tsess_";
  protected final String TEXT_36 = ".close();" + NL + "\t\tif((\"\").equals(stringStderr_";
  protected final String TEXT_37 = ".toString()) || stringStderr_";
  protected final String TEXT_38 = ".toString() == null){" + NL + "\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_40 = " - The file '\" + ";
  protected final String TEXT_41 = " + \"' exists in the remote directory '\"+ ";
  protected final String TEXT_42 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_44 = "_STATUS\", \"File exists.\");" + NL + "\t\t}else{" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_46 = " - The file '\" + ";
  protected final String TEXT_47 = " + \"' doesn't exist in the remote directory '\"+ ";
  protected final String TEXT_48 = " + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "        \tglobalMap.put(\"";
  protected final String TEXT_50 = "_STATUS\", stringStderr_";
  protected final String TEXT_51 = ".toString());" + NL + "        }";
  protected final String TEXT_52 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String remoteDir = ElementParameterParser.getValue(node,"__REMOTEDIR__");
    String fileExists = ElementParameterParser.getValue(node,"__EXISTFILE__");
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(fileExists );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(fileExists );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(fileExists );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(fileExists );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(TEXT_52);
    return stringBuffer.toString();
  }
}
