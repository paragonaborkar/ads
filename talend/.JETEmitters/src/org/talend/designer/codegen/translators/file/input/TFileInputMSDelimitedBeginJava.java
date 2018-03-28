package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.List;
import java.util.Map;

public class TFileInputMSDelimitedBeginJava
{
  protected static String nl;
  public static synchronized TFileInputMSDelimitedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputMSDelimitedBeginJava result = new TFileInputMSDelimitedBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + "int key_";
  protected final String TEXT_32 = "_";
  protected final String TEXT_33 = " = 0;";
  protected final String TEXT_34 = NL + "String key_";
  protected final String TEXT_35 = "_";
  protected final String TEXT_36 = " = \"\";";
  protected final String TEXT_37 = NL + "int count_";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = " = ";
  protected final String TEXT_40 = ";" + NL + "final int lowBound_";
  protected final String TEXT_41 = "_";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = ";";
  protected final String TEXT_44 = "final int highBound_";
  protected final String TEXT_45 = "_";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = ";";
  protected final String TEXT_48 = NL + "org.talend.fileprocess.FileInputDelimited fid_";
  protected final String TEXT_49 = " = new org.talend.fileprocess.FileInputDelimited(";
  protected final String TEXT_50 = ",";
  protected final String TEXT_51 = ",";
  protected final String TEXT_52 = ",";
  protected final String TEXT_53 = ", true, 0, 0,-1, -1, false);" + NL + "String temp_";
  protected final String TEXT_54 = " = null;" + NL + "while (fid_";
  protected final String TEXT_55 = ".nextRecord()) {";
  protected final String TEXT_56 = NL + "\t";
  protected final String TEXT_57 = " = null;";
  protected final String TEXT_58 = NL + "\ttry{";
  protected final String TEXT_59 = NL + "\t";
  protected final String TEXT_60 = "if(fid_";
  protected final String TEXT_61 = ".get(Integer.parseInt(";
  protected final String TEXT_62 = "))";
  protected final String TEXT_63 = ".equals(";
  protected final String TEXT_64 = ")){";
  protected final String TEXT_65 = NL + "\t\tkey_";
  protected final String TEXT_66 = "_";
  protected final String TEXT_67 = "++;";
  protected final String TEXT_68 = NL + "\t\tkey_";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = " = fid_";
  protected final String TEXT_71 = ".get(";
  protected final String TEXT_72 = ")";
  protected final String TEXT_73 = ";";
  protected final String TEXT_74 = NL + "\t\tif((count_";
  protected final String TEXT_75 = "_";
  protected final String TEXT_76 = " < lowBound_";
  protected final String TEXT_77 = "_";
  protected final String TEXT_78 = ")";
  protected final String TEXT_79 = " || (count_";
  protected final String TEXT_80 = "_";
  protected final String TEXT_81 = " > highBound_";
  protected final String TEXT_82 = "_";
  protected final String TEXT_83 = ")";
  protected final String TEXT_84 = "){" + NL + "\t\t\tthrow new java.lang.Exception(\"Data error in file: The cardinality for \" + ";
  protected final String TEXT_85 = " + \" is ";
  protected final String TEXT_86 = ", but we have found \" + count_";
  protected final String TEXT_87 = "_";
  protected final String TEXT_88 = " + \".\");//thow exception............" + NL + "\t\t}" + NL + "\t\tcount_";
  protected final String TEXT_89 = "_";
  protected final String TEXT_90 = " = 0;";
  protected final String TEXT_91 = NL + "\t\tcount_";
  protected final String TEXT_92 = "_";
  protected final String TEXT_93 = "++;" + NL + "\t\tif((count_";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = " < lowBound_";
  protected final String TEXT_96 = "_";
  protected final String TEXT_97 = ")";
  protected final String TEXT_98 = " || (count_";
  protected final String TEXT_99 = "_";
  protected final String TEXT_100 = " > highBound_";
  protected final String TEXT_101 = "_";
  protected final String TEXT_102 = ")";
  protected final String TEXT_103 = "){" + NL + "\t\t\tthrow new java.lang.Exception(\"Data error in file: The cardinality for \" + ";
  protected final String TEXT_104 = " + \" is ";
  protected final String TEXT_105 = ", but we have found \" + count_";
  protected final String TEXT_106 = "_";
  protected final String TEXT_107 = " + \".\");//thow exception............" + NL + "\t\t}";
  protected final String TEXT_108 = NL + "\t\t";
  protected final String TEXT_109 = " = new ";
  protected final String TEXT_110 = "Struct();";
  protected final String TEXT_111 = NL + "\t\t";
  protected final String TEXT_112 = ".";
  protected final String TEXT_113 = " = String.valueOf(key_";
  protected final String TEXT_114 = "_";
  protected final String TEXT_115 = ");";
  protected final String TEXT_116 = NL + "\t\t";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = " = fid_";
  protected final String TEXT_119 = ".get(";
  protected final String TEXT_120 = ")";
  protected final String TEXT_121 = ";";
  protected final String TEXT_122 = NL + "\t\ttemp_";
  protected final String TEXT_123 = " = String.valueOf(key_";
  protected final String TEXT_124 = "_";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "\t\ttemp_";
  protected final String TEXT_127 = " = fid_";
  protected final String TEXT_128 = ".get(";
  protected final String TEXT_129 = ")";
  protected final String TEXT_130 = ";";
  protected final String TEXT_131 = NL + "\t\tif(temp_";
  protected final String TEXT_132 = ".length() > 0) {";
  protected final String TEXT_133 = NL + "\t\t\t";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = " = temp_";
  protected final String TEXT_136 = ".getBytes(";
  protected final String TEXT_137 = ");";
  protected final String TEXT_138 = "\t\t\t";
  protected final String TEXT_139 = ".";
  protected final String TEXT_140 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_141 = ", ";
  protected final String TEXT_142 = ",false);";
  protected final String TEXT_143 = NL + "\t\t\t";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_146 = ", ";
  protected final String TEXT_147 = ");";
  protected final String TEXT_148 = NL + "\t\t\t";
  protected final String TEXT_149 = ".";
  protected final String TEXT_150 = " = ParserUtils.parseTo_";
  protected final String TEXT_151 = "(ParserUtils.parseTo_Number(temp_";
  protected final String TEXT_152 = ", ";
  protected final String TEXT_153 = ", ";
  protected final String TEXT_154 = "));";
  protected final String TEXT_155 = NL + "\t\t\t";
  protected final String TEXT_156 = ".";
  protected final String TEXT_157 = " = ParserUtils.parseTo_";
  protected final String TEXT_158 = "(temp_";
  protected final String TEXT_159 = ");";
  protected final String TEXT_160 = NL + "\t\t} else {\t\t\t\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_162 = "' in '";
  protected final String TEXT_163 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_164 = "\t\t\t";
  protected final String TEXT_165 = ".";
  protected final String TEXT_166 = " = ";
  protected final String TEXT_167 = ";";
  protected final String TEXT_168 = "\t\t}";
  protected final String TEXT_169 = NL + "\t}";
  protected final String TEXT_170 = NL + "\t} catch (java.lang.Exception e) {";
  protected final String TEXT_171 = NL + "            throw(e);";
  protected final String TEXT_172 = NL + "\t\tlog.error(\"";
  protected final String TEXT_173 = " - \" + e.getMessage());";
  protected final String TEXT_174 = NL + "        System.err.println(e.getMessage());";
  protected final String TEXT_175 = NL + "\t\t";
  protected final String TEXT_176 = " = null;";
  protected final String TEXT_177 = NL + "\t}";
  protected final String TEXT_178 = NL + "int key_";
  protected final String TEXT_179 = "_";
  protected final String TEXT_180 = " = 0;";
  protected final String TEXT_181 = NL + "String key_";
  protected final String TEXT_182 = "_";
  protected final String TEXT_183 = " = \"\";";
  protected final String TEXT_184 = NL + "int count_";
  protected final String TEXT_185 = "_";
  protected final String TEXT_186 = " = ";
  protected final String TEXT_187 = ";" + NL + "final int lowBound_";
  protected final String TEXT_188 = "_";
  protected final String TEXT_189 = " = ";
  protected final String TEXT_190 = ";";
  protected final String TEXT_191 = "final int highBound_";
  protected final String TEXT_192 = "_";
  protected final String TEXT_193 = " = ";
  protected final String TEXT_194 = ";";
  protected final String TEXT_195 = NL + "char fieldSeparator_";
  protected final String TEXT_196 = "[] = null;" + NL + "\t\t" + NL + "//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'. " + NL + "if ( ((String)";
  protected final String TEXT_197 = ").length() > 0 ){" + NL + "\tfieldSeparator_";
  protected final String TEXT_198 = " = ((String)";
  protected final String TEXT_199 = ").toCharArray();" + NL + "}else {\t\t\t" + NL + "\tthrow new IllegalArgumentException(\"Field Separator must be assigned a char.\"); " + NL + "}" + NL + "\t\t" + NL + "char rowSeparator_";
  protected final String TEXT_200 = "[] = null;" + NL + "\t\t" + NL + "//support passing value (property: Row Separator) by 'context.rs' or 'globalMap.get(\"rs\")'. " + NL + "if ( ((String)";
  protected final String TEXT_201 = ").length() > 0 ){" + NL + "\trowSeparator_";
  protected final String TEXT_202 = " = ((String)";
  protected final String TEXT_203 = ").toCharArray();" + NL + "}else {" + NL + "\tthrow new IllegalArgumentException(\"Row Separator must be assigned a char.\"); " + NL + "}" + NL + "\t\t" + NL + "com.talend.csv.CSVReader ";
  protected final String TEXT_204 = "csvReader";
  protected final String TEXT_205 = "=new com.talend.csv.CSVReader(new java.io.BufferedReader(new java.io.InputStreamReader( new java.io.FileInputStream(";
  protected final String TEXT_206 = "),";
  protected final String TEXT_207 = ")), ";
  protected final String TEXT_208 = ");";
  protected final String TEXT_209 = NL;
  protected final String TEXT_210 = "csvReader";
  protected final String TEXT_211 = ".setTrimWhitespace(false);" + NL;
  protected final String TEXT_212 = NL + "\ttmpcsvReader";
  protected final String TEXT_213 = ".setStoreRawRecord(true);";
  protected final String TEXT_214 = NL + NL + "if ( (rowSeparator_";
  protected final String TEXT_215 = "[0] != '\\n') && (rowSeparator_";
  protected final String TEXT_216 = "[0] != '\\r') )" + NL + "\t";
  protected final String TEXT_217 = "csvReader";
  protected final String TEXT_218 = ".setLineEnd(\"\"+rowSeparator_";
  protected final String TEXT_219 = "[0]);" + NL;
  protected final String TEXT_220 = NL;
  protected final String TEXT_221 = "csvReader";
  protected final String TEXT_222 = ".setQuoteChar('";
  protected final String TEXT_223 = "');" + NL;
  protected final String TEXT_224 = NL;
  protected final String TEXT_225 = "csvReader";
  protected final String TEXT_226 = ".setEscapeChar('\\\\');";
  protected final String TEXT_227 = NL;
  protected final String TEXT_228 = "csvReader";
  protected final String TEXT_229 = ".setEscapeChar(";
  protected final String TEXT_230 = "csvReader";
  protected final String TEXT_231 = ".getQuoteChar());";
  protected final String TEXT_232 = NL + "//?????doesn't work for other escapeChar" + NL + "//the default escape mode is double escape";
  protected final String TEXT_233 = NL;
  protected final String TEXT_234 = "csvReader";
  protected final String TEXT_235 = ".setEscapeChar(";
  protected final String TEXT_236 = "csvReader";
  protected final String TEXT_237 = ".getQuoteChar());";
  protected final String TEXT_238 = "\t" + NL + "String[] delim_";
  protected final String TEXT_239 = " = new String[]{";
  protected final String TEXT_240 = NL;
  protected final String TEXT_241 = NL + "};" + NL + "" + NL + "//java.io.BufferedReader reader_";
  protected final String TEXT_242 = " = new java.io.BufferedReader(new java.io.FileReader(";
  protected final String TEXT_243 = "));" + NL + "" + NL + "String tmp";
  protected final String TEXT_244 = " = \"\";";
  protected final String TEXT_245 = "      " + NL + "" + NL + "int index_";
  protected final String TEXT_246 = " = Integer.parseInt(";
  protected final String TEXT_247 = ");" + NL + "" + NL + "String[] row";
  protected final String TEXT_248 = "=null;" + NL + "  " + NL + "String temp_";
  protected final String TEXT_249 = " = null;" + NL + "" + NL + "while ( ";
  protected final String TEXT_250 = "csvReader";
  protected final String TEXT_251 = ".readNext() ) {";
  protected final String TEXT_252 = NL + "\trow";
  protected final String TEXT_253 = "=csvReader";
  protected final String TEXT_254 = ".getValues();" + NL + "\t";
  protected final String TEXT_255 = NL + "\tfor(int ii_";
  protected final String TEXT_256 = "=0;ii_";
  protected final String TEXT_257 = " < row";
  protected final String TEXT_258 = ".length;ii_";
  protected final String TEXT_259 = "++){" + NL + "\t\trow";
  protected final String TEXT_260 = "[ii_";
  protected final String TEXT_261 = "] = row";
  protected final String TEXT_262 = "[ii_";
  protected final String TEXT_263 = "].trim(); " + NL + "\t}" + NL + "\t";
  protected final String TEXT_264 = NL + "\ttmp";
  protected final String TEXT_265 = " = ";
  protected final String TEXT_266 = "csvReader";
  protected final String TEXT_267 = ".getRawRecord();" + NL + "\tfor(int i_";
  protected final String TEXT_268 = "=0; i_";
  protected final String TEXT_269 = "<delim_";
  protected final String TEXT_270 = ".length; i_";
  protected final String TEXT_271 = "++){ //NS000" + NL + "\t\tcom.talend.csv.CSVReader csvReader";
  protected final String TEXT_272 = " = new com.talend.csv.CSVReader(new java.io.BufferedReader(new java.io.InputStreamReader(" + NL + "\t\t\tnew java.io.ByteArrayInputStream(tmp";
  protected final String TEXT_273 = ".getBytes()), ";
  protected final String TEXT_274 = ")), delim_";
  protected final String TEXT_275 = "[i_";
  protected final String TEXT_276 = "].charAt(0));" + NL + "\t\tcsvReader";
  protected final String TEXT_277 = ".setTrimWhitespace(false);" + NL + "\t\tif ( (rowSeparator_";
  protected final String TEXT_278 = "[0] != '\\n') && (rowSeparator_";
  protected final String TEXT_279 = "[0] != '\\r') )" + NL + "\t\t\tcsvReader";
  protected final String TEXT_280 = ".setLineEnd(\"\" + rowSeparator_";
  protected final String TEXT_281 = "[0]);" + NL + "\t\t" + NL + "\t\tcsvReader";
  protected final String TEXT_282 = ".setQuoteChar('";
  protected final String TEXT_283 = "');";
  protected final String TEXT_284 = NL + "\t\tcsvReader";
  protected final String TEXT_285 = ".setEscapeChar('\\\\');";
  protected final String TEXT_286 = NL + "\t\tcsvReader";
  protected final String TEXT_287 = ".setEscapeChar(csvReader";
  protected final String TEXT_288 = ".getQuoteChar());";
  protected final String TEXT_289 = NL + "\t\t//?????doesn't work for other escapeChar" + NL + "\t\tcsvReader";
  protected final String TEXT_290 = ".setEscapeChar(csvReader";
  protected final String TEXT_291 = ".getQuoteChar());";
  protected final String TEXT_292 = NL;
  protected final String TEXT_293 = NL + "\t";
  protected final String TEXT_294 = " = null;";
  protected final String TEXT_295 = "\t\t";
  protected final String TEXT_296 = NL + NL + "\t\tif(csvReader";
  protected final String TEXT_297 = ".readNext()==false) {" + NL + "\t\t\tcsvReader";
  protected final String TEXT_298 = ".close();" + NL + "\t\t\tbreak;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\trow";
  protected final String TEXT_299 = " = csvReader";
  protected final String TEXT_300 = ".getValues();" + NL + "    \t";
  protected final String TEXT_301 = NL + "    \tfor(int ii_";
  protected final String TEXT_302 = "=0;ii_";
  protected final String TEXT_303 = " < row";
  protected final String TEXT_304 = ".length;ii_";
  protected final String TEXT_305 = "++){" + NL + "    \t\trow";
  protected final String TEXT_306 = "[ii_";
  protected final String TEXT_307 = "] = row";
  protected final String TEXT_308 = "[ii_";
  protected final String TEXT_309 = "].trim(); " + NL + "    \t}" + NL + "    \t";
  protected final String TEXT_310 = NL + "\t\tif (row";
  protected final String TEXT_311 = " == null" + NL + "\t\t\t\t|| row";
  protected final String TEXT_312 = ".length <= index_";
  protected final String TEXT_313 = ") {" + NL + "\t\t\tcontinue;" + NL + "\t\t}";
  protected final String TEXT_314 = NL + "\t\ttry{";
  protected final String TEXT_315 = NL + "\t";
  protected final String TEXT_316 = "if((row";
  protected final String TEXT_317 = ".length == 0) ? (\"\".equals(";
  protected final String TEXT_318 = ")) : " + NL + "\t(row";
  protected final String TEXT_319 = "[index_";
  protected final String TEXT_320 = "].equals(";
  protected final String TEXT_321 = ")";
  protected final String TEXT_322 = ")){";
  protected final String TEXT_323 = NL + "\t\tkey_";
  protected final String TEXT_324 = "_";
  protected final String TEXT_325 = "++;";
  protected final String TEXT_326 = NL + "\t\tkey_";
  protected final String TEXT_327 = "_";
  protected final String TEXT_328 = " = (row";
  protected final String TEXT_329 = ".length <= ";
  protected final String TEXT_330 = ") ? \"\" : row";
  protected final String TEXT_331 = "[";
  protected final String TEXT_332 = "];";
  protected final String TEXT_333 = NL + "\t\tif((count_";
  protected final String TEXT_334 = "_";
  protected final String TEXT_335 = " < lowBound_";
  protected final String TEXT_336 = "_";
  protected final String TEXT_337 = ") || (count_";
  protected final String TEXT_338 = "_";
  protected final String TEXT_339 = " > highBound_";
  protected final String TEXT_340 = "_";
  protected final String TEXT_341 = ")){" + NL + "\t\t\tthrow new java.lang.Exception(\"Data error in file: The cardinality for \" + ";
  protected final String TEXT_342 = " + \" is ";
  protected final String TEXT_343 = ", but we have found \" + count_";
  protected final String TEXT_344 = "_";
  protected final String TEXT_345 = " + \".\");//thow exception............" + NL + "\t\t}" + NL + "\t\tcount_";
  protected final String TEXT_346 = "_";
  protected final String TEXT_347 = " = 0;";
  protected final String TEXT_348 = NL + "\t\tcount_";
  protected final String TEXT_349 = "_";
  protected final String TEXT_350 = "++;" + NL + "\t\tif((count_";
  protected final String TEXT_351 = "_";
  protected final String TEXT_352 = " < lowBound_";
  protected final String TEXT_353 = "_";
  protected final String TEXT_354 = ") || (count_";
  protected final String TEXT_355 = "_";
  protected final String TEXT_356 = " > highBound_";
  protected final String TEXT_357 = "_";
  protected final String TEXT_358 = ")){" + NL + "\t\t\tthrow new java.lang.Exception(\"Data error in file: The cardinality for \" + ";
  protected final String TEXT_359 = " + \" is ";
  protected final String TEXT_360 = ", but we have found \" + count_";
  protected final String TEXT_361 = "_";
  protected final String TEXT_362 = " + \".\");//thow exception............" + NL + "\t\t}";
  protected final String TEXT_363 = NL + "\t\t";
  protected final String TEXT_364 = " = new ";
  protected final String TEXT_365 = "Struct();";
  protected final String TEXT_366 = NL + "\t\t";
  protected final String TEXT_367 = ".";
  protected final String TEXT_368 = " = String.valueOf(key_";
  protected final String TEXT_369 = "_";
  protected final String TEXT_370 = ");";
  protected final String TEXT_371 = NL + "\t\t";
  protected final String TEXT_372 = ".";
  protected final String TEXT_373 = " = (row";
  protected final String TEXT_374 = ".length <= ";
  protected final String TEXT_375 = ") ? \"\" : row";
  protected final String TEXT_376 = "[";
  protected final String TEXT_377 = "];";
  protected final String TEXT_378 = NL + "\t\ttemp_";
  protected final String TEXT_379 = " = String.valueOf(key_";
  protected final String TEXT_380 = "_";
  protected final String TEXT_381 = ");";
  protected final String TEXT_382 = NL + "\t\ttemp_";
  protected final String TEXT_383 = " = (row";
  protected final String TEXT_384 = ".length <= ";
  protected final String TEXT_385 = ") ? \"\" : row";
  protected final String TEXT_386 = "[";
  protected final String TEXT_387 = "];";
  protected final String TEXT_388 = NL + "\t\tif(temp_";
  protected final String TEXT_389 = ".length() > 0) {";
  protected final String TEXT_390 = NL + "\t\t\t";
  protected final String TEXT_391 = ".";
  protected final String TEXT_392 = " = temp_";
  protected final String TEXT_393 = ".getBytes(";
  protected final String TEXT_394 = ");";
  protected final String TEXT_395 = "\t\t\t";
  protected final String TEXT_396 = ".";
  protected final String TEXT_397 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_398 = ", ";
  protected final String TEXT_399 = ",false);";
  protected final String TEXT_400 = NL + "\t\t\t";
  protected final String TEXT_401 = ".";
  protected final String TEXT_402 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_403 = ", ";
  protected final String TEXT_404 = ");";
  protected final String TEXT_405 = NL + "\t\t\t";
  protected final String TEXT_406 = ".";
  protected final String TEXT_407 = " = ParserUtils.parseTo_";
  protected final String TEXT_408 = "(ParserUtils.parseTo_Number(temp_";
  protected final String TEXT_409 = ", ";
  protected final String TEXT_410 = ", ";
  protected final String TEXT_411 = "));";
  protected final String TEXT_412 = NL + "\t\t\t";
  protected final String TEXT_413 = ".";
  protected final String TEXT_414 = " = ParserUtils.parseTo_";
  protected final String TEXT_415 = "(temp_";
  protected final String TEXT_416 = ");";
  protected final String TEXT_417 = NL + "\t\t} else {\t\t\t\t\t\t";
  protected final String TEXT_418 = NL + "\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_419 = "' in '";
  protected final String TEXT_420 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_421 = "\t\t\t";
  protected final String TEXT_422 = ".";
  protected final String TEXT_423 = " = ";
  protected final String TEXT_424 = ";";
  protected final String TEXT_425 = "\t\t}";
  protected final String TEXT_426 = NL + "\t\tif(csvReader";
  protected final String TEXT_427 = "!=null) {" + NL + "\t\t\tcsvReader";
  protected final String TEXT_428 = ".close();" + NL + "\t\t}" + NL + "\t\tbreak;";
  protected final String TEXT_429 = NL + "\t}";
  protected final String TEXT_430 = NL + "\t} catch (java.lang.Exception e) {";
  protected final String TEXT_431 = NL + "            throw(e);";
  protected final String TEXT_432 = NL + "\t\tlog.error(\"";
  protected final String TEXT_433 = " - \" + e.getMessage());";
  protected final String TEXT_434 = NL + "        System.err.println(e.getMessage());";
  protected final String TEXT_435 = NL + "\t\t";
  protected final String TEXT_436 = " = null;";
  protected final String TEXT_437 = NL + "\t}";
  protected final String TEXT_438 = NL;
  protected final String TEXT_439 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_30);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
