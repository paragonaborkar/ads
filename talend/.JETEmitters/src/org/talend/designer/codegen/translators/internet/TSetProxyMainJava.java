package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSetProxyMainJava
{
  protected static String nl;
  public static synchronized TSetProxyMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSetProxyMainJava result = new TSetProxyMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "           java.util.Properties props_";
  protected final String TEXT_3 = " = System.getProperties();";
  protected final String TEXT_4 = NL + "\t\t\tSystem.setProperty(\"http.proxySet\",\"true\");   " + NL + "\t\t\t" + NL + "\t\t\tSystem.setProperty(\"http.proxyHost\", ";
  protected final String TEXT_5 = ");" + NL + "            System.setProperty(\"http.proxyPort\", ";
  protected final String TEXT_6 = ");            " + NL + "            System.setProperty(\"http.nonProxyHosts\", ";
  protected final String TEXT_7 = ");" + NL + "            " + NL + "            System.setProperty(\"http.proxyUser\", ";
  protected final String TEXT_8 = ");" + NL + "            ";
  protected final String TEXT_9 = NL + "            ";
  protected final String TEXT_10 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_11 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "; ";
  protected final String TEXT_16 = NL + "            " + NL + "            System.setProperty(\"http.proxyPassword\", decryptedPassword_";
  protected final String TEXT_17 = ");" + NL + "\t\t\t" + NL + "\t\t\tjava.net.Authenticator.setDefault(" + NL + "\t\t\t\tnew java.net.Authenticator() {" + NL + "\t\t\t\t\tpublic java.net.PasswordAuthentication getPasswordAuthentication() {" + NL + "\t\t\t\t\t\treturn new java.net.PasswordAuthentication(" + NL + "\t\t\t\t\t\t   ";
  protected final String TEXT_18 = ", decryptedPassword_";
  protected final String TEXT_19 = ".toCharArray());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t);";
  protected final String TEXT_20 = NL + "\t\t\tSystem.setProperty(\"socksProxySet\",\"true\");   " + NL + "\t\t\t" + NL + "\t\t\tSystem.setProperty(\"socksProxyHost\", ";
  protected final String TEXT_21 = ");" + NL + "            System.setProperty(\"socksProxyPort\", ";
  protected final String TEXT_22 = ");            " + NL + "            System.setProperty(\"java.net.socks.username\", ";
  protected final String TEXT_23 = ");" + NL + "            ";
  protected final String TEXT_24 = NL + "            ";
  protected final String TEXT_25 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_26 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = "; ";
  protected final String TEXT_31 = NL + "            " + NL + "            " + NL + "        \tSystem.setProperty(\"java.net.socks.password\", decryptedPassword_";
  protected final String TEXT_32 = ");    ";
  protected final String TEXT_33 = "\t\t" + NL + "\t\t\t//System.setProperty(\"httpsProxySet\", \"true\");" + NL + "\t\t\t" + NL + "\t\t\tSystem.setProperty(\"https.proxyHost\", ";
  protected final String TEXT_34 = ");" + NL + "            System.setProperty(\"https.proxyPort\", ";
  protected final String TEXT_35 = ");  ";
  protected final String TEXT_36 = "\t\t\t" + NL + "\t\t\t//set it, though in some cases, it is not useful. " + NL + "\t\t\tSystem.setProperty(\"ftpProxySet\", \"true\");" + NL + "\t\t\t" + NL + "\t\t\tSystem.setProperty(\"ftp.proxyHost\", ";
  protected final String TEXT_37 = ");" + NL + "            System.setProperty(\"ftp.proxyPort\", ";
  protected final String TEXT_38 = ");            " + NL + "            System.setProperty(\"ftp.nonProxyHosts\", ";
  protected final String TEXT_39 = ");  ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    // component id
   String cid = node.getUniqueName();
   
   String proxyType = (String)ElementParameterParser.getObjectValue(node,"_PROXY_TYPE_");
   String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
   String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
   String proxyUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
   String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");
   String nonProxyHosts = ElementParameterParser.getValue(node,"__NONPROXYHOSTS__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
           if ("HTTP_PROXY".equals(proxyType)) {
           

    stringBuffer.append(TEXT_4);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(nonProxyHosts );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_8);
    
            String passwordFieldName = "__PROXY_PASSWORD__";
            
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
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
			} else if ("SOCKS_PROXY".equals(proxyType)) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_23);
    
            String passwordFieldName = "__PROXY_PASSWORD__";
            
    stringBuffer.append(TEXT_24);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_27);
    } else {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
			}else if ("HTTPS_PROXY".equals(proxyType)) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_35);
    
			}else if ("FTP_PROXY".equals(proxyType)) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(nonProxyHosts );
    stringBuffer.append(TEXT_39);
    
			}

    return stringBuffer.toString();
  }
}
