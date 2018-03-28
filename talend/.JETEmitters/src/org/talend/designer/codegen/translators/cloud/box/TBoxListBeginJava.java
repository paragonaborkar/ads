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

public class TBoxListBeginJava
{
  protected static String nl;
  public static synchronized TBoxListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBoxListBeginJava result = new TBoxListBeginJava();
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
  protected final String TEXT_30 = NL + "\tcom.box.boxjavalibv2.BoxRESTClient ";
  protected final String TEXT_31 = "_httpClient = new com.box.boxjavalibv2.BoxRESTClient();";
  protected final String TEXT_32 = "   " + NL + "\t\t";
  protected final String TEXT_33 = "_httpClient.setConnectionTimeOut(3000);" + NL + "\t\tString ";
  protected final String TEXT_34 = "_proxyHost = ";
  protected final String TEXT_35 = ";" + NL + "\t\tif (null == ";
  protected final String TEXT_36 = "_proxyHost || ";
  protected final String TEXT_37 = "_proxyHost.isEmpty())" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"Proxy host can not be empty\");" + NL + "\t\t}" + NL + "\t\torg.apache.http.HttpHost ";
  protected final String TEXT_38 = "_proxy = new org.apache.http.HttpHost(";
  protected final String TEXT_39 = "_proxyHost, ";
  protected final String TEXT_40 = ", \"http\");" + NL + "\t\torg.apache.http.client.HttpClient ";
  protected final String TEXT_41 = "_cl = ";
  protected final String TEXT_42 = "_httpClient.getRawHttpClient();" + NL + "\t\t";
  protected final String TEXT_43 = "_cl.getParams().setParameter(org.apache.http.conn.params.ConnRoutePNames.DEFAULT_PROXY, ";
  protected final String TEXT_44 = "_proxy);";
  protected final String TEXT_45 = NL + "\tcom.box.boxjavalibv2.BoxClient ";
  protected final String TEXT_46 = "_client = null;" + NL + "\tString ";
  protected final String TEXT_47 = "_accessToken = ";
  protected final String TEXT_48 = ";" + NL + "\tString ";
  protected final String TEXT_49 = "_refreshToken = ";
  protected final String TEXT_50 = ";" + NL + "\tString ";
  protected final String TEXT_51 = "_clientId = ";
  protected final String TEXT_52 = ";" + NL + "\tString ";
  protected final String TEXT_53 = "_clientSecret = ";
  protected final String TEXT_54 = ";" + NL + "\tif (null == ";
  protected final String TEXT_55 = "_clientId || ";
  protected final String TEXT_56 = "_clientId.isEmpty() || null == ";
  protected final String TEXT_57 = "_clientSecret || ";
  protected final String TEXT_58 = "_clientSecret.isEmpty()) {" + NL + "\t\tthrow new Exception(\"Client Id and secret can not be empty\");" + NL + "\t}" + NL + "\t";
  protected final String TEXT_59 = "_client = new com.box.boxjavalibv2.BoxClient(";
  protected final String TEXT_60 = "_clientId, ";
  protected final String TEXT_61 = "_clientSecret, null, null, ";
  protected final String TEXT_62 = "_httpClient, new com.box.boxjavalibv2.BoxConfigBuilder().build());" + NL + "\t\t" + NL + "\t\tif((";
  protected final String TEXT_63 = "_accessToken == null || \"\".equals(";
  protected final String TEXT_64 = "_accessToken.trim())) && (";
  protected final String TEXT_65 = "_refreshToken == null || \"\".equals(";
  protected final String TEXT_66 = "_refreshToken.trim()))) {" + NL + "\t\t\tthrow new Exception(\"One of Access token or Refresh token should be provided\");" + NL + "\t\t} else {" + NL + "\t\t\tjava.util.Map<String, Object> ";
  protected final String TEXT_67 = "_map = new java.util.HashMap<String, Object>();" + NL + "\t\tif (";
  protected final String TEXT_68 = "_accessToken != null && !";
  protected final String TEXT_69 = "_accessToken.isEmpty()  && !";
  protected final String TEXT_70 = "_accessToken.trim().matches(\"\\\"?\\\"?\")" + NL + "\t\t && ";
  protected final String TEXT_71 = "_refreshToken != null && !";
  protected final String TEXT_72 = "_refreshToken.isEmpty() && !";
  protected final String TEXT_73 = "_refreshToken.trim().matches(\"\\\"?\\\"?\")) {" + NL + "\t\t\t";
  protected final String TEXT_74 = "_map.put(com.box.boxjavalibv2.dao.BoxOAuthToken.FIELD_ACCESS_TOKEN, ";
  protected final String TEXT_75 = "_accessToken);" + NL + "\t\t\t";
  protected final String TEXT_76 = "_map.put(com.box.boxjavalibv2.dao.BoxOAuthToken.FIELD_REFRESH_TOKEN, ";
  protected final String TEXT_77 = "_refreshToken);" + NL + "\t\t    ";
  protected final String TEXT_78 = "_client.getOAuthDataController().setAutoRefreshOAuth(true);" + NL + "\t\t} else if (";
  protected final String TEXT_79 = "_accessToken != null && !";
  protected final String TEXT_80 = "_accessToken.isEmpty() && !";
  protected final String TEXT_81 = "_accessToken.trim().matches(\"\\\"?\\\"?\")) {" + NL + "\t\t    ";
  protected final String TEXT_82 = "_map.put(com.box.boxjavalibv2.dao.BoxOAuthToken.FIELD_ACCESS_TOKEN, ";
  protected final String TEXT_83 = "_accessToken);" + NL + "\t\t} else if (";
  protected final String TEXT_84 = "_refreshToken != null && !\"\".equals(";
  protected final String TEXT_85 = "_refreshToken.trim()) && !";
  protected final String TEXT_86 = "_refreshToken.trim().matches(\"\\\"?\\\"?\")) {" + NL + "\t\t    ";
  protected final String TEXT_87 = "_map.put(com.box.boxjavalibv2.dao.BoxOAuthToken.FIELD_REFRESH_TOKEN, ";
  protected final String TEXT_88 = "_refreshToken);" + NL + "\t\t    ";
  protected final String TEXT_89 = "_client.getOAuthDataController().setAutoRefreshOAuth(true);" + NL + "\t\t}";
  protected final String TEXT_90 = NL + "    ";
  protected final String TEXT_91 = "_client.authenticate(new com.box.boxjavalibv2.dao.BoxOAuthToken(";
  protected final String TEXT_92 = "_map));" + NL + "}";
  protected final String TEXT_93 = NL + "\tcom.box.boxjavalibv2.BoxClient ";
  protected final String TEXT_94 = "_client = (com.box.boxjavalibv2.BoxClient)globalMap.get(";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "\tString ";
  protected final String TEXT_97 = "_path = normalizePath(";
  protected final String TEXT_98 = ");" + NL + "\tboolean ";
  protected final String TEXT_99 = "_hasError = false;" + NL + "\tString ";
  protected final String TEXT_100 = "_name = getFolderFromPath(";
  protected final String TEXT_101 = "_path);" + NL + "\tcom.box.boxjavalibv2.dao.BoxFile ";
  protected final String TEXT_102 = "_boxFile = null;" + NL + "\tcom.box.boxjavalibv2.dao.BoxFolder ";
  protected final String TEXT_103 = "_boxFolder = null;" + NL + "\tif ((";
  protected final String TEXT_104 = "_name.equals(\"All Files\") && (";
  protected final String TEXT_105 = "_path.isEmpty() || ";
  protected final String TEXT_106 = "_path == null)))" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_107 = "_boxFolder = ";
  protected final String TEXT_108 = "_client.getFoldersManager().getFolder(\"0\",null);\t" + NL + "\t}" + NL + "\telse" + NL + "\t{" + NL + "\t\tcom.box.restclientv2.requestsbase.BoxDefaultRequestObject ";
  protected final String TEXT_109 = "_requestObject = new com.box.restclientv2.requestsbase.BoxDefaultRequestObject();" + NL + "\t\t\tif (";
  protected final String TEXT_110 = "_name.equals(\"All Files\") || ";
  protected final String TEXT_111 = "_path.equals(\"All Files\"))" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_112 = "_boxFolder = ";
  protected final String TEXT_113 = "_client.getFoldersManager().getFolder(\"0\", null);" + NL + "\t\t\t}" + NL + "\t\t\telse" + NL + "\t\t\t{" + NL + "                String parentPath = normalizePath(";
  protected final String TEXT_114 = "_path.replace(";
  protected final String TEXT_115 = "_name, \"\"));" + NL + "                ";
  protected final String TEXT_116 = NL + "                ";
  protected final String TEXT_117 = "_boxFolder = ";
  protected final String TEXT_118 = "_client.getFoldersManager().getFolder(\"0\", ";
  protected final String TEXT_119 = "_requestObject);" + NL + "                " + NL + "                if (\"All Files\".equals(parentPath)) {" + NL + "                    " + NL + "                    for (com.box.boxjavalibv2.dao.BoxTypedObject ";
  protected final String TEXT_120 = "_boxTypedObject : ";
  protected final String TEXT_121 = "_boxFolder.getItemCollection().getEntries()) {" + NL + "                        if (";
  protected final String TEXT_122 = "_boxTypedObject.getValue(\"name\").equals(";
  protected final String TEXT_123 = "_name)) {" + NL + "                            if (\"folder\".equals(";
  protected final String TEXT_124 = "_boxTypedObject.getType())) {";
  protected final String TEXT_125 = NL + "                                ";
  protected final String TEXT_126 = "_boxFolder = ";
  protected final String TEXT_127 = "_client.getFoldersManager().getFolder(";
  protected final String TEXT_128 = "_boxTypedObject.getId(), ";
  protected final String TEXT_129 = "_requestObject);" + NL + "                            } else {";
  protected final String TEXT_130 = NL + "                                ";
  protected final String TEXT_131 = "_boxFile = ";
  protected final String TEXT_132 = "_client.getFilesManager().getFile(";
  protected final String TEXT_133 = "_boxTypedObject.getId(),";
  protected final String TEXT_134 = "_requestObject);" + NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                } else {" + NL + "" + NL + "                    List<String> ";
  protected final String TEXT_135 = "_paths = new java.util.ArrayList<String>(java.util.Arrays.asList(parentPath.split(\"/\")));" + NL;
  protected final String TEXT_136 = NL + "                    ";
  protected final String TEXT_137 = "_boxFolder = getBoxFolderRecursively(";
  protected final String TEXT_138 = "_paths, ";
  protected final String TEXT_139 = "_boxFolder, ";
  protected final String TEXT_140 = "_client);" + NL + "                }" + NL + "\t\t\t}" + NL + "\t}" + NL + "" + NL + "\tif (";
  protected final String TEXT_141 = "_boxFile == null && ";
  protected final String TEXT_142 = "_boxFolder == null)" + NL + "\t{" + NL + "\t\tthrow new Exception(\"";
  protected final String TEXT_143 = " - \" + \"No file or directory found in \" + ";
  protected final String TEXT_144 = ");" + NL + "\t}" + NL + "\telse if (";
  protected final String TEXT_145 = "_boxFolder != null)" + NL + "\t{" + NL + "\t\tjava.util.List<com.box.boxjavalibv2.dao.BoxItem>  ";
  protected final String TEXT_146 = "_children = new java.util.ArrayList<com.box.boxjavalibv2.dao.BoxItem>();";
  protected final String TEXT_147 = NL + "\t";
  protected final String TEXT_148 = NL + "\t\t";
  protected final String TEXT_149 = "_children = getChildrenRecursively(";
  protected final String TEXT_150 = "_client, ";
  protected final String TEXT_151 = "_boxFolder, ";
  protected final String TEXT_152 = "_children, true, false);" + NL + "\t";
  protected final String TEXT_153 = "\t\t" + NL + "\t\t";
  protected final String TEXT_154 = "_children = getChildrenRecursively(";
  protected final String TEXT_155 = "_client, ";
  protected final String TEXT_156 = "_boxFolder, ";
  protected final String TEXT_157 = "_children, false, true);" + NL + "\t";
  protected final String TEXT_158 = NL + "\t\t";
  protected final String TEXT_159 = "_children = getChildrenRecursively(";
  protected final String TEXT_160 = "_client, ";
  protected final String TEXT_161 = "_boxFolder, ";
  protected final String TEXT_162 = "_children, true, true);" + NL + "\t";
  protected final String TEXT_163 = NL + "\t\tfor (com.box.boxjavalibv2.dao.BoxTypedObject obj : ";
  protected final String TEXT_164 = "_boxFolder.getItemCollection().getEntries())" + NL + "\t\t{" + NL + "\t";
  protected final String TEXT_165 = NL + "\t\t\tif(obj.getType().equals(\"folder\"))" + NL + "\t\t\t{" + NL + "\t\t\t\tcom.box.boxjavalibv2.dao.BoxFolder folder = ";
  protected final String TEXT_166 = "_client.getFoldersManager().getFolder(obj.getId(), null);" + NL + "\t\t\t\t";
  protected final String TEXT_167 = "_children.add(folder);" + NL + "\t\t\t}" + NL + "\t";
  protected final String TEXT_168 = NL + "\t\t\tif (obj.getType().equals(\"file\"))" + NL + "\t\t\t{" + NL + "\t\t\t\tcom.box.boxjavalibv2.dao.BoxFile file = ";
  protected final String TEXT_169 = "_client.getFilesManager().getFile(obj.getId(), null);" + NL + "\t\t\t\t";
  protected final String TEXT_170 = "_children.add(file);" + NL + "\t\t\t}" + NL + "\t";
  protected final String TEXT_171 = NL + "\t\t\tif(obj.getType().equals(\"folder\"))" + NL + "\t\t\t{" + NL + "\t\t\t\tcom.box.boxjavalibv2.dao.BoxFolder folder = ";
  protected final String TEXT_172 = "_client.getFoldersManager().getFolder(obj.getId(), null);" + NL + "\t\t\t\t";
  protected final String TEXT_173 = "_children.add(folder);" + NL + "\t\t\t}" + NL + "\t\t\telse if (obj.getType().equals(\"file\"))" + NL + "\t\t\t{" + NL + "\t\t\t\tcom.box.boxjavalibv2.dao.BoxFile file = ";
  protected final String TEXT_174 = "_client.getFilesManager().getFile(obj.getId(), null);" + NL + "\t\t\t\t";
  protected final String TEXT_175 = "_children.add(file);" + NL + "\t\t\t}" + NL + "\t";
  protected final String TEXT_176 = NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t}";
  protected final String TEXT_177 = NL + "\t\t" + NL + "\t\tfor (com.box.boxjavalibv2.dao.BoxItem ";
  protected final String TEXT_178 = "_item : ";
  protected final String TEXT_179 = "_children)" + NL + "\t\t{" + NL + "\t\t\tString ";
  protected final String TEXT_180 = "_itemPath = getBoxItemPath(";
  protected final String TEXT_181 = "_item);" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_182 = "_NAME\", ";
  protected final String TEXT_183 = "_item.getName());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_184 = "_ID\", ";
  protected final String TEXT_185 = "_item.getId());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_186 = "_FILE_PATH\", ";
  protected final String TEXT_187 = "_itemPath);" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_188 = "_FILE_DIRECTORY\", ";
  protected final String TEXT_189 = "_itemPath + ";
  protected final String TEXT_190 = "_item.getName());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_191 = "_TYPE\",";
  protected final String TEXT_192 = "_item.getType());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_193 = "_LAST_MODIFIED\", ";
  protected final String TEXT_194 = "_item.getModifiedAt());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_195 = "_SIZE\", ";
  protected final String TEXT_196 = "_item.getSize());" + NL + "\t" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\t" + NL + "\t\t\t";

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
		
		String path = ElementParameterParser.getValue(node, "__PATH__");
		String filelistType = ElementParameterParser.getValue(node, "__LIST_MODE__");
		boolean includeSubDirectories = "true".equals(ElementParameterParser.getValue(node, "__INCLUDSUBDIR__"));
		
		final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
				log4jFileUtil.componentStartInfo(node);
		
		List<IMetadataTable> metadatas = node.getMetadataList();
		IMetadataTable metadata = null;
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			metadata = metadatas.get(0);    
	    }
		
		List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
		
        String dataOutputConnection = null;	
	    for(IConnection conn : outputConnections) {
	        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	dataOutputConnection = conn.getName();
	        	break;
	        } // if(conn) end
	    } // for(conns) end
		

    
if(!"true".equals(useExistingConn)){
	String useProxy = ElementParameterParser.getValue(node,"__USE_PROXY__");
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
	if("true".equals(useProxy)){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
	}else{

    
	}

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(refreshToken);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(clientId);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(clientSecret);
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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
	} else {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(connectionKey);
    stringBuffer.append(TEXT_95);
    
}

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(path);
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
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    if(includeSubDirectories){
    stringBuffer.append(TEXT_147);
    if(filelistType.equalsIgnoreCase("Directories")){
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    } else if (filelistType.equalsIgnoreCase("Files")){
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    } else {
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    }
    }
    else{
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    if(filelistType.equalsIgnoreCase("Directories")){
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    } else if (filelistType.equalsIgnoreCase("Files")){
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    } else {
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    }
    stringBuffer.append(TEXT_176);
    }
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    return stringBuffer.toString();
  }
}
