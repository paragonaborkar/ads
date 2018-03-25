package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IDataConnection;

public class THashBeginJava
{
  protected static String nl;
  public static synchronized THashBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THashBeginJava result = new THashBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tsynchronized (this) {" + NL + "\t\t\t\t\tif (globalMap.get(\"tHash_";
  protected final String TEXT_3 = "\") == null) {" + NL + "\t\t\t            java.util.Map<";
  protected final String TEXT_4 = "Struct, ";
  protected final String TEXT_5 = "Struct> tHash_";
  protected final String TEXT_6 = " = null;" + NL + "\t\t\t            boolean isMultiThreaded_";
  protected final String TEXT_7 = " = false;" + NL + "\t\t\t            if (!(globalMap.get(\"MULTI_THREADED_JOB_";
  protected final String TEXT_8 = "_\"+jobName) == null || !((Boolean)globalMap.get(\"MULTI_THREADED_JOB_";
  protected final String TEXT_9 = "_\"+jobName)))) {" + NL + "\t\t\t            \ttHash_";
  protected final String TEXT_10 = " = new java.util.concurrent.ConcurrentHashMap<";
  protected final String TEXT_11 = "Struct,";
  protected final String TEXT_12 = "Struct>();" + NL + "\t\t\t            \tisMultiThreaded_";
  protected final String TEXT_13 = " = true;" + NL + "\t\t\t            } else {" + NL + "\t\t\t              \ttHash_";
  protected final String TEXT_14 = " = new java.util.LinkedHashMap<";
  protected final String TEXT_15 = "Struct, ";
  protected final String TEXT_16 = "Struct>();" + NL + "\t\t\t            }" + NL + "\t\t\t            globalMap.put(\"tHash_";
  protected final String TEXT_17 = "\", tHash_";
  protected final String TEXT_18 = ");" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\tjava.util.Map<";
  protected final String TEXT_20 = "Struct, ";
  protected final String TEXT_21 = "Struct> tHash_";
  protected final String TEXT_22 = " = new java.util.LinkedHashMap<";
  protected final String TEXT_23 = "Struct, ";
  protected final String TEXT_24 = "Struct>();" + NL + "\t            globalMap.put(\"tHash_";
  protected final String TEXT_25 = "\", tHash_";
  protected final String TEXT_26 = ");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "            ";
  protected final String TEXT_28 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();
	boolean includeParallelComps = false;
	if (connections != null && connections.size() > 0) {
        for (IConnection connection : connections) {
        	String connectionName = connection.getName();
        	INode validTarget = ((IDataConnection) connection).getLinkNodeForHash();
        	INode partitionNode = null;
        	if(validTarget != null) {
            	partitionNode = validTarget.getDesignSubjobStartNode();
	   			if ("tCollector".equals(partitionNode.getComponent().getName())) {
					includeParallelComps = true;
					partitionNode = partitionNode.getIncomingConnections(EConnectionType.STARTS).get(0).getSource();
				}
			}
			if (includeParallelComps && partitionNode!=null) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(partitionNode.getUniqueName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(partitionNode.getUniqueName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_18);
    	
			} else {
			
    stringBuffer.append(TEXT_19);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_26);
    
			}
		}
	}


    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
