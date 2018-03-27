package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.AbstractNode;

public class TFileOutputDelimitedMainJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedMainJava result = new TFileOutputDelimitedMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "                    StringBuilder sb_";
  protected final String TEXT_4 = " = new StringBuilder();";
  protected final String TEXT_5 = NL + "                synchronized (multiThreadLockWrite) {";
  protected final String TEXT_6 = NL + "                synchronized ((Object[])globalMap.get(\"lockWrite_";
  protected final String TEXT_7 = "\")) {";
  protected final String TEXT_8 = NL + "                Object[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "                synchronized (pLockWrite) {";
  protected final String TEXT_9 = NL + "                    if(isFirstCheckDyn_";
  protected final String TEXT_10 = " ";
  protected final String TEXT_11 = "&& (file_";
  protected final String TEXT_12 = ".length()==0)";
  protected final String TEXT_13 = "){";
  protected final String TEXT_14 = NL + "                    if(isFirstCheckDyn_";
  protected final String TEXT_15 = " ";
  protected final String TEXT_16 = "&& file";
  protected final String TEXT_17 = ".length()==0";
  protected final String TEXT_18 = "){";
  protected final String TEXT_19 = NL + "                                    fileOutputDelimitedUtil_";
  protected final String TEXT_20 = ".putHeaderValue_";
  protected final String TEXT_21 = "(out";
  protected final String TEXT_22 = ",OUT_DELIM_";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "                        out";
  protected final String TEXT_26 = ".write(\"";
  protected final String TEXT_27 = "\");";
  protected final String TEXT_28 = NL + "                        routines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ", out";
  protected final String TEXT_31 = ", OUT_DELIM_";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "                        out";
  protected final String TEXT_34 = ".write(OUT_DELIM_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "                        out";
  protected final String TEXT_37 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_38 = ");" + NL + "                        isFirstCheckDyn_";
  protected final String TEXT_39 = " = false;" + NL + "                    }";
  protected final String TEXT_40 = NL + "                }";
  protected final String TEXT_41 = NL + "                }";
  protected final String TEXT_42 = NL + "                }";
  protected final String TEXT_43 = NL + "                            fileOutputDelimitedUtil_";
  protected final String TEXT_44 = ".putValue_";
  protected final String TEXT_45 = "(";
  protected final String TEXT_46 = ",sb_";
  protected final String TEXT_47 = ",OUT_DELIM_";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "                            if(";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = " != null) {";
  protected final String TEXT_52 = NL + "                        routines.system.DynamicUtils.writeValuesToStringBuilder(";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = ", sb_";
  protected final String TEXT_55 = ", OUT_DELIM_";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "                        sb_";
  protected final String TEXT_58 = ".append(";
  protected final String TEXT_59 = NL + "                            FormatterUtils.format_Date(";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ")";
  protected final String TEXT_63 = NL + "                                    FormatterUtils.format_Number(";
  protected final String TEXT_64 = ".toPlainString(), ";
  protected final String TEXT_65 = ", ";
  protected final String TEXT_66 = ")";
  protected final String TEXT_67 = NL + "                                    FormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = ")).toPlainString(), ";
  protected final String TEXT_70 = ", ";
  protected final String TEXT_71 = ")";
  protected final String TEXT_72 = NL + "                            ";
  protected final String TEXT_73 = ".toPlainString()";
  protected final String TEXT_74 = NL + "                            java.nio.charset.Charset.forName(";
  protected final String TEXT_75 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = ")).toString()";
  protected final String TEXT_78 = NL + "                            ";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = NL + "                        );";
  protected final String TEXT_81 = NL + "                            }";
  protected final String TEXT_82 = NL + "                            sb_";
  protected final String TEXT_83 = ".append(OUT_DELIM_";
  protected final String TEXT_84 = ");";
  protected final String TEXT_85 = NL + "                    sb_";
  protected final String TEXT_86 = ".append(OUT_DELIM_ROWSEP_";
  protected final String TEXT_87 = ");" + NL + NL;
  protected final String TEXT_88 = NL + "                    synchronized (multiThreadLockWrite) {";
  protected final String TEXT_89 = NL + "                    synchronized ((Object[])globalMap.get(\"lockWrite_";
  protected final String TEXT_90 = "\")) {";
  protected final String TEXT_91 = NL + "                    Object[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "                    synchronized (pLockWrite) {";
  protected final String TEXT_92 = NL + "                    nb_line_";
  protected final String TEXT_93 = "++;" + NL + "                    resourceMap.put(\"nb_line_";
  protected final String TEXT_94 = "\", nb_line_";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "                        if(currentRow_";
  protected final String TEXT_97 = " % splitEvery_";
  protected final String TEXT_98 = "==0 && currentRow_";
  protected final String TEXT_99 = "!=0){" + NL + "                            splitedFileNo_";
  protected final String TEXT_100 = "++;" + NL + "                            out";
  protected final String TEXT_101 = ".close();" + NL + "                            //close original outputStream" + NL + "" + NL + "                            file";
  protected final String TEXT_102 = " = new java.io.File(fullName_";
  protected final String TEXT_103 = " + splitedFileNo_";
  protected final String TEXT_104 = " + extension_";
  protected final String TEXT_105 = ");" + NL;
  protected final String TEXT_106 = NL + "                            if(file";
  protected final String TEXT_107 = ".exists()) {" + NL + "                                file";
  protected final String TEXT_108 = ".delete();" + NL + "                            }";
  protected final String TEXT_109 = NL + "                            out";
  protected final String TEXT_110 = " = new ";
  protected final String TEXT_111 = "(new java.io.OutputStreamWriter(" + NL + "                                    new java.io.FileOutputStream(fullName_";
  protected final String TEXT_112 = " + splitedFileNo_";
  protected final String TEXT_113 = " + extension_";
  protected final String TEXT_114 = ", ";
  protected final String TEXT_115 = "),";
  protected final String TEXT_116 = "));";
  protected final String TEXT_117 = NL + "                                if(file";
  protected final String TEXT_118 = ".length()==0){";
  protected final String TEXT_119 = NL + "                                        fileOutputDelimitedUtil_";
  protected final String TEXT_120 = ".putHeaderValue_";
  protected final String TEXT_121 = "(out";
  protected final String TEXT_122 = ",OUT_DELIM_";
  protected final String TEXT_123 = ", ";
  protected final String TEXT_124 = ");";
  protected final String TEXT_125 = NL + "                                        out";
  protected final String TEXT_126 = ".write(\"";
  protected final String TEXT_127 = "\");";
  protected final String TEXT_128 = NL + "                                        routines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_129 = ".";
  protected final String TEXT_130 = ", out";
  protected final String TEXT_131 = ", OUT_DELIM_";
  protected final String TEXT_132 = ");";
  protected final String TEXT_133 = NL + "                                            out";
  protected final String TEXT_134 = ".write(OUT_DELIM_";
  protected final String TEXT_135 = ");";
  protected final String TEXT_136 = NL + "                                    out";
  protected final String TEXT_137 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_138 = ");" + NL + "                                }";
  protected final String TEXT_139 = NL + "                            out";
  protected final String TEXT_140 = ".write(sb_";
  protected final String TEXT_141 = ".toString());";
  protected final String TEXT_142 = NL + "                                if(nb_line_";
  protected final String TEXT_143 = "%";
  protected final String TEXT_144 = " == 0) {" + NL + "                                out";
  protected final String TEXT_145 = ".flush();" + NL + "                                }";
  protected final String TEXT_146 = NL + "                        }else{" + NL + "                            out";
  protected final String TEXT_147 = ".write(sb_";
  protected final String TEXT_148 = ".toString());";
  protected final String TEXT_149 = NL + "                                if(nb_line_";
  protected final String TEXT_150 = "%";
  protected final String TEXT_151 = " == 0) {" + NL + "                                out";
  protected final String TEXT_152 = ".flush();" + NL + "                                }";
  protected final String TEXT_153 = NL + "                        }" + NL + "                        currentRow_";
  protected final String TEXT_154 = "++;" + NL + NL;
  protected final String TEXT_155 = NL + NL + "                        out";
  protected final String TEXT_156 = ".write(sb_";
  protected final String TEXT_157 = ".toString());";
  protected final String TEXT_158 = NL + "                                if(nb_line_";
  protected final String TEXT_159 = "%";
  protected final String TEXT_160 = " == 0) {" + NL + "                                out";
  protected final String TEXT_161 = ".flush();" + NL + "                                }";
  protected final String TEXT_162 = NL + "                        log.debug(\"";
  protected final String TEXT_163 = " - Writing the record \" + nb_line_";
  protected final String TEXT_164 = " + \".\");";
  protected final String TEXT_165 = NL;
  protected final String TEXT_166 = NL + "                    }";
  protected final String TEXT_167 = NL + "                    }";
  protected final String TEXT_168 = NL + "                    }";
  protected final String TEXT_169 = NL;
  protected final String TEXT_170 = NL;
  protected final String TEXT_171 = NL;
  protected final String TEXT_172 = NL + "                dynamic_column_count_";
  protected final String TEXT_173 = " = 1;";
  protected final String TEXT_174 = NL + "                    synchronized (multiThreadLockWrite) {";
  protected final String TEXT_175 = NL + "                    synchronized ((Object[])globalMap.get(\"lockWrite_";
  protected final String TEXT_176 = "\")) {";
  protected final String TEXT_177 = NL + "                    Object[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "                    synchronized (pLockWrite) {";
  protected final String TEXT_178 = NL + "                        if(isFirstCheckDyn_";
  protected final String TEXT_179 = " ";
  protected final String TEXT_180 = "&& (file_";
  protected final String TEXT_181 = ".length()==0)";
  protected final String TEXT_182 = "){" + NL + "                            headColu";
  protected final String TEXT_183 = " = new String[";
  protected final String TEXT_184 = "-1+";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = ".getColumnCount()];";
  protected final String TEXT_187 = NL + "                        if(isFirstCheckDyn_";
  protected final String TEXT_188 = " ";
  protected final String TEXT_189 = "&& file";
  protected final String TEXT_190 = ".length()==0";
  protected final String TEXT_191 = "){" + NL + "                            headColu";
  protected final String TEXT_192 = " = new String[";
  protected final String TEXT_193 = "-1+";
  protected final String TEXT_194 = ".";
  protected final String TEXT_195 = ".getColumnCount()];";
  protected final String TEXT_196 = NL + "                                    dynamic_column_count_";
  protected final String TEXT_197 = " = ";
  protected final String TEXT_198 = ".";
  protected final String TEXT_199 = ".getColumnCount();";
  protected final String TEXT_200 = NL + "                                    fileOutputDelimitedUtil_";
  protected final String TEXT_201 = ".putHeaderValue_";
  protected final String TEXT_202 = "(headColu";
  protected final String TEXT_203 = ", ";
  protected final String TEXT_204 = ",dynamic_column_count_";
  protected final String TEXT_205 = ");";
  protected final String TEXT_206 = NL + "                            headColu";
  protected final String TEXT_207 = "[";
  protected final String TEXT_208 = "+dynamic_column_count_";
  protected final String TEXT_209 = "]=\"";
  protected final String TEXT_210 = "\";";
  protected final String TEXT_211 = NL + "                            headColu";
  protected final String TEXT_212 = "[";
  protected final String TEXT_213 = "]=\"";
  protected final String TEXT_214 = "\";";
  protected final String TEXT_215 = NL + "                             for(int mi=0;mi<dynamic_column_count_";
  protected final String TEXT_216 = ";mi++){" + NL + "                                headColu";
  protected final String TEXT_217 = "[";
  protected final String TEXT_218 = "+mi]=";
  protected final String TEXT_219 = ".";
  protected final String TEXT_220 = ".getColumnMetadata(mi).getName();" + NL + "                             }";
  protected final String TEXT_221 = NL + "                            CsvWriter";
  protected final String TEXT_222 = ".writeNext(headColu";
  protected final String TEXT_223 = ");" + NL + "                            CsvWriter";
  protected final String TEXT_224 = ".flush();";
  protected final String TEXT_225 = NL + "                            out";
  protected final String TEXT_226 = ".write(strWriter";
  protected final String TEXT_227 = ".getBuffer().toString());" + NL + "                            out";
  protected final String TEXT_228 = ".flush();" + NL + "                            strWriter";
  protected final String TEXT_229 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_230 = ".getBuffer().length());";
  protected final String TEXT_231 = NL + "                        }";
  protected final String TEXT_232 = NL + "                    }";
  protected final String TEXT_233 = NL + "                    }";
  protected final String TEXT_234 = NL + "                    }";
  protected final String TEXT_235 = NL + "                        if(isFirstCheckDyn_";
  protected final String TEXT_236 = "){" + NL + "                            CsvWriter";
  protected final String TEXT_237 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_238 = ".getEscapeChar());" + NL + "                            CsvWriter";
  protected final String TEXT_239 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_240 = ".getTextEnclosure());" + NL + "                            CsvWriter";
  protected final String TEXT_241 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);" + NL + "                            isFirstCheckDyn_";
  protected final String TEXT_242 = " = false;" + NL + "                        }";
  protected final String TEXT_243 = NL + "                        String[] row";
  protected final String TEXT_244 = "=new String[";
  protected final String TEXT_245 = "];";
  protected final String TEXT_246 = NL + "                        dynamic_column_count_";
  protected final String TEXT_247 = " =1;";
  protected final String TEXT_248 = NL + "                                dynamic_column_count_";
  protected final String TEXT_249 = " = ";
  protected final String TEXT_250 = ".";
  protected final String TEXT_251 = ".getColumnCount();";
  protected final String TEXT_252 = NL + "                                fileOutputDelimitedUtil_";
  protected final String TEXT_253 = ".putValue_";
  protected final String TEXT_254 = "(";
  protected final String TEXT_255 = ",row";
  protected final String TEXT_256 = ",dynamic_column_count_";
  protected final String TEXT_257 = " ";
  protected final String TEXT_258 = ");";
  protected final String TEXT_259 = NL + "                            if (";
  protected final String TEXT_260 = ".";
  protected final String TEXT_261 = " != null) {" + NL + "                                routines.system.DynamicUtils.writeValuesToStringArrayEnhance(";
  protected final String TEXT_262 = ".";
  protected final String TEXT_263 = ", row";
  protected final String TEXT_264 = ", ";
  protected final String TEXT_265 = ",";
  protected final String TEXT_266 = NL + "                                           \"";
  protected final String TEXT_267 = "\"";
  protected final String TEXT_268 = NL + "                                           null";
  protected final String TEXT_269 = NL + "                                );" + NL + "                            }";
  protected final String TEXT_270 = NL + "                            row";
  protected final String TEXT_271 = "[";
  protected final String TEXT_272 = "+dynamic_column_count_";
  protected final String TEXT_273 = "]=";
  protected final String TEXT_274 = NL + "                            row";
  protected final String TEXT_275 = "[";
  protected final String TEXT_276 = "]=";
  protected final String TEXT_277 = ".";
  protected final String TEXT_278 = ";";
  protected final String TEXT_279 = "FormatterUtils.format_Date(";
  protected final String TEXT_280 = ".";
  protected final String TEXT_281 = ", ";
  protected final String TEXT_282 = ");";
  protected final String TEXT_283 = "java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_284 = ".";
  protected final String TEXT_285 = ")).toString();";
  protected final String TEXT_286 = "FormatterUtils.format_Number(";
  protected final String TEXT_287 = ".toPlainString(), ";
  protected final String TEXT_288 = ", ";
  protected final String TEXT_289 = ");";
  protected final String TEXT_290 = "FormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_291 = ".";
  protected final String TEXT_292 = ")).toPlainString(), ";
  protected final String TEXT_293 = ", ";
  protected final String TEXT_294 = ");";
  protected final String TEXT_295 = ".toPlainString();";
  protected final String TEXT_296 = "String.valueOf(";
  protected final String TEXT_297 = ".";
  protected final String TEXT_298 = ");";
  protected final String TEXT_299 = NL + "                synchronized (multiThreadLockWrite) {";
  protected final String TEXT_300 = NL + "                synchronized ((Object[])globalMap.get(\"lockWrite_";
  protected final String TEXT_301 = "\")) {";
  protected final String TEXT_302 = NL + "                Object[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "                synchronized (pLockWrite) {";
  protected final String TEXT_303 = NL + "                nb_line_";
  protected final String TEXT_304 = "++;" + NL + "                resourceMap.put(\"nb_line_";
  protected final String TEXT_305 = "\", nb_line_";
  protected final String TEXT_306 = ");";
  protected final String TEXT_307 = NL + "                            if(currentRow_";
  protected final String TEXT_308 = " % splitEvery_";
  protected final String TEXT_309 = "==0 && currentRow_";
  protected final String TEXT_310 = "!=0){" + NL + "                                splitedFileNo_";
  protected final String TEXT_311 = "++;" + NL + "                                CsvWriter";
  protected final String TEXT_312 = ".close();" + NL + "                                //close original outputStream" + NL;
  protected final String TEXT_313 = NL + "                                java.io.File fileToDelete_";
  protected final String TEXT_314 = " = new java.io.File(fullName_";
  protected final String TEXT_315 = " + splitedFileNo_";
  protected final String TEXT_316 = " + extension_";
  protected final String TEXT_317 = ");" + NL + "                                if(fileToDelete_";
  protected final String TEXT_318 = ".exists()) {" + NL + "                                    fileToDelete_";
  protected final String TEXT_319 = ".delete();" + NL + "                                }";
  protected final String TEXT_320 = NL;
  protected final String TEXT_321 = NL + "                                out";
  protected final String TEXT_322 = ".close();" + NL + "                                out";
  protected final String TEXT_323 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "                                    new java.io.FileOutputStream(fullName_";
  protected final String TEXT_324 = " + splitedFileNo_";
  protected final String TEXT_325 = " + extension_";
  protected final String TEXT_326 = ", ";
  protected final String TEXT_327 = "),";
  protected final String TEXT_328 = "));" + NL + "                                strWriter";
  protected final String TEXT_329 = " = new java.io.StringWriter();" + NL + "                                CsvWriter";
  protected final String TEXT_330 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_331 = ");" + NL + "                                CsvWriter";
  protected final String TEXT_332 = ".setSeparator(csvSettings_";
  protected final String TEXT_333 = ".getFieldDelim());";
  protected final String TEXT_334 = NL + "                                CsvWriter";
  protected final String TEXT_335 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                                    new java.io.FileOutputStream(fullName_";
  protected final String TEXT_336 = " + splitedFileNo_";
  protected final String TEXT_337 = " + extension_";
  protected final String TEXT_338 = ", ";
  protected final String TEXT_339 = "),";
  protected final String TEXT_340 = ")));" + NL + "                                CsvWriter";
  protected final String TEXT_341 = ".setSeparator(csvSettings_";
  protected final String TEXT_342 = ".getFieldDelim());";
  protected final String TEXT_343 = NL;
  protected final String TEXT_344 = NL + "                                if(csvSettings_";
  protected final String TEXT_345 = ".isUseCRLFRecordDelimiter()) {" + NL + "                                    CsvWriter";
  protected final String TEXT_346 = ".setLineEnd(\"\\r\\n\");" + NL + "                                } else {" + NL + "                                    CsvWriter";
  protected final String TEXT_347 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_348 = ".getRowDelim());" + NL + "                                }";
  protected final String TEXT_349 = NL + "                                if(!csvSettings_";
  protected final String TEXT_350 = ".isUseCRLFRecordDelimiter() && csvSettings_";
  protected final String TEXT_351 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_352 = ".getRowDelim()!='\\n') {" + NL + "                                    CsvWriter";
  protected final String TEXT_353 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_354 = ".getRowDelim());" + NL + "                                }";
  protected final String TEXT_355 = NL + NL + "                                //set header.";
  protected final String TEXT_356 = NL + "                                    CsvWriter";
  protected final String TEXT_357 = ".writeNext(headColu";
  protected final String TEXT_358 = ");";
  protected final String TEXT_359 = NL + "                                    out";
  protected final String TEXT_360 = ".write(strWriter";
  protected final String TEXT_361 = ".getBuffer().toString());" + NL + "                                    strWriter";
  protected final String TEXT_362 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_363 = ".getBuffer().length());";
  protected final String TEXT_364 = NL + "                                    file";
  protected final String TEXT_365 = " = new java.io.File(fullName_";
  protected final String TEXT_366 = " + splitedFileNo_";
  protected final String TEXT_367 = " + extension_";
  protected final String TEXT_368 = ");" + NL + "                                    if(file";
  protected final String TEXT_369 = ".length() == 0) {" + NL + "                                        CsvWriter";
  protected final String TEXT_370 = ".writeNext(headColu";
  protected final String TEXT_371 = ");";
  protected final String TEXT_372 = NL + "                                        out";
  protected final String TEXT_373 = ".write(strWriter";
  protected final String TEXT_374 = ".getBuffer().toString());" + NL + "                                        strWriter";
  protected final String TEXT_375 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_376 = ".getBuffer().length());";
  protected final String TEXT_377 = NL + "                                    }";
  protected final String TEXT_378 = NL + "                                //initialize new CsvWriter information" + NL + "                                CsvWriter";
  protected final String TEXT_379 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_380 = ".getEscapeChar());" + NL + "                                CsvWriter";
  protected final String TEXT_381 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_382 = ".getTextEnclosure());" + NL + "                                CsvWriter";
  protected final String TEXT_383 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);" + NL + "" + NL + "                                           CsvWriter";
  protected final String TEXT_384 = ".writeNext(row";
  protected final String TEXT_385 = ");";
  protected final String TEXT_386 = NL + "                                out";
  protected final String TEXT_387 = ".write(strWriter";
  protected final String TEXT_388 = ".getBuffer().toString());" + NL + "                                strWriter";
  protected final String TEXT_389 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_390 = ".getBuffer().length());";
  protected final String TEXT_391 = NL + "                                    if(nb_line_";
  protected final String TEXT_392 = "%";
  protected final String TEXT_393 = " == 0) {";
  protected final String TEXT_394 = NL + "                                    out";
  protected final String TEXT_395 = ".flush();";
  protected final String TEXT_396 = NL + "                                    CsvWriter";
  protected final String TEXT_397 = ".flush();";
  protected final String TEXT_398 = NL + "                                    }";
  protected final String TEXT_399 = NL + NL + "                            }else{" + NL + "                                           CsvWriter";
  protected final String TEXT_400 = ".writeNext(row";
  protected final String TEXT_401 = ");";
  protected final String TEXT_402 = NL + "                                out";
  protected final String TEXT_403 = ".write(strWriter";
  protected final String TEXT_404 = ".getBuffer().toString());" + NL + "                                strWriter";
  protected final String TEXT_405 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_406 = ".getBuffer().length());";
  protected final String TEXT_407 = NL + "                                    if(nb_line_";
  protected final String TEXT_408 = "%";
  protected final String TEXT_409 = " == 0) {";
  protected final String TEXT_410 = NL + "                                    out";
  protected final String TEXT_411 = ".flush();";
  protected final String TEXT_412 = NL + "                                    CsvWriter";
  protected final String TEXT_413 = ".flush();";
  protected final String TEXT_414 = NL + "                                    }";
  protected final String TEXT_415 = NL + "                            }" + NL + "                            currentRow_";
  protected final String TEXT_416 = "++;";
  protected final String TEXT_417 = NL + "                                       CsvWriter";
  protected final String TEXT_418 = ".writeNextEnhance(row";
  protected final String TEXT_419 = ",\"";
  protected final String TEXT_420 = "\");";
  protected final String TEXT_421 = NL + "                                       CsvWriter";
  protected final String TEXT_422 = ".writeNext(row";
  protected final String TEXT_423 = ");";
  protected final String TEXT_424 = NL + "                            out";
  protected final String TEXT_425 = ".write(strWriter";
  protected final String TEXT_426 = ".getBuffer().toString());" + NL + "                            strWriter";
  protected final String TEXT_427 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_428 = ".getBuffer().length());";
  protected final String TEXT_429 = NL + "                                    if(nb_line_";
  protected final String TEXT_430 = "%";
  protected final String TEXT_431 = " == 0) {";
  protected final String TEXT_432 = NL + "                                    out";
  protected final String TEXT_433 = ".flush();";
  protected final String TEXT_434 = NL + "                                    CsvWriter";
  protected final String TEXT_435 = ".flush();";
  protected final String TEXT_436 = NL + "                                    }";
  protected final String TEXT_437 = NL + "                            log.debug(\"";
  protected final String TEXT_438 = " - Writing the record \" + nb_line_";
  protected final String TEXT_439 = " + \".\");";
  protected final String TEXT_440 = NL;
  protected final String TEXT_441 = NL + "                }";
  protected final String TEXT_442 = NL + "                }";
  protected final String TEXT_443 = NL + "                }";
  protected final String TEXT_444 = NL;
  protected final String TEXT_445 = NL;
  protected final String TEXT_446 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean isTSalesforceWaveOutputBulkExec = ((cid == null) ? false : (cid.startsWith("tSalesforceWaveOutputBulkExec")));
boolean useDoubleQuoteEnclosure = "true".equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))
                                  && ("\"\"\"").equals(ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__"));
boolean applyNA4Null = isTSalesforceWaveOutputBulkExec;
String str4Nil = "#N/A";

boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
    schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}
