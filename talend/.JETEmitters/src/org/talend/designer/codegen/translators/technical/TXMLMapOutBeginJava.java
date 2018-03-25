package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.designer.xmlmap.generation.GenerationManagerFactory;
import org.talend.designer.xmlmap.generation.GenerationManager;
import org.talend.designer.xmlmap.XmlMapComponent;
import org.talend.designer.xmlmap.model.emf.xmlmap.XmlMapData;
import org.eclipse.emf.common.util.EList;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.xmlmap.model.emf.xmlmap.VarNode;
import org.talend.designer.xmlmap.model.emf.xmlmap.VarTable;
import org.talend.designer.xmlmap.model.emf.xmlmap.InputXmlTree;
import org.talend.designer.xmlmap.model.emf.xmlmap.OutputXmlTree;
import org.talend.designer.xmlmap.model.emf.xmlmap.TreeNode;
import org.talend.designer.xmlmap.model.emf.xmlmap.AbstractNode;
import org.talend.designer.xmlmap.model.emf.xmlmap.OutputTreeNode;
import org.talend.designer.xmlmap.model.emf.xmlmap.NodeType;
import org.talend.designer.xmlmap.model.emf.xmlmap.InputLoopNodesTable;
import org.talend.designer.xmlmap.model.emf.xmlmap.LookupConnection;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * add by wliu
 */
public class TXMLMapOutBeginJava {

