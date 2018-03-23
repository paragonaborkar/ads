package org.talend.designer.codegen.translators.cloud.amazon.sqs;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import java.util.List;
import java.util.Map;

public class TSQSInputMainJava
{
  protected static String nl;
  public static synchronized TSQSInputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSQSInputMainJava result = new TSQSInputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\t\t";
  protected final String TEXT_3 = " = new ";
  protected final String TEXT_4 = "Struct();" + NL + "   \t";
  protected final String TEXT_5 = NL + "\t\t\t\t\t\tjava.util.Map<String,String> attributes_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = "_message.getAttributes();" + NL + "\t";
  protected final String TEXT_8 = NL + "\t\t\t\t\t\tjava.util.Map<String,com.amazonaws.services.sqs.model.MessageAttributeValue> msgAttributes_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = "_message.getMessageAttributes();" + NL + "\t\t\t\t\t\tcom.amazonaws.services.sqs.model.MessageAttributeValue attributeValue_";
  protected final String TEXT_11 = " = null;" + NL + "\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "_message.get";
  protected final String TEXT_16 = "();" + NL + "\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = " = attributes_";
  protected final String TEXT_20 = ".get(\"";
  protected final String TEXT_21 = "\");" + NL + "\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\t\t\t\tattributeValue_";
  protected final String TEXT_23 = " = msgAttributes_";
  protected final String TEXT_24 = ".get(\"";
  protected final String TEXT_25 = "\");" + NL + "    \t\t\t\t\t\t\tif(attributeValue_";
  protected final String TEXT_26 = " != null){" + NL + "\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t\t\t\t\tjava.nio.ByteBuffer binaryValue_";
  protected final String TEXT_28 = " = attributeValue_";
  protected final String TEXT_29 = ".getBinaryValue();" + NL + "\t\t\t\t\t\t\t\t\t\tif(binaryValue_";
  protected final String TEXT_30 = "!=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = " = binaryValue_";
  protected final String TEXT_33 = ".array();" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = " = attributeValue_";
  protected final String TEXT_37 = ".getStringValue();" + NL + "   \t";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\t\t\t\t\t\tif(attributeValue_";
  protected final String TEXT_39 = ".getStringValue()!=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = " = ParserUtils.parseTo_";
  protected final String TEXT_42 = "(attributeValue_";
  protected final String TEXT_43 = ".getStringValue());" + NL + "\t\t\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_44 = NL + "    \t\t\t\t\t\t\t}" + NL + "\t";
  protected final String TEXT_45 = "\t" + NL + "\t\tlog.debug(\"";
  protected final String TEXT_46 = " - Message Start: \");" + NL + "\t\tlog.debug(\"";
  protected final String TEXT_47 = " - MessageId: \" + ";
  protected final String TEXT_48 = "_message.getMessageId());" + NL + "\t\tlog.debug(\"";
  protected final String TEXT_49 = " - ReceiptHandle: \" + ";
  protected final String TEXT_50 = "_message.getReceiptHandle());" + NL + "\t\tlog.debug(\"";
  protected final String TEXT_51 = " - MD5OfBody: \" + ";
  protected final String TEXT_52 = "_message.getMD5OfBody());" + NL + "\t\tlog.debug(\"";
  protected final String TEXT_53 = " - Body: \" + ";
  protected final String TEXT_54 = "_message.getBody());" + NL + "\t\tlog.debug(\"";
  protected final String TEXT_55 = " - Attribute Start: \");" + NL + "\t\tfor (java.util.Map.Entry<String, String> ";
  protected final String TEXT_56 = "_entry : ";
  protected final String TEXT_57 = "_message.getAttributes().entrySet()) {" + NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_58 = " - Attribute Name: \" + ";
  protected final String TEXT_59 = "_entry.getKey() + \" ,Attribute Value: \" + ";
  protected final String TEXT_60 = "_entry.getValue());" + NL + "        }" + NL + "\t";
  protected final String TEXT_61 = "\t" + NL + "\t\tconn_";
  protected final String TEXT_62 = ".deleteMessage(new com.amazonaws.services.sqs.model.DeleteMessageRequest().withQueueUrl(";
  protected final String TEXT_63 = ").withReceiptHandle(";
  protected final String TEXT_64 = "_message.getReceiptHandle()));" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String queueUrl = ElementParameterParser.getValue(node,"__QUEUE_URL__");
    boolean deleteMessages = "true".equals(ElementParameterParser.getValue(node,"__DELETE_MESSAGE__"));
    boolean getAttributes = "true".equals(ElementParameterParser.getValue(node,"__GET_ATTRIBUTES__"));
    boolean getMessageAttributes = "true".equals(ElementParameterParser.getValue(node,"__GET_MESSAGE_ATTRIBUTES__"));
    boolean dieOnError = "true".equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    List<String> msgInfoField = java.util.Arrays.asList("MessageId","ReceiptHandle","MD5OfBody","Body");
    List<String> msgDefultAttributes = java.util.Arrays.asList("ApproximateFirstReceiveTimestamp","ApproximateReceiveCount","SenderId","SentTimestamp");
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas != null) && (metadatas.size() > 0)) {//b
		IMetadataTable metadata = metadatas.get(0);
		if (metadata != null) {//a
			List<IMetadataColumn> columns = metadata.getListColumns();	
			List< ? extends IConnection> outConns = node.getOutgoingConnections();
			for (IConnection conn : outConns) { //2	
				if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN)||conn.getLineStyle().equals(EConnectionType.FLOW_MERGE)) { //3
					String outputConnName = conn.getName();
   	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_4);
    
					if (getAttributes){
	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
					}
					if (getMessageAttributes){
	
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
					}
					for (int i = 0; i < columns.size(); i++) {//4
 						IMetadataColumn column = columns.get(i);
 						if (msgInfoField.contains(column.getLabel())) {
	
    stringBuffer.append(TEXT_12);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_16);
     
						} else if (msgDefultAttributes.contains(column.getLabel()) && getAttributes) {
	
    stringBuffer.append(TEXT_17);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_21);
    
						} else {
							if (getMessageAttributes){
	
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
    								if ("id_byte[]".equals(column.getTalendType())){
	
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
    								}else{
    									String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
										JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
										if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
   	
    stringBuffer.append(TEXT_34);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
										}else{
    
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(outputConnName );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
										}
    								}
	
    stringBuffer.append(TEXT_44);
    
							}
						}
					}//4
				}//3
			}//2
		}//a
	}//b
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
	}
	if(deleteMessages){
	
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(queueUrl);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
	}
	
    return stringBuffer.toString();
  }
}
