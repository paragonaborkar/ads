package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.BlockCode;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TExtractXMLFieldMainJava
{
  protected static String nl;
  public static synchronized TExtractXMLFieldMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractXMLFieldMainJava result = new TExtractXMLFieldMainJava();
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
  protected final String TEXT_29 = NL + "\tString xmlStr_";
  protected final String TEXT_30 = " = ";
  protected final String TEXT_31 = ";";
  protected final String TEXT_32 = NL + "\tString xmlStr_";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = "_xml;";
  protected final String TEXT_35 = NL + "\tString xmlStr_";
  protected final String TEXT_36 = " = null;" + NL + "\troutines.system.Document xmlDocument_";
  protected final String TEXT_37 = " = null;" + NL + "\tif(";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = "!=null){";
  protected final String TEXT_40 = NL + "\t\t\t\txmlDocument_";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ";";
  protected final String TEXT_44 = NL + "\t\t\t\txmlStr_";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = ";";
  protected final String TEXT_48 = NL + "\t}";
  protected final String TEXT_49 = NL + "\t\t\tif(xmlDocument_";
  protected final String TEXT_50 = "!=null && xmlDocument_";
  protected final String TEXT_51 = ".getDocument()!=null){// C_01";
  protected final String TEXT_52 = NL + "\t\t\tif(xmlStr_";
  protected final String TEXT_53 = "!=null){// C_01";
  protected final String TEXT_54 = NL;
  protected final String TEXT_55 = " = null;";
  protected final String TEXT_56 = NL + "\tNameSpaceTool_";
  protected final String TEXT_57 = " nsTool_";
  protected final String TEXT_58 = " = new NameSpaceTool_";
  protected final String TEXT_59 = "();" + NL + "    org.dom4j.io.SAXReader reader_";
  protected final String TEXT_60 = " = new org.dom4j.io.SAXReader();" + NL + "\t";
  protected final String TEXT_61 = NL + "\t\torg.dom4j.Document doc_tmp_";
  protected final String TEXT_62 = " = org.dom4j.DocumentHelper.createDocument();" + NL + "\t\tXML_ns_rmv_";
  protected final String TEXT_63 = ".removeNamespace(" + NL + "\t\t";
  protected final String TEXT_64 = NL + "\t\t\txmlDocument_";
  protected final String TEXT_65 = ".getDocument()" + NL + "\t\t";
  protected final String TEXT_66 = NL + "\t\t\treader_";
  protected final String TEXT_67 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_68 = "))" + NL + "\t\t";
  protected final String TEXT_69 = NL + "\t\t\t,doc_tmp_";
  protected final String TEXT_70 = NL + "\t\t);" + NL + "\t";
  protected final String TEXT_71 = NL + "    org.dom4j.Document doc_";
  protected final String TEXT_72 = " = null;" + NL + "    java.util.HashMap xmlNameSpaceMap_";
  protected final String TEXT_73 = " = null;" + NL + "    org.dom4j.XPath x_";
  protected final String TEXT_74 = " = null;" + NL + "    java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_75 = " = null;";
  protected final String TEXT_76 = NL + "\tString loopQuery_";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = "+";
  protected final String TEXT_79 = ";";
  protected final String TEXT_80 = NL + "    \tString loopQuery_";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ";" + NL + "\t";
  protected final String TEXT_83 = NL + "\t\tString loopQuery_";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = "; " + NL + "\t";
  protected final String TEXT_86 = NL + "    boolean isStructError_";
  protected final String TEXT_87 = "= true;" + NL + "        " + NL + "    try{" + NL + "\t\t";
  protected final String TEXT_88 = NL + "\t    \tdoc_";
  protected final String TEXT_89 = "= xmlDocument_";
  protected final String TEXT_90 = ".getDocument();" + NL + "\t    ";
  protected final String TEXT_91 = NL + "\t    \tdoc_";
  protected final String TEXT_92 = "= reader_";
  protected final String TEXT_93 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_94 = "));" + NL + "\t    ";
  protected final String TEXT_95 = NL + "\t\t\tdoc_";
  protected final String TEXT_96 = "= doc_tmp_";
  protected final String TEXT_97 = ";" + NL + "\t\t";
  protected final String TEXT_98 = NL + "\t    nsTool_";
  protected final String TEXT_99 = ".countNSMap(doc_";
  protected final String TEXT_100 = ".getRootElement());" + NL + "\t    xmlNameSpaceMap_";
  protected final String TEXT_101 = " = nsTool_";
  protected final String TEXT_102 = ".xmlNameSpaceMap;" + NL + "" + NL + "    \tx_";
  protected final String TEXT_103 = " = doc_";
  protected final String TEXT_104 = ".createXPath(nsTool_";
  protected final String TEXT_105 = ".addDefaultNSPrefix(loopQuery_";
  protected final String TEXT_106 = ",loopQuery_";
  protected final String TEXT_107 = "));" + NL + "      " + NL + "    \tx_";
  protected final String TEXT_108 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_109 = "); " + NL + "    " + NL + "\t\t";
  protected final String TEXT_110 = NL + "\t\t\tx_";
  protected final String TEXT_111 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_112 = ");" + NL + "\t\t";
  protected final String TEXT_113 = " " + NL + "    \tnodeList_";
  protected final String TEXT_114 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_115 = ".selectNodes(doc_";
  protected final String TEXT_116 = ");" + NL + "    \t" + NL + "    \tisStructError_";
  protected final String TEXT_117 = " = false;" + NL + "    \t" + NL + "    }catch(java.lang.Exception ex_";
  protected final String TEXT_118 = "){";
  protected final String TEXT_119 = NL + "\tthrow(ex_";
  protected final String TEXT_120 = ");";
  protected final String TEXT_121 = NL + "\t";
  protected final String TEXT_122 = " = new ";
  protected final String TEXT_123 = "Struct();";
  protected final String TEXT_124 = NL + "\t\t\txml_api_";
  protected final String TEXT_125 = ".putRejectValueBeforeExtract_";
  protected final String TEXT_126 = "(";
  protected final String TEXT_127 = ",";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "    ";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = " = ";
  protected final String TEXT_132 = ".";
  protected final String TEXT_133 = ";";
  protected final String TEXT_134 = NL + "\t";
  protected final String TEXT_135 = NL + "\t\t";
  protected final String TEXT_136 = ".errorXMLField = xmlDocument_";
  protected final String TEXT_137 = ".toString();";
  protected final String TEXT_138 = NL + "\t\t";
  protected final String TEXT_139 = ".errorXMLField = xmlStr_";
  protected final String TEXT_140 = ";";
  protected final String TEXT_141 = NL + "\t";
  protected final String TEXT_142 = ".errorMessage = ex_";
  protected final String TEXT_143 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_144 = ";";
  protected final String TEXT_145 = NL + "\tlog.error(\"";
  protected final String TEXT_146 = " - \" + ex_";
  protected final String TEXT_147 = ".getMessage());";
  protected final String TEXT_148 = NL + "    System.err.println(ex_";
  protected final String TEXT_149 = ".getMessage());";
  protected final String TEXT_150 = NL + "    }" + NL + "    " + NL + "    org.dom4j.Node node_";
  protected final String TEXT_151 = " = null;" + NL + "    String str_";
  protected final String TEXT_152 = " = \"\";" + NL + "    boolean resultIsNode_";
  protected final String TEXT_153 = " = true;" + NL + "    for(int i_";
  protected final String TEXT_154 = "=0; isStructError_";
  protected final String TEXT_155 = " || (nodeList_";
  protected final String TEXT_156 = "!=null && i_";
  protected final String TEXT_157 = " < nodeList_";
  protected final String TEXT_158 = ".size());i_";
  protected final String TEXT_159 = "++){" + NL + "    \t" + NL + "    \tif(!isStructError_";
  protected final String TEXT_160 = "){";
  protected final String TEXT_161 = NL + "\t\t\t";
  protected final String TEXT_162 = " = null;";
  protected final String TEXT_163 = NL + "    \t\t";
  protected final String TEXT_164 = " = new ";
  protected final String TEXT_165 = "Struct();" + NL + "    \t" + NL + "    \t\torg.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_166 = " = nodeList_";
  protected final String TEXT_167 = ".get(i_";
  protected final String TEXT_168 = ");" + NL + "\t" + NL + "\t    \tnb_line_";
  protected final String TEXT_169 = "++;\t";
  protected final String TEXT_170 = NL + "\t    \tif (nb_line_";
  protected final String TEXT_171 = ">";
  protected final String TEXT_172 = ") {" + NL + "\t    \t\tbreak;" + NL + "\t    \t}";
  protected final String TEXT_173 = NL + "\t\t\ttry{";
  protected final String TEXT_174 = NL + "\t\t\txml_api_";
  protected final String TEXT_175 = ".putUnExtractValue_";
  protected final String TEXT_176 = "(";
  protected final String TEXT_177 = ",";
  protected final String TEXT_178 = ");";
  protected final String TEXT_179 = NL + "\t\t\t";
  protected final String TEXT_180 = ".";
  protected final String TEXT_181 = " = ";
  protected final String TEXT_182 = ".";
  protected final String TEXT_183 = ";";
  protected final String TEXT_184 = NL + "\t\t\txml_api_";
  protected final String TEXT_185 = ".putExtractValue_";
  protected final String TEXT_186 = "(";
  protected final String TEXT_187 = ",";
  protected final String TEXT_188 = ",";
  protected final String TEXT_189 = "xmlStr_";
  protected final String TEXT_190 = ",temp_";
  protected final String TEXT_191 = ",nsTool_";
  protected final String TEXT_192 = ",loopQuery_";
  protected final String TEXT_193 = ",xmlNameSpaceMap_";
  protected final String TEXT_194 = ",node_";
  protected final String TEXT_195 = ",str_";
  protected final String TEXT_196 = ",xml_api_";
  protected final String TEXT_197 = ",namespaceContext_";
  protected final String TEXT_198 = ");";
  protected final String TEXT_199 = NL + "\t\t\t\torg.dom4j.XPath xTmp";
  protected final String TEXT_200 = "_";
  protected final String TEXT_201 = " = temp_";
  protected final String TEXT_202 = ".createXPath(nsTool_";
  protected final String TEXT_203 = ".addDefaultNSPrefix(";
  protected final String TEXT_204 = ",loopQuery_";
  protected final String TEXT_205 = "));" + NL + "\t\t\t    xTmp";
  protected final String TEXT_206 = "_";
  protected final String TEXT_207 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_208 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_209 = NL + "\t\t\t\t\txTmp";
  protected final String TEXT_210 = "_";
  protected final String TEXT_211 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_212 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_213 = NL + "\t\t\t    Object obj";
  protected final String TEXT_214 = "_";
  protected final String TEXT_215 = " = xTmp";
  protected final String TEXT_216 = "_";
  protected final String TEXT_217 = ".evaluate(temp_";
  protected final String TEXT_218 = ");" + NL + "\t\t\t    if(obj";
  protected final String TEXT_219 = "_";
  protected final String TEXT_220 = " instanceof String || obj";
  protected final String TEXT_221 = "_";
  protected final String TEXT_222 = " instanceof Number){" + NL + "\t\t\t    \tresultIsNode_";
  protected final String TEXT_223 = " = false;" + NL + "    \t\t\t\tstr_";
  protected final String TEXT_224 = " = String.valueOf(obj";
  protected final String TEXT_225 = "_";
  protected final String TEXT_226 = ");" + NL + "   \t\t\t\t}else{" + NL + "   \t\t\t\t\tresultIsNode_";
  protected final String TEXT_227 = " = true;" + NL + "\t\t\t\t    node_";
  protected final String TEXT_228 = " = xTmp";
  protected final String TEXT_229 = "_";
  protected final String TEXT_230 = ".selectSingleNode(temp_";
  protected final String TEXT_231 = ");";
  protected final String TEXT_232 = NL + "\t\t\t\t\tstr_";
  protected final String TEXT_233 = " = node_";
  protected final String TEXT_234 = "==null?null:node_";
  protected final String TEXT_235 = ".asXML();";
  protected final String TEXT_236 = NL + "\t\t\t\t    str_";
  protected final String TEXT_237 = " = xTmp";
  protected final String TEXT_238 = "_";
  protected final String TEXT_239 = ".valueOf(temp_";
  protected final String TEXT_240 = ");";
  protected final String TEXT_241 = NL + "\t\t\t\t}";
  protected final String TEXT_242 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_243 = ".";
  protected final String TEXT_244 = " = str_";
  protected final String TEXT_245 = ";";
  protected final String TEXT_246 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_247 = ".";
  protected final String TEXT_248 = " = ParserUtils.parseTo_Document(str_";
  protected final String TEXT_249 = ");";
  protected final String TEXT_250 = NL + "\t\t\t\t\t\t\t\t\tif(resultIsNode_";
  protected final String TEXT_251 = " && xml_api_";
  protected final String TEXT_252 = ".isDefNull(node_";
  protected final String TEXT_253 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_254 = ".";
  protected final String TEXT_255 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t}else if(resultIsNode_";
  protected final String TEXT_256 = " && xml_api_";
  protected final String TEXT_257 = ".isEmpty(node_";
  protected final String TEXT_258 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_259 = ".";
  protected final String TEXT_260 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(resultIsNode_";
  protected final String TEXT_261 = " && xml_api_";
  protected final String TEXT_262 = ".isMissing(node_";
  protected final String TEXT_263 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_264 = ".";
  protected final String TEXT_265 = " =";
  protected final String TEXT_266 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_267 = NL + "\t\t\t\t\t\t\t\t\tif(resultIsNode_";
  protected final String TEXT_268 = " && xml_api_";
  protected final String TEXT_269 = ".isEmpty(node_";
  protected final String TEXT_270 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_271 = ".";
  protected final String TEXT_272 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(resultIsNode_";
  protected final String TEXT_273 = " && xml_api_";
  protected final String TEXT_274 = ".isMissing(node_";
  protected final String TEXT_275 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_276 = ".";
  protected final String TEXT_277 = " =";
  protected final String TEXT_278 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_279 = "\t" + NL + "\t\t\t\t\t\t\t\t\t\tif(resultIsNode_";
  protected final String TEXT_280 = " && xml_api_";
  protected final String TEXT_281 = ".isDefNull(node_";
  protected final String TEXT_282 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_283 = ".";
  protected final String TEXT_284 = " =null;" + NL + "\t\t\t\t\t\t\t\t\t\t}else if(resultIsNode_";
  protected final String TEXT_285 = " && (xml_api_";
  protected final String TEXT_286 = ".isEmpty(node_";
  protected final String TEXT_287 = ") || xml_api_";
  protected final String TEXT_288 = ".isMissing(node_";
  protected final String TEXT_289 = "))){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_290 = ".";
  protected final String TEXT_291 = "=";
  protected final String TEXT_292 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_293 = NL + "\t\t\t\t\t\t\t\t\t\tif(resultIsNode_";
  protected final String TEXT_294 = " && (xml_api_";
  protected final String TEXT_295 = ".isMissing(node_";
  protected final String TEXT_296 = ") || xml_api_";
  protected final String TEXT_297 = ".isEmpty(node_";
  protected final String TEXT_298 = "))){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_299 = ".";
  protected final String TEXT_300 = " =";
  protected final String TEXT_301 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_302 = NL + "\t\t\t\t";
  protected final String TEXT_303 = ".";
  protected final String TEXT_304 = " = str_";
  protected final String TEXT_305 = ";";
  protected final String TEXT_306 = NL + "\t\t\t\t";
  protected final String TEXT_307 = ".";
  protected final String TEXT_308 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_309 = ", ";
  protected final String TEXT_310 = ");";
  protected final String TEXT_311 = NL + "\t\t\t\t";
  protected final String TEXT_312 = ".";
  protected final String TEXT_313 = " = ParserUtils.parseTo_";
  protected final String TEXT_314 = "(str_";
  protected final String TEXT_315 = ");";
  protected final String TEXT_316 = NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_317 = NL + "\t";
  protected final String TEXT_318 = " = null;";
  protected final String TEXT_319 = NL + "}catch(java.lang.Exception ex_";
  protected final String TEXT_320 = "){";
  protected final String TEXT_321 = NL + "\tthrow(ex_";
  protected final String TEXT_322 = ");";
  protected final String TEXT_323 = NL + "\t";
  protected final String TEXT_324 = " = new ";
  protected final String TEXT_325 = "Struct();";
  protected final String TEXT_326 = NL + "\t\t\txml_api_";
  protected final String TEXT_327 = ".putRejectValueAfterExtract_";
  protected final String TEXT_328 = "(";
  protected final String TEXT_329 = ",";
  protected final String TEXT_330 = ");";
  protected final String TEXT_331 = NL + "     ";
  protected final String TEXT_332 = ".";
  protected final String TEXT_333 = " = ";
  protected final String TEXT_334 = ".";
  protected final String TEXT_335 = ";";
  protected final String TEXT_336 = NL + "\t\t\t\t";
  protected final String TEXT_337 = ".errorXMLField = xmlDocument_";
  protected final String TEXT_338 = ".toString();";
  protected final String TEXT_339 = NL + "\t\t\t\t";
  protected final String TEXT_340 = ".errorXMLField = xmlStr_";
  protected final String TEXT_341 = ";";
  protected final String TEXT_342 = NL + "\t";
  protected final String TEXT_343 = ".errorMessage = ex_";
  protected final String TEXT_344 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_345 = ";" + NL + "\t";
  protected final String TEXT_346 = " = null;";
  protected final String TEXT_347 = NL + "\tlog.error(\"";
  protected final String TEXT_348 = " - \" + ex_";
  protected final String TEXT_349 = ".getMessage());";
  protected final String TEXT_350 = NL + "    System.err.println(ex_";
  protected final String TEXT_351 = ".getMessage());";
  protected final String TEXT_352 = NL + "    ";
  protected final String TEXT_353 = " = null;";
  protected final String TEXT_354 = NL + "\t\t\t\t";
  protected final String TEXT_355 = ".errorXMLField = xmlDocument_";
  protected final String TEXT_356 = ".toString();";
  protected final String TEXT_357 = NL + "\t\t\t\t";
  protected final String TEXT_358 = ".errorXMLField = xmlStr_";
  protected final String TEXT_359 = ";";
  protected final String TEXT_360 = NL + "\t";
  protected final String TEXT_361 = ".errorMessage = ex_";
  protected final String TEXT_362 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_363 = ";";
  protected final String TEXT_364 = NL + "    \t}" + NL + "    }" + NL + "    " + NL + "    isStructError_";
  protected final String TEXT_365 = " = false;" + NL;
  protected final String TEXT_366 = NL + NL + "   globalMap.put(\"";
  protected final String TEXT_367 = "_NB_LINE\", nb_line_";
  protected final String TEXT_368 = ");";
  protected final String TEXT_369 = NL;

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
	
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
String xmlField = ElementParameterParser.getValue(node, "__XMLFIELD__");

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
boolean ignore_NS_Str = ("true").equals(ElementParameterParser.getValue(node, "__IGNORE_NS__"));

final boolean isLog4jEnabled = "true".equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

String strXMLField = ElementParameterParser.getValue(node, "__USE_XML_FIELD__");
boolean useXMLField = (strXMLField!=null&&!("").equals(strXMLField))?("true").equals(strXMLField):false;
String strXMLText = ElementParameterParser.getValue(node, "__XML_TEXT__");
String strXMLPrefix = ElementParameterParser.getValue(node, "__XML_PREFIX__");
if(("TRIGGER_ITEM").equals(strXMLPrefix)){
	strXMLPrefix = "\"/exchange/item\"";
}else if(("PROCESS_ITEM").equals(strXMLPrefix)){
	strXMLPrefix = "\"/item\"";
}else if(("NONE_ITEM").equals(strXMLPrefix)){
	strXMLPrefix = "\"\"";
}

List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__"); 
String limit = ElementParameterParser.getValue(node, "__LIMIT__");
if (("").equals(limit)) {
	limit = "-1";
}
int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

//get XML field content
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

boolean isDocumentType = false;

if(useXMLField){

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(strXMLText );
    stringBuffer.append(TEXT_31);
    
}else if (inConns!=null) {
	if (inConn!=null) {
		if(("tMDMReadConf").equals(inConn.getSource().getComponent().getName())){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_34);
    
		}else{
			for (IMetadataColumn inputCol : inColumns) {
				if(inputCol.getLabel().equals(xmlField))
				{

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(xmlField);
    stringBuffer.append(TEXT_39);
    
			if("id_Document".equals(inputCol.getTalendType())) {
				isDocumentType = true;

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(xmlField);
    stringBuffer.append(TEXT_43);
    
			} else {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(xmlField);
    stringBuffer.append(TEXT_47);
    
			}

    stringBuffer.append(TEXT_48);
    
					break;
				}
			}
		}
		
		if(isDocumentType) {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
		} else {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
		}
		
		List<BlockCode> blockCodes = new java.util.ArrayList<BlockCode>(1);
		blockCodes.add(new BlockCode("C_01"));
		((org.talend.core.model.process.AbstractNode) node).setBlocksCodeToClose(blockCodes);
	}
}

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

if(outConns!=null){
    for (IConnection conn : outConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_54);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_55);
    
    	}
    }
}

