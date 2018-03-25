package org.talend.designer.codegen.translators.cloud.amazon.sqs;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSQSOutputEndJava
{
  protected static String nl;
  public static synchronized TSQSOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSQSOutputEndJava result = new TSQSOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "    \t\tif(entries_";
  protected final String TEXT_3 = ".size() > 0){" + NL + "    \t\t\tsendMsgRequest_";
  protected final String TEXT_4 = ".setEntries(entries_";
  protected final String TEXT_5 = ");" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\t\t\t\tlog.debug(\"Sending the message with batch request\" );" + NL + "\t";
  protected final String TEXT_7 = NL + "    \t\t\tcom.amazonaws.services.sqs.model.SendMessageBatchResult sendMsgResult_";
  protected final String TEXT_8 = " = conn_";
  protected final String TEXT_9 = ".sendMessageBatch(sendMsgRequest_";
  protected final String TEXT_10 = ");" + NL + "    \t\t\tresultSuccessEntries_";
  protected final String TEXT_11 = " =  sendMsgResult_";
  protected final String TEXT_12 = ".getSuccessful();" + NL + "    \t\t\tresultErrorEntries_";
  protected final String TEXT_13 = " =  sendMsgResult_";
  protected final String TEXT_14 = ".getFailed();" + NL + "    \t\t\tnb_success_";
  protected final String TEXT_15 = " = nb_success_";
  protected final String TEXT_16 = " + resultSuccessEntries_";
  protected final String TEXT_17 = ".size();" + NL + "    \t\t\tnb_reject_";
  protected final String TEXT_18 = " = nb_reject_";
  protected final String TEXT_19 = " + resultErrorEntries_";
  protected final String TEXT_20 = ".size();" + NL + "\t";
  protected final String TEXT_21 = "\t" + NL + "        \t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - \"+resultSuccessEntries_";
  protected final String TEXT_23 = ".size()+\" messages were sent successfully\");" + NL + "        \t\t\tfor(com.amazonaws.services.sqs.model.SendMessageBatchResultEntry resultEntry_";
  protected final String TEXT_24 = ":resultSuccessEntries_";
  protected final String TEXT_25 = "){" + NL + "        \t\t\t\tlog.debug(\"";
  protected final String TEXT_26 = " - Message Start: \");" + NL + "            \t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - MessageId: \" + resultEntry_";
  protected final String TEXT_28 = ".getMessageId());" + NL + "            \t\t\tlog.debug(\"";
  protected final String TEXT_29 = " - MD5OfBody: \" + resultEntry_";
  protected final String TEXT_30 = ".getMD5OfMessageBody());" + NL + "            \t\t\tlog.debug(\"";
  protected final String TEXT_31 = " - Message End \");" + NL + "            \t\t}" + NL + "            \t\tlog.debug(\"";
  protected final String TEXT_32 = " - \"+resultErrorEntries_";
  protected final String TEXT_33 = ".size()+\" messages were sent failed\");" + NL + "        \t\t\tfor(com.amazonaws.services.sqs.model.BatchResultErrorEntry resultErrorEntry_";
  protected final String TEXT_34 = ":resultErrorEntries_";
  protected final String TEXT_35 = "){" + NL + "        \t\t\t\tlog.debug(\"";
  protected final String TEXT_36 = " - Error row number: \" + resultErrorEntry_";
  protected final String TEXT_37 = ".getId());" + NL + "            \t\t\tlog.debug(\"";
  protected final String TEXT_38 = " - Error code: \" + resultErrorEntry_";
  protected final String TEXT_39 = ".getCode());" + NL + "            \t\t\tlog.debug(\"";
  protected final String TEXT_40 = " - Error message: \" + resultErrorEntry_";
  protected final String TEXT_41 = ".getMessage());" + NL + "            \t\t}" + NL + "\t";
  protected final String TEXT_42 = NL + "\t\t\t}" + NL + "\t";
  protected final String TEXT_43 = NL + NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_44 = "){" + NL + "\t\tnb_reject_";
  protected final String TEXT_45 = "++;" + NL + "\t\t";
  protected final String TEXT_46 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_47 = ");" + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_49 = " - \" + e_";
  protected final String TEXT_50 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_52 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t}finally{" + NL + "\t\tif(conn_";
  protected final String TEXT_54 = " !=null){" + NL + "\t\t\tconn_";
  protected final String TEXT_55 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_56 = NL + "\t}" + NL + "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_57 = "_NB_LINE\", nbline_";
  protected final String TEXT_58 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_59 = "_NB_LINE_SUCCESS\", nb_success_";
  protected final String TEXT_60 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_61 = "_NB_LINE_REJECTED\", nb_reject_";
  protected final String TEXT_62 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
        CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
        INode node = (INode)codeGenArgument.getArgument();
        String cid = node.getUniqueName();
        String queueUrl = ElementParameterParser.getValue(node,"__QUEUE_URL__");
        boolean dieOnError = "true".equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
        boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
        String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
        boolean useBatch = "true".equals(ElementParameterParser.getValue(node,"__USE_BATCH__"));
    	if(useBatch){
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
				if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_6);
    
				}
	
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
    
				if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
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
    
				}
	
    stringBuffer.append(TEXT_42);
    
		}
	
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
		if (dieOnError) {
		
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
		} else {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
			}
			
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
		}
		if(!("true").equals(useExistingConn)) {
		
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
		}
		
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    return stringBuffer.toString();
  }
}
