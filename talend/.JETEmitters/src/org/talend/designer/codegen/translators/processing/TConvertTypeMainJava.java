package org.talend.designer.codegen.translators.processing;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;

public class TConvertTypeMainJava
{
  protected static String nl;
  public static synchronized TConvertTypeMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TConvertTypeMainJava result = new TConvertTypeMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    ";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "    ";
  protected final String TEXT_4 = " = new ";
  protected final String TEXT_5 = "Struct();" + NL + "    String errorCode_";
  protected final String TEXT_6 = " = \"\";" + NL + "    String errorMessage_";
  protected final String TEXT_7 = " = \"\";";
  protected final String TEXT_8 = NL + "  ";
  protected final String TEXT_9 = " = new ";
  protected final String TEXT_10 = "Struct();" + NL + "  boolean bHasError_";
  protected final String TEXT_11 = " = false;  ";
  protected final String TEXT_12 = "           " + NL + "          try {";
  protected final String TEXT_13 = NL + "              if (\"\".equals(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ")){  ";
  protected final String TEXT_16 = NL + "                ";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = " = null;" + NL + "              }";
  protected final String TEXT_19 = NL + "              ";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = "=TypeConvert.";
  protected final String TEXT_22 = "2";
  protected final String TEXT_23 = "(";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "              ";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = "=TypeConvert.";
  protected final String TEXT_30 = "2";
  protected final String TEXT_31 = "(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = ");" + NL + "        \t";
  protected final String TEXT_35 = NL + "              ";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = "=ParserUtils.parseTo_Document(";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "              ";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = "=";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = ".toString();";
  protected final String TEXT_45 = NL + "              ";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = "=TypeConvert.";
  protected final String TEXT_48 = "2";
  protected final String TEXT_49 = "(";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = "    ";
  protected final String TEXT_53 = NL + "              ";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = ";";
  protected final String TEXT_58 = "            " + NL + "          } catch(java.lang.Exception e){" + NL + "            bHasError_";
  protected final String TEXT_59 = " = true;            ";
  protected final String TEXT_60 = NL + "              if ((\"\").equals(errorMessage_";
  protected final String TEXT_61 = ")){" + NL + "                errorMessage_";
  protected final String TEXT_62 = " = \"";
  protected final String TEXT_63 = "\" + \":\" + e.getMessage();" + NL + "              } else{" + NL + "                errorMessage_";
  protected final String TEXT_64 = " = errorMessage_";
  protected final String TEXT_65 = " + \";\" + \"";
  protected final String TEXT_66 = "\" + \":\" + e.getMessage();" + NL + "              }";
  protected final String TEXT_67 = NL + "              System.err.println(e.getMessage());          ";
  protected final String TEXT_68 = NL + "              throw e;";
  protected final String TEXT_69 = NL + "          }";
  protected final String TEXT_70 = NL + "      if (bHasError_";
  protected final String TEXT_71 = ") {";
  protected final String TEXT_72 = " = null;}";
  protected final String TEXT_73 = NL + "      ";
  protected final String TEXT_74 = " = null;";
  protected final String TEXT_75 = "     " + NL + "      try {";
  protected final String TEXT_76 = NL + "          if (\"\".equals(";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = ")){  ";
  protected final String TEXT_79 = NL + "            ";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = " = null;" + NL + "          }";
  protected final String TEXT_82 = NL + "          ";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = " = TypeConvert.";
  protected final String TEXT_85 = "2";
  protected final String TEXT_86 = "(";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "          ";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = TypeConvert.";
  protected final String TEXT_93 = "2";
  protected final String TEXT_94 = "(";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = ", ";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "          ";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = "=ParserUtils.parseTo_Document(";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = ");" + NL + "\t\t";
  protected final String TEXT_103 = NL + "          ";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = "=";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = ".toString();";
  protected final String TEXT_108 = NL + "          ";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = " = TypeConvert.";
  protected final String TEXT_111 = "2";
  protected final String TEXT_112 = "(";
  protected final String TEXT_113 = ".";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = "    ";
  protected final String TEXT_116 = NL + "          ";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = " = ";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = ";";
  protected final String TEXT_121 = NL + "      } catch (java.lang.Exception e){" + NL + "        bHasError_";
  protected final String TEXT_122 = " = true;        ";
  protected final String TEXT_123 = NL + "          if (\"\".equals(errorMessage_";
  protected final String TEXT_124 = ")){" + NL + "            errorMessage_";
  protected final String TEXT_125 = " = \"";
  protected final String TEXT_126 = "\" + \":\" + e.getMessage();" + NL + "          } else{" + NL + "            errorMessage_";
  protected final String TEXT_127 = "=errorMessage_";
  protected final String TEXT_128 = " + \";\" + \"";
  protected final String TEXT_129 = "\" + \":\" + e.getMessage();" + NL + "          }";
  protected final String TEXT_130 = NL + "          System.err.println(e.getMessage());          ";
  protected final String TEXT_131 = NL + "          throw e;";
  protected final String TEXT_132 = NL + "      }";
  protected final String TEXT_133 = NL + "      if (bHasError_";
  protected final String TEXT_134 = ") { ";
  protected final String TEXT_135 = " = null;}";
  protected final String TEXT_136 = NL + "      ";
  protected final String TEXT_137 = " = null;";
  protected final String TEXT_138 = NL + "    if (errorMessage_";
  protected final String TEXT_139 = ".length() > 0){" + NL + "      if (errorMessage_";
  protected final String TEXT_140 = ".contains(\"Can't support convert\")){" + NL + "        errorCode_";
  protected final String TEXT_141 = " = \"1\"; //ConvertTypeNotSupportException" + NL + "      }else{" + NL + "        errorCode_";
  protected final String TEXT_142 = " = \"2\"; //Other Java exception" + NL + "      }";
  protected final String TEXT_143 = NL + "      ";
  protected final String TEXT_144 = ".errorCode = errorCode_";
  protected final String TEXT_145 = ";";
  protected final String TEXT_146 = NL + "      ";
  protected final String TEXT_147 = ".errorMessage = errorMessage_";
  protected final String TEXT_148 = " + \" - Line: \" + tos_count_";
  protected final String TEXT_149 = ";" + NL + "    } else{";
  protected final String TEXT_150 = NL + "      ";
  protected final String TEXT_151 = " = null;" + NL + "    }" + NL + "    errorMessage_";
  protected final String TEXT_152 = " = \"\";";
  protected final String TEXT_153 = NL + "  nb_line_";
  protected final String TEXT_154 = " ++ ;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
  CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
  INode node = (INode)codeGenArgument.getArgument();
  String cid = node.getUniqueName();
  boolean autoCast = ("true").equals(ElementParameterParser.getValue(node, "__AUTOCAST__"));
  List<Map<String, String>> manualtable = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MANUALTABLE__");
  boolean bEmptyToNull = "true".equals(ElementParameterParser.getValue(node, "__EMPTYTONULL__"));
  boolean bDieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIEONERROR__"));
  IConnection inMainCon = null;
  List<? extends IConnection> connsIn = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
  
  if (connsIn == null || connsIn.size() == 0 ){
    return "";
  } else{
    inMainCon = connsIn.get(0);
  }   
  IConnection outConn = null;
  List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
  
  if (outConns == null || outConns.size() == 0 ){
    return "";
  } else{
  	for(int i=0; i<outConns.size(); i++){
  		IConnection connTemp = outConns.get(i);
	    if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	    	outConn = connTemp;
	    	break;
	    }
  	}
  } 
  
  String outconnName = outConn.getName();
  String preconnName = inMainCon.getName(); 
  String rejectConnName = null; 
  List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
  
  if (rejectConns != null && rejectConns.size() > 0) {
    for (IConnection conn : rejectConns) {
      if (conn.isActivate()){
        rejectConnName = conn.getName();
      }
    }
  }
  // Output Reject flow
  boolean bOutputReject = (rejectConnName != null) && (!bDieOnError);

  //reset reject = null
  boolean bResetReject = (rejectConnName != null) && (bDieOnError);

  //reset the main = null, and also consider there only have one reject link  
  boolean bResetMain = (rejectConnName == null) || (rejectConnName != null && !rejectConnName.equals(outconnName));
  
  //reset reject = null, when die on error and there only have one reject link, so, always reset to reject = null
  boolean bResetalways = (bDieOnError && rejectConnName != null && rejectConnName.equals(outconnName));

  // will ignore error
  boolean bIgnoreError = (rejectConnName == null) && (!bDieOnError);
  IMetadataTable preMetadata = inMainCon.getMetadataTable(); 
  List<IMetadataColumn> preColumns = preMetadata.getListColumns();   
  List<IMetadataTable> metadatas = node.getMetadataList();
  IMetadataTable metadata = metadatas.get(0);
  List<IMetadataColumn> columns = metadata.getListColumns();
  
  if (bResetReject){
  
    stringBuffer.append(TEXT_1);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_2);
    
  }
  
  if (bOutputReject){
  
    stringBuffer.append(TEXT_3);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
  }
  stringBuffer.append("\n");//control code format  
  
    stringBuffer.append(TEXT_8);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
      
  if (autoCast){ //autoCast begin
  
    for (IMetadataColumn col : columns){//col:columns  
      String outLabel = col.getLabel();
      String outPattern = col.getPattern();
      String outTypeWhole = JavaTypesManager.getTypeToGenerate(col.getTalendType(), col.isNullable());
      String outType = outTypeWhole.contains(".") ? outTypeWhole.substring(outTypeWhole.lastIndexOf(".") + 1) : outTypeWhole;
      if (("byte[]").equals(outType)){
        outType = "byteArray";
      }
      
      for (IMetadataColumn preCol : preColumns){//3
        String preLabel = preCol.getLabel();

        if (preLabel.equals(outLabel)){
          String inTypeWhole = JavaTypesManager.getTypeToGenerate(preCol.getTalendType(), preCol.isNullable());
          String inType = inTypeWhole.contains(".") ? inTypeWhole.substring(inTypeWhole.lastIndexOf(".") + 1) : inTypeWhole;
          String inPattern = preCol.getPattern();
          
          if (("byte[]").equals(inType)){
            inType = "byteArray";
          }
          
    stringBuffer.append(TEXT_12);
    
            if (bEmptyToNull && ("String".equals(inType) || "Object".equals(inType))) {
            
    stringBuffer.append(TEXT_13);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(preLabel);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_18);
    
            }
            
            if ("Date".equals(outType) && ("String".equals(inType)||"Object".equals(inType))) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(outPattern );
    stringBuffer.append(TEXT_26);
    } else if ("String".equals(outType) && "Date".equals(inType)) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(inPattern );
    stringBuffer.append(TEXT_34);
    } else if (("Document".equals(outType) && "String".equals(inType))){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_39);
    } else if (("String".equals(outType) && "Document".equals(inType))){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_44);
    } else{
    stringBuffer.append(TEXT_45);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_51);
    }
            
            if (bOutputReject){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    if (bOutputReject){
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_66);
    }else if (bIgnoreError){
    stringBuffer.append(TEXT_67);
    }else if (bDieOnError){
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
          
        }
      }//3
    }//col:columns

    if (bResetMain){
    
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_72);
    
    }
    
    if (bResetalways){
    
    stringBuffer.append(TEXT_73);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_74);
    
    }
  } else { // autoCast end,manual cast begin
  
    for (Map<String, String> manualColumn : manualtable){//111
      String input = manualColumn.get("INPUT_COLUMN");
      String output = manualColumn.get("OUTPUT_COLUMN");
      IMetadataColumn in = preMetadata.getColumn(input);
      IMetadataColumn out = metadata.getColumn(output);
      String inTypeWhole = JavaTypesManager.getTypeToGenerate(in.getTalendType(), in.isNullable());
      String inType = inTypeWhole.contains(".") ? inTypeWhole.substring(inTypeWhole.lastIndexOf(".") + 1) : inTypeWhole;
      String outTypeWhole = JavaTypesManager.getTypeToGenerate(out.getTalendType(), out.isNullable());
      String outType = outTypeWhole.contains(".") ? outTypeWhole.substring(outTypeWhole.lastIndexOf(".") + 1) : outTypeWhole;
      
      if (("byte[]").equals(outType)){
        outType = "byteArray";
      }
      
      if (("byte[]").equals(inType)){
        inType = "byteArray";
      }
      String outLabel = out.getLabel();
      String outPattern = out.getPattern();
      String preLabel = in.getLabel();
      String inPattern = in.getPattern();
      
    stringBuffer.append(TEXT_75);
    
        if (bEmptyToNull && ("String".equals(inType) || "Object".equals(inType))) {
        
    stringBuffer.append(TEXT_76);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(preLabel);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_81);
    
        }
        
        if ("Date".equals(outType) && "String".equals(inType)) {
    stringBuffer.append(TEXT_82);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(outPattern );
    stringBuffer.append(TEXT_89);
    } else if ("String".equals(outType) && "Date".equals(inType)) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(inPattern );
    stringBuffer.append(TEXT_97);
    } else if (("Document".equals(outType) && "String".equals(inType))){
    stringBuffer.append(TEXT_98);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_102);
    } else if (("String".equals(outType) && "Document".equals(inType))){
    stringBuffer.append(TEXT_103);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_107);
    } else {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(preconnName );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_114);
    }
        
        if (bOutputReject){
        
    stringBuffer.append(TEXT_115);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_120);
    
        }
        
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    if (bOutputReject){
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_129);
    }else if (bIgnoreError){
    stringBuffer.append(TEXT_130);
    }else if (bDieOnError){
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    
    }//111
     
    if (bResetMain){
    
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_135);
    
    }
     
    if (bResetalways){
    
    stringBuffer.append(TEXT_136);
    stringBuffer.append(outconnName );
    stringBuffer.append(TEXT_137);
    
    }
  }//manual end.

  stringBuffer.append("\n"); //control code format

  if (bOutputReject){//occure Reject
  
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    
  }//occure Reject end
  
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    return stringBuffer.toString();
  }
}
