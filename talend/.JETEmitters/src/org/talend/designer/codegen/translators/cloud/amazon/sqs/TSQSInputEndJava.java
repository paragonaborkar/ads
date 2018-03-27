package org.talend.designer.codegen.translators.cloud.amazon.sqs;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSQSInputEndJava
{
  protected static String nl;
  public static synchronized TSQSInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSQSInputEndJava result = new TSQSInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + NL + "\t\t\t} //for loop" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "        \t\t\tisContinueReceive_";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = "_messages.size() > 0;" + NL + "     \t\t";
  protected final String TEXT_6 = NL + "     \t\t\t\tisContinueReceive_";
  protected final String TEXT_7 = " = false;" + NL + "     \t\t";
  protected final String TEXT_8 = NL + "     \t\t";
  protected final String TEXT_9 = "_messages = null;" + NL + "    \t} // while loop" + NL + "\t\t" + NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_10 = "){" + NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_12 = ");" + NL + "\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_14 = " - \" + e_";
  protected final String TEXT_15 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_17 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_18 = NL + "\t}finally{" + NL + "\t\tif(conn_";
  protected final String TEXT_19 = " !=null){" + NL + "\t\t\tconn_";
  protected final String TEXT_20 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.info(\"Number of Messages Read: \" + nbline_";
  protected final String TEXT_22 = ");" + NL + "\t\t";
  protected final String TEXT_23 = NL + "\t}" + NL + "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_24 = "_NB_LINE\", nbline_";
  protected final String TEXT_25 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String queueUrl = ElementParameterParser.getValue(node,"__QUEUE_URL__");
    boolean deleteMessages = "true".equals(ElementParameterParser.getValue(node,"__DELETE_MESSAGE__"));
    boolean readAllMessages = "true".equals(ElementParameterParser.getValue(node,"__READ_ALL_MESSAGE__"));
    boolean dieOnError = "true".equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	
    stringBuffer.append(TEXT_2);
    
			if (deleteMessages && readAllMessages){
    		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
     			} else {
     		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    	
     			}
     		
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
		if (dieOnError) {
		
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
		} else {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
			}
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		}
		if(!("true").equals(useExistingConn)) {
		
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
			if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
			}
		}
		
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
