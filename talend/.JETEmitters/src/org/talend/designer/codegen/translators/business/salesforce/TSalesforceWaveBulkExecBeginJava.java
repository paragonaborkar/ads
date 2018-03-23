package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TSalesforceWaveBulkExecBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceWaveBulkExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceWaveBulkExecBeginJava result = new TSalesforceWaveBulkExecBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "        String generateJsonMetadataPath_";
  protected final String TEXT_4 = " = null;" + NL + "        String tempDirectoryPath_";
  protected final String TEXT_5 = " = (";
  protected final String TEXT_6 = ").replace(\"\\\\\",\"/\");" + NL + "        if(tempDirectoryPath_";
  protected final String TEXT_7 = ".endsWith(\"/\")){" + NL + "            tempDirectoryPath_";
  protected final String TEXT_8 = " = tempDirectoryPath_";
  protected final String TEXT_9 = ".substring(0,tempDirectoryPath_";
  protected final String TEXT_10 = ".length()-1);" + NL + "        }" + NL + "" + NL + "        String timestamp_";
  protected final String TEXT_11 = " = null;" + NL + "        String jsonMetadataFileName_";
  protected final String TEXT_12 = " = null;" + NL + "        timestamp_";
  protected final String TEXT_13 = " = new java.text.SimpleDateFormat(\"yyyyMMdd_HH_mm_ss\").format(new java.util.Date());" + NL + "        jsonMetadataFileName_";
  protected final String TEXT_14 = " = \"SFwaveMetadata_\"+timestamp_";
  protected final String TEXT_15 = "+\".json\";" + NL + "        generateJsonMetadataPath_";
  protected final String TEXT_16 = " = tempDirectoryPath_";
  protected final String TEXT_17 = " + java.io.File.separator + jsonMetadataFileName_";
  protected final String TEXT_18 = ";" + NL + "        generateJsonMetadataPath_";
  protected final String TEXT_19 = " = generateJsonMetadataPath_";
  protected final String TEXT_20 = ".replace(\"\\\\\",\"/\");" + NL + "" + NL + "        java.io.File tempDirectory_";
  protected final String TEXT_21 = " = new java.io.File(tempDirectoryPath_";
  protected final String TEXT_22 = ");" + NL + "        if(!tempDirectory_";
  protected final String TEXT_23 = ".exists()){" + NL + "             boolean createDirOK_";
  protected final String TEXT_24 = " = tempDirectory_";
  protected final String TEXT_25 = ".mkdir();" + NL + "             if(!createDirOK_";
  protected final String TEXT_26 = "){" + NL + "                  throw new RuntimeException(\"Can not create temporary directory: tempDirectoryPath_";
  protected final String TEXT_27 = ", please set the right file permission and try again.\");" + NL + "             }" + NL + "        }";
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL + "//////////////////////////////////////////// Compile Error ///////////////////////////////////////////////////" + NL + "                         Can not generate json metadata because the schema is empty." + NL + "//////////////////////////////////////////// Compile Error ///////////////////////////////////////////////////";
  protected final String TEXT_30 = NL + "                      List<com.talend.salesforce.wave.MetadataColumnRuntime> metadataColumnRuntimeList_";
  protected final String TEXT_31 = NL + "                                                                             = new java.util.ArrayList<com.talend.salesforce.wave.MetadataColumnRuntime>();";
  protected final String TEXT_32 = NL + "                                   metadataColumnRuntimeList_";
  protected final String TEXT_33 = ".add(" + NL + "                                        new com.talend.salesforce.wave.MetadataColumnRuntime.Builder()" + NL + "                                                                      .label(\"";
  protected final String TEXT_34 = "\")" + NL + "                                                                      .talendType(\"";
  protected final String TEXT_35 = "\")";
  protected final String TEXT_36 = NL + "                                                                      .pattern(";
  protected final String TEXT_37 = ")";
  protected final String TEXT_38 = NL + "                                                                      .length(";
  protected final String TEXT_39 = ")";
  protected final String TEXT_40 = NL + "                                                                      .length(10)";
  protected final String TEXT_41 = NL + "                                                                      .precision(";
  protected final String TEXT_42 = ")";
  protected final String TEXT_43 = NL + "                                                                       .precision(2)";
  protected final String TEXT_44 = NL + "                                                                      .defaultValue(\"";
  protected final String TEXT_45 = "\")";
  protected final String TEXT_46 = NL + "                                                                      .comment(\"";
  protected final String TEXT_47 = "\")";
  protected final String TEXT_48 = NL + "                                                                      .isPrimaryKey(";
  protected final String TEXT_49 = ")" + NL + "                                                                      .build()" + NL + "                                        );";
  protected final String TEXT_50 = NL + "           java.util.Map<String,Object> customConfig_";
  protected final String TEXT_51 = " = new java.util.HashMap<String,Object>();";
  protected final String TEXT_52 = NL + "                               customConfig_";
  protected final String TEXT_53 = ".put(\"numberOfLinesToIgnore\",0);" + NL + "                               customConfig_";
  protected final String TEXT_54 = ".put(\"UniqueApiName\",\"SalesData\");" + NL + "                               customConfig_";
  protected final String TEXT_55 = ".put(\"fullyQualifiedName\",\"Sales Data\");" + NL + "                               customConfig_";
  protected final String TEXT_56 = ".put(\"label\",\"CRM.SalesData\");";
  protected final String TEXT_57 = NL + "                               customConfig_";
  protected final String TEXT_58 = ".put(\"numberOfLinesToIgnore\",";
  protected final String TEXT_59 = ");" + NL + "                               customConfig_";
  protected final String TEXT_60 = ".put(\"UniqueApiName\",";
  protected final String TEXT_61 = ");" + NL + "                               customConfig_";
  protected final String TEXT_62 = ".put(\"fullyQualifiedName\",";
  protected final String TEXT_63 = ");" + NL + "                               customConfig_";
  protected final String TEXT_64 = ".put(\"label\",";
  protected final String TEXT_65 = ");" + NL + "                               if(!com.talend.salesforce.wave.SalesforceWaveHelper.isValidUniqueApiName(";
  protected final String TEXT_66 = ")){" + NL + "                                    System.err.println(\"UniqueApiName is invalid,thus it may lead to upload failed.\");" + NL + "                                    System.err.println(\"UniqueApiName must begin with a letter and use only alphanumeric characters and underscores.\"" + NL + "                                                      + \"It can't include spaces, end with an underscore, or have two consecutive underscores.\");" + NL + "                               }" + NL + "                               if(!com.talend.salesforce.wave.SalesforceWaveHelper.isValidValue(";
  protected final String TEXT_67 = ")){" + NL + "                                    System.err.println(\"fullyQualifiedName is invalid,thus it may lead to upload failed.\");" + NL + "                                    System.err.println(\"Names can use only alpha-numeric or '_' characters\");" + NL + "                               }";
  protected final String TEXT_68 = NL + "                              customConfig_";
  protected final String TEXT_69 = ".put(\"charsetName\",";
  protected final String TEXT_70 = ");" + NL + "                              customConfig_";
  protected final String TEXT_71 = ".put(\"fieldsDelimitedBy\",";
  protected final String TEXT_72 = ");" + NL + "                              customConfig_";
  protected final String TEXT_73 = ".put(\"fieldsEnclosedBy\",";
  protected final String TEXT_74 = ");" + NL + "                              customConfig_";
  protected final String TEXT_75 = ".put(\"linesTerminatedBy\",";
  protected final String TEXT_76 = ");" + NL + "                              customConfig_";
  protected final String TEXT_77 = ".put(\"numericFormat\",";
  protected final String TEXT_78 = ");" + NL + "                              customConfig_";
  protected final String TEXT_79 = ".put(\"csvPath\",";
  protected final String TEXT_80 = ");" + NL + "                              customConfig_";
  protected final String TEXT_81 = ".put(\"encoding\",";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + "                             com.talend.salesforce.wave.SalesforceWaveHelper.generateJsonMetadata(new java.io.File(generateJsonMetadataPath_";
  protected final String TEXT_84 = "),metadataColumnRuntimeList_";
  protected final String TEXT_85 = ",customConfig_";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    boolean uploadJsonMetadata = "true".equals(ElementParameterParser.getValue(node,"__UPLODE_JSON_METADATA__"));
    boolean specifyJsonMetadata = "true".equals(ElementParameterParser.getValue(node,"__SPECIFY_JSON_METADATA__"));
    String  jsonMetadataPath = ElementParameterParser.getValue(node,"__JSON_METADATA_PATH__");
    boolean autoGenerateMetadataDesc = "true".equals(ElementParameterParser.getValue(node,"__AUTO_GENERATE_JSON_METADATA_DESCRIPTION__"));
            autoGenerateMetadataDesc = autoGenerateMetadataDesc && !specifyJsonMetadata;

    String nLines2Ingore = ElementParameterParser.getValue(node,"__NUMBER_OF_LINES_TO_IGNORE__");
    String uniqueApiName = ElementParameterParser.getValue(node,"__UNIQUE_API_NAME__");
    String label = ElementParameterParser.getValue(node,"__DATA_LABEL__");
    String fullyQualifiedName = ElementParameterParser.getValue(node,"__FULLY_QUALIFIED_NAME__");

    //hidden parameters
    String charsetName = ElementParameterParser.getValue(node,"__CHARSET__");
    String fieldsDelimitedBy = ElementParameterParser.getValue(node,"__FIELDS_DELIMITED_BY__");
    String fieldsEnclosedBy = ElementParameterParser.getValue(node,"__FIELDS_ENCLOSED_BY__");
    String linesTerminatedBy = ElementParameterParser.getValue(node,"__LINES_TERMINATED_BY__");
    String numericFormat = ElementParameterParser.getValue(node,"__NUMERIC_FORMAT__");

    if("\"\"\"".equals(fieldsEnclosedBy)){
        fieldsEnclosedBy = "\"\\\"\"";
    }

    boolean generateJsonInFile = "true".equals(ElementParameterParser.getValue(node,"__GENERATE_JSON_IN_FILE__"));
    String storagePath = ElementParameterParser.getValue(node,"__CUSTOM_FOLDER__");
    String csvPath = ElementParameterParser.getValue(node, "__LOAD_DATA_PATH__");

    boolean willGenerateJsonMetadata = !specifyJsonMetadata && uploadJsonMetadata;//In File or Memory

    String encoding = "UTF-8";
    if(charsetName != null && !"".equals(charsetName) && !"\"\"".equals(charsetName)){
           encoding = charsetName;
    }

    stringBuffer.append(TEXT_2);
    
    //Generate JSON in File
    if(willGenerateJsonMetadata && generateJsonInFile){

    stringBuffer.append(TEXT_3);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( storagePath );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_27);
    
    }

    stringBuffer.append(TEXT_28);
    
    if(willGenerateJsonMetadata){
        List<IMetadataTable> metadataList = node.getMetadataList();
        if ((metadataList != null) && (metadataList.size() > 0)) {
            IMetadataTable metadata = metadataList.get(0);
            if(metadata != null){
                List<IMetadataColumn> columnList = metadata.getListColumns();
                    if(columnList.size() <= 0){
                        
    stringBuffer.append(TEXT_29);
    
                    }

    stringBuffer.append(TEXT_30);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_31);
    
                            for(IMetadataColumn imetadataColumn: columnList){
                                
    stringBuffer.append(TEXT_32);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( imetadataColumn.getLabel());
    stringBuffer.append(TEXT_34);
    stringBuffer.append( imetadataColumn.getTalendType());
    stringBuffer.append(TEXT_35);
    
                                                                          if(imetadataColumn.getPattern() != null && !"".equals(imetadataColumn.getPattern())){
                                                                      
    stringBuffer.append(TEXT_36);
    stringBuffer.append( imetadataColumn.getPattern() );
    stringBuffer.append(TEXT_37);
    
                                                                          }
                                                                          if(imetadataColumn.getLength() != null){
                                                                      
    stringBuffer.append(TEXT_38);
    stringBuffer.append( imetadataColumn.getLength());
    stringBuffer.append(TEXT_39);
    
                                                                          }else{
                                                                      
    stringBuffer.append(TEXT_40);
    
                                                                          }
                                                                          if(imetadataColumn.getPrecision() != null){
                                                                      
    stringBuffer.append(TEXT_41);
    stringBuffer.append( imetadataColumn.getPrecision());
    stringBuffer.append(TEXT_42);
    
                                                                          }else{
                                                                       
    stringBuffer.append(TEXT_43);
    
                                                                          }
                                                                           if(imetadataColumn.getDefault() != null && !"".equals(imetadataColumn.getDefault())){
                                                                      
    stringBuffer.append(TEXT_44);
    stringBuffer.append( imetadataColumn.getDefault() );
    stringBuffer.append(TEXT_45);
    
                                                                           }
                                                                            if(imetadataColumn.getComment() != null && !"".equals(imetadataColumn.getComment())){
                                                                      
    stringBuffer.append(TEXT_46);
    stringBuffer.append( imetadataColumn.getComment());
    stringBuffer.append(TEXT_47);
    
                                                                            }
                                                                      
    stringBuffer.append(TEXT_48);
    stringBuffer.append( imetadataColumn.isKey() );
    stringBuffer.append(TEXT_49);
    
                            }
            }
        }

        
    stringBuffer.append(TEXT_50);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_51);
    
                        if(autoGenerateMetadataDesc){
                            
    stringBuffer.append(TEXT_52);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_56);
    
                        }else{
                            
    stringBuffer.append(TEXT_57);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( nLines2Ingore );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( uniqueApiName );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( fullyQualifiedName );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( label );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( uniqueApiName );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( fullyQualifiedName );
    stringBuffer.append(TEXT_67);
    
                        }
                     
    
                              if("\"\\n\"".equals(linesTerminatedBy)){
                                    linesTerminatedBy = "\"\\\\n\"";
                              }else if("\"\\r\\n\"".equals(linesTerminatedBy)){
                                    linesTerminatedBy = "\"\\\\r\\\\n\"";
                              }else if("\"\\r\"".equals(linesTerminatedBy)){
                                    linesTerminatedBy = "\"\\\\r\"";
                              }else{
                                   linesTerminatedBy = "\"\\\\n\"";
                              }

                              if("\"\\\"\"".equals(fieldsEnclosedBy)){
                                   fieldsEnclosedBy = "\"\\\\\\\"\"";
                              }
                           
    stringBuffer.append(TEXT_68);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append( charsetName );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( fieldsDelimitedBy );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append( fieldsEnclosedBy );
    stringBuffer.append(TEXT_74);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append( linesTerminatedBy );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append( numericFormat );
    stringBuffer.append(TEXT_78);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append( csvPath );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( encoding );
    stringBuffer.append(TEXT_82);
    
                       if(generateJsonInFile){
                          
    stringBuffer.append(TEXT_83);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_86);
    
                       }
                     
    
}

    stringBuffer.append(TEXT_87);
    return stringBuffer.toString();
  }
}
