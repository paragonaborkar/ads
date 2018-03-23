package org.talend.designer.codegen.translators.databases.vertica;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.IConnection;
import java.util.List;

public class TVerticaOutputEndJava
{
  protected static String nl;
  public static synchronized TVerticaOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TVerticaOutputEndJava result = new TVerticaOutputEndJava();
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
  protected final String TEXT_47 = NL + "\t\t\tif (pstmt_";
  protected final String TEXT_48 = " !=null && batchSizeCounter_";
  protected final String TEXT_49 = " > 0 ) { ";
  protected final String TEXT_50 = NL + "\t\t\tif (pstmt_";
  protected final String TEXT_51 = " !=null && commitCounter_";
  protected final String TEXT_52 = " > 0 ) {";
  protected final String TEXT_53 = NL + "\t\t\tif (pstmt_";
  protected final String TEXT_54 = " !=null) {";
  protected final String TEXT_55 = " " + NL + "\ttry {" + NL + "\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\tpstmt_";
  protected final String TEXT_57 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\tinsertedCount_";
  protected final String TEXT_60 = " +=pstmt_";
  protected final String TEXT_61 = ".getUpdateCount(); " + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\tupdatedCount_";
  protected final String TEXT_63 = " += pstmt_";
  protected final String TEXT_64 = ".getUpdateCount();" + NL + "\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\tdeletedCount_";
  protected final String TEXT_66 = " += pstmt_";
  protected final String TEXT_67 = ".getUpdateCount();" + NL + "\t\t\t";
  protected final String TEXT_68 = NL + "\t}catch (java.sql.BatchUpdateException e){" + NL + "\t\t";
  protected final String TEXT_69 = NL + "\t\t\tthrow(e);" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\tSystem.err.println(e.getMessage());" + NL + "\t\t";
  protected final String TEXT_71 = "\t\t\t\t\t" + NL + "\t}" + NL + "\t}";
  protected final String TEXT_72 = NL + "\t";
  protected final String TEXT_73 = NL + "\t\tpstmt_";
  protected final String TEXT_74 = " = conn_";
  protected final String TEXT_75 = ".prepareStatement(\"COMMIT;\");" + NL + "\t\tpstmtInsert_";
  protected final String TEXT_76 = " = conn_";
  protected final String TEXT_77 = ".prepareStatement(\"COMMIT;\");" + NL + "\t\tpstmtUpdate_";
  protected final String TEXT_78 = " = conn_";
  protected final String TEXT_79 = ".prepareStatement(\"COMMIT;\");" + NL + "\t\tpstmt_";
  protected final String TEXT_80 = ".executeUpdate();" + NL + "\t\tpstmtInsert_";
  protected final String TEXT_81 = ".executeUpdate();" + NL + "\t\tpstmtUpdate_";
  protected final String TEXT_82 = ".executeUpdate();" + NL + "\t";
  protected final String TEXT_83 = NL + "\t\tpstmtInsert_";
  protected final String TEXT_84 = " = conn_";
  protected final String TEXT_85 = ".prepareStatement(\"COMMIT;\");" + NL + "\t\tpstmtUpdate_";
  protected final String TEXT_86 = " = conn_";
  protected final String TEXT_87 = ".prepareStatement(\"COMMIT;\");" + NL + "\t\tpstmtInsert_";
  protected final String TEXT_88 = ".executeUpdate();" + NL + "\t\tpstmtUpdate_";
  protected final String TEXT_89 = ".executeUpdate();" + NL + "\t";
  protected final String TEXT_90 = NL + "\t\t";
  protected final String TEXT_91 = NL + "\t\tpstmt_";
  protected final String TEXT_92 = " = conn_";
  protected final String TEXT_93 = ".prepareStatement(\"COMMIT;\");" + NL + "\t\tpstmt_";
  protected final String TEXT_94 = ".executeUpdate();" + NL + "\t";
  protected final String TEXT_95 = NL + "\t\tif(pstmtUpdate_";
  protected final String TEXT_96 = " != null){" + NL + "" + NL + "\t\t\tpstmtUpdate_";
  protected final String TEXT_97 = ".close();" + NL + "\t\t\t" + NL + "\t\t} " + NL + "\t\tif(pstmtInsert_";
  protected final String TEXT_98 = " != null){" + NL + "" + NL + "\t\t\tpstmtInsert_";
  protected final String TEXT_99 = ".close();" + NL + "\t\t\t" + NL + "\t\t}" + NL + "\t\tif(pstmt_";
  protected final String TEXT_100 = " != null) {" + NL + "" + NL + "\t\t\tpstmt_";
  protected final String TEXT_101 = ".close();" + NL + "\t\t\t" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_102 = NL + "\t\tif(pstmtUpdate_";
  protected final String TEXT_103 = " != null){" + NL + "" + NL + "\t\t\tpstmtUpdate_";
  protected final String TEXT_104 = ".close();" + NL + "\t\t\t" + NL + "\t\t} " + NL + "\t\tif(pstmtInsert_";
  protected final String TEXT_105 = " != null){" + NL + "" + NL + "\t\t\tpstmtInsert_";
  protected final String TEXT_106 = ".close();" + NL + "\t\t\t" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_107 = NL + "\t\t\tif(pstmt_";
  protected final String TEXT_108 = " != null) {" + NL + "\t" + NL + "\t\t\t\tpstmt_";
  protected final String TEXT_109 = ".close();" + NL + "\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_110 = NL + "\tif (stmtBuilder_";
  protected final String TEXT_111 = " != null && stmtBuilder_";
  protected final String TEXT_112 = ".length() != 0 ) {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.ByteArrayInputStream bais_";
  protected final String TEXT_113 = " = new ByteArrayInputStream(stmtBuilder_";
  protected final String TEXT_114 = ".toString().getBytes());" + NL + "\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\t";
  protected final String TEXT_116 = NL + "        \t\t\t((com.vertica.PGStatement)stmt_";
  protected final String TEXT_117 = ").executeCopyIn(template_";
  protected final String TEXT_118 = ", bais_";
  protected final String TEXT_119 = ");" + NL + "        \t\t\t";
  protected final String TEXT_120 = NL + "        \t\t\tcopiedCount_";
  protected final String TEXT_121 = " +=stmt_";
  protected final String TEXT_122 = ".getUpdateCount(); " + NL + "        \t\t\tif (stmt_";
  protected final String TEXT_123 = " != null) {" + NL + "        \t\t\t\tstmt_";
  protected final String TEXT_124 = ".close();" + NL + "        \t\t\t\tstmt_";
  protected final String TEXT_125 = " = null;" + NL + "        \t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\t\t";
  protected final String TEXT_127 = NL + "        \t\t\tcom.vertica.jdbc.VerticaCopyStream vcs_";
  protected final String TEXT_128 = " = new com.vertica.jdbc.VerticaCopyStream((com.vertica.jdbc.VerticaConnection)conn_";
  protected final String TEXT_129 = ",template_";
  protected final String TEXT_130 = ");" + NL + "        \t\t\tvcs_";
  protected final String TEXT_131 = ".start();" + NL + "        \t\t\tvcs_";
  protected final String TEXT_132 = ".addStream(bais_";
  protected final String TEXT_133 = ");" + NL + "        \t\t\tvcs_";
  protected final String TEXT_134 = ".execute();" + NL + "        \t\t\tvcs_";
  protected final String TEXT_135 = ".finish();" + NL + "        \t\t\tcopiedCount_";
  protected final String TEXT_136 = " +=vcs_";
  protected final String TEXT_137 = ".getRowCount();" + NL + "        \t\t\tvcs_";
  protected final String TEXT_138 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\tif (bais_";
  protected final String TEXT_141 = " != null ) {" + NL + "\t\t\t\tbais_";
  protected final String TEXT_142 = ".close();" + NL + "\t\t\t\tbais_";
  protected final String TEXT_143 = " = null;" + NL + "\t\t\t}" + NL + "\t\t\tstmtBuilder_";
  protected final String TEXT_144 = " = null;" + NL + "\t\t}catch (java.sql.SQLException e){" + NL + "\t\t\t";
  protected final String TEXT_145 = NL + "\t\t\t\tthrow(e);" + NL + "\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_147 = NL + "\t\t}  " + NL + "\t}";
  protected final String TEXT_148 = NL + "\t\t\tif (commitCounter_";
  protected final String TEXT_149 = " > 0 ) {" + NL + "\t\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\t\tconn_";
  protected final String TEXT_151 = ".commit();" + NL + "\t\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_153 = "\t" + NL + "\t\t";
  protected final String TEXT_154 = NL + "\t\tconn_";
  protected final String TEXT_155 = ".close();" + NL + "\t\t";
  protected final String TEXT_156 = NL + "\t\tresourceMap.put(\"finish_";
  protected final String TEXT_157 = "\", true);" + NL + "\t";
  protected final String TEXT_158 = NL;
  protected final String TEXT_159 = NL + "\tnb_line_deleted_";
  protected final String TEXT_160 = "=nb_line_deleted_";
  protected final String TEXT_161 = "+ deletedCount_";
  protected final String TEXT_162 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_163 = "=nb_line_update_";
  protected final String TEXT_164 = " + updatedCount_";
  protected final String TEXT_165 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_166 = "=nb_line_inserted_";
  protected final String TEXT_167 = " + insertedCount_";
  protected final String TEXT_168 = ";" + NL + "\tnb_line_rejected_";
  protected final String TEXT_169 = "=nb_line_rejected_";
  protected final String TEXT_170 = " + rejectedCount_";
  protected final String TEXT_171 = ";" + NL + "\t";
  protected final String TEXT_172 = NL + "    \tif (globalMap.get(\"";
  protected final String TEXT_173 = "_NB_LINE\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_174 = "_NB_LINE\",nb_line_";
  protected final String TEXT_175 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_176 = "_NB_LINE\",(Integer)globalMap.get(\"";
  protected final String TEXT_177 = "_NB_LINE\") + nb_line_";
  protected final String TEXT_178 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_179 = "_NB_LINE_UPDATED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_180 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_181 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_182 = "_NB_LINE_UPDATED\",(Integer)globalMap.get(\"";
  protected final String TEXT_183 = "_NB_LINE_UPDATED\") + nb_line_update_";
  protected final String TEXT_184 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_185 = "_NB_LINE_INSERTED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_186 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_187 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_188 = "_NB_LINE_INSERTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_189 = "_NB_LINE_INSERTED\") + nb_line_inserted_";
  protected final String TEXT_190 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_191 = "_NB_LINE_DELETED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_192 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_193 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_194 = "_NB_LINE_DELETED\",(Integer)globalMap.get(\"";
  protected final String TEXT_195 = "_NB_LINE_DELETED\") + nb_line_deleted_";
  protected final String TEXT_196 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_197 = "_NB_LINE_REJECTED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_198 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_199 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_200 = "_NB_LINE_REJECTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_201 = "_NB_LINE_REJECTED\") + nb_line_rejected_";
  protected final String TEXT_202 = ");" + NL + "        }" + NL + "\t";
  protected final String TEXT_203 = NL + "        globalMap.put(\"";
  protected final String TEXT_204 = "_NB_LINE\",nb_line_";
  protected final String TEXT_205 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_206 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_207 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_208 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_209 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_210 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_211 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_212 = "_NB_LINE_REJECTED\", nb_line_rejected_";
  protected final String TEXT_213 = ");" + NL + "    " + NL + "\t";
  protected final String TEXT_214 = NL + NL + "\tnb_line_copied_";
  protected final String TEXT_215 = "=nb_line_copied_";
  protected final String TEXT_216 = " + copiedCount_";
  protected final String TEXT_217 = ";" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_218 = "_NB_LINE_COPIED\",nb_line_copied_";
  protected final String TEXT_219 = ");";
  protected final String TEXT_220 = NL;

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
	dbLog = new DBLogUtil(node);
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	
	 boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String rejectConnName = null;
	List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
	if(rejectConns != null && rejectConns.size() > 0) {
		IConnection rejectConn = rejectConns.get(0);
		rejectConnName = rejectConn.getName();
	}
	boolean manualCommit = !useExistingConnection && !("0").equals(commitEvery);

    
	//batch mode
	if (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) {
		boolean batchMode = ("true").equals(ElementParameterParser.getValue(node, "__BATCH_MODE__"));
		boolean executeBatch = rejectConnName==null && (batchMode||manualCommit);
		if(executeBatch) {
			if(batchMode) {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
			} else if (!useExistingConnection) { //use batch is not ticked

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
			}else {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    
			} 

    stringBuffer.append(TEXT_55);
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    stringBuffer.append(TEXT_58);
    if (("INSERT").equals(dataAction)) {
			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    
			}else if (("UPDATE").equals(dataAction)) {
			
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    
			}else if (("DELETE").equals(dataAction)) {
			
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    
			}
    stringBuffer.append(TEXT_68);
    
			if(("true").equals(dieOnError)) {
		
    stringBuffer.append(TEXT_69);
    
			}else {
				dbLog.logPrintedException("e.getMessage()");
		
    stringBuffer.append(TEXT_70);
    
			}
		
    stringBuffer.append(TEXT_71);
    
		}
	}

