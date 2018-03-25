package org.talend.designer.codegen.translators.logs_errors;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TChronometerStartBeginJava
{
  protected static String nl;
  public static synchronized TChronometerStartBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TChronometerStartBeginJava result = new TChronometerStartBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t" + NL + "\tLong currentTime";
  protected final String TEXT_3 = " = System.currentTimeMillis();" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\tlog.info(\"";
  protected final String TEXT_5 = " - Start time: \"+currentTime";
  protected final String TEXT_6 = "+\" milliseconds\");" + NL + "\t";
  protected final String TEXT_7 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_8 = "\",currentTime";
  protected final String TEXT_9 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_10 = "_STARTTIME\", currentTime";
  protected final String TEXT_11 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
	}
	
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
