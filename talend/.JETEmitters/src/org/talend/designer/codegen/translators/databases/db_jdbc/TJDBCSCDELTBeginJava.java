package org.talend.designer.codegen.translators.databases.db_jdbc;

import org.talend.core.model.metadata.IMetadataColumn;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.MappingTypeRetriever;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import org.talend.commons.utils.StringUtils;

public class TJDBCSCDELTBeginJava {
  protected static String nl;
  public static synchronized TJDBCSCDELTBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCSCDELTBeginJava result = new TJDBCSCDELTBeginJava();
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
  protected final String TEXT_47 = NL + "    java.sql.Connection conn_";
  protected final String TEXT_48 = " = (java.sql.Connection) globalMap.get(\"";
  protected final String TEXT_49 = "\");" + NL + "    String dbUser_";
  protected final String TEXT_50 = " = (String)globalMap.get(\"";
  protected final String TEXT_51 = "\");";
  protected final String TEXT_52 = NL + "    java.lang.Class.forName(";
  protected final String TEXT_53 = ");" + NL + "    String url_";
  protected final String TEXT_54 = " = ";
  protected final String TEXT_55 = ";" + NL + "    String dbUser_";
  protected final String TEXT_56 = " = ";
  protected final String TEXT_57 = ";" + NL;
  protected final String TEXT_58 = NL;
  protected final String TEXT_59 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_60 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = "; ";
  protected final String TEXT_65 = NL + NL + "    String dbPwd_";
  protected final String TEXT_66 = " = decryptedPassword_";
  protected final String TEXT_67 = ";" + NL + "" + NL + "    java.sql.Connection conn_";
  protected final String TEXT_68 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_69 = ", dbUser_";
  protected final String TEXT_70 = ", dbPwd_";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL;
  protected final String TEXT_73 = NL + NL + "String dbschema_";
  protected final String TEXT_74 = " = ";
  protected final String TEXT_75 = ";" + NL + "String sourceTable_";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = ";" + NL + "String tableName_";
  protected final String TEXT_78 = " = ";
  protected final String TEXT_79 = ";" + NL;
  protected final String TEXT_80 = NL + "String schemaForSearch_";
  protected final String TEXT_81 = " = null;" + NL + "String tableForSearch_";
  protected final String TEXT_82 = " = tableName_";
  protected final String TEXT_83 = ";";
  protected final String TEXT_84 = NL + NL + "if(dbschema_";
  protected final String TEXT_85 = "!=null && !dbschema_";
  protected final String TEXT_86 = ".trim().isEmpty()) {" + NL + "\ttableName_";
  protected final String TEXT_87 = " = dbschema_";
  protected final String TEXT_88 = " + \"";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = "\" + tableName_";
  protected final String TEXT_91 = ";" + NL + "    sourceTable_";
  protected final String TEXT_92 = " = dbschema_";
  protected final String TEXT_93 = " + \"";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = "\" + sourceTable_";
  protected final String TEXT_96 = ";" + NL + "    ";
  protected final String TEXT_97 = NL + "    schemaForSearch_";
  protected final String TEXT_98 = " = dbschema_";
  protected final String TEXT_99 = ";";
  protected final String TEXT_100 = NL + "}" + NL;
  protected final String TEXT_101 = NL;
  protected final String TEXT_102 = NL + "int deletedCount_";
  protected final String TEXT_103 = " = 0;";
  protected final String TEXT_104 = NL;
  protected final String TEXT_105 = NL + "            java.sql.Statement stmtDrop_";
  protected final String TEXT_106 = " = conn_";
  protected final String TEXT_107 = ".createStatement();";
  protected final String TEXT_108 = NL + "                              stmtDrop_";
  protected final String TEXT_109 = ".setQueryTimeout(Integer.valueOf(Integer.valueOf(";
  protected final String TEXT_110 = ")));";
  protected final String TEXT_111 = NL + "            stmtDrop_";
  protected final String TEXT_112 = ".execute(\"";
  protected final String TEXT_113 = "\" ";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = NL + "            stmtDrop_";
  protected final String TEXT_116 = ".close();" + NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_117 = " = conn_";
  protected final String TEXT_118 = ".createStatement();";
  protected final String TEXT_119 = NL + "                              stmtCreate_";
  protected final String TEXT_120 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_121 = "));";
  protected final String TEXT_122 = NL + "                    stmtCreate_";
  protected final String TEXT_123 = ".execute(((\"";
  protected final String TEXT_124 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = ", \"";
  protected final String TEXT_127 = "\")";
  protected final String TEXT_128 = ".toUpperCase()";
  protected final String TEXT_129 = ")+\")";
  protected final String TEXT_130 = "\"));";
  protected final String TEXT_131 = NL + "                stmtCreate_";
  protected final String TEXT_132 = ".execute(\"";
  protected final String TEXT_133 = ")\");";
  protected final String TEXT_134 = NL + "            stmtCreate_";
  protected final String TEXT_135 = ".close();";
  protected final String TEXT_136 = NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_137 = " = conn_";
  protected final String TEXT_138 = ".createStatement();";
  protected final String TEXT_139 = NL + "                              stmtCreate_";
  protected final String TEXT_140 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_141 = "));";
  protected final String TEXT_142 = NL + "                    stmtCreate_";
  protected final String TEXT_143 = ".execute(((\"";
  protected final String TEXT_144 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = ", \"";
  protected final String TEXT_147 = "\")";
  protected final String TEXT_148 = ".toUpperCase()";
  protected final String TEXT_149 = ")+\")";
  protected final String TEXT_150 = "\"));";
  protected final String TEXT_151 = NL + "                stmtCreate_";
  protected final String TEXT_152 = ".execute(\"";
  protected final String TEXT_153 = ")\");";
  protected final String TEXT_154 = NL + "            stmtCreate_";
  protected final String TEXT_155 = ".close();";
  protected final String TEXT_156 = NL;
  protected final String TEXT_157 = NL + "                    String keyCheckTable_";
  protected final String TEXT_158 = " = \"[Informix]\"+\"[\"+";
  protected final String TEXT_159 = "+\"][\"+";
  protected final String TEXT_160 = "+\"][\"+";
  protected final String TEXT_161 = "+\"][\"+";
  protected final String TEXT_162 = "+\"][\"+";
  protected final String TEXT_163 = "+\"]\"+ \"[checktable]\" + \"[\" + ";
  protected final String TEXT_164 = " + \"]\";";
  protected final String TEXT_165 = NL + "                    // [%connection%][checktable][tableName]" + NL + "                    String keyCheckTable_";
  protected final String TEXT_166 = " = conn_";
  protected final String TEXT_167 = " + \"[checktable]\" + \"[\" + ";
  protected final String TEXT_168 = " + \"]\";";
  protected final String TEXT_169 = NL + NL + "                if(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_170 = ")== null){//}" + NL + "" + NL + "                    synchronized (GlobalResource.resourceLockMap.get(keyCheckTable_";
  protected final String TEXT_171 = ")) {//}" + NL + "                        if(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_172 = ")== null){//}";
  protected final String TEXT_173 = NL + "                                java.sql.Statement isExistStmt_";
  protected final String TEXT_174 = " = conn_";
  protected final String TEXT_175 = ".createStatement();" + NL + "                                boolean whetherExist_";
  protected final String TEXT_176 = " = false;" + NL + "                                try {" + NL + "                                    isExistStmt_";
  protected final String TEXT_177 = ".execute(\"SELECT TOP 1 1 FROM [\" + tableName_";
  protected final String TEXT_178 = " + \"]\" );" + NL + "                                    whetherExist_";
  protected final String TEXT_179 = " = true;" + NL + "                                } catch (java.lang.Exception e){" + NL + "                                    whetherExist_";
  protected final String TEXT_180 = " = false;" + NL + "                                }" + NL + "                                isExistStmt_";
  protected final String TEXT_181 = ".close();";
  protected final String TEXT_182 = NL + "                                ";
  protected final String TEXT_183 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_184 = " = conn_";
  protected final String TEXT_185 = ".getMetaData();" + NL + "                                if(tableNameForSearch_";
  protected final String TEXT_186 = ".indexOf(\"\\\"\")==-1){" + NL + "                                    tableNameForSearch_";
  protected final String TEXT_187 = " = tableNameForSearch_";
  protected final String TEXT_188 = ".toUpperCase();" + NL + "                                }else{" + NL + "                                    tableNameForSearch_";
  protected final String TEXT_189 = " = tableNameForSearch_";
  protected final String TEXT_190 = ".replaceAll(\"\\\"\",\"\");" + NL + "                                }" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_191 = " = dbMetaData_";
  protected final String TEXT_192 = ".getTables(null, dbschemaForSearch_";
  protected final String TEXT_193 = ", tableNameForSearch_";
  protected final String TEXT_194 = ", new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_195 = " = false;" + NL + "                                if(rsTable_";
  protected final String TEXT_196 = ".next()) {" + NL + "                                    whetherExist_";
  protected final String TEXT_197 = " = true;" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_198 = ".close();" + NL;
  protected final String TEXT_199 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_200 = " = conn_";
  protected final String TEXT_201 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_202 = " = dbMetaData_";
  protected final String TEXT_203 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_204 = " = false;" + NL + "                                while(rsTable_";
  protected final String TEXT_205 = ".next()) {" + NL + "                                    String table_";
  protected final String TEXT_206 = " = rsTable_";
  protected final String TEXT_207 = ".getString(\"TABLE_NAME\");" + NL + "                                    String schema_";
  protected final String TEXT_208 = " = rsTable_";
  protected final String TEXT_209 = ".getString(\"TABLE_SCHEM\");" + NL + "                                    if(table_";
  protected final String TEXT_210 = ".equals";
  protected final String TEXT_211 = "IgnoreCase";
  protected final String TEXT_212 = "(";
  protected final String TEXT_213 = ")" + NL + "                                        && (schema_";
  protected final String TEXT_214 = ".equals";
  protected final String TEXT_215 = "IgnoreCase";
  protected final String TEXT_216 = "(dbschema_";
  protected final String TEXT_217 = ") || dbschema_";
  protected final String TEXT_218 = ".trim().length() ==0)) {" + NL + "                                        whetherExist_";
  protected final String TEXT_219 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_220 = ".close();";
  protected final String TEXT_221 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_222 = " = conn_";
  protected final String TEXT_223 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_224 = " = dbMetaData_";
  protected final String TEXT_225 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_226 = " = false;" + NL + "                                while(rsTable_";
  protected final String TEXT_227 = ".next()) {" + NL + "                                    String table_";
  protected final String TEXT_228 = " = rsTable_";
  protected final String TEXT_229 = ".getString(\"TABLE_NAME\");" + NL + "                                    String schema_";
  protected final String TEXT_230 = " = rsTable_";
  protected final String TEXT_231 = ".getString(\"TABLE_SCHEM\");" + NL + "                                    if(table_";
  protected final String TEXT_232 = ".equals";
  protected final String TEXT_233 = "IgnoreCase";
  protected final String TEXT_234 = "((";
  protected final String TEXT_235 = ")";
  protected final String TEXT_236 = ".toUpperCase()";
  protected final String TEXT_237 = ")" + NL + "                                        && (schema_";
  protected final String TEXT_238 = ".equals";
  protected final String TEXT_239 = "IgnoreCase";
  protected final String TEXT_240 = "(dbschema_";
  protected final String TEXT_241 = ") || (dbschema_";
  protected final String TEXT_242 = ".trim().length() ==0 && dbUser_";
  protected final String TEXT_243 = ".equalsIgnoreCase(schema_";
  protected final String TEXT_244 = ")))) {" + NL + "                                        whetherExist_";
  protected final String TEXT_245 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_246 = ".close();";
  protected final String TEXT_247 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_248 = " = conn_";
  protected final String TEXT_249 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_250 = " = dbMetaData_";
  protected final String TEXT_251 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_252 = " = false;" + NL + "                                String defaultSchema_";
  protected final String TEXT_253 = " = \"public\";" + NL + "                                if(dbschema_";
  protected final String TEXT_254 = " == null || dbschema_";
  protected final String TEXT_255 = ".trim().length() == 0) {" + NL + "                                    java.sql.Statement stmtSchema_";
  protected final String TEXT_256 = " = conn_";
  protected final String TEXT_257 = ".createStatement();" + NL + "                                    java.sql.ResultSet rsSchema_";
  protected final String TEXT_258 = " = stmtSchema_";
  protected final String TEXT_259 = ".executeQuery(\"select current_schema() \");" + NL + "                                    while(rsSchema_";
  protected final String TEXT_260 = ".next()){" + NL + "                                        defaultSchema_";
  protected final String TEXT_261 = " = rsSchema_";
  protected final String TEXT_262 = ".getString(\"current_schema\");" + NL + "                                    }" + NL + "                                    rsSchema_";
  protected final String TEXT_263 = ".close();" + NL + "                                    stmtSchema_";
  protected final String TEXT_264 = ".close();" + NL + "                                }" + NL + "                                while(rsTable_";
  protected final String TEXT_265 = ".next()) {" + NL + "                                    String table_";
  protected final String TEXT_266 = " = rsTable_";
  protected final String TEXT_267 = ".getString(\"TABLE_NAME\");" + NL + "                                    String schema_";
  protected final String TEXT_268 = " = rsTable_";
  protected final String TEXT_269 = ".getString(\"TABLE_SCHEM\");" + NL + "                                    if(table_";
  protected final String TEXT_270 = ".equals";
  protected final String TEXT_271 = "IgnoreCase";
  protected final String TEXT_272 = "(";
  protected final String TEXT_273 = ")" + NL + "                                        && (schema_";
  protected final String TEXT_274 = ".equals";
  protected final String TEXT_275 = "IgnoreCase";
  protected final String TEXT_276 = "(dbschema_";
  protected final String TEXT_277 = ") || ((dbschema_";
  protected final String TEXT_278 = " ==null || dbschema_";
  protected final String TEXT_279 = ".trim().length() ==0) && defaultSchema_";
  protected final String TEXT_280 = ".equals";
  protected final String TEXT_281 = "IgnoreCase";
  protected final String TEXT_282 = "(schema_";
  protected final String TEXT_283 = ")))) {" + NL + "                                        whetherExist_";
  protected final String TEXT_284 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_285 = ".close();";
  protected final String TEXT_286 = NL + "\t\t\t\t            \tString tableForSearch_";
  protected final String TEXT_287 = " = ";
  protected final String TEXT_288 = ";" + NL + "\t\t\t\t            \tif(tableForSearch_";
  protected final String TEXT_289 = " != null){" + NL + "\t\t\t\t            \t\tif(tableForSearch_";
  protected final String TEXT_290 = ".startsWith(\"\\\"\") && tableForSearch_";
  protected final String TEXT_291 = ".endsWith(\"\\\"\")){" + NL + "\t\t\t\t            \t\t\ttableForSearch_";
  protected final String TEXT_292 = " =  tableForSearch_";
  protected final String TEXT_293 = ".substring(1,tableForSearch_";
  protected final String TEXT_294 = ".length()-1);" + NL + "\t\t\t\t            \t\t}else{" + NL + "\t\t\t\t            \t\t\ttableForSearch_";
  protected final String TEXT_295 = " =  tableForSearch_";
  protected final String TEXT_296 = ".toUpperCase();" + NL + "\t\t\t\t            \t\t}" + NL + "\t\t\t\t            \t}" + NL + "\t\t\t\t                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_297 = " = conn_";
  protected final String TEXT_298 = ".getMetaData();" + NL + "\t\t\t\t                java.sql.ResultSet rsTable_";
  protected final String TEXT_299 = " = dbMetaData_";
  protected final String TEXT_300 = ".getTables(null, conn_";
  protected final String TEXT_301 = ".getSchema(), tableForSearch_";
  protected final String TEXT_302 = ", new String[]{\"TABLE\"});" + NL + "\t\t\t\t                boolean whetherExist_";
  protected final String TEXT_303 = " = false;" + NL + "\t\t\t\t               \tif(rsTable_";
  protected final String TEXT_304 = ".next()) {" + NL + "\t\t\t\t\t\t\t\t\twhetherExist_";
  protected final String TEXT_305 = " = true;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t                rsTable_";
  protected final String TEXT_306 = ".close();" + NL + "\t\t\t\t            ";
  protected final String TEXT_307 = NL + "\t\t\t\t                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_308 = " = conn_";
  protected final String TEXT_309 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_310 = " = dbMetaData_";
  protected final String TEXT_311 = ".getTables(null, schemaForSearch_";
  protected final String TEXT_312 = ", null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_313 = " = false;" + NL + "                                while(rsTable_";
  protected final String TEXT_314 = ".next()) {" + NL + "                                    if(rsTable_";
  protected final String TEXT_315 = ".getString(\"TABLE_NAME\").equalsIgnoreCase(tableForSearch_";
  protected final String TEXT_316 = ")) {" + NL + "                                        whetherExist_";
  protected final String TEXT_317 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_318 = ".close();";
  protected final String TEXT_319 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_320 = " = conn_";
  protected final String TEXT_321 = ".getMetaData();" + NL + "                                java.sql.ResultSet rsTable_";
  protected final String TEXT_322 = " = dbMetaData_";
  protected final String TEXT_323 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                                boolean whetherExist_";
  protected final String TEXT_324 = " = false;" + NL + "                                while(rsTable_";
  protected final String TEXT_325 = ".next()) {" + NL + "                                    String table_";
  protected final String TEXT_326 = " = rsTable_";
  protected final String TEXT_327 = ".getString(\"TABLE_NAME\");" + NL + "                                    if(table_";
  protected final String TEXT_328 = ".equalsIgnoreCase(";
  protected final String TEXT_329 = ")) {" + NL + "                                        whetherExist_";
  protected final String TEXT_330 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }" + NL + "                                rsTable_";
  protected final String TEXT_331 = ".close();";
  protected final String TEXT_332 = NL + "                                if(!whetherExist_";
  protected final String TEXT_333 = ") {" + NL + "                                    java.sql.Statement stmtCreate_";
  protected final String TEXT_334 = " = conn_";
  protected final String TEXT_335 = ".createStatement();";
  protected final String TEXT_336 = NL + "                                                      stmtCreate_";
  protected final String TEXT_337 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_338 = "));";
  protected final String TEXT_339 = NL + "                                            stmtCreate_";
  protected final String TEXT_340 = ".execute(((\"";
  protected final String TEXT_341 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_342 = ".";
  protected final String TEXT_343 = ", \"";
  protected final String TEXT_344 = "\")";
  protected final String TEXT_345 = ".toUpperCase()";
  protected final String TEXT_346 = ")+\")";
  protected final String TEXT_347 = "\"));";
  protected final String TEXT_348 = NL + "                                        stmtCreate_";
  protected final String TEXT_349 = ".execute(\"";
  protected final String TEXT_350 = ")\");";
  protected final String TEXT_351 = NL + "                                    stmtCreate_";
  protected final String TEXT_352 = ".close();" + NL + "                                }";
  protected final String TEXT_353 = NL + "                                if(whetherExist_";
  protected final String TEXT_354 = ") {" + NL + "                                    java.sql.Statement stmtDrop_";
  protected final String TEXT_355 = " = conn_";
  protected final String TEXT_356 = ".createStatement();";
  protected final String TEXT_357 = NL + "                                                      stmtDrop_";
  protected final String TEXT_358 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_359 = "));";
  protected final String TEXT_360 = NL + "                                    stmtDrop_";
  protected final String TEXT_361 = ".execute(\"";
  protected final String TEXT_362 = "\" ";
  protected final String TEXT_363 = ");";
  protected final String TEXT_364 = NL + "                                    stmtDrop_";
  protected final String TEXT_365 = ".close();" + NL + "                                }" + NL + "                                java.sql.Statement stmtCreate_";
  protected final String TEXT_366 = " = conn_";
  protected final String TEXT_367 = ".createStatement();";
  protected final String TEXT_368 = NL + "                                                  stmtCreate_";
  protected final String TEXT_369 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_370 = "));";
  protected final String TEXT_371 = NL + "                                        stmtCreate_";
  protected final String TEXT_372 = ".execute(((\"";
  protected final String TEXT_373 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_374 = ".";
  protected final String TEXT_375 = ", \"";
  protected final String TEXT_376 = "\")";
  protected final String TEXT_377 = ".toUpperCase()";
  protected final String TEXT_378 = ")+\")";
  protected final String TEXT_379 = "\"));";
  protected final String TEXT_380 = NL + "                                    stmtCreate_";
  protected final String TEXT_381 = ".execute(\"";
  protected final String TEXT_382 = ")\");";
  protected final String TEXT_383 = NL + "                                stmtCreate_";
  protected final String TEXT_384 = ".close();";
  protected final String TEXT_385 = NL + "                            GlobalResource.resourceMap.put(keyCheckTable_";
  protected final String TEXT_386 = ", true);" + NL + "            //{{{" + NL + "                        } // end of if" + NL + "                    } // end synchronized" + NL + "                }";
  protected final String TEXT_387 = NL + "            java.sql.Statement stmtClear_";
  protected final String TEXT_388 = " = conn_";
  protected final String TEXT_389 = ".createStatement();";
  protected final String TEXT_390 = NL + "                              stmtClear_";
  protected final String TEXT_391 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_392 = "));";
  protected final String TEXT_393 = NL + "            stmtClear_";
  protected final String TEXT_394 = ".executeUpdate(\"";
  protected final String TEXT_395 = "\");";
  protected final String TEXT_396 = NL + "            stmtClear_";
  protected final String TEXT_397 = ".close();";
  protected final String TEXT_398 = NL + "            java.sql.Statement stmtTruncCount_";
  protected final String TEXT_399 = " = conn_";
  protected final String TEXT_400 = ".createStatement();";
  protected final String TEXT_401 = NL + "                              stmtTruncCount_";
  protected final String TEXT_402 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_403 = "));";
  protected final String TEXT_404 = NL + "            java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_405 = " = stmtTruncCount_";
  protected final String TEXT_406 = ".executeQuery(\"";
  protected final String TEXT_407 = "\");" + NL + "            int rsTruncCountNumber_";
  protected final String TEXT_408 = " = 0;" + NL + "            if(rsTruncCount_";
  protected final String TEXT_409 = ".next()) {" + NL + "                rsTruncCountNumber_";
  protected final String TEXT_410 = " = rsTruncCount_";
  protected final String TEXT_411 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_412 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_413 = ".close();" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_414 = " = conn_";
  protected final String TEXT_415 = ".createStatement();";
  protected final String TEXT_416 = NL + "                              stmtTrunc_";
  protected final String TEXT_417 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_418 = "));";
  protected final String TEXT_419 = NL + "                conn_";
  protected final String TEXT_420 = ".commit();";
  protected final String TEXT_421 = NL + "            stmtTrunc_";
  protected final String TEXT_422 = ".executeUpdate(\"";
  protected final String TEXT_423 = "\");";
  protected final String TEXT_424 = NL + "                if(!conn_";
  protected final String TEXT_425 = ".getAutoCommit()){" + NL + "                    conn_";
  protected final String TEXT_426 = ".commit();" + NL + "                }";
  protected final String TEXT_427 = NL + "            deletedCount_";
  protected final String TEXT_428 = " += rsTruncCountNumber_";
  protected final String TEXT_429 = ";" + NL + "            stmtTrunc_";
  protected final String TEXT_430 = ".close();";
  protected final String TEXT_431 = NL + "            java.sql.Statement stmtTruncCount_";
  protected final String TEXT_432 = " = conn_";
  protected final String TEXT_433 = ".createStatement();" + NL + "            java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_434 = " = stmtTruncCount_";
  protected final String TEXT_435 = ".executeQuery(\"";
  protected final String TEXT_436 = "\");" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_437 = " = conn_";
  protected final String TEXT_438 = ".createStatement();";
  protected final String TEXT_439 = NL + "                conn_";
  protected final String TEXT_440 = ".commit();";
  protected final String TEXT_441 = NL + "            stmtTrunc_";
  protected final String TEXT_442 = ".executeUpdate(\"";
  protected final String TEXT_443 = "\");";
  protected final String TEXT_444 = NL + "            while(rsTruncCount_";
  protected final String TEXT_445 = ".next()) {" + NL + "                deletedCount_";
  protected final String TEXT_446 = " += rsTruncCount_";
  protected final String TEXT_447 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_448 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_449 = ".close();" + NL + "            stmtTrunc_";
  protected final String TEXT_450 = ".close();";
  protected final String TEXT_451 = NL;
  protected final String TEXT_452 = NL + "    System.out.println(\"[";
  protected final String TEXT_453 = "] table action ";
  protected final String TEXT_454 = " done\\n\");";
  protected final String TEXT_455 = NL;
  protected final String TEXT_456 = NL;
  protected final String TEXT_457 = NL + "String sequence_";
  protected final String TEXT_458 = " = ";
  protected final String TEXT_459 = ";" + NL + "" + NL + "String sequenceValueFetchPattern_";
  protected final String TEXT_460 = " = \"NEXT VALUE FOR ";
  protected final String TEXT_461 = "\";";
  protected final String TEXT_462 = NL;
  protected final String TEXT_463 = NL + "\t";
  protected final String TEXT_464 = NL;
  protected final String TEXT_465 = NL + "    String updateForType1_";
  protected final String TEXT_466 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_467 = " + \"` d, `\" + sourceTable_";
  protected final String TEXT_468 = " + \"` t SET ";
  protected final String TEXT_469 = " WHERE ";
  protected final String TEXT_470 = " AND (";
  protected final String TEXT_471 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_472 = " = conn_";
  protected final String TEXT_473 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_474 = ".executeUpdate(updateForType1_";
  protected final String TEXT_475 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_476 = ".close();";
  protected final String TEXT_477 = NL + "        System.out.println(\"[";
  protected final String TEXT_478 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_479 = " + \"\\ndone\");";
  protected final String TEXT_480 = "        " + NL + "    String changeDateTime_";
  protected final String TEXT_481 = " = (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_482 = "\"))).toString();" + NL + "\t";
  protected final String TEXT_483 = NL + "    String changeDateTime_";
  protected final String TEXT_484 = "_begin = changeDateTime_";
  protected final String TEXT_485 = ";" + NL + "    String changeDateTime_";
  protected final String TEXT_486 = "_end = changeDateTime_";
  protected final String TEXT_487 = ";" + NL + "    ";
  protected final String TEXT_488 = NL + "\t        changeDateTime_";
  protected final String TEXT_489 = "_begin = routines.system.DBDateParser.getDBDateParser(\"";
  protected final String TEXT_490 = "\").getDateString(\"";
  protected final String TEXT_491 = "\",\"";
  protected final String TEXT_492 = "\",(Long)start_Hash.get(\"";
  protected final String TEXT_493 = "\"),";
  protected final String TEXT_494 = ");" + NL + "\t";
  protected final String TEXT_495 = NL + "    \t\tchangeDateTime_";
  protected final String TEXT_496 = "_end = routines.system.DBDateParser.getDBDateParser(\"";
  protected final String TEXT_497 = "\").getDateString(\"";
  protected final String TEXT_498 = "\",\"";
  protected final String TEXT_499 = "\",(Long)start_Hash.get(\"";
  protected final String TEXT_500 = "\"),";
  protected final String TEXT_501 = ");";
  protected final String TEXT_502 = NL + "    String updateForType2_";
  protected final String TEXT_503 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_504 = " + \"` d, `\" + sourceTable_";
  protected final String TEXT_505 = " + \"` t SET `";
  protected final String TEXT_506 = "` = '\" + (changeDateTime_";
  protected final String TEXT_507 = ") + \"'";
  protected final String TEXT_508 = ", `";
  protected final String TEXT_509 = "` = 0";
  protected final String TEXT_510 = " WHERE ";
  protected final String TEXT_511 = " AND (";
  protected final String TEXT_512 = ") AND d.`";
  protected final String TEXT_513 = "` IS NULL\"; " + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_514 = " = conn_";
  protected final String TEXT_515 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_516 = ".executeUpdate(updateForType2_";
  protected final String TEXT_517 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_518 = ".close();";
  protected final String TEXT_519 = NL + "    \tString updateForType2_";
  protected final String TEXT_520 = "_debug = \"UPDATE `\" + tableName_";
  protected final String TEXT_521 = " + \"` d, `\" + sourceTable_";
  protected final String TEXT_522 = " + \"` t SET `";
  protected final String TEXT_523 = "` = '\" + (changeDateTime_";
  protected final String TEXT_524 = "_end) + \"'";
  protected final String TEXT_525 = ", `";
  protected final String TEXT_526 = "` = 0";
  protected final String TEXT_527 = " WHERE ";
  protected final String TEXT_528 = " AND (";
  protected final String TEXT_529 = ") AND d.`";
  protected final String TEXT_530 = "` IS NULL\"; " + NL + "        System.out.println(\"[";
  protected final String TEXT_531 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_532 = "_debug + \"\\ndone\");";
  protected final String TEXT_533 = NL + "    String insertForType2_";
  protected final String TEXT_534 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_535 = " + \"`(";
  protected final String TEXT_536 = ") SELECT t.";
  protected final String TEXT_537 = ", '\" + " + NL + "    (changeDateTime_";
  protected final String TEXT_538 = ") + \"', NULL";
  protected final String TEXT_539 = ", 1";
  protected final String TEXT_540 = ", d.`";
  protected final String TEXT_541 = "` + 1";
  protected final String TEXT_542 = " FROM `\" + " + NL + "    sourceTable_";
  protected final String TEXT_543 = " + \"` t, `\" + tableName_";
  protected final String TEXT_544 = " + \"` d WHERE ";
  protected final String TEXT_545 = " AND (";
  protected final String TEXT_546 = ") AND d.`";
  protected final String TEXT_547 = "` = '\" + (changeDateTime_";
  protected final String TEXT_548 = ") + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_549 = " = conn_";
  protected final String TEXT_550 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_551 = ".executeUpdate(insertForType2_";
  protected final String TEXT_552 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_553 = ".close();";
  protected final String TEXT_554 = NL + "\t\tString insertForType2_";
  protected final String TEXT_555 = "_debug = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_556 = " + \"`(";
  protected final String TEXT_557 = ") SELECT t.";
  protected final String TEXT_558 = ", '\" + (changeDateTime_";
  protected final String TEXT_559 = "_begin) + \"', NULL";
  protected final String TEXT_560 = ", 1";
  protected final String TEXT_561 = ", d.`";
  protected final String TEXT_562 = "` + 1";
  protected final String TEXT_563 = " FROM `\" + sourceTable_";
  protected final String TEXT_564 = " + \"` t, `\" + tableName_";
  protected final String TEXT_565 = " + \"` d WHERE ";
  protected final String TEXT_566 = " AND (";
  protected final String TEXT_567 = ") AND d.`";
  protected final String TEXT_568 = "` = '\" + (changeDateTime_";
  protected final String TEXT_569 = "_end) + \"'\";" + NL + "        System.out.println(\"[";
  protected final String TEXT_570 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_571 = "_debug + \"\\ndone\");";
  protected final String TEXT_572 = NL + "String insert_";
  protected final String TEXT_573 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_574 = " + \"`(";
  protected final String TEXT_575 = ") SELECT t.";
  protected final String TEXT_576 = "\"";
  protected final String TEXT_577 = " + \", '\" + (changeDateTime_";
  protected final String TEXT_578 = ") + \"', NULL\"";
  protected final String TEXT_579 = NL + "+ \"";
  protected final String TEXT_580 = ", 1";
  protected final String TEXT_581 = ", 1";
  protected final String TEXT_582 = " FROM `\" + " + NL + "sourceTable_";
  protected final String TEXT_583 = " + \"` t LEFT JOIN `\" + tableName_";
  protected final String TEXT_584 = " + \"` d ON ";
  protected final String TEXT_585 = " WHERE (";
  protected final String TEXT_586 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_587 = " = conn_";
  protected final String TEXT_588 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_589 = ".executeUpdate(insert_";
  protected final String TEXT_590 = ");" + NL + "stmtInsert_";
  protected final String TEXT_591 = ".close();";
  protected final String TEXT_592 = NL + "\tString insert_";
  protected final String TEXT_593 = "_debug = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_594 = " + \"`(";
  protected final String TEXT_595 = ") SELECT t.";
  protected final String TEXT_596 = "\"";
  protected final String TEXT_597 = " + \", '\" + (changeDateTime_";
  protected final String TEXT_598 = "_begin) + \"', NULL\"";
  protected final String TEXT_599 = " + \"";
  protected final String TEXT_600 = ", 1";
  protected final String TEXT_601 = ", 1";
  protected final String TEXT_602 = " FROM `\" + sourceTable_";
  protected final String TEXT_603 = " + \"` t LEFT JOIN `\" + tableName_";
  protected final String TEXT_604 = " + \"` d ON ";
  protected final String TEXT_605 = " WHERE (";
  protected final String TEXT_606 = ")\";" + NL + "    System.out.println(\"[";
  protected final String TEXT_607 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_608 = "_debug + \"\\ndone\");";
  protected final String TEXT_609 = NL;
  protected final String TEXT_610 = NL + "\t";
  protected final String TEXT_611 = NL;
  protected final String TEXT_612 = NL + "java.util.Date currentDate_";
  protected final String TEXT_613 = " = new java.util.Date((Long)start_Hash.get(\"";
  protected final String TEXT_614 = "\"));" + NL + "String dateString_";
  protected final String TEXT_615 = " = routines.system.FormatterUtils.format_Date(currentDate_";
  protected final String TEXT_616 = ", \"yyyy-MM-dd HH:mm:ss\");" + NL + "String dateValue_";
  protected final String TEXT_617 = " = \"to_date('\" + dateString_";
  protected final String TEXT_618 = " + \"', 'yyyy-mm-dd HH24:MI:SS')\";";
  protected final String TEXT_619 = NL + "    String updateForType1_";
  protected final String TEXT_620 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_621 = " + \" d SET (";
  protected final String TEXT_622 = ") = (SELECT ";
  protected final String TEXT_623 = " FROM \" + sourceTable_";
  protected final String TEXT_624 = " + \" t WHERE ";
  protected final String TEXT_625 = " AND (";
  protected final String TEXT_626 = ")) WHERE EXISTS (SELECT 1 FROM \" + sourceTable_";
  protected final String TEXT_627 = " + \" t WHERE ";
  protected final String TEXT_628 = " AND (";
  protected final String TEXT_629 = "))\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_630 = " = conn_";
  protected final String TEXT_631 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_632 = ".executeUpdate(updateForType1_";
  protected final String TEXT_633 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_634 = ".close();";
  protected final String TEXT_635 = NL + "        System.out.println(\"[";
  protected final String TEXT_636 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_637 = " + \"\\ndone\");";
  protected final String TEXT_638 = NL + "    String updateForType2_";
  protected final String TEXT_639 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_640 = " + \" d SET ";
  protected final String TEXT_641 = " = \" +";
  protected final String TEXT_642 = NL + "        \"(SELECT t.";
  protected final String TEXT_643 = " FROM \" + sourceTable_";
  protected final String TEXT_644 = " +" + NL + "        \" t WHERE ";
  protected final String TEXT_645 = ")\"";
  protected final String TEXT_646 = NL + "    \tdateValue_";
  protected final String TEXT_647 = NL + "    + \"";
  protected final String TEXT_648 = ", ";
  protected final String TEXT_649 = " = 0";
  protected final String TEXT_650 = " WHERE EXISTS (SELECT 1 FROM \" + sourceTable_";
  protected final String TEXT_651 = " +" + NL + "    \" t WHERE ";
  protected final String TEXT_652 = " AND (";
  protected final String TEXT_653 = ")) AND d.";
  protected final String TEXT_654 = " \"" + NL + "    +";
  protected final String TEXT_655 = NL + "     \" IS NULL\";";
  protected final String TEXT_656 = NL + "     \"= to_date ('\" + ";
  protected final String TEXT_657 = " +\"-01-01', 'yyyy-mm-dd')\";";
  protected final String TEXT_658 = NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_659 = " = conn_";
  protected final String TEXT_660 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_661 = ".executeUpdate(updateForType2_";
  protected final String TEXT_662 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_663 = ".close();";
  protected final String TEXT_664 = NL + "        System.out.println(\"[";
  protected final String TEXT_665 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_666 = " + \"\\ndone\");";
  protected final String TEXT_667 = NL + "    String insertForType2_";
  protected final String TEXT_668 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_669 = " + \"(";
  protected final String TEXT_670 = ", ";
  protected final String TEXT_671 = ") SELECT ";
  protected final String TEXT_672 = "\" + ";
  protected final String TEXT_673 = " + \".NEXTVAL, ";
  protected final String TEXT_674 = "t.";
  protected final String TEXT_675 = ", \"" + NL + "    +";
  protected final String TEXT_676 = NL + "    dateValue_";
  protected final String TEXT_677 = NL + "    \"t.";
  protected final String TEXT_678 = "\"";
  protected final String TEXT_679 = NL + "     +";
  protected final String TEXT_680 = NL + "     \", NULL\"";
  protected final String TEXT_681 = NL + "     \", to_date('\"+";
  protected final String TEXT_682 = "+\"-01-01', 'yyyy-mm-dd')\"";
  protected final String TEXT_683 = NL + "     +\"";
  protected final String TEXT_684 = ", 1";
  protected final String TEXT_685 = ", d.";
  protected final String TEXT_686 = " + 1";
  protected final String TEXT_687 = " FROM \" +" + NL + "    sourceTable_";
  protected final String TEXT_688 = " + \" t, \" + tableName_";
  protected final String TEXT_689 = " + \" d WHERE ";
  protected final String TEXT_690 = " AND (";
  protected final String TEXT_691 = ") AND d.";
  protected final String TEXT_692 = " = \"" + NL + "" + NL + "" + NL + "    +";
  protected final String TEXT_693 = NL + "        \"(SELECT t.";
  protected final String TEXT_694 = " FROM \" + sourceTable_";
  protected final String TEXT_695 = " +" + NL + "        \" t WHERE ";
  protected final String TEXT_696 = ")\"";
  protected final String TEXT_697 = NL + "    \tdateValue_";
  protected final String TEXT_698 = NL + "    ;" + NL + "" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_699 = " = conn_";
  protected final String TEXT_700 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_701 = ".executeUpdate(insertForType2_";
  protected final String TEXT_702 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_703 = ".close();";
  protected final String TEXT_704 = NL + "        System.out.println(\"[";
  protected final String TEXT_705 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_706 = " + \"\\ndone\");";
  protected final String TEXT_707 = NL + "String insert_";
  protected final String TEXT_708 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_709 = " + \"(";
  protected final String TEXT_710 = ", ";
  protected final String TEXT_711 = ") SELECT ";
  protected final String TEXT_712 = "\" + ";
  protected final String TEXT_713 = " + \".NEXTVAL, ";
  protected final String TEXT_714 = "t.";
  protected final String TEXT_715 = "\"" + NL;
  protected final String TEXT_716 = " + \", \"" + NL + "\t+" + NL + "\t";
  protected final String TEXT_717 = NL + "\t dateValue_";
  protected final String TEXT_718 = NL + "\t";
  protected final String TEXT_719 = NL + "\t\"t.";
  protected final String TEXT_720 = "\"" + NL + "\t";
  protected final String TEXT_721 = NL + "\t+" + NL + "\t";
  protected final String TEXT_722 = NL + "\t\t\", NULL\"" + NL + "\t";
  protected final String TEXT_723 = NL + "\t\t \", to_date('\"+";
  protected final String TEXT_724 = "+\"-01-01', 'yyyy-mm-dd')\"" + NL + "\t";
  protected final String TEXT_725 = NL;
  protected final String TEXT_726 = NL + NL + "+ \"";
  protected final String TEXT_727 = ", 1";
  protected final String TEXT_728 = ", 1";
  protected final String TEXT_729 = " FROM \" +" + NL + "" + NL + "sourceTable_";
  protected final String TEXT_730 = " + \" t LEFT JOIN \" + tableName_";
  protected final String TEXT_731 = " + \" d ON ";
  protected final String TEXT_732 = " WHERE (";
  protected final String TEXT_733 = ")\";" + NL + "" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_734 = " = conn_";
  protected final String TEXT_735 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_736 = ".executeUpdate(insert_";
  protected final String TEXT_737 = ");" + NL + "stmtInsert_";
  protected final String TEXT_738 = ".close();";
  protected final String TEXT_739 = NL + "    System.out.println(\"[";
  protected final String TEXT_740 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_741 = " + \"\\ndone\");";
  protected final String TEXT_742 = NL;
  protected final String TEXT_743 = NL + "\t";
  protected final String TEXT_744 = NL;
  protected final String TEXT_745 = NL + "    String updateForType1_";
  protected final String TEXT_746 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_747 = " +\" FROM \"+ sourceTable_";
  protected final String TEXT_748 = " + \" t SET ";
  protected final String TEXT_749 = " WHERE ";
  protected final String TEXT_750 = " AND (";
  protected final String TEXT_751 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_752 = " = conn_";
  protected final String TEXT_753 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_754 = ".executeUpdate(updateForType1_";
  protected final String TEXT_755 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_756 = ".close();";
  protected final String TEXT_757 = NL + "    String updateForType2_";
  protected final String TEXT_758 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_759 = NL + "                                    + \" FROM \" + sourceTable_";
  protected final String TEXT_760 = " + \" t\"" + NL + "                                    + \" SET ";
  protected final String TEXT_761 = " = cast('\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_762 = "\")))" + NL + "                                    + \"' as timestamp format 'YYYY-MM-DDBHH:MI:SS.S(F)')";
  protected final String TEXT_763 = ", ";
  protected final String TEXT_764 = " = 0";
  protected final String TEXT_765 = " \"" + NL + "                                    + \" WHERE ";
  protected final String TEXT_766 = " AND (";
  protected final String TEXT_767 = ") AND \" + tableName_";
  protected final String TEXT_768 = " + \".";
  protected final String TEXT_769 = " IS NULL\";" + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_770 = " = conn_";
  protected final String TEXT_771 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_772 = ".executeUpdate(updateForType2_";
  protected final String TEXT_773 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_774 = ".close();";
  protected final String TEXT_775 = NL + "    String insertForType2_";
  protected final String TEXT_776 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_777 = " + \"(";
  protected final String TEXT_778 = ", ";
  protected final String TEXT_779 = ") SELECT ";
  protected final String TEXT_780 = "\" + ";
  protected final String TEXT_781 = " + \".NEXTVAL, ";
  protected final String TEXT_782 = "t.";
  protected final String TEXT_783 = ", cast('\" +" + NL + "    (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_784 = "\"))) + \"' as timestamp format 'YYYY-MM-DDBHH:MI:SS.S(F)'), NULL";
  protected final String TEXT_785 = ", 1";
  protected final String TEXT_786 = ", d.";
  protected final String TEXT_787 = " + 1";
  protected final String TEXT_788 = " FROM \" +" + NL + "    sourceTable_";
  protected final String TEXT_789 = " + \" t, \" + tableName_";
  protected final String TEXT_790 = " + \" d WHERE ";
  protected final String TEXT_791 = " AND (";
  protected final String TEXT_792 = ") AND d.";
  protected final String TEXT_793 = " = cast('\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_794 = "\"))) + \"' as timestamp format 'YYYY-MM-DDBHH:MI:SS.S(F)')\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_795 = " = conn_";
  protected final String TEXT_796 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_797 = ".executeUpdate(insertForType2_";
  protected final String TEXT_798 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_799 = ".close();";
  protected final String TEXT_800 = NL + "String insert_";
  protected final String TEXT_801 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_802 = " + \"(";
  protected final String TEXT_803 = ", ";
  protected final String TEXT_804 = ") SELECT ";
  protected final String TEXT_805 = "\" + ";
  protected final String TEXT_806 = " + \".NEXTVAL, ";
  protected final String TEXT_807 = "t.";
  protected final String TEXT_808 = "\"";
  protected final String TEXT_809 = " + \", cast('\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_810 = "\"))) + \"' as timestamp format 'YYYY-MM-DDBHH:MI:SS.S(F)'), NULL\"";
  protected final String TEXT_811 = NL + "+ \"";
  protected final String TEXT_812 = ", 1";
  protected final String TEXT_813 = ", 1";
  protected final String TEXT_814 = " FROM \" +" + NL + "sourceTable_";
  protected final String TEXT_815 = " + \" t LEFT JOIN \" + tableName_";
  protected final String TEXT_816 = " + \" d ON ";
  protected final String TEXT_817 = " WHERE (";
  protected final String TEXT_818 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_819 = " = conn_";
  protected final String TEXT_820 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_821 = ".executeUpdate(insert_";
  protected final String TEXT_822 = ");" + NL + "stmtInsert_";
  protected final String TEXT_823 = ".close();";
  protected final String TEXT_824 = NL;
  protected final String TEXT_825 = NL + "\t";
  protected final String TEXT_826 = NL;
  protected final String TEXT_827 = NL + "    String updateForType1_";
  protected final String TEXT_828 = " = \"UPDATE \\\"\" + tableName_";
  protected final String TEXT_829 = " + \"\\\" d SET ";
  protected final String TEXT_830 = " FROM \\\"\" + sourceTable_";
  protected final String TEXT_831 = " + \"\\\" t WHERE ";
  protected final String TEXT_832 = " AND (";
  protected final String TEXT_833 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_834 = " = conn_";
  protected final String TEXT_835 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_836 = ".executeUpdate(updateForType1_";
  protected final String TEXT_837 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_838 = ".close();";
  protected final String TEXT_839 = NL + "        System.out.println(\"[";
  protected final String TEXT_840 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_841 = " + \"\\ndone\");";
  protected final String TEXT_842 = NL + "    String updateForType2_";
  protected final String TEXT_843 = " = \"UPDATE \\\"\" + tableName_";
  protected final String TEXT_844 = " + \"\\\" d SET \\\"";
  protected final String TEXT_845 = "\\\" = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_846 = "\"))) + \"'";
  protected final String TEXT_847 = ", \\\"";
  protected final String TEXT_848 = "\\\" = 0";
  protected final String TEXT_849 = " FROM \\\"\" + sourceTable_";
  protected final String TEXT_850 = " + \"\\\" t WHERE ";
  protected final String TEXT_851 = " AND (";
  protected final String TEXT_852 = ") AND d.\\\"";
  protected final String TEXT_853 = "\\\" IS NULL\";" + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_854 = " = conn_";
  protected final String TEXT_855 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_856 = ".executeUpdate(updateForType2_";
  protected final String TEXT_857 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_858 = ".close();";
  protected final String TEXT_859 = NL + "        System.out.println(\"[";
  protected final String TEXT_860 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_861 = " + \"\\ndone\");";
  protected final String TEXT_862 = NL + "    String insertForType2_";
  protected final String TEXT_863 = " = \"INSERT INTO \\\"\" + tableName_";
  protected final String TEXT_864 = " + \"\\\"(";
  protected final String TEXT_865 = "\\\"";
  protected final String TEXT_866 = "\\\", ";
  protected final String TEXT_867 = ") SELECT ";
  protected final String TEXT_868 = "NEXTVAL('\" + ";
  protected final String TEXT_869 = " + \"'), ";
  protected final String TEXT_870 = "t.";
  protected final String TEXT_871 = ", '\" + " + NL + "    (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_872 = "\"))) + \"', NULL";
  protected final String TEXT_873 = ", 1";
  protected final String TEXT_874 = ", d.\\\"";
  protected final String TEXT_875 = "\\\" + 1";
  protected final String TEXT_876 = " FROM \\\"\" + " + NL + "    sourceTable_";
  protected final String TEXT_877 = " + \"\\\" t, \\\"\" + tableName_";
  protected final String TEXT_878 = " + \"\\\" d WHERE ";
  protected final String TEXT_879 = " AND (";
  protected final String TEXT_880 = ") AND d.\\\"";
  protected final String TEXT_881 = "\\\" = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_882 = "\"))) + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_883 = " = conn_";
  protected final String TEXT_884 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_885 = ".executeUpdate(insertForType2_";
  protected final String TEXT_886 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_887 = ".close();";
  protected final String TEXT_888 = NL + "        System.out.println(\"[";
  protected final String TEXT_889 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_890 = " + \"\\ndone\");";
  protected final String TEXT_891 = NL + "String insert_";
  protected final String TEXT_892 = " = \"INSERT INTO \\\"\" + tableName_";
  protected final String TEXT_893 = " + \"\\\"(";
  protected final String TEXT_894 = "\\\"";
  protected final String TEXT_895 = "\\\", ";
  protected final String TEXT_896 = ") SELECT ";
  protected final String TEXT_897 = "NEXTVAL('\" + ";
  protected final String TEXT_898 = " + \"'), ";
  protected final String TEXT_899 = "t.";
  protected final String TEXT_900 = "\"";
  protected final String TEXT_901 = " + \", '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_902 = "\"))) + \"', NULL\"";
  protected final String TEXT_903 = NL + "+ \"";
  protected final String TEXT_904 = ", 1";
  protected final String TEXT_905 = ", 1";
  protected final String TEXT_906 = " FROM \\\"\" + " + NL + "sourceTable_";
  protected final String TEXT_907 = " + \"\\\" t LEFT JOIN \\\"\" + tableName_";
  protected final String TEXT_908 = " + \"\\\" d ON ";
  protected final String TEXT_909 = " WHERE (";
  protected final String TEXT_910 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_911 = " = conn_";
  protected final String TEXT_912 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_913 = ".executeUpdate(insert_";
  protected final String TEXT_914 = ");" + NL + "stmtInsert_";
  protected final String TEXT_915 = ".close();";
  protected final String TEXT_916 = NL + "    System.out.println(\"[";
  protected final String TEXT_917 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_918 = " + \"\\ndone\");";
  protected final String TEXT_919 = NL;
  protected final String TEXT_920 = NL + "\t";
  protected final String TEXT_921 = NL;
  protected final String TEXT_922 = NL + "    String updateForType1_";
  protected final String TEXT_923 = " = \"UPDATE \\\"\" + tableName_";
  protected final String TEXT_924 = " + \"\\\" d SET (";
  protected final String TEXT_925 = ") = (SELECT ";
  protected final String TEXT_926 = " FROM \\\"\" + sourceTable_";
  protected final String TEXT_927 = " + \"\\\" t WHERE ";
  protected final String TEXT_928 = " AND (";
  protected final String TEXT_929 = ")) WHERE EXISTS (SELECT 1 FROM \\\"\" + sourceTable_";
  protected final String TEXT_930 = " + \"\\\" t WHERE ";
  protected final String TEXT_931 = " AND (";
  protected final String TEXT_932 = "))\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_933 = " = conn_";
  protected final String TEXT_934 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_935 = ".executeUpdate(updateForType1_";
  protected final String TEXT_936 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_937 = ".close();";
  protected final String TEXT_938 = NL + "        System.out.println(\"[";
  protected final String TEXT_939 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_940 = " + \"\\ndone\");";
  protected final String TEXT_941 = NL + "    String updateForType2_";
  protected final String TEXT_942 = " = \"UPDATE \\\"\" + tableName_";
  protected final String TEXT_943 = " + \"\\\" d SET \\\"";
  protected final String TEXT_944 = "\\\" = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_945 = "\"))) + \"'";
  protected final String TEXT_946 = ", \\\"";
  protected final String TEXT_947 = "\\\" = 0";
  protected final String TEXT_948 = " WHERE EXISTS (SELECT 1 FROM \\\"\" + sourceTable_";
  protected final String TEXT_949 = " + " + NL + "    \"\\\" t WHERE ";
  protected final String TEXT_950 = " AND (";
  protected final String TEXT_951 = ")) AND d.\\\"";
  protected final String TEXT_952 = "\\\" IS NULL\";" + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_953 = " = conn_";
  protected final String TEXT_954 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_955 = ".executeUpdate(updateForType2_";
  protected final String TEXT_956 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_957 = ".close();";
  protected final String TEXT_958 = NL + "        System.out.println(\"[";
  protected final String TEXT_959 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_960 = " + \"\\ndone\");";
  protected final String TEXT_961 = NL + "    String insertForType2_";
  protected final String TEXT_962 = " = \"INSERT INTO \\\"\" + tableName_";
  protected final String TEXT_963 = " + \"\\\"(";
  protected final String TEXT_964 = "\\\"";
  protected final String TEXT_965 = "\\\", ";
  protected final String TEXT_966 = ") SELECT ";
  protected final String TEXT_967 = "NEXT VALUE FOR \" + ";
  protected final String TEXT_968 = " + \", ";
  protected final String TEXT_969 = "t.";
  protected final String TEXT_970 = ", '\" + " + NL + "    (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_971 = "\"))) + \"', CAST(NULL AS ";
  protected final String TEXT_972 = ")";
  protected final String TEXT_973 = ", 1";
  protected final String TEXT_974 = ", d.\\\"";
  protected final String TEXT_975 = "\\\" + 1";
  protected final String TEXT_976 = " FROM \\\"\" + " + NL + "    sourceTable_";
  protected final String TEXT_977 = " + \"\\\" t, \\\"\" + tableName_";
  protected final String TEXT_978 = " + \"\\\" d WHERE ";
  protected final String TEXT_979 = " AND (";
  protected final String TEXT_980 = ") AND d.\\\"";
  protected final String TEXT_981 = "\\\" = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_982 = "\"))) + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_983 = " = conn_";
  protected final String TEXT_984 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_985 = ".executeUpdate(insertForType2_";
  protected final String TEXT_986 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_987 = ".close();";
  protected final String TEXT_988 = NL + "        System.out.println(\"[";
  protected final String TEXT_989 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_990 = " + \"\\ndone\");";
  protected final String TEXT_991 = NL + "String insert_";
  protected final String TEXT_992 = " = \"INSERT INTO \\\"\" + tableName_";
  protected final String TEXT_993 = " + \"\\\"(";
  protected final String TEXT_994 = "\\\"";
  protected final String TEXT_995 = "\\\", ";
  protected final String TEXT_996 = ") SELECT ";
  protected final String TEXT_997 = "NEXT VALUE FOR \" + ";
  protected final String TEXT_998 = " + \", ";
  protected final String TEXT_999 = "t.";
  protected final String TEXT_1000 = "\"";
  protected final String TEXT_1001 = " + \", '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1002 = "\"))) + \"', CAST(NULL AS ";
  protected final String TEXT_1003 = ")\"";
  protected final String TEXT_1004 = NL + "+ \"";
  protected final String TEXT_1005 = ", 1";
  protected final String TEXT_1006 = ", 1";
  protected final String TEXT_1007 = " FROM \\\"\" + " + NL + "sourceTable_";
  protected final String TEXT_1008 = " + \"\\\" t LEFT JOIN \\\"\" + tableName_";
  protected final String TEXT_1009 = " + \"\\\" d ON ";
  protected final String TEXT_1010 = " WHERE (";
  protected final String TEXT_1011 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_1012 = " = conn_";
  protected final String TEXT_1013 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_1014 = ".executeUpdate(insert_";
  protected final String TEXT_1015 = ");" + NL + "stmtInsert_";
  protected final String TEXT_1016 = ".close();";
  protected final String TEXT_1017 = NL + "    System.out.println(\"[";
  protected final String TEXT_1018 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_1019 = " + \"\\ndone\");";
  protected final String TEXT_1020 = NL;
  protected final String TEXT_1021 = NL + "\t";
  protected final String TEXT_1022 = NL;
  protected final String TEXT_1023 = NL + "    String updateForType1_";
  protected final String TEXT_1024 = " = \"UPDATE \\\"\" + tableName_";
  protected final String TEXT_1025 = " + \"\\\" d SET ";
  protected final String TEXT_1026 = " FROM \\\"\" + sourceTable_";
  protected final String TEXT_1027 = " + \"\\\" t WHERE ";
  protected final String TEXT_1028 = " AND (";
  protected final String TEXT_1029 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_1030 = " = conn_";
  protected final String TEXT_1031 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_1032 = ".executeUpdate(updateForType1_";
  protected final String TEXT_1033 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_1034 = ".close();";
  protected final String TEXT_1035 = NL + "        System.out.println(\"[";
  protected final String TEXT_1036 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_1037 = " + \"\\ndone\");";
  protected final String TEXT_1038 = NL + "    String updateForType2_";
  protected final String TEXT_1039 = " = \"UPDATE \\\"\" + tableName_";
  protected final String TEXT_1040 = " + \"\\\" d SET \\\"";
  protected final String TEXT_1041 = "\\\" = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1042 = "\"))) + \"'";
  protected final String TEXT_1043 = ", \\\"";
  protected final String TEXT_1044 = "\\\" = 0";
  protected final String TEXT_1045 = " FROM \\\"\" + sourceTable_";
  protected final String TEXT_1046 = " + \"\\\" t WHERE ";
  protected final String TEXT_1047 = " AND (";
  protected final String TEXT_1048 = ") AND d.\\\"";
  protected final String TEXT_1049 = "\\\" IS NULL\";" + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_1050 = " = conn_";
  protected final String TEXT_1051 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_1052 = ".executeUpdate(updateForType2_";
  protected final String TEXT_1053 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_1054 = ".close();";
  protected final String TEXT_1055 = NL + "        System.out.println(\"[";
  protected final String TEXT_1056 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_1057 = " + \"\\ndone\");";
  protected final String TEXT_1058 = NL + "    String insertForType2_";
  protected final String TEXT_1059 = " = \"INSERT INTO \\\"\" + tableName_";
  protected final String TEXT_1060 = " + \"\\\"(";
  protected final String TEXT_1061 = "\\\"";
  protected final String TEXT_1062 = "\\\", ";
  protected final String TEXT_1063 = ") SELECT ";
  protected final String TEXT_1064 = "NEXTVAL('\" + ";
  protected final String TEXT_1065 = " + \"'), ";
  protected final String TEXT_1066 = "t.";
  protected final String TEXT_1067 = ", '\" + " + NL + "    (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1068 = "\"))) + \"', NULL";
  protected final String TEXT_1069 = ", 1";
  protected final String TEXT_1070 = ", d.\\\"";
  protected final String TEXT_1071 = "\\\" + 1";
  protected final String TEXT_1072 = " FROM \\\"\" + " + NL + "    sourceTable_";
  protected final String TEXT_1073 = " + \"\\\" t, \\\"\" + tableName_";
  protected final String TEXT_1074 = " + \"\\\" d WHERE ";
  protected final String TEXT_1075 = " AND (";
  protected final String TEXT_1076 = ") AND d.\\\"";
  protected final String TEXT_1077 = "\\\" = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1078 = "\"))) + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_1079 = " = conn_";
  protected final String TEXT_1080 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_1081 = ".executeUpdate(insertForType2_";
  protected final String TEXT_1082 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_1083 = ".close();";
  protected final String TEXT_1084 = NL + "        System.out.println(\"[";
  protected final String TEXT_1085 = "] type2 new active row sql\\n\" + insertForType2_";
  protected final String TEXT_1086 = " + \"\\ndone\");";
  protected final String TEXT_1087 = NL + "String insert_";
  protected final String TEXT_1088 = " = \"INSERT INTO \\\"\" + tableName_";
  protected final String TEXT_1089 = " + \"\\\"(";
  protected final String TEXT_1090 = "\\\"";
  protected final String TEXT_1091 = "\\\", ";
  protected final String TEXT_1092 = ") SELECT ";
  protected final String TEXT_1093 = "NEXTVAL('\" + ";
  protected final String TEXT_1094 = " + \"'), ";
  protected final String TEXT_1095 = "t.";
  protected final String TEXT_1096 = "\"";
  protected final String TEXT_1097 = " + \", '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1098 = "\"))) + \"', NULL\"";
  protected final String TEXT_1099 = NL + "+ \"";
  protected final String TEXT_1100 = ", 1";
  protected final String TEXT_1101 = ", 1";
  protected final String TEXT_1102 = " FROM \\\"\" + " + NL + "sourceTable_";
  protected final String TEXT_1103 = " + \"\\\" t LEFT JOIN \\\"\" + tableName_";
  protected final String TEXT_1104 = " + \"\\\" d ON ";
  protected final String TEXT_1105 = " WHERE (";
  protected final String TEXT_1106 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_1107 = " = conn_";
  protected final String TEXT_1108 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_1109 = ".executeUpdate(insert_";
  protected final String TEXT_1110 = ");" + NL + "stmtInsert_";
  protected final String TEXT_1111 = ".close();";
  protected final String TEXT_1112 = NL + "    System.out.println(\"[";
  protected final String TEXT_1113 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_1114 = " + \"\\ndone\");";
  protected final String TEXT_1115 = NL;
  protected final String TEXT_1116 = NL + "\t";
  protected final String TEXT_1117 = NL;
  protected final String TEXT_1118 = NL + "    String updateForType1_";
  protected final String TEXT_1119 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_1120 = " + \" SET ";
  protected final String TEXT_1121 = " FROM \" + sourceTable_";
  protected final String TEXT_1122 = " + \" t WHERE ";
  protected final String TEXT_1123 = " AND (";
  protected final String TEXT_1124 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_1125 = " = conn_";
  protected final String TEXT_1126 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_1127 = ".executeUpdate(updateForType1_";
  protected final String TEXT_1128 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_1129 = ".close();";
  protected final String TEXT_1130 = NL + "        System.out.println(\"[";
  protected final String TEXT_1131 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_1132 = " + \"\\ndone\");";
  protected final String TEXT_1133 = NL + "    String updateForType2_";
  protected final String TEXT_1134 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_1135 = " + \" SET ";
  protected final String TEXT_1136 = " = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1137 = "\"))) + \"'";
  protected final String TEXT_1138 = ", ";
  protected final String TEXT_1139 = " = 0";
  protected final String TEXT_1140 = " FROM \" + sourceTable_";
  protected final String TEXT_1141 = " + \" t WHERE ";
  protected final String TEXT_1142 = " AND (";
  protected final String TEXT_1143 = ") AND \" + tableName_";
  protected final String TEXT_1144 = " + \".";
  protected final String TEXT_1145 = " IS NULL\";" + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_1146 = " = conn_";
  protected final String TEXT_1147 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_1148 = ".executeUpdate(updateForType2_";
  protected final String TEXT_1149 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_1150 = ".close();";
  protected final String TEXT_1151 = NL + "        System.out.println(\"[";
  protected final String TEXT_1152 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_1153 = " + \"\\ndone\");";
  protected final String TEXT_1154 = NL + "    String insertForType2_";
  protected final String TEXT_1155 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_1156 = " + \"(";
  protected final String TEXT_1157 = ", ";
  protected final String TEXT_1158 = ") SELECT ";
  protected final String TEXT_1159 = "\" + ";
  protected final String TEXT_1160 = " + \".NEXTVAL, ";
  protected final String TEXT_1161 = "t.";
  protected final String TEXT_1162 = ", '\" + " + NL + "    (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1163 = "\"))) + \"', NULL";
  protected final String TEXT_1164 = ", 1";
  protected final String TEXT_1165 = ", d.";
  protected final String TEXT_1166 = " + 1";
  protected final String TEXT_1167 = " FROM \" + " + NL + "    sourceTable_";
  protected final String TEXT_1168 = " + \" t, \" + tableName_";
  protected final String TEXT_1169 = " + \" d WHERE ";
  protected final String TEXT_1170 = " AND (";
  protected final String TEXT_1171 = ") AND d.";
  protected final String TEXT_1172 = " = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1173 = "\"))) + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_1174 = " = conn_";
  protected final String TEXT_1175 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_1176 = ".executeUpdate(insertForType2_";
  protected final String TEXT_1177 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_1178 = ".close();";
  protected final String TEXT_1179 = NL + "        System.out.println(\"[";
  protected final String TEXT_1180 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_1181 = " + \"\\ndone\");";
  protected final String TEXT_1182 = NL + "String insert_";
  protected final String TEXT_1183 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_1184 = " + \"(";
  protected final String TEXT_1185 = ", ";
  protected final String TEXT_1186 = ") SELECT ";
  protected final String TEXT_1187 = "\" + ";
  protected final String TEXT_1188 = " + \".NEXTVAL, ";
  protected final String TEXT_1189 = "t.";
  protected final String TEXT_1190 = "\"";
  protected final String TEXT_1191 = " + \", '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1192 = "\"))) + \"', NULL\"";
  protected final String TEXT_1193 = NL + "+ \"";
  protected final String TEXT_1194 = ", 1";
  protected final String TEXT_1195 = ", 1";
  protected final String TEXT_1196 = " FROM \" + " + NL + "sourceTable_";
  protected final String TEXT_1197 = " + \" t LEFT JOIN \" + tableName_";
  protected final String TEXT_1198 = " + \" d ON ";
  protected final String TEXT_1199 = " WHERE (";
  protected final String TEXT_1200 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_1201 = " = conn_";
  protected final String TEXT_1202 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_1203 = ".executeUpdate(insert_";
  protected final String TEXT_1204 = ");" + NL + "stmtInsert_";
  protected final String TEXT_1205 = ".close();";
  protected final String TEXT_1206 = NL + "    System.out.println(\"[";
  protected final String TEXT_1207 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_1208 = " + \"\\ndone\");";
  protected final String TEXT_1209 = NL;
  protected final String TEXT_1210 = NL + "\t";
  protected final String TEXT_1211 = NL;
  protected final String TEXT_1212 = NL + "    String updateForType1_";
  protected final String TEXT_1213 = " = \"UPDATE ";
  protected final String TEXT_1214 = " SET ";
  protected final String TEXT_1215 = " FROM ";
  protected final String TEXT_1216 = " d, ";
  protected final String TEXT_1217 = " t WHERE ";
  protected final String TEXT_1218 = " AND (";
  protected final String TEXT_1219 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_1220 = " = conn_";
  protected final String TEXT_1221 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_1222 = ".executeUpdate(updateForType1_";
  protected final String TEXT_1223 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_1224 = ".close();";
  protected final String TEXT_1225 = NL + "        System.out.println(\"[";
  protected final String TEXT_1226 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_1227 = " + \"\\ndone\");";
  protected final String TEXT_1228 = "        " + NL + "    String changeDateTime_";
  protected final String TEXT_1229 = " = (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1230 = "\"))).toString();" + NL + "\t" + NL + "    String updateForType2_";
  protected final String TEXT_1231 = " = \"UPDATE ";
  protected final String TEXT_1232 = " SET ";
  protected final String TEXT_1233 = " = '\" + (changeDateTime_";
  protected final String TEXT_1234 = ") + \"'";
  protected final String TEXT_1235 = ", ";
  protected final String TEXT_1236 = " = 0";
  protected final String TEXT_1237 = " FROM ";
  protected final String TEXT_1238 = " d, ";
  protected final String TEXT_1239 = " t WHERE ";
  protected final String TEXT_1240 = " AND (";
  protected final String TEXT_1241 = ") AND d.";
  protected final String TEXT_1242 = " IS NULL\"; " + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_1243 = " = conn_";
  protected final String TEXT_1244 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_1245 = ".executeUpdate(updateForType2_";
  protected final String TEXT_1246 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_1247 = ".close();";
  protected final String TEXT_1248 = NL + "        System.out.println(\"[";
  protected final String TEXT_1249 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_1250 = " + \"\\ndone\");";
  protected final String TEXT_1251 = NL + "    String insertForType2_";
  protected final String TEXT_1252 = " = \"INSERT INTO ";
  protected final String TEXT_1253 = "(";
  protected final String TEXT_1254 = ", ";
  protected final String TEXT_1255 = ") SELECT \" + ";
  protected final String TEXT_1256 = "sequenceValueFetchPattern_";
  protected final String TEXT_1257 = " + \", \" + ";
  protected final String TEXT_1258 = "\" t.";
  protected final String TEXT_1259 = ", '\" + " + NL + "    (changeDateTime_";
  protected final String TEXT_1260 = ") + \"', NULL";
  protected final String TEXT_1261 = ", 1";
  protected final String TEXT_1262 = ", d.";
  protected final String TEXT_1263 = " + 1";
  protected final String TEXT_1264 = " FROM ";
  protected final String TEXT_1265 = " t, ";
  protected final String TEXT_1266 = " d WHERE ";
  protected final String TEXT_1267 = " AND (";
  protected final String TEXT_1268 = ") AND d.";
  protected final String TEXT_1269 = " = '\" + (changeDateTime_";
  protected final String TEXT_1270 = ") + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_1271 = " = conn_";
  protected final String TEXT_1272 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_1273 = ".executeUpdate(insertForType2_";
  protected final String TEXT_1274 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_1275 = ".close();";
  protected final String TEXT_1276 = NL + "        System.out.println(\"[";
  protected final String TEXT_1277 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_1278 = " + \"\\ndone\");";
  protected final String TEXT_1279 = NL + "String insert_";
  protected final String TEXT_1280 = " = \"INSERT INTO ";
  protected final String TEXT_1281 = "(";
  protected final String TEXT_1282 = ", ";
  protected final String TEXT_1283 = ") SELECT \" + ";
  protected final String TEXT_1284 = "sequenceValueFetchPattern_";
  protected final String TEXT_1285 = " + \", \" + ";
  protected final String TEXT_1286 = "\" t.";
  protected final String TEXT_1287 = "\"";
  protected final String TEXT_1288 = " + \", '\" + (changeDateTime_";
  protected final String TEXT_1289 = ") + \"', NULL\"";
  protected final String TEXT_1290 = NL + "+ \"";
  protected final String TEXT_1291 = ", 1";
  protected final String TEXT_1292 = ", 1";
  protected final String TEXT_1293 = " FROM ";
  protected final String TEXT_1294 = " t LEFT JOIN ";
  protected final String TEXT_1295 = " d ON ";
  protected final String TEXT_1296 = " WHERE (";
  protected final String TEXT_1297 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_1298 = " = conn_";
  protected final String TEXT_1299 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_1300 = ".executeUpdate(insert_";
  protected final String TEXT_1301 = ");" + NL + "stmtInsert_";
  protected final String TEXT_1302 = ".close();";
  protected final String TEXT_1303 = NL + "    System.out.println(\"[";
  protected final String TEXT_1304 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_1305 = " + \"\\ndone\");";
  protected final String TEXT_1306 = NL + "\t";
  protected final String TEXT_1307 = NL;
  protected final String TEXT_1308 = NL + "    String updateForType1_";
  protected final String TEXT_1309 = " = \"UPDATE ";
  protected final String TEXT_1310 = " d SET ";
  protected final String TEXT_1311 = " FROM ";
  protected final String TEXT_1312 = " t WHERE ";
  protected final String TEXT_1313 = " AND (";
  protected final String TEXT_1314 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_1315 = " = conn_";
  protected final String TEXT_1316 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_1317 = ".executeUpdate(updateForType1_";
  protected final String TEXT_1318 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_1319 = ".close();";
  protected final String TEXT_1320 = NL + "        System.out.println(\"[";
  protected final String TEXT_1321 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_1322 = " + \"\\ndone\");";
  protected final String TEXT_1323 = "        " + NL + "    String changeDateTime_";
  protected final String TEXT_1324 = " = (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1325 = "\"))).toString();" + NL + "\t" + NL + "    String updateForType2_";
  protected final String TEXT_1326 = " = \"UPDATE ";
  protected final String TEXT_1327 = " d SET ";
  protected final String TEXT_1328 = " = '\" + (changeDateTime_";
  protected final String TEXT_1329 = ") + \"'";
  protected final String TEXT_1330 = ", ";
  protected final String TEXT_1331 = " = 0";
  protected final String TEXT_1332 = " FROM ";
  protected final String TEXT_1333 = " t WHERE ";
  protected final String TEXT_1334 = " AND (";
  protected final String TEXT_1335 = ") AND d.";
  protected final String TEXT_1336 = " IS NULL\"; " + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_1337 = " = conn_";
  protected final String TEXT_1338 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_1339 = ".executeUpdate(updateForType2_";
  protected final String TEXT_1340 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_1341 = ".close();";
  protected final String TEXT_1342 = NL + "        System.out.println(\"[";
  protected final String TEXT_1343 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_1344 = " + \"\\ndone\");";
  protected final String TEXT_1345 = NL + "    String insertForType2_";
  protected final String TEXT_1346 = " = \"INSERT INTO ";
  protected final String TEXT_1347 = "(";
  protected final String TEXT_1348 = ", ";
  protected final String TEXT_1349 = ") SELECT \" + ";
  protected final String TEXT_1350 = "sequenceValueFetchPattern_";
  protected final String TEXT_1351 = " + \", \" + ";
  protected final String TEXT_1352 = "\" t.";
  protected final String TEXT_1353 = ", '\" + " + NL + "    (changeDateTime_";
  protected final String TEXT_1354 = ") + \"', NULL";
  protected final String TEXT_1355 = ", 1";
  protected final String TEXT_1356 = ", d.";
  protected final String TEXT_1357 = " + 1";
  protected final String TEXT_1358 = " FROM ";
  protected final String TEXT_1359 = " t, ";
  protected final String TEXT_1360 = " d WHERE ";
  protected final String TEXT_1361 = " AND (";
  protected final String TEXT_1362 = ") AND d.";
  protected final String TEXT_1363 = " = '\" + (changeDateTime_";
  protected final String TEXT_1364 = ") + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_1365 = " = conn_";
  protected final String TEXT_1366 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_1367 = ".executeUpdate(insertForType2_";
  protected final String TEXT_1368 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_1369 = ".close();";
  protected final String TEXT_1370 = NL + "        System.out.println(\"[";
  protected final String TEXT_1371 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_1372 = " + \"\\ndone\");";
  protected final String TEXT_1373 = NL + "String insert_";
  protected final String TEXT_1374 = " = \"INSERT INTO ";
  protected final String TEXT_1375 = "(";
  protected final String TEXT_1376 = ", ";
  protected final String TEXT_1377 = ") SELECT \" + ";
  protected final String TEXT_1378 = "sequenceValueFetchPattern_";
  protected final String TEXT_1379 = " + \", \" + ";
  protected final String TEXT_1380 = "\" t.";
  protected final String TEXT_1381 = "\"";
  protected final String TEXT_1382 = " + \", '\" + (changeDateTime_";
  protected final String TEXT_1383 = ") + \"', NULL\"";
  protected final String TEXT_1384 = NL + "+ \"";
  protected final String TEXT_1385 = ", 1";
  protected final String TEXT_1386 = ", 1";
  protected final String TEXT_1387 = " FROM ";
  protected final String TEXT_1388 = " t LEFT JOIN ";
  protected final String TEXT_1389 = " d ON ";
  protected final String TEXT_1390 = " WHERE (";
  protected final String TEXT_1391 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_1392 = " = conn_";
  protected final String TEXT_1393 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_1394 = ".executeUpdate(insert_";
  protected final String TEXT_1395 = ");" + NL + "stmtInsert_";
  protected final String TEXT_1396 = ".close();";
  protected final String TEXT_1397 = NL + "    System.out.println(\"[";
  protected final String TEXT_1398 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_1399 = " + \"\\ndone\");";
  protected final String TEXT_1400 = NL + "\t";
  protected final String TEXT_1401 = NL;
  protected final String TEXT_1402 = NL + "    String updateForType1_";
  protected final String TEXT_1403 = " = \"UPDATE ";
  protected final String TEXT_1404 = " SET ";
  protected final String TEXT_1405 = " FROM ";
  protected final String TEXT_1406 = " d, ";
  protected final String TEXT_1407 = " t WHERE ";
  protected final String TEXT_1408 = " AND (";
  protected final String TEXT_1409 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_1410 = " = conn_";
  protected final String TEXT_1411 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_1412 = ".executeUpdate(updateForType1_";
  protected final String TEXT_1413 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_1414 = ".close();";
  protected final String TEXT_1415 = NL + "        System.out.println(\"[";
  protected final String TEXT_1416 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_1417 = " + \"\\ndone\");";
  protected final String TEXT_1418 = "        " + NL + "    String changeDateTime_";
  protected final String TEXT_1419 = " = (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1420 = "\"))).toString();" + NL + "\t" + NL + "    String updateForType2_";
  protected final String TEXT_1421 = " = \"UPDATE ";
  protected final String TEXT_1422 = " SET ";
  protected final String TEXT_1423 = " = '\" + (changeDateTime_";
  protected final String TEXT_1424 = ") + \"'";
  protected final String TEXT_1425 = ", ";
  protected final String TEXT_1426 = " = 0";
  protected final String TEXT_1427 = " FROM ";
  protected final String TEXT_1428 = " d, ";
  protected final String TEXT_1429 = " t WHERE ";
  protected final String TEXT_1430 = " AND (";
  protected final String TEXT_1431 = ") AND d.";
  protected final String TEXT_1432 = " IS NULL\"; " + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_1433 = " = conn_";
  protected final String TEXT_1434 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_1435 = ".executeUpdate(updateForType2_";
  protected final String TEXT_1436 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_1437 = ".close();";
  protected final String TEXT_1438 = NL + "        System.out.println(\"[";
  protected final String TEXT_1439 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_1440 = " + \"\\ndone\");";
  protected final String TEXT_1441 = NL + "    String insertForType2_";
  protected final String TEXT_1442 = " = \"INSERT INTO ";
  protected final String TEXT_1443 = "(";
  protected final String TEXT_1444 = ", ";
  protected final String TEXT_1445 = ") SELECT \" + ";
  protected final String TEXT_1446 = "sequenceValueFetchPattern_";
  protected final String TEXT_1447 = " + \", \" + ";
  protected final String TEXT_1448 = "\" t.";
  protected final String TEXT_1449 = ", '\" + " + NL + "    (changeDateTime_";
  protected final String TEXT_1450 = ") + \"', NULL";
  protected final String TEXT_1451 = ", 1";
  protected final String TEXT_1452 = ", d.";
  protected final String TEXT_1453 = " + 1";
  protected final String TEXT_1454 = " FROM ";
  protected final String TEXT_1455 = " t, ";
  protected final String TEXT_1456 = " d WHERE ";
  protected final String TEXT_1457 = " AND (";
  protected final String TEXT_1458 = ") AND d.";
  protected final String TEXT_1459 = " = '\" + (changeDateTime_";
  protected final String TEXT_1460 = ") + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_1461 = " = conn_";
  protected final String TEXT_1462 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_1463 = ".executeUpdate(insertForType2_";
  protected final String TEXT_1464 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_1465 = ".close();";
  protected final String TEXT_1466 = NL + "        System.out.println(\"[";
  protected final String TEXT_1467 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_1468 = " + \"\\ndone\");";
  protected final String TEXT_1469 = NL + "String insert_";
  protected final String TEXT_1470 = " = \"INSERT INTO ";
  protected final String TEXT_1471 = "(";
  protected final String TEXT_1472 = ", ";
  protected final String TEXT_1473 = ") SELECT \" + ";
  protected final String TEXT_1474 = "sequenceValueFetchPattern_";
  protected final String TEXT_1475 = " + \", \" + ";
  protected final String TEXT_1476 = "\" t.";
  protected final String TEXT_1477 = "\"";
  protected final String TEXT_1478 = " + \", '\" + (changeDateTime_";
  protected final String TEXT_1479 = ") + \"', NULL\"";
  protected final String TEXT_1480 = NL + "+ \"";
  protected final String TEXT_1481 = ", 1";
  protected final String TEXT_1482 = ", 1";
  protected final String TEXT_1483 = " FROM ";
  protected final String TEXT_1484 = " t LEFT JOIN ";
  protected final String TEXT_1485 = " d ON ";
  protected final String TEXT_1486 = " WHERE (";
  protected final String TEXT_1487 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_1488 = " = conn_";
  protected final String TEXT_1489 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_1490 = ".executeUpdate(insert_";
  protected final String TEXT_1491 = ");" + NL + "stmtInsert_";
  protected final String TEXT_1492 = ".close();";
  protected final String TEXT_1493 = NL + "    System.out.println(\"[";
  protected final String TEXT_1494 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_1495 = " + \"\\ndone\");";

    public static final String INSERT_COLUMN_NAME = "insertColName";
    public static final String INSERT_VALUE_STMT = "insertValueStmt";
    public static final String UPDATE_SET_STMT = "updateSetStmt";
    public static final String UPDATE_WHERE_STMT = "updateWhereStmt";
    public static final String DELETE_WHERE_STMT = "deleteWhereStmt";
    public static final String FIRST_UPDATE_KEY = "firstUpdateKeyColumn";
    public static final String FIRST_DELETE_KEY = "firstDeleteKeyColumn";
    public static final String FIRST_INSERT_COLUMN = "firstInsertColumn";
    public static final String FIRST_UPDATE_COLUMN = "firstUpdateColumn";
    public static final int NORMAL_TYPE = 0;
    public static final int INSERT_TYPE = 1;
    public static final int UPDATE_TYPE = 2;
    public static final String ACCESS = "access_id";
    public static final String AS400 = "as400_id";
    public static final String DB2 = "ibmdb2_id";
    public static final String FIREBIRD = "firebird_id";
    public static final String GREENPLUM = "greenplum_id";
    public static final String HSQLDB = "hsqldb_id";
    public static final String HIVE = "hive_id";
    public static final String INFORMIX = "informix_id";
    public static final String INGRES = "ingres_id";
    public static final String VECTORWISE = "vectorwise_id";
    public static final String INTERBASE = "interbase_id";
    public static final String JAVADB = "javadb_id";
    public static final String MAXDB = "maxdb_id";
    public static final String MSSQL = "id_MSSQL";
    public static final String MYSQL = "mysql_id";
    public static final String NETEZZA = "netezza_id";
    public static final String ORACLE = "oracle_id";
    public static final String PARACCEL = "paraccel_id";
    public static final String POSTGRESQL = "postgres_id";
    public static final String REDSHIFT = "redshift_id";
    public static final String POSTGREPLUS = "postgresplus_id";
    public static final String SQLITE = "sqlite_id";
    public static final String SYBASE = "sybase_id";
    public static final String TERADATA = "teradata_id";
    public static final String VERTICA = "vertica_id";
    public static final String ODBC = "MSODBC";
    public static final String JDBC = "JDBC";
    public static final String EXASOL = "Exasol_id";
    public static final String SAPHANA = "saphana_id";
    private static Map<String, Manager> managerMap = new HashMap<String, Manager>();
    public class Column {
        IMetadataColumn column;
        String name;
        String dataType;
        String operator;
        String columnName;
        String sqlStmt;
        String value;
        boolean addCol;
        boolean isKey;
        boolean isAutoIncrement;
        int startValue;
        int step;
        boolean isUpdateKey;
        boolean isDeleteKey;
        boolean insertable = true;
        boolean updatable = true;
        List<Column> replacement = new ArrayList<Column>();
        
        boolean isDynamic = false;
        
        public Column(String colName, String sqlStmt, boolean addCol) {
            this.column = null;
            this.name = colName;
            this.columnName = colName;
            this.sqlStmt = sqlStmt;
            this.value = "?";
            this.addCol = addCol;
        }
        public Column(IMetadataColumn column) {
            this.column = column;
            this.name = column.getLabel();
            this.sqlStmt = "?";
            this.value = "?";
            this.addCol = false;
            this.columnName = column.getOriginalDbColumnName();
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            this(column, isKey, useFieldOptions, fieldOption);
            if(isSpecifyIdentityKey) {
                if(column.getLabel().equals(identityKey)) {
                    isAutoIncrement = false;
                    this.startValue = startValue;
                    this.step = step;
                }
            }
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption) {
            this(column);
            this.isKey = isKey;
            if(useFieldOptions) {
                this.isUpdateKey = fieldOption.get("UPDATE_KEY").equals("true");
                this.isDeleteKey = fieldOption.get("DELETE_KEY").equals("true");
                this.insertable = fieldOption.get("INSERTABLE").equals("true");
                this.updatable = fieldOption.get("UPDATABLE").equals("true");                
            } else {
                this.insertable = true;
                if (isKey) {
                    this.isUpdateKey = true;
                    this.isDeleteKey = true;
                    this.updatable = false;
                }
                else {
                    this.isUpdateKey = false;
                    this.isDeleteKey = false;
                    this.updatable = true;
                }                
            }
        }
        public boolean isReplaced() {
            return replacement.size() > 0;
        }
        public void replace(Column column) {
            this.replacement.add(column);
        }
        public List<Column> getReplacement() {
            return this.replacement;
        }
        public void setColumn(IMetadataColumn column) {
            this.column = column;
        }
        public IMetadataColumn getColumn() {
            return this.column;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }
        public String getColumnName() {
            return this.columnName;
        }
        public void setIsAddCol(boolean isadd) {
            this.addCol = isadd;
        }
        public boolean isAddCol() {
            return this.addCol;
        }
        public void setSqlStmt(String sql) {
            this.sqlStmt = sql;
        }
        public String getSqlStmt() {
            if(this.getColumn()!=null) {
                if (this.getColumn().getTalendType().equals("id_Geometry")) {
                    
                    if ("MDSYS.SDO_GEOMETRY".equalsIgnoreCase(this.getColumn().getType())) {
                        return "?";
                    } else {
                        return "GeomFromText(?, ?)";    // For PostGIS
                    }
                } else {
                    return this.sqlStmt;
                }
            } else {
                return this.sqlStmt;
            }
        }
        public void setValue(String value) {
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }
        public void setDataType(String dataType) {
            this.dataType = dataType;
        }
        public String getDataType() {
            return dataType;
        }
        public void setOperator(String operator) {
            this.operator = operator;
        }
        public String getOperator() {
            return operator;
        }
        public boolean isAutoIncrement() {
            return this.isAutoIncrement;
        }
        public void setAutoIncrement(boolean isAutoIncrement) {
            this.isAutoIncrement = isAutoIncrement;
        }
        public int getStartValue() {
            return this.startValue;
        }
        public void setStartValue(int startValue) {
            this.startValue = startValue;
        }
        public int getStep() {
            return this.step;
        }
        public void setStep(int step) {
            this.step = step;
        }
        public boolean isKey() {
            return this.isKey;
        }
        public void setKey(boolean isKey) {
            this.isKey = isKey;
        }
        public boolean isUpdateKey() {
            return this.isUpdateKey;
        }
        public void setUpdateKey(boolean isUpdateKey) {
            this.isUpdateKey = isUpdateKey;
        }
        public boolean isDeleteKey() {
            return this.isDeleteKey;
        }
        public void setDeleteKey(boolean isDeleteKey) {
            this.isDeleteKey = isDeleteKey;
        }
        public boolean isInsertable() {
            return this.insertable;
        }
        public void setInsertable(boolean insertable) {
            this.insertable = insertable;
        }
        public boolean isUpdatable() {
            return this.updatable;
        }
        public void setUpdatable(boolean updatable) {
            this.updatable = updatable;
        }
        
        public boolean isDynamic() {
            return isDynamic;
        }
        
        public void setDynamic(boolean isDynamic) {
            this.isDynamic = isDynamic;
        }
    }
        
    public Column getColumn(IMetadataColumn column) {
        return new Column(column);
    }

    public Column getColumn(String colName, String sqlStmt, boolean addCol) {
        return new Column(colName, sqlStmt, addCol);
    }
    
    public Column getColumn(IMetadataColumn column, boolean isKey, boolean useFieldsOptions, Map<String, String> fieldOption) {
        return new Column(column, isKey, useFieldsOptions, fieldOption);
    }

    public abstract class Manager {
        
        protected INode node;// add the Node, it will be more convenient
        public void setNode(INode node) {
           this.node = node;
        }
        
        protected String cid;        
        protected abstract String getDBMSId();
        protected abstract String getLProtectedChar();
        protected abstract String getRProtectedChar();        
        public Manager() {}
        public Manager(String cid) {
            this.cid = cid;
        }
      protected  String getLProtectedChar(String columName) {
          return getLProtectedChar();
      }
      protected  String getRProtectedChar(String columName) {
          return getRProtectedChar();        
      }
      protected boolean contaionsSpaces(String columnName) {
          if (columnName != null) {
              if (columnName.startsWith("\" + ") && columnName.endsWith(" + \"")) {
                  return false;
              }
              
              if (columnName.contains(" ")) {
                  return true;
              }
              // minus are also a problem
              if (columnName.contains("-")) {
                  return true;
              }
          }
          return false;
      }

        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(1) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
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
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE " + getRProtectedChar());
            return truncate_reuse_stroage_TableSQL.toString();
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else if("oracle_id".equalsIgnoreCase(getDBMSId()) && dataType.matches("TIMESTAMP WITH TIME ZONE")){
                            createSQL.append("TIMESTAMP("+length+") WITH TIME ZONE");
                        }else{                            
                            createSQL.append(dataType);
                        }
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if ((("mysql_id".equalsIgnoreCase(getDBMSId()))||("as400_id".equalsIgnoreCase(getDBMSId())))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            // move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                            if("mysql_id".equalsIgnoreCase(getDBMSId()) ) {
                                String columnStr = getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() );
                                int index = pkList.indexOf(columnStr);
                                if(index !=-1){
                                    for (int i=index;i>0;i--) {
                                        pkList.set(i, pkList.get(i-1));
                                    }
                                    pkList.set(0, columnStr);
                                }
                            }
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
        protected String getAutoIncrement(int startValue, int step) {
            if("sybase_id".equalsIgnoreCase(getDBMSId()) || "Exasol_id".equalsIgnoreCase(getDBMSId())){
                return " IDENTITY NOT NULL";
            } else if("mysql_id".equalsIgnoreCase(getDBMSId()) ) {
                return " AUTO_INCREMENT";
            } else if("ibmdb2_id".equalsIgnoreCase(getDBMSId())){
                return " Generated by default AS IDENTITY(START WITH "+startValue+", INCREMENT BY "+step+", NO CACHE )";
            } else if("teradata_id".equalsIgnoreCase(getDBMSId())){
                return " generated by default as identity (start with " + startValue + " increment by " + step + " no cycle) not null";
            }else {
                return " IDENTITY (" + startValue + ", " + step + ") NOT NULL";
            }
        }
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return "";
            }
        }
        protected String setDefaultValue(String defaultValue, String columnType) {
            if (defaultValue == null || defaultValue.equals("\"\"") || defaultValue.equals("")) {
                return " ";
            } else if ((defaultValue.startsWith("\"") || defaultValue.startsWith("'"))
                    && (defaultValue.endsWith("\"") || defaultValue.endsWith("'"))) {
                return " default '" + defaultValue.substring(1, defaultValue.length() - 1) + "' ";
            } else if (defaultValue.equalsIgnoreCase("null")) {
                return " default null ";
            } else {
                return " default " + defaultValue + " ";
            }
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() + ", " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();
        }

        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            List<Column> stmtStructure = createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
            if(isSpecifyIdentityKey) {
                for(Column column : stmtStructure) {
                    if(column.name.equals(identityKey)) {
                        column.setAutoIncrement(true);
                        column.setStartValue(startValue);
                        column.setStep(step);
                        break;
                    }
                }
            }
            return stmtStructure;
        }
        
        private boolean dynamicColumnIsReplaced = false;
        
        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols) {
            List<Column> stmtStructure = new ArrayList<Column>();            
            for(IMetadataColumn column : columnList) {
                Map<String, String> fieldOption = null;
                if(fieldOptions != null && fieldOptions.size() > 0) {
                    for(Map<String, String> tmpFieldOption : fieldOptions) {
                        if(column.getLabel().equals(tmpFieldOption.get("SCHEMA_COLUMN"))) {
                            fieldOption = tmpFieldOption;
                            break;
                        }
                    }
                }
                
                Column skeletonColumn = getColumn(column, column.isKey(), useFieldOptions, fieldOption);
                skeletonColumn.setOperator("=");
                skeletonColumn.setDataType(column.getType());
                stmtStructure.add(skeletonColumn);
                
                if("id_Dynamic".equals(column.getTalendType())) {
                    skeletonColumn.setDynamic(true);
                }
            }
            
            dynamicColumnIsReplaced = false;
            
            if(addCols != null && addCols.size() > 0) {
                for(IMetadataColumn column : columnList) {
                    for(Map<String, String> additionColumn : addCols) {
                        if(additionColumn.get("REFCOL").equals(column.getLabel())) {
                            int stmtIndex = 0;
                            for(Column stmtStr : stmtStructure){          
                                if(stmtStr.getName().equals(additionColumn.get("REFCOL"))) {
                                    break;
                                }
                                stmtIndex++;
                            }           
                            if(additionColumn.get("POS").equals("AFTER")) {
                                Column insertAfter = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertAfter.setDataType(additionColumn.get("DATATYPE"));
                                insertAfter.setOperator("=");
                                stmtStructure.add(stmtIndex+1, insertAfter);
                            } else if(additionColumn.get("POS").equals("BEFORE")) {
                                Column insertBefore = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertBefore.setDataType(additionColumn.get("DATATYPE"));
                                insertBefore.setOperator("=");
                                stmtStructure.add(stmtIndex, insertBefore);
                            } else if(additionColumn.get("POS").equals("REPLACE")) {
                                Column replacementCol = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                replacementCol.setDataType(additionColumn.get("DATATYPE"));
                                replacementCol.setOperator("=");                                
                                Column replacedCol = (Column) stmtStructure.get(stmtIndex);
                                replacementCol.setKey(replacedCol.isKey());
                                replacementCol.setUpdateKey(replacedCol.isUpdateKey());
                                replacementCol.setDeleteKey(replacedCol.isDeleteKey());
                                replacementCol.setUpdatable(replacedCol.isUpdatable());
                                replacementCol.setInsertable(replacedCol.isInsertable());
                                replacedCol.replace(replacementCol);
                                
                                if(replacedCol.isDynamic()) {
                                    dynamicColumnIsReplaced = true;
                                }
                            }                            
                        }
                    }
                }
            }
            
            return stmtStructure;
        }
        
        public boolean isDynamicColumnReplaced() {
            return dynamicColumnIsReplaced;
        }
        
        public Map<String, StringBuilder> createProcessSQL(List<Column> stmtStructure) {
            Map<String, StringBuilder> actionSQLMap = new HashMap<String, StringBuilder>();
            if(stmtStructure==null || stmtStructure.size() < 1) {
                actionSQLMap.put(INSERT_COLUMN_NAME, new StringBuilder());
                actionSQLMap.put(INSERT_VALUE_STMT, new StringBuilder());
                actionSQLMap.put(UPDATE_SET_STMT, new StringBuilder());
                actionSQLMap.put(UPDATE_WHERE_STMT, new StringBuilder());
                actionSQLMap.put(DELETE_WHERE_STMT, new StringBuilder());
                actionSQLMap.put(FIRST_UPDATE_KEY, new StringBuilder());
                actionSQLMap.put(FIRST_DELETE_KEY, new StringBuilder());
                actionSQLMap.put(FIRST_INSERT_COLUMN, new StringBuilder());
                actionSQLMap.put(FIRST_UPDATE_COLUMN, new StringBuilder());
            } else {
                for(Column column : stmtStructure) {
                    if(column.isReplaced()) {
                        List<Column> replacedColumns = column.getReplacement();
                        for(Column replacedColumn : replacedColumns) {
                            actionSQLMap = processSQLClause(replacedColumn, actionSQLMap);
                        }
                    } else {
                        actionSQLMap = processSQLClause(column, actionSQLMap);        
                    }
                }
            }
            return actionSQLMap;
        }
        
        private boolean isSpecifyIdentityKey = false;
        
        public void setIsSpecifyIdentityKey(boolean isSpecifyIdentityKey) {
            this.isSpecifyIdentityKey = isSpecifyIdentityKey;
        }
        
        private Map<String, StringBuilder> processSQLClause(Column column, Map<String, StringBuilder> actionSQLMap) {
            StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);
            if(insertColName == null) {
                insertColName = new StringBuilder();
            }
            StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);
            if(insertValueStmt == null) {
                insertValueStmt = new StringBuilder();
            }
            StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);
            if(updateSetStmt == null) {
                updateSetStmt = new StringBuilder(); 
            }
            StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
            if(updateWhereStmt == null) {
                updateWhereStmt = new StringBuilder();
            }
            StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);
            if(deleteWhereStmt == null) {
                deleteWhereStmt = new StringBuilder();
            }
            StringBuilder firstUpdateKeyColumn = actionSQLMap.get(FIRST_UPDATE_KEY);
            if(firstUpdateKeyColumn == null) {
                firstUpdateKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstDeleteKeyColumn = actionSQLMap.get(FIRST_DELETE_KEY);
            if(firstDeleteKeyColumn == null) {
                firstDeleteKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstInsertColumn = actionSQLMap.get(FIRST_INSERT_COLUMN);
            if(firstInsertColumn == null) {
                firstInsertColumn = new StringBuilder("true");
            }
            StringBuilder firstUpdateColumn = actionSQLMap.get(FIRST_UPDATE_COLUMN);
            if(firstUpdateColumn == null) {
                firstUpdateColumn = new StringBuilder("true");
            }
            String suffix = null;
            String separate = null;
            String identityKey = ElementParameterParser.getValue(node, "__IDENTITY_FIELD__");
            if(!(isSpecifyIdentityKey && (column.getName().equals(identityKey))) && column.isInsertable() && !column.isDynamic()) {
                if(firstInsertColumn.toString().equals("true")) {
                    suffix = "";
                    firstInsertColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                insertColName.append(suffix);
                insertColName.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()));
                insertValueStmt.append(suffix);
                insertValueStmt.append(column.getSqlStmt());
            }
            if(column.isUpdatable() && !column.isDynamic()) {
                if(firstUpdateColumn.toString().equals("true")) {
                    suffix = "";
                    firstUpdateColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                updateSetStmt.append(suffix);
                updateSetStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " " + column.getOperator() + " " + column.getSqlStmt());
            }
            if(column.isDeleteKey() && !column.isDynamic()) {
                if(firstDeleteKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstDeleteKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                deleteWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(deleteWhereStmt, column);                 
            }
            if(column.isUpdateKey() && !column.isDynamic()) {
                if(firstUpdateKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstUpdateKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                updateWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(updateWhereStmt, column);                
                                            
            }
            actionSQLMap.put(INSERT_COLUMN_NAME, insertColName);
            actionSQLMap.put(INSERT_VALUE_STMT, insertValueStmt);
            actionSQLMap.put(UPDATE_SET_STMT, updateSetStmt);
            actionSQLMap.put(UPDATE_WHERE_STMT, updateWhereStmt);
            actionSQLMap.put(DELETE_WHERE_STMT, deleteWhereStmt);
            actionSQLMap.put(FIRST_UPDATE_KEY, firstUpdateKeyColumn);
            actionSQLMap.put(FIRST_DELETE_KEY, firstDeleteKeyColumn);
            actionSQLMap.put(FIRST_INSERT_COLUMN, firstInsertColumn);
            actionSQLMap.put(FIRST_UPDATE_COLUMN, firstUpdateColumn);
            return actionSQLMap;
        }
        public String getGenerateType(String typeToGenerate) {
            if(typeToGenerate.equals("byte[]")) {
                typeToGenerate = "Bytes";
            } else if(typeToGenerate.equals("java.util.Date")) {
                typeToGenerate = "Date";
            } else if(typeToGenerate.equals("Integer")) {
                typeToGenerate = "Int";
            } else if(typeToGenerate.equals("List")) {  
                typeToGenerate = "Object";                 
            } else {
                typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
            return typeToGenerate;
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType) {
            return generateSetStmt(typeToGenerate, dbType, column, index, incomingConnName, cid, actionType, null); 
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                    
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic + ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");                
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }
            else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();            
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, String incomingConnName, String cid, int actionType) {
            return generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, actionType, null); 
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        // @Deprecated : see bug8551
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt) {
            String replaceStr = null;
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " +  replaceStr + ")";
            }else {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ")";
            }
            
                
        }
        
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            return retrieveSQL(null,generatedType, column, incomingConnName, cid, stmt, index, sqlSplit);
        }
        public String retrieveSQL(String dynCol,String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            String replaceStr = null;
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                    if (index == 1 && dynCol == null) {
                        return  stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +  replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
                    } else {
                        return  stmt + cid + ".append(" +  replaceStr + ").append("+sqlSplit+cid+"["+dynamicIndex+"])";
                    }
            }else {
                if (index == 1 && dynCol == null) {
                    return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
                } else {
                    return stmt + cid + ".append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+dynamicIndex+"])";
                }
            }
        }
        
        //feature:2880 @6980 in debug mode
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
            return retrieveSQL(null,generatedType, column, incomingConnName, cid, stmt, index, sqlSplit, replaceFixedStr);
        }
        
        public String retrieveSQL(String dynCol,String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            if (index == 1 && dynCol == null) {
                return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +replaceFixedStr+ ").append("+sqlSplit+cid+"["+index+"])";
            } else {
                return stmt + cid + ".append(" +replaceFixedStr+").append("+sqlSplit+cid+"["+dynamicIndex+"])";
            }
        }
        
        //extract a method for feature:2880, it is a default implement, need every tDBOutput to implement it, if it really want to support the "whereNULL" issue
        //@see: the implement of MSSQLManager
        //feature:2880 @6980
        //i.e: 
        //1.select * FROM user where ((true = true AND name is NULL) OR name = ?);
        //2.select * FROM user where ((true = false AND name is NULL) OR name = ?);
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;

            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn()!=null && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
        // for feature:2880, it will consider the "whereNULL" issue in the generated code.
        // @Deprecated: because the "index" with a small problem when increase it.
        private String generateSetStmt_4_whereSupportNull(String typeToGenerate, Column column, int index,
                String incomingConnName, String cid, int actionType) {

            boolean whereSupportNull = false;

            // if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }

            StringBuilder setStmt = new StringBuilder();

            // the 3 conditions are important
            if (column.isUpdateKey() && whereSupportNull && column.getColumn().isNullable()) {
                setStmt.append(generateSetBooleanForNullableKeyStmt(column, index, incomingConnName, cid, NORMAL_TYPE));
            }

            // the old behave
            setStmt.append(generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, NORMAL_TYPE));

            return setStmt.toString();
        }

        protected String generateSetBooleanForNullableKeyStmt(String dynCol,Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            //TODO generate setXXXX code according to each db .
            setStmt.append(prefix + cid + ".setInt(" + dynamicIndex + ",  ((" + incomingConnName + "." + column.getName() + "==null)?1:0));\r\n");
            return setStmt.toString();
        } 
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            return generateSetBooleanForNullableKeyStmt(null, column, index, incomingConnName, cid, actionType);
        }     
        
        public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, 
                String fieldDelimiter, 
                String newLineChar,
                String nullIndicator) {
        return null;
            
        }
        
        public String generateCode4TabelExist() {
            boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
            String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
            StringBuilder code = new StringBuilder();  
            code.append("String tableNameForSearch_" + cid + "= " + getTableName4Search(useExistingConnection, connection) + ";\r\n");
            if (hasSchema()) {
                code.append("String dbschemaForSearch_" + cid + "= null;\r\n");
                code.append("if(dbschema_" + cid + "== null || dbschema_" + cid + ".trim().length() == 0) {\r\n");
                code.append("dbschemaForSearch_" + cid + "= " + getUserName4Search(useExistingConnection, connection)+ ";\r\n");
                code.append("} else {\r\n");
                code.append("dbschemaForSearch_" + cid + "= " + getShemaName4Search(useExistingConnection, connection)+ ";\r\n");
                code.append("}\r\n");
            }
            return code.toString();
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + " + ElementParameterParser.getValue(node,"__TABLE__") +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }

        /*
         * maybe some db need add getLProtectedChar() and getRProtectedChar() to schema name.
         * this because of some db default add getLProtectedChar() and getRProtectedChar() to schema when create table. e.g:db2
         * 
         * in fact the db add getLProtectedChar() and getRProtectedChar() to scheam when create table that is wrong
        */
        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }   
        
        protected boolean hasSchema() {
            return false;
        }
        
    }
    
    public class AS400Manager extends Manager {
        public AS400Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return AS400;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class AccessManager extends Manager {
        public AccessManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ACCESS;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }   
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else {
                if (typeToGenerate.equals("Long")) {
                    setStmt.append(prefix + cid + ".setBigDecimal(" + index + ",new BigDecimal(" + incomingConnName + "." + column.getName() + "));\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class DB2Manager extends Manager {
        public DB2Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return DB2;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }       
        
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " IMMEDIATE");
            return truncateTableSQL.toString();
        }
        
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE IMMEDIATE");
            return truncate_reuse_stroage_TableSQL.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            // try to build a sql like 
            // update customers a 
            // set (city_name,customer_type)=(select b.city_name,b.customer_type 
            //        from tmp_cust_city b 
            //        where b.customer_id=a.customer_id) // wheresub
            //        where exists (select 1 
            //        from tmp_cust_city b
            //        where b.customer_id=a.customer_id
            //        )
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class FirebirdManager extends Manager {
        public FirebirdManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return FIREBIRD;
        }
        protected String getLProtectedChar() {
            return " ";
        }
        protected String getRProtectedChar() {
            return " ";
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            
            // add VectorWise option
            if ("vectorwise_id".equalsIgnoreCase(getDBMSId())){
                createSQL.append("WITH STRUCTURE = VECTORWISE");
            }
            
            return createSQL.toString();
        }
                
    }
    
    public class HSQLDBManager extends Manager {
        String [] hsqldbKeyWords = {};
        public HSQLDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HSQLDB;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHSQLDBKeyword (String keyword) {
            for (int i=0 ; i < hsqldbKeyWords.length ; i++){
                if (hsqldbKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isHSQLDBKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isHSQLDBKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
    }
    
    public class HiveManager extends Manager {
        String [] hiveKeyWords = {};
        public HiveManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HIVE;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHiveKeyword (String keyword) {
            for (int i=0 ; i < hiveKeyWords.length ; i++){
                if (hiveKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isHiveKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isHiveKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
    }
    
    public class InformixManager extends Manager {
        public InformixManager(String cid) {
            super(cid);
        }
        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(*) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }        
        protected String getDBMSId() {
            return INFORMIX;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class IngresManager extends Manager {
        boolean isTrimSpace = true;
        public IngresManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INGRES;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }  
        protected boolean getTrimSpace() {
            return isTrimSpace;
        }
        protected boolean setTrimSpace(boolean isTrimSpace) {
            this.isTrimSpace = isTrimSpace;
            return isTrimSpace;
        }
        
        public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, String fieldDelimiter, 
                String recordDelimiter, String nullIndicator) {     
            StringBuilder copyBulkSQL = new StringBuilder();
            copyBulkSQL.append("COPY TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            copyBulkSQL.append(" (\"+");                
            int counter = 0;
            for(IMetadataColumn column : columnList) {
                counter++;
                // add each table field and separator
                copyBulkSQL.append( 
                "\n\"\\n" +
                  column.getOriginalDbColumnName() 
                + "="
                + (!getTrimSpace() && ("VARCHAR".equalsIgnoreCase(column.getType()) || "NVARCHAR".equalsIgnoreCase(column.getType()) || "TEXT".equalsIgnoreCase(column.getType())) ? "text(0)" : "char(0)"));
            
                // add these only if not last entry
                if (counter < columnList.size()){
                    copyBulkSQL.append(
                    //convertDelim(fieldDelimiter)
                    "\"+field_delimiter_"+cid +"+\""
                    + (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
                    + " ,"
                    + "\""
                    + "+"
                    );
                } else {
                    copyBulkSQL.append(
                    recordDelimiter
                    + (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
                    );
                    copyBulkSQL.append(")");
                }       
            } 
            return copyBulkSQL.toString();
        } 

        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("MODIFY " + getLProtectedChar() + "\" + tableName_" 
            + cid + " + \"\\\" TO TRUNCATED");
            return truncateTableSQL.toString();
        }                       
    }
    
    public class VectorWiseManager extends IngresManager {
        public VectorWiseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VECTORWISE;
        }
    }   
    
    public class InterbaseManager extends Manager {
        public InterbaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INTERBASE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class JavaDBManager extends Manager {
        public JavaDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JAVADB;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class MaxDBManager extends Manager {
        public MaxDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MAXDB;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MSSQLManager extends Manager {
        public MSSQLManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MSSQL;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        } 
       
        protected String getColumnIsNullCondition() {
            return "0x1";
        }
        
        protected String generateSetBooleanForNullableKeyStmt(String dynCol,Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setBoolean(" + dynamicIndex + ", (" + incomingConnName + "." + column.getName()
                    + "==null));\r\n");
            return setStmt.toString();
        } 
        
        public String generateSetStmt(String typeToGenerate, String ignoreDateOutOfRange, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                String dbType = column.getColumn().getType();
                if(dbType==null || "".equals(dbType)){
                    MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
                    dbType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                }
                boolean isMSSQL = "id_MSSQL".equals(this.getDBMSId());
                if("true".equals(ignoreDateOutOfRange) &&("DATE".equals(dbType) || "DATETIME2".equals(dbType) || "DATETIMEOFFSET".equals(dbType))){                    
                    String pattern = column.getColumn().getPattern();
                    setStmt.append("if(" + incomingConnName + "." + column.getName() +"!=null && "+ incomingConnName + "." + column.getName() + ".getTime() < year2_"+cid+"){");
                    if("DATETIMEOFFSET".equals(dbType)) {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDatetimeoffset("+incomingConnName+"."+column.getName()+"));\r\n");
                    } else {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDate("+pattern+", "+incomingConnName+"."+column.getName()+"));\r\n");
                    }
                    setStmt.append("}else{\r\n");
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                    if("DATETIMEOFFSET".equals(dbType)) {
                        setStmt.append(",calendar_datetimeoffset_").append(cid);
                    }
                    setStmt.append(");\r\n");
                    setStmt.append("}\r\n");
                }else if(isMSSQL && "TIME".equals(dbType)){//TDI-30431 begin
                    String timePattern = column.getColumn().getPattern();
                    //Compatible with Time,Date and String,it will fail if Time contain fractional seconds.(Solution:Use sqljdbc.jar and setTime() instead)
                    //setStmt.append(prefix + cid + ".setString(" + index + dynamic + "," + incomingConnName + "." + column.getName()+".toString()");// For Time and String
                    setStmt.append(prefix + cid + ".setString(" + index + dynamic + ","
                                    + incomingConnName + "." + column.getName()
                                    +" instanceof java.util.Date ? new java.text.SimpleDateFormat("+timePattern+").format("
                                    + incomingConnName + "." + column.getName()+") : "
                                    + incomingConnName + "." + column.getName()+".toString()");//Compatible with tFileInputDelimiter Date Type and Time and String
                    setStmt.append(");\r\n");
                }else{//TDI-30431 end
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                    if("DATETIMEOFFSET".equals(dbType)) {
                        setStmt.append(",calendar_datetimeoffset_").append(cid);
                    }
                    setStmt.append(");\r\n");
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        //bug 0016707 fixed:when set INT IDENTITY in schema and use "Specify identity field". the INT IDENTITY in schema by ignored  
                        if(column.isAutoIncrement()) {
                            length = column.getStartValue();
                            precision =  column.getStep();
                            if ("INT IDENTITY".equals(column.column.getType())) {
                                column.setAutoIncrement(false);
                            } 
                        }
                        // end bug0016707
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class MysqlManager extends Manager {
        public MysqlManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MYSQL;
        }
        protected String getLProtectedChar() {
            return "`";
        }
        protected String getRProtectedChar() {
            return "`";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE){
                prefix = "pstmt_";
            }else if(actionType == INSERT_TYPE){
                prefix = "pstmtInsert_";
            }else if(actionType == UPDATE_TYPE){
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append("date_" + cid + " = " + incomingConnName + "." + column.getName() + ".getTime();\r\n");
                setStmt.append("if(date_" + cid + " < year1_" + cid + " || date_" + cid + " >= year10000_" + cid + ") {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"0000-00-00 00:00:00\");\r\n");
                setStmt.append("} else {");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(date_" + cid + "));\r\n");
                setStmt.append("}\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }

    public class NetezzaManager extends Manager {
        public NetezzaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return NETEZZA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                String dateType="Timestamp";
                if("TIME".equalsIgnoreCase(column.getColumn().getType())){
                    dateType = "Time";
                }
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".set"+dateType+"(" + index + dynamic + ", new java.sql."+dateType+"(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class OracleManager extends Manager {
          private String[] oracleKeyWords= {
                    "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
                    "ADD","CONNECT","DISTINCT" ,
                    "ALL","BY","CREATE","DROP",
                    "ALTER","CHAR","CURRENT","ELSE",
                    "AND","CHECK","DATE","EXCLUSIVE",
                    "ANY","CLUSTER","DECIMAL"," EXISTS",
                    "AS","COLUMN","DEFAULT","FILE",
                    "ASC","COMMENT","DELETE","FLOAT",
                    "FOR","LONG","PCTFREE","SUCCESSFUL",
                    "FROM","MAXEXTENTS","PRIOR","SYNONYM",
                    "GRANT","MINUS","PRIVILEGES","SYSDATE",
                    "GROUP","MODE","PUBLIC","TABLE",
                    "HAVING","MODIFY","RAW","THEN",
                    "IDENTIFIED","NETWORK","RENAME","TO",
                    "IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
                    "IN","NOCOMPRESS","REVOKE","UID",
                    "INCREMENT","NOT","ROW","UNION",
                    "INDEX","NOWAIT","ROWID","UNIQUE",
                    "INITIAL","NULL","ROWNUM","UPDATE",
                    "INSERT","NUMBER","ROWS","USER",
                    "INTEGER","OF","SELECT","VALIDATE",
                    "INTERSECT","OFFLINE","SESSION","VALUES",
                    "INTO","ON","SET","VARCHAR",
                    "IS","ONLINE","SHARE","VARCHAR2",
                    "LEVEL","OPTION","SIZE","VIEW",
                    "LIKE","OR","SMALLINT","WHENEVER",
                    "LOCK","ORDER","START","WHERE","WITH"
                    };
        public OracleManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ORACLE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isOracleKeyword (String keyword) {
            for (int i=0 ; i < oracleKeyWords.length ; i++){
                if (oracleKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
        private String dbVersion = "";
        public void setDbVersion(String dbVersion){
            this.dbVersion = dbVersion;  
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }        
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
        	return generateSetStmt(typeToGenerate, column.getColumn().getType(), column, index, incomingConnName, cid, actionType, dynamic);
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            if(dbType == null){
            	dbType = "";
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");
                }
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");
                }
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if( typeToGenerate.equals("String")&& dbType.toLowerCase().equals("char")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == \"\0\"){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            }
            else if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                boolean isTSWithTZ = dbType.matches("TIMESTAMP WITH TIME ZONE");
                if(isTSWithTZ && ("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_12".equals(dbVersion) || "ORACLE_10".equals(dbVersion))){
                    setStmt.append("if("+ incomingConnName + "." + column.getName() + " instanceof TalendTimestampWithTZ){\r\n");
                    setStmt.append("((oracle.jdbc.OraclePreparedStatement)" + prefix + cid + ").setTIMESTAMPTZ(" + index + dynamic +  ", new oracle.sql.TIMESTAMPTZ(conn_" + cid + ", ((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getTimestamp(),((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getCalendar()));\r\n");
                    setStmt.append("}else{");
                    setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                    setStmt.append("}");
                }else if ("Date".equalsIgnoreCase(dbType)) {
                    if (!"true".equals(ElementParameterParser.getValue(node, "__USE_TIMESTAMP_FOR_DATE_TYPE__"))) {
                        setStmt.append(prefix + cid + ".setDate(" + index + dynamic +  ", new java.sql.Date(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                    } else {
                        setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()),java.sql.Types.DATE);\r\n");
                    }
                } else {
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n"); 
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic +  ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic +  ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic +  ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && (dbType.equals("XMLTYPE")||dbType.equals("CLOB")))) {
                setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ",  clobTypeUtil_" + cid + ".getCLOB(" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ",  blobTypeUtil_" + cid + ".getBLOB(" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
            }else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            boolean convertToUppercase = ("true").equals(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
            if(convertToUppercase){
                return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ").toUpperCase()" +" + \"" + getRProtectedChar() + "\"";
            }else{
                return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
            }
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;
            String columnName = column.getColumnName();
            String dataType = column.getDataType();
            if(dataType!=null)
            {
            boolean trimChar = ("true").equals(ElementParameterParser.getValue(node,"__TRIM_CHAR__"));
            if(trimChar && "char".equals(dataType.toLowerCase()))
            {
                columnName = "trim("+columnName+")";
            }
            }
            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn()!=null && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
    }
    
    public class PostgreManager extends Manager {
        public PostgreManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGRESQL;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            String dbType = column.getColumn().getType();
            StringBuilder setStmt = new StringBuilder();
            if(dbType.equals("UUID") && (typeToGenerate.equals("String") || typeToGenerate.equals("Object"))) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");
            } else if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else if(dbType.equals("UUID") && (typeToGenerate.equals("String") || typeToGenerate.equals("Object"))) {
                setStmt.append(prefix + cid + ".setObject(" + index + ", " + incomingConnName + "." + column.getName() + ", java.sql.Types.OTHER);\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class RedshiftManager extends PostgreManager {
         public RedshiftManager(String cid) {
             super(cid);
         }
         
         protected String getDBMSId() {
             return REDSHIFT;
         }
         
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if(("DECIMAL".equalsIgnoreCase(dataType) || "NUMERIC".equalsIgnoreCase(dataType)) 
                        	&& (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                            && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {
                        	
                        } else { 
	                        if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
	                            if (!precisionIgnored) {
	                                prefix = "(";
	                                suffix = ") ";
	                                createSQL.append(prefix + precision);
	                            }
	                            if (!lengthIgnored) {
	                                prefix = (prefix.equals("") ? "(" : prefix);
	                                suffix = (suffix.equals("") ? ") " : suffix);
	                                if (precisionIgnored) {
	                                    createSQL.append(prefix);
	                                    comma = "";
	                                } else {
	                                    comma = ",";
	                                }
	                                createSQL.append(comma + length);
	                            }
	                            createSQL.append(suffix);
	                        } else {
	                            if (!lengthIgnored) {
	                                if (column.getColumn().getLength() == null) {                                  
	                                } else { 
	                                    prefix = "(";
	                                    suffix = ") ";
	                                    createSQL.append(prefix + length);                                    
	                                }
	                            }
	                            if (!precisionIgnored) {
	                                prefix = (prefix.equals("") ? "(" : prefix);
	                                suffix = (suffix.equals("") ? ") " : suffix);
	                                if (lengthIgnored) {
	                                    createSQL.append(prefix);
	                                    comma = "";
	                                } else {
	                                    comma = ",";
	                                }
	                                createSQL.append(comma + precision);
	                            }
	                            if (column.getColumn().getLength() == null) {
	                            } else {
	                                createSQL.append(suffix);
	                            }
	                        }
	                    }
                            
                        if(column.isAutoIncrement()) {
                            // move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class GreenplumManager extends PostgrePlusManager {
         public GreenplumManager(String cid) {
             super(cid);
         }
         protected String getDBMSId() {
             return GREENPLUM;
         }
    }
    public class PostgrePlusManager extends Manager {
        public PostgrePlusManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGREPLUS;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class SQLiteManager extends Manager {
        public SQLiteManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SQLITE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class SybaseManager extends Manager {
         private String[] sybaseKeyWords= {
                 "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
                "ADD","CONNECT","COUNT","DISTINCT" ,
                "ALL","BY","CREATE","DROP",
                "ALTER","CHAR","CURRENT","ELSE",
                "AND","CHECK","DATE","EXCLUSIVE",
                "ANY","CLUSTER","DECIMAL"," EXISTS",
                "AS","COLUMN","DEFAULT","FILE",
                "ASC","COMMENT","DELETE","FLOAT",
                "FOR","LONG","PCTFREE","SUCCESSFUL",
                "FROM","FALSE","MAXEXTENTS","PRIOR","SYNONYM",
                "GRANT","MINUS","PRIVILEGES","SYSDATE",
                "GROUP","MODE","PUBLIC","TABLE",
                "HAVING","MODIFY","RAW","THEN",
                "IDENTIFIED","NETWORK","RENAME","TO",
                "IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
                "IN","NOCOMPRESS","REVOKE","UID",
                "INCREMENT","NOT","ROW","UNION",
                "INDEX","NOWAIT","ROWID","UNIQUE",
                "INITIAL","NULL","ROWNUM","UPDATE",
                "INSERT","NUMBER","ROWS","USER",
                "INTEGER","OF","SELECT","VALIDATE",
                "INTERSECT","OFFLINE","SESSION","VALUES",
                "INTO","ON","SET","VARCHAR",
                "IS","ONLINE","SHARE",
                "LEVEL","OPTION","SIZE","VIEW",
                "LIKE","OR","SMALLINT","WHENEVER",
                "LOCK","ORDER","START","WHERE","WITH"
                 
         };
        public SybaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SYBASE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected boolean isSybaseKeyword (String keyword) {
            for (int i=0 ; i < sybaseKeyWords.length ; i++){
                if (sybaseKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSybaseKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isSybaseKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return " null ";
            }
        }        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        

        /**
         * This method is added for differences between sybase and common databases on BigDecimal.
         * Reference issue is TDI-7505.
         * */
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("BigDecimal")){
                if(column.getColumn().getPrecision()!=null && column.getColumn().getLength()!=null){
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                    setStmt.append("((com.sybase.jdbc3.jdbc.SybPreparedStatement)"+prefix + cid + ").set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() +","+column.getColumn().getLength() +","+column.getColumn().getPrecision()+ ");\r\n");
                    setStmt.append("} else {\r\n");
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                    setStmt.append("}\r\n");
                }else{
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                }
                
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class TeradataManager extends Manager {
        public TeradataManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return TERADATA;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        } 
                
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            String dbType = column.getColumn().getType();
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if("BLOB".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BINARY);\r\n");                
                }
            } else if(typeToGenerate.equals("Byte")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TINYINT);\r\n");                
            } else if(typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.SMALLINT);\r\n");                
            } else if(typeToGenerate.equals("Long")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BIGINT);\r\n");                
            } else if(typeToGenerate.equals("Integer")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
                }
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if("BLOB".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                    
                }
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if ((typeToGenerate.equals("String")) && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setAsciiStream(" + index + ", new java.io.ByteArrayInputStream(" + incomingConnName + "." + column.getName() + ".toString().getBytes()), (" + incomingConnName + "." + column.getName() + ".toString().getBytes()).length);\r\n");                
            } else if ((typeToGenerate.equals("Bytes")) && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");    
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            
            String tableType = ElementParameterParser.getValue(node, "__CREATE_TABLE_TYPE__");
            
            createSQL.append("CREATE " + tableType + " TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class VerticaManager extends Manager {
        public VerticaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VERTICA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else {
                if(typeToGenerate.equals("Int")) {
                    setStmt.append(prefix + cid + ".setLong(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");                 
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }
    
    public class ODBCManager extends Manager {
        public ODBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ODBC;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class JDBCManager extends Manager {
        String lChar = "";
        String rChar = "";
        public JDBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JDBC;
        }
        protected String getLProtectedChar() {
            return lChar;
        }
        protected String getRProtectedChar() {
            return rChar;
        }        
        public void setLProtectedChar(String lChar){
            this.lChar = lChar;
        }
        public void setRProtectedChar(String rChar){
            this.rChar = rChar;
        }
    }    
    public class SAPHanaManager extends Manager {

        private String[] sapHanaReservedWords = { "ALL", "ALTER", "AS", "BEFORE", "BEGIN", "BOTH", "CASE", "CHAR", "CONDITION",
                "CONNECT", "CROSS", "CUBE", "CURRENT_CONNECTION", "CURRENT_DATE", "CURRENT_SCHEMA", "CURRENT_TIME",
                "CURRENT_TIMESTAMP", "CURRENT_USER", "CURRENT_UTCDATE", "CURRENT_UTCTIME", "CURRENT_UTCTIMESTAMP", "CURRVAL",
                "CURSOR", "DECLARE", "DISTINCT", "ELSE", "ELSEIF", "ELSIF", "END", "EXCEPT", "EXCEPTION", "EXEC", "FOR", "FROM",
                "FULL", "GROUP", "HAVING", "IF", "IN", "INNER", "INOUT", "INTERSECT", "INTO", "IS", "JOIN", "LEADING", "LEFT",
                "LIMIT", "LOOP", "MINUS", "NATURAL", "NEXTVAL", "NULL", "ON", "ORDER", "OUT", "PRIOR", "RETURN", "RETURNS",
                "REVERSE", "RIGHT", "ROLLUP", "ROWID", "SELECT", "SET", "SQL", "START", "SYSDATE", "SYSTIME", "SYSTIMESTAMP",
                "SYSUUID", "TOP", "TRAILING", "UNION", "USING", "UTCDATE", "UTCTIME", "UTCTIMESTAMP", "VALUES", "WHEN", "WHERE",
                "WHILE", "WITH" };

        public SAPHanaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SAPHANA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isSapHanaReservedWords (String keyword) {
            for (int i=0 ; i < sapHanaReservedWords.length ; i++){
                if (sapHanaReservedWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSapHanaReservedWords(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            return getLProtectedChar(keyword);
        }    
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            String table_type = ElementParameterParser.getValue(node,"__TABLE_TYPE__");
            createSQL.append("CREATE "+table_type+" TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                            if (!precisionIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + precision);
                            }
                            if (!lengthIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (precisionIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + length);
                            }
                            createSQL.append(suffix);
                        } else {
                            if (!lengthIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + length);                                    
                            }
                            if (!precisionIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (lengthIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + precision);
                            }
                            createSQL.append(suffix);
                        }                            
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }

    }    
    
    public class ExasolManager extends Manager{
    
		private String[] keywords = { "ABS", "ACOS", "ADD_DAYS", "ADD_HOURS",
				"ADD_MINUTES", "ADD_MONTHS", "ADD_SECONDS", "ADD_WEEKS",
				"ADD_YEARS", "ADMIN", "ALIGN", "ALWAYS", "ANALYZE", "ANSI",
				"ASCII", "ASIN", "ASSIGNMENT", "ASYMMETRIC", "ATAN", "ATAN2",
				"ATOMIC", "AUDIT", "AUTHENTICATED", "AUTO", "AVG", "BACKUP",
				"BERNOULLI", "BIT_AND", "BIT_CHECK", "BIT_LENGTH", "BIT_NOT",
				"BIT_OR", "BIT_SET", "BIT_TO_NUM", "BIT_XOR", "BREADTH",
				"CEIL", "CEILING", "CHANGE", "CHARACTERS", "CHARACTER_LENGTH",
				"CHR", "CLEAR", "COBOL", "COLOGNE_PHONETIC", "COMMENT",
				"COMMENTS", "COMMITTED", "CONCAT", "CONNECT", "CONVERT_TZ",
				"CORR", "COS", "COSH", "COT", "COUNT", "COVAR_POP",
				"COVAR_SAMP", "CREATED", "CROSS", "CURDATE", "DATABASE",
				"DATE_TRUNC", "DAYS_BETWEEN", "DECODE", "DEFAULTS", "DEGREES",
				"DELIMIT", "DELIMITER", "DENSE_RANK", "DEPTH", "DIAGNOSTICS",
				"DICTIONARY", "DISTRIBUTE", "DISTRIBUTION", "DIV", "DOWN",
				"DUMP", "EDIT_DISTANCE", "EMITS", "ENCODING", "ESTIMATE",
				"EVALUATE", "EXA", "EXCLUDE", "EXCLUDING", "EXP", "EXPRESSION",
				"FIRST_VALUE", "FLOOR", "FLUSH", "FOREIGN", "FORTRAN",
				"FROM_POSIX_TIME", "GREATEST", "GROUPING_ID", "HANDLER", "HAS",
				"HASH", "HASH_MD5", "HASH_SHA", "HASH_SHA1", "HASH_TIGER",
				"HIERARCHY", "HOURS_BETWEEN", "IDENTIFIED", "IGNORE",
				"INCLUDING", "INITIALLY", "INSTR", "INVALID", "ISOLATION",
				"IS_BOOLEAN", "IS_DATE", "IS_DSINTERVAL", "IS_NUMBER",
				"IS_TIMESTAMP", "IS_YMINTERVAL", "JAVA", "JAVASCRIPT", "KEEP",
				"KEY", "KEYS", "KILL", "LAG", "LANGUAGE", "LAST_VALUE",
				"LCASE", "LEAD", "LEAST", "LENGTH", "LINK", "LN", "LOCATE",
				"LOCK", "LOG10", "LOG2", "LOGS", "LONG", "LOWER", "LPAD",
				"LTRIM", "LUA", "MAX", "MAXIMAL", "MEDIAN", "MID", "MIN",
				"MINUTES_BETWEEN", "MONTHS_BETWEEN", "MUMPS", "NEVER", "NICE",
				"NORMALIZED", "NOW", "NULLIFZERO", "NULLS", "NUMTODSINTERVAL",
				"NUMTOYMINTERVAL", "NVL", "OCTETS", "OCTET_LENGTH", "OFFSET",
				"OPTIMIZE", "ORA", "OWNER", "PADDING", "PARTITION", "PASCAL",
				"PERCENTILE_CONT", "PERCENTILE_DISC", "PI", "PLI",
				"POSIX_TIME", "POWER", "PRECISION", "PRELOAD", "PRIMARY",
				"PRIORITY", "PRIVILEGE", "PYTHON", "QUERY_CACHE",
				"QUERY_TIMEOUT", "R", "RADIANS", "RAND", "RANK",
				"RATIO_TO_REPORT", "RECOMPRESS", "RECORD", "REGEXP_INSTR",
				"REGEXP_REPLACE", "REGEXP_SUBSTR", "REGR_AVGX", "REGR_AVGY",
				"REGR_COUNT", "REGR_INTERCEPT", "REGR_R2", "REGR_SLOPE",
				"REGR_SXX", "REGR_SXY", "REGR_SYY", "REJECT", "REORGANIZE",
				"REPEATABLE", "REVERSE", "ROLE", "ROUND", "ROWID",
				"ROW_NUMBER", "RPAD", "RTRIM", "SCALAR", "SCHEMAS", "SCHEME",
				"SECONDS_BETWEEN", "SECURE", "SERIALIZABLE", "SHUT", "SIGN",
				"SIMPLE", "SIN", "SINH", "SIZE", "SKIP", "SOUNDEX", "SQRT",
				"STATISTICS", "STDDEV", "STDDEV_POP", "STDDEV_SAMP", "ST_AREA",
				"ST_BOUNDARY", "ST_BUFFER", "ST_CENTROID", "ST_CONTAINS",
				"ST_CONVEXHULL", "ST_CROSSES", "ST_DIFFERENCE", "ST_DIMENSION",
				"ST_DISJOINT", "ST_DISTANCE", "ST_ENDPOINT", "ST_ENVELOPE",
				"ST_EQUALS", "ST_EXTERIORRING", "ST_FORCE2D", "ST_GEOMETRYN",
				"ST_GEOMETRYTYPE", "ST_INTERIORRINGN", "ST_INTERSECTION",
				"ST_INTERSECTS", "ST_ISCLOSED", "ST_ISEMPTY", "ST_ISRING",
				"ST_ISSIMPLE", "ST_LENGTH", "ST_NUMGEOMETRIES",
				"ST_NUMINTERIORRINGS", "ST_NUMPOINTS", "ST_OVERLAPS",
				"ST_POINTN", "ST_SETSRID", "ST_STARTPOINT", "ST_SYMDIFFERENCE",
				"ST_TOUCHES", "ST_TRANSFORM", "ST_UNION", "ST_WITHIN", "ST_X",
				"ST_Y", "SUBSTR", "SUM", "SYMMETRIC", "SYS_CONNECT_BY_PATH",
				"SYS_GUID", "TABLES", "TABLESAMPLE", "TAN", "TANH", "TASKS",
				"TIES", "TIME_ZONE", "TIME_ZONE_BEHAVIOR", "TO_CHAR",
				"TO_DATE", "TO_DSINTERVAL", "TO_NUMBER", "TO_TIMESTAMP",
				"TO_YMINTERVAL", "TRANSLATE", "TRUNC", "TYPE", "UCASE",
				"UNBOUNDED", "UNCOMMITTED", "UNDO", "UNICODE", "UNICODECHR",
				"UNLIMITED", "UPPER", "UTF8", "VARIANCE", "VARYING", "VAR_POP",
				"VAR_SAMP", "WEEK", "WRITE", "YEARS_BETWEEN", "ZEROIFNULL" };
				
        public ExasolManager(String cid) {
            super(cid);
        }

        protected boolean isReservedWord(String keyword) {
            for (int i=0 ; i < keywords.length ; i++){
                if (keywords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }

        protected String getDBMSId() {
            return EXASOL;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected String getLProtectedChar(String name) {
        	if (contaionsSpaces(name) || isReservedWord(name)) {
	            return "\\\"";
        	} else {
        		return "";
        	}
        }
        protected String getRProtectedChar(String name) {
        	if (contaionsSpaces(name) || isReservedWord(name)) {
	            return "\\\"";
        	} else {
        		return "";
        	}
        }  
    }
    public class UnDefinedManager extends Manager{
        
        private String dbmsId = "";
        
        public UnDefinedManager(String cid) {
            super(cid);
        }
        public void setDBMSId(String dbmsId){
            this.dbmsId = dbmsId;
        }
        protected String getDBMSId() {
            return this.dbmsId;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    //////////////////////////////////////////////////////////////////////////////////
    //the managers which only work for tELTJDBCOutput component, we add it to ignore the text quote which wrap the schema, table or column name.
    
    public class AS400ELTManager extends AS400Manager {
        public AS400ELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class AccessELTManager extends AccessManager {
        public AccessELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class DB2ELTManager extends DB2Manager {
        public DB2ELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class FirebirdELTManager extends FirebirdManager {
        public FirebirdELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class HSQLDBELTManager extends HSQLDBManager {
        public HSQLDBELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class HiveELTManager extends HiveManager {
        public HiveELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class InformixELTManager extends InformixManager {
        public InformixELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class IngresELTManager extends IngresManager {
        public IngresELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class VectorWiseELTManager extends VectorWiseManager {
        public VectorWiseELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class InterbaseELTManager extends InterbaseManager {
        public InterbaseELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class JavaDBELTManager extends JavaDBManager {
        public JavaDBELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MaxDBELTManager extends MaxDBManager {
        public MaxDBELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MSSQLELTManager extends MSSQLManager {
        public MSSQLELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MysqlELTManager extends MysqlManager {
        public MysqlELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class NetezzaELTManager extends NetezzaManager {
        public NetezzaELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class OracleELTManager extends OracleManager {
        public OracleELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class PostgrePlusELTManager extends PostgrePlusManager {
        public PostgrePlusELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class GreenplumELTManager extends GreenplumManager {
        public GreenplumELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class PostgreELTManager extends PostgreManager {
        public PostgreELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class RedshiftELTManager extends RedshiftManager {
        public RedshiftELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class SQLiteELTManager extends SQLiteManager {
        public SQLiteELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class SybaseELTManager extends SybaseManager {
        public SybaseELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class TeradataELTManager extends TeradataManager {
        public TeradataELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class VerticaELTManager extends VerticaManager {
        public VerticaELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class ExasolELTManager extends ExasolManager {
        public ExasolELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class SAPHanaELTManager extends SAPHanaManager {
        public SAPHanaELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public Manager getELTManager(String dbmsId, String cid) {
        Manager manager = managerMap.get(dbmsId + cid);
        if(manager == null) {
            if(dbmsId.equalsIgnoreCase(AS400)) {
                manager = new AS400ELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ACCESS)) {
                manager = new AccessELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(DB2)) {
                manager = new DB2ELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(FIREBIRD)) {
                manager = new FirebirdELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HSQLDB)) {
                manager = new HSQLDBELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HIVE)) {
                manager = new HiveELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INFORMIX)) {
                manager = new InformixELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INGRES)) {
                manager = new IngresELTManager(cid);         
            } else if(dbmsId.equalsIgnoreCase(VECTORWISE)) {
                manager = new VectorWiseELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INTERBASE)) {
                manager = new InterbaseELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JAVADB)) {
                manager = new JavaDBELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MAXDB)) {
                manager = new MaxDBELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MSSQL)) {
                manager = new MSSQLELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MYSQL)) {
                manager = new MysqlELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(NETEZZA)) {
                manager = new NetezzaELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ORACLE)) {
                manager = new OracleELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGREPLUS)) {
                manager = new PostgrePlusELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(GREENPLUM)) {
                manager = new GreenplumELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGRESQL)) {
                manager = new PostgreELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(REDSHIFT)) {
                manager = new RedshiftELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SQLITE)) {
                manager = new SQLiteELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SYBASE)) {
                manager = new SybaseELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(TERADATA)) {
                manager = new TeradataELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(VERTICA)) {
                manager = new VerticaELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(EXASOL)) {
                manager = new ExasolELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SAPHANA)) {
                manager = new SAPHanaELTManager(cid);
            } else {
                manager = new UnDefinedManager(cid);
                ((UnDefinedManager)manager).setDBMSId(dbmsId);
            }
        }
        managerMap.put(dbmsId + cid, manager);
        return manager;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    //ELT part end
    
    public Manager getManager(String dbmsId, String cid) {
        Manager manager = managerMap.get(dbmsId + cid);
        if(manager == null) {
            if(dbmsId.equalsIgnoreCase(AS400)) {
                manager = new AS400Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(ACCESS)) {
                manager = new AccessManager(cid);
            } else if(dbmsId.equalsIgnoreCase(DB2)) {
                manager = new DB2Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(FIREBIRD)) {
                manager = new FirebirdManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HSQLDB)) {
                manager = new HSQLDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HIVE)) {
                manager = new HiveManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INFORMIX)) {
                manager = new InformixManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INGRES)) {
                manager = new IngresManager(cid);         
            } else if(dbmsId.equalsIgnoreCase(VECTORWISE)) {
                manager = new VectorWiseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INTERBASE)) {
                manager = new InterbaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JAVADB)) {
                manager = new JavaDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MAXDB)) {
                manager = new MaxDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MSSQL)) {
                manager = new MSSQLManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MYSQL)) {
                manager = new MysqlManager(cid);
            } else if(dbmsId.equalsIgnoreCase(NETEZZA)) {
                manager = new NetezzaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ORACLE)) {
                manager = new OracleManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGREPLUS)) {
                manager = new PostgrePlusManager(cid);
            } else if(dbmsId.equalsIgnoreCase(GREENPLUM)) {
                manager = new GreenplumManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGRESQL)) {
                manager = new PostgreManager(cid);
            } else if(dbmsId.equalsIgnoreCase(REDSHIFT)) {
                manager = new RedshiftManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SQLITE)) {
                manager = new SQLiteManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SYBASE)) {
                manager = new SybaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(TERADATA)) {
                manager = new TeradataManager(cid);
            } else if(dbmsId.equalsIgnoreCase(VERTICA)) {
                manager = new VerticaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ODBC)) {
                manager = new ODBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JDBC)) {
                manager = new JDBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(EXASOL)) {
                manager = new ExasolManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SAPHANA)) {
                manager = new SAPHanaManager(cid);
            } else {
                manager = new UnDefinedManager(cid);
                ((UnDefinedManager)manager).setDBMSId(dbmsId);
            }
        }
        managerMap.put(dbmsId + cid, manager);
        return manager;
    }
    
    
    public Manager getManager(String dbmsId, String cid, INode node) {
        Manager manager = getManager(dbmsId, cid);
        manager.setNode(node);
        return manager;
    }
    
    public Manager getELTManager(String dbmsId, String cid, INode node) {
        Manager manager = getELTManager(dbmsId, cid);
        manager.setNode(node);
        return manager;
    }    
    
    public List<IMetadataColumn> getColumnList(INode node) {
        List<IMetadataColumn> columnList = null;
        List<IMetadataTable> metadatas = node.getMetadataList();
        if(metadatas != null && metadatas.size() > 0) {
            IMetadataTable metadata = metadatas.get(0);
            if(metadata != null) {
                columnList = metadata.getListColumns();
                if(metadata.isDynamicSchema() && columnList!=null) {
                    for(int i=columnList.size()-1; i>-1; i--) {
                        IMetadataColumn column = columnList.get(i);
                        if("id_Dynamic".equals(column.getTalendType())){
                            talendDynamicColumn = column;
                            break;
                        }
                    }
                }
            }
        }
        return columnList;
    }
    
    private IMetadataColumn talendDynamicColumn = null;
    
    public IMetadataColumn getDynamicColumn() {
        return talendDynamicColumn;
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
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataColumn> columnList = getColumnList(node);

if(columnList == null || columnList.isEmpty()) {
	return "";
}

dbLog = new DBLogUtil(node);

//some global var
boolean isEnableDebug = ("true").equals(ElementParameterParser.getValue(node, "__DEBUG__"));
String dbmsId = ElementParameterParser.getValue(node,"__MAPPING__");

//get or create db connection statement generation
String useExistingConnection = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
if (("true").equals(useExistingConnection)) {
    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
    String connectionName = "conn_" + connection;
    String username = "username_" + connection;
    
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_51);
    
} else {
	String driverClass = ElementParameterParser.getValue(node, "__DRIVER_CLASS__");
	String jdbcURL = ElementParameterParser.getValue(node, "__URL__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
    
    stringBuffer.append(TEXT_52);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(jdbcURL );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_57);
    
    String passwordFieldName = "__PASS__";
    
    stringBuffer.append(TEXT_58);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_61);
    } else {
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
}

    stringBuffer.append(TEXT_72);
    
Manager manager = getManager(dbmsId, cid, node);

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SCHEMA_DB__"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TABLE_SRC__"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TABLE__"));
    stringBuffer.append(TEXT_79);
    if("redshift_id".equals(dbmsId)) {
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    if("redshift_id".equals(dbmsId)) {
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    }
    stringBuffer.append(TEXT_100);
    
//table action statement generation
String tableAction = ElementParameterParser.getValue(node, "__TABLE_ACTION__");
String table = ElementParameterParser.getValue(node, "__TABLE__");

String surrogateKey = ElementParameterParser.getValue(node,"__SURROGATE_KEY__");

String surrogateKeyType = ElementParameterParser.getValue(node,"__SK_CREATION__");
boolean autoIncrease = "AUTO_INCREMENT".equals(surrogateKeyType)&&surrogateKey!=null;

List<Column> stmtStructure = null;
if(autoIncrease) {
	stmtStructure = getManager(dbmsId, cid).createColumnList(columnList, false, null, null, true, surrogateKey, 1, 1);
} else {
	stmtStructure = getManager(dbmsId, cid).createColumnList(columnList, false, null, null);
}

boolean isDynamic = false;

    stringBuffer.append(TEXT_101);
    if("TRUNCATE".equals(tableAction)) {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
}
    stringBuffer.append(TEXT_104);
    
//issue 0010346 Parallelization crash with "Drop table if exists and create"
Boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
boolean convertToUppercase_tableAction = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
if (!isParallelize) {
//end issue 0010346 Parallelization crash with "Drop table if exists and create"
	
	manager = getManager(dbmsId, cid);
    
    String ending="";
    
	//TODO need to remove it as it seems not useful now
    if("VECTORWISE".equalsIgnoreCase(dbmsId)) {
        ending="WITH STRUCTURE = VECTORWISE";
    }
	
    boolean useCascade = "true".equals(ElementParameterParser.getValue(node,"__USE_CASCADE__"));
    
    //bugfix: TDI-31650
    boolean setQueryTimeOut = false;
    String queryTimeOutInSeconds = null;
    if(SYBASE.equalsIgnoreCase(dbmsId)){
        setQueryTimeOut = "true".equals(ElementParameterParser.getValue(node,"__SET_QUERY_TIMEOUT__"));
        queryTimeOutInSeconds = ElementParameterParser.getValue(node,"__QUERY_TIMEOUT_IN_SECONDS__");
    }

    if(!("NONE").equals(tableAction)) {
        if(("DROP_CREATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_110);
    
               }
             
    dbLog.table().dropTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_113);
    stringBuffer.append((useCascade ? " + \" cascade\"" : ""));
    stringBuffer.append(TEXT_114);
    dbLog.table().dropDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_121);
    
               }
             
    dbLog.table().createTry(dbLog.var("tableName"));
    
            if(isDynamic) {
                List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                if(conns_dynamic!=null && conns_dynamic.size()>0){
                    String query=manager.getCreateTableSQL(stmtStructure);
                    
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_127);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_128);
    }
    stringBuffer.append(TEXT_129);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_130);
    
                }
            } else {
            
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_133);
    
            }
            
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
        } else if(("CREATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_141);
    
               }
             
    dbLog.table().createTry(dbLog.var("tableName"));
    
            if(isDynamic) {
                List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                if(conns_dynamic!=null && conns_dynamic.size()>0){
                    String query=manager.getCreateTableSQL(stmtStructure);
                    
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_147);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_148);
    }
    stringBuffer.append(TEXT_149);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_150);
    
                }
            } else {
            
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_153);
    
            }
            
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
        } else if(("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction)) {
            boolean tableNameCaseSensitive=false;
            if(DB2.equalsIgnoreCase(dbmsId)||POSTGRESQL.equalsIgnoreCase(dbmsId)||GREENPLUM.equalsIgnoreCase(dbmsId)||POSTGREPLUS.equalsIgnoreCase(dbmsId)){
                tableNameCaseSensitive=true;
            }
            
    
            //to fixed: bug8422
            if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
            
    stringBuffer.append(TEXT_156);
    //bug22719: informix use independent connection, should remove this code after use shared connection
                if(INFORMIX.equalsIgnoreCase(dbmsId)){
                    String dbnameKey = ElementParameterParser.getValue(node, "__DBNAME__");
                    String dbserverKey = ElementParameterParser.getValue(node, "__DBSERVER__");
                    String dbhostKey = ElementParameterParser.getValue(node, "__HOST__");
                    String dbportKey = ElementParameterParser.getValue(node, "__PORT__");
                    String tableSchemaKey = ElementParameterParser.getValue(node,"__SCHEMA_DB__");
                    
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(dbhostKey);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(dbportKey);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(dbnameKey);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(dbserverKey);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(tableSchemaKey);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_164);
    }else{
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    
            }
            
    
                            /*
                            case multi connection access the same db, that maybe have a locked in System table(e.g mssql).
                            so in mssql use "Select" checked the table whether exist.
                            */
                            //TODO we will use like "select" sql intead of use system table to checked table?
                            if(MSSQL.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
                            } else if (ORACLE.equalsIgnoreCase(dbmsId) || SAPHANA.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_182);
    stringBuffer.append(manager.generateCode4TabelExist());
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
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
    
                            } else if ( SYBASE.equalsIgnoreCase(dbmsId)
                                        || INFORMIX.equalsIgnoreCase(dbmsId) ) {
                            
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
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_211);
    }
    stringBuffer.append(TEXT_212);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_215);
    }
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
                            } else if( DB2.equalsIgnoreCase(dbmsId) || TERADATA.equalsIgnoreCase(dbmsId)){
                            
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_233);
    }
    stringBuffer.append(TEXT_234);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_235);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_236);
    }
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_239);
    }
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    
                            } else if (GREENPLUM.equalsIgnoreCase(dbmsId) || POSTGRESQL.equalsIgnoreCase(dbmsId) || POSTGREPLUS.equalsIgnoreCase(dbmsId) || VERTICA.equalsIgnoreCase(dbmsId)) {
                            
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
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
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_271);
    }
    stringBuffer.append(TEXT_272);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_275);
    }
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_281);
    }
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    
                            } else if(EXASOL.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(table);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    
                            } else if(REDSHIFT.equalsIgnoreCase(dbmsId)) {
                            
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
    stringBuffer.append(cid);
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
    
                            } else {
                            
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    
                            }
                            
    
                            if(("CREATE_IF_NOT_EXISTS").equals(tableAction)) {
                            
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    
                                       if(setQueryTimeOut){
                                            
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_338);
    
                                       }
                                     
    dbLog.table().createTry(dbLog.var("tableName"));
    
                                    if(isDynamic) {
                                        List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                                        if(conns_dynamic!=null && conns_dynamic.size()>0){
                                            String query=manager.getCreateTableSQL(stmtStructure);
                                            
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_342);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_343);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_344);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_345);
    }
    stringBuffer.append(TEXT_346);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_347);
    
                                        }
                                    } else {
                                    
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_350);
    
                                    }
                                    
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    
                            } else {
                            
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    
                                       if(setQueryTimeOut){
                                            
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_359);
    
                                       }
                                     
    dbLog.table().dropTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_362);
    stringBuffer.append((useCascade ? " + \" cascade\"" : ""));
    stringBuffer.append(TEXT_363);
    dbLog.table().dropDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    
                                   if(setQueryTimeOut){
                                        
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_370);
    
                                   }
                                 
    dbLog.table().createTry(dbLog.var("tableName"));
    
                                if(isDynamic) {
                                    List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                                    if(conns_dynamic!=null && conns_dynamic.size()>0){
                                        String query=manager.getCreateTableSQL(stmtStructure);
                                        
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_374);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_375);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_376);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_377);
    }
    stringBuffer.append(TEXT_378);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_379);
    
                                    }
                                } else {
                                
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_382);
    
                                }
                                
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    
                            }
                            
    
            //to fixed: bug8422
            if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
            
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_386);
    
            }
            
    
        } else if(("CLEAR").equals(tableAction)) {
        
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_392);
    
               }
             
    dbLog.table().clearTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(manager.getDeleteTableSQL());
    stringBuffer.append(TEXT_395);
    dbLog.table().clearDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    
        }else if(("TRUNCATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_403);
    
               }
             
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(manager.getSelectionSQL());
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_418);
    
               }
             
    dbLog.table().truncateTry(dbLog.var("tableName"));
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    }
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(manager.getTruncateTableSQL());
    stringBuffer.append(TEXT_423);
    if(INFORMIX.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_424);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    }
    dbLog.table().truncateDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    
        } else if(("TRUNCATE_REUSE_STORAGE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    dbLog.table().truncateReuseStorageTry(dbLog.var("tableName"));
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    }
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(manager.getTruncateReuseStroageTableSQL());
    stringBuffer.append(TEXT_443);
    dbLog.table().truncateReuseStorageDone(dbLog.var("tableName"));
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
    
        }
    }
