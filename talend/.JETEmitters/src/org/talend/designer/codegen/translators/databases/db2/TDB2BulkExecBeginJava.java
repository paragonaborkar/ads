package org.talend.designer.codegen.translators.databases.db2;

import org.talend.core.model.metadata.IMetadataColumn;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TDB2BulkExecBeginJava {
  protected static String nl;
  public static synchronized TDB2BulkExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDB2BulkExecBeginJava result = new TDB2BulkExecBeginJava();
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
  protected final String TEXT_30 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_31 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_32 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_34 = " - Uses an existing connection ";
  protected final String TEXT_35 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_37 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_38 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_39 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\tconn_";
  protected final String TEXT_42 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_43 = ", dbUser_";
  protected final String TEXT_44 = ", dbPwd_";
  protected final String TEXT_45 = ");" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\tconn_";
  protected final String TEXT_47 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\tconn_";
  protected final String TEXT_49 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\tconn_";
  protected final String TEXT_51 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\tconn_";
  protected final String TEXT_53 = ".setAutoCommit(";
  protected final String TEXT_54 = ");" + NL + "\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t\tlog.";
  protected final String TEXT_56 = "(\"";
  protected final String TEXT_57 = " - \" + ";
  protected final String TEXT_58 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t    \t\tlog.";
  protected final String TEXT_60 = "(\"";
  protected final String TEXT_61 = "\");" + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_63 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_65 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_66 = ": pstmt_";
  protected final String TEXT_67 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_68 = " += (countEach_";
  protected final String TEXT_69 = " < 0 ? 0 : ";
  protected final String TEXT_70 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_71 = NL;
  protected final String TEXT_72 = NL + "        java.sql.Connection conn_";
  protected final String TEXT_73 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_74 = "\");" + NL + "        String schema_";
  protected final String TEXT_75 = " = (String)globalMap.get(\"";
  protected final String TEXT_76 = "\");" + NL + "        String dbUser_";
  protected final String TEXT_77 = " = (String)globalMap.get(\"";
  protected final String TEXT_78 = "\");";
  protected final String TEXT_79 = NL + "            String url_";
  protected final String TEXT_80 = " = \"jdbc:db2://\" + ";
  protected final String TEXT_81 = " + \":\" + ";
  protected final String TEXT_82 = " + \"/\" + ";
  protected final String TEXT_83 = ";";
  protected final String TEXT_84 = NL + "            String url_";
  protected final String TEXT_85 = " = \"jdbc:db2://\" + ";
  protected final String TEXT_86 = " + \":\" + ";
  protected final String TEXT_87 = " + \"/\" + ";
  protected final String TEXT_88 = " + \":\" + ";
  protected final String TEXT_89 = ";";
  protected final String TEXT_90 = NL + "        String driverClass_";
  protected final String TEXT_91 = " = \"com.ibm.db2.jcc.DB2Driver\";" + NL + "        java.lang.Class.forName(driverClass_";
  protected final String TEXT_92 = ");" + NL + "        String dbUser_";
  protected final String TEXT_93 = " = ";
  protected final String TEXT_94 = ";";
  protected final String TEXT_95 = NL;
  protected final String TEXT_96 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_97 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_98 = ");";
  protected final String TEXT_99 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = "; ";
  protected final String TEXT_102 = NL + "        String dbPwd_";
  protected final String TEXT_103 = " = decryptedPassword_";
  protected final String TEXT_104 = ";" + NL + "        String schema_";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = ";" + NL + "        java.sql.Connection conn_";
  protected final String TEXT_107 = " = null;";
  protected final String TEXT_108 = NL + "        String tableName_";
  protected final String TEXT_109 = " = null;" + NL + "        if(schema_";
  protected final String TEXT_110 = " == null || schema_";
  protected final String TEXT_111 = ".trim().length() == 0) {" + NL + "            tableName_";
  protected final String TEXT_112 = " = ";
  protected final String TEXT_113 = ";" + NL + "        } else {" + NL + "            tableName_";
  protected final String TEXT_114 = " = schema_";
  protected final String TEXT_115 = " +  \"\\\".\\\"\" + ";
  protected final String TEXT_116 = ";" + NL + "        }" + NL;
  protected final String TEXT_117 = NL + "class FileFinder{" + NL + "    public String getFilePathJoinedWithComma(java.io.File targetFolder, String globPattern, boolean willRecurse){" + NL + "        boolean useGlobPattern = (globPattern != null && !\"\".equals(globPattern));" + NL + "        if(!targetFolder.isDirectory()){" + NL + "            throw new RuntimeException(targetFolder.getAbsolutePath() + \"is not a folder.\");" + NL + "        }" + NL + "        java.util.Collection<java.io.File> collection = org.apache.commons.io.FileUtils.listFiles(targetFolder, null, willRecurse);" + NL + "        StringBuilder strBuilder = new StringBuilder();" + NL + "        boolean runOnWindows = \"\\\\\".equals(System.getProperty(\"file.separator\"));" + NL + "        int counter = 0;" + NL + "        if(useGlobPattern){" + NL + "            java.nio.file.PathMatcher matcher = java.nio.file.FileSystems.getDefault().getPathMatcher(\"glob:\" + globPattern);" + NL + "        for(java.io.File file: collection){" + NL + "                if(file.isDirectory()){" + NL + "                   continue;" + NL + "                }" + NL + "            if(matcher.matches(new java.io.File(file.getName()).toPath())){" + NL + "                    if(counter != 0){" + NL + "                        strBuilder.append(\", \");" + NL + "                    }" + NL + "                    String fileAbsPath = file.getAbsolutePath();" + NL + "                    if(runOnWindows){" + NL + "                           fileAbsPath = fileAbsPath.replace(\"/\",\"\\\\\");" + NL + "                    }" + NL + "                        strBuilder.append(fileAbsPath);" + NL + "                        counter ++;" + NL + "                    }" + NL + "            }" + NL + "        }else{" + NL + "            for(java.io.File file: collection){" + NL + "                if(file.isDirectory()){" + NL + "                   continue;" + NL + "                }" + NL + "                if(counter != 0){" + NL + "                    strBuilder.append(\", \");" + NL + "                }" + NL + "                String fileAbsPath = file.getAbsolutePath();" + NL + "                if(runOnWindows){" + NL + "                       fileAbsPath = fileAbsPath.replace(\"/\",\"\\\\\");" + NL + "                }" + NL + "                    strBuilder.append(fileAbsPath);" + NL + "                    counter ++;" + NL + "                }" + NL + "        }" + NL + "        return strBuilder.toString();" + NL + "    }" + NL + "}" + NL + "String runtimeFileSep_";
  protected final String TEXT_118 = " = System.getProperty(\"file.separator\");" + NL + "boolean runOnWindows_";
  protected final String TEXT_119 = " = \"\\\\\".equals(runtimeFileSep_";
  protected final String TEXT_120 = ");" + NL + "java.util.Map<String,String> fileSeparatorMapping_";
  protected final String TEXT_121 = " = new java.util.HashMap<>();" + NL + "fileSeparatorMapping_";
  protected final String TEXT_122 = ".put(\"\\\\\", \"/\");" + NL + "fileSeparatorMapping_";
  protected final String TEXT_123 = ".put(\"/\", \"\\\\\");";
  protected final String TEXT_124 = NL + "\t\t\tjava.sql.Statement stmtDrop_";
  protected final String TEXT_125 = " = conn_";
  protected final String TEXT_126 = ".createStatement();" + NL + "\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_128 = " - Droping table ";
  protected final String TEXT_129 = "\" + tableName_";
  protected final String TEXT_130 = " + \"";
  protected final String TEXT_131 = ".\");" + NL + "\t\t\t";
  protected final String TEXT_132 = NL + "\t\t\tstmtDrop_";
  protected final String TEXT_133 = ".execute(\"";
  protected final String TEXT_134 = "\");" + NL + "\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_136 = " - Drop table ";
  protected final String TEXT_137 = "\" + tableName_";
  protected final String TEXT_138 = " + \"";
  protected final String TEXT_139 = " has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\tstmtDrop_";
  protected final String TEXT_141 = ".close();" + NL + "\t\t\tjava.sql.Statement stmtCreate_";
  protected final String TEXT_142 = " = conn_";
  protected final String TEXT_143 = ".createStatement();" + NL + "\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_145 = " - Creating table ";
  protected final String TEXT_146 = "\" + tableName_";
  protected final String TEXT_147 = " + \"";
  protected final String TEXT_148 = ".\");" + NL + "\t\t\t";
  protected final String TEXT_149 = NL + "\t\t\tstmtCreate_";
  protected final String TEXT_150 = ".execute(\"";
  protected final String TEXT_151 = ")\");" + NL + "\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_153 = " - Create table ";
  protected final String TEXT_154 = "\" + tableName_";
  protected final String TEXT_155 = " + \"";
  protected final String TEXT_156 = " has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_157 = NL + "\t\t\tstmtCreate_";
  protected final String TEXT_158 = ".close();" + NL + "\t\t";
  protected final String TEXT_159 = NL + "\t\t\tjava.sql.Statement stmtCreate_";
  protected final String TEXT_160 = " = conn_";
  protected final String TEXT_161 = ".createStatement();" + NL + "\t\t\t";
  protected final String TEXT_162 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_163 = " - Creating table ";
  protected final String TEXT_164 = "\" + tableName_";
  protected final String TEXT_165 = " + \"";
  protected final String TEXT_166 = ".\");" + NL + "\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\tstmtCreate_";
  protected final String TEXT_168 = ".execute(\"";
  protected final String TEXT_169 = ")\");" + NL + "\t\t\t";
  protected final String TEXT_170 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_171 = " - Create table ";
  protected final String TEXT_172 = "\" + tableName_";
  protected final String TEXT_173 = " + \"";
  protected final String TEXT_174 = " has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_175 = NL + "\t\t\tstmtCreate_";
  protected final String TEXT_176 = ".close();" + NL + "\t\t";
  protected final String TEXT_177 = "   " + NL + "\t\t\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_179 = " = conn_";
  protected final String TEXT_180 = ".getMetaData();" + NL + "\t\t\t\tif(tableNameForSearch_";
  protected final String TEXT_181 = ".indexOf(\"\\\"\")==-1){" + NL + "\t\t\t\t\ttableNameForSearch_";
  protected final String TEXT_182 = " = tableNameForSearch_";
  protected final String TEXT_183 = ".toUpperCase();" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttableNameForSearch_";
  protected final String TEXT_184 = " = tableNameForSearch_";
  protected final String TEXT_185 = ".replaceAll(\"\\\"\",\"\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tjava.sql.ResultSet rsTable_";
  protected final String TEXT_186 = " = dbMetaData_";
  protected final String TEXT_187 = ".getTables(null, dbschemaForSearch_";
  protected final String TEXT_188 = ", tableNameForSearch_";
  protected final String TEXT_189 = ", new String[]{\"TABLE\"});" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_190 = " = false;" + NL + "\t\t\t\tif(rsTable_";
  protected final String TEXT_191 = ".next()) {" + NL + "\t\t\t\t\twhetherExist_";
  protected final String TEXT_192 = " = true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\trsTable_";
  protected final String TEXT_193 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_195 = " = conn_";
  protected final String TEXT_196 = ".getMetaData();" + NL + "\t\t\t\tjava.sql.ResultSet rsTable_";
  protected final String TEXT_197 = " = dbMetaData_";
  protected final String TEXT_198 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_199 = " = false;" + NL + "\t\t\t\twhile(rsTable_";
  protected final String TEXT_200 = ".next()) {" + NL + "\t\t\t\t\tString table_";
  protected final String TEXT_201 = " = rsTable_";
  protected final String TEXT_202 = ".getString(\"TABLE_NAME\");" + NL + "\t\t\t\t\tString schema_";
  protected final String TEXT_203 = " = rsTable_";
  protected final String TEXT_204 = ".getString(\"TABLE_SCHEM\");" + NL + "\t\t\t\t\tif(table_";
  protected final String TEXT_205 = ".equalsIgnoreCase(";
  protected final String TEXT_206 = ")" + NL + "\t\t\t\t\t\t&& (schema_";
  protected final String TEXT_207 = ".equalsIgnoreCase(dbschema_";
  protected final String TEXT_208 = ") || dbschema_";
  protected final String TEXT_209 = ".trim().length() ==0)) {" + NL + "\t\t\t\t\t\twhetherExist_";
  protected final String TEXT_210 = " = true;" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\trsTable_";
  protected final String TEXT_211 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_212 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_213 = " = conn_";
  protected final String TEXT_214 = ".getMetaData();" + NL + "\t\t\t\tjava.sql.ResultSet rsTable_";
  protected final String TEXT_215 = " = dbMetaData_";
  protected final String TEXT_216 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_217 = " = false;" + NL + "\t\t\t\twhile(rsTable_";
  protected final String TEXT_218 = ".next()) {" + NL + "\t\t\t\t\tString table_";
  protected final String TEXT_219 = " = rsTable_";
  protected final String TEXT_220 = ".getString(\"TABLE_NAME\");" + NL + "\t\t\t\t\tString bkSchema_";
  protected final String TEXT_221 = " = rsTable_";
  protected final String TEXT_222 = ".getString(\"TABLE_SCHEM\");" + NL + "\t\t\t\t\tif(table_";
  protected final String TEXT_223 = ".equals(";
  protected final String TEXT_224 = ") " + NL + "\t\t\t\t\t\t&& (bkSchema_";
  protected final String TEXT_225 = ".equals(schema_";
  protected final String TEXT_226 = ") || (schema_";
  protected final String TEXT_227 = ".trim().length() ==0 && dbUser_";
  protected final String TEXT_228 = ".equalsIgnoreCase(bkSchema_";
  protected final String TEXT_229 = ")))) {" + NL + "\t\t\t\t\t\twhetherExist_";
  protected final String TEXT_230 = " = true;" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\trsTable_";
  protected final String TEXT_231 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_232 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_233 = " = conn_";
  protected final String TEXT_234 = ".getMetaData();" + NL + "\t\t\t\tjava.sql.ResultSet rsTable_";
  protected final String TEXT_235 = " = dbMetaData_";
  protected final String TEXT_236 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_237 = " = false;" + NL + "\t\t\t\tString defaultSchema_";
  protected final String TEXT_238 = " = \"public\";" + NL + "\t\t\t\tif(dbschema_";
  protected final String TEXT_239 = " == null || dbschema_";
  protected final String TEXT_240 = ".trim().length() == 0) {" + NL + "\t\t\t\t\tjava.sql.Statement stmtSchema_";
  protected final String TEXT_241 = " = conn_";
  protected final String TEXT_242 = ".createStatement();" + NL + "\t\t\t\t\tjava.sql.ResultSet rsSchema_";
  protected final String TEXT_243 = " = stmtSchema_";
  protected final String TEXT_244 = ".executeQuery(\"select current_schema() \");" + NL + "\t\t\t\t\twhile(rsSchema_";
  protected final String TEXT_245 = ".next()){" + NL + "\t\t\t\t\t\tdefaultSchema_";
  protected final String TEXT_246 = " = rsSchema_";
  protected final String TEXT_247 = ".getString(\"current_schema\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\trsSchema_";
  protected final String TEXT_248 = ".close();" + NL + "\t\t\t\t\tstmtSchema_";
  protected final String TEXT_249 = ".close();" + NL + "\t\t\t\t}" + NL + "\t\t\t\twhile(rsTable_";
  protected final String TEXT_250 = ".next()) {" + NL + "\t\t\t\t\tString table_";
  protected final String TEXT_251 = " = rsTable_";
  protected final String TEXT_252 = ".getString(\"TABLE_NAME\");" + NL + "\t\t\t\t\tString schema_";
  protected final String TEXT_253 = " = rsTable_";
  protected final String TEXT_254 = ".getString(\"TABLE_SCHEM\");" + NL + "\t\t\t\t\tif(table_";
  protected final String TEXT_255 = ".equals";
  protected final String TEXT_256 = "IgnoreCase";
  protected final String TEXT_257 = "(";
  protected final String TEXT_258 = ") " + NL + "\t\t\t\t\t\t&& (schema_";
  protected final String TEXT_259 = ".equals";
  protected final String TEXT_260 = "IgnoreCase";
  protected final String TEXT_261 = "(dbschema_";
  protected final String TEXT_262 = ") || ((dbschema_";
  protected final String TEXT_263 = " ==null || dbschema_";
  protected final String TEXT_264 = ".trim().length() ==0) && defaultSchema_";
  protected final String TEXT_265 = ".equals";
  protected final String TEXT_266 = "IgnoreCase";
  protected final String TEXT_267 = "(schema_";
  protected final String TEXT_268 = ")))) {" + NL + "\t\t\t\t\t\twhetherExist_";
  protected final String TEXT_269 = " = true;" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\trsTable_";
  protected final String TEXT_270 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_271 = NL + "            \tString tableForSearch_";
  protected final String TEXT_272 = " = ";
  protected final String TEXT_273 = ";" + NL + "            \tif(tableForSearch_";
  protected final String TEXT_274 = " != null){" + NL + "            \t\tif(tableForSearch_";
  protected final String TEXT_275 = ".startsWith(\"\\\"\") && tableForSearch_";
  protected final String TEXT_276 = ".endsWith(\"\\\"\")){" + NL + "            \t\t\ttableForSearch_";
  protected final String TEXT_277 = " =  tableForSearch_";
  protected final String TEXT_278 = ".substring(1,tableForSearch_";
  protected final String TEXT_279 = ".length()-1);" + NL + "            \t\t}else{" + NL + "            \t\t\ttableForSearch_";
  protected final String TEXT_280 = " =  tableForSearch_";
  protected final String TEXT_281 = ".toUpperCase();" + NL + "            \t\t}" + NL + "            \t}" + NL + "                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_282 = " = conn_";
  protected final String TEXT_283 = ".getMetaData();" + NL + "                java.sql.ResultSet rsTable_";
  protected final String TEXT_284 = " = dbMetaData_";
  protected final String TEXT_285 = ".getTables(null, conn_";
  protected final String TEXT_286 = ".getSchema(), tableForSearch_";
  protected final String TEXT_287 = ", new String[]{\"TABLE\"});" + NL + "                boolean whetherExist_";
  protected final String TEXT_288 = " = false;" + NL + "               \tif(rsTable_";
  protected final String TEXT_289 = ".next()) {" + NL + "\t\t\t\t\twhetherExist_";
  protected final String TEXT_290 = " = true;" + NL + "\t\t\t\t}" + NL + "                rsTable_";
  protected final String TEXT_291 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_292 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_293 = " = conn_";
  protected final String TEXT_294 = ".getMetaData();" + NL + "\t\t\t\tjava.sql.ResultSet rsTable_";
  protected final String TEXT_295 = " = dbMetaData_";
  protected final String TEXT_296 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_297 = " = false;" + NL + "\t\t\t\twhile(rsTable_";
  protected final String TEXT_298 = ".next()) {" + NL + "\t\t\t\t\tString table_";
  protected final String TEXT_299 = " = rsTable_";
  protected final String TEXT_300 = ".getString(\"TABLE_NAME\");" + NL + "\t\t\t\t\tif(table_";
  protected final String TEXT_301 = ".equals";
  protected final String TEXT_302 = "IgnoreCase";
  protected final String TEXT_303 = "(";
  protected final String TEXT_304 = ")) {" + NL + "\t\t\t\t\t\twhetherExist_";
  protected final String TEXT_305 = " = true;" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\trsTable_";
  protected final String TEXT_306 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_307 = NL + "\t\t\t\tif(!whetherExist_";
  protected final String TEXT_308 = ") {" + NL + "\t\t\t\t\tjava.sql.Statement stmtCreate_";
  protected final String TEXT_309 = " = conn_";
  protected final String TEXT_310 = ".createStatement();" + NL + "\t\t\t\t\t";
  protected final String TEXT_311 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_312 = " - Creating table ";
  protected final String TEXT_313 = "\" + tableName_";
  protected final String TEXT_314 = " + \"";
  protected final String TEXT_315 = ".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_316 = NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_317 = ".execute(\"";
  protected final String TEXT_318 = ")\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_319 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_320 = " - Create table ";
  protected final String TEXT_321 = "\" + tableName_";
  protected final String TEXT_322 = " + \"";
  protected final String TEXT_323 = " has succeeded.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_324 = NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_325 = ".close();" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_326 = NL + "\t\t\t\tif(whetherExist_";
  protected final String TEXT_327 = ") {" + NL + "\t\t\t\t\tjava.sql.Statement stmtDrop_";
  protected final String TEXT_328 = " = conn_";
  protected final String TEXT_329 = ".createStatement();" + NL + "\t\t\t\t\t";
  protected final String TEXT_330 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_331 = " - Droping table ";
  protected final String TEXT_332 = "\" + tableName_";
  protected final String TEXT_333 = " + \"";
  protected final String TEXT_334 = ".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_335 = NL + "\t\t\t\t\tstmtDrop_";
  protected final String TEXT_336 = ".execute(\"";
  protected final String TEXT_337 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_338 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_339 = " - Drop table ";
  protected final String TEXT_340 = "\" + tableName_";
  protected final String TEXT_341 = " + \"";
  protected final String TEXT_342 = " has succeeded.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_343 = NL + "\t\t\t\t\tstmtDrop_";
  protected final String TEXT_344 = ".close();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tjava.sql.Statement stmtCreate_";
  protected final String TEXT_345 = " = conn_";
  protected final String TEXT_346 = ".createStatement();" + NL + "\t\t\t\t";
  protected final String TEXT_347 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_348 = " - Creating table ";
  protected final String TEXT_349 = "\" + tableName_";
  protected final String TEXT_350 = " + \"";
  protected final String TEXT_351 = ".\" );" + NL + "\t\t\t\t";
  protected final String TEXT_352 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_353 = ".execute(\"";
  protected final String TEXT_354 = ")\");" + NL + "\t\t\t\t";
  protected final String TEXT_355 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_356 = " - Create table ";
  protected final String TEXT_357 = "\" + tableName_";
  protected final String TEXT_358 = " + \"";
  protected final String TEXT_359 = " has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_360 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_361 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_362 = NL + "\t\t\tjava.sql.Statement stmtClear_";
  protected final String TEXT_363 = " = conn_";
  protected final String TEXT_364 = ".createStatement();" + NL + "\t\t\t";
  protected final String TEXT_365 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_366 = " - Clearing table ";
  protected final String TEXT_367 = "\" + tableName_";
  protected final String TEXT_368 = " + \"";
  protected final String TEXT_369 = ".\");" + NL + "\t\t\t";
  protected final String TEXT_370 = NL + "\t\t\tstmtClear_";
  protected final String TEXT_371 = ".executeUpdate(\"";
  protected final String TEXT_372 = "\");" + NL + "\t\t\t";
  protected final String TEXT_373 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_374 = "- Clear table ";
  protected final String TEXT_375 = "\" + tableName_";
  protected final String TEXT_376 = " + \"";
  protected final String TEXT_377 = " has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_378 = NL + "\t\t\tstmtClear_";
  protected final String TEXT_379 = ".close();" + NL + "\t\t";
  protected final String TEXT_380 = NL + "\t\t\tjava.sql.Statement stmtTruncCount_";
  protected final String TEXT_381 = " = conn_";
  protected final String TEXT_382 = ".createStatement();" + NL + "\t\t\tjava.sql.ResultSet rsTruncCount_";
  protected final String TEXT_383 = " = stmtTruncCount_";
  protected final String TEXT_384 = ".executeQuery(\"";
  protected final String TEXT_385 = "\");" + NL + "\t\t\tjava.sql.Statement stmtTrunc_";
  protected final String TEXT_386 = " = conn_";
  protected final String TEXT_387 = ".createStatement();" + NL + "\t\t\t";
  protected final String TEXT_388 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_389 = " - Trancating table ";
  protected final String TEXT_390 = "\" + tableName_";
  protected final String TEXT_391 = " + \"";
  protected final String TEXT_392 = ".\");" + NL + "\t\t\t";
  protected final String TEXT_393 = NL + "\t\t\tstmtTrunc_";
  protected final String TEXT_394 = ".executeUpdate(\"";
  protected final String TEXT_395 = "\");" + NL + "   \t    \t";
  protected final String TEXT_396 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_397 = " - Truncate table ";
  protected final String TEXT_398 = "\" + tableName_";
  protected final String TEXT_399 = " + \"";
  protected final String TEXT_400 = " has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_401 = NL + "\t\t\twhile(rsTruncCount_";
  protected final String TEXT_402 = ".next()) {" + NL + "\t\t\t\tdeletedCount_";
  protected final String TEXT_403 = " += rsTruncCount_";
  protected final String TEXT_404 = ".getInt(1);" + NL + "\t\t\t}" + NL + "\t\t\trsTruncCount_";
  protected final String TEXT_405 = ".close();" + NL + "\t\t\tstmtTruncCount_";
  protected final String TEXT_406 = ".close();" + NL + "\t\t\tstmtTrunc_";
  protected final String TEXT_407 = ".close();" + NL + "\t\t";
  protected final String TEXT_408 = NL + "\t\t//in mysql when autoCommit=true don't commit." + NL + "\t\tif (! conn_";
  protected final String TEXT_409 = ".getAutoCommit()) {" + NL + "\t\t\tconn_";
  protected final String TEXT_410 = ".commit();" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_411 = NL + "   FileFinder fileFinder_";
  protected final String TEXT_412 = " = new FileFinder();";
  protected final String TEXT_413 = NL + "            final String decryptedPassword_";
  protected final String TEXT_414 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_415 = ");";
  protected final String TEXT_416 = NL + "            final String decryptedPassword_";
  protected final String TEXT_417 = " = ";
  protected final String TEXT_418 = ";";
  protected final String TEXT_419 = NL + "        String dbPwd_";
  protected final String TEXT_420 = " = decryptedPassword_";
  protected final String TEXT_421 = ";";
  protected final String TEXT_422 = NL + "    String fullTableName_";
  protected final String TEXT_423 = " = ";
  protected final String TEXT_424 = ";" + NL + "    if(!\"\".equals(";
  protected final String TEXT_425 = ") && !\"\\\"\\\"\".equals(";
  protected final String TEXT_426 = ") && ";
  protected final String TEXT_427 = " != null){" + NL + "        fullTableName_";
  protected final String TEXT_428 = " = \"\\\"\" + ";
  protected final String TEXT_429 = " + \"\\\".\\\"\" + fullTableName_";
  protected final String TEXT_430 = " + \"\\\"\";" + NL + "    }";
  protected final String TEXT_431 = NL + "   String scriptPath_";
  protected final String TEXT_432 = " = ";
  protected final String TEXT_433 = ";";
  protected final String TEXT_434 = NL;
  protected final String TEXT_435 = NL + "                     String columnDelimiter_";
  protected final String TEXT_436 = " = \", \";" + NL + "                     StringBuilder ingestCmd_";
  protected final String TEXT_437 = " = new StringBuilder(\"ingest data from\");";
  protected final String TEXT_438 = NL + "                     ingestCmd_";
  protected final String TEXT_439 = ".append(\" ";
  protected final String TEXT_440 = " \");";
  protected final String TEXT_441 = NL + "                     ingestCmd_";
  protected final String TEXT_442 = ".append((";
  protected final String TEXT_443 = ").replace(" + NL + "                                                                                 fileSeparatorMapping_";
  protected final String TEXT_444 = ".get(runtimeFileSep_";
  protected final String TEXT_445 = ")" + NL + "                                                                                 , runtimeFileSep_";
  protected final String TEXT_446 = ")" + NL + "                                                                               );";
  protected final String TEXT_447 = NL + "                     ingestCmd_";
  protected final String TEXT_448 = ".append(";
  protected final String TEXT_449 = ");";
  protected final String TEXT_450 = NL + "                     ingestCmd_";
  protected final String TEXT_451 = ".append(" + NL + "                                          fileFinder_";
  protected final String TEXT_452 = ".getFilePathJoinedWithComma(" + NL + "                                          new java.io.File(";
  protected final String TEXT_453 = ")" + NL + "                                        , ";
  protected final String TEXT_454 = NL + "                                        , ";
  protected final String TEXT_455 = NL + "                                                            )" + NL + "                                                );";
  protected final String TEXT_456 = NL + "                     Compile Err: UNSUPPORTED LOAD TYPE ";
  protected final String TEXT_457 = NL + "                     ingestCmd_";
  protected final String TEXT_458 = ".append(\" format\");";
  protected final String TEXT_459 = NL + "                     ingestCmd_";
  protected final String TEXT_460 = ".append(\" delimited\");";
  protected final String TEXT_461 = NL + "                     ingestCmd_";
  protected final String TEXT_462 = ".append(\" by '\");" + NL + "                     ingestCmd_";
  protected final String TEXT_463 = ".append(";
  protected final String TEXT_464 = ");" + NL + "                     ingestCmd_";
  protected final String TEXT_465 = ".append(\"'\");";
  protected final String TEXT_466 = NL + "                     ingestCmd_";
  protected final String TEXT_467 = ".append(\" positional\");";
  protected final String TEXT_468 = NL + "                     ingestCmd_";
  protected final String TEXT_469 = ".append(\" recordlen \");" + NL + "                     ingestCmd_";
  protected final String TEXT_470 = ".append(Integer.valueOf(";
  protected final String TEXT_471 = "));";
  protected final String TEXT_472 = NL + "                     Compile Err: UNSUPPORTED DATA FORMAT ";
  protected final String TEXT_473 = NL + "                     ingestCmd_";
  protected final String TEXT_474 = ".append(\" input codepage \");" + NL + "                     ingestCmd_";
  protected final String TEXT_475 = ".append(Integer.valueOf(";
  protected final String TEXT_476 = "));";
  protected final String TEXT_477 = NL;
  protected final String TEXT_478 = NL + "StringBuilder fieldDefinition_";
  protected final String TEXT_479 = " = new StringBuilder(\" (\");";
  protected final String TEXT_480 = NL + "            fieldDefinition_";
  protected final String TEXT_481 = ".append(columnDelimiter_";
  protected final String TEXT_482 = ");";
  protected final String TEXT_483 = NL + "            fieldDefinition_";
  protected final String TEXT_484 = ".append(\"\\\"$";
  protected final String TEXT_485 = "\\\"\");";
  protected final String TEXT_486 = NL + "               fieldDefinition_";
  protected final String TEXT_487 = ".append(\" position(\");" + NL + "               fieldDefinition_";
  protected final String TEXT_488 = ".append(Integer.valueOf(";
  protected final String TEXT_489 = "));" + NL + "               fieldDefinition_";
  protected final String TEXT_490 = ".append(\":\");" + NL + "               fieldDefinition_";
  protected final String TEXT_491 = ".append(Integer.valueOf(";
  protected final String TEXT_492 = "));" + NL + "               fieldDefinition_";
  protected final String TEXT_493 = ".append(\")\");";
  protected final String TEXT_494 = NL + "               fieldDefinition_";
  protected final String TEXT_495 = ".append(\" ";
  protected final String TEXT_496 = "\");";
  protected final String TEXT_497 = NL + "               Compile Err: UNSUPPORTED DATABASE TYPE ";
  protected final String TEXT_498 = " FOR INGEST COMMAND, PLEASE TRY TO USE LOAD COMMAND.";
  protected final String TEXT_499 = NL + "            Compile Err: YOU MUST SET THE LENGTH FOR THE COLUMN ";
  protected final String TEXT_500 = ".";
  protected final String TEXT_501 = NL + "            fieldDefinition_";
  protected final String TEXT_502 = ".append(\"(";
  protected final String TEXT_503 = ")\");";
  protected final String TEXT_504 = NL + "            fieldDefinition_";
  protected final String TEXT_505 = ".append(\" OPTIONALLY ENCLOSED BY '\");" + NL + "            fieldDefinition_";
  protected final String TEXT_506 = ".append(";
  protected final String TEXT_507 = ");" + NL + "            fieldDefinition_";
  protected final String TEXT_508 = ".append(\"'\");";
  protected final String TEXT_509 = NL + "            fieldDefinition_";
  protected final String TEXT_510 = ".append(\"(";
  protected final String TEXT_511 = ",";
  protected final String TEXT_512 = ")\");";
  protected final String TEXT_513 = NL + "               fieldDefinition_";
  protected final String TEXT_514 = ".append(\" EXTERNAL\");";
  protected final String TEXT_515 = NL + "            fieldDefinition_";
  protected final String TEXT_516 = ".append(\" '\");" + NL + "            fieldDefinition_";
  protected final String TEXT_517 = ".append(";
  protected final String TEXT_518 = ");" + NL + "            fieldDefinition_";
  protected final String TEXT_519 = ".append(\"'\");";
  protected final String TEXT_520 = NL + "            fieldDefinition_";
  protected final String TEXT_521 = ".append(\" OPTIONALLY ENCLOSED BY '\");" + NL + "            fieldDefinition_";
  protected final String TEXT_522 = ".append(";
  protected final String TEXT_523 = ");" + NL + "            fieldDefinition_";
  protected final String TEXT_524 = ".append(\"'\");";
  protected final String TEXT_525 = NL + "            fieldDefinition_";
  protected final String TEXT_526 = ".append(\" EXTERNAL\");";
  protected final String TEXT_527 = NL + "           fieldDefinition_";
  protected final String TEXT_528 = ".append(\")\");" + NL + "                    ingestCmd_";
  protected final String TEXT_529 = ".append(fieldDefinition_";
  protected final String TEXT_530 = ");";
  protected final String TEXT_531 = NL;
  protected final String TEXT_532 = NL + "                    Compile Err: UNSUPPORTED ERR FILE TYPE ";
  protected final String TEXT_533 = NL + "                    ingestCmd_";
  protected final String TEXT_534 = ".append(\" ";
  protected final String TEXT_535 = "\");" + NL + "                    ingestCmd_";
  protected final String TEXT_536 = ".append(";
  protected final String TEXT_537 = ");";
  protected final String TEXT_538 = NL + "                       ingestCmd_";
  protected final String TEXT_539 = ".append(\" exception table \");" + NL + "                       ingestCmd_";
  protected final String TEXT_540 = ".append(";
  protected final String TEXT_541 = ");";
  protected final String TEXT_542 = NL + "                       ingestCmd_";
  protected final String TEXT_543 = ".append(\" warningcount \");" + NL + "                       ingestCmd_";
  protected final String TEXT_544 = ".append(Integer.valueOf(";
  protected final String TEXT_545 = "));";
  protected final String TEXT_546 = NL + "                       ingestCmd_";
  protected final String TEXT_547 = ".append(\" messages \");" + NL + "                       ingestCmd_";
  protected final String TEXT_548 = ".append(";
  protected final String TEXT_549 = ");";
  protected final String TEXT_550 = NL + "                    ingestCmd_";
  protected final String TEXT_551 = ".append(\" restart \");" + NL + "                    ingestCmd_";
  protected final String TEXT_552 = ".append(\"";
  protected final String TEXT_553 = "\");";
  protected final String TEXT_554 = NL + "                     ingestCmd_";
  protected final String TEXT_555 = ".append(\" '\");" + NL + "                     ingestCmd_";
  protected final String TEXT_556 = ".append(";
  protected final String TEXT_557 = ");" + NL + "                     ingestCmd_";
  protected final String TEXT_558 = ".append(\"'\");";
  protected final String TEXT_559 = NL + "                     ingestCmd_";
  protected final String TEXT_560 = ".append(\" '\");" + NL + "                     ingestCmd_";
  protected final String TEXT_561 = ".append(";
  protected final String TEXT_562 = ");" + NL + "                     ingestCmd_";
  protected final String TEXT_563 = ".append(\"'\");";
  protected final String TEXT_564 = NL + "                        Compile Err: JOB ID MUST NOT BE EMPTY.";
  protected final String TEXT_565 = NL;
  protected final String TEXT_566 = NL + "                     StringBuilder valStatement_";
  protected final String TEXT_567 = " = new StringBuilder(\" (\");" + NL + "                     StringBuilder valsStatement_";
  protected final String TEXT_568 = " = new StringBuilder(\"(\");";
  protected final String TEXT_569 = NL + "                              valStatement_";
  protected final String TEXT_570 = ".append(columnDelimiter_";
  protected final String TEXT_571 = ");" + NL + "                              valsStatement_";
  protected final String TEXT_572 = ".append(columnDelimiter_";
  protected final String TEXT_573 = ");";
  protected final String TEXT_574 = NL + "                             valStatement_";
  protected final String TEXT_575 = ".append(\"\\\"";
  protected final String TEXT_576 = "\\\"\");" + NL + "                             valsStatement_";
  protected final String TEXT_577 = ".append(\"$";
  protected final String TEXT_578 = "\");";
  protected final String TEXT_579 = NL + "                             valStatement_";
  protected final String TEXT_580 = ".append(\")\");" + NL + "                             valsStatement_";
  protected final String TEXT_581 = ".append(\")\");";
  protected final String TEXT_582 = NL;
  protected final String TEXT_583 = NL + "                   ingestCmd_";
  protected final String TEXT_584 = ".append(\" ";
  protected final String TEXT_585 = " into \");" + NL + "                   ingestCmd_";
  protected final String TEXT_586 = ".append(fullTableName_";
  protected final String TEXT_587 = ");";
  protected final String TEXT_588 = NL + "                      ingestCmd_";
  protected final String TEXT_589 = ".append(valStatement_";
  protected final String TEXT_590 = ");";
  protected final String TEXT_591 = NL + "                      ingestCmd_";
  protected final String TEXT_592 = ".append(\" \");" + NL + "                      ingestCmd_";
  protected final String TEXT_593 = ".append(";
  protected final String TEXT_594 = ");";
  protected final String TEXT_595 = NL + "                      ingestCmd_";
  protected final String TEXT_596 = ".append(valStatement_";
  protected final String TEXT_597 = ");" + NL + "                      ingestCmd_";
  protected final String TEXT_598 = ".append(\" values \");" + NL + "                      ingestCmd_";
  protected final String TEXT_599 = ".append(valsStatement_";
  protected final String TEXT_600 = ");";
  protected final String TEXT_601 = NL + "                   ingestCmd_";
  protected final String TEXT_602 = ".append(\" update \");" + NL + "                   ingestCmd_";
  protected final String TEXT_603 = ".append(fullTableName_";
  protected final String TEXT_604 = ");" + NL + "                   ingestCmd_";
  protected final String TEXT_605 = ".append(\" set \");" + NL + "                   StringBuilder updateKey_";
  protected final String TEXT_606 = " = new StringBuilder(\"(\");" + NL + "                   StringBuilder updateVal_";
  protected final String TEXT_607 = " = new StringBuilder(\"(\");";
  protected final String TEXT_608 = NL + "                            updateKey_";
  protected final String TEXT_609 = ".append(columnDelimiter_";
  protected final String TEXT_610 = ");" + NL + "                            updateVal_";
  protected final String TEXT_611 = ".append(columnDelimiter_";
  protected final String TEXT_612 = ");";
  protected final String TEXT_613 = NL + "                            updateKey_";
  protected final String TEXT_614 = ".append(\"";
  protected final String TEXT_615 = "\");" + NL + "                            updateVal_";
  protected final String TEXT_616 = ".append(\"";
  protected final String TEXT_617 = "\");";
  protected final String TEXT_618 = NL + "                            updateKey_";
  protected final String TEXT_619 = ".append(columnDelimiter_";
  protected final String TEXT_620 = ");" + NL + "                            updateVal_";
  protected final String TEXT_621 = ".append(columnDelimiter_";
  protected final String TEXT_622 = ");";
  protected final String TEXT_623 = NL + "                            updateKey_";
  protected final String TEXT_624 = ".append(\"";
  protected final String TEXT_625 = "\");" + NL + "                            updateVal_";
  protected final String TEXT_626 = ".append(\"$";
  protected final String TEXT_627 = "\");";
  protected final String TEXT_628 = NL + "                        updateKey_";
  protected final String TEXT_629 = ".append(\")\");" + NL + "                        updateVal_";
  protected final String TEXT_630 = ".append(\") \");" + NL + "                        ingestCmd_";
  protected final String TEXT_631 = ".append(updateKey_";
  protected final String TEXT_632 = ");" + NL + "                        ingestCmd_";
  protected final String TEXT_633 = ".append(\" = \");" + NL + "                        ingestCmd_";
  protected final String TEXT_634 = ".append(updateVal_";
  protected final String TEXT_635 = ");" + NL + "                        ingestCmd_";
  protected final String TEXT_636 = ".append(";
  protected final String TEXT_637 = ");";
  protected final String TEXT_638 = NL + "                        ingestCmd_";
  protected final String TEXT_639 = ".append(\" delete from \");" + NL + "                        ingestCmd_";
  protected final String TEXT_640 = ".append(fullTableName_";
  protected final String TEXT_641 = ");" + NL + "                        ingestCmd_";
  protected final String TEXT_642 = ".append(\" \");" + NL + "                        ingestCmd_";
  protected final String TEXT_643 = ".append(";
  protected final String TEXT_644 = ");";
  protected final String TEXT_645 = NL + "                      ingestCmd_";
  protected final String TEXT_646 = ".append(\" \");" + NL + "                      ingestCmd_";
  protected final String TEXT_647 = ".append(";
  protected final String TEXT_648 = ");";
  protected final String TEXT_649 = NL;
  protected final String TEXT_650 = NL + "                   if(!(scriptPath_";
  protected final String TEXT_651 = ".endsWith(\"/\") || scriptPath_";
  protected final String TEXT_652 = ".endsWith(\"\\\\\"))){" + NL + "                       scriptPath_";
  protected final String TEXT_653 = " = scriptPath_";
  protected final String TEXT_654 = " + java.io.File.separator;" + NL + "                    }" + NL + "                       scriptPath_";
  protected final String TEXT_655 = " = scriptPath_";
  protected final String TEXT_656 = ".replace(" + NL + "                                                     fileSeparatorMapping_";
  protected final String TEXT_657 = ".get(runtimeFileSep_";
  protected final String TEXT_658 = ")" + NL + "                                                     , runtimeFileSep_";
  protected final String TEXT_659 = ");" + NL + "                       String scriptStorageFolder_";
  protected final String TEXT_660 = " = scriptPath_";
  protected final String TEXT_661 = ";" + NL + "                       scriptPath_";
  protected final String TEXT_662 = " = scriptPath_";
  protected final String TEXT_663 = " + \"db2_ingest_cmd.db2\";" + NL + "" + NL + "                   java.io.Writer writer_";
  protected final String TEXT_664 = " = new java.io.BufferedWriter(" + NL + "                                                        new java.io.OutputStreamWriter(" + NL + "                                                            new java.io.FileOutputStream(new java.io.File(scriptPath_";
  protected final String TEXT_665 = "), false)" + NL + "                                                            , \"UTF-8\")" + NL + "                                                    );" + NL + "                  writer_";
  protected final String TEXT_666 = ".write(\"CONNECT TO \");" + NL + "                  writer_";
  protected final String TEXT_667 = ".write(";
  protected final String TEXT_668 = ");" + NL + "                  writer_";
  protected final String TEXT_669 = ".write(\" USER \");" + NL + "                  writer_";
  protected final String TEXT_670 = ".write(";
  protected final String TEXT_671 = ");" + NL + "                  writer_";
  protected final String TEXT_672 = ".write(\" USING \");" + NL + "                  writer_";
  protected final String TEXT_673 = ".write(dbPwd_";
  protected final String TEXT_674 = ");" + NL + "                  writer_";
  protected final String TEXT_675 = ".write(System.getProperty(\"line.separator\"));" + NL + "                  writer_";
  protected final String TEXT_676 = ".write(ingestCmd_";
  protected final String TEXT_677 = ".toString());" + NL + "                  writer_";
  protected final String TEXT_678 = ".close();" + NL + "" + NL + "                    Process process_";
  protected final String TEXT_679 = " = null;" + NL + "                   if(runOnWindows_";
  protected final String TEXT_680 = "){" + NL + "                        process_";
  protected final String TEXT_681 = " = Runtime.getRuntime().exec(\"cmd /c db2cmd /i db2 -f \" + scriptPath_";
  protected final String TEXT_682 = ");" + NL + "                   }else{" + NL + "                        process_";
  protected final String TEXT_683 = " = Runtime.getRuntime().exec(new String[]{" + NL + "                                               \"sh\"" + NL + "                                              ,\"-c\"" + NL + "                                              ,\"db2 -f ./db2_ingest_cmd.db2\"" + NL + "                                              }" + NL + "                                              ,null,new java.io.File(scriptStorageFolder_";
  protected final String TEXT_684 = ")" + NL + "                                              );" + NL + "                   }" + NL + "" + NL + "                   final java.io.InputStream inputStream_";
  protected final String TEXT_685 = " = process_";
  protected final String TEXT_686 = ".getInputStream();" + NL + "                   final java.io.InputStream errStream_";
  protected final String TEXT_687 = " = process_";
  protected final String TEXT_688 = ".getErrorStream();" + NL + "                   Thread normal_";
  protected final String TEXT_689 = " = new Thread() {" + NL + "                       public void run() {" + NL + "                           try {" + NL + "                               java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream_";
  protected final String TEXT_690 = "));" + NL + "                               String line = \"\";" + NL + "                               try {" + NL + "                                   while((line = reader.readLine()) != null) {" + NL + "                                      System.out.println(line);" + NL + "                                   }" + NL + "                               } finally {" + NL + "                                    reader.close();" + NL + "                               }" + NL + "                           }catch(java.io.IOException ioe) {" + NL + "                               ioe.printStackTrace();" + NL + "                           }" + NL + "                       }" + NL + "                   };" + NL + "                   normal_";
  protected final String TEXT_691 = ".start();" + NL + "" + NL + "                   Thread error_";
  protected final String TEXT_692 = " = new Thread() {" + NL + "                       public void run() {" + NL + "                           try {" + NL + "                               java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(errStream_";
  protected final String TEXT_693 = "));" + NL + "                               String line = \"\";" + NL + "                               try {" + NL + "                                   while((line = reader.readLine()) != null) {" + NL + "                                       System.err.println(line);" + NL + "                                   }" + NL + "                               } finally {" + NL + "                                   reader.close();" + NL + "                               }" + NL + "                           } catch(java.io.IOException ioe) {" + NL + "                              ioe.printStackTrace();" + NL + "                           }" + NL + "                       }" + NL + "                   };" + NL + "                   error_";
  protected final String TEXT_694 = ".start();" + NL + "                   process_";
  protected final String TEXT_695 = ".waitFor();" + NL + "                   normal_";
  protected final String TEXT_696 = ".interrupt();" + NL + "                   error_";
  protected final String TEXT_697 = ".interrupt();" + NL + "                   java.nio.file.Files.delete(new java.io.File(scriptPath_";
  protected final String TEXT_698 = ").toPath());";
  protected final String TEXT_699 = NL + NL + "String fileName_";
  protected final String TEXT_700 = " = ";
  protected final String TEXT_701 = ";" + NL;
  protected final String TEXT_702 = NL + "        String sqlLoadPending_";
  protected final String TEXT_703 = " = \"CALL SYSPROC.ADMIN_CMD(?)\";" + NL + "        java.sql.CallableStatement callStmtLoadPending_";
  protected final String TEXT_704 = " = conn_";
  protected final String TEXT_705 = ".prepareCall(sqlLoadPending_";
  protected final String TEXT_706 = ");" + NL + "        callStmtLoadPending_";
  protected final String TEXT_707 = ".setString(1, \"load from  /dev/null  of del terminate into \\\"\" + tableName_";
  protected final String TEXT_708 = " + \"\\\"\");" + NL + "        try {" + NL + "            callStmtLoadPending_";
  protected final String TEXT_709 = ".execute();" + NL + "        } catch (java.sql.SQLException e) {" + NL + "            //when table not in load pending mode will throw exception." + NL + "            //and do nothing.";
  protected final String TEXT_710 = NL + "        }" + NL + "        callStmtLoadPending_";
  protected final String TEXT_711 = ".close();";
  protected final String TEXT_712 = NL;
  protected final String TEXT_713 = NL + "\t\t\tjava.sql.Statement stmtDrop_";
  protected final String TEXT_714 = " = conn_";
  protected final String TEXT_715 = ".createStatement();" + NL + "\t\t\t";
  protected final String TEXT_716 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_717 = " - Droping table ";
  protected final String TEXT_718 = "\" + tableName_";
  protected final String TEXT_719 = " + \"";
  protected final String TEXT_720 = ".\");" + NL + "\t\t\t";
  protected final String TEXT_721 = NL + "\t\t\tstmtDrop_";
  protected final String TEXT_722 = ".execute(\"";
  protected final String TEXT_723 = "\");" + NL + "\t\t\t";
  protected final String TEXT_724 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_725 = " - Drop table ";
  protected final String TEXT_726 = "\" + tableName_";
  protected final String TEXT_727 = " + \"";
  protected final String TEXT_728 = " has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_729 = NL + "\t\t\tstmtDrop_";
  protected final String TEXT_730 = ".close();" + NL + "\t\t\tjava.sql.Statement stmtCreate_";
  protected final String TEXT_731 = " = conn_";
  protected final String TEXT_732 = ".createStatement();" + NL + "\t\t\t";
  protected final String TEXT_733 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_734 = " - Creating table ";
  protected final String TEXT_735 = "\" + tableName_";
  protected final String TEXT_736 = " + \"";
  protected final String TEXT_737 = ".\");" + NL + "\t\t\t";
  protected final String TEXT_738 = NL + "\t\t\tstmtCreate_";
  protected final String TEXT_739 = ".execute(\"";
  protected final String TEXT_740 = ")\");" + NL + "\t\t\t";
  protected final String TEXT_741 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_742 = " - Create table ";
  protected final String TEXT_743 = "\" + tableName_";
  protected final String TEXT_744 = " + \"";
  protected final String TEXT_745 = " has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_746 = NL + "\t\t\tstmtCreate_";
  protected final String TEXT_747 = ".close();" + NL + "\t\t";
  protected final String TEXT_748 = NL + "\t\t\tjava.sql.Statement stmtCreate_";
  protected final String TEXT_749 = " = conn_";
  protected final String TEXT_750 = ".createStatement();" + NL + "\t\t\t";
  protected final String TEXT_751 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_752 = " - Creating table ";
  protected final String TEXT_753 = "\" + tableName_";
  protected final String TEXT_754 = " + \"";
  protected final String TEXT_755 = ".\");" + NL + "\t\t\t";
  protected final String TEXT_756 = NL + "\t\t\tstmtCreate_";
  protected final String TEXT_757 = ".execute(\"";
  protected final String TEXT_758 = ")\");" + NL + "\t\t\t";
  protected final String TEXT_759 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_760 = " - Create table ";
  protected final String TEXT_761 = "\" + tableName_";
  protected final String TEXT_762 = " + \"";
  protected final String TEXT_763 = " has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_764 = NL + "\t\t\tstmtCreate_";
  protected final String TEXT_765 = ".close();" + NL + "\t\t";
  protected final String TEXT_766 = "   " + NL + "\t\t\t\t";
  protected final String TEXT_767 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_768 = " = conn_";
  protected final String TEXT_769 = ".getMetaData();" + NL + "\t\t\t\tif(tableNameForSearch_";
  protected final String TEXT_770 = ".indexOf(\"\\\"\")==-1){" + NL + "\t\t\t\t\ttableNameForSearch_";
  protected final String TEXT_771 = " = tableNameForSearch_";
  protected final String TEXT_772 = ".toUpperCase();" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttableNameForSearch_";
  protected final String TEXT_773 = " = tableNameForSearch_";
  protected final String TEXT_774 = ".replaceAll(\"\\\"\",\"\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tjava.sql.ResultSet rsTable_";
  protected final String TEXT_775 = " = dbMetaData_";
  protected final String TEXT_776 = ".getTables(null, dbschemaForSearch_";
  protected final String TEXT_777 = ", tableNameForSearch_";
  protected final String TEXT_778 = ", new String[]{\"TABLE\"});" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_779 = " = false;" + NL + "\t\t\t\tif(rsTable_";
  protected final String TEXT_780 = ".next()) {" + NL + "\t\t\t\t\twhetherExist_";
  protected final String TEXT_781 = " = true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\trsTable_";
  protected final String TEXT_782 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_783 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_784 = " = conn_";
  protected final String TEXT_785 = ".getMetaData();" + NL + "\t\t\t\tjava.sql.ResultSet rsTable_";
  protected final String TEXT_786 = " = dbMetaData_";
  protected final String TEXT_787 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_788 = " = false;" + NL + "\t\t\t\twhile(rsTable_";
  protected final String TEXT_789 = ".next()) {" + NL + "\t\t\t\t\tString table_";
  protected final String TEXT_790 = " = rsTable_";
  protected final String TEXT_791 = ".getString(\"TABLE_NAME\");" + NL + "\t\t\t\t\tString schema_";
  protected final String TEXT_792 = " = rsTable_";
  protected final String TEXT_793 = ".getString(\"TABLE_SCHEM\");" + NL + "\t\t\t\t\tif(table_";
  protected final String TEXT_794 = ".equalsIgnoreCase(";
  protected final String TEXT_795 = ")" + NL + "\t\t\t\t\t\t&& (schema_";
  protected final String TEXT_796 = ".equalsIgnoreCase(dbschema_";
  protected final String TEXT_797 = ") || dbschema_";
  protected final String TEXT_798 = ".trim().length() ==0)) {" + NL + "\t\t\t\t\t\twhetherExist_";
  protected final String TEXT_799 = " = true;" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\trsTable_";
  protected final String TEXT_800 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_801 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_802 = " = conn_";
  protected final String TEXT_803 = ".getMetaData();" + NL + "\t\t\t\tjava.sql.ResultSet rsTable_";
  protected final String TEXT_804 = " = dbMetaData_";
  protected final String TEXT_805 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_806 = " = false;" + NL + "\t\t\t\twhile(rsTable_";
  protected final String TEXT_807 = ".next()) {" + NL + "\t\t\t\t\tString table_";
  protected final String TEXT_808 = " = rsTable_";
  protected final String TEXT_809 = ".getString(\"TABLE_NAME\");" + NL + "\t\t\t\t\tString bkSchema_";
  protected final String TEXT_810 = " = rsTable_";
  protected final String TEXT_811 = ".getString(\"TABLE_SCHEM\");" + NL + "\t\t\t\t\tif(table_";
  protected final String TEXT_812 = ".equals(";
  protected final String TEXT_813 = ") " + NL + "\t\t\t\t\t\t&& (bkSchema_";
  protected final String TEXT_814 = ".equals(schema_";
  protected final String TEXT_815 = ") || (schema_";
  protected final String TEXT_816 = ".trim().length() ==0 && dbUser_";
  protected final String TEXT_817 = ".equalsIgnoreCase(bkSchema_";
  protected final String TEXT_818 = ")))) {" + NL + "\t\t\t\t\t\twhetherExist_";
  protected final String TEXT_819 = " = true;" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\trsTable_";
  protected final String TEXT_820 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_821 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_822 = " = conn_";
  protected final String TEXT_823 = ".getMetaData();" + NL + "\t\t\t\tjava.sql.ResultSet rsTable_";
  protected final String TEXT_824 = " = dbMetaData_";
  protected final String TEXT_825 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_826 = " = false;" + NL + "\t\t\t\tString defaultSchema_";
  protected final String TEXT_827 = " = \"public\";" + NL + "\t\t\t\tif(dbschema_";
  protected final String TEXT_828 = " == null || dbschema_";
  protected final String TEXT_829 = ".trim().length() == 0) {" + NL + "\t\t\t\t\tjava.sql.Statement stmtSchema_";
  protected final String TEXT_830 = " = conn_";
  protected final String TEXT_831 = ".createStatement();" + NL + "\t\t\t\t\tjava.sql.ResultSet rsSchema_";
  protected final String TEXT_832 = " = stmtSchema_";
  protected final String TEXT_833 = ".executeQuery(\"select current_schema() \");" + NL + "\t\t\t\t\twhile(rsSchema_";
  protected final String TEXT_834 = ".next()){" + NL + "\t\t\t\t\t\tdefaultSchema_";
  protected final String TEXT_835 = " = rsSchema_";
  protected final String TEXT_836 = ".getString(\"current_schema\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\trsSchema_";
  protected final String TEXT_837 = ".close();" + NL + "\t\t\t\t\tstmtSchema_";
  protected final String TEXT_838 = ".close();" + NL + "\t\t\t\t}" + NL + "\t\t\t\twhile(rsTable_";
  protected final String TEXT_839 = ".next()) {" + NL + "\t\t\t\t\tString table_";
  protected final String TEXT_840 = " = rsTable_";
  protected final String TEXT_841 = ".getString(\"TABLE_NAME\");" + NL + "\t\t\t\t\tString schema_";
  protected final String TEXT_842 = " = rsTable_";
  protected final String TEXT_843 = ".getString(\"TABLE_SCHEM\");" + NL + "\t\t\t\t\tif(table_";
  protected final String TEXT_844 = ".equals";
  protected final String TEXT_845 = "IgnoreCase";
  protected final String TEXT_846 = "(";
  protected final String TEXT_847 = ") " + NL + "\t\t\t\t\t\t&& (schema_";
  protected final String TEXT_848 = ".equals";
  protected final String TEXT_849 = "IgnoreCase";
  protected final String TEXT_850 = "(dbschema_";
  protected final String TEXT_851 = ") || ((dbschema_";
  protected final String TEXT_852 = " ==null || dbschema_";
  protected final String TEXT_853 = ".trim().length() ==0) && defaultSchema_";
  protected final String TEXT_854 = ".equals";
  protected final String TEXT_855 = "IgnoreCase";
  protected final String TEXT_856 = "(schema_";
  protected final String TEXT_857 = ")))) {" + NL + "\t\t\t\t\t\twhetherExist_";
  protected final String TEXT_858 = " = true;" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\trsTable_";
  protected final String TEXT_859 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_860 = NL + "            \tString tableForSearch_";
  protected final String TEXT_861 = " = ";
  protected final String TEXT_862 = ";" + NL + "            \tif(tableForSearch_";
  protected final String TEXT_863 = " != null){" + NL + "            \t\tif(tableForSearch_";
  protected final String TEXT_864 = ".startsWith(\"\\\"\") && tableForSearch_";
  protected final String TEXT_865 = ".endsWith(\"\\\"\")){" + NL + "            \t\t\ttableForSearch_";
  protected final String TEXT_866 = " =  tableForSearch_";
  protected final String TEXT_867 = ".substring(1,tableForSearch_";
  protected final String TEXT_868 = ".length()-1);" + NL + "            \t\t}else{" + NL + "            \t\t\ttableForSearch_";
  protected final String TEXT_869 = " =  tableForSearch_";
  protected final String TEXT_870 = ".toUpperCase();" + NL + "            \t\t}" + NL + "            \t}" + NL + "                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_871 = " = conn_";
  protected final String TEXT_872 = ".getMetaData();" + NL + "                java.sql.ResultSet rsTable_";
  protected final String TEXT_873 = " = dbMetaData_";
  protected final String TEXT_874 = ".getTables(null, conn_";
  protected final String TEXT_875 = ".getSchema(), tableForSearch_";
  protected final String TEXT_876 = ", new String[]{\"TABLE\"});" + NL + "                boolean whetherExist_";
  protected final String TEXT_877 = " = false;" + NL + "               \tif(rsTable_";
  protected final String TEXT_878 = ".next()) {" + NL + "\t\t\t\t\twhetherExist_";
  protected final String TEXT_879 = " = true;" + NL + "\t\t\t\t}" + NL + "                rsTable_";
  protected final String TEXT_880 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_881 = NL + "\t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_882 = " = conn_";
  protected final String TEXT_883 = ".getMetaData();" + NL + "\t\t\t\tjava.sql.ResultSet rsTable_";
  protected final String TEXT_884 = " = dbMetaData_";
  protected final String TEXT_885 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "\t\t\t\tboolean whetherExist_";
  protected final String TEXT_886 = " = false;" + NL + "\t\t\t\twhile(rsTable_";
  protected final String TEXT_887 = ".next()) {" + NL + "\t\t\t\t\tString table_";
  protected final String TEXT_888 = " = rsTable_";
  protected final String TEXT_889 = ".getString(\"TABLE_NAME\");" + NL + "\t\t\t\t\tif(table_";
  protected final String TEXT_890 = ".equals";
  protected final String TEXT_891 = "IgnoreCase";
  protected final String TEXT_892 = "(";
  protected final String TEXT_893 = ")) {" + NL + "\t\t\t\t\t\twhetherExist_";
  protected final String TEXT_894 = " = true;" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\trsTable_";
  protected final String TEXT_895 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_896 = NL + "\t\t\t\tif(!whetherExist_";
  protected final String TEXT_897 = ") {" + NL + "\t\t\t\t\tjava.sql.Statement stmtCreate_";
  protected final String TEXT_898 = " = conn_";
  protected final String TEXT_899 = ".createStatement();" + NL + "\t\t\t\t\t";
  protected final String TEXT_900 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_901 = " - Creating table ";
  protected final String TEXT_902 = "\" + tableName_";
  protected final String TEXT_903 = " + \"";
  protected final String TEXT_904 = ".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_905 = NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_906 = ".execute(\"";
  protected final String TEXT_907 = ")\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_908 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_909 = " - Create table ";
  protected final String TEXT_910 = "\" + tableName_";
  protected final String TEXT_911 = " + \"";
  protected final String TEXT_912 = " has succeeded.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_913 = NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_914 = ".close();" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_915 = NL + "\t\t\t\tif(whetherExist_";
  protected final String TEXT_916 = ") {" + NL + "\t\t\t\t\tjava.sql.Statement stmtDrop_";
  protected final String TEXT_917 = " = conn_";
  protected final String TEXT_918 = ".createStatement();" + NL + "\t\t\t\t\t";
  protected final String TEXT_919 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_920 = " - Droping table ";
  protected final String TEXT_921 = "\" + tableName_";
  protected final String TEXT_922 = " + \"";
  protected final String TEXT_923 = ".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_924 = NL + "\t\t\t\t\tstmtDrop_";
  protected final String TEXT_925 = ".execute(\"";
  protected final String TEXT_926 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_927 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_928 = " - Drop table ";
  protected final String TEXT_929 = "\" + tableName_";
  protected final String TEXT_930 = " + \"";
  protected final String TEXT_931 = " has succeeded.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_932 = NL + "\t\t\t\t\tstmtDrop_";
  protected final String TEXT_933 = ".close();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tjava.sql.Statement stmtCreate_";
  protected final String TEXT_934 = " = conn_";
  protected final String TEXT_935 = ".createStatement();" + NL + "\t\t\t\t";
  protected final String TEXT_936 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_937 = " - Creating table ";
  protected final String TEXT_938 = "\" + tableName_";
  protected final String TEXT_939 = " + \"";
  protected final String TEXT_940 = ".\" );" + NL + "\t\t\t\t";
  protected final String TEXT_941 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_942 = ".execute(\"";
  protected final String TEXT_943 = ")\");" + NL + "\t\t\t\t";
  protected final String TEXT_944 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_945 = " - Create table ";
  protected final String TEXT_946 = "\" + tableName_";
  protected final String TEXT_947 = " + \"";
  protected final String TEXT_948 = " has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_949 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_950 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_951 = NL + "\t\t\tjava.sql.Statement stmtClear_";
  protected final String TEXT_952 = " = conn_";
  protected final String TEXT_953 = ".createStatement();" + NL + "\t\t\t";
  protected final String TEXT_954 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_955 = " - Clearing table ";
  protected final String TEXT_956 = "\" + tableName_";
  protected final String TEXT_957 = " + \"";
  protected final String TEXT_958 = ".\");" + NL + "\t\t\t";
  protected final String TEXT_959 = NL + "\t\t\tstmtClear_";
  protected final String TEXT_960 = ".executeUpdate(\"";
  protected final String TEXT_961 = "\");" + NL + "\t\t\t";
  protected final String TEXT_962 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_963 = "- Clear table ";
  protected final String TEXT_964 = "\" + tableName_";
  protected final String TEXT_965 = " + \"";
  protected final String TEXT_966 = " has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_967 = NL + "\t\t\tstmtClear_";
  protected final String TEXT_968 = ".close();" + NL + "\t\t";
  protected final String TEXT_969 = NL + "\t\t\tjava.sql.Statement stmtTruncCount_";
  protected final String TEXT_970 = " = conn_";
  protected final String TEXT_971 = ".createStatement();" + NL + "\t\t\tjava.sql.ResultSet rsTruncCount_";
  protected final String TEXT_972 = " = stmtTruncCount_";
  protected final String TEXT_973 = ".executeQuery(\"";
  protected final String TEXT_974 = "\");" + NL + "\t\t\tjava.sql.Statement stmtTrunc_";
  protected final String TEXT_975 = " = conn_";
  protected final String TEXT_976 = ".createStatement();" + NL + "\t\t\t";
  protected final String TEXT_977 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_978 = " - Trancating table ";
  protected final String TEXT_979 = "\" + tableName_";
  protected final String TEXT_980 = " + \"";
  protected final String TEXT_981 = ".\");" + NL + "\t\t\t";
  protected final String TEXT_982 = NL + "\t\t\tstmtTrunc_";
  protected final String TEXT_983 = ".executeUpdate(\"";
  protected final String TEXT_984 = "\");" + NL + "   \t    \t";
  protected final String TEXT_985 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_986 = " - Truncate table ";
  protected final String TEXT_987 = "\" + tableName_";
  protected final String TEXT_988 = " + \"";
  protected final String TEXT_989 = " has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_990 = NL + "\t\t\twhile(rsTruncCount_";
  protected final String TEXT_991 = ".next()) {" + NL + "\t\t\t\tdeletedCount_";
  protected final String TEXT_992 = " += rsTruncCount_";
  protected final String TEXT_993 = ".getInt(1);" + NL + "\t\t\t}" + NL + "\t\t\trsTruncCount_";
  protected final String TEXT_994 = ".close();" + NL + "\t\t\tstmtTruncCount_";
  protected final String TEXT_995 = ".close();" + NL + "\t\t\tstmtTrunc_";
  protected final String TEXT_996 = ".close();" + NL + "\t\t";
  protected final String TEXT_997 = NL + "\t\t//in mysql when autoCommit=true don't commit." + NL + "\t\tif (! conn_";
  protected final String TEXT_998 = ".getAutoCommit()) {" + NL + "\t\t\tconn_";
  protected final String TEXT_999 = ".commit();" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_1000 = NL;
  protected final String TEXT_1001 = NL + "Character field_separator_";
  protected final String TEXT_1002 = " = (";
  protected final String TEXT_1003 = ").charAt(0);";
  protected final String TEXT_1004 = NL + "        String action_";
  protected final String TEXT_1005 = " = \"";
  protected final String TEXT_1006 = "\";" + NL + "        java.sql.CallableStatement callStmt_";
  protected final String TEXT_1007 = " = null;" + NL + "        String sql_";
  protected final String TEXT_1008 = " = \"CALL SYSPROC.ADMIN_CMD(?)\";" + NL + "        String param_";
  protected final String TEXT_1009 = " = \"LOAD FROM \\\"\"+ fileName_";
  protected final String TEXT_1010 = " + \"\\\" OF DEL ";
  protected final String TEXT_1011 = " MODIFIED BY COLDEL\"+ field_separator_";
  protected final String TEXT_1012 = " +" + NL + "                        \" dateformat=\\\"\"+ ";
  protected final String TEXT_1013 = "+ \"\\\" timeformat=\\\"\" + ";
  protected final String TEXT_1014 = "+ \"\\\" timestampformat=\\\"\"+";
  protected final String TEXT_1015 = " +\"\\\" ";
  protected final String TEXT_1016 = " \" +" + NL + "                         action_";
  protected final String TEXT_1017 = " +\" INTO \\\"\"  + tableName_";
  protected final String TEXT_1018 = " + \"\\\" ";
  protected final String TEXT_1019 = "\";";
  protected final String TEXT_1020 = NL + "                log.debug(\"";
  protected final String TEXT_1021 = " - Bulk SQL:CALL SYSPROC.ADMIN_CMD(\"+param_";
  protected final String TEXT_1022 = "+\").\");";
  protected final String TEXT_1023 = NL + "                log.info(\"";
  protected final String TEXT_1024 = " - Bulk inserting data into ";
  protected final String TEXT_1025 = "\" + tableName_";
  protected final String TEXT_1026 = " + \"";
  protected final String TEXT_1027 = ".\" );";
  protected final String TEXT_1028 = NL + "                log.info(\"";
  protected final String TEXT_1029 = " - Bulk replacing data into ";
  protected final String TEXT_1030 = "\" + tableName_";
  protected final String TEXT_1031 = " + \"";
  protected final String TEXT_1032 = ".\" );";
  protected final String TEXT_1033 = NL + "        callStmt_";
  protected final String TEXT_1034 = " = conn_";
  protected final String TEXT_1035 = ".prepareCall(sql_";
  protected final String TEXT_1036 = ");" + NL + "        callStmt_";
  protected final String TEXT_1037 = ".setString(1, param_";
  protected final String TEXT_1038 = ");" + NL + "        callStmt_";
  protected final String TEXT_1039 = ".execute();" + NL + "        callStmt_";
  protected final String TEXT_1040 = ".close();";
  protected final String TEXT_1041 = NL + "                log.info(\"";
  protected final String TEXT_1042 = " - Bulk insert data into ";
  protected final String TEXT_1043 = "\" + tableName_";
  protected final String TEXT_1044 = " + \"";
  protected final String TEXT_1045 = " has finished.\");";
  protected final String TEXT_1046 = NL + "                log.info(\"";
  protected final String TEXT_1047 = " - Bulk replace data into ";
  protected final String TEXT_1048 = "\" + tableName_";
  protected final String TEXT_1049 = " + \"";
  protected final String TEXT_1050 = " has finished.\");";
  protected final String TEXT_1051 = NL + "            int keyCount_";
  protected final String TEXT_1052 = " = ";
  protected final String TEXT_1053 = ";" + NL + "            if(keyCount_";
  protected final String TEXT_1054 = " == 0) {" + NL + "                throw new RuntimeException(\"For bulk update, Schema must have a key at least.\");" + NL + "            }" + NL + "            String tmpTableName_";
  protected final String TEXT_1055 = " = tableName_";
  protected final String TEXT_1056 = ";" + NL + "            tableName_";
  protected final String TEXT_1057 = " = \"tmp_";
  protected final String TEXT_1058 = "\" + \"_\" + pid + Thread.currentThread().getId();" + NL + "            java.sql.Statement stmtCreateTmp_";
  protected final String TEXT_1059 = " = conn_";
  protected final String TEXT_1060 = ".createStatement();" + NL + NL;
  protected final String TEXT_1061 = NL + "                log.info(\"";
  protected final String TEXT_1062 = " - Creating temp table ";
  protected final String TEXT_1063 = "\" + tableName_";
  protected final String TEXT_1064 = " + \"";
  protected final String TEXT_1065 = ".\" );";
  protected final String TEXT_1066 = NL + "            stmtCreateTmp_";
  protected final String TEXT_1067 = ".execute(\"";
  protected final String TEXT_1068 = ")\");" + NL + "            stmtCreateTmp_";
  protected final String TEXT_1069 = ".close();";
  protected final String TEXT_1070 = NL + "                log.info(\"";
  protected final String TEXT_1071 = " - Create temp table ";
  protected final String TEXT_1072 = "\" + tableName_";
  protected final String TEXT_1073 = " + \"";
  protected final String TEXT_1074 = " has succeeded.\");";
  protected final String TEXT_1075 = NL + "            java.sql.CallableStatement callStmt_";
  protected final String TEXT_1076 = " = null;" + NL + "            String sql_";
  protected final String TEXT_1077 = " = \"CALL SYSPROC.ADMIN_CMD(?)\";" + NL + "            String param_";
  protected final String TEXT_1078 = " = \"LOAD FROM \\\"\"+ fileName_";
  protected final String TEXT_1079 = ".replace(\"\\\\\",\"/\") + \"\\\" OF DEL ";
  protected final String TEXT_1080 = " MODIFIED BY COLDEL\" + field_separator_";
  protected final String TEXT_1081 = " +" + NL + "                                    \" dateformat=\\\"\"+";
  protected final String TEXT_1082 = "+\"\\\" timeformat=\\\"\" +";
  protected final String TEXT_1083 = "+ \"\\\" timestampformat=\\\"\" + ";
  protected final String TEXT_1084 = "+\"\\\"\" +" + NL + "                                    \" ";
  protected final String TEXT_1085 = " INSERT INTO \\\"\"  + tableName_";
  protected final String TEXT_1086 = " + \"\\\" ";
  protected final String TEXT_1087 = "\";";
  protected final String TEXT_1088 = NL + "                log.debug(\"";
  protected final String TEXT_1089 = " - Bulk SQL:CALL SYSPROC.ADMIN_CMD(\"+param_";
  protected final String TEXT_1090 = "+\").\");" + NL + "                log.info(\"";
  protected final String TEXT_1091 = " - Bulk inserting data into ";
  protected final String TEXT_1092 = "\" + tableName_";
  protected final String TEXT_1093 = " + \"";
  protected final String TEXT_1094 = ".\" );";
  protected final String TEXT_1095 = NL + "            callStmt_";
  protected final String TEXT_1096 = " = conn_";
  protected final String TEXT_1097 = ".prepareCall(sql_";
  protected final String TEXT_1098 = ");" + NL + "            callStmt_";
  protected final String TEXT_1099 = ".setString(1, param_";
  protected final String TEXT_1100 = ");" + NL + "            callStmt_";
  protected final String TEXT_1101 = ".execute();" + NL + "            callStmt_";
  protected final String TEXT_1102 = ".close();";
  protected final String TEXT_1103 = NL + "                log.info(\"";
  protected final String TEXT_1104 = " - Bulk insert data into ";
  protected final String TEXT_1105 = "\" + tableName_";
  protected final String TEXT_1106 = " + \"";
  protected final String TEXT_1107 = " has finished.\");";
  protected final String TEXT_1108 = NL + "            tableName_";
  protected final String TEXT_1109 = " = tmpTableName_";
  protected final String TEXT_1110 = ";" + NL + "            tmpTableName_";
  protected final String TEXT_1111 = " = \"tmp_";
  protected final String TEXT_1112 = "\"+ \"_\" + pid + Thread.currentThread().getId();" + NL + "            java.sql.Statement stmtUpdateBulk_";
  protected final String TEXT_1113 = " = conn_";
  protected final String TEXT_1114 = ".createStatement();";
  protected final String TEXT_1115 = NL + "                log.info(\"";
  protected final String TEXT_1116 = " - Updating ";
  protected final String TEXT_1117 = "\" + tableName_";
  protected final String TEXT_1118 = " + \"";
  protected final String TEXT_1119 = " from ";
  protected final String TEXT_1120 = "\"+tmpTableName_";
  protected final String TEXT_1121 = "+\"";
  protected final String TEXT_1122 = ".\");";
  protected final String TEXT_1123 = NL + "            stmtUpdateBulk_";
  protected final String TEXT_1124 = ".executeUpdate(\"";
  protected final String TEXT_1125 = "\");";
  protected final String TEXT_1126 = NL + "            stmtUpdateBulk_";
  protected final String TEXT_1127 = ".close();" + NL + "            tableName_";
  protected final String TEXT_1128 = " = \"tmp_";
  protected final String TEXT_1129 = "\" + \"_\" + pid + Thread.currentThread().getId();" + NL + "            java.sql.Statement stmtTmpDrop_";
  protected final String TEXT_1130 = " = conn_";
  protected final String TEXT_1131 = ".createStatement();";
  protected final String TEXT_1132 = NL + "                log.info(\"";
  protected final String TEXT_1133 = " - Droping temp table ";
  protected final String TEXT_1134 = "\" + tableName_";
  protected final String TEXT_1135 = " + \"";
  protected final String TEXT_1136 = ".\");";
  protected final String TEXT_1137 = NL + "            stmtTmpDrop_";
  protected final String TEXT_1138 = ".execute(\"";
  protected final String TEXT_1139 = "\");";
  protected final String TEXT_1140 = NL + "                log.info(\"";
  protected final String TEXT_1141 = " - Drop temp table ";
  protected final String TEXT_1142 = "\" + tableName_";
  protected final String TEXT_1143 = "+ \"";
  protected final String TEXT_1144 = " has succeeded.\");";
  protected final String TEXT_1145 = NL + "            stmtTmpDrop_";
  protected final String TEXT_1146 = ".close();";
  protected final String TEXT_1147 = NL;

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
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    if (cid.startsWith("tImpala") || cid.startsWith("tHive")) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_35);
    } else {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
			connect_end();
		}

		public void connect_begin(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"debug",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"debug",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_54);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_55);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_58);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_59);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_61);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_70);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String db = ElementParameterParser.getValue(node, "__DBNAME__");
