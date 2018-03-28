package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGSBucketExistMainJava
{
  protected static String nl;
  public static synchronized TGSBucketExistMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSBucketExistMainJava result = new TGSBucketExistMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\tboolean bucketExist_";
  protected final String TEXT_3 = "=false;" + NL + "\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_4 = " = null;" + NL + "\ttry {" + NL + "\t";
  protected final String TEXT_5 = NL + "\t\tservice_";
  protected final String TEXT_6 = " = (org.jets3t.service.impl.rest.httpclient.GoogleStorageService)globalMap.get(\"service_";
  protected final String TEXT_7 = "\");" + NL + "\t\t";
  protected final String TEXT_8 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Get an free connection from \" + \"";
  protected final String TEXT_10 = "\" + \".\");" + NL + "\t\t";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + NL + "\t   ";
  protected final String TEXT_13 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "; ";
  protected final String TEXT_19 = NL + "\t   " + NL + "\t\torg.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_20 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_21 = ",decryptedPassword_";
  protected final String TEXT_22 = ");" + NL + "\t" + NL + "\t\tservice_";
  protected final String TEXT_23 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_24 = ",jobName+\"/\"+jobVersion+\" (GPN:Talend)\",null);" + NL + "\t\tservice_";
  protected final String TEXT_25 = ".getAccountOwner();" + NL + "\t";
  protected final String TEXT_26 = NL + "\t\tif(service_";
  protected final String TEXT_27 = ".getBucket(";
  protected final String TEXT_28 = ")!=null){" + NL + "\t\t\tbucketExist_";
  protected final String TEXT_29 = "=true;" + NL + "\t\t}" + NL + "\t}catch(org.jets3t.service.ServiceException e_";
  protected final String TEXT_30 = ") {" + NL + "\t\t";
  protected final String TEXT_31 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_32 = ");" + NL + "\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_34 = " - Exception in component ";
  protected final String TEXT_35 = ":\" + e_";
  protected final String TEXT_36 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_38 = ":\");" + NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_39 = ".getMessage());" + NL + "\t\t\tif(e_";
  protected final String TEXT_40 = ".getErrorCode()!=null){" + NL + "\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_42 = " - \" + e_";
  protected final String TEXT_43 = ".getErrorCode());" + NL + "\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_45 = ".getErrorCode());" + NL + "\t\t\t}" + NL + "\t\t\tif(e_";
  protected final String TEXT_46 = ".getErrorMessage()!=null){" + NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_48 = " - \" + e_";
  protected final String TEXT_49 = ".getErrorMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_51 = ".getErrorMessage());" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_52 = NL + "\t}finally{" + NL + "\t\tif(service_";
  protected final String TEXT_53 = " !=null){" + NL + "\t\t\tservice_";
  protected final String TEXT_54 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_55 = NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_56 = "_BUCKET_NAME\", ";
  protected final String TEXT_57 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_58 = "_BUCKET_EXIST\", bucketExist_";
  protected final String TEXT_59 = ");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	String bucketName=ElementParameterParser.getValue(node,"__BUCKET__");
	
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_7);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_10);
    
		}
	}else{
	
    stringBuffer.append(TEXT_11);
    
       String passwordFieldName = "__SECRET_KEY__";
       
    stringBuffer.append(TEXT_12);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    } else {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(accessKey);
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
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
		if (("true").equals(dieOnError)) {
		
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
		} else {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
				}
				
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
				}
				
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
		}
		if(!("true").equals(useExistingConn)) {
		
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
		}
		
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    return stringBuffer.toString();
  }
}
