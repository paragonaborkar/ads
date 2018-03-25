package org.talend.designer.codegen.translators.business.bonita;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TBonitaInstantiateProcessEndJava
{
  protected static String nl;
  public static synchronized TBonitaInstantiateProcessEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBonitaInstantiateProcessEndJava result = new TBonitaInstantiateProcessEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tif (client_";
  protected final String TEXT_3 = " != null) {" + NL + "\t\t\tclient_";
  protected final String TEXT_4 = ".logout();" + NL + "\t\t\tclient_";
  protected final String TEXT_5 = ".close();" + NL + "\t\t}";
  protected final String TEXT_6 = NL + "\t\tif (httpConn_";
  protected final String TEXT_7 = " != null) {" + NL + "\t\t\thttpConn_";
  protected final String TEXT_8 = ".disconnect();" + NL + "\t\t}";
  protected final String TEXT_9 = NL + "\t\tif (client_";
  protected final String TEXT_10 = " != null) {" + NL + "\t\t\tclient_";
  protected final String TEXT_11 = ".logout();" + NL + "\t\t}";
  protected final String TEXT_12 = NL + "\t\tif (loginContext_";
  protected final String TEXT_13 = " != null) {" + NL + "\t\t\tloginContext_";
  protected final String TEXT_14 = ".logout();" + NL + "\t\t}";
  protected final String TEXT_15 = NL + "resourceMap.put(\"finish_";
  protected final String TEXT_16 = "\", true); ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String clientMode = ElementParameterParser.getValue(node, "__CLIENT_MODE__");
	
	String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
	
	if ("HTTP_CLIENT".equals(clientMode)) {
		if("BONITA_652".equals(dbVersion) || "BONITA_724".equals(dbVersion)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
		} else {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
		}
	} else {
		if("BONITA_652".equals(dbVersion) || "BONITA_724".equals(dbVersion)) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		} else {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
		}
	}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
