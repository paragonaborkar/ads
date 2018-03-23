package org.talend.designer.codegen.translators.business.microsoft_ax;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TMSAXInputBeginJava
{
  protected static String nl;
  public static synchronized TMSAXInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMSAXInputBeginJava result = new TMSAXInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "        " + NL + "\t\t";
  protected final String TEXT_3 = NL + NL + "\t\t";
  protected final String TEXT_4 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_5 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = "; ";
  protected final String TEXT_10 = NL + "        " + NL + "        ";
  protected final String TEXT_11 = NL + "            //connect to com server" + NL + "            org.jinterop.dcom.common.JISystem.setAutoRegisteration(true);" + NL + "            org.jinterop.dcom.core.JISession session_";
  protected final String TEXT_12 = " = org.jinterop.dcom.core.JISession.createSession(";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = ", decryptedPassword_";
  protected final String TEXT_15 = ");" + NL + "            org.jinterop.dcom.core.JIClsid clsid_";
  protected final String TEXT_16 = " = org.jinterop.dcom.core.JIClsid.valueOf(\"71421B8A-81A8-4373-BD8D-E0D83B0B3DAB\");" + NL + "            org.jinterop.dcom.core.JIComServer comServer_";
  protected final String TEXT_17 = " = new org.jinterop.dcom.core.JIComServer(clsid_";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = ", session_";
  protected final String TEXT_20 = ");" + NL + "" + NL + "            //get IAxapta3 interface" + NL + "            org.jinterop.dcom.core.IJIComObject comObject_";
  protected final String TEXT_21 = " = comServer_";
  protected final String TEXT_22 = ".createInstance();" + NL + "            org.jinterop.dcom.win32.IJIDispatch  axapta3_";
  protected final String TEXT_23 = " = (org.jinterop.dcom.win32.IJIDispatch) org.jinterop.dcom.win32.ComFactory.createCOMInstance(" + NL + "                    org.jinterop.dcom.win32.ComFactory.IID_IDispatch, comObject_";
  protected final String TEXT_24 = ");" + NL + "" + NL + "\t\t    //logon ax server" + NL + "\t\t    axapta3_";
  protected final String TEXT_25 = ".callMethod(\"Logon\", " + NL + "\t\t\t    new Object[] { ";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = ", ";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = " });" + NL + "\t" + NL + "\t\t    //init record" + NL + "\t\t    org.jinterop.dcom.core.JIVariant[] results_";
  protected final String TEXT_30 = " = axapta3_";
  protected final String TEXT_31 = ".callMethodA(\"CreateRecord\", new Object[]{";
  protected final String TEXT_32 = " });" + NL + "\t\t    org.jinterop.dcom.win32.IJIDispatch record_";
  protected final String TEXT_33 = " = (org.jinterop.dcom.win32.IJIDispatch) results_";
  protected final String TEXT_34 = "[0].getObjectAsComObject(comObject_";
  protected final String TEXT_35 = ");" + NL + "\t\t" + NL + "\t\t    //exe the SQL query" + NL + "\t\t    String sqlstmt_";
  protected final String TEXT_36 = " = ";
  protected final String TEXT_37 = ";" + NL + "\t\t    org.jinterop.dcom.core.JIVariant sqlStmtVar_";
  protected final String TEXT_38 = " = new org.jinterop.dcom.core.JIVariant(new org.jinterop.dcom.core.JIString(sqlstmt_";
  protected final String TEXT_39 = "));" + NL + "\t\t    record_";
  protected final String TEXT_40 = ".callMethod(\"ExecuteStmt\", new Object[] { sqlStmtVar_";
  protected final String TEXT_41 = "});" + NL + "" + NL + "\t\t\tjava.util.Calendar calendar_";
  protected final String TEXT_42 = " = java.util.Calendar.getInstance();" + NL + "\t\t\tcalendar_";
  protected final String TEXT_43 = ".set(0, 0, 0, 0, 0, 0);" + NL + "\t\t\tjava.util.Date year0_";
  protected final String TEXT_44 = " = calendar_";
  protected final String TEXT_45 = ".getTime();" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_46 = "_QUERY\",";
  protected final String TEXT_47 = ");" + NL + "\t\t\t" + NL + "\t\t\t//loop record" + NL + "\t\t\twhile(record_";
  protected final String TEXT_48 = ".get(\"Found\").getObjectAsBoolean()){" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_49 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_50 = " \t" + NL + "\t\t\t\t\t\t\t{" + NL + "\t\t\t\t\t\t\t\torg.jinterop.dcom.core.JIVariant[] field_";
  protected final String TEXT_51 = " =  record_";
  protected final String TEXT_52 = ".get(\"field\", new Object[] { ";
  protected final String TEXT_53 = " });" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\t\t\t\t \tif(field_";
  protected final String TEXT_55 = "!=null && field_";
  protected final String TEXT_56 = ".length>0 && field_";
  protected final String TEXT_57 = "[0].getObject() != null)" + NL + "\t\t\t\t\t\t\t \t{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = " = (List)field_";
  protected final String TEXT_61 = "[0].getObjectAsArray().getArrayInstance();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = " = field_";
  protected final String TEXT_65 = "[0].getObject();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " = field_";
  protected final String TEXT_69 = "[0].getObjectAsString().getString();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = " = field_";
  protected final String TEXT_73 = "[0].getObjectAs";
  protected final String TEXT_74 = "();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\t\t \t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t \t\t\t\t\t\t";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = " = null;" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_79 = "    " + NL + "\t\t\t\t\t\t \t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t \t\t\t\t\t}" + NL + "\t\t\t \t\t\t\t}\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t \t\t   \t\t\t";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = "=";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t    //init .NET businnes connector" + NL + "\t\t    org.talend.net.Object netBC_";
  protected final String TEXT_87 = " = org.talend.net.Object.createInstance(";
  protected final String TEXT_88 = ",\"Microsoft.Dynamics.BusinessConnectorNet.Axapta\");" + NL + "\t\t    //logon ax server" + NL + "\t\t    org.talend.net.Object cred_";
  protected final String TEXT_89 = " = org.talend.net.Object.createInstance(" + NL + "                \"System, Version=2.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089\", \"System.Net.NetworkCredential\"," + NL + "                new java.lang.Object[] { ";
  protected final String TEXT_90 = ", decryptedPassword_";
  protected final String TEXT_91 = ", ";
  protected final String TEXT_92 = " });" + NL + "\t\t    " + NL + "\t\t    netBC_";
  protected final String TEXT_93 = ".invoke(\"LogonAs\", new Object[]{";
  protected final String TEXT_94 = ",";
  protected final String TEXT_95 = ",cred_";
  protected final String TEXT_96 = ",";
  protected final String TEXT_97 = ",";
  protected final String TEXT_98 = ",";
  protected final String TEXT_99 = "+\"@\"+";
  protected final String TEXT_100 = "+\":\"+";
  protected final String TEXT_101 = ",";
  protected final String TEXT_102 = "});" + NL + "" + NL + "         \t//Create a record for a specific table." + NL + "\t        org.talend.net.Object dynRec_";
  protected final String TEXT_103 = " = netBC_";
  protected final String TEXT_104 = ".invoke(\"CreateAxaptaRecord\",new Object[]{";
  protected final String TEXT_105 = "});" + NL + "\t        dynRec_";
  protected final String TEXT_106 = ".invoke(\"ExecuteStmt\", new Object[]{";
  protected final String TEXT_107 = "});" + NL + "\t\t    while(((Boolean)dynRec_";
  protected final String TEXT_108 = ".accessGenericProperty(\"Found\")).booleanValue()){" + NL + "\t\t    \tnb_line_";
  protected final String TEXT_109 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_110 = " \t" + NL + "\t\t\t\t\t\t\t{" + NL + "\t\t\t\t\t\t\t\tObject field_";
  protected final String TEXT_111 = " =  dynRec_";
  protected final String TEXT_112 = ".invokeGeneric(\"get_Field\",new Object[]{\"";
  protected final String TEXT_113 = "\"});" + NL + "\t\t\t\t\t\t\t\tif(field_";
  protected final String TEXT_114 = " != null){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = " = (String)field_";
  protected final String TEXT_118 = ";\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = " = (Integer)field_";
  protected final String TEXT_122 = ";\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = " = (Long)field_";
  protected final String TEXT_126 = ";\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = " = (Float)field_";
  protected final String TEXT_130 = ";\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_132 = ".";
  protected final String TEXT_133 = " = (Boolean)field_";
  protected final String TEXT_134 = ";\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_136 = ".";
  protected final String TEXT_137 = " = (Byte)field_";
  protected final String TEXT_138 = ";\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_140 = ".";
  protected final String TEXT_141 = " = (Character)field_";
  protected final String TEXT_142 = ";\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = " = (Double)field_";
  protected final String TEXT_146 = ";\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_147 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_148 = ".";
  protected final String TEXT_149 = " = field_";
  protected final String TEXT_150 = ".toString().getBytes();\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_151 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = " = (Date)field_";
  protected final String TEXT_154 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_155 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_156 = ".";
  protected final String TEXT_157 = " = (Short)field_";
  protected final String TEXT_158 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_159 = " " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_160 = ".";
  protected final String TEXT_161 = " = (BigDecimal)field_";
  protected final String TEXT_162 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_163 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = " = ParserUtils.parseTo_";
  protected final String TEXT_166 = "(field_";
  protected final String TEXT_167 = ".toString());" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_168 = NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t \t\t\t\t\t\t";
  protected final String TEXT_170 = ".";
  protected final String TEXT_171 = " = null;" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_172 = "    " + NL + "\t\t\t\t\t\t \t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_173 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_174 = NL;
  protected final String TEXT_175 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
        
String axHost = ElementParameterParser.getValue(node, "__HOST__");
String axDomain = ElementParameterParser.getValue(node, "__DOMAIN__");
String axUser = ElementParameterParser.getValue(node, "__USER__");

String axTable = ElementParameterParser.getValue(node, "__TABLE__");
String dbquery = ElementParameterParser.getValue(node, "__QUERY__");
	   dbquery = dbquery.replaceAll("\n"," ");
	   dbquery = dbquery.replaceAll("\r"," ");
String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
String assemblyName = ElementParameterParser.getValue(node, "__ASSEMBLY_NAME__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String aosServer = ElementParameterParser.getValue(node, "__AOS_SERVER_INSTANCE__");
String company = ElementParameterParser.getValue(node, "__COMPANY__");
String language = ElementParameterParser.getValue(node, "__LANGUAGE__");
String configurationFile = ElementParameterParser.getValue(node, "__CONFIGURATION_FILE__");

List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
        List<IMetadataColumn> columnList = metadata.getListColumns();
    	class VariantTool{
    		public String vStr(String value){
    			return "new org.jinterop.dcom.core.JIVariant(new org.jinterop.dcom.core.JIString("+value+"))";
    		}
    		public String vInt(int value){
    			return "new org.jinterop.dcom.core.JIVariant("+value+")";
    		}
    	}
    	VariantTool vTool = new VariantTool();
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
		String passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_3);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
        if("DCOM".equals(connectionType)){
        
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(axDomain);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(axUser);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(axHost);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(vTool.vStr("\"\""));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(vTool.vStr("\"\""));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(vTool.vStr("\"\""));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(vTool.vStr("\"\""));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(vTool.vStr(axTable));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(dbquery);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
		        if(conns != null && conns.size()>0){
		         	IConnection conn = conns.get(0);
		         	String firstConnName = conn.getName();
		         	for(IMetadataColumn column:columnList){
		             	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		             	String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);
		             	if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))
		             	{
						
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(vTool.vStr("\""+column.getLabel()+"\""));
    stringBuffer.append(TEXT_53);
    
			            		if(("byte[]").equals(typeToGenerate)){
			            			typeToGenerate = "Bytes";
			            		}else if(("java.util.Date").equals(typeToGenerate)){
			            			typeToGenerate = "Date";
			                    }else if(("Integer").equals(typeToGenerate)){
			                      	typeToGenerate = "Int";
			                    }else{
			                    	typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
			                    }
								
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
					 				if (("List").equals(typeToGenerate)) {
									
    stringBuffer.append(TEXT_58);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
									}else if(("Object").equals(typeToGenerate)){
									
    stringBuffer.append(TEXT_62);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
									}else if(("String").equals(typeToGenerate)){
									
    stringBuffer.append(TEXT_66);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
									}else{
									
    stringBuffer.append(TEXT_70);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_74);
    
									}
									
    stringBuffer.append(TEXT_75);
    
				    				if(column.isNullable()){
									
    stringBuffer.append(TEXT_76);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_78);
    
						 			}else{
									
    stringBuffer.append(TEXT_79);
    
				            		}
									
    stringBuffer.append(TEXT_80);
    
			    		}
			 		}
		         	if(conns.size()>1){
		         		for(int connNO = 1; connNO < conns.size(); connNO++){
		        			IConnection conn2 = conns.get(connNO);
		        			if((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))){
		        				for(IMetadataColumn column:columnList){
								
    stringBuffer.append(TEXT_81);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_85);
     
	        					}
	        				}
	         			}
	         		}
				}
			//}while on end part
		}else{
		
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(assemblyName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(axUser);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(axDomain);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(axUser);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(axDomain);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(company);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(aosServer);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(axHost);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(configurationFile);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(axTable);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
		        if(conns != null && conns.size()>0){
		         	IConnection conn = conns.get(0);
		         	String firstConnName = conn.getName();
	             	if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
			         	for(IMetadataColumn column:columnList){
			             	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			             	JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							String columnName = column.getLabel();	
							
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
									if(javaType == JavaTypesManager.STRING){
									
    stringBuffer.append(TEXT_115);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
									}else if(javaType == JavaTypesManager.INTEGER){
									
    stringBuffer.append(TEXT_119);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    	
									}else if(javaType == JavaTypesManager.LONG){
									
    stringBuffer.append(TEXT_123);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    	
									}else if(javaType == JavaTypesManager.FLOAT){
									
    stringBuffer.append(TEXT_127);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    	
									}else if(javaType == JavaTypesManager.BOOLEAN){
									
    stringBuffer.append(TEXT_131);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    	
									}else if(javaType == JavaTypesManager.BYTE){
									
    stringBuffer.append(TEXT_135);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    	
									}else if(javaType == JavaTypesManager.CHARACTER){
									
    stringBuffer.append(TEXT_139);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    	
									}else if(javaType == JavaTypesManager.DOUBLE){
									
    stringBuffer.append(TEXT_143);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    	
									}else if(javaType == JavaTypesManager.BYTE_ARRAY){
									
    stringBuffer.append(TEXT_147);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    	
									}else if(javaType == JavaTypesManager.DATE){
									
    stringBuffer.append(TEXT_151);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
									}else if(javaType == JavaTypesManager.SHORT){
									
    stringBuffer.append(TEXT_155);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
									}else if(javaType == JavaTypesManager.BIGDECIMAL) {
									
    stringBuffer.append(TEXT_159);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    
									} else { 
									
    stringBuffer.append(TEXT_163);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    
									}
									
    stringBuffer.append(TEXT_168);
    
				    				if(column.isNullable()){
									
    stringBuffer.append(TEXT_169);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_171);
    
						 			}else{
									
    stringBuffer.append(TEXT_172);
    
				            		}
									
    stringBuffer.append(TEXT_173);
    
			    		}
			 		}
				}
			//}while on end part
		}			
	}
}

    stringBuffer.append(TEXT_174);
    stringBuffer.append(TEXT_175);
    return stringBuffer.toString();
  }
}
