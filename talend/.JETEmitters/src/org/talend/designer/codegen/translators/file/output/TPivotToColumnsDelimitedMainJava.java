package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TPivotToColumnsDelimitedMainJava
{
  protected static String nl;
  public static synchronized TPivotToColumnsDelimitedMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPivotToColumnsDelimitedMainJava result = new TPivotToColumnsDelimitedMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "                   " + NL + "    //pivot key  " + NL + "    pivot_Exists";
  protected final String TEXT_3 = " = false;" + NL + "    " + NL + "    int pivotNum";
  protected final String TEXT_4 = " = 0;" + NL + "    " + NL + "    for(int i = 0;i<pivot_Keys";
  protected final String TEXT_5 = ".size();i++){" + NL;
  protected final String TEXT_6 = NL + "\t\t\t\tif(ParserUtils.parseTo_";
  protected final String TEXT_7 = "(pivot_Keys";
  protected final String TEXT_8 = ".get(i)).equals(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ")){";
  protected final String TEXT_11 = NL + "\t\t\t\tif(ParserUtils.parseTo_";
  protected final String TEXT_12 = "(pivot_Keys";
  protected final String TEXT_13 = ".get(i)) == ";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = "){";
  protected final String TEXT_16 = " " + NL + " \t \t\t    if(pivot_Keys";
  protected final String TEXT_17 = ".get(i).equals(FormatterUtils.format_Date(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ",";
  protected final String TEXT_20 = "))){ ";
  protected final String TEXT_21 = NL + "\t \t\tif(pivot_Keys";
  protected final String TEXT_22 = ".get(i).equals(";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = ")){";
  protected final String TEXT_25 = NL + "\t            pivot_Exists";
  protected final String TEXT_26 = " = true;" + NL + "\t            " + NL + "\t            pivotNum";
  protected final String TEXT_27 = " = i + 1;" + NL + "\t            " + NL + "\t            break;" + NL + "            " + NL + "        \t }" + NL + "    }" + NL + "    " + NL + "    if(!pivot_Exists";
  protected final String TEXT_28 = "){" + NL + "        " + NL + "        pivot_Key";
  protected final String TEXT_29 = ".delete(0, pivot_Key";
  protected final String TEXT_30 = ".length());";
  protected final String TEXT_31 = " " + NL + " \t  \t    pivot_Keys";
  protected final String TEXT_32 = ".add(pivot_Key";
  protected final String TEXT_33 = ".append(FormatterUtils.format_Date(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = ",";
  protected final String TEXT_36 = ")).toString()); ";
  protected final String TEXT_37 = " " + NL + "            pivot_Keys";
  protected final String TEXT_38 = ".add(pivot_Key";
  protected final String TEXT_39 = ".append(";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = ").toString()); ";
  protected final String TEXT_42 = " " + NL + "" + NL + "        pivotNum";
  protected final String TEXT_43 = " = pivot_Keys";
  protected final String TEXT_44 = ".size();" + NL + "        " + NL + "    }" + NL + "" + NL + "    " + NL + "    //group key" + NL + "    group_Exists";
  protected final String TEXT_45 = " = false;" + NL + "    " + NL + "    gKvalue";
  protected final String TEXT_46 = " = new java.util.ArrayList<String>();" + NL + "    " + NL + "    group_Key";
  protected final String TEXT_47 = ".delete(0,group_Key";
  protected final String TEXT_48 = ".length());" + NL + "        ";
  protected final String TEXT_49 = NL + "\t\t\t" + NL + "\t\t\t\tgKvalue";
  protected final String TEXT_50 = ".add(group_Key";
  protected final String TEXT_51 = ".append(FormatterUtils.format_Date(";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ")).toString());" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_55 = NL + "\t\t\t\t\t" + NL + "        \t\tgKvalue";
  protected final String TEXT_56 = ".add(group_Key";
  protected final String TEXT_57 = ".append(";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = ").toString());" + NL + "        ";
  protected final String TEXT_60 = NL + "        " + NL + "        group_Key";
  protected final String TEXT_61 = ".delete(0,group_Key";
  protected final String TEXT_62 = ".length());";
  protected final String TEXT_63 = NL + "    " + NL + "\tif (group_Keys";
  protected final String TEXT_64 = ".contains(gKvalue";
  protected final String TEXT_65 = ")) {" + NL + "                     group_Exists";
  protected final String TEXT_66 = " = true;" + NL + "\t}" + NL + "\t" + NL + "" + NL + "    if(!group_Exists";
  protected final String TEXT_67 = "){" + NL + "        " + NL + "        group_Key";
  protected final String TEXT_68 = ".delete(0, group_Key";
  protected final String TEXT_69 = ".length());" + NL + "        " + NL + "        group_Keys";
  protected final String TEXT_70 = ".add(gKvalue";
  protected final String TEXT_71 = ");" + NL + "        " + NL + "\t\taggValues";
  protected final String TEXT_72 = " = new java.util.ArrayList<String>();" + NL + "        " + NL + "        for(int i = 0; i<pivotNum";
  protected final String TEXT_73 = "-1; i++)" + NL + "            " + NL + "            aggValues";
  protected final String TEXT_74 = ".add(\"\");" + NL + "        ";
  protected final String TEXT_75 = NL + NL + "\t\taggValues";
  protected final String TEXT_76 = ".add(\"1\");" + NL + "        aggregation";
  protected final String TEXT_77 = ".put(gKvalue";
  protected final String TEXT_78 = ",aggValues";
  protected final String TEXT_79 = ");" + NL;
  protected final String TEXT_80 = NL + "        aggValues";
  protected final String TEXT_81 = ".add(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = "),";
  protected final String TEXT_84 = ",";
  protected final String TEXT_85 = "));" + NL + "        aggregation";
  protected final String TEXT_86 = ".put(gKvalue";
  protected final String TEXT_87 = ",aggValues";
  protected final String TEXT_88 = ");" + NL + "  ";
  protected final String TEXT_89 = NL + "\t\t\t" + NL + "\t\t\t\taggValues";
  protected final String TEXT_90 = ".add(FormatterUtils.format_Date(";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = ", ";
  protected final String TEXT_93 = "));" + NL + "\t\t\t\taggregation";
  protected final String TEXT_94 = ".put(gKvalue";
  protected final String TEXT_95 = ",aggValues";
  protected final String TEXT_96 = ");" + NL + "\t\t\t  " + NL + "       \t \t";
  protected final String TEXT_97 = NL + "        " + NL + "        \t\taggValues";
  protected final String TEXT_98 = ".add(String.valueOf(";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = "));" + NL + "        \t\taggregation";
  protected final String TEXT_101 = ".put(gKvalue";
  protected final String TEXT_102 = ",aggValues";
  protected final String TEXT_103 = ");" + NL + "        \t";
  protected final String TEXT_104 = NL + "    }else{" + NL + "" + NL + "        java.util.List<String> aggStr";
  protected final String TEXT_105 = " = aggregation";
  protected final String TEXT_106 = ".get(gKvalue";
  protected final String TEXT_107 = ");" + NL + "        " + NL + "        int aggSize";
  protected final String TEXT_108 = " = aggStr";
  protected final String TEXT_109 = ".size();" + NL + "        if(aggSize";
  protected final String TEXT_110 = " < pivotNum";
  protected final String TEXT_111 = "){" + NL + "            " + NL + "" + NL + "    \t\tfor(int i = 0 ; i<pivotNum";
  protected final String TEXT_112 = " - aggSize";
  protected final String TEXT_113 = "-1; i++){" + NL + "                    " + NL + "\t\t\t\taggStr";
  protected final String TEXT_114 = ".add(\"\");" + NL + "            " + NL + "            }    " + NL + "               ";
  protected final String TEXT_115 = NL + NL + "\t\t\taggStr";
  protected final String TEXT_116 = ".add(\"1\");" + NL;
  protected final String TEXT_117 = NL + "            " + NL + "\t\t\taggStr";
  protected final String TEXT_118 = ".add(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = "),";
  protected final String TEXT_121 = ",";
  protected final String TEXT_122 = "));" + NL;
  protected final String TEXT_123 = NL + "\t\t\t\t" + NL + "\t\t\taggStr";
  protected final String TEXT_124 = ".add(FormatterUtils.format_Date(";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = ", ";
  protected final String TEXT_127 = "));" + NL + "\t\t\t\t  " + NL + "        \t";
  protected final String TEXT_128 = NL + "            " + NL + "\t\t\taggStr";
  protected final String TEXT_129 = ".add(String.valueOf(";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = "));" + NL + "            ";
  protected final String TEXT_132 = NL + "  " + NL + "        }else{" + NL + "            " + NL + "            //step1: get the index of the pivot" + NL + "            int pivotIndex";
  protected final String TEXT_133 = " = 0 ;" + NL + "            " + NL + "            for(int i = 0; i<pivot_Keys";
  protected final String TEXT_134 = ".size(); i++){" + NL;
  protected final String TEXT_135 = NL + "\t\t\t\tif(ParserUtils.parseTo_";
  protected final String TEXT_136 = "(pivot_Keys";
  protected final String TEXT_137 = ".get(i)).equals(";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = ")){";
  protected final String TEXT_140 = NL + "\t\t\t\tif(ParserUtils.parseTo_";
  protected final String TEXT_141 = "(pivot_Keys";
  protected final String TEXT_142 = ".get(i)) == ";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = "){";
  protected final String TEXT_145 = " " + NL + " \t \t\t\tif(pivot_Keys";
  protected final String TEXT_146 = ".get(i).equals(FormatterUtils.format_Date(";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = ",";
  protected final String TEXT_149 = "))){ ";
  protected final String TEXT_150 = NL + "\t \t\tif(pivot_Keys";
  protected final String TEXT_151 = ".get(i).equals(";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = ")){";
  protected final String TEXT_154 = NL + "                    pivotIndex";
  protected final String TEXT_155 = " = i;" + NL + "                    " + NL + "                    break;" + NL + "                    " + NL + "                }" + NL + "                " + NL + "            }" + NL + "            " + NL + "            //step2: process the splitted data according to function" + NL + "            ";
  protected final String TEXT_156 = NL;
  protected final String TEXT_157 = NL + "                ";
  protected final String TEXT_158 = " sum";
  protected final String TEXT_159 = " ;" + NL + "" + NL + "                if ((\"\").equals(aggStr";
  protected final String TEXT_160 = ".get(pivotIndex";
  protected final String TEXT_161 = "))){" + NL + "                " + NL + "                \t";
  protected final String TEXT_162 = NL + "                \t\tsum";
  protected final String TEXT_163 = " = new java.math.BigDecimal(";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = ".toPlainString());" + NL + "                \t";
  protected final String TEXT_166 = NL + "                \t\taggStr";
  protected final String TEXT_167 = ".set(pivotIndex";
  protected final String TEXT_168 = ", FormatterUtils.format_Number(sum";
  protected final String TEXT_169 = ".toPlainString(),";
  protected final String TEXT_170 = ",";
  protected final String TEXT_171 = "));" + NL + "                \t";
  protected final String TEXT_172 = NL + "                \t\taggStr";
  protected final String TEXT_173 = ".set(pivotIndex";
  protected final String TEXT_174 = ", sum";
  protected final String TEXT_175 = ".toPlainString());" + NL + "                \t\t";
  protected final String TEXT_176 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t  sum";
  protected final String TEXT_177 = " = ";
  protected final String TEXT_178 = ".parse";
  protected final String TEXT_179 = "(";
  protected final String TEXT_180 = ".";
  protected final String TEXT_181 = " + \"\");" + NL + "\t                    " + NL + "\t                      aggStr";
  protected final String TEXT_182 = ".set(pivotIndex";
  protected final String TEXT_183 = ", FormatterUtils.format_Number(String.valueOf(sum";
  protected final String TEXT_184 = "),";
  protected final String TEXT_185 = ",";
  protected final String TEXT_186 = "));" + NL + "                      " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_187 = NL + "\t\t\t\t\t  " + NL + "\t\t\t\t\t\t  sum";
  protected final String TEXT_188 = " = ";
  protected final String TEXT_189 = ".parse";
  protected final String TEXT_190 = "(";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = " + \"\");" + NL + "\t                    " + NL + "\t                      aggStr";
  protected final String TEXT_193 = ".set(pivotIndex";
  protected final String TEXT_194 = ", String.valueOf(sum";
  protected final String TEXT_195 = "));" + NL + "                      " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_196 = NL + NL + "\t\t\t\t\t  sum";
  protected final String TEXT_197 = " = ";
  protected final String TEXT_198 = ".parse";
  protected final String TEXT_199 = "(";
  protected final String TEXT_200 = ".";
  protected final String TEXT_201 = " + \"\");" + NL + "                    " + NL + "                      aggStr";
  protected final String TEXT_202 = ".set(pivotIndex";
  protected final String TEXT_203 = ", String.valueOf(sum";
  protected final String TEXT_204 = "));                      " + NL + "                      " + NL + "\t\t\t\t\t";
  protected final String TEXT_205 = NL + "                    " + NL + "                }else{" + NL + "               \t\t";
  protected final String TEXT_206 = NL + "               \t\t\t" + NL + "\t\t\t\t\t\t\tjava.math.BigDecimal sourceBD_";
  protected final String TEXT_207 = " = new java.math.BigDecimal(FormatterUtils.unformat_Number(aggStr";
  protected final String TEXT_208 = ".get(pivotIndex";
  protected final String TEXT_209 = "),";
  protected final String TEXT_210 = ",";
  protected final String TEXT_211 = "));" + NL + "\t\t\t\t\t\t\tjava.math.BigDecimal targetBD_";
  protected final String TEXT_212 = " = new java.math.BigDecimal(";
  protected final String TEXT_213 = ".";
  protected final String TEXT_214 = ".toString());" + NL + "\t\t\t\t\t  \t\taggStr";
  protected final String TEXT_215 = ".set(pivotIndex";
  protected final String TEXT_216 = ", FormatterUtils.format_Number(sourceBD_";
  protected final String TEXT_217 = ".add(targetBD_";
  protected final String TEXT_218 = ").toString(),";
  protected final String TEXT_219 = ",";
  protected final String TEXT_220 = "));" + NL + "\t\t\t\t\t  " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_221 = NL + NL + "\t\t\t\t\t  \t\taggStr";
  protected final String TEXT_222 = ".set(pivotIndex";
  protected final String TEXT_223 = ", (new java.math.BigDecimal(aggStr";
  protected final String TEXT_224 = ".get(pivotIndex";
  protected final String TEXT_225 = "))).add(new java.math.BigDecimal(";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = ".toString())).toString());" + NL + "\t\t\t\t\t  " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_228 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t  sum";
  protected final String TEXT_229 = " = (";
  protected final String TEXT_230 = ")(";
  protected final String TEXT_231 = ".parse";
  protected final String TEXT_232 = "(aggStr";
  protected final String TEXT_233 = ".get(pivotIndex";
  protected final String TEXT_234 = ")) + ";
  protected final String TEXT_235 = ".parse";
  protected final String TEXT_236 = "(String.valueOf(";
  protected final String TEXT_237 = ".";
  protected final String TEXT_238 = ")));" + NL + "                \t" + NL + "                \t  aggStr";
  protected final String TEXT_239 = ".set(pivotIndex";
  protected final String TEXT_240 = ", String.valueOf(sum";
  protected final String TEXT_241 = "));" + NL + "                \t  " + NL + "\t\t\t\t\t";
  protected final String TEXT_242 = NL + "\t\t\t\t" + NL + "\t\t\t\t}" + NL + "            ";
  protected final String TEXT_243 = NL + "                int count";
  protected final String TEXT_244 = " = 1;" + NL + "                " + NL + "                if (!(\"\").equals(aggStr";
  protected final String TEXT_245 = ".get(pivotIndex";
  protected final String TEXT_246 = ")))" + NL + "            " + NL + "                    count";
  protected final String TEXT_247 = " = Integer.parseInt(aggStr";
  protected final String TEXT_248 = ".get(pivotIndex";
  protected final String TEXT_249 = ")) + 1;" + NL + "                    " + NL + "                aggStr";
  protected final String TEXT_250 = ".set(pivotIndex";
  protected final String TEXT_251 = ", String.valueOf(count";
  protected final String TEXT_252 = "));" + NL + "            ";
  protected final String TEXT_253 = NL + " \t\t\t\tif (!(\"\").equals(aggStr";
  protected final String TEXT_254 = ".get(pivotIndex";
  protected final String TEXT_255 = "))) {" + NL + " \t\t\t";
  protected final String TEXT_256 = NL + "               \t\t" + NL + "               \t\tString unformatedSourceStr_";
  protected final String TEXT_257 = " = FormatterUtils.unformat_Number(String.valueOf(";
  protected final String TEXT_258 = ".";
  protected final String TEXT_259 = "),";
  protected final String TEXT_260 = ",";
  protected final String TEXT_261 = ");" + NL + "            \t\tString unformatedTargetStr_";
  protected final String TEXT_262 = " = FormatterUtils.unformat_Number(aggStr";
  protected final String TEXT_263 = ".get(pivotIndex";
  protected final String TEXT_264 = "),";
  protected final String TEXT_265 = ",";
  protected final String TEXT_266 = ");" + NL + "\t                if(Float.parseFloat(unformatedSourceStr_";
  protected final String TEXT_267 = ")>Float.parseFloat(unformatedTargetStr_";
  protected final String TEXT_268 = "))" + NL + "\t                    aggStr";
  protected final String TEXT_269 = ".set(pivotIndex";
  protected final String TEXT_270 = ", FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_271 = ".";
  protected final String TEXT_272 = "),";
  protected final String TEXT_273 = ",";
  protected final String TEXT_274 = "));" + NL + "\t                    " + NL + "\t            ";
  protected final String TEXT_275 = NL + "\t            " + NL + "\t                if(Float.parseFloat(String.valueOf(";
  protected final String TEXT_276 = ".";
  protected final String TEXT_277 = "))>Float.parseFloat(aggStr";
  protected final String TEXT_278 = ".get(pivotIndex";
  protected final String TEXT_279 = ")))" + NL + "\t                    aggStr";
  protected final String TEXT_280 = ".set(pivotIndex";
  protected final String TEXT_281 = ", String.valueOf(";
  protected final String TEXT_282 = ".";
  protected final String TEXT_283 = "));" + NL + "            ";
  protected final String TEXT_284 = NL + "            \t} else {" + NL + "            \t\taggStr";
  protected final String TEXT_285 = ".set(pivotIndex";
  protected final String TEXT_286 = ", String.valueOf(";
  protected final String TEXT_287 = ".";
  protected final String TEXT_288 = "));" + NL + "            \t}";
  protected final String TEXT_289 = NL + "            \tif (!(\"\").equals(aggStr";
  protected final String TEXT_290 = ".get(pivotIndex";
  protected final String TEXT_291 = "))) {";
  protected final String TEXT_292 = NL + "                " + NL + "               \t\tString unformatedSourceStr_";
  protected final String TEXT_293 = " = FormatterUtils.unformat_Number(String.valueOf(";
  protected final String TEXT_294 = ".";
  protected final String TEXT_295 = "),";
  protected final String TEXT_296 = ",";
  protected final String TEXT_297 = ");" + NL + "            \t\tString unformatedTargetStr_";
  protected final String TEXT_298 = " = FormatterUtils.unformat_Number(aggStr";
  protected final String TEXT_299 = ".get(pivotIndex";
  protected final String TEXT_300 = "),";
  protected final String TEXT_301 = ",";
  protected final String TEXT_302 = ");" + NL + "\t                if(Float.parseFloat(unformatedSourceStr_";
  protected final String TEXT_303 = ")<Float.parseFloat(unformatedTargetStr_";
  protected final String TEXT_304 = "))" + NL + "\t                    aggStr";
  protected final String TEXT_305 = ".set(pivotIndex";
  protected final String TEXT_306 = ", FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_307 = ".";
  protected final String TEXT_308 = "),";
  protected final String TEXT_309 = ",";
  protected final String TEXT_310 = "));" + NL + "                    ";
  protected final String TEXT_311 = NL + "                " + NL + "\t                if(Float.parseFloat(String.valueOf(";
  protected final String TEXT_312 = ".";
  protected final String TEXT_313 = "))<Float.parseFloat(aggStr";
  protected final String TEXT_314 = ".get(pivotIndex";
  protected final String TEXT_315 = ")))" + NL + "\t                    aggStr";
  protected final String TEXT_316 = ".set(pivotIndex";
  protected final String TEXT_317 = ", String.valueOf(";
  protected final String TEXT_318 = ".";
  protected final String TEXT_319 = "));" + NL + "            ";
  protected final String TEXT_320 = NL + "            \t} else {" + NL + "            \t\taggStr";
  protected final String TEXT_321 = ".set(pivotIndex";
  protected final String TEXT_322 = ", String.valueOf(";
  protected final String TEXT_323 = ".";
  protected final String TEXT_324 = "));" + NL + "            \t}";
  protected final String TEXT_325 = NL + "            \t" + NL + "                if ((\"\").equals(aggStr";
  protected final String TEXT_326 = ".get(pivotIndex";
  protected final String TEXT_327 = ")))" + NL + "                ";
  protected final String TEXT_328 = NL + "\t\t\t\t" + NL + "\t\t\t\t\t    aggStr";
  protected final String TEXT_329 = ".set(pivotIndex";
  protected final String TEXT_330 = ", FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_331 = ".";
  protected final String TEXT_332 = "),";
  protected final String TEXT_333 = ",";
  protected final String TEXT_334 = "));" + NL + "                    ";
  protected final String TEXT_335 = NL + "\t\t\t\t" + NL + "\t\t\t\t\t\t\taggStr";
  protected final String TEXT_336 = ".set(pivotIndex";
  protected final String TEXT_337 = ", FormatterUtils.format_Date(";
  protected final String TEXT_338 = ".";
  protected final String TEXT_339 = ", ";
  protected final String TEXT_340 = "));" + NL + "\t\t\t\t  " + NL + "           \t\t\t\t";
  protected final String TEXT_341 = NL + "                " + NL + "                    \taggStr";
  protected final String TEXT_342 = ".set(pivotIndex";
  protected final String TEXT_343 = ", String.valueOf(";
  protected final String TEXT_344 = ".";
  protected final String TEXT_345 = "));" + NL + "                    " + NL + "                    \t";
  protected final String TEXT_346 = NL + "\t\t\t\t" + NL + "                    \taggStr";
  protected final String TEXT_347 = ".set(pivotIndex";
  protected final String TEXT_348 = ", FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_349 = ".";
  protected final String TEXT_350 = "),";
  protected final String TEXT_351 = ",";
  protected final String TEXT_352 = "));" + NL + "                    ";
  protected final String TEXT_353 = NL + "\t\t\t\t" + NL + "\t\t\t\t\t\taggStr";
  protected final String TEXT_354 = ".set(pivotIndex";
  protected final String TEXT_355 = ", FormatterUtils.format_Date(";
  protected final String TEXT_356 = ".";
  protected final String TEXT_357 = ", ";
  protected final String TEXT_358 = "));" + NL + "\t\t\t\t  " + NL + "\t\t\t\t\t";
  protected final String TEXT_359 = NL + "            " + NL + "                    \taggStr";
  protected final String TEXT_360 = ".set(pivotIndex";
  protected final String TEXT_361 = ", String.valueOf(";
  protected final String TEXT_362 = ".";
  protected final String TEXT_363 = "));";
  protected final String TEXT_364 = " " + NL + "            " + NL + "        }" + NL + "        " + NL + "        } " + NL + "" + NL + "    nb_line_";
  protected final String TEXT_365 = "++;" + NL + "    resourceMap.put(\"nb_line_";
  protected final String TEXT_366 = "\", nb_line_";
  protected final String TEXT_367 = "); " + NL + "   ";
  protected final String TEXT_368 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
   		    
