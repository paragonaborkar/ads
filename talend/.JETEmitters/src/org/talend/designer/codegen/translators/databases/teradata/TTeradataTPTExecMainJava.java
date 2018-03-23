package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Arrays;

public class TTeradataTPTExecMainJava
{
  protected static String nl;
  public static synchronized TTeradataTPTExecMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataTPTExecMainJava result = new TTeradataTPTExecMainJava();
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
  protected final String TEXT_29 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_30 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_31 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_33 = " - Uses an existing connection ";
  protected final String TEXT_34 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_36 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_37 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_38 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\tconn_";
  protected final String TEXT_41 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_42 = ", dbUser_";
  protected final String TEXT_43 = ", dbPwd_";
  protected final String TEXT_44 = ");" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\tconn_";
  protected final String TEXT_46 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\tconn_";
  protected final String TEXT_48 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\tconn_";
  protected final String TEXT_50 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\tconn_";
  protected final String TEXT_52 = ".setAutoCommit(";
  protected final String TEXT_53 = ");" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\tlog.";
  protected final String TEXT_55 = "(\"";
  protected final String TEXT_56 = " - \" + ";
  protected final String TEXT_57 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t    \t\tlog.";
  protected final String TEXT_59 = "(\"";
  protected final String TEXT_60 = "\");" + NL + "\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_62 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_64 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_65 = ": pstmt_";
  protected final String TEXT_66 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_67 = " += (countEach_";
  protected final String TEXT_68 = " < 0 ? 0 : ";
  protected final String TEXT_69 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_70 = NL + "String tableFullName_";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = " + \".\" + ";
  protected final String TEXT_73 = ";" + NL + "java.io.File file_";
  protected final String TEXT_74 = " = new java.io.File(";
  protected final String TEXT_75 = "+";
  protected final String TEXT_76 = "+ ";
  protected final String TEXT_77 = "\".script\"";
  protected final String TEXT_78 = "\".scr\"";
  protected final String TEXT_79 = ");" + NL;
  protected final String TEXT_80 = NL + "\t   String logTable_";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = " + \".\" +";
  protected final String TEXT_83 = ";";
  protected final String TEXT_84 = NL + "try{" + NL + "\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t    ";
  protected final String TEXT_87 = NL + NL + "\t\t\t\tjava.io.FileWriter fw_";
  protected final String TEXT_88 = " = new java.io.FileWriter(file_";
  protected final String TEXT_89 = ");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_90 = ".write(\"DEFINE JOB \"+";
  protected final String TEXT_91 = "+\"";
  protected final String TEXT_92 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_93 = ".write(\"  (\"+\"";
  protected final String TEXT_94 = "\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\tfw_";
  protected final String TEXT_96 = ".write(\"  \tDEFINE OPERATOR \"+";
  protected final String TEXT_97 = "+\"";
  protected final String TEXT_98 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_99 = ".write(\"  \tTYPE LOAD";
  protected final String TEXT_100 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_101 = ".write(\"  \tSCHEMA *";
  protected final String TEXT_102 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_103 = ".write(\"  \tATTRIBUTES";
  protected final String TEXT_104 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_105 = ".write(\"  \t(";
  protected final String TEXT_106 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_107 = ".write(\"  \t\tVARCHAR UserName, ";
  protected final String TEXT_108 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_109 = ".write(\"  \t\tVARCHAR UserPassword, ";
  protected final String TEXT_110 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_111 = ".write(\"  \t\tVARCHAR LogTable, ";
  protected final String TEXT_112 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_113 = ".write(\"  \t\tVARCHAR TargetTable, ";
  protected final String TEXT_114 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_115 = ".write(\"  \t\tINTEGER BufferSize, ";
  protected final String TEXT_116 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_117 = ".write(\"  \t\tVARCHAR DataEncryption, ";
  protected final String TEXT_118 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_119 = ".write(\"  \t\tINTEGER ErrorLimit, ";
  protected final String TEXT_120 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_121 = ".write(\"  \t\tINTEGER MaxSessions, ";
  protected final String TEXT_122 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_123 = ".write(\"  \t\tINTEGER MinSessions, ";
  protected final String TEXT_124 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_125 = ".write(\"  \t\tINTEGER TenacityHours, ";
  protected final String TEXT_126 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_127 = ".write(\"  \t\tINTEGER TenacitySleep, ";
  protected final String TEXT_128 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_129 = ".write(\"  \t\tVARCHAR AccountId, ";
  protected final String TEXT_130 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_131 = ".write(\"  \t\tVARCHAR DateForm, ";
  protected final String TEXT_132 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_133 = ".write(\"  \t\tVARCHAR ErrorTable1, ";
  protected final String TEXT_134 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_135 = ".write(\"  \t\tVARCHAR ErrorTable2, ";
  protected final String TEXT_136 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_137 = ".write(\"  \t\tVARCHAR LogSQL, ";
  protected final String TEXT_138 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_139 = ".write(\"  \t\tVARCHAR LogonMech, ";
  protected final String TEXT_140 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_141 = ".write(\"  \t\tVARCHAR LogonMechData, ";
  protected final String TEXT_142 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_143 = ".write(\"  \t\tVARCHAR NotifyExit, ";
  protected final String TEXT_144 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_145 = ".write(\"  \t\tVARCHAR NotifyExitIsDLL, ";
  protected final String TEXT_146 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_147 = ".write(\"  \t\tVARCHAR NotifyLevel, ";
  protected final String TEXT_148 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_149 = ".write(\"  \t\tVARCHAR NotifyMethod, ";
  protected final String TEXT_150 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_151 = ".write(\"  \t\tVARCHAR NotifyString, ";
  protected final String TEXT_152 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_153 = ".write(\"  \t\tVARCHAR PauseAcq, ";
  protected final String TEXT_154 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_155 = ".write(\"  \t\tVARCHAR PrivateLogName,";
  protected final String TEXT_156 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_157 = ".write(\"  \t\tVARCHAR QueryBandSessInfo,";
  protected final String TEXT_158 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_159 = ".write(\"  \t\tVARCHAR TdpId, ";
  protected final String TEXT_160 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_161 = ".write(\"  \t\tVARCHAR ARRAY TraceLevel, ";
  protected final String TEXT_162 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_163 = ".write(\"  \t\tVARCHAR WildcardInsert, ";
  protected final String TEXT_164 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_165 = ".write(\"  \t\tVARCHAR WorkingDatabase";
  protected final String TEXT_166 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_167 = ".write(\"  \t);";
  protected final String TEXT_168 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_169 = ".write(\"  ";
  protected final String TEXT_170 = "\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_171 = NL + "\t\t\t\tfw_";
  protected final String TEXT_172 = ".write(\"  \tDEFINE OPERATOR \"+";
  protected final String TEXT_173 = "+\"";
  protected final String TEXT_174 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_175 = ".write(\"  \tTYPE INSERTER";
  protected final String TEXT_176 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_177 = ".write(\"  \tSCHEMA *";
  protected final String TEXT_178 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_179 = ".write(\"  \tATTRIBUTES";
  protected final String TEXT_180 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_181 = ".write(\"  \t(";
  protected final String TEXT_182 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_183 = ".write(\"  \t\tVARCHAR UserName, ";
  protected final String TEXT_184 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_185 = ".write(\"  \t\tVARCHAR UserPassword, ";
  protected final String TEXT_186 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_187 = ".write(\"  \t\tVARCHAR Tdpid, ";
  protected final String TEXT_188 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_189 = ".write(\"  \t\tVARCHAR DateForm, ";
  protected final String TEXT_190 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_191 = ".write(\"  \t\tVARCHAR PrivateLogName, ";
  protected final String TEXT_192 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_193 = ".write(\"  \t\tVARCHAR AccountId, ";
  protected final String TEXT_194 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_195 = ".write(\"  \t\tVARCHAR DataEncryption, ";
  protected final String TEXT_196 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_197 = ".write(\"  \t\tVARCHAR LogSQL, ";
  protected final String TEXT_198 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_199 = ".write(\"  \t\tVARCHAR LogonMech, ";
  protected final String TEXT_200 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_201 = ".write(\"  \t\tVARCHAR LogonMechData, ";
  protected final String TEXT_202 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_203 = ".write(\"  \t\tVARCHAR QueryBandSessInfo, ";
  protected final String TEXT_204 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_205 = ".write(\"  \t\tVARCHAR ReplicationOverride, ";
  protected final String TEXT_206 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_207 = ".write(\"  \t\tVARCHAR ARRAY TraceLevel, ";
  protected final String TEXT_208 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_209 = ".write(\"  \t\tVARCHAR WorkingDatabase ";
  protected final String TEXT_210 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_211 = ".write(\"  \t);";
  protected final String TEXT_212 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_213 = ".write(\"  ";
  protected final String TEXT_214 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_215 = NL + NL + "\t\t\t\tfw_";
  protected final String TEXT_216 = ".write(\"  \tDEFINE OPERATOR \"+";
  protected final String TEXT_217 = "+\"";
  protected final String TEXT_218 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_219 = ".write(\"  \tTYPE UPDATE";
  protected final String TEXT_220 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_221 = ".write(\"  \tSCHEMA *";
  protected final String TEXT_222 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_223 = ".write(\"  \tATTRIBUTES";
  protected final String TEXT_224 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_225 = ".write(\"  \t(";
  protected final String TEXT_226 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_227 = ".write(\"  \t\tVARCHAR UserName, ";
  protected final String TEXT_228 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_229 = ".write(\"  \t\tVARCHAR UserPassword, ";
  protected final String TEXT_230 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_231 = ".write(\"  \t\tVARCHAR Tdpid, ";
  protected final String TEXT_232 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_233 = ".write(\"  \t\tVARCHAR PrivateLogName, ";
  protected final String TEXT_234 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_235 = ".write(\"  \t\tVARCHAR LogTable, ";
  protected final String TEXT_236 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_237 = ".write(\"  \t\tVARCHAR ARRAY TraceLevel, ";
  protected final String TEXT_238 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_239 = ".write(\"  \t\tINTEGER BufferSize, ";
  protected final String TEXT_240 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_241 = ".write(\"  \t\tINTEGER ErrorLimit, ";
  protected final String TEXT_242 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_243 = ".write(\"  \t\tINTEGER MaxSessions, ";
  protected final String TEXT_244 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_245 = ".write(\"  \t\tINTEGER MinSessions, ";
  protected final String TEXT_246 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_247 = ".write(\"  \t\tINTEGER TenacityHours, ";
  protected final String TEXT_248 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_249 = ".write(\"  \t\tINTEGER TenacitySleep, ";
  protected final String TEXT_250 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_251 = ".write(\"  \t\tVARCHAR AccountId, ";
  protected final String TEXT_252 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_253 = ".write(\"  \t\tVARCHAR AmpCheck, ";
  protected final String TEXT_254 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_255 = ".write(\"  \t\tVARCHAR DataEncryption, ";
  protected final String TEXT_256 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_257 = ".write(\"  \t\tVARCHAR DateForm, ";
  protected final String TEXT_258 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_259 = ".write(\"  \t\tVARCHAR DeleteTask, ";
  protected final String TEXT_260 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_261 = ".write(\"  \t\tVARCHAR DropErrorTable, ";
  protected final String TEXT_262 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_263 = ".write(\"  \t\tVARCHAR DropLogTable, ";
  protected final String TEXT_264 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_265 = ".write(\"  \t\tVARCHAR DropWorkTable, ";
  protected final String TEXT_266 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_267 = ".write(\"  \t\tVARCHAR LogSQL, ";
  protected final String TEXT_268 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_269 = ".write(\"  \t\tVARCHAR LogonMech, ";
  protected final String TEXT_270 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_271 = ".write(\"  \t\tVARCHAR LogonMechData, ";
  protected final String TEXT_272 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_273 = ".write(\"  \t\tVARCHAR NotifyExit, ";
  protected final String TEXT_274 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_275 = ".write(\"  \t\tVARCHAR NotifyExitIsDLL, ";
  protected final String TEXT_276 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_277 = ".write(\"  \t\tVARCHAR NotifyLevel, ";
  protected final String TEXT_278 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_279 = ".write(\"  \t\tVARCHAR NotifyMethod, ";
  protected final String TEXT_280 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_281 = ".write(\"  \t\tVARCHAR NotifyString, ";
  protected final String TEXT_282 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_283 = ".write(\"  \t\tVARCHAR PauseAcq, ";
  protected final String TEXT_284 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_285 = ".write(\"  \t\tVARCHAR QueryBandSessInfo, ";
  protected final String TEXT_286 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_287 = ".write(\"  \t\tVARCHAR QueueErrorTable, ";
  protected final String TEXT_288 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_289 = ".write(\"  \t\tVARCHAR WorkTable, ";
  protected final String TEXT_290 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_291 = ".write(\"  \t\tVARCHAR WorkingDatabase, ";
  protected final String TEXT_292 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_293 = ".write(\"  \t\tVARCHAR TargetTable, ";
  protected final String TEXT_294 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_295 = ".write(\"  \t\tVARCHAR ErrorTable1, ";
  protected final String TEXT_296 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_297 = ".write(\"  \t\tVARCHAR ErrorTable2 ";
  protected final String TEXT_298 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_299 = ".write(\"  \t);";
  protected final String TEXT_300 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_301 = ".write(\"  ";
  protected final String TEXT_302 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_303 = NL + NL + "\t\t\t\tfw_";
  protected final String TEXT_304 = ".write(\"  \tDEFINE OPERATOR \"+";
  protected final String TEXT_305 = "+\"";
  protected final String TEXT_306 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_307 = ".write(\"  \tTYPE STREAM";
  protected final String TEXT_308 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_309 = ".write(\"  \tSCHEMA *";
  protected final String TEXT_310 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_311 = ".write(\"  \tATTRIBUTES";
  protected final String TEXT_312 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_313 = ".write(\"  \t(";
  protected final String TEXT_314 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_315 = ".write(\"  \t\tVARCHAR UserName, ";
  protected final String TEXT_316 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_317 = ".write(\"  \t\tVARCHAR UserPassword, ";
  protected final String TEXT_318 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_319 = ".write(\"  \t\tVARCHAR TdpId, ";
  protected final String TEXT_320 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_321 = ".write(\"  \t\tVARCHAR PrivateLogName, ";
  protected final String TEXT_322 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_323 = ".write(\"  \t\tVARCHAR LogTable, ";
  protected final String TEXT_324 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_325 = ".write(\"  \t\tVARCHAR ErrorTable, ";
  protected final String TEXT_326 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_327 = ".write(\"  \t\tVARCHAR AppendErrorTable, ";
  protected final String TEXT_328 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_329 = ".write(\"  \t\tINTEGER Buffers, ";
  protected final String TEXT_330 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_331 = ".write(\"  \t\tINTEGER ErrorLimit, ";
  protected final String TEXT_332 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_333 = ".write(\"  \t\tINTEGER MaxSessions, ";
  protected final String TEXT_334 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_335 = ".write(\"  \t\tINTEGER MinSessions, ";
  protected final String TEXT_336 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_337 = ".write(\"  \t\tINTEGER Pack, ";
  protected final String TEXT_338 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_339 = ".write(\"  \t\tINTEGER Rate, ";
  protected final String TEXT_340 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_341 = ".write(\"  \t\tINTEGER Periodicity, ";
  protected final String TEXT_342 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_343 = ".write(\"  \t\tINTEGER TenacityHours, ";
  protected final String TEXT_344 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_345 = ".write(\"  \t\tINTEGER TenacitySleep, ";
  protected final String TEXT_346 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_347 = ".write(\"  \t\tVARCHAR AccountId, ";
  protected final String TEXT_348 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_349 = ".write(\"  \t\tVARCHAR ArraySupport, ";
  protected final String TEXT_350 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_351 = ".write(\"  \t\tVARCHAR DataEncryption, ";
  protected final String TEXT_352 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_353 = ".write(\"  \t\tVARCHAR DateForm, ";
  protected final String TEXT_354 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_355 = ".write(\"  \t\tVARCHAR DropMacro, ";
  protected final String TEXT_356 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_357 = ".write(\"  \t\tVARCHAR LogonMech, ";
  protected final String TEXT_358 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_359 = ".write(\"  \t\tVARCHAR LogonMechData, ";
  protected final String TEXT_360 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_361 = ".write(\"  \t\tVARCHAR MacroDatabase, ";
  protected final String TEXT_362 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_363 = ".write(\"  \t\tVARCHAR OperatorCommandID, ";
  protected final String TEXT_364 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_365 = ".write(\"  \t\tVARCHAR NotifyExit, ";
  protected final String TEXT_366 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_367 = ".write(\"  \t\tVARCHAR NotifyExitIsDLL, ";
  protected final String TEXT_368 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_369 = ".write(\"  \t\tVARCHAR NotifyLevel, ";
  protected final String TEXT_370 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_371 = ".write(\"  \t\tVARCHAR NotifyMethod, ";
  protected final String TEXT_372 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_373 = ".write(\"  \t\tVARCHAR LogSQL, ";
  protected final String TEXT_374 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_375 = ".write(\"  \t\tVARCHAR NotifyString, ";
  protected final String TEXT_376 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_377 = ".write(\"  \t\tVARCHAR PackMaximum, ";
  protected final String TEXT_378 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_379 = ".write(\"  \t\tVARCHAR QueryBandSessInfo, ";
  protected final String TEXT_380 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_381 = ".write(\"  \t\tVARCHAR QueueErrorTable, ";
  protected final String TEXT_382 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_383 = ".write(\"  \t\tVARCHAR ReplicationOverrride, ";
  protected final String TEXT_384 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_385 = ".write(\"  \t\tVARCHAR Robust, ";
  protected final String TEXT_386 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_387 = ".write(\"  \t\tVARCHAR WorkingDatabase, ";
  protected final String TEXT_388 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_389 = ".write(\"  \t\tVARCHAR ARRAY TraceLevel, ";
  protected final String TEXT_390 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_391 = ".write(\"  \t\tVARCHAR DropErrorTable";
  protected final String TEXT_392 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_393 = ".write(\"  \t);";
  protected final String TEXT_394 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_395 = ".write(\"  ";
  protected final String TEXT_396 = "\");" + NL + "\t\t\t    ";
  protected final String TEXT_397 = NL + NL + "\t\t\t\tfw_";
  protected final String TEXT_398 = ".write(\"  \tDEFINE SCHEMA \"+";
  protected final String TEXT_399 = "+\"";
  protected final String TEXT_400 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_401 = ".write(\"  \t(";
  protected final String TEXT_402 = "\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_403 = NL + "\t\t\t\t\t\tfw_";
  protected final String TEXT_404 = ".write(\"               ";
  protected final String TEXT_405 = "\"+\" VARCHAR(";
  protected final String TEXT_406 = "),";
  protected final String TEXT_407 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_408 = NL + "\t\t\t\t\t\tfw_";
  protected final String TEXT_409 = ".write(\"               ";
  protected final String TEXT_410 = "\"+\" VARCHAR(";
  protected final String TEXT_411 = ")";
  protected final String TEXT_412 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_413 = NL + NL + "\t\t\t\tfw_";
  protected final String TEXT_414 = ".write(\"  \t);";
  protected final String TEXT_415 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_416 = ".write(\"  ";
  protected final String TEXT_417 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_418 = ".write(\"  \tDEFINE OPERATOR \"+";
  protected final String TEXT_419 = "+\"";
  protected final String TEXT_420 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_421 = ".write(\"  \tTYPE DATACONNECTOR PRODUCER";
  protected final String TEXT_422 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_423 = ".write(\"  \tSCHEMA \"+";
  protected final String TEXT_424 = "+\"";
  protected final String TEXT_425 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_426 = ".write(\"  \tATTRIBUTES";
  protected final String TEXT_427 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_428 = ".write(\"  \t(";
  protected final String TEXT_429 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_430 = ".write(\"  \t\tVARCHAR FileName, ";
  protected final String TEXT_431 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_432 = ".write(\"  \t\tVARCHAR Format, ";
  protected final String TEXT_433 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_434 = ".write(\"  \t\tVARCHAR OpenMode, ";
  protected final String TEXT_435 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_436 = ".write(\"  \t\tINTEGER BlockSize, ";
  protected final String TEXT_437 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_438 = ".write(\"  \t\tINTEGER BufferSize, ";
  protected final String TEXT_439 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_440 = ".write(\"  \t\tINTEGER RetentionPeriod, ";
  protected final String TEXT_441 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_442 = ".write(\"  \t\tINTEGER RowsPerInstance, ";
  protected final String TEXT_443 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_444 = ".write(\"  \t\tINTEGER SecondarySpace, ";
  protected final String TEXT_445 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_446 = ".write(\"  \t\tINTEGER UnitCount, ";
  protected final String TEXT_447 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_448 = ".write(\"  \t\tINTEGER VigilElapsedTime, ";
  protected final String TEXT_449 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_450 = ".write(\"  \t\tINTEGER VigilWaitTime, ";
  protected final String TEXT_451 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_452 = ".write(\"  \t\tINTEGER VolumeCount, ";
  protected final String TEXT_453 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_454 = ".write(\"  \t\tVARCHAR AccessModuleName, ";
  protected final String TEXT_455 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_456 = ".write(\"  \t\tVARCHAR AccessModuleInitStr, ";
  protected final String TEXT_457 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_458 = ".write(\"  \t\tVARCHAR DirectoryPath, ";
  protected final String TEXT_459 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_460 = ".write(\"  \t\tVARCHAR ExpirationDate, ";
  protected final String TEXT_461 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_462 = ".write(\"  \t\tVARCHAR IndicatorMode, ";
  protected final String TEXT_463 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_464 = ".write(\"  \t\tVARCHAR PrimarySpace, ";
  protected final String TEXT_465 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_466 = ".write(\"  \t\tVARCHAR PrivateLogName, ";
  protected final String TEXT_467 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_468 = ".write(\"  \t\tVARCHAR RecordFormat, ";
  protected final String TEXT_469 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_470 = ".write(\"  \t\tVARCHAR RecordLength, ";
  protected final String TEXT_471 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_472 = ".write(\"  \t\tVARCHAR SpaceUnit, ";
  protected final String TEXT_473 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_474 = ".write(\"  \t\tVARCHAR TextDelimiter, ";
  protected final String TEXT_475 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_476 = ".write(\"  \t\tVARCHAR VigilNoticeFileName, ";
  protected final String TEXT_477 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_478 = ".write(\"  \t\tVARCHAR VigilStartTime, ";
  protected final String TEXT_479 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_480 = ".write(\"  \t\tVARCHAR VigilStopTime, ";
  protected final String TEXT_481 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_482 = ".write(\"  \t\tVARCHAR VolSerNumber, ";
  protected final String TEXT_483 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_484 = ".write(\"  \t\tVARCHAR UnitType";
  protected final String TEXT_485 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_486 = ".write(\"  \t);";
  protected final String TEXT_487 = "\");" + NL + "\t\t\t\tfw_";
  protected final String TEXT_488 = ".write(\"  ";
  protected final String TEXT_489 = "\");" + NL + "" + NL + "\t\t\t\tfw_";
  protected final String TEXT_490 = ".write(\"    APPLY";
  protected final String TEXT_491 = "\");" + NL + "                fw_";
  protected final String TEXT_492 = ".write(\"        (";
  protected final String TEXT_493 = "\");" + NL + "" + NL + "                //builder4insert begin";
  protected final String TEXT_494 = NL + "                //builder4insert end" + NL + "" + NL + "                //builder4update begin";
  protected final String TEXT_495 = NL;
  protected final String TEXT_496 = NL + "                //builder4update end" + NL;
  protected final String TEXT_497 = NL + "\t\t\t\t\t\tfw_";
  protected final String TEXT_498 = ".write(\"            'INSERT INTO \"+ ";
  protected final String TEXT_499 = " + \".\" + ";
  protected final String TEXT_500 = "+\" (";
  protected final String TEXT_501 = ") VALUES (";
  protected final String TEXT_502 = ");'";
  protected final String TEXT_503 = "\");" + NL + "\t\t\t\t ";
  protected final String TEXT_504 = NL + "\t\t                ";
  protected final String TEXT_505 = NL + "\t\t                    fw_";
  protected final String TEXT_506 = ".write(\"            'INSERT INTO \"+ ";
  protected final String TEXT_507 = " + \".\" + ";
  protected final String TEXT_508 = "+\" (";
  protected final String TEXT_509 = ") VALUES (";
  protected final String TEXT_510 = ");'";
  protected final String TEXT_511 = "\");" + NL + "\t\t                ";
  protected final String TEXT_512 = NL + "\t\t                    fw_";
  protected final String TEXT_513 = ".write(\"            'UPDATE \" + ";
  protected final String TEXT_514 = " + \".\" + ";
  protected final String TEXT_515 = " + \" SET ";
  protected final String TEXT_516 = " WHERE ";
  protected final String TEXT_517 = ";'";
  protected final String TEXT_518 = "\" );" + NL + "\t\t                ";
  protected final String TEXT_519 = NL + "\t\t                    fw_";
  protected final String TEXT_520 = ".write(\"            'DELETE  FROM \" + ";
  protected final String TEXT_521 = " + \".\" + ";
  protected final String TEXT_522 = " + \" WHERE ";
  protected final String TEXT_523 = ";'";
  protected final String TEXT_524 = "\");" + NL + "\t\t                ";
  protected final String TEXT_525 = NL + "\t\t                    fw_";
  protected final String TEXT_526 = ".write(\"            'UPDATE \" + ";
  protected final String TEXT_527 = " + \".\" + ";
  protected final String TEXT_528 = " + \" SET ";
  protected final String TEXT_529 = " WHERE ";
  protected final String TEXT_530 = ";',";
  protected final String TEXT_531 = "\");" + NL + "\t\t                    fw_";
  protected final String TEXT_532 = ".write(\"            'INSERT INTO \"+ ";
  protected final String TEXT_533 = " + \".\" + ";
  protected final String TEXT_534 = "+\" (";
  protected final String TEXT_535 = ") VALUES (";
  protected final String TEXT_536 = ");'";
  protected final String TEXT_537 = "\");" + NL + "\t\t                ";
  protected final String TEXT_538 = NL + "\t\t                      System.err.println(\"Unexcepted DML type.\");" + NL + "\t\t                    ";
  protected final String TEXT_539 = NL + "                \t  \tSystem.err.println(\"Unknow customer operator.\");" + NL + "                \t";
  protected final String TEXT_540 = NL + NL + "                fw_";
  protected final String TEXT_541 = ".write(\"        )";
  protected final String TEXT_542 = "\");";
  protected final String TEXT_543 = NL + "                fw_";
  protected final String TEXT_544 = ".write(\"    INSERT FOR MISSING UPDATE ROWS";
  protected final String TEXT_545 = "\");";
  protected final String TEXT_546 = NL + NL + "             \tfw_";
  protected final String TEXT_547 = ".write(\"    TO OPERATOR";
  protected final String TEXT_548 = "\");" + NL + "                fw_";
  protected final String TEXT_549 = ".write(\"    (";
  protected final String TEXT_550 = "\");" + NL + "                fw_";
  protected final String TEXT_551 = ".write(\"        \"+";
  protected final String TEXT_552 = "+\"[1]\"+\"";
  protected final String TEXT_553 = "\");" + NL + "                fw_";
  protected final String TEXT_554 = ".write(\"  ";
  protected final String TEXT_555 = "\");" + NL + "                fw_";
  protected final String TEXT_556 = ".write(\"        ATTRIBUTES";
  protected final String TEXT_557 = "\");" + NL + "                fw_";
  protected final String TEXT_558 = ".write(\"        (";
  protected final String TEXT_559 = "\");" + NL + "                fw_";
  protected final String TEXT_560 = ".write(\"            UserName = '\" + ";
  protected final String TEXT_561 = " + \"', ";
  protected final String TEXT_562 = "\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_563 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_564 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_565 = ");";
  protected final String TEXT_566 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_567 = " = ";
  protected final String TEXT_568 = "; ";
  protected final String TEXT_569 = NL + NL + "                fw_";
  protected final String TEXT_570 = ".write(\"            UserPassword = '\" + decryptedPassword_";
  protected final String TEXT_571 = " + \"',";
  protected final String TEXT_572 = "\");" + NL + "                fw_";
  protected final String TEXT_573 = ".write(\"            TdpId = '\" + ";
  protected final String TEXT_574 = " + \"'";
  protected final String TEXT_575 = "\");                " + NL;
  protected final String TEXT_576 = NL + "                \t    fw_";
  protected final String TEXT_577 = ".write(\"            ,TargetTable = '\" + tableFullName_";
  protected final String TEXT_578 = " + \"'";
  protected final String TEXT_579 = "\");" + NL + "                \t";
  protected final String TEXT_580 = "                \t    " + NL + "                \t    fw_";
  protected final String TEXT_581 = ".write(\"            ,LogTable = '\" + logTable_";
  protected final String TEXT_582 = " + \"'";
  protected final String TEXT_583 = "\");" + NL + "                \t";
  protected final String TEXT_584 = NL + "                \t";
  protected final String TEXT_585 = NL + "                \t    fw_";
  protected final String TEXT_586 = ".write(\"            ,LogTable = '\" + logTable_";
  protected final String TEXT_587 = " + \"'";
  protected final String TEXT_588 = "\");" + NL + "                \t";
  protected final String TEXT_589 = NL + "\t\t\t\t\t\t\t\t   fw_";
  protected final String TEXT_590 = ".write(\"            ,";
  protected final String TEXT_591 = " = \"+";
  protected final String TEXT_592 = "+\"";
  protected final String TEXT_593 = "\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_594 = NL + "\t\t\t\t\t\t\t\t\t   fw_";
  protected final String TEXT_595 = ".write(\"            ,";
  protected final String TEXT_596 = " = '\"+";
  protected final String TEXT_597 = "+\".\"+";
  protected final String TEXT_598 = "+\"'";
  protected final String TEXT_599 = "\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_600 = NL + "\t\t\t\t\t\t\t\t\t   fw_";
  protected final String TEXT_601 = ".write(\"            ,";
  protected final String TEXT_602 = " = '\"+";
  protected final String TEXT_603 = "+\"'";
  protected final String TEXT_604 = "\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_605 = NL + "\t\t\t\t\t\t\t\t\t\t   fw_";
  protected final String TEXT_606 = ".write(\"            ,";
  protected final String TEXT_607 = " = \"+";
  protected final String TEXT_608 = "+\"";
  protected final String TEXT_609 = "\");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_610 = NL + NL + "                fw_";
  protected final String TEXT_611 = ".write(\"        )";
  protected final String TEXT_612 = "\");" + NL + "                fw_";
  protected final String TEXT_613 = ".write(\"    )";
  protected final String TEXT_614 = "\");" + NL + "                fw_";
  protected final String TEXT_615 = ".write(\"    SELECT * FROM OPERATOR";
  protected final String TEXT_616 = "\");" + NL + "                fw_";
  protected final String TEXT_617 = ".write(\"    (";
  protected final String TEXT_618 = "\");" + NL + "                fw_";
  protected final String TEXT_619 = ".write(\"        \"+";
  protected final String TEXT_620 = "+\"[1]\"+\"";
  protected final String TEXT_621 = "\");" + NL + "                fw_";
  protected final String TEXT_622 = ".write(\"  ";
  protected final String TEXT_623 = "\");" + NL + "                fw_";
  protected final String TEXT_624 = ".write(\"        ATTRIBUTES";
  protected final String TEXT_625 = "\");" + NL + "                fw_";
  protected final String TEXT_626 = ".write(\"        (";
  protected final String TEXT_627 = "\");" + NL + "                fw_";
  protected final String TEXT_628 = ".write(\"            FileName = '\" + ";
  protected final String TEXT_629 = " + \"', ";
  protected final String TEXT_630 = "\");" + NL + "                fw_";
  protected final String TEXT_631 = ".write(\"            Format = 'DELIMITED', ";
  protected final String TEXT_632 = "\");" + NL + "                fw_";
  protected final String TEXT_633 = ".write(\"            OpenMode = 'Read', ";
  protected final String TEXT_634 = "\");" + NL + "                fw_";
  protected final String TEXT_635 = ".write(\"            DirectoryPath = '', ";
  protected final String TEXT_636 = "\");" + NL + "                fw_";
  protected final String TEXT_637 = ".write(\"            IndicatorMode = 'N', ";
  protected final String TEXT_638 = "\");" + NL + "                fw_";
  protected final String TEXT_639 = ".write(\"            TextDelimiter = '\" + ";
  protected final String TEXT_640 = " + \"'";
  protected final String TEXT_641 = "\");" + NL + "                fw_";
  protected final String TEXT_642 = ".write(\"        )";
  protected final String TEXT_643 = "\");" + NL + "                fw_";
  protected final String TEXT_644 = ".write(\"    );";
  protected final String TEXT_645 = "\");" + NL + "                fw_";
  protected final String TEXT_646 = ".write(\"  );";
  protected final String TEXT_647 = "\");" + NL + "" + NL + "                //write script to file" + NL + "                fw_";
  protected final String TEXT_648 = ".close();" + NL + "" + NL + "                //run tbuild (TPT) command";
  protected final String TEXT_649 = NL + "                            String[] sb_";
  protected final String TEXT_650 = "= {\"cmd\",\"/c\",\"tbuild -f \\\"\"+";
  protected final String TEXT_651 = "+";
  protected final String TEXT_652 = "+\".script\\\" -e \"+";
  protected final String TEXT_653 = "+\" > \\\"\"+";
  protected final String TEXT_654 = "+\"\\\" 2>&1\"};";
  protected final String TEXT_655 = NL + "                            String[] sb_";
  protected final String TEXT_656 = "= {\"sh\",\"-c\",\"tbuild -f \\\"\"+";
  protected final String TEXT_657 = "+";
  protected final String TEXT_658 = "+\".scr\\\" -e \"+";
  protected final String TEXT_659 = "+\" > \\\"\"+";
  protected final String TEXT_660 = "+\"\\\" 2>&1\"};";
  protected final String TEXT_661 = NL + "                        String[] sb_";
  protected final String TEXT_662 = "= {\"cmd\",\"/c\",\"tbuild -f \\\"\"+";
  protected final String TEXT_663 = "+";
  protected final String TEXT_664 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_665 = "+\"\\\" 2>&1\"};";
  protected final String TEXT_666 = NL + "                        String[] sb_";
  protected final String TEXT_667 = "= {\"sh\",\"-c\",\"tbuild -f \\\"\"+";
  protected final String TEXT_668 = "+";
  protected final String TEXT_669 = "+\".scr\\\" > \\\"\"+";
  protected final String TEXT_670 = "+\"\\\" 2>&1\"};";
  protected final String TEXT_671 = NL + "                \tString cmdStr_";
  protected final String TEXT_672 = " = java.util.Arrays.toString(sb_";
  protected final String TEXT_673 = ");" + NL + "                    log.info(\"";
  protected final String TEXT_674 = " - Executing command: '\" + cmdStr_";
  protected final String TEXT_675 = " + \"'.\");";
  protected final String TEXT_676 = NL + "                final Process process_";
  protected final String TEXT_677 = " = Runtime.getRuntime().exec(sb_";
  protected final String TEXT_678 = ");" + NL + "                Thread normal_";
  protected final String TEXT_679 = " = new Thread() {" + NL + "                    public void run() {" + NL + "                        try {" + NL + "                            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_680 = ".getInputStream()));" + NL + "                            String line = \"\";" + NL + "                            try {" + NL + "                                while((line = reader.readLine()) != null) {" + NL + "                                   System.out.println(line);" + NL + "                                }" + NL + "                            } finally {" + NL + "                                 reader.close();" + NL + "                            }" + NL + "                        }catch(java.io.IOException ioe) {";
  protected final String TEXT_681 = NL + "                            ioe.printStackTrace();" + NL + "                        }" + NL + "                    }" + NL + "                };" + NL + "                normal_";
  protected final String TEXT_682 = ".start();" + NL + "" + NL + "                Thread error_";
  protected final String TEXT_683 = " = new Thread() {" + NL + "                    public void run() {" + NL + "                        try {" + NL + "                            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_684 = ".getErrorStream()));" + NL + "                            String line = \"\";" + NL + "                            try {" + NL + "                                while((line = reader.readLine()) != null) {" + NL + "                                    System.err.println(line);" + NL + "                                }" + NL + "                            } finally {" + NL + "                                reader.close();" + NL + "                            }" + NL + "                        } catch(java.io.IOException ioe) {";
  protected final String TEXT_685 = NL + "                           ioe.printStackTrace();" + NL + "                        }" + NL + "                    }" + NL + "                };" + NL + "                error_";
  protected final String TEXT_686 = ".start();" + NL + "" + NL + "                process_";
  protected final String TEXT_687 = ".waitFor();" + NL + "" + NL + "                normal_";
  protected final String TEXT_688 = ".interrupt();" + NL + "" + NL + "                error_";
  protected final String TEXT_689 = ".interrupt();" + NL + "" + NL + "                globalMap.put(\"";
  protected final String TEXT_690 = "_EXIT_VALUE\", process_";
  protected final String TEXT_691 = ".exitValue());" + NL;
  protected final String TEXT_692 = NL + "                    if(process_";
  protected final String TEXT_693 = ".exitValue()>=";
  protected final String TEXT_694 = ") {" + NL + "                        throw new RuntimeException(\"TPT returned exit code \"+process_";
  protected final String TEXT_695 = ".exitValue());" + NL + "                    }";
  protected final String TEXT_696 = NL + "                    log.info(\"";
  protected final String TEXT_697 = " - Excute command:'\" + cmdStr_";
  protected final String TEXT_698 = " + \"' has finished.\");";
  protected final String TEXT_699 = NL + "}finally{" + NL + "\ttry{" + NL + "\t\tfile_";
  protected final String TEXT_700 = ".delete();" + NL + "\t}catch(Exception e_";
  protected final String TEXT_701 = "){";
  protected final String TEXT_702 = NL + "\t}" + NL + "}";
  protected final String TEXT_703 = NL;

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
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    if (cid.startsWith("tImpala") || cid.startsWith("tHive")) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_34);
    } else {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
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
			
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
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
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
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
			
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_53);
    
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
	    	
    stringBuffer.append(TEXT_54);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_57);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_58);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_60);
    
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
			
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_69);
    
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

