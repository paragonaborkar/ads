package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import org.talend.core.model.process.ElementParameterParser;

public class TFileOutputJSONBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputJSONBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputJSONBeginJava result = new TFileOutputJSONBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "java.io.File file_";
  protected final String TEXT_3 = " = new java.io.File(";
  protected final String TEXT_4 = ");" + NL + "java.io.File dir_";
  protected final String TEXT_5 = " = file_";
  protected final String TEXT_6 = ".getParentFile();";
  protected final String TEXT_7 = NL + "\tif(dir_";
  protected final String TEXT_8 = "!=null && !dir_";
  protected final String TEXT_9 = ".exists()){" + NL + "\t\tdir_";
  protected final String TEXT_10 = ".mkdirs();" + NL + "\t}";
  protected final String TEXT_11 = NL + "java.io.PrintWriter out";
  protected final String TEXT_12 = " = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(";
  protected final String TEXT_13 = ")));";
  protected final String TEXT_14 = NL + "\tout";
  protected final String TEXT_15 = ".append(\"{\\\"\" + ";
  protected final String TEXT_16 = " + \"\\\":[\");";
  protected final String TEXT_17 = NL + "\tout";
  protected final String TEXT_18 = ".append(\"[\");";
  protected final String TEXT_19 = NL + "boolean isFirst_";
  protected final String TEXT_20 = " = true;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
String datablockname = ElementParameterParser.getValue(node, "__DATABLOCKNAME__");
String filename = ElementParameterParser.getValue(node, "__FILENAME__");
boolean create = "true".equals(ElementParameterParser.getValue(node, "__CREATE__"));
boolean generateJsonArray = "true".equals(ElementParameterParser.getValue(node, "__GENERATE_JSON_ARRAY__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
if(create){

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_13);
    if(!generateJsonArray){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(datablockname);
    stringBuffer.append(TEXT_16);
    }else{
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
