package org.talend.designer.codegen.translators.business.sugarcrm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSugarCRMOutputBeginJava
{
  protected static String nl;
  public static synchronized TSugarCRMOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSugarCRMOutputBeginJava result = new TSugarCRMOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL + "        int nb_line_";
  protected final String TEXT_2 = " = 0;";
  protected final String TEXT_3 = NL + "        String modulename_";
  protected final String TEXT_4 = " =  ";
  protected final String TEXT_5 = "+\"_\"+";
  protected final String TEXT_6 = ";";
  protected final String TEXT_7 = NL + "        String modulename_";
  protected final String TEXT_8 = " = \"";
  protected final String TEXT_9 = "\";";
  protected final String TEXT_10 = NL + "        ";
  protected final String TEXT_11 = NL + "        ";
  protected final String TEXT_12 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_13 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = "; ";
  protected final String TEXT_18 = NL + "        " + NL + "        " + NL + "        org.talend.SugarManagement.SugarManagement sugarManagement_";
  protected final String TEXT_19 = " = new org.talend.SugarManagement.SugarManagementImpl(";
  protected final String TEXT_20 = ", decryptedPassword_";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = ", \"sugarcrm\",\"5.2.0\");" + NL + "        sugarManagement_";
  protected final String TEXT_23 = ".login(); ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
    
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
	String modulename = ElementParameterParser.getValue(node, "__MODULENAME__");
	String packageName = ElementParameterParser.getValue(node, "__CUSTOM_MODULE_PACKAGE__");
	String customModuleName = ElementParameterParser.getValue(node, "__CUSTOM_MODULE_NAME__");
	
	String username = ElementParameterParser.getValue(node, "__USER__");


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    if("CustomModule".equals(modulename)){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(customModuleName);
    stringBuffer.append(TEXT_6);
    }else{
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
        String passwordFieldName = "__PASS__";
        
    stringBuffer.append(TEXT_11);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_14);
    } else {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(endpoint );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    return stringBuffer.toString();
  }
}
