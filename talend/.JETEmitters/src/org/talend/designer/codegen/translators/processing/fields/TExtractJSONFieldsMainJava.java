package org.talend.designer.codegen.translators.processing.fields;

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

public class TExtractJSONFieldsMainJava
{
  protected static String nl;
  public static synchronized TExtractJSONFieldsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractJSONFieldsMainJava result = new TExtractJSONFieldsMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "            if(";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "!=null){// C_01" + NL + "                jsonStr_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ".toString();";
  protected final String TEXT_8 = NL + "   ";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = " = null;";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + "\t";
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = NL + "    org.dom4j.io.SAXReader reader_";
  protected final String TEXT_15 = " = new org.dom4j.io.SAXReader();" + NL + "    org.dom4j.Document doc_";
  protected final String TEXT_16 = " = null;" + NL + "    java.util.HashMap xmlNameSpaceMap_";
  protected final String TEXT_17 = " = new java.util.HashMap<String, String>();" + NL + "    org.dom4j.XPath x_";
  protected final String TEXT_18 = " = null;" + NL + "    java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_19 = " = null;" + NL + "    boolean isStructError_";
  protected final String TEXT_20 = " = true;" + NL + "" + NL + "    String loopQuery_";
  protected final String TEXT_21 = " =  ";
  protected final String TEXT_22 = " ;" + NL + "    String oraginalJsonStr_";
  protected final String TEXT_23 = " = jsonStr_";
  protected final String TEXT_24 = ";" + NL + "    cjs_";
  protected final String TEXT_25 = ".setJsonString(jsonStr_";
  protected final String TEXT_26 = ");" + NL + "    cjs_";
  protected final String TEXT_27 = ".setLoopString(loopQuery_";
  protected final String TEXT_28 = ");" + NL + "    java.io.ByteArrayInputStream bais_";
  protected final String TEXT_29 = " = null;" + NL + "    java.io.ByteArrayOutputStream  baos_";
  protected final String TEXT_30 = " = new java.io.ByteArrayOutputStream();" + NL + "    try {" + NL + "        cjs_";
  protected final String TEXT_31 = ".generate();" + NL + "        jsonStr_";
  protected final String TEXT_32 = " = cjs_";
  protected final String TEXT_33 = ".getJsonString4XML();" + NL + "        loopQuery_";
  protected final String TEXT_34 = " = cjs_";
  protected final String TEXT_35 = ".getLoopString4XML();" + NL + "        bais_";
  protected final String TEXT_36 = " = new ByteArrayInputStream(jsonStr_";
  protected final String TEXT_37 = ".getBytes(";
  protected final String TEXT_38 = "));" + NL + "        javax.xml.stream.XMLEventReader xmlEventReader_";
  protected final String TEXT_39 = " = jsonXMLInputFactory_";
  protected final String TEXT_40 = ".createXMLEventReader(bais_";
  protected final String TEXT_41 = ");" + NL + "        javax.xml.stream.XMLEventWriter xmLEventWriter_";
  protected final String TEXT_42 = " = xmlOutputFactory_";
  protected final String TEXT_43 = ".createXMLEventWriter(baos_";
  protected final String TEXT_44 = ",";
  protected final String TEXT_45 = ");" + NL + "        xmLEventWriter_";
  protected final String TEXT_46 = ".add(xmlEventReader_";
  protected final String TEXT_47 = ");" + NL + "        //convert json string to xml" + NL + "        xmlStr_";
  protected final String TEXT_48 = " = baos_";
  protected final String TEXT_49 = ".toString();  " + NL + "        xmLEventWriter_";
  protected final String TEXT_50 = ".close();" + NL + "        xmlEventReader_";
  protected final String TEXT_51 = ".close();" + NL + "    " + NL + "        doc_";
  protected final String TEXT_52 = "= reader_";
  protected final String TEXT_53 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_54 = "));" + NL + "        x_";
  protected final String TEXT_55 = " = doc_";
  protected final String TEXT_56 = ".createXPath(loopQuery_";
  protected final String TEXT_57 = ");" + NL + "        x_";
  protected final String TEXT_58 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_59 = "); " + NL + "        nodeList_";
  protected final String TEXT_60 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_61 = ".selectNodes(doc_";
  protected final String TEXT_62 = ");" + NL + "        isStructError_";
  protected final String TEXT_63 = " = false;" + NL + "        " + NL + "    }catch(java.lang.Exception ex_";
  protected final String TEXT_64 = "){";
  protected final String TEXT_65 = NL + "        throw(ex_";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_68 = " - \" + ex_";
  protected final String TEXT_69 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_70 = NL + "    ";
  protected final String TEXT_71 = " = new ";
  protected final String TEXT_72 = "Struct();";
  protected final String TEXT_73 = NL + "            xml_api_";
  protected final String TEXT_74 = ".putRejectValueBeforeExtract_";
  protected final String TEXT_75 = "(";
  protected final String TEXT_76 = ",";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = NL + "    ";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = " = ";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = ";";
  protected final String TEXT_83 = NL + "    ";
  protected final String TEXT_84 = ".errorJSONField = oraginalJsonStr_";
  protected final String TEXT_85 = ";";
  protected final String TEXT_86 = NL + "    ";
  protected final String TEXT_87 = ".errorMessage = ex_";
  protected final String TEXT_88 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_89 = ";";
  protected final String TEXT_90 = NL + "    System.err.println(ex_";
  protected final String TEXT_91 = ".getMessage());";
  protected final String TEXT_92 = NL + "    }finally {" + NL + "        baos_";
  protected final String TEXT_93 = ".close();" + NL + "        if(bais_";
  protected final String TEXT_94 = "!=null){" + NL + "            bais_";
  protected final String TEXT_95 = ".close();" + NL + "        }" + NL + "    }" + NL + "    " + NL + "    org.dom4j.Node node_";
  protected final String TEXT_96 = " = null;" + NL + "    String str_";
  protected final String TEXT_97 = " = \"\";" + NL + "    for(int i_";
  protected final String TEXT_98 = "=0; isStructError_";
  protected final String TEXT_99 = " || (nodeList_";
  protected final String TEXT_100 = "!=null && i_";
  protected final String TEXT_101 = " < nodeList_";
  protected final String TEXT_102 = ".size());i_";
  protected final String TEXT_103 = "++){" + NL + "        " + NL + "        if(!isStructError_";
  protected final String TEXT_104 = "){";
  protected final String TEXT_105 = NL + "            ";
  protected final String TEXT_106 = " = null;";
  protected final String TEXT_107 = NL + "            ";
  protected final String TEXT_108 = " = new ";
  protected final String TEXT_109 = "Struct();" + NL + "        " + NL + "            org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_110 = " = nodeList_";
  protected final String TEXT_111 = ".get(i_";
  protected final String TEXT_112 = ");" + NL + "    " + NL + "            nb_line_";
  protected final String TEXT_113 = "++; " + NL + "            try{";
  protected final String TEXT_114 = NL + "            xml_api_";
  protected final String TEXT_115 = ".putUnExtractValue_";
  protected final String TEXT_116 = "(";
  protected final String TEXT_117 = ",";
  protected final String TEXT_118 = ");";
  protected final String TEXT_119 = NL + "            ";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = " = ";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = ";";
  protected final String TEXT_124 = NL + "            xml_api_";
  protected final String TEXT_125 = ".putExtractValue_";
  protected final String TEXT_126 = "(";
  protected final String TEXT_127 = ",";
  protected final String TEXT_128 = ",";
  protected final String TEXT_129 = "xmlStr_";
  protected final String TEXT_130 = ",temp_";
  protected final String TEXT_131 = ",loopQuery_";
  protected final String TEXT_132 = ",xmlNameSpaceMap_";
  protected final String TEXT_133 = ",node_";
  protected final String TEXT_134 = ",str_";
  protected final String TEXT_135 = ",xml_api_";
  protected final String TEXT_136 = ",originalJSONString_";
  protected final String TEXT_137 = ",cjs_";
  protected final String TEXT_138 = ",isGetWholeJson_";
  protected final String TEXT_139 = ");";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\tisGetWholeJson_";
  protected final String TEXT_141 = "  = true;";
  protected final String TEXT_142 = NL + "                org.dom4j.XPath xTmp";
  protected final String TEXT_143 = "_";
  protected final String TEXT_144 = " = temp_";
  protected final String TEXT_145 = ".createXPath(";
  protected final String TEXT_146 = ");" + NL + "                xTmp";
  protected final String TEXT_147 = "_";
  protected final String TEXT_148 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_149 = ");";
  protected final String TEXT_150 = NL + "\t                Object obj";
  protected final String TEXT_151 = "_";
  protected final String TEXT_152 = " = xTmp";
  protected final String TEXT_153 = "_";
  protected final String TEXT_154 = ".evaluate(temp_";
  protected final String TEXT_155 = ");" + NL + "\t                if(obj";
  protected final String TEXT_156 = "_";
  protected final String TEXT_157 = " instanceof String || obj";
  protected final String TEXT_158 = "_";
  protected final String TEXT_159 = " instanceof Number){" + NL + "\t                    node_";
  protected final String TEXT_160 = " = temp_";
  protected final String TEXT_161 = ";" + NL + "\t                    str_";
  protected final String TEXT_162 = " = String.valueOf(obj";
  protected final String TEXT_163 = "_";
  protected final String TEXT_164 = ");" + NL + "\t                }else{" + NL + "                    \tnode_";
  protected final String TEXT_165 = " = xTmp";
  protected final String TEXT_166 = "_";
  protected final String TEXT_167 = ".selectSingleNode(temp_";
  protected final String TEXT_168 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\t\t\tif(node_";
  protected final String TEXT_170 = "==null){" + NL + "\t\t\t\t\t\t\t\tstr_";
  protected final String TEXT_171 = " = null;" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tstr_";
  protected final String TEXT_172 = " = originalJSONString_";
  protected final String TEXT_173 = ".getOriginalJSONString(node_";
  protected final String TEXT_174 = ".asXML(),cjs_";
  protected final String TEXT_175 = ".getAdditionRoot(),";
  protected final String TEXT_176 = ",isGetWholeJson_";
  protected final String TEXT_177 = ");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tisGetWholeJson_";
  protected final String TEXT_178 = " = false;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_179 = NL + "\t                        str_";
  protected final String TEXT_180 = " = xTmp";
  protected final String TEXT_181 = "_";
  protected final String TEXT_182 = ".valueOf(temp_";
  protected final String TEXT_183 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_184 = NL + "\t                }" + NL + "\t\t\t\t";
  protected final String TEXT_185 = NL + "\t\t\t\t\t\tString xmlStrTemp";
  protected final String TEXT_186 = "_";
  protected final String TEXT_187 = " = \"\";" + NL + "\t\t\t\t\t\tfor(Object tempNode_";
  protected final String TEXT_188 = " : xTmp";
  protected final String TEXT_189 = "_";
  protected final String TEXT_190 = ".selectNodes(temp_";
  protected final String TEXT_191 = ")){" + NL + "\t\t\t\t\t\t\tnode_";
  protected final String TEXT_192 = " = (org.dom4j.Node)tempNode_";
  protected final String TEXT_193 = ";" + NL + "\t\t\t\t\t\t\txmlStrTemp";
  protected final String TEXT_194 = "_";
  protected final String TEXT_195 = " += node_";
  protected final String TEXT_196 = ".asXML();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(\"\".equals(xmlStrTemp";
  protected final String TEXT_197 = "_";
  protected final String TEXT_198 = ")){" + NL + "\t\t\t\t\t\t\tstr_";
  protected final String TEXT_199 = " = null;" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tstr_";
  protected final String TEXT_200 = " = originalJSONString_";
  protected final String TEXT_201 = ".getOriginalJSONString(xmlStrTemp";
  protected final String TEXT_202 = "_";
  protected final String TEXT_203 = ",cjs_";
  protected final String TEXT_204 = ".getAdditionRoot(),";
  protected final String TEXT_205 = ",isGetWholeJson_";
  protected final String TEXT_206 = ", true);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tisGetWholeJson_";
  protected final String TEXT_207 = " = false;" + NL + "                \t";
  protected final String TEXT_208 = NL + "\t\t\t\t\t\tjava.util.List<String> xmlListTemp";
  protected final String TEXT_209 = "_";
  protected final String TEXT_210 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\t\tfor(Object tempNode_";
  protected final String TEXT_211 = " : xTmp";
  protected final String TEXT_212 = "_";
  protected final String TEXT_213 = ".selectNodes(temp_";
  protected final String TEXT_214 = ")){" + NL + "\t\t\t\t\t\t\txmlListTemp";
  protected final String TEXT_215 = "_";
  protected final String TEXT_216 = ".add(((org.dom4j.Node)tempNode_";
  protected final String TEXT_217 = ").getStringValue());" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_218 = NL + "                                ";
  protected final String TEXT_219 = ".";
  protected final String TEXT_220 = " = str_";
  protected final String TEXT_221 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_222 = NL + "\t                                    if(xml_api_";
  protected final String TEXT_223 = ".isDefNull(node_";
  protected final String TEXT_224 = ")){" + NL + "\t                                        ";
  protected final String TEXT_225 = ".";
  protected final String TEXT_226 = " = null;" + NL + "\t                                    }else if(xml_api_";
  protected final String TEXT_227 = ".isEmpty(node_";
  protected final String TEXT_228 = ")){" + NL + "\t                                        ";
  protected final String TEXT_229 = ".";
  protected final String TEXT_230 = " = \"\";" + NL + "\t                                    }else if(xml_api_";
  protected final String TEXT_231 = ".isMissing(node_";
  protected final String TEXT_232 = " )){ " + NL + "\t                                        ";
  protected final String TEXT_233 = ".";
  protected final String TEXT_234 = " = ";
  protected final String TEXT_235 = ";" + NL + "\t                                    }else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_236 = NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_237 = ".isEmpty(node_";
  protected final String TEXT_238 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_239 = ".";
  protected final String TEXT_240 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_241 = ".isMissing(node_";
  protected final String TEXT_242 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_243 = ".";
  protected final String TEXT_244 = " =";
  protected final String TEXT_245 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_246 = "  " + NL + "\t                                \tif(xml_api_";
  protected final String TEXT_247 = ".isDefNull(node_";
  protected final String TEXT_248 = ")){" + NL + "\t                                    \t";
  protected final String TEXT_249 = ".";
  protected final String TEXT_250 = " = null;" + NL + "\t                                \t}else if(xml_api_";
  protected final String TEXT_251 = ".isEmpty(node_";
  protected final String TEXT_252 = ") || xml_api_";
  protected final String TEXT_253 = ".isMissing(node_";
  protected final String TEXT_254 = ")){" + NL + "\t                                    \t";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = " = ";
  protected final String TEXT_257 = ";" + NL + "\t                                \t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_258 = NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_259 = ".isMissing(node_";
  protected final String TEXT_260 = ") || xml_api_";
  protected final String TEXT_261 = ".isEmpty(node_";
  protected final String TEXT_262 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_263 = ".";
  protected final String TEXT_264 = " =";
  protected final String TEXT_265 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_266 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_267 = ".";
  protected final String TEXT_268 = " = str_";
  protected final String TEXT_269 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_270 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_271 = ".";
  protected final String TEXT_272 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_273 = ", ";
  protected final String TEXT_274 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_275 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_276 = ".";
  protected final String TEXT_277 = " = ParserUtils.parseTo_";
  protected final String TEXT_278 = "(str_";
  protected final String TEXT_279 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_280 = NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_281 = NL + "\t\t\t\t\t\t\t\tif(xmlListTemp";
  protected final String TEXT_282 = "_";
  protected final String TEXT_283 = ".isEmpty()){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_284 = ".";
  protected final String TEXT_285 = " = null;\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_286 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_287 = ".";
  protected final String TEXT_288 = " = xmlListTemp";
  protected final String TEXT_289 = "_";
  protected final String TEXT_290 = ".toString();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_291 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_292 = ".";
  protected final String TEXT_293 = " = xmlListTemp";
  protected final String TEXT_294 = "_";
  protected final String TEXT_295 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_296 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_297 = NL + "    ";
  protected final String TEXT_298 = " = null;";
  protected final String TEXT_299 = NL + "}catch(java.lang.Exception ex_";
  protected final String TEXT_300 = "){";
  protected final String TEXT_301 = NL + "    throw(ex_";
  protected final String TEXT_302 = ");";
  protected final String TEXT_303 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_304 = " - \" + ex_";
  protected final String TEXT_305 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_306 = NL + "    ";
  protected final String TEXT_307 = " = new ";
  protected final String TEXT_308 = "Struct();";
  protected final String TEXT_309 = NL + "            xml_api_";
  protected final String TEXT_310 = ".putRejectValueAfterExtract_";
  protected final String TEXT_311 = "(";
  protected final String TEXT_312 = ",";
  protected final String TEXT_313 = ");";
  protected final String TEXT_314 = NL + "     ";
  protected final String TEXT_315 = ".";
  protected final String TEXT_316 = " = ";
  protected final String TEXT_317 = ".";
  protected final String TEXT_318 = ";";
  protected final String TEXT_319 = NL + "    ";
  protected final String TEXT_320 = ".errorJSONField = oraginalJsonStr_";
  protected final String TEXT_321 = ";";
  protected final String TEXT_322 = NL + "    ";
  protected final String TEXT_323 = ".errorMessage = ex_";
  protected final String TEXT_324 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_325 = ";";
  protected final String TEXT_326 = NL + "    ";
  protected final String TEXT_327 = " = null;";
  protected final String TEXT_328 = NL + "    System.err.println(ex_";
  protected final String TEXT_329 = ".getMessage());";
  protected final String TEXT_330 = NL + "    ";
  protected final String TEXT_331 = " = null;";
  protected final String TEXT_332 = NL + "    ";
  protected final String TEXT_333 = ".errorJSONField = oraginalJsonStr_";
  protected final String TEXT_334 = ";";
  protected final String TEXT_335 = NL + "    ";
  protected final String TEXT_336 = ".errorMessage = ex_";
  protected final String TEXT_337 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_338 = ";";
  protected final String TEXT_339 = NL + "        }" + NL + "    }" + NL + "    " + NL + "    isStructError_";
  protected final String TEXT_340 = " = false;" + NL;
  protected final String TEXT_341 = NL;
  protected final String TEXT_342 = NL + "\tlog.debug(\"";
  protected final String TEXT_343 = " - Extracting the record \" + nb_line_";
  protected final String TEXT_344 = " + \".\");";
  protected final String TEXT_345 = " ";
  protected final String TEXT_346 = NL + "\t";
  protected final String TEXT_347 = NL;
  protected final String TEXT_348 = NL + NL + "String loopPath_";
  protected final String TEXT_349 = " = ";
  protected final String TEXT_350 = ";" + NL + "java.util.List<Object> resultset_";
  protected final String TEXT_351 = " = new java.util.ArrayList<Object>();" + NL + "" + NL + "boolean isStructError_";
  protected final String TEXT_352 = " = true;" + NL + "try {" + NL + "\tcom.jayway.jsonpath.ReadContext document_";
  protected final String TEXT_353 = " = com.jayway.jsonpath.JsonPath.parse(jsonStr_";
  protected final String TEXT_354 = ");" + NL + "\tcom.jayway.jsonpath.JsonPath compiledLoopPath_";
  protected final String TEXT_355 = " = jsonPathCache_";
  protected final String TEXT_356 = ".getCompiledJsonPath(loopPath_";
  protected final String TEXT_357 = ");" + NL + "\tObject result_";
  protected final String TEXT_358 = " = document_";
  protected final String TEXT_359 = ".read(compiledLoopPath_";
  protected final String TEXT_360 = ",net.minidev.json.JSONObject.class);" + NL + "\tif (result_";
  protected final String TEXT_361 = " instanceof net.minidev.json.JSONArray) {" + NL + "\t\tresultset_";
  protected final String TEXT_362 = " = (net.minidev.json.JSONArray) result_";
  protected final String TEXT_363 = ";" + NL + "\t} else {" + NL + "\t\tresultset_";
  protected final String TEXT_364 = ".add(result_";
  protected final String TEXT_365 = ");" + NL + "\t}" + NL + "\t" + NL + "\tisStructError_";
  protected final String TEXT_366 = " = false;" + NL + "} catch (java.lang.Exception ex_";
  protected final String TEXT_367 = ") {";
  protected final String TEXT_368 = NL + "\tthrow(ex_";
  protected final String TEXT_369 = ");";
  protected final String TEXT_370 = NL + "    \t";
  protected final String TEXT_371 = " = new ";
  protected final String TEXT_372 = "Struct();" + NL + "\t    ";
  protected final String TEXT_373 = ".errorJSONField = jsonStr_";
  protected final String TEXT_374 = ";" + NL + "    \t";
  protected final String TEXT_375 = ".errorMessage = ex_";
  protected final String TEXT_376 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_377 = ";";
  protected final String TEXT_378 = NL + "\t\t";
  protected final String TEXT_379 = ".";
  protected final String TEXT_380 = " = ";
  protected final String TEXT_381 = ".";
  protected final String TEXT_382 = ";";
  protected final String TEXT_383 = NL + "\t\tlog.error(\"";
  protected final String TEXT_384 = " - \" + ex_";
  protected final String TEXT_385 = ".getMessage());";
  protected final String TEXT_386 = NL + "\t\tSystem.err.println(ex_";
  protected final String TEXT_387 = ".getMessage());";
  protected final String TEXT_388 = NL + "}" + NL + "" + NL + "String jsonPath_";
  protected final String TEXT_389 = " = null;" + NL + "com.jayway.jsonpath.JsonPath compiledJsonPath_";
  protected final String TEXT_390 = " = null;" + NL + "" + NL + "Object value_";
  protected final String TEXT_391 = " = null;" + NL + "" + NL + "for(int i_";
  protected final String TEXT_392 = "=0; isStructError_";
  protected final String TEXT_393 = " || (i_";
  protected final String TEXT_394 = " < resultset_";
  protected final String TEXT_395 = ".size());i_";
  protected final String TEXT_396 = "++){" + NL + "\tif(!isStructError_";
  protected final String TEXT_397 = "){" + NL + "\t\tObject row_";
  protected final String TEXT_398 = " = resultset_";
  protected final String TEXT_399 = ".get(i_";
  protected final String TEXT_400 = ");";
  protected final String TEXT_401 = NL + "            ";
  protected final String TEXT_402 = " = null;";
  protected final String TEXT_403 = NL + "\t";
  protected final String TEXT_404 = " = new ";
  protected final String TEXT_405 = "Struct();" + NL + "\tnb_line_";
  protected final String TEXT_406 = "++;" + NL + "\ttry {";
  protected final String TEXT_407 = NL + "        \t\t";
  protected final String TEXT_408 = ".";
  protected final String TEXT_409 = " = ";
  protected final String TEXT_410 = ".";
  protected final String TEXT_411 = ";";
  protected final String TEXT_412 = NL + "\t\tjsonPath_";
  protected final String TEXT_413 = " = ";
  protected final String TEXT_414 = ";" + NL + "\t\tcompiledJsonPath_";
  protected final String TEXT_415 = " = jsonPathCache_";
  protected final String TEXT_416 = ".getCompiledJsonPath(jsonPath_";
  protected final String TEXT_417 = ");" + NL + "\t\t" + NL + "\t\ttry {" + NL + "\t\t\tvalue_";
  protected final String TEXT_418 = " = compiledJsonPath_";
  protected final String TEXT_419 = ".read(row_";
  protected final String TEXT_420 = ");";
  protected final String TEXT_421 = NL + "\t\t\t\t";
  protected final String TEXT_422 = ".";
  protected final String TEXT_423 = " = value_";
  protected final String TEXT_424 = " == null ? ";
  protected final String TEXT_425 = NL;
  protected final String TEXT_426 = NL + "\t\t";
  protected final String TEXT_427 = NL + "\t\t";
  protected final String TEXT_428 = NL + NL + " : value_";
  protected final String TEXT_429 = ".toString();";
  protected final String TEXT_430 = NL + "\t\t\t\tif(value_";
  protected final String TEXT_431 = " != null && !value_";
  protected final String TEXT_432 = ".toString().isEmpty()) {";
  protected final String TEXT_433 = NL + "\t\t\t\t\t";
  protected final String TEXT_434 = ".";
  protected final String TEXT_435 = " = value_";
  protected final String TEXT_436 = ".toString();";
  protected final String TEXT_437 = NL + "\t\t\t\t\t";
  protected final String TEXT_438 = ".";
  protected final String TEXT_439 = " = ParserUtils.parseTo_Date(value_";
  protected final String TEXT_440 = ".toString(), ";
  protected final String TEXT_441 = ");";
  protected final String TEXT_442 = NL + "\t\t\t\t\t";
  protected final String TEXT_443 = ".";
  protected final String TEXT_444 = " = ParserUtils.parseTo_";
  protected final String TEXT_445 = "(value_";
  protected final String TEXT_446 = ".toString());";
  protected final String TEXT_447 = NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_448 = ".";
  protected final String TEXT_449 = " = ";
  protected final String TEXT_450 = NL;
  protected final String TEXT_451 = NL + "\t\t";
  protected final String TEXT_452 = NL + "\t\t";
  protected final String TEXT_453 = NL + NL + ";" + NL + "\t\t\t\t}";
  protected final String TEXT_454 = NL + "\t\t} catch (com.jayway.jsonpath.PathNotFoundException e_";
  protected final String TEXT_455 = ") {" + NL + "\t\t\t";
  protected final String TEXT_456 = ".";
  protected final String TEXT_457 = " = ";
  protected final String TEXT_458 = NL;
  protected final String TEXT_459 = NL + "\t\t";
  protected final String TEXT_460 = NL + "\t\t";
  protected final String TEXT_461 = NL + NL + ";" + NL + "\t\t}";
  protected final String TEXT_462 = NL + "\t";
  protected final String TEXT_463 = " = null;";
  protected final String TEXT_464 = "\t" + NL + "\t} catch (java.lang.Exception ex_";
  protected final String TEXT_465 = ") {";
  protected final String TEXT_466 = NL + "    \tthrow(ex_";
  protected final String TEXT_467 = ");";
  protected final String TEXT_468 = NL + "    \t\t";
  protected final String TEXT_469 = " = new ";
  protected final String TEXT_470 = "Struct();";
  protected final String TEXT_471 = NL + " \t\t\t";
  protected final String TEXT_472 = ".";
  protected final String TEXT_473 = " = ";
  protected final String TEXT_474 = ".";
  protected final String TEXT_475 = ";";
  protected final String TEXT_476 = NL + "\t\t    ";
  protected final String TEXT_477 = ".errorJSONField = jsonStr_";
  protected final String TEXT_478 = ";" + NL + "\t\t    ";
  protected final String TEXT_479 = ".errorMessage = ex_";
  protected final String TEXT_480 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_481 = ";" + NL + "\t\t    ";
  protected final String TEXT_482 = " = null;";
  protected final String TEXT_483 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_484 = " - \" + ex_";
  protected final String TEXT_485 = ".getMessage());";
  protected final String TEXT_486 = NL + "\t\t    System.err.println(ex_";
  protected final String TEXT_487 = ".getMessage());" + NL + "\t\t    ";
  protected final String TEXT_488 = " = null;";
  protected final String TEXT_489 = NL + "\t\t    ";
  protected final String TEXT_490 = ".errorJSONField = jsonStr_";
  protected final String TEXT_491 = ";" + NL + "\t\t    ";
  protected final String TEXT_492 = ".errorMessage = ex_";
  protected final String TEXT_493 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_494 = ";";
  protected final String TEXT_495 = "\t" + NL + "\t}" + NL + "\t" + NL + "\t}" + NL + "    " + NL + "\tisStructError_";
  protected final String TEXT_496 = " = false;" + NL + "\t";
  protected final String TEXT_497 = NL + "\tlog.debug(\"";
  protected final String TEXT_498 = " - Extracting the record \" + nb_line_";
  protected final String TEXT_499 = " + \".\");";
  protected final String TEXT_500 = NL + "//}";
  protected final String TEXT_501 = NL;
  protected final String TEXT_502 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

String jsonField = ElementParameterParser.getValue(node, "__JSONFIELD__");
String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");

int schemaOptNum=1;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
    schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}
//get JSON field content
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
if (inConn!=null) {
    for (IMetadataColumn inputCol : inColumns) {
        if(inputCol.getLabel().equals(jsonField))
        {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(jsonField);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(jsonField);
    stringBuffer.append(TEXT_7);
    
			List<BlockCode> blockCodes = new java.util.ArrayList<BlockCode>(1);
			blockCodes.add(new BlockCode("C_01"));
			((org.talend.core.model.process.AbstractNode) node).setBlocksCodeToClose(blockCodes);
			break;
        }
    }
}

    stringBuffer.append(TEXT_8);
    

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

    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_10);
    
        }
    }
}

