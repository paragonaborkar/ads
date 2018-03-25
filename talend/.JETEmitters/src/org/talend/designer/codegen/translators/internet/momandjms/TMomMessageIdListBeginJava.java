package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;

public class TMomMessageIdListBeginJava
{
  protected static String nl;
  public static synchronized TMomMessageIdListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomMessageIdListBeginJava result = new TMomMessageIdListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_5 = "=null;" + NL + "\t\tcom.ibm.mq.MQQueue remoteQ_";
  protected final String TEXT_6 = "=null;" + NL + "\t\tjava.util.List<String> idList_";
  protected final String TEXT_7 = " = new java.util.ArrayList<String>();" + NL + "\t\ttry{\t" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tqMgr_";
  protected final String TEXT_9 = " = (com.ibm.mq.MQQueueManager)globalMap.get(\"qMgr_";
  protected final String TEXT_10 = "\");" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\tjava.util.Hashtable properties_";
  protected final String TEXT_12 = "=new java.util.Hashtable();" + NL + "\t\t\t\tproperties_";
  protected final String TEXT_13 = ".put(\"hostname\", ";
  protected final String TEXT_14 = ");" + NL + "\t\t\t\tproperties_";
  protected final String TEXT_15 = ".put(\"port\", Integer.valueOf(";
  protected final String TEXT_16 = "));" + NL + "\t\t\t\tproperties_";
  protected final String TEXT_17 = ".put(\"channel\", ";
  protected final String TEXT_18 = ");" + NL + "\t\t\t\tproperties_";
  protected final String TEXT_19 = ".put(\"CCSID\", new Integer(1208));" + NL + "\t\t\t\tproperties_";
  protected final String TEXT_20 = ".put(\"transport\",\"MQSeries\");" + NL + "\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\tproperties_";
  protected final String TEXT_22 = ".put(\"userID\",";
  protected final String TEXT_23 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_25 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_26 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = "; ";
  protected final String TEXT_31 = NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\t\t\tproperties_";
  protected final String TEXT_32 = ".put(\"password\",decryptedPassword_";
  protected final String TEXT_33 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\tqMgr_";
  protected final String TEXT_35 = "=new com.ibm.mq.MQQueueManager(";
  protected final String TEXT_36 = ",properties_";
  protected final String TEXT_37 = ");" + NL + "\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\tint openOptions_";
  protected final String TEXT_39 = "=com.ibm.mq.MQC.MQOO_FAIL_IF_QUIESCING | com.ibm.mq.MQC.MQOO_INPUT_AS_Q_DEF;" + NL + "\t" + NL + "\t    \tcom.ibm.mq.MQGetMessageOptions gmo_";
  protected final String TEXT_40 = "=new com.ibm.mq.MQGetMessageOptions();" + NL + "\t    \tgmo_";
  protected final String TEXT_41 = ".options=gmo_";
  protected final String TEXT_42 = ".options+com.ibm.mq.MQC.MQGMO_SYNCPOINT;" + NL + "\t    \tgmo_";
  protected final String TEXT_43 = ".options=gmo_";
  protected final String TEXT_44 = ".options+com.ibm.mq.MQC.MQGMO_NO_WAIT;" + NL + "\t    \tgmo_";
  protected final String TEXT_45 = ".options=gmo_";
  protected final String TEXT_46 = ".options+com.ibm.mq.MQC.MQGMO_FAIL_IF_QUIESCING;" + NL + "\t    \tgmo_";
  protected final String TEXT_47 = ".waitInterval=com.ibm.mq.MQC.MQWI_UNLIMITED;" + NL + "\t    \tcom.ibm.mq.MQException.log = null;" + NL + "\t    \tboolean flag_";
  protected final String TEXT_48 = "=true;" + NL + "\t\t\t";
  protected final String TEXT_49 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_50 = " - Ready to receive message.\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_51 = " - Waiting...\");" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "\t    \twhile(flag_";
  protected final String TEXT_53 = "){" + NL + "\t    \t\tremoteQ_";
  protected final String TEXT_54 = "=qMgr_";
  protected final String TEXT_55 = ".accessQueue(";
  protected final String TEXT_56 = ",openOptions_";
  protected final String TEXT_57 = ");" + NL + "\t    \t\tcom.ibm.mq.MQMessage inMessage_";
  protected final String TEXT_58 = "=new com.ibm.mq.MQMessage();" + NL + "\t    \t\tremoteQ_";
  protected final String TEXT_59 = ".get(inMessage_";
  protected final String TEXT_60 = ",gmo_";
  protected final String TEXT_61 = ");" + NL + "\t    \t\tidList_";
  protected final String TEXT_62 = ".add(new String(inMessage_";
  protected final String TEXT_63 = ".messageId,\"ISO-8859-15\"));" + NL + "\t    \t\tremoteQ_";
  protected final String TEXT_64 = ".close();" + NL + "\t\t\t}" + NL + "\t\t}catch(com.ibm.mq.MQException me_";
  protected final String TEXT_65 = "){" + NL + "\t\t\tif (me_";
  protected final String TEXT_66 = ".reasonCode == com.ibm.mq.MQException.MQRC_NO_MSG_AVAILABLE) {" + NL + "\t\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_68 = " - Disconnecting connection...\");" + NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t        \tremoteQ_";
  protected final String TEXT_70 = ".close();" + NL + "\t        \tqMgr_";
  protected final String TEXT_71 = ".backout();" + NL + "\t            qMgr_";
  protected final String TEXT_72 = ".disconnect();" + NL + "\t            ";
  protected final String TEXT_73 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_74 = " - Disconnected successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_75 = NL + "\t        }else{" + NL + "\t        \tthrow me_";
  protected final String TEXT_76 = ";" + NL + "\t        }" + NL + "\t\t}" + NL + "\t" + NL + "\t\tfor(String tmpId_";
  protected final String TEXT_77 = " : idList_";
  protected final String TEXT_78 = "){" + NL + "\t\t\tnb_line_";
  protected final String TEXT_79 = " ++;" + NL + "\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_81 = " - Retrieving the record: \" + nb_line_";
  protected final String TEXT_82 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_84 = "_CURRENT_MESSAGE_ID\", tmpId_";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = NL;

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
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	IMetadataTable metadata=null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
	}


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if(("WebSphere").equals(serverType)){ 
	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			if(isExistConnection){
				
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_10);
    
			}else{
				String channel=ElementParameterParser.getValue(node, "__CHANNEL__");
				String qm=ElementParameterParser.getValue(node, "__QM__");
				
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(channel);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
				if(!(dbuser == null) && !("\"\"").equals(dbuser) && !("").equals(dbuser)) {
				
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_23);
    
					String passwordFieldName = "__PASS__";
					
    stringBuffer.append(TEXT_24);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_27);
    } else {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
				}
				
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
			}
			String queue = ElementParameterParser.getValue(node, "__QUEUE__");
			
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
			}
			
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
				}
				
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
				if (isLog4jEnabled) {
				
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
			}
			
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
	}

    stringBuffer.append(TEXT_86);
    return stringBuffer.toString();
  }
}
