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

public class TBoxCopyMainJava
{
  protected static String nl;
  public static synchronized TBoxCopyMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBoxCopyMainJava result = new TBoxCopyMainJava();
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
  protected final String TEXT_30 = NL + NL + "\tString ";
  protected final String TEXT_31 = "_filePath = normalizePath(";
  protected final String TEXT_32 = ");" + NL + "\tboolean ";
  protected final String TEXT_33 = "_hasError = false;" + NL + "\tString ";
  protected final String TEXT_34 = "_fileName = getFolderFromPath(";
  protected final String TEXT_35 = "_filePath);" + NL + "\tString ";
  protected final String TEXT_36 = "_destinationFolderPath = normalizePath(";
  protected final String TEXT_37 = ");" + NL + "\tString ";
  protected final String TEXT_38 = "_destinationFolderName = getFolderFromPath(";
  protected final String TEXT_39 = "_destinationFolderPath);" + NL + "\tcom.box.boxjavalibv2.dao.BoxFile ";
  protected final String TEXT_40 = "_boxFile = null;" + NL + "\tcom.box.boxjavalibv2.dao.BoxFile ";
  protected final String TEXT_41 = "_boxFileNew = null;" + NL + "\tcom.box.boxjavalibv2.dao.BoxFolder ";
  protected final String TEXT_42 = "_boxFolderTo = null;" + NL + "\tcom.box.boxjavalibv2.dao.BoxFolder ";
  protected final String TEXT_43 = "_boxFolderFrom = null;" + NL + "\tcom.box.restclientv2.requestsbase.BoxDefaultRequestObject ";
  protected final String TEXT_44 = "_requestObject = new com.box.restclientv2.requestsbase.BoxDefaultRequestObject();" + NL + "" + NL + "\t";
  protected final String TEXT_45 = "_boxFolderTo = ";
  protected final String TEXT_46 = "_client.getFoldersManager().getFolder(\"0\", ";
  protected final String TEXT_47 = "_requestObject);" + NL + "\t" + NL + "\tList<String> ";
  protected final String TEXT_48 = "_paths = new java.util.ArrayList<String>(java.util.Arrays.asList(";
  protected final String TEXT_49 = "_destinationFolderPath.split(\"/\")));" + NL + "\t";
  protected final String TEXT_50 = "_boxFolderTo = getBoxFolderRecursively(";
  protected final String TEXT_51 = "_paths, ";
  protected final String TEXT_52 = "_boxFolderTo, ";
  protected final String TEXT_53 = "_client);" + NL + "\tif (";
  protected final String TEXT_54 = "_boxFolderTo == null)" + NL + "\t\tthrow new Exception(\"No destination folder found under path \" + ";
  protected final String TEXT_55 = "_destinationFolderPath);";
  protected final String TEXT_56 = NL + "\t\tString ";
  protected final String TEXT_57 = "_sourceFolderPath = normalizePath(";
  protected final String TEXT_58 = ");" + NL + "\t\tString ";
  protected final String TEXT_59 = "_sourceFolderName = getFolderFromPath(";
  protected final String TEXT_60 = "_sourceFolderPath);" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_61 = "_boxFolderFrom = ";
  protected final String TEXT_62 = "_client.getFoldersManager().getFolder(\"0\", ";
  protected final String TEXT_63 = "_requestObject);" + NL + "\t";
  protected final String TEXT_64 = NL + "        ";
  protected final String TEXT_65 = "_paths = new java.util.ArrayList<String>(java.util.Arrays.asList(";
  protected final String TEXT_66 = "_sourceFolderPath.split(\"/\")));";
  protected final String TEXT_67 = NL + "        ";
  protected final String TEXT_68 = "_boxFolderFrom = getBoxFolderRecursively(";
  protected final String TEXT_69 = "_paths, ";
  protected final String TEXT_70 = "_boxFolderFrom, ";
  protected final String TEXT_71 = "_client);" + NL + "        " + NL + "\t\tcom.box.boxjavalibv2.dao.BoxCollection ";
  protected final String TEXT_72 = "_searchResults = ";
  protected final String TEXT_73 = "_boxFolderFrom.getItemCollection();" + NL + "\t\t\tif (";
  protected final String TEXT_74 = "_boxFolderFrom == null)" + NL + "\t\t\t\tthrow new Exception(\"No source folder found under path \" + ";
  protected final String TEXT_75 = "_sourceFolderPath);" + NL + "\t\t\telse if (";
  protected final String TEXT_76 = "_boxFolderTo != null && ";
  protected final String TEXT_77 = "_boxFolderFrom != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\tcom.box.boxjavalibv2.requests.requestobjects.BoxFolderRequestObject ";
  protected final String TEXT_79 = "_fRequest = com.box.boxjavalibv2.requests.requestobjects.BoxFolderRequestObject.createFolderRequestObject(";
  protected final String TEXT_80 = "_boxFolderFrom.getName(), ";
  protected final String TEXT_81 = "_boxFolderTo.getId());" + NL + "        \t\t";
  protected final String TEXT_82 = "_boxFolderFrom = ";
  protected final String TEXT_83 = "_client.getFoldersManager().updateFolderInfo(";
  protected final String TEXT_84 = "_boxFolderFrom.getId(), ";
  protected final String TEXT_85 = "_fRequest);" + NL + "        \t\t";
  protected final String TEXT_86 = NL + "        \t\tcom.box.boxjavalibv2.requests.requestobjects.BoxItemCopyRequestObject ";
  protected final String TEXT_87 = "_copyObj = com.box.boxjavalibv2.requests.requestobjects.BoxItemCopyRequestObject.copyItemRequestObject(";
  protected final String TEXT_88 = "_boxFolderTo.getId());" + NL + "        \t\tcom.box.boxjavalibv2.dao.BoxFolder ";
  protected final String TEXT_89 = "_copiedFolder = ";
  protected final String TEXT_90 = "_client.getFoldersManager().copyFolder(";
  protected final String TEXT_91 = "_boxFolderFrom.getId(), ";
  protected final String TEXT_92 = "_copyObj);" + NL + "        \t\t";
  protected final String TEXT_93 = NL + "        \t\tString ";
  protected final String TEXT_94 = "_newFolderName = ";
  protected final String TEXT_95 = ";" + NL + "        \t\tif(";
  protected final String TEXT_96 = "_newFolderName == null || ";
  protected final String TEXT_97 = "_newFolderName.isEmpty())" + NL + "        \t\t{" + NL + "        \t\t\tthrow new Exception(\"New folder name can not be empty\");" + NL + "        \t\t}" + NL + "        \t\tcom.box.boxjavalibv2.requests.requestobjects.BoxFolderRequestObject ";
  protected final String TEXT_98 = "_rObj = com.box.boxjavalibv2.requests.requestobjects.BoxFolderRequestObject.createFolderRequestObject(";
  protected final String TEXT_99 = "_newFolderName, ";
  protected final String TEXT_100 = "_copiedFolder.getParent().getId());" + NL + "        \t\t";
  protected final String TEXT_101 = "_client.getFoldersManager().updateFolderInfo(";
  protected final String TEXT_102 = "_copiedFolder.getId(), ";
  protected final String TEXT_103 = "_rObj);" + NL + "        \t\t";
  protected final String TEXT_104 = NL + "\t\t\t}";
  protected final String TEXT_105 = NL + "\t\tcom.box.boxjavalibv2.dao.BoxFolder ";
  protected final String TEXT_106 = "_folder = ";
  protected final String TEXT_107 = "_client.getFoldersManager().getFolder(\"0\", ";
  protected final String TEXT_108 = "_requestObject);" + NL + "\t\t";
  protected final String TEXT_109 = "_paths = new java.util.ArrayList<String>(java.util.Arrays.asList(";
  protected final String TEXT_110 = "_filePath.substring(0, ";
  protected final String TEXT_111 = "_filePath.length() - ";
  protected final String TEXT_112 = "_fileName.length()).split(\"/\")));" + NL + "\t\t";
  protected final String TEXT_113 = "_folder = getBoxFolderRecursively(";
  protected final String TEXT_114 = "_paths, ";
  protected final String TEXT_115 = "_folder, ";
  protected final String TEXT_116 = "_client);" + NL + "\t\tcom.box.boxjavalibv2.dao.BoxCollection ";
  protected final String TEXT_117 = "_searchResults = ";
  protected final String TEXT_118 = "_folder.getItemCollection();" + NL + " \t\tfor (com.box.boxjavalibv2.dao.BoxTypedObject ";
  protected final String TEXT_119 = "_entry : ";
  protected final String TEXT_120 = "_searchResults.getEntries())" + NL + " \t\t{" + NL + " \t\t\tif(";
  protected final String TEXT_121 = "_entry.getValue(\"name\").equals(";
  protected final String TEXT_122 = "_fileName) && \"file\".equals(";
  protected final String TEXT_123 = "_entry.getType())) {" + NL + " \t\t\t\t";
  protected final String TEXT_124 = "_boxFile = ";
  protected final String TEXT_125 = "_client.getFilesManager().getFile(";
  protected final String TEXT_126 = "_entry.getId(),null);" + NL + " \t\t\t\tbreak;" + NL + " \t\t\t}" + NL + " \t\t}" + NL + "\t\tif (";
  protected final String TEXT_127 = "_boxFile == null)" + NL + "\t\t\tthrow new Exception(\"No file found with path \" + ";
  protected final String TEXT_128 = "_filePath);" + NL + "\t\t" + NL + "\t\tif (";
  protected final String TEXT_129 = "_boxFolderTo != null)" + NL + "\t\t{" + NL + "\t\t\t\tString ";
  protected final String TEXT_130 = "_boxFilePath = getBoxItemPath(";
  protected final String TEXT_131 = "_boxFile);" + NL + "\t\t\t\t// Check for not to copy in the same directory" + NL + "\t\t\t\tif(!getBoxItemPath(";
  protected final String TEXT_132 = "_boxFile).equals(getBoxItemPath(";
  protected final String TEXT_133 = "_boxFolderTo) + ";
  protected final String TEXT_134 = "_boxFolderTo.getName()))" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tcom.box.boxjavalibv2.requests.requestobjects.BoxItemCopyRequestObject ";
  protected final String TEXT_135 = "_copyObject = com.box.boxjavalibv2.requests.requestobjects.BoxItemCopyRequestObject.copyItemRequestObject(";
  protected final String TEXT_136 = "_boxFolderTo.getId());" + NL + "\t\t    \t\t";
  protected final String TEXT_137 = "_boxFileNew = ";
  protected final String TEXT_138 = "_client.getFilesManager().copyFile(";
  protected final String TEXT_139 = "_boxFile.getId(), ";
  protected final String TEXT_140 = "_copyObject);";
  protected final String TEXT_141 = NL + "\t\t\t\t\t";
  protected final String TEXT_142 = "_client.getFilesManager().deleteFile(";
  protected final String TEXT_143 = "_boxFile.getId(), null);";
  protected final String TEXT_144 = NL + "\t\t    \t}";
  protected final String TEXT_145 = NL + "\t\t\t\tcom.box.boxjavalibv2.requests.requestobjects.BoxFileRequestObject ";
  protected final String TEXT_146 = "_fileRequestObject = new com.box.boxjavalibv2.requests.requestobjects.BoxFileRequestObject();" + NL + "        \t\t";
  protected final String TEXT_147 = "_fileRequestObject.setName(";
  protected final String TEXT_148 = ");" + NL + "        \t\tif (";
  protected final String TEXT_149 = "_boxFileNew != null)" + NL + "        \t\t\t";
  protected final String TEXT_150 = "_boxFileNew = ";
  protected final String TEXT_151 = "_client.getFilesManager().updateFileInfo(";
  protected final String TEXT_152 = "_boxFileNew.getId(), ";
  protected final String TEXT_153 = "_fileRequestObject);" + NL + "        \t\telse" + NL + "        \t\t\t";
  protected final String TEXT_154 = "_boxFileNew = ";
  protected final String TEXT_155 = "_client.getFilesManager().updateFileInfo(";
  protected final String TEXT_156 = "_boxFile.getId(), ";
  protected final String TEXT_157 = "_fileRequestObject);";
  protected final String TEXT_158 = "   " + NL + "\t\t}";
  protected final String TEXT_159 = NL + "    ";
  protected final String TEXT_160 = NL + "\t\tif (";
  protected final String TEXT_161 = "_boxFileNew != null)" + NL + "    \t{" + NL + "\t\t\t";
  protected final String TEXT_162 = ".destinationFilePath = getBoxItemPath(";
  protected final String TEXT_163 = "_boxFileNew);" + NL + "\t\t\t";
  protected final String TEXT_164 = ".destinationFileName = ";
  protected final String TEXT_165 = "_boxFileNew.getName();" + NL + "\t\t}" + NL + "\t\tif (";
  protected final String TEXT_166 = "_boxFile != null)" + NL + "    \t{" + NL + "\t\t\t";
  protected final String TEXT_167 = ".sourceDirectory = getBoxItemPath(";
  protected final String TEXT_168 = "_boxFile);" + NL + "\t\t}" + NL + "\t\telse if (";
  protected final String TEXT_169 = "_boxFolderFrom != null)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_170 = ".sourceDirectory = getBoxItemPath(";
  protected final String TEXT_171 = "_boxFolderFrom);" + NL + "\t\t}" + NL + "\t\tif (";
  protected final String TEXT_172 = "_boxFileNew != null)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_173 = ".destinationDirectory = getBoxItemPath(";
  protected final String TEXT_174 = "_boxFileNew);" + NL + "\t\t}" + NL + "\t\telse if (";
  protected final String TEXT_175 = "_boxFolderTo != null)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_176 = ".destinationDirectory = getBoxItemPath(";
  protected final String TEXT_177 = "_boxFolderTo);" + NL + "\t\t}";
  protected final String TEXT_178 = NL + "    \tif (";
  protected final String TEXT_179 = "_boxFileNew != null)" + NL + "    \t{" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_180 = "_DESTINATION_FILEPATH\", getBoxItemPath(";
  protected final String TEXT_181 = "_boxFileNew));" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_182 = "_DESTINATION_FILENAME\", ";
  protected final String TEXT_183 = "_boxFileNew.getName());" + NL + "\t\t}" + NL + "\t\tif (";
  protected final String TEXT_184 = "_boxFile != null)" + NL + "    \t{" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_185 = "_SOURCE_DIRECTORY\", getBoxItemPath(";
  protected final String TEXT_186 = "_boxFile));" + NL + "\t\t}" + NL + "\t\telse if (";
  protected final String TEXT_187 = "_boxFolderFrom != null)" + NL + "\t\t{" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_188 = "_SOURCE_DIRECTORY\", getBoxItemPath(";
  protected final String TEXT_189 = "_boxFolderFrom));" + NL + "\t\t}" + NL + "\t\tif (";
  protected final String TEXT_190 = "_boxFileNew != null)" + NL + "\t\t{" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_191 = "_DESTINATION_DIRECTORY\", getBoxItemPath(";
  protected final String TEXT_192 = "_boxFileNew));" + NL + "\t\t}" + NL + "\t\telse if (";
  protected final String TEXT_193 = "_boxFolderTo != null)" + NL + "\t\t{" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_194 = "_DESTINATION_DIRECTORY\", getBoxItemPath(";
  protected final String TEXT_195 = "_boxFolderTo));" + NL + "\t\t}" + NL + "" + NL + "\t//}\t\t\t";

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
		
		String fileName = ElementParameterParser.getValue(node, "__FILE_NAME__");
		boolean moveDirectory = "true".equals(ElementParameterParser.getValue(node, "__MOVE_DIRECTORY__"));
		boolean copyDirectory = "true".equals(ElementParameterParser.getValue(node, "__COPY_DIRECTORY__"));
		String sourceDirectory = ElementParameterParser.getValue(node, "__SOURCE_DIRECTORY__");
		String destinationDirectory = ElementParameterParser.getValue(node, "__DESTINATION_DIRECTORY__");
		boolean rename = "true".equals(ElementParameterParser.getValue(node, "__RENAME__"));
		String newDirName = ElementParameterParser.getValue(node, "__NEW_FOLDER_NAME__");
		String destinationFileName = ElementParameterParser.getValue(node, "__DESTINATION_FILE_NAME__");
		boolean removeSource = "true".equals(ElementParameterParser.getValue(node, "__REMOVE_SOURCE_FILE__"));
		
		final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
				
		List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
		
        String dataOutputConnection = null;	
	    for(IConnection conn : outputConnections) {
	        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	dataOutputConnection = conn.getName();
	        	break;
	        } // if(conn) end
	    } // for(conns) end

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(destinationDirectory);
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
    
	if(moveDirectory || copyDirectory)
	{

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(sourceDirectory);
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
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    if (moveDirectory) {
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    } else if (copyDirectory) {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    if(rename) { 
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(newDirName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    }
        		}
    stringBuffer.append(TEXT_104);
    	
	}
	else
	{

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    					if(removeSource)
					{

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    		
					}

    stringBuffer.append(TEXT_144);
    			if(rename)
			{

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(destinationFileName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    		
			}

    stringBuffer.append(TEXT_158);
    
	}

    stringBuffer.append(TEXT_159);
    
		if(dataOutputConnection != null) {

    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
		}

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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    return stringBuffer.toString();
  }
}