//issue 0010346 Parallelization crash with "Drop table if exists and create"
}
//end issue 0010346 Parallelization crash with "Drop table if exists and create"

    stringBuffer.append(TEXT_451);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(tableAction);
    stringBuffer.append(TEXT_454);
    
}

    stringBuffer.append(TEXT_455);
    
class TextUtil {
	Manager manager;
	
	TextUtil(Manager manager) {
		this.manager = manager;
	}
	
	String wrap(String objectName) {
		return manager.getLProtectedChar() + objectName + manager.getRProtectedChar();
	}
	
	String wrap(String var, String cid) {
		return manager.getLProtectedChar() + "\" + " + var + "_" + cid + " + \"" + manager.getRProtectedChar();
	}
}

TextUtil text_util = new TextUtil(manager);

    stringBuffer.append(TEXT_456);
    if("DB_SEQUENCE".equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__"));
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(text_util.wrap("sequence", cid));
    stringBuffer.append(TEXT_461);
    }
    stringBuffer.append(TEXT_462);
    if("mysql_id".equals(dbmsId)) {
    stringBuffer.append(TEXT_463);
    stringBuffer.append(TEXT_464);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + StringUtils.getMysqlProtectedColumnName(sk.get("NAME")) + " = t." + StringUtils.getMysqlProtectedColumnName(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

String strFieldName = "";
String selectColumnString = "";
String columnNameString = "";

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getMysqlProtectedColumnName(sk.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getMysqlProtectedColumnName(sk.get("NAME")));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
    	strFieldName = StringUtils.getMysqlProtectedColumnName(type1Attribute.get("NAME"));
        columnNames.add(strFieldName);
        setColumns.add(" d." + strFieldName + " = t." + strFieldName);
        if(isFieldValueIncNull){
            whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
       	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(whereClauseString);
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
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    
    }
}

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        strFieldName = StringUtils.getMysqlProtectedColumnName(type2Attribute.get("NAME"));
    	if(isFieldValueIncNull){
        	whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
     	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_482);
    if(isEnableDebug){
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    
    for(IMetadataColumn column:columnList){
    	if(startDateField.equals(column.getLabel())){
	
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(column.getType());
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(column.getPattern()==""?"\"\"":column.getPattern());
    stringBuffer.append(TEXT_494);
    
    	}else if(endDateField.equals(column.getLabel())){
    
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(column.getType());
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_500);
    stringBuffer.append(column.getPattern()==""?"\"\"":column.getPattern());
    stringBuffer.append(TEXT_501);
    
        	}
        }
	}

    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    if (isEnableActive) {
    stringBuffer.append(TEXT_508);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_509);
    }
    stringBuffer.append(TEXT_510);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    if (isEnableActive) {
    stringBuffer.append(TEXT_525);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_526);
    }
    stringBuffer.append(TEXT_527);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getMysqlProtectedColumnName(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getMysqlProtectedColumnName(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(StringUtils.getMysqlProtectedColumnName(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(StringUtils.getMysqlProtectedColumnName(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(StringUtils.getMysqlProtectedColumnName(startDateField));
    columnNames.add(StringUtils.getMysqlProtectedColumnName(endDateField));
    if(isEnableActive) {
        columnNames.add(StringUtils.getMysqlProtectedColumnName(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(StringUtils.getMysqlProtectedColumnName(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    if(isEnableActive) {
    stringBuffer.append(TEXT_539);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_540);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_541);
    }
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    if(isEnableActive) {
    stringBuffer.append(TEXT_560);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_561);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_562);
    }
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_571);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + StringUtils.getMysqlProtectedColumnName(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_576);
    if(isEnableType2) {
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    }
    stringBuffer.append(TEXT_579);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_580);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_581);
    }
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(outerWhereClauseString);
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
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_596);
    if(isEnableType2) {
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    }
    stringBuffer.append(TEXT_599);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_600);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_601);
    }
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_608);
    
}

    stringBuffer.append(TEXT_609);
    } else if("oracle_id".equals(dbmsId)){
    stringBuffer.append(TEXT_610);
    stringBuffer.append(TEXT_611);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

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
    
String selectColumnString = "";
String columnNameString = "";
List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + sk.get("NAME") + " = t." + sk.get("NAME"));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(sk.get("NAME"));
            }
        } else {
            columnNames.add(sk.get("NAME"));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(type1Attribute.get("NAME"));
        setColumns.add(type1Attribute.get("NAME"));
        if(isFieldValueIncNull){
            whereClause.add("( d." + type1Attribute.get("NAME") + " is null AND t." + type1Attribute.get("NAME")+" is not null )");
        	whereClause.add("( d." + type1Attribute.get("NAME") + " is not null AND t." + type1Attribute.get("NAME")+" is null )");
        }
        whereClause.add("( d." + type1Attribute.get("NAME") + " <> t." + type1Attribute.get("NAME")+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(whereClauseString);
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
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    
    }
}

