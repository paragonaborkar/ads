package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TLDAPInputEndJava
{
  protected static String nl;
  public static synchronized TLDAPInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPInputEndJava result = new TLDAPInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t";
  protected final String TEXT_2 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving the record \" + ";
  protected final String TEXT_4 = "_NB_LINE + \".\");" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t}//a" + NL + "\t";
  protected final String TEXT_6 = NL + "    // examine the response controls" + NL + "    javax.naming.ldap.Control[] responseControls_";
  protected final String TEXT_7 = " = ctx_";
  protected final String TEXT_8 = ".getResponseControls();" + NL + "    if (responseControls_";
  protected final String TEXT_9 = " != null) {" + NL + "        for (int i_";
  protected final String TEXT_10 = " = 0; i_";
  protected final String TEXT_11 = " < responseControls_";
  protected final String TEXT_12 = ".length; i_";
  protected final String TEXT_13 = "++) {" + NL + "            if (responseControls_";
  protected final String TEXT_14 = "[i_";
  protected final String TEXT_15 = "] instanceof javax.naming.ldap.PagedResultsResponseControl) {" + NL + "                javax.naming.ldap.PagedResultsResponseControl prrc_";
  protected final String TEXT_16 = " = (javax.naming.ldap.PagedResultsResponseControl) responseControls_";
  protected final String TEXT_17 = "[i_";
  protected final String TEXT_18 = "];               " + NL + "                cookie_";
  protected final String TEXT_19 = " = prrc_";
  protected final String TEXT_20 = ".getCookie();" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "    // pass the cookie back to the server for the next page" + NL + "    ctx_";
  protected final String TEXT_21 = ".setRequestControls(new javax.naming.ldap.Control[] { new javax.naming.ldap.PagedResultsControl(pageSize_";
  protected final String TEXT_22 = ", cookie_";
  protected final String TEXT_23 = ", javax.naming.ldap.Control.CRITICAL) });" + NL + "" + NL + "} while ((cookie_";
  protected final String TEXT_24 = " != null) && (cookie_";
  protected final String TEXT_25 = ".length != 0));";
  protected final String TEXT_26 = NL + "\t}catch (java.lang.Exception e){";
  protected final String TEXT_27 = NL + "        \tthrow new java.lang.Exception(e);";
  protected final String TEXT_28 = NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_30 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_31 = NL + "           \t System.err.println(e.getMessage());";
  protected final String TEXT_32 = NL + "\t}finally{";
  protected final String TEXT_33 = "  " + NL + "\t\tif(ctx_";
  protected final String TEXT_34 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_36 = " - Closing the connection to the server.\");" + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\tctx_";
  protected final String TEXT_38 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_40 = " - Connection to the server closed.\");" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t}";
  protected final String TEXT_42 = NL + "\t}" + NL + "globalMap.put(\"";
  protected final String TEXT_43 = "_NB_LINE\", ";
  protected final String TEXT_44 = "_NB_LINE);";
  protected final String TEXT_45 = NL + "\tlog.info(\"";
  protected final String TEXT_46 = " - Retrieved records count: \" + ";
  protected final String TEXT_47 = "_NB_LINE + \" .\");";
  protected final String TEXT_48 = NL;
  protected final String TEXT_49 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean paging =("true").equals(ElementParameterParser.getValue(node, "__ISPAGING__"));
boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
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
    
        if (dieOnError) {

    stringBuffer.append(TEXT_27);
    
        } else {

    stringBuffer.append(TEXT_28);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    
		}

    stringBuffer.append(TEXT_32);
    
if(("false").equals(useExistingConn)){

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    
}

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    
 }

    stringBuffer.append(TEXT_49);
    return stringBuffer.toString();
  }
}
