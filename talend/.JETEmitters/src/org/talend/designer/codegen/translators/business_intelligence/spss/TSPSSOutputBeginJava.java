package org.talend.designer.codegen.translators.business_intelligence.spss;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TSPSSOutputBeginJava
{
  protected static String nl;
  public static synchronized TSPSSOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSPSSOutputBeginJava result = new TSPSSOutputBeginJava();
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
  protected final String TEXT_29 = NL + "\tint nb_line_";
  protected final String TEXT_30 = " = 0;" + NL + "\torg.talend.jspss.spss ";
  protected final String TEXT_31 = "_sp = new org.talend.jspss.spss();";
  protected final String TEXT_32 = NL + "\torg.talend.jspss.spssfile ";
  protected final String TEXT_33 = "_sf = ";
  protected final String TEXT_34 = "_sp.openFile(";
  protected final String TEXT_35 = ", org.talend.jspss.spssfile.SPSS_WRITE);" + NL + "\torg.talend.jspss.spssvariables ";
  protected final String TEXT_36 = "_spVars = ";
  protected final String TEXT_37 = "_sf.getVariables();";
  protected final String TEXT_38 = NL + "\t\t\t\torg.talend.jspss.spssvariable spVar_";
  protected final String TEXT_39 = " = new org.talend.jspss.spssvariable(\"";
  protected final String TEXT_40 = "\");";
  protected final String TEXT_41 = NL + "\t\t\t\t\tspVar_";
  protected final String TEXT_42 = ".setType(org.talend.jspss.spssvariables.SPSS_STRING);" + NL + " \t\t\t\t\tspVar_";
  protected final String TEXT_43 = ".setFormat(1);" + NL + "\t\t\t\t\tspVar_";
  protected final String TEXT_44 = ".setWidth(";
  protected final String TEXT_45 = ");" + NL + "\t\t\t\t\tspVar_";
  protected final String TEXT_46 = ".setDecimals(";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "\t\t\t\t\tspVar_";
  protected final String TEXT_49 = ".setType(org.talend.jspss.spssvariables.SPSS_NUMERIC);" + NL + " \t\t\t\t\tspVar_";
  protected final String TEXT_50 = ".setFormat(22);" + NL + "\t\t\t\t\tspVar_";
  protected final String TEXT_51 = ".setDecimals(17);" + NL + " \t\t\t\t\tspVar_";
  protected final String TEXT_52 = ".setPrecision(0);" + NL;
  protected final String TEXT_53 = NL + "\t\t\t\t\tspVar_";
  protected final String TEXT_54 = ".setWidth(";
  protected final String TEXT_55 = ");" + NL + " \t\t\t\t\tspVar_";
  protected final String TEXT_56 = ".setFormat(5);" + NL + "\t\t\t\t\tspVar_";
  protected final String TEXT_57 = ".setDecimals(";
  protected final String TEXT_58 = "-";
  protected final String TEXT_59 = ");" + NL + " \t\t\t\t\tspVar_";
  protected final String TEXT_60 = ".setPrecision(";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL + "\t\t\t\t\tspVar_";
  protected final String TEXT_63 = ".setLabel(\"";
  protected final String TEXT_64 = "\");";
  protected final String TEXT_65 = NL + "\t\t\t\t";
  protected final String TEXT_66 = "_spVars.addVariable(spVar_";
  protected final String TEXT_67 = ");";
  protected final String TEXT_68 = NL + "\t\t\t";
  protected final String TEXT_69 = "_spVars.writeVariables(); ";
  protected final String TEXT_70 = NL;
  protected final String TEXT_71 = NL + "\torg.talend.jspss.spssfile ";
  protected final String TEXT_72 = "_sf = ";
  protected final String TEXT_73 = "_sp.openFile(";
  protected final String TEXT_74 = ", org.talend.jspss.spssfile.SPSS_APPEND);" + NL + "\torg.talend.jspss.spssvariables ";
  protected final String TEXT_75 = "_spVars = ";
  protected final String TEXT_76 = "_sf.getVariables();";
  protected final String TEXT_77 = NL + "\t//";
  protected final String TEXT_78 = NL + "\t//";
  protected final String TEXT_79 = NL + "\torg.talend.jspss.spssrecord ";
  protected final String TEXT_80 = "_spR = new org.talend.jspss.spssrecord(";
  protected final String TEXT_81 = "_spVars, false);";
  protected final String TEXT_82 = NL;
  protected final String TEXT_83 = NL;

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
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String cid = node.getUniqueName();
String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String writeType = ElementParameterParser.getValue(node, "__WRITE_TYPE__");

String inputConnName = null;
List< ? extends IConnection> conns = node.getIncomingConnections();
if (conns!=null) {
	if (conns.size()>0) {
		for (int i=0;i<conns.size();i++) {
			IConnection connTemp = conns.get(i);
			if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				inputConnName = connTemp.getName();
				break;
			}
		}
	}
}
if (inputConnName != null){

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
	if(("write").equals(writeType)){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null && conns.size()>0) {
			List<IMetadataColumn> columns = metadata.getListColumns();
			int sizeColumns = columns.size();
	    		for (int i = 0; i < sizeColumns; i++) {
	    			IMetadataColumn column = columns.get(i);
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

    stringBuffer.append(TEXT_38);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_40);
    				
				if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_47);
     
				}else if(javaType == JavaTypesManager.DATE){

    stringBuffer.append(TEXT_48);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_52);
     
				}else if(javaType == JavaTypesManager.BOOLEAN){
				}else if(javaType == JavaTypesManager.DOUBLE || javaType == JavaTypesManager.INTEGER || javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.BIGDECIMAL || javaType == JavaTypesManager.FLOAT){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(column.getLength());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getPrecision());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getPrecision() );
    stringBuffer.append(TEXT_61);
    	
				}
				if(column.getComment()!=null || column.getComment().length()>0){

    stringBuffer.append(TEXT_62);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getComment());
    stringBuffer.append(TEXT_64);
    
				}

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_67);
    
			}

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
		}
	}

    stringBuffer.append(TEXT_70);
    
	}else{

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
	}

    stringBuffer.append(TEXT_77);
    stringBuffer.append(inputConnName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(writeType);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
}

    stringBuffer.append(TEXT_82);
    stringBuffer.append(TEXT_83);
    return stringBuffer.toString();
  }
}