String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");
String l2StartDateFieldType = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD_TYPE__");
String l2EndDateFieldType = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD_TYPE__");
String l2StartDateFieldInputFieldName =  ElementParameterParser.getValue(node,"__INPUT_FIELD_NAME__");
String l2EndDateFieldFixedYearValue = ElementParameterParser.getValue(node,"__FIXED_YEAR_VALUE__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
    	if(isFieldValueIncNull){
        	whereClause.add("( d." + type2Attribute.get("NAME") + " is null AND t." + type2Attribute.get("NAME")+" is not null )");
        	whereClause.add("( d." + type2Attribute.get("NAME") + " is not null AND t." + type2Attribute.get("NAME")+" is null )");
      	}
        whereClause.add("( d." + type2Attribute.get("NAME") + " <> t." + type2Attribute.get("NAME")+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_641);
    if ("INPUT_FIELD".equals(l2StartDateFieldType)){
    stringBuffer.append(TEXT_642);
    stringBuffer.append(l2StartDateFieldInputFieldName);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_645);
    }else{
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid );
    }
    stringBuffer.append(TEXT_647);
    if (isEnableActive) {
    stringBuffer.append(TEXT_648);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_649);
    }
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_654);
    if ("NULL".equals(l2EndDateFieldType)) {
    
    stringBuffer.append(TEXT_655);
    
    }else if ("FIXED_YEAR_VALUE".equals(l2EndDateFieldType)) {
    
    stringBuffer.append(TEXT_656);
    stringBuffer.append(l2EndDateFieldFixedYearValue);
    stringBuffer.append(TEXT_657);
    
    }
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_666);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(sourceKey.get("NAME"));
            }
        } else {
            columnNames.add(sourceKey.get("NAME"));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(type1Attribute.get("NAME"));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(type2Attribute.get("NAME"));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(startDateField);
    columnNames.add(endDateField);
    if(isEnableActive) {
        columnNames.add(activeField);
    }
    if(isEnableVersion) {
        columnNames.add(versionField);
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_670);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_671);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_672);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_673);
    }
    stringBuffer.append(TEXT_674);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_675);
    if ("JOB_START_TIME".equals(l2StartDateFieldType)) { // job start time
    
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid );
    
    }else if ("INPUT_FIELD".equals(l2StartDateFieldType)){
    
    stringBuffer.append(TEXT_677);
    stringBuffer.append(l2StartDateFieldInputFieldName);
    stringBuffer.append(TEXT_678);
    
    }
    stringBuffer.append(TEXT_679);
    if ("NULL".equals(l2EndDateFieldType)) {
     
    stringBuffer.append(TEXT_680);
    
     }else if ("FIXED_YEAR_VALUE".equals(l2EndDateFieldType)) {
     
    stringBuffer.append(TEXT_681);
    stringBuffer.append(l2EndDateFieldFixedYearValue);
    stringBuffer.append(TEXT_682);
    
     }
    stringBuffer.append(TEXT_683);
    if(isEnableActive) {
    stringBuffer.append(TEXT_684);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_685);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_686);
    }
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_692);
    if ("INPUT_FIELD".equals(l2StartDateFieldType)){
    stringBuffer.append(TEXT_693);
    stringBuffer.append(l2StartDateFieldInputFieldName);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_696);
    }else{
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid );
    }
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_703);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_706);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + sk.get("NAME") + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_709);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_710);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_711);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_712);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_713);
    }
    stringBuffer.append(TEXT_714);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_715);
    if(isEnableType2) {
    stringBuffer.append(TEXT_716);
    if ("JOB_START_TIME".equals(l2StartDateFieldType)) {
	
    stringBuffer.append(TEXT_717);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_718);
    
	}else if ("INPUT_FIELD".equals(l2StartDateFieldType)){
	
    stringBuffer.append(TEXT_719);
    stringBuffer.append(l2StartDateFieldInputFieldName);
    stringBuffer.append(TEXT_720);
    
	}
    stringBuffer.append(TEXT_721);
    if ("NULL".equals(l2EndDateFieldType)) {
	
    stringBuffer.append(TEXT_722);
    
	}else if ("FIXED_YEAR_VALUE".equals(l2EndDateFieldType)) {
	
    stringBuffer.append(TEXT_723);
    stringBuffer.append(l2EndDateFieldFixedYearValue);
    stringBuffer.append(TEXT_724);
    
	}
    stringBuffer.append(TEXT_725);
    }
    stringBuffer.append(TEXT_726);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_727);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_728);
    }
    stringBuffer.append(TEXT_729);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_734);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_735);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_738);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_741);
    
}

    stringBuffer.append(TEXT_742);
    } else if("teradata_id".equals(dbmsId)){
    stringBuffer.append(TEXT_743);
    stringBuffer.append(TEXT_744);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

String selectColumnString = "";
String columnNameString = "";
List<String> joinClause = new ArrayList<String>();
List<String> updateJoinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + sk.get("NAME") + " = t." + sk.get("NAME"));
    updateJoinClause.add("\" + tableName_" + cid + " + \"." + sk.get("NAME") + " = t." + sk.get("NAME"));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");
