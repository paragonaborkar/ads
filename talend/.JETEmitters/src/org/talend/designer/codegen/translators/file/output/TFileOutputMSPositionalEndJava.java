package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TFileOutputMSPositionalEndJava
{
  protected static String nl;
  public static synchronized TFileOutputMSPositionalEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputMSPositionalEndJava result = new TFileOutputMSPositionalEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "String tempStringM";
  protected final String TEXT_30 = " = null;" + NL + "            " + NL + "int tempLengthM";
  protected final String TEXT_31 = " = 0;" + NL + "" + NL + "StringBuilder sb_";
  protected final String TEXT_32 = " = new StringBuilder();";
  protected final String TEXT_33 = NL;
  protected final String TEXT_34 = NL + "out";
  protected final String TEXT_35 = ".close();" + NL + "globalMap.put(\"";
  protected final String TEXT_36 = "_NB_LINE\",nb_line_";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

final String cid = node.getUniqueName();

List<String> connList = new java.util.ArrayList<String>();
List< ? extends IConnection> conns = node.getIncomingConnections();
if(conns!=null){
	for(int i=0;i<conns.size();i++){
		IConnection connTemp = conns.get(i);
	    if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	   		connList.add(connTemp.getName());
	    }
	}
}

final String separator = ElementParameterParser.getValue(
            node,
            "__ROWSEPARATOR__"
        );
final String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
final boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
final String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
final String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);   


class Gen{//HSS_____inner class
	List<Map<String, String>> schemas;
	List<String> connections;
	Map<String, List<IMetadataColumn>> connectionMapColumnList;
	Set<String> connectionSet;
	StringBuilder sb;
	
	Gen(List<Map<String, String>> schemas, List<String> connections, Map<String, List<IMetadataColumn>> connectionMapColumnList){
		this.schemas = schemas;
		this.connections = connections;
		this.connectionMapColumnList = connectionMapColumnList;
		
		sb = new StringBuilder();
		connectionSet = new java.util.HashSet<String>();
	}
	
	private void genError(String msg){
		sb = new StringBuilder();
		sb.append("if(true){\nthrow new RuntimeException(\"").append(msg).append("\");\n}\n");
		connectionSet.addAll(connections);
	}
	
