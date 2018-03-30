package org.talend.designer.codegen.translators.cloud.box;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TBoxConnectionBeginJava
{
  protected static String nl;
  public static synchronized TBoxConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBoxConnectionBeginJava result = new TBoxConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\tcom.box.boxjavalibv2.BoxRESTClient ";
  protected final String TEXT_30 = "_httpClient = new com.box.boxjavalibv2.BoxRESTClient();";
  protected final String TEXT_31 = "   " + NL + "\t";
  protected final String TEXT_32 = "_httpClient.setConnectionTimeOut(3000);" + NL + "\tString ";
  protected final String TEXT_33 = "_proxyHost = ";
  protected final String TEXT_34 = ";" + NL + "\tif (null == ";
  protected final String TEXT_35 = "_proxyHost || ";
  protected final String TEXT_36 = "_proxyHost.isEmpty())" + NL + "\t{" + NL + "\t\tthrow new Exception(\"Proxy host can not be empty\");" + NL + "\t}" + NL + "\torg.apache.http.HttpHost ";
  protected final String TEXT_37 = "_proxy = new org.apache.http.HttpHost(";
  protected final String TEXT_38 = "_proxyHost, ";
  protected final String TEXT_39 = ", \"http\");" + NL + "\t";
  protected final String TEXT_40 = "_httpClient.getRawHttpClient().getParams().setParameter(org.apache.http.conn.params.ConnRoutePNames.DEFAULT_PROXY, ";
  protected final String TEXT_41 = "_proxy);";
  protected final String TEXT_42 = NL + NL + "\tString ";
  protected final String TEXT_43 = "_accessToken = ";
  protected final String TEXT_44 = ";" + NL + "\tString ";
  protected final String TEXT_45 = "_refreshToken = ";
  protected final String TEXT_46 = ";" + NL + "\tString ";
  protected final String TEXT_47 = "_clientId = ";
  protected final String TEXT_48 = ";" + NL + "\tString ";
  protected final String TEXT_49 = "_clientSecret = ";
  protected final String TEXT_50 = ";" + NL + "\tif (null == ";
  protected final String TEXT_51 = "_clientId || ";
  protected final String TEXT_52 = "_clientId.isEmpty() || null == ";
  protected final String TEXT_53 = "_clientSecret || ";
  protected final String TEXT_54 = "_clientSecret.isEmpty()) {" + NL + "\t\tthrow new Exception(\"Client Id and secret can not be empty\");" + NL + "\t}" + NL + "\tif((";
  protected final String TEXT_55 = "_accessToken == null || \"\".equals(";
  protected final String TEXT_56 = "_accessToken.trim())) && (";
  protected final String TEXT_57 = "_refreshToken == null || \"\".equals(";
  protected final String TEXT_58 = "_refreshToken.trim()))) {" + NL + "\t" + NL + "\t\tthrow new Exception(\"One of Access token or Refresh token should be provided\");" + NL + "\t} else {" + NL + "\t\tcom.box.boxjavalibv2.BoxClient ";
  protected final String TEXT_59 = "_client = new com.box.boxjavalibv2.BoxClient(";
  protected final String TEXT_60 = "_clientId, ";
  protected final String TEXT_61 = "_clientSecret, null, null, ";
  protected final String TEXT_62 = "_httpClient, new com.box.boxjavalibv2.BoxConfigBuilder().build());" + NL + "\t\tjava.util.Map<String, Object> ";
  protected final String TEXT_63 = "_map = new java.util.HashMap<String, Object>();" + NL + "\tif (";
  protected final String TEXT_64 = "_accessToken != null && !";
  protected final String TEXT_65 = "_accessToken.isEmpty()  && !";
  protected final String TEXT_66 = "_accessToken.trim().matches(\"\\\"?\\\"?\")" + NL + "\t && ";
  protected final String TEXT_67 = "_refreshToken != null && !";
  protected final String TEXT_68 = "_refreshToken.isEmpty() && !";
  protected final String TEXT_69 = "_refreshToken.trim().matches(\"\\\"?\\\"?\")) {" + NL + "\t\t";
  protected final String TEXT_70 = "_map.put(com.box.boxjavalibv2.dao.BoxOAuthToken.FIELD_ACCESS_TOKEN, ";
  protected final String TEXT_71 = "_accessToken);" + NL + "\t\t";
  protected final String TEXT_72 = "_map.put(com.box.boxjavalibv2.dao.BoxOAuthToken.FIELD_REFRESH_TOKEN, ";
  protected final String TEXT_73 = "_refreshToken);" + NL + "\t    ";
  protected final String TEXT_74 = "_client.getOAuthDataController().setAutoRefreshOAuth(true);" + NL + "\t} else if (";
  protected final String TEXT_75 = "_accessToken != null && !";
  protected final String TEXT_76 = "_accessToken.isEmpty() && !";
  protected final String TEXT_77 = "_accessToken.trim().matches(\"\\\"?\\\"?\")) {" + NL + "\t    ";
  protected final String TEXT_78 = "_map.put(com.box.boxjavalibv2.dao.BoxOAuthToken.FIELD_ACCESS_TOKEN, ";
  protected final String TEXT_79 = "_accessToken);" + NL + "\t} else if (";
  protected final String TEXT_80 = "_refreshToken != null && !\"\".equals(";
  protected final String TEXT_81 = "_refreshToken.trim()) && !";
  protected final String TEXT_82 = "_refreshToken.trim().matches(\"\\\"?\\\"?\")) {" + NL + "\t    ";
  protected final String TEXT_83 = "_map.put(com.box.boxjavalibv2.dao.BoxOAuthToken.FIELD_REFRESH_TOKEN, ";
  protected final String TEXT_84 = "_refreshToken);" + NL + "\t    ";
  protected final String TEXT_85 = "_client.getOAuthDataController().setAutoRefreshOAuth(true);" + NL + "\t}" + NL + "\t  " + NL + "\t    ";
  protected final String TEXT_86 = "_client.authenticate(new com.box.boxjavalibv2.dao.BoxOAuthToken(";
  protected final String TEXT_87 = "_map));" + NL + "\t    globalMap.put(\"conn_";
  protected final String TEXT_88 = "\",  ";
  protected final String TEXT_89 = "_client);" + NL + "\t}" + NL + "    " + NL + "\t" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		
		String accessToken = ElementParameterParser.getValue(node, "__ACCESS_TOKEN__");
		String refreshToken = ElementParameterParser.getValue(node, "__REFRESH_TOKEN__");
		
		String clientId = ElementParameterParser.getValue(node, "__CLIENT_ID__");
		String clientSecret = ElementParameterParser.getValue(node, "__CLIENT_SECRET__");
		
		String useProxy = ElementParameterParser.getValue(node, "__USE_PROXY__");
		String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
		String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
		final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
				log4jFileUtil.componentStartInfo(node);
		String clientIdentifier = "\""+cid+"\"";
		
		String localeName = "\""+java.util.Locale.getDefault().toString()+"\"";
		

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    if("true".equals(useProxy)){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    }else{
    }
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(refreshToken);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(clientId);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(clientSecret);
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
    return stringBuffer.toString();
  }
}
