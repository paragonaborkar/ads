package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputXMLBeginJava
{
  protected static String nl;
  public static synchronized TFileInputXMLBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputXMLBeginJava result = new TFileInputXMLBeginJava();
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
  protected final String TEXT_29 = NL + "\t";
  protected final String TEXT_30 = NL + "\t\t\trowHelper_";
  protected final String TEXT_31 = ".valueToConn(";
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = " ";
  protected final String TEXT_34 = ");" + NL + "\t\t";
  protected final String TEXT_35 = NL + "\t\t\trowHelper_";
  protected final String TEXT_36 = ".valueToConnWithD(";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = ", ";
  protected final String TEXT_39 = " ";
  protected final String TEXT_40 = ");" + NL + "\t\t";
  protected final String TEXT_41 = NL + "\t\t\trowHelper_";
  protected final String TEXT_42 = ".connToConn(";
  protected final String TEXT_43 = ",";
  protected final String TEXT_44 = ");" + NL + "\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\tclass RowHelper_";
  protected final String TEXT_46 = "{" + NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\tpublic void valueToConn_";
  protected final String TEXT_48 = "(";
  protected final String TEXT_49 = " ";
  protected final String TEXT_50 = ",";
  protected final String TEXT_51 = "Struct ";
  protected final String TEXT_52 = " ";
  protected final String TEXT_53 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t\t\tpublic void valueToConnWithD_";
  protected final String TEXT_56 = "(";
  protected final String TEXT_57 = " ";
  protected final String TEXT_58 = ",";
  protected final String TEXT_59 = "Struct ";
  protected final String TEXT_60 = ", routines.system.Dynamic ";
  protected final String TEXT_61 = " ";
  protected final String TEXT_62 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t\tpublic void connToConn_";
  protected final String TEXT_65 = "(";
  protected final String TEXT_66 = "Struct ";
  protected final String TEXT_67 = ",";
  protected final String TEXT_68 = "Struct ";
  protected final String TEXT_69 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t\t\tpublic void valueToConn(";
  protected final String TEXT_72 = " ";
  protected final String TEXT_73 = ",";
  protected final String TEXT_74 = "Struct ";
  protected final String TEXT_75 = " ";
  protected final String TEXT_76 = ") throws java.lang.Exception{" + NL + "\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\tpublic void valueToConnWithD(";
  protected final String TEXT_78 = " ";
  protected final String TEXT_79 = ",";
  protected final String TEXT_80 = "Struct ";
  protected final String TEXT_81 = ", routines.system.Dynamic ";
  protected final String TEXT_82 = " ";
  protected final String TEXT_83 = ") throws java.lang.Exception{" + NL + "\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\tvalueToConn_";
  protected final String TEXT_85 = "(";
  protected final String TEXT_86 = ",";
  protected final String TEXT_87 = " ";
  protected final String TEXT_88 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\t\t\tvalueToConnWithD_";
  protected final String TEXT_90 = "(";
  protected final String TEXT_91 = ",";
  protected final String TEXT_92 = ",";
  protected final String TEXT_93 = " ";
  protected final String TEXT_94 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\t\tpublic void connToConn(";
  protected final String TEXT_97 = "Struct ";
  protected final String TEXT_98 = ",";
  protected final String TEXT_99 = "Struct ";
  protected final String TEXT_100 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\tconnToConn_";
  protected final String TEXT_102 = "(";
  protected final String TEXT_103 = ",";
  protected final String TEXT_104 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t}" + NL + "\t\t\t\tRowHelper_";
  protected final String TEXT_107 = " rowHelper_";
  protected final String TEXT_108 = "  = new RowHelper_";
  protected final String TEXT_109 = "();" + NL + "\t\t\t";
  protected final String TEXT_110 = NL;
  protected final String TEXT_111 = NL + "int nb_line_";
  protected final String TEXT_112 = " = 0;" + NL;
  protected final String TEXT_113 = NL + "class IgnoreDTDEntityResolver_";
  protected final String TEXT_114 = " implements org.xml.sax.EntityResolver {" + NL + "" + NL + " public org.xml.sax.InputSource resolveEntity(String publicId, String systemId)" + NL + "   throws org.xml.sax.SAXException, java.io.IOException {" + NL + "        return new org.xml.sax.InputSource(new java.io.ByteArrayInputStream(\"<?xml version='1.0' encoding='UTF-8'?>\".getBytes()));" + NL + " }" + NL + "" + NL + "}";
  protected final String TEXT_115 = NL + "\tString os_";
  protected final String TEXT_116 = " = System.getProperty(\"os.name\").toLowerCase();" + NL + "\tboolean isWindows_";
  protected final String TEXT_117 = "=false;" + NL + "\tif(os_";
  protected final String TEXT_118 = ".indexOf(\"windows\") > -1 || os_";
  protected final String TEXT_119 = ".indexOf(\"nt\") > -1){" + NL + "\t\tisWindows_";
  protected final String TEXT_120 = "=true;" + NL + "\t}";
  protected final String TEXT_121 = NL + "class TalendPrefixResolver_";
  protected final String TEXT_122 = " implements org.apache.xml.utils.PrefixResolver {" + NL + "" + NL + "    private java.util.Map<String, String> map = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "\t" + NL + "\tpublic java.util.List<String> getDefualtNSPath() {" + NL + "\t\treturn defualtNSPath;" + NL + "\t}" + NL + "\t" + NL + "    public String getBaseIdentifier() {" + NL + "        return null;" + NL + "    }" + NL + "" + NL + "    public String getNamespaceForPrefix(String prefix) {" + NL + "        if ((\"xml\").equals(prefix)) {" + NL + "            return org.apache.xml.utils.Constants.S_XMLNAMESPACEURI;" + NL + "        } else {" + NL + "            return map.get(prefix);" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public String getNamespaceForPrefix(String prefix, org.w3c.dom.Node context) {" + NL + "        return getNamespaceForPrefix(prefix);" + NL + "    }" + NL + "" + NL + "    public boolean handlesNullPrefixes() {" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean countNSMap(org.w3c.dom.Node el) {" + NL + "    \tboolean hasDefaultPrefix = false;" + NL + "        if (el.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {" + NL + "            org.w3c.dom.NamedNodeMap attris = el.getAttributes();" + NL + "            for (int i = 0; i < attris.getLength(); i++) {" + NL + "                org.w3c.dom.Node attr = attris.item(i);" + NL + "                String aname = attr.getNodeName();" + NL + "                if (aname.startsWith(\"xmlns\")) {" + NL + "                    int index = aname.indexOf(\":\");" + NL + "                    if(index > 0){" + NL + "                    \taname = aname.substring(index + 1);" + NL + "                    }else{" + NL + "                    \taname = \"pre\"+defualtNSPath.size();" + NL + "                    \thasDefaultPrefix = true;" + NL + "                    \tString path = \"\";" + NL + "                    \torg.w3c.dom.Node elTmp = el;" + NL + "                    \twhile(elTmp!=null && !(elTmp instanceof org.w3c.dom.Document)){" + NL + "\t\t\t\t\t\t\tpath = \"/\"+elTmp.getNodeName()+path;" + NL + "                    \t\telTmp = elTmp.getParentNode();" + NL + "                    \t}" + NL + "                        defualtNSPath.add(path);" + NL + "                    }" + NL + "                    map.put(aname, attr.getNodeValue());" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "        org.w3c.dom.NodeList nodeList = el.getChildNodes();" + NL + "        for (int i = 0; i < nodeList.getLength(); i++) {" + NL + "            hasDefaultPrefix = hasDefaultPrefix | countNSMap(nodeList.item(i));" + NL + "        }" + NL + "        return hasDefaultPrefix;" + NL + "    }" + NL + "    " + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_123 = "{" + NL + "" + NL + "\tString loopPath = null;" + NL + "\tboolean hasDefaultNS = false;" + NL + "\tTalendPrefixResolver_";
  protected final String TEXT_124 = " pr = null;" + NL + "\t" + NL + "\tpublic boolean isDefNull(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {" + NL + "            return ((org.apache.xerces.xs.ElementPSVI) node).getNil();" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getTextContent().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "\tprivate final org.talend.xpath.XPathUtil util = new  org.talend.xpath.XPathUtil();" + NL + "" + NL + "\tpublic void initXPath(org.w3c.dom.Node root){" + NL + "\t\tpr= new TalendPrefixResolver_";
  protected final String TEXT_125 = "();" + NL + "    \thasDefaultNS = pr.countNSMap(root);" + NL + "    \tutil.setDefaultNSPath(pr.getDefualtNSPath());" + NL + "\t}" + NL + "" + NL + "//==============add for feature 10753 start================================" + NL + "\torg.apache.xpath.objects.XObject obj = null;" + NL + "\t" + NL + "\tpublic int getNodeType(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException{" + NL + "\t\tobj = org.apache.xpath.XPathAPI.eval(node, util.addDefaultNSPrefix(xpath,loopPath), pr);" + NL + "\t\treturn obj.getType();" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getNodeString(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException{" + NL + "\t\tif(obj==null){" + NL + "\t\t\tobj = org.apache.xpath.XPathAPI.eval(node, util.addDefaultNSPrefix(xpath,loopPath), pr);" + NL + "\t\t}" + NL + "\t\treturn obj.str();" + NL + "\t}" + NL + "" + NL + "    public org.w3c.dom.Node getSingleNode(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException {" + NL + "    \tif(obj==null){" + NL + "        \tobj = org.apache.xpath.XPathAPI.eval(node, util.addDefaultNSPrefix(xpath,loopPath), pr);" + NL + "        }" + NL + "        return obj.nodelist().item(0);" + NL + "    }" + NL + "//=====================end=================================================" + NL + "" + NL + "    public org.w3c.dom.NodeList getNodeList(org.w3c.dom.Node node, String xpath) throws javax.xml.transform.TransformerException {" + NL + "        org.apache.xpath.objects.XObject obj = org.apache.xpath.XPathAPI.eval(node, util.addDefaultNSPrefix(xpath), pr);" + NL + "        return obj.nodelist();" + NL + "    }" + NL + "    " + NL + "}" + NL;
  protected final String TEXT_126 = NL + "class ContentTool_";
  protected final String TEXT_127 = "{" + NL + "\tpublic String field_separator=\",\";//default value" + NL + "\t" + NL + "\tpublic String getNodeContent(org.w3c.dom.Node node){" + NL + "\t\tString result=getSubNodeContent(node);" + NL + "\t\tif(result.equals(\"\")) return \"\";" + NL + "\t\telse return result.substring(1);" + NL + "\t}" + NL + "\t" + NL + "\tprivate String getSubNodeContent(org.w3c.dom.Node node){" + NL + "\t\tif(node==null) return \"\";" + NL + "\t\t" + NL + "\t\tString tmp=node.getNodeValue();" + NL + "\t\t" + NL + "\t\tif(tmp==null){" + NL + "\t\t\ttmp=\"\";" + NL + "\t\t}else{" + NL + "\t\t\ttmp=field_separator+tmp;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif(node.hasChildNodes()){" + NL + "\t\t\torg.w3c.dom.NodeList nodeList = node.getChildNodes();" + NL + "\t\t\tfor(int i=0;i<nodeList.getLength();i++){" + NL + "\t\t\t\torg.w3c.dom.Node tmpNode= nodeList.item(i);\t" + NL + "\t\t\t\ttmp=tmp+getSubNodeContent(tmpNode);" + NL + "" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\treturn tmp;" + NL + "\t}" + NL + "}" + NL + "ContentTool_";
  protected final String TEXT_128 = " contentTool_";
  protected final String TEXT_129 = " = new ContentTool_";
  protected final String TEXT_130 = "();" + NL + "contentTool_";
  protected final String TEXT_131 = ".field_separator=";
  protected final String TEXT_132 = ";";
  protected final String TEXT_133 = NL + NL + "XML_API_";
  protected final String TEXT_134 = " xml_api_";
  protected final String TEXT_135 = " = new XML_API_";
  protected final String TEXT_136 = "();" + NL + "xml_api_";
  protected final String TEXT_137 = ".loopPath=";
  protected final String TEXT_138 = ";" + NL + "org.apache.xerces.parsers.DOMParser parser_";
  protected final String TEXT_139 = " = new org.apache.xerces.parsers.DOMParser();";
  protected final String TEXT_140 = NL + "parser_";
  protected final String TEXT_141 = ".setEntityResolver(new IgnoreDTDEntityResolver_";
  protected final String TEXT_142 = "());";
  protected final String TEXT_143 = NL + "parser_";
  protected final String TEXT_144 = ".setProperty(\"http://apache.org/xml/properties/dom/document-class-name\"," + NL + "        \"org.apache.xerces.dom.PSVIDocumentImpl\");" + NL + "parser_";
  protected final String TEXT_145 = ".setFeature(\"http://xml.org/sax/features/validation\", true);" + NL + "parser_";
  protected final String TEXT_146 = ".setFeature(\"http://apache.org/xml/features/validation/schema\", true);" + NL + "parser_";
  protected final String TEXT_147 = ".setFeature(\"http://apache.org/xml/features/validation/schema-full-checking\", true);" + NL + "parser_";
  protected final String TEXT_148 = ".setFeature(\"http://xml.org/sax/features/namespaces\", true);" + NL + "parser_";
  protected final String TEXT_149 = ".setErrorHandler(null);" + NL + "Object filename_";
  protected final String TEXT_150 = " = null;" + NL + "try {" + NL + "\tfilename_";
  protected final String TEXT_151 = " = ";
  protected final String TEXT_152 = ";" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_153 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_154 = NL + "\t";
  protected final String TEXT_155 = NL + "\t\tlog.error(\"";
  protected final String TEXT_156 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_157 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_158 = NL + "}" + NL + "" + NL + "boolean isValidFile_";
  protected final String TEXT_159 = " = true;" + NL + "java.io.Closeable toClose_";
  protected final String TEXT_160 = " = null;" + NL + "try{" + NL + "    if(filename_";
  protected final String TEXT_161 = " != null && filename_";
  protected final String TEXT_162 = " instanceof String && filename_";
  protected final String TEXT_163 = ".toString().startsWith(\"//\")){" + NL + "\t\tif (!isWindows_";
  protected final String TEXT_164 = "){" + NL + "\t\t\tfilename_";
  protected final String TEXT_165 = " = filename_";
  protected final String TEXT_166 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t\t}" + NL + "    }" + NL + "    if(filename_";
  protected final String TEXT_167 = " instanceof java.io.InputStream){" + NL + "    \tjava.io.InputStream inputStream_";
  protected final String TEXT_168 = " = (java.io.InputStream)filename_";
  protected final String TEXT_169 = ";" + NL + "    \ttoClose_";
  protected final String TEXT_170 = " = inputStream_";
  protected final String TEXT_171 = ";" + NL + "    \tparser_";
  protected final String TEXT_172 = ".parse(new org.xml.sax.InputSource(inputStream_";
  protected final String TEXT_173 = "));" + NL + "    }else{" + NL + "    \tjava.io.InputStream in_";
  protected final String TEXT_174 = "= new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_175 = "));" + NL + "    \tjava.io.Reader unicodeReader_";
  protected final String TEXT_176 = " = new UnicodeReader(in_";
  protected final String TEXT_177 = ",";
  protected final String TEXT_178 = ");" + NL + "    \ttoClose_";
  protected final String TEXT_179 = " = unicodeReader_";
  protected final String TEXT_180 = ";" + NL + "    \torg.xml.sax.InputSource xmlInputSource_";
  protected final String TEXT_181 = " = new org.xml.sax.InputSource(unicodeReader_";
  protected final String TEXT_182 = ");" + NL + "    \tparser_";
  protected final String TEXT_183 = ".parse(xmlInputSource_";
  protected final String TEXT_184 = ");" + NL + "    }" + NL + "}catch(java.lang.Exception e){";
  protected final String TEXT_185 = NL + "\tthrow(e);";
  protected final String TEXT_186 = NL + "\t";
  protected final String TEXT_187 = NL + "\t\tlog.error(\"";
  protected final String TEXT_188 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_189 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\tisValidFile_";
  protected final String TEXT_190 = " = false;";
  protected final String TEXT_191 = NL + "}finally {" + NL + "\tif(toClose_";
  protected final String TEXT_192 = "!=null) {" + NL + "\t\ttoClose_";
  protected final String TEXT_193 = ".close();" + NL + "\t}" + NL + "}" + NL + "if(isValidFile_";
  protected final String TEXT_194 = "){" + NL + "org.w3c.dom.Document doc_";
  protected final String TEXT_195 = " = parser_";
  protected final String TEXT_196 = ".getDocument();" + NL + "" + NL + "xml_api_";
  protected final String TEXT_197 = ".initXPath(doc_";
  protected final String TEXT_198 = ");" + NL + "org.w3c.dom.NodeList nodelist_";
  protected final String TEXT_199 = " = xml_api_";
  protected final String TEXT_200 = ".getNodeList(doc_";
  protected final String TEXT_201 = ",";
  protected final String TEXT_202 = ");" + NL + "" + NL + "org.w3c.dom.Node node_";
  protected final String TEXT_203 = "  = null;" + NL + "String str_";
  protected final String TEXT_204 = " = null;";
  protected final String TEXT_205 = NL + "for (int i_";
  protected final String TEXT_206 = " = 0; i_";
  protected final String TEXT_207 = " < nodelist_";
  protected final String TEXT_208 = ".getLength(); i_";
  protected final String TEXT_209 = "++) {" + NL + "\torg.w3c.dom.Node tmp_";
  protected final String TEXT_210 = " = nodelist_";
  protected final String TEXT_211 = ".item(i_";
  protected final String TEXT_212 = ");";
  protected final String TEXT_213 = NL + "class NameSpaceTool_";
  protected final String TEXT_214 = " {" + NL + "" + NL + "    public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "" + NL + "    public void countNSMap(org.dom4j.Element el) {" + NL + "        for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {" + NL + "            if (ns.getPrefix().trim().length() == 0) {" + NL + "                xmlNameSpaceMap.put(\"pre\"+defualtNSPath.size(), ns.getURI());" + NL + "                String path = \"\";" + NL + "                org.dom4j.Element elTmp = el;" + NL + "                while (elTmp != null) {" + NL + "                \tif (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {" + NL + "                        path = \"/\" + elTmp.getNamespacePrefix() + \":\" + elTmp.getName() + path;" + NL + "                    } else {" + NL + "                        path = \"/\" + elTmp.getName() + path;" + NL + "                    }" + NL + "                    elTmp = elTmp.getParent();" + NL + "                }" + NL + "                defualtNSPath.add(path);" + NL + "            } else {" + NL + "                xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());" + NL + "            }" + NL + "" + NL + "        }" + NL + "        for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {" + NL + "            countNSMap(e);" + NL + "        }" + NL + "    }" + NL + "    " + NL + "    private final org.talend.xpath.XPathUtil util = new  org.talend.xpath.XPathUtil();" + NL + "    " + NL + "    {" + NL + "    \tutil.setDefaultNSPath(defualtNSPath);" + NL + "    }" + NL + "    " + NL + "\tpublic String addDefaultNSPrefix(String path) {" + NL + "\t\treturn util.addDefaultNSPrefix(path);" + NL + "\t}" + NL + "\t" + NL + "\tpublic String addDefaultNSPrefix(String relativeXpression, String basePath) {" + NL + "\t\treturn util.addDefaultNSPrefix(relativeXpression,basePath);" + NL + "\t}" + NL + "    " + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_215 = "{" + NL + "\tpublic boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node instanceof org.dom4j.Element) {" + NL + "        \torg.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "        \tif(attri != null && (\"true\").equals(attri.getText())){" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getText().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}" + NL;
  protected final String TEXT_216 = NL + "\tclass XML_NS_RMV_";
  protected final String TEXT_217 = "{\t" + NL + "" + NL + "\t\tpublic void removeNamespace(org.dom4j.Document reader," + NL + "\t\t\t\torg.dom4j.Document writer) {" + NL + "\t\t\torg.dom4j.Element elemReader = reader.getRootElement();" + NL + "\t\t\torg.dom4j.Element elemTo = writer.addElement(elemReader" + NL + "\t\t\t\t\t.getName());" + NL + "\t\t\tif(elemReader!=null && elemReader.getText()!=null && !\"\".equals(elemReader.getText())){" + NL + "\t\t\t\telemTo.setText(elemReader.getText());" + NL + "\t\t\t}" + NL + "\t\t\tfor (org.dom4j.Attribute attri : (List<org.dom4j.Attribute>) elemReader" + NL + "\t\t\t\t\t.attributes()) {" + NL + "\t\t\t\telemTo.addAttribute(attri.getName(),attri.getText());" + NL + "\t\t\t}" + NL + "\t\t\tremoveSubNamespace(elemReader, elemTo);" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void removeSubNamespace(org.dom4j.Element elemFrom," + NL + "\t\t\t\torg.dom4j.Element elemTo) {" + NL + "\t\t\tfor (org.dom4j.Element subFrom : (List<org.dom4j.Element>) elemFrom" + NL + "\t\t\t\t\t.elements()) {" + NL + "\t\t\t\torg.dom4j.Element tmpElemTo = elemTo.addElement(subFrom" + NL + "\t\t\t\t\t\t.getName());" + NL + "\t\t\t\tif(subFrom!=null && subFrom.getText()!=null && !\"\".equals(subFrom.getText())){" + NL + "\t\t\t\t\ttmpElemTo.setText(subFrom.getText());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tfor (org.dom4j.Attribute attri : (List<org.dom4j.Attribute>) subFrom" + NL + "\t\t\t\t\t\t.attributes()) {" + NL + "\t\t\t\t\ttmpElemTo.addAttribute(attri.getName(),attri.getText());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tremoveSubNamespace(subFrom, tmpElemTo);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_218 = NL + NL + "org.dom4j.io.SAXReader reader_";
  protected final String TEXT_219 = " = new org.dom4j.io.SAXReader();";
  protected final String TEXT_220 = NL + "reader_";
  protected final String TEXT_221 = ".setEntityResolver(new IgnoreDTDEntityResolver_";
  protected final String TEXT_222 = "());";
  protected final String TEXT_223 = NL + "Object filename_";
  protected final String TEXT_224 = " = null;" + NL + "try {" + NL + "\tfilename_";
  protected final String TEXT_225 = " = ";
  protected final String TEXT_226 = ";" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_227 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_228 = NL + "\t";
  protected final String TEXT_229 = NL + "\t\tlog.error(\"";
  protected final String TEXT_230 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_231 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_232 = NL + "}" + NL + "if(filename_";
  protected final String TEXT_233 = " != null && filename_";
  protected final String TEXT_234 = " instanceof String && filename_";
  protected final String TEXT_235 = ".toString().startsWith(\"//\")){" + NL + "\tif (!isWindows_";
  protected final String TEXT_236 = "){" + NL + "\t\tfilename_";
  protected final String TEXT_237 = " = filename_";
  protected final String TEXT_238 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_239 = NL + "org.dom4j.Document doc_reader_";
  protected final String TEXT_240 = " = null;" + NL + "org.dom4j.Document doc_tmp_";
  protected final String TEXT_241 = " = org.dom4j.DocumentHelper.createDocument();" + NL + "org.dom4j.io.OutputFormat format_";
  protected final String TEXT_242 = " = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "try {" + NL + "\tif(filename_";
  protected final String TEXT_243 = " instanceof java.io.InputStream){" + NL + "\t\tdoc_reader_";
  protected final String TEXT_244 = " = reader_";
  protected final String TEXT_245 = ".read((java.io.InputStream)filename_";
  protected final String TEXT_246 = ");" + NL + "\t}else{" + NL + "\t\tdoc_reader_";
  protected final String TEXT_247 = " = reader_";
  protected final String TEXT_248 = ".read(new java.io.File(String.valueOf(filename_";
  protected final String TEXT_249 = ")).toURI().toString());" + NL + "\t}" + NL + "\tformat_";
  protected final String TEXT_250 = ".setTrimText(false);" + NL + "\tformat_";
  protected final String TEXT_251 = ".setEncoding(";
  protected final String TEXT_252 = ");" + NL + "\tnew XML_NS_RMV_";
  protected final String TEXT_253 = "().removeNamespace(doc_reader_";
  protected final String TEXT_254 = ",doc_tmp_";
  protected final String TEXT_255 = ");" + NL + "\tdoc_reader_";
  protected final String TEXT_256 = ".clearContent();" + NL + "\tdoc_reader_";
  protected final String TEXT_257 = " = null;" + NL + "\tjava.io.FileOutputStream stream_";
  protected final String TEXT_258 = " = new java.io.FileOutputStream(";
  protected final String TEXT_259 = ");" + NL + "\torg.dom4j.io.XMLWriter output_";
  protected final String TEXT_260 = " = new org.dom4j.io.XMLWriter(stream_";
  protected final String TEXT_261 = ", format_";
  protected final String TEXT_262 = ");" + NL + "\toutput_";
  protected final String TEXT_263 = ".write(doc_tmp_";
  protected final String TEXT_264 = ");" + NL + "\toutput_";
  protected final String TEXT_265 = ".close();" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_266 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_267 = NL + "\t";
  protected final String TEXT_268 = NL + "\t\tlog.error(\"";
  protected final String TEXT_269 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_270 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_271 = NL + "} finally {" + NL + "\tif(filename_";
  protected final String TEXT_272 = " instanceof java.io.InputStream && filename_";
  protected final String TEXT_273 = "!=null){" + NL + "\t\t((java.io.InputStream)filename_";
  protected final String TEXT_274 = ").close();" + NL + "\t}" + NL + "}" + NL + "filename_";
  protected final String TEXT_275 = " = ";
  protected final String TEXT_276 = ";";
  protected final String TEXT_277 = NL + "boolean isValidFile_";
  protected final String TEXT_278 = " = true;" + NL + "org.dom4j.Document doc_";
  protected final String TEXT_279 = " = null;" + NL + "java.io.Closeable toClose_";
  protected final String TEXT_280 = " = null;" + NL + "try{" + NL + "\tif(filename_";
  protected final String TEXT_281 = " instanceof java.io.InputStream){" + NL + "\t\tjava.io.InputStream inputStream_";
  protected final String TEXT_282 = " = (java.io.InputStream)filename_";
  protected final String TEXT_283 = ";" + NL + "\t\ttoClose_";
  protected final String TEXT_284 = " = inputStream_";
  protected final String TEXT_285 = ";" + NL + "\t\tdoc_";
  protected final String TEXT_286 = " = reader_";
  protected final String TEXT_287 = ".read(inputStream_";
  protected final String TEXT_288 = ");" + NL + "\t}else{" + NL + "\t\tjava.io.Reader unicodeReader_";
  protected final String TEXT_289 = " = new UnicodeReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_290 = ")),";
  protected final String TEXT_291 = ");" + NL + "\t\ttoClose_";
  protected final String TEXT_292 = " = unicodeReader_";
  protected final String TEXT_293 = ";" + NL + "\t\torg.xml.sax.InputSource in_";
  protected final String TEXT_294 = "= new org.xml.sax.InputSource(unicodeReader_";
  protected final String TEXT_295 = ");" + NL + "\t\tdoc_";
  protected final String TEXT_296 = " = reader_";
  protected final String TEXT_297 = ".read(in_";
  protected final String TEXT_298 = ");" + NL + "\t}" + NL + "}catch(java.lang.Exception e){";
  protected final String TEXT_299 = NL + "\tthrow(e);";
  protected final String TEXT_300 = NL + "\t";
  protected final String TEXT_301 = NL + "\t\tlog.error(\"";
  protected final String TEXT_302 = " - \" + e.getMessage());" + NL + "\t";
  protected final String TEXT_303 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\tisValidFile_";
  protected final String TEXT_304 = " = false;";
  protected final String TEXT_305 = NL + "} finally {" + NL + "\tif(toClose_";
  protected final String TEXT_306 = "!=null) {" + NL + "\t\ttoClose_";
  protected final String TEXT_307 = ".close();" + NL + "\t}" + NL + "}" + NL + "if(isValidFile_";
  protected final String TEXT_308 = "){" + NL + "NameSpaceTool_";
  protected final String TEXT_309 = " nsTool_";
  protected final String TEXT_310 = " = new NameSpaceTool_";
  protected final String TEXT_311 = "();" + NL + "nsTool_";
  protected final String TEXT_312 = ".countNSMap(doc_";
  protected final String TEXT_313 = ".getRootElement());" + NL + "java.util.HashMap<String,String> xmlNameSpaceMap_";
  protected final String TEXT_314 = " = nsTool_";
  protected final String TEXT_315 = ".xmlNameSpaceMap;  " + NL + "" + NL + "org.dom4j.XPath x_";
  protected final String TEXT_316 = " = doc_";
  protected final String TEXT_317 = ".createXPath(nsTool_";
  protected final String TEXT_318 = ".addDefaultNSPrefix(";
  protected final String TEXT_319 = "));  " + NL + "x_";
  protected final String TEXT_320 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_321 = "); ";
  protected final String TEXT_322 = NL + "org.jaxen.NamespaceContext namespaceContext_";
  protected final String TEXT_323 = " = new org.jaxen.NamespaceContext() {" + NL + "" + NL + "\tpublic String translateNamespacePrefixToUri(String prefix) { " + NL + "\t\treturn \"\";//ignore prefix in xpath when evaluate" + NL + "\t}" + NL + "\t" + NL + "};" + NL + "x_";
  protected final String TEXT_324 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_325 = ");";
  protected final String TEXT_326 = NL + NL + "java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_327 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_328 = ".selectNodes(doc_";
  protected final String TEXT_329 = ");\t" + NL + "XML_API_";
  protected final String TEXT_330 = " xml_api_";
  protected final String TEXT_331 = " = new XML_API_";
  protected final String TEXT_332 = "();" + NL + "String str_";
  protected final String TEXT_333 = " = \"\";" + NL + "org.dom4j.Node node_";
  protected final String TEXT_334 = " = null;" + NL + "" + NL + "//init all mapping xpaths";
  protected final String TEXT_335 = NL + "for (org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_336 = ": nodeList_";
  protected final String TEXT_337 = ") {";
  protected final String TEXT_338 = NL + "class XML_API_";
  protected final String TEXT_339 = "{" + NL + "\tpublic boolean isDefNull(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        if(node[0] != null && node[1]!=null && (\"true\").equals(node[1])){" + NL + "        \treturn true;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        return node[0] == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(String[] node) throws javax.xml.transform.TransformerException {" + NL + "        if(node[0]!=null ){" + NL + "        \treturn node[0].length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}" + NL + "XML_API_";
  protected final String TEXT_340 = " xml_api_";
  protected final String TEXT_341 = " = new XML_API_";
  protected final String TEXT_342 = "();" + NL + "" + NL + "String[] queryPaths_";
  protected final String TEXT_343 = " = new String[]{";
  protected final String TEXT_344 = "\t" + NL + "\t";
  protected final String TEXT_345 = "\t\t" + NL + "\t,";
  protected final String TEXT_346 = "+\"/@xsi:nil\"";
  protected final String TEXT_347 = NL + "};" + NL + "" + NL + "boolean[] asXMLs_";
  protected final String TEXT_348 = " = new boolean[]{";
  protected final String TEXT_349 = "\t" + NL + "\t";
  protected final String TEXT_350 = "\t\t" + NL + "\t,false";
  protected final String TEXT_351 = NL + "};" + NL + "" + NL + "String str_";
  protected final String TEXT_352 = " = \"\";" + NL + "String[] node_";
  protected final String TEXT_353 = " = null;" + NL + "org.talend.xml.sax.SAXLooper looper_";
  protected final String TEXT_354 = " = new org.talend.xml.sax.SAXLooper(";
  protected final String TEXT_355 = ",queryPaths_";
  protected final String TEXT_356 = ",asXMLs_";
  protected final String TEXT_357 = ");";
  protected final String TEXT_358 = NL + "looper_";
  protected final String TEXT_359 = ".setIgnoreDTD(true);";
  protected final String TEXT_360 = NL + "looper_";
  protected final String TEXT_361 = ".setEncoding(";
  protected final String TEXT_362 = ");" + NL + "Object filename_";
  protected final String TEXT_363 = " = null;" + NL + "try {" + NL + "\tfilename_";
  protected final String TEXT_364 = " = ";
  protected final String TEXT_365 = ";" + NL + "} catch(java.lang.Exception e) {" + NL + "\t";
  protected final String TEXT_366 = NL + "\tthrow(e);" + NL + "\t";
  protected final String TEXT_367 = NL + "\tlog.error(\"";
  protected final String TEXT_368 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_369 = NL + "\tSystem.err.println(e.getMessage());" + NL + "\t";
  protected final String TEXT_370 = NL + "}" + NL + "if(filename_";
  protected final String TEXT_371 = " != null && filename_";
  protected final String TEXT_372 = " instanceof String && filename_";
  protected final String TEXT_373 = ".toString().startsWith(\"//\")){" + NL + "\tif (!isWindows_";
  protected final String TEXT_374 = "){" + NL + "\t\tfilename_";
  protected final String TEXT_375 = " = filename_";
  protected final String TEXT_376 = ".toString().replaceFirst(\"//\",\"/\");" + NL + "\t}" + NL + "}" + NL + "if(filename_";
  protected final String TEXT_377 = " instanceof java.io.InputStream){" + NL + "\tlooper_";
  protected final String TEXT_378 = ".parse((java.io.InputStream)filename_";
  protected final String TEXT_379 = ");" + NL + "}else{" + NL + "\tlooper_";
  protected final String TEXT_380 = ".parse(String.valueOf(filename_";
  protected final String TEXT_381 = "));" + NL + "}" + NL + "java.util.Iterator<java.util.Map<String, String>> it_";
  protected final String TEXT_382 = "  = looper_";
  protected final String TEXT_383 = ".iterator();";
  protected final String TEXT_384 = NL + "while (it_";
  protected final String TEXT_385 = ".hasNext()) {" + NL + "\tjava.util.Map<String, String> row_";
  protected final String TEXT_386 = " = it_";
  protected final String TEXT_387 = ".next();";
  protected final String TEXT_388 = NL + "\tnb_line_";
  protected final String TEXT_389 = "++;";
  protected final String TEXT_390 = NL + "\t";
  protected final String TEXT_391 = " = null;\t\t\t";
  protected final String TEXT_392 = NL + "\tif(xml_api_";
  protected final String TEXT_393 = ".getNodeType(tmp_";
  protected final String TEXT_394 = ",";
  protected final String TEXT_395 = ")==org.apache.xpath.objects.XObject.CLASS_NODESET){" + NL + "\t\tnode_";
  protected final String TEXT_396 = " = xml_api_";
  protected final String TEXT_397 = ".getSingleNode(tmp_";
  protected final String TEXT_398 = ",";
  protected final String TEXT_399 = ");";
  protected final String TEXT_400 = NL + "    \tif(node_";
  protected final String TEXT_401 = "!=null && node_";
  protected final String TEXT_402 = ".getNodeType()==org.w3c.dom.Node.ELEMENT_NODE && node_";
  protected final String TEXT_403 = ".hasChildNodes()){" + NL + "    \t\tstr_";
  protected final String TEXT_404 = " = contentTool_";
  protected final String TEXT_405 = ".getNodeContent(node_";
  protected final String TEXT_406 = ");" + NL + "    \t}else{" + NL + "    \t\tstr_";
  protected final String TEXT_407 = " = node_";
  protected final String TEXT_408 = "!=null?node_";
  protected final String TEXT_409 = ".getTextContent():\"\";" + NL + "    \t}";
  protected final String TEXT_410 = NL + "\t\tstr_";
  protected final String TEXT_411 = " = node_";
  protected final String TEXT_412 = "!=null?node_";
  protected final String TEXT_413 = ".getTextContent():\"\";";
  protected final String TEXT_414 = NL + "\t}else{" + NL + "\t\tnode_";
  protected final String TEXT_415 = " = tmp_";
  protected final String TEXT_416 = ";" + NL + "\t\tstr_";
  protected final String TEXT_417 = " = xml_api_";
  protected final String TEXT_418 = ".getNodeString(tmp_";
  protected final String TEXT_419 = ",";
  protected final String TEXT_420 = ");" + NL + "\t}";
  protected final String TEXT_421 = NL + "\torg.dom4j.XPath xTmp";
  protected final String TEXT_422 = "_";
  protected final String TEXT_423 = " = org.dom4j.DocumentHelper.createXPath(nsTool_";
  protected final String TEXT_424 = ".addDefaultNSPrefix(";
  protected final String TEXT_425 = ",";
  protected final String TEXT_426 = "));" + NL + "\txTmp";
  protected final String TEXT_427 = "_";
  protected final String TEXT_428 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_429 = ");";
  protected final String TEXT_430 = NL + "\txTmp";
  protected final String TEXT_431 = "_";
  protected final String TEXT_432 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_433 = ");";
  protected final String TEXT_434 = NL + "\tif(true) {" + NL + "\t\tthrow new RuntimeException(\"Error Config: \\\"Get Nodes\\\" should be checked when type is \\\"Document\\\"\");" + NL + "\t}";
  protected final String TEXT_435 = NL + "    Object obj";
  protected final String TEXT_436 = "_";
  protected final String TEXT_437 = " = xTmp";
  protected final String TEXT_438 = "_";
  protected final String TEXT_439 = ".evaluate(temp_";
  protected final String TEXT_440 = ");" + NL + "    if(obj";
  protected final String TEXT_441 = "_";
  protected final String TEXT_442 = " == null) {" + NL + "    \tnode_";
  protected final String TEXT_443 = " = null;";
  protected final String TEXT_444 = NL + "\t\tstr_";
  protected final String TEXT_445 = " = null;";
  protected final String TEXT_446 = NL + "    \tstr_";
  protected final String TEXT_447 = " = \"\";";
  protected final String TEXT_448 = NL + "    \t" + NL + "    } else if(obj";
  protected final String TEXT_449 = "_";
  protected final String TEXT_450 = " instanceof org.dom4j.Node) {" + NL + "    \tnode_";
  protected final String TEXT_451 = " = (org.dom4j.Node)obj";
  protected final String TEXT_452 = "_";
  protected final String TEXT_453 = ";";
  protected final String TEXT_454 = NL + "\t\tstr_";
  protected final String TEXT_455 = " = node_";
  protected final String TEXT_456 = ".asXML();";
  protected final String TEXT_457 = NL + "    \tstr_";
  protected final String TEXT_458 = " = org.jaxen.function.StringFunction.evaluate(node_";
  protected final String TEXT_459 = ",org.jaxen.dom4j.DocumentNavigator.getInstance());";
  protected final String TEXT_460 = NL + "    } else if(obj";
  protected final String TEXT_461 = "_";
  protected final String TEXT_462 = " instanceof String || obj";
  protected final String TEXT_463 = "_";
  protected final String TEXT_464 = " instanceof Number){" + NL + "    \tnode_";
  protected final String TEXT_465 = " = temp_";
  protected final String TEXT_466 = ";" + NL + "    \tstr_";
  protected final String TEXT_467 = " = String.valueOf(obj";
  protected final String TEXT_468 = "_";
  protected final String TEXT_469 = ");" + NL + "    } else if(obj";
  protected final String TEXT_470 = "_";
  protected final String TEXT_471 = " instanceof java.util.List){" + NL + "    \tjava.util.List<org.dom4j.Node> nodes_";
  protected final String TEXT_472 = " = (java.util.List<org.dom4j.Node>)obj";
  protected final String TEXT_473 = "_";
  protected final String TEXT_474 = ";" + NL + "    \tnode_";
  protected final String TEXT_475 = " = nodes_";
  protected final String TEXT_476 = ".size()>0 ? nodes_";
  protected final String TEXT_477 = ".get(0) : null;";
  protected final String TEXT_478 = NL + "\t\tstr_";
  protected final String TEXT_479 = " = node_";
  protected final String TEXT_480 = "==null?null:node_";
  protected final String TEXT_481 = ".asXML();";
  protected final String TEXT_482 = NL + "    \tstr_";
  protected final String TEXT_483 = " = node_";
  protected final String TEXT_484 = "==null?\"\":org.jaxen.function.StringFunction.evaluate(node_";
  protected final String TEXT_485 = ",org.jaxen.dom4j.DocumentNavigator.getInstance());";
  protected final String TEXT_486 = NL + "\t}";
  protected final String TEXT_487 = NL + "\tstr_";
  protected final String TEXT_488 = " = row_";
  protected final String TEXT_489 = ".get(";
  protected final String TEXT_490 = ");";
  protected final String TEXT_491 = NL + "\tnode_";
  protected final String TEXT_492 = " = new String[]{str_";
  protected final String TEXT_493 = ",row_";
  protected final String TEXT_494 = ".get(";
  protected final String TEXT_495 = "+\"/@xsi:nil\")};";
  protected final String TEXT_496 = NL + "\tnode_";
  protected final String TEXT_497 = " = new String[]{str_";
  protected final String TEXT_498 = ",null};";
  protected final String TEXT_499 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_500 = ".";
  protected final String TEXT_501 = " = ParserUtils.parseTo_Document(str_";
  protected final String TEXT_502 = ",";
  protected final String TEXT_503 = ",";
  protected final String TEXT_504 = ");";
  protected final String TEXT_505 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_506 = ".";
  protected final String TEXT_507 = " = str_";
  protected final String TEXT_508 = ";";
  protected final String TEXT_509 = NL + "\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_510 = ".isDefNull(node_";
  protected final String TEXT_511 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_512 = ".";
  protected final String TEXT_513 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_514 = ".isEmpty(node_";
  protected final String TEXT_515 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_516 = ".";
  protected final String TEXT_517 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_518 = ".isMissing(node_";
  protected final String TEXT_519 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_520 = ".";
  protected final String TEXT_521 = " =";
  protected final String TEXT_522 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_523 = NL + "\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_524 = ".isEmpty(node_";
  protected final String TEXT_525 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_526 = ".";
  protected final String TEXT_527 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_528 = ".isMissing(node_";
  protected final String TEXT_529 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_530 = ".";
  protected final String TEXT_531 = " =";
  protected final String TEXT_532 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_533 = "\t" + NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_534 = ".isDefNull(node_";
  protected final String TEXT_535 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_536 = ".";
  protected final String TEXT_537 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_538 = ".isEmpty(node_";
  protected final String TEXT_539 = ") || xml_api_";
  protected final String TEXT_540 = ".isMissing(node_";
  protected final String TEXT_541 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_542 = ".";
  protected final String TEXT_543 = "=";
  protected final String TEXT_544 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_545 = NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_546 = ".isMissing(node_";
  protected final String TEXT_547 = ") || xml_api_";
  protected final String TEXT_548 = ".isEmpty(node_";
  protected final String TEXT_549 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_550 = ".";
  protected final String TEXT_551 = " =";
  protected final String TEXT_552 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_553 = NL + "\t\t";
  protected final String TEXT_554 = ".";
  protected final String TEXT_555 = " = str_";
  protected final String TEXT_556 = ";";
  protected final String TEXT_557 = NL + "\t\t";
  protected final String TEXT_558 = ".";
  protected final String TEXT_559 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_560 = ", ";
  protected final String TEXT_561 = ",false);";
  protected final String TEXT_562 = NL + "\t\t";
  protected final String TEXT_563 = ".";
  protected final String TEXT_564 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_565 = ", ";
  protected final String TEXT_566 = ");";
  protected final String TEXT_567 = "\t\t\t\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_568 = ".";
  protected final String TEXT_569 = " = str_";
  protected final String TEXT_570 = ".getBytes(";
  protected final String TEXT_571 = ");";
  protected final String TEXT_572 = NL + "\t\t";
  protected final String TEXT_573 = ".";
  protected final String TEXT_574 = " = ParserUtils.parseTo_";
  protected final String TEXT_575 = "(ParserUtils.parseTo_Number(str_";
  protected final String TEXT_576 = ", ";
  protected final String TEXT_577 = ", ";
  protected final String TEXT_578 = "));";
  protected final String TEXT_579 = NL + "\t\t";
  protected final String TEXT_580 = ".";
  protected final String TEXT_581 = " = ParserUtils.parseTo_";
  protected final String TEXT_582 = "(str_";
  protected final String TEXT_583 = ");";
  protected final String TEXT_584 = NL + "\t}";
  protected final String TEXT_585 = NL + "    \t\t\t\t";
  protected final String TEXT_586 = ".";
  protected final String TEXT_587 = " = ";
  protected final String TEXT_588 = ".";
  protected final String TEXT_589 = ";";
  protected final String TEXT_590 = NL + "\tboolean whetherReject_";
  protected final String TEXT_591 = " = false;" + NL + "\t";
  protected final String TEXT_592 = " = new ";
  protected final String TEXT_593 = "Struct();" + NL + "\ttry{";
  protected final String TEXT_594 = " ";
  protected final String TEXT_595 = " ";
  protected final String TEXT_596 = " = null; ";
  protected final String TEXT_597 = NL + "\t\t\t" + NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_598 = " = true;";
  protected final String TEXT_599 = NL + "            throw(e);";
  protected final String TEXT_600 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_601 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_602 = NL + "                    ";
  protected final String TEXT_603 = " = new ";
  protected final String TEXT_604 = "Struct();";
  protected final String TEXT_605 = NL + "                ";
  protected final String TEXT_606 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_607 = ";";
  protected final String TEXT_608 = NL + "                ";
  protected final String TEXT_609 = " = null;";
  protected final String TEXT_610 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_611 = NL + "                ";
  protected final String TEXT_612 = " = null;";
  protected final String TEXT_613 = NL + "            \t";
  protected final String TEXT_614 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_615 = ";";
  protected final String TEXT_616 = NL + "    }";
  protected final String TEXT_617 = NL + "\t\t";
  protected final String TEXT_618 = "if(!whetherReject_";
  protected final String TEXT_619 = ") { ";
  protected final String TEXT_620 = "      " + NL + "             if(";
  protected final String TEXT_621 = " == null){ " + NL + "            \t ";
  protected final String TEXT_622 = " = new ";
  protected final String TEXT_623 = "Struct();" + NL + "             }";
  protected final String TEXT_624 = NL + "\t    \t ";
  protected final String TEXT_625 = ".";
  protected final String TEXT_626 = " = ";
  protected final String TEXT_627 = ".";
  protected final String TEXT_628 = ";    \t\t\t\t";
  protected final String TEXT_629 = NL + "\t\t";
  protected final String TEXT_630 = " } ";
  protected final String TEXT_631 = "\t";
  protected final String TEXT_632 = NL + "\t" + NL + "\tif (nb_line_";
  protected final String TEXT_633 = ">";
  protected final String TEXT_634 = ") {" + NL + "\t";
  protected final String TEXT_635 = NL + "\t\t\tlooper_";
  protected final String TEXT_636 = ".stopRead();" + NL + "\t";
  protected final String TEXT_637 = NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_638 = NL + "\t\t\t";
  protected final String TEXT_639 = NL;

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
	
    stringBuffer.append(TEXT_29);
    
	class DefaultRowUtil {
		String cid = "";
		INode node;
		int schemaOptNum;
		int columnListSize;
		boolean isOptimizeCode;
		boolean isBehindDynamic;
	
		boolean useV2C = false;
		IMetadataTable V2CMetadata;
		String V2CTargetConnName;
		String V2CSourceValueClass;
		String V2CSourceValueName;
		StringBuffer parmsStr;
		StringBuffer varsStr;
		public void prepareOptimizeParam(IMetadataTable metadata,int schemaOptNum){
			this.schemaOptNum=schemaOptNum;
			this.columnListSize = metadata.getListColumns().size();
			this.isOptimizeCode = schemaOptNum < this.columnListSize;
		}
		
		public void prepareValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int schemaOptNum){
			this.node = node;
			this.V2CMetadata = metadata;
			this.V2CTargetConnName = targetConnName;
			this.V2CSourceValueClass = sourceValueClass;
			this.V2CSourceValueName = sourceValueName;
			this.useV2C = true;
			prepareOptimizeParam(metadata, schemaOptNum);
		}
		public void genVarsParmsStr(Map<String,String> varsMap){
			parmsStr=new StringBuffer();
			varsStr=new StringBuffer();
			if(varsMap!=null && varsMap.size()>0){
				java.util.Set<String> vars=varsMap.keySet();
				for(String varName:vars){
					parmsStr.append(","+varsMap.get(varName)+" "+varName);
					varsStr.append(","+varName);
				}
			}
		}
		public void codeForValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int start , int end){
		}
		
		public void callValueToConn(String sourceValueName, String targetConnName){
			if(isOptimizeCode){
		
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_34);
    
			}else{
				codeForValueToConn(node, V2CMetadata, V2CSourceValueClass, V2CSourceValueName, V2CTargetConnName, 0, columnListSize);
			}
		}
		
		boolean useV2CWithD = false;
		IMetadataTable V2CWithDMetadata;
		String V2CWithDTargetConnName;
		String V2CWithDSourceValueClass;
		String V2CWithDSourceValueName;
		String V2CWithDDynamicName;
		public void prepareValueToConnWithD(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, String dynamicName, int schemaOptNum){
			this.node = node;
			this.V2CWithDMetadata = metadata;
			this.V2CWithDTargetConnName = targetConnName;
			this.V2CWithDSourceValueClass = sourceValueClass;
			this.V2CWithDSourceValueName = sourceValueName;
			this.V2CWithDDynamicName = dynamicName;
			this.useV2CWithD = true;
			prepareOptimizeParam(metadata, schemaOptNum);
		}
		
		public boolean codeForValueToConnWithD(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, String dynamicName ,int start , int end){
			return false;
		}
		
		public void callValueToConnWithD(String sourceValueName, String targetConnName, String dynamicName){
			if(isOptimizeCode){
		
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_40);
    
			}else{
				codeForValueToConnWithD(node, V2CWithDMetadata, V2CWithDSourceValueClass, V2CWithDSourceValueName, V2CWithDTargetConnName, V2CWithDDynamicName, 0, columnListSize);
			}
		}
		
		IMetadataTable C2CMetadata;
		String C2CTargetConnName;
		String C2CSourceConnName;
		boolean useC2C = false;
		public void prepareConnToConn(IMetadataTable metadata, String sourceConnName, String targetConnName){
			this.C2CMetadata = metadata;
			this.C2CTargetConnName = targetConnName;
			this.C2CSourceConnName = sourceConnName;
			this.useC2C = true;
		}
		
		public void codeForConnToConn(INode node, IMetadataTable metadata, String sourceConnName, String targetConnName, int start ,int end){
		}
		
		public void callConnToConn(String sourceConnName, String targetConnName){
			if(isOptimizeCode){
		
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_44);
    
			}else{
				codeForConnToConn(node, C2CMetadata, C2CSourceConnName, C2CTargetConnName, 0, columnListSize);
			}
		}
		
		
		public void generateClass(){
		  	if(isOptimizeCode){
				cid = node.getUniqueName();
				int methodNum=(columnListSize%schemaOptNum==0?columnListSize/schemaOptNum:(columnListSize/schemaOptNum)+1);
				
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
				int start=0;
				int end=0;
				for(int i=0;i<methodNum;i++){
					start=i*schemaOptNum;
					if(i==(methodNum-1)){
						end=columnListSize;
					}else{
						end=(i+1)*schemaOptNum;
					}
					if(useV2C){
					
    stringBuffer.append(TEXT_47);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(V2CSourceValueClass);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_53);
    codeForValueToConn(node, V2CMetadata, V2CSourceValueClass, V2CSourceValueName, V2CTargetConnName, start, end);
    stringBuffer.append(TEXT_54);
    	
					}
					if(useV2CWithD){
					
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(V2CWithDSourceValueClass);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_62);
    this.isBehindDynamic = codeForValueToConnWithD(node, V2CWithDMetadata, V2CWithDSourceValueClass, V2CWithDSourceValueName, V2CWithDTargetConnName, V2CWithDDynamicName, start, end);
    stringBuffer.append(TEXT_63);
    		
					}
					if(useC2C){
					
    stringBuffer.append(TEXT_64);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_69);
    codeForConnToConn(node, C2CMetadata, C2CSourceConnName, C2CTargetConnName, start, end);
    stringBuffer.append(TEXT_70);
    
					}
				}
				if(useV2C){//Call all split methods in one method
				
    stringBuffer.append(TEXT_71);
    stringBuffer.append(V2CSourceValueClass);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_76);
    	
				}
				if(useV2CWithD){
				
    stringBuffer.append(TEXT_77);
    stringBuffer.append(V2CWithDSourceValueClass);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_83);
    
				}
				for(int i=0;i<methodNum;i++){
					if(useV2C){
					
    stringBuffer.append(TEXT_84);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_88);
    
					}
					if(useV2CWithD){
					
    stringBuffer.append(TEXT_89);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_94);
    
					}
				}
				if(useV2C || useV2CWithD){
				
    stringBuffer.append(TEXT_95);
    
				}
				if(useC2C){
				
    stringBuffer.append(TEXT_96);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_100);
    
					for(int i=0;i<methodNum;i++){
						if(useC2C){
						
    stringBuffer.append(TEXT_101);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_104);
    
						}
					}
					
    stringBuffer.append(TEXT_105);
    
				}
				
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
		  	}
		}
	}
	
    stringBuffer.append(TEXT_110);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
        