String updateJoinClauseString = StringUtils.join(updateJoinClause.toArray(), " AND ");

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(sk.get("NAME"));
            }
        } else {
            columnNames.add(sk.get("NAME"));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(type1Attribute.get("NAME"));
        setColumns.add(type1Attribute.get("NAME") + " = t." + type1Attribute.get("NAME"));
        if(isFieldValueIncNull){
            whereClause.add("(\" + tableName_" + cid + " + \"." + type1Attribute.get("NAME") + " is null AND t." + type1Attribute.get("NAME")+" is not null )");
            whereClause.add("(\" + tableName_" + cid + " + \"." + type1Attribute.get("NAME") + " is not null AND t." + type1Attribute.get("NAME")+" is null )");
        }
        whereClause.add("(\" + tableName_" + cid + " + \"." + type1Attribute.get("NAME") + " <> t." + type1Attribute.get("NAME")+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_745);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_746);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_747);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_748);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_749);
    stringBuffer.append(updateJoinClauseString);
    stringBuffer.append(TEXT_750);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_751);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_752);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_754);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_755);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_756);
    
}

String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = "true".equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = "true".equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");
if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    List<String> updateWhereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        if(isFieldValueIncNull){
            whereClause.add("(d." + type2Attribute.get("NAME") + " is null AND t." + type2Attribute.get("NAME")+" is not null )");
            whereClause.add("(d." + type2Attribute.get("NAME") + " is not null AND t." + type2Attribute.get("NAME")+" is null )");
            updateWhereClause.add("(\" + tableName_" + cid + " + \"." + type2Attribute.get("NAME") + " is null AND t." + type2Attribute.get("NAME")+" is not null )");
            updateWhereClause.add("(\" + tableName_" + cid + " + \"." + type2Attribute.get("NAME") + " is not null AND t." + type2Attribute.get("NAME")+" is null )");
        }
        whereClause.add("(d." + type2Attribute.get("NAME") + " <> t." + type2Attribute.get("NAME")+")");
        updateWhereClause.add("(\" + tableName_" + cid + " + \"." + type2Attribute.get("NAME") + " <> t." + type2Attribute.get("NAME")+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    String updateWhereClauseString = StringUtils.join(updateWhereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_757);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_759);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_760);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_761);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_762);
    if(isEnableActive) {
    stringBuffer.append(TEXT_763);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_764);
    }
    stringBuffer.append(TEXT_765);
    stringBuffer.append(updateJoinClauseString);
    stringBuffer.append(TEXT_766);
    stringBuffer.append(updateWhereClauseString);
    stringBuffer.append(TEXT_767);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_768);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_769);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_770);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_771);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_772);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_773);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_774);
    
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(sourceKey.get("NAME"));
            }
        } else {
            columnNames.add(sourceKey.get("NAME"));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(type1Attribute.get("NAME"));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(type2Attribute.get("NAME"));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(startDateField);
    columnNames.add(endDateField);
    if(isEnableActive) {
        columnNames.add(activeField);
    }
    if(isEnableVersion) {
        columnNames.add(versionField);
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_775);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_776);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_777);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_778);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_779);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_780);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_781);
    }
    stringBuffer.append(TEXT_782);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_783);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_784);
    if(isEnableActive) {
    stringBuffer.append(TEXT_785);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_786);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_787);
    }
    stringBuffer.append(TEXT_788);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_789);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_790);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_791);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_792);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_793);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_794);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_795);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_796);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_797);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_798);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_799);
    
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + sk.get("NAME") + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_800);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_801);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_802);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_803);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_804);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_805);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_806);
    }
    stringBuffer.append(TEXT_807);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_808);
    if(isEnableType2) {
    stringBuffer.append(TEXT_809);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_810);
    }
    stringBuffer.append(TEXT_811);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_812);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_813);
    }
    stringBuffer.append(TEXT_814);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_815);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_816);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_817);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_818);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_819);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_820);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_821);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_822);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_823);
    

    stringBuffer.append(TEXT_824);
    } else if("postgresplus_id".equals(dbmsId)){
    stringBuffer.append(TEXT_825);
    stringBuffer.append(TEXT_826);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

String selectColumnString = "";
String columnNameString = "";

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")) +
            " = t." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();        
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")));
        setColumns.add(StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")) + 
                " = t." + StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")));
        whereClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")) + 
                " <> t." + StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")));            
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");    
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");    
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_827);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_829);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_830);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_831);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_832);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_833);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_834);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_835);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_836);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_837);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_838);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_839);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_840);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_841);
    
    }
}

