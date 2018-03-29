package org.talend.designer.codegen.translators.databases.ms_sql_server;

import java.util.List;

import org.talend.core.model.metadata.IMetadataColumn;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.utils.NodeUtil;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TMSSqlSCDBeginJava {
  protected static String nl;
  public static synchronized TMSSqlSCDBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMSSqlSCDBeginJava result = new TMSSqlSCDBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "                if(log.is";
  protected final String TEXT_4 = "Enabled())";
  protected final String TEXT_5 = NL + "            log.";
  protected final String TEXT_6 = "(\"";
  protected final String TEXT_7 = " - \" ";
  protected final String TEXT_8 = " + (";
  protected final String TEXT_9 = ") ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "    \tclass BytesLimit65535_";
  protected final String TEXT_12 = "{" + NL + "    \t\tpublic void limitLog4jByte() throws Exception{" + NL + "    \t\t\t";
  protected final String TEXT_13 = NL + "            StringBuilder ";
  protected final String TEXT_14 = " = new StringBuilder();";
  protected final String TEXT_15 = NL + "            ";
  protected final String TEXT_16 = ".append(\"Parameters:\");";
  protected final String TEXT_17 = NL + "                    ";
  protected final String TEXT_18 = ".append(\"";
  protected final String TEXT_19 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_20 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_21 = NL + "                    ";
  protected final String TEXT_22 = ".append(\"";
  protected final String TEXT_23 = "\" + \" = \" + ";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "                ";
  protected final String TEXT_26 = ".append(\" | \");";
  protected final String TEXT_27 = NL + "    \t\t}" + NL + "    \t}" + NL + "    \t" + NL + "        new BytesLimit65535_";
  protected final String TEXT_28 = "().limitLog4jByte();";
  protected final String TEXT_29 = NL + "            StringBuilder ";
  protected final String TEXT_30 = " = new StringBuilder();    ";
  protected final String TEXT_31 = NL + "                    ";
  protected final String TEXT_32 = ".append(";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "                    if(";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = " == null){";
  protected final String TEXT_38 = NL + "                        ";
  protected final String TEXT_39 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_40 = NL + "                        ";
  protected final String TEXT_41 = ".append(";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ");" + NL + "                    }   ";
  protected final String TEXT_44 = NL + "                ";
  protected final String TEXT_45 = ".append(\"|\");";
  protected final String TEXT_46 = NL;
  protected final String TEXT_47 = NL + "        ";
  protected final String TEXT_48 = NL + "    ";
  protected final String TEXT_49 = NL + "    int nb_line_update_";
  protected final String TEXT_50 = " = 0;" + NL + "    int nb_line_inserted_";
  protected final String TEXT_51 = " = 0;" + NL + "    int nb_line_rejected_";
  protected final String TEXT_52 = " = 0;" + NL + "    String tableName_";
  protected final String TEXT_53 = " = null;" + NL + "\tString dbschema_";
  protected final String TEXT_54 = " = null;";
  protected final String TEXT_55 = NL + "\tclass MssqlSCD_Util_";
  protected final String TEXT_56 = "{";
  protected final String TEXT_57 = NL + "\t\t\tpublic void genSearchSetStatment_";
  protected final String TEXT_58 = "(java.sql.PreparedStatement searchingStmt_";
  protected final String TEXT_59 = ",";
  protected final String TEXT_60 = "Struct ";
  protected final String TEXT_61 = ")throws Exception{";
  protected final String TEXT_62 = NL + "            ";
  protected final String TEXT_63 = NL + "\t\t\t}";
  protected final String TEXT_64 = NL + "\t\t\t}";
  protected final String TEXT_65 = NL + "\t\t\tpublic void getSearchResult_";
  protected final String TEXT_66 = "(java.sql.ResultSet searchingResult_";
  protected final String TEXT_67 = ",SCDStruct_";
  protected final String TEXT_68 = " lookUpValue_";
  protected final String TEXT_69 = ",String tmpValue_";
  protected final String TEXT_70 = ",org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_";
  protected final String TEXT_71 = ")throws Exception{";
  protected final String TEXT_72 = NL + "            tmpValue_";
  protected final String TEXT_73 = " = searchingResult_";
  protected final String TEXT_74 = ".getString(";
  protected final String TEXT_75 = ");" + NL + "            if (tmpValue_";
  protected final String TEXT_76 = " != null && tmpValue_";
  protected final String TEXT_77 = ".length() > 0) {" + NL + "                lookUpValue_";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = " = tmpValue_";
  protected final String TEXT_80 = ".charAt(0);" + NL + "            } else {";
  protected final String TEXT_81 = NL + "                    if(tmpValue_";
  protected final String TEXT_82 = " == null) {" + NL + "                        lookUpValue_";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = " = null;" + NL + "                    } else {" + NL + "                        lookUpValue_";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = " = '\\0';" + NL + "                    }";
  protected final String TEXT_87 = NL + "                    if((\"\").equals(tmpValue_";
  protected final String TEXT_88 = ")) {" + NL + "                        lookUpValue_";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = " = '\\0';" + NL + "                    } else {" + NL + "                        throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_91 = "' in '";
  protected final String TEXT_92 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "                    }";
  protected final String TEXT_93 = NL + "            }";
  protected final String TEXT_94 = NL + "             lookUpValue_";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = " = mssqlGTU_";
  protected final String TEXT_97 = ".getDate(searchingResult_";
  protected final String TEXT_98 = ".getMetaData(), searchingResult_";
  protected final String TEXT_99 = ", ";
  protected final String TEXT_100 = ");";
  protected final String TEXT_101 = NL + "            if(searchingResult_";
  protected final String TEXT_102 = ".getObject(";
  protected final String TEXT_103 = ") != null) {" + NL + "                lookUpValue_";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = " = searchingResult_";
  protected final String TEXT_106 = ".get";
  protected final String TEXT_107 = "(";
  protected final String TEXT_108 = ");" + NL + "            }";
  protected final String TEXT_109 = NL + "\t\t\t}";
  protected final String TEXT_110 = NL + "\t\t\t}";
  protected final String TEXT_111 = NL + "\t\t\tpublic void getSearchResult_";
  protected final String TEXT_112 = "(java.sql.ResultSet resultSet_";
  protected final String TEXT_113 = ",SCDSK_";
  protected final String TEXT_114 = " sk_";
  protected final String TEXT_115 = ",SCDStruct_";
  protected final String TEXT_116 = " row_";
  protected final String TEXT_117 = ",String tmpValue_";
  protected final String TEXT_118 = ",org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_";
  protected final String TEXT_119 = ")throws Exception{";
  protected final String TEXT_120 = NL + "                    tmpValue_";
  protected final String TEXT_121 = " = resultSet_";
  protected final String TEXT_122 = ".getString(";
  protected final String TEXT_123 = ");" + NL + "                    if (tmpValue_";
  protected final String TEXT_124 = " != null && tmpValue_";
  protected final String TEXT_125 = ".length() > 0) {";
  protected final String TEXT_126 = NL + "                        ";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = " = tmpValue_";
  protected final String TEXT_129 = ".charAt(0);" + NL + "                    } else {";
  protected final String TEXT_130 = NL + "                            if(tmpValue_";
  protected final String TEXT_131 = " == null) {";
  protected final String TEXT_132 = NL + "                                ";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " = null;" + NL + "                            } else {";
  protected final String TEXT_135 = NL + "                                ";
  protected final String TEXT_136 = ".";
  protected final String TEXT_137 = " = '\\0';" + NL + "                            }";
  protected final String TEXT_138 = NL + "                            if((\"\").equals(tmpValue_";
  protected final String TEXT_139 = ")) {";
  protected final String TEXT_140 = NL + "                                ";
  protected final String TEXT_141 = ".";
  protected final String TEXT_142 = " = '\\0';" + NL + "                            } else {" + NL + "                                throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_143 = "' in '";
  protected final String TEXT_144 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "                            }";
  protected final String TEXT_145 = NL + "                    }";
  protected final String TEXT_146 = NL + "                     ";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " = mssqlGTU_";
  protected final String TEXT_149 = ".getDate(resultSet_";
  protected final String TEXT_150 = ".getMetaData(), resultSet_";
  protected final String TEXT_151 = ", ";
  protected final String TEXT_152 = ");";
  protected final String TEXT_153 = NL + "                    if(resultSet_";
  protected final String TEXT_154 = ".getObject(";
  protected final String TEXT_155 = ") != null) {";
  protected final String TEXT_156 = NL + "                        ";
  protected final String TEXT_157 = ".";
  protected final String TEXT_158 = " = resultSet_";
  protected final String TEXT_159 = ".get";
  protected final String TEXT_160 = "(";
  protected final String TEXT_161 = ");" + NL + "                    }";
  protected final String TEXT_162 = NL + "\t\t\t}";
  protected final String TEXT_163 = NL + "\t\t\t}";
  protected final String TEXT_164 = NL + "\t\t\tpublic ";
  protected final String TEXT_165 = "int";
  protected final String TEXT_166 = "void";
  protected final String TEXT_167 = "  genInsertSetStatment_";
  protected final String TEXT_168 = "(" + NL + "\t\t\t\tjava.sql.PreparedStatement insertionStatement_";
  protected final String TEXT_169 = ",";
  protected final String TEXT_170 = "Struct ";
  protected final String TEXT_171 = "," + NL + "\t\t\t\t";
  protected final String TEXT_172 = " nextSurrogateKey_";
  protected final String TEXT_173 = ")throws Exception{";
  protected final String TEXT_174 = NL + "                    ";
  protected final String TEXT_175 = NL + "                    ";
  protected final String TEXT_176 = " skRoutine_";
  protected final String TEXT_177 = " = ";
  protected final String TEXT_178 = ";";
  protected final String TEXT_179 = NL + "                    ";
  protected final String TEXT_180 = "                    ";
  protected final String TEXT_181 = NL + "                    ";
  protected final String TEXT_182 = NL + "                    nextSurrogateKey_";
  protected final String TEXT_183 = "++;";
  protected final String TEXT_184 = NL + "                    ";
  protected final String TEXT_185 = NL + "                ";
  protected final String TEXT_186 = " version_";
  protected final String TEXT_187 = " = 1;";
  protected final String TEXT_188 = NL + "                ";
  protected final String TEXT_189 = NL + "                    ";
  protected final String TEXT_190 = NL + "\t\t\t\t\treturn nextSurrogateKey_";
  protected final String TEXT_191 = ";";
  protected final String TEXT_192 = NL + "\t\t\t}";
  protected final String TEXT_193 = NL + "\t\t\t\t\treturn nextSurrogateKey_";
  protected final String TEXT_194 = ";";
  protected final String TEXT_195 = NL + "\t\t\t}";
  protected final String TEXT_196 = NL + "\t\tpublic boolean genType1Condition_";
  protected final String TEXT_197 = "(SCDStruct_";
  protected final String TEXT_198 = " lookUpValue_";
  protected final String TEXT_199 = ",";
  protected final String TEXT_200 = "Struct ";
  protected final String TEXT_201 = "){";
  protected final String TEXT_202 = NL + "\t\t\treturn ";
  protected final String TEXT_203 = ";" + NL + "\t\t}";
  protected final String TEXT_204 = NL + "\t\t\treturn ";
  protected final String TEXT_205 = ";" + NL + "\t\t}";
  protected final String TEXT_206 = NL + "\t\t\tpublic void genUpdateType1SetStatment_";
  protected final String TEXT_207 = "(java.sql.PreparedStatement updateForType1_";
  protected final String TEXT_208 = ",";
  protected final String TEXT_209 = "Struct ";
  protected final String TEXT_210 = ")throws Exception{\t";
  protected final String TEXT_211 = NL + "                ";
  protected final String TEXT_212 = NL + "\t\t\t}";
  protected final String TEXT_213 = NL + "\t\t\tpublic void genUpdateType1SetStatment_";
  protected final String TEXT_214 = "(java.sql.PreparedStatement updateForType1_";
  protected final String TEXT_215 = ",";
  protected final String TEXT_216 = "Struct ";
  protected final String TEXT_217 = ")throws Exception{\t";
  protected final String TEXT_218 = NL + "                ";
  protected final String TEXT_219 = NL + "\t\t\t}";
  protected final String TEXT_220 = NL + "\t\t\t}";
  protected final String TEXT_221 = NL + "\t\tpublic boolean genType2Condition_";
  protected final String TEXT_222 = "(SCDStruct_";
  protected final String TEXT_223 = " lookUpValue_";
  protected final String TEXT_224 = ",";
  protected final String TEXT_225 = "Struct ";
  protected final String TEXT_226 = "){";
  protected final String TEXT_227 = NL + "\t\t\treturn ";
  protected final String TEXT_228 = ";" + NL + "\t\t}";
  protected final String TEXT_229 = NL + "\t\t\treturn ";
  protected final String TEXT_230 = ";" + NL + "\t\t}";
  protected final String TEXT_231 = NL + "\t\t\tpublic void genUpdateType2SetStatment_0(java.sql.PreparedStatement updateForType2_";
  protected final String TEXT_232 = ",";
  protected final String TEXT_233 = "Struct ";
  protected final String TEXT_234 = ")throws Exception{" + NL + "            \t";
  protected final String TEXT_235 = NL + "\t\t\tpublic void genUpdateType2SetStatment_";
  protected final String TEXT_236 = "(java.sql.PreparedStatement updateForType2_";
  protected final String TEXT_237 = ",";
  protected final String TEXT_238 = "Struct ";
  protected final String TEXT_239 = ")throws Exception{\t";
  protected final String TEXT_240 = NL + "            \t";
  protected final String TEXT_241 = NL + "\t\t\t}";
  protected final String TEXT_242 = NL + "\t\t\t}";
  protected final String TEXT_243 = NL + "\t\t\tpublic ";
  protected final String TEXT_244 = "int";
  protected final String TEXT_245 = "void";
  protected final String TEXT_246 = " genInsertType2SetStatment_";
  protected final String TEXT_247 = "(java.sql.PreparedStatement insertionStatement_";
  protected final String TEXT_248 = "," + NL + "\t\t\t\t";
  protected final String TEXT_249 = "Struct ";
  protected final String TEXT_250 = ",";
  protected final String TEXT_251 = " nextSurrogateKey_";
  protected final String TEXT_252 = NL + "\t\t\t\t\t,SCDStruct_";
  protected final String TEXT_253 = " lookUpValue_";
  protected final String TEXT_254 = ")throws Exception{\t";
  protected final String TEXT_255 = NL + "                        ";
  protected final String TEXT_256 = NL + "                        ";
  protected final String TEXT_257 = " skRoutine_";
  protected final String TEXT_258 = " = ";
  protected final String TEXT_259 = ";";
  protected final String TEXT_260 = NL + "                        ";
  protected final String TEXT_261 = "                    ";
  protected final String TEXT_262 = NL + "                        ";
  protected final String TEXT_263 = NL + "                        nextSurrogateKey_";
  protected final String TEXT_264 = "++;";
  protected final String TEXT_265 = NL + "                        ";
  protected final String TEXT_266 = NL + "                    ";
  protected final String TEXT_267 = " maxVersion_";
  protected final String TEXT_268 = " = lookUpValue_";
  protected final String TEXT_269 = ".";
  protected final String TEXT_270 = " + 1;";
  protected final String TEXT_271 = NL + "                        lookUpValue_";
  protected final String TEXT_272 = ".";
  protected final String TEXT_273 = " = lookUpValue_";
  protected final String TEXT_274 = ".";
  protected final String TEXT_275 = " + 1;                            ";
  protected final String TEXT_276 = NL + "                    ";
  protected final String TEXT_277 = NL + "                        ";
  protected final String TEXT_278 = NL + "\t\t\t\t\treturn nextSurrogateKey_";
  protected final String TEXT_279 = ";";
  protected final String TEXT_280 = NL + "\t\t\t}";
  protected final String TEXT_281 = NL + "\t\t\t\t\treturn nextSurrogateKey_";
  protected final String TEXT_282 = ";";
  protected final String TEXT_283 = NL + "\t\t\t}";
  protected final String TEXT_284 = NL + "\t\t\tpublic boolean genType3Condition_";
  protected final String TEXT_285 = "(SCDStruct_";
  protected final String TEXT_286 = " lookUpValue_";
  protected final String TEXT_287 = ",";
  protected final String TEXT_288 = "Struct ";
  protected final String TEXT_289 = "){";
  protected final String TEXT_290 = NL + "\t\t\t\treturn ";
  protected final String TEXT_291 = ";" + NL + "\t\t\t}";
  protected final String TEXT_292 = NL + "\t\t\t\treturn ";
  protected final String TEXT_293 = ";" + NL + "\t\t\t}";
  protected final String TEXT_294 = NL + "\t\t\tpublic void genUpdateType3SetStatment_";
  protected final String TEXT_295 = "(SCDStruct_";
  protected final String TEXT_296 = " lookUpValue_";
  protected final String TEXT_297 = ",java.sql.PreparedStatement updateForType3_";
  protected final String TEXT_298 = ",";
  protected final String TEXT_299 = "Struct ";
  protected final String TEXT_300 = ")throws Exception{\t";
  protected final String TEXT_301 = NL + "                ";
  protected final String TEXT_302 = NL + "\t\t\t}";
  protected final String TEXT_303 = NL + "\t\t\tpublic void genUpdateType3SetStatment_";
  protected final String TEXT_304 = "(SCDStruct_";
  protected final String TEXT_305 = " lookUpValue_";
  protected final String TEXT_306 = ",java.sql.PreparedStatement updateForType3_";
  protected final String TEXT_307 = ",";
  protected final String TEXT_308 = "Struct ";
  protected final String TEXT_309 = ")throws Exception{\t";
  protected final String TEXT_310 = NL + "                if (";
  protected final String TEXT_311 = ") {";
  protected final String TEXT_312 = NL + "                ";
  protected final String TEXT_313 = NL + "               \t} else {" + NL + "               \t";
  protected final String TEXT_314 = NL + "               \t}";
  protected final String TEXT_315 = NL + "               \t";
  protected final String TEXT_316 = NL + "\t\t\t}";
  protected final String TEXT_317 = NL + "\t\t\tpublic void genUpdateType3SetStatment_";
  protected final String TEXT_318 = "(SCDStruct_";
  protected final String TEXT_319 = " lookUpValue_";
  protected final String TEXT_320 = ",java.sql.PreparedStatement updateForType3_";
  protected final String TEXT_321 = ",";
  protected final String TEXT_322 = "Struct ";
  protected final String TEXT_323 = ")throws Exception{\t";
  protected final String TEXT_324 = NL + "                ";
  protected final String TEXT_325 = NL + "\t\t\t}";
  protected final String TEXT_326 = NL + "\t\t\t}";
  protected final String TEXT_327 = NL + "\t\t\tpublic void putFlowValueToReject_";
  protected final String TEXT_328 = "(";
  protected final String TEXT_329 = "Struct ";
  protected final String TEXT_330 = ", ";
  protected final String TEXT_331 = "Struct ";
  protected final String TEXT_332 = "){\t";
  protected final String TEXT_333 = NL + "                    ";
  protected final String TEXT_334 = ".";
  protected final String TEXT_335 = " = ";
  protected final String TEXT_336 = ".";
  protected final String TEXT_337 = ";";
  protected final String TEXT_338 = NL + "\t\t\t}";
  protected final String TEXT_339 = NL + "\t\t\t}";
  protected final String TEXT_340 = NL + "\t}" + NL + "\tMssqlSCD_Util_";
  protected final String TEXT_341 = " mssqlSCD_Util_";
  protected final String TEXT_342 = "=new MssqlSCD_Util_";
  protected final String TEXT_343 = "();";
  protected final String TEXT_344 = NL + "java.sql.Connection conn_";
  protected final String TEXT_345 = " = null;";
  protected final String TEXT_346 = NL + "String dbUser_";
  protected final String TEXT_347 = " = null;";
  protected final String TEXT_348 = NL + "\tdbschema_";
  protected final String TEXT_349 = " = (String)globalMap.get(\"";
  protected final String TEXT_350 = "\");" + NL + "\tconn_";
  protected final String TEXT_351 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_352 = "\");" + NL + "\t";
  protected final String TEXT_353 = NL + "\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_354 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\tif (null != dataSources_";
  protected final String TEXT_355 = ") {" + NL + "\t\t\tString dsAlias_";
  protected final String TEXT_356 = " = ";
  protected final String TEXT_357 = ";" + NL + "    \t\tif (dataSources_";
  protected final String TEXT_358 = ".get(dsAlias_";
  protected final String TEXT_359 = ") == null) {" + NL + "       \t\t\tthrow new RuntimeException(\"No DataSource with alias: \" + dsAlias_";
  protected final String TEXT_360 = " + \" available!\");" + NL + "          \t}" + NL + "    \t\tconn_";
  protected final String TEXT_361 = " = dataSources_";
  protected final String TEXT_362 = ".get(dsAlias_";
  protected final String TEXT_363 = ").getConnection();" + NL + "\t\t} else {" + NL + "\t";
  protected final String TEXT_364 = NL + "    dbschema_";
  protected final String TEXT_365 = " = ";
  protected final String TEXT_366 = ";";
  protected final String TEXT_367 = NL + "    String driverClass_";
  protected final String TEXT_368 = " = \"net.sourceforge.jtds.jdbc.Driver\";";
  protected final String TEXT_369 = NL + "    String driverClass_";
  protected final String TEXT_370 = " = \"com.microsoft.sqlserver.jdbc.SQLServerDriver\";";
  protected final String TEXT_371 = NL + "\t";
  protected final String TEXT_372 = NL + "    java.lang.Class.forName(driverClass_";
  protected final String TEXT_373 = ");" + NL + "    String port_";
  protected final String TEXT_374 = " = ";
  protected final String TEXT_375 = ";" + NL + "    String dbname_";
  protected final String TEXT_376 = " = ";
  protected final String TEXT_377 = " ;";
  protected final String TEXT_378 = NL + "    String url_";
  protected final String TEXT_379 = " = \"jdbc:jtds:sqlserver://\" + ";
  protected final String TEXT_380 = " ;";
  protected final String TEXT_381 = NL + "    String url_";
  protected final String TEXT_382 = " = \"jdbc:sqlserver://\" + ";
  protected final String TEXT_383 = " ;";
  protected final String TEXT_384 = " " + NL + "    if (!\"\".equals(port_";
  protected final String TEXT_385 = ")) {" + NL + "    \turl_";
  protected final String TEXT_386 = " += \":\" + ";
  protected final String TEXT_387 = ";" + NL + "    }" + NL + "    if (!\"\".equals(dbname_";
  protected final String TEXT_388 = ")) {";
  protected final String TEXT_389 = NL + "\t\t\t\turl_";
  protected final String TEXT_390 = " += \"//\" + ";
  protected final String TEXT_391 = "; " + NL + "\t";
  protected final String TEXT_392 = "\t\t    " + NL + "\t\t    \turl_";
  protected final String TEXT_393 = " += \";databaseName=\" + ";
  protected final String TEXT_394 = "; " + NL + "\t";
  protected final String TEXT_395 = NL + "    }" + NL + "    url_";
  protected final String TEXT_396 = " += \";appName=\" + projectName + \";\" + ";
  protected final String TEXT_397 = ";" + NL + "    dbUser_";
  protected final String TEXT_398 = " = ";
  protected final String TEXT_399 = ";" + NL;
  protected final String TEXT_400 = NL;
  protected final String TEXT_401 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_402 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_403 = ");";
  protected final String TEXT_404 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_405 = " = ";
  protected final String TEXT_406 = "; ";
  protected final String TEXT_407 = NL + NL + "    String dbPwd_";
  protected final String TEXT_408 = " = decryptedPassword_";
  protected final String TEXT_409 = ";";
  protected final String TEXT_410 = "\t" + NL + "    conn_";
  protected final String TEXT_411 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_412 = ",dbUser_";
  protected final String TEXT_413 = ",dbPwd_";
  protected final String TEXT_414 = ");";
  protected final String TEXT_415 = NL + "\t";
  protected final String TEXT_416 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_417 = NL + NL + "    if(dbschema_";
  protected final String TEXT_418 = " == null || dbschema_";
  protected final String TEXT_419 = ".trim().length() == 0) {" + NL + "        tableName_";
  protected final String TEXT_420 = " = ";
  protected final String TEXT_421 = ";" + NL + "    } else {" + NL + "        tableName_";
  protected final String TEXT_422 = " = dbschema_";
  protected final String TEXT_423 = " + \"].[\" + ";
  protected final String TEXT_424 = ";" + NL + "    }" + NL + "\torg.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_";
  protected final String TEXT_425 = " = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();\t" + NL + "    String tmpValue_";
  protected final String TEXT_426 = " = null;    ";
  protected final String TEXT_427 = NL + "        String searching_";
  protected final String TEXT_428 = " = \"";
  protected final String TEXT_429 = "\";" + NL + "        java.sql.PreparedStatement searchingStmt_";
  protected final String TEXT_430 = " = conn_";
  protected final String TEXT_431 = ".prepareStatement(searching_";
  protected final String TEXT_432 = ");" + NL + "        java.sql.ResultSet searchingResult_";
  protected final String TEXT_433 = " = null;";
  protected final String TEXT_434 = NL + "        String search_";
  protected final String TEXT_435 = " = \"";
  protected final String TEXT_436 = "\";" + NL + "        java.sql.Statement statement_";
  protected final String TEXT_437 = " = conn_";
  protected final String TEXT_438 = ".createStatement();" + NL + "        java.sql.ResultSet resultSet_";
  protected final String TEXT_439 = " = statement_";
  protected final String TEXT_440 = ".executeQuery(search_";
  protected final String TEXT_441 = ");" + NL + "        java.util.Map<SCDSK_";
  protected final String TEXT_442 = ", SCDStruct_";
  protected final String TEXT_443 = "> cache_";
  protected final String TEXT_444 = " = new java.util.HashMap<SCDSK_";
  protected final String TEXT_445 = ", SCDStruct_";
  protected final String TEXT_446 = ">();" + NL + "        while(resultSet_";
  protected final String TEXT_447 = ".next()) {" + NL + "            SCDSK_";
  protected final String TEXT_448 = " sk_";
  protected final String TEXT_449 = " = new SCDSK_";
  protected final String TEXT_450 = "();" + NL + "            SCDStruct_";
  protected final String TEXT_451 = " row_";
  protected final String TEXT_452 = " = new SCDStruct_";
  protected final String TEXT_453 = "();";
  protected final String TEXT_454 = NL + "                    tmpValue_";
  protected final String TEXT_455 = " = resultSet_";
  protected final String TEXT_456 = ".getString(";
  protected final String TEXT_457 = ");" + NL + "                    if (tmpValue_";
  protected final String TEXT_458 = " != null && tmpValue_";
  protected final String TEXT_459 = ".length() > 0) {";
  protected final String TEXT_460 = NL + "                        ";
  protected final String TEXT_461 = ".";
  protected final String TEXT_462 = " = tmpValue_";
  protected final String TEXT_463 = ".charAt(0);" + NL + "                    } else {";
  protected final String TEXT_464 = NL + "                            if(tmpValue_";
  protected final String TEXT_465 = " == null) {";
  protected final String TEXT_466 = NL + "                                ";
  protected final String TEXT_467 = ".";
  protected final String TEXT_468 = " = null;" + NL + "                            } else {";
  protected final String TEXT_469 = NL + "                                ";
  protected final String TEXT_470 = ".";
  protected final String TEXT_471 = " = '\\0';" + NL + "                            }";
  protected final String TEXT_472 = NL + "                            if((\"\").equals(tmpValue_";
  protected final String TEXT_473 = ")) {";
  protected final String TEXT_474 = NL + "                                ";
  protected final String TEXT_475 = ".";
  protected final String TEXT_476 = " = '\\0';" + NL + "                            } else {" + NL + "                                throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_477 = "' in '";
  protected final String TEXT_478 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "                            }";
  protected final String TEXT_479 = NL + "                    }";
  protected final String TEXT_480 = NL + "                     ";
  protected final String TEXT_481 = ".";
  protected final String TEXT_482 = " = mssqlGTU_";
  protected final String TEXT_483 = ".getDate(resultSet_";
  protected final String TEXT_484 = ".getMetaData(), resultSet_";
  protected final String TEXT_485 = ", ";
  protected final String TEXT_486 = ");";
  protected final String TEXT_487 = NL + "                    if(resultSet_";
  protected final String TEXT_488 = ".getObject(";
  protected final String TEXT_489 = ") != null) {";
  protected final String TEXT_490 = NL + "                        ";
  protected final String TEXT_491 = ".";
  protected final String TEXT_492 = " = resultSet_";
  protected final String TEXT_493 = ".get";
  protected final String TEXT_494 = "(";
  protected final String TEXT_495 = ");" + NL + "                    }";
  protected final String TEXT_496 = NL + "\t\t\t mssqlSCD_Util_";
  protected final String TEXT_497 = ".getSearchResult_";
  protected final String TEXT_498 = "(resultSet_";
  protected final String TEXT_499 = ", sk_";
  protected final String TEXT_500 = ", row_";
  protected final String TEXT_501 = ", tmpValue_";
  protected final String TEXT_502 = ", mssqlGTU_";
  protected final String TEXT_503 = ");";
  protected final String TEXT_504 = NL + "            cache_";
  protected final String TEXT_505 = ".put(sk_";
  protected final String TEXT_506 = ", row_";
  protected final String TEXT_507 = ");" + NL + "        }" + NL + "        resultSet_";
  protected final String TEXT_508 = ".close();" + NL + "        statement_";
  protected final String TEXT_509 = ".close();";
  protected final String TEXT_510 = NL + "            System.out.println(\"[";
  protected final String TEXT_511 = "] comparison cache loaded\");";
  protected final String TEXT_512 = NL + "        ";
  protected final String TEXT_513 = " nextSurrogateKey_";
  protected final String TEXT_514 = " = 1;";
  protected final String TEXT_515 = NL + "            if(cache_";
  protected final String TEXT_516 = ".size() > 0) {";
  protected final String TEXT_517 = NL + "        String tmpQuery_";
  protected final String TEXT_518 = " = \"SELECT MAX([";
  protected final String TEXT_519 = "]) FROM [\" + tableName_";
  protected final String TEXT_520 = " + \"]\";" + NL + "        java.sql.Statement tmpStmt_";
  protected final String TEXT_521 = " = conn_";
  protected final String TEXT_522 = ".createStatement();" + NL + "        java.sql.ResultSet tmpRS_";
  protected final String TEXT_523 = " = tmpStmt_";
  protected final String TEXT_524 = ".executeQuery(tmpQuery_";
  protected final String TEXT_525 = ");";
  protected final String TEXT_526 = NL + "        if(tmpRS_";
  protected final String TEXT_527 = ".next() && tmpRS_";
  protected final String TEXT_528 = ".getObject(1) != null) {" + NL + "            nextSurrogateKey_";
  protected final String TEXT_529 = " = tmpRS_";
  protected final String TEXT_530 = ".get";
  protected final String TEXT_531 = "(1) + 1;" + NL + "        }" + NL + "        tmpRS_";
  protected final String TEXT_532 = ".close();" + NL + "        tmpStmt_";
  protected final String TEXT_533 = ".close();";
  protected final String TEXT_534 = NL + "            }            ";
  protected final String TEXT_535 = NL + "    String insertionSQL_";
  protected final String TEXT_536 = " = \"";
  protected final String TEXT_537 = "\";" + NL + "    java.sql.PreparedStatement insertionStatement_";
  protected final String TEXT_538 = " = conn_";
  protected final String TEXT_539 = ".prepareStatement(insertionSQL_";
  protected final String TEXT_540 = ");";
  protected final String TEXT_541 = NL + "            insertionStatement_";
  protected final String TEXT_542 = ".setTimestamp(";
  protected final String TEXT_543 = ", new java.sql.Timestamp(start_Hash.get(\"";
  protected final String TEXT_544 = "\")));";
  protected final String TEXT_545 = NL + "            insertionStatement_";
  protected final String TEXT_546 = ".setNull(";
  protected final String TEXT_547 = ", java.sql.Types.DATE);";
  protected final String TEXT_548 = NL + "            String endDateTimeDetail_";
  protected final String TEXT_549 = " = ";
  protected final String TEXT_550 = ";" + NL + "            String datePattern_";
  protected final String TEXT_551 = " = \"yyyy-MM-dd\";" + NL + "            if(endDateTimeDetail_";
  protected final String TEXT_552 = ".length()>0){" + NL + "            \tendDateTimeDetail_";
  protected final String TEXT_553 = " = \" \"+endDateTimeDetail_";
  protected final String TEXT_554 = ";" + NL + "            \tdatePattern_";
  protected final String TEXT_555 = " = \"yyyy-MM-dd HH:mm:ss\";" + NL + "            }" + NL + "            insertionStatement_";
  protected final String TEXT_556 = ".setTimestamp(";
  protected final String TEXT_557 = ", new java.sql.Timestamp(new java.text.SimpleDateFormat(datePattern_";
  protected final String TEXT_558 = ").parse(";
  protected final String TEXT_559 = " + \"-01-01\"+endDateTimeDetail_";
  protected final String TEXT_560 = ").getTime()));";
  protected final String TEXT_561 = NL + "        String updateSQLForType1_";
  protected final String TEXT_562 = " = \"";
  protected final String TEXT_563 = "\";" + NL + "        java.sql.PreparedStatement updateForType1_";
  protected final String TEXT_564 = " = conn_";
  protected final String TEXT_565 = ".prepareStatement(updateSQLForType1_";
  protected final String TEXT_566 = ");        ";
  protected final String TEXT_567 = NL + "        String updateSQLForType2_";
  protected final String TEXT_568 = " = \"";
  protected final String TEXT_569 = "\";" + NL + "        java.sql.PreparedStatement updateForType2_";
  protected final String TEXT_570 = " = conn_";
  protected final String TEXT_571 = ".prepareStatement(updateSQLForType2_";
  protected final String TEXT_572 = ");";
  protected final String TEXT_573 = NL + "            updateForType2_";
  protected final String TEXT_574 = ".setTimestamp(1, new java.sql.Timestamp(start_Hash.get(\"";
  protected final String TEXT_575 = "\")));";
  protected final String TEXT_576 = NL + "        String updateSQLForType3_";
  protected final String TEXT_577 = " = \"";
  protected final String TEXT_578 = "\";" + NL + "        java.sql.PreparedStatement updateForType3_";
  protected final String TEXT_579 = " = conn_";
  protected final String TEXT_580 = ".prepareStatement(updateSQLForType3_";
  protected final String TEXT_581 = ");";
  protected final String TEXT_582 = NL + "    ";
  protected final String TEXT_583 = NL + "        SCDSK_";
  protected final String TEXT_584 = " lookUpKey_";
  protected final String TEXT_585 = " = null;        ";
  protected final String TEXT_586 = NL + "    SCDStruct_";
  protected final String TEXT_587 = " lookUpValue_";
  protected final String TEXT_588 = " = null;";
  protected final String TEXT_589 = NL;

    public static final String DB2 = "DB2";
    public static final String INGRES = "INGRES";    
    public static final String MSSQL = "MSSQL";
    public static final String MYSQL = "MYSQL";
    public static final String NETEZZA = "NETEZZA";
    public static final String ORACLE = "ORACLE";
    public static final String POSTGRESQL = "POSTGRESQL";
    public static final String POSTGREPLUS = "POSTGREPLUS";
    public static final String SYBASE = "SYBASE";
    public static final String INFORMIX = "INFORMIX";
    public static final String VERTICA = "VERTICA";
    public static final String TERADATA = "TERADATA";
	private static Map<String, SCDManager> managerMap = new HashMap<String, SCDManager>();
    public class Column {
        private String labelName;
        private String columnName;
        private String javaType;
        private String talendType;
        private String dbType;
        private boolean isNullable;
        private boolean isKey;
        public Column(String columnName, String javaType) {
            this.columnName = columnName;
            this.javaType = javaType;
        }
        public Column(IMetadataColumn column) {
            labelName = column.getLabel();
            columnName = column.getOriginalDbColumnName();
            javaType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
            talendType = column.getTalendType();
            dbType = column.getType();
            isNullable = column.isNullable();
            isKey = column.isKey();
        }
        public String getLabelName() {
            return labelName;
        }
        public String getColumnName() {
            return columnName;
        }
        public String getJavaType() {
            return javaType;
        }
        public String getTalendType() {
            return talendType;
        }
        public String getDbType() {
            if(dbType==null){
                return "";
            }
            return dbType;
        }
        public boolean isNullable() {
            return isNullable;
        }
        public boolean isKey() {
            return isKey;
        }
    }
    
    public class InfromixSCDManager extends SCDManager {
    	
    	  public InfromixSCDManager(String cid) {
              super(cid);
          }
          protected String getDBMSId() {
              return "informix_id";
          }        
          protected String getLProtectedChar() {
              return "";
          }
          protected String getRProtectedChar() {
              return "";
          }
          protected String getSequence(String surrogateKeySequence) {
              return "+ \"" + surrogateKeySequence + "\" + \".nextval";
          }
          protected String getIncrement() {
              return "";
          }        
          protected String getDate(String endDateValue) {
              return "TO_DATE('\" + " + endDateValue + " + \"-01-01', 'yyyy-mm-dd')";
          }        
          protected String getYear(String endDateField) {
              return "EXTRACT(YEAR FROM " + getLProtectedChar() + endDateField + getRProtectedChar() + ")";
          }
          protected String getActiveFieldTrueValue(JavaType activeFieldType) {
              if(activeFieldType == JavaTypesManager.STRING) {
                  return "'true'";
              } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                  return "'t'";
              } else {
                  return "1";
              }            
          }
          protected String getActiveFieldFalseValue(JavaType activeFieldType) {
              if(activeFieldType == JavaTypesManager.STRING) {
                  return "'false'";
              } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                  return "'f'";
              } else {
                  return "0";
              }            
          }        
    	
    }
    
    public class SCDConfiger {
        private String surrogateKeyField;
        private String surrogateKeyFieldType;
        private String surrogateKeyValueType;
        private String surrogateKeySequence;
        private String surrogateKeyInputField;
        private String surrogateKeyRoutine;
        private List<Column> sourceKeys;
        private boolean isEnableType0;
        private boolean isEnableType1;
        private boolean isEnableType2;
        private boolean isEnableType3;
        private DimensionType0Configer dimensionType0Configer;
        private DimensionType1Configer dimensionType1Configer;
        private DimensionType2Configer dimensionType2Configer;
        private DimensionType3Configer dimensionType3Configer;
        public SCDConfiger(List<Column> sourceKeys) {
            this.sourceKeys = sourceKeys;
        }
        public void setSurrogateKeyFieldType(String surrogateKeyFieldType) {
            this.surrogateKeyFieldType = surrogateKeyFieldType;
        }
        public String getSurrogateKeyFieldType() {
            return surrogateKeyFieldType;
        }
        public void setSurrogateKeyField(String surrogateKeyField) {
            this.surrogateKeyField = surrogateKeyField;
        }
        public String getSurrogateKeyField() {
            return surrogateKeyField;
        }
        public void setSurrogateKeyValueType(String surrogateKeyValueType) {
            this.surrogateKeyValueType = surrogateKeyValueType;
        }
        public String getSurrogateKeyValueType() {
            return surrogateKeyValueType;
        }
        public void setSurrogateKeySequence(String surrogateKeySequence) {
            this.surrogateKeySequence = surrogateKeySequence;
        }
        public String getSurrogateKeySequence() {
            return surrogateKeySequence;
        }
        public void setSurrogateKeyInputField(String surrogateKeyInputField) {
            this.surrogateKeyInputField = surrogateKeyInputField;
        }
        public String getSurrogateKeyInputField() {
            return surrogateKeyInputField;
        }
        public void setSurrogateKeyRoutine(String surrogateKeyRoutine) {
            this.surrogateKeyRoutine = surrogateKeyRoutine;
        }
        public String getSurrogateKeyRoutine() {
            return surrogateKeyRoutine;
        }
        public void setEnableType0(boolean isEnableType0) {
            this.isEnableType0 = isEnableType0;
        }
        public boolean isEnableType0() {
            return isEnableType0;
        }
        public void setEnableType1(boolean isEnableType1) {
            this.isEnableType1 = isEnableType1;
        }
        public boolean isEnableType1() {
            return isEnableType1;
        }
        public void setEnableType2(boolean isEnableType2) {
            this.isEnableType2 = isEnableType2;
        }
        public boolean isEnableType2() {
            return isEnableType2;
        }
        public void setEnableType3(boolean isEnableType3) {
            this.isEnableType3 = isEnableType3;
        }
        public boolean isEnableType3() {
            return isEnableType3;
        }
        public void setDimensionType0Configer(DimensionType0Configer dimensionType0Configer) {
            this.dimensionType0Configer = dimensionType0Configer;
        }
        public DimensionType0Configer getDimensionType0Configer() {
            return dimensionType0Configer;
        }
        public void setDimensionType1Configer(DimensionType1Configer dimensionType1Configer) {
            this.dimensionType1Configer = dimensionType1Configer;
        }
        public DimensionType1Configer getDimensionType1Configer() {
            return dimensionType1Configer;
        }
        public void setDimensionType2Configer(DimensionType2Configer dimensionType2Configer) {
            this.dimensionType2Configer = dimensionType2Configer;
        }
        public DimensionType2Configer getDimensionType2Configer() {
            return dimensionType2Configer;
        }
        public void setDimensionType3Configer(DimensionType3Configer dimensionType3Configer) {
            this.dimensionType3Configer = dimensionType3Configer;
        }
        public DimensionType3Configer getDimensionType3Configer() {
            return dimensionType3Configer;
        }
        public List<Column> getSourceKeys() {
            return sourceKeys;
        }
    }
    public class DimensionType0Configer {
        private List<Column> dimensionAttributes;
        public DimensionType0Configer(List<Column> dimensionAttributes) {
            this.dimensionAttributes = dimensionAttributes;
        }
        public List<Column> getDimensionAttributes() {
            return dimensionAttributes;
        }
    }
    public class DimensionType1Configer {
        private List<Column> dimensionAttributes;
        private boolean isOnlyUpdateActive;
        public DimensionType1Configer(List<Column> dimensionAttributes) {
            this.dimensionAttributes = dimensionAttributes;
        }
        public List<Column> getDimensionAttributes() {
            return dimensionAttributes;
        }
        public void setOnlyUpdateActive(boolean isOnlyUpdateActive) {
            this.isOnlyUpdateActive = isOnlyUpdateActive;
        }
        public boolean isOnlyUpdateActive() {
            return isOnlyUpdateActive;
        }
    }
    public class DimensionType2Configer {
        private List<Column> dimensionAttributes;
        private String startDateField;
        private String startDateValueType;
        private String startDateValue;
        private String endDateField;
        private String endDateValueType;
        private String endDateValue;
        private boolean isEnableVersion;
        private String versionField;
        private String versionFieldType;
        private boolean isEnableActive;
        private String activeField;
        private JavaType activeFieldType;        
        public DimensionType2Configer(List<Column> dimensionAttributes) {
            this.dimensionAttributes = dimensionAttributes;
        }
        public void setStartDateField(String startDateField) {
            this.startDateField = startDateField;
        }
        public String getStartDateField() {
            return startDateField;
        }
        public void setStartDateValueType(String startDateValueType) {
            this.startDateValueType = startDateValueType;
        }
        public String getStartDateValueType() {
            return startDateValueType;
        }
        public void setStartDateValue(String startDateValue) {
            this.startDateValue = startDateValue;
        }
        public String getStartDateValue() {
            return startDateValue;
        }
        public void setEndDateField(String endDateField) {
            this.endDateField = endDateField;
        }
        public String getEndDateField() {
            return endDateField;
        }
        public void setEndDateValueType(String endDateValueType) {
            this.endDateValueType = endDateValueType;
        }
        public String getEndDateValueType() {
            return endDateValueType;
        }
        public void setEndDateValue(String endDateValue) {
            this.endDateValue = endDateValue;
        }
        public String getEndDateValue() {
            return endDateValue;
        }
        public void setEnableVersion(boolean isEnableVersion) {
            this.isEnableVersion = isEnableVersion;
        }
        public boolean isEnableVersion() {
            return isEnableVersion;
        }
        public void setVersionField(String versionField) {
            this.versionField = versionField;
        }
        public String getVersionField() {
            return versionField;
        }
        public void setVersionFieldType(String versionFieldType) {
            this.versionFieldType = versionFieldType;
        }
        public String getVersionFieldType() {
            return versionFieldType;
        }
        public void setEnableActive(boolean isEnableActive) {
            this.isEnableActive = isEnableActive;
        }
        public boolean isEnableActive() {
            return isEnableActive;
        }
        public void setActiveField(String activeField) {
            this.activeField = activeField;
        }
        public String getActiveField() {
            return activeField;
        }
        public void setActiveFieldType(JavaType activeFieldType) {
            this.activeFieldType = activeFieldType;
        }
        public JavaType getActiveFieldType() {
            return activeFieldType;
        }
        public List<Column> getDimensionAttributes() {
            return dimensionAttributes;
        }        
    }
    public class DimensionType3Configer {
        private List<DimensionType3Attribute> dimensionAttributes;
        public DimensionType3Configer(List<DimensionType3Attribute> dimensionAttributes) {
            this.dimensionAttributes = dimensionAttributes;
        }
        public List<DimensionType3Attribute> getDimensionAttributes() {
            return dimensionAttributes;
        }
    }
    public class DimensionType3Attribute {
        private Column currentColumn;
        private Column prevColumn;
        public DimensionType3Attribute(Column currentColumn, Column prevColumn) {
            this.currentColumn = currentColumn;
            this.prevColumn = prevColumn;
        }
        public Column getCurrentColumn() {
            return currentColumn;
        }
        public Column getPrevColumn() {
            return prevColumn;
        }
    }
    public Column getColumn(IMetadataColumn column) {
        return new Column(column);
    }
    public Column getColumn(String columnName, String javaType) {
        return new Column(columnName, javaType);
    }
    public List<IMetadataColumn> getInputSchema(INode node) {
        List<IMetadataColumn> inputSchema = null;
        List<? extends IConnection> incomingConnections = node.getIncomingConnections();
        if(incomingConnections != null && incomingConnections.size() > 0) {
            for(IConnection incomingConnection : incomingConnections) {
                if(incomingConnection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                    IMetadataTable schemaTable = incomingConnection.getMetadataTable();
                    if(schemaTable != null) {
                        inputSchema = schemaTable.getListColumns();
                    }
                }
            }
        }
        return inputSchema;
    }
    public List<IMetadataColumn> getOutputSchema(INode node) {
        List<IMetadataColumn> outputSchema = null;
        List<IMetadataTable> schemaTables = node.getMetadataList();
        if(schemaTables != null && schemaTables.size() > 0) {
            IMetadataTable schemaTable = schemaTables.get(0);
            if(schemaTable != null) {
                outputSchema = schemaTable.getListColumns();
            }
        }
        return outputSchema;
    }
    public DimensionType0Configer getDimensionType0Configer(INode node) {
        DimensionType0Configer dimensionType0Configer = null;
        List<IMetadataColumn> inputSchema = getInputSchema(node);
        if(inputSchema != null && inputSchema.size() > 0) {
            List<Map<String, String>> dimensionType0s = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L0_FIELDS__");
            List<Column> dimensionAttributes = new ArrayList<Column>();
            if(dimensionType0s != null && dimensionType0s.size() > 0) {
                for(Map<String, String> dimensionType0 : dimensionType0s) {
                    for(IMetadataColumn metadataColumn : inputSchema) {
                        if(dimensionType0.get("NAME").equals(metadataColumn.getLabel())) {
                            Column column = getColumn(metadataColumn);
                            dimensionAttributes.add(column);
                            break;
                        }
                    }
                }
            }
            dimensionType0Configer = new DimensionType0Configer(dimensionAttributes);
        }
        return dimensionType0Configer;
    }
    public DimensionType1Configer getDimensionType1Configer(INode node) {
        DimensionType1Configer dimensionType1Configer = null;
        List<IMetadataColumn> inputSchema = getInputSchema(node);
        if(inputSchema != null && inputSchema.size() > 0) {
            List<Map<String, String>> dimensionType1s = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
            List<Column> dimensionAttributes = new ArrayList<Column>();
            if(dimensionType1s != null && dimensionType1s.size() > 0) {
                for(Map<String, String> dimensionType1 : dimensionType1s) {
                    for(IMetadataColumn metadataColumn : inputSchema) {
                        if(dimensionType1.get("NAME").equals(metadataColumn.getLabel())) {
                            Column column = getColumn(metadataColumn);
                            dimensionAttributes.add(column);
                            break;
                        }
                    }
                }
            }
            dimensionType1Configer = new DimensionType1Configer(dimensionAttributes);
            boolean isOnlyUpdateActive = ElementParameterParser.getValue(node, "__ONLY_UPDATE_ACTIVE__").equals("true");
            dimensionType1Configer.setOnlyUpdateActive(isOnlyUpdateActive);
        }
        return dimensionType1Configer;
    }
    public String getColumnNameByLabel(String labelName, List<IMetadataColumn> schema) {
        String columnName = "";
        for(IMetadataColumn metadataColumn : schema) {
            if(labelName.equals(metadataColumn.getLabel())) {
                columnName = metadataColumn.getOriginalDbColumnName();
                break;
            }
        }
        return columnName;
    }
    public JavaType getJavaType(String labelName, List<IMetadataColumn> schema) {
        JavaType javaType = null;
        for(IMetadataColumn metadataColumn : schema) {
            if(labelName.equals(metadataColumn.getLabel())) {
                javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
                break;
            }
        }
        return javaType;
    }
    public String getGeneratedType(String labelName, List<IMetadataColumn> schema) {
        String generatedType = "";
        for(IMetadataColumn metadataColumn : schema) {
            if(labelName.equals(metadataColumn.getLabel())) {
                generatedType = JavaTypesManager.getTypeToGenerate(metadataColumn.getTalendType(), metadataColumn.isNullable());
                break;
            }
        }        
        return generatedType;
    }
    public boolean isEqualWithSK(String surrogateKeyField, List<Column> sourceKeys) {
        boolean isEqualWithSK = false;
        for(Column column : sourceKeys) {
            if(column.getColumnName().equals(surrogateKeyField)) {
                isEqualWithSK = true;
                break;
            }
        }
        return isEqualWithSK;
    }    
    public DimensionType2Configer getDimensionType2Configer(INode node) {
        DimensionType2Configer dimensionType2Configer = null;
        List<IMetadataColumn> inputSchema = getInputSchema(node);
        List<IMetadataColumn> outputSchema = getOutputSchema(node);
        if(inputSchema != null && inputSchema.size() > 0 && outputSchema != null && outputSchema.size() > 0) {
            List<Map<String, String>> dimensionType2s = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
            List<Column> dimensionAttributes = new ArrayList<Column>();
            if(dimensionType2s != null && dimensionType2s.size() > 0) {
                for(Map<String, String> dimensionType2 : dimensionType2s) {
                    for(IMetadataColumn metadataColumn : inputSchema) {
                        if(dimensionType2.get("NAME").equals(metadataColumn.getLabel())) {
                            Column column = getColumn(metadataColumn);
                            dimensionAttributes.add(column);
                            break;
                        }
                    }
                }
            }
            dimensionType2Configer = new DimensionType2Configer(dimensionAttributes);
            String startDateField = getColumnNameByLabel(ElementParameterParser.getValue(node, "__L2_STARTDATE_FIELD__"), outputSchema);
            String startDateValueType = ElementParameterParser.getValue(node, "__L2_STARTDATE_VALUE__");
            String startDateValue = ElementParameterParser.getValue(node, "__L2_STARTDATE_INPUT_FIELD__");
            String endDateField = getColumnNameByLabel(ElementParameterParser.getValue(node, "__L2_ENDDATE_FIELD__"), outputSchema);
            String endDateValueType = ElementParameterParser.getValue(node, "__L2_ENDDATE_VALUE__");
            String endDateValue = ElementParameterParser.getValue(node, "__L2_ENDDATE_FIXED_VALUE__");
            boolean isEnableVersion = ElementParameterParser.getValue(node, "__USE_L2_VERSION__").equals("true");
            String versionField = getColumnNameByLabel(ElementParameterParser.getValue(node, "__L2_VERSION_FIELD__"), outputSchema);
            String versionFieldType = getGeneratedType(ElementParameterParser.getValue(node, "__L2_VERSION_FIELD__"), outputSchema);
            boolean isEnableActive = ElementParameterParser.getValue(node, "__USE_L2_ACTIVE__").equals("true");
            String activeField = getColumnNameByLabel(ElementParameterParser.getValue(node, "__L2_ACTIVE_FIELD__"), outputSchema);
            JavaType activeFieldType = getJavaType(ElementParameterParser.getValue(node, "__L2_ACTIVE_FIELD__"), outputSchema);
            dimensionType2Configer.setStartDateField(startDateField);
            dimensionType2Configer.setStartDateValueType(startDateValueType);
            dimensionType2Configer.setStartDateValue(startDateValue);
            dimensionType2Configer.setEndDateField(endDateField);
            dimensionType2Configer.setEndDateValueType(endDateValueType);
            dimensionType2Configer.setEndDateValue(endDateValue);
            dimensionType2Configer.setEnableVersion(isEnableVersion);
            dimensionType2Configer.setVersionField(versionField);
            dimensionType2Configer.setVersionFieldType(versionFieldType);
            dimensionType2Configer.setEnableActive(isEnableActive);
            dimensionType2Configer.setActiveField(activeField);
            dimensionType2Configer.setActiveFieldType(activeFieldType);
        }
        return dimensionType2Configer;
    }
    public DimensionType3Configer getDimensionType3Configer(INode node) {
        DimensionType3Configer dimensionType3Configer = null;
        List<IMetadataColumn> inputSchema = getInputSchema(node);
        List<IMetadataColumn> outputSchema = getOutputSchema(node);
        if(inputSchema != null && inputSchema.size() > 0 && outputSchema != null && outputSchema.size() > 0) {
            List<Map<String, String>> dimensionType3s = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__L3_FIELDS__");
            List<DimensionType3Attribute> dimensionAttributes = new ArrayList<DimensionType3Attribute>();
            if(dimensionType3s != null && dimensionType3s.size() > 0) {
                Column currentColumn = null;
                Column prevColumn = null;
                for(Map<String, String> dimensionType3 : dimensionType3s) {
                    for(IMetadataColumn metadataColumn : inputSchema) {
                        if(dimensionType3.get("CURRENT_VALUE").equals(metadataColumn.getLabel())) {
                            currentColumn = getColumn(metadataColumn);
                            break;
                        }
                    }
                    for(IMetadataColumn metadataColumn : outputSchema) {
                        if(dimensionType3.get("PREV_VALUE").equals(metadataColumn.getLabel())) {
                            prevColumn = getColumn(metadataColumn);
                            break;
                        }
                    }
                    DimensionType3Attribute dimensionType3Attribute = new DimensionType3Attribute(currentColumn, prevColumn);
                    dimensionAttributes.add(dimensionType3Attribute);
                }
            }
            dimensionType3Configer = new DimensionType3Configer(dimensionAttributes);
        }
        return dimensionType3Configer;
    }    
    public SCDConfiger getSCDConfiger(INode node) {
        SCDConfiger scdConfiger = null;
        List<IMetadataColumn> inputSchema = getInputSchema(node);
        List<IMetadataColumn> outputSchema = getOutputSchema(node);
        if(inputSchema != null && inputSchema.size() > 0 && outputSchema != null && outputSchema.size() > 0) {
            List<Map<String, String>> sourceKeyMaps = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");
            List<Column> sourceKeys = new ArrayList<Column>();
            if(sourceKeyMaps != null && sourceKeyMaps.size() > 0) {
                for(Map<String, String> sourceKeyMap : sourceKeyMaps) {
                    for(IMetadataColumn metadataColumn : inputSchema) {
                        if(sourceKeyMap.get("NAME").equals(metadataColumn.getLabel())) {
                            Column column = getColumn(metadataColumn);
                            sourceKeys.add(column);
                            break;
                        }
                    }
                }
            }
            scdConfiger = new SCDConfiger(sourceKeys);            
            String surrogateKeyField = getColumnNameByLabel(ElementParameterParser.getValue(node, "__SURROGATE_KEY__"), outputSchema);
            String surrogateKeyFieldType = getGeneratedType(ElementParameterParser.getValue(node, "__SURROGATE_KEY__"), outputSchema);
            String surrogateKeyValueType = ElementParameterParser.getValue(node, "__SK_CREATION__");
            String surrogateKeySequence = ElementParameterParser.getValue(node, "__SK_DB_SEQUENCE__");
            String surrogateKeyInputField = ElementParameterParser.getValue(node, "__SK_INPUT_FIELD__");
            String surrogateKeyRoutine = ElementParameterParser.getValue(node, "__SK_ROUTINE__");
            boolean isEnableType0 = ElementParameterParser.getValue(node, "__USE_L0__").equals("true");
            boolean isEnableType1 = ElementParameterParser.getValue(node, "__USE_L1__").equals("true");
            boolean isEnableType2 = ElementParameterParser.getValue(node, "__USE_L2__").equals("true");
            boolean isEnableType3 = ElementParameterParser.getValue(node, "__USE_L3__").equals("true");
            scdConfiger.setSurrogateKeyField(surrogateKeyField);
            scdConfiger.setSurrogateKeyFieldType(surrogateKeyFieldType);
            scdConfiger.setSurrogateKeyValueType(surrogateKeyValueType);
            scdConfiger.setSurrogateKeySequence(surrogateKeySequence);
            scdConfiger.setSurrogateKeyInputField(surrogateKeyInputField);
            scdConfiger.setSurrogateKeyRoutine(surrogateKeyRoutine);
            scdConfiger.setEnableType0(isEnableType0);
            scdConfiger.setEnableType1(isEnableType1);
            scdConfiger.setEnableType2(isEnableType2);
            scdConfiger.setEnableType3(isEnableType3);
            scdConfiger.setDimensionType0Configer(getDimensionType0Configer(node));
            scdConfiger.setDimensionType1Configer(getDimensionType1Configer(node));
            scdConfiger.setDimensionType2Configer(getDimensionType2Configer(node));
            scdConfiger.setDimensionType3Configer(getDimensionType3Configer(node));
        }
        return scdConfiger;
    }
    public String genSourceKeyClass(SCDConfiger scdConfiger, String cid) {       
        
        StringBuilder sourceKeyClass = new StringBuilder();
        
        sourceKeyClass.append("class SCDSK_" + cid + " {\r\n");
        sourceKeyClass.append("private int hashCode;\r\n");
        sourceKeyClass.append("public boolean hashCodeDirty = true;\r\n");        
        List<Column> sourceKeys = scdConfiger.getSourceKeys();
        for(Column sourceKey : sourceKeys) {
            sourceKeyClass.append(sourceKey.getJavaType() + " " + sourceKey.getColumnName() + ";\r\n");
        }
        
        //equals()
        sourceKeyClass.append("public boolean equals(Object obj) {\r\n");
        sourceKeyClass.append("if (this == obj) return true;\r\n");
        sourceKeyClass.append("if (obj == null) return false;\r\n");
        sourceKeyClass.append("if (getClass() != obj.getClass()) return false;\r\n");
        sourceKeyClass.append("final SCDSK_" + cid + " other = (SCDSK_" + cid + ") obj;\r\n");
        boolean isFirstSK = true;
        for(Column sourceKey : sourceKeys) { 
            //if (JavaTypesManager.isJavaPrimitiveType(sourceKey.getJavaType(), sourceKey.isNullable())) {
            if (sourceKey.getJavaType().equals("java.util.Date") || sourceKey.getJavaType().equals("String") 
            		|| sourceKey.getJavaType().equals("Object") || sourceKey.getJavaType().equals("BigDecimal")
            		|| sourceKey.isNullable()) {
                sourceKeyClass.append("if (this." + sourceKey.getColumnName() + " == null) {\r\n");
                sourceKeyClass.append("if (other." + sourceKey.getColumnName() + "!= null)\r\n");
                sourceKeyClass.append("return false;\r\n");
                sourceKeyClass.append("} else if (!this." + sourceKey.getColumnName() + ".equals(other." + sourceKey.getColumnName() + "))\r\n");
                sourceKeyClass.append("return false;\r\n");
            } else {                
                sourceKeyClass.append("if (this." + sourceKey.getColumnName() + "!= other." + sourceKey.getColumnName() + ")\r\n");
                sourceKeyClass.append("return false;\r\n");
            }
            sourceKeyClass.append("\r\n");
        }        
        sourceKeyClass.append("return true;\r\n");        
        sourceKeyClass.append("}\r\n");
        
        //hashCode()
        sourceKeyClass.append("public int hashCode() {\r\n");
        sourceKeyClass.append("if(hashCodeDirty) {\r\n");
        sourceKeyClass.append("int prime = 31;");
        for(Column sourceKey : sourceKeys) {
            if(sourceKey.getJavaType().equals("java.util.Date") || sourceKey.getJavaType().equals("String") 
            		|| sourceKey.getJavaType().equals("Object") || sourceKey.getJavaType().equals("BigDecimal") 
            		|| sourceKey.isNullable() || sourceKey.getJavaType().equals("byte[]")) {
                sourceKeyClass.append("hashCode = prime * hashCode + (" + sourceKey.getColumnName() + " == null ? 0 : " + sourceKey.getColumnName() + ".hashCode());\r\n");
            } else {
                if(sourceKey.getJavaType().equals("long")) {
                    sourceKeyClass.append("hashCode = prime * hashCode + (new Long(" + sourceKey.getColumnName() + ")).hashCode();\r\n");
                }else if(sourceKey.getJavaType().equals("double")) {
                    sourceKeyClass.append("hashCode = prime * hashCode + (new Double(" + sourceKey.getColumnName() + ")).hashCode();\r\n");
                }else if(sourceKey.getJavaType().equals("float")) {
                    sourceKeyClass.append("hashCode = prime * hashCode + (new Float(" + sourceKey.getColumnName() + ")).hashCode();\r\n");
                } else {
                    sourceKeyClass.append("hashCode = prime * hashCode + " + sourceKey.getColumnName() + ";\r\n");
                }
            }
        }
        sourceKeyClass.append("hashCodeDirty = false;\r\n");
        sourceKeyClass.append("}\r\n");
        sourceKeyClass.append("return hashCode;\r\n");
        sourceKeyClass.append("}\r\n");
        sourceKeyClass.append("}\r\n");
        return sourceKeyClass.toString();
    }
    public String genDimensionAttributeClass(SCDConfiger scdConfiger, String cid) {
        StringBuilder dimensionAttributeClass = new StringBuilder();
        dimensionAttributeClass.append("class SCDStruct_" + cid + " {\r\n");
        if(scdConfiger.isEnableType1()) {
            List<Column> type1Attributes = scdConfiger.getDimensionType1Configer().getDimensionAttributes();
            for(Column type1Attribute : type1Attributes) {
                dimensionAttributeClass.append("private " + type1Attribute.getJavaType() + " " + type1Attribute.getColumnName() + ";\r\n");
            }
        }
        if(scdConfiger.isEnableType2()) {
            List<Column> type2Attributes = scdConfiger.getDimensionType2Configer().getDimensionAttributes();
            for(Column type2Attribute : type2Attributes) {
                dimensionAttributeClass.append("private " + type2Attribute.getJavaType() + " " + type2Attribute.getColumnName() + ";\r\n");
            }
        }
        if(scdConfiger.isEnableType3()) {
            List<DimensionType3Attribute> type3Attributes = scdConfiger.getDimensionType3Configer().getDimensionAttributes();
            for(DimensionType3Attribute type3Attribute : type3Attributes) {
                dimensionAttributeClass.append("private " + type3Attribute.getCurrentColumn().getJavaType() + " " + type3Attribute.getCurrentColumn().getColumnName() + ";\r\n");
                dimensionAttributeClass.append("private " + type3Attribute.getPrevColumn().getJavaType() + " " + type3Attribute.getPrevColumn().getColumnName() + ";\r\n");
            }
        }
        if(scdConfiger.isEnableType2() && scdConfiger.getDimensionType2Configer().isEnableVersion()) {
            String versionField = scdConfiger.getDimensionType2Configer().getVersionField();
            String versionFieldType = scdConfiger.getDimensionType2Configer().getVersionFieldType();
            dimensionAttributeClass.append("private " + versionFieldType + " " + versionField + ";\r\n");
        }        
        dimensionAttributeClass.append("}\r\n");
        return dimensionAttributeClass.toString();
    }
    public List<Column> getInsertionColumnList(SCDConfiger scdConfiger) {
        List<Column> insertionColumnList = new ArrayList<Column>();
        String surrogateKeyField = scdConfiger.getSurrogateKeyField();
        if(surrogateKeyField.length()>0 && !scdConfiger.getSurrogateKeyValueType().equals("AUTO_INCREMENT") && !scdConfiger.getSurrogateKeyValueType().equals("DB_SEQUENCE")) {
            String surrogateKeyFieldType = scdConfiger.getSurrogateKeyFieldType();
            insertionColumnList.add(getColumn(surrogateKeyField, surrogateKeyFieldType));
        }
        List<Column> sourceKeys = scdConfiger.getSourceKeys();
        boolean isEqualWithSK = isEqualWithSK(surrogateKeyField, sourceKeys);
        if(isEqualWithSK) {
            for(Column column : sourceKeys) {
                if(!column.getColumnName().equals(surrogateKeyField)) {
                    insertionColumnList.add(column);
                }
            }
        } else {
            for(Column column : sourceKeys) {
                insertionColumnList.add(column);
            }
        }
        if(scdConfiger.isEnableType0()) {
            List<Column> dimensionAttributes = scdConfiger.getDimensionType0Configer().getDimensionAttributes();
            for(Column column : dimensionAttributes) {
                insertionColumnList.add(column);
            }
        }
        if(scdConfiger.isEnableType1()) {
            List<Column> dimensionAttributes = scdConfiger.getDimensionType1Configer().getDimensionAttributes();
            for(Column column : dimensionAttributes) {
                insertionColumnList.add(column);
            }
        }
        if(scdConfiger.isEnableType2()) {
            List<Column> dimensionAttributes = scdConfiger.getDimensionType2Configer().getDimensionAttributes();
            for(Column column : dimensionAttributes) {
                insertionColumnList.add(column);
            }
            if(scdConfiger.getDimensionType2Configer().isEnableVersion()) {
                String versionField = scdConfiger.getDimensionType2Configer().getVersionField();
                String versionFieldType = scdConfiger.getDimensionType2Configer().getVersionFieldType();
                insertionColumnList.add(getColumn(versionField, versionFieldType));
            }
            String startDateField = scdConfiger.getDimensionType2Configer().getStartDateField();
            insertionColumnList.add(getColumn(startDateField, "java.util.Date"));
            String endDateField = scdConfiger.getDimensionType2Configer().getEndDateField();
            insertionColumnList.add(getColumn(endDateField, "java.util.Date"));            
        }
        if(scdConfiger.isEnableType3()) {
            List<DimensionType3Attribute> dimensionAttributes = scdConfiger.getDimensionType3Configer().getDimensionAttributes();
            for(DimensionType3Attribute dimensionType3Attribute : dimensionAttributes) {
                insertionColumnList.add(dimensionType3Attribute.getCurrentColumn());
            }
        }
        return insertionColumnList;
    }
    public List<Column> getSearchingColumnList(SCDConfiger scdConfiger) {
        List<Column> columnList = new ArrayList<Column>();
        if(scdConfiger.isEnableType1()) {
            List<Column> type1Attributes = scdConfiger.getDimensionType1Configer().getDimensionAttributes();
            for(Column type1Attribute : type1Attributes) {
                columnList.add(type1Attribute);
            }
        }
        if(scdConfiger.isEnableType2()) {
            List<Column> type2Attributes = scdConfiger.getDimensionType2Configer().getDimensionAttributes();
            for(Column type2Attribute : type2Attributes) {
                columnList.add(type2Attribute);
            }
        }
        if(scdConfiger.isEnableType3()) {
            List<DimensionType3Attribute> type3Attributes = scdConfiger.getDimensionType3Configer().getDimensionAttributes();
            for(DimensionType3Attribute type3Attribute : type3Attributes) {
                columnList.add(type3Attribute.getCurrentColumn());
                columnList.add(type3Attribute.getPrevColumn());
            }
        }
        if(scdConfiger.isEnableType2() && scdConfiger.getDimensionType2Configer().isEnableVersion()) {
            String versionField = scdConfiger.getDimensionType2Configer().getVersionField();
            String versionFieldType = scdConfiger.getDimensionType2Configer().getVersionFieldType();
            columnList.add(getColumn(versionField, versionFieldType));
        }        
        return columnList;
    }
    public List<Column> getSearchColumnList(SCDConfiger scdConfiger) {
        List<Column> columnList = new ArrayList<Column>();
        List<Column> sourceKeys = scdConfiger.getSourceKeys();
        for(Column sourceKey : sourceKeys) {
            columnList.add(sourceKey);
        }
        if(scdConfiger.isEnableType1()) {
            List<Column> type1Attributes = scdConfiger.getDimensionType1Configer().getDimensionAttributes();
            for(Column type1Attribute : type1Attributes) {
                columnList.add(type1Attribute);
            }
        }
        if(scdConfiger.isEnableType2()) {
            List<Column> type2Attributes = scdConfiger.getDimensionType2Configer().getDimensionAttributes();
            for(Column type2Attribute : type2Attributes) {
                columnList.add(type2Attribute);
            }
        }
        if(scdConfiger.isEnableType3()) {
            List<DimensionType3Attribute> type3Attributes = scdConfiger.getDimensionType3Configer().getDimensionAttributes();
            for(DimensionType3Attribute type3Attribute : type3Attributes) {
                columnList.add(type3Attribute.getCurrentColumn());
                columnList.add(type3Attribute.getPrevColumn());
            }
        }
        if(scdConfiger.isEnableType2() && scdConfiger.getDimensionType2Configer().isEnableVersion()) {
            String versionField = scdConfiger.getDimensionType2Configer().getVersionField();
            String versionFieldType = scdConfiger.getDimensionType2Configer().getVersionFieldType();
            columnList.add(getColumn(versionField, versionFieldType));
        }
        return columnList;
    }
    public abstract class SCDManager {
        protected String cid;
        public SCDManager(String cid) {
            this.cid = cid;
        }
        protected abstract String getDBMSId();
        protected abstract String getLProtectedChar();
        protected abstract String getRProtectedChar();
        protected abstract String getSequence(String surrogateKeySequence);
        protected abstract String getIncrement();
        protected abstract String getDate(String endDateValue);
        protected abstract String getYear(String endDateField);
        protected abstract String getActiveFieldTrueValue(JavaType activeFieldType);
        protected abstract String getActiveFieldFalseValue(JavaType activeFieldType);        
        public String createSearchingSQL(SCDConfiger scdConfiger) {
         	return createSearchingSQL(scdConfiger ,true);
        }
        public String createSearchingSQL(SCDConfiger scdConfiger ,boolean isSourceKeyEnableNull) {
            StringBuilder searchingSQL = new StringBuilder();
            boolean firstColumn = true;
            boolean firstKeyColumn = true;
            String separator = ", ";
            String keySeparator = " AND ";
            searchingSQL.append("SELECT ");
            List<Column> sourceKeys = scdConfiger.getSourceKeys();
            for(Column sourceKey : sourceKeys) {
                if(firstColumn) {
                    firstColumn = false;
                } else {
                    searchingSQL.append(separator);
                }
                searchingSQL.append(getLProtectedChar() + sourceKey.getColumnName() + getRProtectedChar());
            }
            if(scdConfiger.isEnableType1()) {
                List<Column> type1Attributes = scdConfiger.getDimensionType1Configer().getDimensionAttributes();
                for(Column type1Attribute : type1Attributes) {
                    if(firstColumn) {
                        firstColumn = false;
                    } else {
                        searchingSQL.append(separator);
                    }
                    searchingSQL.append(getLProtectedChar() + type1Attribute.getColumnName() + getRProtectedChar());
                }
            }
            if(scdConfiger.isEnableType2()) {
                List<Column> type2Attributes = scdConfiger.getDimensionType2Configer().getDimensionAttributes();
                for(Column type2Attribute : type2Attributes) {
                    if(firstColumn) {
                        firstColumn = false;
                    } else {
                        searchingSQL.append(separator);
                    }
                    searchingSQL.append(getLProtectedChar() + type2Attribute.getColumnName() + getRProtectedChar());
                }
            }
            if(scdConfiger.isEnableType3()) {
                List<DimensionType3Attribute> type3Attributes = scdConfiger.getDimensionType3Configer().getDimensionAttributes();
                for(DimensionType3Attribute type3Attribute : type3Attributes) {
                    if(firstColumn) {
                        firstColumn = false;
                    } else {
                        searchingSQL.append(separator);
                    }
                    searchingSQL.append(getLProtectedChar() + type3Attribute.getCurrentColumn().getColumnName() + getRProtectedChar());
                    searchingSQL.append(", " + getLProtectedChar() + type3Attribute.getPrevColumn().getColumnName() + getRProtectedChar());                    
                }
            }
            if(scdConfiger.isEnableType2() && scdConfiger.getDimensionType2Configer().isEnableVersion()) {
                String versionField = scdConfiger.getDimensionType2Configer().getVersionField();
                searchingSQL.append(separator + getLProtectedChar() + versionField + getRProtectedChar());                
            }
            searchingSQL.append(" FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " WHERE ");
            for(Column sourceKey : sourceKeys) {
                if(firstKeyColumn) {
                    firstKeyColumn = false;
                } else {
                    searchingSQL.append(keySeparator);
                }
                if(isSourceKeyEnableNull){
                	searchingSQL.append(" ("+getLProtectedChar() + sourceKey.getColumnName() + getRProtectedChar() + " = ? OR ((? IS NULL) AND ("+getLProtectedChar() + sourceKey.getColumnName() + getRProtectedChar() + " IS NULL ))) ");
                }else{
                	searchingSQL.append(getLProtectedChar() + sourceKey.getColumnName() + getRProtectedChar() + " = ?");
                }
            }
            if(scdConfiger.isEnableType2()) {
                searchingSQL.append(keySeparator);
                String endDateField = scdConfiger.getDimensionType2Configer().getEndDateField();
                if(scdConfiger.getDimensionType2Configer().getEndDateValueType().equals("NULL_VALUE")) {
                    searchingSQL.append(getLProtectedChar() + endDateField + getRProtectedChar() + " IS NULL");
                } else {
                    String endDateValue = scdConfiger.getDimensionType2Configer().getEndDateValue();
                    searchingSQL.append(getYear(endDateField) + " = \" + " + endDateValue + " + \"");
                }                
            }
            return searchingSQL.toString();
        }
        public String createSelectionSQL(SCDConfiger scdConfiger) {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT ");
            List<Column> sourceKeys = scdConfiger.getSourceKeys();
            String separator = ", ";
            boolean firstColumn = true;
            for(Column sourceKey : sourceKeys) {
                if(firstColumn) {
                    firstColumn = false;
                } else {
                    selectionSQL.append(separator);
                }
                selectionSQL.append(getLProtectedChar() + sourceKey.getColumnName() + getRProtectedChar());
            }
            if(scdConfiger.isEnableType1()) {
                List<Column> type1Attributes = scdConfiger.getDimensionType1Configer().getDimensionAttributes();
                for(Column type1Attribute : type1Attributes) {
                    if(firstColumn) {
                        firstColumn = false;
                    } else {
                        selectionSQL.append(separator);
                    }
                    selectionSQL.append(getLProtectedChar() + type1Attribute.getColumnName() + getRProtectedChar());
                }
            }
            if(scdConfiger.isEnableType2()) {
                List<Column> type2Attributes = scdConfiger.getDimensionType2Configer().getDimensionAttributes();
                for(Column type2Attribute : type2Attributes) {
                    if(firstColumn) {
                        firstColumn = false;
                    } else {
                        selectionSQL.append(separator);
                    }
                    selectionSQL.append(getLProtectedChar() + type2Attribute.getColumnName() + getRProtectedChar());                
                }
            }
            if(scdConfiger.isEnableType3()) {
                List<DimensionType3Attribute> type3Attributes = scdConfiger.getDimensionType3Configer().getDimensionAttributes();
                for(DimensionType3Attribute type3Attribute : type3Attributes) {
                    if(firstColumn) {
                        firstColumn = false;
                    } else {
                        selectionSQL.append(separator);
                    }
                    selectionSQL.append(getLProtectedChar() + type3Attribute.getCurrentColumn().getColumnName() + getRProtectedChar());
                    selectionSQL.append(", " + getLProtectedChar() + type3Attribute.getPrevColumn().getColumnName() + getRProtectedChar());
                }
            }
            if(scdConfiger.isEnableType2() && scdConfiger.getDimensionType2Configer().isEnableVersion()) {
                String versionField = scdConfiger.getDimensionType2Configer().getVersionField();
                selectionSQL.append(separator + getLProtectedChar() + versionField + getRProtectedChar());
            }
            selectionSQL.append(" FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            if(scdConfiger.isEnableType2()) {
                String endDateField = scdConfiger.getDimensionType2Configer().getEndDateField();
                if(scdConfiger.getDimensionType2Configer().getEndDateValueType().equals("NULL_VALUE")) {
                    selectionSQL.append(" WHERE " + getLProtectedChar() + endDateField + getRProtectedChar() + " IS NULL");
                } else {
                    String endDateValue = scdConfiger.getDimensionType2Configer().getEndDateValue();
                    selectionSQL.append(" WHERE " + getYear(endDateField) + " = \" + " + endDateValue + " + \"");
                }
            }
            return selectionSQL.toString();
        }
        protected String getDBSequenceWithSchemaPrefix (SCDConfiger scdConfiger) {
        	return "\" + ((schema_" + cid +"!= null && schema_" +cid+".trim().length()!=0)?schema_"+cid+" +\".\":\"\")" +     
            getSequence(scdConfiger.getSurrogateKeySequence());
        }
        public String createInsertionSQL(SCDConfiger scdConfiger) {
            StringBuilder insertionSQL = new StringBuilder();
            insertionSQL.append("INSERT INTO "  + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            String insertColumns = "";
            String insertValues = "";
            String separator = ", ";
            String surrogateKeyField = scdConfiger.getSurrogateKeyField();
            List<Column> sourceKeys = scdConfiger.getSourceKeys();
            boolean isEqualWithSK = isEqualWithSK(surrogateKeyField, sourceKeys);
            if(!scdConfiger.getSurrogateKeyValueType().equals("AUTO_INCREMENT") && !scdConfiger.getSurrogateKeyValueType().equals("DB_SEQUENCE")) {
                insertColumns = getLProtectedChar() + surrogateKeyField + getRProtectedChar();
                insertValues = "?";
            }
            if(surrogateKeyField.length()>0 && scdConfiger.getSurrogateKeyValueType().equals("DB_SEQUENCE")) {
                insertColumns = getLProtectedChar() + surrogateKeyField + getRProtectedChar();
                insertValues = getDBSequenceWithSchemaPrefix(scdConfiger);
            }
            boolean isAbsenceSK="".equals(insertColumns);
            int removedIndex = separator.length();
            if(insertColumns.equals(getLProtectedChar()+getRProtectedChar())){
            	isAbsenceSK = true;
            	removedIndex = separator.length()+ getLProtectedChar().length()+getRProtectedChar().length();
            }
            if(isEqualWithSK) {
                for(Column column : sourceKeys) {
                    if(!column.getColumnName().equals(surrogateKeyField)) {
                        insertColumns += separator + getLProtectedChar() + column.getColumnName() + getRProtectedChar();
                        insertValues += separator + "?";
                    }
                }
            } else {
                for(Column column : sourceKeys) {
                    insertColumns += separator + getLProtectedChar() + column.getColumnName() + getRProtectedChar();
                    insertValues += separator + "?";
                }
            }
            if(scdConfiger.isEnableType0()) {
                List<Column> dimensionAttributes = scdConfiger.getDimensionType0Configer().getDimensionAttributes();
                for(Column column : dimensionAttributes) {
                    insertColumns += separator + getLProtectedChar() + column.getColumnName() + getRProtectedChar();
                    insertValues += separator + "?";
                }
            }
            if(scdConfiger.isEnableType1()) {
                List<Column> dimensionAttributes = scdConfiger.getDimensionType1Configer().getDimensionAttributes();
                for(Column column : dimensionAttributes) {
                    insertColumns += separator + getLProtectedChar() + column.getColumnName() + getRProtectedChar();
                    insertValues += separator + "?";
                }
            }
            if(scdConfiger.isEnableType2()) {
                List<Column> dimensionAttributes = scdConfiger.getDimensionType2Configer().getDimensionAttributes();
                for(Column column : dimensionAttributes) {
                    insertColumns += separator + getLProtectedChar() + column.getColumnName() + getRProtectedChar();
                    insertValues += separator + "?";
                }
                if(scdConfiger.getDimensionType2Configer().isEnableActive()) {
                    insertColumns += separator + getLProtectedChar() + scdConfiger.getDimensionType2Configer().getActiveField() + getRProtectedChar();
                    insertValues += separator;
                    JavaType activeFieldType = scdConfiger.getDimensionType2Configer().getActiveFieldType();
                    insertValues += getActiveFieldTrueValue(activeFieldType);                    
                }
                if(scdConfiger.getDimensionType2Configer().isEnableVersion()) {
                    insertColumns += separator + getLProtectedChar() + scdConfiger.getDimensionType2Configer().getVersionField() + getRProtectedChar();
                    insertValues += separator + "?";
                }
                insertColumns += separator + getLProtectedChar() + scdConfiger.getDimensionType2Configer().getStartDateField() + getRProtectedChar();
                insertValues += separator + "?";
                insertColumns += separator + getLProtectedChar() + scdConfiger.getDimensionType2Configer().getEndDateField() + getRProtectedChar();
                insertValues += separator + "?";
            }
            if(scdConfiger.isEnableType3()) {
                List<DimensionType3Attribute> dimensionAttributes = scdConfiger.getDimensionType3Configer().getDimensionAttributes();
                for(DimensionType3Attribute dimensionType3Attribute : dimensionAttributes) {
                    insertColumns += separator + getLProtectedChar() + dimensionType3Attribute.getCurrentColumn().getColumnName() + getRProtectedChar();
                    insertValues += separator + "?";
                }
            }
            if(isAbsenceSK || scdConfiger.getSurrogateKeyValueType().equals("AUTO_INCREMENT")) {
                if(insertColumns.length() > removedIndex) {
                    insertColumns = insertColumns.substring(removedIndex);
                }
                if(insertValues.length() > separator.length()) {
                    insertValues = insertValues.substring(separator.length());
                }
            }
            insertionSQL.append("(" + insertColumns + ") VALUES(" + insertValues + ")");
            return insertionSQL.toString();
        }
        public String createUpdateSQLForType1(SCDConfiger scdConfiger) {
         	return createUpdateSQLForType1(scdConfiger ,true);
        }
        public String createUpdateSQLForType1(SCDConfiger scdConfiger ,boolean isSourceKeyEnableNull) {
            StringBuilder updateSQL = new StringBuilder();
            if(scdConfiger.isEnableType1()) {
                updateSQL.append("UPDATE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
                String updateSetStmt = "";
                String updateWhereStmt = "";
                String separator = ", ";
                String keySeparator = " AND ";
                boolean firstKeyColumn = true;
                boolean firstColumn = true;
                List<Column> sourceKeys = scdConfiger.getSourceKeys();
                for(Column keyColumn : sourceKeys) {
                    if(firstKeyColumn) {
                        firstKeyColumn = false;
                    } else {
                        updateWhereStmt += keySeparator;
                    }
                    if(isSourceKeyEnableNull){
                    	updateWhereStmt += " ("+getLProtectedChar() + keyColumn.getColumnName() + getRProtectedChar() + " = ? OR ((? IS NULL) AND ("+getLProtectedChar() + keyColumn.getColumnName() + getRProtectedChar() + " IS NULL ))) ";
                    }else{
                    	updateWhereStmt += getLProtectedChar() + keyColumn.getColumnName() + getRProtectedChar() + " = ?";
                    }
                }
                if(scdConfiger.isEnableType2() && scdConfiger.getDimensionType1Configer().isOnlyUpdateActive()) {
                    String endDateField = scdConfiger.getDimensionType2Configer().getEndDateField();
                    if(scdConfiger.getDimensionType2Configer().getEndDateValueType().equals("NULL_VALUE")) {
                        updateWhereStmt += keySeparator + getLProtectedChar() + endDateField + getRProtectedChar() + " IS NULL";
                    } else {
                        String endDateValue = scdConfiger.getDimensionType2Configer().getEndDateValue();
                        updateWhereStmt += keySeparator + getYear(endDateField) + " = \" + " + endDateValue + " + \"";
                    }
                }
                List<Column> dimensionAttributes = scdConfiger.getDimensionType1Configer().getDimensionAttributes();
                for(Column dimensionAttribute : dimensionAttributes) {
                    if(firstColumn) {
                        firstColumn = false;
                    } else {
                        updateSetStmt += separator;
                    }
                    updateSetStmt += getLProtectedChar() + dimensionAttribute.getColumnName() + getRProtectedChar() + " = ?";
                }
                updateSQL.append(" SET " + updateSetStmt + " WHERE " + updateWhereStmt);
            }
            return updateSQL.toString();
        }
        public String createUpdateSQLForType2(SCDConfiger scdConfiger) {
         	return createUpdateSQLForType2(scdConfiger ,true);
        }
        public String createUpdateSQLForType2(SCDConfiger scdConfiger ,boolean isSourceKeyEnableNull) {
            StringBuilder updateSQL = new StringBuilder();
            if(scdConfiger.isEnableType2()) {
                updateSQL.append("UPDATE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
                String updateSetStmt = "";
                String updateWhereStmt = "";
                String separator = ", ";
                String keySeparator = " AND ";
                boolean firstKeyColumn = true;
                boolean firstColumn = true;
                List<Column> sourceKeys = scdConfiger.getSourceKeys();
                for(Column keyColumn : sourceKeys) {
                    if(firstKeyColumn) {
                        firstKeyColumn = false;
                    } else {
                        updateWhereStmt += keySeparator;
                    }
                    if(isSourceKeyEnableNull){
                    	updateWhereStmt += "("+getLProtectedChar() + keyColumn.getColumnName() + getRProtectedChar() + " = ? OR ((? IS NULL) AND ("+getLProtectedChar() + keyColumn.getColumnName() + getRProtectedChar() + " IS NULL ))) ";
                    }else{
                        updateWhereStmt += getLProtectedChar() + keyColumn.getColumnName() + getRProtectedChar() + " = ?";
                    }
                }                
                String endDateField = scdConfiger.getDimensionType2Configer().getEndDateField();
                if(scdConfiger.getDimensionType2Configer().getEndDateValueType().equals("NULL_VALUE")) {
                    updateWhereStmt += keySeparator + getLProtectedChar() + endDateField + getRProtectedChar() + " IS NULL";
                } else {
                    String endDateValue = scdConfiger.getDimensionType2Configer().getEndDateValue();
                    updateWhereStmt += keySeparator + getYear(endDateField) + " = \" + " + endDateValue + " + \"";
                }
                updateSetStmt = getLProtectedChar() + endDateField + getRProtectedChar() + " = ?";
                if(scdConfiger.getDimensionType2Configer().isEnableActive()) {
                    String activeField = scdConfiger.getDimensionType2Configer().getActiveField();
                    JavaType activeFieldType = scdConfiger.getDimensionType2Configer().getActiveFieldType();
                    updateSetStmt += separator + getLProtectedChar() + activeField + getRProtectedChar() + " = " + getActiveFieldFalseValue(activeFieldType);
                }
                updateSQL.append(" SET " + updateSetStmt + " WHERE " + updateWhereStmt);
            }
            return updateSQL.toString();
        }
        public String createUpdateSQLForType3(SCDConfiger scdConfiger) {
         	return createUpdateSQLForType3(scdConfiger ,true);
        }
        public String createUpdateSQLForType3(SCDConfiger scdConfiger ,boolean isSourceKeyEnableNull) {
            StringBuilder updateSQL = new StringBuilder();
            if(scdConfiger.isEnableType3()) {
                updateSQL.append("UPDATE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
                String updateSetStmt = "";
                String updateWhereStmt = "";
                String separator = ", ";
                String keySeparator = " AND ";
                boolean firstKeyColumn = true;
                boolean firstColumn = true;
                List<Column> sourceKeys = scdConfiger.getSourceKeys();
                for(Column keyColumn : sourceKeys) {
                    if(firstKeyColumn) {
                        firstKeyColumn = false;
                    } else {
                        updateWhereStmt += keySeparator;
                    }
                    if(isSourceKeyEnableNull){
                    	updateWhereStmt += "("+getLProtectedChar() + keyColumn.getColumnName() + getRProtectedChar() + " = ? OR ((? IS NULL) AND ("+getLProtectedChar() + keyColumn.getColumnName() + getRProtectedChar() + " IS NULL ))) ";
                    }else{
                    	updateWhereStmt += getLProtectedChar() + keyColumn.getColumnName() + getRProtectedChar() + " = ?";
                    }
                }
                if(scdConfiger.isEnableType2()) {
                    String endDateField = scdConfiger.getDimensionType2Configer().getEndDateField();
                    if(scdConfiger.getDimensionType2Configer().getEndDateValueType().equals("NULL_VALUE")) {
                        updateWhereStmt += keySeparator + getLProtectedChar() + endDateField + getRProtectedChar() + " IS NULL";
                    } else {
                        String endDateValue = scdConfiger.getDimensionType2Configer().getEndDateValue();
                        updateWhereStmt += keySeparator + getYear(endDateField) + " = \" + " + endDateValue + " + \"";
                    }
                }
                List<DimensionType3Attribute> dimensionAttributes = scdConfiger.getDimensionType3Configer().getDimensionAttributes();
                for(DimensionType3Attribute dimensionAttribute : dimensionAttributes) {
                    if(firstColumn) {
                        firstColumn = false;
                    } else {
                        updateSetStmt += separator;
                    }
                    updateSetStmt += getLProtectedChar() + dimensionAttribute.getCurrentColumn().getColumnName() + getRProtectedChar() + " = ?";
                    updateSetStmt += ", " + getLProtectedChar() + dimensionAttribute.getPrevColumn().getColumnName() + getRProtectedChar() + " = ?";
                }
                updateSQL.append(" SET " + updateSetStmt + " WHERE " + updateWhereStmt);
            }
            return updateSQL.toString();
        }
        public String getDeleteTableSQL() {
            StringBuilder deleteTableSQL = new StringBuilder();
            deleteTableSQL.append("DELETE FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return deleteTableSQL.toString();
        }        
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return truncateTableSQL.toString();
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }        
        public String getCreateTableSQL(List<IMetadataColumn> outputSchema, SCDConfiger scdConfiger) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createTableSQL = new StringBuilder();
            createTableSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            String columnName = null;
            String surrogateKey = scdConfiger.getSurrogateKeyField();
            String surrogateKeyValueType = scdConfiger.getSurrogateKeyValueType();
            for(IMetadataColumn metadataColumn : outputSchema) {
                columnName = metadataColumn.getOriginalDbColumnName();
                if(columnName.equals(surrogateKey) && surrogateKeyValueType.equals("AUTO_INCREMENT")) {
                    pkList.add(getLProtectedChar() + columnName + getRProtectedChar());
                } else {
                    if(metadataColumn.isKey()) {
                        pkList.add(getLProtectedChar() + columnName + getRProtectedChar());
                    }                    
                }
                createTableSQL.append(getLProtectedChar() + columnName + getRProtectedChar() + " ");
                String dataType = null;
                if(!("vertica_id".equals(getDBMSId()) && columnName.equals(surrogateKey) && surrogateKeyValueType.equals("AUTO_INCREMENT"))){ 
	                if(metadataColumn.getType() == null || metadataColumn.getType().trim().length() == 0) {
	                    dataType = mappingType.getDefaultSelectedDbType(metadataColumn.getTalendType());
	                }else {
	                    dataType = metadataColumn.getType();
	                }
	                createTableSQL.append(dataType);
	                Integer length = metadataColumn.getLength() == null ? 0 : metadataColumn.getLength();
	                Integer precision = metadataColumn.getPrecision() == null ? 0 : metadataColumn.getPrecision();
	                boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
	                boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
	                String prefix = "";
	                String suffix = "";
	                String comma = "";
	                if(mappingType.isPreBeforeLength(getDBMSId(),dataType)) {
	                    if(!precisionIgnored) {
	                        prefix = "(";
	                        suffix = ") ";
	                        createTableSQL.append(prefix + precision);
	                    }
	                    if(!lengthIgnored) {
	                        prefix = (prefix.equals("") ? "(" : prefix);
	                        suffix = (suffix.equals("") ? ") " : suffix);
	                        if(precisionIgnored) {
	                            createTableSQL.append(prefix);
	                            comma = "";
	                        } else {
	                            comma = ",";
	                        }
	                        createTableSQL.append(comma + length);
	                    }
	                    createTableSQL.append(suffix);
	                } else {
	                    if(!lengthIgnored) {
	                        prefix = "(";
	                        suffix = ") ";
	                        createTableSQL.append(prefix + length);
	                    }
	                    if(!precisionIgnored) {
	                        prefix = (prefix.equals("") ? "(" : prefix);
	                        suffix = (suffix.equals("") ? ") " : suffix);
	                        if(lengthIgnored) {
	                            createTableSQL.append(prefix);
	                            comma = "";                        
	                        } else {
	                            comma = ",";
	                        }
	                        createTableSQL.append(comma + precision);
	                    }
	                    createTableSQL.append(suffix);
	                }
                }
                if(columnName.equals(surrogateKey) && surrogateKeyValueType.equals("AUTO_INCREMENT")) {
                    createTableSQL.append(getIncrement());
                    createTableSQL.append(setNullable(false));
                } else {
                    createTableSQL.append(getDefaultValueSQL(metadataColumn.getDefault()));            
                    createTableSQL.append(setNullable(metadataColumn.isNullable()));                    
                }            
                if(count == outputSchema.size() - 1 && pkList.size() == 0) {
                    ending = "";
                }
                createTableSQL.append(ending);
                count++;
            }
            if(pkList.size() > 0) {                
                createTableSQL.append("primary key(");                
                int i = 0;                
                for(String pk : pkList) {                    
                    createTableSQL.append(pk);                    
                    if(i != pkList.size() - 1) {                        
                        createTableSQL.append(",");                        
                    }                    
                    i++;                    
                }                
                createTableSQL.append(")");                
            }
            createTableSQL.append(")");
            return createTableSQL.toString();            
        }
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return "";
            }
        }    
        protected String getDefaultValueSQL(String defaultValue) {
            if(defaultValue == null || defaultValue.equals("\"\"") || defaultValue.equals("")) {
                return " ";
            } else if((defaultValue.startsWith("\"") || defaultValue.startsWith("'")) && (defaultValue.endsWith("\"") || defaultValue.endsWith("'"))) {
                return " default '" + defaultValue.substring(1,defaultValue.length() - 1) + "' ";
            } else if(defaultValue.equalsIgnoreCase("null")) {
                return " default null ";
            } else {
                return " default " + defaultValue + " ";
            }            
        }     
        
        public String genSetStatement(String pstmt, String variable, int paramIndex, String generatedType) {
            return genSetStatement(pstmt, variable, paramIndex, generatedType, false);
        }
        
        public String genSetStatement(String pstmt, String variable, int paramIndex, String generatedType, boolean isSourceKeyEnableNull) {
            return genSetStatement(pstmt, variable, paramIndex, generatedType , isSourceKeyEnableNull, null);
        }
        
        public String genSetStatement(String pstmt, String variable, int paramIndex, String generatedType, String dbType) {
            return genSetStatement(pstmt, variable, paramIndex, generatedType, false, dbType);
        }
        
        public String genSetStatement(String pstmt, String variable, int paramIndex, String generatedType ,boolean isSourceKeyEnableNull, String dbType) {
            StringBuilder setStatement = new StringBuilder();
            boolean isObject = false;
            if(generatedType.equals("Character")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.CHAR);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.CHAR);\r\n");
                }
            } else if(generatedType.equals("java.util.Date")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.DATE);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.DATE);\r\n");
                }
            } else if(generatedType.equals("byte[]")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.ARRAY);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.ARRAY);\r\n");
                }
            } else if(generatedType.equals("Long") || generatedType.equals("Byte") || generatedType.equals("Integer") || generatedType.equals("Short")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.INTEGER);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.INTEGER);\r\n");
                }
            } else if(generatedType.equals("String")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.VARCHAR);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.VARCHAR);\r\n");
                }
            } else if(generatedType.equals("Object")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.OTHER);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.OTHER);\r\n");
                }
            } else if(generatedType.equals("Boolean")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.BOOLEAN);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.BOOLEAN);\r\n");
                }
            } else if(generatedType.equals("Double")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.DOUBLE);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.DOUBLE);\r\n");
                }
            } else if(generatedType.equals("Float")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.FLOAT);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.FLOAT);\r\n");
                }
            }
            if(!variable.equals("null")) {
                if(isObject) {
                    setStatement.append("} else {\r\n");
                }
                if(generatedType.equals("byte[]")) {
                    generatedType = "Bytes";
                } else if(generatedType.equals("java.util.Date")) {
                    generatedType = "Date";
                } else if(generatedType.equals("Integer")) {
                    generatedType = "Int";
                } else {
                    if(generatedType.length() >= 1) {
                        generatedType = generatedType.substring(0, 1).toUpperCase() + generatedType.substring(1);
                    }
                }
                if(generatedType.equals("Char") || generatedType.equals("Character")) {
                    if(isObject) {
                        setStatement.append("if(" + variable + " == null) {\r\n");
                    } else {
                        setStatement.append("if(String.valueOf(" + variable + ").toLowerCase().equals(\"null\")) {\r\n");
                    }
                    setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.CHAR);\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.CHAR);\r\n");
                    }
                    setStatement.append("} else if(" + variable + " == '\\0') {\r\n");
                    setStatement.append(pstmt + ".setString(" + paramIndex + ", \"\");\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setString(" + (paramIndex+1) + ", \"\");\r\n");
                    }
                    setStatement.append("} else {\r\n");
                    setStatement.append(pstmt + ".setString(" + paramIndex + ", String.valueOf(" + variable + "));\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setString(" + (paramIndex+1) + ", String.valueOf(" + variable + "));\r\n");
                    }
                    setStatement.append("}\r\n");
                } else if(generatedType.equals("Date")) {
                    setStatement.append("if(" + variable + " != null) {\r\n");
                    setStatement.append(pstmt + ".setTimestamp(" + paramIndex + ", new java.sql.Timestamp(" + variable + ".getTime()));\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setTimestamp(" + (paramIndex+1) + ", new java.sql.Timestamp(" + variable + ".getTime()));\r\n");
                    }
                    setStatement.append("} else {\r\n");
                    setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.DATE);\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.DATE);\r\n");
                    }
                    setStatement.append("}\r\n");
                } else {
                    setStatement.append(pstmt + ".set" + generatedType + "(" + paramIndex + ", " + variable + ");\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".set" + generatedType + "(" + (paramIndex+1) + ", " + variable + ");\r\n");
                    }
                }
                if(isObject) {
                    setStatement.append("}\r\n");
                }
            }
            return setStatement.toString();
        }

    }
    public class DB2SCDManager extends SCDManager {
        public DB2SCDManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return "ibmdb2_id";
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        protected String getSequence(String surrogateKeySequence) {
            return "+ \" nextval for \"+((schema_" + cid +"!= null && schema_" +cid+".trim().length()!=0)?schema_"+cid+" +\".\":\"\") +\"" + surrogateKeySequence + "\" + \"";
        }
        protected String getIncrement() {
            return "";
        }
        protected String getDate(String endDateValue) {
            return "'\" + " + endDateValue + " + \"-01-01'";
        }
        protected String getYear(String endDateField) {
            return "YEAR(" + getLProtectedChar() + endDateField + getRProtectedChar() + ")";
        }
        protected String getActiveFieldTrueValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'true'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "1";
            } else {
                return "1";
            }            
        }
        protected String getActiveFieldFalseValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'false'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "0";
            } else {
                return "0";
            }            
        }
        protected String getDBSequenceWithSchemaPrefix (SCDConfiger scdConfiger) {
        	return "\" " +getSequence(scdConfiger.getSurrogateKeySequence());
        }
    }
    public class IngresSCDManager extends SCDManager {
        public IngresSCDManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return "ingres_id";
        }        
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        protected String getSequence(String surrogateKeySequence) {
        	return "+ \"" + surrogateKeySequence + "\" + \".nextval";
        }
        protected String getIncrement() {
            return "";
        }        
        protected String getDate(String endDateValue) {
            return "'\" + " + endDateValue + " + \"-01-01'";
        }        
        protected String getYear(String endDateField) {
            return "DATE_PART('year', " + getLProtectedChar() + endDateField + getRProtectedChar() + ")";
        }
        protected String getActiveFieldTrueValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'true'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "1";
            } else {
                return "1";
            }            
        }
        protected String getActiveFieldFalseValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'false'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "0";
            } else {
                return "0";
            }            
        }        
    }
    public class MSSQLSCDManager extends SCDManager {
        public MSSQLSCDManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return "id_MSSQL";
        }        
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }
        protected String getSequence(String surrogateKeySequence) {
            return "\" + " + surrogateKeySequence + " + \".nextval";
        }
        protected String getIncrement() {
            return "";
        }        
        protected String getDate(String endDateValue) {
            return "'\" + " + endDateValue + " + \"-01-01'";
        }        
        protected String getYear(String endDateField) {
            return "YEAR(" + getLProtectedChar() + endDateField + getRProtectedChar() + ")";
        }
        protected String getActiveFieldTrueValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'true'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "1";
            } else {
                return "1";
            }            
        }
        protected String getActiveFieldFalseValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'false'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "0";
            } else {
                return "0";
            }            
        }        
    }
    
    public class TeradataSCDManager extends SCDManager {
        public TeradataSCDManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return "teradata_id";
        }        
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        protected String getSequence(String surrogateKeySequence) {
            return "";
        }
        protected String getIncrement() {
            return " GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 999999999 NO CYCLE) ";
        }        
        protected String getDate(String endDateValue) {
            return "'\" + " + endDateValue + " + \"-01-01'";
        }        
        protected String getYear(String endDateField) {
            return "EXTRACT(YEAR FROM " + getLProtectedChar() + endDateField + getRProtectedChar() + ")";
        }
        protected String getActiveFieldTrueValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'true'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "'1'";
            } else {
                return "1";
            }            
        }
        protected String getActiveFieldFalseValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'false'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "'0'";
            } else {
                return "0";
            }            
        }        
       
        public String genSetStatement(String pstmt, String variable, int paramIndex, String generatedType ,boolean isSourceKeyEnableNull) {

            StringBuilder setStatement = new StringBuilder();
            boolean isObject = false;
            if(generatedType.equals("Character")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.CHAR);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.CHAR);\r\n");
                }
            } else if(generatedType.equals("java.util.Date")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.DATE);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.DATE);\r\n");
                }
            } else if(generatedType.equals("byte[]")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.ARRAY);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.ARRAY);\r\n");
                }
            } else if(generatedType.equals("Long") || generatedType.equals("Byte") || generatedType.equals("Integer") || generatedType.equals("Short")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.INTEGER);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.INTEGER);\r\n");
                }
            } else if(generatedType.equals("String")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.VARCHAR);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.VARCHAR);\r\n");
                }
            } else if(generatedType.equals("Object")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.OTHER);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.OTHER);\r\n");
                }
            } else if(generatedType.equals("Boolean")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.BOOLEAN);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.BOOLEAN);\r\n");
                }
            } else if(generatedType.equals("Double")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.DOUBLE);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.DOUBLE);\r\n");
                }
            } else if(generatedType.equals("Float")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.FLOAT);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.FLOAT);\r\n");
                }
            }
            if(!variable.equals("null")) {
                if(isObject) {
                    setStatement.append("} else {\r\n");
                }
                if(generatedType.equals("byte[]")) {
                    generatedType = "Bytes";
                } else if(generatedType.equals("java.util.Date")) {
                    generatedType = "Date";
                } else if(generatedType.equals("Integer")) {
                    generatedType = "Int";
                } else {
                    if(generatedType.length() >= 1) {
                        generatedType = generatedType.substring(0, 1).toUpperCase() + generatedType.substring(1);
                    }
                }
                if(generatedType.equals("Char") || generatedType.equals("Character")) {
                    if(isObject) {
                        setStatement.append("if(" + variable + " == null) {\r\n");
                    } else {
                        setStatement.append("if(String.valueOf(" + variable + ").toLowerCase().equals(\"null\")) {\r\n");
                    }
                    setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.CHAR);\r\n");
                    setStatement.append("} else if(" + variable + " == '\\0') {\r\n");
                    setStatement.append(pstmt + ".setString(" + paramIndex + ", \"\");\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setString(" + paramIndex + ", \"\");\r\n");
                    }
                    setStatement.append("} else {\r\n");
                    setStatement.append(pstmt + ".setString(" + paramIndex + ", String.valueOf(" + variable + "));\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setString(" + paramIndex + ", String.valueOf(" + variable + "));\r\n");
                    }
                    setStatement.append("}\r\n");
                } else if(generatedType.equals("Date")) {
                    setStatement.append("if(" + variable + " != null) {\r\n");
                    setStatement.append("date_" + cid + " = " + variable + ".getTime();\r\n");
                    setStatement.append("if(date_" + cid + " < year1_" + cid + " || date_" + cid + " >= year10000_" + cid + ") {\r\n");
                    setStatement.append(pstmt + ".setString(" + paramIndex + ", \"0000-00-00 00:00:00\");\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setString(" + (paramIndex+1) + ", \"0000-00-00 00:00:00\");\r\n");
                    }
                    setStatement.append("} else {\r\n");
                    setStatement.append(pstmt + ".setTimestamp(" + paramIndex + ", new java.sql.Timestamp(date_" + cid + "));\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setTimestamp(" + (paramIndex+1) + ", new java.sql.Timestamp(date_" + cid + "));\r\n");
                    }
                    setStatement.append("}\r\n");
                    setStatement.append("} else {\r\n");
                    setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.DATE);\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.DATE);\r\n");
                    }
                    setStatement.append("}\r\n");
                } else {
                    setStatement.append(pstmt + ".set" + generatedType + "(" + paramIndex + ", " + variable + ");\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".set" + generatedType + "(" + (paramIndex+1) + ", " + variable + ");\r\n");
                    }
                }
                if(isObject) {
                    setStatement.append("}\r\n");
                }
            }
            return setStatement.toString();
        }
    }
    
    public class MysqlSCDManager extends SCDManager {
        public MysqlSCDManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return "mysql_id";
        }        
        protected String getLProtectedChar() {
            return "`";
        }
        protected String getRProtectedChar() {
            return "`";
        }
        protected String getSequence(String surrogateKeySequence) {
            return "\" + " + surrogateKeySequence + " + \".nextval";
        }
        protected String getIncrement() {
            return " AUTO_INCREMENT ";
        }        
        protected String getDate(String endDateValue) {
            return "'\" + " + endDateValue + " + \"-01-01'";
        }        
        protected String getYear(String endDateField) {
            return "YEAR(" + getLProtectedChar() + endDateField + getRProtectedChar() + ")";
        }
        protected String getActiveFieldTrueValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'true'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "b'1'";
            } else {
                return "1";
            }            
        }
        protected String getActiveFieldFalseValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'false'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "b'0'";
            } else {
                return "0";
            }            
        }        
       
        public String genSetStatement(String pstmt, String variable, int paramIndex, String generatedType ,boolean isSourceKeyEnableNull) {

            StringBuilder setStatement = new StringBuilder();
            boolean isObject = false;
            if(generatedType.equals("Character")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.CHAR);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.CHAR);\r\n");
                }
            } else if(generatedType.equals("java.util.Date")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.DATE);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.DATE);\r\n");
                }
            } else if(generatedType.equals("byte[]")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.ARRAY);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.ARRAY);\r\n");
                }
            } else if(generatedType.equals("Long") || generatedType.equals("Byte") || generatedType.equals("Integer") || generatedType.equals("Short")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.INTEGER);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.INTEGER);\r\n");
                }
            } else if(generatedType.equals("String")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.VARCHAR);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.VARCHAR);\r\n");
                }
            } else if(generatedType.equals("Object")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.OTHER);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.OTHER);\r\n");
                }
            } else if(generatedType.equals("Boolean")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.BOOLEAN);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.BOOLEAN);\r\n");
                }
            } else if(generatedType.equals("Double")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.DOUBLE);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.DOUBLE);\r\n");
                }
            } else if(generatedType.equals("Float")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.FLOAT);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.FLOAT);\r\n");
                }
            }
            if(!variable.equals("null")) {
                if(isObject) {
                    setStatement.append("} else {\r\n");
                }
                if(generatedType.equals("byte[]")) {
                    generatedType = "Bytes";
                } else if(generatedType.equals("java.util.Date")) {
                    generatedType = "Date";
                } else if(generatedType.equals("Integer")) {
                    generatedType = "Int";
                } else {
                    if(generatedType.length() >= 1) {
                        generatedType = generatedType.substring(0, 1).toUpperCase() + generatedType.substring(1);
                    }
                }
                if(generatedType.equals("Char") || generatedType.equals("Character")) {
                    if(isObject) {
                        setStatement.append("if(" + variable + " == null) {\r\n");
                    } else {
                        setStatement.append("if(String.valueOf(" + variable + ").toLowerCase().equals(\"null\")) {\r\n");
                    }
                    setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.CHAR);\r\n");
                    setStatement.append("} else if(" + variable + " == '\\0') {\r\n");
                    setStatement.append(pstmt + ".setString(" + paramIndex + ", \"\");\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setString(" + paramIndex + ", \"\");\r\n");
                    }
                    setStatement.append("} else {\r\n");
                    setStatement.append(pstmt + ".setString(" + paramIndex + ", String.valueOf(" + variable + "));\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setString(" + paramIndex + ", String.valueOf(" + variable + "));\r\n");
                    }
                    setStatement.append("}\r\n");
                } else if(generatedType.equals("Date")) {
                    setStatement.append("if(" + variable + " != null) {\r\n");
                    setStatement.append("date_" + cid + " = " + variable + ".getTime();\r\n");
                    setStatement.append("if(date_" + cid + " < year1_" + cid + " || date_" + cid + " >= year10000_" + cid + ") {\r\n");
                    setStatement.append(pstmt + ".setString(" + paramIndex + ", \"0000-00-00 00:00:00\");\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setString(" + (paramIndex+1) + ", \"0000-00-00 00:00:00\");\r\n");
                    }
                    setStatement.append("} else {\r\n");
                    setStatement.append(pstmt + ".setTimestamp(" + paramIndex + ", new java.sql.Timestamp(date_" + cid + "));\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setTimestamp(" + (paramIndex+1) + ", new java.sql.Timestamp(date_" + cid + "));\r\n");
                    }
                    setStatement.append("}\r\n");
                    setStatement.append("} else {\r\n");
                    setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.DATE);\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.DATE);\r\n");
                    }
                    setStatement.append("}\r\n");
                } else {
                    setStatement.append(pstmt + ".set" + generatedType + "(" + paramIndex + ", " + variable + ");\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".set" + generatedType + "(" + (paramIndex+1) + ", " + variable + ");\r\n");
                    }
                }
                if(isObject) {
                    setStatement.append("}\r\n");
                }
            }
            return setStatement.toString();
        }
    }
    
    public class NetezzaSCDManager extends SCDManager {
        public NetezzaSCDManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return "netezza_id";
        }        
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected String getSequence(String surrogateKeySequence) {
            return "+ \" next value for " + surrogateKeySequence + "\" + \"";
        }
        protected String getIncrement() {
            return "";
        }        
        protected String getDate(String endDateValue) {
            return "'\" + " + endDateValue + " + \"-01-01'";
        }        
        protected String getYear(String endDateField) {
            return "YEAR(" + getLProtectedChar() + endDateField + getRProtectedChar() + ")";
        }
        protected String getActiveFieldTrueValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'true'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "'1'";
            } else {
                return "1";
            }            
        }
        protected String getActiveFieldFalseValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'false'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "'0'";
            } else {
                return "0";
            }            
        } 
        protected String getDBSequenceWithSchemaPrefix (SCDConfiger scdConfiger) {
        	return "\" " +getSequence(scdConfiger.getSurrogateKeySequence());
        }
    }
    
    public class OracleSCDManager extends SCDManager {
        public OracleSCDManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return "oracle_id";
        }        
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected String getSequence(String surrogateKeySequence) {
            return "+ \"" + surrogateKeySequence + "\" + \".nextval";
        }
        protected String getIncrement() {
            return "";
        }        
        protected String getDate(String endDateValue) {
            return "TO_DATE('\" + " + endDateValue + " + \"-01-01', 'yyyy-mm-dd')";
        }        
        protected String getYear(String endDateField) {
            return "EXTRACT(YEAR FROM " + getLProtectedChar() + endDateField + getRProtectedChar() + ")";
        }
        protected String getActiveFieldTrueValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'true'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "1";
            } else {
                return "1";
            }            
        }
        protected String getActiveFieldFalseValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'false'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "0";
            } else {
                return "0";
            }            
        } 
        private String dbVersion = "";
        public void setDbVersion(String dbVersion){
            this.dbVersion = dbVersion;  
        }
        public String genSetStatement(String pstmt, String variable, int paramIndex, String generatedType ,boolean isSourceKeyEnableNull, String dbType) {
            StringBuilder setStatement = new StringBuilder();
            boolean isObject = false;
            if(generatedType.equals("Character")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.CHAR);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.CHAR);\r\n");
                }
            } else if(generatedType.equals("java.util.Date")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.DATE);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.DATE);\r\n");
                }
            } else if(generatedType.equals("byte[]")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.ARRAY);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.ARRAY);\r\n");
                }
            } else if(generatedType.equals("Long") || generatedType.equals("Byte") || generatedType.equals("Integer") || generatedType.equals("Short")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.INTEGER);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.INTEGER);\r\n");
                }
            } else if(generatedType.equals("String")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.VARCHAR);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.VARCHAR);\r\n");
                }
            } else if(generatedType.equals("Object")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.OTHER);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.OTHER);\r\n");
                }
            } else if(generatedType.equals("Boolean")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.BOOLEAN);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.BOOLEAN);\r\n");
                }
            } else if(generatedType.equals("Double")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.DOUBLE);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.DOUBLE);\r\n");
                }
            } else if(generatedType.equals("Float")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.FLOAT);\r\n");
                if(isSourceKeyEnableNull){
                    setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.FLOAT);\r\n");
                }
            }
            if(!variable.equals("null")) {
                if(isObject) {
                    setStatement.append("} else {\r\n");
                }
                if(generatedType.equals("byte[]")) {
                    generatedType = "Bytes";
                } else if(generatedType.equals("java.util.Date")) {
                    generatedType = "Date";
                } else if(generatedType.equals("Integer")) {
                    generatedType = "Int";
                } else {
                    if(generatedType.length() >= 1) {
                        generatedType = generatedType.substring(0, 1).toUpperCase() + generatedType.substring(1);
                    }
                }
                if(generatedType.equals("Char") || generatedType.equals("Character")) {
                    if(isObject) {
                        setStatement.append("if(" + variable + " == null) {\r\n");
                    } else {
                        setStatement.append("if(String.valueOf(" + variable + ").toLowerCase().equals(\"null\")) {\r\n");
                    }
                    setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.CHAR);\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.CHAR);\r\n");
                    }
                    setStatement.append("} else if(" + variable + " == '\\0') {\r\n");
                    setStatement.append(pstmt + ".setString(" + paramIndex + ", \"\");\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setString(" + (paramIndex+1) + ", \"\");\r\n");
                    }
                    setStatement.append("} else {\r\n");
                    setStatement.append(pstmt + ".setString(" + paramIndex + ", String.valueOf(" + variable + "));\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setString(" + (paramIndex+1) + ", String.valueOf(" + variable + "));\r\n");
                    }
                    setStatement.append("}\r\n");
                } else if(generatedType.equals("Date")) {
                    setStatement.append("if(" + variable + " != null) {\r\n");
                    boolean isTSWithTZ = false; 
                    if(dbType!=null)
                        isTSWithTZ = dbType.matches("TIMESTAMP WITH TIME ZONE");
                    if(isTSWithTZ && ("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_12".equals(dbVersion) || "ORACLE_10".equals(dbVersion))){
                        setStatement.append("if("+ variable + " instanceof TalendTimestampWithTZ){\r\n");
                        setStatement.append("((oracle.jdbc.OraclePreparedStatement)" + pstmt + ").setTIMESTAMPTZ(" + paramIndex + ", new oracle.sql.TIMESTAMPTZ(connection_" + cid + ", " +
                                "((TalendTimestampWithTZ)"+ variable +").getTimestamp(),((TalendTimestampWithTZ)"+ variable +").getCalendar()));\r\n");
                        if(isSourceKeyEnableNull){
                            setStatement.append("((oracle.jdbc.OraclePreparedStatement)" + pstmt + ").setTIMESTAMPTZ(" + (paramIndex+1) + ", new oracle.sql.TIMESTAMPTZ(connection_" + cid + ", " +
                                    "((TalendTimestampWithTZ)"+ variable +").getTimestamp(),((TalendTimestampWithTZ)"+ variable +").getCalendar()));\r\n");
                        }
                        setStatement.append("}else{");
                        setStatement.append(pstmt + ".setTimestamp(" + paramIndex + ", new java.sql.Timestamp(" + variable + ".getTime()));\r\n");
                        if(isSourceKeyEnableNull){
                            setStatement.append(pstmt + ".setTimestamp(" + (paramIndex+1) + ", new java.sql.Timestamp(" + variable + ".getTime()));\r\n");
                        }
                        setStatement.append("}");
                    }else{
                        setStatement.append(pstmt + ".setTimestamp(" + paramIndex + ", new java.sql.Timestamp(" + variable + ".getTime()));\r\n");
                        if(isSourceKeyEnableNull){
                            setStatement.append(pstmt + ".setTimestamp(" + (paramIndex+1) + ", new java.sql.Timestamp(" + variable + ".getTime()));\r\n");
                        }
                    }
                    setStatement.append("} else {\r\n");
                    setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.DATE);\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.DATE);\r\n");
                    }
                    setStatement.append("}\r\n");
                } else {
                    setStatement.append(pstmt + ".set" + generatedType + "(" + paramIndex + ", " + variable + ");\r\n");
                    if(isSourceKeyEnableNull){
                        setStatement.append(pstmt + ".set" + generatedType + "(" + (paramIndex+1) + ", " + variable + ");\r\n");
                    }
                }
                if(isObject) {
                    setStatement.append("}\r\n");
                }
            }
            return setStatement.toString();
        }
    }
    public class PostgresqlSCDManager extends SCDManager {
        public PostgresqlSCDManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return "postgres_id";
        }        
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        protected String getSequence(String surrogateKeySequence) {
        	return "+ \"nextval('\"+((dbSchema_" + cid +"!= null && dbSchema_" +cid+".trim().length()!=0)?dbSchema_"+cid+" +\".\":\"\") +\"" + surrogateKeySequence + "\"+ \"')\" + \"";
        }
        protected String getIncrement() {
            return "";
        }        
        protected String getDate(String endDateValue) {
            return "'\" + " + endDateValue + " + \"-01-01'";
        }        
        protected String getYear(String endDateField) {
            return "EXTRACT(YEAR FROM " + getLProtectedChar() + endDateField + getRProtectedChar() + ")";
        }
        protected String getActiveFieldTrueValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'true'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "TRUE";
            } else {
                return "1";
            }            
        }
        protected String getActiveFieldFalseValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'false'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "FALSE";
            } else {
                return "0";
            }            
        }        
        public String genSetStatement(String pstmt, String variable, int paramIndex, String generatedType ,boolean isSourceKeyEnableNull) {
            StringBuilder setStatement = new StringBuilder();
            boolean isObject = false;
            if(generatedType.equals("Character")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.CHAR);\r\n");
                if(isSourceKeyEnableNull){
                	setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.CHAR);\r\n");
                }
            } else if(generatedType.equals("java.util.Date")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.TIMESTAMP);\r\n");
                if(isSourceKeyEnableNull){
                	setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.TIMESTAMP);\r\n");
                }
            } else if(generatedType.equals("byte[]")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.ARRAY);\r\n");
                if(isSourceKeyEnableNull){
                	setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.ARRAY);\r\n");
                }
            } else if(generatedType.equals("Long") || generatedType.equals("Byte") || generatedType.equals("Integer") || generatedType.equals("Short")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.INTEGER);\r\n");
                if(isSourceKeyEnableNull){
                	setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.INTEGER);\r\n");
                }
            } else if(generatedType.equals("String")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.VARCHAR);\r\n");
                if(isSourceKeyEnableNull){
                	setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.VARCHAR);\r\n");
                }
            } else if(generatedType.equals("Object")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.OTHER);\r\n");
                if(isSourceKeyEnableNull){
                	setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.OTHER);\r\n");
                }
            } else if(generatedType.equals("Boolean")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.BOOLEAN);\r\n");
                if(isSourceKeyEnableNull){
                	setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.BOOLEAN);\r\n");
                }
            } else if(generatedType.equals("Double")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.DOUBLE);\r\n");
                if(isSourceKeyEnableNull){
                	setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.DOUBLE);\r\n");
                }
            } else if(generatedType.equals("Float")) {
                isObject = true;
                if(!variable.equals("null")) {
                    setStatement.append("if(" + variable + " == null) {\r\n");
                }
                setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.FLOAT);\r\n");
                if(isSourceKeyEnableNull){
                	setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.FLOAT);\r\n");
                }
            }
            if(!variable.equals("null")) {
                if(isObject) {
                    setStatement.append("} else {\r\n");
                }
                if(generatedType.equals("byte[]")) {
                    generatedType = "Bytes";
                } else if(generatedType.equals("java.util.Date")) {
                    generatedType = "Date";
                } else if(generatedType.equals("Integer")) {
                    generatedType = "Int";
                } else {
                    if(generatedType.length() >= 1) {
                        generatedType = generatedType.substring(0, 1).toUpperCase() + generatedType.substring(1);
                    }
                }
                if(generatedType.equals("Char") || generatedType.equals("Character")) {
                    if(isObject) {
                        setStatement.append("if(" + variable + " == null) {\r\n");
                    } else {
                        setStatement.append("if(String.valueOf(" + variable + ").toLowerCase().equals(\"null\")) {\r\n");
                    }
                    setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.CHAR);\r\n");
                    if(isSourceKeyEnableNull){
                    	setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.CHAR);\r\n");
                    }
                    setStatement.append("} else if(" + variable + " == '\\0') {\r\n");
                    setStatement.append(pstmt + ".setString(" + paramIndex + ", \"\");\r\n");
                    if(isSourceKeyEnableNull){
                    	setStatement.append(pstmt + ".setString(" + (paramIndex+1) + ", \"\");\r\n");
                    }
                    setStatement.append("} else {\r\n");
                    setStatement.append(pstmt + ".setString(" + paramIndex + ", String.valueOf(" + variable + "));\r\n");
                    if(isSourceKeyEnableNull){
                    	setStatement.append(pstmt + ".setString(" + (paramIndex+1) + ", String.valueOf(" + variable + "));\r\n");
                    }
                    setStatement.append("}\r\n");
                } else if(generatedType.equals("Date")) {
                    setStatement.append("if(" + variable + " != null) {\r\n");
                    setStatement.append(pstmt + ".setTimestamp(" + paramIndex + ", new java.sql.Timestamp(" + variable + ".getTime()));\r\n");
                    if(isSourceKeyEnableNull){
                    	setStatement.append(pstmt + ".setTimestamp(" + (paramIndex+1) + ", new java.sql.Timestamp(" + variable + ".getTime()));\r\n");
                    }
                    setStatement.append("} else {\r\n");
                    setStatement.append(pstmt + ".setNull(" + paramIndex + ", java.sql.Types.TIMESTAMP);\r\n");
                    if(isSourceKeyEnableNull){
                    	setStatement.append(pstmt + ".setNull(" + (paramIndex+1) + ", java.sql.Types.TIMESTAMP);\r\n");
                    }
                    setStatement.append("}\r\n");
                } else {
                    setStatement.append(pstmt + "."+"set" + generatedType + "(" + paramIndex + ", " + variable + ");\r\n");
                    if(isSourceKeyEnableNull){
                    	setStatement.append(pstmt + "."+"set" + generatedType + "(" + (paramIndex+1) + ", " + variable + ");\r\n");
                    }
                }
                if(isObject) {
                    setStatement.append("}\r\n");
                }
            }
            return setStatement.toString();
        }
        protected String getDBSequenceWithSchemaPrefix (SCDConfiger scdConfiger) {
        	return "\" " +getSequence(scdConfiger.getSurrogateKeySequence());
        }
    }
    public class PostgrePlusSCDManager extends SCDManager {
        public PostgrePlusSCDManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return "postgresplus_id";
        }        
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        protected String getSequence(String surrogateKeySequence) {
        	return "+ \"nextval('\"+((dbSchema_" + cid +"!= null && dbSchema_" +cid+".trim().length()!=0)?dbSchema_"+cid+" +\".\":\"\") +\"" + surrogateKeySequence + "\"+ \"')\" + \"";
        }
        protected String getIncrement() {
            return "";
        }        
        protected String getDate(String endDateValue) {
            return "'\" + " + endDateValue + " + \"-01-01'";
        }        
        protected String getYear(String endDateField) {
            return "EXTRACT(YEAR FROM " + getLProtectedChar() + endDateField + getRProtectedChar() + ")";
        }
        protected String getActiveFieldTrueValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'true'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "TRUE";
            } else {
                return "1";
            }            
        }
        protected String getActiveFieldFalseValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'false'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "FALSE";
            } else {
                return "0";
            }            
        }
		protected String getDBSequenceWithSchemaPrefix (SCDConfiger scdConfiger) {
        	return "\" " +getSequence(scdConfiger.getSurrogateKeySequence());
        }
    }
    public class SybaseSCDManager extends SCDManager {
        public SybaseSCDManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return "sybase_id";
        }        
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected String getSequence(String surrogateKeySequence) {
            return "\" + " + surrogateKeySequence + " + \".nextval";
        }
        protected String getIncrement() {
            return "";
        }        
        protected String getDate(String endDateValue) {
            return "'\" + " + endDateValue + " + \"-01-01'";
        }        
        protected String getYear(String endDateField) {
            return "YEAR(" + getLProtectedChar() + endDateField + getRProtectedChar() + ")";
        }
        protected String getActiveFieldTrueValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'true'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "1";
            } else {
                return "1";
            }            
        }
        protected String getActiveFieldFalseValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'false'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "0";
            } else {
                return "0";
            }            
        }        
    }
    
    public class VerticaSCDManager extends SCDManager {
        public VerticaSCDManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return "vertica_id";
        }        
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected String getSequence(String surrogateKeySequence) {
        	return "+ \"nextval('\"+((dbschema_" + cid +"!= null && dbschema_" +cid+".trim().length()!=0)?dbschema_"+cid+" +\".\":\"\") +\"" + surrogateKeySequence + "\"+ \"')\" + \"";
        }
        protected String getIncrement() {
        	return " auto_increment ";
        }        
        protected String getDate(String endDateValue) {
            return "TO_DATE('\" + " + endDateValue + " + \"-01-01', 'YYYY-MM-DD')";
        }        
        protected String getYear(String endDateField) {
            return "EXTRACT(YEAR FROM " + getLProtectedChar() + endDateField + getRProtectedChar() + ")";
        }
        protected String getActiveFieldTrueValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'true'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "'1'";
            } else {
                return "1";
            }            
        }
        protected String getActiveFieldFalseValue(JavaType activeFieldType) {
            if(activeFieldType == JavaTypesManager.STRING) {
                return "'false'";
            } else if(activeFieldType == JavaTypesManager.BOOLEAN) {
                return "'0'";
            } else {
                return "0";
            }            
        }
        protected String getDBSequenceWithSchemaPrefix (SCDConfiger scdConfiger) {
        	return "\" " +getSequence(scdConfiger.getSurrogateKeySequence());
        }
    }
    public SCDManager getSCDManager(String cid, String dbType) {
        SCDManager manager = managerMap.get(cid);
        if(manager == null) {
            if(dbType.equals(DB2)) {
                manager = new DB2SCDManager(cid);
            } else if(dbType.equals(INGRES)) {
                manager = new IngresSCDManager(cid);
            } else if(dbType.equals(MSSQL)) {
                manager = new MSSQLSCDManager(cid);
            } else if(dbType.equals(MYSQL)) {
                manager = new MysqlSCDManager(cid);
            } else if(dbType.equals(ORACLE)) {
                manager = new OracleSCDManager(cid);
            } else if(dbType.equals(POSTGREPLUS)) {
                manager = new PostgrePlusSCDManager(cid);
            } else if(dbType.equals(POSTGRESQL)) {
                manager = new PostgresqlSCDManager(cid);
            } else if(dbType.equals(SYBASE)) {
                manager = new SybaseSCDManager(cid);
            } else if(dbType.equals(INFORMIX)) {
                manager = new InfromixSCDManager(cid);
            } else if(dbType.equals(NETEZZA)) {
                manager = new NetezzaSCDManager(cid);
            } else if (dbType.equals(VERTICA)) {
                manager = new VerticaSCDManager(cid);
            } else if (dbType.equals(TERADATA)) {
                manager = new TeradataSCDManager(cid);
            }
            managerMap.put(cid, manager);
        }
        return manager;
    }
    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_3);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_4);
    
            }
            
    stringBuffer.append(TEXT_5);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_7);
    for(String message : messages){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        debug(str("Start to work."));
    }
    
    public void endWork(){
        debug(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
    
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
       			 if(log4jEnabled){
       			 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_16);
    
            java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
            ignoredParamsTypes.addAll(
                java.util.Arrays.asList(
                    org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                    org.talend.core.model.process.EParameterFieldType.LABEL,
                    org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                    org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                    org.talend.core.model.process.EParameterFieldType.IMAGE,
                    org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                    org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                    org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                    org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                    org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                    org.talend.core.model.process.EParameterFieldType.VERSION,
                    org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                    org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                    org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                    org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                    org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                    org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                    org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                    )
            );
            for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                    continue;
                }
                String name = ep.getName();
                if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                    String epName = "__" + name + "__";
                    String password = "";
                    if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                        password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                    }else{
                        String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                        if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                            passwordValue = "\"\"";
                        } 
                        password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                    } 
                    
    stringBuffer.append(TEXT_17);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_20);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    
    stringBuffer.append(TEXT_21);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_24);
    
                }   
                
    stringBuffer.append(TEXT_25);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_26);
    
            }
        }
		debug(var("log4jParamters"));
		
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_29);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_30);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_31);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_34);
    
                }else{
                
    stringBuffer.append(TEXT_35);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_43);
    
                }
                
    stringBuffer.append(TEXT_44);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_45);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    stringBuffer.append(TEXT_46);
    