boolean hasDataLink = false;
if(conns!=null){
	for(int i=0;i<conns.size();i++){
		IConnection connTemp = conns.get(i);
	    if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	   		hasDataLink = true;
	   		break;
	    }
	}
}

final boolean isLog4jEnabled = "true".equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

List<Map<String, String>> schemas_o = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SCHEMAS__");
List<Map<String, String>> schemas = new java.util.ArrayList<Map<String, String>>();
for(Map<String, String> schema_o : schemas_o){
	Map<String, String> schema = new java.util.HashMap<String, String>();
	schemas.add(schema);
	schema.put("SCHEMA", TalendTextUtils.removeQuotes(schema_o.get("SCHEMA")));
	schema.put("RECORD", schema_o.get("RECORD"));
	schema.put("PARENT_RECORD", schema_o.get("PARENT_RECORD"));
	schema.put("KEY_COLUMN_INDEX", TalendTextUtils.removeQuotes(schema_o.get("KEY_COLUMN_INDEX")));
	schema.put("CARDINALITY", TalendTextUtils.removeQuotes(schema_o.get("CARDINALITY")));
	schema.put("FIELDDELIMITED",schema_o.get("FIELDDELIMITED"));
	String strInfinitude = "false"; // used to support *
	if(!("\"\"").equals(schema.get("PARENT_RECORD"))){//has parent node
		String cardString = schema.get("CARDINALITY");
		if(("*").equals(cardString)){
			strInfinitude = "true";
		}else if(cardString.contains(",")){
			String[] cards = cardString.split(",");
			if(("*").equals(cards[1])){
				strInfinitude = "true";
			}
		}
	}
	schema.put("IS_INFINITUDE",strInfinitude);
}

