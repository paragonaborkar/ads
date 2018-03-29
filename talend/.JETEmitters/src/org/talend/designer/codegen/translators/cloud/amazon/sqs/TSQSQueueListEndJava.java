package org.talend.designer.codegen.translators.cloud.amazon.sqs;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TSQSQueueListEndJava
{
  protected static String nl;
  public static synchronized TSQSQueueListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSQSQueueListEndJava result = new TSQSQueueListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_3 = NL + "\t}finally{" + NL + "\t\tif(conn_";
  protected final String TEXT_4 = " !=null){" + NL + "\t\t\tconn_";
  protected final String TEXT_5 = ".shutdown();" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_6 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_7 = "_NB_QUEUE\", nb_queue_";
  protected final String TEXT_8 = ");" + NL + "\t";
  protected final String TEXT_9 = NL + "\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved queues count: \" + nb_queue_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
    stringBuffer.append(TEXT_2);
    
	if(!("true").equals(useExistingConn)) {
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	}
	
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    		
	}
	
    return stringBuffer.toString();
  }
}
