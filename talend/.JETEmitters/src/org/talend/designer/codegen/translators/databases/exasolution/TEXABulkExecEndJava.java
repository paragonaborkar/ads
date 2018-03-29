package org.talend.designer.codegen.translators.databases.exasolution;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TEXABulkExecEndJava
{
  protected static String nl;
  public static synchronized TEXABulkExecEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TEXABulkExecEndJava result = new TEXABulkExecEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "{" + NL + "\tjava.sql.Connection conn = (java.sql.Connection) globalMap.get(\"conn_";
  protected final String TEXT_3 = "\"); " + NL + "\tif (conn != null) {" + NL + "\t    conn.close();" + NL + "\t}" + NL + "}";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = ".deleteErrorLogFileIfEmpty();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    	if ("false".equals(useExistingConn)) { 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_3);
    	} 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