class DBConnLogUtil extends BasicLogUtil{
	
	private DBConnLogUtil(){}
	
	protected DBConnLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logJDBCDriver(String driverClass){
		debug(str("Driver ClassName: "), driverClass, str("."));
	}
	
	public void connTry(String url, String dbUser){
		if(dbUser != null){
			debug(str("Connection attempts to '"), url, str("' with the username '"), dbUser, str("'."));
		}else{
			debug(str("Connection attempts to '"), url, str("'."));
		}
	}
	
	public void connDone(String url){
		debug(str("Connection to '"), url, str("' has succeeded."));
	}
	
	public void useExistConn(String url, String dbUser){
		if(dbUser != null){
			debug(str("Uses an existing connection with username '"), dbUser, str("'. Connection URL: "), url, str("."));
		}else{
			debug(str("Uses an existing connection. Connection URL: "), url, str("."));
		}
	}
	
	public void closeTry(String connCompID){
		if(connCompID == null){
			debug(str("Closing the connection to the database."));
		}else{
			debug(str("Closing the connection "), connCompID, str(" to the database."));
		}
	}
	
	public void closeDone(String connCompID){
		if(connCompID == null){
			debug(str("Connection to the database has closed."));	
		}else{
			debug(str("Connection "), connCompID, str(" to the database has closed."));
		}
	}
}

