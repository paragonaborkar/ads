package org.talend.designer.codegen.translators.xml;

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

public class TExtractXMLFieldBeginJava
{
  protected static String nl;
  public static synchronized TExtractXMLFieldBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractXMLFieldBeginJava result = new TExtractXMLFieldBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "" + NL + "class NameSpaceTool_";
  protected final String TEXT_4 = " {" + NL + "" + NL + "    public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();" + NL + "    " + NL + "\tprivate java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();" + NL + "" + NL + "    public void countNSMap(org.dom4j.Element el) {" + NL + "        for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {" + NL + "            if (ns.getPrefix().trim().length() == 0) {" + NL + "                xmlNameSpaceMap.put(\"pre\"+defualtNSPath.size(), ns.getURI());" + NL + "                String path = \"\";" + NL + "                org.dom4j.Element elTmp = el;" + NL + "                while (elTmp != null) {" + NL + "                   \tif (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {" + NL + "                        path = \"/\" + elTmp.getNamespacePrefix() + \":\" + elTmp.getName() + path;" + NL + "                    } else {" + NL + "                        path = \"/\" + elTmp.getName() + path;" + NL + "                    }" + NL + "                    elTmp = elTmp.getParent();" + NL + "                }" + NL + "                defualtNSPath.add(path);" + NL + "            } else {" + NL + "                xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());" + NL + "            }" + NL + "" + NL + "        }" + NL + "        for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {" + NL + "            countNSMap(e);" + NL + "        }" + NL + "    }" + NL + "    " + NL + "    /**" + NL + "\t *\tthe regex for the xpath like that : " + NL + "\t *\tcase 1 : functionA(locationXPathExpression) " + NL + "\t *\tcase 2 : fn:functionA(locationXPathExpression) " + NL + "\t *\tcase 3 : functionA(functionB(locationXPathExpression))" + NL + "\t *\tcase 4 : fn:functionA(fn:functionB(locationXPathExpression))" + NL + "\t *\tand like that." + NL + "\t*/" + NL + "\tprivate java.util.regex.Pattern simpleFunctionPattern;" + NL + "\tprivate StringBuffer stringBuffer;" + NL + "\tprivate java.util.Map<String,String> resultCache;" + NL + "\t" + NL + "\tpublic String addDefaultNSPrefix(final String xpathExpression, String loopPath) {" + NL + "\t    if (defualtNSPath.size() < 1) {" + NL + "        \treturn xpathExpression;" + NL + "    \t}" + NL + "    \t" + NL + "    \tif(resultCache == null) {" + NL + "    \t\tresultCache = new java.util.HashMap<String,String>();" + NL + "    \t}" + NL + "    \t" + NL + "    \tString resultXpathExpression = resultCache.get(xpathExpression);" + NL + "\t\tif(resultXpathExpression!=null) {" + NL + "    \t\treturn resultXpathExpression;" + NL + "    \t}" + NL + "    \t" + NL + "    \tString locationPathExpression = xpathExpression;" + NL + "    \t" + NL + "    \tif(simpleFunctionPattern == null) {" + NL + "    \t\tsimpleFunctionPattern = java.util.regex.Pattern.compile(\"([a-zA-z0-9]+:)?[a-zA-Z]+-?[A-Za-z]+\\\\(.*\\\\)\");" + NL + "    \t}" + NL + "    \t" + NL + "    \tboolean isSimpleFunctionXPath = simpleFunctionPattern.matcher(xpathExpression).matches();" + NL + "    \tString tail = null;" + NL + "    \tif(isSimpleFunctionXPath) {" + NL + "\t\t\tint start = xpathExpression.lastIndexOf('(');" + NL + "\t\t\tint end = xpathExpression.indexOf(')');" + NL + "\t\t\tif(start < end) {" + NL + "\t\t\t    if(stringBuffer == null) {" + NL + "    \t\t\t\tstringBuffer = new StringBuffer();" + NL + "    \t\t\t}" + NL + "\t\t\t\tlocationPathExpression = xpathExpression.substring(start+1,end);" + NL + "\t\t\t\tstringBuffer.append(xpathExpression.substring(0,start+1));" + NL + "\t\t\t\ttail = xpathExpression.substring(end);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tisSimpleFunctionXPath = false;" + NL + "\t\t\t}" + NL + "    \t}" + NL + "    \t" + NL + "    \tlocationPathExpression = addDefaultNSPrefixForLocationXPathExpression(locationPathExpression,loopPath);" + NL + "    \t" + NL + "    \tresultXpathExpression = locationPathExpression;" + NL + "    \t" + NL + "    \tif(isSimpleFunctionXPath) {" + NL + "        \tstringBuffer.append(locationPathExpression);" + NL + "    \t\tstringBuffer.append(tail);" + NL + "    \t\tresultXpathExpression = stringBuffer.toString();" + NL + "    \t\tstringBuffer.setLength(0);" + NL + "        }" + NL + "    \t" + NL + "    \tresultCache.put(xpathExpression,resultXpathExpression);" + NL + "    \treturn resultXpathExpression;" + NL + "\t}" + NL + "\t" + NL + "    private String addDefaultNSPrefixForLocationXPathExpression(String path, String loopPath) {" + NL + "    \tString fullPath = loopPath;" + NL + "    \tif(!path.equals(fullPath)){" + NL + "        \tfor (String tmp : path.split(\"/\")) {" + NL + "        \t\tif ((\"..\").equals(tmp)) {" + NL + "                    fullPath = fullPath.substring(0, fullPath.lastIndexOf(\"/\"));" + NL + "                } else {" + NL + "                    fullPath += \"/\" + tmp;" + NL + "                }" + NL + "        \t}" + NL + "        }" + NL + "    \tint[] indexs = new int[fullPath.split(\"/\").length - 1];" + NL + "        java.util.Arrays.fill(indexs, -1);" + NL + "        int length = 0;" + NL + "        for (int i = 0; i < defualtNSPath.size(); i++) {" + NL + "            if (defualtNSPath.get(i).length() > length && fullPath.startsWith(defualtNSPath.get(i))) {" + NL + "                java.util.Arrays.fill(indexs, defualtNSPath.get(i).split(\"/\").length - 2, indexs.length, i);" + NL + "                length = defualtNSPath.get(i).length();" + NL + "            }" + NL + "        }" + NL + "    " + NL + "        StringBuilder newPath = new StringBuilder();" + NL + "        String[] pathStrs = path.split(\"/\");" + NL + "        for (int i = 0; i < pathStrs.length; i++) {" + NL + "            String tmp = pathStrs[i];" + NL + "            if (newPath.length() > 0) {" + NL + "                newPath.append(\"/\");" + NL + "            }" + NL + "            if (tmp.length() > 0 && tmp.indexOf(\":\") == -1 && tmp.indexOf(\".\") == -1 /*&& tmp.indexOf(\"@\") == -1*/) {" + NL + "                int index = indexs[i + indexs.length - pathStrs.length];" + NL + "                if (index >= 0) {" + NL + "                \t//==== add by wliu to support both filter and functions==" + NL + "    \t\t\t\tif(tmp.indexOf(\"[\")>0 && tmp.indexOf(\"]\")>tmp.indexOf(\"[\")){//include filter" + NL + "    \t\t\t\t\tString tmpStr=replaceElementWithNS(tmp,\"pre\"+index+\":\");" + NL + "    \t\t\t\t\tnewPath.append(tmpStr);" + NL + "    \t\t\t\t}else{" + NL + "    \t\t\t\t\tif(tmp.indexOf(\"@\") != -1 || tmp.indexOf(\"(\")<tmp.indexOf(\")\")){  // include attribute" + NL + "    \t\t\t\t\t\tnewPath.append(tmp);" + NL + "    \t\t\t\t\t}else{" + NL + "    \t\t\t\t//==add end=======\t" + NL + "                    \t\tnewPath.append(\"pre\").append(index).append(\":\").append(tmp);" + NL + "                    \t}" + NL + "                    }                    " + NL + "                } else {" + NL + "                    newPath.append(tmp);" + NL + "                }" + NL + "            } else {" + NL + "                newPath.append(tmp);" + NL + "            }" + NL + "        }" + NL + "        return newPath.toString();" + NL + "    }" + NL + "    " + NL + "\tprivate String matches = \"@*\\\\b[a-z|A-Z|_]+[[-]*\\\\w]*\\\\b[^'|^\\\\(]\";" + NL + "    private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(matches);" + NL + "    " + NL + "\tprivate String replaceElementWithNS(String global, String pre){" + NL + "" + NL + "        java.util.regex.Matcher match = pattern.matcher(global);" + NL + "        StringBuffer sb = new StringBuffer();" + NL + "        match.reset();" + NL + "        while (match.find()) {" + NL + "            String group = match.group();" + NL + "            String tmp = \"\";" + NL + "            if (group.toLowerCase().matches(\"\\\\b(div|mod|and|or)\\\\b.*\") || group.matches(\"@.*\")) {" + NL + "                tmp = group;" + NL + "            } else {" + NL + "                tmp = tmp + pre + group;" + NL + "            }" + NL + "            match.appendReplacement(sb, tmp);" + NL + "        }" + NL + "        match.appendTail(sb);" + NL + "        " + NL + "        return sb.toString();" + NL + "\t}" + NL + "\t" + NL + "}" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_5 = "{" + NL + "\tpublic boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node instanceof org.dom4j.Element) {" + NL + "        \torg.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "        \tif(attri != null && (\"true\").equals(attri.getText())){" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getText().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }";
  protected final String TEXT_6 = NL + "\t\t\tpublic void putUnExtractValue_";
  protected final String TEXT_7 = "(";
  protected final String TEXT_8 = "Struct ";
  protected final String TEXT_9 = ",";
  protected final String TEXT_10 = "Struct ";
  protected final String TEXT_11 = "){";
  protected final String TEXT_12 = NL + "\t\t\t\t";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = ";";
  protected final String TEXT_17 = NL + "\t\t\t}";
  protected final String TEXT_18 = NL + "\t\t\t}";
  protected final String TEXT_19 = NL + "\t\t\tpublic void putExtractValue_";
  protected final String TEXT_20 = "(";
  protected final String TEXT_21 = "Struct ";
  protected final String TEXT_22 = ",";
  protected final String TEXT_23 = "Struct ";
  protected final String TEXT_24 = ",";
  protected final String TEXT_25 = NL + "\t\t\t\tString xmlStr_";
  protected final String TEXT_26 = ",org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_27 = ",NameSpaceTool_";
  protected final String TEXT_28 = " nsTool_";
  protected final String TEXT_29 = ",String loopQuery_";
  protected final String TEXT_30 = ",java.util.HashMap xmlNameSpaceMap_";
  protected final String TEXT_31 = ",org.dom4j.Node node_";
  protected final String TEXT_32 = "," + NL + "\t\t\t\t\tString str_";
  protected final String TEXT_33 = ",XML_API_";
  protected final String TEXT_34 = " xml_api_";
  protected final String TEXT_35 = ",org.jaxen.NamespaceContext namespaceContext_";
  protected final String TEXT_36 = ")throws java.lang.Exception {" + NL + "\t\t\t\t" + NL + "\t\t\t\t\tboolean resultIsNode_";
  protected final String TEXT_37 = " = true;";
  protected final String TEXT_38 = NL + "\t\t\t\torg.dom4j.XPath xTmp";
  protected final String TEXT_39 = "_";
  protected final String TEXT_40 = " = temp_";
  protected final String TEXT_41 = ".createXPath(nsTool_";
  protected final String TEXT_42 = ".addDefaultNSPrefix(";
  protected final String TEXT_43 = ",loopQuery_";
  protected final String TEXT_44 = "));" + NL + "\t\t\t    xTmp";
  protected final String TEXT_45 = "_";
  protected final String TEXT_46 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_47 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\txTmp";
  protected final String TEXT_49 = "_";
  protected final String TEXT_50 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_51 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t    Object obj";
  protected final String TEXT_53 = "_";
  protected final String TEXT_54 = " = xTmp";
  protected final String TEXT_55 = "_";
  protected final String TEXT_56 = ".evaluate(temp_";
  protected final String TEXT_57 = ");" + NL + "\t\t\t    if(obj";
  protected final String TEXT_58 = "_";
  protected final String TEXT_59 = " instanceof String || obj";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = " instanceof Number){" + NL + "\t\t\t    \tresultIsNode_";
  protected final String TEXT_62 = " = false;" + NL + "    \t\t\t\tstr_";
  protected final String TEXT_63 = " = String.valueOf(obj";
  protected final String TEXT_64 = "_";
  protected final String TEXT_65 = ");" + NL + "   \t\t\t\t}else{" + NL + "   \t\t\t\t\tresultIsNode_";
  protected final String TEXT_66 = " = true;" + NL + "\t\t\t\t    node_";
  protected final String TEXT_67 = " = xTmp";
  protected final String TEXT_68 = "_";
  protected final String TEXT_69 = ".selectSingleNode(temp_";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = NL + "\t\t\t\t\tstr_";
  protected final String TEXT_72 = " = node_";
  protected final String TEXT_73 = "==null?null:node_";
  protected final String TEXT_74 = ".asXML();";
  protected final String TEXT_75 = NL + "\t\t\t\t    str_";
  protected final String TEXT_76 = " = xTmp";
  protected final String TEXT_77 = "_";
  protected final String TEXT_78 = ".valueOf(temp_";
  protected final String TEXT_79 = ");";
  protected final String TEXT_80 = NL + "\t\t\t\t}";
  protected final String TEXT_81 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = " = str_";
  protected final String TEXT_84 = ";";
  protected final String TEXT_85 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = " = ParserUtils.parseTo_Document(str_";
  protected final String TEXT_88 = ");";
  protected final String TEXT_89 = NL + "\t\t\t\t\t\t\t\t\tif(resultIsNode_";
  protected final String TEXT_90 = " && xml_api_";
  protected final String TEXT_91 = ".isDefNull(node_";
  protected final String TEXT_92 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_93 = ".";
  protected final String TEXT_94 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t}else if(resultIsNode_";
  protected final String TEXT_95 = " && xml_api_";
  protected final String TEXT_96 = ".isEmpty(node_";
  protected final String TEXT_97 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(resultIsNode_";
  protected final String TEXT_100 = " && xml_api_";
  protected final String TEXT_101 = ".isMissing(node_";
  protected final String TEXT_102 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = " =";
  protected final String TEXT_105 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_106 = NL + "\t\t\t\t\t\t\t\t\tif(resultIsNode_";
  protected final String TEXT_107 = " && xml_api_";
  protected final String TEXT_108 = ".isEmpty(node_";
  protected final String TEXT_109 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(resultIsNode_";
  protected final String TEXT_112 = " && xml_api_";
  protected final String TEXT_113 = ".isMissing(node_";
  protected final String TEXT_114 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_115 = ".";
  protected final String TEXT_116 = " =";
  protected final String TEXT_117 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_118 = "\t" + NL + "\t\t\t\t\t\t\t\t\t\tif(resultIsNode_";
  protected final String TEXT_119 = " && xml_api_";
  protected final String TEXT_120 = ".isDefNull(node_";
  protected final String TEXT_121 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t\t}else if(resultIsNode_";
  protected final String TEXT_124 = " && (xml_api_";
  protected final String TEXT_125 = ".isEmpty(node_";
  protected final String TEXT_126 = ") || xml_api_";
  protected final String TEXT_127 = ".isMissing(node_";
  protected final String TEXT_128 = "))){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_129 = ".";
  protected final String TEXT_130 = "=";
  protected final String TEXT_131 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_132 = NL + "\t\t\t\t\t\t\t\t\t\tif(resultIsNode_";
  protected final String TEXT_133 = " && (xml_api_";
  protected final String TEXT_134 = ".isMissing(node_";
  protected final String TEXT_135 = ") || xml_api_";
  protected final String TEXT_136 = ".isEmpty(node_";
  protected final String TEXT_137 = "))){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " =";
  protected final String TEXT_140 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_141 = NL + "\t\t\t\t";
  protected final String TEXT_142 = ".";
  protected final String TEXT_143 = " = str_";
  protected final String TEXT_144 = ";";
  protected final String TEXT_145 = NL + "\t\t\t\t";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_148 = ", ";
  protected final String TEXT_149 = ");";
  protected final String TEXT_150 = NL + "\t\t\t\t";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = " = ParserUtils.parseTo_";
  protected final String TEXT_153 = "(str_";
  protected final String TEXT_154 = ");";
  protected final String TEXT_155 = NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_156 = NL + "\t\t\t}";
  protected final String TEXT_157 = NL + "\t\t\t}";
  protected final String TEXT_158 = NL + "\t\t\tpublic void putRejectValueBeforeExtract_";
  protected final String TEXT_159 = "(";
  protected final String TEXT_160 = "Struct ";
  protected final String TEXT_161 = ",";
  protected final String TEXT_162 = "Struct ";
  protected final String TEXT_163 = "){";
  protected final String TEXT_164 = NL + "    \t\t\t";
  protected final String TEXT_165 = ".";
  protected final String TEXT_166 = " = ";
  protected final String TEXT_167 = ".";
  protected final String TEXT_168 = ";";
  protected final String TEXT_169 = NL + "\t\t\t}";
  protected final String TEXT_170 = NL + "\t\t\t}";
  protected final String TEXT_171 = NL + "\t\t\tpublic void putRejectValueAfterExtract_";
  protected final String TEXT_172 = "(";
  protected final String TEXT_173 = "Struct ";
  protected final String TEXT_174 = ",";
  protected final String TEXT_175 = "Struct ";
  protected final String TEXT_176 = "){";
  protected final String TEXT_177 = NL + "     \t\t\t";
  protected final String TEXT_178 = ".";
  protected final String TEXT_179 = " = ";
  protected final String TEXT_180 = ".";
  protected final String TEXT_181 = ";";
  protected final String TEXT_182 = NL + "\t\t\t}";
  protected final String TEXT_183 = NL + "\t\t\t}";
  protected final String TEXT_184 = NL + "}" + NL + "" + NL + "XML_API_";
  protected final String TEXT_185 = " xml_api_";
  protected final String TEXT_186 = " = new XML_API_";
  protected final String TEXT_187 = "();";
  protected final String TEXT_188 = NL + "\tclass XML_NS_RMV_";
  protected final String TEXT_189 = "{\t" + NL + "" + NL + "\t\tpublic void removeNamespace(org.dom4j.Document reader," + NL + "\t\t\t\torg.dom4j.Document writer) {" + NL + "\t\t\torg.dom4j.Element elemReader = reader.getRootElement();" + NL + "\t\t\torg.dom4j.Element elemTo = writer.addElement(elemReader" + NL + "\t\t\t\t\t.getName());" + NL + "\t\t\tif(elemReader!=null && elemReader.getText()!=null && !\"\".equals(elemReader.getText())){" + NL + "\t\t\t\telemTo.setText(elemReader.getText());" + NL + "\t\t\t}" + NL + "\t\t\tfor (org.dom4j.Attribute attri : (List<org.dom4j.Attribute>) elemReader" + NL + "\t\t\t\t\t.attributes()) {" + NL + "\t\t\t\telemTo.addAttribute(attri.getName(),attri.getText());" + NL + "\t\t\t}" + NL + "\t\t\tremoveSubNamespace(elemReader, elemTo);" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void removeSubNamespace(org.dom4j.Element elemFrom," + NL + "\t\t\t\torg.dom4j.Element elemTo) {" + NL + "\t\t\tfor (org.dom4j.Element subFrom : (List<org.dom4j.Element>) elemFrom" + NL + "\t\t\t\t\t.elements()) {" + NL + "\t\t\t\torg.dom4j.Element tmpElemTo = elemTo.addElement(subFrom" + NL + "\t\t\t\t\t\t.getName());" + NL + "\t\t\t\tif(subFrom!=null && subFrom.getText()!=null && !\"\".equals(subFrom.getText())){" + NL + "\t\t\t\t\ttmpElemTo.setText(subFrom.getText());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tfor (org.dom4j.Attribute attri : (List<org.dom4j.Attribute>) subFrom" + NL + "\t\t\t\t\t\t.attributes()) {" + NL + "\t\t\t\t\ttmpElemTo.addAttribute(attri.getName(),attri.getText());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tremoveSubNamespace(subFrom, tmpElemTo);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\tXML_NS_RMV_";
  protected final String TEXT_190 = " XML_ns_rmv_";
  protected final String TEXT_191 = " = new XML_NS_RMV_";
  protected final String TEXT_192 = "();" + NL + "\torg.jaxen.NamespaceContext namespaceContext_";
  protected final String TEXT_193 = " = new org.jaxen.NamespaceContext() {" + NL + "\t\tpublic String translateNamespacePrefixToUri(String prefix) { " + NL + "\t\t\treturn \"\";//ignore prefix in xpath when evaluate" + NL + "\t\t}" + NL + "\t};";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
	int schemaOptNum=100;
	String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
	if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
		schemaOptNum  = Integer.parseInt(schemaOptNumStr);
	}
	String xmlField = ElementParameterParser.getValue(node, "__XMLFIELD__");

	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
	boolean ignore_NS_Str = ("true").equals(ElementParameterParser.getValue(node, "__IGNORE_NS__"));
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

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
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

    stringBuffer.append(TEXT_6);
    stringBuffer.append(unExtractColNo/schemaOptNum);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(outConn));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_11);
    
								}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_16);
    
								if((unExtractColNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_17);
    
								}
								unExtractColNo++;
								break;
							}
						}
					}
				}
			}
			if(unExtractColNo>0&&(unExtractColNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_18);
    
			}
		}
		int extractColNo=0;
		for (int i=0;i<mapping.size();i++) {  //for S_0
			String query = mapping.get(i).get("QUERY");
			String nodeCheck = mapping.get(i).get("NODECHECK");
			if(query!=null && query.trim().length()>0){  // if S_0_0
				if(extractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_19);
    stringBuffer.append(extractColNo/schemaOptNum);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(outConn));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_22);
    if(inConn!=null){
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    if(ignore_NS_Str){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
				}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    if(ignore_NS_Str){
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
					if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    
					}else{

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    
					}

    stringBuffer.append(TEXT_80);
    
				for(IMetadataColumn column:outConn.getMetadataTable().getListColumns()) { // for S_0_0_0
					if (mapping.get(i).get("SCHEMA_COLUMN")!=null) { // if S_0_0_0_0
						if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) { //if S_0_0_0_0_0
	        				
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
							
							if(("true").equals(nodeCheck)){
								if(!("id_Document".equals(column.getTalendType()))) { 

    stringBuffer.append(TEXT_81);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    
								} else {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    
								}
	            				continue;
	            			}
							if(javaType == JavaTypesManager.STRING){
								if(column.isNullable()){

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_105);
    
								}else{ // column.isNullable()

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_117);
    
								}
							}else{ // other type
								if(column.isNullable()){

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_131);
    
								}else{ // column.isNullable()

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_140);
    
								}
							}
									
							if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_144);
    
							} else {
								if (javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_145);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_149);
    
								} else {

    stringBuffer.append(TEXT_150);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_153);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_154);
    
								}
							}

    stringBuffer.append(TEXT_155);
    
							break;
	        			} // if S_0_0_0_0_1
					} // if S_0_0_0_1
				} // for S_0_0_1
				if((extractColNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_156);
    
				}
				extractColNo++;
			}// if S_0_1
		} // for S_1
		if(extractColNo >0&&(extractColNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_157);
    
		}
		if(!dieOnError && !("").equals(rejectConnName) && rejectColumnList != null && rejectColumnList.size() > 0) {//reject before extract
			if(inConn!=null){
				int columnNo=0;
		 		for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
	    	  		if(!xmlField.equals(column.getLabel())){
	    	  			for(IMetadataColumn inColumn : inConn.getMetadataTable().getListColumns()){
	    	  				if(inColumn.getLabel().equals(column.getLabel())){
	    	  					if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_158);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_163);
    
		 						}

    stringBuffer.append(TEXT_164);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_168);
    
	    						if((columnNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_169);
    
								}
								columnNo++;
								break;
	    					}
	    				}
	    			}
	    	    }
				if(columnNo>0&&(columnNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_170);
    
				}
	    	}
		}//reject before extract
		
		if(!dieOnError && !("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//reject extract
	    	int columnNo=0;
    	 	for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
    	 		if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_171);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_176);
    
		 		}

    stringBuffer.append(TEXT_177);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_181);
    
				if((columnNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_182);
    
				}
				columnNo++;
    	    }
			if(columnNo>0&&(columnNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_183);
    
			}
		}//reject extract
		
	}//whether to optimize
}

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    
	if(ignore_NS_Str){

    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    
	}

    return stringBuffer.toString();
  }
}
