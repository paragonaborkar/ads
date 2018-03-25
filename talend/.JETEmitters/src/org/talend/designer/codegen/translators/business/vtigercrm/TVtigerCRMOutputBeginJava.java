package org.talend.designer.codegen.translators.business.vtigercrm;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TVtigerCRMOutputBeginJava
{
  protected static String nl;
  public static synchronized TVtigerCRMOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TVtigerCRMOutputBeginJava result = new TVtigerCRMOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    ";
  protected final String TEXT_2 = NL + "    ";
  protected final String TEXT_3 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_4 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = "; ";
  protected final String TEXT_9 = NL + "    " + NL + "    " + NL + "    org.talend.vtiger.IVtigerManager vtigerManager_";
  protected final String TEXT_10 = " = new org.talend.vtiger.VtigerManager(";
  protected final String TEXT_11 = ", decryptedPassword_";
  protected final String TEXT_12 = ", ";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "        java.util.List<org.talend.vtiger.module.outlook.Clndrdetail> clndrDetais_";
  protected final String TEXT_18 = " = new java.util.ArrayList<org.talend.vtiger.module.outlook.Clndrdetail>(); ";
  protected final String TEXT_19 = NL + "        java.util.List<org.talend.vtiger.module.outlook.Contactdetail> contactdetails_";
  protected final String TEXT_20 = " = new java.util.ArrayList<org.talend.vtiger.module.outlook.Contactdetail>();";
  protected final String TEXT_21 = NL + "        java.util.List<org.talend.vtiger.module.outlook.Taskdetail> taskdetails_";
  protected final String TEXT_22 = " = new java.util.ArrayList<org.talend.vtiger.module.outlook.Taskdetail>();";
  protected final String TEXT_23 = NL + "    com.vtiger.vtwsclib.WSClient vtMgr_";
  protected final String TEXT_24 = " = new com.vtiger.vtwsclib.WSClient(";
  protected final String TEXT_25 = ");" + NL + "    ";
  protected final String TEXT_26 = NL + "    ";
  protected final String TEXT_27 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_28 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = "; ";
  protected final String TEXT_33 = NL + "\t    " + NL + "    " + NL + "\tboolean lr_";
  protected final String TEXT_34 = " = vtMgr_";
  protected final String TEXT_35 = ".doLogin(";
  protected final String TEXT_36 = ", decryptedPassword_";
  protected final String TEXT_37 = ");" + NL + "\tif(!lr_";
  protected final String TEXT_38 = "){" + NL + "\t \tthrow new RuntimeException(vtMgr_";
  protected final String TEXT_39 = ".lastError().toString());" + NL + "\t}";
  protected final String TEXT_40 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String version_selection = ElementParameterParser.getValue(node, "__VERSION_SELECTION__");
if(version_selection.equals("VTIGER_50")){

    String serverAddr = ElementParameterParser.getValue(node, "__SERVERADDR__");
    String port = ElementParameterParser.getValue(node, "__PORT__");
    String vtigerPath = ElementParameterParser.getValue(node, "__VTIGERPATH__");
    String userName = ElementParameterParser.getValue(node, "__USERNAME__");
    String password = ElementParameterParser.getValue(node, "__PASSWORD__");
    String version = ElementParameterParser.getValue(node, "__VERSION__");
    String method = ElementParameterParser.getValue(node, "__METHODNAME__");
    
    stringBuffer.append(TEXT_1);
    
    String passwordFieldName = "__PASSWORD__";
    
    stringBuffer.append(TEXT_2);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_5);
    } else {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(serverAddr);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(vtigerPath);
    stringBuffer.append(TEXT_16);
    
    if(("addClndr").equals(method) || ("updateClndr").equals(method)) {
        
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
    } else if(("addContacts").equals(method) || ("updateContacts").equals(method)) {
        
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
    } else if(("addTasks").equals(method) || ("updateTasks").equals(method)) {
        
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
    }
//*****************************************************version 5.1 start**************************************
}else{
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
	String username = ElementParameterParser.getValue(node, "__USERNAME_510__");
    String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_25);
    
    String passwordFieldName = "__ACCESS_KEY__";
    
    stringBuffer.append(TEXT_26);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_29);
    } else {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
}

    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}