  protected static String nl;
  public static synchronized TXMLMapOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TXMLMapOutBeginJava result = new TXMLMapOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\torg.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_2 = "LookupManager<";
  protected final String TEXT_3 = "Struct> tHash_Lookup_";
  protected final String TEXT_4 = " = " + NL + "\t\t(org.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_5 = "LookupManager<";
  protected final String TEXT_6 = "Struct>) " + NL + "\t\t\t((org.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_7 = "LookupManager<";
  protected final String TEXT_8 = "Struct>) " + NL + "\t\t\t\t globalMap.get( \"tHash_Lookup_";
  protected final String TEXT_9 = "\" ))" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t.clone()" + NL + "\t\t\t\t";
  protected final String TEXT_11 = ";" + NL + "\t";
  protected final String TEXT_12 = NL + "\torg.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_13 = "Struct> tHash_Lookup_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "null;";
  protected final String TEXT_16 = "(org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_17 = "Struct>) " + NL + "\t\t\t((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_18 = "Struct>) " + NL + "\t\t\t\tglobalMap.get( \"tHash_Lookup_";
  protected final String TEXT_19 = "\" ))" + NL + "\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t.clone()" + NL + "\t\t\t\t";
  protected final String TEXT_21 = ";" + NL + "\t";
  protected final String TEXT_22 = NL + "\t";
  protected final String TEXT_23 = NL + "\t" + NL + "\troutines.system.DocumentLookupCache tHash_Lookup_Cache_";
  protected final String TEXT_24 = " = new routines.system.DocumentLookupCache(\"";
  protected final String TEXT_25 = "\");" + NL + "\t";
  protected final String TEXT_26 = NL + "\t\ttHash_Lookup_";
  protected final String TEXT_27 = ".initGet();" + NL + "\t";
  protected final String TEXT_28 = NL + "\t";
  protected final String TEXT_29 = " ";
  protected final String TEXT_30 = "HashKey = new ";
  protected final String TEXT_31 = "();" + NL + "\t";
  protected final String TEXT_32 = " ";
  protected final String TEXT_33 = "Default = new ";
  protected final String TEXT_34 = "();" + NL + "\t";
  protected final String TEXT_35 = " ";
  protected final String TEXT_36 = " = new ";
  protected final String TEXT_37 = "();" + NL + "\t";
  protected final String TEXT_38 = NL + "\t" + NL + "\t";
  protected final String TEXT_39 = NL + "//===============================input xml init part===============================" + NL + "class XML_API_";
  protected final String TEXT_40 = "{" + NL + "\tpublic boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node instanceof org.dom4j.Element) {" + NL + "        \torg.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "        \tif(attri != null && (\"true\").equals(attri.getText())){" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getText().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "}";
  protected final String TEXT_41 = NL + "class TreeNode_API_";
  protected final String TEXT_42 = " {" + NL + "\tjava.util.Map<String, String> xpath_value_map = new java.util.HashMap<String, String>();" + NL + "\t" + NL + "\tvoid clear(){" + NL + "\t\txpath_value_map.clear();" + NL + "\t}" + NL + "\t" + NL + "\tvoid put(String xpath, String value){" + NL + "\t\txpath_value_map.put(xpath, value);" + NL + "\t}" + NL + "\tString get_null(String xpath) {" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_43 = NL + "}";
  protected final String TEXT_44 = NL + "\tString get_String(String xpath){" + NL + "\t\treturn xpath_value_map.get(xpath);" + NL + "\t}";
  protected final String TEXT_45 = NL + "\tjava.util.Date get_Date(String xpath, String pattern){" + NL + "\t\tString content = xpath_value_map.get(xpath);" + NL + "\t\tif(content==null || content.length()==0) return null;" + NL + "\t\treturn ParserUtils.parseTo_Date(content, pattern);" + NL + "\t}";
  protected final String TEXT_46 = NL + "\tbyte[] get_Bytes(String xpath){" + NL + "\t\tString content = xpath_value_map.get(xpath);" + NL + "\t\tif(content==null || content.length()==0) return null;" + NL + "\t\treturn content.getBytes();" + NL + "\t}";
  protected final String TEXT_47 = NL + "\t";
  protected final String TEXT_48 = " get_";
  protected final String TEXT_49 = "(String xpath){" + NL + "\t\tString content = xpath_value_map.get(xpath);" + NL + "\t\tif(content==null || content.length()==0) return ";
  protected final String TEXT_50 = ";" + NL + "\t\treturn ParserUtils.parseTo_";
  protected final String TEXT_51 = "(content);" + NL + "\t}";
  protected final String TEXT_52 = NL + "\tclass ";
  protected final String TEXT_53 = " {";
  protected final String TEXT_54 = "\t";
  protected final String TEXT_55 = " ";
  protected final String TEXT_56 = ";";
  protected final String TEXT_57 = NL + "\t}" + NL + "\t";
  protected final String TEXT_58 = " ";
  protected final String TEXT_59 = " = new ";
  protected final String TEXT_60 = "();";
  protected final String TEXT_61 = NL + "// ###############################" + NL + "// # Outputs initialization";
  protected final String TEXT_62 = NL;
  protected final String TEXT_63 = " ";
  protected final String TEXT_64 = "_tmp = new ";
  protected final String TEXT_65 = "();";
  protected final String TEXT_66 = NL;
  protected final String TEXT_67 = " ";
  protected final String TEXT_68 = "_save = null;" + NL + "//the aggregate variable";
  protected final String TEXT_69 = NL;
  protected final String TEXT_70 = " ";
  protected final String TEXT_71 = "_aggregate = null;";
  protected final String TEXT_72 = NL + "int count_";
  protected final String TEXT_73 = "_";
  protected final String TEXT_74 = " = 0;";
  protected final String TEXT_75 = NL + "//init the resultset for aggregate" + NL + "java.util.List<Object> allOutsForAggregate_";
  protected final String TEXT_76 = " = new java.util.ArrayList<Object>();" + NL + "globalMap.put(\"allOutsForAggregate_";
  protected final String TEXT_77 = "\",allOutsForAggregate_";
  protected final String TEXT_78 = ");" + NL + "// ###############################";
  protected final String TEXT_79 = NL + "\t\t\tTreeNode_API_";
  protected final String TEXT_80 = " treeNodeAPI_";
  protected final String TEXT_81 = " = new TreeNode_API_";
  protected final String TEXT_82 = "();" + NL + "\t\t\tNameSpaceTool nsTool_";
  protected final String TEXT_83 = " = new NameSpaceTool();";
  protected final String TEXT_84 = NL + "\t\tint nb_line_";
  protected final String TEXT_85 = " = 0; ";
  protected final String TEXT_86 = NL + "\t" + NL + "    XML_API_";
  protected final String TEXT_87 = " xml_api_";
  protected final String TEXT_88 = " = new XML_API_";
  protected final String TEXT_89 = "();" + NL;
  protected final String TEXT_90 = NL + "\t\t\t\t\t";
  protected final String TEXT_91 = " = ";
  protected final String TEXT_92 = ";";
  protected final String TEXT_93 = NL + "valueMap.put(\"";
  protected final String TEXT_94 = "\",";
  protected final String TEXT_95 = ");" + NL + "if(valueMap.get(\"";
  protected final String TEXT_96 = "\")!=null) {//open if 8080";
  protected final String TEXT_97 = NL;
  protected final String TEXT_98 = ".addNamespace(\"";
  protected final String TEXT_99 = "\", TalendString.replaceSpecialCharForXML(FormatterUtils.format(";
  protected final String TEXT_100 = ",";
  protected final String TEXT_101 = ")));";
  protected final String TEXT_102 = NL;
  protected final String TEXT_103 = ".addNamespace(\"";
  protected final String TEXT_104 = "\", TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_105 = "\"));";
  protected final String TEXT_106 = NL + "        \troutines.system.DocumentHelper.applyNamespace1(";
  protected final String TEXT_107 = ",\"\",FormatterUtils.format(";
  protected final String TEXT_108 = ",";
  protected final String TEXT_109 = "));" + NL + "}//close if 8080";
  protected final String TEXT_110 = NL + "        \troutines.system.DocumentHelper.applyNamespace1(";
  protected final String TEXT_111 = ",\"\",\"";
  protected final String TEXT_112 = "\");";
  protected final String TEXT_113 = NL + "        \troutines.system.DocumentHelper.applyNamespace2(";
  protected final String TEXT_114 = ",\"";
  protected final String TEXT_115 = "\",\"";
  protected final String TEXT_116 = "\",FormatterUtils.format(";
  protected final String TEXT_117 = ",";
  protected final String TEXT_118 = "));" + NL + "}//close if 8080";
  protected final String TEXT_119 = NL + "        \troutines.system.DocumentHelper.applyNamespace2(";
  protected final String TEXT_120 = ",\"";
  protected final String TEXT_121 = "\",\"";
  protected final String TEXT_122 = "\",\"";
  protected final String TEXT_123 = "\");";
  protected final String TEXT_124 = NL + "\t\t\t";
  protected final String TEXT_125 = "_";
  protected final String TEXT_126 = " = ";
  protected final String TEXT_127 = ".elements(\"";
  protected final String TEXT_128 = "\");";
  protected final String TEXT_129 = NL + "\t\t\t";
  protected final String TEXT_130 = "_";
  protected final String TEXT_131 = " = ";
  protected final String TEXT_132 = ".elements(" + NL + "\t\t\t\torg.dom4j.DocumentHelper.createQName(" + NL + "\t\t\t\t\t\"";
  protected final String TEXT_133 = "\"," + NL + "\t        \t\torg.dom4j.DocumentHelper.createNamespace(" + NL + "\t        \t\t\t\"";
  protected final String TEXT_134 = "\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_135 = "\")" + NL + "\t        \t\t)" + NL + "\t        \t)" + NL + "        \t);";
  protected final String TEXT_136 = NL + "\t\t\tnamespace_";
  protected final String TEXT_137 = " = ";
  protected final String TEXT_138 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_139 = "\");" + NL + "\t\t\t";
  protected final String TEXT_140 = "_";
  protected final String TEXT_141 = " = namespace_";
  protected final String TEXT_142 = "!=null ? ";
  protected final String TEXT_143 = ".elements(org.dom4j.DocumentHelper.createQName(\"";
  protected final String TEXT_144 = "\",namespace_";
  protected final String TEXT_145 = ")) : ";
  protected final String TEXT_146 = ".elements(\"";
  protected final String TEXT_147 = "\"); ";
  protected final String TEXT_148 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_149 = " = null;";
  protected final String TEXT_150 = NL + "\t\t        ";
  protected final String TEXT_151 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_152 = "\");" + NL + "\t\t\t\tif (";
  protected final String TEXT_153 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_154 = "\") != null) {" + NL + "\t\t        \t";
  protected final String TEXT_155 = ".setQName(org.dom4j.DocumentHelper.createQName(\"";
  protected final String TEXT_156 = "\", ";
  protected final String TEXT_157 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_158 = "\")));" + NL + "\t\t        }";
  protected final String TEXT_159 = NL + "\t\t\t\t";
  protected final String TEXT_160 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_161 = "\");";
  protected final String TEXT_162 = NL + "\t\t\t\t";
  protected final String TEXT_163 = ".add(";
  protected final String TEXT_164 = ");";
  protected final String TEXT_165 = NL + "\t\t\t\t\t";
  protected final String TEXT_166 = ".elements().add(";
  protected final String TEXT_167 = ");";
  protected final String TEXT_168 = NL + "\t\t\t\t\tList allElements_";
  protected final String TEXT_169 = " = ";
  protected final String TEXT_170 = ".elements();" + NL + "\t\t\t\t\tif(allElements_";
  protected final String TEXT_171 = ".isEmpty()) {//when the group or loop element appear first time" + NL + "\t\t\t\t\t\tallElements_";
  protected final String TEXT_172 = ".add(";
  protected final String TEXT_173 = ");" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\torg.dom4j.Namespace namespace_";
  protected final String TEXT_174 = " = null;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_175 = NL + "\t\t\t\t\t\tint size_";
  protected final String TEXT_176 = " = currentElementList_";
  protected final String TEXT_177 = ".size();" + NL + "\t\t\t\t\t\tif(size_";
  protected final String TEXT_178 = " > 0){" + NL + "\t\t\t\t\t\t\tallElements_";
  protected final String TEXT_179 = ".add(allElements_";
  protected final String TEXT_180 = ".indexOf(currentElementList_";
  protected final String TEXT_181 = ".get(size_";
  protected final String TEXT_182 = "-1)) + 1, ";
  protected final String TEXT_183 = ");" + NL + "\t\t\t\t\t\t} else {//when the group or loop element appear first time" + NL + "\t\t\t\t\t\t\tint location_";
  protected final String TEXT_184 = " = allElements_";
  protected final String TEXT_185 = ".size();";
  protected final String TEXT_186 = NL + "\t\t\t\t\t\t\t\tboolean findInsertPosition_";
  protected final String TEXT_187 = " = false;" + NL + "\t\t\t\t\t\t\t\tList siblingList_";
  protected final String TEXT_188 = " = null;";
  protected final String TEXT_189 = NL + "\t\t\t\t\t\t\t\tif(!findInsertPosition_";
  protected final String TEXT_190 = ") {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_191 = NL + "\t\t\t\t\t\t\t\t\tif(siblingList_";
  protected final String TEXT_192 = ".size() > 0) {" + NL + "\t\t\t\t\t\t\t\t\t\tfindInsertPosition_";
  protected final String TEXT_193 = " = true;" + NL + "\t\t\t\t\t\t\t\t\t\tlocation_";
  protected final String TEXT_194 = " = allElements_";
  protected final String TEXT_195 = ".indexOf(siblingList_";
  protected final String TEXT_196 = ".get(0));" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t}";
  protected final String TEXT_197 = NL + "\t\t\t\t\t\t\tallElements_";
  protected final String TEXT_198 = ".add(location_";
  protected final String TEXT_199 = ",";
  protected final String TEXT_200 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}\t";
  protected final String TEXT_201 = NL + "\t\t\t\t";
  protected final String TEXT_202 = ".elements().add(orderHelper.getInsertLocation(";
  protected final String TEXT_203 = ",";
  protected final String TEXT_204 = "),";
  protected final String TEXT_205 = ");";
  protected final String TEXT_206 = NL + "\t\t\t\tif (";
  protected final String TEXT_207 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_208 = "\") == null) {" + NL + "\t\t            ";
  protected final String TEXT_209 = " = ";
  protected final String TEXT_210 = ".addElement(\"";
  protected final String TEXT_211 = "\");" + NL + "\t\t        } else {" + NL + "\t\t        \t";
  protected final String TEXT_212 = " = ";
  protected final String TEXT_213 = ".addElement(\"";
  protected final String TEXT_214 = "\");" + NL + "\t\t        }";
  protected final String TEXT_215 = NL + "\t\t\t\t";
  protected final String TEXT_216 = " = ";
  protected final String TEXT_217 = ".addElement(\"";
  protected final String TEXT_218 = "\");";
  protected final String TEXT_219 = NL + "\t\tsubTreeRootParent = ";
  protected final String TEXT_220 = ";";
  protected final String TEXT_221 = NL + "\t\t\t\tcurrentValue = null;";
  protected final String TEXT_222 = NL + "    \t\t\tvalueMap.put(\"";
  protected final String TEXT_223 = "\",";
  protected final String TEXT_224 = ");" + NL + "    \t\t\tif(valueMap.get(\"";
  protected final String TEXT_225 = "\")!=null) {" + NL + "    \t\t\t\tcurrentValue = FormatterUtils.format(";
  protected final String TEXT_226 = ",";
  protected final String TEXT_227 = ");" + NL + "    \t\t\t}";
  protected final String TEXT_228 = " else {" + NL + "    \t\t\t\tcurrentValue = \"\";" + NL + "    \t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_229 = NL + "\t\t\t\tcurrentValue = \"\";";
  protected final String TEXT_230 = NL + "    \t\t\troutines.system.DocumentHelper.applyNamespace2Attribute(";
  protected final String TEXT_231 = ", ";
  protected final String TEXT_232 = " \"";
  protected final String TEXT_233 = "\" ";
  protected final String TEXT_234 = " null ";
  protected final String TEXT_235 = ", \"";
  protected final String TEXT_236 = "\", currentValue);";
  protected final String TEXT_237 = NL + "\t\tvalueMap.put(\"";
  protected final String TEXT_238 = "\",";
  protected final String TEXT_239 = ");" + NL + "\t\tif(valueMap.get(\"";
  protected final String TEXT_240 = "\")!=null) {" + NL + "\t\t\troutines.system.NestXMLTool.setText(";
  protected final String TEXT_241 = ", FormatterUtils.format(";
  protected final String TEXT_242 = ",";
  protected final String TEXT_243 = "));" + NL + "\t\t}";
  protected final String TEXT_244 = NL + "\t\t\tisNewElement = false;";
  protected final String TEXT_245 = NL + "\t\t\t\t\tif(isNewElement || groupbyList.size()<=";
  protected final String TEXT_246 = " || groupbyList.get(";
  protected final String TEXT_247 = ")==null";
  protected final String TEXT_248 = NL + "\t\t\t\t\t|| ( groupbyList.get(";
  protected final String TEXT_249 = ").get(";
  protected final String TEXT_250 = ")!=null ? !groupbyList.get(";
  protected final String TEXT_251 = ").get(";
  protected final String TEXT_252 = ").equals(FormatterUtils.format(";
  protected final String TEXT_253 = ",";
  protected final String TEXT_254 = ")) : FormatterUtils.format(";
  protected final String TEXT_255 = ",";
  protected final String TEXT_256 = ")!=null )";
  protected final String TEXT_257 = NL + "\t\t\t\t\t){" + NL;
  protected final String TEXT_258 = "\t" + NL + "\t\t\t\t\tif(groupbyList.size()<=";
  protected final String TEXT_259 = "){" + NL + "\t\t\t\t\t\tgroupbyList.add(new java.util.ArrayList<String>());" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tgroupbyList.get(";
  protected final String TEXT_260 = ").clear();" + NL + "\t\t\t\t\t}";
  protected final String TEXT_261 = NL + "\t\t\t\t\t\tgroupbyList.get(";
  protected final String TEXT_262 = ").add(FormatterUtils.format(";
  protected final String TEXT_263 = ",";
  protected final String TEXT_264 = "));";
  protected final String TEXT_265 = NL + "\t\t\t\t\tisNewElement=true;" + NL + "\t\t\t\t\tif(groupElementList.size()<=";
  protected final String TEXT_266 = "){" + NL + "\t\t\t\t\t\tgroupElementList.add(group";
  protected final String TEXT_267 = "_);" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tgroupElementList.set(";
  protected final String TEXT_268 = ",group";
  protected final String TEXT_269 = "_);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tsubTreeRootParent=groupElementList.get(";
  protected final String TEXT_270 = ");" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_271 = NL + "\t//the map store the previous value of aggregate columns" + NL + "\tjava.util.Map<String,Object> aggregateCacheMap_";
  protected final String TEXT_272 = " = new java.util.HashMap<String,Object>();";
  protected final String TEXT_273 = NL + "\t\t\t\t\t//init the map,the keys is aggregate columns xpath,the values is all null." + NL + "\t\t\t\t\taggregateCacheMap_";
  protected final String TEXT_274 = ".put(\"";
  protected final String TEXT_275 = "\",null);";
  protected final String TEXT_276 = NL + NL + "class GenerateDocument_";
  protected final String TEXT_277 = " {" + NL;
  protected final String TEXT_278 = NL + "\t\tTreeNode_API_";
  protected final String TEXT_279 = " treeNodeAPI = null;";
  protected final String TEXT_280 = NL + "\tjava.util.Map<String,Object> valueMap = null;" + NL + "\t" + NL + "\troutines.system.DocumentGenerateOrderHelper orderHelper = new routines.system.DocumentGenerateOrderHelper(";
  protected final String TEXT_281 = ");" + NL + "\t" + NL + "\torg.dom4j.Document doc = null;" + NL + "\t" + NL + "\torg.dom4j.Element root4Group = null;" + NL + "\t" + NL + "\torg.dom4j.io.OutputFormat format = null;" + NL + "\t" + NL + "\tjava.util.List<java.util.List<String>> groupbyList = null;" + NL + "\tjava.util.List<org.dom4j.Element> groupElementList = null;" + NL + "\tint order = 0;" + NL + "\t" + NL + "\tboolean isFirst = true;" + NL + "\t" + NL + "\tboolean\tneedRoot = true;" + NL + "\t" + NL + "\tString currentValue = null;";
  protected final String TEXT_282 = NL;
  protected final String TEXT_283 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_284 = " = null;" + NL + "\t\tpublic boolean  ";
  protected final String TEXT_285 = " = false;";
  protected final String TEXT_286 = NL + "\t" + NL + "    public GenerateDocument_";
  protected final String TEXT_287 = "() {" + NL + "//    \tthis.treeNodeAPI = treeNodeAPI;" + NL + "    \t" + NL + "    \tvalueMap = new java.util.HashMap<String,Object>();" + NL + "    \t" + NL + "    \tgroupbyList =  new java.util.ArrayList<java.util.List<String>>();" + NL + "\t\tgroupElementList = new java.util.ArrayList<org.dom4j.Element>();" + NL + "    \t" + NL + "    \tdoc = org.dom4j.DocumentHelper.createDocument();" + NL + "    \tformat = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "    \tformat.setTrimText(false);" + NL + "    }" + NL + "    " + NL + "    public org.dom4j.Document getDocument(){" + NL + "    \treturn this.doc;" + NL + "    }" + NL + "    " + NL + "\t//We generate the TreeNode_API object only if there is a document in the main input table." + NL + "    void generateElements(";
  protected final String TEXT_288 = "TreeNode_API_";
  protected final String TEXT_289 = " treeNodeAPI,";
  protected final String TEXT_290 = "boolean isInnerJoin";
  protected final String TEXT_291 = ", ";
  protected final String TEXT_292 = " ";
  protected final String TEXT_293 = NL + "\t";
  protected final String TEXT_294 = ") {" + NL + "\t" + NL + "\t" + NL + "\t/*if(this.treeNodeAPI==null) {" + NL + "\t\tthis.treeNodeAPI = treeNodeAPI;" + NL + "\t}*/" + NL + "\t" + NL + "\torg.dom4j.Element subTreeRootParent = null;" + NL + "// build root xml tree " + NL + "if (needRoot) {" + NL + "\tneedRoot=false;";
  protected final String TEXT_295 = NL + "\t\troot4Group = subTreeRootParent;" + NL + "\t}else{" + NL + "\t\tsubTreeRootParent=root4Group;" + NL + "\t}" + NL + "\t/* build group xml tree */" + NL + "\tboolean isNewElement = false;";
  protected final String TEXT_296 = NL + "\t\tisNewElement = false;";
  protected final String TEXT_297 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_298 = ") {";
  protected final String TEXT_299 = NL + "\t\t\t\t\t\t}";
  protected final String TEXT_300 = NL + "\t\t}" + NL + "    }" + NL + "" + NL + "\tGenerateDocument_";
  protected final String TEXT_301 = " gen_Doc_";
  protected final String TEXT_302 = "_";
  protected final String TEXT_303 = " = new GenerateDocument_";
  protected final String TEXT_304 = "();" + NL + "\tboolean docAlreadyInstanciate_";
  protected final String TEXT_305 = " = false;";
  protected final String TEXT_306 = NL;
  protected final String TEXT_307 = NL + "\t            class SortableRow_";
  protected final String TEXT_308 = " implements Comparable<SortableRow_";
  protected final String TEXT_309 = ">, routines.system.IPersistableRow<SortableRow_";
  protected final String TEXT_310 = "> { // G_TM_B_001 " + NL + "\t" + NL + "\t\t\t\t\tboolean is__rejectedInnerJoin;" + NL + "\t\t\t\t\t";
  protected final String TEXT_311 = " exprKey_";
  protected final String TEXT_312 = "__";
  protected final String TEXT_313 = ";" + NL + "\t\t\t                    \t";
  protected final String TEXT_314 = NL + "\t\t\t\t//";
  protected final String TEXT_315 = NL + "\t\t\t\t";
  protected final String TEXT_316 = " ";
  protected final String TEXT_317 = "__";
  protected final String TEXT_318 = ";" + NL + "\t\t\t                    ";
  protected final String TEXT_319 = NL + "\t\t\t        public void fillFrom(";
  protected final String TEXT_320 = " ";
  protected final String TEXT_321 = "Struct ";
  protected final String TEXT_322 = " ";
  protected final String TEXT_323 = " exprKey_";
  protected final String TEXT_324 = "__";
  protected final String TEXT_325 = ") {" + NL + "\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_326 = "this.";
  protected final String TEXT_327 = "__";
  protected final String TEXT_328 = " = ";
  protected final String TEXT_329 = ".";
  protected final String TEXT_330 = ";" + NL + "\t\t\t            \t\t";
  protected final String TEXT_331 = NL + "\t\t\t            ";
  protected final String TEXT_332 = "this.exprKey_";
  protected final String TEXT_333 = "__";
  protected final String TEXT_334 = " = exprKey_";
  protected final String TEXT_335 = "__";
  protected final String TEXT_336 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_337 = NL + "\t\t\t        }" + NL + "\t\t\t" + NL + "\t\t\t        public void copyDataTo(";
  protected final String TEXT_338 = "Struct ";
  protected final String TEXT_339 = ") {" + NL + "\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_340 = ".";
  protected final String TEXT_341 = " = this.";
  protected final String TEXT_342 = "__";
  protected final String TEXT_343 = ";" + NL + "\t\t\t\t            \t";
  protected final String TEXT_344 = NL + "\t\t\t        }" + NL + "\t\t\t\t\tpublic String toString() {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\tStringBuilder sb = new StringBuilder();" + NL + "\t\t\t\t\t\tsb.append(super.toString());" + NL + "\t\t\t\t\t\tsb.append(\"[\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_345 = NL + "\t\t\t\t\t\t\t\t\t\t\tsb.append(\"";
  protected final String TEXT_346 = "\");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_347 = NL + "\t\t\t\t\t\t\t\t\t\tsb.append(\"";
  protected final String TEXT_348 = "__";
  protected final String TEXT_349 = "\");" + NL + "\t\t\t\t\t\t\t\t\t\tsb.append(\"=\");" + NL + "\t\t\t\t\t\t\t\t\t\tsb.append(String.valueOf(this.";
  protected final String TEXT_350 = "__";
  protected final String TEXT_351 = "));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_352 = NL + "\t\t\t\t\t\tsb.append(\"]\");" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\treturn sb.toString();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t        public int compareTo(SortableRow_";
  protected final String TEXT_353 = " other) {" + NL + "\t\t\t            int returnValue = 0;" + NL + "\t\t\t            ";
  protected final String TEXT_354 = NL + "\t\t\t            \treturnValue = checkNullsAndCompare(this.exprKey_";
  protected final String TEXT_355 = "__";
  protected final String TEXT_356 = ", other.exprKey_";
  protected final String TEXT_357 = "__";
  protected final String TEXT_358 = ");" + NL + "\t\t\t            \tif (returnValue != 0) {" + NL + "\t\t\t                    return returnValue;" + NL + "\t\t\t            \t}" + NL + "\t\t\t            ";
  protected final String TEXT_359 = NL + "\t\t\t            return returnValue;" + NL + "\t\t\t        }" + NL + "\t\t\t" + NL + "\t\t\t        private int checkNullsAndCompare(Object object1, Object object2) {" + NL + "\t\t\t            int returnValue = 0;" + NL + "\t\t\t            if (object1 instanceof Comparable && object2 instanceof Comparable) {" + NL + "\t\t\t                returnValue = ((Comparable) object1).compareTo(object2);" + NL + "\t\t\t            } else if (object1 != null && object2 != null) {" + NL + "\t\t\t                returnValue = compareStrings(object1.toString(), object2" + NL + "\t\t\t                        .toString());" + NL + "\t\t\t            } else if (object1 == null && object2 != null) {" + NL + "\t\t\t                returnValue = 1;" + NL + "\t\t\t            } else if (object1 != null && object2 == null) {" + NL + "\t\t\t                returnValue = -1;" + NL + "\t\t\t            } else {" + NL + "\t\t\t                returnValue = 0;" + NL + "\t\t\t            }" + NL + "\t\t\t            return returnValue;" + NL + "\t\t\t        }" + NL + "\t\t\t" + NL + "\t\t\t        private int compareStrings(String string1, String string2) {" + NL + "\t\t\t            return string1.compareTo(string2);" + NL + "\t\t\t        }" + NL + "\t\t\t" + NL + "\t\t\t\t\tpublic void readData(ObjectInputStream dis) {" + NL + "\t\t\t\t\t\tsynchronized(";
  protected final String TEXT_360 = "Struct.commonByteArrayLock_";
  protected final String TEXT_361 = "_";
  protected final String TEXT_362 = ") {" + NL + "\t\t\t\t\t\t    try {" + NL + "\t\t\t\t\t\t\t\tint length = 0;" + NL + "\t\t\t\t\t\t\t\tthis.is__rejectedInnerJoin = dis.readBoolean();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_363 = NL + "\t\t\t\t            this.";
  protected final String TEXT_364 = "__";
  protected final String TEXT_365 = " = dis.read";
  protected final String TEXT_366 = "();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_367 = NL + "\t\t\t\t            length = dis.readInt();" + NL + "\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t   \t    \t\t\tthis.";
  protected final String TEXT_368 = "__";
  protected final String TEXT_369 = " = null;" + NL + "\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t   \t\t\t\t\tif(length > ";
  protected final String TEXT_370 = "Struct.commonByteArray_";
  protected final String TEXT_371 = "_";
  protected final String TEXT_372 = ".length) {" + NL + "\t\t\t   \t\t\t\t\t\tif(length < 1024 && ";
  protected final String TEXT_373 = "Struct.commonByteArray_";
  protected final String TEXT_374 = "_";
  protected final String TEXT_375 = ".length == 0) {" + NL + "\t\t\t           \t\t\t\t\t";
  protected final String TEXT_376 = "Struct.commonByteArray_";
  protected final String TEXT_377 = "_";
  protected final String TEXT_378 = " = new byte[1024];" + NL + "\t\t\t   \t\t\t\t\t\t} else {" + NL + "\t\t\t           \t\t\t\t\t";
  protected final String TEXT_379 = "Struct.commonByteArray_";
  protected final String TEXT_380 = "_";
  protected final String TEXT_381 = " = new byte[2 * length];" + NL + "\t\t\t           \t\t\t\t}" + NL + "\t\t\t   \t\t\t\t\t}" + NL + "\t\t\t       \t\t\t\tdis.readFully(";
  protected final String TEXT_382 = "Struct.commonByteArray_";
  protected final String TEXT_383 = "_";
  protected final String TEXT_384 = ", 0, length);" + NL + "\t\t\t       \t\t\t\tthis.";
  protected final String TEXT_385 = "__";
  protected final String TEXT_386 = " = new String(";
  protected final String TEXT_387 = "Struct.commonByteArray_";
  protected final String TEXT_388 = "_";
  protected final String TEXT_389 = ", 0, length);" + NL + "\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_390 = NL + "\t\t\t\t            length = dis.readByte();" + NL + "\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t   \t    \t\t\tthis.";
  protected final String TEXT_391 = "__";
  protected final String TEXT_392 = " = null;" + NL + "\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t   \t\t\t    \tthis.";
  protected final String TEXT_393 = "__";
  protected final String TEXT_394 = " = new Date(dis.readLong());" + NL + "\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_395 = NL + "\t\t\t\t            length = dis.readInt();" + NL + "\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t   \t    \t\t\tthis.";
  protected final String TEXT_396 = "__";
  protected final String TEXT_397 = " = null;" + NL + "\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t       \t\t\t\tbyte[] byteArray = new byte[length];" + NL + "\t\t\t       \t\t\t\tdis.readFully(byteArray);" + NL + "\t\t\t       \t\t\t\tthis.";
  protected final String TEXT_398 = "__";
  protected final String TEXT_399 = " = byteArray;" + NL + "\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_400 = NL + "\t\t\t\t\t\t\tthis.";
  protected final String TEXT_401 = "__";
  protected final String TEXT_402 = " = (";
  protected final String TEXT_403 = ") dis.readObject();" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_404 = NL + "\t\t\t\t            length = dis.readByte();" + NL + "\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t   \t    \t\t\tthis.";
  protected final String TEXT_405 = "__";
  protected final String TEXT_406 = " = null;" + NL + "\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t   \t\t\t\t\tthis.";
  protected final String TEXT_407 = "__";
  protected final String TEXT_408 = " = dis.read";
  protected final String TEXT_409 = "();" + NL + "\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_410 = NL + "\t\t\t            ";
  protected final String TEXT_411 = NL + "\t\t\t\t            this.exprKey_";
  protected final String TEXT_412 = "__";
  protected final String TEXT_413 = " = dis.read";
  protected final String TEXT_414 = "();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_415 = NL + "\t\t\t\t            length = dis.readByte();" + NL + "\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t   \t    \t\t\tthis.exprKey_";
  protected final String TEXT_416 = "__";
  protected final String TEXT_417 = " = null;" + NL + "\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t   \t\t\t    \tthis.exprKey_";
  protected final String TEXT_418 = "__";
  protected final String TEXT_419 = " = new Date(dis.readLong());" + NL + "\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_420 = NL + "\t\t\t\t\t            length = dis.readInt();" + NL + "\t\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t\t   \t    \t\t\tthis.exprKey_";
  protected final String TEXT_421 = "__";
  protected final String TEXT_422 = " = null;" + NL + "\t\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t\t   \t\t\t\t\tif(length > ";
  protected final String TEXT_423 = "Struct.commonByteArray_";
  protected final String TEXT_424 = "_";
  protected final String TEXT_425 = ".length) {" + NL + "\t\t\t\t   \t\t\t\t\t\tif(length < 1024 && ";
  protected final String TEXT_426 = "Struct.commonByteArray_";
  protected final String TEXT_427 = "_";
  protected final String TEXT_428 = ".length == 0) {" + NL + "\t\t\t\t           \t\t\t\t\t";
  protected final String TEXT_429 = "Struct.commonByteArray_";
  protected final String TEXT_430 = "_";
  protected final String TEXT_431 = " = new byte[1024];" + NL + "\t\t\t\t   \t\t\t\t\t\t} else {" + NL + "\t\t\t\t           \t\t\t\t\t";
  protected final String TEXT_432 = "Struct.commonByteArray_";
  protected final String TEXT_433 = "_";
  protected final String TEXT_434 = " = new byte[2 * length];" + NL + "\t\t\t\t           \t\t\t\t}" + NL + "\t\t\t\t   \t\t\t\t\t}" + NL + "\t\t\t\t       \t\t\t\tdis.readFully(";
  protected final String TEXT_435 = "Struct.commonByteArray_";
  protected final String TEXT_436 = "_";
  protected final String TEXT_437 = ", 0, length);" + NL + "\t\t\t\t       \t\t\t\tthis.exprKey_";
  protected final String TEXT_438 = "__";
  protected final String TEXT_439 = " = new String(";
  protected final String TEXT_440 = "Struct.commonByteArray_";
  protected final String TEXT_441 = "_";
  protected final String TEXT_442 = ", 0, length);" + NL + "\t\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_443 = NL + "\t\t\t\t            length = dis.readInt();" + NL + "\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t   \t    \t\t\tthis.exprKey_";
  protected final String TEXT_444 = "__";
  protected final String TEXT_445 = " = null;" + NL + "\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t       \t\t\t\tbyte[] byteArray = new byte[length];" + NL + "\t\t\t       \t\t\t\tdis.readFully(byteArray);" + NL + "\t\t\t       \t\t\t\tthis.exprKey_";
  protected final String TEXT_446 = "__";
  protected final String TEXT_447 = " = byteArray;" + NL + "\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_448 = NL + "\t\t\t   \t\t\t\tthis.exprKey_";
  protected final String TEXT_449 = "__";
  protected final String TEXT_450 = " = (";
  protected final String TEXT_451 = ") dis.readObject();" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_452 = NL + "\t\t\t\t            length = dis.readByte();" + NL + "\t\t\t   \t\t\t\tif (length == -1) {" + NL + "\t\t\t   \t    \t\t\tthis.exprKey_";
  protected final String TEXT_453 = "__";
  protected final String TEXT_454 = " = null;" + NL + "\t\t\t   \t\t\t\t} else {" + NL + "\t\t\t   \t\t\t\t\tthis.exprKey_";
  protected final String TEXT_455 = "__";
  protected final String TEXT_456 = " = dis.read";
  protected final String TEXT_457 = "();" + NL + "\t\t\t   \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_458 = NL + "\t\t\t\t\t} catch (IOException e) {" + NL + "\t\t\t        throw new RuntimeException(e);" + NL + "\t\t\t\t";
  protected final String TEXT_459 = NL + "\t\t\t\t";
  protected final String TEXT_460 = NL + "\t\t\t\t\t} catch(ClassNotFoundException eCNFE) {" + NL + "\t\t\t\t\t\t\t throw new RuntimeException(eCNFE);" + NL + "\t\t\t\t";
  protected final String TEXT_461 = NL + "\t\t\t\t\t    \t}" + NL + "\t\t\t\t\t\t} " + NL + "\t\t\t\t\t}" + NL + "\t\t\t\tpublic void writeData(ObjectOutputStream dos) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t   \tdos.writeBoolean(this.is__rejectedInnerJoin);" + NL + "\t\t\t\t\t";
  protected final String TEXT_462 = NL + "\t\t\t            \tdos.write";
  protected final String TEXT_463 = "(this.";
  protected final String TEXT_464 = "__";
  protected final String TEXT_465 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_466 = NL + "\t\t\t\t\t\t\tif(this.";
  protected final String TEXT_467 = "__";
  protected final String TEXT_468 = " == null) {" + NL + "\t\t\t\t                dos.writeInt(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t                byte[] byteArray = this.";
  protected final String TEXT_469 = "__";
  protected final String TEXT_470 = ".getBytes();" + NL + "\t\t\t   \t\t\t    \tdos.writeInt(byteArray.length);" + NL + "\t\t\t       \t\t\t\tdos.write(byteArray);" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_471 = NL + "\t\t\t\t\t\t\tif(this.";
  protected final String TEXT_472 = "__";
  protected final String TEXT_473 = " == null) {" + NL + "\t\t\t\t                dos.writeByte(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t       \t\t\t\tdos.writeByte(0);" + NL + "\t\t\t   \t\t\t    \tdos.writeLong(this.";
  protected final String TEXT_474 = "__";
  protected final String TEXT_475 = ".getTime());" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_476 = NL + "\t\t\t\t\t\t\tif(this.";
  protected final String TEXT_477 = "__";
  protected final String TEXT_478 = " == null) {" + NL + "\t\t\t\t                dos.writeInt(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t   \t\t\t    \tdos.writeInt(this.";
  protected final String TEXT_479 = "__";
  protected final String TEXT_480 = ".length);" + NL + "\t\t\t       \t\t\t\tdos.write(this.";
  protected final String TEXT_481 = "__";
  protected final String TEXT_482 = ");" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_483 = NL + "\t\t\t\t\t\t    \tdos.writeObject(this.";
  protected final String TEXT_484 = "__";
  protected final String TEXT_485 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_486 = NL + "\t\t\t\t\t\t\tif(this.";
  protected final String TEXT_487 = "__";
  protected final String TEXT_488 = " == null) {" + NL + "\t\t\t\t                dos.writeByte(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t       \t\t\t\tdos.writeByte(0);" + NL + "\t\t\t   \t\t\t    \tdos.write";
  protected final String TEXT_489 = "(this.";
  protected final String TEXT_490 = "__";
  protected final String TEXT_491 = ");" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_492 = NL + "\t\t\t            ";
  protected final String TEXT_493 = NL + "\t\t\t\t            dos.write";
  protected final String TEXT_494 = "(this.exprKey_";
  protected final String TEXT_495 = "__";
  protected final String TEXT_496 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_497 = NL + "\t\t\t\t\t\t\tif(this.exprKey_";
  protected final String TEXT_498 = "__";
  protected final String TEXT_499 = " == null) {" + NL + "\t\t\t\t                dos.writeInt(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t                byte[] byteArray = this.exprKey_";
  protected final String TEXT_500 = "__";
  protected final String TEXT_501 = ".getBytes();" + NL + "\t\t\t   \t\t\t    \tdos.writeInt(byteArray.length);" + NL + "\t\t\t       \t\t\t\tdos.write(byteArray);" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_502 = NL + "\t\t\t\t\t\t\tif(this.exprKey_";
  protected final String TEXT_503 = "__";
  protected final String TEXT_504 = " == null) {" + NL + "\t\t\t\t                dos.writeByte(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t       \t\t\t\tdos.writeByte(0);" + NL + "\t\t\t   \t\t\t    \tdos.writeLong(this.exprKey_";
  protected final String TEXT_505 = "__";
  protected final String TEXT_506 = ".getTime());" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_507 = NL + "\t\t\t\t\t\t\tif(this.exprKey_";
  protected final String TEXT_508 = "__";
  protected final String TEXT_509 = " == null) {" + NL + "\t\t\t\t                dos.writeInt(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t   \t\t\t    \tdos.writeInt(this.exprKey_";
  protected final String TEXT_510 = "__";
  protected final String TEXT_511 = ".length);" + NL + "\t\t\t       \t\t\t\tdos.write(this.exprKey_";
  protected final String TEXT_512 = "__";
  protected final String TEXT_513 = ");" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_514 = NL + "\t\t\t\t\t\t    \tdos.writeObject(this.exprKey_";
  protected final String TEXT_515 = "__";
  protected final String TEXT_516 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_517 = NL + "\t\t\t\t\t\t\tif(this.exprKey_";
  protected final String TEXT_518 = "__";
  protected final String TEXT_519 = " == null) {" + NL + "\t\t\t\t                dos.writeByte(-1);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t       \t\t\t\tdos.writeByte(0);" + NL + "\t\t\t   \t\t\t    \tdos.write";
  protected final String TEXT_520 = "(this.exprKey_";
  protected final String TEXT_521 = "__";
  protected final String TEXT_522 = ");" + NL + "\t\t\t            \t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_523 = NL + "\t\t\t\t\t\t} catch (IOException e) {" + NL + "\t\t\t\t\t        throw new RuntimeException(e);" + NL + "\t\t\t\t\t";
  protected final String TEXT_524 = NL + "\t\t\t    }" + NL + "\t\t\t}" + NL + "\t     }" + NL + "\t   ";
  protected final String TEXT_525 = NL + "\t            ";

	class XMLMapUtil {
	
		private XmlMapData getXmlMapData(INode node) {
		
			XmlMapData xmlMapData = (XmlMapData)ElementParameterParser.getObjectValueXMLTree(node);
			
			return xmlMapData;
		}
		
		private List<IConnection> filterAndSort(INode node) {
			
			XmlMapData xmlMapData= getXmlMapData(node);
			EList<InputXmlTree> inputTables = xmlMapData.getInputTrees();
			final List<String> tableNames = new ArrayList<String>();
			HashMap<String, InputXmlTree> hNameToInputXmlTree = new HashMap<String, InputXmlTree>();
			
			for(InputXmlTree inputTable : inputTables){
				hNameToInputXmlTree.put(inputTable.getName(), inputTable);
				tableNames.add(inputTable.getName());
			}
			
			List<IConnection> inputConnections = new ArrayList<IConnection>();
			
			for(IConnection conn : node.getIncomingConnections()){
				if(hNameToInputXmlTree.get(conn.getName()) != null){
					inputConnections.add(conn);
				}
			}
			
			java.util.Collections.sort(inputConnections,new java.util.Comparator<IConnection>() {
				public int compare(IConnection conn1, IConnection conn2) {
					return tableNames.indexOf(conn1.getName()) - tableNames.indexOf(conn2.getName());
				}	
			});
			
			return inputConnections;
		}
	
		public String createSignature(INode node, boolean force) {
			String toReturn = "";
			
			List<IConnection> inputConnections = filterAndSort(node);
			
			for(IConnection conn : inputConnections) {
				if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN) || conn.getLineStyle().equals(EConnectionType.FLOW_MERGE) || conn.getLineStyle().equals(EConnectionType.FLOW_REF)) {
					if ((force)|| conn.getLineStyle().equals(EConnectionType.FLOW_REF) ||(conn.getSource().isSubProcessStart() || !(NodeUtil.isDataAutoPropagated(conn.getSource())))) {
						toReturn+=", "+conn.getName() + "Struct " + conn.getName();
					} else {
						toReturn+=", "+getConnectionType(conn)+"Struct " + conn.getName();
					}
				}
			}
    		return toReturn;
    	}
    	
    	public String getConnectionType(IConnection currentConn) {
    	    INode sourceNode = currentConn.getSource();
    		for(IConnection conn : sourceNode.getIncomingConnections()) {
				if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN) || conn.getLineStyle().equals(EConnectionType.FLOW_MERGE) || conn.getLineStyle().equals(EConnectionType.FLOW_REF)) {
					if ((conn.getLineStyle().equals(EConnectionType.FLOW_REF) || conn.getSource().isSubProcessStart() || !(NodeUtil.isDataAutoPropagated(conn.getSource())))) {
						return conn.getName();
					} else {
						return getConnectionType(conn);
					}
				} else if (conn.getLineStyle().equals(EConnectionType.ITERATE)||conn.getLineStyle().equals(EConnectionType.ON_ROWS_END)) {
				    if(sourceNode.getOutgoingConnections() != null && sourceNode.getOutgoingConnections().size() > 0) {
				        return currentConn.getName();
				    }
				}
			}
			return "";
    	}
    	
    	public boolean tableHasADocument(EList<OutputTreeNode> outputTableEntries) {
    		for (OutputTreeNode outputTableEntry : outputTableEntries) {
    			if(("id_Document").equals(outputTableEntry.getType())){
    				return true;
    			}
    		}
    		return false;
    	}
	}

	class MatchXmlTreeExpr {
		String cid = null;
		java.util.Map<String, String> pathTypeMap = new java.util.HashMap<String, String>(); // Map<input table xpath, typeToGenerate>
		java.util.Map<String, String> pathPatternMap = new java.util.HashMap<String, String>(); // Map<input table xpath, Pattern>
		java.util.Map<String, String> pathTypeToGenMap = new java.util.HashMap<String, String>(); // Map<"/root/name","String">
		
		//only for main input table
		public MatchXmlTreeExpr(TreeNode node, String cid) {
			this.cid = cid;
			init(node);
		}
		
		//for main and all lookup tables
		public MatchXmlTreeExpr(List<TreeNode> nodes, String cid) {
			this.cid = cid;
			for(TreeNode node : nodes) {
				init(node);
			}
		}
		
		//NO TYPE CHECK 
		public MatchXmlTreeExpr(String cid) {
			this.cid = cid;
		}
		
		private void init(TreeNode node) {
			if(node.getOutgoingConnections().size()>0 || node.getLookupOutgoingConnections().size()>0 || node.getFilterOutGoingConnections().size()>0){
				String talendType = node.getType();
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(talendType);
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(talendType, node.isNullable());
				String patternValue = node.getPattern() == null || node.getPattern().trim().length() == 0 ? null : node.getPattern();
				
				pathTypeMap.put(node.getXpath(), talendType);
				pathPatternMap.put(node.getXpath(), patternValue);
				pathTypeToGenMap.put(node.getXpath(), typeToGenerate);
			}
    		
    		for(TreeNode tmpNode : node.getChildren()) {
    			init(tmpNode);
    		}
		}
		
		String generateExprCode(String expression){
			StringBuilder strBuilder = new StringBuilder();
			if(expression==null || ("").equals(expression)) {
				return "";
			}
	
			String currentExpression = expression;
			String tmpXpath = "";
			java.util.regex.Pattern expressionFromDoc = java.util.regex.Pattern.compile("\\[.*\\..*:.*\\]");
			java.util.regex.Matcher matcherFromDoc;
			
			boolean end = false;
			
			if(expression.indexOf("[")>-1) {
				strBuilder.append(expression.substring(0, expression.indexOf("[")));
				currentExpression = currentExpression.substring(currentExpression.indexOf("["), currentExpression.length());
				
				while(currentExpression.length()>0 && !end) {
					expression = this.getXPathExpression(currentExpression);
					currentExpression = currentExpression.substring(expression.length(), currentExpression.length());
					matcherFromDoc = expressionFromDoc.matcher(expression);
					if(matcherFromDoc.matches()) {
						tmpXpath = expression.substring(1, expression.length()-1);
						if("id_String".equals(pathTypeMap.get(tmpXpath)) || "id_Object".equals(pathTypeMap.get(tmpXpath))){
							strBuilder.append("treeNodeAPI_"+cid+".get_String(\""+ tmpXpath + "\")");
						} else if("id_Date".equals(pathTypeMap.get(tmpXpath))) {
							strBuilder.append("treeNodeAPI_"+cid+".get_Date(\""+ tmpXpath + "\" , " + pathPatternMap.get(tmpXpath) + ")");
						} else if("id_byte[]".equals(pathTypeMap.get(tmpXpath))) {
							strBuilder.append("treeNodeAPI_"+cid+".get_Bytes(\""+ tmpXpath + "\")");
						} else {
							if(pathTypeToGenMap.get(tmpXpath)!=null) {
								strBuilder.append("treeNodeAPI_"+cid+".get_" + pathTypeToGenMap.get(tmpXpath) + "(\""+ tmpXpath + "\")");
							} else {
								strBuilder.append("treeNodeAPI_"+cid+".get_String(\""+ tmpXpath + "\")");
							}
						}				
					} else {
						strBuilder.append(expression);
					}
					if(currentExpression.indexOf("[")>-1) {
						strBuilder.append(currentExpression.substring(0, currentExpression.indexOf("[")));
						currentExpression = currentExpression.substring(currentExpression.indexOf("["), currentExpression.length());
					} else {
						strBuilder.append(currentExpression);
						end=true;
					}
				
				}
			} else {
				strBuilder.append(expression);
			}
			return strBuilder.toString();
		}
		
		private String getXPathExpression(String currentExpression) {
			int count = 0;
			int i = 0;
			for(;i<currentExpression.length();i++) {
				char c = currentExpression.charAt(i);
				if('[' == c) {
					count++;
				}
				if(']' == c) {
					if(count==1) {
						break;
					}
					count--;
				}
			}
			return currentExpression.substring(0,i+1);
		}
		
	}
	
	class XPathHelper{
		int dPrefixCount = 0;
		Map<String,String> nsMapping = new HashMap<String,String>();
		Map<String,String> dPrefixMapping = new HashMap<String,String>();
		TreeNode rootNode;
		boolean isOptional = false; // use to judge if the loop node is mandotary in the source file.
		TreeNode loopNode;
		String finalLoopNodeXPath;
		Map<String,String> outNodesXPath = new HashMap<String,String>();
		Map<String,String> lookupInputNodesXPath;
		
		Map<String,String> xpathToPattern = new HashMap<String,String>();
		Map<String,String> xpathToType = new HashMap<String,String>();
		
		//all input loops used by current output table
		List<TreeNode> inputLoopsInCurrentOutputTable;
		public void setInputLoopsInCurrentOutputTable(List<TreeNode> inputLoopsInCurrentOutputTable) {
			this.inputLoopsInCurrentOutputTable = inputLoopsInCurrentOutputTable;
		}
		
		public Map<String,String> getXpathToPatternMap(){
			return xpathToPattern;
		}
		
		public Map<String,String> getXpathToTypeMap(){
			return xpathToType;
		}
		
		public XPathHelper(TreeNode rootNode){
			this(rootNode,false);
		}
		
		public XPathHelper(TreeNode rootNode,boolean isMultiLoop){
			this.rootNode = rootNode;
			collectionNS(rootNode, nsMapping, dPrefixMapping, null);
			if(!isMultiLoop) {
				//set loop node
				setInputLoopNode(findLoopNode(rootNode));
			} else {
				//do nothing
			}
			
		}
				
		public void setInputLoopNode(TreeNode inputLoopNode) {
			if(inputLoopNode==null){
				return;
			}
			loopNode = inputLoopNode;
			isOptional = loopNode.isOptional();
			
			
			List<TreeNode> outNodes = new ArrayList<TreeNode>(); 
			//find all output node(out & lookup out)
			findOutputNodes(rootNode, outNodes);
			
			//build xpath with prefix
			finalLoopNodeXPath = buildXPathWithPrefix(getXPath(loopNode.getXpath()), dPrefixMapping);
			
			outNodesXPath = new HashMap<String,String>();
			buildXPathWithPrefix(outNodes, dPrefixMapping, outNodesXPath);
			
			//build xpath for the node has lookup input connection
			List<TreeNode> lookupInputNodes = new ArrayList<TreeNode>();
			findLookupInputNodes(rootNode, lookupInputNodes);
			lookupInputNodesXPath = new HashMap<String,String>();
			buildXPathWithPrefix(lookupInputNodes, dPrefixMapping, lookupInputNodesXPath);
		}
		
		public boolean hasLoopNode(){
			if(loopNode == null){
				return false;
			}
			return true;
		}
		public boolean hasDefinedNS(){
			if(nsMapping.size()==0){
				return false;
			}
			return true;
		}
		
		/**
		 * use to judge if the loop is mandotary
		 * 
		 */
		public boolean isLoopOptional() {
			return isOptional;
		}
		
		public Map<String,String> getOutNodesXPath(){
			return outNodesXPath;
		}
		
		public Map<String,String> getLookupInputNodesXPath(){
			return lookupInputNodesXPath;
		}
		
		public String buildNSMapping(String name){
			StringBuilder sb = new StringBuilder();
			for (Object key : nsMapping.keySet()) { 
			    Object val = nsMapping.get(key);
			    sb.append(name+".put(\""+key+"\",\""+val+"\");"); 
			} 
			return sb.toString();
		}
		
		public String getLoopNodeXPath(){
			return finalLoopNodeXPath;
		}
		
		private void buildXPathWithPrefix(List<TreeNode> nodes, Map<String,String> dPrefixMapping, Map<String,String> nodesXPath){
			String loopNodeXPath = loopNode.getXpath();
			for(TreeNode node: nodes){
				String currentNodeXPath = node.getXpath();
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(node.getType(), node.isNullable()); 
				xpathToType.put(currentNodeXPath,typeToGenerate);
				xpathToPattern.put(currentNodeXPath,node.getPattern());
				
				if(currentNodeXPath==null || ("").equals(currentNodeXPath)){
				}else if(loopNodeXPath.equals(currentNodeXPath)){
					nodesXPath.put(currentNodeXPath, ".");
				}else{
					String xpath = getXPath(currentNodeXPath);
					
					if(inputLoopsInCurrentOutputTable!=null) {
						for(TreeNode inputLoop : inputLoopsInCurrentOutputTable) {
							if(loopNode.equals(inputLoop)) {//skip current loop
								continue;
							}
							
							String otherLoopNodeXPath = inputLoop.getXpath();
							if(currentNodeXPath.equals(otherLoopNodeXPath) || isChild(currentNodeXPath,otherLoopNodeXPath)) {//current node in other loop node
								StringBuilder sb = new StringBuilder(currentNodeXPath);
								String newXPath = sb.insert(otherLoopNodeXPath.length(),"[1]").toString();
							 	xpath = getXPath(newXPath);
							 	break;
							}
						}
					}
					
					String nodeXPathWithPrefix = buildXPathWithPrefix(xpath, dPrefixMapping);
					if(isChild(nodeXPathWithPrefix,finalLoopNodeXPath)){
						String relativeXPath = nodeXPathWithPrefix.substring(finalLoopNodeXPath.length() + 1);
						nodesXPath.put(currentNodeXPath, relativeXPath);
					}else{
						StringBuilder relativeXPath = new StringBuilder();
						String tmp = finalLoopNodeXPath;
						
						while(!isChild(nodeXPathWithPrefix,tmp)){
							int index = tmp.lastIndexOf("/");
							if(index<0){ break; }
							tmp = tmp.substring(0,index);
							relativeXPath.append("../");
						}
						if(tmp.lastIndexOf("/") < 0 ){
							System.out.println("Loop Path is not set or loop Path is invalid");
						}else{
							relativeXPath.append(nodeXPathWithPrefix.substring(tmp.length() + 1));
						}
						nodesXPath.put(currentNodeXPath, relativeXPath.toString());
					}
				}
			}
		} 
		
		private boolean isChild(String asChild,String asParent) {
            return asChild.startsWith(asParent) && '/' == asChild.charAt(asParent.length());
		}
		
		private String buildXPathWithPrefix(String xpath, Map<String,String> dPrefixMapping){
			StringBuilder finalXPath = new StringBuilder();
			return buildXPathWithPrefix(finalXPath, xpath, dPrefixMapping);
			
		}
		private String buildXPathWithPrefix(StringBuilder finalXPath, String xpath, Map<String,String> dPrefixMapping){
			List<String> nodePaths = new ArrayList<String>();
			
			while(xpath.lastIndexOf("/") != -1){
				nodePaths.add(xpath);
				xpath = xpath.substring(0,xpath.lastIndexOf("/"));
			}
			
			for(int i=nodePaths.size()-1; i>=0; i--){
				String nodePath = nodePaths.get(i);
				String prefix = dPrefixMapping.get(nodePath);
				String nodeName = nodePath.substring(nodePath.lastIndexOf("/")+1);
				
				finalXPath.append("/");
				if(prefix != null && !"".equals(prefix)){
					finalXPath.append(prefix);
					finalXPath.append(":");
					finalXPath.append(nodeName);
				}else{
					finalXPath.append(nodeName);
				}
			}
			
			return finalXPath.toString();
		}
		
		private void findOutputNodes(TreeNode currentNode, List<TreeNode> outNodes){
			if(currentNode.getOutgoingConnections().size()>0 || currentNode.getLookupOutgoingConnections().size()>0 || currentNode.getFilterOutGoingConnections().size()>0){
				outNodes.add(currentNode);
			}
			for(TreeNode childNode : currentNode.getChildren()) {
				if(childNode.getNodeType() == NodeType.ELEMENT || childNode.getNodeType() == NodeType.ATTRIBUT){
					findOutputNodes(childNode, outNodes);
				}
			}
		}
		
		private void findLookupInputNodes(TreeNode currentNode, List<TreeNode> lookupInputNodes){
			if(currentNode.getLookupIncomingConnections().size()>0){
				lookupInputNodes.add(currentNode);
			}
			for(TreeNode childNode : currentNode.getChildren()) {
				if(childNode.getNodeType() == NodeType.ELEMENT || childNode.getNodeType() == NodeType.ATTRIBUT){
					findLookupInputNodes(childNode, lookupInputNodes);
				}
			}
		}
		
		private void collectionNS(TreeNode currentNode, Map<String,String> nsMapping, Map<String,String> dPrefixMapping, String parentDPrefix){
			EList<TreeNode> childNodes = currentNode.getChildren();
			for(TreeNode childNode : childNodes){
				if(childNode.getNodeType() == NodeType.NAME_SPACE){
					if(childNode.getName() != null && !"(default)".equals(childNode.getName())){
						nsMapping.put(childNode.getName(),childNode.getDefaultValue());
					}else{
						String defaultPrefix = findVaildDefaultPrefix();
						nsMapping.put(defaultPrefix,childNode.getDefaultValue());
						//dPrefixMapping.put(getXPath(currentNode.getXpath()),defaultPrefix);
						parentDPrefix = defaultPrefix;
					}
				}
			}
			if(!currentNode.getName().contains(":")){
				if(parentDPrefix != null && !"".equals(parentDPrefix)){
					dPrefixMapping.put(getXPath(currentNode.getXpath()),parentDPrefix);
				}
			}else{
				//parentDPrefix = null;
			}
			for(TreeNode childNode : childNodes){
				if(childNode.getNodeType() == NodeType.ELEMENT){
					collectionNS(childNode, nsMapping, dPrefixMapping, parentDPrefix);
				}
			}
		}
		
		private String findVaildDefaultPrefix(){
			String prefix = "TPrefix"+dPrefixCount;
			dPrefixCount++;
			if(nsMapping.get(prefix)==null || "".equals(nsMapping.get(prefix))){
				return prefix;
			}else{
				return findVaildDefaultPrefix();
			}
		}
		
		private TreeNode findLoopNode(TreeNode node){
			if(node == null){
				return null;
			}
			if(node.isLoop()) {
				return node;
			}
			for(TreeNode childNode : node.getChildren()) {
				if(childNode.getNodeType() == NodeType.ELEMENT){
					TreeNode resultNode = findLoopNode(childNode);
					if(resultNode!=null){
						return resultNode;
					}
				}
			}
			
			return null;
		}
		
		private String getXPath(String uiXPath){
			return uiXPath.substring(uiXPath.indexOf(":")+1);
		}
	}

	class TreeUtil{
		//get all nodes whose expression is editable;
		void getAllLeaf(TreeNode node,List<TreeNode> result) {
			EList<TreeNode> children = node.getChildren();
			if(children==null || children.size() == 0) {
				result.add(node);//leaf is editable
			} else {
				boolean editableAtExpression = true;
				for(TreeNode child : children) {
					if(child!=null) {
						//attribute and namespace are not treat as subnode , so the expression of treeNode should be editable.
						if(NodeType.ATTRIBUT != child.getNodeType() && NodeType.NAME_SPACE != child.getNodeType()) {
							editableAtExpression = false;
						}
						getAllLeaf(child,result);
					}
				}
				
				if(editableAtExpression) {
					result.add(node);
				}
			}
		}
		
		void getAllLoopNodes(OutputTreeNode node,List<OutputTreeNode> result) {
			if(node == null) {
				return;
			}
			if(node.isLoop()){
				result.add(node);
				return;
			}
			for(TreeNode child : node.getChildren()){
				getAllLoopNodes((OutputTreeNode)child,result);
			}
		}
		
		TreeNode getUniqueLoopNode(TreeNode node) {
			if(node == null) {
				return null;
			}
			if(node.isLoop()){
				return node;
			}
			for(TreeNode child : node.getChildren()){
				TreeNode loopNode = getUniqueLoopNode(child);
				if(loopNode!=null) {
					return loopNode;
				}
			}
			return null;
		}
		
		boolean isRootLoop(TreeNode root) {
			if(root == null) return false;
			List<TreeNode> children = root.getChildren();
			if(children == null || children.size() == 0) {
				return false;
			}
			TreeNode realRoot = children.get(0);
			return realRoot.isLoop();
		}
	}
	
	static class XMLOrderUtil {
		
		int groupCount = 0;
		
		int getGroupCount(OutputTreeNode rootNode) {
			groupCount = 0;
			countGroupNode(rootNode);
			return groupCount;
		}
		
		static int getCurrOrder(OutputTreeNode currNode) {
			int currOrder = 0;
			if(isGroupOrLoopInMain(currNode)) {
				OutputTreeNode parent = (OutputTreeNode)currNode.eContainer();
				if(parent!=null) {
					EList<TreeNode> children = parent.getChildren();
					//the order not containing namespace and attribute
					for(TreeNode child : children) {
						NodeType nodeType = child.getNodeType();
						if(nodeType != NodeType.ELEMENT) {
							continue;
						}
						if(currNode.equals(child)) {
							break;
						} 
						currOrder++;
					}
				}
			}
			return currOrder;
		}
		
		static int getCurrPos(OutputTreeNode currNode) {
			int currPos = 0;
			if(isGroupOrLoopInMain(currNode)) {
				OutputTreeNode parent = (OutputTreeNode)currNode.eContainer();
				OutputTreeNode tmpNode = parent;
				while(tmpNode!=null){
					boolean isGroupOrLoopInMain = isGroupOrLoopInMain(tmpNode);
					boolean isVirtualNode = isVirtualNode(tmpNode);
					
					if(!isGroupOrLoopInMain && !isVirtualNode) {
						break;
					}
					
					if(isGroupOrLoopInMain && !isVirtualNode) {
    					currPos++;
    				}
    				
    				tmpNode = (OutputTreeNode)tmpNode.eContainer();
    			}
			}
			return currPos;
		}
		
		//work for multi loop document output
		static java.util.List<OutputTreeNode> getNextSiblings(OutputTreeNode currNode){
            java.util.List<OutputTreeNode> result = new java.util.ArrayList<OutputTreeNode>();
            OutputTreeNode parent = (OutputTreeNode)currNode.eContainer();
            boolean isNextSibling = false;
            if(parent!=null){
            	EList<TreeNode> children = parent.getChildren();
                for(TreeNode child : children) {
					NodeType nodeType = child.getNodeType();
					if(nodeType != NodeType.ELEMENT) {
						continue;
					}
					
					if(isNextSibling) {
						result.add((OutputTreeNode)child);
						continue;
					}
					
					if(currNode.equals(child)) {
						isNextSibling = true;
					}
				}
            }
            return result;
        }
		
		private static boolean isGroupOrLoopInMain(OutputTreeNode currNode) {
			return currNode.isMain() && (currNode.isGroup() || currNode.isLoop());
		}
		
		private static boolean isVirtualNode(OutputTreeNode currNode) {
			return currNode.isSubstitution() || currNode.isChoice();
		}
		
		private void countGroupNode(OutputTreeNode node) {
			EList<TreeNode> children = node.getChildren();
			
			if(children==null || children.size() == 0) {
				//it is impossible that leaf is Group.
				
			} else {
				//branch maybe Group
				if(node.isGroup() && !isVirtualNode(node)) {
					groupCount++;
				}
				
				for(TreeNode child : children) {
					if(child!=null) {
						countGroupNode((OutputTreeNode)child);
					}
				}
			}
		}
		
		
		
	}
	
	public INode searchSubProcessStartNode(IConnection connection) {
       	INode source = connection.getSource();
    	INode subprocessStartNode = null;
    	if(source != null) {
			String searchedComponentName = source.getUniqueName();
			List<? extends INode> generatedNodes = source.getProcess().getGeneratingNodes();
			for(INode loopNode : generatedNodes) {
				if(loopNode.getUniqueName().equals(searchedComponentName)) {
					subprocessStartNode = loopNode.getSubProcessStartNode(false);
				}
			}
		}
		return subprocessStartNode;
	}
	
	public List<InputLoopNodesTable> getValidInputLoopNodesTables(List<InputLoopNodesTable> inputLoopNodesTablesWithUnValid) {
    	List<InputLoopNodesTable> inputLoopNodesTables = new ArrayList<InputLoopNodesTable>();
    	if(inputLoopNodesTablesWithUnValid == null) return inputLoopNodesTables;
		for(InputLoopNodesTable inputLoopNodesTable : inputLoopNodesTablesWithUnValid) {
			if(inputLoopNodesTable!=null && inputLoopNodesTable.getInputloopnodes()!=null && inputLoopNodesTable.getInputloopnodes().size()>0)
				inputLoopNodesTables.add(inputLoopNodesTable);
		}
		return inputLoopNodesTables;
    }
	
    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	XmlMapComponent node = (XmlMapComponent) codeGenArgument.getArgument();
	GenerationManager gm = (GenerationManager) GenerationManagerFactory.getInstance().getGenerationManager();
	String cid = node.getUniqueName();
	
	String uniqueNameComponent = cid.replace("_TXMLMAP_OUT", "");
	String uniqueNameComponentIn = cid.replace("_TXMLMAP_OUT", "_TXMLMAP_IN");
	
	INode generatingNodeIn = null;
	for(INode loopNode : node.getProcess().getGeneratingNodes()) {
		if(loopNode.getUniqueName().equals(uniqueNameComponentIn)) {
			generatingNodeIn = loopNode;
			break;
		}
	}

	XmlMapData xmlMapData =(XmlMapData)ElementParameterParser.getObjectValueXMLTree(node);
	
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	final boolean keepOrder4Document = "true".equals(ElementParameterParser.getValue(node, "__KEEP_ORDER_FOR_DOCUMENT__"));
	
	EList<InputXmlTree> inputTables = xmlMapData.getInputTrees();
	EList<OutputXmlTree> outputTables = xmlMapData.getOutputTrees();
	EList<VarTable> varTables = xmlMapData.getVarTables();
	boolean hasConcurrencyContext = false;
	List<IConnection> inputConnections = (List<IConnection>)node.getIncomingConnections();
	HashMap<String, IConnection> hNameToConnection = new HashMap<String, IConnection>();
	for(IConnection connection : inputConnections){
		hNameToConnection.put(connection.getName(), connection);
	}
	
	List<InputXmlTree> inputTableTrees = new ArrayList<InputXmlTree>();
	for(int i=0; i<inputTables.size(); i++){
		InputXmlTree  currentTree = inputTables.get(i);
		if(hNameToConnection.get(currentTree.getName()) != null){
			inputTableTrees.add(currentTree);
		}
	}
	
	boolean hasDocumentInAnyLookupTable = false;
	List<TreeNode> lookupDocumentTreeNodes = new ArrayList<TreeNode>();
	
	int lstSizeInputs = inputTableTrees.size();
	for(int i = 1; i<lstSizeInputs; i++){//TA8080
		InputXmlTree inputTable = (InputXmlTree)inputTableTrees.get(i);
		String tableName = inputTable.getName();
		
		EList<TreeNode> treeNodes = inputTable.getNodes();
		if(treeNodes!=null) {
			for(TreeNode treeNode : treeNodes) {
				if("id_Document".equals(treeNode.getType())) {
					hasDocumentInAnyLookupTable = true;
					lookupDocumentTreeNodes.add(treeNode);
				}
			}
		}		
		
		List<IMetadataTable> treeNodeEntries = node.getMetadataList();
		if(treeNodeEntries == null){
		      continue;
	    }
		
		boolean isAllRows = "ALL_ROWS".equals(inputTable.getMatchingMode());
		String className = tableName + "Struct";
		String lookupMode = inputTable.getLookupMode();
		boolean isReloadLookupMode = org.talend.designer.xmlmap.model.tree.LOOKUP_MODE.RELOAD.name().equals(lookupMode);
		boolean isCacheOrReloadLookupMode = org.talend.designer.xmlmap.model.tree.LOOKUP_MODE.CACHE_OR_RELOAD.name().equals(lookupMode);
		boolean isOneOfReloadLookupMode = isReloadLookupMode || isCacheOrReloadLookupMode;
		if(inputTable.isPersistent()){

    stringBuffer.append(TEXT_1);
    stringBuffer.append( isAllRows ? "" : "Sorted" );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append( isAllRows ? "" : "Sorted" );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append( isAllRows ? "" : "Sorted" );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_9);
    
				if(hasConcurrencyContext) {
				
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    
		} else {
	
    stringBuffer.append(TEXT_12);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_14);
    
	
	if(isOneOfReloadLookupMode) {
		 
    stringBuffer.append(TEXT_15);
    
	} else {
		
    stringBuffer.append(TEXT_16);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_19);
    
				if(hasConcurrencyContext) {
				
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    
	}
	
    stringBuffer.append(TEXT_22);
    
	}
	String matchingModeStr = inputTable.getMatchingMode();
	if(isCacheOrReloadLookupMode) {
	
    stringBuffer.append(TEXT_23);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(matchingModeStr);
    stringBuffer.append(TEXT_25);
    }
	if(isAllRows && !isOneOfReloadLookupMode) {
	
    stringBuffer.append(TEXT_26);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_37);
    
	}//TA8080
	
    stringBuffer.append(TEXT_38);
    
	class RepalceTableXpath {
		
		public void replaceTableXpath(TreeNode root){
			String xpath = root.getXpath();
			int index_p = xpath.indexOf(".");
			if(index_p<0){
    			xpath = xpath.replaceFirst("/", ".");
    			xpath = xpath.replaceFirst("/", ":/");
    			root.setXpath(xpath);
			}
    		for(TreeNode tmpNode : root.getChildren()) {
    			replaceTableXpath(tmpNode);
    		}
		}
	}
	RepalceTableXpath replaceXpath = new RepalceTableXpath();
	
	if(inputTables.size() > 0 && !inputTables.get(0).isLookup()) {
		InputXmlTree inputMainTable = inputTables.get(0);
		for(TreeNode tmpnode : inputMainTable.getNodes()) {
			if("id_Document".equals(tmpnode.getType())) {
				replaceXpath.replaceTableXpath(tmpnode);
				break;
			}
		}
	}
	for(OutputXmlTree outputMainTable : outputTables) {
		for(OutputTreeNode tmpnode : outputMainTable.getNodes()) {
			if("id_Document".equals(tmpnode.getType())) {
				replaceXpath.replaceTableXpath(tmpnode);
				break;
			}
		}
	}
	
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    

class GenerateMethodUtil {
	String cid = null;
	java.util.Map<String, String> typeMap = new java.util.HashMap<String, String>(); // Map<typeToGenerate, typeToGenerate>
	java.util.Map<String, String> pathTypeMap = new java.util.HashMap<String, String>(); // Map<input table xpath, typeToGenerate>
	java.util.Map<String, String> pathPatternMap = new java.util.HashMap<String, String>(); // Map<input table xpath, Pattern>
	java.util.Map<String, String> pathTypeToGenMap = new java.util.HashMap<String, String>(); // Map<"/root/name","String">
	
	void generateExprCode(String expression){
			StringBuilder strBuilder = new StringBuilder();
			if(expression==null || ("").equals(expression)) {
				return;
			}
	
			String currentExpression = expression;
			String tmpXpath = "";
			java.util.regex.Pattern expressionFromDoc = java.util.regex.Pattern.compile("\\[.*\\..*:.*\\]");
			java.util.regex.Matcher matcherFromDoc;
			
			boolean end = false;
			
			if(expression.indexOf("[")>-1) {
				strBuilder.append(expression.substring(0, expression.indexOf("[")));
				currentExpression = currentExpression.substring(currentExpression.indexOf("["), currentExpression.length());
				
				while(currentExpression.length()>0 && !end) {
					expression = this.getXPathExpression(currentExpression);
					currentExpression = currentExpression.substring(expression.length(), currentExpression.length());
					matcherFromDoc = expressionFromDoc.matcher(expression);
					if(matcherFromDoc.matches()) {
						tmpXpath = expression.substring(1, expression.length()-1);
						if("id_String".equals(pathTypeMap.get(tmpXpath)) || "id_Object".equals(pathTypeMap.get(tmpXpath))){
							strBuilder.append("treeNodeAPI.get_String(\""+ tmpXpath + "\")");
						} else if("id_Date".equals(pathTypeMap.get(tmpXpath))) {
							strBuilder.append("treeNodeAPI.get_Date(\""+ tmpXpath + "\" , " + pathPatternMap.get(tmpXpath) + ")");
						} else if("id_byte[]".equals(pathTypeMap.get(tmpXpath))) {
							strBuilder.append("treeNodeAPI.get_Bytes(\""+ tmpXpath + "\")");
						} else {
							String type = pathTypeToGenMap.get(tmpXpath);
							if(type != null) {
								strBuilder.append("treeNodeAPI.get_" + pathTypeToGenMap.get(tmpXpath) + "(\""+ tmpXpath + "\")");
							} else {
								strBuilder.append("treeNodeAPI.get_String(\""+ tmpXpath + "\")");
							}
						}				
					} else {
						strBuilder.append(expression);
					}
					if(currentExpression.indexOf("[")>-1) {
						strBuilder.append(currentExpression.substring(0, currentExpression.indexOf("[")));
						currentExpression = currentExpression.substring(currentExpression.indexOf("["), currentExpression.length());
					} else {
						strBuilder.append(currentExpression);
						end=true;
					}
				
				}
			} else {
				strBuilder.append(expression);
			}
			
    stringBuffer.append(strBuilder.toString());
    
		}
		
		private String getXPathExpression(String currentExpression) {
			int count = 0;
			int i = 0;
			for(;i<currentExpression.length();i++) {
				char c = currentExpression.charAt(i);
				if('[' == c) {
					count++;
				}
				if(']' == c) {
					if(count==1) {
						break;
					}
					count--;
				}
			}
			return currentExpression.substring(0,i+1);
		}
		
		public List<TreeNode> getGroupByNodeList(TreeNode group) {
			List<TreeNode> list = new ArrayList<TreeNode>();
			for (TreeNode attri : group.getChildren()) {
				if(NodeType.ATTRIBUT.equals(attri.getNodeType())) {
					String expression = attri.getExpression();
					if(expression!=null && !"".equals(expression)) {
						list.add(attri);
					}
				}
			}
			if (NodeType.ELEMENT.equals(group.getNodeType()) && group.getChildren().size()==0) {
				String expression = group.getExpression();
				if(expression!=null && !"".equals(expression)) {
					list.add(group);
				}
			} else {
				if(NodeType.ELEMENT.equals(group.getNodeType()))
				for (TreeNode element : group.getChildren()) {
					boolean isVirtualNode = element.isSubstitution() || element.isChoice();
					if ((!element.isMain() && !element.isLoop()) || isVirtualNode) {
						list.addAll(getGroupByNodeList(element));
					}
				}
			}
			return list;
		}

	
	void generateCode(List<TreeNode> nodes, String cid){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    
		generateMethodCodeForAll(nodes, cid);

    stringBuffer.append(TEXT_43);
    
	}
	
	void generateMethodCodeForAll(List<TreeNode> nodes, String cid) {
		for(TreeNode node : nodes) {
			generateMethodCodeForOne(node,cid);
		}
	}
	
	boolean methodExist = false;
	
	void generateMethodCodeForOne(TreeNode node, String cid) {
		
		if(!(node.getChildren().size()>0) || node.getOutgoingConnections().size()>0 || node.getLookupOutgoingConnections().size()>0 || node.getFilterOutGoingConnections().size()>0){
			String talendType = node.getType();
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(talendType);
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(talendType, node.isNullable());
			String patternValue = node.getPattern() == null || node.getPattern().trim().length() == 0 ? null : node.getPattern();
			
			pathTypeMap.put(node.getXpath(), talendType);
			pathPatternMap.put(node.getXpath(), patternValue);
			pathTypeToGenMap.put(node.getXpath(), typeToGenerate);
			if(typeMap.get(typeToGenerate)==null){
				typeMap.put(typeToGenerate,typeToGenerate);
				if ("id_String".equals(talendType) || "id_Object".equals(talendType)) {
					if(!methodExist) {

    stringBuffer.append(TEXT_44);
    
						methodExist = true;
					}
				} else if ("id_Date".equals(talendType)) {

    stringBuffer.append(TEXT_45);
    
				} else if("id_byte[]".equals(talendType)){ 

    stringBuffer.append(TEXT_46);
    
				} else {
					String returnValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);

    stringBuffer.append(TEXT_47);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(returnValue);
    stringBuffer.append(TEXT_50);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_51);
    
				}
			}
		}
		
		for(TreeNode tmpNode : node.getChildren()) {
			generateMethodCodeForOne(tmpNode,cid);
		}
	}
}

	// define the var row
	for (VarTable var : xmlMapData.getVarTables()) {
		String tableName = var.getName();
        String instanceVarName = tableName + "__" + node.getUniqueName();
        String className = instanceVarName + "__Struct";

    stringBuffer.append(TEXT_52);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_53);
    
            for(VarNode varNode : var.getNodes()){
                String javaType = varNode.getType();

    stringBuffer.append(TEXT_54);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(javaType, varNode.isNullable()) );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(varNode.getName() );
    stringBuffer.append(TEXT_56);
    
            }

    stringBuffer.append(TEXT_57);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( instanceVarName );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_60);
    
	}

    stringBuffer.append(TEXT_61);
    

		List<IConnection> outputConnections = (List<IConnection>) generatingNodeIn.getOutgoingConnections();
		Map<String, IConnection> nameToOutputConnection = new HashMap<String, IConnection>();
        for (IConnection connection : outputConnections) {
		  		nameToOutputConnection.put(connection.getName(), connection);
		}

        for (OutputXmlTree table : outputTables) {
        
            EList<OutputTreeNode> tableEntries = table.getNodes();
            if (tableEntries == null || nameToOutputConnection.get(table.getName()) == null) {
                continue;
            }
            String tableName1 = table.getName();
            
            String instanceVarName = tableName1 + "__" + node.getUniqueName();
            String className = tableName1 + "Struct";
            

    stringBuffer.append(TEXT_62);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(TEXT_66);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_67);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(TEXT_69);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( tableName1 );
    stringBuffer.append(TEXT_71);
    
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(tableName1);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
			}
        }

    stringBuffer.append(TEXT_75);
    stringBuffer.append(uniqueNameComponent );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(uniqueNameComponent );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(uniqueNameComponent );
    stringBuffer.append(TEXT_78);
    
	
	InputXmlTree mainInputTable = null;  // the main input table
	if(inputConnections==null || inputConnections.size() < 1) {
		return "";
	}

	if(inputTables==null || inputTables.size()==0) return "";
	for(IConnection conn : inputConnections) { // find the input main table
		InputXmlTree inputTable = inputTables.get(0);
		EConnectionType connectionType = conn.getLineStyle();
		if (connectionType == EConnectionType.FLOW_MAIN) {
			if(!inputTable.isLookup()) { // lookup is used to sign it is lookup table
    			mainInputTable = inputTable;
    			break;
			}
		}
	}
	
	boolean hasDocumentInMainInputTable = false;
	//we should consider all document node instead of only main document node
	TreeNode mainDocumentTreeNode = null;
	if(mainInputTable != null) {
		for(TreeNode tmpNode : mainInputTable.getNodes()){
			if("id_Document".equals(tmpNode.getType())) {
				hasDocumentInMainInputTable = true;
				mainDocumentTreeNode = tmpNode;
				//This boolean when there is a document in the main input table schema.
				break;
			}
		}
	}
	
	GenerateMethodUtil generateMethodUtil = new GenerateMethodUtil();
	generateMethodUtil.cid = cid;
	if(mainInputTable != null) {
		String mainInputName = mainInputTable.getName();
		
		boolean hasDocumentInAnyTable = hasDocumentInAnyLookupTable || hasDocumentInMainInputTable;
		List<TreeNode> AllDocumentTreeNodes = new ArrayList<TreeNode>();
		if(lookupDocumentTreeNodes.size()!=0) {
			AllDocumentTreeNodes.addAll(lookupDocumentTreeNodes);
		}
		if(mainDocumentTreeNode!=null) {
			AllDocumentTreeNodes.add(mainDocumentTreeNode);
		}
		
		if(hasDocumentInAnyTable) {
			generateMethodUtil.generateCode(AllDocumentTreeNodes, cid); // begin part keep this part

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    	
		}

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    		
    }


    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//=====================================================output xml init part=======================================================================