String dbschema = ElementParameterParser.getValue(node, "__TABLESCHEMA__");
String user = ElementParameterParser.getValue(node, "__USER__");

String table = ElementParameterParser.getValue(node, "__TABLE__");
String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");
String dbmsId = ElementParameterParser.getValue(node,"__MAPPING__");

boolean useIngestCommand = "true".equals(ElementParameterParser.getValue(node,"__USE_INGEST_COMMAND__"));

List<IMetadataColumn> columnList = getColumnList(node);
List<Column> stmtStructure = null;
Manager manager = null;

    stringBuffer.append(TEXT_71);
    
    if(useExistingConnection) {
        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
        String conn = "conn_" + connection;
        String schema = "tableschema_" + connection;
        String username = "username_" + connection;
        
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(schema );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_78);
    
        log4jCodeGenerateUtil.useExistConnection(node);
    } else {
        String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
        if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_83);
    
        } else {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_89);
    
        }

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_94);
    
        String passwordFieldName = "__PASS__";
        
    stringBuffer.append(TEXT_95);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_98);
    } else {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
        log4jCodeGenerateUtil.connect(node);
    }

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_116);
    
        if(useIngestCommand){
           
    stringBuffer.append(TEXT_117);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_123);
    
class IMetadataColumnEnhance{
    private IMetadataColumn iMetadataColumn;
    private boolean isTableColumn;
    private String startPosition;
    private String endPosition;
    private String expression = null;
    public IMetadataColumnEnhance(IMetadataColumn iMetadataColumn, boolean isTableColumn, String startPosition, String endPosition, String expression){
        this.iMetadataColumn = iMetadataColumn;
        this.isTableColumn = isTableColumn;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.expression = expression;
    }
    public String getExpression(){
        return this.expression;
    }

