package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.AbstractNode;

public class TFileOutputPositionalFinallyJava
{
  protected static String nl;
  public static synchronized TFileOutputPositionalFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputPositionalFinallyJava result = new TFileOutputPositionalFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t";
  protected final String TEXT_31 = NL + "\tsynchronized (multiThreadLockWrite) {";
  protected final String TEXT_32 = NL + "\tsynchronized ((Object[])globalMap.get(\"lockWrite_";
  protected final String TEXT_33 = "\")) {";
  protected final String TEXT_34 = NL + "\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\tsynchronized (pLockWrite) {";
  protected final String TEXT_35 = NL + "\tjava.io.Writer out";
  protected final String TEXT_36 = " = (java.io.Writer)resourceMap.get(\"out";
  protected final String TEXT_37 = "\");" + NL + "\tout";
  protected final String TEXT_38 = ".close();";
  protected final String TEXT_39 = NL + "\tjava.io.Writer out";
  protected final String TEXT_40 = " = (java.io.Writer)resourceMap.get(\"out";
  protected final String TEXT_41 = "\");" + NL + "\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_42 = " = (java.io.OutputStreamWriter)resourceMap.get(\"outWriter_";
  protected final String TEXT_43 = "\");" + NL + "\tout";
  protected final String TEXT_44 = ".flush();" + NL + "\toutWriter_";
  protected final String TEXT_45 = ".flush();" + NL + "\toutWriter_";
  protected final String TEXT_46 = " = null;";
  protected final String TEXT_47 = NL + "    } ";
  protected final String TEXT_48 = NL + "\t}";
  protected final String TEXT_49 = NL + "\t}";
  protected final String TEXT_50 = NL + "\t";
  protected final String TEXT_51 = NL + "\t\t\t\tif(Boolean.valueOf(String.valueOf(resourceMap.get(\"isFileGenerated_";
  protected final String TEXT_52 = "\"))) && Integer.valueOf(String.valueOf(resourceMap.get(\"nb_line_";
  protected final String TEXT_53 = "\"))) == 0){" + NL + "\t\t\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\t\t\t((java.io.File)resourceMap.get(\"file_";
  protected final String TEXT_55 = "\")).delete();" + NL + "\t\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\t((java.io.File)resourceMap.get(\"createFile";
  protected final String TEXT_57 = "\")).delete();" + NL + "\t\t\t\t\t";
  protected final String TEXT_58 = "\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_59 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_30);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
    boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));
	
	boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
	boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
	boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));

	String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
	boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;

	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {

     
	if(codeGenArgument.getIsRunInMultiThread()){

    stringBuffer.append(TEXT_31);
    
	}
	if (((AbstractNode)node).getParallelIterator() != null) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(((AbstractNode)node).getParallelIterator());
    stringBuffer.append(TEXT_33);
     
	}
	if (isParallelize) {

    stringBuffer.append(TEXT_34);
     
	}
	if(!useStream){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
     
	}else{

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    
	}
	if ( isParallelize) {

    stringBuffer.append(TEXT_47);
    
    }
	if (((AbstractNode)node).getParallelIterator() != null) {

    stringBuffer.append(TEXT_48);
     
	}
	if(codeGenArgument.getIsRunInMultiThread()){

    stringBuffer.append(TEXT_49);
    
	}

    stringBuffer.append(TEXT_50);
    
	}
}

    if(!useStream && isDeleteEmptyFile){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    if(compress && !isAppend){
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    }else{
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    return stringBuffer.toString();
  }
}
