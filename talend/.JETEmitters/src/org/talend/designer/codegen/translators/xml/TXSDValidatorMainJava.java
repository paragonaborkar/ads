package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TXSDValidatorMainJava
{
  protected static String nl;
  public static synchronized TXSDValidatorMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TXSDValidatorMainJava result = new TXSDValidatorMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "javax.xml.validation.SchemaFactory factory";
  protected final String TEXT_3 = " =javax.xml.validation.SchemaFactory.newInstance(\"http://www.w3.org/2001/XMLSchema\");" + NL;
  protected final String TEXT_4 = NL + "    \tfactory";
  protected final String TEXT_5 = ".setFeature(";
  protected final String TEXT_6 = ", true);";
  protected final String TEXT_7 = NL + NL + "String xsdfile_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";" + NL + "boolean isURL_";
  protected final String TEXT_10 = " = xsdfile_";
  protected final String TEXT_11 = "!=null && xsdfile_";
  protected final String TEXT_12 = ".startsWith(\"http\") && xsdfile_";
  protected final String TEXT_13 = ".endsWith(\"xsd\");" + NL + "Object schemaLocation";
  protected final String TEXT_14 = " = null;" + NL + "if(isURL_";
  protected final String TEXT_15 = ") {" + NL + "\tschemaLocation";
  protected final String TEXT_16 = " = new java.net.URL(xsdfile_";
  protected final String TEXT_17 = ");\t" + NL + "} else {" + NL + "\tschemaLocation";
  protected final String TEXT_18 = " = new java.io.File(xsdfile_";
  protected final String TEXT_19 = ");" + NL + "}" + NL + "String message_";
  protected final String TEXT_20 = " =null;" + NL + "String errorMessage_";
  protected final String TEXT_21 = "=null;" + NL + "int validate_";
  protected final String TEXT_22 = " = 0;" + NL + "" + NL + "" + NL + "\tclass TalendErrorHandler_";
  protected final String TEXT_23 = " implements org.xml.sax.ErrorHandler{" + NL + "\t  \tString errorMessage=null;" + NL + "" + NL + "\t\tpublic void warning(org.xml.sax.SAXParseException ex) throws org.xml.sax.SAXException{" + NL + "\t\t\tif (errorMessage== null){" + NL + "\t\t\t\terrorMessage = \"There is a Warning on line \" + String.valueOf(ex.getLineNumber()) + \" : \" + ex.getMessage();" + NL + "\t\t\t}else{" + NL + "\t\t\t\terrorMessage = errorMessage + \"\\n\" + \"There is a Warning on line \" + String.valueOf(ex.getLineNumber()) + \" : \" + ex.getMessage();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void error(org.xml.sax.SAXParseException ex) throws org.xml.sax.SAXException{" + NL + "\t\t\tif (errorMessage== null){" + NL + "\t\t\t\terrorMessage = \"There is an Error on line \" + String.valueOf(ex.getLineNumber()) + \" : \" + ex.getMessage();" + NL + "\t\t\t}else{" + NL + "\t\t\t\terrorMessage = errorMessage + \"\\n\" + \"There is an Error on line \" + String.valueOf(ex.getLineNumber()) + \" : \" + ex.getMessage();" + NL + "\t\t\t}" + NL + "\t\t\t\t//throw ex;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic void error(java.io.IOException ioEx){" + NL + "\t\t\tif (errorMessage == null) {" + NL + "\t\t\t\terrorMessage = \"There is an Error on line \" + \" : \" + ioEx.getMessage();" + NL + "\t\t\t} else {" + NL + "\t\t\t\terrorMessage = errorMessage + \"\\n\" + \"There is an Error on line \" + \" : \" + ioEx.getMessage();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic void fatalError(org.xml.sax.SAXParseException ex) throws org.xml.sax.SAXException{" + NL + "\t\t\tif (errorMessage == null){" + NL + "\t\t\t\terrorMessage = \"There is a Fatal Error on line \" + String.valueOf(ex.getLineNumber()) + \" : \" + ex.getMessage();" + NL + "\t\t\t}else{" + NL + "\t\t\t\terrorMessage =errorMessage + \"\\n\" + \"There is a Fatal Error on line \" + String.valueOf(ex.getLineNumber()) + \" : \" + ex.getMessage();" + NL + "\t\t\t}" + NL + "\t\t\tthrow ex;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tprivate String returnMessage(){" + NL + "\t\t\treturn errorMessage==null?\"\":errorMessage;" + NL + "\t\t}" + NL + "" + NL + "\t}" + NL + "TalendErrorHandler_";
  protected final String TEXT_24 = " errorHandler_";
  protected final String TEXT_25 = "=new TalendErrorHandler_";
  protected final String TEXT_26 = "();" + NL + "java.io.InputStream xmlfile";
  protected final String TEXT_27 = " = null;" + NL + "\t";
  protected final String TEXT_28 = NL + "\t\t\t\t";
  protected final String TEXT_29 = " = new ";
  protected final String TEXT_30 = "Struct();";
  protected final String TEXT_31 = NL + "\t\t\t\t\t";
  protected final String TEXT_32 = " = new ";
  protected final String TEXT_33 = "Struct();";
  protected final String TEXT_34 = NL + "\t\t\t\tString errorMessageRow_";
  protected final String TEXT_35 = " = \"\";";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tjavax.xml.validation.Schema schema";
  protected final String TEXT_37 = " = null;" + NL + "\t\t\t\t\t\t\tString location";
  protected final String TEXT_38 = " = ";
  protected final String TEXT_39 = ";" + NL + "\t\t\t\t\t\t\tisURL_";
  protected final String TEXT_40 = " = location";
  protected final String TEXT_41 = "!=null && location";
  protected final String TEXT_42 = ".startsWith(\"http\") && location";
  protected final String TEXT_43 = ".endsWith(\"xsd\");" + NL + "\t\t\t\t\t\t\tif(isURL_";
  protected final String TEXT_44 = ") {" + NL + "\t\t\t\t\t\t\t\tschema";
  protected final String TEXT_45 = " = factory";
  protected final String TEXT_46 = ".newSchema(new java.net.URL(location";
  protected final String TEXT_47 = "));" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\tschema";
  protected final String TEXT_48 = " = factory";
  protected final String TEXT_49 = ".newSchema(new java.io.File(location";
  protected final String TEXT_50 = "));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\txmlfile";
  protected final String TEXT_51 = " = new ByteArrayInputStream(((String)";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = ").getBytes(";
  protected final String TEXT_54 = "));" + NL + "\t\t\t\t\t\t\tjavax.xml.validation.Validator validator";
  protected final String TEXT_55 = " = schema";
  protected final String TEXT_56 = ".newValidator();" + NL + "\t\t\t\t\t\t\tjavax.xml.transform.Source source";
  protected final String TEXT_57 = " = new javax.xml.transform.stream.StreamSource(xmlfile";
  protected final String TEXT_58 = ");" + NL + "\t\t\t\t\t\t\tvalidator";
  protected final String TEXT_59 = ".setErrorHandler(errorHandler_";
  protected final String TEXT_60 = ");" + NL + "\t\t\t\t\t\t    validator";
  protected final String TEXT_61 = ".validate(source";
  protected final String TEXT_62 = ");" + NL + "\t\t\t\t\t\t} catch (org.xml.sax.SAXParseException ex";
  protected final String TEXT_63 = ") {" + NL + "\t\t\t\t\t\t\terrorHandler_";
  protected final String TEXT_64 = ".error(ex";
  protected final String TEXT_65 = ");" + NL + "\t\t\t\t\t\t} catch (java.io.IOException ioEx";
  protected final String TEXT_66 = "){" + NL + "\t\t\t\t\t\t\terrorHandler_";
  protected final String TEXT_67 = ".error(ioEx";
  protected final String TEXT_68 = ");" + NL + "\t\t\t\t\t\t}finally{" + NL + "\t\t\t\t\t\t\tif(xmlfile";
  protected final String TEXT_69 = " != null){" + NL + "\t\t\t\t\t\t\t\txmlfile";
  protected final String TEXT_70 = ".close();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\terrorMessage_";
  protected final String TEXT_71 = " = errorHandler_";
  protected final String TEXT_72 = ".returnMessage();" + NL + "\t\t\t\t\t\tif (errorMessage_";
  protected final String TEXT_73 = "==null || errorMessage_";
  protected final String TEXT_74 = ".length()<1) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = ";" + NL + "\t\t\t\t\t\t\tvalidate_";
  protected final String TEXT_79 = " = 1;";
  protected final String TEXT_80 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_81 = " = null;";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t    errorMessageRow_";
  protected final String TEXT_83 = " = errorMessageRow_";
  protected final String TEXT_84 = " + \"";
  protected final String TEXT_85 = ": \"+errorMessage_";
  protected final String TEXT_86 = "+'\\n';";
  protected final String TEXT_87 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = " = ";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_92 = ".errorMessage = \"";
  protected final String TEXT_93 = ": \"+errorMessage_";
  protected final String TEXT_94 = ";";
  protected final String TEXT_95 = NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"";
  protected final String TEXT_96 = ": \"+errorMessage_";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_99 = " = null;";
  protected final String TEXT_100 = NL + "\t\t\t\t\t\t}";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\tif (errorMessage_";
  protected final String TEXT_102 = "==null || errorMessage_";
  protected final String TEXT_103 = ".length()<1) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = ";" + NL + "\t\t\t\t\t\t\tvalidate_";
  protected final String TEXT_108 = " = 1;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\t\t\t\telse {" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = " = ";
  protected final String TEXT_112 = ".";
  protected final String TEXT_113 = ";" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_114 = NL + "            globalMap.put(\"";
  protected final String TEXT_115 = "_DIFFERENCE\", \"\" + validate_";
  protected final String TEXT_116 = ");" + NL + "            globalMap.put(\"";
  protected final String TEXT_117 = "_VALID\", (validate_";
  protected final String TEXT_118 = " == 1)?true:false);" + NL + "\t    \tglobalMap.put(\"";
  protected final String TEXT_119 = "_XSD_ERROR_MESSAGE\", errorMessageRow_";
  protected final String TEXT_120 = ");";
  protected final String TEXT_121 = NL + "Object oXmlFile";
  protected final String TEXT_122 = " = null;" + NL + "try {" + NL + "\tjavax.xml.validation.Schema schema";
  protected final String TEXT_123 = " = null;" + NL + "\tif(isURL_";
  protected final String TEXT_124 = ") {" + NL + "\t\tschema";
  protected final String TEXT_125 = " = factory";
  protected final String TEXT_126 = ".newSchema((java.net.URL)schemaLocation";
  protected final String TEXT_127 = ");" + NL + "\t} else {" + NL + "\t\tschema";
  protected final String TEXT_128 = " = factory";
  protected final String TEXT_129 = ".newSchema((java.io.File)schemaLocation";
  protected final String TEXT_130 = ");" + NL + "\t}" + NL + "\tjavax.xml.validation.Validator validator";
  protected final String TEXT_131 = " = schema";
  protected final String TEXT_132 = ".newValidator();" + NL + "\tjavax.xml.transform.Source source";
  protected final String TEXT_133 = " = null;" + NL + "\toXmlFile";
  protected final String TEXT_134 = " = ";
  protected final String TEXT_135 = ";" + NL + "\tif(oXmlFile";
  protected final String TEXT_136 = " instanceof String){" + NL + "\t\txmlfile";
  protected final String TEXT_137 = " = new java.io.FileInputStream((String)oXmlFile";
  protected final String TEXT_138 = ");" + NL + "\t\tsource";
  protected final String TEXT_139 = " = new javax.xml.transform.stream.StreamSource(xmlfile";
  protected final String TEXT_140 = ");" + NL + "\t} else if(oXmlFile";
  protected final String TEXT_141 = " instanceof java.io.InputStream){" + NL + "\t\tsource";
  protected final String TEXT_142 = " = new javax.xml.transform.stream.StreamSource((java.io.InputStream)oXmlFile";
  protected final String TEXT_143 = ");" + NL + "\t}" + NL + "\tvalidator";
  protected final String TEXT_144 = ".setErrorHandler(errorHandler_";
  protected final String TEXT_145 = ");" + NL + "    validator";
  protected final String TEXT_146 = ".validate(source";
  protected final String TEXT_147 = ");" + NL + "} catch (org.xml.sax.SAXParseException ex";
  protected final String TEXT_148 = ") {" + NL + "\terrorHandler_";
  protected final String TEXT_149 = ".error(ex";
  protected final String TEXT_150 = ");" + NL + "} catch (java.io.IOException ioEx";
  protected final String TEXT_151 = "){" + NL + "\terrorHandler_";
  protected final String TEXT_152 = ".error(ioEx";
  protected final String TEXT_153 = ");" + NL + "}finally{" + NL + "\tif(xmlfile";
  protected final String TEXT_154 = " != null){" + NL + "\t\txmlfile";
  protected final String TEXT_155 = ".close();" + NL + "\t}" + NL + "}" + NL + "errorMessage_";
  protected final String TEXT_156 = "=errorHandler_";
  protected final String TEXT_157 = ".returnMessage();" + NL + "if (errorMessage_";
  protected final String TEXT_158 = "!=null&& errorMessage_";
  protected final String TEXT_159 = ".length()>0) {" + NL + "\tmessage_";
  protected final String TEXT_160 = " = ";
  protected final String TEXT_161 = ";" + NL + "} else {" + NL + "\tmessage_";
  protected final String TEXT_162 = " = ";
  protected final String TEXT_163 = ";" + NL + "\tvalidate_";
  protected final String TEXT_164 = " = 1;" + NL + "\terrorMessage_";
  protected final String TEXT_165 = "=null;" + NL + "}" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_166 = "_DIFFERENCE\", \"\" + validate_";
  protected final String TEXT_167 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_168 = "_VALID\", (validate_";
  protected final String TEXT_169 = " == 1)?true:false);" + NL + "globalMap.put(\"";
  protected final String TEXT_170 = "_ERROR_MESSAGE\", \"\" + message_";
  protected final String TEXT_171 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_172 = "_XSD_ERROR_MESSAGE\", \"\" + errorMessage_";
  protected final String TEXT_173 = ");" + NL;
  protected final String TEXT_174 = NL + "    System.out.println(message_";
  protected final String TEXT_175 = ");" + NL + "    if(validate_";
  protected final String TEXT_176 = "==0)" + NL + "    {" + NL + "    System.err.println(errorMessage_";
  protected final String TEXT_177 = ");" + NL + "    }";
  protected final String TEXT_178 = NL + "\t\t";
  protected final String TEXT_179 = ".xsdfile = ";
  protected final String TEXT_180 = ";" + NL + "\t\t";
  protected final String TEXT_181 = ".xmlfile = ";
  protected final String TEXT_182 = ".toString();\t" + NL + "    \t";
  protected final String TEXT_183 = ".moment = java.util.Calendar.getInstance().getTime();" + NL + "    \t";
  protected final String TEXT_184 = ".job = jobName;" + NL + "\t\t";
  protected final String TEXT_185 = ".component = currentComponent;" + NL + "\t\t";
  protected final String TEXT_186 = ".validate = validate_";
  protected final String TEXT_187 = ";" + NL + "\t\t";
  protected final String TEXT_188 = ".message = message_";
  protected final String TEXT_189 = ";";
  protected final String TEXT_190 = NL + NL;
  protected final String TEXT_191 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String xsdfile = ElementParameterParser.getValue(node, "__XSDFILE__");
Boolean print = new Boolean(ElementParameterParser.getValue(node, "__PRINT__"));
String validMessage = ElementParameterParser.getValue(node, "__VALID_MESSAGE__");
String invalidMessage = ElementParameterParser.getValue(node, "__INVALID_MESSAGE__");
String xmlfile = ElementParameterParser.getValue(node, "__XMLFILE__");
String mode = ElementParameterParser.getValue(node, "__MODE__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");

List<Map<String, String>> features = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ENABLE_FEATURES__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
if(features!=null && features.size()>0){
    for(int i = 0; i < features.size(); i++){
    	Map<String, String> feature = features.get(i);
    	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(feature.get("FEATURE"));
    stringBuffer.append(TEXT_6);
    
    }
}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(xsdfile );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
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
    
if("FLOW_MODE".equals(mode)){
	List<Map<String, String>> manualtable = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MANUALTABLE__");
	Map<String,String> allocateMap = new HashMap<String,String>();
	for (Map<String, String> manualColumn : manualtable){
		allocateMap.put(manualColumn.get("INPUT_COLUMN"),manualColumn.get("XSD_FILE"));
	}
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata!=null) {
			List<IMetadataColumn> columns = metadata.getListColumns();
	    	String inConnName = "", outConnName = "", rejectConnName = null;
	    	List<? extends IConnection> inConns = node.getIncomingConnections();
	    	List<? extends IConnection> outConns = node.getOutgoingSortedConnections();
	    	List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
			if (rejectConns != null && rejectConns.size() > 0) {
				for (IConnection rejectConn : rejectConns) {
					if (rejectConn.isActivate()){
						rejectConnName = rejectConn.getName();
					}
				}
			}
	    	if(inConns != null && inConns.size() > 0){
		    	inConnName = inConns.get(0).getName();
		    }
	    	if(outConns != null && outConns.size() > 0){
		    	outConnName = outConns.get(0).getName();
		    }

    stringBuffer.append(TEXT_28);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_30);
    
				if(rejectConnName != null){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_33);
    
				}

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
				for(IMetadataColumn column : columns){
					String outLabel = column.getLabel();
		    		if(allocateMap.containsKey(outLabel)){

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(allocateMap.get(outLabel));
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(outLabel);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(encoding);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    
							if(rejectConnName != null){

    stringBuffer.append(TEXT_80);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_81);
    
							}

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
							if(rejectConnName != null){

    stringBuffer.append(TEXT_87);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
							}else{

    stringBuffer.append(TEXT_95);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
							}
							if(!outConnName.equals(rejectConnName)){

    stringBuffer.append(TEXT_98);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_99);
    
                            }

    stringBuffer.append(TEXT_100);
    
		    		}else{

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    
						if(rejectConnName!=null){
						
    stringBuffer.append(TEXT_109);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_113);
    
                    }
	    		}
	    	}

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
	    }
	}
}else{

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(xmlfile );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(invalidMessage );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(validMessage );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
if (print) {

    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
}

for (IConnection conn : node.getOutgoingConnections()) {
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_178);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(xsdfile );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(xmlfile );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    
	}
}

    
}

    stringBuffer.append(TEXT_190);
    stringBuffer.append(TEXT_191);
    return stringBuffer.toString();
  }
}
