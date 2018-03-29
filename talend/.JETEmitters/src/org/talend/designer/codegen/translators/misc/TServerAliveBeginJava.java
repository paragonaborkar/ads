package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TServerAliveBeginJava
{
  protected static String nl;
  public static synchronized TServerAliveBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TServerAliveBeginJava result = new TServerAliveBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    try {" + NL + "        java.net.InetAddress address_";
  protected final String TEXT_3 = " = java.net.InetAddress.getByName(";
  protected final String TEXT_4 = ");" + NL + "        boolean isAlive_";
  protected final String TEXT_5 = " = address_";
  protected final String TEXT_6 = ".isReachable(";
  protected final String TEXT_7 = " * 1000);" + NL + "        if(isAlive_";
  protected final String TEXT_8 = ") {" + NL + "            globalMap.put(\"";
  protected final String TEXT_9 = "_SERVER_ALIVE_RESULT\",true);" + NL + "        } else {" + NL + "            globalMap.put(\"";
  protected final String TEXT_10 = "_SERVER_ALIVE_RESULT\",false);" + NL + "        }" + NL + "    } catch(java.lang.Exception e) {" + NL + "        globalMap.put(\"";
  protected final String TEXT_11 = "_SERVER_ALIVE_RESULT\",false);" + NL + "    }";
  protected final String TEXT_12 = NL + "    try {";
  protected final String TEXT_13 = NL + "            java.util.Properties properties_";
  protected final String TEXT_14 = " = System.getProperties();" + NL + "            properties_";
  protected final String TEXT_15 = ".put(\"socksProxyHost\",";
  protected final String TEXT_16 = ");" + NL + "            properties_";
  protected final String TEXT_17 = ".put(\"socksProxyPort\",";
  protected final String TEXT_18 = ");" + NL + "            properties_";
  protected final String TEXT_19 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_20 = ");" + NL + "            ";
  protected final String TEXT_21 = NL + "            ";
  protected final String TEXT_22 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_23 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = "; ";
  protected final String TEXT_28 = NL + "            " + NL + "            " + NL + "            properties_";
  protected final String TEXT_29 = ".put(\"java.net.socks.password\", decryptedPassword_";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "        java.net.Socket server_";
  protected final String TEXT_32 = " = new java.net.Socket();" + NL + "        java.net.InetSocketAddress address_";
  protected final String TEXT_33 = " = new java.net.InetSocketAddress(";
  protected final String TEXT_34 = ", ";
  protected final String TEXT_35 = ");" + NL + "        server_";
  protected final String TEXT_36 = ".connect(address_";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = " * 1000);" + NL + "        server_";
  protected final String TEXT_39 = ".close();" + NL + "        globalMap.put(\"";
  protected final String TEXT_40 = "_SERVER_ALIVE_RESULT\",true);" + NL + "    } catch(java.lang.Exception e) {" + NL + "        globalMap.put(\"";
  protected final String TEXT_41 = "_SERVER_ALIVE_RESULT\",false);" + NL + "    }";
  protected final String TEXT_42 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String protocol = ElementParameterParser.getValue(node, "__PROTOCOL__");
String host = ElementParameterParser.getValue(node, "__HOST__");
String timeoutInterval = ElementParameterParser.getValue(node, "__TIMEOUT_INTERVAL__");
boolean isEnableProxy = ("true").equals(ElementParameterParser.getValue(node, "__ENABLE_PROXY_SERVER__"));
if(("PING").equals(protocol)) {
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(timeoutInterval);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
} else {
    String port = ElementParameterParser.getValue(node, "__PORT__");
    
    stringBuffer.append(TEXT_12);
    
        if(isEnableProxy) {
            String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
            String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
            String userName = ElementParameterParser.getValue(node, "__PROXY_USER__");
            String password = ElementParameterParser.getValue(node, "__PROXY_PASS__");
            
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_20);
    
            String passwordFieldName = "__PROXY_PASS__";
            
    stringBuffer.append(TEXT_21);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_24);
    } else {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
        }
        
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(timeoutInterval);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
}

    stringBuffer.append(TEXT_42);
    return stringBuffer.toString();
  }
}
