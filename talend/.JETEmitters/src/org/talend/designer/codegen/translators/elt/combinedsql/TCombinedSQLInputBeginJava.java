package org.talend.designer.codegen.translators.elt.combinedsql;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;

public class TCombinedSQLInputBeginJava
{
  protected static String nl;
  public static synchronized TCombinedSQLInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCombinedSQLInputBeginJava result = new TCombinedSQLInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "System.err.println(\"";
  protected final String TEXT_2 = " should not be used by itself!\");";
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();	
String cid = node.getUniqueName();	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
