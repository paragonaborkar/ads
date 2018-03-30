package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TFileInputFullRowBeginJava
{
  protected static String nl;
  public static synchronized TFileInputFullRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputFullRowBeginJava result = new TFileInputFullRowBeginJava();
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
  protected final String TEXT_29 = NL + "\torg.talend.fileprocess.FileInputDelimited fid_";
  protected final String TEXT_30 = " = null;" + NL + "" + NL + "\t";
  protected final String TEXT_31 = NL + NL + "\ttry{//}" + NL + "\t\tfid_";
  protected final String TEXT_32 = " =new org.talend.fileprocess.FileInputDelimited(";
  protected final String TEXT_33 = ",";
  protected final String TEXT_34 = ",\"\",";
  protected final String TEXT_35 = ",";
  protected final String TEXT_36 = ",";
  protected final String TEXT_37 = ",";
  protected final String TEXT_38 = ",";
  protected final String TEXT_39 = ",";
  protected final String TEXT_40 = ",false);" + NL + "\t\twhile (fid_";
  protected final String TEXT_41 = ".nextRecord()) {//}";
  protected final String TEXT_42 = NL + "\t\t\t";
  protected final String TEXT_43 = " = null;\t\t\t";
  protected final String TEXT_44 = "\t\t\t" + NL + "\tboolean whetherReject_";
  protected final String TEXT_45 = " = false;" + NL + "\t";
  protected final String TEXT_46 = " = new ";
  protected final String TEXT_47 = "Struct();";
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = " = fid_";
  protected final String TEXT_51 = ".get(";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	

    
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
	
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if (metadatas==null || metadatas.isEmpty()) {
		return stringBuffer.toString();
	}

	IMetadataTable metadata = metadatas.get(0);
	if (metadata==null) {
		return stringBuffer.toString();
	}
	
	String filename = ElementParameterParser.getValue(node,"__FILENAME__");
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	String header = ElementParameterParser.getValue(node, "__HEADER__");
	if(("").equals(header)){
		header="0";
	}
	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
	if(("").equals(limit)){
		limit = "-1";
	}
	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
	if(("").equals(footer)){
		footer="0";
	}
	String random = "-1";
	String ran = ElementParameterParser.getValue(node, "__RANDOM__");
	if(("true").equals(ran)){
		random = ElementParameterParser.getValue(node, "__NB_RANDOM__");
		if(("").equals(random)){
			random="0";
		}
	}
	
	String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
	String removeEmptyRowFlag =  ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
		
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	log4jFileUtil.componentStartInfo(node);

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(removeEmptyRowFlag );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(random );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
	List<? extends IConnection> conns = node.getOutgoingSortedConnections();
	
	if (conns==null || conns.isEmpty()) {
		return stringBuffer.toString();
	}
	
	for (int i=0;i<conns.size();i++) {
		IConnection connTemp = conns.get(i);
		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_43);
    
		}
	}
	
	IConnection conn = conns.get(0);
	String firstConnName = conn.getName();
	if (!conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		return stringBuffer.toString();
	}

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    
	List<IMetadataColumn> listColumns = metadata.getListColumns();
	for (int valueN=0; valueN<listColumns.size(); valueN++) {
		IMetadataColumn column = listColumns.get(valueN);

    stringBuffer.append(TEXT_48);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_52);
    
	}

    stringBuffer.append(TEXT_53);
    return stringBuffer.toString();
  }
}
