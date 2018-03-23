package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TPivotToColumnsDelimitedFinallyJava
{
  protected static String nl;
  public static synchronized TPivotToColumnsDelimitedFinallyJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPivotToColumnsDelimitedFinallyJava result = new TPivotToColumnsDelimitedFinallyJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tif(resourceMap.get(\"finish_";
  protected final String TEXT_3 = "\") == null){" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tif(resourceMap.get(\"CsvWriter";
  protected final String TEXT_5 = "\") != null){" + NL + "\t\t\t\t\t((com.talend.csv.CSVWriter)resourceMap.get(\"CsvWriter";
  protected final String TEXT_6 = "\")).close();" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tif(resourceMap.get(\"out";
  protected final String TEXT_8 = "\") != null){" + NL + "\t\t\t\t \t((java.io.BufferedWriter)resourceMap.get(\"out";
  protected final String TEXT_9 = "\")).flush();" + NL + "\t\t\t\t \t((java.io.BufferedWriter)resourceMap.get(\"out";
  protected final String TEXT_10 = "\")).close();" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\tif(resourceMap.get(\"out";
  protected final String TEXT_12 = "\") != null && resourceMap.get(\"fileName_";
  protected final String TEXT_13 = "\") != null){" + NL + "\t\t\t\t\tif(Integer.valueOf(String.valueOf(resourceMap.get(\"out";
  protected final String TEXT_14 = "\"))) == 0 && (new java.io.File(String.valueOf(resourceMap.get(\"fileName_";
  protected final String TEXT_15 = "\"))).exists())){" + NL + "\t\t\t\t\t\tnew java.io.File(String.valueOf(resourceMap.get(\"fileName_";
  protected final String TEXT_16 = "\"))).delete();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_18 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));
	
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        
        List<Map<String, String>> groupbys = 
            ( List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");

        boolean csvOption = ("true").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"));
        
        String pivotColumn = ElementParameterParser.getValue(node, "__PIVOT_COLUMN__");

        String aggColumn = ElementParameterParser.getValue(node, "__AGGREGATION_COLUMN__");
        
        String aggFunction = ElementParameterParser.getValue(node, "__AGGREGATION_FUNCTION__");
        
        String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
        
        String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
        
        boolean isCsvOption=("true").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"));
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
			if(isCsvOption) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}else{
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
			if(isDeleteEmptyFile){
			
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
    
			}
			
    stringBuffer.append(TEXT_17);
    
    }
}

    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}
