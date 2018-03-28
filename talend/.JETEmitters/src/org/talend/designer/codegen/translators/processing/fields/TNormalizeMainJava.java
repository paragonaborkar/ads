package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;

public class TNormalizeMainJava
{
  protected static String nl;
  public static synchronized TNormalizeMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNormalizeMainJava result = new TNormalizeMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "            normalizeRecord_";
  protected final String TEXT_3 = " = new String[1];" + NL + "            if(";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = " != null) {" + NL + "\t\t\t\tif(\"\".equals(";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ")){" + NL + "\t\t        \tnormalizeRecord_";
  protected final String TEXT_8 = "[0] = \"\";" + NL + "\t\t        }else{" + NL + "\t                ";
  protected final String TEXT_9 = NL + "\t                    com.talend.csv.CSVReader reader_";
  protected final String TEXT_10 = " = new com.talend.csv.CSVReader(new java.io.StringReader(";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = "), '";
  protected final String TEXT_13 = "');" + NL + "\t                    reader_";
  protected final String TEXT_14 = ".setTrimWhitespace(false);" + NL + "\t                    ";
  protected final String TEXT_15 = NL + "\t                    \treader_";
  protected final String TEXT_16 = ".setEscapeChar('\\\\');" + NL + "\t                   \t";
  protected final String TEXT_17 = NL + "\t                 \t\treader_";
  protected final String TEXT_18 = ".setEscapeChar('";
  protected final String TEXT_19 = "');" + NL + "\t                   \t";
  protected final String TEXT_20 = NL + "\t                    reader_";
  protected final String TEXT_21 = ".setQuoteChar('";
  protected final String TEXT_22 = "');" + NL + "\t                    if (reader_";
  protected final String TEXT_23 = ".readNext()) {" + NL + "\t                        normalizeRecord_";
  protected final String TEXT_24 = " = reader_";
  protected final String TEXT_25 = ".getValues();" + NL + "\t                    }" + NL + "\t                ";
  protected final String TEXT_26 = NL + "\t                    \tnormalizeRecord_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ".split(";
  protected final String TEXT_30 = ");" + NL + "\t                    ";
  protected final String TEXT_31 = NL + "\t                \t\tnormalizeRecord_";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ".split(";
  protected final String TEXT_35 = ",-1);" + NL + "\t                    ";
  protected final String TEXT_36 = "    " + NL + "                }           " + NL + "            }";
  protected final String TEXT_37 = NL + "\t\t  \t\t\tint lastNoEmptyIndex_";
  protected final String TEXT_38 = "=0;" + NL + "\t\t            for(int i_";
  protected final String TEXT_39 = "=normalizeRecord_";
  protected final String TEXT_40 = ".length;i_";
  protected final String TEXT_41 = " > 0;i_";
  protected final String TEXT_42 = "--){" + NL + "\t\t            \tif(!\"\".equals(normalizeRecord_";
  protected final String TEXT_43 = "[i_";
  protected final String TEXT_44 = " - 1])){" + NL + "\t\t            \t\tlastNoEmptyIndex_";
  protected final String TEXT_45 = "=i_";
  protected final String TEXT_46 = ";" + NL + "\t\t            \t\tbreak;" + NL + "\t\t            \t}" + NL + "\t\t            }" + NL + "            \t";
  protected final String TEXT_47 = NL + "             \t\tint lastNoEmptyIndex_";
  protected final String TEXT_48 = "=normalizeRecord_";
  protected final String TEXT_49 = ".length;" + NL + "\t             \t";
  protected final String TEXT_50 = NL + "\t             \t\tif(lastNoEmptyIndex_";
  protected final String TEXT_51 = " == 1 && \"\".equals(normalizeRecord_";
  protected final String TEXT_52 = "[0])){" + NL + "\t             \t\t\tlastNoEmptyIndex_";
  protected final String TEXT_53 = " = 0;" + NL + "\t             \t\t}" + NL + "\t             \t";
  protected final String TEXT_54 = NL + "            \t";
  protected final String TEXT_55 = NL + "            \tfor(int i_";
  protected final String TEXT_56 = " = 0 ; i_";
  protected final String TEXT_57 = " < lastNoEmptyIndex_";
  protected final String TEXT_58 = " ; i_";
  protected final String TEXT_59 = "++) {" + NL + "\t\t  \t\t\t";
  protected final String TEXT_60 = NL + "\t\t            \tif(normalizeRecord_";
  protected final String TEXT_61 = "[i_";
  protected final String TEXT_62 = "]!=null){" + NL + "\t\t            \t\tnormalizeRecord_";
  protected final String TEXT_63 = "[i_";
  protected final String TEXT_64 = "]=normalizeRecord_";
  protected final String TEXT_65 = "[i_";
  protected final String TEXT_66 = "].trim();" + NL + "\t\t            \t}" + NL + "\t\t            ";
  protected final String TEXT_67 = NL + "\t                currentRecord_";
  protected final String TEXT_68 = " = new StringBuilder();" + NL + "\t                nb_line_";
  protected final String TEXT_69 = "++;               " + NL + "\t                ";
  protected final String TEXT_70 = NL + "\t                                \ttmp_";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = " == null ? null : String.valueOf(";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = ".getTime());" + NL + "\t                                ";
  protected final String TEXT_76 = NL + "\t\t                                    tmp_";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = " == null ? null : ";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = ".toString();" + NL + "\t\t                                    ";
  protected final String TEXT_82 = NL + "\t\t                                    tmp_";
  protected final String TEXT_83 = " = String.valueOf(";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = ");" + NL + "\t\t                                    ";
  protected final String TEXT_86 = NL + "\t                                \ttmp_";
  protected final String TEXT_87 = " = ";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = " == null ? null : new String(";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = ");" + NL + "\t                                ";
  protected final String TEXT_92 = NL + "\t                                \ttmp_";
  protected final String TEXT_93 = " = ";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = " == null ? null : String.valueOf(";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = ");" + NL + "\t                                ";
  protected final String TEXT_98 = NL + "\t                                \ttmp_";
  protected final String TEXT_99 = " = String.valueOf(";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = ");" + NL + "\t                                ";
  protected final String TEXT_102 = NL + "\t\t                            if(tmp_";
  protected final String TEXT_103 = " != null){" + NL + "\t\t                                currentRecord_";
  protected final String TEXT_104 = ".append(tmp_";
  protected final String TEXT_105 = " + tmp_";
  protected final String TEXT_106 = ".length());" + NL + "\t\t                            }" + NL + "\t                            ";
  protected final String TEXT_107 = NL + "\t\t                            if(normalizeRecord_";
  protected final String TEXT_108 = "[i_";
  protected final String TEXT_109 = "] != null) {" + NL + "\t\t                                currentRecord_";
  protected final String TEXT_110 = ".append(normalizeRecord_";
  protected final String TEXT_111 = "[i_";
  protected final String TEXT_112 = "] + normalizeRecord_";
  protected final String TEXT_113 = "[i_";
  protected final String TEXT_114 = "].length());" + NL + "\t\t                            }" + NL + "\t                            ";
  protected final String TEXT_115 = NL + "\t\t                    if(!recordSet_";
  protected final String TEXT_116 = ".contains(currentRecord_";
  protected final String TEXT_117 = ".toString())) {" + NL + "\t\t                        recordSet_";
  protected final String TEXT_118 = ".add(currentRecord_";
  protected final String TEXT_119 = ".toString());" + NL + "\t\t                    } else {" + NL + "\t\t                        continue;" + NL + "\t\t                    }                    " + NL + "\t\t                ";
  protected final String TEXT_120 = NL + "\t                        \t";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = " = normalizeRecord_";
  protected final String TEXT_123 = "[i_";
  protected final String TEXT_124 = "];" + NL + "\t\t                    ";
  protected final String TEXT_125 = NL + "\t                        \t";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = " = ";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = ";" + NL + "\t                        ";
  protected final String TEXT_130 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);    
    if (metadata!=null) {//2
       
        String cid = node.getUniqueName();
        String normalizeColumn = ElementParameterParser.getValue(node, "__NORMALIZE_COLUMN__");
        String deduplicate = ElementParameterParser.getValue(node, "__DEDUPLICATE__");
        boolean useCSV = ("true").equals(ElementParameterParser.getValue(node, "__CSV_OPTION__"));
        String escapeMode = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
        
        String delim = ElementParameterParser.getValue(node, "__ITEMSEPARATOR__");
        
        boolean isDiscardTrailingEmptyStr=("true").equals(ElementParameterParser.getValue(node, "__DISCARD_TRAILING_EMPTY_STR__"));
        boolean isTrim=("true").equals(ElementParameterParser.getValue(node, "__TRIM__"));
        if(useCSV){
        	delim = delim.substring(1,delim.length()-1);
        	if(("'").equals(delim)){
        		delim = "\\'";
        	}
        }
        
    	String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
    	String textEnclosure = textEnclosure1.substring(1,textEnclosure1.length()-1);
    	if ("".equals(textEnclosure)) textEnclosure = "\0";
    	if(("'").equals(textEnclosure)){
    		textEnclosure = "\\'";
    	}        
        
        String incomingConnName = null;
        String outgoingConnName = null;

        List< ? extends IConnection> inConns = node.getIncomingConnections();
        if (inConns != null && !inConns.isEmpty()) {
            IConnection inConn = inConns.get(0);
            incomingConnName = inConn.getName();
        }
        
        List< ? extends IConnection> outConns = NodeUtil.getOutgoingConnections(node, IConnectionCategory.DATA);
        if (outConns != null && !outConns.isEmpty()) {
            IConnection outConn = outConns.get(0);
            outgoingConnName = outConn.getName();
        }
        List< ? extends IConnection> outIterate = NodeUtil.getOutgoingConnections(node, IConnectionCategory.USE_ITERATE);
        List<IMetadataColumn> metadataColumns = metadata.getListColumns();
        if(incomingConnName != null && 
            metadataColumns != null && !metadataColumns.isEmpty()) {//3
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(normalizeColumn);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(normalizeColumn);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    if(useCSV){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(normalizeColumn);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
	                    if("ESCAPE_MODE_BACKSLASH".equals(escapeMode)) {
	                    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    } else {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_19);
    } 
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
     
	                } else { 
	            		if(isDiscardTrailingEmptyStr){
	                    
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(normalizeColumn);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_30);
    
	            		}else{
	                    
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(normalizeColumn);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_35);
    
	            		}
	            	}
	                
    stringBuffer.append(TEXT_36);
    
            if(!outIterate.isEmpty()||outgoingConnName != null){
  				if(useCSV && isDiscardTrailingEmptyStr){
  				
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
            	}else{
           	 	
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    if(isDiscardTrailingEmptyStr){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    
       			}
            	
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    if(isTrim){
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
	                if(outgoingConnName != null ){
		                if(("true").equals(deduplicate)) {//check deduplicate start
		                    for(int i = 0 ; i < metadataColumns.size() ; i++) {
		                        IMetadataColumn metadataColumn = (IMetadataColumn)metadataColumns.get(i);
		                        JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
		                        String typeName = JavaTypesManager.getTypeToGenerate(metadataColumn.getTalendType(), metadataColumn.isNullable());
		                        if(!metadataColumn.getLabel().equals(normalizeColumn)) {
		                            if(javaType == JavaTypesManager.DATE) {
	                                
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_75);
    
	                            	} else if(javaType == JavaTypesManager.BYTE || 
	                                    javaType == JavaTypesManager.SHORT || 
	                                    javaType == JavaTypesManager.FLOAT ||
	                                    javaType == JavaTypesManager.DOUBLE ||
	                                    javaType == JavaTypesManager.LONG ||
	                                    javaType == JavaTypesManager.INTEGER || 
	                                    javaType == JavaTypesManager.BOOLEAN) {
		                                if(("Byte").equals(typeName) || 
		                                        ("Short").equals(typeName) || 
		                                        ("Float").equals(typeName) || 
		                                        ("Double").equals(typeName) || 
		                                        ("Long").equals(typeName) || 
		                                        ("Integer").equals(typeName) || 
		                                        ("Boolean").equals(typeName)) {                    
		                                    
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_81);
    
		                                } else {
		                                    
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_85);
    
		                                }
	                            	} else if(javaType == JavaTypesManager.BYTE_ARRAY) {
	                                
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_91);
    
	                            	} else if(javaType == JavaTypesManager.STRING){
	                                
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_97);
    
	                            	} else {
	                                
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_101);
    
	                            	}
	                            	
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
	                       	 	} else {
	                            
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
		                        }
		                    }
		                    
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
		                }//check deduplicate end                
		                for(IMetadataColumn metadataColumn : metadataColumns) {
		                    if(metadataColumn.getLabel().equals(normalizeColumn)) {
	                        
    stringBuffer.append(TEXT_120);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
		                    } else {
	                        
    stringBuffer.append(TEXT_125);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_129);
    
	                    	}
	                	}
	                }
        	}
        }
        //3
    }
    //2    
}
//1

    stringBuffer.append(TEXT_130);
    return stringBuffer.toString();
  }
}
