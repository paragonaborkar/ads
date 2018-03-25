package org.talend.designer.codegen.translators.cloud.amazon.s3;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TS3CloseMainJava
{
  protected static String nl;
  public static synchronized TS3CloseMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3CloseMainJava result = new TS3CloseMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_3 = " = (com.amazonaws.services.s3.AmazonS3Client)globalMap.get(\"conn_";
  protected final String TEXT_4 = "\");" + NL + "\tif(conn_";
  protected final String TEXT_5 = " !=null){" + NL + "\t\tconn_";
  protected final String TEXT_6 = ".shutdown();\t" + NL + "\t}" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();

   	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
