package org.talend.designer.codegen.translators.business.bonita;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TBonitaInstantiateProcessMainJava
{
  protected static String nl;
  public static synchronized TBonitaInstantiateProcessMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBonitaInstantiateProcessMainJava result = new TBonitaInstantiateProcessMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = " != null) {//}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\t\t\t\t\t\t\tvars_";
  protected final String TEXT_6 = ".put(\"";
  protected final String TEXT_7 = "\",org.apache.commons.lang3.StringEscapeUtils.escapeJson(routines.system.FormatterUtils.format_Date(";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ")));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\tvars_";
  protected final String TEXT_12 = ".put(\"";
  protected final String TEXT_13 = "\",org.apache.commons.lang3.StringEscapeUtils.escapeJson(String.valueOf(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ")));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\t\t\t\t\t//{" + NL + "\t\t\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t\t\tvars_";
  protected final String TEXT_17 = ".put(\"";
  protected final String TEXT_18 = "\",\"\");" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_20 = ".append(\"&variables=<map>\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_22 = ".append(\"<entry><string>";
  protected final String TEXT_23 = "</string>\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = " != null) {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t\t\t\t\tjava.io.StringWriter sw_";
  protected final String TEXT_28 = " = new java.io.StringWriter();" + NL + "\t\t\t\t\t\t\t\t\t\tnew com.thoughtworks.xstream.XStream().marshal(";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ", new com.thoughtworks.xstream.io.xml.CompactWriter(sw_";
  protected final String TEXT_31 = "));" + NL + "\t\t\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_32 = ".append(sw_";
  protected final String TEXT_33 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_35 = ".append(\"<string><![CDATA[\");" + NL + "\t\t\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_36 = ".append(java.net.URLEncoder.encode(java.net.URLEncoder.encode(String.valueOf(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = "), utf8Charset),utf8Charset));" + NL + "\t\t\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_39 = ".append(\"]]></string>\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_42 = ".append(\"<string></string>\");" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_44 = ".append(\"</entry>\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_46 = ".append(\"</map>\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_48 = ".put(\"";
  protected final String TEXT_49 = "\", ";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_52 = "    " + NL + "\ttry{" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\tprocessInstanceUUID_";
  protected final String TEXT_54 = " = client_";
  protected final String TEXT_55 = ".startProcess(processID_";
  protected final String TEXT_56 = ",vars_";
  protected final String TEXT_57 = ");" + NL + "\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\tjava.io.DataOutputStream output_";
  protected final String TEXT_59 = " = new java.io.DataOutputStream(httpConn_";
  protected final String TEXT_60 = ".getOutputStream());" + NL + "\t\t\t\toutput_";
  protected final String TEXT_61 = ".writeBytes(parameters_";
  protected final String TEXT_62 = ".toString());" + NL + "\t\t\t\toutput_";
  protected final String TEXT_63 = ".flush();" + NL + "\t\t\t\tif (output_";
  protected final String TEXT_64 = " != null) {" + NL + "\t\t\t\t\toutput_";
  protected final String TEXT_65 = ".close();" + NL + "\t\t\t\t\toutput_";
  protected final String TEXT_66 = " = null;" + NL + "\t\t\t\t}" + NL + "\t\t\t    int responseCode_";
  protected final String TEXT_67 = " = httpConn_";
  protected final String TEXT_68 = ".getResponseCode();" + NL + "\t\t\t    " + NL + "\t\t\t    if(responseCode_";
  protected final String TEXT_69 = " != java.net.HttpURLConnection.HTTP_OK){" + NL + "\t\t\t    \tSystem.out.println(\"----------\\nRequest failled: \" + responseCode_";
  protected final String TEXT_70 = "+ \"----------\");" + NL + "\t\t\t      \tthrow new java.lang.Exception(\"Request the url:\" + url_";
  protected final String TEXT_71 = " + \" failed: \" + responseCode_";
  protected final String TEXT_72 = ");" + NL + "\t\t\t    } else {" + NL + "\t\t\t      \tjava.io.InputStream is_";
  protected final String TEXT_73 = " = httpConn_";
  protected final String TEXT_74 = ".getInputStream();" + NL + "\t\t\t      \tjavax.xml.xpath.XPath xPath_";
  protected final String TEXT_75 = " = javax.xml.xpath.XPathFactory.newInstance().newXPath();" + NL + "\t\t\t      \torg.xml.sax.InputSource inputSource_";
  protected final String TEXT_76 = " = new org.xml.sax.InputSource(is_";
  protected final String TEXT_77 = ");" + NL + "\t\t\t      \tprocessInstanceUUID_";
  protected final String TEXT_78 = " = (String) xPath_";
  protected final String TEXT_79 = ".evaluate(\"/ProcessInstanceUUID/value/text()\", inputSource_";
  protected final String TEXT_80 = ", javax.xml.xpath.XPathConstants.STRING);" + NL + "\t\t\t      \tif (is_";
  protected final String TEXT_81 = " != null) {" + NL + "\t\t\t      \t\tis_";
  protected final String TEXT_82 = ".close();" + NL + "\t\t\t      \t\tis_";
  protected final String TEXT_83 = " = null;" + NL + "\t\t\t      \t}" + NL + "\t\t\t    }" + NL + "\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\tprocessInstanceUUID_";
  protected final String TEXT_85 = " = client_";
  protected final String TEXT_86 = ".startProcess(";
  protected final String TEXT_87 = ",parameters_";
  protected final String TEXT_88 = ");" + NL + "\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\t\tprocessInstanceUUID_";
  protected final String TEXT_90 = " = client_";
  protected final String TEXT_91 = ".startProcess(";
  protected final String TEXT_92 = ",";
  protected final String TEXT_93 = ",parameters_";
  protected final String TEXT_94 = ");" + NL + "\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\torg.ow2.bonita.facade.uuid.ProcessInstanceUUID instanceUUID_";
  protected final String TEXT_96 = " = runtimeAPI_";
  protected final String TEXT_97 = ".instantiateProcess(processID_";
  protected final String TEXT_98 = ", parameters_";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\tprocessInstanceUUID_";
  protected final String TEXT_100 = " = instanceUUID_";
  protected final String TEXT_101 = ".getValue();" + NL + "\t\t";
  protected final String TEXT_102 = NL + "\t} catch (java.lang.Exception lee_";
  protected final String TEXT_103 = ") {" + NL + "\t\t";
  protected final String TEXT_104 = NL + "\t\t\tthrow lee_";
  protected final String TEXT_105 = ";\t" + NL + "\t\t";
  protected final String TEXT_106 = NL + "\t\t\tSystem.err.println(lee_";
  protected final String TEXT_107 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_108 = NL + "\t}" + NL + "\t";
  protected final String TEXT_109 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = " = processInstanceUUID_";
  protected final String TEXT_112 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t " + NL + "\tSystem.out.println(\"**** Instance \"+ processInstanceUUID_";
  protected final String TEXT_114 = " + \" created ****\");" + NL + "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_115 = "_ProcessInstanceUUID\", processInstanceUUID_";
  protected final String TEXT_116 = "); ";
  protected final String TEXT_117 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String processID = ElementParameterParser.getValue(node, "__PROCESS_ID__");
	String clientMode = ElementParameterParser.getValue(node, "__CLIENT_MODE__");
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	
	String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns != null && conns.size() > 0 && conns.get(0) != null) {
    	IConnection conn = conns.get(0);
    	if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
	    	INode previousNode = conn.getSource();
	    	if(previousNode != null) {
				List<IMetadataTable> metadatas = previousNode.getMetadataList();
				if ((metadatas!=null)&&(metadatas.size()>0)) {
					IMetadataTable metadata = metadatas.get(0);
					if (metadata!=null) {
						List<IMetadataColumn> columns = metadata.getListColumns();
						int sizeColumns = columns.size();
						
						for (int i = 0; i < sizeColumns; i++) {
							if ("HTTP_CLIENT".equals(clientMode)) {
								if("BONITA_652".equals(dbVersion) || "BONITA_724".equals(dbVersion)) {
									if(!JavaTypesManager.isJavaPrimitiveType(columns.get(i).getTalendType(), columns.get(i).isNullable())) {
									
    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_4);
    
									}
									
									JavaType javaType = JavaTypesManager.getJavaTypeFromId(columns.get(i).getTalendType());
									String pattern = columns.get(i).getPattern() == null || columns.get(i).getPattern().trim().length() == 0 ? null : columns.get(i).getPattern();
									if(javaType == JavaTypesManager.DATE){
									
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_9);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_10);
    
									} else {
									
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_15);
    
									}
									
									if(!JavaTypesManager.isJavaPrimitiveType(columns.get(i).getTalendType(), columns.get(i).isNullable())) {
									
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_18);
    
									}
									
									continue;
								}
								
								if (i==0) {
								
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
								}
								
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(columns.get(i).getLabel() );
    stringBuffer.append(TEXT_23);
    if(!JavaTypesManager.isJavaPrimitiveType(columns.get(i).getTalendType(), columns.get(i).isNullable())) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_26);
    }
									JavaType javaType = JavaTypesManager.getJavaTypeFromId(columns.get(i).getTalendType());
									if(javaType == JavaTypesManager.DATE){
									
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
									}else{
									
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
									}
									
    stringBuffer.append(TEXT_40);
    if(!JavaTypesManager.isJavaPrimitiveType(columns.get(i).getTalendType(), columns.get(i).isNullable())) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
								if (i==sizeColumns-1) {
								
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
								}
							} else {
							
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_51);
    
							}
						}
					}
				}
	    	}
	    }
    }
	
    stringBuffer.append(TEXT_52);
    
		if ("HTTP_CLIENT".equals(clientMode)) {
			if("BONITA_652".equals(dbVersion) || "BONITA_724".equals(dbVersion)) {
		
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
			} else {
		
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
			}
		} else { // Java Client
			if("BONITA_652".equals(dbVersion) || "BONITA_724".equals(dbVersion)) {
				boolean use_process_id = "true".equals(ElementParameterParser.getValue(node, "__USE_PROCESS_ID__"));
				if(use_process_id) {
		
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(processID);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
				} else {
					String process_name = ElementParameterParser.getValue(node, "__PROCESS_NAME__");
					String process_version = ElementParameterParser.getValue(node, "__PROCESS_VERSION__");
		
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(process_name);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(process_version);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
				}
			} else {
		
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
    
			}
		}
		
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
		if (dieOnError) {
		
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
		} else {
		
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    	
		}
		
    stringBuffer.append(TEXT_108);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			List< ? extends IConnection> conns_out = node.getOutgoingConnections();
			for (IConnection conn : conns_out) {
				String connName = conn.getName();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					List<IMetadataColumn> columns = metadata.getListColumns();
					int sizeColumns = columns.size();
					for (int i = 0; i < sizeColumns; i++) {
						if ("ProcessInstanceUUID".equals(columns.get(i).getLabel()) ) {
						
    stringBuffer.append(TEXT_109);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
							break;
						}
					}
				}
			}
		}
	}
	
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(TEXT_117);
    return stringBuffer.toString();
  }
}
