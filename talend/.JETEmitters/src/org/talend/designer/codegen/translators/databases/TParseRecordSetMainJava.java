package org.talend.designer.codegen.translators.databases;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TParseRecordSetMainJava
{
  protected static String nl;
  public static synchronized TParseRecordSetMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TParseRecordSetMainJava result = new TParseRecordSetMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.sql.ResultSet re_";
  protected final String TEXT_3 = " = (java.sql.ResultSet)";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL + "\tboolean hasNextRecord_";
  protected final String TEXT_7 = "=false;" + NL + "\tString res_str_";
  protected final String TEXT_8 = " = null;" + NL + "\tjava.sql.Timestamp res_ts_";
  protected final String TEXT_9 = " = null;" + NL + "    while (true) {" + NL + "\ttry{" + NL + "\t\thasNextRecord_";
  protected final String TEXT_10 = "=re_";
  protected final String TEXT_11 = ".next();" + NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_12 = "){" + NL + "\t\thasNextRecord_";
  protected final String TEXT_13 = "=false;" + NL + "\t}" + NL + "\tif (!hasNextRecord_";
  protected final String TEXT_14 = ") {" + NL + "\t\tbreak;" + NL + "\t}" + NL + "\tnb_line_";
  protected final String TEXT_15 = "++;\t";
  protected final String TEXT_16 = NL + "\t";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = " = re_";
  protected final String TEXT_19 = ".getObject(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\t\t\t\tres_str_";
  protected final String TEXT_22 = " = re_";
  protected final String TEXT_23 = ".getString(";
  protected final String TEXT_24 = ");" + NL + "\t\t\t\t\t\t\t\t\tif(res_str_";
  protected final String TEXT_25 = " != null){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = " = ParserUtils.parseTo_Date(res_str_";
  protected final String TEXT_28 = ".trim(),";
  protected final String TEXT_29 = ");" + NL + "\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = " = ParserUtils.parseTo_Date(res_str_";
  protected final String TEXT_32 = ",";
  protected final String TEXT_33 = ");" + NL + "   \t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_34 = NL + "\t\t\t\t\t\t\t\t\tres_ts_";
  protected final String TEXT_35 = " = re_";
  protected final String TEXT_36 = ".getTimestamp(";
  protected final String TEXT_37 = ");" + NL + "\t\t\t\t\t\t\t\t\tif(res_ts_";
  protected final String TEXT_38 = " != null){" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " = " + NL + "    \t\t\t\t\t\t\t\t\t\tnew java.util.Date(res_ts_";
  protected final String TEXT_41 = ".getTime());" + NL + "       \t\t\t\t\t\t\t\t }else{" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = " = null;" + NL + "        \t\t\t\t\t\t\t}";
  protected final String TEXT_44 = NL + "\tres_str_";
  protected final String TEXT_45 = " = re_";
  protected final String TEXT_46 = ".getString(";
  protected final String TEXT_47 = ");" + NL + "\tif(res_str_";
  protected final String TEXT_48 = " != null){" + NL + "\t\t";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = " = res_str_";
  protected final String TEXT_51 = ".trim();" + NL + "\t}else{" + NL + "\t\t//";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = " = res_str_";
  protected final String TEXT_54 = ";" + NL + "\t\t";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = " = ";
  protected final String TEXT_57 = ";" + NL + "\t}";
  protected final String TEXT_58 = NL + "\tres_str_";
  protected final String TEXT_59 = " = re_";
  protected final String TEXT_60 = ".getString(";
  protected final String TEXT_61 = ");" + NL + "\tif(res_str_";
  protected final String TEXT_62 = "!=null){" + NL + "\t\t";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = " = ParserUtils.parseTo_";
  protected final String TEXT_65 = "(res_str_";
  protected final String TEXT_66 = ".trim());" + NL + "\t}else{" + NL + "\t\t//";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " = ParserUtils.parseTo_";
  protected final String TEXT_69 = "(res_str_";
  protected final String TEXT_70 = ");" + NL + "\t\t";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = " = ";
  protected final String TEXT_73 = ";\t\t" + NL + "\t}";
  protected final String TEXT_74 = NL + "\t\t";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = ";";
  protected final String TEXT_79 = NL + NL + NL + NL + NL + "\t\t\t";
  protected final String TEXT_80 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
String recordsetField = ElementParameterParser.getValue(node, "__RECORDSET_FIELD__");
List<Map<String, String>> attriTable = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__ATTRIBUTE_TABLE__");

String inputConnName = "";
if (node.getIncomingConnections()!=null) {
	for (IConnection incomingConn : node.getIncomingConnections()) {
		if (incomingConn.getLineStyle().equals(EConnectionType.FLOW_MAIN)) {
			inputConnName = incomingConn.getName();
			IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
			for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
				if(inputCol.getLabel().equals(recordsetField)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(inputConnName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(recordsetField);
    stringBuffer.append(TEXT_5);
    
				}
			}
		}
	}
}

List< ? extends IConnection> outputConns = node.getOutgoingSortedConnections();
String outputConnName = "";
if (outputConns!=null && outputConns.size()>0) {
	IConnection outputConn = outputConns.get(0);
	outputConnName = outputConn.getName();  
    IMetadataTable outputMetadata = outputConn.getMetadataTable();
    if (outputMetadata!=null) {
    	List<IMetadataColumn> columns= outputMetadata.getListColumns();

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
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
    
		//get the mapping column 
		for (Map<String, String> tmpMap:attriTable) { 
			for(IMetadataColumn column:columns) {
				String attriName = tmpMap.get("SCHEMA_COLUMN");
				if (attriName!=null && column.getLabel().equals(attriName)) {
					if(tmpMap.get("VALUE").length()>0){
						boolean isNotSetDefault = false;
						String defaultValue=column.getDefault();
						if(defaultValue!=null){
							isNotSetDefault = defaultValue.length()==0;
						}else{
							isNotSetDefault=true;
						}
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						if (javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(tmpMap.get("VALUE"));
    stringBuffer.append(TEXT_20);
    
						}else if (javaType == JavaTypesManager.DATE) {
    							String patternValue = column.getPattern();
    							if (patternValue != null && patternValue.length()>0){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(tmpMap.get("VALUE"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_33);
    
    							 } else {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(tmpMap.get("VALUE"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_43);
    
								}
						}else if (javaType == JavaTypesManager.STRING) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(tmpMap.get("VALUE"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_57);
    
    					}else {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(tmpMap.get("VALUE"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_73);
    
						}
					}else{

    stringBuffer.append(TEXT_74);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(inputConnName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_78);
    
					}
				}
			}
		}

	}
}

    stringBuffer.append(TEXT_79);
    stringBuffer.append(TEXT_80);
    return stringBuffer.toString();
  }
}
