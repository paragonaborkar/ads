package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TMicrosoftMQInputEndJava
{
  protected static String nl;
  public static synchronized TMicrosoftMQInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftMQInputEndJava result = new TMicrosoftMQInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t}" + NL + "\t\t}catch(java.net.UnknownHostException ex_";
  protected final String TEXT_3 = "){" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tthrow ex_";
  protected final String TEXT_5 = ";" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tSystem.err.println(\"Unknown host :\" + ex_";
  protected final String TEXT_7 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t}catch(ionic.Msmq.MessageQueueException e_";
  protected final String TEXT_9 = "){" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tthrow e_";
  protected final String TEXT_11 = ";" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tif (msgu_";
  protected final String TEXT_13 = ".isOpen()){" + NL + "\t\t\t\t\tSystem.out.println(\"Receive failure: \" + e_";
  protected final String TEXT_14 = ".getMessage());" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tSystem.out.println(\"Queue open failure: \" + e_";
  protected final String TEXT_15 = ".getMessage());" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t}catch(java.io.UnsupportedEncodingException ex_";
  protected final String TEXT_17 = "){" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tthrow ex_";
  protected final String TEXT_19 = ";" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tSystem.out.println(\"Unsupported encoding: \" + ex_";
  protected final String TEXT_21 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t    }finally{" + NL + "\t\t\ttry{" + NL + "\t\t    \tif (msgu_";
  protected final String TEXT_23 = ".isOpen()){" + NL + "\t\t    \t\tmsgu_";
  protected final String TEXT_24 = ".close();" + NL + "\t\t  \t\t}" + NL + "\t    \t }catch(ionic.Msmq.MessageQueueException e_";
  protected final String TEXT_25 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\t\tthrow e_";
  protected final String TEXT_27 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\tSystem.out.println(\"Close failure: \" + e_";
  protected final String TEXT_29 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_30 = NL + "\t    \t}" + NL + "\t    }" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();  
	List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
	    
	if (outConns != null && outConns.size() > 0){
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
			if(dieOnError){
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}else{
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			}
			
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
			if(dieOnError){
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}else{
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
			}
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			if(dieOnError){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
			}else{
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
			}
			
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
				if(dieOnError){
				
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
				}else{
				
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
				}
				
    stringBuffer.append(TEXT_30);
    
	}
	
    return stringBuffer.toString();
  }
}
