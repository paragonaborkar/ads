package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TAggregateInMainJava
{
  protected static String nl;
  public static synchronized TAggregateInMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateInMainJava result = new TAggregateInMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "                if(log.is";
  protected final String TEXT_3 = "Enabled())";
  protected final String TEXT_4 = NL + "            log.";
  protected final String TEXT_5 = "(\"";
  protected final String TEXT_6 = " - \" ";
  protected final String TEXT_7 = " + (";
  protected final String TEXT_8 = ") ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "    \tclass BytesLimit65535_";
  protected final String TEXT_11 = "{" + NL + "    \t\tpublic void limitLog4jByte() throws Exception{" + NL + "    \t\t\t";
  protected final String TEXT_12 = NL + "            StringBuilder ";
  protected final String TEXT_13 = " = new StringBuilder();";
  protected final String TEXT_14 = NL + "            ";
  protected final String TEXT_15 = ".append(\"Parameters:\");";
  protected final String TEXT_16 = NL + "                    ";
  protected final String TEXT_17 = ".append(\"";
  protected final String TEXT_18 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_19 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_20 = NL + "                    ";
  protected final String TEXT_21 = ".append(\"";
  protected final String TEXT_22 = "\" + \" = \" + ";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "                ";
  protected final String TEXT_25 = ".append(\" | \");";
  protected final String TEXT_26 = NL + "    \t\t}" + NL + "    \t}" + NL + "    \t" + NL + "        new BytesLimit65535_";
  protected final String TEXT_27 = "().limitLog4jByte();";
  protected final String TEXT_28 = NL + "            StringBuilder ";
  protected final String TEXT_29 = " = new StringBuilder();    ";
  protected final String TEXT_30 = NL + "                    ";
  protected final String TEXT_31 = ".append(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "                    if(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = " == null){";
  protected final String TEXT_37 = NL + "                        ";
  protected final String TEXT_38 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_39 = NL + "                        ";
  protected final String TEXT_40 = ".append(";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ");" + NL + "                    }   ";
  protected final String TEXT_43 = NL + "                ";
  protected final String TEXT_44 = ".append(\"|\");";
  protected final String TEXT_45 = NL + "            \t\t\t\t    ";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = " = aggregated_row_";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = ";" + NL + "            \t\t\t\t    ";
  protected final String TEXT_50 = NL + "            \t\t\t\t    String s_";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = "_";
  protected final String TEXT_53 = " = String.valueOf(aggregated_row_";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = ");" + NL + "            \t\t\t\t    ";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = "s_";
  protected final String TEXT_59 = "_";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = "s_";
  protected final String TEXT_62 = "_";
  protected final String TEXT_63 = "_";
  protected final String TEXT_64 = ".getBytes()";
  protected final String TEXT_65 = "(\"null\").equals(s_";
  protected final String TEXT_66 = "_";
  protected final String TEXT_67 = "_";
  protected final String TEXT_68 = ") ? null : ParserUtils.parseTo_Date(s_";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = "_";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ")";
  protected final String TEXT_73 = "ParserUtils.parseTo_";
  protected final String TEXT_74 = "(s_";
  protected final String TEXT_75 = "_";
  protected final String TEXT_76 = "_";
  protected final String TEXT_77 = ")";
  protected final String TEXT_78 = ";" + NL + "            \t\t\t\t    ";
  protected final String TEXT_79 = NL + "                                if(aggregated_row_";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = "_count > 0){" + NL + "                                \t";
  protected final String TEXT_82 = NL + "\t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = " = aggregated_row_";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = "_sum.divide(new BigDecimal(String.valueOf(aggregated_row_";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = "_count)), ";
  protected final String TEXT_89 = ", BigDecimal.ROUND_HALF_UP)" + NL + "\t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_90 = NL + "\t    \t\t\t\t\t\t\t\t\t.";
  protected final String TEXT_91 = "Value()" + NL + "\t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_92 = NL + "\t    \t\t\t\t\t\t\t\t;" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_93 = NL + "\t    \t\t\t\t\t\t\t\tdouble ";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = "_temp = (double) aggregated_row_";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = "_sum / (double) aggregated_row_";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = "_count;" + NL + "\t    \t\t\t\t\t\t\t\t" + NL + "\t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_100 = NL + "\t\t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = " = String.valueOf(";
  protected final String TEXT_103 = "_";
  protected final String TEXT_104 = "_temp);" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = " = (";
  protected final String TEXT_107 = ") ";
  protected final String TEXT_108 = "_";
  protected final String TEXT_109 = "_temp;" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_110 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_111 = NL + "                                } else {" + NL + "                                \t\tString count = \"0\";" + NL + "   \t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_112 = NL + "    \t\t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_113 = ".";
  protected final String TEXT_114 = " = count;" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_115 = NL + "    \t\t    \t\t\t\t\t\t\t";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = " = ParserUtils.parseTo_";
  protected final String TEXT_118 = "(count);" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_119 = NL + "                                }";
  protected final String TEXT_120 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = " = new BigDecimal(aggregated_row_";
  protected final String TEXT_123 = ".count);" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = " = new BigDecimal(aggregated_row_";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = "_clmCount);" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = " = String.valueOf(aggregated_row_";
  protected final String TEXT_130 = ".count);" + NL + "\t    \t\t\t\t\t\t\t\t  ";
  protected final String TEXT_131 = ".";
  protected final String TEXT_132 = " = String.valueOf(aggregated_row_";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = "_clmCount);" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = " = (";
  protected final String TEXT_137 = ") aggregated_row_";
  protected final String TEXT_138 = ".count;" + NL + "\t                                \t";
  protected final String TEXT_139 = ".";
  protected final String TEXT_140 = " = (";
  protected final String TEXT_141 = ") aggregated_row_";
  protected final String TEXT_142 = ".";
  protected final String TEXT_143 = "_clmCount;" + NL + "\t                                \t";
  protected final String TEXT_144 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = " = new BigDecimal(aggregated_row_";
  protected final String TEXT_147 = ".distinctValues_";
  protected final String TEXT_148 = ".size());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_149 = ".";
  protected final String TEXT_150 = " = String.valueOf(aggregated_row_";
  protected final String TEXT_151 = ".distinctValues_";
  protected final String TEXT_152 = ".size());" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_153 = ".";
  protected final String TEXT_154 = " = (";
  protected final String TEXT_155 = ") aggregated_row_";
  protected final String TEXT_156 = ".distinctValues_";
  protected final String TEXT_157 = ".size();" + NL + "\t                                \t";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = " = String.valueOf(aggregated_row_";
  protected final String TEXT_160 = ".";
  protected final String TEXT_161 = "_";
  protected final String TEXT_162 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_163 = NL + "    \t\t\t\t\t\t\t\tif(aggregated_row_";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = "_";
  protected final String TEXT_166 = " != null) {" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_167 = ".";
  protected final String TEXT_168 = " = aggregated_row_";
  protected final String TEXT_169 = ".";
  protected final String TEXT_170 = "_";
  protected final String TEXT_171 = ".";
  protected final String TEXT_172 = "Value();" + NL + "\t\t\t\t\t\t\t\t\t\t" + NL + "    \t\t\t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_173 = NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_174 = ".";
  protected final String TEXT_175 = " = null;" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_176 = NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_177 = ".";
  protected final String TEXT_178 = " = 0;" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_179 = NL + "    \t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_180 = ".";
  protected final String TEXT_181 = " = aggregated_row_";
  protected final String TEXT_182 = ".";
  protected final String TEXT_183 = "_";
  protected final String TEXT_184 = ";" + NL + "                                \t";
  protected final String TEXT_185 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_186 = ".";
  protected final String TEXT_187 = " = aggregated_row_";
  protected final String TEXT_188 = ".";
  protected final String TEXT_189 = "_";
  protected final String TEXT_190 = ".toString();" + NL + "\t    \t\t\t\t\t\t";
  protected final String TEXT_191 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_192 = ".";
  protected final String TEXT_193 = " = aggregated_row_";
  protected final String TEXT_194 = ".";
  protected final String TEXT_195 = "_";
  protected final String TEXT_196 = ";" + NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_197 = "double result_";
  protected final String TEXT_198 = "_";
  protected final String TEXT_199 = "_";
  protected final String TEXT_200 = " = utilClass_";
  protected final String TEXT_201 = ".sd(aggregated_row_";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = "_";
  protected final String TEXT_204 = ".toArray(new Double[0]));" + NL + "\t\t    \t\t\t\t\t\t\tif(((Double)result_";
  protected final String TEXT_205 = "_";
  protected final String TEXT_206 = "_";
  protected final String TEXT_207 = ").equals((Double)Double.NaN)) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_208 = ".";
  protected final String TEXT_209 = " = null;" + NL + "\t\t    \t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = " = new BigDecimal(result_";
  protected final String TEXT_212 = "_";
  protected final String TEXT_213 = "_";
  protected final String TEXT_214 = ");" + NL + "\t\t    \t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_215 = ".";
  protected final String TEXT_216 = " = (";
  protected final String TEXT_217 = ") utilClass_";
  protected final String TEXT_218 = ".sd(aggregated_row_";
  protected final String TEXT_219 = ".";
  protected final String TEXT_220 = "_";
  protected final String TEXT_221 = ".toArray(new Double[0]));" + NL + "\t    \t\t\t\t\t\t\t\t";
  protected final String TEXT_222 = ".";
  protected final String TEXT_223 = " = String.valueOf(utilClass_";
  protected final String TEXT_224 = ".sd(aggregated_row_";
  protected final String TEXT_225 = ".";
  protected final String TEXT_226 = "_";
  protected final String TEXT_227 = ".toArray(new Double[0])));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_228 = NL + "                                ";
  protected final String TEXT_229 = ".";
  protected final String TEXT_230 = " = aggregated_row_";
  protected final String TEXT_231 = ".";
  protected final String TEXT_232 = "_";
  protected final String TEXT_233 = ";";
  protected final String TEXT_234 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_3);
    
            }
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_6);
    for(String message : messages){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
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
    
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
       			 if(log4jEnabled){
       			 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_15);
    
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
                    
    stringBuffer.append(TEXT_16);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_19);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    
    stringBuffer.append(TEXT_20);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_23);
    
                }   
                
    stringBuffer.append(TEXT_24);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_25);
    
            }
        }
		debug(var("log4jParamters"));
		
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_28);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_29);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_30);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_33);
    
                }else{
                
    stringBuffer.append(TEXT_34);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_42);
    
                }
                
    stringBuffer.append(TEXT_43);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_44);
    
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

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
log = new LogUtil(node);
String origin = ElementParameterParser.getValue(node, "__ORIGIN__");
String cid = origin;