    public IMetadataColumn getIMetadataColumn(){
        return this.iMetadataColumn;
    }

    public boolean isTableColumn(){
        return this.isTableColumn;
    }

    public String getStartPosition(){
        return this.startPosition;
    }

    public String getEndPosition(){
        return this.endPosition;
    }
}

Map<String,String> ingestDataTypeMapping = new HashMap<String, String>();
ingestDataTypeMapping.put("BIGINT", "BIGINT");
ingestDataTypeMapping.put("BLOB", "UNSUPPORTED");
ingestDataTypeMapping.put("CHAR", "CHAR");
ingestDataTypeMapping.put("CHARACTER", "CHARACTER");
ingestDataTypeMapping.put("CLOB", "UNSUPPORTED");
ingestDataTypeMapping.put("DATE", "DATE");
ingestDataTypeMapping.put("DECIMAL", "DECIMAL");
ingestDataTypeMapping.put("DOUBLE", "DOUBLE");
ingestDataTypeMapping.put("FLOAT", "FLOAT");
ingestDataTypeMapping.put("GRAPHIC", "UNSUPPORTED");
ingestDataTypeMapping.put("INTEGER", "INTEGER");
ingestDataTypeMapping.put("LONG VARCHAR", "CHARACTER");
ingestDataTypeMapping.put("NUMERIC", "DECIMAL");
ingestDataTypeMapping.put("SMALLINT", "SMALLINT");
ingestDataTypeMapping.put("TIME", "TIME");
ingestDataTypeMapping.put("TIMESTAMP", "TIMESTAMP");
ingestDataTypeMapping.put("VARCHAR", "CHARACTER");
ingestDataTypeMapping.put("VARGRAPHIC", "UNSUPPORTED");
ingestDataTypeMapping.put("XML", "UNSUPPORTED");
if(columnList != null && columnList.size()>0){
    stmtStructure = getManager(dbmsId, cid).createColumnList(columnList, false, null, null);
    
      
//issue 0010346 Parallelization crash with "Drop table if exists and create"
Boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
boolean isLog4jEnabled_tableAction = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if (!isParallelize) {
//end issue 0010346 Parallelization crash with "Drop table if exists and create"
	manager = getManager(dbmsId, cid);   
	manager.setNode(node);
	if(!("NONE").equals(tableAction)) {

		if(("DROP_CREATE").equals(tableAction)) {
		
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_134);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_148);
    }
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_151);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_156);
    }
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
		} else if(("CREATE").equals(tableAction)) {
		
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_166);
    }
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_169);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_174);
    }
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
		} else if(("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction)) {
			boolean tableNameCaseSensitive=false;
			if(DB2.equalsIgnoreCase(dbmsId)||GREENPLUM.equalsIgnoreCase(dbmsId)||PARACCEL.equalsIgnoreCase(dbmsId)
				||POSTGRESQL.equalsIgnoreCase(dbmsId)||POSTGREPLUS.equalsIgnoreCase(dbmsId)){
				tableNameCaseSensitive=true;
			}
		
			if (ORACLE.equalsIgnoreCase(dbmsId)) {
			
    stringBuffer.append(TEXT_177);
    stringBuffer.append(manager.generateCode4TabelExist());
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
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
    			
			} else if(SYBASE.equalsIgnoreCase(dbmsId)){
			
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
    stringBuffer.append(table);
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
    				
			} else if( DB2.equalsIgnoreCase(dbmsId) ){
			
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(table);
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
    
			} else if ( GREENPLUM.equalsIgnoreCase(dbmsId) || POSTGRESQL.equalsIgnoreCase(dbmsId) ||  POSTGREPLUS.equalsIgnoreCase(dbmsId) || VERTICA.equalsIgnoreCase(dbmsId)) {
			
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_256);
    }
    stringBuffer.append(TEXT_257);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_260);
    }
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_266);
    }
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    
            } else if(EXASOL.equalsIgnoreCase(dbmsId)) {
            
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    			
			} else{
			
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
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_302);
    }
    stringBuffer.append(TEXT_303);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    
			}
			if(("CREATE_IF_NOT_EXISTS").equals(tableAction)) {
			
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_315);
    }
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_318);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_323);
    }
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    
			} else {
			
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_334);
    }
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_337);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_342);
    }
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_351);
    }
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_354);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_359);
    }
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    
			}

		} else if(("CLEAR").equals(tableAction)) {
		
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_369);
    }
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(manager.getDeleteTableSQL());
    stringBuffer.append(TEXT_372);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_377);
    }
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    
		}else if(("TRUNCATE").equals(tableAction)) {
		
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_392);
    }
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(manager.getTruncateTableSQL());
    stringBuffer.append(TEXT_395);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_400);
    }
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    
		}  
		
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    
	}
