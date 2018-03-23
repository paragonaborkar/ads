package org.talend.designer.codegen.translators.internet;

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

public class TSocketOutputMainJava
{
  protected static String nl;
  public static synchronized TSocketOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSocketOutputMainJava result = new TSocketOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "            CsvWriter";
  protected final String TEXT_4 = ".setLineEnd(\"\"+'";
  protected final String TEXT_5 = "');";
  protected final String TEXT_6 = NL + "            CsvWriter";
  protected final String TEXT_7 = ".setEscapeChar('\\\\');";
  protected final String TEXT_8 = NL + "            CsvWriter";
  protected final String TEXT_9 = ".setEscapeChar('";
  protected final String TEXT_10 = "');";
  protected final String TEXT_11 = NL + "            //doesn't work for other escapeChar" + NL + "            CsvWriter";
  protected final String TEXT_12 = ".setEscapeChar('";
  protected final String TEXT_13 = "');";
  protected final String TEXT_14 = NL + "        " + NL + "        CsvWriter";
  protected final String TEXT_15 = ".setQuoteChar('";
  protected final String TEXT_16 = "'); " + NL + "        CsvWriter";
  protected final String TEXT_17 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);";
  protected final String TEXT_18 = "      " + NL + "                    String[] row";
  protected final String TEXT_19 = "=new String[";
  protected final String TEXT_20 = "];      ";
  protected final String TEXT_21 = NL + "                            row";
  protected final String TEXT_22 = "[";
  protected final String TEXT_23 = "] =String.valueOf(";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = "); ";
  protected final String TEXT_26 = NL + "                            if(";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = " == null){" + NL + "                                row";
  protected final String TEXT_29 = "[";
  protected final String TEXT_30 = "]=\"\";" + NL + "                            }else{";
  protected final String TEXT_31 = NL + "                                    row";
  protected final String TEXT_32 = "[";
  protected final String TEXT_33 = "] = ";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = ";";
  protected final String TEXT_36 = NL + "                                    row";
  protected final String TEXT_37 = "[";
  protected final String TEXT_38 = "] = FormatterUtils.format_Date(";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = ", ";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "                                    row";
  protected final String TEXT_43 = "[";
  protected final String TEXT_44 = "] = java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = ")).toString();";
  protected final String TEXT_47 = NL + "                                    row";
  protected final String TEXT_48 = "[";
  protected final String TEXT_49 = "] = String.valueOf(";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "                            }";
  protected final String TEXT_53 = NL + "                       //encoding" + NL + "                        for(int i =0;i<row";
  protected final String TEXT_54 = ".length;i++){" + NL + "                            row";
  protected final String TEXT_55 = "[i]=new sun.misc.BASE64Encoder().encode(com";
  protected final String TEXT_56 = ".zip(row";
  protected final String TEXT_57 = "[i].getBytes(";
  protected final String TEXT_58 = ")));//encodeing!!!!!!!!!!!!!!!!!!!" + NL + "                        }";
  protected final String TEXT_59 = "    " + NL + "                        CsvWriter";
  protected final String TEXT_60 = ".writeNext(row";
  protected final String TEXT_61 = "); " + NL + "                        CsvWriter";
  protected final String TEXT_62 = ".flush();                " + NL + "" + NL + "                    nb_line_";
  protected final String TEXT_63 = "++;";
  protected final String TEXT_64 = "            ";
  protected final String TEXT_65 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();  

    stringBuffer.append(TEXT_2);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {                                    
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
        String delim1 = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
        boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
        String delim = delim1.substring(1,delim1.length()-1);
        String rowSeparator1 = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
        String rowSeparator = rowSeparator1.substring(1,rowSeparator1.length()-1);
        String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
        String escapeChar = escapeChar1.substring(1,escapeChar1.length()-1);
        String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
        String textEnclosure = textEnclosure1.substring(1,textEnclosure1.length()-1);
        if ("".equals(textEnclosure)) textEnclosure = "\0";
        
        List< ? extends IConnection> conns = node.getIncomingConnections();
        if(!("\\n").equals(rowSeparator) && !("\\r").equals(rowSeparator)){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_5);
                  
        }
        if(("\\\\").equals(escapeChar)){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
        }else if(escapeChar.equals(textEnclosure)){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_10);
    
        }else{

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_13);
    
        }

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
          
        if(conns!=null){
            if (conns.size()>0){
                IConnection conn =conns.get(0);
                if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                List<IMetadataColumn> columns = metadata.getListColumns();
                    int sizeColumns = columns.size();

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_20);
    
                    for (int i = 0; i < sizeColumns; i++) {
                        IMetadataColumn column = columns.get(i);
                        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                        String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                        if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){
                            
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_25);
    
                        }else { 
                            
    stringBuffer.append(TEXT_26);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_30);
                      
                                if(javaType == JavaTypesManager.STRING ){
                                    
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_35);
    
                                }else if(javaType == JavaTypesManager.DATE && pattern != null){
                                    
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_41);
    
                                }else if(javaType == JavaTypesManager.BYTE_ARRAY){
                                    
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_46);
    
                                }else{
                                    
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_51);
    
                                }
                                
    stringBuffer.append(TEXT_52);
                  
                        }
                    } 

                        
     if(compress){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_58);
     } 
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
              
                }
            
            }
        }   
    
    }

}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(TEXT_65);
    return stringBuffer.toString();
  }
}
