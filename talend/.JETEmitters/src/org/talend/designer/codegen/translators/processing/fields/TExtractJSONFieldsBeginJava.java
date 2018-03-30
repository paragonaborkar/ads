package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TExtractJSONFieldsBeginJava
{
  protected static String nl;
  public static synchronized TExtractJSONFieldsBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractJSONFieldsBeginJava result = new TExtractJSONFieldsBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "String jsonStr_";
  protected final String TEXT_3 = " = \"\";" + NL;
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = NL + NL + "class ConvertJSONString_";
  protected final String TEXT_6 = "{" + NL + "    final static int Brace = 0 ; // {" + NL + "    final static int Bracket = 1; // [" + NL + "    private int barceType = -1 ;" + NL + "    private String originalJsonString = \"\" ;" + NL + "    private String originalLoopString = \"\" ;" + NL + "    private String jsonString4XML = null;" + NL + "    private String loopString4XML = null;" + NL + "    private String additionRoot = null;" + NL + "    " + NL + "    public void barceType(){" + NL + "" + NL + "        for (int c = 0; c < originalJsonString.length(); ++c) {" + NL + "            if (originalJsonString.charAt(c) == '{') {" + NL + "                barceType = Brace;" + NL + "                break;" + NL + "            } else if (originalJsonString.charAt(c) == '[') {" + NL + "                barceType = Bracket;" + NL + "                break;" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public void setJsonString (String originalJsonString) {" + NL + "        this.originalJsonString = originalJsonString;" + NL + "    }" + NL + "    " + NL + "    public void setLoopString (String originalLoopString) {" + NL + "        this.originalLoopString = originalLoopString;" + NL + "    }" + NL + "    " + NL + "    public String getJsonString4XML(){" + NL + "        return jsonString4XML;" + NL + "    }" + NL + "    " + NL + "    public String getLoopString4XML(){" + NL + "        if(loopString4XML.length()>1 && loopString4XML.endsWith(\"/\")){" + NL + "        \tloopString4XML = loopString4XML.substring(0, loopString4XML.length()-1);" + NL + "\t\t}" + NL + "        return loopString4XML;" + NL + "    }" + NL + "    " + NL + "    public void setAdditionRoot(String additionRoot) {" + NL + "        this.additionRoot = additionRoot;" + NL + "    }" + NL + "    " + NL + "    public String getAdditionRoot(){" + NL + "        return additionRoot;" + NL + "    }" + NL + "    " + NL + "    public void generate() {" + NL + "        barceType();" + NL + "        jsonString4XML = originalJsonString;" + NL + "        loopString4XML = originalLoopString;" + NL + "        if (Brace == barceType) {" + NL + "            if (isNeedAddRoot(originalJsonString)) {" + NL + "                jsonString4XML = \"{ \\\"root\\\": \" + originalJsonString + \" }\";" + NL + "                loopString4XML = \"root\" + originalLoopString;" + NL + "                setAdditionRoot(\"root\");" + NL + "            }" + NL + "        } else if (Bracket == barceType) {" + NL + "            jsonString4XML = \"{ \\\"root\\\" : { \\\"object\\\": \"" + NL + "                    + originalJsonString + \" } }\";" + NL + "            loopString4XML = \"root/object\" + originalLoopString;" + NL + "                setAdditionRoot(\"object\");" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public boolean isNeedAddRoot(String originalJsonString) {" + NL + "        boolean isNeedAddRoot = false;" + NL + "        net.sf.json.JSONObject jso = net.sf.json.JSONObject" + NL + "                .fromObject(originalJsonString);" + NL + "        String jsonKey = \"\";" + NL + "        Object firstObject = null;" + NL + "        if (jso.names().size() == 1) {" + NL + "            jsonKey = jso.names().get(0).toString();" + NL + "            firstObject = jso.get(jsonKey);" + NL + "        }" + NL + "        if (jso.size() > 1" + NL + "                || (firstObject != null" + NL + "                        && firstObject instanceof net.sf.json.JSONArray && ((net.sf.json.JSONArray) firstObject)" + NL + "                        .size() > 1)) {" + NL + "            isNeedAddRoot = true;" + NL + "        }" + NL + "        return isNeedAddRoot;" + NL + "    }" + NL + "" + NL + "}" + NL + "" + NL + "ConvertJSONString_";
  protected final String TEXT_7 = " cjs_";
  protected final String TEXT_8 = " = new ConvertJSONString_";
  protected final String TEXT_9 = "();" + NL + "" + NL + "de.odysseus.staxon.json.JsonXMLConfig config_";
  protected final String TEXT_10 = " = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).build();" + NL + "de.odysseus.staxon.json.JsonXMLInputFactory jsonXMLInputFactory_";
  protected final String TEXT_11 = " = new de.odysseus.staxon.json.JsonXMLInputFactory(config_";
  protected final String TEXT_12 = ");" + NL + "javax.xml.stream.XMLOutputFactory xmlOutputFactory_";
  protected final String TEXT_13 = " = javax.xml.stream.XMLOutputFactory.newInstance();" + NL + "boolean isGetWholeJson_";
  protected final String TEXT_14 = " = false;" + NL + "" + NL + "\tclass OriginalJSONString_";
  protected final String TEXT_15 = " {";
  protected final String TEXT_16 = NL + NL + "        \t\tString originalJSONString = null;" + NL + "        \t\tjava.io.ByteArrayInputStream bais = null;" + NL + "        \t\tjava.io.ByteArrayOutputStream baos = null;" + NL + "        \t\tde.odysseus.staxon.json.JsonXMLConfig config = null;" + NL + "        \t\tde.odysseus.staxon.json.JsonXMLOutputFactory jxof = null;" + NL + "           \t\t" + NL + "           \t\tpublic String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson, boolean isArray) throws Exception {" + NL + "" + NL + "    \t\t\t\t\ttry {" + NL + "\t           \t\t\t\tif(isArray){" + NL + "    \t       \t\t\t\t\txmlString = \"<list>\" + xmlString + \"</list>\";" + NL + "        \t   \t\t\t\t}" + NL + "    \t\t\t\t\t\tbais = new ByteArrayInputStream(xmlString.getBytes(encoding));" + NL + "                \t\t\tbaos = new java.io.ByteArrayOutputStream();" + NL + "                \t\t\tconfig = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).autoArray(true).build();" + NL + "                \t\t\tjxof = new de.odysseus.staxon.json.JsonXMLOutputFactory(config);" + NL + "            \t\t\t\tjavax.xml.stream.XMLEventReader xmlEventReader = javax.xml.stream.XMLInputFactory.newInstance().createXMLEventReader(bais,encoding);" + NL + "                \t\t\tjavax.xml.stream.XMLEventWriter xmLEventWriter = jxof.createXMLEventWriter(baos);" + NL + "    \t\t\t\t\t\txmLEventWriter.add(xmlEventReader);" + NL + "    \t\t\t\t\t\txmlEventReader.close();" + NL + "    \t\t\t\t\t\txmLEventWriter.close();" + NL + "    \t\t\t\t\t\tnet.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(baos.toString());" + NL + "\t\t\t\t\t\t\tif(isArray){" + NL + "\t\t\t\t\t\t\t\tjson = json.getJSONObject(\"list\");" + NL + "\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\tnet.sf.json.JSONObject originalJsonObject = null;" + NL + "\t\t\t\t\t\t\tif (!json.isNullObject()) {" + NL + "\t\t\t\t\t\t\t\tif (additionRoot == null) {" + NL + "\t\t\t\t\t\t\t\t\toriginalJSONString = json.toString();" + NL + "\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\tif (isGetWholeJson) {" + NL + "                                        originalJsonObject = json.getJSONObject(additionRoot);" + NL + "                                        if (!originalJsonObject.isNullObject()) {" + NL + "                                            originalJSONString = originalJsonObject.toString();" + NL + "                                        } " + NL + "                                    }else {" + NL + "                                            originalJSONString = json.toString();" + NL + "                                    }" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t} finally {" + NL + "    \t\t\t\t        baos.close();" + NL + "    \t\t\t\t        if(bais!=null){" + NL + "    \t\t\t\t            bais.close();" + NL + "    \t\t\t\t        }" + NL + "    \t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\treturn originalJSONString;" + NL + "\t\t\t\t}" + NL + "           \t\tpublic String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson) throws Exception {" + NL + "    \t\t\t\t\treturn getOriginalJSONString(xmlString, additionRoot, encoding, isGetWholeJson, false);" + NL + "\t\t\t\t}";
  protected final String TEXT_17 = NL + "}" + NL + "\t\t\t" + NL + "\t\t\tOriginalJSONString_";
  protected final String TEXT_18 = " originalJSONString_";
  protected final String TEXT_19 = " = new OriginalJSONString_";
  protected final String TEXT_20 = "();" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_21 = "{" + NL + "\tpublic boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node instanceof org.dom4j.Element) {" + NL + "        \torg.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "        \tif(attri != null && (\"true\").equals(attri.getText())){" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getText().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }";
  protected final String TEXT_22 = NL + "            public void putUnExtractValue_";
  protected final String TEXT_23 = "(";
  protected final String TEXT_24 = "Struct ";
  protected final String TEXT_25 = ",";
  protected final String TEXT_26 = "Struct ";
  protected final String TEXT_27 = "){";
  protected final String TEXT_28 = NL + "                ";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = " = ";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + "            }";
  protected final String TEXT_34 = NL + "            }";
  protected final String TEXT_35 = NL + "            public void putExtractValue_";
  protected final String TEXT_36 = "(";
  protected final String TEXT_37 = "Struct ";
  protected final String TEXT_38 = ",";
  protected final String TEXT_39 = "Struct ";
  protected final String TEXT_40 = ",";
  protected final String TEXT_41 = NL + "                String xmlStr_";
  protected final String TEXT_42 = ",org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_43 = ",String loopQuery_";
  protected final String TEXT_44 = ",java.util.HashMap xmlNameSpaceMap_";
  protected final String TEXT_45 = ",org.dom4j.Node node_";
  protected final String TEXT_46 = "," + NL + "                    String str_";
  protected final String TEXT_47 = ",XML_API_";
  protected final String TEXT_48 = " xml_api_";
  protected final String TEXT_49 = ",OriginalJSONString_";
  protected final String TEXT_50 = " originalJSONString_";
  protected final String TEXT_51 = ",ConvertJSONString_";
  protected final String TEXT_52 = " cjs_";
  protected final String TEXT_53 = ",boolean isGetWholeJson_";
  protected final String TEXT_54 = " ) throws java.lang.Exception {";
  protected final String TEXT_55 = NL + "                    \tisGetWholeJson_";
  protected final String TEXT_56 = "  = true;";
  protected final String TEXT_57 = NL + "                org.dom4j.XPath xTmp";
  protected final String TEXT_58 = "_";
  protected final String TEXT_59 = " = temp_";
  protected final String TEXT_60 = ".createXPath(";
  protected final String TEXT_61 = ");" + NL + "                xTmp";
  protected final String TEXT_62 = "_";
  protected final String TEXT_63 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_64 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_65 = NL + "                Object obj";
  protected final String TEXT_66 = "_";
  protected final String TEXT_67 = " = xTmp";
  protected final String TEXT_68 = "_";
  protected final String TEXT_69 = ".evaluate(temp_";
  protected final String TEXT_70 = ");" + NL + "                if(obj";
  protected final String TEXT_71 = "_";
  protected final String TEXT_72 = " instanceof String || obj";
  protected final String TEXT_73 = "_";
  protected final String TEXT_74 = " instanceof Number){" + NL + "                    node_";
  protected final String TEXT_75 = " = temp_";
  protected final String TEXT_76 = ";" + NL + "                    str_";
  protected final String TEXT_77 = " = String.valueOf(obj";
  protected final String TEXT_78 = "_";
  protected final String TEXT_79 = ");" + NL + "                }else{" + NL + "                    node_";
  protected final String TEXT_80 = " = xTmp";
  protected final String TEXT_81 = "_";
  protected final String TEXT_82 = ".selectSingleNode(temp_";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\tif(node_";
  protected final String TEXT_85 = "==null){" + NL + "\t \t\t\t\t\t\tstr_";
  protected final String TEXT_86 = " = null;" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tstr_";
  protected final String TEXT_87 = " = originalJSONString_";
  protected final String TEXT_88 = ".getOriginalJSONString(node_";
  protected final String TEXT_89 = ".asXML(),cjs_";
  protected final String TEXT_90 = ".getAdditionRoot(),";
  protected final String TEXT_91 = ",isGetWholeJson_";
  protected final String TEXT_92 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tisGetWholeJson_";
  protected final String TEXT_93 = " = false;";
  protected final String TEXT_94 = NL + "                        str_";
  protected final String TEXT_95 = " = xTmp";
  protected final String TEXT_96 = "_";
  protected final String TEXT_97 = ".valueOf(temp_";
  protected final String TEXT_98 = ");";
  protected final String TEXT_99 = NL + "                }";
  protected final String TEXT_100 = NL + "\t\t\t\t\t\tString xmlStrTemp";
  protected final String TEXT_101 = "_";
  protected final String TEXT_102 = " = \"\";" + NL + "\t\t\t\t\t\tfor(Object tempNode_";
  protected final String TEXT_103 = " : xTmp";
  protected final String TEXT_104 = "_";
  protected final String TEXT_105 = ".selectNodes(temp_";
  protected final String TEXT_106 = ")){" + NL + "\t\t\t\t\t\t\tnode_";
  protected final String TEXT_107 = " = (org.dom4j.Node)tempNode_";
  protected final String TEXT_108 = ";" + NL + "\t\t\t\t\t\t\txmlStrTemp";
  protected final String TEXT_109 = "_";
  protected final String TEXT_110 = " += node_";
  protected final String TEXT_111 = ".asXML();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(\"\".equals(xmlStrTemp";
  protected final String TEXT_112 = "_";
  protected final String TEXT_113 = ")){" + NL + "\t\t\t\t\t\t\tstr_";
  protected final String TEXT_114 = " = null;" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tstr_";
  protected final String TEXT_115 = " = originalJSONString_";
  protected final String TEXT_116 = ".getOriginalJSONString(xmlStrTemp";
  protected final String TEXT_117 = "_";
  protected final String TEXT_118 = ",cjs_";
  protected final String TEXT_119 = ".getAdditionRoot(),";
  protected final String TEXT_120 = ",isGetWholeJson_";
  protected final String TEXT_121 = ", true);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tisGetWholeJson_";
  protected final String TEXT_122 = " = false;" + NL + "                \t";
  protected final String TEXT_123 = NL + "\t\t\t\t\t\tjava.util.List<String> xmlListTemp";
  protected final String TEXT_124 = "_";
  protected final String TEXT_125 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\t\tfor(Object tempNode_";
  protected final String TEXT_126 = " : xTmp";
  protected final String TEXT_127 = "_";
  protected final String TEXT_128 = ".selectNodes(temp_";
  protected final String TEXT_129 = ")){" + NL + "\t\t\t\t\t\t\txmlListTemp";
  protected final String TEXT_130 = "_";
  protected final String TEXT_131 = ".add(((org.dom4j.Node)tempNode_";
  protected final String TEXT_132 = ").getStringValue());" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_133 = NL + "                                    ";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = " = str_";
  protected final String TEXT_136 = ";";
  protected final String TEXT_137 = NL + "                                    if(xml_api_";
  protected final String TEXT_138 = ".isDefNull(node_";
  protected final String TEXT_139 = ")){";
  protected final String TEXT_140 = NL + "                                        ";
  protected final String TEXT_141 = ".";
  protected final String TEXT_142 = " =null;" + NL + "                                    }else if(xml_api_";
  protected final String TEXT_143 = ".isEmpty(node_";
  protected final String TEXT_144 = ")){";
  protected final String TEXT_145 = NL + "                                        ";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = " =\"\";" + NL + "                                    }else if(xml_api_";
  protected final String TEXT_148 = ".isMissing(node_";
  protected final String TEXT_149 = " )){ ";
  protected final String TEXT_150 = NL + "                                        ";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = " =";
  protected final String TEXT_153 = ";" + NL + "                                    }else{";
  protected final String TEXT_154 = NL + "\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_155 = ".isEmpty(node_";
  protected final String TEXT_156 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_157 = ".";
  protected final String TEXT_158 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_159 = ".isMissing(node_";
  protected final String TEXT_160 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = " =";
  protected final String TEXT_163 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_164 = "\t" + NL + "                                \tif(xml_api_";
  protected final String TEXT_165 = ".isDefNull(node_";
  protected final String TEXT_166 = ")){" + NL + "                                    \t";
  protected final String TEXT_167 = ".";
  protected final String TEXT_168 = " = null;" + NL + "                                \t}else if(xml_api_";
  protected final String TEXT_169 = ".isEmpty(node_";
  protected final String TEXT_170 = ") || xml_api_";
  protected final String TEXT_171 = ".isMissing(node_";
  protected final String TEXT_172 = ")){" + NL + "                                    \t";
  protected final String TEXT_173 = ".";
  protected final String TEXT_174 = " = ";
  protected final String TEXT_175 = ";" + NL + "                                \t}else{";
  protected final String TEXT_176 = NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_177 = ".isMissing(node_";
  protected final String TEXT_178 = ") || xml_api_";
  protected final String TEXT_179 = ".isEmpty(node_";
  protected final String TEXT_180 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_181 = ".";
  protected final String TEXT_182 = " =";
  protected final String TEXT_183 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = " = str_";
  protected final String TEXT_187 = ";";
  protected final String TEXT_188 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_189 = ".";
  protected final String TEXT_190 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_191 = ", ";
  protected final String TEXT_192 = ");";
  protected final String TEXT_193 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_194 = ".";
  protected final String TEXT_195 = " = ParserUtils.parseTo_";
  protected final String TEXT_196 = "(str_";
  protected final String TEXT_197 = ");";
  protected final String TEXT_198 = NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_199 = NL + "\t\t\t\t\t\t\t\tif(xmlListTemp";
  protected final String TEXT_200 = "_";
  protected final String TEXT_201 = ".isEmpty()){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = " = null;\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_204 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_205 = ".";
  protected final String TEXT_206 = " = xmlListTemp";
  protected final String TEXT_207 = "_";
  protected final String TEXT_208 = ".toString();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_209 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = " = xmlListTemp";
  protected final String TEXT_212 = "_";
  protected final String TEXT_213 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_214 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_215 = NL + "            }";
  protected final String TEXT_216 = NL + "            }";
  protected final String TEXT_217 = NL + "            public void putRejectValueBeforeExtract_";
  protected final String TEXT_218 = "(";
  protected final String TEXT_219 = "Struct ";
  protected final String TEXT_220 = ",";
  protected final String TEXT_221 = "Struct ";
  protected final String TEXT_222 = "){";
  protected final String TEXT_223 = NL + "                ";
  protected final String TEXT_224 = ".";
  protected final String TEXT_225 = " = ";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = ";";
  protected final String TEXT_228 = NL + "            }";
  protected final String TEXT_229 = NL + "            }";
  protected final String TEXT_230 = NL + "            public void putRejectValueAfterExtract_";
  protected final String TEXT_231 = "(";
  protected final String TEXT_232 = "Struct ";
  protected final String TEXT_233 = ",";
  protected final String TEXT_234 = "Struct ";
  protected final String TEXT_235 = "){";
  protected final String TEXT_236 = NL + "                ";
  protected final String TEXT_237 = ".";
  protected final String TEXT_238 = " = ";
  protected final String TEXT_239 = ".";
  protected final String TEXT_240 = ";";
  protected final String TEXT_241 = NL + "            }";
  protected final String TEXT_242 = NL + "            }";
  protected final String TEXT_243 = NL + "}" + NL + "" + NL + "String xmlStr_";
  protected final String TEXT_244 = " = \"\";" + NL + "" + NL + "XML_API_";
  protected final String TEXT_245 = " xml_api_";
  protected final String TEXT_246 = " = new XML_API_";
  protected final String TEXT_247 = "();" + NL + " ";
  protected final String TEXT_248 = NL + "\t";
  protected final String TEXT_249 = NL + NL + "class JsonPathCache_";
  protected final String TEXT_250 = " {" + NL + "\tfinal java.util.Map<String,com.jayway.jsonpath.JsonPath> jsonPathString2compiledJsonPath = new java.util.HashMap<String,com.jayway.jsonpath.JsonPath>();" + NL + "\t" + NL + "\tpublic com.jayway.jsonpath.JsonPath getCompiledJsonPath(String jsonPath) {" + NL + "\t\tif(jsonPathString2compiledJsonPath.containsKey(jsonPath)) {" + NL + "\t\t\treturn jsonPathString2compiledJsonPath.get(jsonPath);" + NL + "\t\t} else {" + NL + "\t\t\tcom.jayway.jsonpath.JsonPath compiledLoopPath = com.jayway.jsonpath.JsonPath.compile(jsonPath);" + NL + "\t\t\tjsonPathString2compiledJsonPath.put(jsonPath,compiledLoopPath);" + NL + "\t\t\treturn compiledLoopPath;" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL + "" + NL + "JsonPathCache_";
  protected final String TEXT_251 = " jsonPathCache_";
  protected final String TEXT_252 = " = new JsonPathCache_";
  protected final String TEXT_253 = "();" + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	int schemaOptNum=100;
    String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
    if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
        schemaOptNum  = Integer.parseInt(schemaOptNumStr);
    }
    String jsonField = ElementParameterParser.getValue(node, "__JSONFIELD__");

    String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    
    IConnection inConn = null;
    List< ? extends IConnection> inConns = node.getIncomingConnections();
    List<IMetadataColumn> inColumns = null;
    if (inConns!=null) {
        for (IConnection incomingConn : inConns) {
            if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                inConn = incomingConn;
                inColumns = inConn.getMetadataTable().getListColumns();
                break;
            }
        }
    }
    
    String readBy = ElementParameterParser.getValue(node, "__READ_BY__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    if(!"JSONPATH".equals(readBy)) {
	List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING__");
	String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
        String nodeChecked = null;
        boolean hasNodeCheck = false;
        for(int i = 0 ;i<mapping.size();i++){
            nodeChecked = mapping.get(i).get("NODECHECK");
            if("true".equals(nodeChecked)){
                hasNodeCheck = true;
                break;
            }
        }
        if(hasNodeCheck){//----start has nodeCheck

    stringBuffer.append(TEXT_16);
    
        }//----end has nodeCheck

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
String rejectConnName = "";
List<IMetadataColumn> rejectColumnList = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
    IConnection rejectConn = rejectConns.get(0);
    rejectColumnList = rejectConn.getMetadataTable().getListColumns();
    rejectConnName = rejectConn.getName(); 
}

IConnection outConn = null;
String firstConnName = "";
List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
if(outConns!=null){
    for (IConnection conn : outConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            outConn = conn;
            firstConnName = outConn.getName();
            break;
        }
    }
}
if (outConn!=null) {
    if(schemaOptNum < mapping.size()){//whether to optimize
        if(inConn!=null){
            int unExtractColNo=0;
            for (int i=0;i<mapping.size();i++) { 
                if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
                    String query = mapping.get(i).get("QUERY");
                    if(query==null || query.trim().length()<1){
                        for(IMetadataColumn inColumn:inColumns) {
                            if (inColumn.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
                                if(unExtractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(unExtractColNo/schemaOptNum);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(outConn));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_27);
    
                                }

    stringBuffer.append(TEXT_28);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_32);
    
                                if((unExtractColNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_33);
    
                                }
                                unExtractColNo++;
                                break;
                            }
                        }
                    }
                }
            }
            if(unExtractColNo>0&&(unExtractColNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_34);
    
            }
        }
        int extractColNo=0;
        for (int i=0;i<mapping.size();i++) {  //for S_0
            String query = mapping.get(i).get("QUERY");
            String nodeCheck = mapping.get(i).get("NODECHECK");
            boolean isArrayCheck = "true".equals(mapping.get(i).get("ISARRAY"));
            if(query!=null && query.trim().length()>0){  // if S_0_0
                if(extractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(extractColNo/schemaOptNum);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(outConn));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_38);
    if(inConn!=null){
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
                }
             	if("true".equals(nodeCheck)){
                	if((".").equals(query.substring(1,query.length()-1)) && ("/").equals(loopQuery.substring(1,loopQuery.length()-1))){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    
                	}
            	}

    stringBuffer.append(TEXT_57);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
                if(!isArrayCheck){
                
    stringBuffer.append(TEXT_65);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
                    if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
                    }else{

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    
                    }

    stringBuffer.append(TEXT_99);
    
}else{
                	if(("true").equals(nodeCheck)){
					
    stringBuffer.append(TEXT_100);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
                	}else{
					
    stringBuffer.append(TEXT_123);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
                	}
                }
                for(IMetadataColumn column:outConn.getMetadataTable().getListColumns()) { // for S_0_0_0
                    if (mapping.get(i).get("SCHEMA_COLUMN")!=null) { // if S_0_0_0_0
                        if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) { //if S_0_0_0_0_0
                            
                            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                            String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                            
                            boolean isNotSetDefault = false;
                            String defaultValue=column.getDefault();
                            if(defaultValue!=null){
                                isNotSetDefault = defaultValue.trim().length()==0;
                            }else{
                                isNotSetDefault=true;
                            }
                            
                            if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_133);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    
                                continue;
                            }
                            if(!isArrayCheck){
                            if(javaType == JavaTypesManager.STRING){
								if(column.isNullable()){

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_153);
    
								}else{ // column.isNullable()

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_163);
    
								}
                            }else{ // other type
								if(column.isNullable()){

    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_175);
    
								}else{ // column.isNullable()

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_183);
    
								}
							}
							if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_184);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_187);
    
							} else {
								if (javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_188);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_192);
    
								} else {

    stringBuffer.append(TEXT_193);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_195);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_196);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_197);
    
								}
							}

    stringBuffer.append(TEXT_198);
    
							}else{
							
    stringBuffer.append(TEXT_199);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_203);
    
									if(javaType == JavaTypesManager.STRING){
									
    stringBuffer.append(TEXT_204);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    
									}else if(javaType == JavaTypesManager.LIST || javaType == JavaTypesManager.OBJECT){
									
    stringBuffer.append(TEXT_209);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
									}
									
    stringBuffer.append(TEXT_214);
    
							}
                            break;
                        } // if S_0_0_0_0_1
                    } // if S_0_0_0_1
                } // for S_0_0_1
                if((extractColNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_215);
    
                }
                extractColNo++;
            }// if S_0_1
        } // for S_1
        if(extractColNo >0&&(extractColNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_216);
    
        }
        if(!dieOnError && !("").equals(rejectConnName) && rejectColumnList != null && rejectColumnList.size() > 0) {//reject before extract
            if(inConn!=null){
                int columnNo=0;
                for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
                    if(!jsonField.equals(column.getLabel())){
                        for(IMetadataColumn inColumn : inConn.getMetadataTable().getListColumns()){
                            if(inColumn.getLabel().equals(column.getLabel())){
                                if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_217);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_222);
    
                                }

    stringBuffer.append(TEXT_223);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_227);
    
                                if((columnNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_228);
    
                                }
                                columnNo++;
                                break;
                            }
                        }
                    }
                }
                if(columnNo>0&&(columnNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_229);
    
                }
            }
        }//reject before extract
        
        if(!dieOnError && !("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//reject extract
            int columnNo=0;
            for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
                if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_230);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_235);
    
                }

    stringBuffer.append(TEXT_236);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_240);
    
                if((columnNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_241);
    
                }
                columnNo++;
            }
            if(columnNo>0&&(columnNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_242);
    
            }
        }//reject extract
        
    }//whether to optimize
}

    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    } else {
	List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING_4_JSONPATH__");
	String loopQuery = ElementParameterParser.getValue(node, "__JSON_LOOP_QUERY__");

    stringBuffer.append(TEXT_248);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    }
    return stringBuffer.toString();
  }
}
