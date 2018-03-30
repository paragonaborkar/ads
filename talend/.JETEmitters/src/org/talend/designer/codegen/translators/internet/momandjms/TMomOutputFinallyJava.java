package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TMomOutputFinallyJava
{
  protected static String nl;
  public static synchronized TMomOutputFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomOutputFinallyJava result = new TMomOutputFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\tif(resourceMap.get(\"finish_";
  protected final String TEXT_3 = "\") == null){" + NL + "\t\tif(resourceMap.get(\"session_";
  protected final String TEXT_4 = "\") != null){" + NL + "\t\t\t((javax.jms.Session)resourceMap.get(\"session_";
  protected final String TEXT_5 = "\")).rollback();" + NL + "\t    \t";
  protected final String TEXT_6 = NL + "\t    \t\tif(resourceMap.get(\"producer_";
  protected final String TEXT_7 = "\") != null){" + NL + "\t\t    \t\t((javax.jms.MessageProducer)resourceMap.get(\"producer_";
  protected final String TEXT_8 = "\")).close();" + NL + "\t\t\t\t}" + NL + "   \t    \t \t((javax.jms.Session)resourceMap.get(\"session_";
  protected final String TEXT_9 = "\")).close();" + NL + "   \t    \t \tif(resourceMap.get(\"connection_";
  protected final String TEXT_10 = "\") != null){" + NL + "\t    \t    \t((javax.jms.Connection)resourceMap.get(\"connection_";
  protected final String TEXT_11 = "\")).close();" + NL + "\t    \t    }" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean isUseExistConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
String cid = node.getUniqueName();
String serverType=ElementParameterParser.getValue(node, "__SERVER__");
boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");

List<? extends INode> commitNodes=node.getProcess().getNodesOfType("tMomCommit");
List<? extends INode> rollBackNodes=node.getProcess().getNodesOfType("tMomRollback");

boolean isCommitRollback = false;
for(INode cNode:commitNodes){
	String cNodeName = ElementParameterParser.getValue(cNode,"__CONNECTION__");
	if(cid.equals(cNodeName) || (isUseExistConnection && connectionComponentName.equals(cNodeName))){
		isCommitRollback = true;
		break;
	}
}
if(!isCommitRollback){
	for(INode rNode:rollBackNodes){
		String rNodeName = ElementParameterParser.getValue(rNode,"__CONNECTION__");
		if(cid.equals(rNodeName) || (isUseExistConnection && connectionComponentName.equals(rNodeName))){
			isCommitRollback = true;
			break;
		}
	}
}

if (isUseExistConnection) {
	for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
		if (pNode.getUniqueName().equals(connectionComponentName)) {
			transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
			serverType=ElementParameterParser.getValue(pNode, "__SERVER__");
		}	
	}
}

if((("ActiveMQ").equals(serverType)) && !isCommitRollback && transacted){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    if(!isUseExistConnection){
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
    }
    stringBuffer.append(TEXT_12);
    
}

    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
