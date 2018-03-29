package org.talend.designer.codegen.translators.business.bonita;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TBonitaDeployMainJava
{
  protected static String nl;
  public static synchronized TBonitaDeployMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBonitaDeployMainJava result = new TBonitaDeployMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t";
  protected final String TEXT_3 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_4 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = "; ";
  protected final String TEXT_9 = NL + "\t\t\torg.talend.bonita.RestClient client_";
  protected final String TEXT_10 = " = null;" + NL + "\t\t\tString processId_";
  protected final String TEXT_11 = " = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\tclient_";
  protected final String TEXT_12 = " = new org.talend.bonita.RestClient(";
  protected final String TEXT_13 = ");" + NL + "\t\t\t" + NL + "\t\t\t\tclient_";
  protected final String TEXT_14 = ".loginAs(";
  protected final String TEXT_15 = ", decryptedPassword_";
  protected final String TEXT_16 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\tprocessId_";
  protected final String TEXT_17 = " = client_";
  protected final String TEXT_18 = ".deployProcess(";
  protected final String TEXT_19 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\tSystem.out.println(\"**** Process \"+ processId_";
  protected final String TEXT_20 = " + \" deploy successful ****\");" + NL + "\t\t\t" + NL + "\t\t\t} catch(java.lang.Exception e_";
  protected final String TEXT_21 = ") {";
  protected final String TEXT_22 = NL + "\t\t\t\tthrow e_";
  protected final String TEXT_23 = ";\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_25 = ".getMessage());";
  protected final String TEXT_26 = NL + "\t\t\t} finally {" + NL + "\t\t\t\tif(client_";
  protected final String TEXT_27 = "!=null) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tclient_";
  protected final String TEXT_28 = ".logout();" + NL + "\t\t\t\t\t\tclient_";
  protected final String TEXT_29 = ".close();" + NL + "\t\t\t\t\t} catch(java.lang.Exception e_";
  protected final String TEXT_30 = ") {" + NL + "\t\t\t\t\t\t//do nothing,keep quiet" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_31 = "_ProcessDefinitionUUID\", processId_";
  protected final String TEXT_32 = "); ";
  protected final String TEXT_33 = NL + "\t\t\torg.talend.bonita.Client client_";
  protected final String TEXT_34 = " = null;" + NL + "\t\t\tString processId_";
  protected final String TEXT_35 = " = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\tclient_";
  protected final String TEXT_36 = " = new org.talend.bonita.Client(";
  protected final String TEXT_37 = ");" + NL + "\t\t        client_";
  protected final String TEXT_38 = ".login(";
  protected final String TEXT_39 = ", decryptedPassword_";
  protected final String TEXT_40 = ");" + NL + "\t\t        processId_";
  protected final String TEXT_41 = " = client_";
  protected final String TEXT_42 = ".deployProcess(";
  protected final String TEXT_43 = ");" + NL + "\t\t        " + NL + "\t\t        System.out.println(\"**** Process \"+ processId_";
  protected final String TEXT_44 = " + \" deploy successful ****\");" + NL + "\t        } catch(java.lang.Exception e_";
  protected final String TEXT_45 = ") {";
  protected final String TEXT_46 = NL + "\t\t\t\tthrow e_";
  protected final String TEXT_47 = ";\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_49 = ".getMessage());";
  protected final String TEXT_50 = NL + "\t\t\t} finally {" + NL + "\t\t\t\tif(client_";
  protected final String TEXT_51 = "!=null) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tclient_";
  protected final String TEXT_52 = ".logout();" + NL + "\t\t\t\t\t} catch(java.lang.Exception e_";
  protected final String TEXT_53 = ") {" + NL + "\t\t\t\t\t\t//do nothing,keep quiet" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_54 = "_ProcessDefinitionUUID\", processId_";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\tSystem.setProperty(\"BONITA_HOME\", ";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "\tSystem.setProperty(\"org.ow2.bonita.environment\", ";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "\tSystem.setProperty(\"java.security.auth.login.config\", ";
  protected final String TEXT_61 = " );" + NL + "\tSystem.setProperty(\"java.util.logging.config.file\", new java.io.File(";
  protected final String TEXT_62 = ").toURI().toURL().toString());" + NL + "\t" + NL + "\t" + NL + "\torg.ow2.bonita.facade.ManagementAPI managementAPI_";
  protected final String TEXT_63 = " = org.ow2.bonita.util.AccessorUtil.getAPIAccessor().getManagementAPI();" + NL + "\tjavax.security.auth.login.LoginContext loginContext_";
  protected final String TEXT_64 = " = null;" + NL + "\torg.ow2.bonita.facade.def.majorElement.ProcessDefinition process_";
  protected final String TEXT_65 = " = null;" + NL + "\t" + NL + "\tString processDefinitionUUID_";
  protected final String TEXT_66 = " = null;" + NL + "\ttry {" + NL + "\t\t\t        " + NL + "\t\t";
  protected final String TEXT_67 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_68 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_69 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_72 = " = ";
  protected final String TEXT_73 = "; ";
  protected final String TEXT_74 = NL + "\t   \t" + NL + "\t\tloginContext_";
  protected final String TEXT_75 = " = new javax.security.auth.login.LoginContext(";
  protected final String TEXT_76 = ", new org.ow2.bonita.util.SimpleCallbackHandler(";
  protected final String TEXT_77 = ", decryptedPassword_";
  protected final String TEXT_78 = "));" + NL + "\t\tloginContext_";
  protected final String TEXT_79 = ".login();" + NL + "\t\tprocess_";
  protected final String TEXT_80 = " = managementAPI_";
  protected final String TEXT_81 = ".deploy(org.ow2.bonita.util.BusinessArchiveFactory.getBusinessArchive(new java.io.File(";
  protected final String TEXT_82 = ").toURI().toURL()));" + NL + "\t\tprocessDefinitionUUID_";
  protected final String TEXT_83 = " = process_";
  protected final String TEXT_84 = ".getUUID().getValue();" + NL + "\t\t" + NL + "\t\tSystem.out.println(\"**** Process \"+ processDefinitionUUID_";
  protected final String TEXT_85 = " + \" deploy successful ****\");" + NL + "" + NL + "\t} catch (javax.security.auth.login.LoginException le_";
  protected final String TEXT_86 = ") {//just login exception";
  protected final String TEXT_87 = NL + "\t\tthrow le_";
  protected final String TEXT_88 = ";\t\t";
  protected final String TEXT_89 = NL + "\t\tSystem.err.println(le_";
  protected final String TEXT_90 = ".getCause().getMessage());";
  protected final String TEXT_91 = "\t\t" + NL + "\t} catch (java.lang.Exception e_";
  protected final String TEXT_92 = ") {";
  protected final String TEXT_93 = NL + "\t\tthrow e_";
  protected final String TEXT_94 = ";\t\t";
  protected final String TEXT_95 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_96 = ".getMessage());";
  protected final String TEXT_97 = NL + "\t} finally {" + NL + "\t\tloginContext_";
  protected final String TEXT_98 = ".logout();" + NL + "\t}" + NL + "" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_99 = "_ProcessDefinitionUUID\", processDefinitionUUID_";
  protected final String TEXT_100 = "); ";
  protected final String TEXT_101 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String businessArchive = ElementParameterParser.getValue(node, "__BUSINESS_ARCHIVE__");
	String userName = ElementParameterParser.getValue(node, "__USERNAME__");
	
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	
	String bonitaEnvironmentFile = ElementParameterParser.getValue(node, "__BONITA_ENVIRONMENT_FILE__");
	String jassFile = ElementParameterParser.getValue(node, "__JASS_STANDARD_FILE__");
	String loggingFile = ElementParameterParser.getValue(node, "__LOGGING_FILE__");
	String loginModule = ElementParameterParser.getValue(node, "__LOGIN_MODULE__");
	String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
	String bonitaHome = ElementParameterParser.getValue(node, "__BONITA_HOME__");
	
	String clientMode = ElementParameterParser.getValue(node, "__CLIENT_MODE__");
	if("BONITA_652".equals(dbVersion) || "BONITA_724".equals(dbVersion)) {
		String passwordFieldName = "__PASSWORD__";

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
    
		if("HTTP_CLIENT".equals(clientMode)) {
			String url = ElementParameterParser.getValue(node, "__BONITA_URL__");

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(businessArchive);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
			if (dieOnError) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
			} else {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
			}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
			
		} else if("JAVA_CLIENT".equals(clientMode)) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(bonitaHome);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(businessArchive);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
			if (dieOnError) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
			} else {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
			}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
		}
		
		return stringBuffer.toString();
	}
	
	if("BONITA_561".equals(dbVersion) || "BONITA_5101".equals(dbVersion)){

    stringBuffer.append(TEXT_56);
    stringBuffer.append(bonitaHome);
    stringBuffer.append(TEXT_57);
    
	}else if("BONITA_531".equals(dbVersion)||"BONITA_523".equals(dbVersion)){

    stringBuffer.append(TEXT_58);
    stringBuffer.append(bonitaEnvironmentFile);
    stringBuffer.append(TEXT_59);
    
	}

    stringBuffer.append(TEXT_60);
    stringBuffer.append(jassFile);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(loggingFile);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
		String passwordFieldName = "__PASSWORD__";
		
    stringBuffer.append(TEXT_67);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_70);
    } else {
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(loginModule);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(businessArchive);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
	if (dieOnError) {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
	} else {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    	
	}

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
	if (dieOnError) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
	} else {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    	
	}

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(TEXT_101);
    return stringBuffer.toString();
  }
}
