package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;

public class THashMainJava
{
  protected static String nl;
  public static synchronized THashMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THashMainJava result = new THashMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = "Struct ";
  protected final String TEXT_4 = "_HashRow = new ";
  protected final String TEXT_5 = "Struct();" + NL;
  protected final String TEXT_6 = NL + "\t\t\t\t\t";
  protected final String TEXT_7 = "_HashRow.";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ".clone();";
  protected final String TEXT_11 = NL + "\t\t\t\t\t";
  protected final String TEXT_12 = "_HashRow.";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL + "tHash_";
  protected final String TEXT_17 = ".put(";
  protected final String TEXT_18 = "_HashRow, ";
  protected final String TEXT_19 = "_HashRow);" + NL;
  protected final String TEXT_20 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();

    List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();

	if (connections != null && connections.size() > 0) {
        for (IConnection connection : connections) {
        	String connectionName = connection.getName();

            IMetadataTable metadataTable = connection.getMetadataTable();
            

    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_5);
    
			
            List<IMetadataColumn> listColumns = metadataTable.getListColumns();
            for (IMetadataColumn column : listColumns) {
                String columnName = column.getLabel();
				if("id_Dynamic".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_10);
    
				} else {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_15);
    
				}
            }


    stringBuffer.append(TEXT_16);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_19);
    
		}
	}


    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