String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");    
if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        whereClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(type2Attribute.get("NAME")) + 
                " <> t." + StringUtils.getPostgresqlProtectedColumnName(type2Attribute.get("NAME")));
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_842);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_843);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_844);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_845);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_846);
    if(isEnableActive) {
    stringBuffer.append(TEXT_847);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_848);
    }
    stringBuffer.append(TEXT_849);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_850);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_851);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_852);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_853);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_854);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_855);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_856);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_857);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_858);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_859);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_860);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_861);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(StringUtils.getPostgresqlProtectedColumnName(startDateField));
    columnNames.add(StringUtils.getPostgresqlProtectedColumnName(endDateField));
    if(isEnableActive) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_862);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_863);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_864);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_865);
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_866);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_867);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_868);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_869);
    }
    stringBuffer.append(TEXT_870);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_871);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_872);
    if(isEnableActive) {
    stringBuffer.append(TEXT_873);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_874);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_875);
    }
    stringBuffer.append(TEXT_876);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_877);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_878);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_879);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_880);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_881);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_882);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_883);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_884);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_885);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_886);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_887);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_888);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_889);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_890);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_891);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_892);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_893);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_894);
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_895);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_896);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_897);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_898);
    }
    stringBuffer.append(TEXT_899);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_900);
    if(isEnableType2) {
    stringBuffer.append(TEXT_901);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_902);
    }
    stringBuffer.append(TEXT_903);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_904);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_905);
    }
    stringBuffer.append(TEXT_906);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_907);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_908);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_909);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_910);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_911);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_912);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_913);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_914);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_915);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_916);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_917);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_918);
    
}

    stringBuffer.append(TEXT_919);
    } else if("ibmdb2_id".equals(dbmsId)){
    stringBuffer.append(TEXT_920);
    stringBuffer.append(TEXT_921);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")) +
            " = t." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

String strFieldName = "";
String selectColumnString = "";
String columnNameString = "";

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
    	strFieldName = StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME"));
        columnNames.add(strFieldName);
        setColumns.add(strFieldName);
        if(isFieldValueIncNull){
            whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
       	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");    
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_922);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_923);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_924);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_925);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_926);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_927);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_928);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_929);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_930);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_931);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_932);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_933);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_934);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_935);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_936);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_937);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_938);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_939);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_940);
    
    }
}