class GenerateToolByDom4j{
	String cid = null;
	boolean allowEmpty = false;
	GenerateMethodUtil generateMethodUtil = null;
	java.util.List<java.util.List<TreeNode>> groupList = new java.util.ArrayList<java.util.List<TreeNode>>();
	java.util.List<java.util.List<java.util.List<TreeNode>>> groupbyNodeList = new java.util.ArrayList(new java.util.ArrayList<java.util.List<TreeNode>>());
	
	java.util.List<TreeNode> loopNodes;
	java.util.Map<TreeNode,String> loopNodeToParentRef;
	java.util.Map<TreeNode,String> currentLoopNodeRef;
	
	void setAllMainNodes(TreeNode root) {
		loopNodes = new java.util.ArrayList<TreeNode>();
		loopNodeToParentRef = new java.util.HashMap<TreeNode,String>();
		currentLoopNodeRef = new java.util.HashMap<TreeNode,String>();
		
		getLoopNodes(root);
		int i = 0;
		for(;i<loopNodes.size();i++) {
			TreeNode loop = loopNodes.get(i);
			loop.setMain(true);
			loopNodeToParentRef.put(loop,"subTreeLoopParent"+i);
			currentLoopNodeRef.put(loop,"subTreeLoop"+i);
			TreeNode parent = (TreeNode)loop.eContainer();
			while((parent != null) && (!("id_Document").equals(parent.getType())) ) {
				parent.setMain(true);
				parent = (TreeNode)parent.eContainer();
			}
		}
		
	}
	