	void generate(int index){
		String connection = connections.get(index);
		if(connectionSet.contains(connection)){
			return;
		}else{
			connectionSet.add(connection);
		}
		Map<String, String> schema = schemas.get(index);
		String parent = schema.get("PARENT_ROW");
		boolean hasParent = !(("").equals(parent) || parent == null);
		if(hasParent){//assign key....
			sb.append("String key_").append(connection).append("_").append(parent).append(" = String.valueOf(").append(parent).append("_e.").append(schema.get("PARENT_KEY_COLUMN")).append(");\n");
			//sb.append("Object v_").append(connection).append("_").append(cid).append(" = ").append(connection).append("Map_").append(cid).append(".get(key_").append(connection).append("_").append(schema.get("PARENT_ROW")).append(");\n");
			sb.append("Object v_").append(connection).append("_").append(cid).append(" = ").append(connection).append("Map_").append(cid).append(".get(key_").append(connection).append("_").append(schema.get("PARENT_ROW")).append(");\n");
            sb.append(connection).append("Struct[] ra_").append(connection).append("_").append(cid).append(" = EMPTY_ARRAY_").append(connection).append("_").append(cid).append(";\n");
            sb.append("if (v_").append(connection).append("_").append(cid).append(" != null) {\n");
			sb.append("if (v_").append(connection).append("_").append(cid).append(" instanceof List) {\n");
			sb.append("ra_").append(connection).append("_").append(cid).append(" = ((List<").append(connection).append("Struct>) v_").append(connection).append("_").append(cid).append(").toArray(ra_").append(connection).append("_").append(cid).append(");\n");
            sb.append("} else {\n");
			sb.append("ra_").append(connection).append("_").append(cid).append(" = new ").append(connection).append("Struct[1];\n");
			sb.append("ra_").append(connection).append("_").append(cid).append("[0] = (").append(connection).append("Struct) v_").append(connection).append("_").append(cid).append(";\n");
            sb.append("}\n");
            sb.append("}\n");

            sb.append("for (int ").append(connection).append("_index_").append(cid).append(" = 0; ").append(connection).append("_index_").append(cid).append(" < ra_").append(connection).append("_").append(cid).append(".length; ").append(connection).append("_index_").append(cid).append("++) {\n");
			sb.append(connection).append("Struct ").append(connection).append("_e = ra_").append(connection).append("_").append(cid).append("[").append(connection).append("_index_").append(cid).append("];\n");
		}else{
			sb.append("for (int ").append(connection).append("_index_").append(cid).append("= 0; ").append(connection).append("_index_").append(cid).append(" < ").append(connection).append("List_").append(cid).append(".size(); ").append(connection).append("_index_").append(cid).append("++) {\n");
			sb.append("").append(connection).append("Struct ").append(connection).append("_e = ").append(connection).append("List_").append(cid).append(".get(").append(connection).append("_index_").append(cid).append(");\n");
		}
		
		List<IMetadataColumn> columns = connectionMapColumnList.get(connection);
		int sizeColumns = columns.size();
		String[] sizes = schema.get("PATTERN").split(",");
		if(sizes.length < sizeColumns){
			genError("Error: pattern " + schema.get("PATTERN") + " is not specified right for connection " + connection);
			return;
		}
		for (int i = 0; i < sizeColumns; i++) {
			IMetadataColumn column = columns.get(i);
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
			///////////////////////////////////
			sb.append("//get  and format output String begin\n");
    		sb.append("tempStringM").append(cid).append("=");				
			if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable()) ) {
				sb.append("String.valueOf(").append(connection).append("_e.").append(column.getLabel()).append(")");					
			} else {
				sb.append("(").append(connection).append("_e.").append(column.getLabel()).append(" == null) ? \"\": ");
				if(javaType == JavaTypesManager.DATE && patternValue!=null){
					sb.append("FormatterUtils.format_Date(").append(connection).append("_e.").append(column.getLabel()).append(", ").append(patternValue).append(")");
				}else if(javaType == JavaTypesManager.BYTE_ARRAY){
					sb.append("java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(").append(connection).append("_e.").append(column.getLabel()).append(")).toString()");
				}else if(javaType == JavaTypesManager.STRING){
					sb.append(connection).append("_e.").append(column.getLabel());
				} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        			if(javaType == JavaTypesManager.BIGDECIMAL) {
        				sb.append("FormatterUtils.format_Number(String.valueOf(").append(column.getPrecision() == null? connection + "_e." + column.getLabel() : connection + "_e." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)").append("), ").append(thousandsSeparator).append(", ").append(decimalSeparator).append(")");					
					} else {
						sb.append("FormatterUtils.format_Number(String.valueOf(").append(connection).append("_e.").append(column.getLabel()).append("), ").append(thousandsSeparator).append(", ").append(decimalSeparator).append(")");
					}
				}else if (javaType == JavaTypesManager.BIGDECIMAL) {
					sb.append("String.valueOf(").append(column.getPrecision() == null? connection + "_e." + column.getLabel() : connection + "_e." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" ).append(")");
				}else{
					sb.append("String.valueOf(").append(connection).append("_e.").append(column.getLabel()).append(")");
				}
			}
			sb.append(";\n");
    		sb.append("tempLengthM").append(cid).append("=tempStringM").append(cid).append(".length();\n");
    		sb.append("if (tempLengthM").append(cid).append(" >=").append(sizes[i]).append(") {");
            if (("\'A\'").equals(schema.get("KEEP"))) {
            	sb.append("sb_").append(cid).append(".append(tempStringM").append(cid).append(");\n");
            } else if (("\'R\'").equals(schema.get("KEEP"))) {
                sb.append("sb_").append(cid).append(".append(tempStringM").append(cid).append(".substring(tempLengthM").append(cid).append("-").append(sizes[i]).append("));\n");
            } else if (("\'M\'").equals(schema.get("KEEP"))) {
                sb.append("int begin").append(cid).append("=(tempLengthM").append(cid).append("-").append(sizes[i]).append(")/2;\n");
                sb.append("sb_").append(cid).append(".append(tempStringM").append(cid).append(".substring(begin").append(cid).append(", begin").append(cid).append("+").append(sizes[i]).append("));\n");
            } else {
				sb.append("sb_").append(cid).append(".append(tempStringM").append(cid).append(".substring(0, ").append(sizes[i]).append("));\n");
            }
            sb.append("}else if(tempLengthM").append(cid).append("<").append(sizes[i]).append("){\n");
            if (("\'L\'").equals(schema.get("ALIGN"))) {
            	sb.append("sb_").append(cid).append(".append(tempStringM").append(cid).append(");\n");
                sb.append("for(int i_").append(cid).append("=0; i_").append(cid).append("< ").append(sizes[i]).append("-tempLengthM").append(cid).append("; i_").append(cid).append("++){");
                sb.append("sb_").append(cid).append(".append(").append(schema.get("PADDING_CHAR")).append(");\n");
                sb.append("}\n");
            } else if (("\'R\'").equals(schema.get("ALIGN"))) {
				sb.append("for(int i_").append(cid).append("=0; i_").append(cid).append("< ").append(sizes[i]).append("-tempLengthM").append(cid).append("; i_").append(cid).append("++){\n");
                sb.append("sb_").append(cid).append(".append(").append(schema.get("PADDING_CHAR")).append(");\n");
                sb.append("}\n");
                sb.append("sb_").append(cid).append(".append(tempStringM").append(cid).append(");\n");
			} else {
				sb.append("int temp").append(cid).append("= (").append(sizes[i]).append("-tempLengthM").append(cid).append(")/2;\n");
                sb.append("for(int i_").append(cid).append("=0;i_").append(cid).append("<temp").append(cid).append(";i_").append(cid).append("++){\n");
                sb.append("sb_").append(cid).append(".append(").append(schema.get("PADDING_CHAR")).append(");\n");
                sb.append("}\n");
                sb.append("sb_").append(cid).append(".append(tempStringM").append(cid).append(");\n");
		        sb.append("for(int i=temp").append(cid).append("+tempLengthM").append(cid).append(";i<").append(sizes[i]).append(";i++){\n");
                sb.append("sb_").append(cid).append(".append(").append(schema.get("PADDING_CHAR")).append(");\n");
                sb.append("}\n");
            }       
            sb.append("}\n");
            sb.append("//get  and format output String end\n");
            ///////////////////////////////////
		}
		sb.append("sb_").append(cid).append(".append(").append(separator).append(");\n");
		sb.append("out").append(cid).append(".write(sb_").append(cid).append(".toString());\n");
		sb.append("sb_").append(cid).append(" = new StringBuilder();\n");
			
		for(int i = 0; i < schemas.size(); i++){//generate children row code....
			Map<String,String> schema2 = schemas.get(i);
			if(schema2.get("PARENT_ROW").equals(connection)){
				generate(i);
			}
		}
		sb.append("}\n");
	}
	
	void generateCode(){
		for(int i = 0; i < connections.size(); i++){
			generate(i);
		}
	}
	
	String getCode(){
		return sb.toString();
	}
}//HSS_____inner class

