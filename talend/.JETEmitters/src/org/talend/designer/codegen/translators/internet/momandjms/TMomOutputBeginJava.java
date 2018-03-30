package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMomOutputBeginJava
{
  protected static String nl;
  public static synchronized TMomOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomOutputBeginJava result = new TMomOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.util.Hashtable props_";
  protected final String TEXT_3 = "=new java.util.Hashtable();" + NL + "\tint nb_line_";
  protected final String TEXT_4 = " = 0;" + NL + "" + NL + "\t";
  protected final String TEXT_5 = NL + "        javax.jms.Connection connection_";
  protected final String TEXT_6 = " = null;" + NL + "\t    javax.jms.Session session_";
  protected final String TEXT_7 = " = null;" + NL + "        try {" + NL + "        \t";
  protected final String TEXT_8 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Get a connection from component: ";
  protected final String TEXT_10 = " .\");" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t        connection_";
  protected final String TEXT_12 = " = (javax.jms.Connection) globalMap.get(\"connection_";
  protected final String TEXT_13 = "\");" + NL + "\t        ";
  protected final String TEXT_14 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_15 = " - Activating the connection...\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "            connection_";
  protected final String TEXT_17 = ".start();";
  protected final String TEXT_18 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_19 = " - Activate successfully.\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_20 = " - Get a  session from component: ";
  protected final String TEXT_21 = " .\");" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\tsession_";
  protected final String TEXT_23 = " = (javax.jms.Session) globalMap.get(\"session_";
  protected final String TEXT_24 = "\");" + NL + "\t\t} catch (NullPointerException npe) {" + NL + "\t\t\t";
  protected final String TEXT_25 = "\t" + NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_26 = " - Got connection unsuccessfully.\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t    throw new RuntimeException(\"";
  protected final String TEXT_28 = " still not initialized. Try to redesign job.\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tjavax.jms.MessageProducer producer_";
  protected final String TEXT_29 = " = (javax.jms.MessageProducer)globalMap.get(\"producer_";
  protected final String TEXT_30 = "\");" + NL + "\t\t" + NL + "\t\tif(producer_";
  protected final String TEXT_31 = " == null) {" + NL + "\t\t" + NL + "\t\t\tjavax.jms.Destination des_";
  protected final String TEXT_32 = ";" + NL + "\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\tdes_";
  protected final String TEXT_34 = " = session_";
  protected final String TEXT_35 = ".createQueue(";
  protected final String TEXT_36 = ");" + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "\t    \t\tdes_";
  protected final String TEXT_38 = " = session_";
  protected final String TEXT_39 = ".createTopic(";
  protected final String TEXT_40 = ");" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + " " + NL + "\t\t \tproducer_";
  protected final String TEXT_42 = " = session_";
  protected final String TEXT_43 = ".createProducer(des_";
  protected final String TEXT_44 = ");" + NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\tproducer_";
  protected final String TEXT_46 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\tproducer_";
  protected final String TEXT_48 = ".setDeliveryMode(javax.jms.DeliveryMode.PERSISTENT);" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_50 = NL + "        \tresourceMap.put(\"session_";
  protected final String TEXT_51 = "\", session_";
  protected final String TEXT_52 = ");" + NL + "        \tresourceMap.put(\"producer_";
  protected final String TEXT_53 = "\", producer_";
  protected final String TEXT_54 = ");" + NL + "\t\t\tresourceMap.put(\"connection_";
  protected final String TEXT_55 = "\", connection_";
  protected final String TEXT_56 = ");" + NL + "\t\t";
  protected final String TEXT_57 = NL + "\t\t    " + NL + "\t";
  protected final String TEXT_58 = NL + "\t\t\tprops_";
  protected final String TEXT_59 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,\"org.jnp.interfaces.NamingContextFactory\");" + NL + "\t\t\tprops_";
  protected final String TEXT_60 = ".put(javax.naming.Context.PROVIDER_URL, ";
  protected final String TEXT_61 = "+\":\"+";
  protected final String TEXT_62 = ");" + NL + "\t\t\tprops_";
  protected final String TEXT_63 = ".put(\"java.naming.rmi.security.manager\", \"yes\");" + NL + "\t\t\t" + NL + "\t\t\tjavax.naming.Context context_";
  protected final String TEXT_64 = "=new javax.naming.InitialContext(props_";
  protected final String TEXT_65 = ");" + NL + "\t\t\tjavax.jms.ConnectionFactory factory_";
  protected final String TEXT_66 = NL + "\t\t\t\t= (javax.jms.ConnectionFactory)context_";
  protected final String TEXT_67 = ".lookup(\"ConnectionFactory\");\t" + NL + "\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_68 = "\t" + NL + "\t\t\t\tString url_";
  protected final String TEXT_69 = " =\"\";" + NL + "\t\t\t\tString endParam_";
  protected final String TEXT_70 = "=\"\";" + NL + " \t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_72 = " = \"failover:(\";" + NL + "\t\t\t\t\tendParam_";
  protected final String TEXT_73 = "=";
  protected final String TEXT_74 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_76 = " = \"discovery://static:(\";" + NL + "\t\t\t\t\tendParam_";
  protected final String TEXT_77 = "=";
  protected final String TEXT_78 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\t\turl_";
  protected final String TEXT_80 = " = url_";
  protected final String TEXT_81 = " +\",\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_83 = " = url_";
  protected final String TEXT_84 = " +\"";
  protected final String TEXT_85 = "://\";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_86 = " = url_";
  protected final String TEXT_87 = " +";
  protected final String TEXT_88 = ";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_89 = " = url_";
  protected final String TEXT_90 = " +\":\";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_91 = " = url_";
  protected final String TEXT_92 = " +";
  protected final String TEXT_93 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\turl_";
  protected final String TEXT_95 = " = url_";
  protected final String TEXT_96 = " +\")\"+endParam_";
  protected final String TEXT_97 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_99 = " = url_";
  protected final String TEXT_100 = " +\"&\"+";
  protected final String TEXT_101 = "+\"=\"+";
  protected final String TEXT_102 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\turl_";
  protected final String TEXT_104 = " = \"";
  protected final String TEXT_105 = "://\"+";
  protected final String TEXT_106 = "+\":\"+";
  protected final String TEXT_107 = ";" + NL + "\t\t\t";
  protected final String TEXT_108 = "\t" + NL + "\t\t\t" + NL + "\t\t\tSystem.out.println(\"Connecting to URL: \" + url_";
  protected final String TEXT_109 = ");" + NL + "\t\t\tSystem.out.println(\"Producing \" + (";
  protected final String TEXT_110 = " ? \"topic\" : \"queue\") + \": \" + ";
  protected final String TEXT_111 = ");" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_112 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_113 = " - Attempt to create connection from URL: \" + url_";
  protected final String TEXT_114 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\torg.apache.activemq.ActiveMQConnectionFactory factory_";
  protected final String TEXT_116 = " = " + NL + "\t\t\t\tnew org.apache.activemq.ActiveMQConnectionFactory(url_";
  protected final String TEXT_117 = ");" + NL + "\t\t";
  protected final String TEXT_118 = "\t" + NL + "\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_119 = NL + "\t\t\tjavax.jms.Connection connection_";
  protected final String TEXT_120 = " = factory_";
  protected final String TEXT_121 = ".createConnection();" + NL + "\t\t";
  protected final String TEXT_122 = NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_123 = NL + NL + "\t\t\t";
  protected final String TEXT_124 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_125 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_128 = " = ";
  protected final String TEXT_129 = "; ";
  protected final String TEXT_130 = NL + "\t\t\t\t" + NL + "\t\t\tjavax.jms.Connection connection_";
  protected final String TEXT_131 = " = factory_";
  protected final String TEXT_132 = ".createConnection(";
  protected final String TEXT_133 = ",decryptedPassword_";
  protected final String TEXT_134 = ");" + NL + "\t\t";
  protected final String TEXT_135 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_136 = " - Created connection successfully.\");" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_137 = " - Activating the connection...\");" + NL + "\t\t";
  protected final String TEXT_138 = NL + "\t\tconnection_";
  protected final String TEXT_139 = ".start();" + NL + "\t\t";
  protected final String TEXT_140 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_141 = " - Activate successfully.\");" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_142 = " - Creating a session...\");" + NL + "\t\t";
  protected final String TEXT_143 = NL + "\t\tjavax.jms.Session session_";
  protected final String TEXT_144 = " = connection_";
  protected final String TEXT_145 = ".createSession(";
  protected final String TEXT_146 = ", javax.jms.Session.";
  protected final String TEXT_147 = ");" + NL + "\t\t";
  protected final String TEXT_148 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_149 = " - Created session successfully.\");" + NL + "\t\t";
  protected final String TEXT_150 = NL + "\t\tjavax.jms.Destination des_";
  protected final String TEXT_151 = ";" + NL + "\t\t";
  protected final String TEXT_152 = NL + "\t\t\tdes_";
  protected final String TEXT_153 = " = session_";
  protected final String TEXT_154 = ".createQueue(";
  protected final String TEXT_155 = ");" + NL + "\t\t";
  protected final String TEXT_156 = NL + "\t    \tdes_";
  protected final String TEXT_157 = " = session_";
  protected final String TEXT_158 = ".createTopic(";
  protected final String TEXT_159 = ");" + NL + "\t\t";
  protected final String TEXT_160 = NL + "\t\tjavax.jms.MessageProducer producer_";
  protected final String TEXT_161 = " = session_";
  protected final String TEXT_162 = ".createProducer(des_";
  protected final String TEXT_163 = ");" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_164 = NL + "\t\t\tproducer_";
  protected final String TEXT_165 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);" + NL + "\t\t";
  protected final String TEXT_166 = NL + "\t\t\tproducer_";
  protected final String TEXT_167 = ".setDeliveryMode(javax.jms.DeliveryMode.PERSISTENT);" + NL + "\t\t";
  protected final String TEXT_168 = NL + "\t\t";
  protected final String TEXT_169 = NL + "\t\t\tresourceMap.put(\"session_";
  protected final String TEXT_170 = "\", session_";
  protected final String TEXT_171 = ");" + NL + "\t\t\tresourceMap.put(\"producer_";
  protected final String TEXT_172 = "\", producer_";
  protected final String TEXT_173 = ");" + NL + "\t\t\tresourceMap.put(\"connection_";
  protected final String TEXT_174 = "\", connection_";
  protected final String TEXT_175 = ");" + NL + "" + NL + "\t\t";
  protected final String TEXT_176 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_177 = " - Start to produce \" + (";
  protected final String TEXT_178 = " ? \"topic\" : \"queue\") + \": \" + ";
  protected final String TEXT_179 = ");" + NL + "\t\t";
  protected final String TEXT_180 = NL + "\t\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_181 = "=null;\t" + NL + "\t\t";
  protected final String TEXT_182 = NL + "\t\t\tqMgr_";
  protected final String TEXT_183 = " = (com.ibm.mq.MQQueueManager)globalMap.get(\"qMgr_";
  protected final String TEXT_184 = "\");" + NL + "\t\t\tglobalMap.put(\"qMgr_";
  protected final String TEXT_185 = "\",qMgr_";
  protected final String TEXT_186 = ");" + NL + "\t\t";
  protected final String TEXT_187 = NL + "\t\t\tprops_";
  protected final String TEXT_188 = ".put(\"hostname\", ";
  protected final String TEXT_189 = ");" + NL + "\t\t\tprops_";
  protected final String TEXT_190 = ".put(\"port\", Integer.valueOf(";
  protected final String TEXT_191 = "));" + NL + "\t\t\tprops_";
  protected final String TEXT_192 = ".put(\"channel\", ";
  protected final String TEXT_193 = ");" + NL + "\t\t\tprops_";
  protected final String TEXT_194 = ".put(\"CCSID\", new Integer(1208));" + NL + "\t\t\tprops_";
  protected final String TEXT_195 = ".put(\"transport\",\"MQSeries\");" + NL + "\t\t\t";
  protected final String TEXT_196 = NL + "\t\t\t\tcom.ibm.mq.MQEnvironment.sslCipherSuite = \"";
  protected final String TEXT_197 = "\";" + NL + "\t\t\t";
  protected final String TEXT_198 = NL + "\t\t\t\tprops_";
  protected final String TEXT_199 = ".put(\"userID\",";
  protected final String TEXT_200 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_201 = NL + NL + "\t\t\t\t";
  protected final String TEXT_202 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_203 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_204 = ");";
  protected final String TEXT_205 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_206 = " = ";
  protected final String TEXT_207 = "; ";
  protected final String TEXT_208 = NL + "\t\t\t" + NL + "\t\t" + NL + "\t\t\t\tprops_";
  protected final String TEXT_209 = ".put(\"password\",decryptedPassword_";
  protected final String TEXT_210 = ");" + NL + "\t\t\t";
  protected final String TEXT_211 = NL + "\t\t\tqMgr_";
  protected final String TEXT_212 = "=new com.ibm.mq.MQQueueManager(";
  protected final String TEXT_213 = ",props_";
  protected final String TEXT_214 = ");" + NL + "\t\t\tglobalMap.put(\"qMgr_";
  protected final String TEXT_215 = "\",qMgr_";
  protected final String TEXT_216 = ");" + NL + "\t\t\t";
  protected final String TEXT_217 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_218 = " - Created successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_219 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_220 = " - Creating queue instance for queue: \"+";
  protected final String TEXT_221 = "+\"...\");" + NL + "\t\t";
  protected final String TEXT_222 = NL + "\t    com.ibm.mq.MQQueue remoteQ_";
  protected final String TEXT_223 = " = qMgr_";
  protected final String TEXT_224 = ".accessQueue(";
  protected final String TEXT_225 = ", 16);" + NL + "\t    ";
  protected final String TEXT_226 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_227 = " - Created successfully.\");" + NL + "\t\t";
  protected final String TEXT_228 = NL + "\t    com.ibm.mq.MQPutMessageOptions opM_";
  protected final String TEXT_229 = " = new com.ibm.mq.MQPutMessageOptions();" + NL + "\t\t";
  protected final String TEXT_230 = "\t" + NL + "\t\t\topM_";
  protected final String TEXT_231 = ".options=opM_";
  protected final String TEXT_232 = ".options+com.ibm.mq.MQC.MQGMO_SYNCPOINT;" + NL + "\t\t";
  protected final String TEXT_233 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_234 = " - Start to produce queue: \" + ";
  protected final String TEXT_235 = ");" + NL + "\t\t";
  protected final String TEXT_236 = NL + "\t\t\tif(producer_";
  protected final String TEXT_237 = "!=null){" + NL + "\t\t\t\t";
  protected final String TEXT_238 = NL + "\t\t\t\t\t\tproducer_";
  protected final String TEXT_239 = ".setTimeToLive(";
  protected final String TEXT_240 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_241 = NL + "\t\t\t\t\t\tproducer_";
  protected final String TEXT_242 = ".setPriority(";
  protected final String TEXT_243 = ");\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_244 = NL + "\t\t\t\t\t\tproducer_";
  protected final String TEXT_245 = ".setDisableMessageTimestamp(false);" + NL + "\t\t\t\t\t";
  protected final String TEXT_246 = NL + "\t\t\t\t\t\tproducer_";
  protected final String TEXT_247 = ".setDeliveryMode(";
  protected final String TEXT_248 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_249 = NL + "\t\t\t}" + NL + "\t\t\tglobalMap.put(\"producer_";
  protected final String TEXT_250 = "\",producer_";
  protected final String TEXT_251 = ");" + NL + "\t\t\tglobalMap.put(\"session_";
  protected final String TEXT_252 = "\",session_";
  protected final String TEXT_253 = ");" + NL + "\t\t\tglobalMap.put(\"connection_";
  protected final String TEXT_254 = "\",connection_";
  protected final String TEXT_255 = ");" + NL + "\t\t";
  protected final String TEXT_256 = NL + "\t";
  protected final String TEXT_257 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	boolean isUseExistConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
	String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");

	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
	String to = ElementParameterParser.getValue(node, "__TO__");
	String deliverMode = ElementParameterParser.getValue(node, "__DELIVERY_MODE__");
	
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	
	boolean failover =  ("true").equals(ElementParameterParser.getValue(node, "__FAILOVER__"));
	
	boolean staticdiscovery =  ("true").equals(ElementParameterParser.getValue(node, "__STATIC__"));
	String connectParamFailover = ElementParameterParser.getValue(node, "__CONNECTION_PARAM_FAILOVER__");
	String connectParamStatic = ElementParameterParser.getValue(node, "__CONNECTION_PARAM_STATIC__");
	
	List<Map<String,String>> servers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SERVERS__");
	List<Map<String,String>> additionalOpts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADDITIONAL_OPTIONS__");

	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	boolean isUseSSL = ("true").equals(ElementParameterParser.getValue(node, "__USE_SSL__"));
	String transProtocol="tcp";
	if(isUseSSL){
		transProtocol = "ssl";
	}
		
	String strHost = null;
	String strPort = null;
	
	boolean setJmsHeader =  ("true").equals(ElementParameterParser.getValue(node, "__SET_JMS_HEADER__"));
	List<Map<String,String>> jmsHeaders = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JMS_HEADERS__");

	IMetadataTable metadata=null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
	}

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
                failover =  ("true").equals(ElementParameterParser.getValue(pNode, "__FAILOVER__"));
			}	
		}
	}
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    	
	if (isUseExistConnection && ("ActiveMQ").equals(serverType))  { 
	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_10);
    
			}
			
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_13);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
			}
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_21);
    
			}
			
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_24);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
			}
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
			if (("Queue").equals(msgType)) {
			
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_36);
    
			} else {
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_40);
    
			}
			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    
			if ("N_PERSISTENT".equals(deliverMode)) {
			
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    
			} else if ("PERSISTENT".equals(deliverMode)) {
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
			}
			
    stringBuffer.append(TEXT_49);
    
		if(!isCommitRollback && transacted){
		
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
		}
		
    stringBuffer.append(TEXT_57);
    	
	} else if (("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)) {// server judgement
	
	/*---------------------------------------1.initial jms connection factry---------------------------------*/ 
		if(("JBoss").equals(serverType)){ 
		
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
		}else if(("ActiveMQ").equals(serverType)) {
		
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    if(failover || staticdiscovery){
      		if(failover){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(connectParamFailover);
    stringBuffer.append(TEXT_74);
    }else if(staticdiscovery){
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(connectParamStatic);
    stringBuffer.append(TEXT_78);
    }
				int i=0;
				for(Map<String, String> serversMap : servers) {
					strHost = serversMap.get("SERVERS_HOST");
					strPort = serversMap.get("SERVERS_PORT");
	
					if(i>0) {
					
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    
					}
					
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(transProtocol);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(strHost);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(strPort);
    stringBuffer.append(TEXT_93);
    
					i++;
				}
				
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    
				for(Map<String, String> optrion : additionalOpts) {
				
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(optrion.get("OPTION_NAME"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(optrion.get("OPTION_VALUE"));
    stringBuffer.append(TEXT_102);
    
				}
			}else{
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(transProtocol);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_107);
    }
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(!("Queue").equals(msgType));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_111);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    
			}
			
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
		}
		
		/*---------------------------------------2.create Queue Or Topic from connection ---------------------------------*/ 
		
    stringBuffer.append(TEXT_118);
    
		if(dbuser == null || ("\"\"").equals(dbuser) || ("").equals(dbuser)) { 
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    
		} else { 
		
    stringBuffer.append(TEXT_122);
    
			String passwordFieldName = "__PASS__";
			
    stringBuffer.append(TEXT_123);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_126);
    } else {
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
		} 
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
		}
		
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
		}
		
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(transacted);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(acknowledgmentMode);
    stringBuffer.append(TEXT_147);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
		}
		
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    
		if (("Queue").equals(msgType)) {
		
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_155);
    
		} else {
		
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_159);
    
		}
		
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    
		if ("N_PERSISTENT".equals(deliverMode)) {
		
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    
		} else if ("PERSISTENT".equals(deliverMode)) {
		
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    
		}
		
    stringBuffer.append(TEXT_168);
    if(!isCommitRollback && transacted){
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    
		}
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(!("Queue").equals(msgType));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_179);
    
		}
	} else if(("WebSphere").equals(serverType)){ //server judgement   /***WebSphere MQ*****/
		
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
		String queue = ElementParameterParser.getValue(node, "__QUEUE__");
		if(isUseExistConnection){
			String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
			
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
		}else{
			String channel=ElementParameterParser.getValue(node, "__CHANNEL__");
			String qm=ElementParameterParser.getValue(node, "__QM__");
			boolean needSSLCipher = ("true").equals(ElementParameterParser.getValue(node,"__SET_MQ_SSL_CIPHER__"));
			String sslCipher = ElementParameterParser.getValue(node, "__MQ_SSL_CIPHER__");
			
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(channel);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    
			if(needSSLCipher){
			
    stringBuffer.append(TEXT_196);
    stringBuffer.append(sslCipher);
    stringBuffer.append(TEXT_197);
    
			}
			if(!(dbuser == null) && !("\"\"").equals(dbuser) && !("").equals(dbuser)) {
			
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_200);
    
				String passwordFieldName = "__PASS__";
				
    stringBuffer.append(TEXT_201);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_204);
    } else {
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_207);
    }
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    
			}
			
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
			}
		}
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_221);
    
		}
		
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_225);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    
		}
		
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    	    
	    if (transacted) {
		
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    
	    }
	    if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_235);
    
		}
	}
	if(("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)){
		if(setJmsHeader && jmsHeaders !=null && jmsHeaders.size()>0){
		
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    
				for(Map<String,String> header:jmsHeaders) {
					java.util.List<String> senderHeaderParams = java.util.Arrays.asList(new String[]{"JMSExpiration","JMSPriority","JMSTimestamp","JMSDeliveryMode"});
					String senderHeaderParam = header.get("JMS_HEADER_NAME");
					if(!senderHeaderParams.contains(senderHeaderParam)){
						continue;
					}
					if("JMSExpiration".equals(senderHeaderParam)){
					
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(header.get("JMS_HEADER_VALUE"));
    stringBuffer.append(TEXT_240);
    
					}
					if("JMSPriority".equals(senderHeaderParam)){
					
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(header.get("JMS_HEADER_VALUE"));
    stringBuffer.append(TEXT_243);
    
					}
					if("JMSTimestamp".equals(senderHeaderParam)){
					
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    
					}
					if("JMSDeliveryMode".equals(senderHeaderParam)){
					
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(header.get("JMS_HEADER_VALUE"));
    stringBuffer.append(TEXT_248);
    
					}
				}
				
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    
		}
	}
	
    stringBuffer.append(TEXT_256);
    stringBuffer.append(TEXT_257);
    return stringBuffer.toString();
  }
}
