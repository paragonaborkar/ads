package org.talend.designer.codegen.translators.business.sap;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TSAPConnectionBeginJava
{
  protected static String nl;
  public static synchronized TSAPConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPConnectionBeginJava result = new TSAPConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    ";
  protected final String TEXT_3 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_4 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = "; ";
  protected final String TEXT_9 = NL + "    ";
  protected final String TEXT_10 = NL + "\t\tcom.sap.conn.jco.JCoDestination dest_";
  protected final String TEXT_11 = " = null;";
  protected final String TEXT_12 = NL + "\t\t\t\tdest_";
  protected final String TEXT_13 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\t\t\tif (dest_";
  protected final String TEXT_16 = " == null) {" + NL;
  protected final String TEXT_17 = NL + "\t\t\torg.talend.sap.TSAPDestinationData destinationData_";
  protected final String TEXT_18 = " = null;" + NL + "\t\t\t" + NL + "\t\t\tjava.util.Properties properties_";
  protected final String TEXT_19 = " = new java.util.Properties();" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "        \t\tproperties_";
  protected final String TEXT_21 = ".setProperty(\"jco.client.snc_mode\", \"1\");" + NL + "        \t\tproperties_";
  protected final String TEXT_22 = ".setProperty(\"jco.client.snc_partnername\", ";
  protected final String TEXT_23 = ");" + NL + "        \t\tproperties_";
  protected final String TEXT_24 = ".setProperty(\"jco.client.snc_qop\", String.valueOf(";
  protected final String TEXT_25 = "));" + NL + "        \t\t";
  protected final String TEXT_26 = NL + "            \t\tif(";
  protected final String TEXT_27 = " != null){" + NL + "            \t\t\tproperties_";
  protected final String TEXT_28 = ".setProperty(\"jco.client.snc_myname\", ";
  protected final String TEXT_29 = ");" + NL + "            \t\t}" + NL + "        \t\t";
  protected final String TEXT_30 = NL + "        \t\t";
  protected final String TEXT_31 = NL + "            \t\tif(";
  protected final String TEXT_32 = " != null){" + NL + "            \t\t\tproperties_";
  protected final String TEXT_33 = ".setProperty(\"jco.client.snc_lib\", ";
  protected final String TEXT_34 = ");" + NL + "            \t\t}" + NL + "        \t\t";
  protected final String TEXT_35 = NL + "        \t";
  protected final String TEXT_36 = NL + "        \t";
  protected final String TEXT_37 = "\t" + NL + "        \t\tproperties_";
  protected final String TEXT_38 = ".put(";
  protected final String TEXT_39 = " ,";
  protected final String TEXT_40 = ");" + NL + "        \t\t";
  protected final String TEXT_41 = NL + "        \t" + NL + "\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\tdestinationData_";
  protected final String TEXT_43 = " = new org.talend.sap.TSAPApplicationServerDestData.Builder(";
  protected final String TEXT_44 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_45 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdecryptedPassword_";
  protected final String TEXT_46 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_47 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_48 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_49 = ")" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_50 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setSAPGUI(\"2\")" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setCustomProp(properties_";
  protected final String TEXT_52 = ")" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.build();" + NL + "\t\t\t";
  protected final String TEXT_53 = "\t\t\t" + NL + "\t\t\t\tdestinationData_";
  protected final String TEXT_54 = " = new org.talend.sap.TSAPMessageServerDestData.Builder(";
  protected final String TEXT_55 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_56 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdecryptedPassword_";
  protected final String TEXT_57 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_58 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_59 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_60 = "," + NL + "\t\t\t\t\t\t            \t\t\t\t \t\t\t\t\t\t\t\t";
  protected final String TEXT_61 = ")" + NL + "\t\t\t\t\t\t            \t\t\t\t \t\t\t\t\t\t\t\t";
  protected final String TEXT_62 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setSAPGUI(\"2\")" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setCustomProp(properties_";
  protected final String TEXT_64 = ")" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.build();" + NL + "\t\t\t";
  protected final String TEXT_65 = NL + "\t\t    ";
  protected final String TEXT_66 = NL + "\t\t\t\tcom.sap.conn.jco.JCo.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\");" + NL + "\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\tdest_";
  protected final String TEXT_68 = " = org.talend.sap.TSAPDestinationFactory.getInstance().getDestination(destinationData_";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "\t\t\t}";
  protected final String TEXT_71 = NL + "    // Begins the stateful call sequence for calls to the specified destination." + NL + "    com.sap.conn.jco.JCoContext.begin(dest_";
  protected final String TEXT_72 = ");" + NL + "\tdest_";
  protected final String TEXT_73 = ".ping();" + NL + "    globalMap.put(\"conn_";
  protected final String TEXT_74 = "\", dest_";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "\torg.talend.sap.ISAPConnection connection_";
  protected final String TEXT_77 = " = null;";
  protected final String TEXT_78 = NL + "\t\t\tconnection_";
  protected final String TEXT_79 = " = ((org.talend.sap.impl.SAPConnectionFactory)(org.talend.sap.impl.SAPConnectionFactory.getInstance())).createConnection(";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "\t\tif (connection_";
  protected final String TEXT_82 = " == null) {//}";
  protected final String TEXT_83 = NL + "\t" + NL + "\tjava.util.Properties properties_";
  protected final String TEXT_84 = " = new java.util.Properties();" + NL + "    properties_";
  protected final String TEXT_85 = ".put(org.talend.sap.ISAPConnection.PROP_CLIENT, ";
  protected final String TEXT_86 = ");" + NL + "    properties_";
  protected final String TEXT_87 = ".put(org.talend.sap.ISAPConnection.PROP_USER, ";
  protected final String TEXT_88 = ");" + NL + "    properties_";
  protected final String TEXT_89 = ".put(org.talend.sap.ISAPConnection.PROP_PASSWORD, decryptedPassword_";
  protected final String TEXT_90 = ");" + NL + "    properties_";
  protected final String TEXT_91 = ".put(org.talend.sap.ISAPConnection.PROP_LANGUAGE, ";
  protected final String TEXT_92 = ");" + NL + "    ";
  protected final String TEXT_93 = NL + "    properties_";
  protected final String TEXT_94 = ".put(org.talend.sap.ISAPConnection.PROP_APPLICATION_SERVER_HOST, ";
  protected final String TEXT_95 = ");" + NL + "    properties_";
  protected final String TEXT_96 = ".put(org.talend.sap.ISAPConnection.PROP_SYSTEM_NUMBER, ";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "    properties_";
  protected final String TEXT_99 = ".put(\"jco.client.mshost\", ";
  protected final String TEXT_100 = ");" + NL + "    properties_";
  protected final String TEXT_101 = ".put(\"jco.client.r3name\", ";
  protected final String TEXT_102 = ");" + NL + "    properties_";
  protected final String TEXT_103 = ".put(\"jco.client.group\", ";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + "    ";
  protected final String TEXT_106 = NL + "\t\tproperties_";
  protected final String TEXT_107 = ".setProperty(\"jco.client.snc_mode\", \"1\");" + NL + "\t\tproperties_";
  protected final String TEXT_108 = ".setProperty(\"jco.client.snc_partnername\", ";
  protected final String TEXT_109 = ");" + NL + "\t\tproperties_";
  protected final String TEXT_110 = ".setProperty(\"jco.client.snc_qop\", String.valueOf(";
  protected final String TEXT_111 = "));" + NL + "\t\t";
  protected final String TEXT_112 = NL + "    \t\tif(";
  protected final String TEXT_113 = " != null){" + NL + "    \t\t\tproperties_";
  protected final String TEXT_114 = ".setProperty(\"jco.client.snc_myname\", ";
  protected final String TEXT_115 = ");" + NL + "    \t\t}" + NL + "\t\t";
  protected final String TEXT_116 = NL + "\t\t";
  protected final String TEXT_117 = NL + "    \t\tif(";
  protected final String TEXT_118 = " != null){" + NL + "    \t\t\tproperties_";
  protected final String TEXT_119 = ".setProperty(\"jco.client.snc_lib\", ";
  protected final String TEXT_120 = ");" + NL + "    \t\t}" + NL + "\t\t";
  protected final String TEXT_121 = NL + "\t";
  protected final String TEXT_122 = NL + "\t";
  protected final String TEXT_123 = "\t" + NL + "\t\tproperties_";
  protected final String TEXT_124 = ".put(";
  protected final String TEXT_125 = " ,";
  protected final String TEXT_126 = ");" + NL + "\t\t";
  protected final String TEXT_127 = NL + "    " + NL + "\tconnection_";
  protected final String TEXT_128 = " = org.talend.sap.impl.SAPConnectionFactory.getInstance().createConnection(properties_";
  protected final String TEXT_129 = ");";
  protected final String TEXT_130 = NL + "\t\t//{" + NL + "\t\t}";
  protected final String TEXT_131 = NL + "\tconnection_";
  protected final String TEXT_132 = ".beginTransaction();" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_133 = "\", connection_";
  protected final String TEXT_134 = ");";
  protected final String TEXT_135 = NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String version = ElementParameterParser.getValue(node, "__DB_VERSION__");
    String client = ElementParameterParser.getValue(node, "__CLIENT__");
    String userid = ElementParameterParser.getValue(node, "__USERID__");
    String password = ElementParameterParser.getValue(node, "__PASSWORD__");
    String language = ElementParameterParser.getValue(node, "__LANGUAGE__");
    String hostname = ElementParameterParser.getValue(node, "__HOSTNAME__");
    String systemnumber = ElementParameterParser.getValue(node, "__SYSTEMNUMBER__");
    
    String serverType = ElementParameterParser.getValue(node,"__SERVERTYPE__");
    String systemId = ElementParameterParser.getValue(node,"__SYSTEMID__");
    String groupName = ElementParameterParser.getValue(node,"__GROUPNAME__");
    boolean useFtpHttp = ("true").equals(ElementParameterParser.getValue(node,"__FTP_HTTP_FUNCTION__"));
    
    String passwordFieldName = "__PASSWORD__";
    
    boolean activeSNC = ("true").equals(ElementParameterParser.getValue(node,"__SNC_ACTIVE__"));
    String partnerSNCName = ElementParameterParser.getValue(node,"__SNC_PARTNER_NAME__");
    String mySNCName = ElementParameterParser.getValue(node,"__SNC_MY_NAME__");
    String sncLevel = ElementParameterParser.getValue(node,"__SNC_LEVEL__");
    String sncLibPath = ElementParameterParser.getValue(node,"__SNC_LIB_PATH__");
    boolean hasSNCLibPath = sncLibPath != null && !"".equals(sncLibPath);
    boolean hasMySNCName = mySNCName != null && !"".equals(mySNCName);
    
    List<Map<String, String>> sapProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SAP_PROPERTIES__");

    stringBuffer.append(TEXT_2);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_5);
    } else {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__SAP_DATASOURCE_ALIAS__");
			if(null != alias && !("".equals(alias))){

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_14);
    
			}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
		}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
        	if(activeSNC){
        	
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(partnerSNCName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(sncLevel);
    stringBuffer.append(TEXT_25);
    if(hasMySNCName){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    if(hasSNCLibPath){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    
        	}
        	
    stringBuffer.append(TEXT_36);
    
            if(sapProps!=null) {
        		for(Map<String, String> item : sapProps){
        		
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_40);
     
        		}
            }
        	
    stringBuffer.append(TEXT_41);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(systemnumber);
    stringBuffer.append(TEXT_49);
    if(useFtpHttp){
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    }else{
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_61);
    if(useFtpHttp){
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    if(useFtpHttp){
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
		if(specify_alias){

    stringBuffer.append(TEXT_70);
    
		}

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    }else{
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
	boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
	if(specify_alias){
		String alias = ElementParameterParser.getValue(node, "__SAP_DATASOURCE_ALIAS__");
		if(null != alias && !("".equals(alias))){

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_80);
    
		}

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
	}

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_92);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(systemnumber);
    stringBuffer.append(TEXT_97);
    }else{
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(systemId);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    
	if(activeSNC){
	
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(partnerSNCName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(sncLevel);
    stringBuffer.append(TEXT_111);
    if(hasMySNCName){
    stringBuffer.append(TEXT_112);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_115);
    }
    stringBuffer.append(TEXT_116);
    if(hasSNCLibPath){
    stringBuffer.append(TEXT_117);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    
	}
	
    stringBuffer.append(TEXT_122);
    
    if(sapProps!=null) {
		for(Map<String, String> item : sapProps){
		
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_126);
     
		}
    }
	
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
	if(specify_alias){

    stringBuffer.append(TEXT_130);
    
	}

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_135);
    return stringBuffer.toString();
  }
}
