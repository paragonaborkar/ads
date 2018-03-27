package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TMicrosoftMQOutputBeginJava
{
  protected static String nl;
  public static synchronized TMicrosoftMQOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftMQOutputBeginJava result = new TMicrosoftMQOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\torg.talend.msmq.MsmqUtil msgu_";
  protected final String TEXT_3 = " = new org.talend.msmq.MsmqUtil();" + NL + "\t\t\ttry{" + NL + "\t\t\t\tmsgu_";
  protected final String TEXT_4 = ".setHost(";
  protected final String TEXT_5 = ");" + NL + "\t\t\t\tmsgu_";
  protected final String TEXT_6 = ".setQueue(";
  protected final String TEXT_7 = "); " + NL + "\t\t\t\tmsgu_";
  protected final String TEXT_8 = ".createIfNotExists(";
  protected final String TEXT_9 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\tmsgu_";
  protected final String TEXT_11 = ".setQueueType(\"\"); " + NL + "\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\tmsgu_";
  protected final String TEXT_13 = ".setIsTransaction(true);" + NL + "\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\tmsgu_";
  protected final String TEXT_15 = ".open();" + NL + "\t\t\t\tresourceMap.put(\"msgu_";
  protected final String TEXT_16 = "\", msgu_";
  protected final String TEXT_17 = ");" + NL + "\t\t\t}catch(java.net.UnknownHostException ex_";
  protected final String TEXT_18 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\tthrow ex_";
  protected final String TEXT_20 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\tSystem.err.println(\"Unknown host :\" + ex_";
  protected final String TEXT_22 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t}catch(ionic.Msmq.MessageQueueException e_";
  protected final String TEXT_24 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\tthrow e_";
  protected final String TEXT_26 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\tSystem.out.println(\"Queue creation failure: \" +e_";
  protected final String TEXT_28 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t}" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	List< ? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
	String queueType = ElementParameterParser.getValue(node, "__QUEUE_TYPE__");
	boolean isCreateQueueNotExist = ("true").equals(ElementParameterParser.getValue(node,"__CREATE_QUEUE_NOT_EXIST__"));
	   
	if (inConns != null && inConns.size() > 0){
		IMetadataTable inTable = inConns.get(0).getMetadataTable();
		List<IMetadataColumn> columns = inTable.getListColumns();
	
		if (columns != null && columns.size() > 0){
			String host = ElementParameterParser.getValue(node, "__HOST__");
			String queue = ElementParameterParser.getValue(node, "__QUEUE__");
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(isCreateQueueNotExist);
    stringBuffer.append(TEXT_9);
    
		   		if(queueType!=null && queueType.endsWith("PUBLIC")){
				
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
				}
				if(queueType!=null && queueType.startsWith("TRANSACTION")){
				
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
				}
		   		
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
				if(dieOnError){
				
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
				}else{
				
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
				}
				
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
				if(dieOnError){
				
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
				}else{
				
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
				}
				
    stringBuffer.append(TEXT_29);
    
		}
	}
	
    return stringBuffer.toString();
  }
}
