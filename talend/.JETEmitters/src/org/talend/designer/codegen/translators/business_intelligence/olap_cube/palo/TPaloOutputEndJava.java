package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPaloOutputEndJava
{
  protected static String nl;
  public static synchronized TPaloOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloOutputEndJava result = new TPaloOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " " + NL + "" + NL + "\t";
  protected final String TEXT_2 = NL + "\t\tlog.info(\"";
  protected final String TEXT_3 = " - Committing cube .\");" + NL + "\t";
  protected final String TEXT_4 = NL + "\tplDb_";
  protected final String TEXT_5 = ".commitCube(cube_";
  protected final String TEXT_6 = ");" + NL + "\t";
  protected final String TEXT_7 = NL + "\t\tlog.info(\"";
  protected final String TEXT_8 = " - Commit has succeeded.\");" + NL + "\t";
  protected final String TEXT_9 = NL + "\tnb_commit_count_";
  protected final String TEXT_10 = " =0;" + NL + "\tif(";
  protected final String TEXT_11 = ") plDb_";
  protected final String TEXT_12 = ".save();" + NL + "\t";
  protected final String TEXT_13 = NL + "\t\tlog.info(\"";
  protected final String TEXT_14 = " - Closing the connection to the database.\");" + NL + "\t";
  protected final String TEXT_15 = NL + "\tplIX_";
  protected final String TEXT_16 = ".kill();" + NL + "\t";
  protected final String TEXT_17 = NL + "\t\tlog.info(\"";
  protected final String TEXT_18 = " - Connection to the database closed.\");" + NL + "\t";
  protected final String TEXT_19 = NL + NL + "\tglobalMap.put(\"";
  protected final String TEXT_20 = "_NB_LINE\",nb_line_";
  protected final String TEXT_21 = ");  " + NL + "" + NL + "\t";
  protected final String TEXT_22 = NL + "\t\tlog.info(\"";
  protected final String TEXT_23 = " - Written records count: \" + nb_line_";
  protected final String TEXT_24 = " + \" .\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	boolean isSaveCube = ("true").equals(ElementParameterParser.getValue(node,"__SAVECUBE__"));

    stringBuffer.append(TEXT_1);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(isSaveCube );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    }
    return stringBuffer.toString();
  }
}
