package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TMicrosoftMQInputBeginJava
{
  protected static String nl;
  public static synchronized TMicrosoftMQInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftMQInputBeginJava result = new TMicrosoftMQInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\torg.talend.msmq.MsmqUtil msgu_";
  protected final String TEXT_3 = " = new org.talend.msmq.MsmqUtil();" + NL + "\t    try{" + NL + "\t    \tmsgu_";
  protected final String TEXT_4 = ".setHost(";
  protected final String TEXT_5 = ");" + NL + "\t   \t\tmsgu_";
  protected final String TEXT_6 = ".setQueue(";
  protected final String TEXT_7 = "); " + NL + "\t   \t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tmsgu_";
  protected final String TEXT_9 = ".setQueueType(\"\"); " + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t    \tmsgu_";
  protected final String TEXT_11 = ".open();" + NL + "\t    \tif (msgu_";
  protected final String TEXT_12 = ".isOpen()){" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t    " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = " = msgu_";
  protected final String TEXT_16 = ".receive();" + NL + "\t\t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();  
	List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
	    
	String host = ElementParameterParser.getValue(node, "__HOST__");
	String queue = ElementParameterParser.getValue(node, "__QUEUE__");
	String queueType = ElementParameterParser.getValue(node, "__QUEUE_TYPE__");
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
	if (outConns != null && outConns.size() > 0){
	
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
    
	   		if("PUBLIC".equals(queueType)){
			
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
			}
	   		
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
				String connNameOut = outConns.get(0).getName();
				if (outConns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
					IMetadataTable outTable = outConns.get(0).getMetadataTable();
					List<IMetadataColumn> columns = outTable.getListColumns();
					if (columns != null && columns.size() > 0){
					
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(columns.get(0).getLabel());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
					}
				}
	}
	
    return stringBuffer.toString();
  }
}
