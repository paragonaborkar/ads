package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;
import java.util.Map;

public class TMomOutputMainJava
{
  protected static String nl;
  public static synchronized TMomOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomOutputMainJava result = new TMomOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Writing the record: \" + (nb_line_";
  protected final String TEXT_4 = "+1) + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\t\t\tString msgID_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = ";" + NL + "\t\t\t\t\t\tjavax.jms.MapMessage message_";
  protected final String TEXT_9 = " = session_";
  protected final String TEXT_10 = ".createMapMessage();";
  protected final String TEXT_11 = NL + "\t\t\t\t\t\tString msgBody_";
  protected final String TEXT_12 = " = String.valueOf(";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\t\tjavax.jms.TextMessage message_";
  protected final String TEXT_16 = " = session_";
  protected final String TEXT_17 = ".createTextMessage( msgBody_";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\t\t message_";
  protected final String TEXT_20 = ".setString(msgID_";
  protected final String TEXT_21 = ",msgBody_";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\t    byte[] msgBody_";
  protected final String TEXT_24 = " = String.valueOf(";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ").getBytes();";
  protected final String TEXT_27 = NL + "\t                        byte[] msgBody_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\t\tjavax.jms.BytesMessage message_";
  protected final String TEXT_32 = " = session_";
  protected final String TEXT_33 = ".createBytesMessage();" + NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_34 = ".writeBytes(msgBody_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_37 = ".setBytes(msgID_";
  protected final String TEXT_38 = ",msgBody_";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\tjavax.jms.MapMessage message_";
  protected final String TEXT_41 = " = session_";
  protected final String TEXT_42 = ".createMapMessage();";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_44 = ".set";
  protected final String TEXT_45 = "(\"";
  protected final String TEXT_46 = "\",";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = ");\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_50 = ".setString(\"";
  protected final String TEXT_51 = "\",String.valueOf(";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = "));\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\t\t\t\tjavax.jms.Destination desJMS_";
  protected final String TEXT_55 = "=";
  protected final String TEXT_56 = ";";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_58 = ".set";
  protected final String TEXT_59 = "(";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_62 = ".set";
  protected final String TEXT_63 = "Property(";
  protected final String TEXT_64 = ", ";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + NL + "\t\t\t\t\t\tproducer_";
  protected final String TEXT_67 = ".send(";
  protected final String TEXT_68 = "desJMS_";
  protected final String TEXT_69 = " ,";
  protected final String TEXT_70 = "message_";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "\t\t\t\t\tcom.ibm.mq.MQMessage message_";
  protected final String TEXT_73 = " = new com.ibm.mq.MQMessage();";
  protected final String TEXT_74 = NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_75 = ".format = ";
  protected final String TEXT_76 = ";";
  protected final String TEXT_77 = "\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\tString msgID_";
  protected final String TEXT_79 = " = ";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = ";" + NL + "\t\t\t\t\t\tif (msgID_";
  protected final String TEXT_82 = " != null & !(\"\").equals(msgID_";
  protected final String TEXT_83 = ")) {" + NL + "\t\t\t\t\t\t\tString padding = new String();" + NL + "\t\t\t\t\t       \tint padlen = 24;" + NL + "\t\t\t\t\t " + NL + "\t\t\t\t\t       \tint len = Math.abs(padlen) - msgID_";
  protected final String TEXT_84 = ".toString().length();" + NL + "\t\t\t\t\t       \tif (len > 0) {" + NL + "\t\t\t\t\t        \tfor (int i = 0 ; i < len ; i++) {" + NL + "\t\t\t\t\t           \t\tpadding = padding + \" \";" + NL + "\t\t\t\t\t         \t}" + NL + "\t\t\t\t\t        \tmsgID_";
  protected final String TEXT_85 = " = msgID_";
  protected final String TEXT_86 = " + padding;" + NL + "\t\t\t\t\t        }" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_87 = ".messageId = msgID_";
  protected final String TEXT_88 = ".getBytes(\"ISO-8859-15\");";
  protected final String TEXT_89 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = " = ";
  protected final String TEXT_92 = ";";
  protected final String TEXT_93 = NL + "\t\t\t\t\t\t\torg.talend.mq.headers.rfh2.MQRFH2 mqrfh2_";
  protected final String TEXT_94 = " = new org.talend.mq.headers.rfh2.MQRFH2();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\t\t\t\tmqrfh2_";
  protected final String TEXT_96 = ".set";
  protected final String TEXT_97 = "(";
  protected final String TEXT_98 = ");";
  protected final String TEXT_99 = NL + "\t\t\t\t\t\t\torg.talend.mq.headers.rfh2.McdArea mcd_";
  protected final String TEXT_100 = " = new org.talend.mq.headers.rfh2.McdArea();";
  protected final String TEXT_101 = " " + NL + "\t\t\t\t\t\t\tmcd_";
  protected final String TEXT_102 = ".set";
  protected final String TEXT_103 = "(";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + "\t\t\t\t\t\t\tmqrfh2_";
  protected final String TEXT_106 = ".addArea(mcd_";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL + "\t\t\t\t\t\t\torg.talend.mq.headers.rfh2.JmsArea jms_";
  protected final String TEXT_109 = " = new org.talend.mq.headers.rfh2.JmsArea();";
  protected final String TEXT_110 = " " + NL + "\t\t\t\t\t\t\tjms_";
  protected final String TEXT_111 = ".set";
  protected final String TEXT_112 = "(";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "\t\t\t\t\t\t\tmqrfh2_";
  protected final String TEXT_115 = ".addArea(jms_";
  protected final String TEXT_116 = ");";
  protected final String TEXT_117 = NL + "\t\t\t\t\t\t\torg.talend.mq.headers.rfh2.UsrArea usr_";
  protected final String TEXT_118 = " = new org.talend.mq.headers.rfh2.UsrArea();" + NL + "\t\t\t\t\t\t\tjava.util.Map<String, Object> map_usr_";
  protected final String TEXT_119 = " = new java.util.HashMap<String, Object>();";
  protected final String TEXT_120 = " " + NL + "\t\t\t\t\t\t\tmap_usr_";
  protected final String TEXT_121 = ".put(";
  protected final String TEXT_122 = ",";
  protected final String TEXT_123 = ");";
  protected final String TEXT_124 = NL + "\t\t\t\t\t\t\torg.talend.mq.util.TalendMQUtil.setDefinedPropertiesToUser(usr_";
  protected final String TEXT_125 = ",map_usr_";
  protected final String TEXT_126 = ");" + NL + "\t\t\t\t\t\t\tmqrfh2_";
  protected final String TEXT_127 = ".addArea(usr_";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "\t\t\t\t\t\t\tmqrfh2_";
  protected final String TEXT_130 = ".toMessage(message_";
  protected final String TEXT_131 = ");";
  protected final String TEXT_132 = NL + "\t\t\t\t\t\tString msgBody_";
  protected final String TEXT_133 = " = String.valueOf(";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = ");" + NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_136 = ".writeString(msgBody_";
  protected final String TEXT_137 = ");";
  protected final String TEXT_138 = NL + "\t\t\t\t\t\t    String msgBody_";
  protected final String TEXT_139 = " = String.valueOf(";
  protected final String TEXT_140 = ".";
  protected final String TEXT_141 = ");" + NL + "\t\t\t\t\t\t    message_";
  protected final String TEXT_142 = ".write(msgBody_";
  protected final String TEXT_143 = ".getBytes());";
  protected final String TEXT_144 = NL + "                            message_";
  protected final String TEXT_145 = ".write(";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = ");";
  protected final String TEXT_148 = NL + "\t\t\t\t\t\tjava.util.Map msgBody_";
  protected final String TEXT_149 = " = new java.util.HashMap();";
  protected final String TEXT_150 = NL + "\t\t\t\t\t\t\tmsgBody_";
  protected final String TEXT_151 = ".put(\"";
  protected final String TEXT_152 = "\",";
  protected final String TEXT_153 = ".";
  protected final String TEXT_154 = ");";
  protected final String TEXT_155 = NL + "\t\t\t\t    \tmessage_";
  protected final String TEXT_156 = ".writeObject(msgBody_";
  protected final String TEXT_157 = ");" + NL + "\t\t\t\t  ";
  protected final String TEXT_158 = NL + "\t\t\t\t\tremoteQ_";
  protected final String TEXT_159 = ".put(message_";
  protected final String TEXT_160 = ", opM_";
  protected final String TEXT_161 = ");";
  protected final String TEXT_162 = NL + "\t" + NL + "\tnb_line_";
  protected final String TEXT_163 = "++;" + NL + "" + NL + "\t\t";
  protected final String TEXT_164 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String useMsgId=ElementParameterParser.getValue(node, "__IS_USE_MESSAGE_ID__");
	boolean useMQFormat = ("true").equals(ElementParameterParser.getValue(node, "__USE_FORMAT__"));
	String wsMQFormat = ElementParameterParser.getValue(node, "__WS_MQ_FORMAT__");
	
	String msgBobyType =  ElementParameterParser.getValue(node, "__MESSAGE_BODY_TYPE__");
	
	boolean isSetJMSDestination = false;
    boolean isUseExistConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
    String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");
    if (isUseExistConnection) {
		for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
			if (pNode.getUniqueName().equals(connectionComponentName)) {
				serverType=ElementParameterParser.getValue(pNode, "__SERVER__");
			}	
		}
	}
    
	boolean setJmsHeader =  ("true").equals(ElementParameterParser.getValue(node, "__SET_JMS_HEADER__"));
	List<Map<String,String>> jmsHeaders = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JMS_HEADERS__");
	
	boolean setJmsProp =  ("true").equals(ElementParameterParser.getValue(node, "__SET_JMS_PROPERTIES__"));
	List<Map<String,String>> jmsProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JMS_PROPERTIES__");

	boolean setMQMDField =  ("true").equals(ElementParameterParser.getValue(node, "__SET_MQMD_FIELDS__"));
	List<Map<String,String>> mqmdFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQMD_FIELDS__");

	boolean useMqHeader = "true".equals(ElementParameterParser.getValue(node, "__USE_MQ_HEADER__"));
	boolean useFixedMqRFH2 = "true".equals(ElementParameterParser.getValue(node, "__USE_FIX_MQRFH2__"));
	List<Map<String,String>> mqrfh2FixedFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQRFH2_FIXED_FIELD__");

	boolean useMqRFH2_mcd = "true".equals(ElementParameterParser.getValue(node, "__USE_MQRFH2_MCD__"));
	List<Map<String,String>> mqrfh2mcdFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQRFH2_MCD_FIELD__");

	boolean useMqRFH2_jms = "true".equals(ElementParameterParser.getValue(node, "__USE_MQRFH2_JMS__"));
	List<Map<String,String>> mqrfh2jmsFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQRFH2_JMS_FIELD__");

	boolean useMqRFH2_usr = "true".equals(ElementParameterParser.getValue(node, "__USE_MQRFH2_USR__"));
	List<Map<String,String>> mqrfh2usrFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQRFH2_USR_FIELD__");

	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		List<IMetadataColumn> columns = metadata.getListColumns();
		List< ? extends IConnection> conns = node.getIncomingConnections();
		if((conns!=null)&&(conns.size()>0)) {
			IConnection conn = conns.get(0);
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
				}
				if (("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)) {
				
					/*-------------------1.is use message id.this functions just use map message type-------------------------------------*/
					if(("true").equals(useMsgId)){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(metadata.getColumn("messageid").getLabel() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
					}
					
					/*--------------------------2.judge message body type----------------------------------------------------------------*/
					if ("Text".equals(msgBobyType)) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(metadata.getColumn("message").getLabel());
    stringBuffer.append(TEXT_14);
    
						if(!("true").equals(useMsgId)){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
						} else {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
						}
					} else if ("Bytes".equals(msgBobyType)) {
						IMetadataColumn column = conn.getMetadataTable().getColumn("message");
						if(!"id_byte[]".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_26);
    
						}else{

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_30);
    
						}
						if(!("true").equals(useMsgId)){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
						} else {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
						}
					} else if ("Map".equals(msgBobyType)) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
						for(IMetadataColumn column : columns) {
							 String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							  if(("byte[]").equals(typeToGenerate)) {
					                typeToGenerate = "Bytes";
					            }else if(("Character").equals(typeToGenerate)) {
					            	 typeToGenerate = "Char";
					            }else if(("Integer").equals(typeToGenerate)) {
					            	 typeToGenerate = "Int";
					            } else if(("Java.util.Date").equals(typeToGenerate)||"BigDecimal".equals(typeToGenerate)
					            			||"List".equals(typeToGenerate)) {
					            	 typeToGenerate = "Object";
					            }else {
					                typeToGenerate = typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					            }
					            if(!"Document".equals(typeToGenerate)){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_48);
    
								}else{

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_53);
    
								}
						}
					} 
					/*---------------------------------------------3.set message headers------------------------------------------------------*/
					
					if (setJmsHeader) {
						java.util.List<String> jsmHeaderClient=java.util.Arrays.asList(new String[]{"JMSCorrelationID","JMSReplyTo","JMSType","JMSTimestamp","JMSDestination","JMSMessageID","JMSRedelivered"});
						for(Map<String,String> header:jmsHeaders) {
							String jsmHeaderParam=header.get("JMS_HEADER_NAME");
							if("JMSDestination".equals(jsmHeaderParam)){
								isSetJMSDestination = true;

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(header.get("JMS_HEADER_VALUE"));
    stringBuffer.append(TEXT_56);
    
								continue;
							}
							if(jsmHeaderClient.contains(jsmHeaderParam)){

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(jsmHeaderParam);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(header.get("JMS_HEADER_VALUE"));
    stringBuffer.append(TEXT_60);
    				
							}
						}
					}
					
					/*---------------------------------------------4.set message headers------------------------------------------------------*/
					
					if (setJmsProp) {
						for(Map<String,String> prop:jmsProps) {

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(prop.get("JMS_PROPERTIES_TYPE"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(prop.get("JMS_PROPERTIES_NAME"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(prop.get("JMS_PROPERTIES_VALUE"));
    stringBuffer.append(TEXT_65);
    				
						}
					}
					
					/*---------------------------------------------5.send message to server------------------------------------------------------*/

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    if(isSetJMSDestination){
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    
				} else {//server judgement   /***WebSphere MQ*****/

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
     
					if(useMQFormat) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(wsMQFormat);
    stringBuffer.append(TEXT_76);
    
					}

    stringBuffer.append(TEXT_77);
    
					if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(metadata.getColumn("messageid").getLabel() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
					}
										
					/*---------------------------------------------set MQMD Fields------------------------------------------------------*/
					
					if (setMQMDField) {
						for(Map<String,String> field:mqmdFields) {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(field.get("MQMD_FIELD_VALUE"));
    stringBuffer.append(TEXT_92);
    				
						}
					}
					// include the header: MQRFH2
					if (useMqHeader) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
						if (useFixedMqRFH2 ) {
							for(Map<String,String> field : mqrfh2FixedFields) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(field.get("VALUE"));
    stringBuffer.append(TEXT_98);
    
							}
						}
						if(useMqRFH2_mcd ) { // mcd folder

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    
							for(Map<String,String> field : mqrfh2mcdFields) {

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(field.get("VALUE"));
    stringBuffer.append(TEXT_104);
    
							}

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    
						}
						if(useMqRFH2_jms ) { //jms folder

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    
							for(Map<String,String> field : mqrfh2jmsFields) {

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(field.get("VALUE"));
    stringBuffer.append(TEXT_113);
    
							}

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    
						}
						if(useMqRFH2_usr ) { //usr folder

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    
							for(Map<String,String> field : mqrfh2usrFields) {

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(field.get("VALUE"));
    stringBuffer.append(TEXT_123);
    
							}

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    
						}

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
					}
					
					if ("Text".equals(msgBobyType)) {

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(metadata.getColumn("message").getLabel());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
					} else if ("Bytes".equals(msgBobyType)) {
					    IMetadataColumn column = conn.getMetadataTable().getColumn("message");
                        if(!"id_byte[]".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
                        }else{

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_147);
    
                        }
					} else if ("Map".equals(msgBobyType)) {

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
						for(IMetadataColumn column : columns) {

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_154);
    
						}

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
					}

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
				}
			}
		}
	}  

    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(TEXT_164);
    return stringBuffer.toString();
  }
}
