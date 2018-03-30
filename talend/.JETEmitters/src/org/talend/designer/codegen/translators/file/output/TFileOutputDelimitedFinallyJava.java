package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.AbstractNode;

public class TFileOutputDelimitedFinallyJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedFinallyJava result = new TFileOutputDelimitedFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\tif(resourceMap.get(\"finish_";
  protected final String TEXT_4 = "\") == null){ " + NL + "\t\t\t";
  protected final String TEXT_5 = NL + "\t\t   \t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tsynchronized ((Object[])globalMap.get(\"lockWrite_";
  protected final String TEXT_7 = "\")) {" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\tjava.io.Writer out";
  protected final String TEXT_11 = " = (java.io.Writer)resourceMap.get(\"out_";
  protected final String TEXT_12 = "\");" + NL + "\t\t\t\t\t\tif(out";
  protected final String TEXT_13 = "!=null) {" + NL + "\t\t\t\t\t\t\tout";
  protected final String TEXT_14 = ".flush();" + NL + "\t\t\t\t\t\t\tout";
  protected final String TEXT_15 = ".close();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\tjava.io.Writer out";
  protected final String TEXT_17 = " = (java.io.Writer)resourceMap.get(\"out_";
  protected final String TEXT_18 = "\");" + NL + "\t\t\t\t\t\tjava.io.OutputStreamWriter writer_";
  protected final String TEXT_19 = " = (java.io.OutputStreamWriter)resourceMap.get(\"writer_";
  protected final String TEXT_20 = "\");" + NL + "\t\t\t\t\t\tif(out";
  protected final String TEXT_21 = "!=null) {" + NL + "\t\t\t\t\t\t\tout";
  protected final String TEXT_22 = ".flush();" + NL + "\t\t\t\t\t\t\twriter_";
  protected final String TEXT_23 = ".flush();" + NL + "\t\t\t\t\t\t\tout";
  protected final String TEXT_24 = " = null;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t" + NL + "\t\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_27 = " = (com.talend.csv.CSVWriter)resourceMap.get(\"CsvWriter_";
  protected final String TEXT_28 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t\t\tif(CsvWriter";
  protected final String TEXT_30 = "!=null) {" + NL + "\t\t\t\t\t    \tCsvWriter";
  protected final String TEXT_31 = ".close();" + NL + "\t\t\t\t\t    }" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\t\tjava.io.Writer out";
  protected final String TEXT_33 = " = (java.io.Writer)resourceMap.get(\"out_";
  protected final String TEXT_34 = "\");" + NL + "\t\t\t\t\t\t\tif(out";
  protected final String TEXT_35 = "!=null) {" + NL + "\t\t\t\t\t\t\t\tout";
  protected final String TEXT_36 = ".flush();" + NL + "\t\t\t\t\t\t\t\tout";
  protected final String TEXT_37 = ".close();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\t\tif(CsvWriter";
  protected final String TEXT_39 = "!=null) {" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_40 = ".close();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tjava.io.Writer out";
  protected final String TEXT_41 = " = (java.io.Writer)resourceMap.get(\"out_";
  protected final String TEXT_42 = "\");" + NL + "\t\t\t\t\t\t\tif(out";
  protected final String TEXT_43 = "!=null) {" + NL + "\t\t\t\t\t\t\t\tout";
  protected final String TEXT_44 = ".flush();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_45 = " = (java.io.OutputStreamWriter)resourceMap.get(\"outWriter_";
  protected final String TEXT_46 = "\");" + NL + "\t\t\t\t\t\t\tif(outWriter_";
  protected final String TEXT_47 = "!=null) {" + NL + "\t\t\t\t\t\t\t\toutWriter_";
  protected final String TEXT_48 = ".flush();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t\tif(CsvWriter";
  protected final String TEXT_50 = "!=null) {" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_51 = ".flush();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tjava.io.BufferedWriter bufferWriter_";
  protected final String TEXT_52 = " = (java.io.BufferedWriter)resourceMap.get(\"bufferWriter_";
  protected final String TEXT_53 = "\");" + NL + "\t\t\t\t\t\t\tif(bufferWriter_";
  protected final String TEXT_54 = "!=null) {" + NL + "\t\t\t\t\t\t\t\tbufferWriter_";
  protected final String TEXT_55 = ".flush();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_56 = " = (java.io.OutputStreamWriter)resourceMap.get(\"outWriter_";
  protected final String TEXT_57 = "\");" + NL + "\t\t\t\t\t\t\tif(outWriter_";
  protected final String TEXT_58 = "!=null) {" + NL + "\t\t\t\t\t\t\t\toutWriter_";
  protected final String TEXT_59 = ".flush();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_60 = " = null;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\tif(Boolean.valueOf(String.valueOf(resourceMap.get(\"isFileGenerated_";
  protected final String TEXT_66 = "\"))) && Integer.valueOf(String.valueOf(resourceMap.get(\"nb_line_";
  protected final String TEXT_67 = "\"))) == 0){" + NL + "\t\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t((java.io.File)resourceMap.get(\"file_";
  protected final String TEXT_69 = "\")).delete();" + NL + "\t\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t\t\t((java.io.File)resourceMap.get(\"file";
  protected final String TEXT_71 = "\")).delete();" + NL + "\t\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\t}\t\t" + NL + "\t\t\t";
  protected final String TEXT_73 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_74 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
    boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
    
    String filename = ElementParameterParser.getValue(node,"__FILENAME__");
	boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__")); 
	boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
	
	boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
	
	String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
	boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
	
	boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
	IProcess process = node.getProcess();

    stringBuffer.append(TEXT_2);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
     
		    if(codeGenArgument.getIsRunInMultiThread()){
			
    stringBuffer.append(TEXT_5);
    
			}
			if (((AbstractNode)node).getParallelIterator() != null) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(((AbstractNode)node).getParallelIterator());
    stringBuffer.append(TEXT_7);
     
			}
			if (isParallelize) {
			
    stringBuffer.append(TEXT_8);
     
			}
			
    stringBuffer.append(TEXT_9);
    
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					if(!useStream){
					
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
    
					}else{
					
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
					}
					
    stringBuffer.append(TEXT_25);
    
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				}else{//the following is the tFileOutputCSV component
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
					if(!useStream){
					
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
						if(isInRowMode){
						
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
    
						}
					}else{
						if(isInRowMode){
						
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
						}else{
						
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
					}
				}
			if (isParallelize) {
			
    stringBuffer.append(TEXT_61);
    
			}
			if (((AbstractNode)node).getParallelIterator() != null) {
			
    stringBuffer.append(TEXT_62);
     
			}
			if(codeGenArgument.getIsRunInMultiThread()){
			
    stringBuffer.append(TEXT_63);
    
			}
			
    stringBuffer.append(TEXT_64);
    if(!useStream && isDeleteEmptyFile){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    if(compress && !isAppend && !split){
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    }else{
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    
	}
}

    stringBuffer.append(TEXT_74);
    return stringBuffer.toString();
  }
}
