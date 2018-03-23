package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TSCPRenameEndJava
{
  protected static String nl;
  public static synchronized TSCPRenameEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPRenameEndJava result = new TSCPRenameEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "  \t" + NL + "\t\t/* Close the connection */" + NL + "\t\t";
  protected final String TEXT_3 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Closing the connection to the server.\");" + NL + "\t\t";
  protected final String TEXT_5 = NL + "        conn_";
  protected final String TEXT_6 = ".close();" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Connection to the server closed.\");" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	if(!("true").equals(useExistingConn)){

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
    
	}
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
