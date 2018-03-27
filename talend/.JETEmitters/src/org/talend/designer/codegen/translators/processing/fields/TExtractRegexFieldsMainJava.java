package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.BlockCode;
import java.util.List;
import java.util.ArrayList;

public class TExtractRegexFieldsMainJava
{
  protected static String nl;
  public static synchronized TExtractRegexFieldsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractRegexFieldsMainJava result = new TExtractRegexFieldsMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t";
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + "\t\t\tif(";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = "!=null){// C_01";
  protected final String TEXT_7 = NL + "    \t\tjava.util.regex.Matcher matcher_";
  protected final String TEXT_8 = " = pattern_";
  protected final String TEXT_9 = ".matcher(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\t\t\t    boolean isNotMatch_";
  protected final String TEXT_13 = " = false;" + NL + "\t\t\t    if(!matcher_";
  protected final String TEXT_14 = ".find()){" + NL + "\t\t\t        ";
  protected final String TEXT_15 = " = new ";
  protected final String TEXT_16 = "Struct();" + NL + "\t\t\t        ";
  protected final String TEXT_17 = ".errorMessage = ";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = " + \" doesn't match regex:\" + ";
  protected final String TEXT_20 = ";" + NL + "\t\t\t        isNotMatch_";
  protected final String TEXT_21 = " = true;";
  protected final String TEXT_22 = NL + "                                ";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL + "\t\t\t    }" + NL + "\t\t\t    matcher_";
  protected final String TEXT_28 = ".reset();";
  protected final String TEXT_29 = NL + "    " + NL + "\t\t    int groupCount_";
  protected final String TEXT_30 = " = matcher_";
  protected final String TEXT_31 = ".groupCount();" + NL + "\t\t    while(";
  protected final String TEXT_32 = " matcher_";
  protected final String TEXT_33 = ".find()){" + NL + "\t\t";
  protected final String TEXT_34 = NL;
  protected final String TEXT_35 = NL + "try{";
  protected final String TEXT_36 = NL + "    ";
  protected final String TEXT_37 = " = new ";
  protected final String TEXT_38 = "Struct();";
  protected final String TEXT_39 = NL + "    \t\t\t";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ";";
  protected final String TEXT_44 = NL + NL + "String temp_";
  protected final String TEXT_45 = " = null;";
  protected final String TEXT_46 = NL + "\t\t\t";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = " = groupCount_";
  protected final String TEXT_49 = " <= ";
  protected final String TEXT_50 = "? \"\" : matcher_";
  protected final String TEXT_51 = ".group(";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\t\t    temp_";
  protected final String TEXT_54 = " = groupCount_";
  protected final String TEXT_55 = " <= ";
  protected final String TEXT_56 = "? \"\" : matcher_";
  protected final String TEXT_57 = ".group(";
  protected final String TEXT_58 = " + 1);" + NL + "\t\t    if(temp_";
  protected final String TEXT_59 = ".length() > 0) {";
  protected final String TEXT_60 = NL + "        \t\t\t";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = " = temp_";
  protected final String TEXT_63 = ".getBytes();";
  protected final String TEXT_64 = NL + "        \t\t\t\t";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = ", false);";
  protected final String TEXT_69 = NL + "        \t\t\t\t";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "        \t\t\t";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = " = ParserUtils.parseTo_";
  protected final String TEXT_77 = "(temp_";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "    \t\t} else {";
  protected final String TEXT_80 = NL + "        \t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_81 = "' in '";
  protected final String TEXT_82 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_83 = NL + "        \t\t\t";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = " = ";
  protected final String TEXT_86 = ";";
  protected final String TEXT_87 = NL + "    \t\t}";
  protected final String TEXT_88 = NL + "     int filedsum_";
  protected final String TEXT_89 = " = groupCount_";
  protected final String TEXT_90 = ";" + NL + "     if(filedsum_";
  protected final String TEXT_91 = " < ";
  protected final String TEXT_92 = "){" + NL + "         throw new RuntimeException(\"Column(s) missing\");" + NL + "     } else if(filedsum_";
  protected final String TEXT_93 = " > ";
  protected final String TEXT_94 = ") {" + NL + "         throw new RuntimeException(\"Too many columns\");" + NL + "     }";
  protected final String TEXT_95 = NL + "    \t";
  protected final String TEXT_96 = " = null;";
  protected final String TEXT_97 = NL + "\t}catch(java.lang.Exception ex_";
  protected final String TEXT_98 = "){";
  protected final String TEXT_99 = NL + "    \tthrow(ex_";
  protected final String TEXT_100 = ");";
  protected final String TEXT_101 = NL + "    \t\t";
  protected final String TEXT_102 = " = new ";
  protected final String TEXT_103 = "Struct();";
  protected final String TEXT_104 = NL + "    \t\t\t";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = " = ";
  protected final String TEXT_107 = ".";
  protected final String TEXT_108 = ";";
  protected final String TEXT_109 = NL + "\t\t    ";
  protected final String TEXT_110 = ".errorMessage = ex_";
  protected final String TEXT_111 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_112 = ";" + NL + "\t\t    ";
  protected final String TEXT_113 = " = null;";
  protected final String TEXT_114 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_115 = " - \" + ex_";
  protected final String TEXT_116 = ".getMessage());";
  protected final String TEXT_117 = NL + "\t\t    System.err.println(ex_";
  protected final String TEXT_118 = ".getMessage());" + NL + "\t\t    ";
  protected final String TEXT_119 = " = null;";
  protected final String TEXT_120 = NL + "    \t\t";
  protected final String TEXT_121 = ".errorMessage = ex_";
  protected final String TEXT_122 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_123 = ";";
  protected final String TEXT_124 = NL + "}";
  protected final String TEXT_125 = NL + "}" + NL + "\tisNotMatch_";
  protected final String TEXT_126 = " = false;";
  protected final String TEXT_127 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String field = ElementParameterParser.getValue(node, "__FIELD__");
String reg = ElementParameterParser.getValue(node,"__REGEX__");

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;

String checkNumStr = ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__");
boolean checkNum = (checkNumStr!=null&&!("").equals(checkNumStr))?("true").equals(checkNumStr):false;

final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

IConnection inConn = null;
List< ? extends IConnection> inConns = node.getIncomingConnections();
if(inConns!=null){
    for (IConnection conn : inConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            inConn = conn;
            break;
        }
    }
}