//issue 0010346 Parallelization crash with "Drop table if exists and create"
}
//end issue 0010346 Parallelization crash with "Drop table if exists and create"

    
}
List<IMetadataTable> metadataList = node.getMetadataList();
String operationType = ElementParameterParser.getValue(node, "__DATA_ACTION_TYPE__");
boolean generateValStatement = true;
boolean generateFieldDefinition = true;
String loadFrom = ElementParameterParser.getValue(node, "__LOAD_FROM__");
if("folder".equals(loadFrom)){

    stringBuffer.append(TEXT_411);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_412);
    
}
boolean addExternal4Numeric = "false".equals(ElementParameterParser.getValue(node, "__NUMERIC_REPRESENT_IN_BINARY__"));
String pipeName = ElementParameterParser.getValue(node, "__PIPE_NAME__");
String targetLoadFile = ElementParameterParser.getValue(node, "__DATA__");
String targetFolder = ElementParameterParser.getValue(node, "__TARGET_FOLDER__");
String filePattern = ElementParameterParser.getValue(node, "__FILE_INCLUDE_FILTER__");
       if(filePattern == null || "".equals(filePattern)){
            filePattern = null;
       }
boolean willRecurse = "true".equals(ElementParameterParser.getValue(node, "__RECURSE_DIRECTORY__"));
String optionallyEnclosedBy = ElementParameterParser.getValue(node, "__OPTIONALLY_ENCLOSED_BY__");
boolean applyOptionallyEnclosedBy = false;
String contentFormat = ElementParameterParser.getValue(node, "__CONTENT_FORMAT__");
String fieldDelimitedBy = ElementParameterParser.getValue(node, "__FIELD_DELIMITED_BY__");
String recordLgth = ElementParameterParser.getValue(node, "__RECORDLEN__");
String codePage = ElementParameterParser.getValue(node, "__INPUT_CODE_PAGE__");
String loadTable = ElementParameterParser.getValue(node, "__TABLE__");
boolean customInsertValuesClause = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_INSERT_VALUES_CLAUSE__"));
String insertValsClause = ElementParameterParser.getValue(node, "__INSERT_VALUES_CLAUSE__");
boolean customSetMapping = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_SET_MAPPING__"));
    if(useExistingConnection){
        String reusedConn = ElementParameterParser.getValue(node,"__CONNECTION__");
        INode nodeY = NodeUtil.getNodeByUniqueName(node.getProcess(), reusedConn);
        dbschema = ElementParameterParser.getValue(nodeY,"__TABLESCHEMA__");
        db = ElementParameterParser.getValue(nodeY,"__DBNAME__");
        user = ElementParameterParser.getValue(nodeY,"__USER__");
        String passwordFieldName = "__PASS__";
        
    if(ElementParameterParser.canEncrypt(nodeY, passwordFieldName)){
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(nodeY, passwordFieldName));
    stringBuffer.append(TEXT_415);
    }else{
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append( ElementParameterParser.getValue(nodeY, passwordFieldName));
    stringBuffer.append(TEXT_418);
    }
    stringBuffer.append(TEXT_419);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    
    }

    stringBuffer.append(TEXT_422);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append( loadTable );
    stringBuffer.append(TEXT_424);
    stringBuffer.append( dbschema );
    stringBuffer.append(TEXT_425);
    stringBuffer.append( dbschema );
    stringBuffer.append(TEXT_426);
    stringBuffer.append( dbschema );
    stringBuffer.append(TEXT_427);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_428);
    stringBuffer.append( dbschema );
    stringBuffer.append(TEXT_429);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_430);
    