if (connList.size()>0) {//HSS_____0
	List<Map<String, String>> schemas_o = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SCHEMAS__");
	
	List<Map<String, String>> schemas = new java.util.ArrayList<Map<String, String>>();
	List<String> connections = new java.util.ArrayList<String>();
    Map<String, List<IMetadataColumn>> connectionMapColumnList = new java.util.HashMap<String, List<IMetadataColumn>>();
	
	for(Map<String, String> schema_o : schemas_o){//HSS_____0_____1
		Map<String, String> schema = new java.util.HashMap<String, String>();
		schema.put("SCHEMA", TalendTextUtils.removeQuotes(schema_o.get("SCHEMA")));
		schema.put("PARENT_ROW", TalendTextUtils.removeQuotes(schema_o.get("PARENT_ROW")));
		schema.put("KEY_COLUMN", TalendTextUtils.removeQuotes(schema_o.get("KEY_COLUMN")));
		schema.put("PARENT_KEY_COLUMN", TalendTextUtils.removeQuotes(schema_o.get("PARENT_KEY_COLUMN")));
		schema.put("PATTERN", TalendTextUtils.removeQuotes(schema_o.get("PATTERN")));
		schema.put("PADDING_CHAR", TalendTextUtils.removeQuotes(schema_o.get("PADDING_CHAR")));
		schema.put("KEEP", TalendTextUtils.removeQuotes(schema_o.get("KEEP")));
		schema.put("ALIGN", TalendTextUtils.removeQuotes(schema_o.get("ALIGN")));
		if(("").equals(schema.get("PARENT_ROW"))){//put the root schema in the first place on list.
			for(int i=0;i<conns.size();i++){//HSS_____0_____1_____1
	    		IConnection connTemp = conns.get(i);
	    		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	    			IMetadataTable tempMetadataTable = connTemp.getMetadataTable();
					if(tempMetadataTable.getTableName().equals(schema.get("SCHEMA"))){
						schema.put("CONNECTION", connTemp.getName());
		    			List<IMetadataColumn> listColumns = tempMetadataTable.getListColumns();
		    			connections.add(0, connTemp.getName());
		    			connectionMapColumnList.put(connTemp.getName(), listColumns);
					}
	    		}
	    	}//HSS_____0_____1_____1
			schemas.add(0, schema);
		}else{
			for(int i=0;i<conns.size();i++){//HSS_____0_____1_____2
	    		IConnection connTemp = conns.get(i);
	    		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	    			IMetadataTable tempMetadataTable = connTemp.getMetadataTable();
					if(tempMetadataTable.getTableName().equals(schema.get("SCHEMA"))){
						schema.put("CONNECTION", connTemp.getName());
		    			List<IMetadataColumn> listColumns = tempMetadataTable.getListColumns();
		    			connections.add(connTemp.getName());
		    			connectionMapColumnList.put(connTemp.getName(), listColumns);
					}
	    		}
	    	}//HSS_____0_____1_____2
			schemas.add(schema);
		}
	}//HSS_____0_____1
	

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
	Gen gen = new Gen(schemas, connections, connectionMapColumnList);
	gen.generateCode();

    stringBuffer.append(TEXT_33);
    stringBuffer.append(gen.getCode() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
	log4jFileUtil.writeDataFinishInfo(node);
}//HSS_____0

    stringBuffer.append(TEXT_38);
    return stringBuffer.toString();
  }
}