String readBy = ElementParameterParser.getValue(node, "__READ_BY__");

    stringBuffer.append(TEXT_11);
    if(!"JSONPATH".equals(readBy)) {
	List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING__");
	String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__");

    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    
if (outConn!=null) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(loopQuery );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    
    if(dieOnError){

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    
    }else{
		if(isLog4jEnabled){
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    }
        if(!("").equals(rejectConnName) && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_72);
    
            if(inConn!=null){
                int columnNo=0;
                for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
                    if(!jsonField.equals(column.getLabel())){
                        for(IMetadataColumn inColumn : inConn.getMetadataTable().getListColumns()){
                            if(inColumn.getLabel().equals(column.getLabel())){
                                if(schemaOptNum < mapping.size()){
                                    if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_77);
    
                                    }
                                    columnNo++;
                                }else{

    stringBuffer.append(TEXT_78);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_82);
    
                                }
                                break;
                            }
                        }
                    }
                }
            }

    stringBuffer.append(TEXT_83);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_89);
    
        } else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    
        }
    }

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    
if(outConns!=null){
    for (IConnection conn : outConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_106);
    
        }
    }
}

    stringBuffer.append(TEXT_107);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
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

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(unExtractColNo/schemaOptNum);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_118);
    
                                    }
                                    unExtractColNo++;
                                }else{

    stringBuffer.append(TEXT_119);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_123);
    
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
            boolean isArrayCheck = "true".equals(mapping.get(i).get("ISARRAY"));
            if(schemaOptNum < mapping.size()){
                if(query!=null && query.trim().length()>0){  // if S_0_0
                    if(extractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(extractColNo/schemaOptNum);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_127);
    if(inConn!=null){
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_128);
    }
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    
                    }
                    extractColNo++;
                }
            }else{
              if(query!=null && query.trim().length()>0){  // if S_0_0
            		if("true".equals(nodeCheck)){
						if((".").equals(query.substring(1,query.length()-1)) && ("/").equals(loopQuery.substring(1,loopQuery.length()-1))){

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    
						}
					}

    stringBuffer.append(TEXT_142);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
                if(!isArrayCheck){
                
    stringBuffer.append(TEXT_150);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
	                    if(("true").equals(nodeCheck)){
						
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    
	                    }else{
						
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    
	                    }
						
    stringBuffer.append(TEXT_184);
    
				}else{
                	if(("true").equals(nodeCheck)){
					
    stringBuffer.append(TEXT_185);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    
                	}else{
					
    stringBuffer.append(TEXT_208);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    
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
							
    stringBuffer.append(TEXT_218);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    
                                continue;
                            }
                            if(!isArrayCheck){
	                            if(javaType == JavaTypesManager.STRING){
									if(column.isNullable()){
									
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_235);
    
									}else{ // column.isNullable()
									
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_245);
    
									}
	                            }else{ // other type
									if(column.isNullable()){
									
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_257);
    
									}else{ // column.isNullable()
									
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_265);
    
									}
								}
								if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
								
    stringBuffer.append(TEXT_266);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_268);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_269);
    
								} else {
									if (javaType == JavaTypesManager.DATE) {
									
    stringBuffer.append(TEXT_270);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_272);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_274);
    
									} else {
									
    stringBuffer.append(TEXT_275);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_277);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_278);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_279);
    
									}
								}
								
    stringBuffer.append(TEXT_280);
    
							}else{
							
    stringBuffer.append(TEXT_281);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_285);
    
									if(javaType == JavaTypesManager.STRING){
									
    stringBuffer.append(TEXT_286);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    
									}else if(javaType == JavaTypesManager.LIST || javaType == JavaTypesManager.OBJECT){
									
    stringBuffer.append(TEXT_291);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    
									}
									
    stringBuffer.append(TEXT_296);
    
							}
	                        break;
                        } // if S_0_0_0_0_1
                    } // if S_0_0_0_1
                } // for S_0_0_1
              }// if S_0_1
            }
        } // for S_1
        if(!("").equals(rejectConnName) && rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_297);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_298);
    
        }

    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    
    if(dieOnError){

    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    
    }else{
		if(isLog4jEnabled){
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    }
        if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_306);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_308);
    
            int columnNo=0;
            for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
                if(schemaOptNum < mapping.size()){
                    if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_313);
    
                    }
                    columnNo++;
                }else{

    stringBuffer.append(TEXT_314);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_316);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_318);
    
                }
            }

    stringBuffer.append(TEXT_319);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_327);
    
        } else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_331);
    
        } else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_332);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_338);
    
        }
    }

    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    
}

    stringBuffer.append(TEXT_341);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    }
    stringBuffer.append(TEXT_345);
    } else {
	List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING_4_JSONPATH__");
	String loopQuery = ElementParameterParser.getValue(node, "__JSON_LOOP_QUERY__");

    stringBuffer.append(TEXT_346);
    stringBuffer.append(TEXT_347);
    
if (outConn ==null ) {
	return stringBuffer.toString();
}

    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    
if(dieOnError){

    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    
} else {
    if(!("").equals(rejectConnName) && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_370);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_377);
    
        if(inConn!=null){
            for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
                if(!jsonField.equals(column.getLabel())){
                    for(IMetadataColumn inColumn : inConn.getMetadataTable().getListColumns()){
                        if(inColumn.getLabel().equals(column.getLabel())){

    stringBuffer.append(TEXT_378);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_380);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_382);
    
                        }
                    }
                }
            }
        }
    } else if(("").equals(rejectConnName)){
    	if(isLog4jEnabled){

    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_385);
    
		}

    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    
	}
}

    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    