String endDateFieldType="DATE";
String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
    	strFieldName = StringUtils.getPostgresqlProtectedColumnName(type2Attribute.get("NAME"));
    	if(isFieldValueIncNull){
        	whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
     	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    for(IMetadataColumn column : columnList) {
    	if(endDateField!=null && endDateField.equals(column.getLabel())){
    		endDateFieldType=column.getType();
    		break;
    	}
    }
    
    stringBuffer.append(TEXT_941);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_942);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_943);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_944);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_945);
    if (isEnableActive) {
    stringBuffer.append(TEXT_946);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_947);
    }
    stringBuffer.append(TEXT_948);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_949);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_950);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_951);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_952);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_953);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_954);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_955);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_956);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_957);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_958);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_959);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_960);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(StringUtils.getPostgresqlProtectedColumnName(startDateField));
    columnNames.add(StringUtils.getPostgresqlProtectedColumnName(endDateField));
    if(isEnableActive) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_961);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_962);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_963);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_964);
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_965);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_966);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_967);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_968);
    }
    stringBuffer.append(TEXT_969);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_970);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_971);
    stringBuffer.append(endDateFieldType);
    stringBuffer.append(TEXT_972);
    if(isEnableActive) {
    stringBuffer.append(TEXT_973);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_974);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_975);
    }
    stringBuffer.append(TEXT_976);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_977);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_978);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_979);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_980);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_981);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_982);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_983);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_984);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_985);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_986);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_987);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_988);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_989);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_990);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_991);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_992);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_993);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_994);
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_995);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_996);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_997);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_998);
    }
    stringBuffer.append(TEXT_999);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1000);
    if(isEnableType2) {
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(endDateFieldType);
    stringBuffer.append(TEXT_1003);
    }
    stringBuffer.append(TEXT_1004);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_1005);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_1006);
    }
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1016);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1019);
    
}

    stringBuffer.append(TEXT_1020);
    } else if("postgres_id".equals(dbmsId)){
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(TEXT_1022);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

String strFieldName = "";
String selectColumnString = "";
String columnNameString = "";

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")) +
            " = t." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));                
        }
    }
    
    for(Map<String, String> type1Attribute : type1Attributes) {
        strFieldName = StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME"));
        columnNames.add(strFieldName);
        setColumns.add(strFieldName +  " = t." + strFieldName);                    
        whereClause.add(" COALESCE(d." + strFieldName + "<> t."+ strFieldName + ", (d." + strFieldName + " is null and not t." + strFieldName + " is null) or (not d." + strFieldName + " is null and t." + strFieldName + " is null))");                   
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");    
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");    
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1034);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1037);
    
    }
}

