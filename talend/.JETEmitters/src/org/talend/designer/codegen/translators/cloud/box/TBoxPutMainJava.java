package org.talend.designer.codegen.translators.cloud.box;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TBoxPutMainJava
{
  protected static String nl;
  public static synchronized TBoxPutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBoxPutMainJava result = new TBoxPutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + NL + "\t";
  protected final String TEXT_32 = NL + "\t\tString ";
  protected final String TEXT_33 = "_remotePath = normalizePath(";
  protected final String TEXT_34 = ");" + NL + "\t\t" + NL + "\t\tif(";
  protected final String TEXT_35 = "_remotePath == null || \"\".equals(";
  protected final String TEXT_36 = "_remotePath.trim()))" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"The Box remote path can't be null\");" + NL + "\t\t}" + NL + "\t\tString ";
  protected final String TEXT_37 = "_remoteName = getFolderFromPath(";
  protected final String TEXT_38 = "_remotePath);" + NL + "\t\tObject ";
  protected final String TEXT_39 = "_content = ";
  protected final String TEXT_40 = ".content;" + NL + "\t\tjava.io.InputStream ";
  protected final String TEXT_41 = "_InputStream = null;" + NL + "\t\ttry" + NL + "\t\t{" + NL + "\t\t\tif(";
  protected final String TEXT_42 = "_content == null){" + NL + "\t\t\t\tthrow new Exception(\"The Uploaded Box file Content can't be null\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_43 = "_content instanceof byte[]){" + NL + "\t\t\t\t";
  protected final String TEXT_44 = "_InputStream = new java.io.ByteArrayInputStream((byte[])";
  protected final String TEXT_45 = "_content);" + NL + "\t\t\t}else if(";
  protected final String TEXT_46 = "_content instanceof java.io.InputStream){" + NL + "\t\t\t\t";
  protected final String TEXT_47 = "_InputStream = (java.io.InputStream)";
  protected final String TEXT_48 = "_content;" + NL + "\t\t\t}else{" + NL + "\t\t\t\t";
  protected final String TEXT_49 = "_InputStream = new java.io.ByteArrayInputStream(";
  protected final String TEXT_50 = "_content.toString().getBytes());" + NL + "\t\t\t}" + NL + "\t\t\tcom.box.restclientv2.requestsbase.BoxDefaultRequestObject ";
  protected final String TEXT_51 = "_requestObject = new com.box.restclientv2.requestsbase.BoxDefaultRequestObject();" + NL + "\t\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_52 = "_remotePath.equals(\"All Files\"))" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_53 = "_boxFolder = ";
  protected final String TEXT_54 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "\t\t\t}" + NL + "\t\t\telse" + NL + "\t\t\t{" + NL + "\t\t\t\tif (";
  protected final String TEXT_55 = "_remotePath.startsWith(\"All Files\"))" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\t";
  protected final String TEXT_56 = "_boxFolder = ";
  protected final String TEXT_57 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "\t\t\t\t}" + NL + "\t\t\t\telse" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tthrow new Exception(\"Remote path should start with \" + \"\\\"\" + \"All Files\" + \"\\\"\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_58 = "_boxFolder = createSubDirectories(";
  protected final String TEXT_59 = "_client, ";
  protected final String TEXT_60 = "_boxFolder, ";
  protected final String TEXT_61 = "_remotePath.substring(\"All Files/\".length(), ";
  protected final String TEXT_62 = "_remotePath.length() - ";
  protected final String TEXT_63 = "_remoteName.length()));" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif (";
  protected final String TEXT_64 = "_boxFolder == null)" + NL + "\t\t\t\tthrow new Exception(\"No destination folder found under path \" + ";
  protected final String TEXT_65 = "_remotePath);" + NL + "\t\t\tcom.box.restclientv2.requestsbase.BoxFileUploadRequestObject ";
  protected final String TEXT_66 = "_fileUploadObj = com.box.restclientv2.requestsbase.BoxFileUploadRequestObject.uploadFileRequestObject(";
  protected final String TEXT_67 = "_boxFolder.getId(), ";
  protected final String TEXT_68 = "_remoteName, ";
  protected final String TEXT_69 = "_InputStream);" + NL + "\t\t\tboolean ";
  protected final String TEXT_70 = "_exists = false;" + NL + "\t\t\tString ";
  protected final String TEXT_71 = "_fileId = null;" + NL + "\t        for (com.box.boxjavalibv2.dao.BoxTypedObject obj : ";
  protected final String TEXT_72 = "_boxFolder.getItemCollection().getEntries())" + NL + "\t        {" + NL + "\t        \tif (obj.getType().equals(\"file\") && obj.getValue(\"name\").equals(";
  protected final String TEXT_73 = "_remoteName))" + NL + "\t        \t{" + NL + "\t        \t\t";
  protected final String TEXT_74 = "_exists = true;" + NL + "\t        \t\t";
  protected final String TEXT_75 = "_fileId = obj.getId();" + NL + "\t        \t\tbreak;" + NL + "\t        \t}" + NL + "\t        }" + NL + "\t        if (";
  protected final String TEXT_76 = "_exists)" + NL + "\t        {" + NL + "\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\t";
  protected final String TEXT_78 = "_client.getFilesManager().deleteFile(";
  protected final String TEXT_79 = "_fileId, null);" + NL + "\t\t\t\t\t";
  protected final String TEXT_80 = "_boxFile = ";
  protected final String TEXT_81 = "_client.getFilesManager().uploadFile(";
  protected final String TEXT_82 = "_fileUploadObj);" + NL + "\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t\tthrow new Exception(\"File with the same name already exist\");" + NL + "\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t}" + NL + "\t\t\telse" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_85 = "_boxFile = ";
  protected final String TEXT_86 = "_client.getFilesManager().uploadFile(";
  protected final String TEXT_87 = "_fileUploadObj);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t";
  protected final String TEXT_89 = ".content = ";
  protected final String TEXT_90 = "_content;" + NL + "\t\t\t";
  protected final String TEXT_91 = NL + "\t\t}" + NL + "\t\tfinally {" + NL + "\t\t\tif (";
  protected final String TEXT_92 = "_InputStream != null)" + NL + "\t\t\t\t";
  protected final String TEXT_93 = "_InputStream.close();" + NL + "\t\t}";
  protected final String TEXT_94 = "\t" + NL + "\tString ";
  protected final String TEXT_95 = "_remotePath = normalizePath(";
  protected final String TEXT_96 = ");" + NL + "\t" + NL + "\tif(";
  protected final String TEXT_97 = "_remotePath == null || \"\".equals(";
  protected final String TEXT_98 = "_remotePath.trim()))" + NL + "\t{" + NL + "\t\tthrow new Exception(\"The Box remote path can't be null\");" + NL + "\t}" + NL + "\tString ";
  protected final String TEXT_99 = "_remoteName = getFolderFromPath(";
  protected final String TEXT_100 = "_remotePath);" + NL + "\tjava.io.InputStream ";
  protected final String TEXT_101 = "_InputStream = null;" + NL + "\tjava.nio.file.Path ";
  protected final String TEXT_102 = "_path = java.nio.file.FileSystems.getDefault().getPath(";
  protected final String TEXT_103 = "," + NL + "                new String[] {});" + NL + "\tjava.io.File ";
  protected final String TEXT_104 = "_fileToUpload = ";
  protected final String TEXT_105 = "_path.toFile();" + NL + "\tif(!";
  protected final String TEXT_106 = "_fileToUpload.exists())" + NL + "\t{" + NL + "\t\tthrow new Exception(\"Can not find file at \" + ";
  protected final String TEXT_107 = "_path.toString());" + NL + "\t}" + NL + "\tif(";
  protected final String TEXT_108 = "_fileToUpload.isDirectory())" + NL + "\t{" + NL + "\t\tthrow new Exception(\"The specified path is a directory (file expected)\");" + NL + "\t}" + NL + "\t";
  protected final String TEXT_109 = "_InputStream = new java.io.FileInputStream(";
  protected final String TEXT_110 = "_fileToUpload);" + NL + "\tif(";
  protected final String TEXT_111 = "_remotePath.equals(\"All Files\"))" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_112 = "_boxFolder = ";
  protected final String TEXT_113 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "\t}" + NL + "\telse" + NL + "\t{" + NL + "\t\tif (";
  protected final String TEXT_114 = "_remotePath.startsWith(\"All Files\"))" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_115 = "_boxFolder = ";
  protected final String TEXT_116 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"Remote path should start with \" + \"\\\"\" + \"All Files\" + \"\\\"\");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_117 = "_boxFolder = createSubDirectories(";
  protected final String TEXT_118 = "_client, ";
  protected final String TEXT_119 = "_boxFolder, ";
  protected final String TEXT_120 = "_remotePath.substring(\"All Files/\".length(), ";
  protected final String TEXT_121 = "_remotePath.length() - ";
  protected final String TEXT_122 = "_remoteName.length()));" + NL + "\t}" + NL + "\tif (";
  protected final String TEXT_123 = "_boxFolder == null)" + NL + "\t\tthrow new Exception(\"No destination folder found under path \" + ";
  protected final String TEXT_124 = "_remotePath);" + NL + "\tcom.box.restclientv2.requestsbase.BoxFileUploadRequestObject ";
  protected final String TEXT_125 = "_fileUploadObj = com.box.restclientv2.requestsbase.BoxFileUploadRequestObject.uploadFileRequestObject(";
  protected final String TEXT_126 = "_boxFolder.getId(), ";
  protected final String TEXT_127 = "_remoteName, ";
  protected final String TEXT_128 = "_InputStream);" + NL + "\tboolean ";
  protected final String TEXT_129 = "_exists = false;" + NL + "\tString ";
  protected final String TEXT_130 = "_fileId = null;" + NL + "    for (com.box.boxjavalibv2.dao.BoxTypedObject obj : ";
  protected final String TEXT_131 = "_boxFolder.getItemCollection().getEntries())" + NL + "    {" + NL + "    \tif (obj.getType().equals(\"file\") && obj.getValue(\"name\").equals(";
  protected final String TEXT_132 = "_remoteName))" + NL + "    \t{" + NL + "    \t\t";
  protected final String TEXT_133 = "_exists = true;" + NL + "    \t\t";
  protected final String TEXT_134 = "_fileId = obj.getId();" + NL + "    \t\tbreak;" + NL + "    \t}" + NL + "    }" + NL + "    if (";
  protected final String TEXT_135 = "_exists)" + NL + "    {" + NL + "\t\t";
  protected final String TEXT_136 = NL + "\t\t\t";
  protected final String TEXT_137 = "_client.getFilesManager().deleteFile(";
  protected final String TEXT_138 = "_fileId, null);" + NL + "\t\t\t";
  protected final String TEXT_139 = "_boxFile = ";
  protected final String TEXT_140 = "_client.getFilesManager().uploadFile(";
  protected final String TEXT_141 = "_fileUploadObj);" + NL + "\t\t";
  protected final String TEXT_142 = NL + "\t\t\tthrow new Exception(\"File with the same name already exist\");" + NL + "\t\t";
  protected final String TEXT_143 = NL + "\t}" + NL + "\telse" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_144 = "_boxFile = ";
  protected final String TEXT_145 = "_client.getFilesManager().uploadFile(";
  protected final String TEXT_146 = "_fileUploadObj);" + NL + "\t}" + NL + "\t";
  protected final String TEXT_147 = NL + "\t";
  protected final String TEXT_148 = ".content = ";
  protected final String TEXT_149 = "_InputStream;" + NL + "\t";
  protected final String TEXT_150 = NL + "\tString ";
  protected final String TEXT_151 = "_filePath = normalizePath(";
  protected final String TEXT_152 = ");" + NL + "\tString ";
  protected final String TEXT_153 = "_remotePath = normalizePath(";
  protected final String TEXT_154 = ");" + NL + "\t" + NL + "\tif(";
  protected final String TEXT_155 = "_remotePath == null || \"\".equals(";
  protected final String TEXT_156 = "_remotePath.trim()))" + NL + "\t{" + NL + "\t\tthrow new Exception(\"The Box remote path can't be null\");" + NL + "\t}" + NL + "\tString ";
  protected final String TEXT_157 = "_remoteName = getFolderFromPath(";
  protected final String TEXT_158 = "_remotePath);" + NL + "\tif(";
  protected final String TEXT_159 = "_remoteName == null || ";
  protected final String TEXT_160 = "_remoteName.isEmpty())" + NL + "\t{" + NL + "\t\tthrow new Exception(\"File name can not be empty\");" + NL + "\t}" + NL + "\t";
  protected final String TEXT_161 = "_uploader_input = new java.io.ByteArrayInputStream(";
  protected final String TEXT_162 = "_uploader_output.toByteArray());" + NL + "\tif(";
  protected final String TEXT_163 = "_remotePath.equals(\"All Files\"))" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_164 = "_boxFolder = ";
  protected final String TEXT_165 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "\t}" + NL + "\telse" + NL + "\t{" + NL + "\t\tif (";
  protected final String TEXT_166 = "_remotePath.startsWith(\"All Files\"))" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_167 = "_boxFolder = ";
  protected final String TEXT_168 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"Remote path should start with \" + \"\\\"\" + \"All Files\" + \"\\\"\");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_169 = "_boxFolder = createSubDirectories(";
  protected final String TEXT_170 = "_client, ";
  protected final String TEXT_171 = "_boxFolder, ";
  protected final String TEXT_172 = "_remotePath.substring(\"All Files/\".length(), ";
  protected final String TEXT_173 = "_remotePath.length() - ";
  protected final String TEXT_174 = "_remoteName.length()));" + NL + "\t}" + NL + "\t\t" + NL + "\tif (";
  protected final String TEXT_175 = "_boxFolder == null)" + NL + "\t\tthrow new Exception(\"No destination folder found under path \" + ";
  protected final String TEXT_176 = "_remotePath);" + NL + "\tcom.box.restclientv2.requestsbase.BoxFileUploadRequestObject ";
  protected final String TEXT_177 = "_fileUploadObj = com.box.restclientv2.requestsbase.BoxFileUploadRequestObject.uploadFileRequestObject(";
  protected final String TEXT_178 = "_boxFolder.getId(), ";
  protected final String TEXT_179 = "_remoteName, ";
  protected final String TEXT_180 = "_uploader_input);" + NL + "\tboolean ";
  protected final String TEXT_181 = "_exists = false;" + NL + "\tString ";
  protected final String TEXT_182 = "_fileId = null;" + NL + "\tfor (com.box.boxjavalibv2.dao.BoxTypedObject obj : ";
  protected final String TEXT_183 = "_boxFolder.getItemCollection().getEntries())" + NL + "    {" + NL + "    \tif (obj.getType().equals(\"file\") && obj.getValue(\"name\").equals(";
  protected final String TEXT_184 = "_remoteName))" + NL + "    \t{" + NL + "    \t\t";
  protected final String TEXT_185 = "_exists = true;" + NL + "    \t\t";
  protected final String TEXT_186 = "_fileId = obj.getId();" + NL + "    \t\tbreak;" + NL + "    \t}" + NL + "    }" + NL + "    if (";
  protected final String TEXT_187 = "_exists)" + NL + "    {" + NL + "\t\t";
  protected final String TEXT_188 = NL + "\t\t\t";
  protected final String TEXT_189 = "_client.getFilesManager().deleteFile(";
  protected final String TEXT_190 = "_fileId, null);" + NL + "\t\t\t";
  protected final String TEXT_191 = "_boxFile = ";
  protected final String TEXT_192 = "_client.getFilesManager().uploadFile(";
  protected final String TEXT_193 = "_fileUploadObj);" + NL + "\t\t";
  protected final String TEXT_194 = NL + "\t\t\tthrow new Exception(\"File with the same name already exist\");" + NL + "\t\t";
  protected final String TEXT_195 = NL + "\t}" + NL + "\telse" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_196 = "_boxFile = ";
  protected final String TEXT_197 = "_client.getFilesManager().uploadFile(";
  protected final String TEXT_198 = "_fileUploadObj);" + NL + "\t}" + NL + "\tif (";
  protected final String TEXT_199 = "_uploader_input != null) {" + NL + "\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_200 = "_uploader_input.close();" + NL + "\t\t} catch (IOException e)" + NL + "\t\t{" + NL + "\t\t}" + NL + "\t}" + NL + "\tif (";
  protected final String TEXT_201 = "_uploader_output != null) {" + NL + "\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_202 = "_uploader_output.close();" + NL + "\t\t} catch (IOException e)" + NL + "\t\t{" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_203 = "_uploader_output = new java.io.ByteArrayOutputStream();" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_204 = "_OUTPUTSTREAM\", ";
  protected final String TEXT_205 = "_uploader_output);";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		
		String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		String accessToken = ElementParameterParser.getValue(node, "__ACCESS_TOKEN__");
		String refreshToken = ElementParameterParser.getValue(node, "__REFRESH_TOKEN__");
		
		String clientId = ElementParameterParser.getValue(node, "__CLIENT_ID__");
		String clientSecret = ElementParameterParser.getValue(node, "__CLIENT_SECRET__");
		
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	    String connectionKey = "\"conn_" + connection+"\"";
		
		String boxPath = ElementParameterParser.getValue(node, "__PATH__");
		String filePath = ElementParameterParser.getValue(node, "__FILE_PATH__");
		String fileName = ElementParameterParser.getValue(node, "__FILE_NAME__");
		String exposeOutput = ElementParameterParser.getValue(node, "__EXPOSE_OUTPUT_STREAM__");
		String uploadLocalFile = ElementParameterParser.getValue(node, "__UPLOAD_LOCAL_FILE__");
		String readContentFromInput = ElementParameterParser.getValue(node, "__READ_CONTENT_FROM_INPUT__");
		String overwrite = ElementParameterParser.getValue(node, "__REPLACE_IF_EXIST__");
		
		final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		
		String dataInputConnection = null;
        String dataOutputConnection = null;
        
        List< ? extends IConnection> inputConnections = node.getIncomingConnections();
	    for(IConnection conn : inputConnections) {
	        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	dataInputConnection = conn.getName();
	        	break;
	        } // if(conn) end
	    } // for(conns) end
	    
	    
		List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
	    for(IConnection conn : outputConnections) {
	        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	dataOutputConnection = conn.getName();
	        	break;
	        } // if(conn) end
	    } // for(conns) end

    stringBuffer.append(TEXT_30);
    if("true".equals(readContentFromInput)){
    stringBuffer.append(TEXT_31);
    if(dataInputConnection != null)
	{
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(boxPath);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(dataInputConnection);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
     if ("true".equals(overwrite))
				{ 
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    } else {
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    if(dataOutputConnection != null){
    stringBuffer.append(TEXT_88);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
	} 

    
} else if ("true".equals(uploadLocalFile)) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(boxPath);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(filePath);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
     if ("true".equals(overwrite))
		{ 
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    } else {
    stringBuffer.append(TEXT_142);
    }
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    if(dataOutputConnection != null) {
    stringBuffer.append(TEXT_147);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    }
    } else if("true".equals(exposeOutput)) {
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(filePath);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(boxPath);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
     if ("true".equals(overwrite))
		{ 
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    } else {
    stringBuffer.append(TEXT_194);
    }
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    }
    return stringBuffer.toString();
  }
}
