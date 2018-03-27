package org.talend.designer.codegen.translators.business.microsoft_ax;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.List;
import java.util.Map;

public class TMSAXOutputBeginJava
{
  protected static String nl;
  public static synchronized TMSAXOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMSAXOutputBeginJava result = new TMSAXOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "    int keyCount_";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ";" + NL + "    if(keyCount_";
  protected final String TEXT_6 = " < 1){" + NL + "    \tthrow new RuntimeException(\"For update or delete, Schema must have a key\");" + NL + "    }";
  protected final String TEXT_7 = " " + NL + "" + NL + "int nb_line_";
  protected final String TEXT_8 = " = 0;" + NL + "int nb_line_update_";
  protected final String TEXT_9 = " = 0;" + NL + "int nb_line_inserted_";
  protected final String TEXT_10 = " = 0;" + NL + "int nb_line_deleted_";
  protected final String TEXT_11 = " = 0;" + NL + "int nb_line_rejected_";
  protected final String TEXT_12 = " = 0;" + NL + "" + NL + "int deletedCount_";
  protected final String TEXT_13 = "=0;" + NL + "int updatedCount_";
  protected final String TEXT_14 = "=0;" + NL + "int insertedCount_";
  protected final String TEXT_15 = "=0;" + NL + "" + NL + "boolean whetherReject_";
  protected final String TEXT_16 = " = false;" + NL;
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_19 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = "; ";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + "\tjava.util.Calendar calendar_";
  protected final String TEXT_26 = " = java.util.Calendar.getInstance();" + NL + "\tcalendar_";
  protected final String TEXT_27 = ".set(1, 0, 1, 0, 0, 0);" + NL + "\tlong year1_";
  protected final String TEXT_28 = " = calendar_";
  protected final String TEXT_29 = ".getTime().getTime();" + NL + "\tcalendar_";
  protected final String TEXT_30 = ".set(10000, 0, 1, 0, 0, 0);" + NL + "\tlong year10000_";
  protected final String TEXT_31 = " = calendar_";
  protected final String TEXT_32 = ".getTime().getTime();" + NL + "\tlong date_";
  protected final String TEXT_33 = ";" + NL + "\t" + NL + "\t//connect to com server" + NL + "\torg.jinterop.dcom.common.JISystem.setAutoRegisteration(true);" + NL + "\torg.jinterop.dcom.core.JISession session_";
  protected final String TEXT_34 = " = org.jinterop.dcom.core.JISession.createSession(";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = ", decryptedPassword_";
  protected final String TEXT_37 = ");" + NL + "\torg.jinterop.dcom.core.JIClsid clsid_";
  protected final String TEXT_38 = " = org.jinterop.dcom.core.JIClsid.valueOf(\"71421B8A-81A8-4373-BD8D-E0D83B0B3DAB\");" + NL + "\torg.jinterop.dcom.core.JIComServer comServer_";
  protected final String TEXT_39 = " = new org.jinterop.dcom.core.JIComServer(clsid_";
  protected final String TEXT_40 = ", ";
  protected final String TEXT_41 = ", session_";
  protected final String TEXT_42 = ");" + NL + "\t" + NL + "\t//get IAxapta3 interface" + NL + "\torg.jinterop.dcom.core.IJIComObject comObject_";
  protected final String TEXT_43 = " = comServer_";
  protected final String TEXT_44 = ".createInstance();" + NL + "\torg.jinterop.dcom.win32.IJIDispatch  axapta3_";
  protected final String TEXT_45 = " = (org.jinterop.dcom.win32.IJIDispatch) org.jinterop.dcom.win32.ComFactory.createCOMInstance(" + NL + "\t                    org.jinterop.dcom.win32.ComFactory.IID_IDispatch, comObject_";
  protected final String TEXT_46 = ");" + NL + "\t" + NL + "\t//logon ax server" + NL + "\taxapta3_";
  protected final String TEXT_47 = ".callMethod(\"Logon\", " + NL + "\t\tnew Object[] { ";
  protected final String TEXT_48 = ", ";
  protected final String TEXT_49 = ", ";
  protected final String TEXT_50 = ", ";
  protected final String TEXT_51 = " });" + NL + "\t" + NL + "\t//init record" + NL + "\torg.jinterop.dcom.core.JIVariant[] results_";
  protected final String TEXT_52 = " = axapta3_";
  protected final String TEXT_53 = ".callMethodA(\"CreateRecord\", new Object[]{";
  protected final String TEXT_54 = " });" + NL + "\torg.jinterop.dcom.win32.IJIDispatch record_";
  protected final String TEXT_55 = " = (org.jinterop.dcom.win32.IJIDispatch) results_";
  protected final String TEXT_56 = "[0].getObjectAsComObject(comObject_";
  protected final String TEXT_57 = ");" + NL + "\t" + NL + "\t//begin modify" + NL + "\taxapta3_";
  protected final String TEXT_58 = ".callMethod(\"TTSBegin\");" + NL;
  protected final String TEXT_59 = "\t" + NL + "\t//init .NET businnes connector" + NL + "    org.talend.net.Object netBC_";
  protected final String TEXT_60 = " = org.talend.net.Object.createInstance(";
  protected final String TEXT_61 = ",\"Microsoft.Dynamics.BusinessConnectorNet.Axapta\");" + NL + "    //logon ax server" + NL + "    org.talend.net.Object cred_";
  protected final String TEXT_62 = " = org.talend.net.Object.createInstance(" + NL + "        \"System, Version=2.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089\", \"System.Net.NetworkCredential\"," + NL + "        new java.lang.Object[] { ";
  protected final String TEXT_63 = ", decryptedPassword_";
  protected final String TEXT_64 = ", ";
  protected final String TEXT_65 = " });" + NL + "\t\t    " + NL + "    netBC_";
  protected final String TEXT_66 = ".invoke(\"LogonAs\", new Object[]{";
  protected final String TEXT_67 = ",";
  protected final String TEXT_68 = ",cred_";
  protected final String TEXT_69 = ",";
  protected final String TEXT_70 = ",";
  protected final String TEXT_71 = ",";
  protected final String TEXT_72 = "+\"@\"+";
  protected final String TEXT_73 = "+\":\"+";
  protected final String TEXT_74 = ",";
  protected final String TEXT_75 = "});" + NL + "" + NL + " \t//Create a record for a specific table." + NL + "    org.talend.net.Object dynRec_";
  protected final String TEXT_76 = " = netBC_";
  protected final String TEXT_77 = ".invoke(\"CreateAxaptaRecord\",new Object[]{";
  protected final String TEXT_78 = "});";
  protected final String TEXT_79 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
    List<Map<String, String>> addCols =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,"__ADD_COLS__" );
    String axHost = ElementParameterParser.getValue(node, "__HOST__");
	String axDomain = ElementParameterParser.getValue(node, "__DOMAIN__");
	String axUser= ElementParameterParser.getValue(node, "__USER__");

	String axTable = ElementParameterParser.getValue(node,"__TABLE__");
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
	String assemblyName = ElementParameterParser.getValue(node, "__ASSEMBLY_NAME__");
    String port = ElementParameterParser.getValue(node, "__PORT__");
	String aosServer = ElementParameterParser.getValue(node, "__AOS_SERVER_INSTANCE__");
	String company = ElementParameterParser.getValue(node, "__COMPANY__");
	String language = ElementParameterParser.getValue(node, "__LANGUAGE__");
	String configurationFile = ElementParameterParser.getValue(node, "__CONFIGURATION_FILE__");
    
    List<IMetadataColumn> columnList = null;
    List<IMetadataTable> metadatas = node.getMetadataList();
    if(metadatas !=null && metadatas.size()>0){
    	IMetadataTable metadata = metadatas.get(0);
    	if(metadata != null){
    		columnList = metadata.getListColumns();
    	}
    }

    stringBuffer.append(TEXT_2);
    
if(!("INSERT").equals(dataAction)){
    int keyCount = 0;
    for(IMetadataColumn column:columnList){
    	if(column.isKey()){
    		keyCount++;
    	}
    }

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
}

class VariantTool{
	public String vStr(String value){
		return "new org.jinterop.dcom.core.JIVariant(new org.jinterop.dcom.core.JIString("+value+"))";
	}
	public String vInt(int value){
		return "new org.jinterop.dcom.core.JIVariant("+value+")";
	}
}
VariantTool vTool = new VariantTool();

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
String passwordFieldName = "__PASS__";

    stringBuffer.append(TEXT_17);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_20);
    } else {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    
if("DCOM".equals(connectionType)){

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(axDomain);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(axUser);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(axHost);
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
    stringBuffer.append(vTool.vStr("\"\""));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(vTool.vStr("\"\""));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(vTool.vStr("\"\""));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(vTool.vStr("\"\""));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(vTool.vStr(axTable));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
}else{

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(assemblyName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(axUser);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(axDomain);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(axUser);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(axDomain);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(company);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(aosServer);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(axHost);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(configurationFile);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(axTable);
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    return stringBuffer.toString();
  }
}
