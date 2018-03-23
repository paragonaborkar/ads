package org.talend.designer.codegen.translators.common;

import java.util.List;
import java.util.Set;
import org.talend.components.api.component.ComponentDefinition;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.core.generic.model.Component;
import org.talend.core.model.utils.NodeUtil;

public class Handle_rejects_endJava
{
  protected static String nl;
  public static synchronized Handle_rejects_endJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Handle_rejects_endJava result = new Handle_rejects_endJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t} // Finish while";
  protected final String TEXT_3 = NL + NL + "} // finish if writer";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean hasReject = false;

List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
if (outgoingConns!=null){
   for (int i = 0; i < outgoingConns.size(); i++) {
       IConnection outgoingConn = outgoingConns.get(i);
       if ("REJECT".equals(outgoingConn.getConnectorName())) {
           hasReject = true;
       }
   }
}

if (hasReject) {

    stringBuffer.append(TEXT_2);
    
}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
