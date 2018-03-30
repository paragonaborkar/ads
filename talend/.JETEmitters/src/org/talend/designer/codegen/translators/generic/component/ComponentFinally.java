package org.talend.designer.codegen.translators.generic.component;

import java.util.List;
import java.util.Set;
import org.talend.components.api.component.ComponentDefinition;
import org.talend.components.api.component.ConnectorTopology;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.core.generic.model.Component;
import org.talend.core.model.utils.NodeUtil;

public class ComponentFinally
{
  protected static String nl;
  public static synchronized ComponentFinally create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponentFinally result = new ComponentFinally();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "// finally of generic" + NL;
  protected final String TEXT_2 = NL + NL + "if(resourceMap.get(\"finish_";
  protected final String TEXT_3 = "\")==null){";
  protected final String TEXT_4 = NL + "    if(resourceMap.get(\"reader_";
  protected final String TEXT_5 = "\")!=null){" + NL + "\t\ttry {" + NL + "\t\t\t((org.talend.components.api.component.runtime.Reader)resourceMap.get(\"reader_";
  protected final String TEXT_6 = "\")).close();" + NL + "\t\t} catch (java.io.IOException e_";
  protected final String TEXT_7 = ") {" + NL + "\t\t\tString errorMessage_";
  protected final String TEXT_8 = " = \"failed to release the resource in ";
  protected final String TEXT_9 = " :\" + e_";
  protected final String TEXT_10 = ".getMessage();" + NL + "\t\t\tSystem.err.println(errorMessage_";
  protected final String TEXT_11 = ");" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_12 = NL + "    if(resourceMap.get(\"writer_";
  protected final String TEXT_13 = "\")!=null){" + NL + "\t\ttry {" + NL + "\t\t\t((org.talend.components.api.component.runtime.Writer)resourceMap.get(\"writer_";
  protected final String TEXT_14 = "\")).close();" + NL + "\t\t} catch (java.io.IOException e_";
  protected final String TEXT_15 = ") {" + NL + "\t\t\tString errorMessage_";
  protected final String TEXT_16 = " = \"failed to release the resource in ";
  protected final String TEXT_17 = " :\" + e_";
  protected final String TEXT_18 = ".getMessage();" + NL + "\t\t\tSystem.err.println(errorMessage_";
  protected final String TEXT_19 = ");" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_20 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
Component component = (Component)node.getComponent();
ComponentDefinition def = component.getComponentDefinition();

IMetadataTable metadata = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
    metadata = metadatas.get(0);
}

// Return at this point if there is no metadata.
if (metadata == null) {
    return stringBuffer.toString();
}

boolean hasInput = !NodeUtil.getIncomingConnections(node, IConnectionCategory.DATA).isEmpty();
boolean hasOutput = !NodeUtil.getOutgoingConnections(node, IConnectionCategory.DATA).isEmpty();
boolean hasOutputOnly = hasOutput && !hasInput;

Set<ConnectorTopology> connectorTopologies = def.getSupportedConnectorTopologies();
boolean asInputComponent = connectorTopologies!=null && (connectorTopologies.size() < 3) && connectorTopologies.contains(ConnectorTopology.OUTGOING);

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
if(hasOutputOnly || asInputComponent){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
}else if(hasInput){

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
}

    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
