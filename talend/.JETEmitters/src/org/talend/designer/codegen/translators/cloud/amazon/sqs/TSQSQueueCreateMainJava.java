package org.talend.designer.codegen.translators.cloud.amazon.sqs;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSQSQueueCreateMainJava
{
  protected static String nl;
  public static synchronized TSQSQueueCreateMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSQSQueueCreateMainJava result = new TSQSQueueCreateMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t";
  protected final String TEXT_3 = NL + "\t\tcom.amazonaws.services.sqs.AmazonSQS conn_";
  protected final String TEXT_4 = " = (com.amazonaws.services.sqs.AmazonSQSClient)globalMap.get(\"";
  protected final String TEXT_5 = "\");" + NL + "\t\t";
  protected final String TEXT_6 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Get an free connection from \" + \"";
  protected final String TEXT_8 = "\" + \".\");" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t    ";
  protected final String TEXT_10 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Creating new connection.\");" + NL + "\t\t";
  protected final String TEXT_12 = NL + "    " + NL + "    \t";
  protected final String TEXT_13 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "; ";
  protected final String TEXT_19 = NL + NL + "\t\tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_20 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_21 = ",decryptedPassword_";
  protected final String TEXT_22 = ");" + NL + "\t\tcom.amazonaws.auth.AWSCredentialsProvider credentialsProvider_";
  protected final String TEXT_23 = " = new com.amazonaws.internal.StaticCredentialsProvider(credentials_";
  protected final String TEXT_24 = ");" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t\tcom.amazonaws.auth.AWSCredentialsProvider credentialsProvider_";
  protected final String TEXT_26 = " = new com.amazonaws.auth.InstanceProfileCredentialsProvider();" + NL + "\t\t";
  protected final String TEXT_27 = NL + "\t\tcom.amazonaws.ClientConfiguration cc_";
  protected final String TEXT_28 = " = new com.amazonaws.ClientConfiguration();" + NL + "\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t\tint scketSendBufferSizeHints_";
  protected final String TEXT_30 = " = 0;" + NL + "\t\t\t\t\tint socketReceiveBufferSizeHints_";
  protected final String TEXT_31 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\tscketSendBufferSizeHints_";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\tsocketReceiveBufferSizeHints_";
  protected final String TEXT_36 = " = ";
  protected final String TEXT_37 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_39 = ".setProtocol(com.amazonaws.Protocol.";
  protected final String TEXT_40 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_42 = ".set";
  protected final String TEXT_43 = "(";
  protected final String TEXT_44 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\tcc_";
  protected final String TEXT_46 = ".setSocketBufferSizeHints(scketSendBufferSizeHints_";
  protected final String TEXT_47 = ",socketReceiveBufferSizeHints_";
  protected final String TEXT_48 = ");" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\tint sessionDurationSeconds_";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = " * 60;" + NL + "\t\t\tcom.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder stsBuilder_";
  protected final String TEXT_52 = " = " + NL + "\t\t\t\t\tnew com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder(";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ").withLongLivedCredentialsProvider(credentialsProvider_";
  protected final String TEXT_55 = ")" + NL + "\t\t\t\t\t.withRoleSessionDurationSeconds(sessionDurationSeconds_";
  protected final String TEXT_56 = ");" + NL + "\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\tstsBuilder_";
  protected final String TEXT_58 = ".withServiceEndpoint(";
  protected final String TEXT_59 = ");" + NL + "\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\tstsBuilder_";
  protected final String TEXT_61 = ".withClientConfiguration(cc_";
  protected final String TEXT_62 = ");" + NL + "\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t" + NL + "\t\t\tcredentialsProvider_";
  protected final String TEXT_64 = " = stsBuilder_";
  protected final String TEXT_65 = ".build();" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_66 = NL + "\t\tcom.amazonaws.services.sqs.AmazonSQS conn_";
  protected final String TEXT_67 = " = new com.amazonaws.services.sqs.AmazonSQSClient(" + NL + "\t\t\t\t\tcredentialsProvider_";
  protected final String TEXT_68 = "," + NL + "\t\t\t\t\tcc_";
  protected final String TEXT_69 = ");" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\t\tconn_";
  protected final String TEXT_71 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_72 = "));" + NL + "\t\t";
  protected final String TEXT_73 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_74 = " - Creating new connection successfully.\");" + NL + "\t\t";
  protected final String TEXT_75 = NL + "\ttry{" + NL + "\t\t";
  protected final String TEXT_76 = NL + "\t\t\tjava.util.Map<String,String> attributes_";
  protected final String TEXT_77 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\tattributes_";
  protected final String TEXT_79 = ".put(\"";
  protected final String TEXT_80 = "\",String.valueOf(";
  protected final String TEXT_81 = "));" + NL + "\t\t\t\t";
  protected final String TEXT_82 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_83 = " - Creating a queue with name:\" + ";
  protected final String TEXT_84 = ");" + NL + "\t\t";
  protected final String TEXT_85 = NL + "\t\tcom.amazonaws.services.sqs.model.CreateQueueRequest createQueueRequest_";
  protected final String TEXT_86 = " = new com.amazonaws.services.sqs.model.CreateQueueRequest(";
  protected final String TEXT_87 = ")";
  protected final String TEXT_88 = ".withAttributes(attributes_";
  protected final String TEXT_89 = ")";
  protected final String TEXT_90 = ";" + NL + "        String queueUrl_";
  protected final String TEXT_91 = " = conn_";
  protected final String TEXT_92 = ".createQueue(createQueueRequest_";
  protected final String TEXT_93 = ").getQueueUrl();" + NL + "\t\t";
  protected final String TEXT_94 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_95 = " - Create the queue successfully [\" + queueUrl_";
  protected final String TEXT_96 = " + \"]\");" + NL + "\t\t";
  protected final String TEXT_97 = NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_98 = "){" + NL + "\t\t";
  protected final String TEXT_99 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_100 = ");" + NL + "\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_102 = " - \" + e_";
  protected final String TEXT_103 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_104 = NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_105 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_106 = NL + "\t}finally{" + NL + "\t\tif(conn_";
  protected final String TEXT_107 = " !=null){" + NL + "\t\t\tconn_";
  protected final String TEXT_108 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_109 = NL + "\t}" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String queue = ElementParameterParser.getValue(node,"__QUEUE__");
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	List<Map<String,String>> queueAttributes = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__QUEUE_ATTRIBUTES__");
	
    stringBuffer.append(TEXT_2);
    
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	boolean configClient = "true".equals(ElementParameterParser.getValue(node, "__CONFIG_CLIENT__"));
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	List<Map<String,String>> clientConfiguration = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CLIENT_CONFIGURATION__");
	String region = ElementParameterParser.getValue(node,"__REGION__");
	
	boolean assumeRole = "true".equals(ElementParameterParser.getValue(node, "__ASSUME_ROLE__"));
	String arn = ElementParameterParser.getValue(node,"__ARN__");
	String roleSessionName = ElementParameterParser.getValue(node,"__ROLE_SESSION_NAME__");
	
	boolean setStsEndpoint = "true".equals(ElementParameterParser.getValue(node,"__SET_STS_ENDPOINT__"));
	String stsEndpoint = ElementParameterParser.getValue(node,"__STS_ENDPOINT__");
	
	String sessionDuration = ElementParameterParser.getValue(node,"__SESSION_DURATION__");
	if(sessionDuration == null || sessionDuration.isEmpty()) {
		sessionDuration = "15";
	}
	
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;;
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_5);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_8);
    
		}
	}else{
	
    stringBuffer.append(TEXT_9);
    
	    if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		}
		boolean inherit_credentials = "true".equals(ElementParameterParser.getValue(node, "__INHERIT_CREDENTIALS__"));
		if(!inherit_credentials) {
	    	String passwordFieldName = "__SECRET_KEY__";
	    
    stringBuffer.append(TEXT_12);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    } else {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
		} else {
		
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
		}
		
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
		boolean configClientPresent = false;
		if(configClient && clientConfiguration.size()>0){
			configClientPresent = true;
			boolean setBuffer = false;
			for(Map<String,String> map :clientConfiguration){
				String client_parameter = map.get("CLIENT_PARAMETER");
				String value = map.get("VALUE");
				if(!setBuffer && ("SocketSendBufferSizeHints".equals(client_parameter) || "SocketReceiveBufferSizeHints".equals(client_parameter))){
					setBuffer=true;
					
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
				}
				if("SocketSendBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_34);
    
				}else if("SocketReceiveBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_37);
    
				}else if("Protocol".equals(client_parameter)){
				
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(value.toUpperCase().replaceAll("\"",""));
    stringBuffer.append(TEXT_40);
    
				}else{
				
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(client_parameter);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_44);
    
				}
			}
			if(setBuffer){
			
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
			}
		}
		if(assumeRole) {
		
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(sessionDuration);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(arn);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(roleSessionName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
			if(setStsEndpoint) {
			
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(stsEndpoint);
    stringBuffer.append(TEXT_59);
    
			}
			
			if(configClientPresent) {
			
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
			}
			
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
		}
		
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
		if(region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region)){
		
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_72);
    
		}
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
		}
	}
	
    stringBuffer.append(TEXT_75);
    
		if(queueAttributes.size()>0){
			
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
			for(java.util.Map<String,String> map :queueAttributes){
				String attribute = map.get("ATTRIBUTE");
				String value = map.get("VALUE");
				if(attribute!=null && !attribute.trim().isEmpty()){
				
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(attribute);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_81);
    
				}
			}
		}
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_84);
    
		}
		
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_87);
    if(queueAttributes.size()>0){
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
		}
		
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
		if (("true").equals(dieOnError)) {
		
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
		} else {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
			}
			
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
		}
		if(!("true").equals(useExistingConn)) {
		
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
		}
		
    stringBuffer.append(TEXT_109);
    return stringBuffer.toString();
  }
}