String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        strFieldName = StringUtils.getPostgresqlProtectedColumnName(type2Attribute.get("NAME"));            
        whereClause.add(" COALESCE(d." + strFieldName + "<> t."+ strFieldName + ", (d." + strFieldName + " is null and not t." + strFieldName + " is null) or (not d." + strFieldName + " is null and t." + strFieldName + " is null))");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1042);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_1044);
    }
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1054);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1057);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(StringUtils.getPostgresqlProtectedColumnName(startDateField));
    columnNames.add(StringUtils.getPostgresqlProtectedColumnName(endDateField));
    if(isEnableActive) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1060);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_1062);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1063);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_1065);
    }
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1068);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1069);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_1071);
    }
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1083);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1086);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_1087);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1089);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_1091);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1092);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_1094);
    }
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1096);
    if(isEnableType2) {
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1098);
    }
    stringBuffer.append(TEXT_1099);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_1100);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_1101);
    }
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1111);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1114);
    
}

    stringBuffer.append(TEXT_1115);
    } else if("sybase_id".equals(dbmsId)){
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(TEXT_1117);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

String selectColumnString = "";
String columnNameString = "";

List<String> joinClause = new ArrayList<String>();
List<String> updateJoinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + sk.get("NAME") + " = t." + sk.get("NAME"));
    updateJoinClause.add("\" + tableName_" + cid + " + \"." + sk.get("NAME") + " = t." + sk.get("NAME"));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");