List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__"); 

String filename = ElementParameterParser.getValue(node, "__FILENAME__");

String ignore_NS_Str = ElementParameterParser.getValue(node, "__IGNORE_NS__");
String tmp_filename = ElementParameterParser.getValue(node, "__TMP_FILENAME__");

String useSeparator = ElementParameterParser.getValue(node, "__USE_SEPARATOR__");
String fieldSeparator = ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");

String limit = ElementParameterParser.getValue(node, "__LIMIT__");
if (("").equals(limit)) {
	limit = "-1";
}

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;


boolean ignoreDTD="true".equals(ElementParameterParser.getValue(node, "__IGNORE_DTD__"));

String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		
/* -------------------------- */

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
	}

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
// *** Xerces *** //
if(("Xerces").equals(mode)){

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    if("true".equals(useSeparator)){
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
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
      }

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_152);
    if (dieOnError) {
    stringBuffer.append(TEXT_153);
    }else{
    stringBuffer.append(TEXT_154);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    }
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    if (dieOnError) {
    stringBuffer.append(TEXT_185);
    }else{
    stringBuffer.append(TEXT_186);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    }
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    }
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    
// *** Dom4j *** //
}else if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
	if(("true").equals(ignore_NS_Str)){

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    
	}

    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
      if(ignoreDTD){

    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    
      }

    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_226);
    if (dieOnError) {
    stringBuffer.append(TEXT_227);
    }else{
    stringBuffer.append(TEXT_228);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    }
    stringBuffer.append(TEXT_231);
    }
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    
	if(("true").equals(ignore_NS_Str)){

    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(tmp_filename );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    if (dieOnError) {
    stringBuffer.append(TEXT_266);
    }else{
    stringBuffer.append(TEXT_267);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_270);
    }
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(tmp_filename );
    stringBuffer.append(TEXT_276);
    
	}

    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    if (dieOnError) {
    stringBuffer.append(TEXT_299);
    }else{
    stringBuffer.append(TEXT_300);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    }
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    }
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    if(("true").equals(ignore_NS_Str)){
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    }
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    
// *** SAX *** //
}else if(("SAX").equals(mode)){

    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    
	boolean first = true;
	for(Map<String,String> path:mapping){

    stringBuffer.append(TEXT_344);
    stringBuffer.append(first?"":",");
    stringBuffer.append(path.get("QUERY"));
    
		String query = path.get("QUERY");
		if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_345);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_346);
    
		}
		first=false;
	}

    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    
	first = true;
	for(Map<String,String> path:mapping){

    stringBuffer.append(TEXT_349);
    stringBuffer.append(first?"":",");
    stringBuffer.append("true".equals(path.get("NODECHECK"))? "true":"false" );
    
		String query = path.get("QUERY");
		if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_350);
    
		}
		first=false;
	}

    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    if(ignoreDTD){
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    }
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_365);
    if (dieOnError) {
    stringBuffer.append(TEXT_366);
    }else{
		if(isLog4jEnabled){
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    }
    stringBuffer.append(TEXT_369);
    }
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    
}

    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
