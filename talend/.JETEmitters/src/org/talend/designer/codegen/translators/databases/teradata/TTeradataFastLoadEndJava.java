package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TTeradataFastLoadEndJava
{
  protected static String nl;
  public static synchronized TTeradataFastLoadEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataFastLoadEndJava result = new TTeradataFastLoadEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "   if(commitCounter_";
  protected final String TEXT_3 = " > 0){" + NL + "\tint[] resultArr = pstmt_";
  protected final String TEXT_4 = ".executeBatch();" + NL + "\tpstmt_";
  protected final String TEXT_5 = ".clearBatch();" + NL + "\tcommitCounter_";
  protected final String TEXT_6 = "=0;" + NL + "\t" + NL + "\tint sum = 0;" + NL + "\tfor(int i : resultArr){" + NL + "\t\tsum += (i<0 ? 0 : i);" + NL + "\t}" + NL + "\tinsertedCount_";
  protected final String TEXT_7 = " += sum;" + NL + "}" + NL + "" + NL + "pstmt_";
  protected final String TEXT_8 = ".close();" + NL;
  protected final String TEXT_9 = NL + "\tlog.info(\"";
  protected final String TEXT_10 = " - Starting to commit.\");";
  protected final String TEXT_11 = NL + NL + "conn_";
  protected final String TEXT_12 = ".commit();" + NL;
  protected final String TEXT_13 = NL + "\tlog.info(\"";
  protected final String TEXT_14 = " - Commit has succeeded.\");" + NL + "\tlog.info(\"";
  protected final String TEXT_15 = " - Closing the connection to the database.\");";
  protected final String TEXT_16 = NL + NL + "conn_";
  protected final String TEXT_17 = " .close();" + NL;
  protected final String TEXT_18 = NL + "\tlog.info(\"";
  protected final String TEXT_19 = " - Connection to the database closed.\");";
  protected final String TEXT_20 = NL + NL + "\tnb_line_inserted_";
  protected final String TEXT_21 = " += insertedCount_";
  protected final String TEXT_22 = ";" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_23 = "_NB_LINE\",nb_line_";
  protected final String TEXT_24 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_25 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_26 = ");" + NL;
  protected final String TEXT_27 = NL + "\tlog.info(\"";
  protected final String TEXT_28 = " - Loaded records count:\" + nb_line_inserted_";
  protected final String TEXT_29 = " + \".\" );";
  protected final String TEXT_30 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}
