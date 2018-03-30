package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import java.util.List;

public class TUniqRowOutMainJava
{
  protected static String nl;
  public static synchronized TUniqRowOutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniqRowOutMainJava result = new TUniqRowOutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tif (rowsInBuffer_1_";
  protected final String TEXT_2 = " >= bufferSize_1_";
  protected final String TEXT_3 = ") {// buffer is full do sort and" + NL + "\t" + NL + "\t\tjava.util.Arrays.<rowStruct_";
  protected final String TEXT_4 = "> sort(buffer_1_";
  protected final String TEXT_5 = ", 0, bufferSize_1_";
  protected final String TEXT_6 = ", comparator_1_";
  protected final String TEXT_7 = ");" + NL + "\t                    " + NL + "\t    java.io.File file_";
  protected final String TEXT_8 = " = new java.io.File(workDirectory_";
  protected final String TEXT_9 = " + \"/";
  protected final String TEXT_10 = "_TEMP_\" + files_1_";
  protected final String TEXT_11 = ".size());" + NL + "\t    ";
  protected final String TEXT_12 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Invoke request to delete file: \"+file_";
  protected final String TEXT_14 = ".getPath()+\" When VM exit.\");" + NL + "\t\t";
  protected final String TEXT_15 = NL + "\t    file_";
  protected final String TEXT_16 = ".deleteOnExit();" + NL + "\t    java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(new java.io.FileOutputStream(file_";
  protected final String TEXT_17 = ")));" + NL + "\t    ";
  protected final String TEXT_18 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_19 = " - Writing the data into: \"+file_";
  protected final String TEXT_20 = ".getPath());" + NL + "\t\t";
  protected final String TEXT_21 = NL + "\t\tfor (int i_";
  protected final String TEXT_22 = " = 0; i_";
  protected final String TEXT_23 = " < bufferSize_1_";
  protected final String TEXT_24 = "; i_";
  protected final String TEXT_25 = "++) {" + NL + "\t    \tbuffer_1_";
  protected final String TEXT_26 = "[i_";
  protected final String TEXT_27 = "].writeData(rw);" + NL + "\t    }" + NL + "\t                    " + NL + "\t    rw.close();" + NL + "\t\t";
  protected final String TEXT_28 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_29 = " - Wrote successfully.\");" + NL + "\t\t";
  protected final String TEXT_30 = NL + "\t    files_1_";
  protected final String TEXT_31 = ".add(file_";
  protected final String TEXT_32 = ");" + NL + "\t" + NL + "\t    rowsInBuffer_1_";
  protected final String TEXT_33 = " = 0;" + NL + "\t}" + NL + "\trowStruct_";
  protected final String TEXT_34 = " row_";
  protected final String TEXT_35 = " = buffer_1_";
  protected final String TEXT_36 = "[rowsInBuffer_1_";
  protected final String TEXT_37 = "++];" + NL + "\trow_";
  protected final String TEXT_38 = ".id_";
  protected final String TEXT_39 = " = ++nb_";
  protected final String TEXT_40 = ";";
  protected final String TEXT_41 = NL + "\trow_";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = ";" + NL + "    \t";
  protected final String TEXT_46 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = ElementParameterParser.getValue(node, "__CID__");

String connName = "";
if (node.getIncomingConnections().size()==1) {
	IConnection conn = node.getIncomingConnections().get(0);
	connName = conn.getName();
}
final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
///////////////
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0) && !("").equals(connName)) {//HSS_____0
	IMetadataTable metadata = metadatas.get(0);
    List<IMetadataColumn> columnList = metadata.getListColumns();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
		if (isLog4jEnabled) {
		
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
		}
		
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
		if (isLog4jEnabled) {
		
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    
		}
		
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    
		if (isLog4jEnabled) {
		
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
		}
		
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
    for(IMetadataColumn column : columnList){//HSS_____0_____1
    	
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_45);
    
    }//HSS_____0_____1
}//HSS_____0

    stringBuffer.append(TEXT_46);
    return stringBuffer.toString();
  }
}
