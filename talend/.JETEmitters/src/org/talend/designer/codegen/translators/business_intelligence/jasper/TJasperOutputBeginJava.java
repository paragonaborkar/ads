package org.talend.designer.codegen.translators.business_intelligence.jasper;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TJasperOutputBeginJava
{
  protected static String nl;
  public static synchronized TJasperOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJasperOutputBeginJava result = new TJasperOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "       " + NL + "    int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "    String jrxmlName_";
  protected final String TEXT_4 = " = (";
  protected final String TEXT_5 = ").substring((";
  protected final String TEXT_6 = ").lastIndexOf(\"/\"),(";
  protected final String TEXT_7 = ").lastIndexOf(\".\"));" + NL + "    String tempFile_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = "+jrxmlName_";
  protected final String TEXT_10 = "+\".csv\";" + NL + "    java.io.File file_";
  protected final String TEXT_11 = "=new java.io.File(tempFile_";
  protected final String TEXT_12 = ");\t" + NL + "    if (!file_";
  protected final String TEXT_13 = ".exists()) {" + NL + "        file_";
  protected final String TEXT_14 = ".createNewFile();" + NL + "    }" + NL + "    " + NL + "    com.talend.csv.CSVWriter CsvWriter_";
  protected final String TEXT_15 = "=new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                new java.io.FileOutputStream(tempFile_";
  protected final String TEXT_16 = ",false),";
  protected final String TEXT_17 = ")));  " + NL + "\t";
  protected final String TEXT_18 = NL + "   \tString[] headColu_";
  protected final String TEXT_19 = "=new String[";
  protected final String TEXT_20 = "];";
  protected final String TEXT_21 = NL + "   \theadColu_";
  protected final String TEXT_22 = "[";
  protected final String TEXT_23 = "]=\"";
  protected final String TEXT_24 = "\";";
  protected final String TEXT_25 = NL + "    CsvWriter_";
  protected final String TEXT_26 = ".writeNext(headColu_";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        String filename = ElementParameterParser.getValue(node,"__JRXML_FILE__");
        String tempDirectory = ElementParameterParser.getValue(node,"__TEMP_FILE__");
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
        

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(tempDirectory);
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
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_17);
    
        List<IMetadataColumn> columns = metadata.getListColumns();
        int sizeColumns = columns.size();

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_20);
    
     	for(int i = 0; i < sizeColumns; i++){
        	IMetadataColumn column = columns.get(i);

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_24);
    
		}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
	}
}

    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