class DBTableActionLogUtil extends BasicLogUtil{
	private DBTableActionLogUtil(){}
	
	protected DBTableActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void dropTry(String tableName){
		tableActionTry(tableName, str("Dropping"));
	}
	
	public void dropDone(String tableName){
		tableActionDone(tableName, str("Drop"));
	}
	
	public void createTry(String tableName){
		tableActionTry(tableName, str("Creating"));
	}
	
	public void createDone(String tableName){
		tableActionDone(tableName, str("Create"));
	}
	
	public void clearTry(String tableName){
		tableActionTry(tableName, str("Clearing"));
	}
	
	public void clearDone(String tableName){
		tableActionDone(tableName, str("Clear"));
	}
	
	public void truncateTry(String tableName){
		tableActionTry(tableName, str("Truncating"));
	}
	
	public void truncateDone(String tableName){
		tableActionDone(tableName, str("Truncate"));
	}
	
	public void truncateReuseStorageTry(String tableName){
		tableActionTry(tableName, str("Truncating reuse storage"));
	}
	
	public void truncateReuseStorageDone(String tableName){
		tableActionDone(tableName, str("Truncate reuse stroage"));
	}
	
	private void tableActionTry(String tableName, String action){
		debug(action, str(" table '"), tableName, str("'."));
	}
	