	private boolean isRoot(TreeNode node) {
		if(node == null) return false;
		TreeNode parent = (TreeNode)node.eContainer();
		if(parent == null) return false;
		return "id_Document".equals(parent.getType());
	}
	
	public void getLoopNodes(TreeNode root) {
		if(root == null) {
			return;
		}
		if(root.isLoop()){
			loopNodes.add(root);
			return;
		}
		
		for(TreeNode node : root.getChildren()){
			getLoopNodes(node);
		}
	}
	
	private int index = 0;
	
	public void generateCode(OutputTreeNode node, String currEleName, String parentName){
		if(node.getNodeType()==NodeType.ELEMENT){
			boolean isVirtualNode = node.isSubstitution() || node.isChoice();
			if(!isVirtualNode) {
				createElement(currEleName,node,parentName);
				setText(currEleName,node);
			
	    		// add namespace support here in the future
	    		for(TreeNode child: node.getChildren()) {
	    			if(child.getNodeType()==NodeType.NAME_SPACE) { // namespaces
	    				addNameSpace(currEleName, (OutputTreeNode)child);
	    			}
	    		}
	    		
	    		addAttribute(currEleName, node);
    		} else {
    			currEleName = parentName;
    		}
			
			for(TreeNode child:node.getChildren()){
				if(!child.isGroup() && !child.isLoop()) {
					if(isVirtualNode && noUseSubTree(child)) {
						continue;
					}
					generateCode((OutputTreeNode)child,currEleName+"_"+index++,currEleName);
				} else if(child.isLoop()) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(loopNodeToParentRef.get(child));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_92);
    
					
				}
			}
			
		}
	}
	
	private boolean noUseSubTree(TreeNode node) {
		if(node.getExpression()!=null && !("").equals(node.getExpression())) {
			return false;
		}
		for(TreeNode child:node.getChildren()){
			if(!noUseSubTree(child)) {
				return false;
			}
		}
		return true;
	}
	
	private void addNameSpace(String currEleName, OutputTreeNode node) {
		if(node.getDefaultValue()==null || ("").equals(node.getDefaultValue())) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_94);
    generateMethodUtil.generateExprCode(node.getExpression() ); 
    stringBuffer.append(TEXT_95);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(node.getName() );
    stringBuffer.append(TEXT_99);
    generateMethodUtil.generateExprCode(node.getExpression() ); 
    stringBuffer.append(TEXT_100);
    stringBuffer.append(node.getPattern());
    stringBuffer.append(TEXT_101);
    
		} else {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append("(default)".equals(node.getName())?"":node.getName() );
    stringBuffer.append(TEXT_104);
    generateMethodUtil.generateExprCode(((OutputTreeNode)node).getDefaultValue()); 
    stringBuffer.append(TEXT_105);
    
		}
		OutputTreeNode parent = (OutputTreeNode)node.eContainer();
		if(parent.getName().indexOf(":") < 0) { // element without prefix
			if(node.getName()==null || ("").equals(node.getName().trim()) || "(default)".equals(node.getName().trim())) { // it is the default namespace
				if(node.getDefaultValue()==null || ("").equals(node.getDefaultValue())) { // get the expression

    stringBuffer.append(TEXT_106);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_107);
    generateMethodUtil.generateExprCode(node.getExpression()); 
    stringBuffer.append(TEXT_108);
    stringBuffer.append(node.getPattern());
    stringBuffer.append(TEXT_109);
    
				} else { // get the static value as the url

    stringBuffer.append(TEXT_110);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_111);
    generateMethodUtil.generateExprCode(((OutputTreeNode)node).getDefaultValue()); 
    stringBuffer.append(TEXT_112);
    
				}
			}
		} else {
			int index = parent.getName().indexOf(":");
			if(node.getName().equals(parent.getName().substring(0, index))) { // the prefix of element is the same with the namespace
				if(node.getDefaultValue()==null || ("").equals(node.getDefaultValue())) { // get the expression

    stringBuffer.append(TEXT_113);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(parent.getName().substring(index+1 ) );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(node.getName() );
    stringBuffer.append(TEXT_116);
    generateMethodUtil.generateExprCode(node.getExpression() ); 
    stringBuffer.append(TEXT_117);
    stringBuffer.append(node.getPattern());
    stringBuffer.append(TEXT_118);
    
				} else {

    stringBuffer.append(TEXT_119);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(parent.getName().substring(index+1 ) );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(node.getName() );
    stringBuffer.append(TEXT_122);
    generateMethodUtil.generateExprCode(((OutputTreeNode)node).getDefaultValue()); 
    stringBuffer.append(TEXT_123);
    
				}
			}
		}
	}
	
	private void findElementFromParent(OutputTreeNode node, String parentName, String resultVar) {
		String elementName = node.getName();
		int index = elementName.indexOf(":");
		
		if(index < 1) {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(resultVar);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_128);
    
			return;
		}
		
		String namespacePrefixOfCurrentElement = elementName.substring(0,index);
		String localName = elementName.substring(index+1);
		TreeNode matchedNamespaceNode = null;
		
		for(TreeNode child: node.getChildren()) {
			if(child.getNodeType()!=NodeType.NAME_SPACE) {
				continue;
			}
			
			if(namespacePrefixOfCurrentElement.equals(child.getName())) {
				matchedNamespaceNode = child;
				break;
			}
		}
		
		if(matchedNamespaceNode!=null) {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(resultVar);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(localName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(matchedNamespaceNode.getName() );
    stringBuffer.append(TEXT_134);
    generateMethodUtil.generateExprCode(((OutputTreeNode)matchedNamespaceNode).getDefaultValue());
    stringBuffer.append(TEXT_135);
    
			return;
		}
		
		if(hasParent(node)){

    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(namespacePrefixOfCurrentElement);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(resultVar);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(localName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(localName);
    stringBuffer.append(TEXT_147);
    
		}
	}
	
	private void createElement(String currEleName, OutputTreeNode node, String parentName){

    stringBuffer.append(TEXT_148);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_149);
    
		int index = node.getName().indexOf(":");
		if(node.isMain() && (node.isGroup() || node.isLoop())) {
			if(index>0 && hasParent(node)){

    stringBuffer.append(TEXT_150);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(node.getName().substring(index+1));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(node.getName().substring(0,index));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(node.getName().substring(index+1));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(node.getName().substring(0,index));
    stringBuffer.append(TEXT_158);
    
			} else {

    stringBuffer.append(TEXT_159);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(node.getName());
    stringBuffer.append(TEXT_161);
    
			}
			
			if(isRoot(node)) {

    stringBuffer.append(TEXT_162);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_164);
    
			} else if(loopNodes.size() > 1) {
				if(!keepOrder4Document) {

    stringBuffer.append(TEXT_165);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_167);
    
				} else {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    findElementFromParent(node,parentName,"List currentElementList");
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    
							List<OutputTreeNode> nextSiblings = XMLOrderUtil.getNextSiblings(node);
							if(nextSiblings.size() > 0) {

    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    
							}
							
							for(OutputTreeNode sibling : nextSiblings) {

    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    findElementFromParent(sibling,parentName,"siblingList");
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    
							}

    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_200);
    
				}
			} else {

    stringBuffer.append(TEXT_201);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(XMLOrderUtil.getCurrPos(node) );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(XMLOrderUtil.getCurrOrder(node) );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_205);
    
			}
		} else {
			if(index>0 && hasParent(node)){

    stringBuffer.append(TEXT_206);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(node.getName().substring(0,index));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(node.getName().substring(index+1));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(node.getName());
    stringBuffer.append(TEXT_214);
    
			} else {

    stringBuffer.append(TEXT_215);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(node.getName());
    stringBuffer.append(TEXT_218);
    
			}
		}
		
		if(node.isGroup() || node.isMain()){

    stringBuffer.append(TEXT_219);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_220);
    
		}
	}
	
	private void addAttribute(String currEleName, OutputTreeNode node){
		for(TreeNode tmpNode : node.getChildren()) {
			if(tmpNode.getNodeType()==NodeType.ATTRIBUT) {

    stringBuffer.append(TEXT_221);
    
				if(tmpNode.getExpression()!=null && !("").equals(tmpNode.getExpression())){

    stringBuffer.append(TEXT_222);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_223);
    generateMethodUtil.generateExprCode(tmpNode.getExpression()); 
    stringBuffer.append(TEXT_224);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_225);
    generateMethodUtil.generateExprCode(tmpNode.getExpression()); 
    stringBuffer.append(TEXT_226);
    stringBuffer.append(tmpNode.getPattern());
    stringBuffer.append(TEXT_227);
     if(allowEmpty) { 
    stringBuffer.append(TEXT_228);
     } 
    
				} else if(allowEmpty) {

    stringBuffer.append(TEXT_229);
    
				}
				
				String name = tmpNode.getName();
				
        		String prefix = null;
        		String localname = name;
        		
        		int index = name.indexOf(":");
        		if(index > 0) {
        			prefix = name.substring(0,index);
        			localname = name.substring(index+1);
        		}

    stringBuffer.append(TEXT_230);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_231);
    if(prefix != null) {
    stringBuffer.append(TEXT_232);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_233);
    } else {
    stringBuffer.append(TEXT_234);
    }
    stringBuffer.append(TEXT_235);
    stringBuffer.append(localname);
    stringBuffer.append(TEXT_236);
    
			}
		}
	}
	
	private void setText(String currEleName, OutputTreeNode node){
		if(node.getExpression()!=null && !("").equals(node.getExpression()) ){

    stringBuffer.append(TEXT_237);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_238);
    generateMethodUtil.generateExprCode(node.getExpression()); 
    stringBuffer.append(TEXT_239);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_241);
    generateMethodUtil.generateExprCode(node.getExpression()); 
    stringBuffer.append(TEXT_242);
    stringBuffer.append(node.getPattern());
    stringBuffer.append(TEXT_243);
    
		}
	}
	private boolean hasParent(OutputTreeNode node){
		if(node.eContainer()!=null){
			OutputTreeNode parent = (OutputTreeNode)node.eContainer();
			if(!("id_Document").equals(parent.getType()) && parent.isMain()){
				return true;
			}
		}
		return false;
	}
	// judge if the current main element has a group or loop element as his child node
	private boolean isRootEndMainNode(OutputTreeNode node){
		if(!node.isMain() || node.isLoop() || node.isGroup()){
			return false;
		}
		for(TreeNode tmpNode: node.getChildren()){
			if(tmpNode.isMain() && (tmpNode.isLoop() || tmpNode.isGroup())){
				return true;
			}
		}
		return false;
	}
	// the root node which a group child or loop child
	private boolean isMediaMainNode(OutputTreeNode node) {
		if(node.isMain()) {
			for(TreeNode tmpNode : node.getChildren()) {
				if(tmpNode.isMain() && (tmpNode.isLoop() || tmpNode.isGroup())) {
					return true;
				}
			}
		}
		return false;
	}
	
	private void generateGroupCode(int index) {
		if(groupList.get(index).size()>0){

    stringBuffer.append(TEXT_244);
    
			for(int i=0;i<groupList.get(index).size();i++){
				TreeNode groupRootNode = groupList.get(index).get(i);

    stringBuffer.append(TEXT_245);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_247);
    
						for(int j=0;j<groupbyNodeList.get(index).get(i).size();j++){
							TreeNode attr = groupbyNodeList.get(index).get(i).get(j);
							if(attr.getExpression()!=null && !("").equals(attr.getExpression()) ){

    stringBuffer.append(TEXT_248);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_252);
    generateMethodUtil.generateExprCode(attr.getExpression()); 
    stringBuffer.append(TEXT_253);
    stringBuffer.append(attr.getPattern());
    stringBuffer.append(TEXT_254);
    generateMethodUtil.generateExprCode(attr.getExpression()); 
    stringBuffer.append(TEXT_255);
    stringBuffer.append(attr.getPattern());
    stringBuffer.append(TEXT_256);
     
							}
						}
			

    stringBuffer.append(TEXT_257);
    
					generateCode((OutputTreeNode)groupList.get(index).get(i),"group"+i+"_","subTreeRootParent");						

    stringBuffer.append(TEXT_258);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_260);
     
					for(int j=0;j<groupbyNodeList.get(index).get(i).size();j++){
						TreeNode attr = groupbyNodeList.get(index).get(i).get(j);
						if(attr.getExpression()!=null && !("").equals(attr.getExpression()) ){

    stringBuffer.append(TEXT_261);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_262);
    generateMethodUtil.generateExprCode(attr.getExpression()); 
    stringBuffer.append(TEXT_263);
    stringBuffer.append(attr.getPattern());
    stringBuffer.append(TEXT_264);
     
						}
					}

    stringBuffer.append(TEXT_265);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_270);
     
		}
	}
}
	
	
	private void generateGroupCmpCode(OutputTreeNode node, int index) {
		for(TreeNode tmpNode : node.getChildren()) {
			if(tmpNode.isLoop()) {
				return;
			}
			
			if(tmpNode.isGroup()) {
				boolean isVirtualNode = tmpNode.isSubstitution() || tmpNode.isChoice();
				if(!isVirtualNode) {
					groupbyNodeList.get(index).add(generateMethodUtil.getGroupByNodeList(tmpNode));
					groupList.get(index).add(tmpNode);
				}
			}
			
			generateGroupCmpCode((OutputTreeNode)tmpNode, index);
		}
	}
}

	//init the generate tool.
	GenerateToolByDom4j generateToolByDom4j = new GenerateToolByDom4j();
	generateToolByDom4j.cid = cid;
	generateToolByDom4j.generateMethodUtil = generateMethodUtil;
