package org.talend.designer.codegen.translators.business.bonita;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TBonitaInstantiateProcessFinallyJava
{
  protected static String nl;
  public static synchronized TBonitaInstantiateProcessFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBonitaInstantiateProcessFinallyJava result = new TBonitaInstantiateProcessFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "if(resourceMap.get(\"finish_";
  protected final String TEXT_3 = "\") == null){";
  protected final String TEXT_4 = NL + "\t\tif (resourceMap.get(\"client_";
  protected final String TEXT_5 = "\") != null) {" + NL + "\t\t\t((org.talend.bonita.RestClient)resourceMap.get(\"client_";
  protected final String TEXT_6 = "\")).logout();" + NL + "\t\t\t((org.talend.bonita.RestClient)resourceMap.get(\"client_";
  protected final String TEXT_7 = "\")).close();" + NL + "\t\t}";
  protected final String TEXT_8 = NL + "\t\tif (resourceMap.get(\"httpConn_";
  protected final String TEXT_9 = "\") != null) {" + NL + "\t\t\t((java.net.HttpURLConnection)resourceMap.get(\"httpConn_";
  protected final String TEXT_10 = "\")).disconnect();" + NL + "\t\t}";
  protected final String TEXT_11 = NL + "\t\tif (resourceMap.get(\"client_";
  protected final String TEXT_12 = "\") != null) {" + NL + "\t\t\t((org.talend.bonita.RestClient)resourceMap.get(\"client_";
  protected final String TEXT_13 = "\")).logout();" + NL + "\t\t}";
  protected final String TEXT_14 = NL + "\t\tif (resourceMap.get(\"loginContext_";
  protected final String TEXT_15 = "\") != null) {" + NL + "\t\t\t((javax.security.auth.login.LoginContext)resourceMap.get(\"loginContext_";
  protected final String TEXT_16 = "\")).logout();" + NL + "\t\t}";
  protected final String TEXT_17 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String clientMode = ElementParameterParser.getValue(node, "__CLIENT_MODE__");
	
	String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if ("HTTP_CLIENT".equals(clientMode)) {
		if("BONITA_652".equals(dbVersion) || "BONITA_724".equals(dbVersion)) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
		} else {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
		}
	} else {
		if("BONITA_652".equals(dbVersion) || "BONITA_724".equals(dbVersion)) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
		} else {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
		}
	}

    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