	private void tableActionDone(String tableName, String action){
		debug(action, str(" table '"), tableName, str("' has succeeded."));
	}
}

class DBCommitLogUtil extends BasicLogUtil{
	private DBCommitLogUtil(){}
	
	protected DBCommitLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logAutoCommit(String autoCommit){
		debug(str("Connection is set auto commit to '"), autoCommit, str("'."));
	}

	public void commitTry(String connCompID, String commitCount){
		if(commitCount == null && connCompID == null){
			debug(str("Connection starting to commit."));
		}else if(commitCount == null){
			debug(str("Connection "), connCompID, str(" starting to commit."));	
		}else if(connCompID == null){
			debug(str("Connection starting to commit "), commitCount, str(" record(s)."));
		}else{
			debug(str("Connection "), connCompID, str(" starting to commit "), commitCount, str(" record(s)."));
		}
	}
	
	public void commitDone(String connCompID){
		if(connCompID == null){
			debug(str("Connection commit has succeeded."));
		}else{
			debug(str("Connection "), connCompID, (" commit has succeeded."));
		}
	}
}

class DBBatchLogUtil extends BasicLogUtil{
	private DBBatchLogUtil(){}
	
	protected DBBatchLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void executeTry(String action){
		debug(str("Executing the "), action, str(" batch."));
	}
	
