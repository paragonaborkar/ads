package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;

public class TFileOutputPositionalBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputPositionalBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputPositionalBeginJava result = new TFileOutputPositionalBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_3 = " = (routines.system.Dynamic)globalMap.get(\"";
  protected final String TEXT_4 = "\");" + NL + "\t\t\tint maxColumnCount_";
  protected final String TEXT_5 = " = dynamic_";
  protected final String TEXT_6 = ".getColumnCount();" + NL + "\t\t\tdynamic_";
  protected final String TEXT_7 = ".clearColumnValues();";
  protected final String TEXT_8 = NL + "\t\tint nb_line_";
  protected final String TEXT_9 = " = 0;" + NL + "\t\tresourceMap.put(\"nb_line_";
  protected final String TEXT_10 = "\", nb_line_";
  protected final String TEXT_11 = ");" + NL + "\t\t";
  protected final String TEXT_12 = NL + "class Arrays_";
  protected final String TEXT_13 = "{" + NL + "    public byte[] copyOfRange(byte[] original, int from, int to) {" + NL + "        int newLength = to - from;" + NL + "        if (newLength < 0)" + NL + "            throw new IllegalArgumentException(from + \" > \" + to);" + NL + "        byte[] copy = new byte[newLength];" + NL + "        System.arraycopy(original, from, copy, 0," + NL + "                         Math.min(original.length - from, newLength));" + NL + "        return copy;" + NL + "    }" + NL + "}" + NL + "byte[] byteArray_";
  protected final String TEXT_14 = " = new byte[0];" + NL + "Arrays_";
  protected final String TEXT_15 = " arrays_";
  protected final String TEXT_16 = " = new Arrays_";
  protected final String TEXT_17 = "();";
  protected final String TEXT_18 = "\t\t" + NL + "\t\tclass PositionUtil_";
  protected final String TEXT_19 = "{" + NL + "\t\t";
  protected final String TEXT_20 = NL + "              void writeHeader_";
  protected final String TEXT_21 = "(String tempStringB";
  protected final String TEXT_22 = ",int tempLengthB";
  protected final String TEXT_23 = ",final ";
  protected final String TEXT_24 = " out";
  protected final String TEXT_25 = ",byte[] byteArray_";
  protected final String TEXT_26 = ",Arrays_";
  protected final String TEXT_27 = " arrays_";
  protected final String TEXT_28 = ")throws IOException,java.io.UnsupportedEncodingException{" + NL + "              " + NL + "                 int tempLengthM";
  protected final String TEXT_29 = "= 0;";
  protected final String TEXT_30 = NL + "    \t\t\t//get  and format output String begin";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_32 = " = (routines.system.Dynamic)globalMap.get(\"";
  protected final String TEXT_33 = "\");" + NL + "\t\t\t\t\t\tint maxColumnCount_";
  protected final String TEXT_34 = " = dynamic_";
  protected final String TEXT_35 = ".getColumnCount();" + NL + "\t\t\t\t\t\tfor (int i=0;i<maxColumnCount_";
  protected final String TEXT_36 = ";i++) {" + NL + "\t\t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadataColumn_";
  protected final String TEXT_37 = " = dynamic_";
  protected final String TEXT_38 = ".getColumnMetadata(i);" + NL + "\t\t\t\t\t\t\tint currentFieldLength_";
  protected final String TEXT_39 = " = dynamicMetadataColumn_";
  protected final String TEXT_40 = ".getLength();" + NL + "\t\t\t\t\t\t\ttempStringB";
  protected final String TEXT_41 = " = dynamicMetadataColumn_";
  protected final String TEXT_42 = ".getName();";
  protected final String TEXT_43 = NL + "    \t\t\t\t\t\t\ttempLengthB";
  protected final String TEXT_44 = " = tempStringB";
  protected final String TEXT_45 = ".getBytes(";
  protected final String TEXT_46 = ").length;";
  protected final String TEXT_47 = NL + "    \t\t\t\t\t\t\ttempLengthB";
  protected final String TEXT_48 = " = tempStringB";
  protected final String TEXT_49 = ".length();";
  protected final String TEXT_50 = NL + "\t    \t\t\t\t\tif(tempLengthB";
  protected final String TEXT_51 = "<currentFieldLength_";
  protected final String TEXT_52 = "){";
  protected final String TEXT_53 = NL + "\t\t\t    \t\t\t\t\tfor(int j=0;j<currentFieldLength_";
  protected final String TEXT_54 = "-tempLengthB";
  protected final String TEXT_55 = ";j++){" + NL + "\t\t\t    \t\t\t\t\t\ttempStringB";
  protected final String TEXT_56 = "= tempStringB";
  protected final String TEXT_57 = " + ";
  protected final String TEXT_58 = ";" + NL + "\t\t\t    \t\t\t\t\t}";
  protected final String TEXT_59 = NL + "\t\t\t\t\t\t\t\t\tfor(int j=0;j<currentFieldLength_";
  protected final String TEXT_60 = "-tempLengthB";
  protected final String TEXT_61 = ";j++){" + NL + "\t\t\t    \t\t\t\t\t\ttempStringB";
  protected final String TEXT_62 = "= ";
  protected final String TEXT_63 = " + tempStringB";
  protected final String TEXT_64 = ";" + NL + "\t\t\t    \t\t\t\t\t}";
  protected final String TEXT_65 = NL + "\t\t\t\t\t\t\t\t\tint temp_";
  protected final String TEXT_66 = " = currentFieldLength_";
  protected final String TEXT_67 = "-tempLengthB";
  protected final String TEXT_68 = ";" + NL + "\t\t\t\t\t\t\t\t\tfor(int j=0;j<temp_";
  protected final String TEXT_69 = "/2;j++){" + NL + "\t\t\t    \t\t\t\t\t\ttempStringB";
  protected final String TEXT_70 = "= ";
  protected final String TEXT_71 = " + tempStringB";
  protected final String TEXT_72 = " + ";
  protected final String TEXT_73 = ";" + NL + "\t\t\t    \t\t\t\t\t}" + NL + "\t\t\t    \t\t\t\t\tif(temp_";
  protected final String TEXT_74 = "%2==1){" + NL + "\t\t\t    \t\t\t\t\t\ttempStringB";
  protected final String TEXT_75 = " = tempStringB";
  protected final String TEXT_76 = " + ";
  protected final String TEXT_77 = ";" + NL + "\t\t\t    \t\t\t\t\t}";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\t\t}else if(tempLengthB";
  protected final String TEXT_79 = " > currentFieldLength_";
  protected final String TEXT_80 = "){";
  protected final String TEXT_81 = NL + "                    \t\t\t\t\tbyteArray_";
  protected final String TEXT_82 = "=arrays_";
  protected final String TEXT_83 = ".copyOfRange(tempStringB";
  protected final String TEXT_84 = ".getBytes(";
  protected final String TEXT_85 = "),tempLengthB";
  protected final String TEXT_86 = " - currentFieldLength_";
  protected final String TEXT_87 = ",tempLengthB";
  protected final String TEXT_88 = ");" + NL + "\t                    \t\t\t\ttempStringB";
  protected final String TEXT_89 = " = new String(byteArray_";
  protected final String TEXT_90 = ",";
  protected final String TEXT_91 = ");";
  protected final String TEXT_92 = NL + "\t\t\t\t\t\t\t\t\t\ttempStringB";
  protected final String TEXT_93 = " = tempStringB";
  protected final String TEXT_94 = ".substring(tempLengthB";
  protected final String TEXT_95 = "-currentFieldLength_";
  protected final String TEXT_96 = ");";
  protected final String TEXT_97 = NL + "\t\t\t\t\t\t\t\t\tint begin";
  protected final String TEXT_98 = "=(tempLengthB";
  protected final String TEXT_99 = "-currentFieldLength_";
  protected final String TEXT_100 = ")/2;";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\t\t\t\t\tbyteArray_";
  protected final String TEXT_102 = "=arrays_";
  protected final String TEXT_103 = ".copyOfRange(tempStringB";
  protected final String TEXT_104 = ".getBytes(";
  protected final String TEXT_105 = "),begin";
  protected final String TEXT_106 = ",begin";
  protected final String TEXT_107 = " + currentFieldLength_";
  protected final String TEXT_108 = ");" + NL + "\t\t                    \t\t\ttempStringB";
  protected final String TEXT_109 = " = new String(byteArray_";
  protected final String TEXT_110 = ",";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "    \t                    \t\t\ttempStringB";
  protected final String TEXT_113 = " = tempStringB";
  protected final String TEXT_114 = ".substring(begin";
  protected final String TEXT_115 = ", begin";
  protected final String TEXT_116 = "+currentFieldLength_";
  protected final String TEXT_117 = ");";
  protected final String TEXT_118 = NL + "\t                    \t\t\t\tbyteArray_";
  protected final String TEXT_119 = "=arrays_";
  protected final String TEXT_120 = ".copyOfRange(tempStringB";
  protected final String TEXT_121 = ".getBytes(";
  protected final String TEXT_122 = "),0,currentFieldLength_";
  protected final String TEXT_123 = ");" + NL + "                    \t\t\t\t\ttempStringB";
  protected final String TEXT_124 = " = new String(byteArray_";
  protected final String TEXT_125 = ",";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = NL + "                    \t\t\t\t\ttempStringB";
  protected final String TEXT_128 = " = tempStringB";
  protected final String TEXT_129 = ".substring(0, currentFieldLength_";
  protected final String TEXT_130 = ");";
  protected final String TEXT_131 = NL + "\t\t\t\t\t\t\t}" + NL + "\t    \t\t\t\t\tout";
  protected final String TEXT_132 = ".write(tempStringB";
  protected final String TEXT_133 = ");" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_134 = "\t\t\t\t" + NL + "    \t\t\ttempStringB";
  protected final String TEXT_135 = "=\"";
  protected final String TEXT_136 = "\";" + NL + "    \t\t\t";
  protected final String TEXT_137 = NL + "    \t\t\ttempLengthB";
  protected final String TEXT_138 = "=tempStringB";
  protected final String TEXT_139 = ".getBytes(";
  protected final String TEXT_140 = ").length;" + NL + "    \t\t\t";
  protected final String TEXT_141 = NL + "    \t\t\ttempLengthB";
  protected final String TEXT_142 = "=tempStringB";
  protected final String TEXT_143 = ".length();" + NL + "    \t\t\t";
  protected final String TEXT_144 = NL + "    \t\t\t" + NL + "            \tif (tempLengthB";
  protected final String TEXT_145 = " > ";
  protected final String TEXT_146 = ") {";
  protected final String TEXT_147 = NL + "                    \t\tbyteArray_";
  protected final String TEXT_148 = "=arrays_";
  protected final String TEXT_149 = ".copyOfRange(tempStringB";
  protected final String TEXT_150 = ".getBytes(";
  protected final String TEXT_151 = "),tempLengthB";
  protected final String TEXT_152 = " - ";
  protected final String TEXT_153 = ",tempLengthB";
  protected final String TEXT_154 = ");" + NL + "\t                    \ttempStringB";
  protected final String TEXT_155 = " = new String(byteArray_";
  protected final String TEXT_156 = ",";
  protected final String TEXT_157 = ");";
  protected final String TEXT_158 = NL + "\t                        tempStringB";
  protected final String TEXT_159 = " = tempStringB";
  protected final String TEXT_160 = ".substring(tempLengthB";
  protected final String TEXT_161 = "-";
  protected final String TEXT_162 = ");";
  protected final String TEXT_163 = NL + "                        int begin";
  protected final String TEXT_164 = "=(tempLengthB";
  protected final String TEXT_165 = "-";
  protected final String TEXT_166 = ")/2;";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\t\tbyteArray_";
  protected final String TEXT_168 = "=arrays_";
  protected final String TEXT_169 = ".copyOfRange(tempStringB";
  protected final String TEXT_170 = ".getBytes(";
  protected final String TEXT_171 = "),begin";
  protected final String TEXT_172 = ",begin";
  protected final String TEXT_173 = " + ";
  protected final String TEXT_174 = ");" + NL + "\t\t                    tempStringB";
  protected final String TEXT_175 = " = new String(byteArray_";
  protected final String TEXT_176 = ",";
  protected final String TEXT_177 = ");";
  protected final String TEXT_178 = NL + "    \t                    tempStringB";
  protected final String TEXT_179 = " = tempStringB";
  protected final String TEXT_180 = ".substring(begin";
  protected final String TEXT_181 = ", begin";
  protected final String TEXT_182 = "+";
  protected final String TEXT_183 = ");";
  protected final String TEXT_184 = NL + "\t                    \tbyteArray_";
  protected final String TEXT_185 = "=arrays_";
  protected final String TEXT_186 = ".copyOfRange(tempStringB";
  protected final String TEXT_187 = ".getBytes(";
  protected final String TEXT_188 = "),0,";
  protected final String TEXT_189 = ");" + NL + "                    \t\ttempStringB";
  protected final String TEXT_190 = " = new String(byteArray_";
  protected final String TEXT_191 = ",";
  protected final String TEXT_192 = ");";
  protected final String TEXT_193 = NL + "                    \t\ttempStringB";
  protected final String TEXT_194 = " = tempStringB";
  protected final String TEXT_195 = ".substring(0, ";
  protected final String TEXT_196 = ");";
  protected final String TEXT_197 = NL + "                }else if(tempLengthB";
  protected final String TEXT_198 = "<";
  protected final String TEXT_199 = "){" + NL + "                    StringBuilder result";
  protected final String TEXT_200 = " = new StringBuilder();";
  protected final String TEXT_201 = NL + "                        result";
  protected final String TEXT_202 = ".append(tempStringB";
  protected final String TEXT_203 = ");" + NL + "                        for(int i";
  protected final String TEXT_204 = "=0; i";
  protected final String TEXT_205 = "< ";
  protected final String TEXT_206 = "-tempLengthB";
  protected final String TEXT_207 = "; i";
  protected final String TEXT_208 = "++){" + NL + "                            result";
  protected final String TEXT_209 = ".append(";
  protected final String TEXT_210 = ");" + NL + "                        }" + NL + "                        tempStringB";
  protected final String TEXT_211 = " = result";
  protected final String TEXT_212 = ".toString();";
  protected final String TEXT_213 = NL + "                        for(int i";
  protected final String TEXT_214 = "=0; i";
  protected final String TEXT_215 = "< ";
  protected final String TEXT_216 = "-tempLengthB";
  protected final String TEXT_217 = "; i";
  protected final String TEXT_218 = "++){" + NL + "                            result";
  protected final String TEXT_219 = ".append(";
  protected final String TEXT_220 = ");" + NL + "                        }" + NL + "                        result";
  protected final String TEXT_221 = ".append(tempStringB";
  protected final String TEXT_222 = ");" + NL + "                        tempStringB";
  protected final String TEXT_223 = " = result";
  protected final String TEXT_224 = ".toString();";
  protected final String TEXT_225 = NL + "                        int temp";
  protected final String TEXT_226 = "= (";
  protected final String TEXT_227 = "-tempLengthB";
  protected final String TEXT_228 = ")/2;" + NL + "                        for(int i";
  protected final String TEXT_229 = "=0;i";
  protected final String TEXT_230 = "<temp";
  protected final String TEXT_231 = ";i";
  protected final String TEXT_232 = "++){" + NL + "                            result";
  protected final String TEXT_233 = ".append(";
  protected final String TEXT_234 = ");" + NL + "                        }" + NL + "                        result";
  protected final String TEXT_235 = ".append(tempStringB";
  protected final String TEXT_236 = ");" + NL + "                        for(int i";
  protected final String TEXT_237 = "=0;i";
  protected final String TEXT_238 = "<temp";
  protected final String TEXT_239 = ";i";
  protected final String TEXT_240 = "++){" + NL + "                            result";
  protected final String TEXT_241 = ".append(";
  protected final String TEXT_242 = ");" + NL + "                        }" + NL + "                        if((temp";
  protected final String TEXT_243 = "+temp";
  protected final String TEXT_244 = ")!=(";
  protected final String TEXT_245 = "-tempLengthB";
  protected final String TEXT_246 = ")){" + NL + "                            result";
  protected final String TEXT_247 = ".append(";
  protected final String TEXT_248 = ");" + NL + "                        }" + NL + "                        tempStringB";
  protected final String TEXT_249 = " = result";
  protected final String TEXT_250 = ".toString();";
  protected final String TEXT_251 = "       " + NL + "                }" + NL + "                //get  and format output String end" + NL + "    \t\t\tout";
  protected final String TEXT_252 = ".write(tempStringB";
  protected final String TEXT_253 = ");";
  protected final String TEXT_254 = NL + "              }";
  protected final String TEXT_255 = NL + "              }  ";
  protected final String TEXT_256 = NL + "\t\t\t\t  void setValue_";
  protected final String TEXT_257 = "(final ";
  protected final String TEXT_258 = "Struct ";
  protected final String TEXT_259 = ",StringBuilder sb_";
  protected final String TEXT_260 = ",String tempStringM";
  protected final String TEXT_261 = ",int tempLengthM";
  protected final String TEXT_262 = ",byte[] byteArray_";
  protected final String TEXT_263 = ",Arrays_";
  protected final String TEXT_264 = " arrays_";
  protected final String TEXT_265 = ")throws IOException,java.io.UnsupportedEncodingException{";
  protected final String TEXT_266 = NL + "\t\t\t\t\t\troutines.system.Dynamic dynamic_map_";
  protected final String TEXT_267 = " =(routines.system.Dynamic)globalMap.get(\"";
  protected final String TEXT_268 = "\");" + NL + "\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_269 = " = ";
  protected final String TEXT_270 = ".";
  protected final String TEXT_271 = ";//" + NL + "\t\t\t\t\t\tint maxColumnCount_";
  protected final String TEXT_272 = " = dynamic_map_";
  protected final String TEXT_273 = ".getColumnCount();" + NL + "\t\t\t\t\t\tString temp_";
  protected final String TEXT_274 = "= \"\";" + NL + "\t\t\t\t\t\tfor (int i=0;i<maxColumnCount_";
  protected final String TEXT_275 = ";i++) {" + NL + "\t\t\t\t\t\t\troutines.system.DynamicMetadata metadata_";
  protected final String TEXT_276 = " = dynamic_map_";
  protected final String TEXT_277 = ".getColumnMetadata(i);" + NL + "\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_278 = " = String.valueOf(dynamic_";
  protected final String TEXT_279 = ".getColumnValue(i));" + NL + "\t\t\t\t\t\t\tString type_";
  protected final String TEXT_280 = " = metadata_";
  protected final String TEXT_281 = ".getType();" + NL + "\t\t\t\t\t\t\tif(\"id_BigDecimal\".equals(type_";
  protected final String TEXT_282 = ")){" + NL + "\t\t\t\t\t\t\t\tint precision_";
  protected final String TEXT_283 = " = metadata_";
  protected final String TEXT_284 = ".getPrecision();" + NL + "\t\t\t\t\t\t\t\tif(precision_";
  protected final String TEXT_285 = " !=0){" + NL + "\t\t\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_286 = " = (new BigDecimal(temp_";
  protected final String TEXT_287 = ")).setScale(precision_";
  protected final String TEXT_288 = ",java.math.RoundingMode.HALF_UP).toPlainString();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_289 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tif(\"id_BigDecimal\".equals(type_";
  protected final String TEXT_290 = ") || \"id_Short\".equals(type_";
  protected final String TEXT_291 = ") || \"id_Integer\".equals(type_";
  protected final String TEXT_292 = ") || \"id_Double\".equals(type_";
  protected final String TEXT_293 = ") || \"id_Float\".equals(type_";
  protected final String TEXT_294 = ") || \"id_Long\".equals(type_";
  protected final String TEXT_295 = ")){" + NL + "\t\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_296 = " = FormatterUtils.format_Number(temp_";
  protected final String TEXT_297 = ", ";
  protected final String TEXT_298 = ", ";
  protected final String TEXT_299 = ");" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_300 = NL + "\t\t\t\t\t\t\tint columnLength_";
  protected final String TEXT_301 = " = metadata_";
  protected final String TEXT_302 = ".getLength();";
  protected final String TEXT_303 = NL + "    \t\t\t\t\t\t\tint temp_length_";
  protected final String TEXT_304 = " = temp_";
  protected final String TEXT_305 = ".getBytes(";
  protected final String TEXT_306 = ").length;";
  protected final String TEXT_307 = NL + "    \t\t\t\t\t\t\tint temp_length_";
  protected final String TEXT_308 = " = temp_";
  protected final String TEXT_309 = ".length();";
  protected final String TEXT_310 = NL + "\t\t\t\t\t\t\tif(temp_length_";
  protected final String TEXT_311 = " < columnLength_";
  protected final String TEXT_312 = "){";
  protected final String TEXT_313 = NL + "\t\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_314 = ".append(temp_";
  protected final String TEXT_315 = ");" + NL + "\t\t\t    \t\t\t\t\tfor(int j=0;j<columnLength_";
  protected final String TEXT_316 = "-temp_length_";
  protected final String TEXT_317 = ";j++){" + NL + "\t\t\t    \t\t\t\t\t\tsb_";
  protected final String TEXT_318 = ".append(";
  protected final String TEXT_319 = ");" + NL + "\t\t\t    \t\t\t\t\t}";
  protected final String TEXT_320 = NL + "\t\t\t    \t\t\t\t\tfor(int j=0;j<columnLength_";
  protected final String TEXT_321 = "-temp_length_";
  protected final String TEXT_322 = ";j++){" + NL + "\t\t\t    \t\t\t\t\t\tsb_";
  protected final String TEXT_323 = ".append(";
  protected final String TEXT_324 = ");" + NL + "\t\t\t    \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_325 = ".append(temp_";
  protected final String TEXT_326 = ");";
  protected final String TEXT_327 = NL + "\t\t\t\t\t\t\t\t\tint tempNum_";
  protected final String TEXT_328 = " = columnLength_";
  protected final String TEXT_329 = "-temp_length_";
  protected final String TEXT_330 = ";" + NL + "\t\t\t\t\t\t\t\t\tfor(int j=0;j<tempNum_";
  protected final String TEXT_331 = "/2;j++){" + NL + "\t\t\t    \t\t\t\t\t\tsb_";
  protected final String TEXT_332 = ".append(";
  protected final String TEXT_333 = ");" + NL + "\t\t\t    \t\t\t\t\t}" + NL + "\t\t\t    \t\t\t\t\tsb_";
  protected final String TEXT_334 = ".append(temp_";
  protected final String TEXT_335 = ");" + NL + "\t\t\t\t\t\t\t\t\tfor(int j=0;j<tempNum_";
  protected final String TEXT_336 = "/2;j++){" + NL + "\t\t\t    \t\t\t\t\t\tsb_";
  protected final String TEXT_337 = ".append(";
  protected final String TEXT_338 = ");" + NL + "\t\t\t    \t\t\t\t\t}" + NL + "\t\t\t    \t\t\t\t\tif(tempNum_";
  protected final String TEXT_339 = "%2==1){" + NL + "\t\t\t    \t\t\t\t\t\tsb_";
  protected final String TEXT_340 = ".append(";
  protected final String TEXT_341 = ");" + NL + "\t\t\t    \t\t\t\t\t}";
  protected final String TEXT_342 = NL + "\t\t\t\t\t\t\t}else{";
  protected final String TEXT_343 = NL + "\t\t\t                        sb_";
  protected final String TEXT_344 = ".append(temp_";
  protected final String TEXT_345 = ");";
  protected final String TEXT_346 = NL + "\t\t\t                    \t\tbyteArray_";
  protected final String TEXT_347 = "=arrays_";
  protected final String TEXT_348 = ".copyOfRange(temp_";
  protected final String TEXT_349 = ".getBytes(";
  protected final String TEXT_350 = "),temp_length_";
  protected final String TEXT_351 = " - columnLength_";
  protected final String TEXT_352 = ",temp_length_";
  protected final String TEXT_353 = ");" + NL + "\t\t\t\t                    \tsb_";
  protected final String TEXT_354 = ".append(new String(byteArray_";
  protected final String TEXT_355 = ",";
  protected final String TEXT_356 = "));";
  protected final String TEXT_357 = NL + "\t\t\t    \t                    sb_";
  protected final String TEXT_358 = ".append(temp_";
  protected final String TEXT_359 = ".substring(temp_length_";
  protected final String TEXT_360 = "-columnLength_";
  protected final String TEXT_361 = "));";
  protected final String TEXT_362 = NL + "\t\t\t                        int begin";
  protected final String TEXT_363 = "=(temp_length_";
  protected final String TEXT_364 = "-columnLength_";
  protected final String TEXT_365 = ")/2;";
  protected final String TEXT_366 = NL + "\t\t\t\t\t\t\t\t\t\tbyteArray_";
  protected final String TEXT_367 = "=arrays_";
  protected final String TEXT_368 = ".copyOfRange(temp_";
  protected final String TEXT_369 = ".getBytes(";
  protected final String TEXT_370 = "),begin";
  protected final String TEXT_371 = ",begin";
  protected final String TEXT_372 = "+columnLength_";
  protected final String TEXT_373 = ");" + NL + "\t\t\t\t                    \tsb_";
  protected final String TEXT_374 = ".append(new String(byteArray_";
  protected final String TEXT_375 = ",";
  protected final String TEXT_376 = "));";
  protected final String TEXT_377 = NL + "\t\t\t    \t                    sb_";
  protected final String TEXT_378 = ".append(temp_";
  protected final String TEXT_379 = ".substring(begin";
  protected final String TEXT_380 = ", begin";
  protected final String TEXT_381 = "+columnLength_";
  protected final String TEXT_382 = "));";
  protected final String TEXT_383 = NL + "\t\t\t                    \t\tbyteArray_";
  protected final String TEXT_384 = "=arrays_";
  protected final String TEXT_385 = ".copyOfRange(temp_";
  protected final String TEXT_386 = ".getBytes(";
  protected final String TEXT_387 = "),0,columnLength_";
  protected final String TEXT_388 = ");" + NL + "\t\t\t                    \t\tsb_";
  protected final String TEXT_389 = ".append(new String(byteArray_";
  protected final String TEXT_390 = ",";
  protected final String TEXT_391 = "));";
  protected final String TEXT_392 = NL + "\t\t\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_393 = ".append(temp_";
  protected final String TEXT_394 = ".substring(0, columnLength_";
  protected final String TEXT_395 = "));";
  protected final String TEXT_396 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_397 = NL + "\t\t\t\t//get  and format output String begin" + NL + "    \t\t\ttempStringM";
  protected final String TEXT_398 = "=";
  protected final String TEXT_399 = NL + "\t\t\t\t\tString.valueOf(";
  protected final String TEXT_400 = ".";
  protected final String TEXT_401 = ")";
  protected final String TEXT_402 = NL + "\t\t\t\t\t(";
  protected final String TEXT_403 = ".";
  protected final String TEXT_404 = " == null) ? " + NL + "\t\t\t\t\t\"\": ";
  protected final String TEXT_405 = "FormatterUtils.format_Date(";
  protected final String TEXT_406 = ".";
  protected final String TEXT_407 = ", ";
  protected final String TEXT_408 = ")";
  protected final String TEXT_409 = "java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_410 = ".";
  protected final String TEXT_411 = ")).toString()";
  protected final String TEXT_412 = ".";
  protected final String TEXT_413 = NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_414 = NL + "        \t\t\t\t\t\t\tFormatterUtils.format_Number(";
  protected final String TEXT_415 = ".toPlainString(), ";
  protected final String TEXT_416 = ", ";
  protected final String TEXT_417 = ")\t\t\t\t\t" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_418 = NL + "        \t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_419 = ".";
  protected final String TEXT_420 = "), ";
  protected final String TEXT_421 = ", ";
  protected final String TEXT_422 = ")\t\t\t\t\t\t" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_423 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_424 = ".toPlainString()\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_425 = "String.valueOf(";
  protected final String TEXT_426 = ".";
  protected final String TEXT_427 = ")";
  protected final String TEXT_428 = " ;" + NL + "\t\t\t\t";
  protected final String TEXT_429 = NL + "    \t\t\ttempLengthM";
  protected final String TEXT_430 = "=tempStringM";
  protected final String TEXT_431 = ".getBytes(";
  protected final String TEXT_432 = ").length;" + NL + "    \t\t\t";
  protected final String TEXT_433 = NL + "    \t\t\ttempLengthM";
  protected final String TEXT_434 = "=tempStringM";
  protected final String TEXT_435 = ".length();" + NL + "    \t\t\t";
  protected final String TEXT_436 = NL + "    \t\t\t" + NL + "            \tif (tempLengthM";
  protected final String TEXT_437 = " >=";
  protected final String TEXT_438 = ") {";
  protected final String TEXT_439 = NL + "                        sb_";
  protected final String TEXT_440 = ".append(tempStringM";
  protected final String TEXT_441 = ");";
  protected final String TEXT_442 = NL + "                    \t\tbyteArray_";
  protected final String TEXT_443 = "=arrays_";
  protected final String TEXT_444 = ".copyOfRange(tempStringM";
  protected final String TEXT_445 = ".getBytes(";
  protected final String TEXT_446 = "),tempLengthM";
  protected final String TEXT_447 = " - ";
  protected final String TEXT_448 = ",tempLengthM";
  protected final String TEXT_449 = ");" + NL + "\t                    \tsb_";
  protected final String TEXT_450 = ".append(new String(byteArray_";
  protected final String TEXT_451 = ",";
  protected final String TEXT_452 = "));";
  protected final String TEXT_453 = NL + "    \t                    sb_";
  protected final String TEXT_454 = ".append(tempStringM";
  protected final String TEXT_455 = ".substring(tempLengthM";
  protected final String TEXT_456 = "-";
  protected final String TEXT_457 = "));";
  protected final String TEXT_458 = NL + "                        int begin";
  protected final String TEXT_459 = "=(tempLengthM";
  protected final String TEXT_460 = "-";
  protected final String TEXT_461 = ")/2;";
  protected final String TEXT_462 = NL + "\t\t\t\t\t\t\tbyteArray_";
  protected final String TEXT_463 = "=arrays_";
  protected final String TEXT_464 = ".copyOfRange(tempStringM";
  protected final String TEXT_465 = ".getBytes(";
  protected final String TEXT_466 = "),begin";
  protected final String TEXT_467 = ",begin";
  protected final String TEXT_468 = "+";
  protected final String TEXT_469 = ");" + NL + "\t                    \tsb_";
  protected final String TEXT_470 = ".append(new String(byteArray_";
  protected final String TEXT_471 = ",";
  protected final String TEXT_472 = "));";
  protected final String TEXT_473 = NL + "    \t                    sb_";
  protected final String TEXT_474 = ".append(tempStringM";
  protected final String TEXT_475 = ".substring(begin";
  protected final String TEXT_476 = ", begin";
  protected final String TEXT_477 = "+";
  protected final String TEXT_478 = "));";
  protected final String TEXT_479 = NL + "                    \t\tbyteArray_";
  protected final String TEXT_480 = "=arrays_";
  protected final String TEXT_481 = ".copyOfRange(tempStringM";
  protected final String TEXT_482 = ".getBytes(";
  protected final String TEXT_483 = "),0,";
  protected final String TEXT_484 = ");" + NL + "                    \t\tsb_";
  protected final String TEXT_485 = ".append(new String(byteArray_";
  protected final String TEXT_486 = ",";
  protected final String TEXT_487 = "));";
  protected final String TEXT_488 = NL + "                    \t\tsb_";
  protected final String TEXT_489 = ".append(tempStringM";
  protected final String TEXT_490 = ".substring(0, ";
  protected final String TEXT_491 = "));";
  protected final String TEXT_492 = NL + "                }else if(tempLengthM";
  protected final String TEXT_493 = "<";
  protected final String TEXT_494 = "){" + NL + "                   ";
  protected final String TEXT_495 = NL + "                        sb_";
  protected final String TEXT_496 = ".append(tempStringM";
  protected final String TEXT_497 = ");" + NL + "                        for(int i_";
  protected final String TEXT_498 = "=0; i_";
  protected final String TEXT_499 = "< ";
  protected final String TEXT_500 = "-tempLengthM";
  protected final String TEXT_501 = "; i_";
  protected final String TEXT_502 = "++){" + NL + "                            sb_";
  protected final String TEXT_503 = ".append(";
  protected final String TEXT_504 = ");" + NL + "                        }" + NL + "                        ";
  protected final String TEXT_505 = NL + "                        for(int i_";
  protected final String TEXT_506 = "=0; i_";
  protected final String TEXT_507 = "< ";
  protected final String TEXT_508 = "-tempLengthM";
  protected final String TEXT_509 = "; i_";
  protected final String TEXT_510 = "++){" + NL + "                            sb_";
  protected final String TEXT_511 = ".append(";
  protected final String TEXT_512 = ");" + NL + "                        }" + NL + "                        sb_";
  protected final String TEXT_513 = ".append(tempStringM";
  protected final String TEXT_514 = ");" + NL + "                        ";
  protected final String TEXT_515 = NL + "                        int temp";
  protected final String TEXT_516 = "= (";
  protected final String TEXT_517 = "-tempLengthM";
  protected final String TEXT_518 = ")/2;" + NL + "                        for(int i_";
  protected final String TEXT_519 = "=0;i_";
  protected final String TEXT_520 = "<temp";
  protected final String TEXT_521 = ";i_";
  protected final String TEXT_522 = "++){" + NL + "                            sb_";
  protected final String TEXT_523 = ".append(";
  protected final String TEXT_524 = ");" + NL + "                        }" + NL + "                        sb_";
  protected final String TEXT_525 = ".append(tempStringM";
  protected final String TEXT_526 = ");" + NL + "                        for(int i=temp";
  protected final String TEXT_527 = "+tempLengthM";
  protected final String TEXT_528 = ";i<";
  protected final String TEXT_529 = ";i++){" + NL + "                            sb_";
  protected final String TEXT_530 = ".append(";
  protected final String TEXT_531 = ");" + NL + "                        }" + NL + "" + NL + "                        ";
  protected final String TEXT_532 = "       " + NL + "                }" + NL + "                //get  and format output String end\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_533 = NL + "                 }";
  protected final String TEXT_534 = NL + "                   }";
  protected final String TEXT_535 = NL + "\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tPositionUtil_";
  protected final String TEXT_536 = " positionUtil_";
  protected final String TEXT_537 = "=new PositionUtil_";
  protected final String TEXT_538 = "();" + NL + "\t\t";
  protected final String TEXT_539 = NL + "\t\tString fileNewName_";
  protected final String TEXT_540 = " = ";
  protected final String TEXT_541 = ";" + NL + "\t\tjava.io.File createFile";
  protected final String TEXT_542 = " = new java.io.File(fileNewName_";
  protected final String TEXT_543 = ");" + NL + "\t\tboolean isFileGenerated_";
  protected final String TEXT_544 = " = true;" + NL + "\t\tresourceMap.put(\"createFile";
  protected final String TEXT_545 = "\", createFile";
  protected final String TEXT_546 = ");" + NL + "\t\tresourceMap.put(\"isFileGenerated_";
  protected final String TEXT_547 = "\", isFileGenerated_";
  protected final String TEXT_548 = ");";
  protected final String TEXT_549 = NL + "\t\tif(createFile";
  protected final String TEXT_550 = ".exists()){" + NL + "\t\t\tisFileGenerated_";
  protected final String TEXT_551 = " = false;" + NL + "\t\t\tresourceMap.put(\"isFileGenerated_";
  protected final String TEXT_552 = "\", isFileGenerated_";
  protected final String TEXT_553 = ");" + NL + "\t\t}";
  protected final String TEXT_554 = NL + "        //create directory only if not exists" + NL + "        java.io.File parentFile_";
  protected final String TEXT_555 = " = createFile";
  protected final String TEXT_556 = ".getParentFile();" + NL + "        if(parentFile_";
  protected final String TEXT_557 = " != null && !parentFile_";
  protected final String TEXT_558 = ".exists()) {" + NL + "            parentFile_";
  protected final String TEXT_559 = ".mkdirs();" + NL + "        }";
  protected final String TEXT_560 = NL + "        String fullName_";
  protected final String TEXT_561 = " = null;" + NL + "        String extension_";
  protected final String TEXT_562 = " = null;" + NL + "        String directory_";
  protected final String TEXT_563 = " = null;" + NL + "        if((fileNewName_";
  protected final String TEXT_564 = ".indexOf(\"/\") != -1)) {" + NL + "            if(fileNewName_";
  protected final String TEXT_565 = ".lastIndexOf(\".\") < fileNewName_";
  protected final String TEXT_566 = ".lastIndexOf(\"/\")) {" + NL + "                fullName_";
  protected final String TEXT_567 = " = fileNewName_";
  protected final String TEXT_568 = ";" + NL + "                extension_";
  protected final String TEXT_569 = " = \"\";" + NL + "            } else {" + NL + "                fullName_";
  protected final String TEXT_570 = " = fileNewName_";
  protected final String TEXT_571 = ".substring(0, fileNewName_";
  protected final String TEXT_572 = ".lastIndexOf(\".\"));" + NL + "                extension_";
  protected final String TEXT_573 = " = fileNewName_";
  protected final String TEXT_574 = ".substring(fileNewName_";
  protected final String TEXT_575 = ".lastIndexOf(\".\"));" + NL + "            }           " + NL + "            directory_";
  protected final String TEXT_576 = " = fileNewName_";
  protected final String TEXT_577 = ".substring(0, fileNewName_";
  protected final String TEXT_578 = ".lastIndexOf(\"/\"));            " + NL + "        } else {" + NL + "            if(fileNewName_";
  protected final String TEXT_579 = ".lastIndexOf(\".\") != -1) {" + NL + "                fullName_";
  protected final String TEXT_580 = " = fileNewName_";
  protected final String TEXT_581 = ".substring(0, fileNewName_";
  protected final String TEXT_582 = ".lastIndexOf(\".\"));" + NL + "                extension_";
  protected final String TEXT_583 = " = fileNewName_";
  protected final String TEXT_584 = ".substring(fileNewName_";
  protected final String TEXT_585 = ".lastIndexOf(\".\"));" + NL + "            } else {" + NL + "                fullName_";
  protected final String TEXT_586 = " = fileNewName_";
  protected final String TEXT_587 = ";" + NL + "                extension_";
  protected final String TEXT_588 = " = \"\";" + NL + "            }" + NL + "            directory_";
  protected final String TEXT_589 = " = \"\";" + NL + "        }" + NL + "\t\tString zipName_";
  protected final String TEXT_590 = " = fullName_";
  protected final String TEXT_591 = " + \".zip\";" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_592 = " = new java.io.File(zipName_";
  protected final String TEXT_593 = ");" + NL + "\t\tresourceMap.put(\"file_";
  protected final String TEXT_594 = "\", file_";
  protected final String TEXT_595 = ");" + NL + "\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_596 = "=new java.util.zip.ZipOutputStream(" + NL + "\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_597 = ")));" + NL + "\t    zipOut_";
  protected final String TEXT_598 = ".putNextEntry(new java.util.zip.ZipEntry(createFile";
  protected final String TEXT_599 = ".getName()));" + NL + "\t\tfinal ";
  protected final String TEXT_600 = " out";
  protected final String TEXT_601 = " = new ";
  protected final String TEXT_602 = "(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_603 = ",";
  protected final String TEXT_604 = "));" + NL + "\t\tresourceMap.put(\"out";
  protected final String TEXT_605 = "\", out";
  protected final String TEXT_606 = ");";
  protected final String TEXT_607 = NL + "\t\tfinal ";
  protected final String TEXT_608 = " out";
  protected final String TEXT_609 = " = new ";
  protected final String TEXT_610 = "(new java.io.OutputStreamWriter(" + NL + "        \t\tnew java.io.FileOutputStream(fileNewName_";
  protected final String TEXT_611 = ", ";
  protected final String TEXT_612 = "),";
  protected final String TEXT_613 = "));" + NL + "        \t\tresourceMap.put(\"out";
  protected final String TEXT_614 = "\", out";
  protected final String TEXT_615 = ");";
  protected final String TEXT_616 = NL + "\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_617 = "=new java.util.zip.ZipOutputStream(" + NL + "\t    \t\t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_618 = "));" + NL + "\t    zipOut_";
  protected final String TEXT_619 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputPositional\"));" + NL + "\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_620 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_621 = ",";
  protected final String TEXT_622 = ");" + NL + "\t\tresourceMap.put(\"outWriter_";
  protected final String TEXT_623 = "\", outWriter_";
  protected final String TEXT_624 = ");" + NL + "\t\tfinal ";
  protected final String TEXT_625 = " out";
  protected final String TEXT_626 = " = new ";
  protected final String TEXT_627 = "(outWriter_";
  protected final String TEXT_628 = ");" + NL + "\t\tresourceMap.put(\"out";
  protected final String TEXT_629 = "\", out";
  protected final String TEXT_630 = ");";
  protected final String TEXT_631 = NL + "\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_632 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_633 = ",";
  protected final String TEXT_634 = ");" + NL + "\t\tresourceMap.put(\"outWriter_";
  protected final String TEXT_635 = "\", outWriter_";
  protected final String TEXT_636 = ");" + NL + "\t\tfinal ";
  protected final String TEXT_637 = " out";
  protected final String TEXT_638 = " = new ";
  protected final String TEXT_639 = "(outWriter_";
  protected final String TEXT_640 = "); " + NL + "\t\tresourceMap.put(\"out";
  protected final String TEXT_641 = "\", out";
  protected final String TEXT_642 = "); ";
  protected final String TEXT_643 = NL + "\t\tif(createFile";
  protected final String TEXT_644 = ".length()==0){";
  protected final String TEXT_645 = NL + "    \t\t" + NL + "    \t\tString tempStringB";
  protected final String TEXT_646 = "=null;" + NL + "    \t\tint tempLengthB";
  protected final String TEXT_647 = "=0;";
  protected final String TEXT_648 = NL + "            positionUtil_";
  protected final String TEXT_649 = ".writeHeader_";
  protected final String TEXT_650 = "(tempStringB";
  protected final String TEXT_651 = ",tempLengthB";
  protected final String TEXT_652 = ",out";
  protected final String TEXT_653 = ",byteArray_";
  protected final String TEXT_654 = ",arrays_";
  protected final String TEXT_655 = ");";
  protected final String TEXT_656 = NL + "    \t\tout";
  protected final String TEXT_657 = ".write(";
  protected final String TEXT_658 = ");";
  protected final String TEXT_659 = NL + "    \t}";
  protected final String TEXT_660 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
   
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    
    	String cid = node.getUniqueName();
    	
    	String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
        if (encoding!=null) {
            if (("").equals(encoding)) {
                encoding = "undef";
            }
        }
        
        String separator = ElementParameterParser.getValue(
            node,
            "__ROWSEPARATOR__"
        );
        
        String filename = ElementParameterParser.getValue(
            node,
            "__FILENAME__"
        );
		
		boolean useByte = ("true").equals(ElementParameterParser.getValue(node, "__USE_BYTE__"));
		
        boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));

        boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
        
		boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
		String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
        
        String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);        
 
        List<Map<String, String>> formats =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__FORMATS__"
            );
        
        boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
        
        boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
        String writerClass = null;
    	if(isInRowMode){
    		writerClass = "routines.system.BufferedOutput";
    	}else{
    		writerClass = "java.io.BufferedWriter";
    	}
		String dynamic = ElementParameterParser.getValue(node, "__DYNAMIC__");
		boolean useExistingDynamic = "true".equals(ElementParameterParser.getValue(node, "__USE_EXISTING_DYNAMIC__"));
        String dyn = dynamic+"_DYNAMIC";
		if(useExistingDynamic){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
		}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
		if(useByte){

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
		}

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
		    List<IMetadataColumn> columns = metadata.getListColumns();
    		int sizeColumns = columns.size();
    		if(isIncludeHeader){
    		for (int i = 0; i < sizeColumns; i++) {
    			IMetadataColumn column = columns.get(i);
    			Map<String, String> format=formats.get(i);
    			if(i%100==0){

    stringBuffer.append(TEXT_20);
    stringBuffer.append(i/100);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
     if(useByte){ 
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
     } 
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
                }

    stringBuffer.append(TEXT_30);
    
				if("id_Dynamic".equals(column.getTalendType())){
					if(useExistingDynamic){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
	    					if(useByte){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_46);
    
    						}else{

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    
    						}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
								if (("\'L\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_58);
    
								} else if (("\'R\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    
								} else {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_77);
    
								}

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
                    			if (("\'A\'").equals(format.get("KEEP"))) {
                    			} else if (("\'R\'").equals(format.get("KEEP"))) {
									if(useByte){

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_91);
    
                        			}else{

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
									}
								} else if (("\'M\'").equals(format.get("KEEP"))) {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
									if(useByte){

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_111);
    
									}else{

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
	                    			}
                    			} else {
                    				if(useByte){

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_126);
    
                    				}else{

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    									}
                    			}

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    
					}
				}else{//not dynamic begin

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_136);
    if(useByte){
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_140);
    }else{
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_146);
    
                    if (("\'A\'").equals(format.get("KEEP"))) {
                    } else if (("\'R\'").equals(format.get("KEEP"))) {
						if(useByte){

    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_157);
    
                        }else{

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_162);
    
						}
                    } else if (("\'M\'").equals(format.get("KEEP"))) {

    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_166);
    
						if(useByte){

    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_177);
    
						}else{

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_183);
    
	                    }
                    } else {
                    	if(useByte){

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_192);
    
                    	}else{

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_196);
    						}
                    }

    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    
                    if (("\'L\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    
                    } else if (("\'R\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    
                    } else {

    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
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
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    
                    } 

    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    
			}//not dynamic end
	          if((i+1)%100==0){

    stringBuffer.append(TEXT_254);
    
              }
    	}
    		  if(sizeColumns>0&&(sizeColumns%100)>0){

    stringBuffer.append(TEXT_255);
    
              }
        }	

    
	  	List< ? extends IConnection> conns = node.getIncomingConnections();
	    for (IConnection conn : conns) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
           for (int i = 0; i < sizeColumns; i++) {
				IMetadataColumn column = columns.get(i);
				Map<String,String> format=formats.get(i);
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				if(i%100==0){

    stringBuffer.append(TEXT_256);
    stringBuffer.append(i/100);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
     if(useByte){ 
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
     } 
    stringBuffer.append(TEXT_265);
    
                }
                if("id_Dynamic".equals(column.getTalendType())){
					if(useExistingDynamic){

    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_270);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    
						if(advancedSeparator){

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_298);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_299);
    
						}

    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    
							if(useByte){

    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_306);
    
    						}else{

    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    
    						}

    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    
								if (("\'L\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_319);
    
								} else if (("\'R\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    
								} else {

    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_341);
    
								}

    stringBuffer.append(TEXT_342);
    
			                    if (("\'A\'").equals(format.get("KEEP"))) {

    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    
			                    } else if (("\'R\'").equals(format.get("KEEP"))) {
			                    	 if(useByte){

    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_356);
    
			                         }else{

    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    
			                    	 }
			                    } else if (("\'M\'").equals(format.get("KEEP"))) {

    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    
									if(useByte){

    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_376);
    
									}else{

    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    
			                    	}
			                    } else {
			                    	if(useByte){

    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_391);
    
			                    	}else{

    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    
									}
								}

    stringBuffer.append(TEXT_396);
    
					}
				}else{

    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    				
				if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable()) ) {
    stringBuffer.append(TEXT_399);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_401);
    					
				} else {
    stringBuffer.append(TEXT_402);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_404);
    
					if(javaType == JavaTypesManager.DATE && patternValue!=null){
					
    stringBuffer.append(TEXT_405);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_407);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_408);
    
					}else if(javaType == JavaTypesManager.BYTE_ARRAY){
					
    stringBuffer.append(TEXT_409);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_411);
    
					}else if(javaType == JavaTypesManager.STRING){
					
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_412);
    stringBuffer.append(column.getLabel() );
    
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
							
    stringBuffer.append(TEXT_413);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_414);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_415);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_416);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_417);
     } else { 
    stringBuffer.append(TEXT_418);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_419);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_420);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_421);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_422);
     } 
    stringBuffer.append(TEXT_423);
    
					}else if (javaType == JavaTypesManager.BIGDECIMAL) {
					
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_424);
     }else{
					
    stringBuffer.append(TEXT_425);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_426);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_427);
    
					}
				}
    stringBuffer.append(TEXT_428);
    if(useByte){
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_432);
    }else{
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    }
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_437);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_438);
    
                    if (("\'A\'").equals(format.get("KEEP"))) {
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_441);
    
                    } else if (("\'R\'").equals(format.get("KEEP"))) {
                    	 if(useByte){
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_447);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_452);
    
                         }else{

    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_456);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_457);
    
                    	 }
                    } else if (("\'M\'").equals(format.get("KEEP"))) {

    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_460);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_461);
    
						if(useByte){

    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_465);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_471);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_472);
    
						}else{

    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_477);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_478);
    
                    	}
                    } else {
                    	if(useByte){

    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_487);
    
                    	}else{

    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_491);
    
                    	}
                    }
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_494);
    
                    if (("\'L\'").equals(format.get("ALIGN"))) {
                    
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_499);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_504);
    
                    } else if (("\'R\'").equals(format.get("ALIGN"))) {
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_511);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_514);
    
                    } else {
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_516);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_530);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_531);
    
                    } 
    stringBuffer.append(TEXT_532);
    
				if((i+1)%100==0){

    stringBuffer.append(TEXT_533);
    
				}
				}//other columns (not dynamic)	end
			}
		}
                if(sizeColumns>0&&(sizeColumns%100)>0){

    stringBuffer.append(TEXT_534);
    
                 }
          }

    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    
		if(!useStream){// the part of file path

    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    
			if(isAppend){

    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    
			}
			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    
			}
			if(compress && !isAppend){// compress the dest file

    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_601);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_603);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_606);
    
			}else{

    stringBuffer.append(TEXT_607);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_609);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    stringBuffer.append( isAppend);
    stringBuffer.append(TEXT_612);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_615);
    
			}
		}else{ //the part of the output stream
			if(compress && !isAppend){// compress the dest output stream

    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_621);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_624);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_626);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_630);
    
			}else{

    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_632);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_633);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_636);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_638);
    stringBuffer.append(writerClass );
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_642);
    
			}
		}
		
		if(isIncludeHeader){      	
			if(!useStream){

    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    
			}
			

    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_647);
    
    		for (int i = 0; i < sizeColumns; i++) {
    			if(i%100==0){

    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(i/100);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid );
     if(useByte){ 
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid );
     }
    stringBuffer.append(TEXT_655);
    
                }
            }

    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_657);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_658);
    
			if(!useStream){

    stringBuffer.append(TEXT_659);
    
			}
		}
    }
}

    stringBuffer.append(TEXT_660);
    return stringBuffer.toString();
  }
}
