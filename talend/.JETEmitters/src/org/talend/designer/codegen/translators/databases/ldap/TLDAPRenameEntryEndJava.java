package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TLDAPRenameEntryEndJava
{
  protected static String nl;
  public static synchronized TLDAPRenameEntryEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPRenameEntryEndJava result = new TLDAPRenameEntryEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\tlog.info(\"";
  protected final String TEXT_3 = " - Closing the connection to the server.\");" + NL + "\t";
  protected final String TEXT_4 = NL + "\tctx_";
  protected final String TEXT_5 = ".close();" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\tlog.info(\"";
  protected final String TEXT_7 = " - Connection to the server closed.\");" + NL + "\t";
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");

    
if(("false").equals(useExistingConn)){

    stringBuffer.append(TEXT_1);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    }
    
}

    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
