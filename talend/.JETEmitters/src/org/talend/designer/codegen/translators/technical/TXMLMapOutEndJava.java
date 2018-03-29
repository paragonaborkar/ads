package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.xmlmap.XmlMapComponent;
import org.talend.designer.xmlmap.model.emf.xmlmap.XmlMapData;
import org.eclipse.emf.common.util.EList;
import org.talend.designer.xmlmap.model.emf.xmlmap.InputXmlTree;
import org.talend.designer.xmlmap.model.emf.xmlmap.OutputXmlTree;
import org.talend.designer.xmlmap.model.emf.xmlmap.TreeNode;
import org.talend.designer.xmlmap.model.emf.xmlmap.OutputTreeNode;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class TXMLMapOutEndJava
{
  protected static String nl;
  public static synchronized TXMLMapOutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TXMLMapOutEndJava result = new TXMLMapOutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Written records count in the table '";
  protected final String TEXT_3 = "': \" + count_";
  protected final String TEXT_4 = "_";
  protected final String TEXT_5 = " + \".\");";
  protected final String TEXT_6 = NL + NL;
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	XmlMapComponent node = (XmlMapComponent) codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String uniqueNameComponent = cid.replaceAll("_TXMLMAP_OUT", "");
	
	XmlMapData xmlMapData =(XmlMapData)ElementParameterParser.getObjectValueXMLTree(node);
	
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

	EList<OutputXmlTree> outputTables = xmlMapData.getOutputTrees();
	
	String uniqueNameComponentIn = cid.replace("_TXMLMAP_OUT", "_TXMLMAP_IN");
	
	INode generatingNodeIn = null;
	for(INode loopNode : node.getProcess().getGeneratingNodes()) {
		if(loopNode.getUniqueName().equals(uniqueNameComponentIn)) {
			generatingNodeIn = loopNode;
			break;
		}
	}
	
	if(generatingNodeIn == null) {
		return "";
	}
	
	List<IConnection> outputConnections = (List<IConnection>) generatingNodeIn.getOutgoingConnections();
	Map<String, IConnection> nameToOutputConnection = new HashMap<String, IConnection>();
    for (IConnection connection : outputConnections) {
		nameToOutputConnection.put(connection.getName(), connection);
	}

    for (OutputXmlTree table : outputTables) {
        EList<OutputTreeNode> tableEntries = table.getNodes();
        if (tableEntries == null || nameToOutputConnection.get(table.getName()) == null) {
            continue;
        }
        String outputTableName = table.getName();
        
		if(isLog4jEnabled) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(outputTableName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outputTableName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
		}
    }

    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
