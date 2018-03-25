package org.talend.designer.codegen.translators.databases.amazon.oracle;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;

public class TAmazonOracleOutputEndJava
{
  protected static String nl;
  public static synchronized TAmazonOracleOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAmazonOracleOutputEndJava result = new TAmazonOracleOutputEndJava();
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
  protected final String TEXT_47 = NL + "\t     \t// TODO unable to parse integer: ";
  protected final String TEXT_48 = NL + "\t     \t// TODO error: ";
  protected final String TEXT_49 = NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\tjava.sql.Statement stmtCreateGeoColumns_";
  protected final String TEXT_51 = " = conn_";
  protected final String TEXT_52 = ".createStatement();" + NL + "" + NL + "\t\t// Delete geometry columns entry if already exists." + NL + "\t\tString deleteGeometryColumns_";
  protected final String TEXT_53 = " = \"DELETE FROM user_sdo_geom_metadata \"" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t+ \"WHERE TABLE_NAME='\" + ";
  protected final String TEXT_54 = " + \"'\";" + NL + "\t\t";
  protected final String TEXT_55 = NL + "\t\tstmtCreateGeoColumns_";
  protected final String TEXT_56 = ".execute(deleteGeometryColumns_";
  protected final String TEXT_57 = ");" + NL + "\t\t";
  protected final String TEXT_58 = NL + NL + "\t\tfor (String column: geometryColumnToExtends.keySet()) {" + NL + "\t\t    com.vividsolutions.jts.geom.Envelope extend = geometryColumnToExtends.get(column);" + NL + "" + NL + "\t\t\t// Create new entry in geometry columns table" + NL + "\t        String insertGeometryColumns_";
  protected final String TEXT_59 = " = \"INSERT INTO user_sdo_geom_metadata (TABLE_NAME, COLUMN_NAME, DIMINFO, SRID) VALUES ('\"" + NL + "\t        \t\t\t\t\t\t\t\t\t\t+ ";
  protected final String TEXT_60 = " + \"','\" + column.toUpperCase(java.util.Locale.US) + \"', \"" + NL + "\t        \t\t\t\t\t\t\t\t\t\t+ \"MDSYS.SDO_DIM_ARRAY(MDSYS.SDO_DIM_ELEMENT('x', \" + extend.getMinX() + \", \" + extend.getMaxX() + \", ";
  protected final String TEXT_61 = "), \"" + NL + "\t        \t\t\t\t\t\t\t\t\t\t+ \"MDSYS.SDO_DIM_ELEMENT('y', \" + extend.getMinY() + \", \" + extend.getMaxY() + \", ";
  protected final String TEXT_62 = ")), \"" + NL + "\t        \t\t\t\t\t\t\t\t\t\t+ ";
  protected final String TEXT_63 = " +\")\";" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t    \tstmtCreateGeoColumns_";
  protected final String TEXT_65 = ".execute(insertGeometryColumns_";
  protected final String TEXT_66 = ");" + NL + "\t    \t";
  protected final String TEXT_67 = NL + "    \t}" + NL + "" + NL + "        stmtCreateGeoColumns_";
  protected final String TEXT_68 = ".close();" + NL + "\t\t";
  protected final String TEXT_69 = NL + "\t\tfor (String geometryColumnName: geometryColumnToExtends.keySet()) {" + NL + "" + NL + "\t\t\tString index_name = \"spatialidx_\"+";
  protected final String TEXT_70 = "+\"_\" + geometryColumnName;" + NL + "\t\t\tif (index_name.length() > 30) {" + NL + "\t\t\t\tindex_name = index_name.substring(0, 29);" + NL + "\t\t\t}" + NL + "" + NL + "\t    \tjava.sql.Statement stmtCreateIndex_";
  protected final String TEXT_71 = " = conn_";
  protected final String TEXT_72 = ".createStatement();" + NL + "\t\t\t// Drop spatial index if exists" + NL + "\t\t\tString dropIndex_";
  protected final String TEXT_73 = " = \"DROP INDEX \"+index_name;" + NL + "\t        try {" + NL + "\t        \t";
  protected final String TEXT_74 = NL + "\t\t\t\tstmtCreateIndex_";
  protected final String TEXT_75 = ".execute(dropIndex_";
  protected final String TEXT_76 = ");" + NL + "        \t\t";
  protected final String TEXT_77 = NL + "\t\t\t}" + NL + "\t\t\tcatch (java.sql.SQLException e) {" + NL + "\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t}" + NL + "" + NL + "\t\t\t// Create spatial index using GIST on geometry columns" + NL + "\t\t\tString createIndex_";
  protected final String TEXT_79 = " = \"CREATE INDEX \"+index_name + \" \"" + NL + "\t\t\t\t\t\t+ \"ON \" + ";
  protected final String TEXT_80 = " + \"(\" + geometryColumnName + \") \"" + NL + "\t\t\t\t\t\t+ \"INDEXTYPE IS MDSYS.SPATIAL_INDEX\";" + NL + "\t\t\t";
  protected final String TEXT_81 = NL + "\t        stmtCreateIndex_";
  protected final String TEXT_82 = ".execute(createIndex_";
  protected final String TEXT_83 = ");" + NL + "\t        ";
  protected final String TEXT_84 = NL + "\t        stmtCreateIndex_";
  protected final String TEXT_85 = ".close();" + NL + "\t    }" + NL + "\t\t";
  protected final String TEXT_86 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_87 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_88 = ".close();" + NL + "" + NL + "        }" + NL + "        if(pstmtInsert_";
  protected final String TEXT_89 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_90 = ".close();" + NL + "" + NL + "        }" + NL + "        if(pstmt_";
  protected final String TEXT_91 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_92 = ".close();" + NL + "" + NL + "        }";
  protected final String TEXT_93 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_94 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_95 = ".close();" + NL + "" + NL + "        }" + NL + "        if(pstmtInsert_";
  protected final String TEXT_96 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_97 = ".close();" + NL + "" + NL + "        }";
  protected final String TEXT_98 = NL + "                if(batchSizeCounter_";
  protected final String TEXT_99 = " > 0){" + NL + "                try {" + NL + "                \tif (pstmt_";
  protected final String TEXT_100 = " != null) {" + NL + "                \t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\tpstmt_";
  protected final String TEXT_102 = ".executeBatch();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_103 = NL + "            \t    }" + NL + "                }catch (java.sql.BatchUpdateException e){" + NL + "                \t";
  protected final String TEXT_104 = NL + "                \t\tthrow(e);" + NL + "                \t";
  protected final String TEXT_105 = NL + "                \tSystem.err.println(e.getMessage());" + NL + "                \t";
  protected final String TEXT_106 = NL + "            \t}" + NL + "            \tif (pstmt_";
  protected final String TEXT_107 = " != null) {" + NL + "\t            \ttmp_batchUpdateCount_";
  protected final String TEXT_108 = " = pstmt_";
  protected final String TEXT_109 = ".getUpdateCount();" + NL + "\t    \t    \t";
  protected final String TEXT_110 = NL + "\t    \t    \t\tinsertedCount_";
  protected final String TEXT_111 = NL + "\t    \t    \t";
  protected final String TEXT_112 = NL + "\t    \t    \t\tupdatedCount_";
  protected final String TEXT_113 = NL + "\t    \t    \t";
  protected final String TEXT_114 = NL + "\t    \t    \t    deletedCount_";
  protected final String TEXT_115 = NL + "\t    \t    \t";
  protected final String TEXT_116 = NL + "\t    \t    \t+= (tmp_batchUpdateCount_";
  protected final String TEXT_117 = "!=-1?tmp_batchUpdateCount_";
  protected final String TEXT_118 = ":0);" + NL + "                }" + NL + "            }";
  protected final String TEXT_119 = NL + "\t\t\t        if(pstmt_";
  protected final String TEXT_120 = " != null) {" + NL + "\t\t\t\t\t\tpstmt_";
  protected final String TEXT_121 = ".close();" + NL + "\t\t\t        }";
  protected final String TEXT_122 = NL;
  protected final String TEXT_123 = NL + "\t\t    if (commitCounter_";
  protected final String TEXT_124 = " > 0 ) {" + NL + "    \t\t    ";
  protected final String TEXT_125 = NL + "    \t\t    conn_";
  protected final String TEXT_126 = ".commit();" + NL + "    \t\t    ";
  protected final String TEXT_127 = NL + "\t\t    }" + NL + "\t\t    ";
  protected final String TEXT_128 = NL + "\t\t";
  protected final String TEXT_129 = NL + "    \tconn_";
  protected final String TEXT_130 = " .close();" + NL + "    \t";
  protected final String TEXT_131 = NL + "    \tresourceMap.put(\"finish_";
  protected final String TEXT_132 = "\", true);" + NL + "    \t";
  protected final String TEXT_133 = NL;
  protected final String TEXT_134 = NL + "\tnb_line_deleted_";
  protected final String TEXT_135 = "=nb_line_deleted_";
  protected final String TEXT_136 = "+ deletedCount_";
  protected final String TEXT_137 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_138 = "=nb_line_update_";
  protected final String TEXT_139 = " + updatedCount_";
  protected final String TEXT_140 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_141 = "=nb_line_inserted_";
  protected final String TEXT_142 = " + insertedCount_";
  protected final String TEXT_143 = ";" + NL + "\tnb_line_rejected_";
  protected final String TEXT_144 = "=nb_line_rejected_";
  protected final String TEXT_145 = " + rejectedCount_";
  protected final String TEXT_146 = ";" + NL + "\t";
  protected final String TEXT_147 = NL + "    \tif (globalMap.get(\"";
  protected final String TEXT_148 = "_NB_LINE\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_149 = "_NB_LINE\",nb_line_";
  protected final String TEXT_150 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_151 = "_NB_LINE\",(Integer)globalMap.get(\"";
  protected final String TEXT_152 = "_NB_LINE\") + nb_line_";
  protected final String TEXT_153 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_154 = "_NB_LINE_UPDATED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_155 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_156 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_157 = "_NB_LINE_UPDATED\",(Integer)globalMap.get(\"";
  protected final String TEXT_158 = "_NB_LINE_UPDATED\") + nb_line_update_";
  protected final String TEXT_159 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_160 = "_NB_LINE_INSERTED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_161 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_162 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_163 = "_NB_LINE_INSERTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_164 = "_NB_LINE_INSERTED\") + nb_line_inserted_";
  protected final String TEXT_165 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_166 = "_NB_LINE_DELETED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_167 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_168 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_169 = "_NB_LINE_DELETED\",(Integer)globalMap.get(\"";
  protected final String TEXT_170 = "_NB_LINE_DELETED\") + nb_line_deleted_";
  protected final String TEXT_171 = ");" + NL + "        }" + NL + "        if (globalMap.get(\"";
  protected final String TEXT_172 = "_NB_LINE_REJECTED\") == null) {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_173 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_174 = ");" + NL + "        } else {" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_175 = "_NB_LINE_REJECTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_176 = "_NB_LINE_REJECTED\") + nb_line_rejected_";
  protected final String TEXT_177 = ");" + NL + "        }" + NL + "\t";
  protected final String TEXT_178 = NL + "        globalMap.put(\"";
  protected final String TEXT_179 = "_NB_LINE\",nb_line_";
  protected final String TEXT_180 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_181 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_182 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_183 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_184 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_185 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_186 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_187 = "_NB_LINE_REJECTED\", nb_line_rejected_";
  protected final String TEXT_188 = ");" + NL + "    " + NL + "\t";
  protected final String TEXT_189 = NL;

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

	String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");

	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");

	String dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");

	String tableName = ElementParameterParser.getValue(node,"__TABLE__");

	String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");

	boolean useSpatialOptions = ("true").equals(ElementParameterParser.getValue(node,"__USE_SPATIAL_OPTIONS__"));

	boolean createSpatialIndex = ("true").equals(ElementParameterParser.getValue(node,"__SPATIAL_INDEX__"));

	String indexAccuracy = ElementParameterParser.getValue(node, "__SPATIAL_INDEX_ACCURACY__");

	String useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
    String batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
    String useBatchAndUseConn = ElementParameterParser.getValue(node,"__USE_BATCH_AND_USE_CONN__");

    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    boolean isUseBatchByDBVersion = (!useExistingConnection && !"ORACLE_8".equalsIgnoreCase(dbVersion)) || (useExistingConnection && !"ORACLE_8".equalsIgnoreCase(NodeUtil.getNodeByUniqueName(node.getProcess(), connection).getUniqueName()));

    boolean useBatch = true;
    if(useExistingConnection){
        useBatch = rejectConnName == null && isUseBatchByDBVersion && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) && ("true").equals(useBatchAndUseConn);
    }else{
        useBatch = rejectConnName == null && isUseBatchByDBVersion && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) && ("true").equals(useBatchSize);
    }

    if (useSpatialOptions && (("DROP_CREATE").equals(tableAction) || ("CREATE").equals(tableAction)
    		|| ("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction))) {

	    int targetSRID = -1;
	    try {
	      	targetSRID = Integer.parseInt(ElementParameterParser.getValue(node,"__SRID__"));
	    }
	    catch (NumberFormatException e) {
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(ElementParameterParser.getValue(node,"__SRID__"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(e.getMessage());
    stringBuffer.append(TEXT_49);
    
	     	e.printStackTrace();
	    }
		
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(tableName.toUpperCase(java.util.Locale.US) );
    stringBuffer.append(TEXT_54);
    dbLog.data().sqlExecuteTry(dbLog.var("deleteGeometryColumns"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    dbLog.data().sqlExecuteDone(dbLog.var("deleteGeometryColumns"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(tableName.toUpperCase(java.util.Locale.US) );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(indexAccuracy );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(indexAccuracy );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(targetSRID < 0 ? "\"NULL\"" : targetSRID );
    stringBuffer.append(TEXT_63);
    dbLog.data().sqlExecuteTry(dbLog.var("insertGeometryColumns"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    dbLog.data().sqlExecuteDone(dbLog.var("insertGeometryColumns"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
	}
	if (createSpatialIndex && useSpatialOptions) {
		
    stringBuffer.append(TEXT_69);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    dbLog.data().sqlExecuteTry(dbLog.var("dropIndex"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    dbLog.data().sqlExecuteDone(dbLog.var("dropIndex"));
    stringBuffer.append(TEXT_77);
    dbLog.logIgnoredException("e.getMessage()");
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_80);
    dbLog.data().sqlExecuteTry(dbLog.var("createIndex"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    dbLog.data().sqlExecuteDone(dbLog.var("createIndex"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
	}

    if(("INSERT_OR_UPDATE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    
    } else if(("UPDATE_OR_INSERT").equals(dataAction)) {
        
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    
    } else { // dataAction equals "INSERT" or "UPDATE" or "DELETE"
        
    
              if(useBatch){
            
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    stringBuffer.append(TEXT_103);
    if(("true").equals(dieOnError)) {
                	
    stringBuffer.append(TEXT_104);
    
                	}else {
                	dbLog.logPrintedException("e.getMessage()");
                	
    stringBuffer.append(TEXT_105);
    
                	}
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    if (("INSERT").equals(dataAction)) {
	    	    	
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
	    	    	}else if (("UPDATE").equals(dataAction)) {
	    	    	
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
	    	    	}else if (("DELETE").equals(dataAction)) {
	    	    	
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
	    	    	}
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
     } 
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    
        }
    
    stringBuffer.append(TEXT_122);
    
	if(!useExistingConnection)
	{
		if(!("").equals(commitEvery) && !("0").equals(commitEvery))
		{
		    
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    dbLog.commit().commitTry(null, dbLog.var("commitCounter"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    dbLog.commit().commitDone(null);
    stringBuffer.append(TEXT_127);
    
		}
		
    stringBuffer.append(TEXT_128);
    dbLog.conn().closeTry(null);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    dbLog.conn().closeDone(null);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
	}
    
    stringBuffer.append(TEXT_133);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
	boolean isEnableParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	if (isEnableParallelize) {
	
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
	} else {
	
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
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
	
    stringBuffer.append(TEXT_189);
    return stringBuffer.toString();
  }
}
