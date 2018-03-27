package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.Map;

public class TFileOutputMSDelimitedMainJava
{
  protected static String nl;
  public static synchronized TFileOutputMSDelimitedMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputMSDelimitedMainJava result = new TFileOutputMSDelimitedMainJava();
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
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = "Struct ";
  protected final String TEXT_31 = "_";
  protected final String TEXT_32 = " = new ";
  protected final String TEXT_33 = "Struct(); ";
  protected final String TEXT_34 = NL;
  protected final String TEXT_35 = "_";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ";";
  protected final String TEXT_40 = NL;
  protected final String TEXT_41 = "List_";
  protected final String TEXT_42 = ".add(";
  protected final String TEXT_43 = "_";
  protected final String TEXT_44 = ");" + NL + "nb_line_";
  protected final String TEXT_45 = " ++;";
  protected final String TEXT_46 = NL;
  protected final String TEXT_47 = "Map_";
  protected final String TEXT_48 = ".put(String.valueOf(";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = "), ";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = ");" + NL + "nb_line_";
  protected final String TEXT_53 = " ++;";
  protected final String TEXT_54 = NL;

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
String incomingName = (String)codeGenArgument.getIncomingName();
    
String cid = node.getUniqueName();
        
List< ? extends IConnection> conns = node.getIncomingConnections();
boolean hasDataLink = false;
if(conns!=null){
	for(int i=0;i<conns.size();i++){
		IConnection connTemp = conns.get(i);
	    if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	   		hasDataLink = true;
	   		break;
	    }
	}
}
    
if(hasDataLink){//HSS_____0
    
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
			for(int i=0;i<conns.size();i++){//HSS_____0_____1_____1
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
	    	}//HSS_____0_____1_____1
			schemas.add(schema);
		}
	}//HSS_____0_____1
    
	//get the right input connection and the previous input node and metadatas
	    
    List< ? extends IConnection> incomingConns = node.getIncomingConnections();
    	
    if (incomingName == null && incomingConns.size() > 0) {
    	   incomingName = incomingConns.get(0).getName(); 
    }

    int i = 0;
    for(; i<connections.size(); i++){
    	if(connections.get(i).equals(incomingName)){
    		break;
    	}
    }

    stringBuffer.append(TEXT_29);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_33);
    
    List<IMetadataColumn> listColumns = connectionMapColumnList.get(incomingName);
    if(!listColumns.isEmpty()){
		for(IMetadataColumn column : listColumns){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_39);
    
		}
	}
	
    if(i==0){

    stringBuffer.append(TEXT_40);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    
	}else{
		

    stringBuffer.append(TEXT_46);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(schemas.get(i).get("KEY_COLUMN") );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
	}
	
	log4jFileUtil.debugWriteData(node);
}//HSS_____0

    stringBuffer.append(TEXT_54);
    return stringBuffer.toString();
  }
}
