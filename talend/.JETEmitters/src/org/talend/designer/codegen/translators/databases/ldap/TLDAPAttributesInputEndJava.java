package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TLDAPAttributesInputEndJava
{
  protected static String nl;
  public static synchronized TLDAPAttributesInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPAttributesInputEndJava result = new TLDAPAttributesInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t";
  protected final String TEXT_2 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving the record \" + ";
  protected final String TEXT_4 = "_NB_LINE + \".\");" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t}//a" + NL;
  protected final String TEXT_6 = NL + "\t// examine the response controls" + NL + "\tjavax.naming.ldap.Control[] responseControls_";
  protected final String TEXT_7 = " = ctx_";
  protected final String TEXT_8 = ".getResponseControls();" + NL + "\tif (responseControls_";
  protected final String TEXT_9 = " != null) {" + NL + "\t\tfor (int i_";
  protected final String TEXT_10 = " = 0; i_";
  protected final String TEXT_11 = " < responseControls_";
  protected final String TEXT_12 = ".length; i_";
  protected final String TEXT_13 = "++) {" + NL + "\t\t\tif (responseControls_";
  protected final String TEXT_14 = "[i_";
  protected final String TEXT_15 = "] instanceof javax.naming.ldap.PagedResultsResponseControl) {" + NL + "\t\t\t\tjavax.naming.ldap.PagedResultsResponseControl prrc_";
  protected final String TEXT_16 = " = (javax.naming.ldap.PagedResultsResponseControl) responseControls_";
  protected final String TEXT_17 = "[i_";
  protected final String TEXT_18 = "];   \t\t\t" + NL + "\t\t\t\tcookie_";
  protected final String TEXT_19 = " = prrc_";
  protected final String TEXT_20 = ".getCookie();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\t// pass the cookie back to the server for the next page" + NL + "\tctx_";
  protected final String TEXT_21 = ".setRequestControls(new javax.naming.ldap.Control[] { new javax.naming.ldap.PagedResultsControl(pageSize_";
  protected final String TEXT_22 = ", cookie_";
  protected final String TEXT_23 = ", javax.naming.ldap.Control.CRITICAL) });" + NL + "" + NL + "} while ((cookie_";
  protected final String TEXT_24 = " != null) && (cookie_";
  protected final String TEXT_25 = ".length != 0));";
  protected final String TEXT_26 = NL + NL + "rootSchema_";
  protected final String TEXT_27 = ".close();";
  protected final String TEXT_28 = NL + "\t";
  protected final String TEXT_29 = NL + "\t\tlog.info(\"";
  protected final String TEXT_30 = " - Closing the connection to the server.\");" + NL + "\t";
  protected final String TEXT_31 = NL + "\tctx_";
  protected final String TEXT_32 = ".close();" + NL + "\t";
  protected final String TEXT_33 = NL + "\t\tlog.info(\"";
  protected final String TEXT_34 = " - Connection to the server closed.\");" + NL + "\t";
  protected final String TEXT_35 = NL + "globalMap.put(\"";
  protected final String TEXT_36 = "_NB_LINE\", ";
  protected final String TEXT_37 = "_NB_LINE);";
  protected final String TEXT_38 = NL + "\tlog.info(\"";
  protected final String TEXT_39 = " - Retrieved records count: \" + ";
  protected final String TEXT_40 = "_NB_LINE +  \" .\");";
  protected final String TEXT_41 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean paging =("true").equals(ElementParameterParser.getValue(node, "__ISPAGING__"));
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)&&(metadatas.get(0) != null)) {

    stringBuffer.append(TEXT_1);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    if(paging){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
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
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
if(("false").equals(useExistingConn)){

    stringBuffer.append(TEXT_28);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    }
    
}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    }
    
 }

    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}
