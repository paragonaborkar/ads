package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TFileInputLDIFBeginJava
{
  protected static String nl;
  public static synchronized TFileInputLDIFBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputLDIFBeginJava result = new TFileInputLDIFBeginJava();
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
  protected final String TEXT_30 = NL + "\t";
  protected final String TEXT_31 = NL + "///////////////////////////////////" + NL + "\t\tjava.io.DataInputStream dis_";
  protected final String TEXT_32 = " = null;" + NL + "" + NL + "        String[] filters_";
  protected final String TEXT_33 = " = new String[] {         ";
  protected final String TEXT_34 = " " + NL + "\t\t\"";
  protected final String TEXT_35 = "\",";
  protected final String TEXT_36 = "        " + NL + "        };" + NL + "        " + NL + "        String[] filters_binary_";
  protected final String TEXT_37 = " = new String[] {         ";
  protected final String TEXT_38 = " " + NL + "\t\t\"";
  protected final String TEXT_39 = ";binary\",";
  protected final String TEXT_40 = "        " + NL + "        };" + NL + "        " + NL + "        String[] results_";
  protected final String TEXT_41 = " = null;" + NL + "\t\tList<List<byte[]>> resultsBinary_";
  protected final String TEXT_42 = " = null;" + NL + "        int nb_line_";
  protected final String TEXT_43 = " = 0;" + NL + "        " + NL + "        ///////////////////////////////////" + NL + "     \t";
  protected final String TEXT_44 = NL + "      " + NL + "\t  try{" + NL + "\t  \tdis_";
  protected final String TEXT_45 = "=new java.io.DataInputStream(new java.io.FileInputStream(";
  protected final String TEXT_46 = "));" + NL + "        netscape.ldap.util.LDIF ldif_";
  protected final String TEXT_47 = " = new netscape.ldap.util.LDIF(dis_";
  protected final String TEXT_48 = ");" + NL + "        for (netscape.ldap.util.LDIFRecord record_";
  protected final String TEXT_49 = " = ldif_";
  protected final String TEXT_50 = ".nextRecord(); record_";
  protected final String TEXT_51 = " != null; record_";
  protected final String TEXT_52 = " = ldif_";
  protected final String TEXT_53 = ".nextRecord()) {" + NL + "" + NL + "            results_";
  protected final String TEXT_54 = " = new String[";
  protected final String TEXT_55 = "];" + NL + "            resultsBinary_";
  protected final String TEXT_56 = " =  new java.util.ArrayList<List<byte[]>>();" + NL + "            " + NL + "            netscape.ldap.util.LDIFContent content_";
  protected final String TEXT_57 = " = record_";
  protected final String TEXT_58 = ".getContent();" + NL + "\t\t\tnetscape.ldap.LDAPAttribute[] attributes_";
  protected final String TEXT_59 = " = null;" + NL + "\t\t\t" + NL + "            switch (content_";
  protected final String TEXT_60 = ".getType()) {" + NL + "            " + NL + "            case netscape.ldap.util.LDIFContent.ATTRIBUTE_CONTENT:" + NL + "            " + NL + "                netscape.ldap.util.LDIFAttributeContent attrContent_";
  protected final String TEXT_61 = " = (netscape.ldap.util.LDIFAttributeContent) content_";
  protected final String TEXT_62 = ";" + NL + "                attributes_";
  protected final String TEXT_63 = " = attrContent_";
  protected final String TEXT_64 = ".getAttributes();" + NL + "                " + NL + "                for (int i_";
  protected final String TEXT_65 = " = 0; i_";
  protected final String TEXT_66 = " < filters_";
  protected final String TEXT_67 = ".length; i_";
  protected final String TEXT_68 = "++) {" + NL + "                " + NL + "\t\t\t\t\tresultsBinary_";
  protected final String TEXT_69 = ".add(new java.util.ArrayList<byte[]>());" + NL + "" + NL + "                    for (int j_";
  protected final String TEXT_70 = " = 0; j_";
  protected final String TEXT_71 = " < attributes_";
  protected final String TEXT_72 = ".length; j_";
  protected final String TEXT_73 = "++) {" + NL + "                    " + NL + "                        netscape.ldap.LDAPAttribute attribute_";
  protected final String TEXT_74 = " = attributes_";
  protected final String TEXT_75 = "[j_";
  protected final String TEXT_76 = "];" + NL + "                        " + NL + "\t\t\t\t\t\tif(\"dn\".equalsIgnoreCase(filters_";
  protected final String TEXT_77 = "[i_";
  protected final String TEXT_78 = "])){" + NL + "\t\t\t\t\t\t\tresults_";
  protected final String TEXT_79 = "[i_";
  protected final String TEXT_80 = "] = record_";
  protected final String TEXT_81 = ".getDN();" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t" + NL + "                            if (filters_";
  protected final String TEXT_82 = "[i_";
  protected final String TEXT_83 = "].equalsIgnoreCase(attribute_";
  protected final String TEXT_84 = ".getName())" + NL + "                            || filters_binary_";
  protected final String TEXT_85 = "[i_";
  protected final String TEXT_86 = "].equalsIgnoreCase(attribute_";
  protected final String TEXT_87 = ".getName())) {" + NL + "                            " + NL + "                                byte[][] values_";
  protected final String TEXT_88 = " = attribute_";
  protected final String TEXT_89 = ".getByteValueArray();";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\t\t\t\t\tif(attribute_";
  protected final String TEXT_91 = ".getBaseName().equalsIgnoreCase(\"";
  protected final String TEXT_92 = "\")){" + NL + "\t\t\t\t\t\t\t\t\t\t\tfor(byte[] byteValue_";
  protected final String TEXT_93 = " : values_";
  protected final String TEXT_94 = ") {" + NL + "\t\t                           \t\t\t\tString value_";
  protected final String TEXT_95 = " = null;" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_96 = "){" + NL + "\t\t                             \t   \t\t\tvalue_";
  protected final String TEXT_97 = " = new String(byteValue_";
  protected final String TEXT_98 = ",";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "                                \t\t\t\t\tvalue_";
  protected final String TEXT_100 = " = netscape.ldap.util.LDIF.toPrintableString(byteValue_";
  protected final String TEXT_101 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t \t\t\t\t\t\t\t\t\t\t\tresultsBinary_";
  protected final String TEXT_102 = ".get(i_";
  protected final String TEXT_103 = ").add(value_";
  protected final String TEXT_104 = ".getBytes(";
  protected final String TEXT_105 = "));" + NL + "                                \t\t\t\t\tresults_";
  protected final String TEXT_106 = "[i_";
  protected final String TEXT_107 = "] = results_";
  protected final String TEXT_108 = "[i_";
  protected final String TEXT_109 = "] == null ? value_";
  protected final String TEXT_110 = " : results_";
  protected final String TEXT_111 = "[i_";
  protected final String TEXT_112 = "] + ";
  protected final String TEXT_113 = " + value_";
  protected final String TEXT_114 = ";" + NL + "                                \t\t\t}" + NL + "                                \t\t}";
  protected final String TEXT_115 = NL + "\t\t\t\t\t\t\t\t\t\tfor(byte[] byteValue_";
  protected final String TEXT_116 = " : values_";
  protected final String TEXT_117 = ") {" + NL + "\t                           \t\t\t\tString value_";
  protected final String TEXT_118 = " = netscape.ldap.util.LDIF.toPrintableString(byteValue_";
  protected final String TEXT_119 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\tresultsBinary_";
  protected final String TEXT_120 = ".get(i_";
  protected final String TEXT_121 = ").add(value_";
  protected final String TEXT_122 = ".getBytes(";
  protected final String TEXT_123 = "));" + NL + "                           \t\t\t\t\tresults_";
  protected final String TEXT_124 = "[i_";
  protected final String TEXT_125 = "] = results_";
  protected final String TEXT_126 = "[i_";
  protected final String TEXT_127 = "] == null ? value_";
  protected final String TEXT_128 = " : results_";
  protected final String TEXT_129 = "[i_";
  protected final String TEXT_130 = "] + ";
  protected final String TEXT_131 = " + value_";
  protected final String TEXT_132 = ";" + NL + "                            \t\t\t}";
  protected final String TEXT_133 = NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                }" + NL + "                " + NL + "                break;" + NL + "" + NL + "            case netscape.ldap.util.LDIFContent.ADD_CONTENT:" + NL + "            " + NL + "                netscape.ldap.util.LDIFAddContent addContent_";
  protected final String TEXT_134 = " = (netscape.ldap.util.LDIFAddContent) content_";
  protected final String TEXT_135 = ";" + NL + "                attributes_";
  protected final String TEXT_136 = " = addContent_";
  protected final String TEXT_137 = ".getAttributes();" + NL + "                " + NL + "                for (int i_";
  protected final String TEXT_138 = " = 0; i_";
  protected final String TEXT_139 = " < filters_";
  protected final String TEXT_140 = ".length; i_";
  protected final String TEXT_141 = "++) {" + NL + "                " + NL + "\t\t\t\t\tresultsBinary_";
  protected final String TEXT_142 = ".add(new java.util.ArrayList<byte[]>());" + NL + "" + NL + "                    for (int j_";
  protected final String TEXT_143 = " = 0; j_";
  protected final String TEXT_144 = " < attributes_";
  protected final String TEXT_145 = ".length; j_";
  protected final String TEXT_146 = "++) {" + NL + "                    " + NL + "                        netscape.ldap.LDAPAttribute attribute_";
  protected final String TEXT_147 = " = attributes_";
  protected final String TEXT_148 = "[j_";
  protected final String TEXT_149 = "];" + NL + "                        " + NL + "\t\t\t\t\t\tif(\"dn\".equalsIgnoreCase(filters_";
  protected final String TEXT_150 = "[i_";
  protected final String TEXT_151 = "])){" + NL + "\t\t\t\t\t\t\tresults_";
  protected final String TEXT_152 = "[i_";
  protected final String TEXT_153 = "] = record_";
  protected final String TEXT_154 = ".getDN();" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t}else if(\"changetype\".equalsIgnoreCase(filters_";
  protected final String TEXT_155 = "[i_";
  protected final String TEXT_156 = "])){" + NL + "\t\t\t\t\t\t\tresults_";
  protected final String TEXT_157 = "[i_";
  protected final String TEXT_158 = "] = \"add\";" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t" + NL + "                            if (filters_";
  protected final String TEXT_159 = "[i_";
  protected final String TEXT_160 = "].equalsIgnoreCase(attribute_";
  protected final String TEXT_161 = ".getName())" + NL + "                            || filters_binary_";
  protected final String TEXT_162 = "[i_";
  protected final String TEXT_163 = "].equalsIgnoreCase(attribute_";
  protected final String TEXT_164 = ".getName())) {" + NL + "                            " + NL + "                                byte[][] values_";
  protected final String TEXT_165 = " = attribute_";
  protected final String TEXT_166 = ".getByteValueArray();";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\t\t\t\t\tif(attribute_";
  protected final String TEXT_168 = ".getBaseName().equalsIgnoreCase(\"";
  protected final String TEXT_169 = "\")){" + NL + "\t\t\t\t\t\t\t\t\t\t\tfor(byte[] byteValue_";
  protected final String TEXT_170 = " : values_";
  protected final String TEXT_171 = ") {" + NL + "\t\t                           \t\t\t\tString value_";
  protected final String TEXT_172 = " = null;" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_173 = "){" + NL + "\t\t                             \t\t   \t\tvalue_";
  protected final String TEXT_174 = " = new String(byteValue_";
  protected final String TEXT_175 = ",";
  protected final String TEXT_176 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "                                \t\t\t\t\tvalue_";
  protected final String TEXT_177 = " = netscape.ldap.util.LDIF.toPrintableString(byteValue_";
  protected final String TEXT_178 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tresultsBinary_";
  protected final String TEXT_179 = ".get(i_";
  protected final String TEXT_180 = ").add(value_";
  protected final String TEXT_181 = ".getBytes(";
  protected final String TEXT_182 = "));" + NL + "                                \t\t\t\t\tresults_";
  protected final String TEXT_183 = "[i_";
  protected final String TEXT_184 = "] = results_";
  protected final String TEXT_185 = "[i_";
  protected final String TEXT_186 = "] == null ? value_";
  protected final String TEXT_187 = " : results_";
  protected final String TEXT_188 = "[i_";
  protected final String TEXT_189 = "] + ";
  protected final String TEXT_190 = " + value_";
  protected final String TEXT_191 = ";" + NL + "                                \t\t\t}" + NL + "                                \t\t}";
  protected final String TEXT_192 = NL + "\t\t\t\t\t\t\t\t\t\tfor(byte[] byteValue_";
  protected final String TEXT_193 = " : values_";
  protected final String TEXT_194 = ") {" + NL + "\t    \t                       \t\t\tString value_";
  protected final String TEXT_195 = " = netscape.ldap.util.LDIF.toPrintableString(byteValue_";
  protected final String TEXT_196 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\tresultsBinary_";
  protected final String TEXT_197 = ".get(i_";
  protected final String TEXT_198 = ").add(value_";
  protected final String TEXT_199 = ".getBytes(";
  protected final String TEXT_200 = "));" + NL + "            \t                \t\t\tresults_";
  protected final String TEXT_201 = "[i_";
  protected final String TEXT_202 = "] = results_";
  protected final String TEXT_203 = "[i_";
  protected final String TEXT_204 = "] == null ? value_";
  protected final String TEXT_205 = " : results_";
  protected final String TEXT_206 = "[i_";
  protected final String TEXT_207 = "] + ";
  protected final String TEXT_208 = " + value_";
  protected final String TEXT_209 = ";" + NL + "                \t            \t\t}";
  protected final String TEXT_210 = NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                }                " + NL + "                break;" + NL + "                " + NL + "            case netscape.ldap.util.LDIFContent.MODIFICATION_CONTENT:" + NL + "" + NL + "\t\t\t\t\tnetscape.ldap.util.LDIFModifyContent modifyContent_";
  protected final String TEXT_211 = " = (netscape.ldap.util.LDIFModifyContent) content_";
  protected final String TEXT_212 = ";" + NL + "\t\t\t\t\tnetscape.ldap.LDAPModification[] modifications_";
  protected final String TEXT_213 = " = modifyContent_";
  protected final String TEXT_214 = ".getModifications();" + NL + "" + NL + "\t\t\t\t\tfor (int i_";
  protected final String TEXT_215 = " = 0; i_";
  protected final String TEXT_216 = " < filters_";
  protected final String TEXT_217 = ".length; i_";
  protected final String TEXT_218 = "++) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\tresultsBinary_";
  protected final String TEXT_219 = ".add(new java.util.ArrayList<byte[]>());" + NL + "" + NL + "\t\t\t\t\t\tfor (netscape.ldap.LDAPModification modification_";
  protected final String TEXT_220 = " : modifications_";
  protected final String TEXT_221 = ") {" + NL + "\t\t\t\t\t\t\tnetscape.ldap.LDAPAttribute attribute_";
  protected final String TEXT_222 = " = modification_";
  protected final String TEXT_223 = ".getAttribute();" + NL + "" + NL + "\t\t\t\t\t\t\tif (\"dn\".equalsIgnoreCase(filters_";
  protected final String TEXT_224 = "[i_";
  protected final String TEXT_225 = "])) {" + NL + "\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_226 = "[i_";
  protected final String TEXT_227 = "] = record_";
  protected final String TEXT_228 = ".getDN();" + NL + "" + NL + "\t\t\t\t\t\t\t} else if (\"changetype\".equalsIgnoreCase(filters_";
  protected final String TEXT_229 = "[i_";
  protected final String TEXT_230 = "])) {" + NL + "\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_231 = "[i_";
  protected final String TEXT_232 = "] = \"modify\";" + NL + "" + NL + "\t\t\t\t\t\t\t} else {" + NL + "" + NL + "\t\t\t\t\t\t\t\tif (filters_";
  protected final String TEXT_233 = "[i_";
  protected final String TEXT_234 = "].equalsIgnoreCase(attribute_";
  protected final String TEXT_235 = ".getName())" + NL + "\t\t\t\t\t\t\t\t|| filters_binary_";
  protected final String TEXT_236 = "[i_";
  protected final String TEXT_237 = "].equalsIgnoreCase(attribute_";
  protected final String TEXT_238 = ".getName())) {" + NL + "" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_239 = "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tint op_";
  protected final String TEXT_240 = " = modification_";
  protected final String TEXT_241 = ".getOp();" + NL + "\t\t\t\t\t\t\t\t\tswitch(op_";
  protected final String TEXT_242 = "){" + NL + "\t\t\t\t\t\t\t\t\t\tcase netscape.ldap.LDAPModification.ADD: " + NL + "\t\t\t\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_243 = "[i_";
  protected final String TEXT_244 = "] = \"add\";" + NL + "\t\t\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t\t\tcase netscape.ldap.LDAPModification.DELETE: " + NL + "\t\t\t\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_245 = "[i_";
  protected final String TEXT_246 = "] = \"delete\";" + NL + "\t\t\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t\t\tcase netscape.ldap.LDAPModification.REPLACE:" + NL + "\t\t\t\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_247 = "[i_";
  protected final String TEXT_248 = "] = \"replace\";" + NL + "\t\t\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t\t\tdefault:" + NL + "\t\t\t\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_249 = "[i_";
  protected final String TEXT_250 = "] = \"\";" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_251 = "\t\t\t\t\t\t\t\t\t" + NL + "" + NL + "\t\t\t\t\t\t\t\t\tbyte[][] values_";
  protected final String TEXT_252 = " = attribute_";
  protected final String TEXT_253 = ".getByteValueArray();" + NL + "                                " + NL + "                                \tboolean firstLoop_";
  protected final String TEXT_254 = " = true;";
  protected final String TEXT_255 = NL + "\t\t\t\t\t\t\t\t\t\t\tif(attribute_";
  protected final String TEXT_256 = ".getBaseName().equalsIgnoreCase(\"";
  protected final String TEXT_257 = "\")){" + NL + "\t\t\t                          \t \t\tfor(byte[] byteValue_";
  protected final String TEXT_258 = " : values_";
  protected final String TEXT_259 = ") {" + NL + "\t\t\t\t                        \t  \t \tString value_";
  protected final String TEXT_260 = " = null;" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_261 = "){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue_";
  protected final String TEXT_262 = " = new String(byteValue_";
  protected final String TEXT_263 = ",";
  protected final String TEXT_264 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t        \t                   \t    \t\t\tvalue_";
  protected final String TEXT_265 = " = netscape.ldap.util.LDIF.toPrintableString(byteValue_";
  protected final String TEXT_266 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tresultsBinary_";
  protected final String TEXT_267 = ".get(i_";
  protected final String TEXT_268 = ").add(value_";
  protected final String TEXT_269 = ".getBytes(";
  protected final String TEXT_270 = "));" + NL + "\t                                \t\t\t\tif(firstLoop_";
  protected final String TEXT_271 = "){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_272 = "[i_";
  protected final String TEXT_273 = "] = results_";
  protected final String TEXT_274 = "[i_";
  protected final String TEXT_275 = "] == null ? value_";
  protected final String TEXT_276 = " : results_";
  protected final String TEXT_277 = "[i_";
  protected final String TEXT_278 = "] + \":\" + value_";
  protected final String TEXT_279 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_280 = "[i_";
  protected final String TEXT_281 = "] = results_";
  protected final String TEXT_282 = "[i_";
  protected final String TEXT_283 = "] + ";
  protected final String TEXT_284 = " + value_";
  protected final String TEXT_285 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tfirstLoop_";
  protected final String TEXT_286 = " = false;" + NL + "\t                          \t\t\t\t \t}" + NL + "                                \t\t\t}";
  protected final String TEXT_287 = NL + "\t                          \t \t\tfor(byte[] byteValue_";
  protected final String TEXT_288 = " : values_";
  protected final String TEXT_289 = ") {" + NL + "\t\t                        \t  \t \tString value_";
  protected final String TEXT_290 = " = netscape.ldap.util.LDIF.toPrintableString(byteValue_";
  protected final String TEXT_291 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\tresultsBinary_";
  protected final String TEXT_292 = ".get(i_";
  protected final String TEXT_293 = ").add(value_";
  protected final String TEXT_294 = ".getBytes(";
  protected final String TEXT_295 = "));" + NL + "                            \t\t\t\tif(firstLoop_";
  protected final String TEXT_296 = "){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_297 = "[i_";
  protected final String TEXT_298 = "] = results_";
  protected final String TEXT_299 = "[i_";
  protected final String TEXT_300 = "] == null ? value_";
  protected final String TEXT_301 = " : results_";
  protected final String TEXT_302 = "[i_";
  protected final String TEXT_303 = "] + \":\" + value_";
  protected final String TEXT_304 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_305 = "[i_";
  protected final String TEXT_306 = "] = results_";
  protected final String TEXT_307 = "[i_";
  protected final String TEXT_308 = "] + ";
  protected final String TEXT_309 = " + value_";
  protected final String TEXT_310 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\tfirstLoop_";
  protected final String TEXT_311 = " = false;" + NL + "                      \t\t\t\t\t }";
  protected final String TEXT_312 = NL + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}                " + NL + "                break;" + NL + "                " + NL + "            case netscape.ldap.util.LDIFContent.DELETE_CONTENT:" + NL + "                //netscape.ldap.util.LDIFDeleteContent deleteContent_";
  protected final String TEXT_313 = " = (netscape.ldap.util.LDIFDeleteContent) content_";
  protected final String TEXT_314 = ";" + NL + "                for (int i_";
  protected final String TEXT_315 = " = 0; i_";
  protected final String TEXT_316 = " < filters_";
  protected final String TEXT_317 = ".length; i_";
  protected final String TEXT_318 = "++) {" + NL + "\t\t\t\t\tif(\"dn\".equalsIgnoreCase(filters_";
  protected final String TEXT_319 = "[i_";
  protected final String TEXT_320 = "])){" + NL + "\t\t\t\t\t\tresults_";
  protected final String TEXT_321 = "[i_";
  protected final String TEXT_322 = "] = record_";
  protected final String TEXT_323 = ".getDN();\t\t\t\t\t\t" + NL + "\t\t\t\t\t}else if(\"changetype\".equalsIgnoreCase(filters_";
  protected final String TEXT_324 = "[i_";
  protected final String TEXT_325 = "])){" + NL + "\t\t\t\t\t\tresults_";
  protected final String TEXT_326 = "[i_";
  protected final String TEXT_327 = "] = \"delete\";" + NL + "\t\t\t\t\t}                " + NL + "                }                " + NL + "                break;" + NL + "                " + NL + "\t\t\tcase netscape.ldap.util.LDIFContent.MODDN_CONTENT:" + NL + "\t\t\t\tnetscape.ldap.util.LDIFModDNContent moddnContent_";
  protected final String TEXT_328 = " = (netscape.ldap.util.LDIFModDNContent) content_";
  protected final String TEXT_329 = ";" + NL + "                for (int i_";
  protected final String TEXT_330 = " = 0; i_";
  protected final String TEXT_331 = " < filters_";
  protected final String TEXT_332 = ".length; i_";
  protected final String TEXT_333 = "++) {" + NL + "\t\t\t\t\tif(\"dn\".equalsIgnoreCase(filters_";
  protected final String TEXT_334 = "[i_";
  protected final String TEXT_335 = "])){" + NL + "\t\t\t\t\t\tresults_";
  protected final String TEXT_336 = "[i_";
  protected final String TEXT_337 = "] = record_";
  protected final String TEXT_338 = ".getDN();\t\t\t\t\t\t" + NL + "\t\t\t\t\t}else if(\"changetype\".equalsIgnoreCase(filters_";
  protected final String TEXT_339 = "[i_";
  protected final String TEXT_340 = "])){" + NL + "\t\t\t\t\t\tresults_";
  protected final String TEXT_341 = "[i_";
  protected final String TEXT_342 = "] = \"modrdn\";" + NL + "\t\t\t\t\t}else if(\"newrdn\".equalsIgnoreCase(filters_";
  protected final String TEXT_343 = "[i_";
  protected final String TEXT_344 = "])){" + NL + "\t\t\t\t\t\tresults_";
  protected final String TEXT_345 = "[i_";
  protected final String TEXT_346 = "] = moddnContent_";
  protected final String TEXT_347 = ".getRDN();" + NL + "\t\t\t\t\t}else if(\"deleteoldrdn\".equalsIgnoreCase(filters_";
  protected final String TEXT_348 = "[i_";
  protected final String TEXT_349 = "])){" + NL + "\t\t\t\t\t\tresults_";
  protected final String TEXT_350 = "[i_";
  protected final String TEXT_351 = "] = Boolean.toString(moddnContent_";
  protected final String TEXT_352 = ".getDeleteOldRDN());" + NL + "\t\t\t\t\t}else if(\"newsuperior\".equalsIgnoreCase(filters_";
  protected final String TEXT_353 = "[i_";
  protected final String TEXT_354 = "])){" + NL + "\t\t\t\t\t\tresults_";
  protected final String TEXT_355 = "[i_";
  protected final String TEXT_356 = "] = moddnContent_";
  protected final String TEXT_357 = ".getNewParent();" + NL + "\t\t\t\t\t}\t\t\t\t\t                " + NL + "                }" + NL + "\t\t\t\tbreak;" + NL + "\t\t\tdefault:                " + NL + "            }" + NL + "            nb_line_";
  protected final String TEXT_358 = "++;" + NL + "            " + NL + "            " + NL + "// for output";
  protected final String TEXT_359 = NL + "    \t\t";
  protected final String TEXT_360 = " = null;\t\t\t";
  protected final String TEXT_361 = NL + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_362 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_363 = " = new ";
  protected final String TEXT_364 = "Struct();" + NL + "\t\t\ttry {\t\t\t";
  protected final String TEXT_365 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_366 = " < results_";
  protected final String TEXT_367 = ".length && results_";
  protected final String TEXT_368 = "[";
  protected final String TEXT_369 = "]!=null ){\t\t\t\t";
  protected final String TEXT_370 = NL + "\t\t\t\t\t";
  protected final String TEXT_371 = ".";
  protected final String TEXT_372 = " = results_";
  protected final String TEXT_373 = "[";
  protected final String TEXT_374 = "];";
  protected final String TEXT_375 = NL + "\t\t\t\t\t";
  protected final String TEXT_376 = ".";
  protected final String TEXT_377 = " = ParserUtils.parseTo_Date(results_";
  protected final String TEXT_378 = "[";
  protected final String TEXT_379 = "], ";
  protected final String TEXT_380 = ");";
  protected final String TEXT_381 = NL + "\t\t\t\t\t";
  protected final String TEXT_382 = ".";
  protected final String TEXT_383 = " = resultsBinary_";
  protected final String TEXT_384 = ".get(";
  protected final String TEXT_385 = ").get(0);";
  protected final String TEXT_386 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_387 = ".";
  protected final String TEXT_388 = " = resultsBinary_";
  protected final String TEXT_389 = ".get(";
  protected final String TEXT_390 = ");";
  protected final String TEXT_391 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_392 = ".";
  protected final String TEXT_393 = " = ParserUtils.parseTo_";
  protected final String TEXT_394 = "(results_";
  protected final String TEXT_395 = "[";
  protected final String TEXT_396 = "]);";
  protected final String TEXT_397 = NL + "\t\t\t" + NL + "\t\t\t} else { " + NL + "\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_398 = ".";
  protected final String TEXT_399 = " = ";
  protected final String TEXT_400 = ";" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_401 = NL + "\t\t\t";
  protected final String TEXT_402 = " ";
  protected final String TEXT_403 = " = null; ";
  protected final String TEXT_404 = "\t\t\t" + NL + "\t\t\t" + NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_405 = " = true;";
  protected final String TEXT_406 = NL + "            throw(e);";
  protected final String TEXT_407 = NL + "                    ";
  protected final String TEXT_408 = " = new ";
  protected final String TEXT_409 = "Struct();";
  protected final String TEXT_410 = NL + "                    ";
  protected final String TEXT_411 = ".";
  protected final String TEXT_412 = " = ";
  protected final String TEXT_413 = ".";
  protected final String TEXT_414 = ";";
  protected final String TEXT_415 = NL + "                ";
  protected final String TEXT_416 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_417 = ";";
  protected final String TEXT_418 = NL + "                ";
  protected final String TEXT_419 = " = null;";
  protected final String TEXT_420 = NL + "\t        \tlog.error(\"";
  protected final String TEXT_421 = " - \" +e.getMessage());" + NL + "\t        \t";
  protected final String TEXT_422 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_423 = NL + "                ";
  protected final String TEXT_424 = " = null;";
  protected final String TEXT_425 = NL + "            \t";
  protected final String TEXT_426 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_427 = ";";
  protected final String TEXT_428 = NL + "    }" + NL + "\t\t\t";
  protected final String TEXT_429 = NL + "\t\t";
  protected final String TEXT_430 = "if(!whetherReject_";
  protected final String TEXT_431 = ") { ";
  protected final String TEXT_432 = "      " + NL + "             if(";
  protected final String TEXT_433 = " == null){ " + NL + "            \t ";
  protected final String TEXT_434 = " = new ";
  protected final String TEXT_435 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_436 = NL + "\t    \t ";
  protected final String TEXT_437 = ".";
  protected final String TEXT_438 = " = ";
  protected final String TEXT_439 = ".";
  protected final String TEXT_440 = ";    \t\t\t\t";
  protected final String TEXT_441 = NL + "\t\t";
  protected final String TEXT_442 = " } ";
  protected final String TEXT_443 = "\t";
  protected final String TEXT_444 = NL + "///////////////////////////////////        ";
  protected final String TEXT_445 = NL;

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
	
    stringBuffer.append(TEXT_30);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean useFieldOptions = ("true").equals(ElementParameterParser.getValue(node, "__USE_FIELD_OPTIONS__"));

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        // component id
        String cid = node.getUniqueName();
        String filename = ElementParameterParser.getValue(node,"__FILENAME__"); 
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;               
        List<IMetadataColumn> listColumns = metadata.getListColumns();
        
        String addprefixStr = ElementParameterParser.getValue(node, "__ADDPREFIX__");
        boolean addprefix = (addprefixStr!=null&&!("").equals(addprefixStr))?("true").equals(addprefixStr):false;
        String valueSeparator = ElementParameterParser.getValue(node, "__VALUE_SEPARATOR__");
		List<Map<String, String>> textEncodingColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TEXTENCODING__");
		boolean isBinary = false;
		boolean isBase64 = false;
		
		final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    	log4jFileUtil.componentStartInfo(node);

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
        for (IMetadataColumn column: listColumns) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_35);
    
        }

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
        for (IMetadataColumn column: listColumns) {//fix bug TDI17707

    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_39);
    
        }

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(listColumns.size() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    
								if(useFieldOptions){
									for(Map<String, String> line:textEncodingColumns){// search in the configuration table
										String columnName = line.get("SCHEMA_COLUMN");
										isBase64 = "true".equals(line.get("BASE64"));

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(isBase64);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(valueSeparator);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    
	                                	isBase64 = false;
	                               	}
	                           	}else{

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(valueSeparator);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    
	                           	}

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    
								if(useFieldOptions){
									for(Map<String, String> line:textEncodingColumns){// search in the configuration table
										String columnName = line.get("SCHEMA_COLUMN");
										isBase64 = "true".equals(line.get("BASE64"));

    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(isBase64);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(valueSeparator);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    
                            			isBase64 = false;
                            		}
                           	 	}else{

    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(valueSeparator);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    
                    	        }

    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    if(addprefix){
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    
									if(useFieldOptions){
										for(Map<String, String> line:textEncodingColumns){// search in the configuration table
											String columnName = line.get("SCHEMA_COLUMN");
											isBase64 = "true".equals(line.get("BASE64"));

    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(isBase64);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(valueSeparator);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    
											isBase64 = false;
										}
                            		}else{

    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(valueSeparator);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    
                            		}

    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    
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

    	if (conns!=null) {
    		if (conns.size()>0) {
    			for (int i=0;i<conns.size();i++) {
    				IConnection connTemp = conns.get(i);
    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_359);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_360);
    
    				}
    			}
    		}
    	}
    	
	String firstConnName = "";
	if (conns!=null) {//1
		if (conns.size()>0) {//2
		
			IConnection conn = conns.get(0); //the first connection
			firstConnName = conn.getName();		
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3

				
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_364);
    
			List<IMetadataColumn> columns=metadata.getListColumns();
			int columnSize = columns.size();
			for (int i=0;i<columnSize;i++) {//4
					IMetadataColumn column=columns.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_365);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_369);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { //String or Object

    stringBuffer.append(TEXT_370);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_374);
    
					} else if(javaType == JavaTypesManager.DATE) { //Date

    stringBuffer.append(TEXT_375);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_379);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_380);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_381);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_384);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_385);
    
					} else if(javaType == JavaTypesManager.LIST)  { // List<byte[]>

    stringBuffer.append(TEXT_386);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_390);
    
					} else  { //other

    stringBuffer.append(TEXT_391);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_393);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_396);
    
					}

    stringBuffer.append(TEXT_397);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_400);
    			
			} //4
			
			log4jFileUtil.debugRetriveData(node);

    stringBuffer.append(TEXT_401);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_402);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_403);
    }
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_406);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_407);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_409);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_410);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_412);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_414);
    
                }
                
    stringBuffer.append(TEXT_415);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_419);
    
            } else if(("").equals(rejectConnName)){
	        	if(isLog4jEnabled){
	        	
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    
	        	}
                
    stringBuffer.append(TEXT_422);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_424);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_425);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_427);
    }
        } 
        
    stringBuffer.append(TEXT_428);
    
		}//3
		
		
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_429);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_432);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_435);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_436);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_437);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_438);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_440);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_441);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_442);
     } 
    stringBuffer.append(TEXT_443);
    
		}
		
		
	}//2
	
}//1


    stringBuffer.append(TEXT_444);
    
  }
}  
 
    stringBuffer.append(TEXT_445);
    return stringBuffer.toString();
  }
}
