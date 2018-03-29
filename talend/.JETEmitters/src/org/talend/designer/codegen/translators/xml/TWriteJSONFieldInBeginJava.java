package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TWriteJSONFieldInBeginJava
{
  protected static String nl;
  public static synchronized TWriteJSONFieldInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteJSONFieldInBeginJava result = new TWriteJSONFieldInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\t\t\t\tnet.sf.json.xml.XMLSerializer xmlSerializer_";
  protected final String TEXT_4 = " = new net.sf.json.xml.XMLSerializer(); " + NL + "\t\t\t    xmlSerializer_";
  protected final String TEXT_5 = ".clearNamespaces();" + NL + "\t\t\t    xmlSerializer_";
  protected final String TEXT_6 = ".setSkipNamespaces(true);" + NL + "\t\t\t    xmlSerializer_";
  protected final String TEXT_7 = ".setForceTopLevelObject(";
  protected final String TEXT_8 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\t\tjava.util.Map map_";
  protected final String TEXT_10 = " = new java.util.HashMap();" + NL + "\t\t\t\t        java.util.Queue<java.util.Map> queue_";
  protected final String TEXT_11 = " = new java.util.concurrent.ConcurrentLinkedQueue<java.util.Map>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\t   java.util.Queue<";
  protected final String TEXT_13 = "> queue_";
  protected final String TEXT_14 = " = new java.util.concurrent.ConcurrentLinkedQueue<";
  protected final String TEXT_15 = ">();" + NL + "\t\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tclass ThreadXMLField_";
  protected final String TEXT_17 = " extends Thread {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\t\tjava.util.Queue<java.util.Map> queue;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\t    java.util.Queue<";
  protected final String TEXT_20 = "> queue;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\tjava.util.List<java.util.Map<String,String>> flows;" + NL + "\t\t\t\t\t\tjava.lang.Exception lastException;" + NL + "\t\t\t\t\t\tString currentComponent;" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tThreadXMLField_";
  protected final String TEXT_22 = "(java.util.Queue q) {" + NL + "\t\t\t\t\t\t\tthis.queue = q;" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_23 = "\", queue);" + NL + "\t\t\t\t\t\t\tlastException = null;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tThreadXMLField_";
  protected final String TEXT_24 = "(java.util.Queue q, java.util.List<java.util.Map<String,String>> l) {" + NL + "\t\t\t\t\t\t\tthis.queue = q;" + NL + "\t\t\t\t\t\t\tthis.flows = l;" + NL + "\t\t\t\t\t\t\tlastException = null;" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_25 = "\", queue);" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"flows_";
  protected final String TEXT_26 = "\", flows);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tpublic java.lang.Exception getLastException() {" + NL + "\t\t\t\t\t\t\treturn this.lastException;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tpublic String getCurrentComponent() {" + NL + "\t\t\t\t\t\t\treturn this.currentComponent;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t@Override" + NL + "\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_27 = "Process(globalMap);" + NL + "\t\t\t\t\t\t\t} catch (TalendException te) {" + NL + "\t\t\t\t\t\t\t\tthis.lastException = te.getException();" + NL + "\t\t\t\t\t\t\t\tthis.currentComponent = te.getCurrentComponent();" + NL + "\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_28 = "_FINISH\"+(this.queue==null?\"\":this.queue.hashCode()), \"true\");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tThreadXMLField_";
  protected final String TEXT_29 = " txf_";
  protected final String TEXT_30 = " = new ThreadXMLField_";
  protected final String TEXT_31 = "(queue_";
  protected final String TEXT_32 = ");" + NL + "\t\t\t\t\ttxf_";
  protected final String TEXT_33 = ".start();" + NL + "\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t        java.util.Map map_";
  protected final String TEXT_35 = " = new java.util.HashMap();" + NL + "\t\t\t\t        java.util.Queue<java.util.Map> queue_";
  protected final String TEXT_36 = " = (java.util.Queue<java.util.Map>) globalMap.get(\"queue_";
  protected final String TEXT_37 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\t   java.util.Queue<";
  protected final String TEXT_39 = "> queue_";
  protected final String TEXT_40 = " = (java.util.Queue<";
  protected final String TEXT_41 = ">) globalMap.get(\"queue_";
  protected final String TEXT_42 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\tString readFinishMarkWithPipeId_";
  protected final String TEXT_44 = " = \"";
  protected final String TEXT_45 = "_FINISH\"+(queue_";
  protected final String TEXT_46 = "==null?\"\":queue_";
  protected final String TEXT_47 = ".hashCode());" + NL + "\t\t\t\tString str_";
  protected final String TEXT_48 = " = null;" + NL + "\t\t\t\t" + NL + "\t\t\t\twhile(!globalMap.containsKey(readFinishMarkWithPipeId_";
  protected final String TEXT_49 = ") || !queue_";
  protected final String TEXT_50 = ".isEmpty()) {" + NL + "\t\t\t\t\tif (!queue_";
  protected final String TEXT_51 = ".isEmpty()) {" + NL + "\t\t\t";
  protected final String TEXT_52 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if(conns!=null && conns.size()>0){
			if (conns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			    String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
			    boolean removeRoot="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REMOVE_ROOT__"));
			    String outputRowStructName = conns.get(0).getName()+"Struct";//row2
				
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append((removeRoot?false:true));
    stringBuffer.append(TEXT_8);
    
				INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
				String virtualSourceCid = sourceNode.getUniqueName();
				INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
				String startNodeCid = null; 
				if(startNode != null){
					startNodeCid = startNode.getUniqueName();
				} 
				IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
				if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){
					if(destination.indexOf("tCouchbaseOutput_")==0 || destination.indexOf("tCouchDBOutput_")==0){
					
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
				    }else{
					
    stringBuffer.append(TEXT_12);
    stringBuffer.append( outputRowStructName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append( outputRowStructName );
    stringBuffer.append(TEXT_15);
    
				    }
					
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
						if(destination.indexOf("tCouchbaseOutput_")==0 || destination.indexOf("tCouchDBOutput_")==0){
						
    stringBuffer.append(TEXT_18);
    
						}else{
						
    stringBuffer.append(TEXT_19);
    stringBuffer.append( outputRowStructName );
    stringBuffer.append(TEXT_20);
    
						}
						
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(startNodeCid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
				}else{

    				if(destination!=null && (destination.indexOf("tCouchbaseOutput_")>=0 || destination.indexOf("tCouchDBOutput_")>=0)){
					
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
    				}else{
					
    stringBuffer.append(TEXT_38);
    stringBuffer.append( outputRowStructName );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append( outputRowStructName );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
				    }
				}
				
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
			}
		}
	}
}

    stringBuffer.append(TEXT_52);
    return stringBuffer.toString();
  }
}
