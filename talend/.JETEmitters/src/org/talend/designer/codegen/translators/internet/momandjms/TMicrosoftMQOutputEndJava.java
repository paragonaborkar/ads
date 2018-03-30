package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TMicrosoftMQOutputEndJava
{
  protected static String nl;
  public static synchronized TMicrosoftMQOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftMQOutputEndJava result = new TMicrosoftMQOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\ttry{" + NL + "\t\t\t\tif (msgu_";
  protected final String TEXT_3 = ".isOpen()){" + NL + "\t\t\t\t\tmsgu_";
  protected final String TEXT_4 = ".close();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tresourceMap.put(\"finish_";
  protected final String TEXT_5 = "\", true);" + NL + "\t\t\t}catch(ionic.Msmq.MessageQueueException e_";
  protected final String TEXT_6 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t\tthrow e_";
  protected final String TEXT_8 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\tSystem.out.println(\"Close failure: \" + e_";
  protected final String TEXT_10 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t}" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();  
	List< ? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
	    
	if (inConns != null && inConns.size() > 0){
		IMetadataTable inTable = inConns.get(0).getMetadataTable();
		List<IMetadataColumn> columns = inTable.getListColumns();
	      
		if (columns != null && columns.size() > 0){
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
				if(dieOnError){
				
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
				}else{
				
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
				}
				
    stringBuffer.append(TEXT_11);
    
		}
	}
	
    return stringBuffer.toString();
  }
}
