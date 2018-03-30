package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSCPTruncateMainJava
{
  protected static String nl;
  public static synchronized TSCPTruncateMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPTruncateMainJava result = new TSCPTruncateMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\ttry{" + NL + "        if(destFile_";
  protected final String TEXT_2 = "!=null && destFile_";
  protected final String TEXT_3 = ".length()!=0){" + NL + "   \t\t\tjava.io.OutputStream out_";
  protected final String TEXT_4 = " = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\tout_";
  protected final String TEXT_5 = " = scp_";
  protected final String TEXT_6 = ".put(destFile_";
  protected final String TEXT_7 = ", 0, ";
  protected final String TEXT_8 = ", \"0644\");" + NL + "\t\t\t\tout_";
  protected final String TEXT_9 = ".write(new byte[]{});" + NL + "\t\t\t} finally {" + NL + "            \tif(out_";
  protected final String TEXT_10 = " != null){" + NL + "        \t\t\tout_";
  protected final String TEXT_11 = ".close();" + NL + "            \t}" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "            nb_file_";
  protected final String TEXT_12 = " ++;" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_14 = " - '\" + destFile_";
  protected final String TEXT_15 = "  + \"' truncate OK.\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "            globalMap.put(\"";
  protected final String TEXT_17 = "_STATUS\", \"File truncate OK.\");" + NL + "        }" + NL + "    }catch(java.lang.Exception e_";
  protected final String TEXT_18 = "){" + NL + "\t\t";
  protected final String TEXT_19 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_20 = " - \" + e_";
  protected final String TEXT_21 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_23 = "_STATUS\", \"File truncate fail.\");" + NL + "    }";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    String cid = node.getUniqueName();      
	String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
