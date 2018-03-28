package org.talend.designer.codegen.translators.databases.amazon.redshift;

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

public class TRedshiftOutputBulkMainJava
{
  protected static String nl;
  public static synchronized TRedshiftOutputBulkMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRedshiftOutputBulkMainJava result = new TRedshiftOutputBulkMainJava();
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
  protected final String TEXT_30 = NL + "\tString[] row_";
  protected final String TEXT_31 = "=new String[]{";
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = "};" + NL + "\t";
  protected final String TEXT_34 = NL + "\t\t\t\trow_";
  protected final String TEXT_35 = "[";
  protected final String TEXT_36 = "] = String.valueOf(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ");" + NL + "\t\t\t";
  protected final String TEXT_39 = NL + "\t\t    \trow_";
  protected final String TEXT_40 = "[";
  protected final String TEXT_41 = "] = String.valueOf(";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ");" + NL + "\t\t    ";
  protected final String TEXT_44 = NL + "\t\t    if(";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = " != null){" + NL + "\t\t        ";
  protected final String TEXT_47 = NL + "\t\t            row_";
  protected final String TEXT_48 = "[";
  protected final String TEXT_49 = "] = ";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = ";" + NL + "\t\t            ";
  protected final String TEXT_52 = NL + "\t\t            row_";
  protected final String TEXT_53 = "[";
  protected final String TEXT_54 = "] = FormatterUtils.format_Date(";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = ", ";
  protected final String TEXT_57 = ");" + NL + "\t\t            ";
  protected final String TEXT_58 = NL + "\t\t            row_";
  protected final String TEXT_59 = "[";
  protected final String TEXT_60 = "] = java.nio.charset.Charset.forName(";
  protected final String TEXT_61 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = ")).toString();" + NL + "\t\t            ";
  protected final String TEXT_64 = NL + "\t\t\t\t\trow_";
  protected final String TEXT_65 = "[";
  protected final String TEXT_66 = "] = String.valueOf(";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t            row_";
  protected final String TEXT_70 = "[";
  protected final String TEXT_71 = "] = String.valueOf(";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = ");" + NL + "\t\t            ";
  protected final String TEXT_74 = "                \t\t\t    " + NL + "\t\t    }" + NL + "\t ";
  protected final String TEXT_75 = NL + "\t" + NL + "\tfor (int i_";
  protected final String TEXT_76 = " = 0; i_";
  protected final String TEXT_77 = " < row_";
  protected final String TEXT_78 = ".length; i_";
  protected final String TEXT_79 = "++) {" + NL + "\t\tString temp_";
  protected final String TEXT_80 = " = row_";
  protected final String TEXT_81 = "[i_";
  protected final String TEXT_82 = "];" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_83 = NL + "\t\tif(!";
  protected final String TEXT_84 = ".equals(temp_";
  protected final String TEXT_85 = ")) {" + NL + "\t\t\ttemp_";
  protected final String TEXT_86 = " = temp_";
  protected final String TEXT_87 = ".replace(\"\\\\\", \"\\\\\\\\\");" + NL + "\t\t\ttemp_";
  protected final String TEXT_88 = " = temp_";
  protected final String TEXT_89 = ".replace(fieldSeparator_";
  protected final String TEXT_90 = ", escapedFieldSeparator_";
  protected final String TEXT_91 = ");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_92 = NL + "\t\tif(!";
  protected final String TEXT_93 = ".equals(temp_";
  protected final String TEXT_94 = ")) {" + NL + "\t\t\ttemp_";
  protected final String TEXT_95 = " = temp_";
  protected final String TEXT_96 = ".replace(textEnclosureReplaced_";
  protected final String TEXT_97 = ", textEnclosureReplacement_";
  protected final String TEXT_98 = ");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_99 = NL + "\t\tif(i_";
  protected final String TEXT_100 = " != 0) {" + NL + "\t\t\tcsvWriter_";
  protected final String TEXT_101 = ".write(fieldSeparator_";
  protected final String TEXT_102 = ");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif(textEnclosure_";
  protected final String TEXT_103 = "!='\\0') {" + NL + "\t\t\tcsvWriter_";
  protected final String TEXT_104 = ".append(textEnclosure_";
  protected final String TEXT_105 = ");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tcsvWriter_";
  protected final String TEXT_106 = ".write(temp_";
  protected final String TEXT_107 = ");" + NL + "\t\t" + NL + "\t\tif(textEnclosure_";
  protected final String TEXT_108 = "!='\\0') {" + NL + "\t\t\tcsvWriter_";
  protected final String TEXT_109 = ".append(textEnclosure_";
  protected final String TEXT_110 = ");" + NL + "\t\t}" + NL + "\t}" + NL + "\tcsvWriter_";
  protected final String TEXT_111 = ".write(rowSeparator_";
  protected final String TEXT_112 = ");" + NL + "\tnb_line_";
  protected final String TEXT_113 = "++;";
  protected final String TEXT_114 = NL + "        log.debug(\"";
  protected final String TEXT_115 = " - Writing the record \" + nb_line_";
  protected final String TEXT_116 = " + \".\");";

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
	boolean isLog4jEnabled = "true".equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas==null)||(metadatas.isEmpty())) {
		return "";
	}
	
	IMetadataTable metadata = metadatas.get(0);
	if (metadata==null) {
		return "";
	}
	
	String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
	if(encoding!=null) {
		encoding = encoding.replace("UTF16LE","UTF-16LE").replace("UTF16BE","UTF-16BE");
	}
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns==null || conns.isEmpty()){
		return "";
	}
	
    IConnection conn =conns.get(0);
    
	if (!conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		return "";
	}
	
	String nullString = "\"\\\\N\"";
	
	List<IMetadataColumn> columns = metadata.getListColumns();
	int sizeColumns = columns.size();
	
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    for(int j=0;j<sizeColumns;j++){if(j != 0) {
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(nullString);
    }
    stringBuffer.append(TEXT_33);
    
	for (int i = 0; i < sizeColumns; i++) {
		IMetadataColumn column = columns.get(i);
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
		if(JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())){
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
    					
		        if(javaType == JavaTypesManager.STRING ){
		            
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_51);
    
		        }else if(javaType == JavaTypesManager.DATE && pattern != null){
		            
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_57);
    
		        }else if(javaType == JavaTypesManager.BYTE_ARRAY){
		            
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_63);
    
		        }else if(javaType == JavaTypesManager.BOOLEAN ){
				
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_68);
    
				}
		        else{
		            
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    
	String textEnclosure = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
	if("EMPTY".equals(textEnclosure)) {//escape by backslash, but we only escape itself and delimiter, delimiter should not be backslash.
	
    stringBuffer.append(TEXT_83);
    stringBuffer.append(nullString);
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
    
	} else {//auto escape and only need to escape text enclosure explicitly
	
    stringBuffer.append(TEXT_92);
    stringBuffer.append(nullString);
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
    
	}
	
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    }
    return stringBuffer.toString();
  }
}
