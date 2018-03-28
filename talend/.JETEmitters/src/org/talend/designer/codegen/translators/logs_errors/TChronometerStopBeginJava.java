package org.talend.designer.codegen.translators.logs_errors;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TChronometerStopBeginJava
{
  protected static String nl;
  public static synchronized TChronometerStopBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TChronometerStopBeginJava result = new TChronometerStopBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\tlong time";
  protected final String TEXT_3 = ";" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\tlog.info(\"";
  protected final String TEXT_5 = " - Stop time: \"+System.currentTimeMillis()+\" milliseconds\");" + NL + "\t";
  protected final String TEXT_6 = NL + "\t  \ttime";
  protected final String TEXT_7 = " = System.currentTimeMillis() - ((Long)globalMap.get(\"";
  protected final String TEXT_8 = "\")).longValue();" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Duration since ";
  protected final String TEXT_11 = " start: \"+time";
  protected final String TEXT_12 = "+\" milliseconds\");" + NL + "\t\t";
  protected final String TEXT_13 = NL + "\t\ttime";
  protected final String TEXT_14 = " = System.currentTimeMillis() - startTime;" + NL + "\t\t";
  protected final String TEXT_15 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_16 = " - Duration since job start: \"+time";
  protected final String TEXT_17 = "+\" milliseconds\");" + NL + "\t\t";
  protected final String TEXT_18 = NL + "\t   \t\tSystem.out.print(\"[ ";
  protected final String TEXT_19 = " ]  \");" + NL + "\t\t";
  protected final String TEXT_20 = NL + "\t    \tSystem.out.print(\"   \" + time";
  protected final String TEXT_21 = "/1000 + \"seconds   \");" + NL + "\t\t    " + NL + "\t  \t\t";
  protected final String TEXT_22 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_23 = " - Readable duration : \"+ time";
  protected final String TEXT_24 = "/1000 + \" seconds\");" + NL + "\t\t\t";
  protected final String TEXT_25 = NL + "\t  \tSystem.out.println(";
  protected final String TEXT_26 = " + \"  \" + time";
  protected final String TEXT_27 = " + \" milliseconds\");" + NL + "\t  \t";
  protected final String TEXT_28 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_29 = " - \"+ ";
  protected final String TEXT_30 = " + \"  \" + time";
  protected final String TEXT_31 = " + \" milliseconds\");" + NL + "\t\t";
  protected final String TEXT_32 = " " + NL + "\t";
  protected final String TEXT_33 = NL + "\tLong currentTime";
  protected final String TEXT_34 = " = System.currentTimeMillis();" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_35 = "\", currentTime";
  protected final String TEXT_36 = ");" + NL + "\t";
  protected final String TEXT_37 = NL + "\t\tlog.info(\"";
  protected final String TEXT_38 = " - Current time \" + currentTime";
  protected final String TEXT_39 = " + \" milliseconds\");" + NL + "\t";
  protected final String TEXT_40 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_41 = "_STOPTIME\", currentTime";
  protected final String TEXT_42 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_43 = "_DURATION\", time";
  protected final String TEXT_44 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean sinceStarter = ("true").equals(ElementParameterParser.getValue(node, "__SINCE_STARTER__"));
	String starter = ElementParameterParser.getValue(node, "__STARTER__");
	boolean display = ("true").equals(ElementParameterParser.getValue(node, "__DISPLAY__"));
	boolean displayComponentName = ("true").equals(ElementParameterParser.getValue(node, "__DISPLAY_COMPONENT_NAME__"));
	boolean displayReadableDuration = ("true").equals(ElementParameterParser.getValue(node, "__DISPLAY_READABLE_DURATION__"));
	String caption = ElementParameterParser.getValue(node, "__CAPTION__");
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	}
	if (sinceStarter) {
	
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(starter);
    stringBuffer.append(TEXT_8);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(starter);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
		}
	}else {
	
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		}
	}

	if (display) {
		if (displayComponentName) {
	  	
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
		}
		if (displayReadableDuration) {
		
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
	  		if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
			}
	  	}
	  	
    stringBuffer.append(TEXT_25);
    stringBuffer.append(caption);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
  		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(caption);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
		}
		
    stringBuffer.append(TEXT_32);
    
	}
	
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
  	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
	}
	
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    return stringBuffer.toString();
  }
}
