package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSetKerberosConfigurationMainJava
{
  protected static String nl;
  public static synchronized TSetKerberosConfigurationMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSetKerberosConfigurationMainJava result = new TSetKerberosConfigurationMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\tSystem.setProperty(\"java.security.krb5.kdc\", ";
  protected final String TEXT_3 = ");" + NL + "\tSystem.setProperty(\"java.security.krb5.realm\", ";
  protected final String TEXT_4 = ");" + NL + "\t\t\t          " + NL + "\tjava.util.Map state_";
  protected final String TEXT_5 = " = new java.util.HashMap();" + NL + "\tstate_";
  protected final String TEXT_6 = ".put(\"javax.security.auth.login.name\", ";
  protected final String TEXT_7 = ");" + NL + "\t";
  protected final String TEXT_8 = NL + "    ";
  protected final String TEXT_9 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_10 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = "; ";
  protected final String TEXT_15 = NL + "\t" + NL + "\t" + NL + "\tstate_";
  protected final String TEXT_16 = ".put(\"javax.security.auth.login.password\", decryptedPassword_";
  protected final String TEXT_17 = ".toCharArray());" + NL + "\t\t\t      " + NL + "\tjava.util.Map option_";
  protected final String TEXT_18 = " = new java.util.HashMap();" + NL + "\t//option_";
  protected final String TEXT_19 = ".put(\"debug\", \"true\");" + NL + "\toption_";
  protected final String TEXT_20 = ".put(\"tryFirstPass\", \"true\");" + NL + "\toption_";
  protected final String TEXT_21 = ".put(\"useTicketCache\", \"false\");" + NL + "\toption_";
  protected final String TEXT_22 = ".put(\"doNotPrompt\", \"false\");" + NL + "\toption_";
  protected final String TEXT_23 = ".put(\"storePass\", \"false\");" + NL + "" + NL + "\tcom.sun.security.auth.module.Krb5LoginModule login_";
  protected final String TEXT_24 = " = new com.sun.security.auth.module.Krb5LoginModule();" + NL + "\tjavax.security.auth.Subject subject_";
  protected final String TEXT_25 = " = new javax.security.auth.Subject();" + NL + "\tlogin_";
  protected final String TEXT_26 = ".initialize(subject_";
  protected final String TEXT_27 = ", null, state_";
  protected final String TEXT_28 = ", option_";
  protected final String TEXT_29 = ");" + NL + "" + NL + "\tif(login_";
  protected final String TEXT_30 = ".login()){" + NL + "\t\tSystem.out.println(\"Build the connection with Kerberos Successfully!\");" + NL + "\t\tlogin_";
  protected final String TEXT_31 = ".commit();" + NL + "\t}else{" + NL + "\t\tSystem.err.println(\"Fail to build the connection with Kerberos!\");" + NL + "\t}" + NL + "\tglobalMap.put(\"kerberos_subject_";
  protected final String TEXT_32 = "\",subject_";
  protected final String TEXT_33 = ");" + NL + "\t" + NL + "\t" + NL + "\t        ";
  protected final String TEXT_34 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
   
    String kdc = ElementParameterParser.getValue(node,"__KDC__");
    String realm = ElementParameterParser.getValue(node,"__REALM__");
    String username = ElementParameterParser.getValue(node,"__USERNAME__");
    String password = ElementParameterParser.getValue(node,"__PASSWORD__");
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(kdc);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(realm);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_7);
    
    String passwordFieldName = "__PASSWORD__";
    
    stringBuffer.append(TEXT_8);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_11);
    } else {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    return stringBuffer.toString();
  }
}