if(outConns!=null){
    for (IConnection conn : outConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_401);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_402);
    
        }
    }
}

    stringBuffer.append(TEXT_403);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    
for (int i=0;i<mapping.size();i++) {
	for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
		String schemaColumn = mapping.get(i).get("SCHEMA_COLUMN");
		if(schemaColumn == null || !column.getLabel().equals(schemaColumn)) {
			continue;
		}
		
		String jsonPath = mapping.get(i).get("QUERY");
	 	if(jsonPath==null || jsonPath.trim().isEmpty()) {//only propagate
	 		for(IMetadataColumn inColumn : inColumns) {
		 		if(inColumn.getLabel().equals(column.getLabel())) {

    stringBuffer.append(TEXT_407);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_409);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_411);
    
				}
			}
			continue;
	 	}
	 	
		String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
        String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
        
        String defaultValue = column.getDefault();
        boolean isNotSetDefault = (defaultValue == null || defaultValue.trim().length()==0);

    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(jsonPath);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    
        	if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_421);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(TEXT_425);
    
	if(column.isNullable()) {

    stringBuffer.append(TEXT_426);
    stringBuffer.append(isNotSetDefault? null: defaultValue);
    
	} else {

    stringBuffer.append(TEXT_427);
    stringBuffer.append(isNotSetDefault ? JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate) : defaultValue);
    
	}

    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    
			} else {

    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    
				if(javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_433);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    
				} else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_437);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_441);
    
        		} else {

    stringBuffer.append(TEXT_442);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    
        		}

    stringBuffer.append(TEXT_447);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_448);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(TEXT_450);
    
	if(column.isNullable()) {

    stringBuffer.append(TEXT_451);
    stringBuffer.append(isNotSetDefault? null: defaultValue);
    
	} else {

    stringBuffer.append(TEXT_452);
    stringBuffer.append(isNotSetDefault ? JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate) : defaultValue);
    
	}

    stringBuffer.append(TEXT_453);
    
        	}

    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_456);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(TEXT_458);
    
	if(column.isNullable()) {

    stringBuffer.append(TEXT_459);
    stringBuffer.append(isNotSetDefault? null: defaultValue);
    
	} else {

    stringBuffer.append(TEXT_460);
    stringBuffer.append(isNotSetDefault ? JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate) : defaultValue);
    
	}

    stringBuffer.append(TEXT_461);
    
	}
}

if(!("").equals(rejectConnName) && rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_462);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_463);
    
}

    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_465);
    
    if(dieOnError){

    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    
    }else{
        if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_468);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_470);
    
            for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {

    stringBuffer.append(TEXT_471);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_473);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_475);
    
            }

    stringBuffer.append(TEXT_476);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_481);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_482);
    
        } else if(("").equals(rejectConnName)){
        	if(isLog4jEnabled){

    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_485);
    
			}

    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_488);
    
        } else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_489);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_494);
    
        }
    }

    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_499);
    }
    stringBuffer.append(TEXT_500);
    }
    stringBuffer.append(TEXT_501);
    stringBuffer.append(TEXT_502);
    return stringBuffer.toString();
  }
}
