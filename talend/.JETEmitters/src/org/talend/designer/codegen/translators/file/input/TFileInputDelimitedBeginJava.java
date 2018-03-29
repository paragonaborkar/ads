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
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IProcess;

public class TFileInputDelimitedBeginJava
{
  protected static String nl;
  public static synchronized TFileInputDelimitedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputDelimitedBeginJava result = new TFileInputDelimitedBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t\t\trowHelper_";
  protected final String TEXT_4 = ".valueToConn(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = " ";
  protected final String TEXT_7 = ");" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\t\trowHelper_";
  protected final String TEXT_9 = ".valueToConnWithD(";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = " ";
  protected final String TEXT_13 = ");" + NL + "\t\t";
  protected final String TEXT_14 = NL + "\t\t\trowHelper_";
  protected final String TEXT_15 = ".connToConn(";
  protected final String TEXT_16 = ",";
  protected final String TEXT_17 = ");" + NL + "\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tclass RowHelper_";
  protected final String TEXT_19 = "{" + NL + "\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t\tpublic void valueToConn_";
  protected final String TEXT_21 = "(";
  protected final String TEXT_22 = " ";
  protected final String TEXT_23 = ",";
  protected final String TEXT_24 = "Struct ";
  protected final String TEXT_25 = " ";
  protected final String TEXT_26 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\tpublic void valueToConnWithD_";
  protected final String TEXT_29 = "(";
  protected final String TEXT_30 = " ";
  protected final String TEXT_31 = ",";
  protected final String TEXT_32 = "Struct ";
  protected final String TEXT_33 = ", routines.system.Dynamic ";
  protected final String TEXT_34 = " ";
  protected final String TEXT_35 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t\tpublic void connToConn_";
  protected final String TEXT_38 = "(";
  protected final String TEXT_39 = "Struct ";
  protected final String TEXT_40 = ",";
  protected final String TEXT_41 = "Struct ";
  protected final String TEXT_42 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\tpublic void valueToConn(";
  protected final String TEXT_45 = " ";
  protected final String TEXT_46 = ",";
  protected final String TEXT_47 = "Struct ";
  protected final String TEXT_48 = " ";
  protected final String TEXT_49 = ") throws java.lang.Exception{" + NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\tpublic void valueToConnWithD(";
  protected final String TEXT_51 = " ";
  protected final String TEXT_52 = ",";
  protected final String TEXT_53 = "Struct ";
  protected final String TEXT_54 = ", routines.system.Dynamic ";
  protected final String TEXT_55 = " ";
  protected final String TEXT_56 = ") throws java.lang.Exception{" + NL + "\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\tvalueToConn_";
  protected final String TEXT_58 = "(";
  protected final String TEXT_59 = ",";
  protected final String TEXT_60 = " ";
  protected final String TEXT_61 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\tvalueToConnWithD_";
  protected final String TEXT_63 = "(";
  protected final String TEXT_64 = ",";
  protected final String TEXT_65 = ",";
  protected final String TEXT_66 = " ";
  protected final String TEXT_67 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\tpublic void connToConn(";
  protected final String TEXT_70 = "Struct ";
  protected final String TEXT_71 = ",";
  protected final String TEXT_72 = "Struct ";
  protected final String TEXT_73 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t\t\tconnToConn_";
  protected final String TEXT_75 = "(";
  protected final String TEXT_76 = ",";
  protected final String TEXT_77 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t}" + NL + "\t\t\t\tRowHelper_";
  protected final String TEXT_80 = " rowHelper_";
  protected final String TEXT_81 = "  = new RowHelper_";
  protected final String TEXT_82 = "();" + NL + "\t\t\t";
  protected final String TEXT_83 = NL + "\t";
  protected final String TEXT_84 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_85 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_87 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_88 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_90 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_91 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_93 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_94 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_96 = " - Written records count: \" + nb_line_";
  protected final String TEXT_97 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_99 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_101 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_102 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_104 = " - Writing the record \" + nb_line_";
  protected final String TEXT_105 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_107 = " - Processing the record \" + nb_line_";
  protected final String TEXT_108 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_110 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_111 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_112 = NL + " " + NL + "\t";
  protected final String TEXT_113 = NL + "\t\t\tif(isFirstCheckDyn_";
  protected final String TEXT_114 = "){// for the header line" + NL + "\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\tint colsLen_";
  protected final String TEXT_116 = " = row";
  protected final String TEXT_117 = ".length;" + NL + "\t\t\t\t";
  protected final String TEXT_118 = NL + "\t\t\t\t\tint colsLen_";
  protected final String TEXT_119 = " = fid_";
  protected final String TEXT_120 = ".getColumnsCountOfCurrentRow();" + NL + "\t\t\t\t";
  protected final String TEXT_121 = NL + "    \t\t\tfor (int i = ";
  protected final String TEXT_122 = "; i < colsLen_";
  protected final String TEXT_123 = "-";
  protected final String TEXT_124 = "; i++) {" + NL + "\t\t\t    \troutines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_125 = " = new routines.system.DynamicMetadata();" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_126 = ".setName(";
  protected final String TEXT_127 = "row";
  protected final String TEXT_128 = "[i]";
  protected final String TEXT_129 = "fid_";
  protected final String TEXT_130 = ".get(i)";
  protected final String TEXT_131 = ".replaceAll(\"[ .-]+\", \"_\"));" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_132 = ".setDbName(dynamicMetadata_";
  protected final String TEXT_133 = ".getName());" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_134 = ".setType(\"id_String\");" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_135 = ".setDbType(\"VARCHAR\");" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_136 = ".setLength(100);" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_137 = ".setPrecision(0);" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_138 = ".setNullable(true);" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_139 = ".setKey(false);" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_140 = ".setSourceType(routines.system.DynamicMetadata.sourceTypes.demilitedFile);" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_141 = ".setColumnPosition(i);" + NL + "\t\t\t    \tdynamic_";
  protected final String TEXT_142 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_143 = ");" + NL + "\t\t\t    }" + NL + "    \t\t\tisFirstCheckDyn_";
  protected final String TEXT_144 = " = false;" + NL + "    \t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_145 = NL + "\t\t\tint footer_value_";
  protected final String TEXT_146 = " = ";
  protected final String TEXT_147 = ", random_value_";
  protected final String TEXT_148 = " = ";
  protected final String TEXT_149 = ";" + NL + "\t\t\tif(footer_value_";
  protected final String TEXT_150 = " >0 || random_value_";
  protected final String TEXT_151 = " > 0){" + NL + "\t\t\t\tthrow new java.lang.Exception(\"When the input source is a stream,footer and random shouldn't be bigger than 0.\");\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_152 = NL + "\t\t\tint footer_value_";
  protected final String TEXT_153 = " = ";
  protected final String TEXT_154 = ";" + NL + "\t\t\tif(footer_value_";
  protected final String TEXT_155 = " > 0){" + NL + "\t\t\t\tthrow new java.lang.Exception(\"When the input source is a stream,footer shouldn't be bigger than 0.\");" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_156 = NL + "\t" + NL + "\tfinal routines.system.RowState rowstate_";
  protected final String TEXT_157 = " = new routines.system.RowState();" + NL + "\t" + NL + "\t";
  protected final String TEXT_158 = NL + "\t\t\t\tint dynamic_column_count_";
  protected final String TEXT_159 = "=";
  protected final String TEXT_160 = ".getColumnCount()";
  protected final String TEXT_161 = "1";
  protected final String TEXT_162 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_163 = NL + "\t\t\t\tint columnIndexWithD_";
  protected final String TEXT_164 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_165 = NL + "\t\t\t\t\tString temp = \"\"; " + NL + "\t\t\t\t";
  protected final String TEXT_166 = NL + "\t\t\t\t\tcolumnIndexWithD_";
  protected final String TEXT_167 = " = ";
  protected final String TEXT_168 = "+dynamic_column_count_";
  protected final String TEXT_169 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_170 = NL + "\t\t\t\t\tcolumnIndexWithD_";
  protected final String TEXT_171 = " = ";
  protected final String TEXT_172 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_173 = NL + "\t\t\t\t\t\t\ttemp  = ";
  protected final String TEXT_174 = ".get(columnIndexWithD_";
  protected final String TEXT_175 = ")";
  protected final String TEXT_176 = ";" + NL + "\t\t\t\t\t\t\tif(temp.length() > 0){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_177 = ".";
  protected final String TEXT_178 = " = temp;" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_179 = ".";
  protected final String TEXT_180 = " = ";
  protected final String TEXT_181 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_183 = ".";
  protected final String TEXT_184 = " = ";
  protected final String TEXT_185 = ".get(columnIndexWithD_";
  protected final String TEXT_186 = ")";
  protected final String TEXT_187 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_188 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_189 = ".clearColumnValues();" + NL + "\t\t\t\t\t\tint fieldCount = ";
  protected final String TEXT_190 = ".getColumnsCountOfCurrentRow();" + NL + "\t\t\t\t\t\tdynamic_column_count_";
  protected final String TEXT_191 = " = ";
  protected final String TEXT_192 = ".getColumnCount();" + NL + "\t\t\t\t\t\tfor (int i = 0; i < dynamic_column_count_";
  protected final String TEXT_193 = " ; i++) {" + NL + "\t\t\t\t\t\t\tif ((";
  protected final String TEXT_194 = "+i) < fieldCount){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_195 = ".addColumnValue(";
  protected final String TEXT_196 = ".get(";
  protected final String TEXT_197 = "+i)";
  protected final String TEXT_198 = ");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\telse{" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_199 = ".addColumnValue(\"\");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_200 = ".";
  protected final String TEXT_201 = "=";
  protected final String TEXT_202 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_203 = NL + "\t\t\t\t\t\ttemp = ";
  protected final String TEXT_204 = ".get(columnIndexWithD_";
  protected final String TEXT_205 = ")";
  protected final String TEXT_206 = ";" + NL + "\t\t\t\t\t\tif(temp.length() > 0) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_207 = NL + "\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_208 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = " = temp.getBytes(";
  protected final String TEXT_211 = ");" + NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_212 = NL + "                                    ";
  protected final String TEXT_213 = ".";
  protected final String TEXT_214 = " = ParserUtils.parseTo_List(temp, ";
  protected final String TEXT_215 = ");";
  protected final String TEXT_216 = NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = " = ParserUtils.parseTo_Date(temp, ";
  protected final String TEXT_219 = ", false);" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_220 = NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_221 = ".";
  protected final String TEXT_222 = " = ParserUtils.parseTo_Date(temp, ";
  protected final String TEXT_223 = ");" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_224 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_225 = ".";
  protected final String TEXT_226 = " = ParserUtils.parseTo_";
  protected final String TEXT_227 = "(ParserUtils.parseTo_Number(temp, ";
  protected final String TEXT_228 = ", ";
  protected final String TEXT_229 = ")";
  protected final String TEXT_230 = ");" + NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_231 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_232 = ".";
  protected final String TEXT_233 = " = ParserUtils.parseTo_";
  protected final String TEXT_234 = "(ParserUtils.parseTo_Number(temp, ";
  protected final String TEXT_235 = ", ";
  protected final String TEXT_236 = "));" + NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_237 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_238 = ".";
  protected final String TEXT_239 = " = ParserUtils.parseTo_";
  protected final String TEXT_240 = "(temp";
  protected final String TEXT_241 = ");" + NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_242 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_243 = ".";
  protected final String TEXT_244 = " = ParserUtils.parseTo_";
  protected final String TEXT_245 = "(temp);" + NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_246 = NL + "    \t\t\t\t\t\t\t} catch(java.lang.Exception ex_";
  protected final String TEXT_247 = ") {" + NL + "\t\t\t\t\t\t\t\t\trowstate_";
  protected final String TEXT_248 = ".setException(ex_";
  protected final String TEXT_249 = ");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_250 = NL + "\t\t\t\t\t\t} else {\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_251 = NL + "\t\t\t\t\t\t\t\trowstate_";
  protected final String TEXT_252 = ".setException(new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_253 = "' in '";
  protected final String TEXT_254 = "' connection, value is invalid or this column should be nullable or have a default value.\"));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_255 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_256 = ".";
  protected final String TEXT_257 = " = ";
  protected final String TEXT_258 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_259 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_260 = NL + "\t\t\t\t";
  protected final String TEXT_261 = NL + "\t\t\t\t";
  protected final String TEXT_262 = NL + "\t\t\t\t \tint filedsum = ";
  protected final String TEXT_263 = ".getColumnsCountOfCurrentRow();" + NL + "\t\t\t\t \tif(filedsum < (";
  protected final String TEXT_264 = " ";
  protected final String TEXT_265 = "+ dynamic_column_count_";
  protected final String TEXT_266 = " -1";
  protected final String TEXT_267 = ")){" + NL + "\t\t\t\t\t \tthrow new RuntimeException(\"Column(s) missing\");" + NL + "\t\t\t\t\t } else if(filedsum > (";
  protected final String TEXT_268 = " ";
  protected final String TEXT_269 = "+ dynamic_column_count_";
  protected final String TEXT_270 = " -1";
  protected final String TEXT_271 = ")) {" + NL + "\t\t\t\t\t \tthrow new RuntimeException(\"Too many columns\");" + NL + "\t\t\t\t\t }     " + NL + "\t\t\t\t";
  protected final String TEXT_272 = NL + "    \t\t\t\t";
  protected final String TEXT_273 = ".";
  protected final String TEXT_274 = " = ";
  protected final String TEXT_275 = ".";
  protected final String TEXT_276 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_277 = NL + "\t\t\t";
  protected final String TEXT_278 = NL + "\t\t\t\t\t\t\tboolean isFirstCheckDyn_";
  protected final String TEXT_279 = " = true;" + NL + "\t\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_280 = " = new routines.system.Dynamic();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_281 = NL + "\t\t\t\tint nb_line_";
  protected final String TEXT_282 = " = 0;" + NL + "\t\t\t\torg.talend.fileprocess.FileInputDelimited fid_";
  protected final String TEXT_283 = " = null;" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_284 = NL + "\t\t\t\t\t\tObject filename_";
  protected final String TEXT_285 = " = ";
  protected final String TEXT_286 = ";\t" + NL + "\t\t\t\t\t\tjava.util.zip.ZipInputStream zis_";
  protected final String TEXT_287 = " = null;" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tif(filename_";
  protected final String TEXT_288 = " instanceof java.io.InputStream){" + NL + "\t\t\t\t\t\t\t\tzis_";
  protected final String TEXT_289 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream((java.io.InputStream)filename_";
  protected final String TEXT_290 = "));" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tzis_";
  protected final String TEXT_291 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_292 = "))));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_293 = NL + "\t\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_294 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_295 = NL + "\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_296 = " - \" +e.getMessage());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_297 = NL + "\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_298 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tjava.util.zip.ZipEntry entry_";
  protected final String TEXT_299 = " = null;" + NL + "\t\t" + NL + "\t\t\t\t\t\twhile (true) {" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\tentry_";
  protected final String TEXT_300 = " = zis_";
  protected final String TEXT_301 = ".getNextEntry();" + NL + "\t\t\t\t\t\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_302 = NL + "\t\t\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_303 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_304 = NL + "\t\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_305 = " - \" +e.getMessage());" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_306 = NL + "\t\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_307 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif(entry_";
  protected final String TEXT_308 = " == null) {" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif(entry_";
  protected final String TEXT_309 = ".isDirectory()){ //directory" + NL + "\t\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\tfid_";
  protected final String TEXT_310 = " = new org.talend.fileprocess.FileInputDelimited(zis_";
  protected final String TEXT_311 = ", ";
  protected final String TEXT_312 = ",";
  protected final String TEXT_313 = ",";
  protected final String TEXT_314 = ",";
  protected final String TEXT_315 = ",";
  protected final String TEXT_316 = ",";
  protected final String TEXT_317 = ",";
  protected final String TEXT_318 = ",";
  protected final String TEXT_319 = ", ";
  protected final String TEXT_320 = ");" + NL + "\t\t\t\t\t\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_321 = NL + "\t\t\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_322 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_323 = NL + "\t\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_324 = " - \" +e.getMessage());" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_325 = NL + "\t\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_326 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_327 = NL + "\t\t\t\t\t\tObject filename_";
  protected final String TEXT_328 = " = ";
  protected final String TEXT_329 = ";" + NL + "\t\t\t\t\t\tif(filename_";
  protected final String TEXT_330 = " instanceof java.io.InputStream){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_331 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tfid_";
  protected final String TEXT_332 = " = new org.talend.fileprocess.FileInputDelimited(";
  protected final String TEXT_333 = ", ";
  protected final String TEXT_334 = ",";
  protected final String TEXT_335 = ",";
  protected final String TEXT_336 = ",";
  protected final String TEXT_337 = ",";
  protected final String TEXT_338 = ",";
  protected final String TEXT_339 = ",";
  protected final String TEXT_340 = ",";
  protected final String TEXT_341 = ", ";
  protected final String TEXT_342 = ");" + NL + "\t\t\t\t\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_343 = NL + "\t\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_344 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_345 = NL + "\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_346 = " - \" +e.getMessage());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_347 = NL + "\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_348 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_349 = NL + "\t\t\t\t    ";
  protected final String TEXT_350 = NL + "\t\t\t\t    \tlog.info(\"";
  protected final String TEXT_351 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t\t    ";
  protected final String TEXT_352 = NL + "\t\t\t\t\twhile (fid_";
  protected final String TEXT_353 = "!=null && fid_";
  protected final String TEXT_354 = ".nextRecord()) {" + NL + "\t\t\t\t\t\trowstate_";
  protected final String TEXT_355 = ".reset();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_356 = NL + "\t\t\t    \t\t\t\t\t\t";
  protected final String TEXT_357 = " = null;\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_358 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tboolean whetherReject_";
  protected final String TEXT_359 = " = false;" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_360 = " = new ";
  protected final String TEXT_361 = "Struct();" + NL + "\t\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_362 = NL + "\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\tif(rowstate_";
  protected final String TEXT_363 = ".getException()!=null) {" + NL + "\t\t\t\t\t\t\t\t\t\t\tthrow rowstate_";
  protected final String TEXT_364 = ".getException();" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_365 = " " + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_366 = " = null; " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_367 = NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t    \t\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t        \t\t\t\t\twhetherReject_";
  protected final String TEXT_368 = " = true;" + NL + "\t\t\t        \t\t\t\t\t";
  protected final String TEXT_369 = NL + "\t\t\t            \t\t\t\t\tthrow(e);" + NL + "\t\t\t            \t\t\t\t";
  protected final String TEXT_370 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_371 = " - \" +e.getMessage());" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_372 = "                    " + NL + "\t\t\t                    \t\t\t\t";
  protected final String TEXT_373 = " = new ";
  protected final String TEXT_374 = "Struct();" + NL + "\t\t\t\t                \t\t\t\t";
  protected final String TEXT_375 = NL + "\t\t\t\t                \t\t\t\t";
  protected final String TEXT_376 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_377 = ";" + NL + "\t\t\t                \t\t\t\t\t";
  protected final String TEXT_378 = " = null;" + NL + "\t\t\t                \t\t\t\t";
  protected final String TEXT_379 = NL + "\t\t\t                \t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t                \t\t\t\t\t";
  protected final String TEXT_380 = " = null;" + NL + "\t\t\t                \t\t\t\t";
  protected final String TEXT_381 = NL + "\t\t\t            \t\t\t\t\t\t";
  protected final String TEXT_382 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_383 = ";" + NL + "\t\t\t            \t\t\t\t\t";
  protected final String TEXT_384 = NL + "\t\t\t    \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_385 = NL + "\t\t\t\t\t\t\t\t\t\t\tif(!whetherReject_";
  protected final String TEXT_386 = ") { " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_387 = "      " + NL + "\t\t\t             \t\t\t\tif(";
  protected final String TEXT_388 = " == null){ " + NL + "\t\t\t            \t \t\t\t\t";
  protected final String TEXT_389 = " = new ";
  protected final String TEXT_390 = "Struct();" + NL + "\t\t\t             \t\t\t\t}\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_391 = " " + NL + "\t\t\t\t\t\t\t\t\t} " + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_392 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_393 = " - Retrieving the record \" + fid_";
  protected final String TEXT_394 = ".getRowNumber() + \".\");" + NL + "\t\t";
  protected final String TEXT_395 = "\t\t\t\t" + NL + "\t                int dynamic_column_count_";
  protected final String TEXT_396 = "=";
  protected final String TEXT_397 = ".getColumnCount()";
  protected final String TEXT_398 = "1";
  protected final String TEXT_399 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_400 = NL + "\t\t\t\tchar fieldSeparator_";
  protected final String TEXT_401 = "_ListType[] = null;" + NL + "\t\t\t\t//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'. " + NL + "\t\t\t\tif ( ((String)";
  protected final String TEXT_402 = ").length() > 0 ){" + NL + "\t\t\t\t\tfieldSeparator_";
  protected final String TEXT_403 = "_ListType = ((String)";
  protected final String TEXT_404 = ").toCharArray();" + NL + "\t\t\t\t}else {\t\t\t" + NL + "\t\t\t\t\tthrow new IllegalArgumentException(\"Field Separator must be assigned a char.\"); " + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(";
  protected final String TEXT_405 = ".length == 1 && (\"\\015\").equals(";
  protected final String TEXT_406 = "[0])){//empty line when row separator is '\\n'" + NL + "\t\t\t\t\t";
  protected final String TEXT_407 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_408 = ".clearColumnValues();" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_409 = ".";
  protected final String TEXT_410 = " = ";
  protected final String TEXT_411 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_412 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_413 = ".";
  protected final String TEXT_414 = " = ";
  protected final String TEXT_415 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_416 = NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\t";
  protected final String TEXT_417 = NL + "\t\t\t\t\tfor(int i_";
  protected final String TEXT_418 = "=0;i_";
  protected final String TEXT_419 = "<";
  protected final String TEXT_420 = ".length;i_";
  protected final String TEXT_421 = "++){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_422 = "[i_";
  protected final String TEXT_423 = "]=";
  protected final String TEXT_424 = "[i_";
  protected final String TEXT_425 = "].trim();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_426 = NL + "\t\t\t\t\t\tString temp = \"\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_427 = NL + "\t                int columnIndexWithD_";
  protected final String TEXT_428 = " = 0; //Column Index " + NL + "\t                ";
  protected final String TEXT_429 = NL + "\t\t\t\t\t\tcolumnIndexWithD_";
  protected final String TEXT_430 = " = ";
  protected final String TEXT_431 = " + dynamic_column_count_";
  protected final String TEXT_432 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_433 = NL + "\t\t\t\t\t\tcolumnIndexWithD_";
  protected final String TEXT_434 = " = ";
  protected final String TEXT_435 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_436 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_437 = NL + "\t\t\t\t\t\tif(columnIndexWithD_";
  protected final String TEXT_438 = " < ";
  protected final String TEXT_439 = ".length){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_440 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_441 = "\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_442 = "[columnIndexWithD_";
  protected final String TEXT_443 = "]=";
  protected final String TEXT_444 = "[columnIndexWithD_";
  protected final String TEXT_445 = "].trim();\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_446 = NL + "\t\t\t\t\t\t\t\t\ttemp = ";
  protected final String TEXT_447 = "[columnIndexWithD_";
  protected final String TEXT_448 = "];" + NL + "\t\t\t\t\t\t\t\t\tif(temp.length() > 0){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_449 = ".";
  protected final String TEXT_450 = " = temp;" + NL + "\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_451 = ".";
  protected final String TEXT_452 = " = ";
  protected final String TEXT_453 = ";" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_454 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_455 = ".";
  protected final String TEXT_456 = " = ";
  protected final String TEXT_457 = "[columnIndexWithD_";
  protected final String TEXT_458 = "];" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_459 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_460 = NL + "\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_461 = "[columnIndexWithD_";
  protected final String TEXT_462 = "].length() > 0) {" + NL + "\t\t\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_463 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_464 = ".";
  protected final String TEXT_465 = " = ParserUtils.parseTo_Date(";
  protected final String TEXT_466 = "[columnIndexWithD_";
  protected final String TEXT_467 = "], ";
  protected final String TEXT_468 = ", false);" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_469 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_470 = ".";
  protected final String TEXT_471 = " = ParserUtils.parseTo_Date(";
  protected final String TEXT_472 = "[columnIndexWithD_";
  protected final String TEXT_473 = "], ";
  protected final String TEXT_474 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_475 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_476 = ".";
  protected final String TEXT_477 = " = ParserUtils.parseTo_";
  protected final String TEXT_478 = "(ParserUtils.parseTo_Number(";
  protected final String TEXT_479 = "[columnIndexWithD_";
  protected final String TEXT_480 = "], ";
  protected final String TEXT_481 = ", ";
  protected final String TEXT_482 = ")";
  protected final String TEXT_483 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_484 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_485 = ".";
  protected final String TEXT_486 = " = ParserUtils.parseTo_";
  protected final String TEXT_487 = "(ParserUtils.parseTo_Number(";
  protected final String TEXT_488 = "[columnIndexWithD_";
  protected final String TEXT_489 = "], ";
  protected final String TEXT_490 = ", ";
  protected final String TEXT_491 = "));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_492 = "\t\t\t\t\t\t\t" + NL + "\t\t    \t\t\t\t\t\t\t";
  protected final String TEXT_493 = ".";
  protected final String TEXT_494 = " = ";
  protected final String TEXT_495 = "[columnIndexWithD_";
  protected final String TEXT_496 = "].getBytes(";
  protected final String TEXT_497 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_498 = "                          ";
  protected final String TEXT_499 = NL + "                                        ";
  protected final String TEXT_500 = ".";
  protected final String TEXT_501 = " = ParserUtils.parseTo_List(";
  protected final String TEXT_502 = "[columnIndexWithD_";
  protected final String TEXT_503 = "],String.valueOf(fieldSeparator_";
  protected final String TEXT_504 = "_ListType[0]));";
  protected final String TEXT_505 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_506 = ".";
  protected final String TEXT_507 = " = ParserUtils.parseTo_";
  protected final String TEXT_508 = "(";
  protected final String TEXT_509 = "[columnIndexWithD_";
  protected final String TEXT_510 = "]";
  protected final String TEXT_511 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_512 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_513 = ".";
  protected final String TEXT_514 = " = ParserUtils.parseTo_";
  protected final String TEXT_515 = "(";
  protected final String TEXT_516 = "[columnIndexWithD_";
  protected final String TEXT_517 = "]);" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_518 = NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t} catch(java.lang.Exception ex_";
  protected final String TEXT_519 = ") {" + NL + "\t\t\t\t\t\t\t\t\t\t\trowstate_";
  protected final String TEXT_520 = ".setException(ex_";
  protected final String TEXT_521 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_522 = NL + "    \t\t\t\t\t\t\t\t\t\trowstate_";
  protected final String TEXT_523 = ".setException(new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_524 = "' in '";
  protected final String TEXT_525 = "' connection, value is invalid or this column should be nullable or have a default value.\"));" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_526 = NL + "    \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_527 = ".";
  protected final String TEXT_528 = " = ";
  protected final String TEXT_529 = ";" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_530 = NL + "    \t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_531 = NL + "\t\t\t\t\t\t\t\t    dynamic_column_count_";
  protected final String TEXT_532 = " = ";
  protected final String TEXT_533 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t\tif(dynamic_column_count_";
  protected final String TEXT_534 = " > 0) {" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_535 = ".clearColumnValues();" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\tint fieldCount = ";
  protected final String TEXT_536 = ".length;" + NL + "\t\t\t\t\t\t\t\t\tfor (int i = 0; i < dynamic_column_count_";
  protected final String TEXT_537 = "; i++) {" + NL + "\t\t\t\t\t\t\t\t\t\tif ((";
  protected final String TEXT_538 = "+i) < fieldCount) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_539 = ".addColumnValue(";
  protected final String TEXT_540 = "[";
  protected final String TEXT_541 = "+i]);" + NL + "\t\t\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_542 = ".addColumnValue(\"\");" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_543 = ".";
  protected final String TEXT_544 = " = ";
  protected final String TEXT_545 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_546 = "\t" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_547 = NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_548 = ".";
  protected final String TEXT_549 = " = ";
  protected final String TEXT_550 = ";" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_551 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_552 = NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_553 = NL + " \t\t\t\t\tint filedsum = ";
  protected final String TEXT_554 = ".length;" + NL + " \t\t\t\t\tif(filedsum < (";
  protected final String TEXT_555 = " ";
  protected final String TEXT_556 = "+ dynamic_column_count_";
  protected final String TEXT_557 = "-1";
  protected final String TEXT_558 = ")){" + NL + " \t\t\t\t\t\tthrow new java.lang.Exception(\"Column(s) missing\");" + NL + " \t\t\t\t\t} else if(filedsum > (";
  protected final String TEXT_559 = " ";
  protected final String TEXT_560 = "+ dynamic_column_count_";
  protected final String TEXT_561 = " -1";
  protected final String TEXT_562 = ")) {" + NL + " \t\t\t\t\t\tthrow new RuntimeException(\"Too many columns\");" + NL + " \t\t\t\t\t}     " + NL + "\t\t\t\t";
  protected final String TEXT_563 = NL + "    \t\t\t\t";
  protected final String TEXT_564 = ".";
  protected final String TEXT_565 = " = ";
  protected final String TEXT_566 = ".";
  protected final String TEXT_567 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_568 = NL + "\t\t\t";
  protected final String TEXT_569 = NL + "\t\t\t\t\t\t\tboolean isFirstCheckDyn_";
  protected final String TEXT_570 = " = true;" + NL + "\t\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_571 = " = new routines.system.Dynamic();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_572 = NL + "\t\t\t\tint nb_line_";
  protected final String TEXT_573 = " = 0;" + NL + "\t\t\t\tint footer_";
  protected final String TEXT_574 = " = ";
  protected final String TEXT_575 = ";" + NL + "\t\t\t\tint totalLine";
  protected final String TEXT_576 = " = 0;" + NL + "\t\t\t\tint limit";
  protected final String TEXT_577 = " = ";
  protected final String TEXT_578 = ";" + NL + "\t\t\t\tint lastLine";
  protected final String TEXT_579 = " = -1;\t" + NL + "\t\t\t\t" + NL + "\t\t\t\tchar fieldSeparator_";
  protected final String TEXT_580 = "[] = null;" + NL + "\t\t\t\t" + NL + "\t\t\t\t//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'. " + NL + "\t\t\t\tif ( ((String)";
  protected final String TEXT_581 = ").length() > 0 ){" + NL + "\t\t\t\t\tfieldSeparator_";
  protected final String TEXT_582 = " = ((String)";
  protected final String TEXT_583 = ").toCharArray();" + NL + "\t\t\t\t}else {\t\t\t" + NL + "\t\t\t\t\tthrow new IllegalArgumentException(\"Field Separator must be assigned a char.\"); " + NL + "\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t\tchar rowSeparator_";
  protected final String TEXT_584 = "[] = null;" + NL + "\t\t\t" + NL + "\t\t\t\t//support passing value (property: Row Separator) by 'context.rs' or 'globalMap.get(\"rs\")'. " + NL + "\t\t\t\tif ( ((String)";
  protected final String TEXT_585 = ").length() > 0 ){" + NL + "\t\t\t\t\trowSeparator_";
  protected final String TEXT_586 = " = ((String)";
  protected final String TEXT_587 = ").toCharArray();" + NL + "\t\t\t\t}else {" + NL + "\t\t\t\t\tthrow new IllegalArgumentException(\"Row Separator must be assigned a char.\"); " + NL + "\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t\tObject filename_";
  protected final String TEXT_588 = " = ";
  protected final String TEXT_589 = ";\t\t" + NL + "\t\t\t\tcom.talend.csv.CSVReader csvReader";
  protected final String TEXT_590 = " = null;" + NL + "\t" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_591 = NL + "\t        \t\t\tjava.util.zip.ZipInputStream zis_";
  protected final String TEXT_592 = " = null;" + NL + "\t        \t\t\ttry {" + NL + "\t\t        \t\t\tif(filename_";
  protected final String TEXT_593 = " instanceof java.io.InputStream){" + NL + "\t\t        \t\t\t\tzis_";
  protected final String TEXT_594 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream((java.io.InputStream)filename_";
  protected final String TEXT_595 = "));" + NL + "\t\t        \t\t\t}else{" + NL + "\t\t        \t\t\t\tzis_";
  protected final String TEXT_596 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_597 = "))));" + NL + "\t\t        \t\t\t}" + NL + "\t        \t\t\t} catch(java.lang.Exception e) {" + NL + "\t        \t\t\t\t";
  protected final String TEXT_598 = NL + "\t\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_599 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_600 = NL + "\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_601 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_602 = NL + "\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_603 = NL + "\t        \t\t\t}" + NL + "\t        \t\t\tjava.util.zip.ZipEntry entry_";
  protected final String TEXT_604 = " = null;" + NL + "\t\t        " + NL + "\t\t\t\t        while (true) {" + NL + "\t\t\t        \t\ttry {" + NL + "\t        \t\t\t\t\tentry_";
  protected final String TEXT_605 = " = zis_";
  protected final String TEXT_606 = ".getNextEntry();" + NL + "\t        \t\t\t\t} catch(java.lang.Exception e) {" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_607 = NL + "\t\t\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_608 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_609 = NL + "\t\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_610 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_611 = NL + "\t\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_612 = NL + "\t        \t\t\t\t}" + NL + "\t        \t\t\t\tif(entry_";
  protected final String TEXT_613 = " == null) {" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t        \t\t\t\tif(entry_";
  protected final String TEXT_614 = ".isDirectory()){ //directory" + NL + "\t        \t\t\t\t\tcontinue;" + NL + "\t        \t\t\t\t}" + NL + "\t        \t\t\t\tString[] row";
  protected final String TEXT_615 = "=null;" + NL + "\t        \t\t\t\tint currentLine";
  protected final String TEXT_616 = " = 0;" + NL + "\t        \t\t\t\tint outputLine";
  protected final String TEXT_617 = " = 0;" + NL + "\t        \t\t\t\ttry {//TD110 begin" + NL + "\t        \t\t\t\t\tcsvReader";
  protected final String TEXT_618 = "=new com.talend.csv.CSVReader(zis_";
  protected final String TEXT_619 = ", fieldSeparator_";
  protected final String TEXT_620 = "[0], ";
  protected final String TEXT_621 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_622 = NL + "\t\t\t\t\t\tString[] row";
  protected final String TEXT_623 = "=null;" + NL + "\t\t\t\t\t\tint currentLine";
  protected final String TEXT_624 = " = 0;" + NL + "\t        \t\t\tint outputLine";
  protected final String TEXT_625 = " = 0;" + NL + "\t\t\t\t\t\ttry {//TD110 begin" + NL + "\t\t\t\t\t\t\tif(filename_";
  protected final String TEXT_626 = " instanceof java.io.InputStream){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_627 = NL + "\t\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_628 = "=new com.talend.csv.CSVReader((java.io.InputStream)filename_";
  protected final String TEXT_629 = ", fieldSeparator_";
  protected final String TEXT_630 = "[0], ";
  protected final String TEXT_631 = ");" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_632 = "=new com.talend.csv.CSVReader(new java.io.BufferedReader(new java.io.InputStreamReader(" + NL + "\t\t                \t\tnew java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_633 = ")),";
  protected final String TEXT_634 = ")), fieldSeparator_";
  protected final String TEXT_635 = "[0]);" + NL + "\t\t        \t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_636 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tcsvReader";
  protected final String TEXT_637 = ".setTrimWhitespace(false);" + NL + "\t\t\t\t\tif ( (rowSeparator_";
  protected final String TEXT_638 = "[0] != '\\n') && (rowSeparator_";
  protected final String TEXT_639 = "[0] != '\\r') )" + NL + "\t        \t\t\tcsvReader";
  protected final String TEXT_640 = ".setLineEnd(\"\"+rowSeparator_";
  protected final String TEXT_641 = "[0]);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_642 = NL + "\t        \t\t\t\tcsvReader";
  protected final String TEXT_643 = ".setQuoteChar('";
  protected final String TEXT_644 = "');" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_645 = NL + "\t\t\t\t\t\t\tString textEnclosure1_";
  protected final String TEXT_646 = " = ";
  protected final String TEXT_647 = "; " + NL + "\t\t\t\t\t\t\tchar textEnclosure_";
  protected final String TEXT_648 = "[] = null;" + NL + "\t\t\t        " + NL + "\t    \t\t\t\t    if(((String)textEnclosure1_";
  protected final String TEXT_649 = ").length() > 0 ){ " + NL + "\t  \t\t\t\t\t\t\ttextEnclosure_";
  protected final String TEXT_650 = " = ((String)textEnclosure1_";
  protected final String TEXT_651 = ").toCharArray(); " + NL + "\t\t\t\t\t\t\t}else { " + NL + "\t            \t\t\t\tthrow new IllegalArgumentException(\"Text Enclosure must be assigned a char.\"); " + NL + "\t        \t\t\t\t}" + NL + "\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_652 = ".setQuoteChar(textEnclosure_";
  protected final String TEXT_653 = "[0]); " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_654 = NL + "\t            \t\t\t\tcsvReader";
  protected final String TEXT_655 = ".setEscapeChar('\\\\');" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_656 = NL + "\t            \t\t\t\tcsvReader";
  protected final String TEXT_657 = ".setEscapeChar(csvReader";
  protected final String TEXT_658 = ".getQuoteChar());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_659 = NL + "\t            \t\t\t\t//?????doesn't work for other escapeChar" + NL + "\t            \t\t\t\t//the default escape mode is double escape" + NL + "\t            \t\t\t\tcsvReader";
  protected final String TEXT_660 = ".setEscapeChar(csvReader";
  protected final String TEXT_661 = ".getQuoteChar());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_662 = " " + NL + "\t\t        \t\t\tString escapeChar1_";
  protected final String TEXT_663 = " = ";
  protected final String TEXT_664 = ";          " + NL + "\t\t        \t\t\tchar escapeChar_";
  protected final String TEXT_665 = "[] = null;" + NL + "\t\t\t        " + NL + "\t\t\t\t\t        if(((String)escapeChar1_";
  protected final String TEXT_666 = ").length() > 0 ){ " + NL + "\t\t\t\t\t        \tescapeChar_";
  protected final String TEXT_667 = " = ((String)escapeChar1_";
  protected final String TEXT_668 = ").toCharArray(); " + NL + "\t\t\t\t\t  \t\t}else { " + NL + "\t\t        \t\t\t    throw new IllegalArgumentException(\"Escape Char must be assigned a char.\"); " + NL + "\t\t        \t\t\t}" + NL + "\t\t       \t\t\t\tif(escapeChar_";
  protected final String TEXT_669 = "[0] == '\\\\'){" + NL + "\t\t       \t\t\t\t\tcsvReader";
  protected final String TEXT_670 = ".setEscapeChar('\\\\');" + NL + "\t\t       \t\t\t\t}else if(escapeChar_";
  protected final String TEXT_671 = "[0] ==";
  protected final String TEXT_672 = "'";
  protected final String TEXT_673 = "'";
  protected final String TEXT_674 = "textEnclosure_";
  protected final String TEXT_675 = "[0]";
  protected final String TEXT_676 = "){" + NL + "\t\t       \t\t\t\t\tcsvReader";
  protected final String TEXT_677 = ".setEscapeChar(csvReader";
  protected final String TEXT_678 = ".getQuoteChar());" + NL + "\t\t       \t\t\t\t} else {" + NL + "\t\t       \t\t\t\t\t//the default escape mode is double escape" + NL + "\t\t       \t\t\t\t\tcsvReader";
  protected final String TEXT_679 = ".setEscapeChar(csvReader";
  protected final String TEXT_680 = ".getQuoteChar());" + NL + "\t\t       \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_681 = "      " + NL + "\t\t" + NL + "\t\t\t" + NL + "\t\t\t\t\t\tif(footer_";
  protected final String TEXT_682 = " > 0){" + NL + "\t\t\t\t\t\tfor(totalLine";
  protected final String TEXT_683 = "=0;totalLine";
  protected final String TEXT_684 = " < ";
  protected final String TEXT_685 = "; totalLine";
  protected final String TEXT_686 = "++){" + NL + "\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_687 = ".readNext();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tcsvReader";
  protected final String TEXT_688 = ".setSkipEmptyRecords(";
  protected final String TEXT_689 = ");" + NL + "\t\t\t            while (csvReader";
  protected final String TEXT_690 = ".readNext()) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_691 = NL + "\t\t\t\t\t\t\t\trow";
  protected final String TEXT_692 = "=csvReader";
  protected final String TEXT_693 = ".getValues();" + NL + "\t\t\t\t\t\t\t\tif(!(row";
  protected final String TEXT_694 = ".length == 1 && (\"\\015\").equals(row";
  protected final String TEXT_695 = "[0]))){//empty line when row separator is '\\n'" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_696 = NL + "\t                " + NL + "\t                \t\ttotalLine";
  protected final String TEXT_697 = "++;" + NL + "\t                " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_698 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_699 = NL + "\t                " + NL + "\t\t\t            }" + NL + "\t            \t\tint lastLineTemp";
  protected final String TEXT_700 = " = totalLine";
  protected final String TEXT_701 = " - footer_";
  protected final String TEXT_702 = "   < 0? 0 : totalLine";
  protected final String TEXT_703 = " - footer_";
  protected final String TEXT_704 = " ;" + NL + "\t            \t\tif(lastLine";
  protected final String TEXT_705 = " > 0){" + NL + "\t                \t\tlastLine";
  protected final String TEXT_706 = " = lastLine";
  protected final String TEXT_707 = " < lastLineTemp";
  protected final String TEXT_708 = " ? lastLine";
  protected final String TEXT_709 = " : lastLineTemp";
  protected final String TEXT_710 = "; " + NL + "\t            \t\t}else {" + NL + "\t                \t\tlastLine";
  protected final String TEXT_711 = " = lastLineTemp";
  protected final String TEXT_712 = ";" + NL + "\t            \t\t}" + NL + "\t         " + NL + "\t\t\t          \tcsvReader";
  protected final String TEXT_713 = ".close();" + NL + "\t\t\t\t        if(filename_";
  protected final String TEXT_714 = " instanceof java.io.InputStream){" + NL + "\t\t\t\t \t\t\tcsvReader";
  protected final String TEXT_715 = "=new com.talend.csv.CSVReader((java.io.InputStream)filename_";
  protected final String TEXT_716 = ", fieldSeparator_";
  protected final String TEXT_717 = "[0], ";
  protected final String TEXT_718 = ");" + NL + "\t\t        \t\t}else{" + NL + "\t\t\t\t \t\t\tcsvReader";
  protected final String TEXT_719 = "=new com.talend.csv.CSVReader(new java.io.BufferedReader(new java.io.InputStreamReader(" + NL + "\t\t\t\t          \tnew java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_720 = ")),";
  protected final String TEXT_721 = ")), fieldSeparator_";
  protected final String TEXT_722 = "[0]);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tcsvReader";
  protected final String TEXT_723 = ".setTrimWhitespace(false);" + NL + "\t\t\t\t\t\tif ( (rowSeparator_";
  protected final String TEXT_724 = "[0] != '\\n') && (rowSeparator_";
  protected final String TEXT_725 = "[0] != '\\r') )\t" + NL + "\t        \t\t\t\tcsvReader";
  protected final String TEXT_726 = ".setLineEnd(\"\"+rowSeparator_";
  protected final String TEXT_727 = "[0]);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_728 = NL + "\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_729 = ".setQuoteChar('";
  protected final String TEXT_730 = "');" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_731 = NL + "\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_732 = ".setQuoteChar(textEnclosure_";
  protected final String TEXT_733 = "[0]);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_734 = NL + "\t        \t\t\t\tcsvReader";
  protected final String TEXT_735 = ".setEscapeChar('\\\\');" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_736 = NL + "\t        \t\t\t\tcsvReader";
  protected final String TEXT_737 = ".setEscapeChar(csvReader";
  protected final String TEXT_738 = ".getQuoteChar());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_739 = NL + "\t        \t\t\t\t//?????doesn't work for other escapeChar" + NL + "\t        \t\t\t\t//the default escape mode is double escape" + NL + "\t        \t\t\t\tcsvReader";
  protected final String TEXT_740 = ".setEscapeChar(csvReader";
  protected final String TEXT_741 = ".getQuoteChar());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_742 = " " + NL + "\t       \t\t\t\t\tif(escapeChar_";
  protected final String TEXT_743 = "[0] == '\\\\'){" + NL + "\t       \t\t\t\t\t\tcsvReader";
  protected final String TEXT_744 = ".setEscapeChar('\\\\');" + NL + "\t       \t\t\t\t\t}else if(escapeChar_";
  protected final String TEXT_745 = "[0] == ";
  protected final String TEXT_746 = "'";
  protected final String TEXT_747 = "'";
  protected final String TEXT_748 = "textEnclosure_";
  protected final String TEXT_749 = "[0]";
  protected final String TEXT_750 = "){" + NL + "\t       \t\t\t\t\t\tcsvReader";
  protected final String TEXT_751 = ".setEscapeChar(csvReader";
  protected final String TEXT_752 = ".getQuoteChar());" + NL + "\t       \t\t\t\t\t} else {" + NL + "\t       \t\t\t\t\t\t//the default escape mode is double escape" + NL + "\t        \t\t\t\t\tcsvReader";
  protected final String TEXT_753 = ".setEscapeChar(csvReader";
  protected final String TEXT_754 = ".getQuoteChar());" + NL + "\t       \t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_755 = "  " + NL + "\t        \t\t}" + NL + "\t        " + NL + "\t\t\t        if(limit";
  protected final String TEXT_756 = " != 0){" + NL + "\t\t\t        \tfor(currentLine";
  protected final String TEXT_757 = "=0;currentLine";
  protected final String TEXT_758 = " < ";
  protected final String TEXT_759 = ";currentLine";
  protected final String TEXT_760 = "++){" + NL + "\t\t\t        \t\tcsvReader";
  protected final String TEXT_761 = ".readNext();" + NL + "\t\t\t        \t}" + NL + "\t\t\t        }" + NL + "\t\t\t        csvReader";
  protected final String TEXT_762 = ".setSkipEmptyRecords(";
  protected final String TEXT_763 = ");" + NL + "\t        " + NL + "\t    \t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_764 = NL + "\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t";
  protected final String TEXT_765 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_766 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_767 = " - \" +e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_768 = NL + "\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_769 = NL + "\t    \t\t}//TD110 end" + NL + "\t        " + NL + "\t\t\t    ";
  protected final String TEXT_770 = NL + "\t\t\t    \tlog.info(\"";
  protected final String TEXT_771 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t    ";
  protected final String TEXT_772 = NL + "\t        \twhile ( limit";
  protected final String TEXT_773 = " != 0 && csvReader";
  protected final String TEXT_774 = "!=null && csvReader";
  protected final String TEXT_775 = ".readNext() ) { " + NL + "\t        \t\trowstate_";
  protected final String TEXT_776 = ".reset();" + NL + "\t        " + NL + "\t\t        \trow";
  protected final String TEXT_777 = "=csvReader";
  protected final String TEXT_778 = ".getValues();" + NL + "\t        \t" + NL + "\t\t\t\t\t";
  protected final String TEXT_779 = NL + "\t        \t\t\tif(row";
  protected final String TEXT_780 = ".length == 1 && (\"\\015\").equals(row";
  protected final String TEXT_781 = "[0])){//empty line when row separator is '\\n'" + NL + "\t        \t\t\t\tcontinue;" + NL + "\t        \t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_782 = NL + "\t        \t" + NL + "\t        \t" + NL + "\t        \t\tcurrentLine";
  protected final String TEXT_783 = "++;" + NL + "\t            " + NL + "\t\t            if(lastLine";
  protected final String TEXT_784 = " > -1 && currentLine";
  protected final String TEXT_785 = " > lastLine";
  protected final String TEXT_786 = ") {" + NL + "\t\t                break;" + NL + "\t    \t        }" + NL + "\t        \t    outputLine";
  protected final String TEXT_787 = "++;" + NL + "\t            \tif (limit";
  protected final String TEXT_788 = " > 0 && outputLine";
  protected final String TEXT_789 = " > limit";
  protected final String TEXT_790 = ") {" + NL + "\t                \tbreak;" + NL + "\t            \t}  " + NL + "\t                                                                      " + NL + "\t\t\t\t\t";
  protected final String TEXT_791 = NL + "\t    \t\t\t\t\t\t\t";
  protected final String TEXT_792 = " = null;\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_793 = NL + "\t\t\t\t\t\t\t\tboolean whetherReject_";
  protected final String TEXT_794 = " = false;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_795 = " = new ";
  protected final String TEXT_796 = "Struct();" + NL + "\t\t\t\t\t\t\t\ttry {\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_797 = NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tif(rowstate_";
  protected final String TEXT_798 = ".getException()!=null) {" + NL + "\t\t\t\t\t\t\t\t\t\tthrow rowstate_";
  protected final String TEXT_799 = ".getException();" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_800 = " " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_801 = " = null; " + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_802 = NL + "\t    \t\t\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\t\t\t        whetherReject_";
  protected final String TEXT_803 = " = true;" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_804 = NL + "            \t\t\t\t\t\t\tthrow(e);" + NL + "            \t\t\t\t\t\t";
  protected final String TEXT_805 = NL + "\t\t\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_806 = " - \" +e.getMessage());" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_807 = NL + "\t\t\t\t\t\t                    ";
  protected final String TEXT_808 = " = new ";
  protected final String TEXT_809 = "Struct();" + NL + "                \t\t\t\t\t\t\t";
  protected final String TEXT_810 = NL + "                \t\t\t\t\t\t\t";
  protected final String TEXT_811 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_812 = ";" + NL + "                \t\t\t\t\t\t\t";
  protected final String TEXT_813 = " = null;" + NL + "                \t\t\t\t\t\t";
  protected final String TEXT_814 = NL + "                \t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "                \t\t\t\t\t\t\t";
  protected final String TEXT_815 = " = null;" + NL + "                \t\t\t\t\t\t";
  protected final String TEXT_816 = NL + "            \t\t\t\t\t\t\t\t";
  protected final String TEXT_817 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_818 = ";" + NL + "            \t\t\t\t\t\t\t";
  protected final String TEXT_819 = NL + "\t    \t\t\t\t\t\t}" + NL + "\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_820 = NL + "\t\t\t\t\t\t\t\t\t\tif(!whetherReject_";
  protected final String TEXT_821 = ") { " + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_822 = "      " + NL + "\t             \t\t\t\t\tif(";
  protected final String TEXT_823 = " == null){ " + NL + "\t            \t \t\t\t\t\t";
  protected final String TEXT_824 = " = new ";
  protected final String TEXT_825 = "Struct();" + NL + "\t             \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_826 = " " + NL + "\t\t\t\t\t\t\t\t} " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_827 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_828 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_829 = "+1) + \".\");" + NL + "\t\t";
  protected final String TEXT_830 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
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
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_7);
    
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
		
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_13);
    
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
		
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_17);
    
			}else{
				codeForConnToConn(node, C2CMetadata, C2CSourceConnName, C2CTargetConnName, 0, columnListSize);
			}
		}
		
		
		public void generateClass(){
		  	if(isOptimizeCode){
				cid = node.getUniqueName();
				int methodNum=(columnListSize%schemaOptNum==0?columnListSize/schemaOptNum:(columnListSize/schemaOptNum)+1);
				
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
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
					
    stringBuffer.append(TEXT_20);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(V2CSourceValueClass);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_26);
    codeForValueToConn(node, V2CMetadata, V2CSourceValueClass, V2CSourceValueName, V2CTargetConnName, start, end);
    stringBuffer.append(TEXT_27);
    	
					}
					if(useV2CWithD){
					
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(V2CWithDSourceValueClass);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_35);
    this.isBehindDynamic = codeForValueToConnWithD(node, V2CWithDMetadata, V2CWithDSourceValueClass, V2CWithDSourceValueName, V2CWithDTargetConnName, V2CWithDDynamicName, start, end);
    stringBuffer.append(TEXT_36);
    		
					}
					if(useC2C){
					
    stringBuffer.append(TEXT_37);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_42);
    codeForConnToConn(node, C2CMetadata, C2CSourceConnName, C2CTargetConnName, start, end);
    stringBuffer.append(TEXT_43);
    
					}
				}
				if(useV2C){//Call all split methods in one method
				
    stringBuffer.append(TEXT_44);
    stringBuffer.append(V2CSourceValueClass);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_49);
    	
				}
				if(useV2CWithD){
				
    stringBuffer.append(TEXT_50);
    stringBuffer.append(V2CWithDSourceValueClass);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append((parmsStr!=null?parmsStr.toString():""));
    stringBuffer.append(TEXT_56);
    
				}
				for(int i=0;i<methodNum;i++){
					if(useV2C){
					
    stringBuffer.append(TEXT_57);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_61);
    
					}
					if(useV2CWithD){
					
    stringBuffer.append(TEXT_62);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append((varsStr!=null?varsStr.toString():""));
    stringBuffer.append(TEXT_67);
    
					}
				}
				if(useV2C || useV2CWithD){
				
    stringBuffer.append(TEXT_68);
    
				}
				if(useC2C){
				
    stringBuffer.append(TEXT_69);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_73);
    
					for(int i=0;i<methodNum;i++){
						if(useC2C){
						
    stringBuffer.append(TEXT_74);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_77);
    
						}
					}
					
    stringBuffer.append(TEXT_78);
    
				}
				
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
		  	}
		}
	}
	
    stringBuffer.append(TEXT_83);
    
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
			
    stringBuffer.append(TEXT_84);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_85);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_86);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_89);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_92);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_95);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_100);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_102);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_103);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_106);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_109);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_112);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    final String cid = node.getUniqueName();	
	
	String projectName = codeGenArgument.getCurrentProjectName();
	String jobName = codeGenArgument.getJobName();
	String jobVersion = codeGenArgument.getJobVersion();
	
	String tempDir = ElementParameterParser.getValue(node, "__TEMP_DIR__");
	
	String vcid = "";
	IProcess process = node.getProcess();
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));
	
	String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
	if(destination!=null && !"".equals(destination)){
		vcid = destination;
	}
	int dynamic_index = -1;
	boolean hasDynamic = false;
	List<IMetadataColumn> columnList = null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = null;
	int sizeListColumns = 0;
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
		if (metadata!=null) {
			columnList = metadata.getListColumns();
			sizeListColumns = columnList.size();
		}
	}
	for(int i=0; columnList!=null && i< columnList.size(); i++) {
        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
            dynamic_index = i+1;
            hasDynamic = true;
            break;
        }
	}
	int schemaOptNum=100;
	String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
	if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
		schemaOptNum  = Integer.parseInt(schemaOptNumStr);
	}
		
		
	class GenerateCode{
		public int dynamic_index = -1;
		public int colLen = 0; // the length of the column in the input schema
		public void generateDynamicSchemaCode(boolean isCsv){
		
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    
				if(isCsv){
				
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
				}else{
				
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    
				}
				
    stringBuffer.append(TEXT_121);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(colLen-dynamic_index);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    if(isCsv){
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    }else{
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    
		}
		public void checkFooterAndRandom(String footer,String random){
		
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(random );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    
		}
		
		public void checkFooter(String footer){
		
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    	
		}
	}
	GenerateCode generateCode = new GenerateCode();
	
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
	if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		final String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
		class RowUtil extends DefaultRowUtil{
			public void codeForValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int start , int end){
				codeForValueToConnWithD(node, metadata, sourceValueClass, sourceValueName, targetConnName, null, start ,end);
			}
			public boolean codeForValueToConnWithD(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, String dynamicName, int start , int end){
				cid = node.getUniqueName();
				String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
				
				List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
				String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
				boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;
				
				List<Map<String, String>> decodeClns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DECODE_COLS__");
				boolean isEnableDecode = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_DECODE__"));
				
				String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
				boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
				
				String checkNumStr = ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__");
				boolean checkNum = (checkNumStr!=null&&!("").equals(checkNumStr))?("true").equals(checkNumStr):false; 
				
				String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
				boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
				String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
				String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
				
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int sizeListColumns = listColumns.size();
				boolean noStringTypeExist = false;
				int dynamic_index = -1;
				if(metadata.isDynamicSchema()){
				
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    if(this.isBehindDynamic){
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_160);
    }else{
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    
				}
				
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
					}else{
						noStringTypeExist = true;
						break;
					}
				}
				boolean hasStringDefault = false;
				for (int valueM=0; valueM<sizeListColumns; valueM++) {
					IMetadataColumn column = listColumns.get(valueM);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
						if(hasStringDefault==false && column.getDefault()!=null && column.getDefault().length() > 0 ){
							hasStringDefault = true;
							break;
						}
					}
				}
				if(noStringTypeExist || hasStringDefault){
				
    stringBuffer.append(TEXT_165);
    
				}
				String isDecodeNumber = "false";
				for (int valueN=start; valueN<end; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					
					if (decodeClns != null && decodeClns.size() > valueN) { // to avoid the wizard doesn't initialize the table
						isDecodeNumber = ("true").equals(decodeClns.get(valueN).get("DECODE"))?"true":"false";
					}
					if(metadata.isDynamicSchema()){
					
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(valueN-1);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
					}else{
					
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_172);
    
					}
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
						String defaultValue = column.getDefault();
						if(defaultValue!=null && defaultValue.length()>0){
						
    stringBuffer.append(TEXT_173);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_181);
    
						}else{
						
    stringBuffer.append(TEXT_182);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_187);
    
						}
					}else if(column.getTalendType().equals("id_Dynamic")){
						this.isBehindDynamic=true;
						dynamic_index = valueN;
					
    stringBuffer.append(TEXT_188);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_197);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_202);
    
					}else{
						
					
    stringBuffer.append(TEXT_203);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_206);
    
							if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
								//do nothing
							} else {
								
    stringBuffer.append(TEXT_207);
    
    							if(javaType == JavaTypesManager.BYTE_ARRAY){ 
    							
    stringBuffer.append(TEXT_208);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_211);
    
    							} else if(javaType == JavaTypesManager.LIST){ 
                                
    stringBuffer.append(TEXT_212);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_214);
    stringBuffer.append( fieldSeparator );
    stringBuffer.append(TEXT_215);
    
    							}else if(javaType == JavaTypesManager.DATE) { 
    								if(checkNum || checkDate){
    								
    stringBuffer.append(TEXT_216);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_219);
    
    								}else{
    								
    stringBuffer.append(TEXT_220);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_222);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_223);
    
    								}
    							}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
    								if (JavaTypesManager.isNumberIntType(javaType)) {
    							
    stringBuffer.append(TEXT_224);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_226);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_227);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_228);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(isEnableDecode?","+isDecodeNumber:"");
    stringBuffer.append(TEXT_230);
    
    								} else {
    							
    stringBuffer.append(TEXT_231);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_233);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_234);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_235);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_236);
    
    								}
    							} else if (JavaTypesManager.isNumberIntType(javaType)) {
    							
    stringBuffer.append(TEXT_237);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_239);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(isEnableDecode?","+isDecodeNumber:"");
    stringBuffer.append(TEXT_241);
    
    							} else { 
    							
    stringBuffer.append(TEXT_242);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_244);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_245);
    
    							}
    							
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    
							}
							
    stringBuffer.append(TEXT_250);
    
							String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
							boolean isJavaPrimitiveType = JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable());
							if((isJavaPrimitiveType && (column.getDefault()==null || column.getDefault().length() == 0)) || defaultValue == null) {
							
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_254);
    
							} else {
							
    stringBuffer.append(TEXT_255);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_258);
    
							}
							
    stringBuffer.append(TEXT_259);
    
					}
					
    stringBuffer.append(TEXT_260);
    }
				
    stringBuffer.append(TEXT_261);
    if(checkNum) {
    stringBuffer.append(TEXT_262);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_264);
    if(metadata.isDynamicSchema()){
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    }
    stringBuffer.append(TEXT_267);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_268);
    if(metadata.isDynamicSchema()){
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    }
    stringBuffer.append(TEXT_271);
    
				}
				return this.isBehindDynamic;
			}
			
			public void codeForConnToConn(INode node, IMetadataTable metadata, String sourceConnName, String targetConnName, int start , int end){
    			for(int colNum=start;colNum<end;colNum++) {
    				IMetadataColumn column=metadata.getListColumns().get(colNum);
    			
    stringBuffer.append(TEXT_272);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_274);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_276);
    
				}
				
    stringBuffer.append(TEXT_277);
    
			}
		}//class defined end

		if ((metadatas!=null)&&(metadatas.size()>0)) {
			if (metadata!=null) {
				String filename = ElementParameterParser.getValue(node,"__FILENAME__");
				
				if(!("".equals(vcid))) {
					filename = "\"/"+filename.substring(1, filename.length()-1)+vcid+"_"+projectName+"_"+jobName+"_"+jobVersion+"\"";
					filename = tempDir+"+"+filename;
				}
				
		    	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		    	String header = ElementParameterParser.getValue(node, "__HEADER__");
		    	if(("").equals(header)){
		    		header="0";
		    	}
		    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
				if(("").equals(limit)){
					limit = "-1";
				}
		    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
				boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));
		    	if(("").equals(footer) || uncompress){
		    		footer="0";
		    	}
		    	String random = "-1";
		    	String ran = ElementParameterParser.getValue(node, "__RANDOM__");
		    	if(("true").equals(ran)){
		    		random = ElementParameterParser.getValue(node, "__NB_RANDOM__");
		    		if(("").equals(random)){
		    			random="0";
		    		}
		    	}
		    	if(uncompress){
		    		random="-1";
		    	}
				
		    	String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
		    	String removeEmptyRowFlag =  ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
		    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
				boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false; 
				
				String splitRecordStr = ElementParameterParser.getValue(node, "__SPLITRECORD__");
				boolean splitRecord = (splitRecordStr!=null&&!("").equals(splitRecordStr))?("true").equals(splitRecordStr):false;
				
				//find main & reject conns;
				List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
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
			    String firstConnName = "";
				if (conns!=null) {
					if (conns.size()>0) {
						IConnection conn = conns.get(0);
						if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
							firstConnName = conn.getName();
						}
					}
				}			    
				
				RowUtil rowUtil = new RowUtil(); 
				if (conns!=null) {
				    if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
						if(hasDynamic){
							rowUtil.prepareValueToConnWithD(node, metadata, "org.talend.fileprocess.FileInputDelimited", "fid_"+cid, firstConnName, "dynamic_"+cid, schemaOptNum);
							
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    
						}else{
							rowUtil.prepareValueToConn(node, metadata, "org.talend.fileprocess.FileInputDelimited", "fid_"+cid, firstConnName, schemaOptNum);
						}
						if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
							rowUtil.prepareConnToConn(metadata, firstConnName, rejectConnName);
						}
						rowUtil.generateClass();
					}
				}
				
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    
					if(uncompress){
					
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
     if(dieOnError) {
    stringBuffer.append(TEXT_293);
     } else { 
    stringBuffer.append(TEXT_294);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    }
    stringBuffer.append(TEXT_297);
     } 
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
     if(dieOnError) {
    stringBuffer.append(TEXT_302);
     } else { 
    stringBuffer.append(TEXT_303);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    }
    stringBuffer.append(TEXT_306);
     } 
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(removeEmptyRowFlag );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(header );
    stringBuffer.append(hasDynamic?"-1":"");
    stringBuffer.append(TEXT_316);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(random );
    stringBuffer.append(TEXT_319);
    stringBuffer.append( splitRecord);
    stringBuffer.append(TEXT_320);
     if(dieOnError) {
    stringBuffer.append(TEXT_321);
     } else { 
    stringBuffer.append(TEXT_322);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    }
    stringBuffer.append(TEXT_325);
     } 
    stringBuffer.append(TEXT_326);
    
					}else{
					
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    
									generateCode.checkFooterAndRandom(footer,random);
							
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(removeEmptyRowFlag );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(header );
    stringBuffer.append(hasDynamic?"-1":"");
    stringBuffer.append(TEXT_338);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(random );
    stringBuffer.append(TEXT_341);
    stringBuffer.append( splitRecord);
    stringBuffer.append(TEXT_342);
     if(dieOnError) {
    stringBuffer.append(TEXT_343);
     } else { 
    stringBuffer.append(TEXT_344);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    }
    stringBuffer.append(TEXT_347);
     } 
    stringBuffer.append(TEXT_348);
    
					}
					
    stringBuffer.append(TEXT_349);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    }
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    
				    	if (conns!=null) {
				    		if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
				    			for (int i=0;i<conns.size();i++) {
				    				IConnection connTemp = conns.get(i);
				    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
									
    stringBuffer.append(TEXT_356);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_357);
    
				    				}
				    			}
				    	
								IConnection conn = conns.get(0);
								if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
								
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_361);
    
										if(hasDynamic){// generate the dynamic schema code
											generateCode.colLen = sizeListColumns;
											generateCode.dynamic_index = dynamic_index;
											generateCode.generateDynamicSchemaCode(false); //false: delimited mode
											rowUtil.callValueToConnWithD("fid_"+cid, firstConnName, "dynamic_"+cid);
										}else{
											rowUtil.callValueToConn("fid_"+cid, firstConnName);
										}
										
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    
										
										if(rejectConnName.equals(firstConnName)) {
										
    stringBuffer.append(TEXT_365);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_366);
    
										}
										
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    
			        					if (dieOnError) {
			            				
    stringBuffer.append(TEXT_369);
    
			        					} else {
											if(isLog4jEnabled){
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    }
			            					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
							                
    stringBuffer.append(TEXT_372);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_374);
    rowUtil.callConnToConn(firstConnName, rejectConnName);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_378);
    
			            					} else if(("").equals(rejectConnName)){
			                				
    stringBuffer.append(TEXT_379);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_380);
    
			            					} else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_381);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_383);
    
									}
			        					} 
			        					
    stringBuffer.append(TEXT_384);
    
								}
							}
							if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {//no use code, we can link only one main line now.
								boolean isFirstEnter = true;
								for (int i=0;i<conns.size();i++) {
									IConnection conn = conns.get(i);
									if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
									
										if(isFirstEnter) {
										
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    isFirstEnter = false; 
										}
										
    stringBuffer.append(TEXT_387);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_390);
    
						    	 		rowUtil.callConnToConn(firstConnName, conn.getName());
									}
								}
								 
								if(!isFirstEnter) {
								
    stringBuffer.append(TEXT_391);
    
								}
								
							}
				  		}
			}
		}
		if(isLog4jEnabled){
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    }

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}else{//the following is the tFileInputCSV component
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		final String delim1 = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
		class RowUtil extends DefaultRowUtil{
			public void codeForValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int start , int end){
				codeForValueToConnWithD(node, metadata, sourceValueClass, sourceValueName, targetConnName, null, start ,end);
			}
			public boolean codeForValueToConnWithD(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, String dynamicName, int start , int end){
				cid = node.getUniqueName();
				String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
				
				List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
				String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
				boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;
				
				List<Map<String, String>> decodeClns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DECODE_COLS__");
				boolean isEnableDecode = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_DECODE__"));
				
				String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
				boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
				
				String checkNumStr = ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__");
				boolean checkNum = (checkNumStr!=null&&!("").equals(checkNumStr))?("true").equals(checkNumStr):false; 
				
				String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
				boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
				String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
				String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
				
				List<IMetadataColumn> columns=metadata.getListColumns();
				int columnSize = columns.size();
				if(metadata.isDynamicSchema()){
				
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    if(this.isBehindDynamic){
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_397);
    }else{
    stringBuffer.append(TEXT_398);
    }
    stringBuffer.append(TEXT_399);
    
				}
				
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    
					for(int colNo=start;colNo<end;colNo++) {
						IMetadataColumn column1 =metadata.getListColumns().get(colNo);
						if("id_Dynamic".equals(column1.getTalendType())) {
					
    stringBuffer.append(TEXT_407);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(column1.getLabel() );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_411);
    
						} else {
					
    stringBuffer.append(TEXT_412);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(column1.getLabel() );
    stringBuffer.append(TEXT_414);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaIdType(column1.getTalendType(), column1.isNullable()));
    stringBuffer.append(TEXT_415);
    
						}
					}
					
    stringBuffer.append(TEXT_416);
    if(isTrimAll){
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    
					}
					boolean hasStringDefault = false;
					for (int valueM=0; valueM<columnSize; valueM++) {
						IMetadataColumn column = columns.get(valueM);
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
							if(hasStringDefault==false && column.getDefault()!=null && column.getDefault().length() > 0 ){
								hasStringDefault = true;
								break;
							}
						}
					}
					
					if(hasStringDefault==true){
					
    stringBuffer.append(TEXT_426);
    
					}
					int dynamic_index = 1;
	                
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    
	                String isDecodeNumber = "false";
					for (int i=start;i<end;i++) {
						IMetadataColumn column=columns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if (decodeClns !=null && decodeClns.size() > i) { 
							isDecodeNumber = ("true").equals(decodeClns.get(i).get("DECODE"))?"true":"false";
						}
						if(metadata.isDynamicSchema()){
						
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    
						}else{
						
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_435);
    
						}
						
    stringBuffer.append(TEXT_436);
    if(!"id_Dynamic".equals(column.getTalendType())) {
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_439);
    }
    stringBuffer.append(TEXT_440);
    if((!isTrimAll && (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))){
    stringBuffer.append(TEXT_441);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    
							}
							if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
								String defaultValue = column.getDefault();
								if(defaultValue!=null && defaultValue.length()>0){
								
    stringBuffer.append(TEXT_446);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_453);
    
								}else{
								
    stringBuffer.append(TEXT_454);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_456);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    
								}
							} else {
							
    stringBuffer.append(TEXT_459);
    if(!"id_Dynamic".equals(column.getTalendType())) {
    stringBuffer.append(TEXT_460);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    
									if(javaType == JavaTypesManager.DATE) {
										if(checkNum || checkDate){
										
    stringBuffer.append(TEXT_463);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_465);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_468);
    
										}else{
										
    stringBuffer.append(TEXT_469);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_471);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_474);
    
										}
									} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) {
										if (JavaTypesManager.isNumberIntType(javaType)) {
									
    stringBuffer.append(TEXT_475);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_477);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_481);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(isEnableDecode?","+isDecodeNumber:"");
    stringBuffer.append(TEXT_483);
    
										} else {
									
    stringBuffer.append(TEXT_484);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_486);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_490);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_491);
    
										}
									}else if(javaType == JavaTypesManager.BYTE_ARRAY){ 
									
    stringBuffer.append(TEXT_492);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_494);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_497);
    
									}else if(javaType == JavaTypesManager.LIST){ 
                                    
    stringBuffer.append(TEXT_498);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_500);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_504);
    
									}else if (JavaTypesManager.isNumberIntType(javaType)) {
									
    stringBuffer.append(TEXT_505);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_507);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_508);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(isEnableDecode?","+isDecodeNumber:"");
    stringBuffer.append(TEXT_511);
    
									}else {
									
    stringBuffer.append(TEXT_512);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_514);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_515);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    
									}
									
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    
    									String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
    									boolean isJavaPrimitiveType = JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable());
    									if((isJavaPrimitiveType && (column.getDefault()==null || column.getDefault().length() == 0))) {
    									
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_524);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_525);
    
    									} else {
    									
    stringBuffer.append(TEXT_526);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_529);
    
    									}
    									
    stringBuffer.append(TEXT_530);
    
								} else {
									this.isBehindDynamic=true;
									dynamic_index = i;
								
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_544);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_545);
    
								}
							}
							
    stringBuffer.append(TEXT_546);
    if(!"id_Dynamic".equals(column.getTalendType())) {
    stringBuffer.append(TEXT_547);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_548);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_549);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault()) );
    stringBuffer.append(TEXT_550);
    }
    stringBuffer.append(TEXT_551);
    
					}
					
    stringBuffer.append(TEXT_552);
    if(checkNum) {
    stringBuffer.append(TEXT_553);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_555);
    if(metadata.isDynamicSchema()){
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    }
    stringBuffer.append(TEXT_558);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_559);
    if(metadata.isDynamicSchema()){
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    }
    stringBuffer.append(TEXT_562);
    
				}
				return this.isBehindDynamic;
			}
			
			public void codeForConnToConn(INode node, IMetadataTable metadata, String sourceConnName, String targetConnName, int start , int end){
    			for(int colNum=start;colNum<end;colNum++) {
    				IMetadataColumn column=metadata.getListColumns().get(colNum);
    			
    stringBuffer.append(TEXT_563);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_565);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_567);
    
				}
				
    stringBuffer.append(TEXT_568);
    
			}
		}//class defined end
		
		if ((metadatas!=null)&&(metadatas.size()>0)) {
		    if (metadata!=null) {
		    
		        String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
		    	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		    	String header = ElementParameterParser.getValue(node, "__HEADER__");
		    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
		    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
		    	if(("").equals(limit)){
		    		limit="-1";
		    	}
		    	  	
		    	String rowSeparator1 = ElementParameterParser.getValue(node, "__CSVROWSEPARATOR__");
		    	
		    	
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
		    	if ("".equals(textEnclosure)) 
		    		textEnclosure = "\0";
		    	if(("'").equals(textEnclosure)){
		    		textEnclosure = "\\'";
		    	}
		    	
		    	String removeEmptyRow = ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
		    	
		    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
				boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
				
				boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));
				if(uncompress){
					footer = "0";
				}
				
				List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
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
    			String firstConnName = "";
				if (conns!=null) {
					if (conns.size()>0) {
						IConnection conn = conns.get(0);
						if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
							firstConnName = conn.getName();		
						}
					}
				}
				
				RowUtil rowUtil = new RowUtil(); 
				if (conns!=null) {
				    if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
						if(hasDynamic){
							rowUtil.prepareValueToConnWithD(node, metadata, "String[]", "row"+cid, firstConnName, "dynamic_"+cid, schemaOptNum);
							
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_571);
    
						}else{
							rowUtil.prepareValueToConn(node, metadata, "String[]", "row"+cid, firstConnName, schemaOptNum);
						}
						if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
							rowUtil.prepareConnToConn(metadata, firstConnName, rejectConnName);
						}
						rowUtil.generateClass();
					}
				}	
				
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_574);
    stringBuffer.append( footer);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    stringBuffer.append( limit );
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_580);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(rowSeparator1);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_586);
    stringBuffer.append(rowSeparator1);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_588);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_590);
    
					if(uncompress){
					
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_597);
     if(dieOnError) {
    stringBuffer.append(TEXT_598);
     } else { 
    stringBuffer.append(TEXT_599);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    }
    stringBuffer.append(TEXT_602);
     } 
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_606);
     if(dieOnError) {
    stringBuffer.append(TEXT_607);
     } else { 
    stringBuffer.append(TEXT_608);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    }
    stringBuffer.append(TEXT_611);
     } 
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_620);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_621);
    
					}else{
					
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_626);
    
								generateCode.checkFooter(footer);
							
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_630);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_633);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_635);
    
					}
					
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_641);
    
						if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){//normal situation
						
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_643);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_644);
    
						}else{ //context and global variables
						
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_646);
    stringBuffer.append(textEnclosure1 );
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_653);
    
						}
					
						if(("").equals(escapeChar1) || escapeChar1.startsWith("\"")){//normal situation
	        				if(("\\\\").equals(escapeChar)){
	        				
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_655);
    
	        				}else if(escapeChar.equals(textEnclosure)){
	        				
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_658);
    
	        				}else{
	        				
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_661);
    
	        				}
	        			}else{//context and global variables
	 					
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_663);
    stringBuffer.append(escapeChar1 );
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_671);
    if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){
    stringBuffer.append(TEXT_672);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_673);
    }else{
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_675);
    }
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_680);
    
						}
						
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_684);
    stringBuffer.append( header );
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_688);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_690);
    
						   	if(("true").equals(removeEmptyRow)){
						   	
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_695);
    
							}
							
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_697);
    
							if(("true").equals(removeEmptyRow)){
							
    stringBuffer.append(TEXT_698);
    
							}
							
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_717);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_720);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_727);
    
						if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){//normal situation
						
    stringBuffer.append(TEXT_728);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_729);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_730);
    
						}else{
						
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_733);
    
						}
						if(("").equals(escapeChar1) || escapeChar1.startsWith("\"")){//normal situation
	        				if(("\\\\").equals(escapeChar)){
	        				
    stringBuffer.append(TEXT_734);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_735);
    
	        				}else if(escapeChar.equals(textEnclosure)){
	        				
    stringBuffer.append(TEXT_736);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_738);
    
	        				}else{
	        				
    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_741);
    
	        				}
	        			}else{//context and global variables
						
    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_743);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_745);
    if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){
    stringBuffer.append(TEXT_746);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_747);
    }else{
    stringBuffer.append(TEXT_748);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_749);
    }
    stringBuffer.append(TEXT_750);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_751);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_752);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_754);
    
	        			}
	        			
    stringBuffer.append(TEXT_755);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_756);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_757);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_758);
    stringBuffer.append( header );
    stringBuffer.append(hasDynamic?"-1":"");
    stringBuffer.append(TEXT_759);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_760);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_761);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_762);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_763);
     if(dieOnError) {
    stringBuffer.append(TEXT_764);
     } else { 
    stringBuffer.append(TEXT_765);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_766);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_767);
    }
    stringBuffer.append(TEXT_768);
     } 
    stringBuffer.append(TEXT_769);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_770);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_771);
    }
    stringBuffer.append(TEXT_772);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_773);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_774);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_775);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_776);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_777);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_778);
    
	   				if(("true").equals(removeEmptyRow)){
	   				
    stringBuffer.append(TEXT_779);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_780);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_781);
    
					}
					
    stringBuffer.append(TEXT_782);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_783);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_784);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_786);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_787);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_788);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_789);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_790);
    
			    	if (conns!=null) {
	    				if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
	    					for (int i=0;i<conns.size();i++) {
	    						IConnection connTemp = conns.get(i);
	    						if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
								
    stringBuffer.append(TEXT_791);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_792);
    
	    						}
	    					}
	    					
							IConnection conn = conns.get(0);
							if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							
    stringBuffer.append(TEXT_793);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_794);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_795);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_796);
    
									List<IMetadataColumn> columns=metadata.getListColumns();
									int columnSize = columns.size();
									if(hasDynamic){// generate the dynamic schema code
										generateCode.colLen = columnSize;
										generateCode.dynamic_index = dynamic_index;
										generateCode.generateDynamicSchemaCode(true); //true: CSV mode
										rowUtil.callValueToConnWithD("row"+cid, firstConnName, "dynamic_"+cid);
									}else{
										rowUtil.callValueToConn("row"+cid, firstConnName);
									}
									
    stringBuffer.append(TEXT_797);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_798);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_799);
    
									if(rejectConnName.equals(firstConnName)) {
									
    stringBuffer.append(TEXT_800);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_801);
    
									}
									
    stringBuffer.append(TEXT_802);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_803);
    
        							if (dieOnError) {
            						
    stringBuffer.append(TEXT_804);
    
        							} else {
								        if(isLog4jEnabled){
    stringBuffer.append(TEXT_805);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_806);
    }
            							if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
						                
    stringBuffer.append(TEXT_807);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_808);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_809);
    
                							rowUtil.callConnToConn(firstConnName, rejectConnName);
                							
    stringBuffer.append(TEXT_810);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_811);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_812);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_813);
    
            							} else if(("").equals(rejectConnName)){
                						
    stringBuffer.append(TEXT_814);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_815);
    	
            							} else if(rejectConnName.equals(firstConnName)){
            							
    stringBuffer.append(TEXT_816);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_817);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_818);
    
            							}
        							} 
        							
    stringBuffer.append(TEXT_819);
    			
							}
						}
						if (conns.size()>0) {	
							boolean isFirstEnter = true;
							for (int i=0;i<conns.size();i++) {
								IConnection conn = conns.get(i);
								if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
									if(isFirstEnter) {
									
    stringBuffer.append(TEXT_820);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_821);
    isFirstEnter = false; 
									}
									
    stringBuffer.append(TEXT_822);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_823);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_824);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_825);
    
        							rowUtil.callConnToConn(firstConnName, conn.getName());
								}
							}
							if(!isFirstEnter) {
							
    stringBuffer.append(TEXT_826);
    
							}
						}
					}
			}
		}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(isLog4jEnabled){
    stringBuffer.append(TEXT_827);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_829);
    }
  	}
	
    stringBuffer.append(TEXT_830);
    return stringBuffer.toString();
  }
}
