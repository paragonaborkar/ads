package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TWaitForFileEndJava
{
  protected static String nl;
  public static synchronized TWaitForFileEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWaitForFileEndJava result = new TWaitForFileEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    if(true){" + NL + "\t\t";
  protected final String TEXT_2 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - An action has been triggered. Breaking the loop.\");" + NL + "\t\t";
  protected final String TEXT_4 = NL + "        break;" + NL + "    }";
  protected final String TEXT_5 = NL + "    if(false){" + NL + "        break;" + NL + "    }";
  protected final String TEXT_6 = NL + "\tif(globalMap.get(\"";
  protected final String TEXT_7 = "_NOT_UPDATED_FILE\")!=null){" + NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_8 = NL + "}" + NL;
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    if(("exitloop").equals(ElementParameterParser.getValue(node, "__THEN__"))){
    stringBuffer.append(TEXT_1);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
     } else { 
    stringBuffer.append(TEXT_5);
     }
    if("true".equals(ElementParameterParser.getValue(node, "__NON_UPDATE__"))){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
