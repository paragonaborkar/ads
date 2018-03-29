package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class TDenormalizeSortedRowBeginJava
{
  protected static String nl;
  public static synchronized TDenormalizeSortedRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDenormalizeSortedRowBeginJava result = new TDenormalizeSortedRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = "final ";
  protected final String TEXT_5 = "Struct[] emmitArray_";
  protected final String TEXT_6 = " = new ";
  protected final String TEXT_7 = "Struct[2];" + NL + "emmitArray_";
  protected final String TEXT_8 = "[0] = new ";
  protected final String TEXT_9 = "Struct();" + NL + "emmitArray_";
  protected final String TEXT_10 = "[1] = new ";
  protected final String TEXT_11 = "Struct();";
  protected final String TEXT_12 = NL + "int currentRowIndex_";
  protected final String TEXT_13 = " = 0;" + NL + "boolean  flag_";
  protected final String TEXT_14 = " = true;//flag for the encounter of first row." + NL + "" + NL + "\t";
  protected final String TEXT_15 = NL + "\t\tlog.info(\"";
  protected final String TEXT_16 = " - Start to denormalize the data from datasource.\");" + NL + "\t";
  protected final String TEXT_17 = " group_";
  protected final String TEXT_18 = "_";
  protected final String TEXT_19 = "=null";
  protected final String TEXT_20 = "=false";
  protected final String TEXT_21 = "=(";
  protected final String TEXT_22 = ")0";
  protected final String TEXT_23 = ";";
  protected final String TEXT_24 = NL + "StringBuilder tempSB_";
  protected final String TEXT_25 = " = new StringBuilder();";
  protected final String TEXT_26 = NL + "java.util.List<";
  protected final String TEXT_27 = "> denormalize_";
  protected final String TEXT_28 = "_";
  protected final String TEXT_29 = " = new java.util.ArrayList<";
  protected final String TEXT_30 = ">();";
  protected final String TEXT_31 = NL + "StringBuilder denormalize_";
  protected final String TEXT_32 = "_";
  protected final String TEXT_33 = " = new StringBuilder();";
  protected final String TEXT_34 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
if ((metadatas!=null)&&(metadatas.size()>0)) {

    IMetadataTable metadata = metadatas.get(0);
    List< ? extends IConnection> inConns = node.getIncomingConnections();
    IMetadataTable inMetadata = null;
    if(inConns != null){ 
    	for (IConnection conn : inConns) { 
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
				inMetadata = conn.getMetadataTable();
    			break;
			}
		}
	}
    if (metadata != null && inMetadata != null) { 
    	List<IMetadataColumn> inColumns = inMetadata.getListColumns();
    	Map<String, String> typesMap = new HashMap<String, String>();
    	for(IMetadataColumn column : inColumns){
    		String type = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
    		typesMap.put(column.getLabel(), type);
    	}
        List<Map<String, String>> denormalizes = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DENORMALIZE_COLUMNS__");
        List<String> denormalizeColumns = new ArrayList<String>();
        List<String> denormalizeColumnsType = new ArrayList<String>();
        List<String> denormalizeDelimiters = new ArrayList<String>();
        List<Boolean> denormalizeMergeFlags = new ArrayList<Boolean>();
        List<IMetadataColumn> groupColumns = new ArrayList<IMetadataColumn>();
        for(Map<String, String> denormalize : denormalizes){
        	String columnName = denormalize.get("INPUT_COLUMN");
        	if(denormalizeColumns.contains(columnName)){
        		continue;
        	}
        	denormalizeColumns.add(columnName);
        	denormalizeColumnsType.add(typesMap.get(columnName));
        	denormalizeDelimiters.add(denormalize.get("DELIMITER"));
        	denormalizeMergeFlags.add(("true").equals(denormalize.get("MERGE")));
        }
        for(IMetadataColumn column : inColumns){
        	String columnName = column.getLabel();
        	if(denormalizeColumns.contains(columnName)){
        		continue;
        	}
        	groupColumns.add(column);
        }
        
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_11);
    
				}
			}
		}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    	
	if (isLog4jEnabled) {
	
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
	}
	//gen groups variable
	for(IMetadataColumn column : groupColumns){
		String type = typesMap.get(column.getLabel());

    stringBuffer.append(type );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    
if(!JavaTypesManager.isJavaPrimitiveType(column.getTalendType(),column.isNullable())){
    stringBuffer.append(TEXT_19);
    }else if(("boolean").equals(type) || ("Boolean").equals(type)){
    stringBuffer.append(TEXT_20);
    }else{
    stringBuffer.append(TEXT_21);
    stringBuffer.append(type );
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    	}
	
	//gen denormalize variable
	boolean flag = false;
	for(int i = 0; i < denormalizeColumns.size(); i++){
		String columnName = denormalizeColumns.get(i);
		String columnType = denormalizeColumnsType.get(i);
		if(denormalizeMergeFlags.get(i)){
			if(!flag){
				flag = true;

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(columnType );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnType );
    stringBuffer.append(TEXT_30);
    
		}else{

    stringBuffer.append(TEXT_31);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
		}
	}
	}
}

    stringBuffer.append(TEXT_34);
    return stringBuffer.toString();
  }
}