	public void executeDone(String action){
		debug(str("The "), action, str(" batch execution has succeeded."));
	}
}

class DBDataActionLogUtil extends BasicLogUtil{
	private DBDataActionLogUtil(){}
	
	protected DBDataActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void inserting(String nbline){
		sqlAction(nbline, str("Inserting"));
	}
	
	public void deleting(String nbline){
		sqlAction(nbline, str("Deleting"));
	}
	
	public void updating(String nbline){
		sqlAction(nbline, str("Updating"));
	}
	
	public void replacing(String nbline){
		sqlAction(nbline, str("Replacing"));
	}
	
	public void insertingOnDuplicateKeyUpdating(String nbline){
		sqlAction(nbline, str("Inserting on duplicate key updating"));
	}
	
	public void insertingIgnore(String nbline){
		sqlAction(nbline, str("Inserting ignore"));
	}
	
	private void sqlAction(String nbline, String action){
		if(nbline == null){
			debug(action, str(" the record."));
		}else{
			debug(action, str(" the record "), nbline, str("."));
		}
	}
	
	public void sqlExecuteTry(String sql){
		debug(str("Executing '"), sql, str("'."));
	}
	
	public void sqlExecuteDone(String sql){
		debug(str("Execute '"), sql, str("' has succeeded."));
	}