int dynamic_column_index=-1;
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_2);
    

    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {


            String encoding = ElementParameterParser.getValue(
                node,
                "__ENCODING__"
            );

            boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));

            boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));

            boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));

            boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));

            boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
            String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");

            String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
            boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
            String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
            String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

            String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
            boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;

            boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));

            boolean hasDynamic = metadata.isDynamicSchema();

            List< ? extends IConnection> conns = node.getIncomingConnections();
            for (IConnection conn : conns) {
                if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                    List<IMetadataColumn> columns = metadata.getListColumns();
                    int sizeColumns = columns.size();
                    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
                    if(isIncludeHeader && hasDynamic){
                        if(codeGenArgument.getIsRunInMultiThread()){
                
    stringBuffer.append(TEXT_5);
    
                        }
                        if (((AbstractNode)node).getParallelIterator() != null) {
                
    stringBuffer.append(TEXT_6);
    stringBuffer.append(((AbstractNode)node).getParallelIterator());
    stringBuffer.append(TEXT_7);
    
                        }
                        if (isParallelize) {
                
    stringBuffer.append(TEXT_8);
    
                        }
                        if(!split && compress && !isAppend){
                        
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    if(!useStream){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    
                        }else{
                    
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    if(!useStream){
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    
                        }
                        for (int i = 0; i < sizeColumns; i++) {
                            IMetadataColumn column = columns.get(i);
                            if(sizeColumns> schemaOptNum){
                                if(i%schemaOptNum==0){
                                
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_24);
    
                                }
                            }else{//AA
                            if(!("id_Dynamic".equals(column.getTalendType()))) {
                         
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_27);
    
                            }else{
                         
    stringBuffer.append(TEXT_28);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
                            }
                            if(i != sizeColumns - 1) {
                         
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
                            }
                            }//AA
                        }
                        
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    
                        if (isParallelize) {
                
    stringBuffer.append(TEXT_40);
    
                        }
                        if (((AbstractNode)node).getParallelIterator() != null) {
                
    stringBuffer.append(TEXT_41);
    
                        }
                        if(codeGenArgument.getIsRunInMultiThread()){
                
    stringBuffer.append(TEXT_42);
    
                        }
                
    
                    }
                    for (int i = 0; i < sizeColumns; i++) {

                        IMetadataColumn column = columns.get(i);
                        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                        boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
                        if(sizeColumns> schemaOptNum){
                            if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
                            }
                        }else{//BB
                        if(!isPrimitive) {
                            
    stringBuffer.append(TEXT_49);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_51);
    
                        }
                        if(column.getTalendType().equals("id_Dynamic")){
                            dynamic_column_index = i;

    stringBuffer.append(TEXT_52);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    
                        }else{
                        
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
                            String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                            if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
                            
    stringBuffer.append(TEXT_59);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_62);
    
                            } else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) {
                            
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_66);
     } else { 
    stringBuffer.append(TEXT_67);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_69);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_71);
     } 
    
                            } else if(javaType == JavaTypesManager.BIGDECIMAL){
                            
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_73);
    
                            } else if(javaType == JavaTypesManager.BYTE_ARRAY){
                            
    stringBuffer.append(TEXT_74);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_77);
    
                            } else {
                            
    stringBuffer.append(TEXT_78);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel() );
    
                            }
                        
    stringBuffer.append(TEXT_80);
    
                        }
                        if(!isPrimitive) {
                            
    stringBuffer.append(TEXT_81);
    
                        }
                        if(i != sizeColumns - 1) {
                            
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    
                        }
                        }//BB
                    }
                    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    
                        if(codeGenArgument.getIsRunInMultiThread()){
                    
    stringBuffer.append(TEXT_88);
    
                        }
                        if (((AbstractNode)node).getParallelIterator() != null) {
                    
    stringBuffer.append(TEXT_89);
    stringBuffer.append(((AbstractNode)node).getParallelIterator());
    stringBuffer.append(TEXT_90);
    
                        }
                        if (isParallelize) {
                    
    stringBuffer.append(TEXT_91);
    
                        }
                    
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
                    // add a prerequisite useStream to support output stream feature:8873
                    if(!useStream && split){
                        
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    if(!isAppend) {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(isInRowMode?"routines.system.BufferedOutput":"java.io.BufferedWriter");
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append( isAppend);
    stringBuffer.append(TEXT_115);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_116);
    
                            if(isIncludeHeader){
                                
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
                                    //List<IMetadataColumn> columns = metadata.getListColumns();
                                    //int sizeColumns = columns.size();
                                    for (int i = 0; i < sizeColumns; i++) {
                                        IMetadataColumn column = columns.get(i);
                                        if(sizeColumns> schemaOptNum){
                                            if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    if(hasDynamic){
    stringBuffer.append(TEXT_123);
    stringBuffer.append(conn.getName() );
    }
    stringBuffer.append(TEXT_124);
    
                                            }
                                        }else{//CC
                                        if(!("id_Dynamic".equals(column.getTalendType()))) {
                                        
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_127);
    
                                        }else{
                                        
    stringBuffer.append(TEXT_128);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    
                                        }
                                        if(i != sizeColumns - 1) {
                                            
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    
                                        }
                                        }//CC
                                    }
                                    
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    
                            }
                            
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    
                            if(flushOnRow) {
                                
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    
                            }
                            
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    
                            if(flushOnRow) {
                                
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    
                            }
                            
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
                    } else {
                        
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    
                        if(flushOnRow) {
                            
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    
                        }
                        
    
                    }
                    
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    }
    stringBuffer.append(TEXT_165);
    
                        if (isParallelize) {
                    
    stringBuffer.append(TEXT_166);
    
                        }
                        if (((AbstractNode)node).getParallelIterator() != null) {
                    
    stringBuffer.append(TEXT_167);
    
                        }
                        if(codeGenArgument.getIsRunInMultiThread()){
                    
    stringBuffer.append(TEXT_168);
    
                        }
                    
    stringBuffer.append(TEXT_169);
    
                }
            }
        }
    }
    
    stringBuffer.append(TEXT_170);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{//the following is the tFileOutputCSV component
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_171);
    

    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
            String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
            String delim = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
            boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
            boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));

            boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));

            boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));

            boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
            String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");

            String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
            boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
            String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
            String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

            String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
            boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;

            List< ? extends IConnection> conns = node.getIncomingConnections();

            boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));

            boolean useOSLineSeparator = ("true").equals(ElementParameterParser.getValue(node,"__OS_LINE_SEPARATOR_AS_ROW_SEPARATOR__"));

            boolean hasDynamic = metadata.isDynamicSchema();
            IMetadataColumn dynamicCol = metadata.getDynamicColumn();
            if(hasDynamic){
                
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
            }
            if(conns!=null){
                if (conns.size()>0){
                    IConnection conn =conns.get(0);
                    if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                        List<IMetadataColumn> columns = metadata.getListColumns();
                        int sizeColumns = columns.size();
                        if(isIncludeHeader && hasDynamic){

                            if(codeGenArgument.getIsRunInMultiThread()){
                            
    stringBuffer.append(TEXT_174);
    
                            }
                            if (((AbstractNode)node).getParallelIterator() != null) {
                            
    stringBuffer.append(TEXT_175);
    stringBuffer.append(((AbstractNode)node).getParallelIterator());
    stringBuffer.append(TEXT_176);
    
                            }
                            if (isParallelize) {
                            
    stringBuffer.append(TEXT_177);
    
                            }
                            if(!split && compress && !isAppend){
                            
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    if(!useStream){
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    }
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_185);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_186);
    
                            }else{
                        
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    if(!useStream){
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    }
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_194);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_195);
    
                            }
                            for (int i = 0; i < sizeColumns; i++) {
                                IMetadataColumn column = columns.get(i);
                                if(("id_Dynamic").equals(column.getTalendType())) {
                                    
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_199);
    
                                }
                                if(sizeColumns> schemaOptNum){
                                    if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    
                                    }
                                }else{//DD
                                if(!("id_Dynamic".equals(column.getTalendType()))) {
                                    if(i>dynamic_column_index&& dynamic_column_index != -1){
                             
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_210);
    
                                    }else{
                             
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_214);
    
                                    }
                                }else{
                                dynamic_column_index = i;
                             
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_219);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_220);
    
                                }
                                }//DD
                            }
                            
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    if(isInRowMode){
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    }
    stringBuffer.append(TEXT_231);
    
                            if (isParallelize) {
                        
    stringBuffer.append(TEXT_232);
    
                            }
                            if (((AbstractNode)node).getParallelIterator() != null) {
                        
    stringBuffer.append(TEXT_233);
    
                            }
                            if(codeGenArgument.getIsRunInMultiThread()){
                        
    stringBuffer.append(TEXT_234);
    
                            }
                        
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    
                        }
                        
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(hasDynamic?"+"+conn.getName()+".":"" );
    stringBuffer.append(dynamicCol==null?"":dynamicCol.getLabel()+".getColumnCount()-1" );
    stringBuffer.append(TEXT_245);
    
                        if(hasDynamic){
                        
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    
                        }
                        for (int i = 0; i < sizeColumns; i++) {
                            IMetadataColumn column = columns.get(i);
                            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                            String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                            boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
                            if(("id_Dynamic").equals(column.getTalendType())) {
                                
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_250);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_251);
    
                            }
                            if(sizeColumns> schemaOptNum){
                                if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    }
    stringBuffer.append(TEXT_258);
    
                                }
                            }else{//EE
                            if(("id_Dynamic").equals(column.getTalendType())) {
                                dynamic_column_index=i;
                            
    stringBuffer.append(TEXT_259);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_260);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_261);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_262);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(dynamic_column_index);
    stringBuffer.append(TEXT_265);
    
                                   if(applyNA4Null){
                                        
    stringBuffer.append(TEXT_266);
    stringBuffer.append( str4Nil );
    stringBuffer.append(TEXT_267);
    
                                   }else{
                                        
    stringBuffer.append(TEXT_268);
    
                                   }
                                 
    stringBuffer.append(TEXT_269);
    
                            }else{
                                if(i>dynamic_column_index && dynamic_column_index !=-1){
                            
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ " == null ? null : ");
    
                                }else{
                            
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ " == null ? null : ");
    
                                }
                                if(javaType == JavaTypesManager.STRING ){
                            
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_278);
    
                                }else if(javaType == JavaTypesManager.DATE && pattern != null){
                            
    stringBuffer.append(TEXT_279);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_281);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_282);
    
                                }else if(javaType == JavaTypesManager.BYTE_ARRAY){
                            
    stringBuffer.append(TEXT_283);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_285);
    
                                } else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) {
                                    if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_286);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_287);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_288);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_289);
          } else { 
    stringBuffer.append(TEXT_290);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_292);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_293);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_294);
          }
                                } else if (javaType == JavaTypesManager.BIGDECIMAL) {
                            
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_295);
    
                                } else{
                            
    stringBuffer.append(TEXT_296);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_298);
    
                                }
                            }
                            }//EE
                        }

                          if(codeGenArgument.getIsRunInMultiThread()){

    stringBuffer.append(TEXT_299);
    
                        }
                        if (((AbstractNode)node).getParallelIterator() != null) {

    stringBuffer.append(TEXT_300);
    stringBuffer.append(((AbstractNode)node).getParallelIterator());
    stringBuffer.append(TEXT_301);
    
                        }
                        if (isParallelize) {

    stringBuffer.append(TEXT_302);
    
                        }

    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    
                        if(!useStream && split){
                            
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    if(!isAppend) {
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    }
    stringBuffer.append(TEXT_320);
    if(isInRowMode){
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(encoding);
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
    }else{
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    }
    stringBuffer.append(TEXT_343);
    
                                if(!useOSLineSeparator) {
                                
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    
                                } else {
                                
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    
                                }
                                
    stringBuffer.append(TEXT_355);
    
                                if(isIncludeHeader && !isAppend){
                                    
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    if(isInRowMode){
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
                                }
                                if(isIncludeHeader && isAppend){
                                    
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    if(isInRowMode){
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    }
    stringBuffer.append(TEXT_377);
    
                                }
                                
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    if(isInRowMode){
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    }
                                if(flushOnRow) {
                                    
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_393);
    if(isInRowMode){
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    }else{
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_397);
    }
    stringBuffer.append(TEXT_398);
    
                                }
                                
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    if(isInRowMode){
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    }
                                if(flushOnRow) {
                                    
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_409);
    if(isInRowMode){
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    }else{
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_413);
    }
    stringBuffer.append(TEXT_414);
    
                                }
                                
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    
                        }else{
                            
    
                               if(applyNA4Null){
                                    
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append( str4Nil );
    stringBuffer.append(TEXT_420);
    
                               }else{
                                    
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    
                               }
                             
    if(isInRowMode){
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    }
                            if(flushOnRow) {
                                
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_430);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_431);
    if(isInRowMode){
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    }else{
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    }
    stringBuffer.append(TEXT_436);
    
                            }
                            
    

                        }
                        
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    }
    stringBuffer.append(TEXT_440);
    
                        if ( isParallelize) {

    stringBuffer.append(TEXT_441);
    
                        }
                        if (((AbstractNode)node).getParallelIterator() != null) {

    stringBuffer.append(TEXT_442);
    
                        }
                        if(codeGenArgument.getIsRunInMultiThread()){

    stringBuffer.append(TEXT_443);
    
                        }

    stringBuffer.append(TEXT_444);
    
                    }

                }
            }

        }

    }
    
    stringBuffer.append(TEXT_445);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

    stringBuffer.append(TEXT_446);
    return stringBuffer.toString();
  }
}