    stringBuffer.append(TEXT_72);
    if(!useExistingConnection && ("INSERT_OR_UPDATE").equals(dataAction)){
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    }else if(!useExistingConnection && ("UPDATE_OR_INSERT").equals(dataAction)){
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    }else{
    stringBuffer.append(TEXT_90);
    
		 if(!useExistingConnection && !"COPY".equals(dataAction))	{
		 
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
		}
	}

	
	if(("INSERT_OR_UPDATE").equals(dataAction)) {
		
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    
	} else if(("UPDATE_OR_INSERT").equals(dataAction)) {
		
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    
	} else {
		if (!"COPY".equals(dataAction)) {
		
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    
		}
	}

	//////////////// Copy Action //////////////////////
	if ("COPY".equals(dataAction)) { // COPY
		String db_version = ElementParameterParser.getValue(node,"__DB_VERSION__");
		if(useExistingConnection){
			String connName = ElementParameterParser.getValue(node,"__CONNECTION__");
			INode con_node = NodeUtil.getNodeByUniqueName(node.getProcess(),connName);
			if(con_node!=null){
				db_version = ElementParameterParser.getValue(con_node,"__DB_VERSION__");
			}
		}

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    if("vertica_3.0_jdk_5.jar".equals(db_version) || "vertica_3.5_jdk_5.jar".equals(db_version) || "vertica_4.0_jdk_5.jar".equals(db_version) || "vertica_4.1.7_jdk_5.jar".equals(db_version) || "vertica_4.1.14_jdk_5.jar".equals(db_version)){
    stringBuffer.append(TEXT_115);
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    }else{
    stringBuffer.append(TEXT_126);
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
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
    dbLog.batch().executeDone(dbLog.str(dataAction));
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    if(("true").equals(dieOnError)) {
			
    stringBuffer.append(TEXT_145);
    
			}else {
				dbLog.logPrintedException("e.getMessage()");
			
    stringBuffer.append(TEXT_146);
    
			}
    stringBuffer.append(TEXT_147);
    
	}
	/////// commit end/////////////
	if(!useExistingConnection) {
		if(!("").equals(commitEvery)&&!("0").equals(commitEvery)){
			
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    dbLog.commit().commitTry(null, dbLog.var("commitCounter"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    dbLog.commit().commitDone(null);
    stringBuffer.append(TEXT_152);
    
		}
		
    stringBuffer.append(TEXT_153);
    dbLog.conn().closeTry(null);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    dbLog.conn().closeDone(null);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
	}
	
    stringBuffer.append(TEXT_158);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    
	boolean isEnableParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	if (isEnableParallelize) {
	
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
	} else {
	
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
	}
	if (("INSERT").equals(dataAction)) {
		dbLog.state().logInsertedLines(dbLog.var("nb_line_inserted"));
	}else if (("UPDATE").equals(dataAction)) {
		dbLog.state().logUpdatedLines(dbLog.var("nb_line_update"));
	}else if (("DELETE").equals(dataAction)) {
		dbLog.state().logDeletedLines(dbLog.var("nb_line_deleted"));
	}else if("UPDATE_OR_INSERT".equals(dataAction)){
		dbLog.state().logUpdatedLines(dbLog.var("nb_line_update"));
		dbLog.state().logInsertedLines(dbLog.var("nb_line_inserted"));
	}else if("INSERT_OR_UPDATE".equals(dataAction)){
		dbLog.state().logInsertedLines(dbLog.var("nb_line_inserted"));
		dbLog.state().logUpdatedLines(dbLog.var("nb_line_update"));
	}
	if(rejectConnName != null) {
		dbLog.state().logRejectedLines(dbLog.var("nb_line_rejected"));
	}
	
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(TEXT_220);
    return stringBuffer.toString();
  }
}