	public void addingToBatch(String nbline, String batchAction){
		debug(str("Adding the record "), nbline, str(" to the "), batchAction, str(" batch."));
	}
}

class DBStateLogUtil extends BasicLogUtil{
	private DBStateLogUtil(){}
	
	protected DBStateLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logInsertedLines(String nbline){
		logFinishedLines(nbline, str("inserted"));
	}
	
	public void logUpdatedLines(String nbline){
		logFinishedLines(nbline, str("updated"));
	}
	
	public void logDeletedLines(String nbline){
		logFinishedLines(nbline, str("deleted"));
	}
	
	public void logRejectedLines(String nbline){
		logFinishedLines(nbline, str("rejected"));
	}
	
	private void logFinishedLines(String nbline, String action){
		debug(str("Has "), action, str(" "), nbline, str(" record(s)."));
	}
}	
class DBLogUtil extends LogUtil{
	DBConnLogUtil conn = null;
	DBTableActionLogUtil table = null;
	DBCommitLogUtil commit = null;
	DBBatchLogUtil batch = null;
	DBDataActionLogUtil data = null;
	DBStateLogUtil state = null;
	private DBLogUtil(){}
	
	protected DBLogUtil(org.talend.core.model.process.INode node){
		super(node);
		conn = new DBConnLogUtil(node);
    	table = new DBTableActionLogUtil(node);
    	commit = new DBCommitLogUtil(node);
    	batch = new DBBatchLogUtil(node);
    	data = new DBDataActionLogUtil(node);
    	state = new DBStateLogUtil(node);
	}
	
