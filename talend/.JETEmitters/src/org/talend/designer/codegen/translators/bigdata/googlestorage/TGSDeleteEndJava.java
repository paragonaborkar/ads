package org.talend.designer.codegen.translators.bigdata.googlestorage;

import java.util.List;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;

public class TGSDeleteEndJava
{
  protected static String nl;
  public static synchronized TGSDeleteEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSDeleteEndJava result = new TGSDeleteEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + NL + "\t\t   \t\t}" + NL + "\t\t    }" + NL + "\t";
  protected final String TEXT_3 = NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_4 = "){" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_6 = ");" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t\tif(e_";
  protected final String TEXT_8 = " instanceof org.jets3t.service.ServiceException){" + NL + "\t\t\t\torg.jets3t.service.ServiceException servError_";
  protected final String TEXT_9 = " = (org.jets3t.service.ServiceException)e_";
  protected final String TEXT_10 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_12 = " - Exception in component:\" + servError_";
  protected final String TEXT_13 = ".getErrorCode());" + NL + "\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_15 = ":\");" + NL + "\t\t\t\tSystem.err.println(servError_";
  protected final String TEXT_16 = ".getMessage());" + NL + "\t\t\t\tif(servError_";
  protected final String TEXT_17 = ".getErrorCode()!=null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_19 = " - \" + servError_";
  protected final String TEXT_20 = ".getErrorMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\tSystem.err.println(servError_";
  protected final String TEXT_22 = ".getErrorCode());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(servError_";
  protected final String TEXT_23 = ".getErrorMessage()!=null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_25 = " - \" + e_";
  protected final String TEXT_26 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\tSystem.err.println(servError_";
  protected final String TEXT_28 = ".getErrorMessage());" + NL + "\t\t\t\t}" + NL + "\t" + NL + "\t\t\t}else{" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_30 = " - \" + e_";
  protected final String TEXT_31 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_33 = ".getMessage());" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_34 = NL + "\t}finally{" + NL + "\t\tif(service_";
  protected final String TEXT_35 = " !=null){" + NL + "\t\t\tservice_";
  protected final String TEXT_36 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_37 = NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_38 = "_NB_LINE\", nb_line_";
  protected final String TEXT_39 = ");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean queryDelObjInListBuckets = "true".equals(ElementParameterParser.getValue(node,"__DEL_IN_LIST_BUCKETS__"));
	List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	if(!queryDelObjInListBuckets || buckets.size()>0){
	
    stringBuffer.append(TEXT_2);
    
	}
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
		if (("true").equals(dieOnError)) {
		
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
		} else {
		
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
				}
				
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
					}
					
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
					}
					
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
				}
				
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
		}
		if(!("true").equals(useExistingConn)) {
		
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
		}
		
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    return stringBuffer.toString();
  }
}
