package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.ProcessorUtilities;
import org.talend.designer.runprocess.ProcessorException;

public class TRunJobBeginJava
{
  protected static String nl;
  public static synchronized TRunJobBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRunJobBeginJava result = new TRunJobBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "class DealChildJobLibrary_";
  protected final String TEXT_2 = " {" + NL + "" + NL + "\tpublic String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {" + NL + "\t\tString classPathLine = \"\";" + NL + "\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\tif (isNeedAddLibsPath( crcMapPath)) {" + NL + "\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\tois.close();" + NL + "\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t} else {" + NL + "\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t}" + NL + "\t\treturn classPathLine;" + NL + "\t}" + NL + "\t" + NL + "\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;" + NL + "\t}" + NL + "\t" + NL + "\t" + NL + "\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t}" + NL + "\t\treturn line;" + NL + "\t}" + NL + "\t" + NL + "\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\tString jarName = entry.getValue();" + NL + "\t\tString crc = entry.getKey();" + NL + "\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t}" + NL + "\t\treturn line;" + NL + "\t}" + NL + "\t" + NL + "}" + NL + "\tDealChildJobLibrary_";
  protected final String TEXT_3 = " dealChildJobLibrary_";
  protected final String TEXT_4 = " = new DealChildJobLibrary_";
  protected final String TEXT_5 = "();" + NL;
  protected final String TEXT_6 = NL + "\t\t//For different jobs, job name must be different, but classpath and JVM arguments are possbilely different" + NL + "\t\tjava.util.Map<String,List<String>> childJob_commandLine_Mapper_";
  protected final String TEXT_7 = " = new java.util.HashMap<String,List<String>>();" + NL + "\t\tjava.util.List<String> childJob_commandLine_";
  protected final String TEXT_8 = " = null;" + NL + "\t\tString classpathSeparator_";
  protected final String TEXT_9 = " = System.getProperty(\"path.separator\");" + NL + "\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tchildJob_commandLine_";
  protected final String TEXT_11 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t    childJob_commandLine_";
  protected final String TEXT_13 = ".add(\"";
  protected final String TEXT_14 = "\");" + NL + "\t\t\t\t    ";
  protected final String TEXT_15 = NL + "\t\t\t\t      \t\tchildJob_commandLine_";
  protected final String TEXT_16 = ".add(dealChildJobLibrary_";
  protected final String TEXT_17 = ".replaceJarPathsFromCrcMap(";
  protected final String TEXT_18 = ").replaceAll(\";\",classpathSeparator_";
  protected final String TEXT_19 = "));" + NL + "\t\t\t\t    ";
  protected final String TEXT_20 = NL + "\t\t\t\t    \t\tchildJob_commandLine_";
  protected final String TEXT_21 = ".add(";
  protected final String TEXT_22 = ".replaceAll(\";\",classpathSeparator_";
  protected final String TEXT_23 = "));" + NL + "\t\t\t\t    ";
  protected final String TEXT_24 = NL + "\t\t\t\t    \t\tchildJob_commandLine_";
  protected final String TEXT_25 = ".add(dealChildJobLibrary_";
  protected final String TEXT_26 = ".replaceJarPathsFromCrcMap(\"";
  protected final String TEXT_27 = "\").replaceAll(\";\",classpathSeparator_";
  protected final String TEXT_28 = "));" + NL + "\t\t\t\t    ";
  protected final String TEXT_29 = NL + "\t\t\t\t    \t\tchildJob_commandLine_";
  protected final String TEXT_30 = ".add(\"";
  protected final String TEXT_31 = "\".replaceAll(\";\",classpathSeparator_";
  protected final String TEXT_32 = "));" + NL + "\t\t\t\t    ";
  protected final String TEXT_33 = NL + "\t\t\t\tchildJob_commandLine_Mapper_";
  protected final String TEXT_34 = ".put(\"";
  protected final String TEXT_35 = "\",childJob_commandLine_";
  protected final String TEXT_36 = ");\t" + NL + "\t\t\t";
  protected final String TEXT_37 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean useDynamicJob = ("true").equals(ElementParameterParser.getValue(node, "__USE_DYNAMIC_JOB__"));
boolean useIndependentProcess = "true".equals(ElementParameterParser.getValue(node, "__USE_INDEPENDENT_PROCESS__"));

String process = ElementParameterParser.getValue(node,"__PROCESS_TYPE_PROCESS__");
String context = "";

if(useDynamicJob) {
	context = ElementParameterParser.getValue(node,"__CONTEXT_NAME__");
} else {
	context = ElementParameterParser.getValue(node,"__PROCESS_TYPE_CONTEXT__");
}
String[] codeOptions = null;

String[] commandLine = new String[] {"<command>"};

String childJobName;
int jobNamePosition;
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if(isLog4jEnabled){
	codeOptions = new String[] {"\"--father_pid=\"+pid", "\"--root_pid=\"+rootPid", "\"--father_node="+ cid + "\"", "\"--log4jLevel=\"+ log4jLevel"};
} else {
	codeOptions = new String[] {"\"--father_pid=\"+pid", "\"--root_pid=\"+rootPid", "\"--father_node="+ cid + "\""};
}
if(useDynamicJob || useIndependentProcess){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
}
try {
	if(useDynamicJob){
	
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
	
		//issue 19108: The context text field waits for a context name without quotes. The component removes the first quote and the last quote if they exist.
		if(context.startsWith("\"")) {
			context=context.substring(1, context.length());
		}
		if(context.endsWith("\"")) {
			context=context.substring(0, context.length()-1);
		}

		if(process!=null && !process.equals("")){
			String[] childJobIds = process.split(";");
			for (int i=0;i<childJobIds.length;i++) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			commandLine = ProcessorUtilities.getCommandLine("win32",true, childJobIds[i], context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);
			
			    // remove the frontal 2 lines
			    if (commandLine.length > 0 && ProcessorUtilities.isExportConfig()){
					int tmpSize = commandLine.length - 2;
					String[] tmp = new String[tmpSize];
					System.arraycopy(commandLine, 2, tmp, 0, tmpSize);
					commandLine = tmp;
			    }
			    for (int j = 0; j < commandLine.length; j++) {
				  // commandLine[j] = commandLine[j].replace("\n", "");
				  if (j == 0){
				    
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(commandLine[j]);
    stringBuffer.append(TEXT_14);
    
				  } else if (j > 0){
				    if (commandLine[j].indexOf("\"") >= 0){
				    	if(commandLine[j].indexOf(".jar")>=0){
				    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(commandLine[j] );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
				    	}else{
				    
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(commandLine[j] );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
				    	}
				    }else{
				    	if(commandLine[j].indexOf(".jar")>=0){
				    
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(commandLine[j] );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
				    	}else{
				    
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(commandLine[j] );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
				    	}
				    }
				  }
				}
				
				//find the job name and classpath, the job name in front of codeOptions
			    int position = 0;
			    for(String tempCommandLine : commandLine){
			   		if(codeOptions[0].equals(tempCommandLine)){
			   			break;
			   		}
			   		position++;
			    }
			    jobNamePosition = position-1;
			    
                childJobName = commandLine[jobNamePosition];

			    childJobName = childJobName.substring(childJobName.lastIndexOf(".")+1);
				
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(childJobName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
			}
		}
	}
} catch (ProcessorException e) {
}	

    stringBuffer.append(TEXT_37);
    return stringBuffer.toString();
  }
}