	public DBConnLogUtil conn(){
		return conn;
	}
	
	public DBTableActionLogUtil table(){
		return table;
	}
	
	public DBCommitLogUtil commit(){
		return commit;
	}
	
	public DBBatchLogUtil batch(){
		return batch;
	}
	
	public DBDataActionLogUtil data(){
		return data;
	}
	
	public DBStateLogUtil state(){
		return state;
	}
}
DBLogUtil dbLog = null;

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

dbLog = new DBLogUtil(node); 

List<IMetadataColumn> inputSchema = getInputSchema(node);
List<IMetadataColumn> outputSchema = getOutputSchema(node);

String rejectConnName = null;
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

String incomingConnName = null;
IConnection inConn=null;
List<? extends IConnection> incomingConnections = node.getIncomingConnections();
if(incomingConnections != null && incomingConnections.size() > 0) {
    for(IConnection incomingConnection : incomingConnections) {
        if(incomingConnection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        	inConn=incomingConnection;
            incomingConnName = incomingConnection.getName();
            break;
        }
    }
}

if(inputSchema != null && inputSchema.size() > 0 && outputSchema != null && outputSchema.size() > 0) {
    String dbhost = ElementParameterParser.getValue(node, "__SERVER__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");

    String dbtable = ElementParameterParser.getValue(node, "__TABLE__");
    boolean debug = ("true").equals(ElementParameterParser.getValue(node, "__DEBUG__"));
    boolean isEnableSaveMemMode = ("true").equals(ElementParameterParser.getValue(node, "__USE_SAVE_MEM_MODE__"));
    boolean isSourceKeyIncNull = ("true").equals(ElementParameterParser.getValue(node, "__SOURCE_KEY_INC_NULL__"));
    String dbType = MSSQL;
    SCDConfiger scdConfiger = getSCDConfiger(node);
    SCDManager scdManager = getSCDManager(cid, dbType);
    List<Column> sourceKeys = scdConfiger.getSourceKeys();
    List<Column> insertionColumnList = getInsertionColumnList(scdConfiger);
    String surrogateKeyField = scdConfiger.getSurrogateKeyField();
    boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
    
    int schemaOptNum=100;
	String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
	if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
		schemaOptNum  = Integer.parseInt(schemaOptNumStr);
	}
	boolean isOptimizeCode = false;
	if(schemaOptNum < inputSchema.size() || schemaOptNum < outputSchema.size()){
		isOptimizeCode = true;
	}
    
    
    if(!isEnableSaveMemMode) {    
        
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genSourceKeyClass(scdConfiger, cid));
    
    }
    
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genDimensionAttributeClass(scdConfiger, cid));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
	if(isOptimizeCode){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
		if(isEnableSaveMemMode) {//EnableSaveMemMode
			int paramIndex = 1;
			int indexMult= 0;
	        for(Column sourceKey : sourceKeys) {
	        	if(indexMult%schemaOptNum==0){

    stringBuffer.append(TEXT_57);
    stringBuffer.append(indexMult/schemaOptNum);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_61);
    
				}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(scdManager.genSetStatement("searchingStmt_" + cid, incomingConnName + "." + sourceKey.getLabelName(), paramIndex, sourceKey.getJavaType(),isSourceKeyIncNull));
    
				if((indexMult+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_63);
    
				}
				if(isSourceKeyIncNull){
	            	paramIndex=paramIndex+2;
	            }else{
	            	paramIndex++;
	            }
	            indexMult= isSourceKeyIncNull?paramIndex/2:paramIndex-1;
	        }
			if(indexMult>0&&(indexMult%schemaOptNum)>0){

    stringBuffer.append(TEXT_64);
    
			}
			List<Column> searchingColumns = getSearchingColumnList(scdConfiger);
			int index = sourceKeys.size()+1;
		    for(Column searchingColumn : searchingColumns) {
		    	if((index-sourceKeys.size()-1)%schemaOptNum==0){

    stringBuffer.append(TEXT_65);
    stringBuffer.append((index-sourceKeys.size()-1)/schemaOptNum);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
				}
		        String generatedType = searchingColumn.getJavaType();
		        if(("byte[]").equals(generatedType)) {
		            generatedType = "Bytes";
		        } else if(("java.util.Date").equals(generatedType)) {
		            generatedType = "Timestamp";
		        } else if(("Integer").equals(generatedType)) {
		            generatedType = "Int";
		        } else {
		            generatedType = generatedType.substring(0, 1).toUpperCase() + generatedType.substring(1);
		        }
		        if(("Char").equals(generatedType) || ("Character").equals(generatedType)) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(searchingColumn.getColumnName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
	                if(("Character").equals(generatedType)) {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(searchingColumn.getColumnName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(searchingColumn.getColumnName());
    stringBuffer.append(TEXT_86);
    
	                } else {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(searchingColumn.getColumnName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(searchingColumn.getColumnName());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_92);
    
	                }

    stringBuffer.append(TEXT_93);
    
		        } else if(("Timestamp").equals(generatedType)) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(searchingColumn.getColumnName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_100);
    
		        } else {

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(searchingColumn.getColumnName());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(generatedType);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_108);
    
		        }
				if((index-sourceKeys.size())% schemaOptNum==0){

    stringBuffer.append(TEXT_109);
    
				}
		        index++;
		    }
			if((index-sourceKeys.size()-1)>0&&((index-sourceKeys.size()-1)%schemaOptNum)>0){

    stringBuffer.append(TEXT_110);
    
			}
		}else{//EnableSaveMemMode
			List<Column> searchColumns = getSearchColumnList(scdConfiger);
			int index = 1;
            for(Column searchColumn : searchColumns) {
		    	if((index-1)%schemaOptNum==0){

    stringBuffer.append(TEXT_111);
    stringBuffer.append((index-1)/schemaOptNum);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
				}
                boolean isSourceKey = false;
                for(Column sourceKey : sourceKeys) {
                    if(searchColumn.getColumnName().equals(sourceKey.getColumnName())) {
                        isSourceKey = true;
                        break;
                    }
                }
                String generatedType = searchColumn.getJavaType();
                String struct = (isSourceKey ? "sk_" : "row_") + cid;
                if(("byte[]").equals(generatedType)) {
                    generatedType = "Bytes";
                } else if(("java.util.Date").equals(generatedType)) {
                    generatedType = "Timestamp";
                } else if(("Integer").equals(generatedType)) {
                    generatedType = "Int";
                } else {
                    generatedType = generatedType.substring(0, 1).toUpperCase() + generatedType.substring(1);
                }
                if(("Char").equals(generatedType) || ("Character").equals(generatedType)) {
                    
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(searchColumn.getColumnName());
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
                        if(("Character").equals(generatedType)) {
                            
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(searchColumn.getColumnName());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(searchColumn.getColumnName());
    stringBuffer.append(TEXT_137);
    
                        } else {
                            
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(searchColumn.getColumnName());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(searchColumn.getColumnName());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_144);
    
                        }
                        
    stringBuffer.append(TEXT_145);
    
                } else if(("Timestamp").equals(generatedType)) {
                    
    stringBuffer.append(TEXT_146);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(searchColumn.getColumnName());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_152);
    
                } else {
                    
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(searchColumn.getColumnName());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(generatedType);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_161);
    
                }
				if(index % schemaOptNum==0){

    stringBuffer.append(TEXT_162);
    
				}
                index++;
            }
			if((index-1)>0&&((index-1)%schemaOptNum)>0){

    stringBuffer.append(TEXT_163);
    
			}
		}//not EnableSaveMemMode
		
		//generate inert SetStatement
		int paramIndex = 1;
		boolean isReturnValue = false;
        for(Column insertionColumn : insertionColumnList) {
        	if((paramIndex - 1)%schemaOptNum==0){

    stringBuffer.append(TEXT_164);
    if(insertionColumn.getColumnName().equals(surrogateKeyField) && ("TABLE_MAX").equals(scdConfiger.getSurrogateKeyValueType())){
    stringBuffer.append(TEXT_165);
    }else{
    stringBuffer.append(TEXT_166);
    }
    stringBuffer.append(TEXT_167);
    stringBuffer.append((paramIndex - 1)/schemaOptNum);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(incomingConnName);
    if(insertionColumn.getColumnName().equals(surrogateKeyField) && ("TABLE_MAX").equals(scdConfiger.getSurrogateKeyValueType())){
    stringBuffer.append(TEXT_171);
    stringBuffer.append(scdConfiger.getSurrogateKeyFieldType());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_173);
    
        	}
            if(insertionColumn.getColumnName().equals(surrogateKeyField)) {
                if(("INPUT_FIELD").equals(scdConfiger.getSurrogateKeyValueType())) {
                    
    stringBuffer.append(TEXT_174);
    stringBuffer.append(scdManager.genSetStatement("insertionStatement_" + cid, incomingConnName + "." + scdConfiger.getSurrogateKeyInputField(), paramIndex, insertionColumn.getJavaType()));
    
                } else if(("ROUTINE").equals(scdConfiger.getSurrogateKeyValueType())) {
                    
    stringBuffer.append(TEXT_175);
    stringBuffer.append(scdConfiger.getSurrogateKeyFieldType());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(scdConfiger.getSurrogateKeyRoutine());
    stringBuffer.append(TEXT_178);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(scdManager.genSetStatement("insertionStatement_" + cid, "skRoutine_" + cid, paramIndex, insertionColumn.getJavaType()));
    
                } else if(("TABLE_MAX").equals(scdConfiger.getSurrogateKeyValueType())) {
                	isReturnValue = true;
                    
    stringBuffer.append(TEXT_180);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(scdManager.genSetStatement("insertionStatement_" + cid, "nextSurrogateKey_" + cid, paramIndex, insertionColumn.getJavaType()));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
                }
            } else if(insertionColumn.getColumnName().equals(scdConfiger.getDimensionType2Configer().getStartDateField())) {
                if(("INPUT_FIELD").equals(scdConfiger.getDimensionType2Configer().getStartDateValueType())) {
                    
    stringBuffer.append(TEXT_184);
    stringBuffer.append(scdManager.genSetStatement("insertionStatement_" + cid, incomingConnName + "." + scdConfiger.getDimensionType2Configer().getStartDateValue(), paramIndex, insertionColumn.getJavaType()));
    
                }
            } else if(insertionColumn.getColumnName().equals(scdConfiger.getDimensionType2Configer().getVersionField())) {
                
    stringBuffer.append(TEXT_185);
    stringBuffer.append(scdConfiger.getDimensionType2Configer().getVersionFieldType());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(scdManager.genSetStatement("insertionStatement_" + cid, "version_" + cid, paramIndex, scdConfiger.getDimensionType2Configer().getVersionFieldType()));
    
            } else {
                if(!insertionColumn.getColumnName().equals(scdConfiger.getDimensionType2Configer().getEndDateField())) {
                    
    stringBuffer.append(TEXT_189);
    stringBuffer.append(scdManager.genSetStatement("insertionStatement_" + cid, incomingConnName + "." + insertionColumn.getLabelName(), paramIndex, insertionColumn.getJavaType()));
    
                }
            }
	        if(paramIndex % schemaOptNum == 0){
				if(isReturnValue){

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    
					isReturnValue=false;
				}

    stringBuffer.append(TEXT_192);
    
			}
            paramIndex++;
        }
        if((paramIndex - 1) > 0 && ((paramIndex - 1)%schemaOptNum) > 0){
			if(isReturnValue){

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
				isReturnValue=false;
			}

    stringBuffer.append(TEXT_195);
    
		}
		
		if(scdConfiger.isEnableType1()) {//Type1 generate condition string
			List<Column> dimensionAttrbites = scdConfiger.getDimensionType1Configer().getDimensionAttributes();
            StringBuilder condition = null;
            boolean isFirstColumn = true;
            int desAttrbiteCountNo=0;
            for(Column dimensionAttrbite : dimensionAttrbites) {
            	if(desAttrbiteCountNo%schemaOptNum==0){
            		condition = new StringBuilder();

    stringBuffer.append(TEXT_196);
    stringBuffer.append(desAttrbiteCountNo/schemaOptNum);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_201);
    
            	}
                if(isFirstColumn) {
                    isFirstColumn = false;
                } else {
                    condition.append(" || ");
                }
                String generatedType = dimensionAttrbite.getJavaType();
                if (("BigDecimal").equals(generatedType)) {
                 	condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + " == null && " + incomingConnName + "." + dimensionAttrbite.getLabelName() + "!= null) || ");
                 	condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + " != null && " + incomingConnName + "." + dimensionAttrbite.getLabelName() + "== null) || ");
                    condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + " != null && lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + ".compareTo(" + incomingConnName + "." + dimensionAttrbite.getLabelName() + ")!= 0)");
                 } else if(("java.util.Date").equals(generatedType) || ("Object").equals(generatedType) 
                	|| ("String").equals(generatedType) || dimensionAttrbite.isNullable()) {
                    condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + " == null && " + incomingConnName + "." + dimensionAttrbite.getLabelName() + "!= null) || ");
                    condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + " != null && !lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + ".equals(" + incomingConnName + "." + dimensionAttrbite.getLabelName() + "))");
                } else {
                    condition.append("lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + " != " + incomingConnName + "." + dimensionAttrbite.getLabelName());
                }
               	if((desAttrbiteCountNo + 1) % schemaOptNum == 0){
               		isFirstColumn = true;

    stringBuffer.append(TEXT_202);
    stringBuffer.append(condition.toString());
    stringBuffer.append(TEXT_203);
    
				}
                desAttrbiteCountNo++;
            }
            if(desAttrbiteCountNo > 0 && (desAttrbiteCountNo % schemaOptNum) > 0){

    stringBuffer.append(TEXT_204);
    stringBuffer.append(condition.toString());
    stringBuffer.append(TEXT_205);
    
			}
			int index = 1;
			int columnIndex = 0;
            for(Column dimensionAttrbite : dimensionAttrbites) {
            	if(columnIndex%schemaOptNum==0){

    stringBuffer.append(TEXT_206);
    stringBuffer.append(columnIndex/schemaOptNum);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_210);
    
            	}
                
    stringBuffer.append(TEXT_211);
    stringBuffer.append(scdManager.genSetStatement("updateForType1_" + cid, incomingConnName + "." + dimensionAttrbite.getLabelName(), index, dimensionAttrbite.getJavaType()));
    
                index++;
                if((columnIndex + 1) % schemaOptNum == 0){

    stringBuffer.append(TEXT_212);
    
                }
                columnIndex++;
                
            }
            for(Column sourceKey : sourceKeys) {
            	if(columnIndex%schemaOptNum==0){

    stringBuffer.append(TEXT_213);
    stringBuffer.append(columnIndex/schemaOptNum);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_217);
    
            	}
                
    stringBuffer.append(TEXT_218);
    stringBuffer.append(scdManager.genSetStatement("updateForType1_" + cid, incomingConnName + "." + sourceKey.getLabelName(), index, sourceKey.getJavaType(),isSourceKeyIncNull));
    
                if(isSourceKeyIncNull){
                	index=index+2;
                }else{
                   	index++;
                }
                if((columnIndex + 1) % schemaOptNum == 0){

    stringBuffer.append(TEXT_219);
    
                }
                columnIndex++;
            }
            if(columnIndex > 0 && (columnIndex % schemaOptNum) > 0){

    stringBuffer.append(TEXT_220);
    
            }
		}

		if(scdConfiger.isEnableType2()) {//Type2 generate condition string
			List<Column> dimensionAttrbites = scdConfiger.getDimensionType2Configer().getDimensionAttributes();
            StringBuilder condition = null;
            boolean isFirstColumn = true;
            int desAttrbiteCountNo=0;
            for(Column dimensionAttrbite : dimensionAttrbites) {
            	if(desAttrbiteCountNo%schemaOptNum==0){
            		condition = new StringBuilder();

    stringBuffer.append(TEXT_221);
    stringBuffer.append(desAttrbiteCountNo/schemaOptNum);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_225);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_226);
    
            	}
                if(isFirstColumn) {
                    isFirstColumn = false;
                } else {
                    condition.append(" || ");
                }
                String generatedType = dimensionAttrbite.getJavaType();
                if (("BigDecimal").equals(generatedType)) {
                 	condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + " == null && " + incomingConnName + "." + dimensionAttrbite.getLabelName() + "!= null) || ");
                 	condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + " != null && " + incomingConnName + "." + dimensionAttrbite.getLabelName() + "== null) || ");
                    condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + " != null && lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + ".compareTo(" + incomingConnName + "." + dimensionAttrbite.getLabelName() + ")!= 0)");
                 } else if(("java.util.Date").equals(generatedType) || ("Object").equals(generatedType) 
                	|| ("String").equals(generatedType) || dimensionAttrbite.isNullable()) {
                    condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + " == null && " + incomingConnName + "." + dimensionAttrbite.getLabelName() + "!= null) || ");
                    condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + " != null && !lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + ".equals(" + incomingConnName + "." + dimensionAttrbite.getLabelName() + "))");
                } else {
                    condition.append("lookUpValue_" + cid + "." + dimensionAttrbite.getColumnName() + " != " + incomingConnName + "." + dimensionAttrbite.getLabelName());
                }
               	if((desAttrbiteCountNo + 1) % schemaOptNum == 0){
               		isFirstColumn = true;

    stringBuffer.append(TEXT_227);
    stringBuffer.append(condition.toString());
    stringBuffer.append(TEXT_228);
    
				}
                desAttrbiteCountNo++;
            }
            if(desAttrbiteCountNo > 0 && (desAttrbiteCountNo % schemaOptNum) > 0){

    stringBuffer.append(TEXT_229);
    stringBuffer.append(condition.toString());
    stringBuffer.append(TEXT_230);
    
			}
 			int index = 1;
 			int columnIndex = 0;
            if(("INPUT_FIELD").equals(scdConfiger.getDimensionType2Configer().getStartDateValueType())) {                    

    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(scdManager.genSetStatement("updateForType2_" + cid, incomingConnName + "." + scdConfiger.getDimensionType2Configer().getStartDateValue(), index, "java.util.Date"));
    
            	index++;
            	columnIndex++;
            } else {
                index = 2;
            }
 			for(Column sourceKey : sourceKeys) {
            	if(columnIndex%schemaOptNum==0){

    stringBuffer.append(TEXT_235);
    stringBuffer.append(columnIndex/schemaOptNum);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_239);
    
            	}

    stringBuffer.append(TEXT_240);
    stringBuffer.append(scdManager.genSetStatement("updateForType2_" + cid, incomingConnName + "." + sourceKey.getLabelName(), index, sourceKey.getJavaType(),isSourceKeyIncNull));
    
                if(isSourceKeyIncNull){
                	index=index+2;
                }else{
                   	index++;
                }
                if((columnIndex + 1) % schemaOptNum == 0){

    stringBuffer.append(TEXT_241);
    
                }
            	columnIndex++;
          	}
          	if(columnIndex > 0 && (columnIndex % schemaOptNum) > 0){

    stringBuffer.append(TEXT_242);
    
            }
            
           	paramIndex = 1;
            for(Column insertionColumn : insertionColumnList) {
            	if((paramIndex - 1) % schemaOptNum==0){

    stringBuffer.append(TEXT_243);
    if(insertionColumn.getColumnName().equals(surrogateKeyField) && ("TABLE_MAX").equals(scdConfiger.getSurrogateKeyValueType())){
    stringBuffer.append(TEXT_244);
    }else{
    stringBuffer.append(TEXT_245);
    }
    stringBuffer.append(TEXT_246);
    stringBuffer.append((paramIndex - 1)/schemaOptNum);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(incomingConnName);
    if(insertionColumn.getColumnName().equals(surrogateKeyField) && ("TABLE_MAX").equals(scdConfiger.getSurrogateKeyValueType())){
    stringBuffer.append(TEXT_250);
    stringBuffer.append(scdConfiger.getSurrogateKeyFieldType());
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    
            	}
                if(insertionColumn.getColumnName().equals(surrogateKeyField)) {
                    if(("INPUT_FIELD").equals(scdConfiger.getSurrogateKeyValueType())) {
                        
    stringBuffer.append(TEXT_255);
    stringBuffer.append(scdManager.genSetStatement("insertionStatement_" + cid, incomingConnName + "." + scdConfiger.getSurrogateKeyInputField(), paramIndex, insertionColumn.getJavaType()));
    
                    } else if(("ROUTINE").equals(scdConfiger.getSurrogateKeyValueType())) {
                        
    stringBuffer.append(TEXT_256);
    stringBuffer.append(scdConfiger.getSurrogateKeyFieldType());
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(scdConfiger.getSurrogateKeyRoutine());
    stringBuffer.append(TEXT_259);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(scdManager.genSetStatement("insertionStatement_" + cid, "skRoutine_" + cid, paramIndex, insertionColumn.getJavaType()));
    
                    } else if(("TABLE_MAX").equals(scdConfiger.getSurrogateKeyValueType())) {
                    	isReturnValue=true;
                        
    stringBuffer.append(TEXT_261);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(scdManager.genSetStatement("insertionStatement_" + cid, "nextSurrogateKey_" + cid, paramIndex, insertionColumn.getJavaType()));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    
                    }
                } else if(insertionColumn.getColumnName().equals(scdConfiger.getDimensionType2Configer().getStartDateField())) {
                    if(("INPUT_FIELD").equals(scdConfiger.getDimensionType2Configer().getStartDateValueType())) {
                        
    stringBuffer.append(TEXT_265);
    stringBuffer.append(scdManager.genSetStatement("insertionStatement_" + cid, incomingConnName + "." + scdConfiger.getDimensionType2Configer().getStartDateValue(), paramIndex, insertionColumn.getJavaType()));
    
                    }
                } else if(insertionColumn.getColumnName().equals(scdConfiger.getDimensionType2Configer().getVersionField())) {
                    
    stringBuffer.append(TEXT_266);
    stringBuffer.append(scdConfiger.getDimensionType2Configer().getVersionFieldType());
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(scdConfiger.getDimensionType2Configer().getVersionField());
    stringBuffer.append(TEXT_270);
    
                    if(!isEnableSaveMemMode) {
                        
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(scdConfiger.getDimensionType2Configer().getVersionField());
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(scdConfiger.getDimensionType2Configer().getVersionField());
    stringBuffer.append(TEXT_275);
    
                    }
                    
    stringBuffer.append(TEXT_276);
    stringBuffer.append(scdManager.genSetStatement("insertionStatement_" + cid, "maxVersion_" + cid, paramIndex, scdConfiger.getDimensionType2Configer().getVersionFieldType()));
    
                } else {
                    if(!insertionColumn.getColumnName().equals(scdConfiger.getDimensionType2Configer().getEndDateField())) {
                        
    stringBuffer.append(TEXT_277);
    stringBuffer.append(scdManager.genSetStatement("insertionStatement_" + cid, incomingConnName + "." + insertionColumn.getLabelName(), paramIndex, insertionColumn.getJavaType()));
    
                    }
                }
 				if(paramIndex % schemaOptNum == 0){
					if(isReturnValue){

    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
						isReturnValue=false;
					}

    stringBuffer.append(TEXT_280);
    
                }
                paramIndex++;
            }
           	if((paramIndex - 1) > 0 && ((paramIndex - 1) % schemaOptNum) > 0){
				if(isReturnValue){

    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    
					isReturnValue=false;
				}

    stringBuffer.append(TEXT_283);
    
            }
		}
		if(scdConfiger.isEnableType3()) {
			List<DimensionType3Attribute> dimensionAttrbites = scdConfiger.getDimensionType3Configer().getDimensionAttributes();
            StringBuilder condition = null;
            boolean isFirstColumn = true;
            int desAttrbiteCountNo=0;
            for(DimensionType3Attribute dimensionAttrbite : dimensionAttrbites) {
				if(desAttrbiteCountNo%schemaOptNum==0){
            		condition = new StringBuilder();

    stringBuffer.append(TEXT_284);
    stringBuffer.append(desAttrbiteCountNo/schemaOptNum);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_289);
    
            	}
                if(isFirstColumn) {
                    isFirstColumn = false;
                } else {
                    condition.append(" || ");
                }
                String generatedType = dimensionAttrbite.getCurrentColumn().getJavaType();
                if (("BigDecimal").equals(generatedType)) {
                 	condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + " == null && " + incomingConnName + "." + dimensionAttrbite.getCurrentColumn().getLabelName() + "!= null) || ");
                 	condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + " != null && " + incomingConnName + "." + dimensionAttrbite.getCurrentColumn().getLabelName() + "== null) || ");
                    condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + " != null && lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + ".compareTo(" + incomingConnName + "." + dimensionAttrbite.getCurrentColumn().getLabelName() + ")!= 0)");
                } else if(("java.util.Date").equals(generatedType) || ("Object").equals(generatedType) 
                	|| ("String").equals(generatedType) || dimensionAttrbite.getCurrentColumn().isNullable()) {
                    condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + " == null && " + incomingConnName + "." + dimensionAttrbite.getCurrentColumn().getLabelName() + "!= null) || ");
                    condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + " != null && !lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + ".equals(" + incomingConnName + "." + dimensionAttrbite.getCurrentColumn().getLabelName() + "))");
                } else {
                    condition.append("lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + " != " + incomingConnName + "." + dimensionAttrbite.getCurrentColumn().getLabelName());
                } 
               	if((desAttrbiteCountNo + 1) % schemaOptNum == 0){
               		isFirstColumn = true;

    stringBuffer.append(TEXT_290);
    stringBuffer.append(condition.toString());
    stringBuffer.append(TEXT_291);
    
				}
                desAttrbiteCountNo++;
            }
            if(desAttrbiteCountNo > 0 && (desAttrbiteCountNo % schemaOptNum) > 0){

    stringBuffer.append(TEXT_292);
    stringBuffer.append(condition.toString());
    stringBuffer.append(TEXT_293);
    
			}
			
			int index = 1;
			int columnIndex = 0;
            for(DimensionType3Attribute dimensionAttrbite : dimensionAttrbites) {
            	if(columnIndex%schemaOptNum==0){

    stringBuffer.append(TEXT_294);
    stringBuffer.append(columnIndex/schemaOptNum);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_300);
    
            	}

    stringBuffer.append(TEXT_301);
    stringBuffer.append(scdManager.genSetStatement("updateForType3_" + cid, incomingConnName + "." + dimensionAttrbite.getCurrentColumn().getLabelName(), index, dimensionAttrbite.getCurrentColumn().getJavaType()));
    
                index++;
                if((columnIndex + 1) % schemaOptNum == 0){

    stringBuffer.append(TEXT_302);
    
                }
                columnIndex++;
                if (dimensionAttrbites.size() > 1) {
	                condition = new StringBuilder();
	                String generatedType = dimensionAttrbite.getCurrentColumn().getJavaType();
					if (("BigDecimal").equals(generatedType)) {
	             		condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + " == null && " + incomingConnName + "." + dimensionAttrbite.getCurrentColumn().getLabelName() + "!= null) || ");
	             		condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + " != null && " + incomingConnName + "." + dimensionAttrbite.getCurrentColumn().getLabelName() + "== null) || ");
	                	condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + " != null && lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + ".compareTo(" + incomingConnName + "." + dimensionAttrbite.getCurrentColumn().getLabelName() + ")!= 0)");
	             	} else if(("java.util.Date").equals(generatedType) || ("Object").equals(generatedType) 
	                	|| ("String").equals(generatedType) || dimensionAttrbite.getCurrentColumn().isNullable()) {
	                	condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + " == null && " + incomingConnName + "." + dimensionAttrbite.getCurrentColumn().getLabelName() + "!= null) || ");
	                	condition.append("(lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + " != null && !lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + ".equals(" + incomingConnName + "." + dimensionAttrbite.getCurrentColumn().getLabelName() + "))");
	                } else {
	                    condition.append("lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName() + " != " + incomingConnName + "." + dimensionAttrbite.getCurrentColumn().getLabelName());
	                }
	            	if(columnIndex%schemaOptNum==0){

    stringBuffer.append(TEXT_303);
    stringBuffer.append(columnIndex/schemaOptNum);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_309);
    
            		}

    stringBuffer.append(TEXT_310);
    stringBuffer.append(condition.toString());
    stringBuffer.append(TEXT_311);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(scdManager.genSetStatement("updateForType3_" + cid,  "lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName(), index, dimensionAttrbite.getPrevColumn().getJavaType()));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(scdManager.genSetStatement("updateForType3_" + cid,  "lookUpValue_" + cid + "." + dimensionAttrbite.getPrevColumn().getColumnName(), index, dimensionAttrbite.getPrevColumn().getJavaType()));
    stringBuffer.append(TEXT_314);
    				
				} else {

    stringBuffer.append(TEXT_315);
    stringBuffer.append(scdManager.genSetStatement("updateForType3_" + cid,  "lookUpValue_" + cid + "." + dimensionAttrbite.getCurrentColumn().getColumnName(), index, dimensionAttrbite.getPrevColumn().getJavaType()));
    
               	}
                index++;
                if((columnIndex + 1) % schemaOptNum == 0){

    stringBuffer.append(TEXT_316);
    
                }
                columnIndex++;
            }
            for(Column sourceKey : sourceKeys) {
            	if(columnIndex%schemaOptNum==0){

    stringBuffer.append(TEXT_317);
    stringBuffer.append(columnIndex/schemaOptNum);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_322);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_323);
    
            	}

    stringBuffer.append(TEXT_324);
    stringBuffer.append(scdManager.genSetStatement("updateForType3_" + cid,  incomingConnName + "." + sourceKey.getLabelName(), index, sourceKey.getJavaType(),isSourceKeyIncNull));
    
                if(isSourceKeyIncNull){
                	index=index+2;
                }else{
                   	index++;
                }
                if((columnIndex + 1) % schemaOptNum == 0){

    stringBuffer.append(TEXT_325);
    
                }
                columnIndex++;
            }
            if(columnIndex > 0 && (columnIndex % schemaOptNum) > 0){

    stringBuffer.append(TEXT_326);
    
            }
		}
		if (!dieOnError && rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
        	int columnNo=0;
			for(IMetadataColumn inColumn : inputSchema) {
            	if(columnNo % schemaOptNum==0){

    stringBuffer.append(TEXT_327);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_332);
    
        		}
            	 for(IMetadataColumn outColumn : outputSchema) {
            	 	if (inColumn.getLabel().equals(outColumn.getLabel())) {

    stringBuffer.append(TEXT_333);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_335);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_337);
    
            		}
            	}
            	if((columnNo + 1) % schemaOptNum == 0){

    stringBuffer.append(TEXT_338);
    
           		}
            	columnNo++;
            }
        	if(columnNo > 0 && (columnNo % schemaOptNum) > 0){

    stringBuffer.append(TEXT_339);
    
        	}
		}

    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    
	}

    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    
boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
boolean isEnableDatasource = false;
if(cid.indexOf("tMSSqlOutput")>-1 || cid.indexOf("tMSSqlSP")>-1 ){
	isEnableDatasource = true;
}

    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    
if(useExistingConnection) {
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;
	String schema = "dbschema_" + connection;
	
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(schema);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_352);
    dbLog.conn().useExistConn("conn_"+cid+".getMetaData().getURL()", "conn_"+cid+".getMetaData().getUserName()");
    
} else {
	boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));   
	String driver = ElementParameterParser.getValue(node, "__DRIVER__");
	if(isEnableDatasource && specify_alias){
		String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");
		
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
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
    
	}
    
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_366);
    
    if(driver.equals("JTDS")) {
    
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    
    } else {
    
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
     
    }
    
    stringBuffer.append(TEXT_371);
    dbLog.conn().logJDBCDriver(dbLog.var("driverClass"));
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_377);
    
    if(driver.equals("JTDS")) {
    
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_380);
    
    } else {
    
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_383);
    
    }
    
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_386);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    
			if(driver.equals("JTDS")) {
	
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_391);
    
			} else {
	
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_394);
    
			}
	
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_399);
    
    String passwordFieldName = "__PASS__";
    
    stringBuffer.append(TEXT_400);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_403);
    } else {
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_406);
    }
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    dbLog.conn().connTry(dbLog.var("url"), dbLog.var("dbUser"));
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    dbLog.conn().connDone(dbLog.var("url"));
    stringBuffer.append(TEXT_415);
    
	if(isEnableDatasource && specify_alias){
	
    stringBuffer.append(TEXT_416);
    
	}
}

    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    
    if(isEnableSaveMemMode) {
        
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(scdManager.createSearchingSQL(scdConfiger,isSourceKeyIncNull));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    
    } else {
        List<Column> searchColumns = getSearchColumnList(scdConfiger);
        
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(scdManager.createSelectionSQL(scdConfiger));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    
            int index = 1;
            for(Column searchColumn : searchColumns) {
              if(!isOptimizeCode){
                boolean isSourceKey = false;
                for(Column sourceKey : sourceKeys) {
                    if(searchColumn.getColumnName().equals(sourceKey.getColumnName())) {
                        isSourceKey = true;
                        break;
                    }
                }
                String generatedType = searchColumn.getJavaType();
                String struct = (isSourceKey ? "sk_" : "row_") + cid;
                if(("byte[]").equals(generatedType)) {
                    generatedType = "Bytes";
                } else if(("java.util.Date").equals(generatedType)) {
                    generatedType = "Timestamp";
                } else if(("Integer").equals(generatedType)) {
                    generatedType = "Int";
                } else {
                    generatedType = generatedType.substring(0, 1).toUpperCase() + generatedType.substring(1);
                }
                if(("Char").equals(generatedType) || ("Character").equals(generatedType)) {
                    
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(searchColumn.getColumnName());
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    
                        if(("Character").equals(generatedType)) {
                            
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(searchColumn.getColumnName());
    stringBuffer.append(TEXT_468);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(searchColumn.getColumnName());
    stringBuffer.append(TEXT_471);
    
                        } else {
                            
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(searchColumn.getColumnName());
    stringBuffer.append(TEXT_476);
    stringBuffer.append(searchColumn.getColumnName());
    stringBuffer.append(TEXT_477);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_478);
    
                        }
                        
    stringBuffer.append(TEXT_479);
    
                } else if(("Timestamp").equals(generatedType)) {
                    
    stringBuffer.append(TEXT_480);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(searchColumn.getColumnName());
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_486);
    
                } else {
                    
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_488);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(searchColumn.getColumnName());
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(generatedType);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_495);
    
                }
              }else{
		    	  if((index-1)%schemaOptNum==0){

    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append((index-1)/schemaOptNum);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    
				  }
              }
                index++;
            }
            
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    
        if(debug) {
            
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    
        }        
    }
    if(("TABLE_MAX").equals(scdConfiger.getSurrogateKeyValueType())) {
        
    stringBuffer.append(TEXT_512);
    stringBuffer.append(scdConfiger.getSurrogateKeyFieldType());
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    
        if(!isEnableSaveMemMode) {
            
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    
        }
        
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(scdConfiger.getSurrogateKeyField());
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    
        String tmpType = null;        
        if(("Integer").equals(scdConfiger.getSurrogateKeyFieldType())) {
            tmpType = "Int";
        } else {
            tmpType = scdConfiger.getSurrogateKeyFieldType().substring(0, 1).toUpperCase() + scdConfiger.getSurrogateKeyFieldType().substring(1);
        }
        
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(tmpType);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    
        if(!isEnableSaveMemMode) {
            
    stringBuffer.append(TEXT_534);
    
        }
    }
    
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(scdManager.createInsertionSQL(scdConfiger));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    
    if(scdConfiger.isEnableType2()) {
        int paramIndex = 0;
        if(scdConfiger.isEnableType3()) {
            paramIndex = insertionColumnList.size() - scdConfiger.getDimensionType3Configer().getDimensionAttributes().size() - 1;
        } else {
            paramIndex = insertionColumnList.size() - 1;
        }       
        if(("JOB_START_TIME").equals(scdConfiger.getDimensionType2Configer().getStartDateValueType())) {
            
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(paramIndex);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    
        }
        if(("NULL_VALUE").equals(scdConfiger.getDimensionType2Configer().getEndDateValueType())) {
            
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(paramIndex + 1);
    stringBuffer.append(TEXT_547);
    
        } else {
        	String endDateTimeString = ElementParameterParser.getValue(node, "__L2_ENDDATE_TIME_DETAILS__");
            
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(endDateTimeString.length()>0?endDateTimeString:"\"\"");
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(paramIndex + 1);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(scdConfiger.getDimensionType2Configer().getEndDateValue());
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    
        }
    }
    if(scdConfiger.isEnableType1()) {
        
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(scdManager.createUpdateSQLForType1(scdConfiger,isSourceKeyIncNull));
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    
    }
    if(scdConfiger.isEnableType2()) {
        
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(scdManager.createUpdateSQLForType2(scdConfiger,isSourceKeyIncNull));
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    
        if(("JOB_START_TIME").equals(scdConfiger.getDimensionType2Configer().getStartDateValueType())) {
            
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    
        }
    }
    if(scdConfiger.isEnableType3()) {
        
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(scdManager.createUpdateSQLForType3(scdConfiger,isSourceKeyIncNull));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    
    }
    
    stringBuffer.append(TEXT_582);
    
    if(!isEnableSaveMemMode) {
        
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    
    }
    
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    
}

    stringBuffer.append(TEXT_589);
    return stringBuffer.toString();
  }
}