boolean useFinancialPrecision = "true".equals(ElementParameterParser.getValue(node, "__USE_FINANCIAL_PRECISION__"));

String SUM = "sum";
String COUNT = "count";
String MAX = "max";
String MIN = "min";
String FIRST = "first";
String LAST = "last";
String AVG = "avg";
String COUNT_DISTINCT = "distinct";
String UNION = "union";
String LIST = "list";
String LIST_OBJECT = "list_object";
String STD_DEV = "std_dev";

List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
int sizeOperations = operations.size();
java.util.Map<String,IMetadataColumn> inputValuesColumns = new java.util.HashMap<String,IMetadataColumn>();
IConnection inputConn = null;
IMetadataTable inputMetadataTable = null;
java.util.List<IMetadataColumn> inputColumns = null;



String searchedComponentName = cid + "_AGGOUT";
List<? extends IConnection> incomingConnections = null;
List<? extends INode> generatedNodes = node.getProcess().getGeneratingNodes();
for(INode loopNode : generatedNodes) {
	if(loopNode.getUniqueName().equals(searchedComponentName)) {
		incomingConnections = (List<IConnection>) loopNode.getIncomingConnections();
		break;
	}
}

if (incomingConnections != null && !incomingConnections.isEmpty()) {
	for (IConnection conn : incomingConnections) {
		inputConn = conn;
		inputMetadataTable = conn.getMetadataTable();
		inputColumns = inputMetadataTable.getListColumns();
		break;
	}
}
if(inputColumns != null) { // T_AggR_144
	for (IMetadataColumn column: inputColumns) { // T_AggR_145

		for(int i = 0; i < sizeOperations; i++){ // T_AggR_713
			String columnname = operations.get(i).get("INPUT_COLUMN");
        	if(column.getLabel().equals(columnname)){ // T_AggR_714
       			inputValuesColumns.put(columnname, column);
				break;
       		} // T_AggR_714
		} // T_AggR_713
				
	} // T_AggR_145
} // T_AggR_144



