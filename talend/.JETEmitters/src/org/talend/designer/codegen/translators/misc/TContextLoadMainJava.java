package org.talend.designer.codegen.translators.misc;

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
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.IContextParameter;
import java.util.ArrayList;

public class TContextLoadMainJava
{
  protected static String nl;
  public static synchronized TContextLoadMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TContextLoadMainJava result = new TContextLoadMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        //////////////////////////" + NL + "        String tmp_key_";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "                    String ";
  protected final String TEXT_4 = "_";
  protected final String TEXT_5 = " = null;";
  protected final String TEXT_6 = NL + "                      if (";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " != null){" + NL + "                          tmp_key_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ".trim();" + NL + "                        if ((tmp_key_";
  protected final String TEXT_12 = ".startsWith(\"#\") || tmp_key_";
  protected final String TEXT_13 = ".startsWith(\"!\") )){" + NL + "                          tmp_key_";
  protected final String TEXT_14 = " = null;" + NL + "                        } else {";
  protected final String TEXT_15 = NL + "                          ";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = " = tmp_key_";
  protected final String TEXT_18 = ";" + NL + "                        }" + NL + "                      }";
  protected final String TEXT_19 = NL + "                        if(";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = " != null) {";
  protected final String TEXT_22 = NL + "                    ";
  protected final String TEXT_23 = "_";
  protected final String TEXT_24 = " =";
  protected final String TEXT_25 = NL + "                        FormatterUtils.format_Date(";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = ", ";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "                        ";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ";";
  protected final String TEXT_32 = NL + "                        String.valueOf(";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "                        }";
  protected final String TEXT_36 = NL + "\t\t\t\t" + NL + "\t\t\t\tString currentValue_";
  protected final String TEXT_37 = " = value_";
  protected final String TEXT_38 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_39 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tif (\"";
  protected final String TEXT_40 = "\".equals(key_";
  protected final String TEXT_41 = ") ) currentValue_";
  protected final String TEXT_42 = " = currentValue_";
  protected final String TEXT_43 = ".replaceAll(\".\", \"*\");";
  protected final String TEXT_44 = NL;
  protected final String TEXT_45 = NL + "                    if(";
  protected final String TEXT_46 = ") {" + NL + "                        System.out.println(\"";
  protected final String TEXT_47 = " set key \\\"\" + key_";
  protected final String TEXT_48 = " + \"\\\" with value \\\"\" + currentValue_";
  protected final String TEXT_49 = " + \"\\\"\");" + NL + "                    }";
  protected final String TEXT_50 = NL + "                        System.out.println(\"";
  protected final String TEXT_51 = " set key \\\"\" + key_";
  protected final String TEXT_52 = " + \"\\\" with value \\\"\" + currentValue_";
  protected final String TEXT_53 = " + \"\\\"\");";
  protected final String TEXT_54 = NL + "  if (tmp_key_";
  protected final String TEXT_55 = " != null){" + NL + "  try{";
  protected final String TEXT_56 = NL + "        if(key_";
  protected final String TEXT_57 = "!=null && \"";
  protected final String TEXT_58 = "\".equals(key_";
  protected final String TEXT_59 = "))" + NL + "        {";
  protected final String TEXT_60 = NL + "                String context_";
  protected final String TEXT_61 = "_value = context.getProperty(\"";
  protected final String TEXT_62 = "\");" + NL + "                if(context_";
  protected final String TEXT_63 = "_value==null)" + NL + "                    context_";
  protected final String TEXT_64 = "_value = \"\";" + NL + "                int context_";
  protected final String TEXT_65 = "_pos = context_";
  protected final String TEXT_66 = "_value.indexOf(\";\");" + NL + "                String context_";
  protected final String TEXT_67 = "_pattern =  \"yyyy-MM-dd HH:mm:ss\";" + NL + "                if(context_";
  protected final String TEXT_68 = "_pos > -1){" + NL + "                    context_";
  protected final String TEXT_69 = "_pattern = context_";
  protected final String TEXT_70 = "_value.substring(0, context_";
  protected final String TEXT_71 = "_pos);" + NL + "                }" + NL + "                context.";
  protected final String TEXT_72 = "=(java.util.Date)(new java.text.SimpleDateFormat(context_";
  protected final String TEXT_73 = "_pattern).parse(value_";
  protected final String TEXT_74 = "));" + NL;
  protected final String TEXT_75 = NL + NL + "                context.";
  protected final String TEXT_76 = "=Integer.parseInt(value_";
  protected final String TEXT_77 = ");" + NL;
  protected final String TEXT_78 = NL + "           context.";
  protected final String TEXT_79 = "=value_";
  protected final String TEXT_80 = ";";
  protected final String TEXT_81 = NL + "           context.";
  protected final String TEXT_82 = "=new java.text.StringCharacterIterator(value_";
  protected final String TEXT_83 = ").first();";
  protected final String TEXT_84 = NL + "           context.";
  protected final String TEXT_85 = "=new ";
  protected final String TEXT_86 = " (value_";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + NL + "               context.";
  protected final String TEXT_89 = "=";
  protected final String TEXT_90 = ".parse";
  protected final String TEXT_91 = "(value_";
  protected final String TEXT_92 = ");" + NL;
  protected final String TEXT_93 = NL + "        }" + NL;
  protected final String TEXT_94 = NL + NL + "        if (context.getProperty(key_";
  protected final String TEXT_95 = ")!=null)" + NL + "        {" + NL + "            assignList_";
  protected final String TEXT_96 = ".add(key_";
  protected final String TEXT_97 = ");" + NL + "        }else  {" + NL + "            newPropertyList_";
  protected final String TEXT_98 = ".add(key_";
  protected final String TEXT_99 = ");" + NL + "        }" + NL + "        if(value_";
  protected final String TEXT_100 = " == null){" + NL + "            context.setProperty(key_";
  protected final String TEXT_101 = ", \"\");" + NL + "        }else{" + NL + "            context.setProperty(key_";
  protected final String TEXT_102 = ",value_";
  protected final String TEXT_103 = ");" + NL + "        }" + NL + "    }catch(java.lang.Exception e){";
  protected final String TEXT_104 = NL + "            log.error(\"";
  protected final String TEXT_105 = " - Setting a value for the key \\\"\" + key_";
  protected final String TEXT_106 = " + \"\\\" has failed. Error message: \" + e.getMessage());";
  protected final String TEXT_107 = NL + "        System.err.println(\"Setting a value for the key \\\"\" + key_";
  protected final String TEXT_108 = " + \"\\\" has failed. Error message: \" + e.getMessage());" + NL + "    }" + NL + "        nb_line_";
  protected final String TEXT_109 = "++;" + NL + "    }";
  protected final String TEXT_110 = NL + "        //////////////////////////";
  protected final String TEXT_111 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
IProcess process=node.getProcess();
List<IContextParameter> params = new ArrayList<IContextParameter>();
params=process.getContextManager().getDefaultContext().getContextParameterList();
List<IMetadataTable> metadatas = node.getMetadataList();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
        List< ? extends IConnection> conns = node.getIncomingConnections();
        for (IConnection conn : conns) {
            if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                
    
                List<IMetadataColumn> columns = metadata.getListColumns();
                int sizeColumns = columns.size();
                for (int i = 0; (sizeColumns >= 2)&&(i < 2); i++) {
                    IMetadataColumn column = columns.get(i);
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
                    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(i==0?"key":"value" );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
                    // allow to add comment line start with '#' or '!'
                    if (i == 0){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
                    }
                    if(!isPrimitive) {
                        
    stringBuffer.append(TEXT_19);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_21);
    
                    }
                    
    stringBuffer.append(TEXT_22);
    stringBuffer.append(i==0?"key":"value" );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
                    String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                    if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
                        
    stringBuffer.append(TEXT_25);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_28);
    
                    } else if(javaType == JavaTypesManager.STRING) {
                        
    stringBuffer.append(TEXT_29);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_31);
    
                    } else {
                        
    stringBuffer.append(TEXT_32);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_34);
    
                    }
                    if(!isPrimitive) {
                         
    stringBuffer.append(TEXT_35);
    
                    }
                }//here end the last for, the List "columns"
                
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    
				
				for (IContextParameter ctxParam: params) {
					if ("id_Password".equals(ctxParam.getType()) ) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    						
					}	

				}		

    stringBuffer.append(TEXT_44);
    
                if(node.getElementParameter("PRINT_OPERATIONS").isContextMode()) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PRINT_OPERATIONS__"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    
                } else {
                    if (ElementParameterParser.getValue(node, "__PRINT_OPERATIONS__").equals("true")) {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
                    }
                }

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
            for (IContextParameter ctxParam :params)
             {
                String typeToGenerate ="String";
                if( !(ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory") ||ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_Password")))
                {
                   typeToGenerate=JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
                }
        
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
     if(typeToGenerate.equals("java.util.Date"))
            {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    }else if(typeToGenerate.equals("Integer")){
    stringBuffer.append(TEXT_75);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    }else if(typeToGenerate.equals("Object")||typeToGenerate.equals("String")){
    stringBuffer.append(TEXT_78);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    }else if(typeToGenerate.equals("Character")){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    }else if(typeToGenerate.equals("BigDecimal")){
    stringBuffer.append(TEXT_84);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    }
           else{
    stringBuffer.append(TEXT_88);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    
             }
        
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    
            }
        }//here end the first for, the List "conns"

    stringBuffer.append(TEXT_110);
    
    }
}

    stringBuffer.append(TEXT_111);
    return stringBuffer.toString();
  }
}
