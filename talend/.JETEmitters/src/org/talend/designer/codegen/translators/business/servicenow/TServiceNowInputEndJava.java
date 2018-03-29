package org.talend.designer.codegen.translators.business.servicenow;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TServiceNowInputEndJava
{
  protected static String nl;
  public static synchronized TServiceNowInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TServiceNowInputEndJava result = new TServiceNowInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "}// responce loop" + NL + "} else {" + NL + "\tString error_";
  protected final String TEXT_2 = " = ";
  protected final String TEXT_3 = "_json.getJSONObject(\"error\").getString(\"message\");" + NL + "\tboolean no_record_";
  protected final String TEXT_4 = " = (";
  protected final String TEXT_5 = "_response.getStatusLine().getStatusCode() == 404) && (\"No Record found\".equals(error_";
  protected final String TEXT_6 = "));" + NL + "\tif(!no_record_";
  protected final String TEXT_7 = ") {" + NL + "\t\tthrow new org.apache.http.HttpException(error_";
  protected final String TEXT_8 = ");" + NL + "\t}" + NL + "} " + NL + "} finally {" + NL + "\t";
  protected final String TEXT_9 = "_response.close();" + NL + "}" + NL + "} finally {" + NL + "\t";
  protected final String TEXT_10 = "_httpclient.close();" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_11 = "_NB_LINE\",nb_line_";
  protected final String TEXT_12 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
