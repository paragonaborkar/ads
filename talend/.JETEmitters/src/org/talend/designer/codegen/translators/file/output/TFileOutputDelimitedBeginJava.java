package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.AbstractNode;

public class TFileOutputDelimitedBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedBeginJava result = new TFileOutputDelimitedBeginJava();
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
  protected final String TEXT_29 = NL + "String fileName_";
  protected final String TEXT_30 = " = \"\";";
  protected final String TEXT_31 = NL + "        int dynamic_column_count_";
  protected final String TEXT_32 = " = 1;";
  protected final String TEXT_33 = NL + "                class FileOutputDelimitedUtil_";
  protected final String TEXT_34 = "{";
  protected final String TEXT_35 = NL + "                                    public void putHeaderValue_";
  protected final String TEXT_36 = "(java.io.Writer out";
  protected final String TEXT_37 = ",final String OUT_DELIM_";
  protected final String TEXT_38 = ",final ";
  protected final String TEXT_39 = "Struct ";
  protected final String TEXT_40 = ")throws java.lang.Exception{";
  protected final String TEXT_41 = NL + "                                    out";
  protected final String TEXT_42 = ".write(\"";
  protected final String TEXT_43 = "\");";
  protected final String TEXT_44 = NL + "                                    routines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = ", out";
  protected final String TEXT_47 = ", OUT_DELIM_";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "                                    out";
  protected final String TEXT_50 = ".write(OUT_DELIM_";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "                                    }";
  protected final String TEXT_53 = NL + "                                }";
  protected final String TEXT_54 = NL + "                                public void putValue_";
  protected final String TEXT_55 = "(final ";
  protected final String TEXT_56 = "Struct ";
  protected final String TEXT_57 = ",StringBuilder sb_";
  protected final String TEXT_58 = ",final String OUT_DELIM_";
  protected final String TEXT_59 = ")throws java.lang.Exception {";
  protected final String TEXT_60 = NL + "                                if(";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = " != null) {";
  protected final String TEXT_63 = NL + "                                routines.system.DynamicUtils.writeValuesToStringBuilder(";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = ", sb_";
  protected final String TEXT_66 = ", OUT_DELIM_";
  protected final String TEXT_67 = ");";
  protected final String TEXT_68 = NL + "                                sb_";
  protected final String TEXT_69 = ".append(";
  protected final String TEXT_70 = NL + "                                        FormatterUtils.format_Date(";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ")";
  protected final String TEXT_74 = NL + "                                            FormatterUtils.format_Number(";
  protected final String TEXT_75 = ".toPlainString(), ";
  protected final String TEXT_76 = ", ";
  protected final String TEXT_77 = ")";
  protected final String TEXT_78 = NL + "                                            FormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = ")).toPlainString(), ";
  protected final String TEXT_81 = ", ";
  protected final String TEXT_82 = ")";
  protected final String TEXT_83 = NL + "                                        ";
  protected final String TEXT_84 = ".toPlainString()";
  protected final String TEXT_85 = NL + "                                        java.nio.charset.Charset.forName(";
  protected final String TEXT_86 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = ")).toString()";
  protected final String TEXT_89 = NL + "                                        ";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = NL + "                                );";
  protected final String TEXT_92 = NL + "                                }";
  protected final String TEXT_93 = NL + "                                sb_";
  protected final String TEXT_94 = ".append(OUT_DELIM_";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "                                }";
  protected final String TEXT_97 = NL + "                            }";
  protected final String TEXT_98 = NL + "                                    public void putHeaderValue_";
  protected final String TEXT_99 = "(String[] headColu";
  protected final String TEXT_100 = ",final ";
  protected final String TEXT_101 = "Struct ";
  protected final String TEXT_102 = ",int dynamic_column_count_";
  protected final String TEXT_103 = " ";
  protected final String TEXT_104 = ")throws java.lang.Exception{";
  protected final String TEXT_105 = NL + "                                        headColu";
  protected final String TEXT_106 = "[";
  protected final String TEXT_107 = "+dynamic_column_count_";
  protected final String TEXT_108 = "]=\"";
  protected final String TEXT_109 = "\";";
  protected final String TEXT_110 = NL + "                                        headColu";
  protected final String TEXT_111 = "[";
  protected final String TEXT_112 = "]=\"";
  protected final String TEXT_113 = "\";";
  protected final String TEXT_114 = NL + "                                    dynamic_column_count_";
  protected final String TEXT_115 = " = ";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = ".getColumnCount();" + NL + "                                    for(int mi=0;mi<dynamic_column_count_";
  protected final String TEXT_118 = ";mi++){" + NL + "                                        headColu";
  protected final String TEXT_119 = "[";
  protected final String TEXT_120 = "+mi]=";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = ".getColumnMetadata(mi).getName();" + NL + "                                    }";
  protected final String TEXT_123 = NL + "                                    }";
  protected final String TEXT_124 = NL + "                                }";
  protected final String TEXT_125 = NL + "                                public void putValue_";
  protected final String TEXT_126 = "(final ";
  protected final String TEXT_127 = "Struct ";
  protected final String TEXT_128 = ",String[] row";
  protected final String TEXT_129 = ",int dynamic_column_count_";
  protected final String TEXT_130 = " ";
  protected final String TEXT_131 = "){";
  protected final String TEXT_132 = NL + "                                if (";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " != null) {" + NL + "                                    dynamic_column_count_";
  protected final String TEXT_135 = " = ";
  protected final String TEXT_136 = ".";
  protected final String TEXT_137 = ".getColumnCount();" + NL + "                                    routines.system.DynamicUtils.writeValuesToStringArrayEnhance(";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = ", row";
  protected final String TEXT_140 = ", ";
  protected final String TEXT_141 = ",";
  protected final String TEXT_142 = NL + "                                               \"";
  protected final String TEXT_143 = "\"";
  protected final String TEXT_144 = NL + "                                               null";
  protected final String TEXT_145 = NL + "                                    );" + NL + "                                }";
  protected final String TEXT_146 = NL + "                                    row";
  protected final String TEXT_147 = "[";
  protected final String TEXT_148 = "+dynamic_column_count_";
  protected final String TEXT_149 = "]=";
  protected final String TEXT_150 = NL + "                                    row";
  protected final String TEXT_151 = "[";
  protected final String TEXT_152 = "]=";
  protected final String TEXT_153 = NL + "                                    ";
  protected final String TEXT_154 = ".";
  protected final String TEXT_155 = ";";
  protected final String TEXT_156 = NL + "                                    FormatterUtils.format_Date(";
  protected final String TEXT_157 = ".";
  protected final String TEXT_158 = ", ";
  protected final String TEXT_159 = ");";
  protected final String TEXT_160 = NL + "                                    java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = ")).toString();";
  protected final String TEXT_163 = NL + "                                        FormatterUtils.format_Number(";
  protected final String TEXT_164 = ".toPlainString(), ";
  protected final String TEXT_165 = ", ";
  protected final String TEXT_166 = ");";
  protected final String TEXT_167 = NL + "                                        FormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_168 = ".";
  protected final String TEXT_169 = ")).toPlainString(), ";
  protected final String TEXT_170 = ", ";
  protected final String TEXT_171 = ");";
  protected final String TEXT_172 = NL + "                                    ";
  protected final String TEXT_173 = ".toPlainString();";
  protected final String TEXT_174 = NL + "                                    String.valueOf(";
  protected final String TEXT_175 = ".";
  protected final String TEXT_176 = ");";
  protected final String TEXT_177 = NL + "                                }";
  protected final String TEXT_178 = NL + "                            }";
  protected final String TEXT_179 = NL + "                }" + NL + "                FileOutputDelimitedUtil_";
  protected final String TEXT_180 = " fileOutputDelimitedUtil_";
  protected final String TEXT_181 = "=new FileOutputDelimitedUtil_";
  protected final String TEXT_182 = "();";
  protected final String TEXT_183 = NL + "    fileName_";
  protected final String TEXT_184 = " = (new java.io.File(";
  protected final String TEXT_185 = ")).getAbsolutePath().replace(\"\\\\\",\"/\");" + NL + "    String fullName_";
  protected final String TEXT_186 = " = null;" + NL + "    String extension_";
  protected final String TEXT_187 = " = null;" + NL + "    String directory_";
  protected final String TEXT_188 = " = null;" + NL + "    if((fileName_";
  protected final String TEXT_189 = ".indexOf(\"/\") != -1)) {" + NL + "        if(fileName_";
  protected final String TEXT_190 = ".lastIndexOf(\".\") < fileName_";
  protected final String TEXT_191 = ".lastIndexOf(\"/\")) {" + NL + "            fullName_";
  protected final String TEXT_192 = " = fileName_";
  protected final String TEXT_193 = ";" + NL + "            extension_";
  protected final String TEXT_194 = " = \"\";" + NL + "        } else {" + NL + "            fullName_";
  protected final String TEXT_195 = " = fileName_";
  protected final String TEXT_196 = ".substring(0, fileName_";
  protected final String TEXT_197 = ".lastIndexOf(\".\"));" + NL + "            extension_";
  protected final String TEXT_198 = " = fileName_";
  protected final String TEXT_199 = ".substring(fileName_";
  protected final String TEXT_200 = ".lastIndexOf(\".\"));" + NL + "        }" + NL + "        directory_";
  protected final String TEXT_201 = " = fileName_";
  protected final String TEXT_202 = ".substring(0, fileName_";
  protected final String TEXT_203 = ".lastIndexOf(\"/\"));" + NL + "    } else {" + NL + "        if(fileName_";
  protected final String TEXT_204 = ".lastIndexOf(\".\") != -1) {" + NL + "            fullName_";
  protected final String TEXT_205 = " = fileName_";
  protected final String TEXT_206 = ".substring(0, fileName_";
  protected final String TEXT_207 = ".lastIndexOf(\".\"));" + NL + "            extension_";
  protected final String TEXT_208 = " = fileName_";
  protected final String TEXT_209 = ".substring(fileName_";
  protected final String TEXT_210 = ".lastIndexOf(\".\"));" + NL + "        } else {" + NL + "            fullName_";
  protected final String TEXT_211 = " = fileName_";
  protected final String TEXT_212 = ";" + NL + "            extension_";
  protected final String TEXT_213 = " = \"\";" + NL + "        }" + NL + "        directory_";
  protected final String TEXT_214 = " = \"\";" + NL + "    }" + NL + "    boolean isFileGenerated_";
  protected final String TEXT_215 = " = true;" + NL + "    java.io.File file";
  protected final String TEXT_216 = " = new java.io.File(fileName_";
  protected final String TEXT_217 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_218 = "_FILE_NAME\",fileName_";
  protected final String TEXT_219 = ");";
  protected final String TEXT_220 = NL + "    if(file";
  protected final String TEXT_221 = ".exists()){" + NL + "            throw new RuntimeException(\"The particular file \\\"\"+file";
  protected final String TEXT_222 = ".getAbsoluteFile() +" + NL + "            \"\\\" already exist. If you want to overwrite the file, please uncheck the\" + " + NL + "            \" \\\"Throw an error if the file already exist\\\" option in Advanced settings.\");" + NL + "        }";
  protected final String TEXT_223 = NL + "        if(file";
  protected final String TEXT_224 = ".exists()){" + NL + "            isFileGenerated_";
  protected final String TEXT_225 = " = false;" + NL + "        }";
  protected final String TEXT_226 = NL + "                boolean isFirstCheckDyn_";
  protected final String TEXT_227 = "= true;";
  protected final String TEXT_228 = NL + "            int nb_line_";
  protected final String TEXT_229 = " = 0;";
  protected final String TEXT_230 = NL + "            int splitEvery_";
  protected final String TEXT_231 = " = ";
  protected final String TEXT_232 = ";";
  protected final String TEXT_233 = NL + "            int splitedFileNo_";
  protected final String TEXT_234 = " = 0;" + NL + "            int currentRow_";
  protected final String TEXT_235 = " = 0;" + NL + "" + NL + "            final String OUT_DELIM_";
  protected final String TEXT_236 = " = ";
  protected final String TEXT_237 = ";" + NL + "" + NL + "            final String OUT_DELIM_ROWSEP_";
  protected final String TEXT_238 = " = ";
  protected final String TEXT_239 = ";" + NL;
  protected final String TEXT_240 = NL + "                    //create directory only if not exists" + NL + "                    if(directory_";
  protected final String TEXT_241 = " != null && directory_";
  protected final String TEXT_242 = ".trim().length() != 0) {" + NL + "                        java.io.File dir_";
  protected final String TEXT_243 = " = new java.io.File(directory_";
  protected final String TEXT_244 = ");" + NL + "                        if(!dir_";
  protected final String TEXT_245 = ".exists()) {";
  protected final String TEXT_246 = NL + "                                log.info(\"";
  protected final String TEXT_247 = " - Creating directory '\" + dir_";
  protected final String TEXT_248 = ".getCanonicalPath() +\"'.\");";
  protected final String TEXT_249 = NL + "                            dir_";
  protected final String TEXT_250 = ".mkdirs();";
  protected final String TEXT_251 = NL + "                                log.info(\"";
  protected final String TEXT_252 = " - The directory '\"+ dir_";
  protected final String TEXT_253 = ".getCanonicalPath() + \"' has been created successfully.\");";
  protected final String TEXT_254 = NL + "                        }" + NL + "                    }";
  protected final String TEXT_255 = NL;
  protected final String TEXT_256 = NL + "                        file";
  protected final String TEXT_257 = " = new java.io.File(fileName_";
  protected final String TEXT_258 = ");" + NL + "                        String zipName_";
  protected final String TEXT_259 = " = fullName_";
  protected final String TEXT_260 = " + \".zip\";" + NL + "                        java.io.File file_";
  protected final String TEXT_261 = " = new java.io.File(zipName_";
  protected final String TEXT_262 = ");" + NL + "                        //routines.system.Row" + NL + "                        java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_263 = "= null;" + NL + "                        java.io.Writer out";
  protected final String TEXT_264 = " = null;" + NL + "" + NL + "                        if(file_";
  protected final String TEXT_265 = ".exists()) {" + NL + "                            file_";
  protected final String TEXT_266 = ".delete();" + NL + "                        }" + NL + "                        zipOut_";
  protected final String TEXT_267 = "= new java.util.zip.ZipOutputStream(" + NL + "                                new java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_268 = ")));" + NL + "                        zipOut_";
  protected final String TEXT_269 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_270 = ".getName()));" + NL + "                        out";
  protected final String TEXT_271 = " = new ";
  protected final String TEXT_272 = "(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_273 = ",";
  protected final String TEXT_274 = "));";
  protected final String TEXT_275 = NL + "                        //routines.system.Row" + NL + "                        java.io.Writer out";
  protected final String TEXT_276 = " = null;" + NL;
  protected final String TEXT_277 = NL + "                        java.io.File fileToDelete_";
  protected final String TEXT_278 = " = new java.io.File(fileName_";
  protected final String TEXT_279 = ");" + NL + "                        if(fileToDelete_";
  protected final String TEXT_280 = ".exists()) {" + NL + "                            fileToDelete_";
  protected final String TEXT_281 = ".delete();" + NL + "                        }";
  protected final String TEXT_282 = NL + "                        out";
  protected final String TEXT_283 = " = new ";
  protected final String TEXT_284 = "(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fileName_";
  protected final String TEXT_285 = ", ";
  protected final String TEXT_286 = "),";
  protected final String TEXT_287 = "));";
  protected final String TEXT_288 = NL + "                    java.io.Writer out";
  protected final String TEXT_289 = " = null;" + NL + "                    file";
  protected final String TEXT_290 = " = new java.io.File(fullName_";
  protected final String TEXT_291 = " + splitedFileNo_";
  protected final String TEXT_292 = " + extension_";
  protected final String TEXT_293 = ");" + NL;
  protected final String TEXT_294 = NL + "                    if(file";
  protected final String TEXT_295 = ".exists()) {" + NL + "                        file";
  protected final String TEXT_296 = ".delete();" + NL + "                    }";
  protected final String TEXT_297 = NL + "                    out";
  protected final String TEXT_298 = " = new ";
  protected final String TEXT_299 = "(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_300 = " + splitedFileNo_";
  protected final String TEXT_301 = " + extension_";
  protected final String TEXT_302 = ", ";
  protected final String TEXT_303 = "),";
  protected final String TEXT_304 = "));";
  protected final String TEXT_305 = NL + "                        synchronized (multiThreadLockWrite) {";
  protected final String TEXT_306 = NL + "                            synchronized ((Object[])globalMap.get(\"lockWrite_";
  protected final String TEXT_307 = "\")) {";
  protected final String TEXT_308 = NL + "                                Object[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "                                synchronized (pLockWrite) {";
  protected final String TEXT_309 = NL + "                                    if(file_";
  protected final String TEXT_310 = ".length()==0){";
  protected final String TEXT_311 = NL + "                                    if(file";
  protected final String TEXT_312 = ".length()==0){";
  protected final String TEXT_313 = NL + "                                            fileOutputDelimitedUtil_";
  protected final String TEXT_314 = ".putHeaderValue_";
  protected final String TEXT_315 = "(out";
  protected final String TEXT_316 = ",OUT_DELIM_";
  protected final String TEXT_317 = ");";
  protected final String TEXT_318 = NL + "                                        out";
  protected final String TEXT_319 = ".write(\"";
  protected final String TEXT_320 = "\");";
  protected final String TEXT_321 = NL + "                                            out";
  protected final String TEXT_322 = ".write(OUT_DELIM_";
  protected final String TEXT_323 = ");";
  protected final String TEXT_324 = NL + "                                        out";
  protected final String TEXT_325 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_326 = ");" + NL + "                                        out";
  protected final String TEXT_327 = ".flush();" + NL + "                                    }";
  protected final String TEXT_328 = NL + "                                }";
  protected final String TEXT_329 = NL + "                            }";
  protected final String TEXT_330 = NL + "                        }";
  protected final String TEXT_331 = NL + "                    //routines.system.Row" + NL + "                    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_332 = "= null;" + NL + "                    java.io.OutputStreamWriter writer_";
  protected final String TEXT_333 = " = null;" + NL + "                    java.io.Writer out";
  protected final String TEXT_334 = " = null;" + NL + "                    zipOut_";
  protected final String TEXT_335 = "=new java.util.zip.ZipOutputStream(new java.io.BufferedOutputStream(";
  protected final String TEXT_336 = "));" + NL + "                    zipOut_";
  protected final String TEXT_337 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "                    writer_";
  protected final String TEXT_338 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_339 = ",";
  protected final String TEXT_340 = ");" + NL + "                    out";
  protected final String TEXT_341 = " = new ";
  protected final String TEXT_342 = "(writer_";
  protected final String TEXT_343 = ");";
  protected final String TEXT_344 = NL + "                    //routines.system.Row" + NL + "                    java.io.OutputStreamWriter writer_";
  protected final String TEXT_345 = " = null;" + NL + "                    java.io.Writer out";
  protected final String TEXT_346 = " = null;" + NL + "                    writer_";
  protected final String TEXT_347 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_348 = ",";
  protected final String TEXT_349 = ");" + NL + "                    out";
  protected final String TEXT_350 = " = new ";
  protected final String TEXT_351 = "(writer_";
  protected final String TEXT_352 = ");";
  protected final String TEXT_353 = NL + "                                fileOutputDelimitedUtil_";
  protected final String TEXT_354 = ".putHeaderValue_";
  protected final String TEXT_355 = "(out";
  protected final String TEXT_356 = ",OUT_DELIM_";
  protected final String TEXT_357 = ");";
  protected final String TEXT_358 = NL + "                            out";
  protected final String TEXT_359 = ".write(\"";
  protected final String TEXT_360 = "\");";
  protected final String TEXT_361 = NL + "                                out";
  protected final String TEXT_362 = ".write(OUT_DELIM_";
  protected final String TEXT_363 = ");";
  protected final String TEXT_364 = NL + "                    out";
  protected final String TEXT_365 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_366 = ");";
  protected final String TEXT_367 = NL;
  protected final String TEXT_368 = NL + "                boolean isFirstCheckDyn_";
  protected final String TEXT_369 = "= true;" + NL + "                String[] headColu";
  protected final String TEXT_370 = " = null;";
  protected final String TEXT_371 = NL + "                String[] headColu";
  protected final String TEXT_372 = "=new String[";
  protected final String TEXT_373 = "];";
  protected final String TEXT_374 = NL + "            class CSVBasicSet_";
  protected final String TEXT_375 = "{" + NL + "                private char field_Delim;" + NL + "                private char row_Delim;" + NL + "                private char escape;" + NL + "                private char textEnclosure;" + NL + "                private boolean useCRLFRecordDelimiter;" + NL + "" + NL + "                public boolean isUseCRLFRecordDelimiter() {" + NL + "                    return useCRLFRecordDelimiter;" + NL + "                }" + NL + "" + NL + "                public void setFieldSeparator(String fieldSep) throws IllegalArgumentException{" + NL + "                    char field_Delim_";
  protected final String TEXT_376 = "[] = null;" + NL + "" + NL + "                    //support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'." + NL + "                    if (fieldSep.length() > 0 ){" + NL + "                        field_Delim_";
  protected final String TEXT_377 = " = fieldSep.toCharArray();" + NL + "                    }else {" + NL + "                        throw new IllegalArgumentException(\"Field Separator must be assigned a char.\");" + NL + "                    }" + NL + "                    this.field_Delim = field_Delim_";
  protected final String TEXT_378 = "[0];" + NL + "                }" + NL + "" + NL + "                public char getFieldDelim(){" + NL + "                    if(this.field_Delim==0){" + NL + "                        setFieldSeparator(";
  protected final String TEXT_379 = ");" + NL + "                    }" + NL + "                    return this.field_Delim;" + NL + "                }" + NL + "" + NL + "                public void setRowSeparator(String rowSep){" + NL + "                    if(\"\\r\\n\".equals(rowSep)) {" + NL + "                        useCRLFRecordDelimiter = true;" + NL + "                        return;" + NL + "                    }" + NL + "                    char row_Delim";
  protected final String TEXT_380 = "[] = null;" + NL + "" + NL + "                    //support passing value (property: Row Separator) by 'context.rs' or 'globalMap.get(\"rs\")'." + NL + "                    if (rowSep.length() > 0 ){" + NL + "                        row_Delim";
  protected final String TEXT_381 = " = rowSep.toCharArray();" + NL + "                    }else {" + NL + "                        throw new IllegalArgumentException(\"Row Separator must be assigned a char.\");" + NL + "                    }" + NL + "                    this.row_Delim = row_Delim";
  protected final String TEXT_382 = "[0];" + NL + "                }" + NL + "" + NL + "                public char getRowDelim(){" + NL + "                    if(this.row_Delim==0){" + NL + "                        setRowSeparator(";
  protected final String TEXT_383 = ");" + NL + "                    }" + NL + "                    return this.row_Delim;" + NL + "                }" + NL + "" + NL + "                public void setEscapeAndTextEnclosure(String strEscape, String strTextEnclosure) throws IllegalArgumentException{" + NL + "                    if(strEscape.length() <= 0 ){" + NL + "                        throw new IllegalArgumentException(\"Escape Char must be assigned a char.\");" + NL + "                    }" + NL + "" + NL + "                    if (\"\".equals(strTextEnclosure)) strTextEnclosure = \"\\0\";" + NL + "                    char textEnclosure_";
  protected final String TEXT_384 = "[] = null;" + NL + "" + NL + "                    if(strTextEnclosure.length() > 0 ){" + NL + "                        textEnclosure_";
  protected final String TEXT_385 = " = strTextEnclosure.toCharArray();" + NL + "                    }else {" + NL + "                        throw new IllegalArgumentException(\"Text Enclosure must be assigned a char.\");" + NL + "                    }" + NL + "" + NL + "                    this.textEnclosure = textEnclosure_";
  protected final String TEXT_386 = "[0];" + NL + "" + NL + "                    if((\"\\\\\").equals(strEscape)){" + NL + "                        this.escape = '\\\\';" + NL + "                    }else if(strEscape.equals(strTextEnclosure)){" + NL + "                        this.escape = this.textEnclosure;" + NL + "                    } else {" + NL + "                        //the default escape mode is double escape" + NL + "                        this.escape = this.textEnclosure;" + NL + "                    }" + NL + "" + NL + "" + NL + "                }" + NL + "" + NL + "                public char getEscapeChar(){" + NL + "                    return (char)this.escape;" + NL + "                }" + NL + "" + NL + "                public char getTextEnclosure(){" + NL + "                    return this.textEnclosure;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            int nb_line_";
  protected final String TEXT_387 = " = 0;";
  protected final String TEXT_388 = NL + "            int splitEvery_";
  protected final String TEXT_389 = " = ";
  protected final String TEXT_390 = ";";
  protected final String TEXT_391 = NL + "            int splitedFileNo_";
  protected final String TEXT_392 = " =0;" + NL + "            int currentRow_";
  protected final String TEXT_393 = " = 0;" + NL + "" + NL + "" + NL + "            CSVBasicSet_";
  protected final String TEXT_394 = " csvSettings_";
  protected final String TEXT_395 = " = new CSVBasicSet_";
  protected final String TEXT_396 = "();" + NL + "            csvSettings_";
  protected final String TEXT_397 = ".setFieldSeparator(";
  protected final String TEXT_398 = ");" + NL + "            csvSettings_";
  protected final String TEXT_399 = ".setRowSeparator(";
  protected final String TEXT_400 = ");" + NL + "            csvSettings_";
  protected final String TEXT_401 = ".setEscapeAndTextEnclosure(";
  protected final String TEXT_402 = ",";
  protected final String TEXT_403 = ");";
  protected final String TEXT_404 = NL + "                    //create directory only if not exists" + NL + "                    if(directory_";
  protected final String TEXT_405 = " != null && directory_";
  protected final String TEXT_406 = ".trim().length() != 0) {" + NL + "                        java.io.File dir_";
  protected final String TEXT_407 = " = new java.io.File(directory_";
  protected final String TEXT_408 = ");" + NL + "                        if(!dir_";
  protected final String TEXT_409 = ".exists()) {";
  protected final String TEXT_410 = NL + "                                log.info(\"";
  protected final String TEXT_411 = " - Creating directory '\" +dir_";
  protected final String TEXT_412 = ".getCanonicalPath() +\"'.\");";
  protected final String TEXT_413 = NL + "                            dir_";
  protected final String TEXT_414 = ".mkdirs();";
  protected final String TEXT_415 = NL + "                                log.info(\"";
  protected final String TEXT_416 = " - The directory '\" + dir_";
  protected final String TEXT_417 = ".getCanonicalPath() + \"' has been created successfully.\");";
  protected final String TEXT_418 = NL + "                        }" + NL + "                    }";
  protected final String TEXT_419 = NL + "                            file";
  protected final String TEXT_420 = " = new java.io.File(fileName_";
  protected final String TEXT_421 = ");" + NL + "                            String zipName_";
  protected final String TEXT_422 = " = fullName_";
  protected final String TEXT_423 = " + \".zip\";" + NL + "                            java.io.File file_";
  protected final String TEXT_424 = " = new java.io.File(zipName_";
  protected final String TEXT_425 = ");" + NL + "                            //routines.system.Row" + NL + "                            java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_426 = " = null;" + NL + "                            java.io.Writer out";
  protected final String TEXT_427 = " = null;" + NL + "                            com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_428 = " = null;" + NL + "" + NL + "                            if(file_";
  protected final String TEXT_429 = ".exists()) {" + NL + "                                file_";
  protected final String TEXT_430 = ".delete();" + NL + "                            }" + NL + "                            zipOut_";
  protected final String TEXT_431 = "=new java.util.zip.ZipOutputStream(" + NL + "                                    new java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_432 = ")));" + NL + "                            zipOut_";
  protected final String TEXT_433 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_434 = ".getName()));" + NL + "                            out";
  protected final String TEXT_435 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_436 = ", ";
  protected final String TEXT_437 = "));" + NL + "                            java.io.StringWriter strWriter";
  protected final String TEXT_438 = " = new java.io.StringWriter();" + NL + "                            CsvWriter";
  protected final String TEXT_439 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_440 = ");" + NL + "                            CsvWriter";
  protected final String TEXT_441 = ".setSeparator(csvSettings_";
  protected final String TEXT_442 = ".getFieldDelim());";
  protected final String TEXT_443 = NL + "                            java.io.Writer out";
  protected final String TEXT_444 = " = null;" + NL + "                            com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_445 = " = null;" + NL;
  protected final String TEXT_446 = NL + "                            java.io.File fileToDelete_";
  protected final String TEXT_447 = " = new java.io.File(fileName_";
  protected final String TEXT_448 = ");" + NL + "                            if(fileToDelete_";
  protected final String TEXT_449 = ".exists()) {" + NL + "                                fileToDelete_";
  protected final String TEXT_450 = ".delete();" + NL + "                            }";
  protected final String TEXT_451 = NL + "                            out";
  protected final String TEXT_452 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "                            new java.io.FileOutputStream(fileName_";
  protected final String TEXT_453 = ", ";
  protected final String TEXT_454 = "), ";
  protected final String TEXT_455 = "));" + NL + "                            java.io.StringWriter strWriter";
  protected final String TEXT_456 = " = new java.io.StringWriter();" + NL + "                            CsvWriter";
  protected final String TEXT_457 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_458 = ");" + NL + "                            CsvWriter";
  protected final String TEXT_459 = ".setSeparator(csvSettings_";
  protected final String TEXT_460 = ".getFieldDelim());";
  protected final String TEXT_461 = NL + "                            file";
  protected final String TEXT_462 = " = new java.io.File(fileName_";
  protected final String TEXT_463 = ");" + NL + "                            String zipName_";
  protected final String TEXT_464 = " = fullName_";
  protected final String TEXT_465 = " + \".zip\";" + NL + "                            java.io.File file_";
  protected final String TEXT_466 = " = new java.io.File(zipName_";
  protected final String TEXT_467 = ");" + NL + "                            //routines.system.Row" + NL + "                            java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_468 = " = null;" + NL + "                            com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_469 = " = null;" + NL + "" + NL + "                            if(file_";
  protected final String TEXT_470 = ".exists()) {" + NL + "                                file_";
  protected final String TEXT_471 = ".delete();" + NL + "                            }" + NL + "                            zipOut_";
  protected final String TEXT_472 = "=new java.util.zip.ZipOutputStream(" + NL + "                                    new java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_473 = ")));" + NL + "                            zipOut_";
  protected final String TEXT_474 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_475 = ".getName()));" + NL + "                            CsvWriter";
  protected final String TEXT_476 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                            zipOut_";
  protected final String TEXT_477 = ", ";
  protected final String TEXT_478 = ")));" + NL + "                            CsvWriter";
  protected final String TEXT_479 = ".setSeparator(csvSettings_";
  protected final String TEXT_480 = ".getFieldDelim());";
  protected final String TEXT_481 = NL + "                            com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_482 = " = null;" + NL;
  protected final String TEXT_483 = NL + "                            java.io.File fileToDelete_";
  protected final String TEXT_484 = " = new java.io.File(fileName_";
  protected final String TEXT_485 = ");" + NL + "                            if(fileToDelete_";
  protected final String TEXT_486 = ".exists()) {" + NL + "                                fileToDelete_";
  protected final String TEXT_487 = ".delete();" + NL + "                            }";
  protected final String TEXT_488 = NL + "                            CsvWriter";
  protected final String TEXT_489 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                            new java.io.FileOutputStream(fileName_";
  protected final String TEXT_490 = ", ";
  protected final String TEXT_491 = "), ";
  protected final String TEXT_492 = ")));" + NL + "                            CsvWriter";
  protected final String TEXT_493 = ".setSeparator(csvSettings_";
  protected final String TEXT_494 = ".getFieldDelim());";
  protected final String TEXT_495 = NL + "                        file";
  protected final String TEXT_496 = " = new java.io.File(fullName_";
  protected final String TEXT_497 = " + splitedFileNo_";
  protected final String TEXT_498 = " + extension_";
  protected final String TEXT_499 = ");" + NL + "                        java.io.Writer out";
  protected final String TEXT_500 = " = null;" + NL + "                        com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_501 = " = null;" + NL;
  protected final String TEXT_502 = NL + "                        if(file";
  protected final String TEXT_503 = ".exists()) {" + NL + "                            file";
  protected final String TEXT_504 = ".delete();" + NL + "                        }";
  protected final String TEXT_505 = NL + "                        out";
  protected final String TEXT_506 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "                            new java.io.FileOutputStream(fullName_";
  protected final String TEXT_507 = " + splitedFileNo_";
  protected final String TEXT_508 = " + extension_";
  protected final String TEXT_509 = ", ";
  protected final String TEXT_510 = "),";
  protected final String TEXT_511 = "));" + NL + "                        java.io.StringWriter strWriter";
  protected final String TEXT_512 = " = new java.io.StringWriter();" + NL + "                        CsvWriter";
  protected final String TEXT_513 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_514 = ");" + NL + "                        CsvWriter";
  protected final String TEXT_515 = ".setSeparator(csvSettings_";
  protected final String TEXT_516 = ".getFieldDelim());" + NL;
  protected final String TEXT_517 = NL + "                        file";
  protected final String TEXT_518 = " = new java.io.File(fullName_";
  protected final String TEXT_519 = " + splitedFileNo_";
  protected final String TEXT_520 = " + extension_";
  protected final String TEXT_521 = ");" + NL + "                        com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_522 = " = null;" + NL;
  protected final String TEXT_523 = NL + "                        if(file";
  protected final String TEXT_524 = ".exists()) {" + NL + "                            file";
  protected final String TEXT_525 = ".delete();" + NL + "                        }";
  protected final String TEXT_526 = NL + "                        CsvWriter";
  protected final String TEXT_527 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                            new java.io.FileOutputStream(fullName_";
  protected final String TEXT_528 = " + splitedFileNo_";
  protected final String TEXT_529 = " + extension_";
  protected final String TEXT_530 = ", ";
  protected final String TEXT_531 = "),";
  protected final String TEXT_532 = ")));" + NL + "                        CsvWriter";
  protected final String TEXT_533 = ".setSeparator(csvSettings_";
  protected final String TEXT_534 = ".getFieldDelim());";
  protected final String TEXT_535 = NL + "                    if(csvSettings_";
  protected final String TEXT_536 = ".isUseCRLFRecordDelimiter()) {" + NL + "                        CsvWriter";
  protected final String TEXT_537 = ".setLineEnd(\"\\r\\n\");" + NL + "                    } else {" + NL + "                        CsvWriter";
  protected final String TEXT_538 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_539 = ".getRowDelim());" + NL + "                    }";
  protected final String TEXT_540 = NL + "                    if(!csvSettings_";
  protected final String TEXT_541 = ".isUseCRLFRecordDelimiter() && csvSettings_";
  protected final String TEXT_542 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_543 = ".getRowDelim()!='\\n') {" + NL + "                        CsvWriter";
  protected final String TEXT_544 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_545 = ".getRowDelim());" + NL + "                    }";
  protected final String TEXT_546 = NL + "                        synchronized (multiThreadLockWrite) {";
  protected final String TEXT_547 = NL + "                        synchronized ((Object[])globalMap.get(\"lockWrite_";
  protected final String TEXT_548 = "\")) {";
  protected final String TEXT_549 = NL + "                        Object[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "                        synchronized (pLockWrite) {";
  protected final String TEXT_550 = NL + "                        if(file_";
  protected final String TEXT_551 = ".length()==0){";
  protected final String TEXT_552 = NL + "                        if(file";
  protected final String TEXT_553 = ".length()==0){";
  protected final String TEXT_554 = NL + "                                        fileOutputDelimitedUtil_";
  protected final String TEXT_555 = ".putHeaderValue_";
  protected final String TEXT_556 = "(headColu";
  protected final String TEXT_557 = ");";
  protected final String TEXT_558 = NL + "                                    headColu";
  protected final String TEXT_559 = "[";
  protected final String TEXT_560 = "]=\"";
  protected final String TEXT_561 = "\";";
  protected final String TEXT_562 = NL + "                            CsvWriter";
  protected final String TEXT_563 = ".writeNext(headColu";
  protected final String TEXT_564 = ");" + NL + "                            CsvWriter";
  protected final String TEXT_565 = ".flush();";
  protected final String TEXT_566 = NL + "                                out";
  protected final String TEXT_567 = ".write(strWriter";
  protected final String TEXT_568 = ".getBuffer().toString());" + NL + "                                out";
  protected final String TEXT_569 = ".flush();" + NL + "                                strWriter";
  protected final String TEXT_570 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_571 = ".getBuffer().length());";
  protected final String TEXT_572 = NL + "                        }";
  protected final String TEXT_573 = NL + "                        }";
  protected final String TEXT_574 = NL + "                        }";
  protected final String TEXT_575 = NL + "                        }";
  protected final String TEXT_576 = NL + "                        java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_577 = " = null;" + NL + "                        java.io.OutputStreamWriter outWriter_";
  protected final String TEXT_578 = " = null;" + NL + "                        java.io.Writer out";
  protected final String TEXT_579 = " = null;" + NL + "                        com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_580 = " = null;" + NL + "                        zipOut_";
  protected final String TEXT_581 = "=new java.util.zip.ZipOutputStream(" + NL + "                                new java.io.BufferedOutputStream(";
  protected final String TEXT_582 = "));" + NL + "                        zipOut_";
  protected final String TEXT_583 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "                        outWriter_";
  protected final String TEXT_584 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_585 = ", ";
  protected final String TEXT_586 = ");" + NL + "                        out";
  protected final String TEXT_587 = " = new routines.system.BufferedOutput(outWriter_";
  protected final String TEXT_588 = ");" + NL + "                        java.io.StringWriter strWriter";
  protected final String TEXT_589 = " = new java.io.StringWriter();" + NL + "                        CsvWriter";
  protected final String TEXT_590 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_591 = ");" + NL + "                        CsvWriter";
  protected final String TEXT_592 = ".setSeparator(csvSettings_";
  protected final String TEXT_593 = ".getFieldDelim());";
  protected final String TEXT_594 = NL + "                        java.io.OutputStreamWriter outWriter_";
  protected final String TEXT_595 = " = null;" + NL + "                        java.io.Writer out";
  protected final String TEXT_596 = " = null;" + NL + "                        com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_597 = " = null;" + NL + "                        outWriter_";
  protected final String TEXT_598 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_599 = ", ";
  protected final String TEXT_600 = ");" + NL + "                        out";
  protected final String TEXT_601 = " = new routines.system.BufferedOutput(outWriter_";
  protected final String TEXT_602 = ");" + NL + "                        java.io.StringWriter strWriter";
  protected final String TEXT_603 = " = new java.io.StringWriter();" + NL + "                        CsvWriter";
  protected final String TEXT_604 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_605 = ");" + NL + "                        CsvWriter";
  protected final String TEXT_606 = ".setSeparator(csvSettings_";
  protected final String TEXT_607 = ".getFieldDelim());";
  protected final String TEXT_608 = NL + "                        java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_609 = " = null;" + NL + "                        java.io.OutputStreamWriter outWriter_";
  protected final String TEXT_610 = " = null;" + NL + "                        java.io.BufferedWriter bufferWriter_";
  protected final String TEXT_611 = " = null;" + NL + "                        com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_612 = " = null;" + NL + "                        zipOut_";
  protected final String TEXT_613 = "=new java.util.zip.ZipOutputStream(" + NL + "                                new java.io.BufferedOutputStream(";
  protected final String TEXT_614 = "));" + NL + "                        zipOut_";
  protected final String TEXT_615 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "                        outWriter_";
  protected final String TEXT_616 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_617 = ", ";
  protected final String TEXT_618 = ");" + NL + "                        bufferWriter_";
  protected final String TEXT_619 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_620 = ");" + NL + "                        CsvWriter";
  protected final String TEXT_621 = " = new com.talend.csv.CSVWriter(bufferWriter_";
  protected final String TEXT_622 = ");" + NL + "                        CsvWriter";
  protected final String TEXT_623 = ".setSeparator(csvSettings_";
  protected final String TEXT_624 = ".getFieldDelim());";
  protected final String TEXT_625 = NL + "                        java.io.OutputStreamWriter outWriter_";
  protected final String TEXT_626 = " = null;" + NL + "                        java.io.BufferedWriter bufferWriter_";
  protected final String TEXT_627 = " = null;" + NL + "                        com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_628 = " = null;" + NL + "                        outWriter_";
  protected final String TEXT_629 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_630 = ", ";
  protected final String TEXT_631 = ");" + NL + "                        bufferWriter_";
  protected final String TEXT_632 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_633 = ");" + NL + "                        CsvWriter";
  protected final String TEXT_634 = " = new com.talend.csv.CSVWriter(bufferWriter_";
  protected final String TEXT_635 = ");" + NL + "                        CsvWriter";
  protected final String TEXT_636 = ".setSeparator(csvSettings_";
  protected final String TEXT_637 = ".getFieldDelim());";
  protected final String TEXT_638 = NL + "                    if(csvSettings_";
  protected final String TEXT_639 = ".isUseCRLFRecordDelimiter()) {" + NL + "                        CsvWriter";
  protected final String TEXT_640 = ".setLineEnd(\"\\r\\n\");" + NL + "                    } else {" + NL + "                        CsvWriter";
  protected final String TEXT_641 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_642 = ".getRowDelim());" + NL + "                    }";
  protected final String TEXT_643 = NL + "                    if(!csvSettings_";
  protected final String TEXT_644 = ".isUseCRLFRecordDelimiter() && csvSettings_";
  protected final String TEXT_645 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_646 = ".getRowDelim()!='\\n') {" + NL + "                        CsvWriter";
  protected final String TEXT_647 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_648 = ".getRowDelim());" + NL + "                    }";
  protected final String TEXT_649 = NL + "                                fileOutputDelimitedUtil_";
  protected final String TEXT_650 = ".putHeaderValue_";
  protected final String TEXT_651 = "(headColu";
  protected final String TEXT_652 = ");";
  protected final String TEXT_653 = NL + "                            headColu";
  protected final String TEXT_654 = "[";
  protected final String TEXT_655 = "]=\"";
  protected final String TEXT_656 = "\";";
  protected final String TEXT_657 = NL + "                    CsvWriter";
  protected final String TEXT_658 = ".writeNext(headColu";
  protected final String TEXT_659 = ");";
  protected final String TEXT_660 = NL + "                        out";
  protected final String TEXT_661 = ".write(strWriter";
  protected final String TEXT_662 = ".getBuffer().toString());" + NL + "                        strWriter";
  protected final String TEXT_663 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_664 = ".getBuffer().length());";
  protected final String TEXT_665 = NL + "                CsvWriter";
  protected final String TEXT_666 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_667 = ".getEscapeChar());" + NL + "                CsvWriter";
  protected final String TEXT_668 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_669 = ".getTextEnclosure());" + NL + "                CsvWriter";
  protected final String TEXT_670 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);";
  protected final String TEXT_671 = NL + NL;
  protected final String TEXT_672 = NL;
  protected final String TEXT_673 = NL + "        resourceMap.put(\"out_";
  protected final String TEXT_674 = "\", out";
  protected final String TEXT_675 = ");";
  protected final String TEXT_676 = NL + "        resourceMap.put(\"out_";
  protected final String TEXT_677 = "\", out";
  protected final String TEXT_678 = ");" + NL + "        resourceMap.put(\"writer_";
  protected final String TEXT_679 = "\", writer_";
  protected final String TEXT_680 = ");";
  protected final String TEXT_681 = NL + "    resourceMap.put(\"CsvWriter_";
  protected final String TEXT_682 = "\", CsvWriter";
  protected final String TEXT_683 = ");";
  protected final String TEXT_684 = NL + "            resourceMap.put(\"out_";
  protected final String TEXT_685 = "\", out";
  protected final String TEXT_686 = ");";
  protected final String TEXT_687 = NL + "            resourceMap.put(\"out_";
  protected final String TEXT_688 = "\", out";
  protected final String TEXT_689 = ");" + NL + "            resourceMap.put(\"outWriter_";
  protected final String TEXT_690 = "\", outWriter_";
  protected final String TEXT_691 = ");";
  protected final String TEXT_692 = NL + "            resourceMap.put(\"bufferWriter_";
  protected final String TEXT_693 = "\", bufferWriter_";
  protected final String TEXT_694 = ");" + NL + "            resourceMap.put(\"outWriter_";
  protected final String TEXT_695 = "\", outWriter_";
  protected final String TEXT_696 = ");";
  protected final String TEXT_697 = NL + "resourceMap.put(\"nb_line_";
  protected final String TEXT_698 = "\", nb_line_";
  protected final String TEXT_699 = ");";
  protected final String TEXT_700 = NL + "    resourceMap.put(\"isFileGenerated_";
  protected final String TEXT_701 = "\", isFileGenerated_";
  protected final String TEXT_702 = ");";
  protected final String TEXT_703 = NL + "        resourceMap.put(\"file_";
  protected final String TEXT_704 = "\", file_";
  protected final String TEXT_705 = ");";
  protected final String TEXT_706 = NL + "        resourceMap.put(\"file";
  protected final String TEXT_707 = "\", file";
  protected final String TEXT_708 = ");";
  protected final String TEXT_709 = NL;

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

boolean isTSalesforceWaveOutputBulkExec = ((cid == null) ? false : (cid.startsWith("tSalesforceWaveOutputBulkExec")));
boolean useDoubleQuoteEnclosure = "true".equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))
                                  && ("\"\"\"").equals(ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__"));
boolean applyNA4Null = isTSalesforceWaveOutputBulkExec;
String str4Nil = "#N/A";

boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
String fileName = ElementParameterParser.getValue(node,"__FILENAME__");

boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
    schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}
boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));

boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));

String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
IProcess process = node.getProcess();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));
boolean exceptionOnFileExist = !useStream&&!isAppend&&(("true").equals(ElementParameterParser.getValue(node, "__FILE_EXIST_EXCEPTION__")));

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
List<IMetadataTable> metadatas = node.getMetadataList();
List< ? extends IConnection> conns = node.getIncomingConnections();
if ((metadatas!=null)&&(metadatas.size()>0)) {//A1
    IMetadataTable metadata = metadatas.get(0);
    boolean hasDynamic = metadata.isDynamicSchema();
    if(hasDynamic && ("true").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))){
    
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
    }
    IMetadataColumn dynamicCol = metadata.getDynamicColumn();
    for (IConnection conn : conns) {//B1
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//C1
            List<IMetadataColumn> columns = metadata.getListColumns();
            int sizeColumns = columns.size();
            if(sizeColumns> schemaOptNum){//D1
            
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
                    if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {//E1 not use CSV Option
                        if(isIncludeHeader){//F1
                            for (int i = 0; i < sizeColumns; i++) {//H1
                                IMetadataColumn column = columns.get(i);
                                if(i%schemaOptNum==0){
                                
    stringBuffer.append(TEXT_35);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(conn.getName() );
    }
    stringBuffer.append(TEXT_40);
    
                                }
                                if(!("id_Dynamic".equals(column.getTalendType()))) {
                                
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_43);
    
                                }else{
                                
    stringBuffer.append(TEXT_44);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
                                }
                                if(i != sizeColumns - 1) {
                                
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
                                }
                                if((i+1)%schemaOptNum==0){
                                
    stringBuffer.append(TEXT_52);
    
                                }
                            }//H1
                            if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){
                            
    stringBuffer.append(TEXT_53);
    
                            }
                        }//F1
                        for (int i = 0; i < sizeColumns; i++) {//F2
                            IMetadataColumn column = columns.get(i);
                            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                            boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
                            if(i%schemaOptNum==0){
                            
    stringBuffer.append(TEXT_54);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
                            }
                            if(!isPrimitive) {
                            
    stringBuffer.append(TEXT_60);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_62);
    
                            }
                            if(column.getTalendType().equals("id_Dynamic")){
                            
    stringBuffer.append(TEXT_63);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
                            }else{
                            
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
                                    String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                                    if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
                                    
    stringBuffer.append(TEXT_70);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_73);
    
                                    } else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) {
                                        if(javaType == JavaTypesManager.BIGDECIMAL) {
                                        
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_75);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_77);
    
                                        } else {
                                        
    stringBuffer.append(TEXT_78);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_82);
    
                                        }
                                    } else if(javaType == JavaTypesManager.BIGDECIMAL){
                                    
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_84);
    
                                    } else if(javaType == JavaTypesManager.BYTE_ARRAY){
                                    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_88);
    
                                    } else {
                                    
    stringBuffer.append(TEXT_89);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column.getLabel() );
    
                                    }
                                    
    stringBuffer.append(TEXT_91);
    
                            }
                            if(!isPrimitive) {
                            
    stringBuffer.append(TEXT_92);
    
                            }
                            if(i != sizeColumns - 1) {
                            
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
                            }
                            if((i+1)%schemaOptNum==0){
                            
    stringBuffer.append(TEXT_96);
    
                            }
                        }//F2
                        if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){
                        
    stringBuffer.append(TEXT_97);
    
                        }
                    }else{
                        //E2 use CSV Option
                        if(isIncludeHeader){//F3
                            for (int i = 0; i < sizeColumns; i++) {//H3
                                IMetadataColumn column = columns.get(i);
                                if(i%schemaOptNum==0){
                                
    stringBuffer.append(TEXT_98);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_100);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    
                                }
                                if(!("id_Dynamic".equals(column.getTalendType()))) {
                                    if(hasDynamic){
                                    
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_109);
    
                                    }else{
                                    
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_113);
    
                                    }
                                }else{
                                
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_122);
    
                                }
                                if((i+1)%schemaOptNum==0){
                                
    stringBuffer.append(TEXT_123);
    
                                }
                            }//H3
                            if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){
                            
    stringBuffer.append(TEXT_124);
    
                            }
                        }//F3
                        for (int i = 0; i < sizeColumns; i++) {//F4
                            IMetadataColumn column = columns.get(i);
                            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                            String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                            boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
                            if(i%schemaOptNum==0){
                            
    stringBuffer.append(TEXT_125);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    
                            }
                            if(("id_Dynamic").equals(column.getTalendType())) {
                            
    stringBuffer.append(TEXT_132);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append( i );
    stringBuffer.append(TEXT_141);
    
                                       if(applyNA4Null){
                                            
    stringBuffer.append(TEXT_142);
    stringBuffer.append( str4Nil );
    stringBuffer.append(TEXT_143);
    
                                       }else{
                                            
    stringBuffer.append(TEXT_144);
    
                                       }
                                     
    stringBuffer.append(TEXT_145);
    
                            }else{
                                if(hasDynamic){
                                
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ " == null ? null : ");
    
                                }else{
                                
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ " == null ? null : ");
    
                                }
                                if(javaType == JavaTypesManager.STRING ){
                                
    stringBuffer.append(TEXT_153);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_155);
    
                                }else if(javaType == JavaTypesManager.DATE && pattern != null){
                                
    stringBuffer.append(TEXT_156);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_159);
    
                                }else if(javaType == JavaTypesManager.BYTE_ARRAY){
                                
    stringBuffer.append(TEXT_160);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_162);
    
                                }else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) {
                                    if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_163);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_164);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_165);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_166);
    
                                    } else { 
    stringBuffer.append(TEXT_167);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_170);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_171);
    
                                    }
                                } else if (javaType == JavaTypesManager.BIGDECIMAL) {
                                
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_173);
    
                                } else{
                                
    stringBuffer.append(TEXT_174);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_176);
    
                                }
                            }
                            if((i+1)%schemaOptNum==0){
                            
    stringBuffer.append(TEXT_177);
    
                            }
                        }//F4
                        if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){
                        
    stringBuffer.append(TEXT_178);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
            }//D1
        }//C1
    }//B1
}//A1