if (outConn!=null) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    if(ignore_NS_Str){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    if(isDocumentType) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    } else {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    if(useXMLField){
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(strXMLPrefix );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(loopQuery );
    stringBuffer.append(TEXT_79);
    }else{
	//useItems & loopQueryBase are only for tMDMInput
	String strUseItems = ElementParameterParser.getValue(node, "__USE_ITEMS__");
	boolean useItems = (strUseItems!=null&&!("").equals(strUseItems))?("true").equals(strUseItems):false;
	if(useItems){
		String loopQueryBase = ElementParameterParser.getValue(node, "__LOOP_QUERY_BASE__"); 
		
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append("\"\"".equals(loopQueryBase)?"":loopQueryBase+"+");
    stringBuffer.append(loopQuery );
    stringBuffer.append(TEXT_82);
    
	}else{
	
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(loopQuery );
    stringBuffer.append(TEXT_85);
    
	}
}
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    if(!ignore_NS_Str){
			if(isDocumentType) {
		
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
	    	} else {
	    
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
	    	}
	    }else{
	    
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    
		}
		
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    if(ignore_NS_Str){
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    
	if(dieOnError){

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    
	}else{
		if(!("").equals(rejectConnName) && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_123);
    
			if(inConn!=null){
				int columnNo=0;
		 		for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
	    	  		if(!xmlField.equals(column.getLabel())){
	    	  			for(IMetadataColumn inColumn : inConn.getMetadataTable().getListColumns()){
	    	  				if(inColumn.getLabel().equals(column.getLabel())){
	    	  					if(schemaOptNum < mapping.size()){
	    	  						if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_128);
    
		 							}
		 							columnNo++;
	    	  					}else{

    stringBuffer.append(TEXT_129);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_133);
    
								}
								break;
	    					}
	    				}
	    			}
	    	    }
	    	}

    stringBuffer.append(TEXT_134);
    
	if(isDocumentType) {

    stringBuffer.append(TEXT_135);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
	} else {

    stringBuffer.append(TEXT_138);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
	}

    stringBuffer.append(TEXT_141);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_144);
    
		} else if(("").equals(rejectConnName)){
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    
			}

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    
		}
	}

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    
if(outConns!=null){
    for (IConnection conn : outConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_161);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_162);
    
    	}
    }
}

    stringBuffer.append(TEXT_163);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
		log4jFileUtil.logCurrentRowNumberInfo();
		
		if (limit.compareTo("-1")!=0) {

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(Integer.parseInt(limit));
    stringBuffer.append(TEXT_172);
    
		}

    stringBuffer.append(TEXT_173);
    
		if(inConn!=null){
			int unExtractColNo=0;
			for (int i=0;i<mapping.size();i++) {
				if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
					String query = mapping.get(i).get("QUERY");
					if(query==null || query.trim().length() < 1 ){
						for(IMetadataColumn inColumn:inColumns) {
							if (inColumn.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
								if(schemaOptNum < mapping.size()){
									if(unExtractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(unExtractColNo/schemaOptNum);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_178);
    
									}
									unExtractColNo++;
								}else{

    stringBuffer.append(TEXT_179);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_183);
    
								}
								break;
							}
						}
					}
				}
			}
		}
		//get the mapping column 
		int extractColNo=0;
		for (int i=0;i<mapping.size();i++) {  //for S_0
			String query = mapping.get(i).get("QUERY");
			String nodeCheck = mapping.get(i).get("NODECHECK");
			if(schemaOptNum < mapping.size()){
				if(query!=null && query.trim().length()>0){  // if S_0_0
					if(extractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(extractColNo/schemaOptNum);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_187);
    if(inConn!=null){
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_188);
    }
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    if(ignore_NS_Str){
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_198);
    
					}
					extractColNo++;
				}
			}else{
			  if(query!=null && query.trim().length()>0){  // if S_0_0

    stringBuffer.append(TEXT_199);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    if(ignore_NS_Str){
    stringBuffer.append(TEXT_209);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    }
    stringBuffer.append(TEXT_213);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    
					if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    
					}else{

    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    
					}

    stringBuffer.append(TEXT_241);
    
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

    stringBuffer.append(TEXT_242);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    
								} else {

    stringBuffer.append(TEXT_246);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    
								}
	            				continue;
	            			}
							if(javaType == JavaTypesManager.STRING){
								if(column.isNullable()){

    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_266);
    
								}else{ // column.isNullable()

    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_278);
    
								}
							}else{ // other type
								if(column.isNullable()){

    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_292);
    
								}else{ // column.isNullable()

    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_301);
    
								}
							}
									
							if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_302);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_304);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_305);
    
							} else {
								if (javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_306);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_308);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_310);
    
								} else {

    stringBuffer.append(TEXT_311);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_313);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_314);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_315);
    
								}
							}

    stringBuffer.append(TEXT_316);
    
							break;
	        			} // if S_0_0_0_0_1
					} // if S_0_0_0_1
				} // for S_0_0_1
			  }// if S_0_1
			}
		} // for S_1
		if(!("").equals(rejectConnName) && rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_317);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_318);
    
		}

    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    
	if(dieOnError){

    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    
	}else{
		if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_323);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_325);
    
			int columnNo=0;
    	 	for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
    	 		if(schemaOptNum < mapping.size()){
	    	  		if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_330);
    
		 			}
		 			columnNo++;
	    	  	}else{

    stringBuffer.append(TEXT_331);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_333);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_335);
    
				}
    	    }
    	    
			if(isDocumentType) {

    stringBuffer.append(TEXT_336);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    
			} else {

    stringBuffer.append(TEXT_339);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    
			}

    stringBuffer.append(TEXT_342);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_346);
    
		} else if(("").equals(rejectConnName)){
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    
			}

    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_353);
    
		} else if(rejectConnName.equals(firstConnName)){
			if(isDocumentType) {

    stringBuffer.append(TEXT_354);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    
			} else {

    stringBuffer.append(TEXT_357);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    
			}

    stringBuffer.append(TEXT_360);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_363);
    
		}
	}

    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    
}

    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(TEXT_369);
    return stringBuffer.toString();
  }
}