//Error handling options
boolean useErrHandlingOptions = "true".equals(ElementParameterParser.getValue(node, "__ERROR_HANDLING_OPTIONS__"));
String errFileType = ElementParameterParser.getValue(node, "__ERR_FILE_TYPE__");
String errFileName = ElementParameterParser.getValue(node, "__ERR_FILE_NAME__");
String errFileTypeCmd = null;
String messagesFileName = ElementParameterParser.getValue(node, "__MSG_FILE_NAME__");
boolean willRestartJob = "true".equals(ElementParameterParser.getValue(node, "__WILL_RESTART_JOB__"));
String restartJobType = ElementParameterParser.getValue(node, "__RESTART_JOB_TYPE__");
boolean restartJobOFF = "OFF".equals(restartJobType);
String restartJobId = ElementParameterParser.getValue(node, "__JOB_ID__");
String exceptionTable = ElementParameterParser.getValue(node, "__EXCEPTION_TABLE__");
String warningCount = ElementParameterParser.getValue(node, "__WARNINGCOUNT__");
String scriptStorageFolder = ElementParameterParser.getValue(node, "__SCRIPT_STORAGE_FOLDER__");

    stringBuffer.append(TEXT_431);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append( scriptStorageFolder );
    stringBuffer.append(TEXT_433);
    