String rejectConnName = "";
List<IMetadataColumn> rejectColumnList = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
    IConnection rejectConn = rejectConns.get(0);
    rejectColumnList = rejectConn.getMetadataTable().getListColumns();
    rejectConnName = rejectConn.getName();
}

IConnection outConn = null;
String firstConnName = "";
List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
if(outConns!=null){
    for (IConnection conn : outConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            outConn = conn;
            firstConnName = outConn.getName();
            break;
        }
    }
}
boolean needRejectLink = !("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0;

if(outConns!=null){
    for (IConnection conn : outConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_3);
    
        }
    }
}

//get field column
//========= Bug 19723 add outConn!=null =========
if(inConn!=null && outConn!=null){
    IMetadataTable inputMetadataTable = inConn.getMetadataTable();
    IMetadataTable outputMetadataTable = outConn.getMetadataTable();
    //outCols below is nerver used after definition
    //int outCols = outputMetadataTable.getListColumns().size();
    for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
        if(inputCol.getLabel().equals(field)){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(field);
    stringBuffer.append(TEXT_6);
    
			List<BlockCode> blockCodes = new java.util.ArrayList<BlockCode>(1);
			blockCodes.add(new BlockCode("C_01"));
			((org.talend.core.model.process.AbstractNode) node).setBlocksCodeToClose(blockCodes);

    stringBuffer.append(TEXT_7);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(field);
    stringBuffer.append(TEXT_11);
    
            if(!"".equals(rejectConnName)) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(field);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(reg);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
//========= Bug 15631 START =========
//output rows to reject
//when there's no output component,we can't get "outputMetadataTable" through "out conn"
                    for (IMetadataColumn outputRejCol : outputMetadataTable.getListColumns()) {
                        for (IMetadataColumn inputRejCol : inputMetadataTable.getListColumns()) {
                            if( outputRejCol.getLabel().equals( inputRejCol.getLabel()) ){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(outputRejCol.getLabel());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(inputRejCol.getLabel());
    stringBuffer.append(TEXT_26);
    
                            	break;
                            }
                        }
                    }
//========= Bug 15631 END =========

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
            }

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append("".equals(rejectConnName)?"":"isNotMatch_"+cid + "||" );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_33);
    			
            break;
        }
    }
}

//set original columns
List<IMetadataColumn> newColumnList = new ArrayList<IMetadataColumn>();
if(outConn!=null && inConn!=null){

    stringBuffer.append(TEXT_34);
    stringBuffer.append("".equals(rejectConnName)?"":"if(!isNotMatch_"+cid +"){" );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_38);
    
    IMetadataTable outputMetadataTable = outConn.getMetadataTable();
    IMetadataTable inputMetadataTable = inConn.getMetadataTable();
    for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
        if(outputCol.getLabel().equals(field)){
//========= Bug 15631 =========
//allow to keep copy of original field continue;
        }
        boolean isOirginalColumn = false;
        for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
            if( outputCol.getLabel().equals( inputCol.getLabel()) ){
                isOirginalColumn = true;

    stringBuffer.append(TEXT_39);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(outputCol.getLabel());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(inputCol.getLabel());
    stringBuffer.append(TEXT_43);
    
                break;
            }
        }
        if(!isOirginalColumn){
            if(!("").equals(rejectConnName)&&rejectConnName.equals(firstConnName)
                && (outputCol.getLabel().equals("errorMessage") || outputCol.getLabel().equals("errorCode"))){
            }else{
                newColumnList.add(outputCol);
            }
        }
    }

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
    for(int i=0; i<newColumnList.size();i++){
        IMetadataColumn column = newColumnList.get(i);
        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
        String primitiveTypeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
        String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    
        if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){


    stringBuffer.append(TEXT_46);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(i + 1 );
    stringBuffer.append(TEXT_52);
    
        }else{

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    
	            if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
	            } else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_60);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
	            }else if(javaType == JavaTypesManager.DATE) {
	                if(checkNum){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_68);
    
                	}else{

    stringBuffer.append(TEXT_69);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_73);
    
	                }
	            } else {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    
            	}

    stringBuffer.append(TEXT_79);
    
	            String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
	            if(defaultValue == null) {

    stringBuffer.append(TEXT_80);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_82);
    
            	} else {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_86);
    
            	}

    stringBuffer.append(TEXT_87);
    
    	}
	}
    
    if(checkNum) {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(newColumnList.size() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(newColumnList.size() );
    stringBuffer.append(TEXT_94);
    
    }
    
    if(!("").equals(rejectConnName) && rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_95);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_96);
    
    }

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    
    if(dieOnError){

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    
    }else{
        if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_101);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_103);
    
            for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {

    stringBuffer.append(TEXT_104);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_108);
    
            }

    stringBuffer.append(TEXT_109);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_113);
    
        } else if(("").equals(rejectConnName)){
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    
    		}

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_119);
    
        } else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_120);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_123);
    
        }
    }

    stringBuffer.append(TEXT_124);
    if(!"".equals(rejectConnName)){
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    
}
}

    stringBuffer.append(TEXT_127);
    return stringBuffer.toString();
  }
}
