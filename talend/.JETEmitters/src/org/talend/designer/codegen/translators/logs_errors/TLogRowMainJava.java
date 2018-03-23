package org.talend.designer.codegen.translators.logs_errors;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TLogRowMainJava
{
  protected static String nl;
  public static synchronized TLogRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLogRowMainJava result = new TLogRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "///////////////////////\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + NL + "\t\t\t\tstrBuffer_";
  protected final String TEXT_4 = " = new StringBuilder();";
  protected final String TEXT_5 = NL + "\t\t\t\tstrBuffer_";
  protected final String TEXT_6 = ".append(\"[";
  protected final String TEXT_7 = "] \");";
  protected final String TEXT_8 = NL + NL;
  protected final String TEXT_9 = NL + "\t\t\t\t\t\tlogRowUtil_";
  protected final String TEXT_10 = ".putBasicVerticalValue_";
  protected final String TEXT_11 = "(";
  protected final String TEXT_12 = ",strBuffer_";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t\t\t\tjava.util.Formatter formatter_";
  protected final String TEXT_15 = "_";
  protected final String TEXT_16 = " = new java.util.Formatter(new StringBuilder());";
  protected final String TEXT_17 = NL + NL;
  protected final String TEXT_18 = NL + "\t\t\t\tstrBuffer_";
  protected final String TEXT_19 = ".append(\"";
  protected final String TEXT_20 = ": \");";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = "   \t\t\t\t" + NL + "\t    \t\tif(";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = " != null) { //";
  protected final String TEXT_25 = "              " + NL + "                    ";
  protected final String TEXT_26 = NL + "\t\t\t\tstrBuffer_";
  protected final String TEXT_27 = ".append(formatter_";
  protected final String TEXT_28 = "_";
  protected final String TEXT_29 = ".format(\"%1$";
  protected final String TEXT_30 = "s\", ";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = ")";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = ")).toString()";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_39 = ".toPlainString()";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\t\t\tFormatterUtils.formatUnwithE(";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ")";
  protected final String TEXT_43 = NL + "\t\t\t\t                String.valueOf(";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = ")\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t\t).toString());" + NL + "\t\t\t\t";
  protected final String TEXT_47 = "\t\t\t\t\t\t\t" + NL + "       " + NL + "\t\t\t\tstrBuffer_";
  protected final String TEXT_48 = ".append(";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = ", ";
  protected final String TEXT_52 = ")";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = ")).toString()";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_57 = ".toPlainString()";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\t\t\tFormatterUtils.formatUnwithE(";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = ")";
  protected final String TEXT_61 = NL + "\t\t\t\t                String.valueOf(";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = ")\t\t\t";
  protected final String TEXT_64 = "\t\t\t\t" + NL + "\t\t\t\t);";
  protected final String TEXT_65 = NL + NL + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_66 = NL + "\t    \t\t} //";
  protected final String TEXT_67 = "  \t\t\t" + NL;
  protected final String TEXT_68 = NL + "    \t\t\tstrBuffer_";
  protected final String TEXT_69 = ".append(";
  protected final String TEXT_70 = ");" + NL + "    \t\t\t";
  protected final String TEXT_71 = " " + NL + "" + NL + "                    if (globalMap.get(\"tLogRow_CONSOLE\")!=null)" + NL + "                    {" + NL + "                    \tconsoleOut_";
  protected final String TEXT_72 = " = (java.io.PrintStream) globalMap.get(\"tLogRow_CONSOLE\");" + NL + "                    }" + NL + "                    else" + NL + "                    {" + NL + "                    \tconsoleOut_";
  protected final String TEXT_73 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "                    \tglobalMap.put(\"tLogRow_CONSOLE\",consoleOut_";
  protected final String TEXT_74 = ");" + NL + "                    }";
  protected final String TEXT_75 = NL + "                    \tlog.info(\"";
  protected final String TEXT_76 = " - Content of row \"+(nb_line_";
  protected final String TEXT_77 = "+1)+\": \" + strBuffer_";
  protected final String TEXT_78 = ".toString());";
  protected final String TEXT_79 = NL + "                    consoleOut_";
  protected final String TEXT_80 = ".println(strBuffer_";
  protected final String TEXT_81 = ".toString());" + NL + "                    consoleOut_";
  protected final String TEXT_82 = ".flush();" + NL + "                    nb_line_";
  protected final String TEXT_83 = "++;";
  protected final String TEXT_84 = NL + "\t\t\t\t" + NL + "\t\t\t\tString[] row_";
  protected final String TEXT_85 = " = new String[";
  protected final String TEXT_86 = "];" + NL;
  protected final String TEXT_87 = NL + "\t\t\t\t\t\tlogRowUtil_";
  protected final String TEXT_88 = ".putTableVerticalValue_";
  protected final String TEXT_89 = "(";
  protected final String TEXT_90 = ",row_";
  protected final String TEXT_91 = ");";
  protected final String TEXT_92 = "   \t\t\t\t" + NL + "\t    \t\tif(";
  protected final String TEXT_93 = ".";
  protected final String TEXT_94 = " != null) { //";
  protected final String TEXT_95 = "              " + NL + "                 row_";
  protected final String TEXT_96 = "[";
  protected final String TEXT_97 = "]=    \t\t\t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = ", ";
  protected final String TEXT_101 = ")";
  protected final String TEXT_102 = NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = ")).toString()";
  protected final String TEXT_105 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_106 = ".toPlainString()";
  protected final String TEXT_107 = NL + "\t\t\t\t\t\t\t\tFormatterUtils.formatUnwithE(";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = ")";
  protected final String TEXT_110 = "    " + NL + "\t\t\t\t                String.valueOf(";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = ")\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\t\t          ;\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_114 = NL + "\t    \t\t} //";
  protected final String TEXT_115 = "\t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_116 = " " + NL + "" + NL + "\t\t\t\tutil_";
  protected final String TEXT_117 = ".addRow(row_";
  protected final String TEXT_118 = ");\t" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_119 = "++;";
  protected final String TEXT_120 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_121 = "++;" + NL + "                consoleOut_";
  protected final String TEXT_122 = ".println(util_";
  protected final String TEXT_123 = ".print(row_";
  protected final String TEXT_124 = ",nb_line_";
  protected final String TEXT_125 = "));" + NL + "                consoleOut_";
  protected final String TEXT_126 = ".flush();";
  protected final String TEXT_127 = NL + "                \tlog.info(\"";
  protected final String TEXT_128 = " - Content of row \"+nb_line_";
  protected final String TEXT_129 = "+\": \" + TalendString.unionString(\"|\",row_";
  protected final String TEXT_130 = "));";
  protected final String TEXT_131 = NL + "//////" + NL + "" + NL + "//////                    " + NL + "                    " + NL + "///////////////////////    \t\t\t";
  protected final String TEXT_132 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2
    
        String cid = node.getUniqueName();        

		boolean tablePrint = ("true").equals(ElementParameterParser.getValue(node,"__TABLE_PRINT__"));
		boolean vertical = ("true").equals(ElementParameterParser.getValue(node,"__VERTICAL__"));
    	boolean basic = !(tablePrint||vertical);

        String printUniqueName = ElementParameterParser.getValue(node,"__PRINT_UNIQUE_NAME__");
        String printColumnNames = ElementParameterParser.getValue(node,"__PRINT_COLNAMES__");
        String useFixedLength = ElementParameterParser.getValue(node,"__USE_FIXED_LENGTH__");
        List<Map<String, String>> lengths = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__LENGTHS__");
        boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
        boolean isLogContent = ("true").equals(ElementParameterParser.getValue(node,"__PRINT_CONTENT_WITH_LOG4J__"));

    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {//3
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4

    stringBuffer.append(TEXT_1);
      
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			int schemaOptNum=100;
				String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
				if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
					schemaOptNum  = Integer.parseInt(schemaOptNumStr);
				}
    			boolean isOptimizeCode = false;
				if(schemaOptNum < sizeColumns){
					isOptimizeCode = true;
				}

    stringBuffer.append(TEXT_2);
    
   if (basic||vertical) {  // don't print the table form//***

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
     
   if (("true").equals(printUniqueName)) {//print the component name.

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
   }

    stringBuffer.append(TEXT_8);
        			
    			for (int i = 0; i < sizeColumns; i++) {//5
  			
    				IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(isOptimizeCode){
						if(i%schemaOptNum == 0){

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
     
						}
					}else{
   if (("true").equals(useFixedLength)) {//fix the column length

    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
   }

    stringBuffer.append(TEXT_17);
     
   if (("true").equals(printColumnNames)) {//print the schema name

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_20);
    
   }

    stringBuffer.append(TEXT_21);
    
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) { //begin

    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_24);
    
    				} 

    stringBuffer.append(TEXT_25);
     
   if (("true").equals(useFixedLength)) {//fixed the column length

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(lengths.get(i).get("LENGTH") );
    stringBuffer.append(TEXT_30);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_34);
    
					} else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]

    stringBuffer.append(TEXT_35);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_37);
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_39);
    
					} else if (javaType == JavaTypesManager.DOUBLE || javaType == JavaTypesManager.FLOAT ) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_42);
    
					} else {//others

    stringBuffer.append(TEXT_43);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_45);
    				
					}

    stringBuffer.append(TEXT_46);
    
   } else {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_49);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_52);
    				
					} else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]

    stringBuffer.append(TEXT_53);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_55);
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_57);
    
					} else if (javaType == JavaTypesManager.DOUBLE || javaType == JavaTypesManager.FLOAT ) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_60);
    
					} else {//others

    stringBuffer.append(TEXT_61);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_63);
    				
					}

    stringBuffer.append(TEXT_64);
    
  }

    stringBuffer.append(TEXT_65);
    
					if(!isPrimitive) {//end

    stringBuffer.append(TEXT_66);
    
					} 

    stringBuffer.append(TEXT_67);
    
				if(i == sizeColumns-1) break;								

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELDSEPARATOR__") );
    stringBuffer.append(TEXT_70);
    
					}
				}//5	
}

			
if (basic) { 

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
                    if(isLogContent && isLog4jEnabled){
                    
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
                    }
                    
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    
	} 
	
	
	if(tablePrint || vertical) { //print the table and vertical model//***

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_86);
        			
    			for (int i = 0; i < sizeColumns; i++) {//5
  			
    				IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(isOptimizeCode){
						if(i%schemaOptNum == 0){

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
						}
					}else{
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) { //begin

    stringBuffer.append(TEXT_92);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_94);
    
    				} 

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_97);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_98);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_101);
    				
					} else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]

    stringBuffer.append(TEXT_102);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_104);
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_106);
    
					} else if (javaType == JavaTypesManager.DOUBLE || javaType == JavaTypesManager.FLOAT ) {

    stringBuffer.append(TEXT_107);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_109);
    
					} else {//others

    stringBuffer.append(TEXT_110);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_112);
    				
					}

    stringBuffer.append(TEXT_113);
    
					if(!isPrimitive) {//end

    stringBuffer.append(TEXT_114);
    
					} 

    stringBuffer.append(TEXT_115);
    
					}
				}//5	
				if(tablePrint){

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    
				}else{

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
				}
                if(isLogContent && isLog4jEnabled){
                
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
                }
	}//***

    stringBuffer.append(TEXT_131);
    
    		}//4
    	}//3
    }//2
}//1

    stringBuffer.append(TEXT_132);
    return stringBuffer.toString();
  }
}