List<Map<String, String>> columnsDetail = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__EXISTS_IN_TABLE_COLUMN__");
List<Map<String, String>> setMapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SET_MAPPING__");
List<IMetadataColumnEnhance> iMetadataColumnEnhanceList = new ArrayList<IMetadataColumnEnhance>();
if((metadataList != null) && (metadataList.size() > 0)){
    IMetadataTable metadata = metadataList.get(0);
    if(metadata != null){
       List<IMetadataColumn> columnListA = metadata.getListColumns();
       int idx = 0;
       for(IMetadataColumn imetadataColumn: columnListA){
          iMetadataColumnEnhanceList.add(
                   new IMetadataColumnEnhance(
                        imetadataColumn
                      , "true".equals(columnsDetail.get(idx).get("CORRESPOND_TO_THE_TABLE_COLUMN"))
                      , columnsDetail.get(idx).get("START")
                      , columnsDetail.get(idx).get("END")
                      , setMapping.get(idx).get("EXPRESSION")
                                              )
                      );
          idx ++;
       }
    }
}
String whereClause = ElementParameterParser.getValue(node, "__WHERE_CLAUSE__");
String mergeClause = ElementParameterParser.getValue(node, "__MERGE_CLAUSE__");

    stringBuffer.append(TEXT_434);
    
    if ((metadataList != null) && (metadataList.size() > 0)){//-> Tag1
        IMetadataTable metadata = metadataList.get(0);
        if(metadata != null){//-> Tag2
            List<IMetadataColumn> tableColumnList = metadata.getListColumns();
            if(tableColumnList.size() <= 0){
                generateValStatement = false;
                generateFieldDefinition = false;
            }
               
    stringBuffer.append(TEXT_435);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_437);
     /* It is best to write the delimiter at the beginning of the field. */ 
    stringBuffer.append(TEXT_438);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_439);
    stringBuffer.append( "folder".equals(loadFrom) ? "file" : loadFrom );
    stringBuffer.append(TEXT_440);
    
                  if("file".equals(loadFrom)){
                  
    stringBuffer.append(TEXT_441);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_442);
    stringBuffer.append( targetLoadFile );
    stringBuffer.append(TEXT_443);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_444);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_446);
    
                  }else if("pipe".equals(loadFrom)){
                  
    stringBuffer.append(TEXT_447);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_448);
    stringBuffer.append( pipeName );
    stringBuffer.append(TEXT_449);
    
                  }else if("folder".equals(loadFrom)){
                  
    stringBuffer.append(TEXT_450);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_452);
    stringBuffer.append( targetFolder );
    stringBuffer.append(TEXT_453);
    stringBuffer.append( filePattern );
    stringBuffer.append(TEXT_454);
    stringBuffer.append( willRecurse );
    stringBuffer.append(TEXT_455);
    
                  }else{
                  
    stringBuffer.append(TEXT_456);
    stringBuffer.append( loadFrom );
    
                  }
                  
    stringBuffer.append(TEXT_457);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_458);
    
                  if("delimited".equals(contentFormat)){
                  
    stringBuffer.append(TEXT_459);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_460);
    
                     if(fieldDelimitedBy != null && !"".equals(fieldDelimitedBy) && !"\"\"".equals(fieldDelimitedBy)){
                     
    stringBuffer.append(TEXT_461);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_462);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_463);
    stringBuffer.append( fieldDelimitedBy );
    stringBuffer.append(TEXT_464);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_465);
    
                     }
                      
    
                  }else if("positional".equals(contentFormat)){
                  
    stringBuffer.append(TEXT_466);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_467);
    
                     if(recordLgth != null && !"".equals(recordLgth) && !"\"\"".equals(recordLgth)){
                     
    stringBuffer.append(TEXT_468);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_470);
    stringBuffer.append( recordLgth );
    stringBuffer.append(TEXT_471);
    
                     }
                      
    
                  }else{
                  
    stringBuffer.append(TEXT_472);
    stringBuffer.append( contentFormat );
    
                  }
                  if(codePage != null && !"".equals(codePage) && !"\"\"".equals(codePage)){
                  
    stringBuffer.append(TEXT_473);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_474);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_475);
    stringBuffer.append( codePage );
    stringBuffer.append(TEXT_476);
    
                  }
                  
    stringBuffer.append(TEXT_477);
     /* field definition */ 
    
                 if(generateFieldDefinition){
                 
    stringBuffer.append(TEXT_478);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_479);
    
    if(optionallyEnclosedBy != null && !"".equals(optionallyEnclosedBy) && !"\"\"".equals(optionallyEnclosedBy)){
       applyOptionallyEnclosedBy = true;
    }
    int index_y = 0;
    for(IMetadataColumnEnhance imetadataColumnEnhance: iMetadataColumnEnhanceList){
        IMetadataColumn imetadataColumn = imetadataColumnEnhance.getIMetadataColumn();
        String columnLabel = imetadataColumn.getLabel();
        String startPosition = imetadataColumnEnhance.getStartPosition();
        String endPosition = imetadataColumnEnhance.getEndPosition();
        String dbType = imetadataColumn.getType();
        String ingestDataType = ingestDataTypeMapping.get(dbType);
        String dbColumnName = imetadataColumn.getOriginalDbColumnName();
        Integer lgth = imetadataColumn.getLength();
        Integer precision = imetadataColumn.getPrecision();
        String datePattern = imetadataColumn.getPattern();
        boolean useDatePattern = true;
        if(datePattern == null || "".equals(datePattern) || "\"\"".equals(datePattern)){
                useDatePattern = false;
        }
        if(precision == null){
            precision = 0;
        }
       if(index_y != 0){
          
    stringBuffer.append(TEXT_480);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_481);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_482);
    
       }
       
    stringBuffer.append(TEXT_483);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append( dbColumnName );
    stringBuffer.append(TEXT_485);
    
            if(startPosition != null && !"".equals(startPosition) && endPosition != null && !"".equals(endPosition)){
            
    stringBuffer.append(TEXT_486);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_488);
    stringBuffer.append( startPosition );
    stringBuffer.append(TEXT_489);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_491);
    stringBuffer.append( endPosition );
    stringBuffer.append(TEXT_492);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_493);
    
            }
            
    
            if(ingestDataType != null && !"UNSUPPORTED".equals(ingestDataType)){
            
    stringBuffer.append(TEXT_494);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append( ingestDataType );
    stringBuffer.append(TEXT_496);
    
            }else{
            
    stringBuffer.append(TEXT_497);
    stringBuffer.append( dbType );
    stringBuffer.append(TEXT_498);
    
            }
             
    
         if("CHARACTER".equalsIgnoreCase(ingestDataType) || "CHAR".equalsIgnoreCase(ingestDataType)){
         if(lgth == null){
         
    stringBuffer.append(TEXT_499);
    stringBuffer.append( columnLabel );
    stringBuffer.append(TEXT_500);
    
         }
         
    stringBuffer.append(TEXT_501);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_502);
    stringBuffer.append( lgth );
    stringBuffer.append(TEXT_503);
    
         if(applyOptionallyEnclosedBy){
         
    stringBuffer.append(TEXT_504);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_505);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append( optionallyEnclosedBy );
    stringBuffer.append(TEXT_507);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_508);
    
         }
         }else if("DECIMAL".equalsIgnoreCase(ingestDataType) || "DEC".equalsIgnoreCase(ingestDataType)){
         
    stringBuffer.append(TEXT_509);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append( lgth );
    stringBuffer.append(TEXT_511);
    stringBuffer.append( precision );
    stringBuffer.append(TEXT_512);
    
            if(addExternal4Numeric){
            
    stringBuffer.append(TEXT_513);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_514);
    
            }
             
    
         }else if("DATE".equalsIgnoreCase(ingestDataType) || "TIME".equalsIgnoreCase(ingestDataType) || "TIMESTAMP".equalsIgnoreCase(ingestDataType)){
         if(useDatePattern){
         
    stringBuffer.append(TEXT_515);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_516);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append( datePattern );
    stringBuffer.append(TEXT_518);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_519);
    
         if(applyOptionallyEnclosedBy){
         
    stringBuffer.append(TEXT_520);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_522);
    stringBuffer.append( optionallyEnclosedBy );
    stringBuffer.append(TEXT_523);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_524);
    
                                      }
         }else{
         }
         }else{//For Numeric Types
         if(addExternal4Numeric){
         
    stringBuffer.append(TEXT_525);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_526);
    
         }
         }
       index_y ++;
    }

    stringBuffer.append(TEXT_527);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_529);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_530);
    
                 }
                 
    stringBuffer.append(TEXT_531);
     /* options  begin */ 
    
                  if(useErrHandlingOptions){
                    if("dumpfile".equals(errFileType)){
                         errFileTypeCmd = "dumpfile ";
                    }else if("badfile".equals(errFileType)){
                         errFileTypeCmd = "badfile ";
                    }else{
                    
    stringBuffer.append(TEXT_532);
    stringBuffer.append( errFileType );
    
                    }
                  
    stringBuffer.append(TEXT_533);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_534);
    stringBuffer.append( errFileTypeCmd );
    stringBuffer.append(TEXT_535);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_536);
    stringBuffer.append( errFileName );
    stringBuffer.append(TEXT_537);
    
                    }
                     
    
                    if(exceptionTable != null && !"".equals(exceptionTable) && !"\"\"".equals(exceptionTable)){
                    
    stringBuffer.append(TEXT_538);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_539);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_540);
    stringBuffer.append( exceptionTable );
    stringBuffer.append(TEXT_541);
    
                    }
                    
    
                    if(warningCount != null && !"".equals(warningCount) && !"\"\"".equals(warningCount)){
                    
    stringBuffer.append(TEXT_542);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_543);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_544);
    stringBuffer.append( warningCount );
    stringBuffer.append(TEXT_545);
    
                    }
                    if(messagesFileName != null && !"".equals(messagesFileName) && !"\"\"".equals(messagesFileName)){
                    
    stringBuffer.append(TEXT_546);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_547);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_548);
    stringBuffer.append( messagesFileName );
    stringBuffer.append(TEXT_549);
    
                    }
                     
    
                  if(willRestartJob){
                  
    stringBuffer.append(TEXT_550);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_551);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_552);
    stringBuffer.append( restartJobType );
    stringBuffer.append(TEXT_553);
    
                  if(!restartJobOFF){
                  if("NEW".equals(restartJobType)){
                  if(restartJobId != null && !"".equals(restartJobId) && !"\"\"".equals(restartJobId)){
                  
    stringBuffer.append(TEXT_554);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_555);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_556);
    stringBuffer.append( restartJobId );
    stringBuffer.append(TEXT_557);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_558);
    
                  }
                  }else{
                     if(restartJobId != null && !"".equals(restartJobId) && !"\"\"".equals(restartJobId)){
                  
    stringBuffer.append(TEXT_559);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_560);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_561);
    stringBuffer.append( restartJobId );
    stringBuffer.append(TEXT_562);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_563);
    
                     }else{
                     
    stringBuffer.append(TEXT_564);
    
                     }
                  }
                }
             }
                  
     /* options  end */ 
    stringBuffer.append(TEXT_565);
     /* SQL statement  begin */ 
    
                  if(generateValStatement){
                  
    stringBuffer.append(TEXT_566);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_567);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_568);
    
                     int index = 0;
                     for(IMetadataColumnEnhance imetadataColumnEnhance: iMetadataColumnEnhanceList){
                        IMetadataColumn imetadataColumnY = imetadataColumnEnhance.getIMetadataColumn();
                        boolean isTableColumn = imetadataColumnEnhance.isTableColumn();
                        if(isTableColumn){
                        if(index != 0){
                           
    stringBuffer.append(TEXT_569);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_570);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_571);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_572);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_573);
    
                        }
                        
    stringBuffer.append(TEXT_574);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_575);
    stringBuffer.append( imetadataColumnY.getLabel());
    stringBuffer.append(TEXT_576);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_577);
    stringBuffer.append( imetadataColumnY.getLabel());
    stringBuffer.append(TEXT_578);
    
                        index ++;
                        }
                     }
                     
    stringBuffer.append(TEXT_579);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_580);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_581);
    
                  }
                
    stringBuffer.append(TEXT_582);
    
                if("INSERT".equals(operationType) || "REPLACE".equals(operationType)){
                
    stringBuffer.append(TEXT_583);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_584);
    stringBuffer.append( operationType );
    stringBuffer.append(TEXT_585);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_586);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_587);
    
                   if(customInsertValuesClause){
                   if(generateValStatement){
                   
    stringBuffer.append(TEXT_588);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_589);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_590);
    
                   }
                    
    stringBuffer.append(TEXT_591);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_592);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_593);
    stringBuffer.append( insertValsClause );
    stringBuffer.append(TEXT_594);
    
                   }else{
                   if(generateValStatement){
                   
    stringBuffer.append(TEXT_595);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_596);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_597);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_598);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_599);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_600);
    
                        }
                   }
                    
    
                }else if("UPDATE".equals(operationType)){
                
    stringBuffer.append(TEXT_601);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_602);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_603);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_604);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_605);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_606);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_607);
    
                   if(customSetMapping){
                      int flag = 0;
                      for(IMetadataColumnEnhance imetadataColumnEnhanceMore: iMetadataColumnEnhanceList){
                         IMetadataColumn iMetadataColumnMore = imetadataColumnEnhanceMore.getIMetadataColumn();
                         String tblColumnName = iMetadataColumnMore.getOriginalDbColumnName();
                         boolean isTableColumn = imetadataColumnEnhanceMore.isTableColumn();
                         String expr = imetadataColumnEnhanceMore.getExpression();
                         if(expr == null || "".equals(expr)){
                            expr = "$" + tblColumnName;
                         }
                         
    
                         if(isTableColumn){
                         if(flag != 0){
                         
    stringBuffer.append(TEXT_608);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_609);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_610);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_611);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_612);
    
                         }
                         
    stringBuffer.append(TEXT_613);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_614);
    stringBuffer.append( tblColumnName );
    stringBuffer.append(TEXT_615);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_616);
    stringBuffer.append( expr );
    stringBuffer.append(TEXT_617);
    
                         flag ++;
                        }
                      }
                   }else{
                   
    
                      int counter = 0;
                      for(IMetadataColumnEnhance imetadataColumnEnhanceY: iMetadataColumnEnhanceList){
                         IMetadataColumn imetadataColumnV = imetadataColumnEnhanceY.getIMetadataColumn();
                         String columnName = imetadataColumnV.getLabel();
                         boolean isTableColumn = imetadataColumnEnhanceY.isTableColumn();
                         if(isTableColumn){
                         if(counter != 0){
                         
    stringBuffer.append(TEXT_618);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_619);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_620);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_621);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_622);
    
                         }
                         
    stringBuffer.append(TEXT_623);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_624);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_625);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_626);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_627);
    
                         counter ++ ;
                        }
                      }
                   }
                    
    stringBuffer.append(TEXT_628);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_629);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_630);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_631);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_632);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_633);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_634);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_635);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_636);
    stringBuffer.append( whereClause );
    stringBuffer.append(TEXT_637);
    
                }else if("DELETE".equals(operationType)){
                
    stringBuffer.append(TEXT_638);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_639);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_640);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_641);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_642);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_643);
    stringBuffer.append( whereClause );
    stringBuffer.append(TEXT_644);
    
                }else if("MERGE".equals(operationType)){
                
    stringBuffer.append(TEXT_645);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_646);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_647);
    stringBuffer.append( mergeClause );
    stringBuffer.append(TEXT_648);
    
                }
                
    stringBuffer.append(TEXT_649);
     /* Try to execute the ingest cmd */ 
    stringBuffer.append(TEXT_650);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_651);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_652);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_653);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_654);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_655);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_656);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_657);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_658);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_659);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_660);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_661);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_662);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_663);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_664);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_665);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_666);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_667);
    stringBuffer.append( db );
    stringBuffer.append(TEXT_668);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_669);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_670);
    stringBuffer.append( user );
    stringBuffer.append(TEXT_671);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_672);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_673);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_674);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_675);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_676);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_677);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_679);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_681);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_683);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_684);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_686);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_689);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_692);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_697);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_698);
    
        }//-> Tag2
    }//-> Tag1

    
        }else{
            
    
String action = ElementParameterParser.getValue(node, "__DATA_ACTION__");
String field_separator = ElementParameterParser.getValue(node, "__FIELDS_TERMINATED_BY__");
String file = ElementParameterParser.getValue(node, "__DATA__");

String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");

String dateformat = ElementParameterParser.getValue(node, "__DATE_FORMAT__");
String timeformat = ElementParameterParser.getValue(node, "__TIME_FORMAT__");
String timestampformat = ElementParameterParser.getValue(node, "__TIMESTAMP_FORMAT__");

boolean removeLoadPending = ("true").equals(ElementParameterParser.getValue(node,"__REMOVE_LODA_PENDING__"));

    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_701);
    
