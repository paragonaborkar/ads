package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import java.util.List;
import org.talend.core.model.process.ElementParameterParser;

public class TContextDumpEndJava
{
  protected static String nl;
  public static synchronized TContextDumpEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TContextDumpEndJava result = new TContextDumpEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        }" + NL + "        globalMap.put(\"";
  protected final String TEXT_3 = "_NB_LINE\",nb_line_";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = NL + "        \tlog.info(\"";
  protected final String TEXT_6 = " - Dumped contexts count: \" + nb_line_";
  protected final String TEXT_7 = " + \".\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
    List<IMetadataColumn> columnList = null;
    List<IMetadataTable> metadatas = node.getMetadataList();
    if(metadatas != null && metadatas.size() > 0) {
        IMetadataTable metadata = metadatas.get(0);
        if(metadata != null) {
            columnList = metadata.getListColumns();
        }
    }
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    List< ? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    if(columnList != null && columnList.size() > 0 && outgoingConns != null && outgoingConns.size() > 0) {
        
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    }
    
    }

    return stringBuffer.toString();
  }
}
