package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TPOPEndJava
{
  protected static String nl;
  public static synchronized TPOPEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPOPEndJava result = new TPOPEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t}";
  protected final String TEXT_2 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving the record \" + nb_email_";
  protected final String TEXT_4 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\t} catch (javax.mail.MessageRemovedException mre) {" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.warn(\"";
  protected final String TEXT_7 = " - One mail fails to retrieve since it was removed\");" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\tSystem.out.println(\"one mail fails to retrieve since it was removed\");" + NL + "\t";
  protected final String TEXT_9 = NL + "\t\t\t} catch (javax.mail.MessagingException me) {" + NL + "\t\t\t\tif (!\"Cannot load header\".equals(me.getMessage())) {" + NL + "      \t\t\t\tthrow me;" + NL + "\t\t\t\t}else{ " + NL + "\t\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_11 = " - One mail fails to retrieve since it was removed\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_12 = NL + "      \t\t\t\tSystem.out.println(\"one mail fails to retrieve since it was removed\");" + NL + "      \t\t\t}" + NL + "\t";
  protected final String TEXT_13 = NL + "\t\t\t}" + NL + "\t}" + NL + "" + NL + "\tif (folder_";
  protected final String TEXT_14 = " != null) {" + NL + "\t\t";
  protected final String TEXT_15 = NL + "\t\t\tfolder_";
  protected final String TEXT_16 = ".close(true); " + NL + "\t\t";
  protected final String TEXT_17 = " " + NL + "\t\t\tfolder_";
  protected final String TEXT_18 = ".close(false);" + NL + "\t\t";
  protected final String TEXT_19 = NL + "\t}" + NL + "" + NL + "\tif (store_";
  protected final String TEXT_20 = " != null) {" + NL + "\t\t";
  protected final String TEXT_21 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_22 = " - Closing the connection to the server.\");" + NL + "\t\t";
  protected final String TEXT_23 = NL + "\t\tstore_";
  protected final String TEXT_24 = ".close();" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_26 = " - Connection to the server closed.\");" + NL + "\t\t";
  protected final String TEXT_27 = NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_28 = "_NB_EMAIL\", nb_email_";
  protected final String TEXT_29 = ");  " + NL + "" + NL + "\t";
  protected final String TEXT_30 = NL + "\t\tlog.info(\"";
  protected final String TEXT_31 = " - Retrived \"+nb_email_";
  protected final String TEXT_32 = " + \" mails.\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    String cid = node.getUniqueName();
    boolean bDeleteFromServer = "true".equals(ElementParameterParser.getValue(node, "__DELETE_FROM_SERVER__"));
    List<Map<String, String>> filterList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_FILTER__");
    String protocol = ElementParameterParser.getValue(node, "__PROTOCOL__");
    
		if (filterList.size() > 0) {
    
    stringBuffer.append(TEXT_1);
    
    	}
    	
		if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    		
		}
		
		if ("pop3".equals(protocol)) {
  
    stringBuffer.append(TEXT_5);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    
		} else {
    stringBuffer.append(TEXT_9);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    
		}
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    if (bDeleteFromServer) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    } else {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    }
    return stringBuffer.toString();
  }
}
