package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGSBucketListBeginJava
{
  protected static String nl;
  public static synchronized TGSBucketListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSBucketListBeginJava result = new TGSBucketListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\tint nb_bucket_";
  protected final String TEXT_3 = " = 0;" + NL + "\torg.jets3t.service.model.GSBucket[] buckets_";
  protected final String TEXT_4 = " = new org.jets3t.service.model.GSBucket[] {};" + NL + "\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_5 = " = null;" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\tservice_";
  protected final String TEXT_7 = " = (org.jets3t.service.impl.rest.httpclient.GoogleStorageService)globalMap.get(\"service_";
  protected final String TEXT_8 = "\");" + NL + "\t\t";
  protected final String TEXT_9 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Get an free connection from \" + \"";
  protected final String TEXT_11 = "\" + \".\");" + NL + "\t\t";
  protected final String TEXT_12 = NL + "\ttry {" + NL + "\t";
  protected final String TEXT_13 = NL + NL + "\t   ";
  protected final String TEXT_14 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_15 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = "; ";
  protected final String TEXT_20 = NL + "\t   " + NL + "\t\torg.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_21 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_22 = ",decryptedPassword_";
  protected final String TEXT_23 = ");" + NL + "\t" + NL + "\t\tservice_";
  protected final String TEXT_24 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_25 = ",jobName+\"/\"+jobVersion+\" (GPN:Talend)\",null);" + NL + "\t\tservice_";
  protected final String TEXT_26 = ".getAccountOwner();" + NL + "\t";
  protected final String TEXT_27 = NL + "\t\tbuckets_";
  protected final String TEXT_28 = "=service_";
  protected final String TEXT_29 = ".listAllBuckets(";
  protected final String TEXT_30 = ");" + NL + "\t";
  protected final String TEXT_31 = NL + "\t\tbuckets_";
  protected final String TEXT_32 = "=service_";
  protected final String TEXT_33 = ".listAllBuckets();" + NL + "\t";
  protected final String TEXT_34 = NL + "\tfor (org.jets3t.service.model.GSBucket bucket_";
  protected final String TEXT_35 = " : buckets_";
  protected final String TEXT_36 = ") {" + NL + "\t\tnb_bucket_";
  protected final String TEXT_37 = "++;" + NL + "\t\tString currentBucketName_";
  protected final String TEXT_38 = " = bucket_";
  protected final String TEXT_39 = ".getName();" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_40 = "_CURRENT_BUCKET_NAME\", currentBucketName_";
  protected final String TEXT_41 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	boolean isSpecifyprojectID=("true").equals(ElementParameterParser.getValue(node,"__SPECIFY_PROJECT__"));
	String projectID=ElementParameterParser.getValue(node,"__PROJECT_ID__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_8);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_11);
    
		}
	}else{
	
    stringBuffer.append(TEXT_12);
    
       String passwordFieldName = "__SECRET_KEY__";
       
    stringBuffer.append(TEXT_13);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_16);
    } else {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    		
	}
	if(isSpecifyprojectID){
	
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(projectID);
    stringBuffer.append(TEXT_30);
    
	}else{
	
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
	}
	
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}
