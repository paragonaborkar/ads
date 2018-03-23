package org.talend.designer.codegen.translators.databases.informix;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TInformixOutputBulkMainJava
{
  protected static String nl;
  public static synchronized TInformixOutputBulkMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TInformixOutputBulkMainJava result = new TInformixOutputBulkMainJava();
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
  protected final String TEXT_29 = NL + " ";
  protected final String TEXT_30 = "  \t" + NL + "                    \tString[] row_";
  protected final String TEXT_31 = "=new String[]{";
  protected final String TEXT_32 = "null,";
  protected final String TEXT_33 = "};" + NL + "                    \t";
  protected final String TEXT_34 = NL + "                \t\t\t\t\trow_";
  protected final String TEXT_35 = "[";
  protected final String TEXT_36 = "] = String.valueOf(" + NL + "                \t\t\t\t\t\t\ttrue == ";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = " ?\"t\":\"f\"" + NL + "                \t\t\t\t\t\t\t);" + NL + "                \t\t\t\t";
  protected final String TEXT_39 = NL + "                \t\t\t    \trow_";
  protected final String TEXT_40 = "[";
  protected final String TEXT_41 = "] = String.valueOf(";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ");" + NL + "                \t\t\t    ";
  protected final String TEXT_44 = NL + "                \t\t\t    if(";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = " != null){" + NL + "                \t\t\t        ";
  protected final String TEXT_47 = NL + "                \t\t\t            row_";
  protected final String TEXT_48 = "[";
  protected final String TEXT_49 = "] = FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_50 = "), null, ";
  protected final String TEXT_51 = ");" + NL + "                \t\t\t            ";
  protected final String TEXT_52 = NL + "                \t\t\t            row_";
  protected final String TEXT_53 = "[";
  protected final String TEXT_54 = "] = FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = "), null, ";
  protected final String TEXT_57 = ");" + NL + "                \t\t\t            ";
  protected final String TEXT_58 = NL + "                \t\t\t            row_";
  protected final String TEXT_59 = "[";
  protected final String TEXT_60 = "] = FormatterUtils.format_Date(";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = ", \"";
  protected final String TEXT_63 = "\");" + NL + "                \t\t\t            ";
  protected final String TEXT_64 = NL + "                \t\t\t            row_";
  protected final String TEXT_65 = "[";
  protected final String TEXT_66 = "] = (";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = "==true ? \"t\" : \"f\");" + NL + "                \t\t\t            ";
  protected final String TEXT_69 = NL + "                \t\t\t            row_";
  protected final String TEXT_70 = "[";
  protected final String TEXT_71 = "] = String.valueOf(";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = ");" + NL + "                \t\t\t            " + NL + "                \t\t\t            ";
  protected final String TEXT_74 = "                \t\t\t    " + NL + "                \t\t\t    }" + NL + "                \t\t ";
  protected final String TEXT_75 = NL + "            \t\t\t    csvWriter_";
  protected final String TEXT_76 = ".writeNext(row_";
  protected final String TEXT_77 = ");\t" + NL + "            \t\t\t    ";
  protected final String TEXT_78 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_79 = "%";
  protected final String TEXT_80 = " == 0) {            \t\t\t    " + NL + "            \t\t\t    \t\tcsvWriter_";
  protected final String TEXT_81 = ".flush();" + NL + "            \t\t\t    \t}\t " + NL + "            \t\t\t    ";
  protected final String TEXT_82 = NL + "            \t\t\t\tnb_line_";
  protected final String TEXT_83 = "++;";
  protected final String TEXT_84 = NL + "                                log.debug(\"";
  protected final String TEXT_85 = " - Writing the record \" + nb_line_";
  protected final String TEXT_86 = " + \".\");";
  protected final String TEXT_87 = NL + "            \t\t\t";
  protected final String TEXT_88 = NL;

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
	
    stringBuffer.append(TEXT_29);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    
    	boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
    	
    	String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
    	
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");    	
        
    	boolean setDbmoney = ("true").equals(ElementParameterParser.getValue(node,"__SET_DBMONEY__"));
    	String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
        
        String datePattern = ElementParameterParser.getValue(node,"__DATE_FORMAT__");
        datePattern = datePattern.split(",")[0];
        String datePatternCustom = ElementParameterParser.getValue(node,"__DATE_FORMAT_CUSTOM__");                
        if ("CUSTOM".equals(datePattern))
        	datePattern = datePatternCustom.substring(1,datePatternCustom.length()-1);
        
    	List< ? extends IConnection> conns = node.getIncomingConnections();
        	if(conns!=null){
        		if (conns.size()>0){
        		    IConnection conn =conns.get(0);
            		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            			List<IMetadataColumn> columns = metadata.getListColumns();
                		int sizeColumns = columns.size();
            			
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    for(int j=0;j<sizeColumns;j++){
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    
            			for (int i = 0; i < sizeColumns; i++) {
                			IMetadataColumn column = columns.get(i);
                			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                			//String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                			if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){
                			
                				if(javaType == JavaTypesManager.BOOLEAN ){
                				
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_38);
    
                				} else {
                			    
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_43);
    
                			    }
                			}else {
                			    
    stringBuffer.append(TEXT_44);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_46);
    					
                			        if(setDbmoney && javaType == JavaTypesManager.BIGDECIMAL ){
                			            
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_51);
    
                			        }else if(setDbmoney && javaType == JavaTypesManager.FLOAT ){
                			            
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_57);
    
                			        }else if(javaType == JavaTypesManager.DATE){
                			            
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( datePattern );
    stringBuffer.append(TEXT_63);
    
                			        }else if(javaType == JavaTypesManager.BOOLEAN){
                			            
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_68);
    
                			        }else{
                			            
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_73);
    
                			        }
                			        
    stringBuffer.append(TEXT_74);
     
                			}
            			} 

            			
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
     if(flushOnRow) { 
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    }
    stringBuffer.append(TEXT_87);
       		
            		}
        		
        		}
        	}
    }
}

    stringBuffer.append(TEXT_88);
    return stringBuffer.toString();
  }
}
