package org.talend.designer.codegen.translators.business.openbravo;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TOpenbravoERPOutputBeginJava
{
  protected static String nl;
  public static synchronized TOpenbravoERPOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOpenbravoERPOutputBeginJava result = new TOpenbravoERPOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_3 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = "; ";
  protected final String TEXT_8 = NL + "final String ob_url_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = ";" + NL + "final String login_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ";" + NL + "" + NL + "final String pwd_";
  protected final String TEXT_13 = " = decryptedPassword_";
  protected final String TEXT_14 = ";" + NL + "final String method_";
  protected final String TEXT_15 = " = \"POST\";" + NL + "final String file_";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = ";" + NL + "java.net.Authenticator.setDefault(new java.net.Authenticator() {" + NL + "\tprotected java.net.PasswordAuthentication getPasswordAuthentication() {" + NL + "\t\treturn new java.net.PasswordAuthentication(login_";
  protected final String TEXT_18 = ", pwd_";
  protected final String TEXT_19 = ".toCharArray());" + NL + "\t}" + NL + "});" + NL + "final java.net.URL url_";
  protected final String TEXT_20 = " = new java.net.URL(ob_url_";
  protected final String TEXT_21 = ");" + NL + "final java.net.HttpURLConnection hc_";
  protected final String TEXT_22 = " = (java.net.HttpURLConnection) url_";
  protected final String TEXT_23 = ".openConnection();" + NL + "hc_";
  protected final String TEXT_24 = ".setRequestMethod(method_";
  protected final String TEXT_25 = ");" + NL + "hc_";
  protected final String TEXT_26 = ".setAllowUserInteraction(false);" + NL + "hc_";
  protected final String TEXT_27 = ".setDefaultUseCaches(false);" + NL + "hc_";
  protected final String TEXT_28 = ".setDoOutput(true);" + NL + "hc_";
  protected final String TEXT_29 = ".setDoInput(true);" + NL + "hc_";
  protected final String TEXT_30 = ".setInstanceFollowRedirects(true);" + NL + "hc_";
  protected final String TEXT_31 = ".setUseCaches(false);" + NL + "hc_";
  protected final String TEXT_32 = ".setRequestProperty(\"Content-Type\", \"text/xml\");" + NL + "byte[] bytes_";
  protected final String TEXT_33 = " = new byte[1024];" + NL + "java.io.InputStream is_";
  protected final String TEXT_34 = " = new java.io.BufferedInputStream(new java.io.FileInputStream(file_";
  protected final String TEXT_35 = "));" + NL + "java.io.OutputStream os_";
  protected final String TEXT_36 = " = hc_";
  protected final String TEXT_37 = ".getOutputStream();" + NL + "int read_";
  protected final String TEXT_38 = " = 0;" + NL + "do{" + NL + "\tread_";
  protected final String TEXT_39 = " = is_";
  protected final String TEXT_40 = ".read(bytes_";
  protected final String TEXT_41 = ");" + NL + "\tif(read_";
  protected final String TEXT_42 = ">0){" + NL + "\t\tos_";
  protected final String TEXT_43 = ".write(bytes_";
  protected final String TEXT_44 = ", 0, read_";
  protected final String TEXT_45 = ");" + NL + "\t}" + NL + "}while(read_";
  protected final String TEXT_46 = " >= 1024);" + NL + "os_";
  protected final String TEXT_47 = ".flush();" + NL + "os_";
  protected final String TEXT_48 = ".close();" + NL + "is_";
  protected final String TEXT_49 = ".close();" + NL + "hc_";
  protected final String TEXT_50 = ".connect();" + NL + "if(hc_";
  protected final String TEXT_51 = ".getResponseCode() == 200){" + NL + "\torg.dom4j.io.SAXReader sr_";
  protected final String TEXT_52 = " = new org.dom4j.io.SAXReader();" + NL + "\tis_";
  protected final String TEXT_53 = " = hc_";
  protected final String TEXT_54 = ".getInputStream();" + NL + "\tif(is_";
  protected final String TEXT_55 = ".available()>0){" + NL + "\t\torg.dom4j.Document doc_";
  protected final String TEXT_56 = " = sr_";
  protected final String TEXT_57 = ".read(is_";
  protected final String TEXT_58 = ");" + NL + "\t\torg.dom4j.io.OutputFormat format_";
  protected final String TEXT_59 = " = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "      \tformat_";
  protected final String TEXT_60 = ".setEncoding(\"UTF-8\");" + NL + "      \tformat_";
  protected final String TEXT_61 = ".setTrimText(false);" + NL + "      \tjava.io.StringWriter out_";
  protected final String TEXT_62 = " = new java.io.StringWriter();" + NL + "      \torg.dom4j.io.XMLWriter writer_";
  protected final String TEXT_63 = " = new org.dom4j.io.XMLWriter(out_";
  protected final String TEXT_64 = ", format_";
  protected final String TEXT_65 = ");" + NL + "      \twriter_";
  protected final String TEXT_66 = ".write(doc_";
  protected final String TEXT_67 = ");" + NL + "      \twriter_";
  protected final String TEXT_68 = ".close();" + NL + "       \tString content_";
  protected final String TEXT_69 = " = out_";
  protected final String TEXT_70 = ".toString();" + NL + "       \tSystem.out.println(content_";
  protected final String TEXT_71 = ");" + NL + "\t}" + NL + "}else{" + NL + "\tSystem.out.println(\"HTTP Response Code: \"+hc_";
  protected final String TEXT_72 = ".getResponseCode());" + NL + "}" + NL + "hc_";
  protected final String TEXT_73 = ".disconnect();";
  protected final String TEXT_74 = NL + "int nb_line_";
  protected final String TEXT_75 = " = 0;" + NL + "int nb_line_updated_";
  protected final String TEXT_76 = " = 0;" + NL + "int nb_line_created_";
  protected final String TEXT_77 = " = 0;" + NL + "int nb_line_removed_";
  protected final String TEXT_78 = " = 0;" + NL + "int nb_line_unauthorized_";
  protected final String TEXT_79 = " = 0;" + NL + "int nb_line_failed_";
  protected final String TEXT_80 = " = 0;" + NL + "final String ob_url_";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ";" + NL + "final String login_";
  protected final String TEXT_83 = " = ";
  protected final String TEXT_84 = ";" + NL + "final String pwd_";
  protected final String TEXT_85 = " = decryptedPassword_";
  protected final String TEXT_86 = ";" + NL + "final String entity_";
  protected final String TEXT_87 = " = \"";
  protected final String TEXT_88 = "\";" + NL + "java.net.Authenticator.setDefault(new java.net.Authenticator() {" + NL + "\tprotected java.net.PasswordAuthentication getPasswordAuthentication() {" + NL + "\t\treturn new java.net.PasswordAuthentication(login_";
  protected final String TEXT_89 = ", pwd_";
  protected final String TEXT_90 = ".toCharArray());" + NL + "\t}" + NL + "});" + NL + "String urlString_";
  protected final String TEXT_91 = " = ob_url_";
  protected final String TEXT_92 = ".trim() + \"/\" + entity_";
  protected final String TEXT_93 = ".trim() + \"/\";";
  protected final String TEXT_94 = NL + "final String method_";
  protected final String TEXT_95 = " = \"DELETE\";";
  protected final String TEXT_96 = NL + "StringBuilder sb_";
  protected final String TEXT_97 = " = new StringBuilder(\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" ?>\\n<ob:Openbravo xmlns:ob=\\\"http://www.openbravo.com\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\">\\n\");" + NL + "int xmlHeadLength_";
  protected final String TEXT_98 = " = sb_";
  protected final String TEXT_99 = ".length();" + NL + "final String method_";
  protected final String TEXT_100 = " = \"POST\";" + NL + "//The order will be the same as the one in tOpenbravoERPInput." + NL + "final String[] referenceAttributes_";
  protected final String TEXT_101 = " = {\"id\", \"entity-name\", \"identifier\", \"transient\", \"inactive\"};";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
    
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
	String entityName = ElementParameterParser.getValue(node, "__ENTITYNAME__");
	//String encoding = ElementParameterParser.getValue(node, "__ENCODING__");

	String username = ElementParameterParser.getValue(node, "__USER__");


	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String usingExistingFile = ElementParameterParser.getValue(node, "__USE_EXISTING_FILE__");
	String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
	
	String passwordFieldName = "__PASS__";

    stringBuffer.append(TEXT_1);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_4);
    } else {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_7);
    }
    

	if("UPDATE_CREATE".equals(action) && "true".equals(usingExistingFile)){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(endpoint );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(fileName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    
	}else{

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(endpoint );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(entityName );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    
	if(action.equals("REMOVE")){

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    
	}else if(action.equals("UPDATE_CREATE")){//if(action.equals("REMOVE")){

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    
	}//end
}

    return stringBuffer.toString();
  }
}
