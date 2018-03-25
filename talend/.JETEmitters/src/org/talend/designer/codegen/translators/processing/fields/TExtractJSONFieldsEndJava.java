package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TExtractJSONFieldsEndJava
{
  protected static String nl;
  public static synchronized TExtractJSONFieldsEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractJSONFieldsEndJava result = new TExtractJSONFieldsEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "   globalMap.put(\"";
  protected final String TEXT_2 = "_NB_LINE\", nb_line_";
  protected final String TEXT_3 = ");";
  protected final String TEXT_4 = NL + "\tlog.debug(\"";
  protected final String TEXT_5 = " - Extracted records count: \" + nb_line_";
  protected final String TEXT_6 = " + \" .\");";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String cid = node.getUniqueName();
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
if(destination==null || "".equals(destination)){
    destination = cid;
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