if(columnList != null && columnList.size() > 0) {
    stmtStructure = getManager(dbmsId, cid).createColumnList(columnList, false, null, null);
}
if((columnList != null && columnList.size() > 0) || "CLEAR".equals(tableAction) || "NONE".equals(tableAction)){

    //----------------------remove Load Pending
    if (removeLoadPending) {

    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_709);
    log4jCodeGenerateUtil.logError(node,"warn");
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    
    }

    stringBuffer.append(TEXT_712);
      
//issue 0010346 Parallelization crash with "Drop table if exists and create"
Boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
boolean isLog4jEnabled_tableAction = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if (!isParallelize) {
//end issue 0010346 Parallelization crash with "Drop table if exists and create"
	manager = getManager(dbmsId, cid);   
	manager.setNode(node);
	if(!("NONE").equals(tableAction)) {

		if(("DROP_CREATE").equals(tableAction)) {
		
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_715);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_717);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_720);
    }
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_723);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_725);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_727);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_728);
    }
    stringBuffer.append(TEXT_729);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_732);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_733);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_734);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_735);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_737);
    }
    stringBuffer.append(TEXT_738);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_739);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_740);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_741);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_742);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_743);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_744);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_745);
    }
    stringBuffer.append(TEXT_746);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_747);
    
		} else if(("CREATE").equals(tableAction)) {
		
    stringBuffer.append(TEXT_748);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_749);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_750);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_751);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_752);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_754);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_755);
    }
    stringBuffer.append(TEXT_756);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_757);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_758);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_759);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_760);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_761);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_762);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_763);
    }
    stringBuffer.append(TEXT_764);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_765);
    
		} else if(("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction)) {
			boolean tableNameCaseSensitive=false;
			if(DB2.equalsIgnoreCase(dbmsId)||GREENPLUM.equalsIgnoreCase(dbmsId)||PARACCEL.equalsIgnoreCase(dbmsId)
				||POSTGRESQL.equalsIgnoreCase(dbmsId)||POSTGREPLUS.equalsIgnoreCase(dbmsId)){
				tableNameCaseSensitive=true;
			}
		
			if (ORACLE.equalsIgnoreCase(dbmsId)) {
			
    stringBuffer.append(TEXT_766);
    stringBuffer.append(manager.generateCode4TabelExist());
    stringBuffer.append(TEXT_767);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_768);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_775);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_776);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_777);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_778);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_779);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_780);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_781);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_782);
    			
			} else if(SYBASE.equalsIgnoreCase(dbmsId)){
			
    stringBuffer.append(TEXT_783);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_784);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_786);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_787);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_788);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_789);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_790);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_791);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_792);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_793);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_794);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_795);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_796);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_797);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_798);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_799);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_800);
    				
			} else if( DB2.equalsIgnoreCase(dbmsId) ){
			
    stringBuffer.append(TEXT_801);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_803);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_804);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_805);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_806);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_807);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_808);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_809);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_810);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_811);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_812);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_813);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_814);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_815);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_816);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_817);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_818);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_819);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_820);
    
			} else if ( GREENPLUM.equalsIgnoreCase(dbmsId) || POSTGRESQL.equalsIgnoreCase(dbmsId) ||  POSTGREPLUS.equalsIgnoreCase(dbmsId) || VERTICA.equalsIgnoreCase(dbmsId)) {
			
    stringBuffer.append(TEXT_821);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_822);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_823);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_824);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_825);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_826);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_827);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_829);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_830);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_831);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_832);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_839);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_840);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_841);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_842);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_843);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_844);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_845);
    }
    stringBuffer.append(TEXT_846);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_847);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_848);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_849);
    }
    stringBuffer.append(TEXT_850);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_851);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_852);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_853);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_854);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_855);
    }
    stringBuffer.append(TEXT_856);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_857);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_858);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_859);
    
            } else if(EXASOL.equalsIgnoreCase(dbmsId)) {
            
    stringBuffer.append(TEXT_860);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_861);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_862);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_863);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_864);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_865);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_866);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_867);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_868);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_869);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_870);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_871);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_872);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_873);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_874);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_875);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_876);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_877);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_878);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_879);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_880);
    			
			} else{
			
    stringBuffer.append(TEXT_881);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_888);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_889);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_890);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_891);
    }
    stringBuffer.append(TEXT_892);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_893);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_894);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_895);
    
			}
			if(("CREATE_IF_NOT_EXISTS").equals(tableAction)) {
			
    stringBuffer.append(TEXT_896);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_897);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_898);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_899);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_900);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_901);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_902);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_903);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_904);
    }
    stringBuffer.append(TEXT_905);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_906);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_907);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_908);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_909);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_910);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_911);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_912);
    }
    stringBuffer.append(TEXT_913);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_914);
    
			} else {
			
    stringBuffer.append(TEXT_915);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_916);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_917);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_918);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_919);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_920);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_921);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_922);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_923);
    }
    stringBuffer.append(TEXT_924);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_925);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_926);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_927);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_928);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_929);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_930);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_931);
    }
    stringBuffer.append(TEXT_932);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_933);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_934);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_935);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_936);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_937);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_938);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_939);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_940);
    }
    stringBuffer.append(TEXT_941);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_942);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_943);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_944);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_945);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_946);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_947);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_948);
    }
    stringBuffer.append(TEXT_949);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_950);
    
			}

		} else if(("CLEAR").equals(tableAction)) {
		
    stringBuffer.append(TEXT_951);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_952);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_953);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_954);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_955);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_956);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_957);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_958);
    }
    stringBuffer.append(TEXT_959);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_960);
    stringBuffer.append(manager.getDeleteTableSQL());
    stringBuffer.append(TEXT_961);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_962);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_963);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_964);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_965);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_966);
    }
    stringBuffer.append(TEXT_967);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_968);
    
		}else if(("TRUNCATE").equals(tableAction)) {
		
    stringBuffer.append(TEXT_969);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_970);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_971);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_972);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_973);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_974);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_975);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_976);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_977);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_978);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_979);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_980);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_981);
    }
    stringBuffer.append(TEXT_982);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_983);
    stringBuffer.append(manager.getTruncateTableSQL());
    stringBuffer.append(TEXT_984);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_985);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_986);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_987);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_988);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_989);
    }
    stringBuffer.append(TEXT_990);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_991);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_992);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_993);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_994);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_995);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_996);
    
		}  
		
    stringBuffer.append(TEXT_997);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_998);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_999);
    
	}