// define the generate the output document class
int index = -1;

    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    
for(OutputXmlTree outputTable : outputTables) {
	boolean allowEmptyElement = outputTable.isEnableEmptyElement();
	generateToolByDom4j.allowEmpty = allowEmptyElement;
	
	String tableName = outputTable.getName();
	for(OutputTreeNode outputNode: outputTable.getNodes()) {
		if(("id_Document").equals(outputNode.getType())){
			
			TreeUtil treeUtil = new TreeUtil();
			//check whether root is loop
			boolean isRootLoop = treeUtil.isRootLoop(outputNode);
			//get the document aggregation columns
			List<TreeNode> allLeaf = new ArrayList<TreeNode>();
			treeUtil.getAllLeaf(outputNode,allLeaf);
			for(TreeNode leaf : allLeaf) {
				OutputTreeNode outputLeaf = (OutputTreeNode)leaf;
				if(outputLeaf.isAggregate()) {
					String xpath = outputLeaf.getXpath();

    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(xpath);
    stringBuffer.append(TEXT_275);
    					
				}
			}
			
			index+=1;
			
			//get the group and loop node count(TDI-18000)
			XMLOrderUtil xmlOrderUtil = new XMLOrderUtil();
			int groupCount = xmlOrderUtil.getGroupCount(outputNode);
			

    stringBuffer.append(TEXT_276);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_277);
    
	if(hasDocumentInMainInputTable || hasDocumentInAnyLookupTable) {
		//We generate the TreeNode_API object only if there is a document in the schema.

    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    
	}

    stringBuffer.append(TEXT_280);
    stringBuffer.append(groupCount + 1);
    stringBuffer.append(TEXT_281);
    
//Integer groupSize = new Integer(0);
//getGroupSize(outputNode, groupSize);

XMLMapUtil xmu = new XMLMapUtil();


    stringBuffer.append(TEXT_282);
    
	OutputTreeNode root = (OutputTreeNode)outputNode.getChildren().get(0); // get the root tree node
	generateToolByDom4j.setAllMainNodes(root);
	for(TreeNode loopNode : generateToolByDom4j.loopNodes) {
		String parentRef = generateToolByDom4j.loopNodeToParentRef.get(loopNode);
		String isCurrentLoopRef = generateToolByDom4j.currentLoopNodeRef.get(loopNode);

    stringBuffer.append(TEXT_283);
    stringBuffer.append(parentRef);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(isCurrentLoopRef);
    stringBuffer.append(TEXT_285);
    
	}

    stringBuffer.append(TEXT_286);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_287);
    if(hasDocumentInMainInputTable || hasDocumentInAnyLookupTable){
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    }
    stringBuffer.append(TEXT_290);
    
		
    stringBuffer.append(xmu.createSignature(node, false) );
    
	
		for (VarTable var : varTables) {
			String tableName1 = var.getName();
	        String instanceVarName = tableName1 + "__" + cid;
	        String className = instanceVarName + "__Struct";
	
    stringBuffer.append(TEXT_291);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(var.getName());
    stringBuffer.append(TEXT_293);
    
	}
	
    stringBuffer.append(TEXT_294);
    
	generateToolByDom4j.generateCode(root,"root","doc");

    stringBuffer.append(TEXT_295);
    
generateToolByDom4j.groupList.add(new java.util.ArrayList<TreeNode>());
generateToolByDom4j.groupbyNodeList.add(new java.util.ArrayList<java.util.List<TreeNode>>());
generateToolByDom4j.generateGroupCmpCode(root, index);
generateToolByDom4j.generateGroupCode(index);

    stringBuffer.append(TEXT_296);
    
			if(!isRootLoop){
				if(generateToolByDom4j.loopNodes.size() == 1) {
					OutputTreeNode loop = (OutputTreeNode)generateToolByDom4j.loopNodes.get(0);
					generateToolByDom4j.generateCode(loop,"loop","subTreeRootParent");
				} else {
					for(TreeNode loopNode : generateToolByDom4j.loopNodes) {
						OutputTreeNode loop = (OutputTreeNode)loopNode;
						String parentRef = generateToolByDom4j.loopNodeToParentRef.get(loopNode);
						String isCurrentLoopRef = generateToolByDom4j.currentLoopNodeRef.get(loopNode); 

    stringBuffer.append(TEXT_297);
    stringBuffer.append(isCurrentLoopRef);
    stringBuffer.append(TEXT_298);
    
						generateToolByDom4j.generateCode(loop,"loop",parentRef);

    stringBuffer.append(TEXT_299);
    
					}
				}
			}

    stringBuffer.append(TEXT_300);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_305);
    
		} // if(docuemnt)
	}// for(outputNode)
} // for (outputXMLTree)

    stringBuffer.append(TEXT_306);
    
	//==========================================the next code for Persistent Lookup==============================================
	HashMap<String, AbstractNode> hExternalInputTableEntries = new HashMap<String, AbstractNode>();
	
	String currentJoinedTableNames = "";
	
	int sizeInputTables = inputTables.size();
	        
	List<IConnection> cumulatedInputConnections = new ArrayList<IConnection>();
	
	String comma;
	for (int iInputTable = 0; iInputTable < sizeInputTables - 1; iInputTable++) { 
	        
			InputXmlTree currentInputTable = inputTables.get(iInputTable);
			InputXmlTree nextInputTable = null; 
			
			if(sizeInputTables > 1) {
				nextInputTable = inputTables.get(iInputTable + 1);
			}
			if(currentJoinedTableNames.length() > 0) {
				currentJoinedTableNames += "__";
			}
			currentJoinedTableNames += currentInputTable.getName();
		
			String currentTableName = currentInputTable.getName();
		    IConnection currentConection = hNameToConnection.get(currentTableName);
		    if (currentConection == null) {
		        continue;
		    }
		    cumulatedInputConnections.add(currentConection);
    
		if(nextInputTable != null && nextInputTable.isPersistent()) {
			
			List<IMetadataColumn> nextColumnsKeys = new ArrayList<IMetadataColumn>();
	
		        String nextTableName = nextInputTable.getName();
	            IConnection nextConection = hNameToConnection.get(nextTableName);
	            if (nextConection == null) {
	                continue;
	            }
	  
    stringBuffer.append(TEXT_307);
    stringBuffer.append( currentJoinedTableNames );
    stringBuffer.append(TEXT_308);
    stringBuffer.append( currentJoinedTableNames );
    stringBuffer.append(TEXT_309);
    stringBuffer.append( currentJoinedTableNames );
    stringBuffer.append(TEXT_310);
    
			        IMetadataTable nextMetadataTable = nextConection.getMetadataTable();
			        if (nextInputTable != null) {
			            hExternalInputTableEntries.clear();
			            List<TreeNode> trees = nextInputTable.getNodes();
			            if (trees == null) {
			                continue;
			            }

			            
			            List<IMetadataColumn> listColumns = nextMetadataTable.getListColumns();
			            //for (IMetadataColumn column : listColumns) {
			            for(int i=0; i<listColumns.size(); i++){
			            	IMetadataColumn column = listColumns.get(i);
			                TreeNode currentNode = (TreeNode)trees.get(i);
			            	if (currentNode != null) {
			            		String expressionKey = currentNode.getExpression();
			                    if (expressionKey != null && !"".equals(expressionKey.trim())) {
			                    
			                    	nextColumnsKeys.add(column);
			                    
			                    	
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_311);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_313);
    
				                           
			                    }
			                }
			            }
					}
				// properties declarations 
				
    stringBuffer.append(TEXT_314);
    stringBuffer.append( currentInputTable.getName() );
    stringBuffer.append(TEXT_315);
    
			        IMetadataTable currentMetadataTable = currentConection.getMetadataTable();
			        if (currentInputTable != null) {
			
						for(IConnection connection : cumulatedInputConnections) {
			            	IMetadataTable joinedTable = connection.getMetadataTable();
			                List<IMetadataColumn> listColumns = joinedTable.getListColumns();
			            	for (IMetadataColumn column : listColumns) {
			                    String columnName = column.getLabel();
			                    
			                    
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_316);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_318);
    
							}
			            }
			            hExternalInputTableEntries.clear();

			            List<TreeNode> trees = currentInputTable.getNodes();
			            if (trees == null) {
			                continue;
			            }
					}
			        
    stringBuffer.append(TEXT_319);
    
				        comma = "";
			         	for(IConnection connection : cumulatedInputConnections) {
			         	
			         		IConnection realConnection = org.talend.core.model.utils.NodeUtil.getRealConnectionTypeBased(connection);
			         	
				        	
    stringBuffer.append(comma);
    stringBuffer.append(TEXT_320);
    stringBuffer.append( realConnection.getName() );
    stringBuffer.append(TEXT_321);
    stringBuffer.append( connection.getName() );
    
			         		comma = ", ";
			         	}
			            int sizeNextColumns = nextColumnsKeys.size();
			            for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { 
			            	IMetadataColumn column = nextColumnsKeys.get(iColumn);
			
			         		
    stringBuffer.append(comma);
    stringBuffer.append(TEXT_322);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_323);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(column.getLabel() );
    
			            
			            } 
			            
			         
    stringBuffer.append(TEXT_325);
    
			        	for(IConnection connection : cumulatedInputConnections) {
			        	
			        		IMetadataTable table = connection.getMetadataTable();
							List<IMetadataColumn> listColumns = table.getListColumns();
			            	for (IMetadataColumn column : listColumns) {
								
    stringBuffer.append(TEXT_326);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_327);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_328);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_329);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_330);
    
			        		}
			        	}
			        	
    stringBuffer.append(TEXT_331);
    
			            sizeNextColumns = nextColumnsKeys.size();
			            for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { 
			            	IMetadataColumn column = nextColumnsKeys.get(iColumn);
			
							
    stringBuffer.append(TEXT_332);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_334);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_336);
    
			            
			            } 
			            
    stringBuffer.append(TEXT_337);
    
			         
				         comma = "";
				         for(IConnection connection : cumulatedInputConnections) {
				
				            IConnection realConnection = org.talend.core.model.utils.NodeUtil.getRealConnectionTypeBased(connection);
				
					         
    stringBuffer.append(comma);
    stringBuffer.append( realConnection.getName() );
    stringBuffer.append(TEXT_338);
    stringBuffer.append( connection.getName() );
    
				         	comma = ", ";
				         }
				         
    stringBuffer.append(TEXT_339);
    
				        	for(IConnection connection : cumulatedInputConnections) {
				        	
				        		IMetadataTable table = connection.getMetadataTable();
								List<IMetadataColumn> listColumns = table.getListColumns();
				            	for (IMetadataColumn column : listColumns) {
								
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_340);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_341);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_342);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_343);
    
				        		}
				        	}
				        	
    stringBuffer.append(TEXT_344);
    	
						comma = "";
							for(IConnection connection : cumulatedInputConnections) {
						        	
								IMetadataTable metadata = connection.getMetadataTable();
							if (metadata !=null) {
								for (IMetadataColumn column: metadata.getListColumns()) {
										if(comma.length() > 0) {
										
    stringBuffer.append(TEXT_345);
    stringBuffer.append( comma );
    stringBuffer.append(TEXT_346);
    
										}
										
    stringBuffer.append(TEXT_347);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_348);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_349);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_350);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_351);
    
									comma = ", ";
								}
							}
						}
						
    stringBuffer.append(TEXT_352);
    stringBuffer.append( currentJoinedTableNames );
    stringBuffer.append(TEXT_353);
    
			            sizeNextColumns = nextColumnsKeys.size();
			            for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { 
			            	IMetadataColumn column = nextColumnsKeys.get(iColumn);
			            
    stringBuffer.append(TEXT_354);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_356);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_358);
    
			            } 
			            
    stringBuffer.append(TEXT_359);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_362);
    	
						boolean hasAtLeastOneRead = false;
						boolean hasAtLeastOneObjectType = false;
						if (currentMetadataTable !=null) {
						        for(IConnection connection : cumulatedInputConnections) {
				        		IMetadataTable table = connection.getMetadataTable();
								List<IMetadataColumn> listColumns = table.getListColumns();
				            	for (IMetadataColumn column : listColumns) {
							  	hasAtLeastOneRead = true;
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							 	
						if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
							typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
					    
    stringBuffer.append(TEXT_363);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_364);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_365);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_366);
    
						} else if(("String").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_367);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_368);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_369);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_372);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_375);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_378);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_381);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_384);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_385);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_386);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_389);
    
						} else if(("java.util.Date").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_390);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_391);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_392);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_393);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_394);
    
						} else if(("byte[]").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_395);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_396);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_397);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_398);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_399);
    
						} else if(("Object").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate) || ("List").equals(typeToGenerate)) {
							hasAtLeastOneObjectType = true;
						
    stringBuffer.append(TEXT_400);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_401);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_402);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_403);
    
						} else {
							typeToGenerate =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
							typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
						
    stringBuffer.append(TEXT_404);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_405);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_406);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_407);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_408);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_409);
    
							}
			        	  }
			        	}
			        	
    stringBuffer.append(TEXT_410);
    
			            sizeNextColumns = nextColumnsKeys.size();
			            for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { 
			            	IMetadataColumn column = nextColumnsKeys.get(iColumn);
			
						  	hasAtLeastOneRead = true;
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			
						 	if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
						 		typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
						
    stringBuffer.append(TEXT_411);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_412);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_413);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_414);
    
						 	} else if(("java.util.Date").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_415);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_416);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_417);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_418);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_419);
    
						 	} else if(("String").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_420);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_421);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_422);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_425);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_426);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_428);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_429);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_430);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_431);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_434);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_437);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_438);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_439);
    stringBuffer.append( currentTableName );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_442);
    
						 	} else if(("byte[]").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_443);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_444);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_445);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_446);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_447);
    
						 	} else if(("Object").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate) || ("List").equals(typeToGenerate)) {
				 		hasAtLeastOneObjectType = true;
						
    stringBuffer.append(TEXT_448);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_449);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_450);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_451);
    
						 	} else {
						typeToGenerate =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
						typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
						
    stringBuffer.append(TEXT_452);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_453);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_454);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_455);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_456);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_457);
    
						 	}
			            } 
					}
					if(hasAtLeastOneRead) {
						
    stringBuffer.append(TEXT_458);
    
				}
				
    stringBuffer.append(TEXT_459);
    
					if(hasAtLeastOneObjectType) {
				
    stringBuffer.append(TEXT_460);
    
				}
				
    stringBuffer.append(TEXT_461);
    	
					boolean hasAtLeastOneWrite = false;
					if (currentMetadataTable !=null) {
			        	for(IConnection connection : cumulatedInputConnections) {
			        	
			        		IMetadataTable table = connection.getMetadataTable();
							List<IMetadataColumn> listColumns = table.getListColumns();
			            	for (IMetadataColumn column : listColumns) {
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							hasAtLeastOneWrite = true;
						 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
								typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
							
    stringBuffer.append(TEXT_462);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_463);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_464);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_465);
    
							} else if(("String").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_466);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_467);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_468);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_469);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_470);
    
							} else if(("java.util.Date").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_471);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_472);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_473);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_474);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_475);
    
							} else if(("byte[]").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_476);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_477);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_478);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_479);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_480);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_481);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_482);
    
							} else if(("Object").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate) || ("List").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_483);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_484);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_485);
    
							} else {
								typeToGenerate =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
								typeToGenerate = typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
						
    stringBuffer.append(TEXT_486);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_487);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_488);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_489);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_490);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_491);
    
								}
			        		}
			        	}
			        	
    stringBuffer.append(TEXT_492);
    
			            sizeNextColumns = nextColumnsKeys.size();
			            for (int iColumn = 0; iColumn < sizeNextColumns; iColumn++) { 
			            	IMetadataColumn column = nextColumnsKeys.get(iColumn);
			
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							hasAtLeastOneWrite = true;
						 	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
								typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
						
    stringBuffer.append(TEXT_493);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_494);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_495);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_496);
    
						} else if(("String").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_497);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_498);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_499);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_500);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_501);
    
						} else if(("java.util.Date").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_502);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_503);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_504);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_505);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_506);
    
						} else if(("byte[]").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_507);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_508);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_509);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_510);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_511);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_512);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_513);
    
						} else if(("Object").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate) || ("List").equals(typeToGenerate)) {
						
    stringBuffer.append(TEXT_514);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_515);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_516);
    
						} else {
								typeToGenerate =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
								typeToGenerate = typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
						
    stringBuffer.append(TEXT_517);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_518);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_519);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_520);
    stringBuffer.append( nextInputTable.getName() );
    stringBuffer.append(TEXT_521);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_522);
    
							}
			            } 
					}
					if(hasAtLeastOneWrite) {
					
    stringBuffer.append(TEXT_523);
    
					}
					
    stringBuffer.append(TEXT_524);
    }
	}
	
    stringBuffer.append(TEXT_525);
    return stringBuffer.toString();
  }
    class LoopHelper {
	
		//all used input loops(if the input loop is no used in any output table,we treat as no loop node)
		List<TreeNode> inputLoopsInAllOutputTables = new ArrayList<TreeNode>();
		
		//all output tables
		List<OutputXmlTree> outputTables;
		
		//all input tables
		List<InputXmlTree> inputTables;
		
		TreeNode inputRootOfMainInputTableDocument;
		
		public LoopHelper(TreeNode inputRoot,List<OutputXmlTree> outputTables,List<InputXmlTree> inputTables) {
			this.inputRootOfMainInputTableDocument = inputRoot;
			this.outputTables = outputTables;
			this.inputTables = inputTables;
			
			for(OutputXmlTree outputTable : outputTables) {
				List<InputLoopNodesTable> inputLoopNodesTables = getValidInputLoopNodesTables(outputTable.getInputLoopNodesTables());
				for(InputLoopNodesTable inputLoopNodesTable : inputLoopNodesTables) {
					List<TreeNode> inputLoopNodes = inputLoopNodesTable.getInputloopnodes();
					for(TreeNode node : inputLoopNodes) {
						if(!inputLoopsInAllOutputTables.contains(node)) {
							inputLoopsInAllOutputTables.add(node);
						}
					}
					
				}
			}
		}
		
		//all input loops used by current output table
		List<TreeNode> inputLoopsInCurrentOutputTable;
		
		//for output mapping belong to unique input loop
		public Map<TreeNode,TreeNode> outputNodeToLoopNode;
		
		//need a var for lookup output mapping belong to input loop
		
		boolean parallelLoopExistInCurrentOutputTable;
		
		boolean nestedLoopExistInCurrentOutputTable;
		
		public List<TreeNode> getInputLoopsInCurrentOutputTable() {
			return inputLoopsInCurrentOutputTable;
		}
		
		//set current output table and init
		public void initForOneOutputTable(OutputXmlTree currentOutputTable) {
			inputLoopsInCurrentOutputTable = new ArrayList<TreeNode>();
			parallelLoopExistInCurrentOutputTable = false;
			nestedLoopExistInCurrentOutputTable = false;
			outputNodeToLoopNode = new HashMap<TreeNode,TreeNode>();
			
			List<InputLoopNodesTable> inputLoopNodesTables = getInputLoopNodesTables(currentOutputTable);
			if(inputLoopNodesTables.size() > 1) {
				parallelLoopExistInCurrentOutputTable = true;
			}
			for(InputLoopNodesTable inputLoopNodesTable : inputLoopNodesTables) {
				List<TreeNode> inputLoopNodes = inputLoopNodesTable.getInputloopnodes();
				if(inputLoopNodes.size() > 1) {
					nestedLoopExistInCurrentOutputTable = true;
				}
				for(TreeNode inputLoopNode : inputLoopNodes) {
					if(!inputLoopsInCurrentOutputTable.contains(inputLoopNode)) {
						inputLoopsInCurrentOutputTable.add(inputLoopNode);
					}
				}
			}
			if(parallelLoopExistInCurrentOutputTable || nestedLoopExistInCurrentOutputTable) {
				setLoopMapping();
			}
		}
		
		private List<InputLoopNodesTable> getInputLoopNodesTables(OutputXmlTree currentOutputTable) {
			List<InputLoopNodesTable> result = new ArrayList<InputLoopNodesTable>();
			
			List<OutputTreeNode> loopNodes = new ArrayList<OutputTreeNode>();
			boolean docExist = false;
			for(OutputTreeNode currentNode : currentOutputTable.getNodes()) {
				if("id_Document".equals(currentNode.getType())) {
					getAllLoopNodes(currentNode,loopNodes);
					docExist = true;
				}
			}
			
			if(docExist) {
				for(OutputTreeNode loop : loopNodes) {
					if(loop.getInputLoopNodesTable()!=null) {
						result.add(loop.getInputLoopNodesTable());
					}
				}
			} else {//only flat column exist
				result.addAll(getValidInputLoopNodesTables(currentOutputTable.getInputLoopNodesTables()));
			}
			
			return result;
		}
		
		List<TreeNode> currentInputLoopNodes;
		//filter for lookup table
		List<TreeNode> noUsedInputLoopsForCurrentOutputTableLoop;
		List<TreeNode> noUsedLookupNodesForAllLookupTableToCurrentOutputTableLoop;
		//set current output loop of current output table  and init
		public void initForOneOutputTableLoop(List<TreeNode> inputLoopNodes) {
			noUsedInputLoopsForCurrentOutputTableLoop = new ArrayList<TreeNode>();
			noUsedLookupNodesForAllLookupTableToCurrentOutputTableLoop = new ArrayList<TreeNode>();
			currentInputLoopNodes = inputLoopNodes;
			for(TreeNode inputLoopNode : inputLoopsInAllOutputTables) {
				if(!currentInputLoopNodes.contains(inputLoopNode)) {
					noUsedInputLoopsForCurrentOutputTableLoop.add(inputLoopNode);
					insideOfLoop(inputLoopNode);
				}
			}
		}
		
		private void insideOfLoop(TreeNode loopNode) {
			if(asOutput(loopNode)) {
				noUsedLookupNodesForAllLookupTableToCurrentOutputTableLoop.add(loopNode);
			}
			for(TreeNode childNode : loopNode.getChildren()) {
				insideOfLoop(childNode);
			}
		}
	
		/**
		 * used when parallel loop exist in current output table or  parallel relation exist between all output tables
		 * @param nodeOfLookupTable
		 * @return
		 */
		public boolean validLookupKey(TreeNode nodeOfLookupTable) {
			List<LookupConnection> lookupIncomings = nodeOfLookupTable.getLookupIncomingConnections();
			if(lookupIncomings.size()>0) {
				LookupConnection lookupIncoming = lookupIncomings.get(0);
				TreeNode source = (TreeNode)lookupIncoming.getSource();
				return !noUsedLookupNodesForAllLookupTableToCurrentOutputTableLoop.contains(source);
			}
			return true;
		}
		
		/**
		 * for the output mapping
		 */
		private void setLoopMapping() {
			for(TreeNode inputLoop : inputLoopsInCurrentOutputTable) {
				initInsideOfLoop(inputLoop,inputLoop);
			}
			initOutsideOfLoops(this.inputRootOfMainInputTableDocument);
		}
		
		private void initInsideOfLoop(TreeNode loopNode,TreeNode node) {
			if(asOutput(node)) {
				outputNodeToLoopNode.put(node, loopNode);
			}
			for(TreeNode childNode : node.getChildren()) {
				initInsideOfLoop(loopNode,childNode);
			}
		}
		
		private void initOutsideOfLoops(TreeNode node) {
			if(node.isLoop()) {
				return;
			}
			if(asOutput(node)) {
				outputNodeToLoopNode.put(node,null);
			}
			for(TreeNode childNode : node.getChildren()) {
				initOutsideOfLoops(childNode);
			}
		}
		
		//for output mapping 
		public boolean belongToCurrentLoop(TreeNode inputLoopNode,String xpath,boolean isMainInputLoopInNestLoop) {
			if(parallelLoopExistInCurrentOutputTable || nestedLoopExistInCurrentOutputTable) {
				for(Map.Entry<TreeNode, TreeNode> entry : outputNodeToLoopNode.entrySet()) {
					TreeNode outputNode = entry.getKey();
					TreeNode loopNode = entry.getValue();
					if(xpath.equals(outputNode.getXpath())) {
						if(isMainInputLoopInNestLoop) {
							if(loopNode == null) {//outside of any input loop
								return true;
							}
							return loopNode == inputLoopNode;
						} else {
							if(loopNode == null) {
								return false;
							}
							return loopNode == inputLoopNode;
						}
					}
				}
			}
			return true;
		}
		
		private boolean asOutput(TreeNode currentNode) {
			return currentNode.getOutgoingConnections().size()>0 || currentNode.getLookupOutgoingConnections().size()>0 || currentNode.getFilterOutGoingConnections().size()>0;
		}
		
		private List<InputLoopNodesTable> getValidInputLoopNodesTables(List<InputLoopNodesTable> inputLoopNodesTablesWithUnValid) {
	    	List<InputLoopNodesTable> inputLoopNodesTables = new ArrayList<InputLoopNodesTable>();
	    	if(inputLoopNodesTablesWithUnValid == null) return inputLoopNodesTables;
			for(InputLoopNodesTable inputLoopNodesTable : inputLoopNodesTablesWithUnValid) {
				if(inputLoopNodesTable!=null && inputLoopNodesTable.getInputloopnodes()!=null && inputLoopNodesTable.getInputloopnodes().size()>0)
					inputLoopNodesTables.add(inputLoopNodesTable);
			}
			return inputLoopNodesTables;
	    }
		
		private void getAllLoopNodes(OutputTreeNode node,List<OutputTreeNode> result) {
			if(node == null) {
				return;
			}
			if(node.isLoop()){
				result.add(node);
				return;
			}
			for(TreeNode child : node.getChildren()){
				getAllLoopNodes((OutputTreeNode)child,result);
			}
		}
		
	}
}
