package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMomConnectionBeginJava
{
  protected static String nl;
  public static synchronized TMomConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomConnectionBeginJava result = new TMomConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t\t/*---------------------------------------1.initial jms connection factry---------------------------------*/ " + NL + "\t" + NL + "\t\tString url_";
  protected final String TEXT_3 = " =\"\";" + NL + "\t\tString endParam_";
  protected final String TEXT_4 = " = \"\";" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\turl_";
  protected final String TEXT_6 = " = \"failover:(\";" + NL + "\t\t\t\tendParam_";
  protected final String TEXT_7 = "=";
  protected final String TEXT_8 = ";" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\turl_";
  protected final String TEXT_10 = " = \"discovery://static:(\";" + NL + "\t\t\t\tendParam_";
  protected final String TEXT_11 = "=";
  protected final String TEXT_12 = ";" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_14 = " = url_";
  protected final String TEXT_15 = " +\",\";" + NL + "\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\turl_";
  protected final String TEXT_17 = " = url_";
  protected final String TEXT_18 = " +\"";
  protected final String TEXT_19 = "://\";" + NL + "\t\t\t\turl_";
  protected final String TEXT_20 = " = url_";
  protected final String TEXT_21 = " +";
  protected final String TEXT_22 = ";" + NL + "\t\t\t\turl_";
  protected final String TEXT_23 = " = url_";
  protected final String TEXT_24 = " +\":\";" + NL + "\t\t\t\turl_";
  protected final String TEXT_25 = " = url_";
  protected final String TEXT_26 = " +";
  protected final String TEXT_27 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\turl_";
  protected final String TEXT_29 = " = url_";
  protected final String TEXT_30 = " +\")\"+endParam_";
  protected final String TEXT_31 = ";" + NL + "\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\turl_";
  protected final String TEXT_33 = " = url_";
  protected final String TEXT_34 = " +\"&\"+";
  protected final String TEXT_35 = "+\"=\"+";
  protected final String TEXT_36 = ";" + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\turl_";
  protected final String TEXT_38 = " = \"";
  protected final String TEXT_39 = "://\"+";
  protected final String TEXT_40 = "+\":\"+";
  protected final String TEXT_41 = ";" + NL + "\t\t";
  protected final String TEXT_42 = "\t\t\t" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_43 = NL + "\t\t\t";
  protected final String TEXT_44 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_45 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_48 = " = ";
  protected final String TEXT_49 = "; ";
  protected final String TEXT_50 = NL + "\t\t";
  protected final String TEXT_51 = NL + "\t\t\tjavax.jms.Connection connection_";
  protected final String TEXT_52 = " = org.talend.mq.SharedActiveMQConnection.getMQConnection(url_";
  protected final String TEXT_53 = ",";
  protected final String TEXT_54 = ",decryptedPassword_";
  protected final String TEXT_55 = ",";
  protected final String TEXT_56 = ");" + NL + "\t\t";
  protected final String TEXT_57 = NL + "\t\t\tSystem.out.println(\"Connecting to URL: \" + url_";
  protected final String TEXT_58 = ");" + NL + "\t\t\torg.apache.activemq.ActiveMQConnectionFactory factory_";
  protected final String TEXT_59 = " = " + NL + "\t\t\t\tnew org.apache.activemq.ActiveMQConnectionFactory(url_";
  protected final String TEXT_60 = ");" + NL + "\t\t\t";
  protected final String TEXT_61 = "\t" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\tjavax.jms.Connection connection_";
  protected final String TEXT_63 = " = factory_";
  protected final String TEXT_64 = ".createConnection();" + NL + "\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\tjavax.jms.Connection connection_";
  protected final String TEXT_66 = " = factory_";
  protected final String TEXT_67 = ".createConnection(";
  protected final String TEXT_68 = ",decryptedPassword_";
  protected final String TEXT_69 = ");" + NL + "\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t";
  protected final String TEXT_71 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_72 = " - Created connection successfully.\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_73 = " - Activating the connection...\");" + NL + "\t\t\t";
  protected final String TEXT_74 = NL + "\t\t" + NL + "\t\t    connection_";
  protected final String TEXT_75 = ".start();" + NL + "\t\t    ";
  protected final String TEXT_76 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_77 = " - Activated successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_78 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_79 = " - Creating a session...\");" + NL + "\t\t";
  protected final String TEXT_80 = NL + "\t\t" + NL + "\t    globalMap.put(\"connection_";
  protected final String TEXT_81 = "\", connection_";
  protected final String TEXT_82 = ");" + NL + "\t    javax.jms.Session session_";
  protected final String TEXT_83 = " = connection_";
  protected final String TEXT_84 = ".createSession(";
  protected final String TEXT_85 = ", javax.jms.Session.";
  protected final String TEXT_86 = ");" + NL + "\t    globalMap.put(\"session_";
  protected final String TEXT_87 = "\", session_";
  protected final String TEXT_88 = ");" + NL + "\t\t";
  protected final String TEXT_89 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_90 = " - Created session successfully.\");" + NL + "\t\t";
  protected final String TEXT_91 = NL + "\t\tjava.util.Hashtable properties";
  protected final String TEXT_92 = "=new java.util.Hashtable();" + NL + "\t\tproperties";
  protected final String TEXT_93 = ".put(\"hostname\", ";
  protected final String TEXT_94 = ");" + NL + "\t\tproperties";
  protected final String TEXT_95 = ".put(\"port\", Integer.valueOf(";
  protected final String TEXT_96 = "));" + NL + "\t\tproperties";
  protected final String TEXT_97 = ".put(\"channel\", ";
  protected final String TEXT_98 = ");" + NL + "\t\tproperties";
  protected final String TEXT_99 = ".put(\"CCSID\", new Integer(1208));" + NL + "\t\tproperties";
  protected final String TEXT_100 = ".put(\"transport\",\"MQSeries\");" + NL + "\t\t";
  protected final String TEXT_101 = NL + "\t\t\tcom.ibm.mq.MQEnvironment.sslCipherSuite = \"";
  protected final String TEXT_102 = "\";" + NL + "\t\t";
  protected final String TEXT_103 = NL + "\t\t\tproperties";
  protected final String TEXT_104 = ".put(\"userID\",";
  protected final String TEXT_105 = ");" + NL + "\t\t\t";
  protected final String TEXT_106 = NL + NL + "\t\t\t";
  protected final String TEXT_107 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_108 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_111 = " = ";
  protected final String TEXT_112 = "; ";
  protected final String TEXT_113 = NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tproperties";
  protected final String TEXT_114 = ".put(\"password\",decryptedPassword_";
  protected final String TEXT_115 = ");" + NL + "\t\t";
  protected final String TEXT_116 = NL + "\t\t\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_117 = " =  org.talend.mq.SharedWebSphereMQConnection.getMQConnection(";
  protected final String TEXT_118 = ",properties";
  protected final String TEXT_119 = ",";
  protected final String TEXT_120 = ");" + NL + "\t\t";
  protected final String TEXT_121 = NL + "\t\t\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_122 = " = new com.ibm.mq.MQQueueManager(";
  protected final String TEXT_123 = ",properties";
  protected final String TEXT_124 = ");" + NL + "\t\t";
  protected final String TEXT_125 = NL + "\t\tglobalMap.put(\"qMgr_";
  protected final String TEXT_126 = "\", qMgr_";
  protected final String TEXT_127 = " );" + NL + "\t";
  protected final String TEXT_128 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	boolean isUseSSL = ("true").equals(ElementParameterParser.getValue(node, "__USE_SSL__"));
	String transProtocol="tcp";
	if(isUseSSL){
		transProtocol = "ssl";
	}
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_SHARED_CONNECTION__"));
	String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");
	
	
	if(("ActiveMQ").equals(serverType)){/***ActiveMQ*****/
		boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
		String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
		
		boolean staticdiscovery =  ("true").equals(ElementParameterParser.getValue(node, "__STATIC__"));
		String connectParamFailover = ElementParameterParser.getValue(node, "__CONNECTION_PARAM_FAILOVER__");
		String connectParamStatic = ElementParameterParser.getValue(node, "__CONNECTION_PARAM_STATIC__");
		
		boolean failover =  ("true").equals(ElementParameterParser.getValue(node, "__FAILOVER__"));
		List<Map<String,String>> servers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SERVERS__");
		List<Map<String,String>> additionalOpts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADDITIONAL_OPTIONS__");
		
		String strHost = null;
		String strPort = null;
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    if(failover || staticdiscovery){
		 	if(failover){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connectParamFailover);
    stringBuffer.append(TEXT_8);
    }else if(staticdiscovery){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connectParamStatic);
    stringBuffer.append(TEXT_12);
    }
			int i=0;
			for(Map<String, String> serversMap : servers) {
				strHost = serversMap.get("SERVERS_HOST");
				strPort = serversMap.get("SERVERS_PORT");
	
				if(i>0) {
				
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
				}
				
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(transProtocol);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(strHost);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(strPort);
    stringBuffer.append(TEXT_27);
    
				i++;
			}
			
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
			for(Map<String, String> optrion : additionalOpts) {
			
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(optrion.get("OPTION_NAME"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(optrion.get("OPTION_VALUE"));
    stringBuffer.append(TEXT_36);
    
			}
		}else{
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(transProtocol);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    
		String passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_43);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_46);
    } else {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    
		if(isUseSharedConnection){
		
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_56);
    
		}else{
		
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
				
				/*---------------------------------------2.create Queue Or Topic from connection ---------------------------------*/ 
			
    stringBuffer.append(TEXT_61);
     if(dbuser == null || ("\"\"").equals(dbuser) || ("").equals(dbuser)) { 
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
     } else { 
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
     } 
    stringBuffer.append(TEXT_70);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
			}
			
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
			}
		}
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
		}
		
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(transacted);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(acknowledgmentMode);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
		}
	}else{	/***WebSphere MQ*****/
	
		String channel=ElementParameterParser.getValue(node, "__CHANNEL__");
		String qm=ElementParameterParser.getValue(node, "__QM__");
		boolean needSSLCipher = ("true").equals(ElementParameterParser.getValue(node,"__SET_MQ_SSL_CIPHER__"));
		String sslCipher = ElementParameterParser.getValue(node, "__MQ_SSL_CIPHER__");
		
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(channel);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
		if(needSSLCipher){
		
    stringBuffer.append(TEXT_101);
    stringBuffer.append(sslCipher);
    stringBuffer.append(TEXT_102);
    
		}
		if(!(dbuser == null) && !("\"\"").equals(dbuser) && !("").equals(dbuser)) {
		
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_105);
    
			String passwordFieldName = "__PASS__";
			
    stringBuffer.append(TEXT_106);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_109);
    } else {
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
		}
		if(isUseSharedConnection){
		
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_120);
    
		}else{
		
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
		}
		
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
	}
	
    stringBuffer.append(TEXT_128);
    return stringBuffer.toString();
  }
}
