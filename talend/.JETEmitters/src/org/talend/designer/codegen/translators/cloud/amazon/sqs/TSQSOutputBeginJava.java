package org.talend.designer.codegen.translators.cloud.amazon.sqs;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSQSOutputBeginJava
{
  protected static String nl;
  public static synchronized TSQSOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSQSOutputBeginJava result = new TSQSOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t";
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
  protected final String TEXT_75 = NL + "\t" + NL + "\t" + NL + "\tint nbline_";
  protected final String TEXT_76 = " = 0;" + NL + "\tint nb_success_";
  protected final String TEXT_77 = " = 0;" + NL + "\tint nb_reject_";
  protected final String TEXT_78 = " = 0;" + NL + "\t";
  protected final String TEXT_79 = NL + "\t\tjava.util.List<com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry> entries_";
  protected final String TEXT_80 = " = new java.util.ArrayList<>();" + NL + "\t\tjava.util.List<com.amazonaws.services.sqs.model.BatchResultErrorEntry> resultErrorEntries_";
  protected final String TEXT_81 = " = null;" + NL + "\t\tjava.util.List<com.amazonaws.services.sqs.model.SendMessageBatchResultEntry> resultSuccessEntries_";
  protected final String TEXT_82 = " = null;" + NL + "\t";
  protected final String TEXT_83 = NL + "\tcom.amazonaws.services.sqs.model.";
  protected final String TEXT_84 = " sendMsgRequest_";
  protected final String TEXT_85 = " = null;" + NL + "\ttry{" + NL + "\t\t";
  protected final String TEXT_86 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_87 = " - Sending messages to :\" + ";
  protected final String TEXT_88 = ");" + NL + "\t\t";
  protected final String TEXT_89 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String queueUrl = ElementParameterParser.getValue(node,"__QUEUE_URL__");
    boolean dieOnError = "true".equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
    boolean useBatch = "true".equals(ElementParameterParser.getValue(node,"__USE_BATCH__"));
	
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
	if(useBatch){
	
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
	}
	
    stringBuffer.append(TEXT_83);
    stringBuffer.append(useBatch?"SendMessageBatchRequest":"SendMessageRequest");
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(queueUrl);
    stringBuffer.append(TEXT_88);
    
		}
		
    stringBuffer.append(TEXT_89);
    return stringBuffer.toString();
  }
}
