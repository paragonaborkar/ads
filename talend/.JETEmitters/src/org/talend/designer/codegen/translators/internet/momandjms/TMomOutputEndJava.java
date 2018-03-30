package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TMomOutputEndJava
{
  protected static String nl;
  public static synchronized TMomOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomOutputEndJava result = new TMomOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Committing the session...\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\tsession_";
  protected final String TEXT_5 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Commit successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Closing connection...\");" + NL + "\t\t\t";
  protected final String TEXT_10 = " // if no commmit or rollback component exists - close session" + NL + " \t\t\tSystem.out.println(\"Closing connection\");" + NL + "            session_";
  protected final String TEXT_11 = ".close();" + NL + "            connection_";
  protected final String TEXT_12 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Closed successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "                log.info(\"";
  protected final String TEXT_16 = " - Closing producer...\");";
  protected final String TEXT_17 = NL + "            producer_";
  protected final String TEXT_18 = ".close();";
  protected final String TEXT_19 = NL + "                log.info(\"";
  protected final String TEXT_20 = " - Closed successfully.\");";
  protected final String TEXT_21 = NL + "\t\tresourceMap.put(\"finish_";
  protected final String TEXT_22 = "\", true); " + NL + "\t";
  protected final String TEXT_23 = NL + "\t\tglobalMap.put(\"qMgr_";
  protected final String TEXT_24 = "\",qMgr_";
  protected final String TEXT_25 = ");" + NL + "\t";
  protected final String TEXT_26 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Disconnecting connection...\");" + NL + "\t\t";
  protected final String TEXT_28 = NL + "\t\tSystem.out.println(\"Disconnecting queue\");" + NL + "\t\tremoteQ_";
  protected final String TEXT_29 = ".close();" + NL + "\t\t";
  protected final String TEXT_30 = NL + "\t\t\tSystem.out.println(\"Disconnecting queue manager\");" + NL + "\t\t\tqMgr_";
  protected final String TEXT_31 = ".disconnect();" + NL + "\t\t";
  protected final String TEXT_32 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_33 = " - Disconnected successfully.\");" + NL + "\t\t";
  protected final String TEXT_34 = NL + "\tlog.info(\"";
  protected final String TEXT_35 = " - Written records count: \"+ nb_line_";
  protected final String TEXT_36 = " + \" .\");";
  protected final String TEXT_37 = NL + NL + "    globalMap.put(\"";
  protected final String TEXT_38 = "_NB_LINE\",nb_line_";
  protected final String TEXT_39 = ");";

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
final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 

if (isUseExistConnection) {
	for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
		if (pNode.getUniqueName().equals(connectionComponentName)) {
			transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
			serverType=ElementParameterParser.getValue(pNode, "__SERVER__");
		}	
	}
}

if(("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)){
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
	if( ("JBoss").equals(serverType) || ( ("ActiveMQ").equals(serverType)) ){
		// if no commmit or rollback component exists and set transacted - commit session
		if(!isCommitRollback && transacted){
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
			}
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			}
		}
        if (!isCommitRollback && !isUseExistConnection) {
        	if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
			}
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    	
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
			}
            if (isLog4jEnabled) {
            
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
            }
            
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    
            if (isLog4jEnabled) {
            
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
            }
		}
	}
	if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
	
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
	}
}else{//server judgement   /***WebSphere MQ*****/
	if (transacted) {
	
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
	} else {
		if (!isUseExistConnection && isLog4jEnabled && !isCommitRollback) {
		
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
		}
		
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
		if(!isUseExistConnection && !isCommitRollback){
		
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
		}
		if (!isUseExistConnection && isLog4jEnabled && !isCommitRollback) {
		
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
		}
	}
}
if (isLog4jEnabled) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
}

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    return stringBuffer.toString();
  }
}
