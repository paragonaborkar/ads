package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.NodeUtil;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TSalesforceWaveBulkExecMainJava
{
  protected static String nl;
  public static synchronized TSalesforceWaveBulkExecMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceWaveBulkExecMainJava result = new TSalesforceWaveBulkExecMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        //Step one: Connect to salesforce" + NL + "        com.sforce.ws.ConnectorConfig connectorConfig_";
  protected final String TEXT_3 = " = new com.sforce.ws.ConnectorConfig();";
  protected final String TEXT_4 = NL + "        \tObject sharedConn_";
  protected final String TEXT_5 = " = globalMap.get(\"";
  protected final String TEXT_6 = "\" + \"_Connection\");" + NL + "        \tif(sharedConn_";
  protected final String TEXT_7 = " != null){" + NL + "        \t\tif(sharedConn_";
  protected final String TEXT_8 = " instanceof com.sforce.soap.partner.PartnerConnection){" + NL + "        \t\t\tconnectorConfig_";
  protected final String TEXT_9 = " = ((com.sforce.soap.partner.PartnerConnection)sharedConn_";
  protected final String TEXT_10 = ").getConfig();" + NL + "        \t\t}else{" + NL + "        \t\t\tconnectorConfig_";
  protected final String TEXT_11 = " = ((com.sforce.async.BulkConnection)sharedConn_";
  protected final String TEXT_12 = ").getConfig();" + NL + "        \t\t}" + NL + "        \t\tconnectorConfig_";
  protected final String TEXT_13 = ".setManualLogin(true);" + NL + "        \t}else{" + NL + "        \t\tSystem.err.println(\"No connection available!\");" + NL + "        \t}";
  protected final String TEXT_14 = NL + "          \t";
  protected final String TEXT_15 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_16 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = "; ";
  protected final String TEXT_21 = NL + NL + "          \tconnectorConfig_";
  protected final String TEXT_22 = ".setUsername(";
  protected final String TEXT_23 = ");" + NL + "          \tconnectorConfig_";
  protected final String TEXT_24 = ".setPassword(decryptedPassword_";
  protected final String TEXT_25 = ");" + NL + "          \tconnectorConfig_";
  protected final String TEXT_26 = ".setAuthEndpoint(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + NL + "        com.sforce.soap.partner.PartnerConnection partnerConnection_";
  protected final String TEXT_29 = " = null;" + NL + "        try{" + NL + "            partnerConnection_";
  protected final String TEXT_30 = " = new com.sforce.soap.partner.PartnerConnection(connectorConfig_";
  protected final String TEXT_31 = ");" + NL + "        }catch(com.sforce.ws.ConnectionException e){" + NL + "            throw e;" + NL + "        }" + NL + "" + NL + "        //Step two: Config the upload" + NL + "        com.sforce.soap.partner.sobject.SObject sobject_";
  protected final String TEXT_32 = " = new com.sforce.soap.partner.sobject.SObject();" + NL + "        sobject_";
  protected final String TEXT_33 = ".setType(\"InsightsExternalData\");" + NL + "        sobject_";
  protected final String TEXT_34 = ".setField(\"Format\",\"CSV\");" + NL + "        sobject_";
  protected final String TEXT_35 = ".setField(\"EdgemartAlias\", ";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "//////////////////////////////////////// Compile Error //////////////////////////////////////////////////" + NL + "            datasetName can't be empty string or \"\"" + NL + "//////////////////////////////////////// Compile Error //////////////////////////////////////////////////";
  protected final String TEXT_38 = NL + "        if(!com.talend.salesforce.wave.SalesforceWaveHelper.isValidValue(";
  protected final String TEXT_39 = ")){" + NL + "             System.err.println(\"DatasetName is invalid,thus it may lead to upload failed.\");" + NL + "             System.err.println(\"Names can use only alpha-numeric or '_' characters\");" + NL + "        }";
  protected final String TEXT_40 = NL + "        byte[] metadataJsonInBytes_";
  protected final String TEXT_41 = " = null;";
  protected final String TEXT_42 = NL + "                    try{" + NL + "                        metadataJsonInBytes_";
  protected final String TEXT_43 = " = org.apache.commons.io.FileUtils.readFileToByteArray(new java.io.File(";
  protected final String TEXT_44 = "));" + NL + "                    }catch(IOException e){" + NL + "                            throw e;" + NL + "                    }";
  protected final String TEXT_45 = NL + "                    try{" + NL + "                        metadataJsonInBytes_";
  protected final String TEXT_46 = " = org.apache.commons.io.FileUtils.readFileToByteArray(new java.io.File(generateJsonMetadataPath_";
  protected final String TEXT_47 = "));" + NL + "                    }catch(IOException e){" + NL + "                            throw e;" + NL + "                    }";
  protected final String TEXT_48 = NL + "                        metadataJsonInBytes_";
  protected final String TEXT_49 = " = com.talend.salesforce.wave.SalesforceWaveHelper" + NL + "                                                            .generateJsonMetadata(" + NL + "                                                               null" + NL + "                                                               ,metadataColumnRuntimeList_";
  protected final String TEXT_50 = NL + "                                                               ,customConfig_";
  protected final String TEXT_51 = NL + "                                                            ).getBytes(";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "                       Unexcepted usecase.";
  protected final String TEXT_54 = NL + "            sobject_";
  protected final String TEXT_55 = ".setField(\"MetadataJson\", metadataJsonInBytes_";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "        sobject_";
  protected final String TEXT_58 = ".setField(\"Operation\",\"";
  protected final String TEXT_59 = "\");" + NL + "        sobject_";
  protected final String TEXT_60 = ".setField(\"Action\",\"None\");" + NL + "" + NL + "        com.sforce.soap.partner.SaveResult[] saveResultArr_";
  protected final String TEXT_61 = " = null;" + NL + "        String parentId_";
  protected final String TEXT_62 = " = null;" + NL + "        try{" + NL + "            saveResultArr_";
  protected final String TEXT_63 = " = partnerConnection_";
  protected final String TEXT_64 = ".create(" + NL + "                                                            new com.sforce.soap.partner.sobject.SObject[] { sobject_";
  protected final String TEXT_65 = " }" + NL + "                                                    );" + NL + "            for(com.sforce.soap.partner.SaveResult result: saveResultArr_";
  protected final String TEXT_66 = "){" + NL + "                if(result.isSuccess()){" + NL + "                    parentId_";
  protected final String TEXT_67 = " = result.getId();" + NL + "                }else{" + NL + "                    StringBuilder errMsg = new StringBuilder(\"Saving InsightsExternalData failed.\");";
  protected final String TEXT_68 = NL + "                             errMsg.append(\"There is something wrong with JSON metadata.\");";
  protected final String TEXT_69 = NL + "                    for(com.sforce.soap.partner.Error err: result.getErrors()){" + NL + "                            for(String fieldName: err.getFields()){" + NL + "                                errMsg.append(\"\\nThe errors come from the field: \");" + NL + "                                errMsg.append(fieldName);" + NL + "                                errMsg.append(\".\");" + NL + "                            }" + NL + "                                errMsg.append(\"\\n\");" + NL + "                                errMsg.append(err.getMessage());" + NL + "                                errMsg.append(\".\");" + NL + "                    }" + NL + "                    throw new RuntimeException(errMsg.toString());" + NL + "                }" + NL + "            }" + NL + "        }catch(com.sforce.ws.ConnectionException e){" + NL + "            throw e;" + NL + "        }" + NL + "" + NL + "        //Step three: add the data" + NL + "        java.io.File csvFile_";
  protected final String TEXT_70 = " = new java.io.File(";
  protected final String TEXT_71 = ");" + NL + "        if(csvFile_";
  protected final String TEXT_72 = ".isDirectory()){" + NL + "            throw new RuntimeException(\"Can't load directory,please spectify a CSV file.\");" + NL + "        }" + NL;
  protected final String TEXT_73 = NL + "        //Spilt file to 8 MB" + NL + "        List<java.io.File> splitFileList_";
  protected final String TEXT_74 = " = com.talend.io.FileUtils.splitFilePer8Mb(csvFile_";
  protected final String TEXT_75 = ",tempDirectory_";
  protected final String TEXT_76 = ");" + NL + "" + NL + "        for(int i=0,j=splitFileList_";
  protected final String TEXT_77 = ".size(); i < j; i++){" + NL + "            com.sforce.soap.partner.sobject.SObject sobject_for_";
  protected final String TEXT_78 = " = new com.sforce.soap.partner.sobject.SObject();" + NL + "            sobject_for_";
  protected final String TEXT_79 = ".setType(\"InsightsExternalDataPart\");" + NL + "            try{" + NL + "                sobject_for_";
  protected final String TEXT_80 = ".setField(\"DataFile\", org.apache.commons.io.FileUtils.readFileToByteArray(splitFileList_";
  protected final String TEXT_81 = ".get(i)));" + NL + "            }catch(java.io.IOException e){" + NL + "                throw e;" + NL + "            }" + NL + "            sobject_for_";
  protected final String TEXT_82 = ".setField(\"InsightsExternalDataId\", parentId_";
  protected final String TEXT_83 = ");" + NL + "            sobject_for_";
  protected final String TEXT_84 = ".setField(\"PartNumber\",i+1); //Part numbers should start at 1" + NL + "" + NL + "            com.sforce.soap.partner.SaveResult[] saveResultArr_for_";
  protected final String TEXT_85 = " = null;" + NL + "            String rowId_";
  protected final String TEXT_86 = " = null;" + NL + "            try{" + NL + "                saveResultArr_for_";
  protected final String TEXT_87 = " = partnerConnection_";
  protected final String TEXT_88 = ".create(" + NL + "                     new com.sforce.soap.partner.sobject.SObject[] { sobject_for_";
  protected final String TEXT_89 = " }" + NL + "               );" + NL + "" + NL + "               for(com.sforce.soap.partner.SaveResult result: saveResultArr_for_";
  protected final String TEXT_90 = "){" + NL + "                   if(result.isSuccess()){" + NL + "                       rowId_";
  protected final String TEXT_91 = " = result.getId();" + NL + "                   }else{" + NL + "                       StringBuilder errMsgBuilder = new StringBuilder(\"Digest file failed.\");" + NL + "                       for(com.sforce.soap.partner.Error err: result.getErrors()){" + NL + "                               for(String fieldName: err.getFields()){" + NL + "                                   errMsgBuilder.append(\"\\nThe errors come from the field: \");" + NL + "                                   errMsgBuilder.append(fieldName);" + NL + "                                   errMsgBuilder.append(\".\");" + NL + "                               }" + NL + "                                   errMsgBuilder.append(\"\\n\");" + NL + "                                   errMsgBuilder.append(err.getMessage());" + NL + "                                   errMsgBuilder.append(\".\");" + NL + "                       }" + NL + "                       throw new RuntimeException(errMsgBuilder.toString());" + NL + "                   }" + NL + "               }" + NL + "            }catch(com.sforce.ws.ConnectionException e){" + NL + "                throw e;" + NL + "            }" + NL + "        }";
  protected final String TEXT_92 = NL + "                   boolean hasNextChunk_";
  protected final String TEXT_93 = " = true;" + NL + "                   int index_";
  protected final String TEXT_94 = " = 0;" + NL + "                   while(hasNextChunk_";
  protected final String TEXT_95 = "){" + NL + "                        com.sforce.soap.partner.sobject.SObject sobject_for_";
  protected final String TEXT_96 = " = new com.sforce.soap.partner.sobject.SObject();" + NL + "                        sobject_for_";
  protected final String TEXT_97 = ".setType(\"InsightsExternalDataPart\");" + NL + "                        try{" + NL + "                            sobject_for_";
  protected final String TEXT_98 = ".setField(\"DataFile\",com.talend.io.FileUtils.readFilePer8Mb(csvFile_";
  protected final String TEXT_99 = ",index_";
  protected final String TEXT_100 = "));" + NL + "                        }catch(java.io.IOException e){" + NL + "                            hasNextChunk_";
  protected final String TEXT_101 = " = false;" + NL + "                        }" + NL + "                        if(!hasNextChunk_";
  protected final String TEXT_102 = "){" + NL + "                            break;" + NL + "                        }" + NL + "                        sobject_for_";
  protected final String TEXT_103 = ".setField(\"InsightsExternalDataId\", parentId_";
  protected final String TEXT_104 = ");" + NL + "                        sobject_for_";
  protected final String TEXT_105 = ".setField(\"PartNumber\",index_";
  protected final String TEXT_106 = "+1); //Part numbers should start at 1" + NL + "" + NL + "                        com.sforce.soap.partner.SaveResult[] saveResultArr_for_";
  protected final String TEXT_107 = " = null;" + NL + "                        String rowId_";
  protected final String TEXT_108 = " = null;" + NL + "                        try{" + NL + "                            saveResultArr_for_";
  protected final String TEXT_109 = " = partnerConnection_";
  protected final String TEXT_110 = ".create(" + NL + "                                 new com.sforce.soap.partner.sobject.SObject[] { sobject_for_";
  protected final String TEXT_111 = " }" + NL + "                           );" + NL + "" + NL + "                           for(com.sforce.soap.partner.SaveResult result: saveResultArr_for_";
  protected final String TEXT_112 = "){" + NL + "                               if(result.isSuccess()){" + NL + "                                   rowId_";
  protected final String TEXT_113 = " = result.getId();" + NL + "                               }else{" + NL + "                                       StringBuilder errMsgBuilder = new StringBuilder(\"Digest file failed.\");" + NL + "                                       for(com.sforce.soap.partner.Error err: result.getErrors()){" + NL + "                                               for(String fieldName: err.getFields()){" + NL + "                                                   errMsgBuilder.append(\"\\nThe errors come from the field: \");" + NL + "                                                   errMsgBuilder.append(fieldName);" + NL + "                                                   errMsgBuilder.append(\".\");" + NL + "                                               }" + NL + "                                                   errMsgBuilder.append(\"\\n\");" + NL + "                                                   errMsgBuilder.append(err.getMessage());" + NL + "                                                   errMsgBuilder.append(\".\");" + NL + "                                       }" + NL + "                                       throw new RuntimeException(errMsgBuilder.toString());" + NL + "                                    }" + NL + "                           }" + NL + "                        }catch(com.sforce.ws.ConnectionException e){" + NL + "                            throw e;" + NL + "                        }" + NL + "                        index_";
  protected final String TEXT_114 = " ++;" + NL + "                   }";
  protected final String TEXT_115 = NL + NL + "        //Step four: start to upload" + NL + "        com.sforce.soap.partner.sobject.SObject sobject4process_";
  protected final String TEXT_116 = " = new com.sforce.soap.partner.sobject.SObject();" + NL + "        sobject4process_";
  protected final String TEXT_117 = ".setType(\"InsightsExternalData\");" + NL + "        sobject4process_";
  protected final String TEXT_118 = ".setField(\"Action\",\"Process\");" + NL + "        sobject4process_";
  protected final String TEXT_119 = ".setId(parentId_";
  protected final String TEXT_120 = ");" + NL + "" + NL + "        com.sforce.soap.partner.SaveResult[] saveResultArr4Process_";
  protected final String TEXT_121 = " = null;" + NL + "        try{" + NL + "             saveResultArr4Process_";
  protected final String TEXT_122 = " = partnerConnection_";
  protected final String TEXT_123 = ".update(" + NL + "                        new com.sforce.soap.partner.sobject.SObject[] { sobject4process_";
  protected final String TEXT_124 = " }" + NL + "                );" + NL + "        for(com.sforce.soap.partner.SaveResult result: saveResultArr4Process_";
  protected final String TEXT_125 = "){" + NL + "            if(result.isSuccess()){" + NL + "                parentId_";
  protected final String TEXT_126 = " = result.getId();" + NL + "            }else{" + NL + "                StringBuilder errMsgBuilder = new StringBuilder(\"Upload file failed.\");" + NL + "                for(com.sforce.soap.partner.Error err: result.getErrors()){" + NL + "                        for(String fieldName: err.getFields()){" + NL + "                            errMsgBuilder.append(\"\\nThe errors come from the field: \");" + NL + "                            errMsgBuilder.append(fieldName);" + NL + "                            errMsgBuilder.append(\".\");" + NL + "                        }" + NL + "                            errMsgBuilder.append(\"\\n\");" + NL + "                            errMsgBuilder.append(err.getMessage());" + NL + "                            errMsgBuilder.append(\".\");" + NL + "                }" + NL + "                throw new RuntimeException(errMsgBuilder.toString());" + NL + "            }" + NL + "          }" + NL + "        }catch(com.sforce.ws.ConnectionException e){" + NL + "            throw e;" + NL + "        }" + NL;
  protected final String TEXT_127 = NL + "               //Step five: do clean work" + NL + "               for(java.io.File file: splitFileList_";
  protected final String TEXT_128 = "){" + NL + "                    if(file.exists()){" + NL + "                        if(!file.delete()){" + NL + "                            System.err.println(\"Can't remove the generated file: \" + file.getName());" + NL + "                        }" + NL + "                    }" + NL + "               }";
  protected final String TEXT_129 = NL + NL + "        com.sforce.soap.partner.sobject.SObject[] statusObjArr_";
  protected final String TEXT_130 = " = null;";
  protected final String TEXT_131 = NL + "                   int times2try_";
  protected final String TEXT_132 = " = 1;";
  protected final String TEXT_133 = NL + "                   int times2try_";
  protected final String TEXT_134 = " = Integer.valueOf(";
  protected final String TEXT_135 = ").intValue() / 10;";
  protected final String TEXT_136 = NL + "        String finalProcessStatus_";
  protected final String TEXT_137 = " = null;" + NL + "        try {" + NL + "            for (int i = 0; i < times2try_";
  protected final String TEXT_138 = "; i++ ){" + NL + "                 try{" + NL + "                      Thread.sleep(10000);" + NL + "                  }catch(Exception e){" + NL + "                      e.printStackTrace();" + NL + "                  }" + NL + "               statusObjArr_";
  protected final String TEXT_139 = " = partnerConnection_";
  protected final String TEXT_140 = ".retrieve(\"Status\"," + NL + "                                                                   sobject4process_";
  protected final String TEXT_141 = ".getType()," + NL + "                                                                   new String[] { sobject4process_";
  protected final String TEXT_142 = ".getId() });" + NL + "                for(com.sforce.soap.partner.sobject.SObject obj: statusObjArr_";
  protected final String TEXT_143 = "){" + NL + "                    finalProcessStatus_";
  protected final String TEXT_144 = " = (String)obj.getField(\"Status\");" + NL + "                }" + NL + "                if(\"Completed\".equalsIgnoreCase(finalProcessStatus_";
  protected final String TEXT_145 = ") || \"Failed\".equalsIgnoreCase(finalProcessStatus_";
  protected final String TEXT_146 = ")){" + NL + "                        break;" + NL + "                }" + NL + "            }" + NL + "        } catch (com.sforce.ws.ConnectionException e) {" + NL + "            throw e;" + NL + "        }" + NL + "" + NL + "        if(\"Failed\".equalsIgnoreCase(finalProcessStatus_";
  protected final String TEXT_147 = ")){" + NL + "            throw new RuntimeException(\"Upload CSV file failed.\");" + NL + "        } else if (!\"Completed\".equalsIgnoreCase(finalProcessStatus_";
  protected final String TEXT_148 = ")) {" + NL + "            System.out.println(\"The upload status is '\" + finalProcessStatus_";
  protected final String TEXT_149 = " + \"'.\");" + NL + "        }";
  protected final String TEXT_150 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    boolean useExistingConn = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    String userName = ElementParameterParser.getValue(node,"__USER__");
    String passwordFieldName = "__PASSWORD__";
    String endPoint = ElementParameterParser.getValue(node,"__ENDPOINT__");

    String datasetName = ElementParameterParser.getValue(node,"__DATASET__");
    String datasetOperation = ElementParameterParser.getValue(node,"__DATASET_OPERATION__");
    String csvDataPath = ElementParameterParser.getValue(node,"__LOAD_DATA_PATH__");

    String jsonMetadataPath = ElementParameterParser.getValue(node,"__JSON_METADATA_PATH__");
    boolean uploadJsonMetadata = "true".equals(ElementParameterParser.getValue(node,"__UPLODE_JSON_METADATA__"));
    boolean specifyJsonMetadata = "true".equals(ElementParameterParser.getValue(node,"__SPECIFY_JSON_METADATA__"));

    boolean generateJsonInFile = "true".equals(ElementParameterParser.getValue(node,"__GENERATE_JSON_IN_FILE__"));
    boolean doCleanWork = generateJsonInFile && !specifyJsonMetadata;

    String encoding = "UTF-8";
    String charsetName = ElementParameterParser.getValue(node,"__CHARSET__");
    if(charsetName != null && !"".equals(charsetName) && !"\"\"".equals(charsetName)){
           encoding = charsetName;
    }

    boolean retrieveUploadStatus = "true".equals(ElementParameterParser.getValue(node,"__RETRIEVE_UPLOAD_STATUS__"));
    String seconds2getStatus = ElementParameterParser.getValue(node,"__SECONDS_TO_WAIT_FOR_SERVER_ANSWER__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_3);
    
        if(useExistingConn){
        
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( connection );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_13);
    
        }else{
        
    stringBuffer.append(TEXT_14);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_17);
    } else {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( userName );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append( endPoint );
    stringBuffer.append(TEXT_27);
    
        }
        
    stringBuffer.append(TEXT_28);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( datasetName );
    stringBuffer.append(TEXT_36);
    
          if("".equals(datasetName) || "\"\"".equals(datasetName)){
             
    stringBuffer.append(TEXT_37);
    
          }
         
    stringBuffer.append(TEXT_38);
    stringBuffer.append( datasetName );
    stringBuffer.append(TEXT_39);
    
          if(uploadJsonMetadata){
        
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_41);
    
                if(specifyJsonMetadata){
                     
    stringBuffer.append(TEXT_42);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append( jsonMetadataPath );
    stringBuffer.append(TEXT_44);
    
                }else if(!specifyJsonMetadata && generateJsonInFile){
                     
    stringBuffer.append(TEXT_45);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_47);
    
                }else if(!specifyJsonMetadata && !generateJsonInFile){//Generate JSON Metadata in Memory
                     
    stringBuffer.append(TEXT_48);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( encoding );
    stringBuffer.append(TEXT_52);
    
                }else{
                    
    stringBuffer.append(TEXT_53);
    
                }
             
    stringBuffer.append(TEXT_54);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_56);
    
            }
         
    stringBuffer.append(TEXT_57);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( datasetOperation );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_67);
    
                      if(uploadJsonMetadata){
                          
    stringBuffer.append(TEXT_68);
    
                      }
                     
    stringBuffer.append(TEXT_69);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( csvDataPath );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_72);
    
           if(generateJsonInFile && !specifyJsonMetadata){
                
    stringBuffer.append(TEXT_73);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_91);
    
           }else{
                //read from memory
                
    stringBuffer.append(TEXT_92);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_114);
    
           }
         
    stringBuffer.append(TEXT_115);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_126);
    
        if(doCleanWork){
            
    stringBuffer.append(TEXT_127);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_128);
    
        }
     
    stringBuffer.append(TEXT_129);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_130);
    
           if(!retrieveUploadStatus){
                
    stringBuffer.append(TEXT_131);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_132);
    
           }else{
                
    stringBuffer.append(TEXT_133);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append( seconds2getStatus );
    stringBuffer.append(TEXT_135);
    
          }
         
    stringBuffer.append(TEXT_136);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    return stringBuffer.toString();
  }
}
