package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TWriteXMLFieldInBeginJava
{
  protected static String nl;
  public static synchronized TWriteXMLFieldInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteXMLFieldInBeginJava result = new TWriteXMLFieldInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    \t\t\t\tjava.util.Queue<String> queue_";
  protected final String TEXT_3 = " = new java.util.concurrent.ConcurrentLinkedQueue<String>();" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tclass ThreadXMLField_";
  protected final String TEXT_4 = " extends Thread {" + NL + "\t\t\t\t\t\tjava.util.Queue<String> queue;" + NL + "\t\t\t\t\t\tjava.util.List<java.util.Map<String,String>> flows;" + NL + "\t\t\t\t\t\tjava.lang.Exception lastException;" + NL + "\t\t\t\t\t\tString currentComponent;" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tThreadXMLField_";
  protected final String TEXT_5 = "(java.util.Queue q) {" + NL + "\t\t\t\t\t\t\tthis.queue = q;" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_6 = "\", queue);" + NL + "\t\t\t\t\t\t\tlastException = null;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tThreadXMLField_";
  protected final String TEXT_7 = "(java.util.Queue q, java.util.List<java.util.Map<String,String>> l) {" + NL + "\t\t\t\t\t\t\tthis.queue = q;" + NL + "\t\t\t\t\t\t\tthis.flows = l;" + NL + "\t\t\t\t\t\t\tlastException = null;" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_8 = "\", queue);" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"flows_";
  protected final String TEXT_9 = "\", flows);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tpublic java.lang.Exception getLastException() {" + NL + "\t\t\t\t\t\t\treturn this.lastException;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tpublic String getCurrentComponent() {" + NL + "\t\t\t\t\t\t\treturn this.currentComponent;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t@Override" + NL + "\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_10 = "Process(globalMap);" + NL + "\t\t\t\t\t\t\t} catch (TalendException te) {" + NL + "\t\t\t\t\t\t\t\tthis.lastException = te.getException();" + NL + "\t\t\t\t\t\t\t\tthis.currentComponent = te.getCurrentComponent();" + NL + "\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_11 = "_FINISH\" + (this.queue==null?\"\":this.queue.hashCode()), \"true\");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tThreadXMLField_";
  protected final String TEXT_12 = " txf_";
  protected final String TEXT_13 = " = new ThreadXMLField_";
  protected final String TEXT_14 = "(queue_";
  protected final String TEXT_15 = ");" + NL + "\t\t\t\t\ttxf_";
  protected final String TEXT_16 = ".start();" + NL + "    \t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\tjava.util.Queue<String> queue_";
  protected final String TEXT_18 = " = (java.util.Queue<String>) globalMap.get(\"queue_";
  protected final String TEXT_19 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tString readFinishMarkWithPipeId_";
  protected final String TEXT_21 = " = \"";
  protected final String TEXT_22 = "_FINISH\"+(queue_";
  protected final String TEXT_23 = "==null?\"\":queue_";
  protected final String TEXT_24 = ".hashCode());" + NL + "\t\t\t\tint nb_line_";
  protected final String TEXT_25 = " = 0;" + NL + "\t\t\t\twhile(!globalMap.containsKey(readFinishMarkWithPipeId_";
  protected final String TEXT_26 = ") || !queue_";
  protected final String TEXT_27 = ".isEmpty()) {" + NL + "\t\t\t\t\tif (!queue_";
  protected final String TEXT_28 = ".isEmpty()) {" + NL + "\t\t\t";
  protected final String TEXT_29 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String xmlField = ElementParameterParser.getValue(node, "__XMLFIELD__");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if(conns!=null && conns.size()>0){
    		IConnection conn = conns.get(0);
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		
				INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
				String virtualSourceCid = sourceNode.getUniqueName();
				INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
				String startNodeCid = null; 
				if(startNode != null){
					startNodeCid = startNode.getUniqueName();
				} 
    			IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
    			if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){
   				
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(startNodeCid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
    			}else{
				
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
				}
				
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
}

    stringBuffer.append(TEXT_29);
    return stringBuffer.toString();
  }
}