String filename_o = ElementParameterParser.getValue(node,"__FILENAME__");
String filename = filename_o;
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
String fieldSeparator = ElementParameterParser.getValue(node,"__FIELDSEPARATOR__");
String columnIndex = ElementParameterParser.getValue(node,"__COLUMNINDEX__");

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false; 
		
boolean trimAll = ("true").equals(ElementParameterParser.getValue(node,"__TRIMALL__"));

String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;

boolean useMulSeprators = "true".equals(ElementParameterParser.getValue(node,"__USE_MULTISEPARATORS__"));

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

if (hasDataLink) {//FIM_000
////////////////////////

log4jFileUtil.startRetriveDataInfo();

if(useMulSeprators==false && ("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {//FIM_0000
	List<String> connections = new java.util.ArrayList<String>();
    Map<String, List<IMetadataColumn>> connectionMapColumnList = new java.util.HashMap<String, List<IMetadataColumn>>();
    Map<String, String> schemaConnectionMap = new java.util.HashMap<String, String>();
    
    for(int i=0;i<conns.size();i++){
    	IConnection connTemp = conns.get(i);
    	if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		IMetadataTable tempMetadataTable = connTemp.getMetadataTable();
    		for(Map<String, String> schema : schemas){
				if(tempMetadataTable.getLabel().equals(schema.get("SCHEMA"))){
					schemaConnectionMap.put(schema.get("SCHEMA"), connTemp.getName());
					break;
				}
			}
    		List<IMetadataColumn> listColumns = tempMetadataTable.getListColumns();
    		connections.add(connTemp.getName());
    		connectionMapColumnList.put(connTemp.getName(), listColumns);
    	}
	}
	
	for(int i=0; i<schemas.size();i++){//FIM_001
		Map<String, String> schema = schemas.get(i);
		String schemaName = schema.get("SCHEMA");
		for(int j=0; j<schemas.size();j++){
			if(i == j){
				continue;
			}
			Map<String, String> schema2 = schemas.get(j);
			if(schema.get("RECORD").equals(schema2.get("PARENT_RECORD"))){//has child node
				String keyIndex = schema.get("KEY_COLUMN_INDEX");
				if(("").equals(keyIndex)){//no key __________PROBLEM_2_________

    stringBuffer.append(TEXT_31);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
				}else{

    stringBuffer.append(TEXT_34);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    
				}
				break;
			}
		}
		if(!("\"\"").equals(schema.get("PARENT_RECORD"))){//has parent node
			String cardString = schema.get("CARDINALITY");
			String lowBound = String.valueOf(0);
			String highBound = String.valueOf(Integer.MAX_VALUE);
			//way to parse the cardinality string.............__________PROBLEM_3_________
			if(("").equals(cardString)){
				//do nothing
			}else if(cardString.contains(",")){
				String[] cards = cardString.split(",");
				lowBound = cards[0];
				highBound = cards[1];
			}else{
				lowBound = cardString;
				highBound = cardString;
			}

    stringBuffer.append(TEXT_37);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(lowBound );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(lowBound );
    stringBuffer.append(TEXT_43);
    if(("false").equals(schema.get("IS_INFINITUDE"))){
    stringBuffer.append(TEXT_44);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(highBound );
    stringBuffer.append(TEXT_47);
    }
    
		}
	}//FIM_001

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    
	for(String conName : connections){

    stringBuffer.append(TEXT_56);
    stringBuffer.append(conName );
    stringBuffer.append(TEXT_57);
    
	}

    stringBuffer.append(TEXT_58);
    
	for(int i=0; i<schemas.size();i++){//FIM_002
		Map<String, String> schema = schemas.get(i);
		String record = schema.get("RECORD");

    stringBuffer.append(TEXT_59);
    stringBuffer.append((i==0) ? "" : "else " );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(columnIndex );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(trimAll?".trim()":"");
    stringBuffer.append(TEXT_63);
    stringBuffer.append(record );
    stringBuffer.append(TEXT_64);
    
		String schemaName = schema.get("SCHEMA");
		boolean keyUpdated = false;
		for(int j=0; j<schemas.size();j++){
			if(i == j){
				continue;
			}
			Map<String, String> schema2 = schemas.get(j);
			if(schema.get("RECORD").equals(schema2.get("PARENT_RECORD"))){//FIM_003
			//get child node
				if(!keyUpdated){//FIM_003_1
					keyUpdated = true;
					String keyIndex = schema.get("KEY_COLUMN_INDEX");
					if(("").equals(keyIndex)){//no key ??? 

    stringBuffer.append(TEXT_65);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    
					}else{

    stringBuffer.append(TEXT_68);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(keyIndex);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(trimAll?".trim()":"");
    stringBuffer.append(TEXT_73);
    
					}
				}//FIM_003_1
				String schemaNameChild = schema2.get("SCHEMA");
				String cardinality = schema2.get("CARDINALITY");
				String childRecord = schema2.get("RECORD");

    stringBuffer.append(TEXT_74);
    stringBuffer.append(schemaNameChild );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(schemaNameChild );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    if(("false").equals(schema2.get("IS_INFINITUDE"))){
    stringBuffer.append(TEXT_79);
    stringBuffer.append(schemaNameChild );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(schemaNameChild );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(childRecord );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cardinality );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(schemaNameChild );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(schemaNameChild );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    
			}//FIM_003
		}
		if(!("\"\"").equals(schema.get("PARENT_RECORD"))){//has parent node
			String cardinality = schema.get("CARDINALITY");

    stringBuffer.append(TEXT_91);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    if(("false").equals(schema.get("IS_INFINITUDE"))){
    stringBuffer.append(TEXT_98);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    stringBuffer.append(record );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cardinality );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    
		}
		String connection = schemaConnectionMap.get(schemaName);
		if(connection != null){//FIM_004 has connection......

    stringBuffer.append(TEXT_108);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_110);
    
			String parentRecord = schema.get("PARENT_RECORD");
			String parentSchema = null;
			for(int j=0; j<schemas.size();j++){
				if(i == j){
					continue;
				}
				Map<String, String> schema2 = schemas.get(j);
				if(schema2.get("RECORD").equals(parentRecord)){//has child node
					parentSchema = schema2.get("SCHEMA");
					break;
				}
			}
			
			List<IMetadataColumn> listColumns = connectionMapColumnList.get(connection);
			//
			for (int valueN=0; valueN < listColumns.size(); valueN++) {//FIM_005
				IMetadataColumn column = listColumns.get(valueN);
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){//FIM_006
					if(valueN + 1 == listColumns.size() && parentSchema != null){

    stringBuffer.append(TEXT_111);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(parentSchema );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    
					}else{

    stringBuffer.append(TEXT_116);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(trimAll?".trim()":"");
    stringBuffer.append(TEXT_121);
    
					}
				}else{ //FIM_006
					if(valueN + 1 == listColumns.size() && parentSchema != null){

    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(parentSchema );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    
					}else{

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(trimAll?".trim()":"");
    stringBuffer.append(TEXT_130);
    
					}

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_133);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_137);
    
					}else if(javaType == JavaTypesManager.DATE) { 
						if(checkDate) {

    stringBuffer.append(TEXT_138);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_142);
    
						} else {

    stringBuffer.append(TEXT_143);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_147);
    
						}
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_148);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_150);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_153);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_154);
    
					} else {

    stringBuffer.append(TEXT_155);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_157);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    
					}

    stringBuffer.append(TEXT_160);
    
					String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
					if(defaultValue == null) {

    stringBuffer.append(TEXT_161);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_163);
    
					} else {

    stringBuffer.append(TEXT_164);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_167);
    
					}

    stringBuffer.append(TEXT_168);
    
				} //FIM_006
			}//FIM_005
			//
		}//FIM_004

    stringBuffer.append(TEXT_169);
    
	}//FIN_002

    stringBuffer.append(TEXT_170);
    
        if (dieOnError) {
 
    stringBuffer.append(TEXT_171);
    
        } else {
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
			}

    stringBuffer.append(TEXT_174);
    
			for(String conName : connections){

    stringBuffer.append(TEXT_175);
    stringBuffer.append(conName );
    stringBuffer.append(TEXT_176);
    
			}
        }

    stringBuffer.append(TEXT_177);
    
}else{//FIM_0000
//CVS OPTION
	String delim1 = fieldSeparator;     	
    String rowSeparator1 = rowSeparator;
    	
    String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
    if(("").equals(escapeChar1)){
    	escapeChar1 = "\"\"";
    }
    String escapeChar = escapeChar1.substring(1,escapeChar1.length()-1);
    if(("'").equals(escapeChar)){
    	escapeChar = "\\'";
    }
    String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
    if(("").equals(textEnclosure1)){
    	textEnclosure1 = "\"\"";
    }
    String textEnclosure = textEnclosure1.substring(1,textEnclosure1.length()-1);
    if ("".equals(textEnclosure)) textEnclosure = "\0";
    if(("'").equals(textEnclosure)){
    	textEnclosure = "\\'";
    }
    
    String strIndex = ElementParameterParser.getValue(node, "__COLUMNINDEX__");
    	
	List<String> connections = new java.util.ArrayList<String>();
    Map<String, List<IMetadataColumn>> connectionMapColumnList = new java.util.HashMap<String, List<IMetadataColumn>>();
    Map<String, String> schemaConnectionMap = new java.util.HashMap<String, String>();
    
    for(int i=0;i<conns.size();i++){
    	IConnection connTemp = conns.get(i);
    	if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		IMetadataTable tempMetadataTable = connTemp.getMetadataTable();
    		for(Map<String, String> schema : schemas){
				if(tempMetadataTable.getLabel().equals(schema.get("SCHEMA"))){
					schemaConnectionMap.put(schema.get("SCHEMA"), connTemp.getName());
					break;
				}
			}
    		List<IMetadataColumn> listColumns = tempMetadataTable.getListColumns();
    		connections.add(connTemp.getName());
    		connectionMapColumnList.put(connTemp.getName(), listColumns);
    	}
	}
	
	for(int i=0; i<schemas.size();i++){//FIM_001
		Map<String, String> schema = schemas.get(i);
		String schemaName = schema.get("SCHEMA");
		for(int j=0; j<schemas.size();j++){
			if(i == j){
				continue;
			}
			Map<String, String> schema2 = schemas.get(j);
			if(schema.get("RECORD").equals(schema2.get("PARENT_RECORD"))){//has child node
				String keyIndex = schema.get("KEY_COLUMN_INDEX");
				if(("").equals(keyIndex)){//no key __________PROBLEM_2_________

    stringBuffer.append(TEXT_178);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    
				}else{

    stringBuffer.append(TEXT_181);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    
				}
				break;
			}
		}
		if(!("\"\"").equals(schema.get("PARENT_RECORD"))){//has parent node
			String cardString = schema.get("CARDINALITY");
			String lowBound = String.valueOf(0);
			String highBound = String.valueOf(Integer.MAX_VALUE);
			//way to parse the cardinality string.............__________PROBLEM_3_________
			if(("").equals(cardString)){
				//do nothing
			}else if(cardString.contains(",")){
				String[] cards = cardString.split(",");
				lowBound = cards[0];
				highBound = cards[1];
			}else{
				lowBound = cardString;
				highBound = cardString;
			}

    stringBuffer.append(TEXT_184);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(lowBound );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(lowBound );
    stringBuffer.append(TEXT_190);
    if(("false").equals(schema.get("IS_INFINITUDE"))){
    stringBuffer.append(TEXT_191);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(highBound );
    stringBuffer.append(TEXT_194);
    }
    
		}
	}//FIM_001

    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(rowSeparator1);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(rowSeparator1);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(useMulSeprators? "tmp":"" );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(useMulSeprators?"';'" : "fieldSeparator_"+cid+"[0]" );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(useMulSeprators? "tmp":"" );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    if(useMulSeprators) {
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    }
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(useMulSeprators? "tmp":"" );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(useMulSeprators? "tmp":"" );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_223);
    
	if(("\\\\").equals(escapeChar)){
        
    stringBuffer.append(TEXT_224);
    stringBuffer.append(useMulSeprators? "tmp":"" );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    
	}else if(escapeChar.equals(textEnclosure)){
        
    stringBuffer.append(TEXT_227);
    stringBuffer.append(useMulSeprators? "tmp":"" );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(useMulSeprators? "tmp":"" );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    
	}else{
        
    stringBuffer.append(TEXT_232);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(useMulSeprators? "tmp":"" );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(useMulSeprators? "tmp":"" );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    
	}
