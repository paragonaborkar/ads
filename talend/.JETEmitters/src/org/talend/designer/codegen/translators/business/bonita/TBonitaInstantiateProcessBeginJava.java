package org.talend.designer.codegen.translators.business.bonita;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TBonitaInstantiateProcessBeginJava
{
  protected static String nl;
  public static synchronized TBonitaInstantiateProcessBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBonitaInstantiateProcessBeginJava result = new TBonitaInstantiateProcessBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\tString processInstanceUUID_";
  protected final String TEXT_3 = " = null;" + NL + "\t\t\tjava.util.Map<String,String> vars_";
  protected final String TEXT_4 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\t" + NL + "\t\t\torg.talend.bonita.RestClient client_";
  protected final String TEXT_5 = " = new org.talend.bonita.RestClient(";
  protected final String TEXT_6 = ");" + NL + "\t\t\t" + NL + "\t\t\tresourceMap.put(\"client_";
  protected final String TEXT_7 = "\", client_";
  protected final String TEXT_8 = "); ";
  protected final String TEXT_9 = NL + "\t\t\t";
  protected final String TEXT_10 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_11 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "; ";
  protected final String TEXT_16 = NL + "\t\t" + NL + "\t\t\tclient_";
  protected final String TEXT_17 = ".loginAs(";
  protected final String TEXT_18 = ", decryptedPassword_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\t\t\tString processID_";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = ";";
  protected final String TEXT_23 = NL + "\t\t\t\tString processID_";
  protected final String TEXT_24 = " = client_";
  protected final String TEXT_25 = ".getProcessID(";
  protected final String TEXT_26 = ",";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\t\tString processInstanceUUID_";
  protected final String TEXT_29 = " = null;" + NL + "\t\tStringBuilder parameters_";
  protected final String TEXT_30 = " = new StringBuilder(\"options=user:\");" + NL + "\t\tparameters_";
  protected final String TEXT_31 = ".append(";
  protected final String TEXT_32 = ");" + NL + "\t\tString url_";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = " + \"API/runtimeAPI/instantiateProcessWithVariables/\" + ";
  protected final String TEXT_35 = " +\"--\" +";
  protected final String TEXT_36 = ";" + NL + "\t\tjava.net.HttpURLConnection httpConn_";
  protected final String TEXT_37 = " = null;" + NL + "\t" + NL + "\t\thttpConn_";
  protected final String TEXT_38 = " = (java.net.HttpURLConnection) new java.net.URL(url_";
  protected final String TEXT_39 = ").openConnection();" + NL + "\t\tresourceMap.put(\"httpConn_";
  protected final String TEXT_40 = "\", httpConn_";
  protected final String TEXT_41 = "); " + NL + "\t\thttpConn_";
  protected final String TEXT_42 = ".setUseCaches (false);" + NL + "\t    httpConn_";
  protected final String TEXT_43 = ".setDoInput(true);" + NL + "\t    httpConn_";
  protected final String TEXT_44 = ".setDoOutput(true);" + NL + "\t    httpConn_";
  protected final String TEXT_45 = ".setInstanceFollowRedirects(false);" + NL + "\t    httpConn_";
  protected final String TEXT_46 = ".setRequestMethod(\"POST\");" + NL + "\t    httpConn_";
  protected final String TEXT_47 = ".setRequestProperty(\"Content-Type\", \"application/x-www-form-urlencoded\");" + NL + "\t        " + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_49 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_50 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = "; ";
  protected final String TEXT_55 = NL + "\t\t   \t" + NL + "\t    httpConn_";
  protected final String TEXT_56 = ".setRequestProperty(\"Authorization\", \"Basic \" + new String(org.apache.commons.codec.binary.Base64.encodeBase64((";
  protected final String TEXT_57 = "+ \":\"+ decryptedPassword_";
  protected final String TEXT_58 = ").getBytes(utf8Charset)),utf8Charset));" + NL + "\t";
  protected final String TEXT_59 = NL + "\t\t\tString processInstanceUUID_";
  protected final String TEXT_60 = " = null;" + NL + "\t\t\tjava.util.Map<String, Object> parameters_";
  protected final String TEXT_61 = "=new java.util.HashMap<String, Object>();" + NL + "\t\t\t" + NL + "\t\t\torg.talend.bonita.Client client_";
  protected final String TEXT_62 = " = new org.talend.bonita.Client(";
  protected final String TEXT_63 = ");" + NL + "\t\t\tresourceMap.put(\"client_";
  protected final String TEXT_64 = "\", client_";
  protected final String TEXT_65 = "); ";
  protected final String TEXT_66 = NL + "\t\t\t";
  protected final String TEXT_67 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_68 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = "; ";
  protected final String TEXT_73 = NL + "\t\t" + NL + "\t\t\tclient_";
  protected final String TEXT_74 = ".login(";
  protected final String TEXT_75 = ", decryptedPassword_";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = NL + "\t\t\tSystem.setProperty(\"BONITA_HOME\", ";
  protected final String TEXT_78 = ");" + NL + "\t\t";
  protected final String TEXT_79 = NL + "\t\t\tSystem.setProperty(\"org.ow2.bonita.environment\", ";
  protected final String TEXT_80 = " );" + NL + "\t\t";
  protected final String TEXT_81 = NL + "\t\tSystem.setProperty(\"java.security.auth.login.config\", ";
  protected final String TEXT_82 = " );" + NL + "\t\tSystem.setProperty(\"java.util.logging.config.file\", new java.io.File(";
  protected final String TEXT_83 = ").toURI().toURL().toString());" + NL + "\t\t" + NL + "\t\t" + NL + "\t\torg.ow2.bonita.facade.RuntimeAPI runtimeAPI_";
  protected final String TEXT_84 = " = org.ow2.bonita.util.AccessorUtil.getAPIAccessor().getRuntimeAPI();" + NL + "\t\tjavax.security.auth.login.LoginContext loginContext_";
  protected final String TEXT_85 = " = null;" + NL + "\t\torg.ow2.bonita.facade.uuid.ProcessDefinitionUUID processID_";
  protected final String TEXT_86 = " =null;" + NL + "\t\t" + NL + "\t\tString processInstanceUUID_";
  protected final String TEXT_87 = " = null;" + NL + "\t\tjava.util.Map<String, Object> parameters_";
  protected final String TEXT_88 = "=new java.util.HashMap<String, Object>();" + NL + "\t        " + NL + "\t\t";
  protected final String TEXT_89 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_90 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_91 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_92 = ");";
  protected final String TEXT_93 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_94 = " = ";
  protected final String TEXT_95 = "; ";
  protected final String TEXT_96 = NL + "\t   \t" + NL + "\t\tloginContext_";
  protected final String TEXT_97 = " = new javax.security.auth.login.LoginContext(";
  protected final String TEXT_98 = ", new org.ow2.bonita.util.SimpleCallbackHandler(";
  protected final String TEXT_99 = ", decryptedPassword_";
  protected final String TEXT_100 = "));" + NL + "\t\tresourceMap.put(\"loginContext_";
  protected final String TEXT_101 = "\", loginContext_";
  protected final String TEXT_102 = "); " + NL + "\t\tloginContext_";
  protected final String TEXT_103 = ".login();" + NL + "\t\t";
  protected final String TEXT_104 = NL + "\t\t\tprocessID_";
  protected final String TEXT_105 = " = new org.ow2.bonita.facade.uuid.ProcessDefinitionUUID(";
  protected final String TEXT_106 = ");" + NL + "\t\t";
  protected final String TEXT_107 = NL + "\t\t\tprocessID_";
  protected final String TEXT_108 = " = new org.ow2.bonita.facade.uuid.ProcessDefinitionUUID(";
  protected final String TEXT_109 = ", ";
  protected final String TEXT_110 = ");" + NL + "\t\t";
  protected final String TEXT_111 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String clientMode = ElementParameterParser.getValue(node, "__CLIENT_MODE__");
	if ("HTTP_CLIENT".equals(clientMode)) {
		String url = ElementParameterParser.getValue(node, "__BONITA_URL__");
		String authUserName = ElementParameterParser.getValue(node, "__AUTH_USERNAME__");
		String process_name = ElementParameterParser.getValue(node, "__PROCESS_NAME__");
		String process_version = ElementParameterParser.getValue(node, "__PROCESS_VERSION__");
		String userName = ElementParameterParser.getValue(node, "__USERNAME__");
		
		String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
		
		if("BONITA_652".equals(dbVersion) || "BONITA_724".equals(dbVersion)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
			String passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_9);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_12);
    } else {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
			boolean use_process_id = "true".equals(ElementParameterParser.getValue(node, "__USE_PROCESS_ID__"));
			if(use_process_id) {
				String processID = ElementParameterParser.getValue(node, "__PROCESS_ID__");

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(processID);
    stringBuffer.append(TEXT_22);
    
			} else {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(process_name);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(process_version);
    stringBuffer.append(TEXT_27);
    
			}
			
			return stringBuffer.toString();
		}

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(process_name);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(process_version);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
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
    
		String passwordFieldName = "__AUTH_PASSWD__";
		
    stringBuffer.append(TEXT_48);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_51);
    } else {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(authUserName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
	} else { // JAVA CLIENT
	
		String processID = ElementParameterParser.getValue(node, "__PROCESS_ID__");
		String userName = ElementParameterParser.getValue(node, "__USERNAME__");
	
		String use_process_id = ElementParameterParser.getValue(node, "__USE_PROCESS_ID__");
	
		String process_name = ElementParameterParser.getValue(node, "__PROCESS_NAME__");
		String process_version = ElementParameterParser.getValue(node, "__PROCESS_VERSION__");
		
		boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
		
		String bonitaEnvironmentFile = ElementParameterParser.getValue(node, "__BONITA_ENVIRONMENT_FILE__");
		String jassFile = ElementParameterParser.getValue(node, "__JASS_STANDARD_FILE__");
		String loggingFile = ElementParameterParser.getValue(node, "__LOGGING_FILE__");
		String loginModule = ElementParameterParser.getValue(node, "__LOGIN_MODULE__");
		String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
		String bonitaHome = ElementParameterParser.getValue(node, "__BONITA_HOME__");
		
		if("BONITA_652".equals(dbVersion) || "BONITA_724".equals(dbVersion)) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(bonitaHome);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
			String passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_66);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_69);
    } else {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
			return stringBuffer.toString();
		}
		
		if("BONITA_561".equals(dbVersion) || "BONITA_5101".equals(dbVersion)){
		
    stringBuffer.append(TEXT_77);
    stringBuffer.append(bonitaHome);
    stringBuffer.append(TEXT_78);
    
		}else if("BONITA_531".equals(dbVersion)||"BONITA_523".equals(dbVersion)){
		
    stringBuffer.append(TEXT_79);
    stringBuffer.append(bonitaEnvironmentFile);
    stringBuffer.append(TEXT_80);
    
		}
		
    stringBuffer.append(TEXT_81);
    stringBuffer.append(jassFile);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(loggingFile);
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
    
		String passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_89);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_92);
    } else {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_95);
    }
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(loginModule);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
		if("true".equals(use_process_id)) {
		
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(processID);
    stringBuffer.append(TEXT_106);
    
		} else {
		
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(process_name);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(process_version);
    stringBuffer.append(TEXT_110);
    
		}
	}
	
    stringBuffer.append(TEXT_111);
    return stringBuffer.toString();
  }
}