List<IMetadataTable> mestadataTableListOut = node.getMetadataList();

if (mestadataTableListOut!=null && mestadataTableListOut.size()>0) { // T_InMain_AggR_600
    IMetadataTable metadataTableOutput = mestadataTableListOut.get(0);
    if (metadataTableOutput!=null) { // T_InMain_AggR_601
        List<Map<String, String>> groupbys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
		int sizeGroupbys = groupbys.size();
		
		IConnection outputConn = null;
		List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
		if (outConns!=null) {
			if (outConns.size()>0) {
				IConnection conn = outConns.get(0);
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					outputConn = conn;    					
				}
			}
		}
		//fix bug 22089,if only choose iterator,the NPE will not occured.
		if(outputConn!=null){ // T_InMain_AggR_602
		List<IMetadataColumn> outputColumns = metadataTableOutput.getListColumns();
		int sizeColumns = outputColumns.size();
		if(sizeOperations > 0 || sizeGroupbys > 0){ // T_InMain_AggR_603

    			next_column:
    			for(int c = 0; c < sizeColumns; c++){ // T_InMain_AggR_604
    				IMetadataColumn outputColumn = outputColumns.get(c);
    				String outputColumnName = outputColumn.getLabel();
    				String outputTypeToGenerate = JavaTypesManager.getTypeToGenerate(outputColumn.getTalendType(), outputColumn.isNullable());
    				String primitiveOutputType = JavaTypesManager.getTypeToGenerate(outputColumn.getTalendType(), false);
    				JavaType outputJavaType = JavaTypesManager.getJavaTypeFromId(outputColumn.getTalendType());
    				String patternValue = outputColumn.getPattern() == null || outputColumn.getPattern().trim().length() == 0 ? null : outputColumn.getPattern();
    				
    				JavaType inputJavaType = null;
    				
    				for(int g = 0; g < sizeGroupbys; g++){ // T_InMain_AggR_605
    					Map<String, String> groupby = groupbys.get(g);
    					String inputColumn = groupby.get("INPUT_COLUMN");
    					String outputGroupColumn = groupby.get("OUTPUT_COLUMN");
    					if(outputGroupColumn.equals(outputColumnName)){ // T_InMain_AggR_606
    						Boolean sameType = false;
                			
            				if (incomingConnections != null && !incomingConnections.isEmpty()) {
            					loop:
            					for (IConnection conn : incomingConnections) {
            						IMetadataTable inMetadata = conn.getMetadataTable();
            						for (IMetadataColumn inColumn: inMetadata.getListColumns()) {
            							if(inColumn.getLabel().equals(inputColumn)){
            								inputJavaType = JavaTypesManager.getJavaTypeFromId(inColumn.getTalendType());
            								sameType = (inputJavaType == outputJavaType);
            								if(!sameType && inColumn.getTalendType().equals("id_Dynamic") && outputColumn.getTalendType().equals("id_Dynamic")) {
            									sameType = true;
            								}
            								break loop;
            							}
            						}
                				}
            				}
            				if(sameType){
            				    
    stringBuffer.append(TEXT_45);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_49);
      					
            				}else{
            				    
    stringBuffer.append(TEXT_50);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_57);
    
    							if(outputJavaType == JavaTypesManager.STRING || outputJavaType == JavaTypesManager.OBJECT) {
    								
    stringBuffer.append(TEXT_58);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    
    							}else if(outputJavaType == JavaTypesManager.BYTE_ARRAY){
    								
    stringBuffer.append(TEXT_61);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    
    							} else if(outputJavaType == JavaTypesManager.DATE) {
    								
    stringBuffer.append(TEXT_65);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_72);
    
    							} else {
    								
    stringBuffer.append(TEXT_73);
    stringBuffer.append( outputTypeToGenerate );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(outputGroupColumn );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    
    							}
            				    
    stringBuffer.append(TEXT_78);
    
    						}
    						continue next_column;
    					} // T_InMain_AggR_606
    				} // T_InMain_AggR_605
				
    				for(int o = 0; o < sizeOperations; o++){ // T_InMain_AggR_615
    					Map<String, String> operation = operations.get(o);
                		String function = operation.get("FUNCTION");
                		String outOperation = operation.get("OUTPUT_COLUMN");
                		String inOperation = operation.get("INPUT_COLUMN");
						boolean ignoreNull = ("true").equals(operation.get("IGNORE_NULL"));

                		if(outOperation.equals(outputColumnName)){ // T_InMain_AggR_616

							IMetadataColumn inputColumn = inputValuesColumns.get(inOperation);
							inputJavaType = JavaTypesManager.getJavaTypeFromId(inputColumn.getTalendType());

							boolean outputIsNumber = JavaTypesManager.isNumberType(outputJavaType, false);
							boolean outputIsObject = outputJavaType == JavaTypesManager.OBJECT;
							boolean outputIsGeometry = false;
							boolean inputIsGeometry = false;
							try {
								outputIsGeometry = outputJavaType == JavaTypesManager.getJavaTypeFromId("id_Geometry");
							} catch (IllegalArgumentException e) {
							}
							boolean outputIsList = outputJavaType == JavaTypesManager.LIST;
							boolean outputIsString = outputJavaType == JavaTypesManager.STRING;
							boolean outputIsBigDecimal = outputJavaType == JavaTypesManager.BIGDECIMAL;
							boolean outputIsDate = outputJavaType == JavaTypesManager.DATE;
							boolean outputIsLong = outputJavaType == JavaTypesManager.LONG;
							boolean outputIsDecimal = outputJavaType == JavaTypesManager.FLOAT || outputJavaType == JavaTypesManager.DOUBLE || outputIsBigDecimal;
							boolean inputIsNumber = JavaTypesManager.isNumberType(inputJavaType, false);
							boolean inputIsObject = inputJavaType == JavaTypesManager.OBJECT;
							try {
								inputIsGeometry = inputJavaType == JavaTypesManager.getJavaTypeFromId("id_Geometry");
							} catch (IllegalArgumentException e) {
							}
							boolean inputIsBoolean = inputJavaType == JavaTypesManager.BOOLEAN;
							boolean inputIsList = inputJavaType == JavaTypesManager.LIST;
							boolean inputIsString = inputJavaType == JavaTypesManager.STRING;
							boolean inputIsDate = inputJavaType == JavaTypesManager.DATE;
							boolean inputIsBigDecimal = inputJavaType == JavaTypesManager.BIGDECIMAL;
							boolean inputIsByteArray = inputJavaType == JavaTypesManager.BYTE_ARRAY;
							boolean inputIsDecimal = inputJavaType == JavaTypesManager.FLOAT || inputJavaType == JavaTypesManager.DOUBLE || inputIsBigDecimal;
				
							boolean forceUseBigDecimal = 
								(function.equals(SUM) || function.equals(AVG)) 
								&& inputIsDecimal
								&& outputIsDecimal
								&& useFinancialPrecision
							;
							if(AVG.equals(function) && !forceUseBigDecimal) {
								forceUseBigDecimal = outputIsLong;
							}
							boolean sameInOutType = outputJavaType == inputJavaType;
					
							boolean isValidTypeForOperation = 
								(function.equals(SUM) || function.equals(AVG)) && inputIsNumber && outputIsNumber
								|| function.equals(MIN) && sameInOutType && !inputIsList && !inputIsByteArray && !inputIsBoolean 
								|| function.equals(MAX) && sameInOutType && !inputIsList && !inputIsByteArray && !inputIsBoolean
								|| function.equals(FIRST) && sameInOutType
								|| function.equals(LAST) && sameInOutType
								|| function.equals(LIST) && outputIsString
								|| function.equals(UNION) && outputIsGeometry
								|| function.equals(LIST_OBJECT) && outputIsList
								|| function.equals(COUNT) && outputIsNumber
								|| function.equals(COUNT_DISTINCT) && outputIsNumber
								|| function.equals(STD_DEV) && inputIsNumber && outputIsNumber
							;
	
							if(!isValidTypeForOperation) {
								continue;
							}
            				
                			if(function.equals(AVG)){ // T_InMain_AggR_617
                			
                				int pre = 10;
                       		 	Integer precision = outputColumn.getPrecision();
                           		 if(precision!=null && precision!=0) { 
                           		 	pre = precision;
                           		 }               				

                			    
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_81);
    
									if(outputIsBigDecimal || forceUseBigDecimal) {
									
    stringBuffer.append(TEXT_82);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(pre );
    stringBuffer.append(TEXT_89);
     if(!outputIsBigDecimal) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(primitiveOutputType);
    stringBuffer.append(TEXT_91);
     } 
    stringBuffer.append(TEXT_92);
    
									} else {
									
    stringBuffer.append(TEXT_93);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_99);
     
	    								if(outputIsString) {
	    								
		    								
    stringBuffer.append(TEXT_100);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_102);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_104);
    
											
										} else {
		    							
		    								
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(primitiveOutputType);
    stringBuffer.append(TEXT_107);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_109);
    
										
										}
										
    stringBuffer.append(TEXT_110);
    
    								}
    								
    stringBuffer.append(TEXT_111);
     
    	    								if(outputIsString) {
    		    						
    stringBuffer.append(TEXT_112);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_114);
    
    										} else {
    		    						
    stringBuffer.append(TEXT_115);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_117);
    stringBuffer.append( outputTypeToGenerate );
    stringBuffer.append(TEXT_118);
    
    										}
    									
    stringBuffer.append(TEXT_119);
    
                			}  // T_InMain_AggR_617
                			else if(function.equals(COUNT)) { // T_InMain_AggR_638
                			
								if(outputIsBigDecimal) {
								
    stringBuffer.append(TEXT_120);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_127);
    
								} else {
            			
									if(outputIsString) {
									
	    								
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_134);
    
										
									} else {
	    							
	                                	
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(primitiveOutputType);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(primitiveOutputType);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_143);
    
									
									}
								}

							} // T_InMain_AggR__638
                			else if(function.equals(COUNT_DISTINCT)) { // T_InMain_AggR_658
                			
								if(outputIsBigDecimal) {
								
    stringBuffer.append(TEXT_144);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_148);
    
								} else {
            			
									if(outputIsString) {
									
	    								
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_152);
    
										
									} else {
	    							
	                                	
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(primitiveOutputType);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_157);
    
									
									}
								}

							} // T_InMain_AggR__638
                			else if(function.equals(SUM)) { // T_InMain_AggR_618

								if(outputIsString) {
								
    								
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_162);
    
									
								} else if(forceUseBigDecimal && !outputIsBigDecimal) {

    								
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_166);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(primitiveOutputType);
    stringBuffer.append(TEXT_172);
    
    									if(!JavaTypesManager.isJavaPrimitiveType(outputJavaType, outputColumn.isNullable())){// is Object
    stringBuffer.append(TEXT_173);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_175);
    
    									}else{
    stringBuffer.append(TEXT_176);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_178);
    }
    stringBuffer.append(TEXT_179);
    
								
								} else {
    							
                                	
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_184);
    
								
								}
									
    						} // T_InMain_AggR_618 
    						else if(function.equals(LIST)) { // T_InMain_AggR_679
    							
    stringBuffer.append(TEXT_185);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_190);
     
    						}  // T_InMain_AggR_679
    						else if(("list_object").equals(function)) { // T_InMain_AggR_619
    							
    stringBuffer.append(TEXT_191);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_196);
     
    						}  // T_InMain_AggR_619
    						else if(function.equals(STD_DEV)) { // T_InMain_AggR_620
    						
    						
    							if(outputIsNumber || outputIsObject){ // T_InMain_AggR_621

									if(outputIsBigDecimal) {
										
		    							
    stringBuffer.append(TEXT_197);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_209);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    
										
									} else {
	            			
	    								
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(primitiveOutputType);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_221);
    
    								 		
									}

    							} // T_InMain_AggR_621
    							
    							else if(outputIsString){ // T_InMain_AggR_622
								
									
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_227);
    
									
    							} // T_InMain_AggR_622
    							
    						} // T_InMain_AggR_620
    						
    						else { // T_InMain_AggR_636
    							
								
    stringBuffer.append(TEXT_228);
    stringBuffer.append( outputConn.getName() );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_233);
    
                                
    							
    						} // T_InMain_AggR_636
							log.debug(log.str("Operation function: '" + function + "' on the column '" + inOperation + "'."));
                			continue next_column;                			
                		} // T_InMain_AggR_616

                		
                } // T_InMain_AggR_615
    		
    		} // T_InMain_AggR_604

		} // T_InMain_AggR_603
	  } // T_InMain_AggR_602
	} // T_InMain_AggR_601
} // T_InMain_AggR_600

    stringBuffer.append(TEXT_234);
    return stringBuffer.toString();
  }
}