if(useMulSeprators==true){
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    
		for(int i=0; i<schemas.size(); i++){
			Map<String, String> schema = schemas.get(i);

    stringBuffer.append(TEXT_240);
    stringBuffer.append((i==0? "":","));
    stringBuffer.append(schema.get("FIELDDELIMITED") );
    
		}

    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    }
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(strIndex );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(useMulSeprators? "tmp":"" );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    
if(useMulSeprators==false){

    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    if(trimAll){
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    }
    
}else{

    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(useMulSeprators? "tmp":"" );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_283);
    
	if(("\\\\").equals(escapeChar)){
        
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    
	}else if(escapeChar.equals(textEnclosure)){
        
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    
	}else{
        
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    
	}
}
    stringBuffer.append(TEXT_292);
     
	for(String conName : connections){

    stringBuffer.append(TEXT_293);
    stringBuffer.append(conName );
    stringBuffer.append(TEXT_294);
     
	}

    stringBuffer.append(TEXT_295);
    if(useMulSeprators==true){
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    if(trimAll){
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    }
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    }
    stringBuffer.append(TEXT_314);
    
	for(int i=0; i<schemas.size();i++){//FIM_002
		Map<String, String> schema = schemas.get(i);
		String record = schema.get("RECORD");

    stringBuffer.append(TEXT_315);
    stringBuffer.append((i==0) ? "" : "else " );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(record );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(record );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(useMulSeprators? " && delim_"+cid+"[i_"+cid+"].equals("+ schema.get("FIELDDELIMITED") +")":"" );
    stringBuffer.append(TEXT_322);
    
		String schemaName = schema.get("SCHEMA");
		boolean keyUpdated = false;
		for(int j=0; j<schemas.size();j++){
			if(i == j){
				continue;
			}
			Map<String, String> schema2 = schemas.get(j);
			if(schema.get("RECORD").equals(schema2.get("PARENT_RECORD"))){//FIM_003
			//get child node
				if(!keyUpdated){//FIM_003_1
					keyUpdated = true;
					String keyIndex = schema.get("KEY_COLUMN_INDEX");
					if(("").equals(keyIndex)){//no key ??? 

    stringBuffer.append(TEXT_323);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    
				}else{

    stringBuffer.append(TEXT_326);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(keyIndex);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(keyIndex );
    stringBuffer.append(TEXT_332);
    
					}
				}//FIM_003_1
				String schemaNameChild = schema2.get("SCHEMA");
				String cardinality = schema2.get("CARDINALITY");
				String childRecord = schema2.get("RECORD");

    stringBuffer.append(TEXT_333);
    stringBuffer.append(schemaNameChild );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(schemaNameChild );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(schemaNameChild );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(schemaNameChild );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(childRecord );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cardinality );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(schemaNameChild );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(schemaNameChild );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    
			}//FIM_003
		}
		if(!("\"\"").equals(schema.get("PARENT_RECORD"))){//has parent node
			String cardinality = schema.get("CARDINALITY");

    stringBuffer.append(TEXT_348);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(record );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cardinality );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(schemaName );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    
		}
		String connection = schemaConnectionMap.get(schemaName);
		if(connection != null){//FIM_004 has connection......

    stringBuffer.append(TEXT_363);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_365);
    
			String parentRecord = schema.get("PARENT_RECORD");
			String parentSchema = null;
			for(int j=0; j<schemas.size();j++){
				if(i == j){
					continue;
				}
				Map<String, String> schema2 = schemas.get(j);
				if(schema2.get("RECORD").equals(parentRecord)){//has child node
					parentSchema = schema2.get("SCHEMA");
					break;
				}
			}
			
			List<IMetadataColumn> listColumns = connectionMapColumnList.get(connection);
			//
			for (int valueN=0; valueN < listColumns.size(); valueN++) {//FIM_005
				IMetadataColumn column = listColumns.get(valueN);
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){//FIM_006
					if(valueN + 1 == listColumns.size() && parentSchema != null){

    stringBuffer.append(TEXT_366);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(parentSchema );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    
					}else{

    stringBuffer.append(TEXT_371);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_377);
    
					}
				}else{ //FIM_006
					if(valueN + 1 == listColumns.size() && parentSchema != null){

    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(parentSchema );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    
					}else{

    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_384);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_386);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_387);
    
					}

    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_390);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_394);
    
					}else if(javaType == JavaTypesManager.DATE) { 
						if(checkDate) {

    stringBuffer.append(TEXT_395);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_399);
    
						} else {

    stringBuffer.append(TEXT_400);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_404);
    
						}
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_405);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_407);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_410);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_411);
    
					} else {

    stringBuffer.append(TEXT_412);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_414);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_416);
    
					}

    stringBuffer.append(TEXT_417);
    
					String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
					if(defaultValue == null) {

    stringBuffer.append(TEXT_418);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_419);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_420);
    
					} else {

    stringBuffer.append(TEXT_421);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_424);
    
					}

    stringBuffer.append(TEXT_425);
    
				} //FIM_006
			}//FIM_005
			if(useMulSeprators==true){

    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_428);
    
			}
		}//FIM_004

    stringBuffer.append(TEXT_429);
    
	}//FIN_002

    stringBuffer.append(TEXT_430);
    
        if (dieOnError) {
 
    stringBuffer.append(TEXT_431);
    
        } else {
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    
			}

    stringBuffer.append(TEXT_434);
    
			for(String conName : connections){

    stringBuffer.append(TEXT_435);
    stringBuffer.append(conName );
    stringBuffer.append(TEXT_436);
    
			}
        }

    stringBuffer.append(TEXT_437);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(useMulSeprators==true? "}":"");
    
}
}//FIM_000
////////////////////////

    stringBuffer.append(TEXT_439);
    return stringBuffer.toString();
  }
}
