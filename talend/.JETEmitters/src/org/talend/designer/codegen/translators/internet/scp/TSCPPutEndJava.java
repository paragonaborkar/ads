package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TSCPPutEndJava
{
  protected static String nl;
  public static synchronized TSCPPutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPPutEndJava result = new TSCPPutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  \t" + NL + "\t\t/* Close the connection */" + NL + "\t\t";
  protected final String TEXT_2 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Closing the connection to the server.\");" + NL + "\t\t";
  protected final String TEXT_4 = NL + "        conn_";
  protected final String TEXT_5 = ".close();" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Connection to the server closed.\");" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t";
  protected final String TEXT_9 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_10 = "_NB_FILE\",nb_file_";
  protected final String TEXT_11 = ");" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_12 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Uploaded files count: \" + nb_file_";
  protected final String TEXT_14 = " +  \".\");" + NL + "\t\t";
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__")); 
    String cid = node.getUniqueName();
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	if(!("true").equals(useExistingConn)){

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
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
