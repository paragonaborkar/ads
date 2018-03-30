package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.ArrayList;

public class TMomRollbackMainJava
{
  protected static String nl;
  public static synchronized TMomRollbackMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomRollbackMainJava result = new TMomRollbackMainJava();
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
  protected final String TEXT_11 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_12 = " - Rollback operations...\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\tsession_";
  protected final String TEXT_14 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_16 = " - Rollback successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tif (producer_";
  protected final String TEXT_18 = " != null) { " + NL + "\t\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_20 = " - Closing producer...\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\tproducer_";
  protected final String TEXT_22 = ".close();" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_24 = " - Closed successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_25 = " " + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Closing connection...\");" + NL + "\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t        session_";
  protected final String TEXT_29 = ".close();" + NL + "\t\t        connection_";
  protected final String TEXT_30 = ".close();" + NL + "\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_32 = " - Closed successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_34 = NL + "\t\t\tclass BackOutUtil_";
  protected final String TEXT_35 = "{" + NL + "\t\t\t\t" + NL + "\t\t\t\tint threshold = 0;" + NL + "\t\t\t\tString inQueuename = null;" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic com.ibm.mq.MQQueue genInQueue(com.ibm.mq.MQQueueManager qMgr,String inQueueName,boolean isBrowse) throws com.ibm.mq.MQException{" + NL + "\t\t\t\t\tthis.inQueuename = inQueueName;" + NL + "\t\t\t\t\tint openOptions=com.ibm.mq.MQC.MQOO_INPUT_SHARED | com.ibm.mq.MQC.MQOO_FAIL_IF_QUIESCING | com.ibm.mq.MQC.MQOO_INQUIRE;" + NL + "\t\t\t\t\tif(isBrowse){" + NL + "\t\t\t\t\t\topenOptions = openOptions | com.ibm.mq.MQC.MQOO_BROWSE;" + NL + "\t\t\t\t\t}" + NL + "\t    \t\t\treturn qMgr.accessQueue(inQueueName,openOptions);" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic com.ibm.mq.MQGetMessageOptions genGetMsgOptions (boolean isBrowse){" + NL + "\t\t\t\t\tcom.ibm.mq.MQGetMessageOptions gmo=new com.ibm.mq.MQGetMessageOptions();" + NL + "\t\t\t\t\tif(!isBrowse){" + NL + "\t\t\t\t\t\tgmo.options=gmo.options+com.ibm.mq.MQC.MQGMO_SYNCPOINT;" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tgmo.options=gmo.options+com.ibm.mq.MQC.MQGMO_BROWSE_FIRST;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tgmo.options=gmo.options+com.ibm.mq.MQC.MQGMO_NO_WAIT;" + NL + "\t\t\t\t\tgmo.options=gmo.options+com.ibm.mq.MQC.MQGMO_FAIL_IF_QUIESCING;" + NL + "\t\t\t\t\tgmo.waitInterval=com.ibm.mq.MQC.MQWI_UNLIMITED;" + NL + "\t\t\t\t\treturn gmo;" + NL + "\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t\tpublic com.ibm.mq.MQQueue genBackOutQueue(com.ibm.mq.MQQueueManager qMgr,com.ibm.mq.MQQueue inQueue";
  protected final String TEXT_36 = ",org.apache.log4j.Logger log";
  protected final String TEXT_37 = "){" + NL + "\t\t\t\t\tint[] selectors = new int[2];" + NL + "\t\t\t\t\tint[] intAttrs = new int[1];" + NL + "\t\t\t\t\tString backoutQName = \"\";" + NL + "\t\t\t\t\tbyte[] charAttrs = new byte[com.ibm.mq.MQC.MQ_Q_NAME_LENGTH];" + NL + "\t\t\t\t\tselectors[0] = com.ibm.mq.MQC.MQCA_BACKOUT_REQ_Q_NAME;" + NL + "\t\t\t\t\tselectors[1] = com.ibm.mq.MQC.MQIA_BACKOUT_THRESHOLD;" + NL + "\t\t\t\t\tcom.ibm.mq.MQQueue backoutQueue = null;" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_38 = "\t" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_39 = " - Initing backout queue ...\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\tinQueue.inquire(selectors, intAttrs, charAttrs);" + NL + "\t\t\t\t\t\tthis.threshold = intAttrs[0];" + NL + "\t\t\t\t\t\tbackoutQName = new String(charAttrs);" + NL + "\t\t\t\t\t\tif(this.threshold > 0 && backoutQName.trim().length()>0){" + NL + "\t\t\t\t\t\t\tbackoutQueue = qMgr.accessQueue(backoutQName, 16);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tthrow new java.lang.Exception(\"Init backout queue unsuccessfully!\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_41 = "\t" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_42 = " - The backout queue of \"+this.inQueuename+\" is:\"+backoutQName);" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_43 = " - The threshold value of messages in \"+this.inQueuename+\" is:\"+this.threshold);" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_44 = " - Init backout queue successfully.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t}catch (java.lang.Exception e) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_46 = "\t" + NL + "\t\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_47 = " - Init backout queue unsuccessfully, poison messages will remain on the input queue.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t\tSystem.err.println(\"Init backout queue unsuccessfully, poison messages will remain on the input queue.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn backoutQueue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic List<com.ibm.mq.MQMessage> getPoisonMsgs(com.ibm.mq.MQQueueManager qMgr,String inQueueName,com.ibm.mq.MQQueue backoutQueue";
  protected final String TEXT_50 = ",org.apache.log4j.Logger log";
  protected final String TEXT_51 = ") throws com.ibm.mq.MQException{" + NL + "\t\t\t\t\tcom.ibm.mq.MQQueue inQueue = genInQueue(qMgr,inQueueName, true);" + NL + "\t\t\t\t\tcom.ibm.mq.MQGetMessageOptions gmo = genGetMsgOptions(true);" + NL + "\t\t\t\t\tint browseCursor = 0;" + NL + "\t\t\t\t\tboolean flag = true;" + NL + "\t\t\t\t\tjava.util.List<com.ibm.mq.MQMessage> backoutMsgs = new java.util.ArrayList<com.ibm.mq.MQMessage>();" + NL + "\t\t\t\t\tif (backoutQueue == null || threshold <= 0 || Integer.valueOf(inQueue.getCurrentDepth()).equals(0)) {" + NL + "\t\t\t\t\t\tflag = false;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\twhile(flag){" + NL + "\t\t\t\t\t\tif(Integer.valueOf(inQueue.getCurrentDepth()).equals(1)){" + NL + "\t\t\t\t\t\t\tflag= false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif (browseCursor > 0) {" + NL + "\t\t\t\t\t\t\tgmo.options = com.ibm.mq.MQC.MQGMO_BROWSE_NEXT;" + NL + "\t\t\t\t\t\t\tgmo.options = gmo.options" + NL + "\t\t\t\t\t\t\t\t\t+ com.ibm.mq.MQC.MQGMO_NO_WAIT;" + NL + "\t\t\t\t\t\t\tgmo.options = gmo.options" + NL + "\t\t\t\t\t\t\t\t\t+ com.ibm.mq.MQC.MQGMO_FAIL_IF_QUIESCING;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tbrowseCursor++;" + NL + "\t\t\t\t\t\tcom.ibm.mq.MQMessage inMessage = new com.ibm.mq.MQMessage();" + NL + "\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\tinQueue.get(inMessage,gmo);" + NL + "\t\t\t\t\t\t}catch (com.ibm.mq.MQException me) {   " + NL + "\t\t\t\t\t\t\tif(inQueue!=null){" + NL + "\t\t\t\t\t\t\t\tinQueue.close();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t            if (me.reasonCode == com.ibm.mq.MQException.MQRC_NO_MSG_AVAILABLE) {" + NL + "\t\t\t\t            \tbreak;   " + NL + "\t\t\t\t            }else{" + NL + "\t\t\t\t            \tthrow me;" + NL + "\t\t\t\t            }   " + NL + "\t\t     \t\t\t}" + NL + "\t\t     \t\t\tif (inMessage.backoutCount >= threshold) {" + NL + "\t\t     \t\t\t\tbackoutMsgs.add(inMessage);" + NL + "\t\t     \t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(inQueue.isOpen()){" + NL + "\t\t     \t\t\tinQueue.close();" + NL + "\t\t     \t\t}" + NL + "\t\t     \t\treturn backoutMsgs;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic void backoutMsg(com.ibm.mq.MQQueueManager qMgr,String inQueueName";
  protected final String TEXT_52 = ",org.apache.log4j.Logger log";
  protected final String TEXT_53 = ") throws com.ibm.mq.MQException{" + NL + "" + NL + "\t\t\t\t\tcom.ibm.mq.MQQueue inQueue = genInQueue(qMgr,inQueueName,false);" + NL + "\t\t\t\t\tcom.ibm.mq.MQQueue backoutQueue = genBackOutQueue(qMgr,inQueue";
  protected final String TEXT_54 = ",log";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\t\tcom.ibm.mq.MQGetMessageOptions gmo = genGetMsgOptions(false);" + NL + "\t\t\t\t\tcom.ibm.mq.MQException.log = null;" + NL + "\t\t\t\t\tjava.util.List<com.ibm.mq.MQMessage> backoutMsgs = getPoisonMsgs(qMgr,inQueueName,backoutQueue";
  protected final String TEXT_56 = ",log";
  protected final String TEXT_57 = ");" + NL + "\t\t\t\t\tif(inQueue != null && backoutQueue!=null){" + NL + "\t\t\t\t\t\tfor(com.ibm.mq.MQMessage inMessage:backoutMsgs){" + NL + "\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\tinQueue.get(inMessage,gmo);" + NL + "\t\t\t\t\t\t\t}catch (com.ibm.mq.MQException me) {   " + NL + "\t\t\t\t\t            if (me.reasonCode == com.ibm.mq.MQException.MQRC_NO_MSG_AVAILABLE) {" + NL + "\t\t\t\t\t            \tcontinue;   " + NL + "\t\t\t\t\t            }else{" + NL + "\t\t\t\t\t            \tif(inQueue!=null){" + NL + "\t\t\t\t\t\t\t\t\t\tinQueue.close();" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t            \tthrow me;" + NL + "\t\t\t\t\t            }" + NL + "\t\t\t     \t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_58 = "\t" + NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_59 = " - Moving backout message to backout queue...\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\t\t\tbackoutQueue.put(inMessage);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_61 = "\t" + NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_62 = " - Moved successfully.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_64 = "\t" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_65 = " - Closing backout backout queue:\"+(backoutQueue.name)+\"...\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\t\tbackoutQueue.close();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_67 = "\t" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_68 = " - Closed successfully.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\t\tif(inQueue.isOpen()){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_70 = "\t" + NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_71 = " - Closing input queue:\"+inQueueName+\"...\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\t\t\t\tinQueue.close();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_73 = "\t" + NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_74 = " - Closed successfully.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tqMgr.commit();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tBackOutUtil_";
  protected final String TEXT_76 = " backoutUtil_";
  protected final String TEXT_77 = " = new BackOutUtil_";
  protected final String TEXT_78 = "();" + NL + "\t\t";
  protected final String TEXT_79 = NL + "\t\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_80 = " = (com.ibm.mq.MQQueueManager)globalMap.get(\"qMgr_";
  protected final String TEXT_81 = "\");" + NL + "\t\tif(qMgr_";
  protected final String TEXT_82 = " != null) {" + NL + "\t\t\tqMgr_";
  protected final String TEXT_83 = ".backout();" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\tif(start_Hash.get(\"";
  protected final String TEXT_85 = "_Loop\")!=null){" + NL + "\t\t\t\t\t\t\tbackoutUtil_";
  protected final String TEXT_86 = ".backoutMsg(qMgr_";
  protected final String TEXT_87 = ",";
  protected final String TEXT_88 = ",log";
  protected final String TEXT_89 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t    ";
  protected final String TEXT_90 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_91 = " - Closing connection...\");" + NL + "\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t    qMgr_";
  protected final String TEXT_93 = ".disconnect();" + NL + "\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_95 = " - Closed successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t}" + NL + "\t";

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
		List<INode> nodes = (List<INode>) node.getProcess().getGeneratingNodes();
		boolean isAutoBackout = ("true").equals(ElementParameterParser.getValue(node, "__AUTO_BACKOUT__"));
		if(isAutoBackout && connectionCid!=null){
		
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
						}
						
    stringBuffer.append(TEXT_40);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
						}
						
    stringBuffer.append(TEXT_45);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
						}else{
						
    stringBuffer.append(TEXT_48);
    
						}
						
    stringBuffer.append(TEXT_49);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    
							if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
							}
							
    stringBuffer.append(TEXT_60);
    
							if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
							}
							
    stringBuffer.append(TEXT_63);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
						}
						