//issue 0010346 Parallelization crash with "Drop table if exists and create"
}
//end issue 0010346 Parallelization crash with "Drop table if exists and create"

    stringBuffer.append(TEXT_1000);
    
    //feature0011004 load command options begin
    List<Map<String, String>> options = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPTIONS__");
    java.util.Map<String, String> parametersMap = new java.util.HashMap<String, String>();

    //  LOAD FROM OF DEL (position1) MODIFIED BY (position2) INTO (position3)
    java.lang.StringBuilder position1 = new java.lang.StringBuilder();
    java.lang.StringBuilder position2 = new java.lang.StringBuilder();
    java.lang.StringBuilder position3 = new java.lang.StringBuilder();

    for(java.util.Map<String, String> option : options) {
        String key = option.get("KEY");
        String value = option.get("VALUE");

        String[] keySplit = key.split(",");
        if (keySplit.length > 1) {
            if ("1".equals(keySplit[1])) {
                position1.append(keySplit[0]).append(" ").append(value).append(" ");
            } else if ("2".equals(keySplit[1])) {
                if ("MODIFIED BY".equals(keySplit[0])) {
                    position2.append(" ").append(value).append(" ");
                } else {
                    position2.append(keySplit[0]).append(" ").append(value).append(" ");
                }
            } else if ("3".equals(keySplit[1])) {
                position3.append(keySplit[0]).append(" ").append(value).append(" ");
            }
        }
    }
    //end feature0011004 load command options begin

    stringBuffer.append(TEXT_1001);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(field_separator);
    stringBuffer.append(TEXT_1003);
    
    ////////////////////////////////////////////
    //DB2 Load Syntax: https://www-304.ibm.com/support/knowledgecenter/SSEPGG_9.7.0/com.ibm.db2.luw.admin.cmd.doc/doc/r0008305.html?cp=SSEPGG_9.7.0%2F3-6-2-4-78
    if(("INSERT").equals(action) || ("REPLACE").equals(action)) {
        
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(action);
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(position1.toString());
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(dateformat);
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(timeformat);
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(timestampformat);
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(position2.toString());
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(position3.toString());
    stringBuffer.append(TEXT_1019);
    
        if(isLog4jEnabled_tableAction){
            
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1022);
    
            if(("INSERT").equals(action)){
            
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_1027);
    
            }else if(("REPLACE").equals(action)){
            
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_1032);
    
            }
        }
        
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1040);
    
        if(isLog4jEnabled_tableAction){
            if(("INSERT").equals(action)){
                
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_1045);
    
            }else if(("REPLACE").equals(action)){
                
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_1050);
    
            }
        }
    } else if(("UPDATE").equals(action)) {
        if(columnList != null && columnList.size() > 0) {
            int keyCount = 0;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    keyCount++;
                }
            }
            
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1060);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_1065);
    }
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1069);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_1074);
    }
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(position1.toString());
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(dateformat);
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(timeformat);
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(timestampformat);
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(position2.toString());
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(position3.toString());
    stringBuffer.append(TEXT_1087);
    
            if(isLog4jEnabled_tableAction){
            
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_1094);
    
            }
            
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1102);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_1107);
    }
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1114);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_1122);
    }
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(manager.getUpdateBulkSQL(columnList));
    stringBuffer.append(TEXT_1125);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Update has finished.");
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1131);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_1136);
    }
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_1139);
    if(isLog4jEnabled_tableAction){
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_1144);
    }
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1146);
    
        }
    }
}

    
        }

    stringBuffer.append(TEXT_1147);
    return stringBuffer.toString();
  }
}
