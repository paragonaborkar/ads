package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.EConnectionType;
import java.util.List;

public class TMicrosoftMQOutputMainJava
{
  protected static String nl;
  public static synchronized TMicrosoftMQOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftMQOutputMainJava result = new TMicrosoftMQOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t    if (";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = " != null){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tif (msgu_";
  protected final String TEXT_5 = ".isOpen()){" + NL + "\t\t\t        \tmsgu_";
  protected final String TEXT_6 = ".setMsg(";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = ");" + NL + "\t\t\t        \tmsgu_";
  protected final String TEXT_9 = ".send();" + NL + "\t\t\t      \t}" + NL + "\t\t    \t}catch(ionic.Msmq.MessageQueueException e_";
  protected final String TEXT_10 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\t\tthrow e_";
  protected final String TEXT_12 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\tSystem.out.println(\"Send failure: \" + e_";
  protected final String TEXT_14 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t}catch(java.io.UnsupportedEncodingException ex_";
  protected final String TEXT_16 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_18 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\tSystem.out.println(\"Unsupported encoding: \" + ex_";
  protected final String TEXT_20 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";

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
		String connNameIn = inConns.get(0).getName();
		IMetadataTable inTable = inConns.get(0).getMetadataTable();
		List<IMetadataColumn> columns = inTable.getListColumns();
		String message = ElementParameterParser.getValue(node, "__MESSAGE__");
	
		if (columns != null && columns.size() > 0){
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connNameIn);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(columns.get(0).getLabel());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connNameIn);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
					if(dieOnError){
					
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
					}else{
					
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
					}
					
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
					if(dieOnError){
					
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
					}else{
					
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
					}
					
    stringBuffer.append(TEXT_21);
    
		}
	}
	
    return stringBuffer.toString();
  }
}