String operatorType = ElementParameterParser.getValue(node, "__ACTION__");
String dmlType = ElementParameterParser.getValue(node, "__DML_TYPE__");
String tdpid= ElementParameterParser.getValue(node, "__TDPID__");
String jobName= ElementParameterParser.getValue(node, "__JOB_NAME__");
String operatorLoad= ElementParameterParser.getValue(node, "__OPERATOR_LOAD__");
String operatorDataConnector= ElementParameterParser.getValue(node, "__OPERATOR_DATA_CONNECTOR__");
String layoutName= ElementParameterParser.getValue(node, "__LAYOUT_NAME__");
String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser= ElementParameterParser.getValue(node, "__USER__");
String table= ElementParameterParser.getValue(node, "__TABLE__");

String scriptPath= ElementParameterParser.getValue(node, "__SCRIPT_PATH__");
String execution= ElementParameterParser.getValue(node, "__EXECUTION__");
String loadFile= ElementParameterParser.getValue(node, "__LOAD_FILE__");
String separator= ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");
String errorFile= ElementParameterParser.getValue(node, "__ERROR_FILE__");

boolean returnCodeDie= "true".equals(ElementParameterParser.getValue(node, "__RETURN_CODE_DIE__"));
String returnCode= ElementParameterParser.getValue(node, "__RETURN_CODE__");
boolean specifyLogTable= "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_LOG_TABLE__"));
String logTable= ElementParameterParser.getValue(node, "__LOG_TABLE_TABLE__");
String defineCharset = ElementParameterParser.getValue(node, "__DEFINE_CHARSET__");
String charset = ElementParameterParser.getValue(node, "__CHARSET__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

boolean checkedScriptParameter = ("true").equals(ElementParameterParser.getValue(node, "__SCRIPT_PARAMETER__"));
boolean applyOptionalAttributes = "true".equals(ElementParameterParser.getValue(node, "__APPLY_OPTIONAL_ATTRIBUTES__"));

String passwordFieldName="__PASS__";

//New Feature TDI-29325 begin
List<String>  intAttrisList = null;
List<String>  arrayAttrisList = null;
List<String> tableNameAttrisList = null;
Map<String,String> attrisMap = null;
if(applyOptionalAttributes){
	List<Map<String,String>> additionalList = null;
	if("LOAD".equalsIgnoreCase(operatorType)){
		additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__TPT_CONSUMER_OPERATOR_OPTIONAL_ATTRIBUTES__");
	}else if("INSERTER".equalsIgnoreCase(operatorType)){
		additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__TPT_COOA_FOR_INSERTER__");
	}else if("UPDATE".equalsIgnoreCase(operatorType)){
		additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__TPT_COOA_FOR_UPDATE__");
	}else if("STREAM".equalsIgnoreCase(operatorType)){
		additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__TPT_COOA_FOR_STREAM__");
	}else{
		System.err.println("Unexcepted consumer operator type.");
	}

	attrisMap =  new HashMap<String,String>();//For unique key

	for(Map<String,String> map : additionalList){
		String attriName = map.get("OPTIONAL_ATTRIBUTES_NAME");
		String attriValue = map.get("OPTIONAL_ATTRIBUTES_VALUE");
		if("WORKINGDATABASE".equalsIgnoreCase(attriName)){
			dbname = attriValue;
		}
		attrisMap.put(attriName, attriValue);
	}

	intAttrisList = Arrays.asList(
										"BUFFERSIZE","ERRORLIMIT","MAXSESSIONS",
										"MINSESSIONS","TENACITYHOURS","TENACITYSLEEP",
										"BUFFERS","PACK","RATE",
										"PERIODICITY","IOBUFFERSIZE","ROWSPERINSTANCE",
										"SKIPROWS","TIMEOUT","VIGILELAPSEDTIME",
										"VIGILMAXFILES","VIGILWAITTIME"
								  );
    arrayAttrisList = Arrays.asList("TRACELEVEL");
    tableNameAttrisList = Arrays.asList("TARGETTABLE","ERRORTABLE1","ERRORTABLE2","WORKTABLE");
}
//end

//windows line separator as default
String lineSeparator = "\\r\\n";
if("Unix".equals(execution)){
	lineSeparator = "\\n";
}
if(!scriptPath.endsWith("/\"")){
	scriptPath = scriptPath+	"+\"/\"";
}
if(loadFile.indexOf("/") !=0 && ("Windows").equals(execution)){
	loadFile = loadFile.replaceAll("/", "\\\\\\\\");
}

String dbmsId = "teradata_id";

List<IMetadataColumn> columnList = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		columnList = metadata.getListColumns();
	}
}

