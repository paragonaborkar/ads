package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;
import java.util.Map;

public class TMomInputInMainJava
{
  protected static String nl;
  public static synchronized TMomInputInMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomInputInMainJava result = new TMomInputInMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_4 = "+1) + \".\");" + NL + "\t";
  protected final String TEXT_5 = NL + "\t\t\t\t\t";
  protected final String TEXT_6 = ".from=";
  protected final String TEXT_7 = ";\t" + NL + "\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t\t";
  protected final String TEXT_9 = ".message=ParserUtils.parseTo_Document(msg_";
  protected final String TEXT_10 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_11 = NL + "\t                ";
  protected final String TEXT_12 = ".message=bytesMsgBody_";
  protected final String TEXT_13 = ";" + NL + "\t            ";
  protected final String TEXT_14 = NL + "\t\t\t\t\t";
  protected final String TEXT_15 = ".message=msg_";
  protected final String TEXT_16 = ";\t" + NL + "\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = " = msg_";
  protected final String TEXT_20 = ".get";
  protected final String TEXT_21 = "(\"";
  protected final String TEXT_22 = "\");" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = " = ParserUtils.parseTo_";
  protected final String TEXT_26 = "(msg_";
  protected final String TEXT_27 = ".getObject(\"";
  protected final String TEXT_28 = "\").toString());" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_29 = "\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = " = message_";
  protected final String TEXT_32 = ".get";
  protected final String TEXT_33 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = " = message_";
  protected final String TEXT_37 = ".get";
  protected final String TEXT_38 = "Property(";
  protected final String TEXT_39 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_40 = "\t    " + NL + "\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\t";
  protected final String TEXT_42 = ".from=";
  protected final String TEXT_43 = ";\t" + NL + "\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\t";
  protected final String TEXT_45 = ".message=ParserUtils.parseTo_Document(msg_";
  protected final String TEXT_46 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t                ";
  protected final String TEXT_48 = ".message=bytesMsgBody_";
  protected final String TEXT_49 = ";" + NL + "\t            ";
  protected final String TEXT_50 = NL + "\t\t\t\t\t";
  protected final String TEXT_51 = ".message=msg_";
  protected final String TEXT_52 = ";\t" + NL + "\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = " = (";
  protected final String TEXT_56 = ")msg_";
  protected final String TEXT_57 = ".get(\"";
  protected final String TEXT_58 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = " = inMessage";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t\t";
  protected final String TEXT_65 = ".messageid=new String(inMessage";
  protected final String TEXT_66 = ".messageId,\"ISO-8859-15\");\t" + NL + "\t\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\t";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = " = mqrfh2_";
  protected final String TEXT_70 = ".get";
  protected final String TEXT_71 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\torg.talend.mq.headers.rfh2.McdArea mcd_";
  protected final String TEXT_73 = " = (org.talend.mq.headers.rfh2.McdArea)mqrfh2_";
  protected final String TEXT_74 = ".getArea(\"mcd\");" + NL + "\t\t\t\tif(mcd_";
  protected final String TEXT_75 = " != null) {";
  protected final String TEXT_76 = NL + "\t\t\t\t";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = " = mcd_";
  protected final String TEXT_79 = ".get";
  protected final String TEXT_80 = "();";
  protected final String TEXT_81 = NL + "\t\t\t\t}";
  protected final String TEXT_82 = NL + "\t\t\t\torg.talend.mq.headers.rfh2.JmsArea jms_";
  protected final String TEXT_83 = " = (org.talend.mq.headers.rfh2.JmsArea)mqrfh2_";
  protected final String TEXT_84 = ".getArea(\"jms\");" + NL + "\t\t\t\tif (jms_";
  protected final String TEXT_85 = " != null ) {";
  protected final String TEXT_86 = NL + "\t\t\t\t";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = " = jms_";
  protected final String TEXT_89 = ".get";
  protected final String TEXT_90 = "();";
  protected final String TEXT_91 = NL + "\t\t\t\t}";
  protected final String TEXT_92 = NL + "\t\t\t\torg.talend.mq.headers.rfh2.UsrArea usr_";
  protected final String TEXT_93 = " = (org.talend.mq.headers.rfh2.UsrArea)mqrfh2_";
  protected final String TEXT_94 = ".getArea(\"usr\");" + NL + "\t\t\t\tif (usr_";
  protected final String TEXT_95 = " != null) {";
  protected final String TEXT_96 = NL + "\t\t\t\t\t";
  protected final String TEXT_97 = ".";
  protected final String TEXT_98 = " = usr_";
  protected final String TEXT_99 = ".get";
  protected final String TEXT_100 = "Property(";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "\t\t\t\t" + NL + "\t\t\t\t}";
  protected final String TEXT_103 = NL + "\t" + NL + "\tnb_line_";
  protected final String TEXT_104 = "++;" + NL + "" + NL + "\t\t";
  protected final String TEXT_105 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	cid = cid.replaceAll("_In", "");
	
	String serverType = ElementParameterParser.getValue(node, "__SERVER__");

    boolean isUseConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
    String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");
	
	String msgBobyType =  ElementParameterParser.getValue(node, "__MESSAGE_BODY_TYPE__");
	
	String useMsgId = ElementParameterParser.getValue(node, "__IS_USE_MESSAGE_ID__");
	String msgId = ElementParameterParser.getValue(node, "__MSG_ID__");
	
	boolean getJmsHeader =  ("true").equals(ElementParameterParser.getValue(node, "__GET_JMS_HEADER__"));
	List<Map<String,String>> jmsHeaders = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JMS_HEADERS__");
	
	boolean getJmsProp =  ("true").equals(ElementParameterParser.getValue(node, "__GET_JMS_PROPERTIES__"));
	List<Map<String,String>> jmsProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JMS_PROPERTIES__");
	
	boolean getMQMDField =  ("true").equals(ElementParameterParser.getValue(node, "__GET_MQMD_FIELDS__"));
	List<Map<String,String>> mqmdFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQMD_FIELDS__");

	boolean useMqHeader = "true".equals(ElementParameterParser.getValue(node, "__USE_MQ_HEADER__"));
	boolean useFixedMqRFH2 = "true".equals(ElementParameterParser.getValue(node, "__USE_FIX_MQRFH2__"));
	List<Map<String,String>> mqrfh2FixedFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQRFH2_FIXED_FIELD__");

	boolean useMqRFH2_mcd = "true".equals(ElementParameterParser.getValue(node, "__USE_MQRFH2_MCD__"));
	List<Map<String,String>> mqrfh2mcdFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQRFH2_MCD_FIELD__");

	boolean useMqRFH2_jms = "true".equals(ElementParameterParser.getValue(node, "__USE_MQRFH2_JMS__"));
	List<Map<String,String>> mqrfh2jmsFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQRFH2_JMS_FIELD__");

	boolean useMqRFH2_usr = "true".equals(ElementParameterParser.getValue(node, "__USE_MQRFH2_USR__"));
	List<Map<String,String>> mqrfh2usrFields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MQRFH2_USR_FIELD__");
	
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

	IMetadataTable metadata=null;
	List<IMetadataColumn> columns = null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
		columns = metadata.getListColumns();
	}
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
    if (isUseConnection) {
		for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
			if (pNode.getUniqueName().equals(connectionComponentName)) {
				serverType=ElementParameterParser.getValue(pNode, "__SERVER__");
			}	
		}
    }
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
	}
	if (("JBoss").equals(serverType)||("ActiveMQ").equals(serverType)) {
		String from = ElementParameterParser.getValue(node, "__FROM__");
		
		//out put
		for(IConnection conn:conns){
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		 		String firstConnName = conn.getName();
		 		
		 		if ("Text".equals(msgBobyType) || "Bytes".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_5);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_7);
    
					if("id_Document".equals(metadata.getColumn("message").getTalendType())){
				
    stringBuffer.append(TEXT_8);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
					} else if("id_byte[]".equals(metadata.getColumn("message").getTalendType())){
				
    stringBuffer.append(TEXT_11);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
					} else {
				
    stringBuffer.append(TEXT_14);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
					}
				} else {
					for(IMetadataColumn column : columns) {
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						if(("byte[]").equals(typeToGenerate)) {
				        	typeToGenerate = "Bytes";
			            }else if(("Character").equals(typeToGenerate)) {
			            	typeToGenerate = "Char";
			            }else if(("Integer").equals(typeToGenerate)) {
			            	typeToGenerate = "Int";
			            } else if(("Java.util.Date").equals(typeToGenerate)||"BigDecimal".equals(typeToGenerate)
			            			||"List".equals(typeToGenerate)) {
			            	typeToGenerate = "Object";
			            }else {
			                typeToGenerate = typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
				        }
				    	if(!"Document".equals(typeToGenerate)){
						
    stringBuffer.append(TEXT_17);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_22);
    
						}else{
					
    stringBuffer.append(TEXT_23);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_28);
    
						}
					}
				}
				/*---------------------------------------------get message headers------------------------------------------------------*/
				if (getJmsHeader) {
					for(Map<String,String> header:jmsHeaders) {
					
    stringBuffer.append(TEXT_29);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(header.get("REFERENCE_COLUMN"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(header.get("JMS_HEADER_NAME"));
    stringBuffer.append(TEXT_33);
    				
					}
				}	
								
				/*---------------------------------------------4.set message headers------------------------------------------------------*/
				if (getJmsProp) {
					for(Map<String,String> prop:jmsProps) {
					
    stringBuffer.append(TEXT_34);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(prop.get("REFERENCE_COLUMN"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(prop.get("JMS_PROPERTIES_TYPE"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(prop.get("JMS_PROPERTIES_NAME"));
    stringBuffer.append(TEXT_39);
    				
					}
				}					
			}
		}	
		/*---------------------------------------------------------end 4----------------------------------------------------------------*/	
		
    stringBuffer.append(TEXT_40);
    
	} else { //server judgement   /***WebSphere MQ*****/
		String queue = ElementParameterParser.getValue(node, "__QUEUE__");

		for(IConnection conn:conns){
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	 			String firstConnName = conn.getName();
		 		if ("Text".equals(msgBobyType) || "Bytes".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_41);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_43);
    
					if("id_Document".equals(metadata.getColumn("message").getTalendType())){
				
    stringBuffer.append(TEXT_44);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
					} else if("id_byte[]".equals(metadata.getColumn("message").getTalendType())){
				
    stringBuffer.append(TEXT_47);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
					} else {
				
    stringBuffer.append(TEXT_50);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
					}
				} else {
					for(IMetadataColumn column : columns) {
						String columType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						
    stringBuffer.append(TEXT_53);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(columType);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_58);
    
					}
				}
		
				/*---------------------------------------------get MQMD Fields------------------------------------------------------*/
			
				if (getMQMDField) {
					for(Map<String,String> field:mqmdFields) {
					
    stringBuffer.append(TEXT_59);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(field.get("REFERENCE_COLUMN"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_63);
    				
					}
				}
		
				if(("true").equals(useMsgId)&& !"Map".equals(msgBobyType)){
				
    stringBuffer.append(TEXT_64);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
				}
				
				// extract the MQRFH2 header
				if (useMqHeader) {
					if (useFixedMqRFH2) {  // fix portion
						for(Map<String,String> field : mqrfh2FixedFields) {
				
    stringBuffer.append(TEXT_67);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(field.get("REFERENCE_COLUMN"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_71);
    
						}
					}
					if(useMqRFH2_mcd ) { // mcd folder

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    
						for(Map<String,String> field : mqrfh2mcdFields) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(field.get("REFERENCE_COLUMN"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_80);
    
						}

    stringBuffer.append(TEXT_81);
    
					}
					if(useMqRFH2_jms ) { // jms folder

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    
						for(Map<String,String> field : mqrfh2jmsFields) {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(field.get("REFERENCE_COLUMN"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_90);
    
						}

    stringBuffer.append(TEXT_91);
    
					}
					
					if(useMqRFH2_usr ) { //usr folder

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    
						for(Map<String,String> field : mqrfh2usrFields) {
							for(IMetadataColumn column : columns) {
								if(column.getLabel().equals(field.get("REFERENCE_COLUMN"))) {
									String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), true);
									if(typeToGenerate.equals("Integer")) {
										typeToGenerate = "Int";
									}

    stringBuffer.append(TEXT_96);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(field.get("REFERENCE_COLUMN"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(field.get("MQMD_FIELD_NAME"));
    stringBuffer.append(TEXT_101);
    
									break;
								}
							}
						}

    stringBuffer.append(TEXT_102);
    
					}
					
				}
			}
		}// for
	}
	
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(TEXT_105);
    return stringBuffer.toString();
  }
}
