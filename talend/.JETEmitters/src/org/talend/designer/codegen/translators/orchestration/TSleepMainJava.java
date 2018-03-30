package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSleepMainJava
{
  protected static String nl;
  public static synchronized TSleepMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSleepMainJava result = new TSleepMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    Thread.sleep((";
  protected final String TEXT_3 = ")*1000);";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String pause = ElementParameterParser.getValue(node, "__PAUSE__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(pause);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