List<String> primaryKeyList = new ArrayList<String>();
if(columnList!=null){
	for(IMetadataColumn column:columnList){
		if(column.isKey()){
			primaryKeyList.add(column.getOriginalDbColumnName());
		}
	}
}

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_76);
    if("Windows".equals(execution)){
    stringBuffer.append(TEXT_77);
    }else{
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
     if(specifyLogTable){ 
    stringBuffer.append(TEXT_80);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_82);
    stringBuffer.append( logTable );
    stringBuffer.append(TEXT_83);
     } 
    //build script---------------------------------------------------------
    stringBuffer.append(TEXT_84);
     if(!checkedScriptParameter){
    stringBuffer.append(TEXT_85);
    
						operatorLoad = "\"Operator_" + cid+"\"";
						operatorDataConnector = "\"Connector_" + cid+"\"";
						jobName = "\"Job_" + cid+"\"";
						layoutName = "\"Schema_" +cid+"\"";
					
    stringBuffer.append(TEXT_86);
     }
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(jobName );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_94);
     if("Load".equals(operatorType)){ 
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(operatorLoad );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_170);
    }else if("Inserter".equals(operatorType)){ 
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(operatorLoad );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_214);
    }else if("Update".equals(operatorType)){ 
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(operatorLoad );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_302);
    }else if("Stream".equals(operatorType)){
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(operatorLoad );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_396);
    }else{}
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(layoutName );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_402);
    
				if(columnList!=null){
					int counter = 1;
					for(IMetadataColumn column:columnList){
						if( columnList.size() != counter){	
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_405);
    stringBuffer.append(column.getLength() == null ? 0 : column.getLength());
    stringBuffer.append(TEXT_406);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_407);
    
						} else {
					
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_410);
    stringBuffer.append(column.getLength() == null ? 0 : column.getLength());
    stringBuffer.append(TEXT_411);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_412);
     	}
						counter++;
					}
				}
				
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_414);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_416);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(operatorDataConnector );
    stringBuffer.append(TEXT_419);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_421);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(layoutName );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_426);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_428);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_430);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_438);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_442);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_448);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_456);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_460);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_466);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_488);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_492);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_493);
    
                StringBuilder inserterColsStrBuilder = new StringBuilder();
                StringBuilder inserterValueSqlStrBuilder = new StringBuilder();
                if(columnList!=null){
                    String columnName = "";
                    for(IMetadataColumn column:columnList){
                        columnName= column.getOriginalDbColumnName();
                        if(inserterColsStrBuilder.length()>0){
                            inserterColsStrBuilder.append(",");
                        }
                        inserterColsStrBuilder.append(columnName);

                        if(inserterValueSqlStrBuilder.length()>0){
                            inserterValueSqlStrBuilder.append(",");
                        }
                        inserterValueSqlStrBuilder.append(":").append(columnName);
                    }
                }
                
    stringBuffer.append(TEXT_494);
    
                StringBuilder setStrBuilder = new StringBuilder();
                if(columnList!=null){
                    String columnName = "";
                    int lgth = columnList.size();
                    for(IMetadataColumn column:columnList){
                    	if(!column.isKey()){
	                        columnName= column.getOriginalDbColumnName();
	                        if(lgth>1){
	                            setStrBuilder.append(columnName).append("=:").append(columnName).append(",");
	                        }else{
	                            setStrBuilder.append(columnName).append("=:").append(columnName);
	                        }
                    	}
                    	lgth--;
                    }
                }
                
    stringBuffer.append(TEXT_495);
    
                StringBuilder whereStrBuilder = new StringBuilder();
                if(primaryKeyList.size()>0){
                    //get primary key from talend schema
                    int lgthx = primaryKeyList.size();
                    for(String primaryKey:primaryKeyList){
                        if(lgthx>1){
                            whereStrBuilder.append(primaryKey).append("=:").append(primaryKey).append(" and ");
                        }else{
                            whereStrBuilder.append(primaryKey).append("=:").append(primaryKey);
                        }
                        lgthx--;
                    }
                }else{
                     whereStrBuilder.append("1=0");
                }
    stringBuffer.append(TEXT_496);
     if("Load".equals(operatorType) || "Inserter".equals(operatorType)){
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(inserterColsStrBuilder.toString());
    stringBuffer.append(TEXT_501);
    stringBuffer.append(inserterValueSqlStrBuilder.toString());
    stringBuffer.append(TEXT_502);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_503);
    }else if("Update".equals(operatorType) || "Stream".equals(operatorType)){
    stringBuffer.append(TEXT_504);
     if("Insert".equals(dmlType)){ 
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(inserterColsStrBuilder.toString());
    stringBuffer.append(TEXT_509);
    stringBuffer.append(inserterValueSqlStrBuilder.toString());
    stringBuffer.append(TEXT_510);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_511);
     } else if("Update".equals(dmlType)){ 
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_515);
    stringBuffer.append( setStrBuilder.toString() );
    stringBuffer.append(TEXT_516);
    stringBuffer.append( whereStrBuilder.toString() );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_518);
     }else if("Delete".equals(dmlType)){
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_522);
    stringBuffer.append( whereStrBuilder.toString() );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_524);
    }else if("InsertOrUpdate".equals(dmlType)){
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_526);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_528);
    stringBuffer.append( setStrBuilder.toString() );
    stringBuffer.append(TEXT_529);
    stringBuffer.append( whereStrBuilder.toString() );
    stringBuffer.append(TEXT_530);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(inserterColsStrBuilder.toString());
    stringBuffer.append(TEXT_535);
    stringBuffer.append(inserterValueSqlStrBuilder.toString());
    stringBuffer.append(TEXT_536);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_537);
    }else{
		                    
    stringBuffer.append(TEXT_538);
    
		                } 
    }else{
                	
    stringBuffer.append(TEXT_539);
    
	            } 
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_542);
      if(("Update".equals(operatorType) || "Stream".equals(operatorType)) && "InsertOrUpdate".equals(dmlType)){
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_544);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_545);
    } 
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_547);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_549);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_551);
    stringBuffer.append(operatorLoad );
    stringBuffer.append(TEXT_552);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_556);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_558);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_560);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_562);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_565);
    } else {
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_568);
    }
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(tdpid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_575);
     if("Load".equals(operatorType) || "Update".equals(operatorType)){
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_579);
     if(specifyLogTable){ 
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_581);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_583);
     } 
    } if("Stream".equals(operatorType)){
    stringBuffer.append(TEXT_584);
     if(specifyLogTable){ 
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_586);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_587);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_588);
     }
                }
					//New Feature TDI-29325
					if(applyOptionalAttributes){
						Set<String> attrisKeySet = attrisMap.keySet();
						for(String key : attrisKeySet){
							String value = attrisMap.get(key);
							boolean isIntType = intAttrisList.contains(key);
							boolean isArrType;
							if(isIntType){//Integer
								
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_590);
    stringBuffer.append( key );
    stringBuffer.append(TEXT_591);
    stringBuffer.append( value );
    stringBuffer.append(TEXT_592);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_593);
    
							}else{
								isArrType = arrayAttrisList.contains(key);
								if(!isArrType){//Varchar or table name
									boolean isTableType = tableNameAttrisList.contains(key);
									if("ERRORTABLE".equalsIgnoreCase(key) || (isTableType && operatorType.equalsIgnoreCase("LOAD"))){
									
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_595);
    stringBuffer.append( key );
    stringBuffer.append(TEXT_596);
    stringBuffer.append( dbname );
    stringBuffer.append(TEXT_597);
    stringBuffer.append( value );
    stringBuffer.append(TEXT_598);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_599);
    
									}else{
									
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_601);
    stringBuffer.append( key );
    stringBuffer.append(TEXT_602);
    stringBuffer.append( value );
    stringBuffer.append(TEXT_603);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_604);
    
									}
								}else{//Array
										
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_606);
    stringBuffer.append( key );
    stringBuffer.append(TEXT_607);
    stringBuffer.append( value );
    stringBuffer.append(TEXT_608);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_609);
    
									}
								}
							}
						}
				
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_611);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_613);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_615);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_619);
    stringBuffer.append(operatorDataConnector );
    stringBuffer.append(TEXT_620);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_622);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_624);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_626);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_628);
    stringBuffer.append(loadFile);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_631);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_633);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_635);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_637);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_639);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_642);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_644);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_646);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_648);
    if("true".equals(defineCharset)) {
                    if(!("".equals(charset))) {
                        if("Windows".equals(execution)){
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(charset);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_654);
    }else{
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(charset);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_660);
    }
                    }
                } else {
                    if("Windows".equals(execution)){
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_665);
    }else{
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_670);
    }
                }
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_671);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_675);
    }
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_680);
    log4jCodeGenerateUtil.logError(node,"error","ioe");
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_684);
    log4jCodeGenerateUtil.logError(node,"error","ioe");
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_691);
    
                if(returnCodeDie) {
                
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_693);
    stringBuffer.append(returnCode);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_695);
    
                }
                
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_697);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_698);
    }
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    log4jCodeGenerateUtil.logError(node,"warn","e_"+cid);
    stringBuffer.append(TEXT_702);
    stringBuffer.append(TEXT_703);
    return stringBuffer.toString();
  }
}
