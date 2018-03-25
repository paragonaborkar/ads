package org.talend.designer.codegen.translators.databases.amazon.redshift;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TRedshiftOutputBulkFinallyJava
{
  protected static String nl;
  public static synchronized TRedshiftOutputBulkFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRedshiftOutputBulkFinallyJava result = new TRedshiftOutputBulkFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tif(resourceMap.get(\"finish_";
  protected final String TEXT_2 = "\") == null){" + NL + "\t\tif(resourceMap.get(\"csvWriter_";
  protected final String TEXT_3 = "\") != null){" + NL + "\t\t\t((java.io.BufferedWriter)resourceMap.get(\"csvWriter_";
  protected final String TEXT_4 = "\")).close();" + NL + "\t\t}";
  protected final String TEXT_5 = NL + "\t\tif(resourceMap.get(\"file_";
  protected final String TEXT_6 = "\") != null){" + NL + "\t\t\t((java.io.File)resourceMap.get(\"file_";
  protected final String TEXT_7 = "\")).delete();" + NL + "\t\t}";
  protected final String TEXT_8 = NL + "\t}\t";
  protected final String TEXT_9 = NL;

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
    
	boolean delete = "true".equals(ElementParameterParser.getValue(node,"__DELETE_LOCALFILE__"));
	if(delete) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
	}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
