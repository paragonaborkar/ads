package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;

public class TMomCommitMainJava
{
  protected static String nl;
  public static synchronized TMomCommitMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomCommitMainJava result = new TMomCommitMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tjavax.jms.Session session_";
  protected final String TEXT_3 = " = (javax.jms.Session)globalMap.get(\"session_";
  protected final String TEXT_4 = "\");" + NL + "\t\tjavax.jms.Connection connection_";
  protected final String TEXT_5 = " = (javax.jms.Connection)globalMap.get(\"connection_";
  protected final String TEXT_6 = "\");" + NL + "\t\tjavax.jms.MessageProducer producer_";
  protected final String TEXT_7 = " = (javax.jms.MessageProducer)globalMap.get(\"producer_";
  protected final String TEXT_8 = "\");" + NL + "\t\tif(session_";
  protected final String TEXT_9 = " != null && connection_";
  protected final String TEXT_10 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_12 = " - Committing the session...\");" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tsession_";
  protected final String TEXT_14 = ".commit();" + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_16 = " - Commit successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t    if (producer_";
  protected final String TEXT_18 = " != null) { " + NL + "\t\t\t    \t";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_20 = " - Closing producer...\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t    \tproducer_";
  protected final String TEXT_22 = ".close(); " + NL + "\t\t\t    \t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_24 = " - Closed successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t    }" + NL + "\t\t\t    ";
  protected final String TEXT_26 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Closing connection...\");" + NL + "\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t        session_";
  protected final String TEXT_29 = ".close();" + NL + "\t\t        connection_";
  protected final String TEXT_30 = ".close();" + NL + "\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_32 = " - Closed successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_34 = NL + "\t\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_35 = " = (com.ibm.mq.MQQueueManager)globalMap.get(\"qMgr_";
  protected final String TEXT_36 = "\");" + NL + "\t    if(qMgr_";
  protected final String TEXT_37 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_39 = " - Committing ...\");" + NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\tqMgr_";
  protected final String TEXT_41 = ".commit();" + NL + "\t\t\tglobalMap.put(\"currentMessageIsConsumed_";
  protected final String TEXT_42 = "\",true);//if current message has been commited,no need to backout it to the backout queue." + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_44 = " - Commit successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_46 = " - Closing connection...\");" + NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t    qMgr_";
  protected final String TEXT_48 = ".disconnect();" + NL + "\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_50 = " - Closed successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_52 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();

    String connectionCid = ElementParameterParser.getValue(node,"__CONNECTION__");
    
    boolean close = ("true").equals(ElementParameterParser.getValue(node,"__CLOSE__"));
    
    INode connectionNode = NodeUtil.getNodeByUniqueName(node.getProcess(),connectionCid,true);
    
    boolean isUseConnection = ("true").equals(ElementParameterParser.getValue(connectionNode, "__USE_CONNECTION__"));
    
    if(isUseConnection){
    	String realConnNodeName = ElementParameterParser.getValue(connectionNode,"__CONNECTION__");
    	connectionNode = NodeUtil.getNodeByUniqueName(node.getProcess(),realConnNodeName);
    }
    String serverType=ElementParameterParser.getValue(connectionNode, "__SERVER__");
    boolean isTransacted = "true".equals(ElementParameterParser.getValue(connectionNode, "__IS_TRANSACTED__")); 

	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	if (("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)) {
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connectionCid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connectionCid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connectionCid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
			if(isTransacted){
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
				}
				
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
				}
			}
			if(close){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    
			    	if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
					}
					
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
					}
					
    stringBuffer.append(TEXT_25);
    
			   	if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
				}
			    
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
     
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
				}
			}
			
    stringBuffer.append(TEXT_33);
    
	} else {
	
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(connectionCid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
			}
			
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(connectionCid);
    stringBuffer.append(TEXT_42);
      
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
			}
			if(close){
			   	if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
				}
			    
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
     
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
				}
			}
			
    stringBuffer.append(TEXT_51);
    
	}
	
    stringBuffer.append(TEXT_52);
    return stringBuffer.toString();
  }
}
