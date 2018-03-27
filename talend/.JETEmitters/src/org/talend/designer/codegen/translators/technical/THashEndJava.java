package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IDataConnection;

public class THashEndJava
{
  protected static String nl;
  public static synchronized THashEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THashEndJava result = new THashEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tif (isMultiThreaded_";
  protected final String TEXT_2 = ") {" + NL + "\t\t\tjava.util.List<java.util.Map<String,Object>> mapsList_";
  protected final String TEXT_3 = " = " + NL + "\t\t\t\t(java.util.List<java.util.Map<String,Object>>)globalMap.get(\"THREAD_MAPS_";
  protected final String TEXT_4 = "_\"+jobName);" + NL + "\t\t\tif (mapsList_";
  protected final String TEXT_5 = " != null) {" + NL + "\t\t\t\tfor (java.util.Map<String,Object> map : mapsList_";
  protected final String TEXT_6 = ") {" + NL + "\t\t\t\t\tif (globalMap != map) {\t\t" + NL + "\t\t\t\t\t\tmap.put(\"tHash_";
  protected final String TEXT_7 = "\",tHash_";
  protected final String TEXT_8 = ");" + NL + "\t\t\t\t\t} //gm" + NL + "\t\t\t\t}//for" + NL + "\t\t\t}//null" + NL + "\t\t}//is threaded" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();
    boolean includeParallelComps = false;
	if (connections != null && connections.size() > 0) {
        for (IConnection connection : connections) {
        	String connectionName = connection.getName();

            IMetadataTable metadataTable = connection.getMetadataTable();
            INode validTarget = ((IDataConnection) connection).getLinkNodeForHash();
            if(validTarget != null) {
            	INode partitionNode = validTarget.getDesignSubjobStartNode();
	   			if ("tCollector".equals(partitionNode.getComponent().getName())) {
					includeParallelComps = true;
					partitionNode = partitionNode.getIncomingConnections(EConnectionType.STARTS).get(0).getSource();
				}
				if (includeParallelComps) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(partitionNode.getUniqueName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_8);
      			}
 			}
  		}
  	}

    return stringBuffer.toString();
  }
}