List<Map<String, String>> groupbys = 
    ( List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
	
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
                
            String pivotColumn = ElementParameterParser.getValue(node, "__PIVOT_COLUMN__");

            String aggColumn = ElementParameterParser.getValue(node, "__AGGREGATION_COLUMN__");

            String aggFunction = ElementParameterParser.getValue(node, "__AGGREGATION_FUNCTION__");
                
            String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
            
            String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");

            //String fieldSeparator = delim1.substring(1,delim1.length()-1);
            
            List<? extends IConnection> incomingConnections = node.getIncomingConnections();
            
                if (incomingConnections != null && !incomingConnections.isEmpty()) {
                    
                    IMetadataTable inMetadata = incomingConnections.get(0).getMetadataTable();
                    
                    String inConnName = incomingConnections.get(0).getName();
                    
                    List<IMetadataColumn> columnList = metadata.getListColumns();
                    
                    JavaType javaType = null;
                    
                    String columnType = null;
                    
                    String columnTypeValue = null;
                    
                    String columnTypeFunName = null;
                    
                    String pattern = null;
                    
                    JavaType pivotJavaType = null;
                    
					String pivotTypeToGenerate = null;
					
					IMetadataColumn columnPivot = null;
					
					String pivotpattern = null; 
					
             		for(IMetadataColumn column:columnList){
             			
             			if(column.getLabel().equals(aggColumn)){
             			
             				javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
             			
							columnType = column.getTalendType().substring(3);
							
							columnTypeValue = JavaTypesManager.getShortNameFromJavaType(JavaTypesManager.getJavaTypeFromId(column.getTalendType()));
							
							columnTypeFunName = columnTypeValue.substring(0,1).toUpperCase()+columnTypeValue.substring(1);
							
							pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

							break;
						}
             		}
	
					for(IMetadataColumn column:columnList){
					
					   	if(column.getLabel().equals(pivotColumn)){
					   	
					    		pivotJavaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					    		
					    		pivotTypeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					    		
					    		columnPivot = column;
					    		
					    		pivotpattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern(); 
					    							    		
					    		break;
					    }
					}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	if(JavaTypesManager.isNumberType(pivotJavaType,columnPivot.isNullable())){
	
			if(columnPivot.isNullable() || "BigDecimal".equals(pivotTypeToGenerate)){

    stringBuffer.append(TEXT_6);
    stringBuffer.append( pivotTypeToGenerate );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_10);
    
			}else{

    stringBuffer.append(TEXT_11);
    stringBuffer.append( pivotTypeToGenerate );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_15);
    
			}
	}else if(pivotJavaType == JavaTypesManager.DATE) { 

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(pivotpattern);
    stringBuffer.append(TEXT_20);
    
	}else{

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_24);
    	
	}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
     
		if(pivotJavaType == JavaTypesManager.DATE) { 

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(pivotpattern);
    stringBuffer.append(TEXT_36);
     
        }else{

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_41);
     
		} 

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
    for (int i=0; i<groupbys.size(); i++) {
       
    	Map<String, String> groupby = groupbys.get(i);
      
      	String pattern_groupby = null;
      
      	JavaType columnType_groupby = null;
      	
		for(IMetadataColumn column:columnList){
		
			if(column.getLabel().equals(groupby.get("INPUT_COLUMN"))){
			
				columnType_groupby = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				
				pattern_groupby = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				
				break;
			}
		}
		if(columnType_groupby == JavaTypesManager.DATE){
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(groupby.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append( pattern_groupby );
    stringBuffer.append(TEXT_54);
    }else{
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(groupby.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    

     }
    
    
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    if( ("count").equals(aggFunction)){
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    }else{
	if(advancedSeparator && JavaTypesManager.isNumberType(javaType)){
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    }else{
  
  			if(("Date").equals(columnType)){
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_92);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    }else{
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    }
		}
  }
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    if( ("count").equals(aggFunction)){
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    }else{
	if(advancedSeparator && JavaTypesManager.isNumberType(javaType)){
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_122);
    }else{
  
  			if(("Date").equals(columnType)){
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_126);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_127);
    }else{
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_131);
    			}
        }
  }
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
	if(JavaTypesManager.isNumberType(pivotJavaType,columnPivot.isNullable())){
	
			if(columnPivot.isNullable() || "BigDecimal".equals(pivotTypeToGenerate)){

    stringBuffer.append(TEXT_135);
    stringBuffer.append( pivotTypeToGenerate );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_139);
    
			}else{

    stringBuffer.append(TEXT_140);
    stringBuffer.append( pivotTypeToGenerate );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_144);
    
			}
	}else if(pivotJavaType == JavaTypesManager.DATE) { 

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(pivotpattern);
    stringBuffer.append(TEXT_149);
    
	}else{

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_153);
    	
	}

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
      
            if( ("sum").equals(aggFunction) ){
            
    stringBuffer.append(TEXT_156);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(columnTypeValue);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
                	if(("BigDecimal").equals(columnType)) {
                	
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_165);
    
                		if(advancedSeparator){
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_171);
    
                		} else {
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    
                		}
					} else if(("Double").equals(columnType)||("Float").equals(columnType)){
						if(advancedSeparator){
						
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_186);
    }else{
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    }
					  }else{
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    }
    stringBuffer.append(TEXT_205);
    if(("BigDecimal").equals(columnType) || ("Double").equals(columnType)||("Float").equals(columnType)){
               			if(advancedSeparator){
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_220);
    }else{
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_227);
    }
					}else{
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(columnTypeValue);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    }
    stringBuffer.append(TEXT_242);
    
            }else if( ("count").equals(aggFunction) ){
            
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    
            }else if( ("max").equals(aggFunction) ){
 			
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    
               	if(advancedSeparator){
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_274);
    }else{
    stringBuffer.append(TEXT_275);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_283);
    
            	}
            
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_288);
    
            }else if( ("min").equals(aggFunction) ){
            
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    
               	if(advancedSeparator){
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_310);
    }else{
    stringBuffer.append(TEXT_311);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_319);
    
            	}
            
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_324);
    
            }else if( ("first").equals(aggFunction) ){
            
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    if(advancedSeparator){
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_334);
    }else{
                    	if(("Date").equals(columnType)){
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_339);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_340);
    }else{
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_345);
    }
            		}
            }else if( ("last").equals(aggFunction) ){
            	if(advancedSeparator){
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_352);
    }else{
           			if(("Date").equals(columnType)){
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_357);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_358);
    }else{
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_363);
    }
            	}
            }
            
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    
        }
    }
}

    stringBuffer.append(TEXT_368);
    return stringBuffer.toString();
  }
}
