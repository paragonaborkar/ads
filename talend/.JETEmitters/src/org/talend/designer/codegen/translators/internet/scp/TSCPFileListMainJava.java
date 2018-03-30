package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSCPFileListMainJava
{
  protected static String nl;
  public static synchronized TSCPFileListMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPFileListMainJava result = new TSCPFileListMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tnb_line_";
  protected final String TEXT_2 = "++;" + NL + "\t\tstringStdout_";
  protected final String TEXT_3 = ".append(line_out_";
  protected final String TEXT_4 = " + \"\\n\");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_5 = "_NB_LINE\", nb_line_";
  protected final String TEXT_6 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_7 = "_CURRENT_LINE\", line_out_";
  protected final String TEXT_8 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
