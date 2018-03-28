package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TSCPFileListEndJava
{
  protected static String nl;
  public static synchronized TSCPFileListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPFileListEndJava result = new TSCPFileListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t\t}" + NL + "\t    brout_";
  protected final String TEXT_2 = ".close();" + NL + "\t\tstdout_";
  protected final String TEXT_3 = ".close();" + NL + "\t\tjava.io.InputStream stderr_";
  protected final String TEXT_4 = " = sess_";
  protected final String TEXT_5 = ".getStderr();" + NL + "        java.io.BufferedReader breer_";
  protected final String TEXT_6 = "= new java.io.BufferedReader(new java.io.InputStreamReader(stderr_";
  protected final String TEXT_7 = "));" + NL + "        String line_err_";
  protected final String TEXT_8 = " = \"\";" + NL + "        StringBuilder stringStderr_";
  protected final String TEXT_9 = " =new StringBuilder();" + NL + "\t\twhile((line_err_";
  protected final String TEXT_10 = " = breer_";
  protected final String TEXT_11 = ".readLine()) != null) {" + NL + "\t\t\tstringStderr_";
  protected final String TEXT_12 = ".append(line_err_";
  protected final String TEXT_13 = " + \"\\n\");" + NL + "\t\t}" + NL + "\t\tbreer_";
  protected final String TEXT_14 = ".close();" + NL + "\t\tstderr_";
  protected final String TEXT_15 = ".close();" + NL + "\t\t /* Close this session */\t\t\t" + NL + "\t\tsess_";
  protected final String TEXT_16 = ".close();\t\t";
  protected final String TEXT_17 = "  " + NL + "            /* Close the connection */" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_19 = " - Closing the connection to the server.\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "            conn_";
  protected final String TEXT_21 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_23 = " - Connection to the server closed.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "            if(stringStderr_";
  protected final String TEXT_25 = " == null || stringStderr_";
  protected final String TEXT_26 = ".length() == 0){" + NL + "            \tglobalMap.put(\"";
  protected final String TEXT_27 = "_STATUS\",stringStdout_";
  protected final String TEXT_28 = ".toString());" + NL + "            }else{" + NL + "            \tglobalMap.put(\"";
  protected final String TEXT_29 = "_STATUS\",stringStderr_";
  protected final String TEXT_30 = ".toString());" + NL + "            }" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_31 = "_NB_LINE\", nb_line_";
  protected final String TEXT_32 = ");" + NL + "\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_34 = " - Listed files count: \"+nb_line_";
  protected final String TEXT_35 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_36 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
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
    
		if(!("true").equals(useExistingConn)){

    stringBuffer.append(TEXT_17);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    }
      	
		}
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}