    stringBuffer.append(TEXT_66);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
						}
						
    stringBuffer.append(TEXT_69);
    
							if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
							}
							
    stringBuffer.append(TEXT_72);
    
							if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
							}
							
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
	  	}
		
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(connectionCid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
      
			if(isAutoBackout && connectionCid!=null){
				List<String> inputComps= new ArrayList<String>();
				connectionCid = connectionNode.getUniqueName();
		        for (INode current_node : nodes) {
		        	if(current_node.isVirtualGenerateNode()){
		        		current_node = NodeUtil.getVirtualNode(current_node);
		        	}
		        	if(inputComps.contains(current_node.getUniqueName()) || !current_node.getUniqueName().startsWith("tMomInput")){
		        		continue;
		        	}else{
		        		if(!connectionCid.equals(current_node.getUniqueName())){
			        		boolean isUseExistConnection = ("true").equals(ElementParameterParser.getValue(current_node, "__USE_CONNECTION__"));
			        		if(isUseExistConnection){
			        			String connectionComponentName = ElementParameterParser.getValue(current_node, "__CONNECTION__");
			        			if(!connectionCid.equals(connectionComponentName)){
			        				continue;
			        			}
			        		}else{
			        			continue;
			        		}
			        	}
		        	}
		        	inputComps.add(current_node.getUniqueName());
		            String queue = ElementParameterParser.getValue(current_node, "__QUEUE__");
					boolean isRollback = ("true").equals(ElementParameterParser.getValue(current_node, "__ROLLBACK__"));
					boolean isCommit = ("true").equals(ElementParameterParser.getValue(current_node, "__COMMIT__"));
					boolean isBrowse = ("true").equals(ElementParameterParser.getValue(current_node,"__BROWSE__"));
					isAutoBackout = !("true").equals(ElementParameterParser.getValue(current_node, "__AUTO_BACKOUT__")) && !isBrowse && !isRollback && !isCommit;
					if(isAutoBackout){
					
    stringBuffer.append(TEXT_84);
    stringBuffer.append(current_node.getUniqueName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(queue);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    
				    }
		        }
		   	}
			if(close){
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
				}
				
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
     
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
				}
			}
			
    stringBuffer.append(TEXT_96);
    
	}
	
    return stringBuffer.toString();
  }
}