String updateJoinClauseString = StringUtils.join(updateJoinClause.toArray(), " AND ");

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();        
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(sk.get("NAME"));
            }
        } else {
            columnNames.add(sk.get("NAME"));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(type1Attribute.get("NAME"));
        setColumns.add(type1Attribute.get("NAME") + " = t." + type1Attribute.get("NAME"));
        if(isFieldValueIncNull){
            whereClause.add("(\" + tableName_" + cid + " + \"." + type1Attribute.get("NAME") + " is null AND t." + type1Attribute.get("NAME")+" is not null )");
        	whereClause.add("(\" + tableName_" + cid + " + \"." + type1Attribute.get("NAME") + " is not null AND t." + type1Attribute.get("NAME")+" is null )");
        }
        whereClause.add("(\" + tableName_" + cid + " + \"." + type1Attribute.get("NAME") + " <> t." + type1Attribute.get("NAME")+")");            
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");    
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(updateJoinClauseString);
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1129);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1132);
    
    }
}

String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    List<String> updateWhereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
    	if(isFieldValueIncNull){
       		whereClause.add("(d." + type2Attribute.get("NAME") + " is null AND t." + type2Attribute.get("NAME")+" is not null )");
        	whereClause.add("(d." + type2Attribute.get("NAME") + " is not null AND t." + type2Attribute.get("NAME")+" is null )");
        	updateWhereClause.add("(\" + tableName_" + cid + " + \"." + type2Attribute.get("NAME") + " is null AND t." + type2Attribute.get("NAME")+" is not null )");
        	updateWhereClause.add("(\" + tableName_" + cid + " + \"." + type2Attribute.get("NAME") + " is not null AND t." + type2Attribute.get("NAME")+" is null )");
        }
        whereClause.add("(d." + type2Attribute.get("NAME") + " <> t." + type2Attribute.get("NAME")+")");
        updateWhereClause.add("(\" + tableName_" + cid + " + \"." + type2Attribute.get("NAME") + " <> t." + type2Attribute.get("NAME")+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    String updateWhereClauseString = StringUtils.join(updateWhereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1137);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_1139);
    }
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(updateJoinClauseString);
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(updateWhereClauseString);
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1150);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1153);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(sourceKey.get("NAME"));
            }
        } else {
            columnNames.add(sourceKey.get("NAME"));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(type1Attribute.get("NAME"));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(type2Attribute.get("NAME"));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(startDateField);
    columnNames.add(endDateField);
    if(isEnableActive) {
        columnNames.add(activeField);
    }
    if(isEnableVersion) {
        columnNames.add(versionField);
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1156);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_1157);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1158);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_1160);
    }
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1163);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1164);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_1166);
    }
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1178);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1181);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + sk.get("NAME") + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_1182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1184);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_1185);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1186);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_1188);
    }
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1190);
    if(isEnableType2) {
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1192);
    }
    stringBuffer.append(TEXT_1193);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_1194);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_1195);
    }
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1205);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1208);
    
}

    stringBuffer.append(TEXT_1209);
    } else if("redshift_id".equals(dbmsId)){
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(TEXT_1211);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + text_util.wrap(sk.get("NAME")) + " = t." + text_util.wrap(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

String strFieldName = "";
String selectColumnString = "";
String columnNameString = "";

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sk.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sk.get("NAME")));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
    	strFieldName = text_util.wrap(type1Attribute.get("NAME"));
        columnNames.add(strFieldName);
        setColumns.add(" " + strFieldName + " = t." + strFieldName);
        if(isFieldValueIncNull){
            whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
       	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1224);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1227);
    
    }
}

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

boolean useSequence = "DB_SEQUENCE".equals(surrogateKeyType);
String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        strFieldName = text_util.wrap(type2Attribute.get("NAME"));
    	if(isFieldValueIncNull){
        	whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
     	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1234);
    if (isEnableActive) {
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(text_util.wrap(activeField));
    stringBuffer.append(TEXT_1236);
    }
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1247);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1250);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(text_util.wrap(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(text_util.wrap(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(text_util.wrap(startDateField));
    columnNames.add(text_util.wrap(endDateField));
    if(isEnableActive) {
        columnNames.add(text_util.wrap(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(text_util.wrap(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1253);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1254);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1255);
    if(useSequence) {
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1257);
    }
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1260);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1261);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(text_util.wrap(versionField));
    stringBuffer.append(TEXT_1263);
    }
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1275);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1278);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + text_util.wrap(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_1279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1281);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1282);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1283);
    if(useSequence) {
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1285);
    }
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1287);
    if(isEnableType2) {
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1289);
    }
    stringBuffer.append(TEXT_1290);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_1291);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_1292);
    }
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1302);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1305);
    
}

    } else if("netezza_id".equals(dbmsId)){
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(TEXT_1307);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + text_util.wrap(sk.get("NAME")) + " = t." + text_util.wrap(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

String strFieldName = "";
String selectColumnString = "";
String columnNameString = "";

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sk.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sk.get("NAME")));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
    	strFieldName = text_util.wrap(type1Attribute.get("NAME"));
        columnNames.add(strFieldName);
        setColumns.add(" " + strFieldName + " = t." + strFieldName);
        if(isFieldValueIncNull){
            whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
       	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1319);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1322);
    
    }
}

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

boolean useSequence = "DB_SEQUENCE".equals(surrogateKeyType);
String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        strFieldName = text_util.wrap(type2Attribute.get("NAME"));
    	if(isFieldValueIncNull){
        	whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
     	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1329);
    if (isEnableActive) {
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(text_util.wrap(activeField));
    stringBuffer.append(TEXT_1331);
    }
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1341);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1344);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(text_util.wrap(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(text_util.wrap(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(text_util.wrap(startDateField));
    columnNames.add(text_util.wrap(endDateField));
    if(isEnableActive) {
        columnNames.add(text_util.wrap(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(text_util.wrap(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1347);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1348);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1349);
    if(useSequence) {
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1351);
    }
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1354);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1355);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(text_util.wrap(versionField));
    stringBuffer.append(TEXT_1357);
    }
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1369);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1372);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + text_util.wrap(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_1373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1375);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1376);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1377);
    if(useSequence) {
    stringBuffer.append(TEXT_1378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1379);
    }
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1381);
    if(isEnableType2) {
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1383);
    }
    stringBuffer.append(TEXT_1384);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_1385);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_1386);
    }
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1396);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1399);
    
}

    } else {
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(TEXT_1401);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + text_util.wrap(sk.get("NAME")) + " = t." + text_util.wrap(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

String strFieldName = "";
String selectColumnString = "";
String columnNameString = "";

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sk.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sk.get("NAME")));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
    	strFieldName = text_util.wrap(type1Attribute.get("NAME"));
        columnNames.add(strFieldName);
        setColumns.add(" " + strFieldName + " = t." + strFieldName);
        if(isFieldValueIncNull){
            whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
       	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1403);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_1405);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1414);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1417);
    
    }
}

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

boolean useSequence = "DB_SEQUENCE".equals(surrogateKeyType);
String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        strFieldName = text_util.wrap(type2Attribute.get("NAME"));
    	if(isFieldValueIncNull){
        	whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
     	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1424);
    if (isEnableActive) {
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(text_util.wrap(activeField));
    stringBuffer.append(TEXT_1426);
    }
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1431);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1437);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1440);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(text_util.wrap(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(text_util.wrap(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(text_util.wrap(startDateField));
    columnNames.add(text_util.wrap(endDateField));
    if(isEnableActive) {
        columnNames.add(text_util.wrap(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(text_util.wrap(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1443);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1444);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1445);
    if(useSequence) {
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1447);
    }
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1450);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1451);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(text_util.wrap(versionField));
    stringBuffer.append(TEXT_1453);
    }
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1455);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1456);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1457);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1465);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1468);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + text_util.wrap(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_1469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1471);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1472);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1473);
    if(useSequence) {
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1475);
    }
    stringBuffer.append(TEXT_1476);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1477);
    if(isEnableType2) {
    stringBuffer.append(TEXT_1478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1479);
    }
    stringBuffer.append(TEXT_1480);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_1481);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_1482);
    }
    stringBuffer.append(TEXT_1483);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1484);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1492);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_1493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1495);
    
}

    }
    return stringBuffer.toString();
  }
}
