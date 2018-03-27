package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.utils.NodeUtil;

public class TMomMessageIdListEndJava
{
  protected static String nl;
  public static synchronized TMomMessageIdListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomMessageIdListEndJava result = new TMomMessageIdListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "}";
  protected final String TEXT_3 = NL + "\t\tlog.info(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t";
  protected final String TEXT_6 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_7 = "_NB_LINE\",nb_line_";
  protected final String TEXT_8 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
boolean isExistConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String serverType=ElementParameterParser.getValue(node, "__SERVER__");
if(isExistConnection){
	INode connectionComponent = NodeUtil.getNodeByUniqueName(node.getProcess(),connection);
	serverType=ElementParameterParser.getValue(connectionComponent, "__SERVER__");
}
final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

if(("WebSphere").equals(serverType)){

    stringBuffer.append(TEXT_2);
    
	}
	if (isLog4jEnabled) {
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	}
	
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
