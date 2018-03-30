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

public class TBoxDeleteMainJava
{
  protected static String nl;
  public static synchronized TBoxDeleteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBoxDeleteMainJava result = new TBoxDeleteMainJava();
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
  protected final String TEXT_30 = NL + NL + "\t\tString ";
  protected final String TEXT_31 = "_filePath = ";
  protected final String TEXT_32 = ";" + NL + "\t\tif (";
  protected final String TEXT_33 = "_filePath == null || \"\".equals(";
  protected final String TEXT_34 = "_filePath.trim()))" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"File path can not be null\");" + NL + "\t\t}" + NL + "\t\tString ";
  protected final String TEXT_35 = "_remoteFilePath = normalizePath(";
  protected final String TEXT_36 = "_filePath);" + NL + "\t\tString ";
  protected final String TEXT_37 = "_remoteFileName = getFolderFromPath(";
  protected final String TEXT_38 = "_remoteFilePath);" + NL + "\t\tcom.box.boxjavalibv2.dao.BoxItem ";
  protected final String TEXT_39 = "_boxItem = null;" + NL + "\t\tcom.box.boxjavalibv2.dao.BoxFolder ";
  protected final String TEXT_40 = "_boxFolder = null;" + NL + "\t\t" + NL + "\t\tString parentPath = normalizePath(";
  protected final String TEXT_41 = "_remoteFilePath.replace(";
  protected final String TEXT_42 = "_remoteFileName, \"\"));" + NL + "                ";
  protected final String TEXT_43 = NL + "        ";
  protected final String TEXT_44 = "_boxFolder = ";
  protected final String TEXT_45 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "    " + NL + "        List<String> ";
  protected final String TEXT_46 = "_paths = new java.util.ArrayList<String>(java.util.Arrays.asList(parentPath.split(\"/\")));" + NL;
  protected final String TEXT_47 = NL + "        ";
  protected final String TEXT_48 = "_boxFolder = getBoxFolderRecursively(";
  protected final String TEXT_49 = "_paths, ";
  protected final String TEXT_50 = "_boxFolder, ";
  protected final String TEXT_51 = "_client);" + NL + "    " + NL + "        com.box.boxjavalibv2.dao.BoxCollection ";
  protected final String TEXT_52 = "_searchResults = ";
  protected final String TEXT_53 = "_boxFolder.getItemCollection();" + NL + "        for (com.box.boxjavalibv2.dao.BoxTypedObject ";
  protected final String TEXT_54 = "_entry : ";
  protected final String TEXT_55 = "_searchResults.getEntries())" + NL + "        {" + NL + "            if(";
  protected final String TEXT_56 = "_entry.getValue(\"name\").equals(";
  protected final String TEXT_57 = "_remoteFileName)){" + NL + "               if(\"folder\".equals(";
  protected final String TEXT_58 = "_entry.getType())){";
  protected final String TEXT_59 = NL + "                   ";
  protected final String TEXT_60 = "_boxItem = (com.box.boxjavalibv2.dao.BoxItem)";
  protected final String TEXT_61 = "_client.getFoldersManager().getFolder(";
  protected final String TEXT_62 = "_entry.getId(),null);  " + NL + "               }else{";
  protected final String TEXT_63 = NL + "                   ";
  protected final String TEXT_64 = "_boxItem = (com.box.boxjavalibv2.dao.BoxItem)";
  protected final String TEXT_65 = "_client.getFilesManager().getFile(";
  protected final String TEXT_66 = "_entry.getId(),null);" + NL + "               }   " + NL + "            }" + NL + "        }" + NL + "\t\t" + NL + "\t\tif (";
  protected final String TEXT_67 = "_boxItem == null)" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"Nothing found under path \" + ";
  protected final String TEXT_68 = "_filePath);" + NL + "\t\t}" + NL + "\t\tif (";
  protected final String TEXT_69 = "_boxItem.getType().equalsIgnoreCase(\"file\"))" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_70 = "_client.getFilesManager().deleteFile(";
  protected final String TEXT_71 = "_boxItem.getId(), null);" + NL + "\t\t}" + NL + "\t\telse if (";
  protected final String TEXT_72 = "_boxItem.getType().equalsIgnoreCase(\"folder\"))" + NL + "\t\t{" + NL + "\t\t\tcom.box.boxjavalibv2.requests.requestobjects.BoxFolderDeleteRequestObject ";
  protected final String TEXT_73 = "_delObject = com.box.boxjavalibv2.requests.requestobjects.BoxFolderDeleteRequestObject.deleteFolderRequestObject(true);" + NL + "\t       \t";
  protected final String TEXT_74 = "_client.getFoldersManager().deleteFolder(";
  protected final String TEXT_75 = "_boxItem.getId(), ";
  protected final String TEXT_76 = "_delObject);" + NL + "\t\t}" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_77 = "_REMOVED_PATH\",getBoxItemPath(";
  protected final String TEXT_78 = "_boxItem));" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_79 = NL;

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
		
		String filePath = ElementParameterParser.getValue(node, "__PATH__");
		boolean deleteFolder = "true".equals(ElementParameterParser.getValue(node, "__DELETE_FOLDER__"));
		boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
		
		final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		String dataInputConnection = null;
        
        List< ? extends IConnection> inputConnections = node.getIncomingConnections();
	    for(IConnection conn : inputConnections) {
	        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	dataInputConnection = conn.getName();
	        	break;
	        } // if(conn) end
	    } // for(conns) end


    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(filePath);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
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
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(TEXT_79);
    return stringBuffer.toString();
  }
}