String firstConnName = "";
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		if (conns!=null) {
//************ add for reject start*****************
		    String rejectConnName = "";
		    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
		    if(rejectConns != null && rejectConns.size() > 0) {
		        IConnection rejectConn = rejectConns.get(0);
		        rejectConnName = rejectConn.getName();
		    }
		    List<IMetadataColumn> rejectColumnList = null;
		    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
		    if(metadataTable != null) {
		        rejectColumnList = metadataTable.getListColumns();      
		    }
			for (int i=0;i<conns.size();i++) {
				IConnection connTemp = conns.get(i);
				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_390);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_391);
    
				}
    		}
//***************************end********************
			Map<String,String> varsMap=new java.util.HashMap<String,String>();
			varsMap.put("xml_api_"+cid,"XML_API_"+cid);
			if("true".equals(useSeparator)){
				varsMap.put("contentTool_"+cid,"ContentTool_"+cid);
			}
			if(("Xerces").equals(mode)){
				varsMap.put("tmp_"+cid,"org.w3c.dom.Node");
				varsMap.put("node_"+cid,"org.w3c.dom.Node");
			}
			if(("Dom4j").equals(mode)){
				varsMap.put("node_"+cid,"org.dom4j.Node");
				varsMap.put("nsTool_"+cid,"NameSpaceTool_"+cid);
				varsMap.put("xmlNameSpaceMap_"+cid,"java.util.HashMap<String,String>");
				varsMap.put("temp_"+cid,"org.dom4j.tree.AbstractNode");
				if(("true").equals(ignore_NS_Str)){
					varsMap.put("namespaceContext_"+cid,"org.jaxen.NamespaceContext");
				}
			}
			if(("SAX").equals(mode)){
				varsMap.put("row_"+cid,"java.util.Map<String, String>");
				varsMap.put("node_"+cid,"String[]");
			}
			class RowUtil extends DefaultRowUtil{
				public void codeForValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int start , int end){
					cid = node.getUniqueName();
					boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
					List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
					List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
					IConnection conn = conns.get(0);
					String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
					boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
					String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
					String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
					
					String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
					boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
					boolean ignoreDTD="true".equals(ElementParameterParser.getValue(node, "__IGNORE_DTD__"));
					String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
					
					String useSeparator = ElementParameterParser.getValue(node, "__USE_SEPARATOR__");
					
					String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
					String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__"); 
					String ignore_NS_Str = ElementParameterParser.getValue(node, "__IGNORE_NS__");
					
					for (int i=start;i<end;i++) { // S_for_a_1_0
						String query = mapping.get(i).get("QUERY");
						String nodeCheck = mapping.get(i).get("NODECHECK");
						if(("Xerces").equals(mode)){

    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_399);
    
							if("true".equals(useSeparator)){

    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    
							}else{

    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    
							}

    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_419);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_420);
    
						}else if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_421);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    
							if(("true").equals(ignore_NS_Str)){

    stringBuffer.append(TEXT_430);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    
							}
							//TDI-18498
							boolean isWrongConfig = false;
							
							for(IMetadataColumn column:metadata.getListColumns()) {
								if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
									if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
										if("id_Document".equals(column.getTalendType()) && "false".equals(nodeCheck)) {
											isWrongConfig = true;
											break;
										}
									}
								}
							}
							
							if(isWrongConfig) {

    stringBuffer.append(TEXT_434);
    
							}

    stringBuffer.append(TEXT_435);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    
							if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_445);
    
							
							}else{

    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_447);
    
						}

    stringBuffer.append(TEXT_448);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    
							if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_456);
    
							
							}else{

    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_459);
    
							}

    stringBuffer.append(TEXT_460);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    
							if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_481);
    
							
							}else{

    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_485);
    
							}

    stringBuffer.append(TEXT_486);
    
						}else if(("SAX").equals(mode)){

    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_490);
    
							if(query!=null && query.indexOf("@")<0){

    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_495);
    
							}else{

    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
    
							}
						}
						for(IMetadataColumn column:metadata.getListColumns()) {  // S_for_0_1
							if (mapping.get(i).get("SCHEMA_COLUMN")!=null) { // S_if_0_2
								if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) { // S_if_0_3
									String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
									JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
									String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
									
									boolean isNotSetDefault = false;
									String defaultValue=column.getDefault();
									if(defaultValue!=null){
										isNotSetDefault = defaultValue.length()==0;
									}else{
										isNotSetDefault=true;
									}
									if(("Dom4j").equals(mode) && ("true").equals(nodeCheck)){
										if("id_Document".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_499);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_500);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(ignoreDTD);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_504);
    
										} else {

    stringBuffer.append(TEXT_505);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    
										}
										continue;
									}
									if(javaType == JavaTypesManager.STRING){
										if(column.isNullable()){

    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_516);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_522);
    
										}else{ // column.isNullable()

    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_526);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_530);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_531);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_532);
    
										}
									}else{ // other type
										if(column.isNullable()){

    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_536);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_542);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_544);
    
								  		}else{ // column.isNullable()

    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_550);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_551);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_552);
    
										}
									}
									if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_553);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_556);
    
									} else if (javaType == JavaTypesManager.DATE) {
										if(checkDate) {

    stringBuffer.append(TEXT_557);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_558);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_560);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_561);
      
										} else {

    stringBuffer.append(TEXT_562);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_563);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_565);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_566);
    
										}
									} else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_567);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_568);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_570);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_571);
    
									} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_572);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_574);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_576);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_577);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_578);
    
									} else {

    stringBuffer.append(TEXT_579);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_580);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_581);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_583);
    
									}

    stringBuffer.append(TEXT_584);
    
								} //S_if_1_2
							} // S_if_1_1
						} // S_for_1_0
					} // S_for_a_1_0
				}
				
				public void codeForConnToConn(INode node, IMetadataTable metadata, String sourceConnName, String targetConnName, int start , int end){
	    			for(int colNum=start;colNum<end;colNum++) {
	    				IMetadataColumn column=metadata.getListColumns().get(colNum);

    stringBuffer.append(TEXT_585);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_587);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_589);
    
					}
				}
			}//class defined end
			RowUtil rowUtil = new RowUtil(); 
			if (conns.size()>0) { // S_if_a_0_0	
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
			    if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
			    	rowUtil.genVarsParmsStr(varsMap);
					rowUtil.prepareValueToConn(node, metadata, "String", "str_"+cid, firstConnName, schemaOptNum);
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
						rowUtil.prepareConnToConn(metadata, firstConnName, rejectConnName);
					}
					rowUtil.generateClass();
				}
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // add for reject

    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_592);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_593);
    
	rowUtil.callValueToConn("str_"+cid, firstConnName);

     log4jFileUtil.debugRetriveData(node); 
    stringBuffer.append(TEXT_594);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_595);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_596);
    }
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_599);
    
        } else {
			if(isLog4jEnabled){
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    }
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_602);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_603);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_604);
    
                rowUtil.callConnToConn(firstConnName, rejectConnName);
                
    stringBuffer.append(TEXT_605);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_607);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_609);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_610);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_612);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_613);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_615);
    }
		}
        
    stringBuffer.append(TEXT_616);
    
				} //if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))
			} // S_if_a_1_1

//***********************************
			if (conns.size()>0) {	
				boolean isFirstEnter = true;
				for (int i=0;i<conns.size();i++) {
					IConnection tmpconn = conns.get(i);
					if ((tmpconn.getName().compareTo(firstConnName)!=0)&&(tmpconn.getName().compareTo(rejectConnName)!=0)&&(tmpconn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_617);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_620);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_621);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_622);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_623);
    
			    	 	for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_624);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_625);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_626);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_627);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_628);
    
				 		}
					}
				}

    stringBuffer.append(TEXT_629);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_630);
     } 
    stringBuffer.append(TEXT_631);
    
			}
//***********************************

		} // if(conn!=null)
		
		// limit
		if (limit.compareTo("-1")!=0) {

    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_633);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_634);
    if(("SAX").equals(mode)) {
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    }
    stringBuffer.append(TEXT_637);
     
		}
	}// if (metadata!=null)
} //if ((metadatas!=null)&&(metadatas.size()>0))

    stringBuffer.append(TEXT_638);
    stringBuffer.append(TEXT_639);
    return stringBuffer.toString();
  }
}
