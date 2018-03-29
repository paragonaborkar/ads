package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TOracleOutputBulkMainJava
{
  protected static String nl;
  public static synchronized TOracleOutputBulkMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleOutputBulkMainJava result = new TOracleOutputBulkMainJava();
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
  protected final String TEXT_30 = NL + "    \t\t\tStringBuilder sb_";
  protected final String TEXT_31 = " = new StringBuilder(";
  protected final String TEXT_32 = ");" + NL + "    \t\t\t";
  protected final String TEXT_33 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_36 = NL + "    \t\t\t\t" + NL + "    \t\t\t\t";
  protected final String TEXT_37 = "\t\t" + NL + "\t\t\t\t\t\tsb_";
  protected final String TEXT_38 = ".append(OUT_FIELDS_ENCLOSURE_LEFT_";
  protected final String TEXT_39 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_40 = NL + "    \t\t\t\t\t\tsb_";
  protected final String TEXT_41 = ".append(" + NL + "\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\t\t\"<startlob>\" +" + NL + "\t\t\t\t\t";
  protected final String TEXT_43 = "    \t\t\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\t\tFormatterUtils.format_Date_Locale(";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = ", ";
  protected final String TEXT_47 = ", \"";
  protected final String TEXT_48 = "\")";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_50 = " " + NL + "                                      FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_51 = "), ";
  protected final String TEXT_52 = ", ";
  protected final String TEXT_53 = ")                                  ";
  protected final String TEXT_54 = " " + NL + "                                      FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = "), ";
  protected final String TEXT_57 = ", ";
  protected final String TEXT_58 = ")                                           ";
  protected final String TEXT_59 = " " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\t\t new String(((byte[])(";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = ")))";
  protected final String TEXT_65 = NL + "\t\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_66 = ".";
  protected final String TEXT_67 = ")";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t+\"<endlob>\"";
  protected final String TEXT_69 = "   " + NL + "\t\t\t\t\t\t);";
  protected final String TEXT_70 = "\t\t" + NL + "\t\t\t\t\t\tsb_";
  protected final String TEXT_71 = ".append(OUT_FIELDS_ENCLOSURE_RIGHT_";
  protected final String TEXT_72 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_73 = NL + "\t    \t\t\t\t} " + NL + "\t\t\t\t\t";
  protected final String TEXT_74 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_75 = ".append(OUT_DELIM_";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = NL + "    \t\t\t" + NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_78 = NL + "    \t\t\tsb_";
  protected final String TEXT_79 = ".append(OUT_DELIM_ROWSEP_";
  protected final String TEXT_80 = ");" + NL + "    \t\t\t";
  protected final String TEXT_81 = NL + "    \t\t\tsb_";
  protected final String TEXT_82 = ".append(OUT_DELIM_ROWSEP_WITH_LOB_";
  protected final String TEXT_83 = ");" + NL + "    \t\t\t";
  protected final String TEXT_84 = NL + "    \t\t\tout";
  protected final String TEXT_85 = ".write(sb_";
  protected final String TEXT_86 = ".toString());" + NL + "    \t\t\tnb_line_";
  protected final String TEXT_87 = "++;" + NL + "    \t\t\t";
  protected final String TEXT_88 = NL + "    \t\t\t\tlog.debug(\"";
  protected final String TEXT_89 = " - Writing the record \" + nb_line_";
  protected final String TEXT_90 = " + \".\");" + NL + "    \t\t\t";
  protected final String TEXT_91 = NL;

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

boolean hasLobflag=false;

if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	
    	String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    	boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    	String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    	String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
    	String locale = ElementParameterParser.getValue(node, "__DATE_LOCALE__");
    	boolean useFieldsEnclosure = ("true").equals(ElementParameterParser.getValue(node,"__USE_FIELDS_ENCLOSURE__"));
    	String stringBuilderSize = ElementParameterParser.getValue(node, "__STRING_BUILDER_SIZE__");
    	
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(stringBuilderSize);
    stringBuffer.append(TEXT_32);
    
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
    				
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String dbType = columns.get(i).getType();
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
					
    				
    stringBuffer.append(TEXT_33);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_35);
    
    				} 
    				
    stringBuffer.append(TEXT_36);
    
					if (useFieldsEnclosure && !( "BLOB".equals (dbType) || "CLOB".equals(dbType))) {
					
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    
					}
					
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
     if ("BLOB".equals (dbType) || "CLOB".equals(dbType)) {
						hasLobflag=true;
					
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
    					if(("DEFAULT").equals(locale)){
							locale = java.util.Locale.getDefault().toString();
						}else if(("CUSTOM").equals(locale)){
							locale = ElementParameterParser.getValue(node, "__CUSTOM_DATE_LOCALE__");
							locale = locale.substring(1,locale.length()-1);
						}else{
							locale = locale;
						}

    stringBuffer.append(TEXT_44);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(locale);
    stringBuffer.append(TEXT_48);
    
					}  else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) {  										
							
    stringBuffer.append(TEXT_49);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_52);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_53);
     } else { 
    stringBuffer.append(TEXT_54);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_57);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_58);
     } 
    stringBuffer.append(TEXT_59);
    
					} else if(javaType == JavaTypesManager.STRING) {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel());
    				
					} else if (javaType == JavaTypesManager.BYTE_ARRAY ) {					

    stringBuffer.append(TEXT_62);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_64);
    					
					} else  {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_67);
    				
					}

     
					if ("BLOB".equals (dbType) || "CLOB".equals(dbType)) {
    stringBuffer.append(TEXT_68);
    
					}

    stringBuffer.append(TEXT_69);
    	
					if (useFieldsEnclosure && !( "BLOB".equals (dbType) || "CLOB".equals(dbType))) {
					
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_73);
    
    				} 
					if(i != sizeColumns - 1) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    
    				}
    			}
    			
    stringBuffer.append(TEXT_77);
     if (!hasLobflag) {
    			
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    
    			}else { 
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    }
    
    		}
    	}
    }
}

    stringBuffer.append(TEXT_91);
    return stringBuffer.toString();
  }
}
