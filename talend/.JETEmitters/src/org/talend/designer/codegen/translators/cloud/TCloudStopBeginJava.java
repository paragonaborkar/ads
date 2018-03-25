package org.talend.designer.codegen.translators.cloud;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TCloudStopBeginJava
{
  protected static String nl;
  public static synchronized TCloudStopBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCloudStopBeginJava result = new TCloudStopBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t        " + NL + "\t";
  protected final String TEXT_3 = NL + "\t" + NL + "\t";
  protected final String TEXT_4 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_5 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = "; ";
  protected final String TEXT_10 = NL + "   \t" + NL + "\torg.jclouds.compute.ComputeServiceContext context_";
  protected final String TEXT_11 = " = new org.jclouds.compute.ComputeServiceContextFactory().createContext(\"";
  protected final String TEXT_12 = "\", ";
  protected final String TEXT_13 = ", decryptedPassword_";
  protected final String TEXT_14 = ");" + NL + "\torg.jclouds.compute.ComputeService client_";
  protected final String TEXT_15 = " = context_";
  protected final String TEXT_16 = ".getComputeService();" + NL;
  protected final String TEXT_17 = NL + "\t" + NL + "\t\tclient_";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = "NodesMatching(org.jclouds.compute.predicates.NodePredicates.";
  protected final String TEXT_20 = NL + "\t\t\tRUNNING);";
  protected final String TEXT_21 = NL + "\t\t\tinGroup(";
  protected final String TEXT_22 = ".toLowerCase()));";
  protected final String TEXT_23 = NL + "\t\t\trunningInGroup(";
  protected final String TEXT_24 = ".toLowerCase()));";
  protected final String TEXT_25 = NL + "\t\tclient_";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = "Node(";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String accesskey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
	String provider = ElementParameterParser.getValue(node, "__PROVIDER__");
	String predicates = ElementParameterParser.getValue(node, "__PREDICATES__");
	
	String instanceName = ElementParameterParser.getValue(node, "__INSTANCE_NAME__");
	String id = ElementParameterParser.getValue(node, "__ID__");
	
	String providerId = "";
	if("AWS_EC2".equals(provider)) {
		providerId = "aws-ec2";
	}


    stringBuffer.append(TEXT_2);
    
	String passwordFieldName = "__SECRET_KEY__";
	
    stringBuffer.append(TEXT_3);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(providerId);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(accesskey);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
	if(!("WITH_IDS".equals(predicates))) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ACTION__").toLowerCase());
    stringBuffer.append(TEXT_19);
    
		if("RUNNING".equals(predicates)) {

    stringBuffer.append(TEXT_20);
    
		}
		if("IN_GROUP".equals(predicates)) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(instanceName);
    stringBuffer.append(TEXT_22);
    
		}
		if("RUNNING_IN_GROUP".equals(predicates)) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(instanceName);
    stringBuffer.append(TEXT_24);
    
		}
	} else {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ACTION__").toLowerCase());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_28);
    
	}

    stringBuffer.append(TEXT_29);
    return stringBuffer.toString();
  }
}
