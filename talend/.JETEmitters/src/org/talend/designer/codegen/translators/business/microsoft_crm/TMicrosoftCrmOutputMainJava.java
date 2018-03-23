package org.talend.designer.codegen.translators.business.microsoft_crm;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMicrosoftCrmOutputMainJava
{
  protected static String nl;
  public static synchronized TMicrosoftCrmOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftCrmOutputMainJava result = new TMicrosoftCrmOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "                               nb_line_";
  protected final String TEXT_2 = " ++;" + NL + "                               java.util.Map<String, Object> map_";
  protected final String TEXT_3 = " = new java.util.HashMap<String, Object>();";
  protected final String TEXT_4 = NL + " \t\t\t    \t\t\t\t\tif(";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = " != null ) { //" + NL + " \t\t\t\t\t\t\t\t";
  protected final String TEXT_7 = NL + "                                            if(";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = " != null){" + NL + "                                                map_";
  protected final String TEXT_10 = ".put(\"";
  protected final String TEXT_11 = "\", Long.valueOf(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = "));" + NL + "                                            }else{" + NL + "                                                map_";
  protected final String TEXT_14 = ".put(\"";
  protected final String TEXT_15 = "\", null);" + NL + "                                            }";
  protected final String TEXT_16 = NL + "                                            if(";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = " != null){" + NL + "                                                map_";
  protected final String TEXT_19 = ".put(\"";
  protected final String TEXT_20 = "\", Boolean.valueOf(";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = "));" + NL + "                                            }else{" + NL + "                                                map_";
  protected final String TEXT_23 = ".put(\"";
  protected final String TEXT_24 = "\", null);" + NL + "                                            }";
  protected final String TEXT_25 = NL + "                                            if(";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = " != null){" + NL + "                                                map_";
  protected final String TEXT_28 = ".put(\"";
  protected final String TEXT_29 = "\", (com.microsoft.schemas.xrm._2011.contracts.EntityCollection)";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ");" + NL + "                                            }else{" + NL + "                                                map_";
  protected final String TEXT_32 = ".put(\"";
  protected final String TEXT_33 = "\", null);" + NL + "                                            }";
  protected final String TEXT_34 = NL + NL + "                                                                 org.dom4j.Document doc_";
  protected final String TEXT_35 = " = null;";
  protected final String TEXT_36 = NL + "                                                                 if(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = " instanceof com.microsoft.schemas.xrm._2011.contracts.EntityReference){" + NL + "                                                                      map_";
  protected final String TEXT_39 = ".put(\"";
  protected final String TEXT_40 = "\", ";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ");" + NL + "                                                                 }else if(";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = " instanceof routines.system.Document || ";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = " instanceof String){" + NL + "                                                                      if(";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = " instanceof routines.system.Document){" + NL + "                                                                            routines.system.Document document_";
  protected final String TEXT_49 = " = (routines.system.Document)";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = ";" + NL + "                                                                            doc_";
  protected final String TEXT_52 = " = document_";
  protected final String TEXT_53 = ".getDocument();" + NL + "                                                                      }else{" + NL + "                                                                           try{" + NL + "                                                                               doc_";
  protected final String TEXT_54 = " = org.dom4j.DocumentHelper.parseText((String)";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = ");" + NL + "                                                                           }catch(org.dom4j.DocumentException e){" + NL + "                                                                               throw new RuntimeException(e.getMessage(), e);" + NL + "                                                                           }" + NL + "                                                                      }" + NL + "                                                                      com.microsoft.schemas.xrm._2011.contracts.EntityReference" + NL + "                                                                                    entityRef_";
  protected final String TEXT_57 = " = new com.microsoft.schemas.xrm._2011.contracts.EntityReference();" + NL + "                                                                      com.microsoft.schemas._2003._10.serialization.Guid" + NL + "                                                                                    guid_";
  protected final String TEXT_58 = " = new com.microsoft.schemas._2003._10.serialization.Guid();" + NL + "                                                                                    guid_";
  protected final String TEXT_59 = ".setValue(" + NL + "                                                                                                         xmlHelper_";
  protected final String TEXT_60 = ".parseXml(doc_";
  protected final String TEXT_61 = ", guid_xpath_";
  protected final String TEXT_62 = ")" + NL + "                                                                                                      );" + NL + "                                                                      entityRef_";
  protected final String TEXT_63 = ".setId(guid_";
  protected final String TEXT_64 = ");" + NL + "                                                                      entityRef_";
  protected final String TEXT_65 = ".setLogicalName(xmlHelper_";
  protected final String TEXT_66 = ".parseXml(doc_";
  protected final String TEXT_67 = ", logical_name_xpath_";
  protected final String TEXT_68 = "));" + NL + "                                                                      entityRef_";
  protected final String TEXT_69 = ".setName(xmlHelper_";
  protected final String TEXT_70 = ".parseXml(doc_";
  protected final String TEXT_71 = ", name_xpath_";
  protected final String TEXT_72 = "));" + NL + "                                                                      map_";
  protected final String TEXT_73 = ".put(\"";
  protected final String TEXT_74 = "\", entityRef_";
  protected final String TEXT_75 = ");" + NL + "                                                                 }else{" + NL + "                                                                      map_";
  protected final String TEXT_76 = ".put(\"";
  protected final String TEXT_77 = "\", null);" + NL + "                                                                 }";
  protected final String TEXT_78 = NL + "                                                                if(";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = " != null){" + NL + "                                                                    try{" + NL + "                                                                        doc_";
  protected final String TEXT_81 = " = org.dom4j.DocumentHelper.parseText(";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = ");" + NL + "                                                                    }catch(org.dom4j.DocumentException e){" + NL + "                                                                        throw new RuntimeException(e.getMessage(), e);" + NL + "                                                                    }" + NL + "                                                                    com.microsoft.schemas.xrm._2011.contracts.EntityReference" + NL + "                                                                                  entityRef_";
  protected final String TEXT_84 = " = new com.microsoft.schemas.xrm._2011.contracts.EntityReference();" + NL + "                                                                    com.microsoft.schemas._2003._10.serialization.Guid" + NL + "                                                                                  guid_";
  protected final String TEXT_85 = " = new com.microsoft.schemas._2003._10.serialization.Guid();" + NL + "                                                                                  guid_";
  protected final String TEXT_86 = ".setValue(" + NL + "                                                                                                       xmlHelper_";
  protected final String TEXT_87 = ".parseXml(doc_";
  protected final String TEXT_88 = ", guid_xpath_";
  protected final String TEXT_89 = ")" + NL + "                                                                                                    );" + NL + "                                                                    entityRef_";
  protected final String TEXT_90 = ".setId(guid_";
  protected final String TEXT_91 = ");" + NL + "                                                                    entityRef_";
  protected final String TEXT_92 = ".setLogicalName(xmlHelper_";
  protected final String TEXT_93 = ".parseXml(doc_";
  protected final String TEXT_94 = ", logical_name_xpath_";
  protected final String TEXT_95 = "));" + NL + "                                                                    entityRef_";
  protected final String TEXT_96 = ".setName(xmlHelper_";
  protected final String TEXT_97 = ".parseXml(doc_";
  protected final String TEXT_98 = ", name_xpath_";
  protected final String TEXT_99 = "));" + NL + "                                                                    map_";
  protected final String TEXT_100 = ".put(\"";
  protected final String TEXT_101 = "\", entityRef_";
  protected final String TEXT_102 = ");" + NL + "                                                                }else{" + NL + "                                                                    map_";
  protected final String TEXT_103 = ".put(\"";
  protected final String TEXT_104 = "\", null);" + NL + "                                                                }";
  protected final String TEXT_105 = NL + "                                                            if(";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = " != null){" + NL + "                                                                routines.system.Document document_";
  protected final String TEXT_108 = " = ";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = ";" + NL + "                                                                doc_";
  protected final String TEXT_111 = " = document_";
  protected final String TEXT_112 = ".getDocument();" + NL + "                                                                com.microsoft.schemas.xrm._2011.contracts.EntityReference" + NL + "                                                                              entityRef_";
  protected final String TEXT_113 = " = new com.microsoft.schemas.xrm._2011.contracts.EntityReference();" + NL + "                                                                com.microsoft.schemas._2003._10.serialization.Guid" + NL + "                                                                              guid_";
  protected final String TEXT_114 = " = new com.microsoft.schemas._2003._10.serialization.Guid();" + NL + "                                                                              guid_";
  protected final String TEXT_115 = ".setValue(" + NL + "                                                                                                   xmlHelper_";
  protected final String TEXT_116 = ".parseXml(doc_";
  protected final String TEXT_117 = ", guid_xpath_";
  protected final String TEXT_118 = ")" + NL + "                                                                                                );" + NL + "                                                                entityRef_";
  protected final String TEXT_119 = ".setId(guid_";
  protected final String TEXT_120 = ");" + NL + "                                                                entityRef_";
  protected final String TEXT_121 = ".setLogicalName(xmlHelper_";
  protected final String TEXT_122 = ".parseXml(doc_";
  protected final String TEXT_123 = ", logical_name_xpath_";
  protected final String TEXT_124 = "));" + NL + "                                                                entityRef_";
  protected final String TEXT_125 = ".setName(xmlHelper_";
  protected final String TEXT_126 = ".parseXml(doc_";
  protected final String TEXT_127 = ", name_xpath_";
  protected final String TEXT_128 = "));" + NL + "                                                                map_";
  protected final String TEXT_129 = ".put(\"";
  protected final String TEXT_130 = "\", entityRef_";
  protected final String TEXT_131 = ");" + NL + "                                                            }else{" + NL + "                                                                map_";
  protected final String TEXT_132 = ".put(\"";
  protected final String TEXT_133 = "\", null);" + NL + "                                                            }";
  protected final String TEXT_134 = NL;
  protected final String TEXT_135 = NL + "                                                                if(";
  protected final String TEXT_136 = ".";
  protected final String TEXT_137 = " instanceof java.util.Date){" + NL + "                                                                     map_";
  protected final String TEXT_138 = ".put(\"";
  protected final String TEXT_139 = "\", ";
  protected final String TEXT_140 = ".";
  protected final String TEXT_141 = ");" + NL + "                                                                }else{" + NL + "                                                                 if(";
  protected final String TEXT_142 = ".";
  protected final String TEXT_143 = " != null){" + NL + "                                                                     map_";
  protected final String TEXT_144 = ".put(\"";
  protected final String TEXT_145 = "\",ParserUtils.parseTo_Date(";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = ".toString(), ";
  protected final String TEXT_148 = "));" + NL + "                                                                 }else{" + NL + "                                                                     map_";
  protected final String TEXT_149 = ".put(\"";
  protected final String TEXT_150 = "\", null);" + NL + "                                                                 }" + NL + "                                                                }";
  protected final String TEXT_151 = NL + "                                                                     map_";
  protected final String TEXT_152 = ".put(\"";
  protected final String TEXT_153 = "\", ";
  protected final String TEXT_154 = ".";
  protected final String TEXT_155 = ");";
  protected final String TEXT_156 = NL + "                                                             if(";
  protected final String TEXT_157 = ".";
  protected final String TEXT_158 = " != null){" + NL + "                                                                     map_";
  protected final String TEXT_159 = ".put(\"";
  protected final String TEXT_160 = "\",ParserUtils.parseTo_Date(";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = ".toString(), ";
  protected final String TEXT_163 = "));" + NL + "                                                             }else{" + NL + "                                                                     map_";
  protected final String TEXT_164 = ".put(\"";
  protected final String TEXT_165 = "\", null);" + NL + "                                                             }";
  protected final String TEXT_166 = NL + "                                                                 if(";
  protected final String TEXT_167 = ".";
  protected final String TEXT_168 = " instanceof java.math.BigDecimal){" + NL + "                                                                    map_";
  protected final String TEXT_169 = ".put(\"";
  protected final String TEXT_170 = "\", ";
  protected final String TEXT_171 = ".";
  protected final String TEXT_172 = ");" + NL + "                                                                 }else{" + NL + "                                                                    if(";
  protected final String TEXT_173 = ".";
  protected final String TEXT_174 = " != null){" + NL + "                                                                    map_";
  protected final String TEXT_175 = ".put(\"";
  protected final String TEXT_176 = "\"," + NL + "                                                                                      ParserUtils.parseTo_BigDecimal(";
  protected final String TEXT_177 = ".";
  protected final String TEXT_178 = ".toString()));" + NL + "                                                                    }else{" + NL + "                                                                    map_";
  protected final String TEXT_179 = ".put(\"";
  protected final String TEXT_180 = "\", null);" + NL + "                                                                    }" + NL + "                                                                 }";
  protected final String TEXT_181 = NL + "                                                                    map_";
  protected final String TEXT_182 = ".put(\"";
  protected final String TEXT_183 = "\", ";
  protected final String TEXT_184 = ".";
  protected final String TEXT_185 = ");";
  protected final String TEXT_186 = NL + "                                                             if(";
  protected final String TEXT_187 = ".";
  protected final String TEXT_188 = " != null){" + NL + "                                                                    map_";
  protected final String TEXT_189 = ".put(\"";
  protected final String TEXT_190 = "\"," + NL + "                                                                                      ParserUtils.parseTo_BigDecimal(";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = ".toString()));" + NL + "                                                             }else{" + NL + "                                                                    map_";
  protected final String TEXT_193 = ".put(\"";
  protected final String TEXT_194 = "\", null);" + NL + "                                                             }";
  protected final String TEXT_195 = NL + "                                                if(";
  protected final String TEXT_196 = ".";
  protected final String TEXT_197 = " != null){" + NL + "                                                     map_";
  protected final String TEXT_198 = ".put(\"";
  protected final String TEXT_199 = "\"," + NL + "                                                                       Double.valueOf(";
  protected final String TEXT_200 = ".";
  protected final String TEXT_201 = "));" + NL + "                                                 }else{" + NL + "                                                     map_";
  protected final String TEXT_202 = ".put(\"";
  protected final String TEXT_203 = "\", null);" + NL + "                                                 }";
  protected final String TEXT_204 = NL + "                                                 if(";
  protected final String TEXT_205 = ".";
  protected final String TEXT_206 = " != null){" + NL + "                                                    map_";
  protected final String TEXT_207 = ".put(\"";
  protected final String TEXT_208 = "\",";
  protected final String TEXT_209 = NL + "                                                                      ";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = ".toString());" + NL + "                                                  }else{" + NL + "                                                    map_";
  protected final String TEXT_212 = ".put(\"";
  protected final String TEXT_213 = "\", null);" + NL + "                                                  }";
  protected final String TEXT_214 = NL + "                                                if(";
  protected final String TEXT_215 = ".";
  protected final String TEXT_216 = " != null){" + NL + "                                                      map_";
  protected final String TEXT_217 = ".put(\"";
  protected final String TEXT_218 = "\"," + NL + "                                                                        Integer.valueOf(";
  protected final String TEXT_219 = ".";
  protected final String TEXT_220 = "));" + NL + "                                                }else{" + NL + "                                                      map_";
  protected final String TEXT_221 = ".put(\"";
  protected final String TEXT_222 = "\", null);" + NL + "                                                }";
  protected final String TEXT_223 = NL + "                                              map_";
  protected final String TEXT_224 = ".put(\"";
  protected final String TEXT_225 = "\"," + NL + "                                                                new com.microsoft.schemas.xrm._2011.contracts.BooleanManagedProperty());";
  protected final String TEXT_226 = NL + "                                              com.microsoft.schemas.xrm._2011.contracts.Money" + NL + "                                                            money_";
  protected final String TEXT_227 = " = new com.microsoft.schemas.xrm._2011.contracts.Money();";
  protected final String TEXT_228 = NL + "                                                                 if(";
  protected final String TEXT_229 = ".";
  protected final String TEXT_230 = " instanceof java.math.BigDecimal){" + NL + "                                                                                money_";
  protected final String TEXT_231 = ".setValue(";
  protected final String TEXT_232 = ".";
  protected final String TEXT_233 = ");" + NL + "                                                                 }else{" + NL + "                                                                       if(";
  protected final String TEXT_234 = ".";
  protected final String TEXT_235 = " != null){" + NL + "                                                                                money_";
  protected final String TEXT_236 = ".setValue(ParserUtils.parseTo_BigDecimal(";
  protected final String TEXT_237 = NL + "                                                                                                             ";
  protected final String TEXT_238 = ".";
  protected final String TEXT_239 = ".toString()" + NL + "                                                                                                             )" + NL + "                                                                                                         );" + NL + "                                                                        }else{" + NL + "                                                                               money_";
  protected final String TEXT_240 = ".setValue(null);" + NL + "                                                                        }" + NL + "                                                                 }";
  protected final String TEXT_241 = NL + "                                                             money_";
  protected final String TEXT_242 = ".setValue(";
  protected final String TEXT_243 = ".";
  protected final String TEXT_244 = ");";
  protected final String TEXT_245 = NL + "                                                          if(";
  protected final String TEXT_246 = ".";
  protected final String TEXT_247 = " != null){" + NL + "                                                             money_";
  protected final String TEXT_248 = ".setValue(ParserUtils.parseTo_BigDecimal(";
  protected final String TEXT_249 = NL + "                                                                                          ";
  protected final String TEXT_250 = ".";
  protected final String TEXT_251 = ".toString()" + NL + "                                                                                          )" + NL + "                                                                                      );" + NL + "                                                          }else{" + NL + "                                                            money_";
  protected final String TEXT_252 = ".setValue(null);" + NL + "                                                          }";
  protected final String TEXT_253 = NL + "                                             map_";
  protected final String TEXT_254 = ".put(\"";
  protected final String TEXT_255 = "\", money_";
  protected final String TEXT_256 = ");";
  protected final String TEXT_257 = NL + "                                                 com.microsoft.schemas.xrm._2011.contracts.OptionSetValue" + NL + "                                                               optionSetValue_";
  protected final String TEXT_258 = " = new com.microsoft.schemas.xrm._2011.contracts.OptionSetValue();" + NL + "                                                 if(";
  protected final String TEXT_259 = ".";
  protected final String TEXT_260 = " != null){" + NL + "                                                 optionSetValue_";
  protected final String TEXT_261 = ".setValue(Integer.valueOf(";
  protected final String TEXT_262 = ".";
  protected final String TEXT_263 = "));" + NL + "                                                 }else{" + NL + "                                                 optionSetValue_";
  protected final String TEXT_264 = ".setValue(null);" + NL + "                                                 }" + NL + "                                                 map_";
  protected final String TEXT_265 = ".put(\"";
  protected final String TEXT_266 = "\", optionSetValue_";
  protected final String TEXT_267 = ");";
  protected final String TEXT_268 = NL + "                                                 com.microsoft.schemas._2003._10.serialization.Guid" + NL + "                                                               guid_";
  protected final String TEXT_269 = " = new com.microsoft.schemas._2003._10.serialization.Guid();" + NL + "                                                 if(";
  protected final String TEXT_270 = ".";
  protected final String TEXT_271 = " != null){" + NL + "                                                 guid_";
  protected final String TEXT_272 = ".setValue(";
  protected final String TEXT_273 = ".";
  protected final String TEXT_274 = ".toString());" + NL + "                                                 }else{" + NL + "                                                 throw new RuntimeException(\"UNIQUEIDENTIFIER can't be null, the column name is ";
  protected final String TEXT_275 = "\");" + NL + "                                                 }" + NL + "                                                 map_";
  protected final String TEXT_276 = ".put(\"";
  protected final String TEXT_277 = "\", guid_";
  protected final String TEXT_278 = ");";
  protected final String TEXT_279 = NL + "                                                  System.err.println(\"Unsupported Crm Data Type ==> ";
  protected final String TEXT_280 = "\");" + NL + "                                                  map_";
  protected final String TEXT_281 = ".put(\"";
  protected final String TEXT_282 = "\", null);";
  protected final String TEXT_283 = NL + " \t\t\t    \t\t\t\t\t} //" + NL + " \t\t\t\t\t\t\t\t  ";
  protected final String TEXT_284 = NL + "                                      crmEntityHelper_";
  protected final String TEXT_285 = ".createEntity(\"";
  protected final String TEXT_286 = "\", map_";
  protected final String TEXT_287 = ");";
  protected final String TEXT_288 = NL + "                                      crmEntityHelper_";
  protected final String TEXT_289 = ".updateEntity(\"";
  protected final String TEXT_290 = "\", map_";
  protected final String TEXT_291 = ");";
  protected final String TEXT_292 = NL + "                                crmEntityHelper_";
  protected final String TEXT_293 = ".deleteEntity(\"";
  protected final String TEXT_294 = "\",";
  protected final String TEXT_295 = ".Id);";
  protected final String TEXT_296 = NL + "                               System.out.println(\"Unsupported Operation ==> ";
  protected final String TEXT_297 = "\");";
  protected final String TEXT_298 = NL + "                  org.apache.olingo.client.api.domain.ClientEntity entity_";
  protected final String TEXT_299 = " = client_";
  protected final String TEXT_300 = ".newEntity();";
  protected final String TEXT_301 = NL + "                            \t\tif(";
  protected final String TEXT_302 = ".";
  protected final String TEXT_303 = " != null";
  protected final String TEXT_304 = " && !(String.valueOf(";
  protected final String TEXT_305 = ".";
  protected final String TEXT_306 = ").isEmpty())";
  protected final String TEXT_307 = "){" + NL + "\t                            \t\tclient_";
  protected final String TEXT_308 = ".addEntityNavigationLink(entity_";
  protected final String TEXT_309 = ", ";
  protected final String TEXT_310 = ",\"";
  protected final String TEXT_311 = "\", ";
  protected final String TEXT_312 = ".";
  protected final String TEXT_313 = ");" + NL + "\t                            \t}";
  protected final String TEXT_314 = "   \t\t\t\t" + NL + "\t\t\t  \t\t\t    \t\t\t\tif(";
  protected final String TEXT_315 = ".";
  protected final String TEXT_316 = " != null){" + NL + "\t\t\t  \t\t\t    \t\t\t\t" + NL + "\t\t\t  \t\t\t    \t\t\t";
  protected final String TEXT_317 = NL + "                           \t\tclient_";
  protected final String TEXT_318 = ".addEntityProperty(entity_";
  protected final String TEXT_319 = ", \"";
  protected final String TEXT_320 = "\", org.apache.olingo.commons.api.edm.EdmPrimitiveTypeKind.";
  protected final String TEXT_321 = ", \t";
  protected final String TEXT_322 = ".";
  protected final String TEXT_323 = ");" + NL + "\t                           ";
  protected final String TEXT_324 = NL + "\t\t\t  \t\t\t    \t\t\t\t}" + NL + "\t\t\t  \t\t\t\t\t\t\t";
  protected final String TEXT_325 = NL + "                        //";
  protected final String TEXT_326 = NL + "                    \t";
  protected final String TEXT_327 = NL + "                    \t\tclient_";
  protected final String TEXT_328 = ".insertEntity(entity_";
  protected final String TEXT_329 = ");" + NL + "                    \t";
  protected final String TEXT_330 = NL + "                 \t\t\tclient_";
  protected final String TEXT_331 = ".updateEntity( entity_";
  protected final String TEXT_332 = ", ";
  protected final String TEXT_333 = ".";
  protected final String TEXT_334 = ");" + NL + "                    \t";
  protected final String TEXT_335 = NL + "                    \t\tclient_";
  protected final String TEXT_336 = ".deleteEntity(";
  protected final String TEXT_337 = ".Id);" + NL + "                    \t";
  protected final String TEXT_338 = NL + "                    \tnb_line_";
  protected final String TEXT_339 = "++;";
  protected final String TEXT_340 = NL + "                        StringBuffer OperXml_";
  protected final String TEXT_341 = " = new StringBuffer();" + NL;
  protected final String TEXT_342 = NL + "                                OperXml_";
  protected final String TEXT_343 = ".append(\"<Create xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\">\");";
  protected final String TEXT_344 = NL + "                                OperXml_";
  protected final String TEXT_345 = ".append(\"<Update xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\">\");";
  protected final String TEXT_346 = NL + "                            OperXml_";
  protected final String TEXT_347 = ".append(\"\\n\");" + NL + "                            OperXml_";
  protected final String TEXT_348 = ".append(\"<entity xsi:type=\\\"web:\");" + NL + "                            OperXml_";
  protected final String TEXT_349 = ".append(\"";
  protected final String TEXT_350 = "\");" + NL + "                            OperXml_";
  protected final String TEXT_351 = ".append(\"\\\" xmlns:web=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\">\");" + NL + "                            OperXml_";
  protected final String TEXT_352 = ".append(\"\\n\");" + NL;
  protected final String TEXT_353 = NL + " \t\t\t    \t\t\t\t\tif(";
  protected final String TEXT_354 = ".";
  protected final String TEXT_355 = " != null ) { //" + NL + " \t\t\t\t\t\t\t\t";
  protected final String TEXT_356 = NL + "                                    OperXml_";
  protected final String TEXT_357 = ".append(\"<\");" + NL + "                                    OperXml_";
  protected final String TEXT_358 = ".append(\"";
  protected final String TEXT_359 = "\");";
  protected final String TEXT_360 = NL + "                                            OperXml_";
  protected final String TEXT_361 = ".append(\" type=\\\"\");" + NL + "                                            OperXml_";
  protected final String TEXT_362 = ".append(";
  protected final String TEXT_363 = ");" + NL + "                                            OperXml_";
  protected final String TEXT_364 = ".append(\"\\\"\");";
  protected final String TEXT_365 = NL + "                                    OperXml_";
  protected final String TEXT_366 = ".append(\">\");" + NL + "                                    OperXml_";
  protected final String TEXT_367 = ".append(\"<![CDATA[\");";
  protected final String TEXT_368 = NL + "                                        if(";
  protected final String TEXT_369 = ".";
  protected final String TEXT_370 = " != null ){" + NL + "                                            OperXml_";
  protected final String TEXT_371 = ".append(FormatterUtils.format_Date(";
  protected final String TEXT_372 = ".";
  protected final String TEXT_373 = ", ";
  protected final String TEXT_374 = "));" + NL + "                                        }else{" + NL + "                                            OperXml_";
  protected final String TEXT_375 = ".append(";
  protected final String TEXT_376 = ");" + NL + "                                        }";
  protected final String TEXT_377 = NL + "                                        if(";
  protected final String TEXT_378 = ".";
  protected final String TEXT_379 = " != null ){" + NL + "                                            OperXml_";
  protected final String TEXT_380 = ".append(String.valueOf(";
  protected final String TEXT_381 = ".";
  protected final String TEXT_382 = "));" + NL + "                                        }else{" + NL + "                                            OperXml_";
  protected final String TEXT_383 = ".append(";
  protected final String TEXT_384 = ");" + NL + "                                        }";
  protected final String TEXT_385 = NL + "                                    OperXml_";
  protected final String TEXT_386 = ".append(\"]]>\");" + NL + "                                    OperXml_";
  protected final String TEXT_387 = ".append(\"</\");" + NL + "                                    OperXml_";
  protected final String TEXT_388 = ".append(\"";
  protected final String TEXT_389 = "\");" + NL + "                                    OperXml_";
  protected final String TEXT_390 = ".append(\">\");" + NL + "                                    OperXml_";
  protected final String TEXT_391 = ".append(\"\\n\");";
  protected final String TEXT_392 = NL + "                                    OperXml_";
  protected final String TEXT_393 = ".append(\"<\");" + NL + "                                    OperXml_";
  protected final String TEXT_394 = ".append(\"";
  protected final String TEXT_395 = "\");" + NL + "                                    OperXml_";
  protected final String TEXT_396 = ".append(\"id>\");" + NL + "                                    OperXml_";
  protected final String TEXT_397 = ".append(";
  protected final String TEXT_398 = ".Id);" + NL + "                                    OperXml_";
  protected final String TEXT_399 = ".append(\"</\");" + NL + "                                    OperXml_";
  protected final String TEXT_400 = ".append(\"";
  protected final String TEXT_401 = "\");" + NL + "                                    OperXml_";
  protected final String TEXT_402 = ".append(\"id>\");" + NL + "                                    OperXml_";
  protected final String TEXT_403 = ".append(\"\\n\");";
  protected final String TEXT_404 = NL + " \t\t\t    \t\t\t\t\t} //" + NL + " \t\t\t\t\t\t\t\t";
  protected final String TEXT_405 = NL + "                                OperXml_";
  protected final String TEXT_406 = ".append(\"</entity>\");" + NL + "                                OperXml_";
  protected final String TEXT_407 = ".append(\"\\n\");" + NL + "                                OperXml_";
  protected final String TEXT_408 = ".append(\"</Create>\");" + NL + "                                com.microsoft.schemas.crm._2007.webservices.CreateDocument createDoc_";
  protected final String TEXT_409 = " =  com.microsoft.schemas.crm._2007.webservices.CreateDocument.Factory.parse(OperXml_";
  protected final String TEXT_410 = ".toString());" + NL + "                                service_";
  protected final String TEXT_411 = ".create(createDoc_";
  protected final String TEXT_412 = ", catd_";
  protected final String TEXT_413 = ", null, null);";
  protected final String TEXT_414 = NL + "                                OperXml_";
  protected final String TEXT_415 = ".append(\"</entity>\");" + NL + "                                OperXml_";
  protected final String TEXT_416 = ".append(\"\\n\");" + NL + "                                OperXml_";
  protected final String TEXT_417 = ".append(\"</Update>\");" + NL + "                                com.microsoft.schemas.crm._2007.webservices.UpdateDocument updateDoc_";
  protected final String TEXT_418 = " = com.microsoft.schemas.crm._2007.webservices.UpdateDocument.Factory.parse(OperXml_";
  protected final String TEXT_419 = ".toString());" + NL + "                                service_";
  protected final String TEXT_420 = ".update(updateDoc_";
  protected final String TEXT_421 = ",catd_";
  protected final String TEXT_422 = ",null,null);";
  protected final String TEXT_423 = NL + "                            OperXml_";
  protected final String TEXT_424 = ".append(\"<Delete xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\">\");" + NL + "                            OperXml_";
  protected final String TEXT_425 = ".append(\"\\n\");" + NL + "                            OperXml_";
  protected final String TEXT_426 = ".append(\"<entityName>\");" + NL + "                            OperXml_";
  protected final String TEXT_427 = ".append(\"";
  protected final String TEXT_428 = "\");" + NL + "                            OperXml_";
  protected final String TEXT_429 = ".append(\"</entityName>\");" + NL + "                            OperXml_";
  protected final String TEXT_430 = ".append(\"\\n\");" + NL + "                            OperXml_";
  protected final String TEXT_431 = ".append(\"<id>\");" + NL + "                            OperXml_";
  protected final String TEXT_432 = ".append(";
  protected final String TEXT_433 = ".Id);" + NL + "                            OperXml_";
  protected final String TEXT_434 = ".append(\"</id>\\n\");" + NL + "                            OperXml_";
  protected final String TEXT_435 = ".append(\"</Delete>\");" + NL + "                            com.microsoft.schemas.crm._2007.webservices.DeleteDocument deleteDoc_";
  protected final String TEXT_436 = " = com.microsoft.schemas.crm._2007.webservices.DeleteDocument.Factory.parse(OperXml_";
  protected final String TEXT_437 = ".toString());" + NL + "                            service_";
  protected final String TEXT_438 = ".delete(deleteDoc_";
  protected final String TEXT_439 = ",catd_";
  protected final String TEXT_440 = ",null,null);";
  protected final String TEXT_441 = NL + "                            com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Execute execute_";
  protected final String TEXT_442 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Execute.Factory" + NL + "                                    .newInstance();" + NL + "                            com.microsoft.schemas.crm._2007.webservices.ExecuteDocument executeDoc_";
  protected final String TEXT_443 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Factory" + NL + "                                    .newInstance();" + NL + "                            com.microsoft.schemas.crm._2007.webservices.AssignRequest assignRequest_";
  protected final String TEXT_444 = " = com.microsoft.schemas.crm._2007.webservices.AssignRequest.Factory" + NL + "                                    .newInstance();" + NL + "                            com.microsoft.schemas.crm._2006.coretypes.SecurityPrincipal assignee_";
  protected final String TEXT_445 = " = com.microsoft.schemas.crm._2006.coretypes.SecurityPrincipal.Factory.newInstance();" + NL + "                            assignee_";
  protected final String TEXT_446 = ".setPrincipalId(String.valueOf(";
  protected final String TEXT_447 = ".ownerid));" + NL + "                            assignee_";
  protected final String TEXT_448 = ".setType(com.microsoft.schemas.crm._2006.coretypes.SecurityPrincipalType.Enum.forString(\"User\"));" + NL + "                            assignRequest_";
  protected final String TEXT_449 = ".setAssignee(assignee_";
  protected final String TEXT_450 = ");" + NL + "" + NL + "                            com.microsoft.schemas.crm._2007.webservices.TargetOwnedDynamic dynamicTarget_";
  protected final String TEXT_451 = " = com.microsoft.schemas.crm._2007.webservices.TargetOwnedDynamic.Factory" + NL + "                                    .newInstance();" + NL + "                            dynamicTarget_";
  protected final String TEXT_452 = ".setEntityName(\"";
  protected final String TEXT_453 = "\");" + NL + "                            dynamicTarget_";
  protected final String TEXT_454 = ".setEntityId(String.valueOf(";
  protected final String TEXT_455 = ".Id));" + NL + "" + NL + "                            assignRequest_";
  protected final String TEXT_456 = ".setTarget(dynamicTarget_";
  protected final String TEXT_457 = ");" + NL + "" + NL + "                            execute_";
  protected final String TEXT_458 = ".setRequest(assignRequest_";
  protected final String TEXT_459 = ");" + NL + "                            executeDoc_";
  protected final String TEXT_460 = ".setExecute(execute_";
  protected final String TEXT_461 = ");" + NL + "" + NL + "                            executeDoc_";
  protected final String TEXT_462 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Factory.parse(executeDoc_";
  protected final String TEXT_463 = ".toString());" + NL + "" + NL + "                            service_";
  protected final String TEXT_464 = ".execute(executeDoc_";
  protected final String TEXT_465 = ", catd_";
  protected final String TEXT_466 = ", null,null);" + NL;
  protected final String TEXT_467 = NL + "                            com.microsoft.schemas.xrm._2011.contracts.Entity entity_";
  protected final String TEXT_468 = " = com.microsoft.schemas.xrm._2011.contracts.Entity.Factory.newInstance();" + NL + "                            entity_";
  protected final String TEXT_469 = ".setLogicalName(\"";
  protected final String TEXT_470 = "\");" + NL + "" + NL + "                            com.microsoft.schemas.xrm._2011.contracts.AttributeCollection attributes_";
  protected final String TEXT_471 = " = com.microsoft.schemas.xrm._2011.contracts.AttributeCollection.Factory.newInstance();" + NL + "                            org.datacontract.schemas._2004._07.system_collections_generic.KeyValuePairOfstringanyType attribute_";
  protected final String TEXT_472 = " = null;" + NL + "                            " + NL + "                            org.apache.xmlbeans.GDateBuilder gdb_";
  protected final String TEXT_473 = " = null;" + NL + "                            org.apache.xmlbeans.XmlObject xmlObject_";
  protected final String TEXT_474 = " = null;";
  protected final String TEXT_475 = "   \t\t\t\t" + NL + "  \t\t\t    \t\t\t\t\tif(";
  protected final String TEXT_476 = ".";
  protected final String TEXT_477 = " != null){" + NL + "  \t\t\t\t\t\t\t\t";
  protected final String TEXT_478 = NL + "                                attribute_";
  protected final String TEXT_479 = " = attributes_";
  protected final String TEXT_480 = ".addNewKeyValuePairOfstringanyType();" + NL + "                                attribute_";
  protected final String TEXT_481 = ".setKey(\"";
  protected final String TEXT_482 = "\");";
  protected final String TEXT_483 = "   \t\t\t\t" + NL + "  \t\t\t    \t\t\t\t\tif(";
  protected final String TEXT_484 = ".";
  protected final String TEXT_485 = " != null){" + NL + "  \t\t\t\t\t\t\t\t";
  protected final String TEXT_486 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_487 = ".";
  protected final String TEXT_488 = " != null";
  protected final String TEXT_489 = " && !(String.valueOf(";
  protected final String TEXT_490 = ".";
  protected final String TEXT_491 = ").isEmpty())";
  protected final String TEXT_492 = ") {" + NL + "\t\t                                            xmlObject_";
  protected final String TEXT_493 = " = com.microsoft.schemas.xrm._2011.contracts.EntityReference.Factory.newInstance();" + NL + "                                                \t((com.microsoft.schemas.xrm._2011.contracts.EntityReference)xmlObject_";
  protected final String TEXT_494 = ").setId(";
  protected final String TEXT_495 = ".";
  protected final String TEXT_496 = ");" + NL + "\t                                               \t((com.microsoft.schemas.xrm._2011.contracts.EntityReference)xmlObject_";
  protected final String TEXT_497 = ").setLogicalName(";
  protected final String TEXT_498 = ");" + NL + "                                                } else {" + NL + "                                                \txmlObject_";
  protected final String TEXT_499 = " = null;" + NL + "                                                }";
  protected final String TEXT_500 = NL + "                                    \"The type of column \"";
  protected final String TEXT_501 = "\" is EntityReference, need to specify the reference entity logical name in EntityReference Type Mapping table.\"";
  protected final String TEXT_502 = NL + "                                    xmlObject_";
  protected final String TEXT_503 = " = com.microsoft.schemas.xrm._2011.contracts.OptionSetValue.Factory.newInstance();" + NL + "                                    ((com.microsoft.schemas.xrm._2011.contracts.OptionSetValue)xmlObject_";
  protected final String TEXT_504 = ").setValue(";
  protected final String TEXT_505 = ".";
  protected final String TEXT_506 = ");";
  protected final String TEXT_507 = NL + "                                    xmlObject_";
  protected final String TEXT_508 = " = com.microsoft.schemas.xrm._2011.contracts.Money.Factory.newInstance();" + NL + "                                    ((com.microsoft.schemas.xrm._2011.contracts.Money)xmlObject_";
  protected final String TEXT_509 = ").setValue(";
  protected final String TEXT_510 = ".";
  protected final String TEXT_511 = ");";
  protected final String TEXT_512 = NL + "                                    xmlObject_";
  protected final String TEXT_513 = " = com.microsoft.schemas._2003._10.serialization.Guid.Factory.newInstance();" + NL + "                                    ((com.microsoft.schemas._2003._10.serialization.Guid)xmlObject_";
  protected final String TEXT_514 = ").setStringValue(";
  protected final String TEXT_515 = ".";
  protected final String TEXT_516 = ");";
  protected final String TEXT_517 = NL + "                                    xmlObject_";
  protected final String TEXT_518 = " = org.apache.xmlbeans.XmlString.Factory.newInstance();" + NL + "                                    ((org.apache.xmlbeans.XmlString)xmlObject_";
  protected final String TEXT_519 = ").setStringValue(";
  protected final String TEXT_520 = ".";
  protected final String TEXT_521 = ");";
  protected final String TEXT_522 = NL + "                                    xmlObject_";
  protected final String TEXT_523 = " = org.apache.xmlbeans.XmlDateTime.Factory.newInstance();" + NL + "                                    if(";
  protected final String TEXT_524 = ".";
  protected final String TEXT_525 = " == null) {" + NL + "                                    \t((org.apache.xmlbeans.XmlDateTime)xmlObject_";
  protected final String TEXT_526 = ").setDateValue(";
  protected final String TEXT_527 = ".";
  protected final String TEXT_528 = ");" + NL + "                                    } else {" + NL + "                                    \tgdb_";
  protected final String TEXT_529 = " = new org.apache.xmlbeans.GDateBuilder(";
  protected final String TEXT_530 = ".";
  protected final String TEXT_531 = ");" + NL + "                                    \tgdb_";
  protected final String TEXT_532 = ".normalize();" + NL + "                                    \t((org.apache.xmlbeans.XmlDateTime)xmlObject_";
  protected final String TEXT_533 = ").setGDateValue(gdb_";
  protected final String TEXT_534 = ".toGDate());" + NL + "                                    }";
  protected final String TEXT_535 = NL + "                                    xmlObject_";
  protected final String TEXT_536 = " = org.apache.xmlbeans.XmlBoolean.Factory.newInstance();" + NL + "                                    ((org.apache.xmlbeans.XmlBoolean)xmlObject_";
  protected final String TEXT_537 = ").setBooleanValue(";
  protected final String TEXT_538 = ".";
  protected final String TEXT_539 = ");";
  protected final String TEXT_540 = NL + "                                    xmlObject_";
  protected final String TEXT_541 = " = org.apache.xmlbeans.XmlDecimal.Factory.newInstance();" + NL + "                                    ((org.apache.xmlbeans.XmlDecimal)xmlObject_";
  protected final String TEXT_542 = ").setBigDecimalValue(";
  protected final String TEXT_543 = ".";
  protected final String TEXT_544 = ");";
  protected final String TEXT_545 = NL + "                                    xmlObject_";
  protected final String TEXT_546 = " = org.apache.xmlbeans.XmlInt.Factory.newInstance();" + NL + "                                    ((org.apache.xmlbeans.XmlInt)xmlObject_";
  protected final String TEXT_547 = ").setIntValue(";
  protected final String TEXT_548 = ".";
  protected final String TEXT_549 = ");";
  protected final String TEXT_550 = NL + "                                    xmlObject_";
  protected final String TEXT_551 = " = org.apache.xmlbeans.XmlLong.Factory.newInstance();" + NL + "                                    ((org.apache.xmlbeans.XmlLong)xmlObject_";
  protected final String TEXT_552 = ").setLongValue(";
  protected final String TEXT_553 = ".";
  protected final String TEXT_554 = ");";
  protected final String TEXT_555 = NL + "                                    xmlObject_";
  protected final String TEXT_556 = " = org.apache.xmlbeans.XmlDouble.Factory.newInstance();" + NL + "                                    ((org.apache.xmlbeans.XmlDouble)xmlObject_";
  protected final String TEXT_557 = ").setDoubleValue(";
  protected final String TEXT_558 = ".";
  protected final String TEXT_559 = ");";
  protected final String TEXT_560 = NL + "                                    \"don't support entityCollection yet;\"";
  protected final String TEXT_561 = NL + "                                    \"don't support booleanManagedProperty yet;\"";
  protected final String TEXT_562 = NL + "                                    \"wrong type ";
  protected final String TEXT_563 = "\"";
  protected final String TEXT_564 = NL + "  \t\t\t\t\t\t\t\t\t} else {" + NL + "  \t\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_565 = " = null;" + NL + "  \t\t\t\t\t\t\t\t\t}" + NL + "  \t\t\t\t\t\t\t\t";
  protected final String TEXT_566 = NL + "                                attribute_";
  protected final String TEXT_567 = ".setValue(xmlObject_";
  protected final String TEXT_568 = ");";
  protected final String TEXT_569 = NL + "  \t\t\t\t\t\t\t\t\t}" + NL + "  \t\t\t\t\t\t\t\t";
  protected final String TEXT_570 = NL + "                            entity_";
  protected final String TEXT_571 = ".setAttributes(attributes_";
  protected final String TEXT_572 = ");";
  protected final String TEXT_573 = NL + "                                com.microsoft.schemas.xrm._2011.contracts.services.CreateDocument.Create create_";
  protected final String TEXT_574 = " = com.microsoft.schemas.xrm._2011.contracts.services.CreateDocument.Create.Factory.newInstance();" + NL + "                                create_";
  protected final String TEXT_575 = ".setEntity(entity_";
  protected final String TEXT_576 = ");" + NL + "                                com.microsoft.schemas.xrm._2011.contracts.services.CreateDocument createDoc_";
  protected final String TEXT_577 = " = com.microsoft.schemas.xrm._2011.contracts.services.CreateDocument.Factory.newInstance();" + NL + "                                createDoc_";
  protected final String TEXT_578 = ".setCreate(create_";
  protected final String TEXT_579 = ");" + NL + "                                com.microsoft.schemas.xrm._2011.contracts.services.CreateResponseDocument.CreateResponse createResp_";
  protected final String TEXT_580 = " = null;" + NL + "                                try{" + NL + "                                    createResp_";
  protected final String TEXT_581 = " = serviceStub_";
  protected final String TEXT_582 = ".create(createDoc_";
  protected final String TEXT_583 = ").getCreateResponse();" + NL + "                                }catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Create_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_584 = "){" + NL + "                                    throw new Exception(ex_";
  protected final String TEXT_585 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "                                }" + NL + "                                //String returnId_";
  protected final String TEXT_586 = " = createResp_";
  protected final String TEXT_587 = ".getCreateResult();";
  protected final String TEXT_588 = NL + "                                    com.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument.Update update_";
  protected final String TEXT_589 = " = com.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument.Update.Factory.newInstance();" + NL + "                                    update_";
  protected final String TEXT_590 = ".setEntity(entity_";
  protected final String TEXT_591 = ");" + NL + "                                    com.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument updateDoc_";
  protected final String TEXT_592 = " = com.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument.Factory.newInstance();" + NL + "                                    updateDoc_";
  protected final String TEXT_593 = ".setUpdate(update_";
  protected final String TEXT_594 = ");" + NL + "                                    try{" + NL + "                                        serviceStub_";
  protected final String TEXT_595 = ".update(updateDoc_";
  protected final String TEXT_596 = ");" + NL + "                                    }catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Update_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_597 = "){" + NL + "                                        throw new Exception(ex_";
  protected final String TEXT_598 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "                                    }";
  protected final String TEXT_599 = NL + "                                    com.microsoft.schemas.xrm._2011.contracts.OrganizationRequest request_";
  protected final String TEXT_600 = " = com.microsoft.schemas.xrm._2011.contracts.OrganizationRequest.Factory.newInstance();" + NL + "                                    request_";
  protected final String TEXT_601 = ".setNilRequestId();" + NL + "                                    request_";
  protected final String TEXT_602 = ".setRequestName(\"Assign\");" + NL + "                                    com.microsoft.schemas.xrm._2011.contracts.ParameterCollection parameters_";
  protected final String TEXT_603 = " = com.microsoft.schemas.xrm._2011.contracts.ParameterCollection.Factory.newInstance();" + NL + "                                    org.datacontract.schemas._2004._07.system_collections_generic.KeyValuePairOfstringanyType parameter_";
  protected final String TEXT_604 = " = null;" + NL + "" + NL + "                                    parameter_";
  protected final String TEXT_605 = " = parameters_";
  protected final String TEXT_606 = ".addNewKeyValuePairOfstringanyType();" + NL + "                                    parameter_";
  protected final String TEXT_607 = ".setKey(\"Target\");" + NL + "                                    com.microsoft.schemas.xrm._2011.contracts.EntityReference targetEntity_";
  protected final String TEXT_608 = " = com.microsoft.schemas.xrm._2011.contracts.EntityReference.Factory.newInstance();" + NL + "                                    targetEntity_";
  protected final String TEXT_609 = ".setId(";
  protected final String TEXT_610 = ".";
  protected final String TEXT_611 = ");" + NL + "                                    targetEntity_";
  protected final String TEXT_612 = ".setLogicalName(\"";
  protected final String TEXT_613 = "\");" + NL + "                                    parameter_";
  protected final String TEXT_614 = ".setValue(targetEntity_";
  protected final String TEXT_615 = ");" + NL + "" + NL + "                                    parameter_";
  protected final String TEXT_616 = " = parameters_";
  protected final String TEXT_617 = ".addNewKeyValuePairOfstringanyType();" + NL + "                                    parameter_";
  protected final String TEXT_618 = ".setKey(\"Assignee\");" + NL + "                                    com.microsoft.schemas.xrm._2011.contracts.EntityReference assigneeEntity_";
  protected final String TEXT_619 = " = com.microsoft.schemas.xrm._2011.contracts.EntityReference.Factory.newInstance();" + NL + "                                    assigneeEntity_";
  protected final String TEXT_620 = ".setId(";
  protected final String TEXT_621 = ".";
  protected final String TEXT_622 = ");" + NL + "                                    assigneeEntity_";
  protected final String TEXT_623 = ".setLogicalName(\"systemuser\");" + NL + "                                    parameter_";
  protected final String TEXT_624 = ".setValue(assigneeEntity_";
  protected final String TEXT_625 = ");" + NL + "" + NL + "                                    request_";
  protected final String TEXT_626 = ".setParameters(parameters_";
  protected final String TEXT_627 = ");" + NL + "                                    com.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument.Execute execute_";
  protected final String TEXT_628 = " = com.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument.Execute.Factory.newInstance();" + NL + "                                    execute_";
  protected final String TEXT_629 = ".setRequest(request_";
  protected final String TEXT_630 = ");" + NL + "                                    com.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument executeDoc_";
  protected final String TEXT_631 = " = com.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument.Factory.newInstance();" + NL + "                                    executeDoc_";
  protected final String TEXT_632 = ".setExecute(execute_";
  protected final String TEXT_633 = ");" + NL + "                                    try{" + NL + "                                        serviceStub_";
  protected final String TEXT_634 = ".execute(executeDoc_";
  protected final String TEXT_635 = ");" + NL + "                                    }catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Execute_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_636 = "){" + NL + "                                        throw new Exception(ex_";
  protected final String TEXT_637 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "                                    }";
  protected final String TEXT_638 = NL + "                            com.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument.Delete delete_";
  protected final String TEXT_639 = " = com.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument.Delete.Factory.newInstance();" + NL + "                            delete_";
  protected final String TEXT_640 = ".setEntityName(\"";
  protected final String TEXT_641 = "\");" + NL + "                            delete_";
  protected final String TEXT_642 = ".setId(";
  protected final String TEXT_643 = ".Id);" + NL + "                            com.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument deleteDoc_";
  protected final String TEXT_644 = " = com.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument.Factory.newInstance();" + NL + "                            deleteDoc_";
  protected final String TEXT_645 = ".setDelete(delete_";
  protected final String TEXT_646 = ");" + NL + "                            try{" + NL + "                                serviceStub_";
  protected final String TEXT_647 = ".delete(deleteDoc_";
  protected final String TEXT_648 = ");" + NL + "                            }catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Delete_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_649 = "){" + NL + "                                throw new Exception(ex_";
  protected final String TEXT_650 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "                            }";
  protected final String TEXT_651 = NL + "                    nb_line_";
  protected final String TEXT_652 = "++;";
  protected final String TEXT_653 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    String authenticationType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
    String crmVersion = ElementParameterParser.getValue(node, "__MS_CRM_VERSION__");
    boolean ignoreNull = "true".equals(ElementParameterParser.getValue(node,"__IGNORE_NULL__"));

    boolean isMsCrm2015OnPremise = "ON_PREMISE".equals(authenticationType) && "CRM_2015".equals(crmVersion);

        if(isMsCrm2015OnPremise){
           
    
    String entityName = ElementParameterParser.getValue(node, "__ENTITYNAME__").trim();
    String customEntityName = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
    if("CustomEntity".equals(entityName)){
        entityName = customEntityName.replace("\"","");
    }
    entityName = entityName.toLowerCase();
    String action = ElementParameterParser.getValue(node,"__ACTION__");

    List<IMetadataTable> metadatas = node.getMetadataList();
    if((metadatas != null) && (metadatas.size() > 0)){
        IMetadataTable metadata = metadatas.get(0);
        if(metadata != null){
            List<? extends IConnection> conns = node.getIncomingConnections();
            for(IConnection conn : conns){
                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
                    String connName = conn.getName();
                    List<IMetadataColumn> columns = metadata.getListColumns();
                    int columnSize = columns.size();

    
                        if("insert".equals(action) || "update".equals(action)){
                            
    stringBuffer.append(TEXT_1);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_3);
    
                            for(int i = 0; i < columnSize; i++){
                                String index = cid + "_" + i;
                                IMetadataColumn column = columns.get(i);
                                String columnName = column.getLabel();
                                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                                boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
 								if(!isPrimitive && ignoreNull) { //begin of skipping null values.
 								
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_6);
    
 								}
                                String crmType = column.getType();
                                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                            
    
                                       if("BIGINT".equals(crmType)){
                                           //Map 2 Java Long
                                           
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_15);
    
                                       }else if("BOOLEAN".equals(crmType)){
                                            //Map 2 Java Boolean
                                            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_24);
    
                                       }else if("CALENDARRULES".equals(crmType) || "PARTYLIST".equals(crmType)){
                                            //Todo: Need to find a better solution.
                                            
    stringBuffer.append(TEXT_25);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_33);
    
                                       }else if("CUSTOMER".equals(crmType) || "LOOKUP".equals(crmType) || "OWNER".equals(crmType)){
                                            //Map 2 Java Document
                                            
    stringBuffer.append(TEXT_34);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_35);
    
                                                   if(javaType == JavaTypesManager.OBJECT){
                                                              
    stringBuffer.append(TEXT_36);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_52);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_57);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_67);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_69);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_74);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_75);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_77);
    
                                                   }else if(javaType == JavaTypesManager.STRING){
                                                              
    stringBuffer.append(TEXT_78);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_84);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_91);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_94);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_96);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_102);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_104);
    
                                                   }else{
                                                        
    stringBuffer.append(TEXT_105);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_112);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_113);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_115);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_117);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_119);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_120);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_121);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_125);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_130);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_131);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_133);
    
                                                   }
                                                
    stringBuffer.append(TEXT_134);
    
                                   }else if("DATETIME".equals(crmType)){
                                             
    
                                                  if(javaType == JavaTypesManager.OBJECT){
                                                             
    stringBuffer.append(TEXT_135);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_148);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_150);
    
                                                  }else if(javaType == JavaTypesManager.DATE){
                                                             
    stringBuffer.append(TEXT_151);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_155);
    
                                                  }else{
                                                             
    stringBuffer.append(TEXT_156);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_163);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_165);
    
                                                  }
                                                
    
                                  }else if("DECIMAL".equals(crmType)){
                                             //Map 2 Java BigDecimal
                                              
    
                                                if(javaType == JavaTypesManager.OBJECT){
                                                             
    stringBuffer.append(TEXT_166);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_168);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_180);
    
                                                }else if(javaType == JavaTypesManager.BIGDECIMAL){
                                                             
    stringBuffer.append(TEXT_181);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_185);
    
                                                }else{
                                                             
    stringBuffer.append(TEXT_186);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_194);
    
                                                }
                                               
    
                                  }else if("DOUBLE".equals(crmType)){
                                              //Map 2 Java Double
                                              
    stringBuffer.append(TEXT_195);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_201);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_203);
    
                                  }else if("ENTITYNAME".equals(crmType) || "MEMO".equals(crmType) || "STRING".equals(crmType)){
                                              //Map 2 Java String
                                              
    stringBuffer.append(TEXT_204);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_206);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_211);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_213);
    
                                  }else if("INTEGER".equals(crmType)){
                                              //Map 2 Java Integer
                                              
    stringBuffer.append(TEXT_214);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_216);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_220);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_222);
    
                                  }else if("MANAGEDPROPERTY".equals(crmType)){
                                              //Map 2 Java Object
                                              
    stringBuffer.append(TEXT_223);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_225);
    
                                  }else if("MONEY".equals(crmType)){
                                              //Map to Java BigDecimal
                                              
    stringBuffer.append(TEXT_226);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_227);
    
                                               if(javaType == JavaTypesManager.OBJECT){
                                                          
    stringBuffer.append(TEXT_228);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_230);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_235);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_239);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_240);
    
                                               }else if(javaType == JavaTypesManager.BIGDECIMAL){
                                                          
    stringBuffer.append(TEXT_241);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_244);
    
                                               }else{
                                                          
    stringBuffer.append(TEXT_245);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_247);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_251);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_252);
    
                                               }
                                               
    stringBuffer.append(TEXT_253);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_255);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_256);
    
                                  }else if("PICKLIST".equals(crmType) || "STATE".equals(crmType) || "STATUS".equals(crmType) ){
                                              //Map to Java Integer
                                              
    stringBuffer.append(TEXT_257);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_260);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_263);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_264);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_266);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_267);
    
                                  }else if("UNIQUEIDENTIFIER".equals(crmType)){
                                              //Map to Java String
                                              
    stringBuffer.append(TEXT_268);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_274);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_275);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_277);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_278);
    
                                  }else{
                                               
    stringBuffer.append(TEXT_279);
    stringBuffer.append( crmType );
    stringBuffer.append(TEXT_280);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_282);
    
                                  }
                                  if(!isPrimitive && ignoreNull) {//end of skipping null values.
 								  
    stringBuffer.append(TEXT_283);
    
 								  }
                        }
                            
    
                                 if("insert".equals(action)){
                                   
    stringBuffer.append(TEXT_284);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append( entityName );
    stringBuffer.append(TEXT_286);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_287);
    
                                 }else{
                                   
    stringBuffer.append(TEXT_288);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append( entityName );
    stringBuffer.append(TEXT_290);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_291);
    
                                 }
                                 
    
                        }else if("delete".equals(action)){
                            
    stringBuffer.append(TEXT_292);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append( entityName );
    stringBuffer.append(TEXT_294);
    stringBuffer.append( connName );
    stringBuffer.append(TEXT_295);
    
                        }else{
                            
    stringBuffer.append(TEXT_296);
    stringBuffer.append( action );
    stringBuffer.append(TEXT_297);
    
                        }
                }
            }
        }
    }

    
        }else{
            String crmOnlineVersion = ElementParameterParser.getValue(node, "__API_VERSION__");
    	  boolean isOnline2016WithOdata="ONLINE".equals(authenticationType) && "API_2016_ODATA".equals(crmOnlineVersion);
    	  if(isOnline2016WithOdata){
    	  
    
    String action = ElementParameterParser.getValue(node,"__ACTION__");
	 boolean emptyLookupIntoNull = "true".equals(ElementParameterParser.getValue(node,"__EMPTY_LOOKUP_TO_NULL__"));
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {//1
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {//2
            List<? extends IConnection> conns = node.getIncomingConnections();
            for (IConnection conn : conns) {//3
					if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
						String connName = conn.getName();
						List<IMetadataColumn> columns = metadata.getListColumns();
                  int sizeColumns = columns.size();
                  String idColumnName = null;
                  
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    
                  if("insert".equals(action) || "update".equals(action)){
                  	List<Map<String, String>> lookupMapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOKUP_MAPPING__");
                  	Map<String,String> lookupMaps = new java.util.HashMap<String,String>();
							if(lookupMapping.size()>0){
								for(Map<String, String> lookupMapper:lookupMapping){
			                    lookupMaps.put(lookupMapper.get("INPUT_COLUMN"),lookupMapper.get("REF_ENTITYSET"));
			                }
			            }
	                    for(int i = 0; i < sizeColumns; i++){
	                			IMetadataColumn column = columns.get(i);
	                			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
	                       	boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
	                       	if("update".equals(action)){
                                if(column.isKey() && idColumnName == null){
                                    idColumnName = column.getLabel();
                                    continue;
                                }
                            }
                            
		  			    			if(lookupMaps.containsKey(column.getLabel())){
                           
    stringBuffer.append(TEXT_301);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_303);
    if(emptyLookupIntoNull) {
    stringBuffer.append(TEXT_304);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_306);
    }
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(lookupMaps.get(column.getLabel()));
    stringBuffer.append(TEXT_310);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_311);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_313);
    
                           }else{
	                           if(!isPrimitive && ignoreNull) {
			  							
    stringBuffer.append(TEXT_314);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_316);
    
			  			    			}
	                           
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_320);
    stringBuffer.append(column.getType());
    stringBuffer.append(TEXT_321);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_323);
    
	                           if(!isPrimitive && ignoreNull) {
			  			    			
    stringBuffer.append(TEXT_324);
    
			  							}
                           }
                			}
	  						}
                    
    stringBuffer.append(TEXT_325);
    stringBuffer.append(action);
    stringBuffer.append(TEXT_326);
    
                   	if("insert".equals(action)){
							
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    
                    	}else if("update".equals(action)){
                    	
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(idColumnName);
    stringBuffer.append(TEXT_334);
    
                    	} else if ("delete".equals(action)){
                    	
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_337);
    
                    	}
                    	
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    
                }//4
            }//3
        }//2
    }//1
    
    
    	  }else{
        
    
    String authType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
    boolean isAPI2011 = ("API_2011").equals(ElementParameterParser.getValue(node,"__API_VERSION__"));
    
    boolean emptyLookupIntoNull = "true".equals(ElementParameterParser.getValue(node,"__EMPTY_LOOKUP_TO_NULL__"));

    String str4nil = "\"\"";
    String entityname = ElementParameterParser.getValue(node, "__ENTITYNAME__").trim();
    String customEntityname = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
    if("CustomEntity".equals(entityname)){
        entityname = customEntityname.replaceAll("\"","");
    }
    entityname = entityname.toLowerCase();
    String action = ElementParameterParser.getValue(node,"__ACTION__");

    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {//1
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {//2
            List<? extends IConnection> conns = node.getIncomingConnections();
            for (IConnection conn : conns) {//3
                if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
                    String connName = conn.getName();
                    List<IMetadataColumn> columns = metadata.getListColumns();
                    int sizeColumns = columns.size();
                    List<Map<String, String>> lookupMapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOKUP_MAPPING__");

                    if(!isAPI2011 || ("ON_PREMISE").equals(authType)){// (2007,on-premise),(2007,online),(2011,on-premise)

                        if("update".equals(action) && sizeColumns == 2 && "ownerid".equals(columns.get(1).getLabel())){
                             action = "reassignOwnerID";
                        }
                        boolean hasOwnerID = false;
                        
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    
                        if("insert".equals(action) || "update".equals(action)){//************
                            List activityEntities = java.util.Arrays.asList(new String[]{"activitypointer","appointment","bulkoperation","campaignactivity","campaignresponse","email","fax","incidentresolution","letter","opportunityclose","orderclose","phonecall","quoteclose","serviceappointment","task"});

                            if("insert".equals(action)){
                            
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    
                            }else if("update".equals(action)){
                            
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    
                            }
                            
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    
                            for(int i = 0; i < sizeColumns; i++){//5
                                IMetadataColumn column = columns.get(i);
                                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                                String entityMethodTemp = column.getLabel();
                                String entityMethod = "";

                                if("update".equals(action) && "ownerid".equals(column.getLabel()))  {
                                    hasOwnerID = true;
                                    continue;
                                }
                                
                                boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
 								if(!isPrimitive && ignoreNull) { //begin of skipping null values.
 								
    stringBuffer.append(TEXT_353);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_355);
    
 								}

                                if(!"Id".equals(column.getLabel())){
                                
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_359);
    
                                    if(lookupMapping.size()>0){
                                        for(Map<String, String> lookupMapper:lookupMapping){
                                            if(column.getLabel().equals(lookupMapper.get("INPUT_COLUMN"))){
                                            
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(lookupMapper.get("TYPE"));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    
                                            }
                                        }
                                    }
                                    
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    
                                    String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                                    if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){//Date
                                    
    stringBuffer.append(TEXT_368);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_373);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append( str4nil );
    stringBuffer.append(TEXT_376);
    
                                    } else {//others
                                    
    stringBuffer.append(TEXT_377);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append( str4nil );
    stringBuffer.append(TEXT_384);
    
                                    }
                                    
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    
                                }else{
                                    String entityIdStr = entityname;
                                    if(activityEntities.contains(entityIdStr)){
                                        entityIdStr = "activity";
                                    }
                                    
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(entityIdStr);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(entityIdStr);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    
                                }
                                if(!isPrimitive && ignoreNull) {//end of skipping null values.
 								
    stringBuffer.append(TEXT_404);
    
 								}
                            }//5
                            if("insert".equals(action)){//#######
                            
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    
                            }else if("update".equals(action)){//#######
                            
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    
                            }//#######
                        }else if("delete".equals(action)){//*************
                        
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    
                        }//************
                        if("reassignOwnerID".equals(action) || ("update".equals(action) && hasOwnerID)){
                        
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    
                        }
                        
    
                    }else{//(2011,on-line)
                        Map<String, String> crmTypeMapping = new HashMap<String, String>();
                        crmTypeMapping.put("BOOLEAN", "bool");
                        crmTypeMapping.put("CUSTOMER", "entityRef");
                        crmTypeMapping.put("DATETIME", "datatime");
                        crmTypeMapping.put("DECIMAL", "bigDecimal");
                        crmTypeMapping.put("DOUBLE", "double");
                        crmTypeMapping.put("INTEGER", "int");
                        crmTypeMapping.put("LOOKUP", "entityRef");
                        crmTypeMapping.put("MEMO", "string");
                        crmTypeMapping.put("MONEY", "money");
                        crmTypeMapping.put("OWNER", "entityRef");
                        crmTypeMapping.put("PARTYLIST", "entityCollection");
                        crmTypeMapping.put("PICKLIST", "optionSetValue");
                        crmTypeMapping.put("STATE", "optionSetValue");
                        crmTypeMapping.put("STATUS", "optionSetValue");
                        crmTypeMapping.put("STRING", "string");
                        crmTypeMapping.put("UNIQUEIDENTIFIER", "guid");
                        crmTypeMapping.put("CALENDARRULES", "entityCollection");
                        crmTypeMapping.put("BIGINT", "long");
                        crmTypeMapping.put("MANAGEDPROPERTY", "booleanManagedProperty");
                        crmTypeMapping.put("ENTITYNAME", "string");

                        if("insert".equals(action) || "update".equals(action)){
                            String ownerColumnName = null;
                            String idColumnName = null;
                            
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    
                            for(int i = 0; i < sizeColumns; i++){
                                IMetadataColumn column = columns.get(i);
                                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                                String crmType = column.getType();
                                String columnName = column.getLabel();
                                if("update".equals(action)){
                                    if("OWNER".equals(crmType)){
                                        ownerColumnName = columnName;
                                        continue;
                                    }
                                    if(column.isKey() && idColumnName == null){
                                        idColumnName = columnName;
                                    }
                                }
                                boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                                if(!isPrimitive && ignoreNull) {
  								//This will skip the null values and won't add them to the request. 
  								
    stringBuffer.append(TEXT_475);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_477);
    
  								}
                                
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_482);
    
                                if(!isPrimitive && !ignoreNull) {
  								//if you want to set null, just skip this step. 
  								
    stringBuffer.append(TEXT_483);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_485);
    
  								}
                                if("entityRef".equals(crmTypeMapping.get(crmType))){
                                    boolean hasFound = false;
                                    if(lookupMapping.size()>0){
                                        for(Map<String, String> lookupMapper:lookupMapping){
                                            if(columnName.equals(lookupMapper.get("INPUT_COLUMN"))){
                                                hasFound = true;
                                                
    stringBuffer.append(TEXT_486);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_488);
    if(emptyLookupIntoNull) {
    stringBuffer.append(TEXT_489);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_491);
    }
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(lookupMapper.get("TYPE"));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    
                                            }
                                        }
                                    }
                                    if(!hasFound){
                                    
    stringBuffer.append(TEXT_500);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_501);
    
                                    }
                                }else if("optionSetValue".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_506);
    
                                }else if("money".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_511);
    
                                }else if("guid".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_516);
    
                                }else if("string".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_521);
    
                                }else if("datatime".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    
                                }else if("bool".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_539);
    
                                }else if("bigDecimal".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_544);
    
                                }else if("int".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_549);
    
                                }else if("long".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_554);
    
                                }else if("double".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_559);
    
                                }else if("entityCollection".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_560);
    
                                }else if("booleanManagedProperty".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_561);
    
                                }else{
                                
    stringBuffer.append(TEXT_562);
    stringBuffer.append(crmType);
    stringBuffer.append(TEXT_563);
    
                                }
                                if(!isPrimitive && !ignoreNull) {
  								//End of setting null values part. 
  								
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    
  								}
                                
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    
                                if(!isPrimitive && ignoreNull) {
  								//End of ignoring null values part. 
  								
    stringBuffer.append(TEXT_569);
    
  								}
                            }
                            
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    if("insert".equals(action)){
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    
                            }else if("update".equals(action)){
                                if(ownerColumnName != null && columns.size() == 2){
                                //don't need to update, just do reassign opertion is enough.
                                }else{
                                
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    
                                }
                                if(ownerColumnName != null){
                                
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(idColumnName);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(ownerColumnName);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    
                                }
                            }
                        }
                        else if("delete".equals(action)){
                        
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_652);
    
                }//4
            }//3
        }//2
    }//1
    
    
        }
        }

    stringBuffer.append(TEXT_653);
    return stringBuffer.toString();
  }
}