if(!useStream){

    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
    if(exceptionOnFileExist){
    
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    
    }
    
    
    if(isAppend){
    
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    
    }
}
if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {

            String fieldSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__FIELDSEPARATOR__",
                "FIELDSEPARATOR"
            );

            String rowSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__ROWSEPARATOR__",
                "ROWSEPARATOR"
            );


            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");

            boolean hasDynamic = metadata.isDynamicSchema();
            if(hasDynamic){
            
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    
            }
            
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    
            if(split){
            
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_232);
    
            }
            
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_239);
    
            if(!useStream){
            //**************************** the following is the part of file Path***************************************

                if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){
                
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    }
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    }
    stringBuffer.append(TEXT_254);
    
                }
                
    stringBuffer.append(TEXT_255);
    
                String writerClass = null;
                if(isInRowMode){
                    writerClass = "routines.system.BufferedOutput";
                }else{
                    writerClass = "java.io.BufferedWriter";
                }
                if(!split){
                    if(compress && !isAppend){// compress the dest file
                    
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_274);
    
                    }else{
                    
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    if(!isAppend) {
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    }
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_287);
    
                    }
                } else {
                
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    if(!isAppend) {
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    }
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_304);
    
                }

                if(isIncludeHeader && !hasDynamic){
                
    
                    if(codeGenArgument.getIsRunInMultiThread()){
                    
    stringBuffer.append(TEXT_305);
    
                    }
                        if (((AbstractNode)node).getParallelIterator() != null) {
                        
    stringBuffer.append(TEXT_306);
    stringBuffer.append(((AbstractNode)node).getParallelIterator());
    stringBuffer.append(TEXT_307);
    
                        }
                            if (isParallelize) {
                            
    stringBuffer.append(TEXT_308);
    
                            }
                                if(!split && compress && !isAppend){
                                
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    
                                }else{
                                
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    
                                }
                                List<IMetadataColumn> columns = metadata.getListColumns();
                                int sizeColumns = columns.size();
                                for (int i = 0; i < sizeColumns; i++) {
                                    IMetadataColumn column = columns.get(i);
                                    if(sizeColumns > schemaOptNum){
                                        if(i%schemaOptNum==0){
                                        
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    
                                        }
                                    }else{//AA
                                    
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_320);
    
                                        if(i != sizeColumns - 1) {
                                            
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    
                                        }
                                    }//AA
                                }
                                
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    
                            if (isParallelize) {
                            
    stringBuffer.append(TEXT_328);
    
                            }
                        if (((AbstractNode)node).getParallelIterator() != null) {
                        
    stringBuffer.append(TEXT_329);
    
                        }
                    if(codeGenArgument.getIsRunInMultiThread()){
                    
    stringBuffer.append(TEXT_330);
    
                    }
                }

            }else{
            //***********************the following is the part of output Stream**************************************

                String writerClass = null;
                if(isInRowMode){
                    writerClass = "routines.system.BufferedOutput";
                }else{
                    writerClass = "java.io.BufferedWriter";
                }
                if(compress){// compress the dest output stream
                
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    
                }else{
                
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    
                }

                if(isIncludeHeader && !hasDynamic){
                    List<IMetadataColumn> columns = metadata.getListColumns();
                    int sizeColumns = columns.size();
                    for (int i = 0; i < sizeColumns; i++) {
                        IMetadataColumn column = columns.get(i);
                        if(sizeColumns > schemaOptNum){
                            if(i%schemaOptNum==0){
                            
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    
                            }
                        }else{//BB
                        
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_360);
    
                            if(i != sizeColumns - 1) {
                            
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    
                            }
                        }//BB
                    }
                    
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    
                }
            }// ****************************output Stream end*************************************
        }
    }
    
    stringBuffer.append(TEXT_367);
    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{// the following is the tFileOutputCSV component
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
            List<IMetadataColumn> columns = metadata.getListColumns();
            int sizeColumns = columns.size();
            String delim = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
            String rowSeparator = ElementParameterParser.getValue(node, "__CSVROWSEPARATOR__");
            boolean useOSLineSeparator = ("true").equals(ElementParameterParser.getValue(node,"__OS_LINE_SEPARATOR_AS_ROW_SEPARATOR__"));

            String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");

            if(escapeChar1.equals("\"\"\"")){
                escapeChar1 = "\"\\\"\"";
            }

            String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
            if(textEnclosure1.equals("\"\"\"")){
                textEnclosure1 = "\"\\\"\"";
            }

            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");

            boolean hasDynamic = metadata.isDynamicSchema();
            if(hasDynamic){
            
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    
            }else{
            
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_373);
    
            }
            
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    
            if(split){
            
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_390);
    
            }
            
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(delim);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(escapeChar1 );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(textEnclosure1 );
    stringBuffer.append(TEXT_403);
    
            if(!useStream){
            //**************************** the following is the part of file Path***************************************
                if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){
                
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    }
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    }
    stringBuffer.append(TEXT_418);
    
                }

                if(!split){
                    if(isInRowMode){
                        if(compress && !isAppend){// compress the dest file
                        
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    
                        }else{
                        
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    if(!isAppend) {
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    }
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(encoding);
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
    
                        }

                    }else{
                        if(compress && !isAppend){// compress the dest file
                        
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    
                        }else{
                        
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    if(!isAppend) {
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    }
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    
                        }
                    }
                }else{
                    if(isInRowMode){
                    
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    if(!isAppend) {
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    }
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    
                    }else{
                    
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    if(!isAppend) {
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
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
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    
                    }
                }

                if(!useOSLineSeparator) {
                
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    
                } else {
                
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    
                }

                if(isIncludeHeader && !hasDynamic)
                {
                
    
                    if(codeGenArgument.getIsRunInMultiThread()){
                    
    stringBuffer.append(TEXT_546);
    
                    }
                    if (((AbstractNode)node).getParallelIterator() != null) {
                    
    stringBuffer.append(TEXT_547);
    stringBuffer.append(((AbstractNode)node).getParallelIterator());
    stringBuffer.append(TEXT_548);
    
                    }
                    if (isParallelize) {
                    
    stringBuffer.append(TEXT_549);
    
                    }
                    if(!split && compress && !isAppend){
                    
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    
                    }else{
                    
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    
                    }
                    
    
                            for(int i = 0 ; i < sizeColumns ; i++){
                                IMetadataColumn column = columns.get(i);
                                if(sizeColumns> schemaOptNum){
                                    if(i%schemaOptNum==0){
                                    
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    
                                    }
                                }else{//CC
                                
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_561);
    
                                }//CC
                            }
                            
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    if(isInRowMode){
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    }
    stringBuffer.append(TEXT_572);
    
                    if (isParallelize) {
                    
    stringBuffer.append(TEXT_573);
    
                    }
                    if (((AbstractNode)node).getParallelIterator() != null) {
                    
    stringBuffer.append(TEXT_574);
    
                    }
                    if(codeGenArgument.getIsRunInMultiThread()){
                    
    stringBuffer.append(TEXT_575);
    
                    }
                    
    
                }
            }else{
            //***********************the following is the part of output Stream**************************************
                if(isInRowMode){
                    if(compress){// compress the dest output stream
                    
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
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
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
    
                    }else{
                    
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_599);
    stringBuffer.append(encoding);
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
    
                    }

                }else{
                    if(compress){// compress the dest output stream
                    
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    
                    }else{
                    
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_630);
    stringBuffer.append(encoding);
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

                if(!useOSLineSeparator) {
                
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    
                } else {
                
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
    
                }

                if(isIncludeHeader && !hasDynamic)
                {
                    for(int i = 0; i < sizeColumns; i++)
                    {
                        IMetadataColumn column = columns.get(i);
                        if(sizeColumns> schemaOptNum){
                            if(i%schemaOptNum==0){
                            
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    
                            }
                        }else{//DD
                        
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_656);
    
                        }//DD
                    }
                    
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_659);
    if(isInRowMode){
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    }
                }
            }//*****************************csv mode under output stream end********************************************************

            if(!(isIncludeHeader && hasDynamic)){//when there is dynamic schema, it won't be enclosed with "\""
            
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_670);
    
            }
        }
    }
    
    stringBuffer.append(TEXT_671);
    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

    stringBuffer.append(TEXT_672);
    
if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {
    if(!useStream){
    
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_675);
    
    }else{
    
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_680);
    
    }
}else{//the following is the tFileOutputCSV component

    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    
    if(!useStream){
        if(isInRowMode){
        
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    
        }
    }else{
        if(isInRowMode){
        
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    
        }else{
        
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_696);
    
        }
    }
}

    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
    if(!useStream && ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"))){
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_702);
    if(compress && !isAppend && !split){
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    }else{
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    }
    }
    stringBuffer.append(TEXT_709);
    return stringBuffer.toString();
  }
}
