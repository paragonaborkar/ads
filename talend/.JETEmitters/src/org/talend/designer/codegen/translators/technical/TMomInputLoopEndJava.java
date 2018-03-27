package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TMomInputLoopEndJava
{
  protected static String nl;
  public static synchronized TMomInputLoopEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomInputLoopEndJava result = new TMomInputLoopEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\tmessage_";
  protected final String TEXT_3 = ".acknowledge();" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_6 = " - Sleepping time(";
  protected final String TEXT_7 = "s)...\");" + NL + "\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tThread.sleep(";
  protected final String TEXT_9 = "*1000);" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tbreak;" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tif (session_";
  protected final String TEXT_13 = " != null && connection_";
  protected final String TEXT_14 = " != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_16 = " - Committing the session...\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\tsession_";
  protected final String TEXT_18 = ".commit();" + NL + "\t\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_20 = " - Commit successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t}" + NL + "\t\t\t}catch(java.lang.Exception ex){" + NL + "\t\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_23 = " - A Active MQ error occurred :\" + ex);" + NL + "\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tSystem.out.println(\"A Active MQ error occurred :\" + ex);" + NL + "\t\t      \tex.printStackTrace();" + NL + "\t\t\t\tif (session_";
  protected final String TEXT_25 = " != null  && connection_";
  protected final String TEXT_26 = " != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Rollback operations...\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t\tsession_";
  protected final String TEXT_30 = ".rollback();" + NL + "\t\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_32 = " - Rollback successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_34 = NL + "        " + NL + "\t\t}" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_35 = NL + "\t\t\tif(!(Boolean)globalMap.get(\"currentMessageIsConsumed_";
  protected final String TEXT_36 = "\")) {" + NL + "\t\t\t\tif (backoutQueue_";
  protected final String TEXT_37 = "!=null && threshold_";
  protected final String TEXT_38 = " > 0 && inMessage";
  protected final String TEXT_39 = ".backoutCount >= threshold_";
  protected final String TEXT_40 = "-1) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_41 = "\t" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_42 = " - Moving backout message to backout queue...\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\tbackoutQueue_";
  protected final String TEXT_44 = ".put(inMessage";
  protected final String TEXT_45 = ");" + NL + "\t\t\t\t\tqMgr_";
  protected final String TEXT_46 = ".commit();" + NL + "\t\t\t\t\t";
  protected final String TEXT_47 = "\t" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_48 = " - Moved successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tqMgr_";
  protected final String TEXT_50 = ".backout();" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\tqMgr_";
  protected final String TEXT_52 = ".backout();" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t}catch(com.ibm.mq.MQException ex){" + NL + "\t\t\tSystem.out.println(\"A WebSphere MQ error occurred : Completion code \" + ex.completionCode + \" Reason code \" + ex.reasonCode);" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_54 = NL + NL + "} finally {" + NL + "\t";
  protected final String TEXT_55 = NL + "\t\tif(consumer_";
  protected final String TEXT_56 = "!=null){" + NL + "\t\t\tconsumer_";
  protected final String TEXT_57 = ".close();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_58 = NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_60 = " - Closing connection...\");" + NL + "\t\t\t";
  protected final String TEXT_61 = NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\tif (session_";
  protected final String TEXT_63 = " != null  && connection_";
  protected final String TEXT_64 = " != null) {" + NL + "\t \t\t\tsession_";
  protected final String TEXT_65 = ".close();" + NL + " \t\t \t}" + NL + "\t\t\t";
  protected final String TEXT_66 = NL + "\t" + NL + "\t        if (connection_";
  protected final String TEXT_67 = " != null) {" + NL + "\t         \tconnection_";
  protected final String TEXT_68 = ".close();" + NL + "\t        }" + NL + "\t        " + NL + "\t        ";
  protected final String TEXT_69 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_70 = " - Closed successfully\");" + NL + "\t\t\t";
  protected final String TEXT_71 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_72 = NL + "\t" + NL + "\t\t";
  protected final String TEXT_73 = NL + "\t\tlog.info(\"";
  protected final String TEXT_74 = " - Closing connection...\");" + NL + "\t\t";
  protected final String TEXT_75 = NL + "\t\t" + NL + "\t\tSystem.out.println(\"Closing connection\");" + NL + "\t\t" + NL + "\t\tif(consumer_";
  protected final String TEXT_76 = "!=null) {" + NL + "        \tconsumer_";
  protected final String TEXT_77 = ".close();" + NL + "        }" + NL + "        " + NL + "        if(session_";
  protected final String TEXT_78 = "!=null) {" + NL + "        \tsession_";
  protected final String TEXT_79 = ".close();" + NL + "        }" + NL + "        " + NL + "        if(connection_";
  protected final String TEXT_80 = "!=null) {" + NL + "    \t\tconnection_";
  protected final String TEXT_81 = ".close();" + NL + "        }" + NL + "        ";
  protected final String TEXT_82 = NL + "\t\tlog.info(\"";
  protected final String TEXT_83 = " - Closed successfully.\");" + NL + "\t\t";
  protected final String TEXT_84 = NL + "\t\t" + NL + "\t";
  protected final String TEXT_85 = NL + "\t\tlog.info(\"";
  protected final String TEXT_86 = " - Disconnecting connection...\");" + NL + "\t\t";
  protected final String TEXT_87 = NL + "\t\t" + NL + "\t\tSystem.out.println(\"Disconnecting queue...\");" + NL + "\t\t" + NL + "\t\tif(remoteQ_";
  protected final String TEXT_88 = "!=null) {" + NL + "\t\t\tremoteQ_";
  protected final String TEXT_89 = ".close();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_90 = NL + "\t\tif(backoutQueue_";
  protected final String TEXT_91 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_93 = " - Closing backout queue...\");" + NL + "\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\tbackoutQueue_";
  protected final String TEXT_95 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_97 = " - Closed successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_98 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_99 = NL + "\t\t\tSystem.out.println(\"Disconnecting queue manager...\");" + NL + "\t\t\tif(qMgr_";
  protected final String TEXT_100 = "!=null) {" + NL + "\t\t\t\tqMgr_";
  protected final String TEXT_101 = ".disconnect();" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_102 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_103 = " - Disconnected successfully.\");" + NL + "\t\t";
  protected final String TEXT_104 = NL + "}" + NL;
  protected final String TEXT_105 = NL + "\tlog.info(\"";
  protected final String TEXT_106 = " - Consumed messages count: \"+ nb_line_";
  protected final String TEXT_107 = " + \" .\");";
  protected final String TEXT_108 = NL + NL + "\tglobalMap.put(\"";
  protected final String TEXT_109 = "_NB_LINE\",nb_line_";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
    boolean isUseExistConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
	String cid = node.getUniqueName();
	cid = cid.replaceAll("_Loop", "");
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String useMsgId=ElementParameterParser.getValue(node, "__IS_USE_MESSAGE_ID__");
	String kListen=ElementParameterParser.getValue(node, "__KEEPLISTENING__");
	String timeOut=ElementParameterParser.getValue(node, "__TIMEOUT__");
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	String msgBobyType =  ElementParameterParser.getValue(node, "__MESSAGE_BODY_TYPE__");
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
	
	if (("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)) {
		if ("CLIENT_ACKNOWLEDGE".equals(acknowledgmentMode)) {
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    	
		}
		if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){
		
    stringBuffer.append(TEXT_4);
    
		}
		if(("JBoss").equals(serverType)){
			if("true".equals(kListen)){
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(timeOut);
    stringBuffer.append(TEXT_7);
    
				}
				
    stringBuffer.append(TEXT_8);
    stringBuffer.append(timeOut);
    stringBuffer.append(TEXT_9);
    		
			}else{
			
    stringBuffer.append(TEXT_10);
    			
			}
		}else if(("ActiveMQ").equals(serverType)) {
			if (("true").equals(ElementParameterParser.getValue(node,"__USEMAX__"))) {
			
    stringBuffer.append(TEXT_11);
    
			}
		}
		
        if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
					}
					
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
					}
					
    stringBuffer.append(TEXT_21);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
				}
				
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
					}
					
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
					}
					
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    
	}else{//websphere
		boolean isCommit = ("true").equals(ElementParameterParser.getValue(node, "__COMMIT__"));
		boolean isBrowse = ("true").equals(ElementParameterParser.getValue(node,"__BROWSE__"));
		boolean isRollback = ("true").equals(ElementParameterParser.getValue(node, "__ROLLBACK__"));
		isRollback = isRollback && ("false".equals(kListen)) && !isCommit && !isBrowse;
		boolean isAutoBackout = ("true").equals(ElementParameterParser.getValue(node, "__AUTO_BACKOUT__"));
		isAutoBackout = isAutoBackout && !isBrowse && !isRollback && !isCommit;
		
		if(isAutoBackout){
		
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
					}
					
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
					}
					
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
		} else if(isRollback) {
		
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
		}
		
    stringBuffer.append(TEXT_53);
    
	}
	
    stringBuffer.append(TEXT_54);
    if("ActiveMQ".equals(serverType)){
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    
		if(!isUseExistConnection) {
		
    stringBuffer.append(TEXT_58);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(TEXT_61);
    
			if(!isCommitRollback) {
			
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    
			}
			
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    
		}
	} else if("JBoss".equals(serverType)){
    stringBuffer.append(TEXT_72);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    }
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    } else {//websphere
		boolean isCommit = ("true").equals(ElementParameterParser.getValue(node, "__COMMIT__"));
		boolean isBrowse = ("true").equals(ElementParameterParser.getValue(node,"__BROWSE__"));
		boolean isRollback = ("true").equals(ElementParameterParser.getValue(node, "__ROLLBACK__"));
		isRollback = isRollback && ("false".equals(kListen)) && !isCommit && !isBrowse;
		boolean isAutoBackout = "true".equals(ElementParameterParser.getValue(node, "__AUTO_BACKOUT__"));
		isAutoBackout = isAutoBackout && !isBrowse && !isRollback && !isCommit && (!("true").equals(kListen));
		
		if (!isUseExistConnection && isLog4jEnabled && !isCommitRollback) {
		
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
		}
		
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
		if(isAutoBackout){
		
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    
		}
		
		if(!isUseExistConnection && !isCommitRollback){
		
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
		}
		
		if (!isUseExistConnection && isLog4jEnabled && !isCommitRollback) {
		
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
		}
	}
	
    stringBuffer.append(TEXT_104);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    }
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(TEXT_111);
    return stringBuffer.toString();
  }
}
