package org.talend.designer.codegen.translators.databases.paraccel;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TParAccelOutputBulkFinallyJava
{
  protected static String nl;
  public static synchronized TParAccelOutputBulkFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TParAccelOutputBulkFinallyJava result = new TParAccelOutputBulkFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tif(resourceMap.get(\"finish_";
  protected final String TEXT_2 = "\") == null){" + NL + "\t\tif(resourceMap.get(\"out";
  protected final String TEXT_3 = "\") != null){" + NL + "\t\t\t((java.io.BufferedWriter)resourceMap.get(\"out";
  protected final String TEXT_4 = "\")).close();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
