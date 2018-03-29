package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileListEndJava
{
  protected static String nl;
  public static synchronized TFileListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileListEndJava result = new TFileListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "  ";
  protected final String TEXT_2 = NL + "    }" + NL + "  globalMap.put(\"";
  protected final String TEXT_3 = "_NB_FILE\", NB_FILE";
  protected final String TEXT_4 = ");" + NL + "  ";
  protected final String TEXT_5 = NL + "    log.info(\"";
  protected final String TEXT_6 = " - File or directory count : \" + NB_FILE";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + "    if (NB_FILE";
  protected final String TEXT_10 = " == 0) throw new RuntimeException(\"No file found in directory \" + directory_";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "  " + NL + " ";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
  CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
  INode node = (INode)codeGenArgument.getArgument();
  String cid = node.getUniqueName();
  boolean generateError = ("true").equals(ElementParameterParser.getValue(node, "__ERROR__"));
  
  final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    if (generateError){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
