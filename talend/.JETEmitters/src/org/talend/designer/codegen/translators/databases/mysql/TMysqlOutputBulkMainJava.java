package org.talend.designer.codegen.translators.databases.mysql;

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

public class TMysqlOutputBulkMainJava
{
  protected static String nl;
  public static synchronized TMysqlOutputBulkMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlOutputBulkMainJava result = new TMysqlOutputBulkMainJava();
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
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = "\"\\\\N\"";
  protected final String TEXT_34 = "};\t\t//empty value must be NULL('\\N' in bulk file)" + NL + "                    \t";
  protected final String TEXT_35 = NL + "                \t\t\t\t\trow_";
  protected final String TEXT_36 = "[";
  protected final String TEXT_37 = "] = String.valueOf(" + NL + "                \t\t\t\t\t\t\ttrue == ";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = " ?\"1\":\"0\"" + NL + "                \t\t\t\t\t\t\t);" + NL + "                \t\t\t\t";
  protected final String TEXT_40 = NL + "                \t\t\t    \trow_";
  protected final String TEXT_41 = "[";
  protected final String TEXT_42 = "] = String.valueOf(";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = ");" + NL + "                \t\t\t    ";
  protected final String TEXT_45 = NL + "                \t\t\t    if(";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = " != null){" + NL + "                \t\t\t        ";
  protected final String TEXT_48 = NL + "                \t\t\t            row_";
  protected final String TEXT_49 = "[";
  protected final String TEXT_50 = "] = ";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = ";" + NL + "                \t\t\t            ";
  protected final String TEXT_53 = NL + "                \t\t\t            row_";
  protected final String TEXT_54 = "[";
  protected final String TEXT_55 = "] = FormatterUtils.format_Date(";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = ", ";
  protected final String TEXT_58 = ");" + NL + "                \t\t\t            ";
  protected final String TEXT_59 = NL + "                \t\t\t            row_";
  protected final String TEXT_60 = "[";
  protected final String TEXT_61 = "] = java.nio.charset.Charset.forName(";
  protected final String TEXT_62 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = ")).toString();" + NL + "                \t\t\t            ";
  protected final String TEXT_65 = NL + "                \t\t\t\t\t\trow_";
  protected final String TEXT_66 = "[";
  protected final String TEXT_67 = "] = String.valueOf(" + NL + "                \t\t\t\t\t\t\ttrue == ";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = " ?\"1\":\"0\"" + NL + "                \t\t\t\t\t\t\t);" + NL + "                \t\t\t\t\t";
  protected final String TEXT_70 = NL + "                \t\t\t            row_";
  protected final String TEXT_71 = "[";
  protected final String TEXT_72 = "] = String.valueOf(";
  protected final String TEXT_73 = ".";
  protected final String TEXT_74 = ");" + NL + "                \t\t\t            ";
  protected final String TEXT_75 = "                \t\t\t    " + NL + "                \t\t\t    }" + NL + "                \t\t ";
  protected final String TEXT_76 = NL + "\t            \t\t\t";
  protected final String TEXT_77 = NL + "\t            \t\t\t\tdiskSpace_";
  protected final String TEXT_78 = " = file_";
  protected final String TEXT_79 = ".getFreeSpace();" + NL + "\t            \t\t\t\tif(diskSpace_";
  protected final String TEXT_80 = " <= 0){" + NL + "\t\t\t\t\t\t\t\t\tthrow new java.io.IOException(\"The disk space is not enough,please check it!\");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t            \t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t\t\t\tfor (int i_";
  protected final String TEXT_82 = " = 0; i_";
  protected final String TEXT_83 = " < row_";
  protected final String TEXT_84 = ".length; i_";
  protected final String TEXT_85 = "++) {" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tString temp_";
  protected final String TEXT_86 = " = row_";
  protected final String TEXT_87 = "[i_";
  protected final String TEXT_88 = "];" + NL + "\t\t\t\t\t\t\t\tif(!\"\\\\N\".equals(temp_";
  protected final String TEXT_89 = ")) {" + NL + "\t\t\t\t\t\t\t\t\tif (escape_mode_";
  protected final String TEXT_90 = " == 0 ) { // double quotes" + NL + "\t\t\t\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_91 = " = temp_";
  protected final String TEXT_92 = ".replace(\"\" + textEnclosure_";
  protected final String TEXT_93 = ", \"\" + textEnclosure_";
  protected final String TEXT_94 = " + textEnclosure_";
  protected final String TEXT_95 = ");" + NL + "\t\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_96 = " = temp_";
  protected final String TEXT_97 = ".replace(\"\\\\\", \"\\\\\\\\\");" + NL + "\t\t\t\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_98 = " = temp_";
  protected final String TEXT_99 = ".replace(\"\" + textEnclosure_";
  protected final String TEXT_100 = ", \"\\\\\" + textEnclosure_";
  protected final String TEXT_101 = ");" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\tif(i_";
  protected final String TEXT_102 = " != 0) {" + NL + "\t\t\t\t\t\t\t\t\tcsvWriter_";
  protected final String TEXT_103 = ".write(fieldSeparator_";
  protected final String TEXT_104 = ");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\tcsvWriter_";
  protected final String TEXT_105 = ".append(textEnclosure_";
  protected final String TEXT_106 = ");" + NL + "\t\t\t\t\t\t\t\tcsvWriter_";
  protected final String TEXT_107 = ".write(temp_";
  protected final String TEXT_108 = ");" + NL + "\t\t\t\t\t\t\t\tcsvWriter_";
  protected final String TEXT_109 = ".append(textEnclosure_";
  protected final String TEXT_110 = ");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tcsvWriter_";
  protected final String TEXT_111 = ".write(rowSeparator_";
  protected final String TEXT_112 = ");" + NL + "\t            \t\t\t";
  protected final String TEXT_113 = NL + "        \t\t\t    \t\tcsvWriter_";
  protected final String TEXT_114 = ".flush();" + NL + "\t            \t\t\t";
  protected final String TEXT_115 = NL + "            \t\t\t    ";
  protected final String TEXT_116 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_117 = "%";
  protected final String TEXT_118 = " == 0) {            \t\t\t    " + NL + "            \t\t\t    \t\tcsvWriter_";
  protected final String TEXT_119 = ".flush();" + NL + "            \t\t\t    \t}\t " + NL + "            \t\t\t    ";
  protected final String TEXT_120 = NL + "            \t\t\t\tnb_line_";
  protected final String TEXT_121 = "++;";
  protected final String TEXT_122 = NL + "                                log.debug(\"";
  protected final String TEXT_123 = " - Writing the record \" + nb_line_";
  protected final String TEXT_124 = " + \".\");";
  protected final String TEXT_125 = NL + "            \t\t\t";
  protected final String TEXT_126 = NL;

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
    
        boolean checkDiskSpace = ("true").equals(ElementParameterParser.getValue(node,"__CHECK_DISK_SPACE__"));
    	boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
    	String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
    	
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");    	
    	
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
    for(int j=0;j<sizeColumns;j++){if(j != 0) {
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    
            			for (int i = 0; i < sizeColumns; i++) {
                			IMetadataColumn column = columns.get(i);
                			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                			if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){
                			
                				if(javaType == JavaTypesManager.BOOLEAN ){
                				
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_39);
    
                				} else {
                			    
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_44);
    
                			    }
                			}else {
                			    
    stringBuffer.append(TEXT_45);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_47);
    					
                			        if(javaType == JavaTypesManager.STRING ){
                			            
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_52);
    
                			        }else if(javaType == JavaTypesManager.DATE && pattern != null){
                			            
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_58);
    
                			        }else if(javaType == JavaTypesManager.BYTE_ARRAY){
                			            
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_64);
    
                			        }else if(javaType == JavaTypesManager.BOOLEAN ){
                					
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_69);
    
                					}	             			        
                			        else{
                			            
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_74);
    
                			        }
                			        
    stringBuffer.append(TEXT_75);
     
                			}
            			} 

            			
    stringBuffer.append(TEXT_76);
    if(checkDiskSpace){
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    if(checkDiskSpace){
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
     if(flushOnRow) { 
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    }
    stringBuffer.append(TEXT_125);
       		
            		}
        		
        		}
        	}
    }
}

    stringBuffer.append(TEXT_126);
    return stringBuffer.toString();
  }
}
