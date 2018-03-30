package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.IConnection;

public class TWriteXMLFieldOutFinallyJava
{
  protected static String nl;
  public static synchronized TWriteXMLFieldOutFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteXMLFieldOutFinallyJava result = new TWriteXMLFieldOutFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tjava.util.Queue listGroupby_";
  protected final String TEXT_3 = " = (java.util.Queue)globalMap.get(\"queue_";
  protected final String TEXT_4 = "\");" + NL + "\t\tif(resourceMap.get(\"finish_";
  protected final String TEXT_5 = "\") == null){" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_6 = "_FINISH_WITH_EXCEPTION\" + (listGroupby_";
  protected final String TEXT_7 = "==null?\"\":listGroupby_";
  protected final String TEXT_8 = ".hashCode()), \"true\");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_9 = NL + "\t\tjava.util.Queue listGroupby_";
  protected final String TEXT_10 = " = (java.util.Queue)globalMap.get(\"queue_";
  protected final String TEXT_11 = "\");" + NL + "\t";
  protected final String TEXT_12 = NL + "\tif (listGroupby_";
  protected final String TEXT_13 = " != null) {" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_14 = "_FINISH\" + (listGroupby_";
  protected final String TEXT_15 = "==null?\"\":listGroupby_";
  protected final String TEXT_16 = ".hashCode()), \"true\");" + NL + "\t}";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    

CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();

String virtualTargetCid = node.getOutgoingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getTarget().getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
	if(nextMergeConn == null || nextMergeConn.getInputId()==1){
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(virtualTargetCid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(virtualTargetCid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
	}else{
	
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
	}
	
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(virtualTargetCid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
}

    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
