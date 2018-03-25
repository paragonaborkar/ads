package org.talend.designer.codegen.translators.business.centriccrm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TCentricCRMOutputBeginJava
{
  protected static String nl;
  public static synchronized TCentricCRMOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCentricCRMOutputBeginJava result = new TCentricCRMOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "       int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "       org.aspcfs.utils.CRMConnection crm";
  protected final String TEXT_4 = " = new org.aspcfs.utils.CRMConnection();" + NL + "       crm";
  protected final String TEXT_5 = ".setUrl(";
  protected final String TEXT_6 = ");" + NL + "       crm";
  protected final String TEXT_7 = ".setId(";
  protected final String TEXT_8 = ");" + NL + "       ";
  protected final String TEXT_9 = NL + "        ";
  protected final String TEXT_10 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_11 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "; ";
  protected final String TEXT_16 = NL + "\t\t       " + NL + "       " + NL + "       crm";
  protected final String TEXT_17 = ".setCode(decryptedPassword_";
  protected final String TEXT_18 = ");" + NL + "       crm";
  protected final String TEXT_19 = ".setClientId(";
  protected final String TEXT_20 = ");" + NL + "       crm";
  protected final String TEXT_21 = ".setAutoCommit(false);" + NL + "       org.aspcfs.apps.transfer.DataRecord ";
  protected final String TEXT_22 = " = new org.aspcfs.apps.transfer.DataRecord();";
  protected final String TEXT_23 = NL + "       ";
  protected final String TEXT_24 = " .setName(\"";
  protected final String TEXT_25 = "\");";
  protected final String TEXT_26 = NL + "       ";
  protected final String TEXT_27 = " .setAction(org.aspcfs.apps.transfer.DataRecord.";
  protected final String TEXT_28 = ");" + NL + "      " + NL + "       ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String url = ElementParameterParser.getValue(node, "__CENTRIC-URL__");
	String modulename = ElementParameterParser.getValue(node, "__MODULENAME__");
	String userid = ElementParameterParser.getValue(node, "__CLIENT__");
	String server = ElementParameterParser.getValue(node, "__SERVER-ID__");
	String action=ElementParameterParser.getValue(node, "__ACTION__");

    stringBuffer.append(TEXT_1);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {    

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(server);
    stringBuffer.append(TEXT_8);
    
       String passwordFieldName = "__CODE__";
       
    stringBuffer.append(TEXT_9);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_12);
    } else {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(modulename);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(modulename);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(modulename);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(modulename);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(action);
    stringBuffer.append(TEXT_28);
     }
 }
    return stringBuffer.toString();
  }
}
