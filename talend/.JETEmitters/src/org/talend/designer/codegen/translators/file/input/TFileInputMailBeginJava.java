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

public class TFileInputMailBeginJava
{
  protected static String nl;
  public static synchronized TFileInputMailBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputMailBeginJava result = new TFileInputMailBeginJava();
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
  protected final String TEXT_29 = NL + " ";
  protected final String TEXT_30 = " " + NL + "\t\tif(!(";
  protected final String TEXT_31 = ").endsWith(\"/\")){" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_32 = "_EXPORTED_FILE_PATH\",";
  protected final String TEXT_33 = " + \"/\");" + NL + "\t\t}else{" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_34 = "_EXPORTED_FILE_PATH\",";
  protected final String TEXT_35 = ");" + NL + "\t\t}" + NL + "\t\tboolean hasData_";
  protected final String TEXT_36 = " = false;" + NL + "\t\t";
  protected final String TEXT_37 = NL + "        \t";
  protected final String TEXT_38 = "\t\t";
  protected final String TEXT_39 = NL + "\t\tString [] mailParts_";
  protected final String TEXT_40 = " = new String [] {" + NL + "\t\t";
  protected final String TEXT_41 = NL + "\t\t\t";
  protected final String TEXT_42 = "," + NL + "\t\t";
  protected final String TEXT_43 = NL + "\t\t};" + NL + "\t\tString [] mailChecked_";
  protected final String TEXT_44 = " = new String [] {" + NL + "\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\"";
  protected final String TEXT_46 = "\"," + NL + "\t\t";
  protected final String TEXT_47 = NL + "\t\t};" + NL + "\t\tString [] mailSeparator_";
  protected final String TEXT_48 = " = new String [] {" + NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t";
  protected final String TEXT_50 = "," + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t";
  protected final String TEXT_52 = "," + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t};" + NL + "\t\tjava.io.FileInputStream fileInput";
  protected final String TEXT_54 = "=null;\t" + NL + "\t" + NL + "\t\tclass DecodeString_";
  protected final String TEXT_55 = " {" + NL + "\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\tpublic String decode(String str){" + NL + "\t\t\t\tif(str==null){" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tString res = \"\";" + NL + "\t\t\t\tint first = str.indexOf(\"=?\");" + NL + "\t\t\t    int last = str.indexOf(\"?=\");" + NL + "\t\t\t\tif(first!=-1 && last!=-1){" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tres = str.substring(0,first)+javax.mail.internet.MimeUtility.decodeWord(str.substring(first,last+2))+str.substring(last+2);" + NL + "\t\t\t\t\t\tif(res.equals(str)){" + NL + "\t\t\t\t\t\t\treturn res;" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\treturn decode(res);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_58 = " - \" + str);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\t\t\treturn str;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\treturn str;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tDecodeString_";
  protected final String TEXT_60 = " decode_";
  protected final String TEXT_61 = " = new DecodeString_";
  protected final String TEXT_62 = "();" + NL + "\t\ttry{" + NL + "\t\t\tfileInput";
  protected final String TEXT_63 = " = new java.io.FileInputStream(";
  protected final String TEXT_64 = ");" + NL + "\t\t\tjavax.mail.Session session_";
  protected final String TEXT_65 = " = javax.mail.Session.getInstance(System.getProperties(), null);" + NL + "\t\t    javax.mail.internet.MimeMessage msg_";
  protected final String TEXT_66 = " = new javax.mail.internet.MimeMessage(session_";
  protected final String TEXT_67 = ", fileInput";
  protected final String TEXT_68 = ");" + NL + "\t\t\tjava.util.List<String> list_";
  protected final String TEXT_69 = " = new java.util.ArrayList<String>();" + NL + "\t\t" + NL + "\t\t\tfor (int i_";
  protected final String TEXT_70 = " =0;i_";
  protected final String TEXT_71 = " < mailParts_";
  protected final String TEXT_72 = ".length;i_";
  protected final String TEXT_73 = "++) {\t\t\t\t" + NL + "\t\t\tString part_";
  protected final String TEXT_74 = " = mailParts_";
  protected final String TEXT_75 = "[i_";
  protected final String TEXT_76 = "];" + NL + "\t       \tString sep_";
  protected final String TEXT_77 = "= mailSeparator_";
  protected final String TEXT_78 = "[i_";
  protected final String TEXT_79 = "];" + NL + "\t\t        if(part_";
  protected final String TEXT_80 = ".equalsIgnoreCase(\"body\")) {        " + NL + "\t\t\t\t\tif(msg_";
  protected final String TEXT_81 = ".isMimeType(\"multipart/*\")) {" + NL + "\t\t\t\t\t\tjavax.mail.Multipart mp";
  protected final String TEXT_82 = " = (javax.mail.Multipart) msg_";
  protected final String TEXT_83 = ".getContent();" + NL + "\t             \t\tfor (int i = 0; i < mp";
  protected final String TEXT_84 = ".getCount(); i++) {" + NL + "\t                 \t\tjavax.mail.BodyPart mpart";
  protected final String TEXT_85 = " = mp";
  protected final String TEXT_86 = ".getBodyPart(i);" + NL + "\t                 \t\tString disposition";
  protected final String TEXT_87 = " = mpart";
  protected final String TEXT_88 = ".getDisposition();" + NL + "\t                 \t\tif (!((disposition";
  protected final String TEXT_89 = " != null) && ((disposition";
  protected final String TEXT_90 = NL + "\t                            .equals(javax.mail.Part.ATTACHMENT)) || (disposition";
  protected final String TEXT_91 = ".equals(javax.mail.Part.INLINE))))) {   " + NL + "\t                    \t\t// the following extract the body part(text/plain + text/html)" + NL + "\t                    \t\ttry{" + NL + "\t\t\t\t\t\t\t\t\tObject content_";
  protected final String TEXT_92 = " = mpart";
  protected final String TEXT_93 = ".getContent();" + NL + "\t\t\t\t\t\t\t\t\tif (content_";
  protected final String TEXT_94 = " instanceof javax.mail.internet.MimeMultipart) {" + NL + "\t\t\t\t\t\t\t\t\t\tjavax.mail.internet.MimeMultipart mimeMultipart_";
  protected final String TEXT_95 = " = (javax.mail.internet.MimeMultipart) content_";
  protected final String TEXT_96 = ";" + NL + "\t\t\t\t\t\t\t\t\t\tfor (int j_";
  protected final String TEXT_97 = " = 0; j_";
  protected final String TEXT_98 = " < mimeMultipart_";
  protected final String TEXT_99 = " .getCount(); j_";
  protected final String TEXT_100 = "++) {" + NL + "\t\t\t\t\t\t\t\t\t\t\tjavax.mail.BodyPart bodyPart_";
  protected final String TEXT_101 = " = mimeMultipart_";
  protected final String TEXT_102 = " .getBodyPart(j_";
  protected final String TEXT_103 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_104 = "    \t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\tObject content_";
  protected final String TEXT_105 = "_body = bodyPart_";
  protected final String TEXT_106 = ".getContent();" + NL + "\t\t\t\t\t\t\t\t\t\t\tif (content_";
  protected final String TEXT_107 = "_body instanceof javax.mail.internet.MimeMultipart) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tjavax.mail.internet.MimeMultipart mimeMultipart_";
  protected final String TEXT_108 = "_body = (javax.mail.internet.MimeMultipart) content_";
  protected final String TEXT_109 = "_body;" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tfor(int j_";
  protected final String TEXT_110 = "_body = 0; j_";
  protected final String TEXT_111 = "_body < mimeMultipart_";
  protected final String TEXT_112 = "_body.getCount(); j_";
  protected final String TEXT_113 = "_body++){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tjavax.mail.BodyPart bodyPart_";
  protected final String TEXT_114 = "_body = mimeMultipart_";
  protected final String TEXT_115 = "_body.getBodyPart(j_";
  protected final String TEXT_116 = "_body);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tif (bodyPart_";
  protected final String TEXT_117 = "_body.isMimeType(\"text/*\")) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_118 = ".add(bodyPart_";
  protected final String TEXT_119 = "_body.getContent().toString());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tSystem.out.println(\"Ignore the part \" + bodyPart_";
  protected final String TEXT_120 = "_body.getContentType());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif (bodyPart_";
  protected final String TEXT_121 = ".isMimeType(\"text/*\")) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_122 = ".add(bodyPart_";
  protected final String TEXT_123 = ".getContent().toString());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tSystem.out.println(\"Ignore the part \" + bodyPart_";
  protected final String TEXT_124 = ".getContentType());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t} else {    " + NL + "\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_125 = ".add(mpart";
  protected final String TEXT_126 = ".getContent().toString());" + NL + "\t\t\t\t\t\t\t\t\t}    " + NL + "\t\t\t\t\t\t\t\t}catch (java.io.UnsupportedEncodingException e){" + NL + "\t\t\t\t\t\t\t\t\tjava.io.ByteArrayOutputStream bao_";
  protected final String TEXT_127 = " = new java.io.ByteArrayOutputStream();" + NL + "\t\t\t\t\t\t\t\t\tmpart";
  protected final String TEXT_128 = ".writeTo(bao_";
  protected final String TEXT_129 = ");" + NL + "\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_130 = ".add(bao_";
  protected final String TEXT_131 = ".toString());" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_132 = NL + "\t\t\t\t\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_133 = " - \" + bao_";
  protected final String TEXT_134 = ".toString());" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_136 = NL + "\t\t\t\t\t\t\t}else if(disposition";
  protected final String TEXT_137 = " != null && disposition";
  protected final String TEXT_138 = ".equals(javax.mail.Part.INLINE)){" + NL + "\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_139 = ".add(mpart";
  protected final String TEXT_140 = ".getContent().toString());" + NL + "\t\t\t\t\t \t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tjava.io.InputStream in_";
  protected final String TEXT_141 = " = msg_";
  protected final String TEXT_142 = ".getInputStream();" + NL + "\t     \t\t    \tbyte[] buffer_";
  protected final String TEXT_143 = " = new byte[1024];" + NL + "\t\t     \t\t    int length_";
  protected final String TEXT_144 = " = 0;" + NL + "\t\t     \t\t    java.io.ByteArrayOutputStream baos_";
  protected final String TEXT_145 = " =  new java.io.ByteArrayOutputStream();" + NL + "\t\t     \t\t    while ((length_";
  protected final String TEXT_146 = " = in_";
  protected final String TEXT_147 = ".read(buffer_";
  protected final String TEXT_148 = ", 0, 1024)) != -1) {" + NL + "\t\t     \t\t        baos_";
  protected final String TEXT_149 = ".write(buffer_";
  protected final String TEXT_150 = ", 0, length_";
  protected final String TEXT_151 = ");" + NL + "\t\t     \t\t    }" + NL + "\t\t     \t\t    String contentType_";
  protected final String TEXT_152 = " = msg_";
  protected final String TEXT_153 = ".getContentType();" + NL + "\t\t     \t\t    String charsetName_";
  protected final String TEXT_154 = " = \"\";" + NL + "\t\t     \t\t    if(contentType_";
  protected final String TEXT_155 = "!=null && contentType_";
  protected final String TEXT_156 = ".trim().length()>0){" + NL + "\t\t     \t\t    \tjavax.mail.internet.ContentType cy_";
  protected final String TEXT_157 = "  = new javax.mail.internet.ContentType(contentType_";
  protected final String TEXT_158 = ");" + NL + "\t\t     \t\t    \tcharsetName_";
  protected final String TEXT_159 = " = cy_";
  protected final String TEXT_160 = ".getParameter(\"charset\");" + NL + "\t\t     \t\t    }" + NL + "\t\t     \t\t    if(charsetName_";
  protected final String TEXT_161 = "!=null && charsetName_";
  protected final String TEXT_162 = ".length()>0){" + NL + "\t\t     \t\t    \tlist_";
  protected final String TEXT_163 = ".add(baos_";
  protected final String TEXT_164 = ".toString(charsetName_";
  protected final String TEXT_165 = "));" + NL + "\t\t     \t\t    }else{" + NL + "\t\t     \t\t    \tlist_";
  protected final String TEXT_166 = ".add(baos_";
  protected final String TEXT_167 = ".toString());" + NL + "\t\t     \t\t    }" + NL + "\t\t     \t\t    in_";
  protected final String TEXT_168 = ".close();" + NL + "\t\t     \t\t    baos_";
  protected final String TEXT_169 = ".close();" + NL + "\t\t\t\t\t}" + NL + "\t        \t}else if(part_";
  protected final String TEXT_170 = ".equalsIgnoreCase(\"header\")){" + NL + "\t\t            java.util.Enumeration em = msg_";
  protected final String TEXT_171 = ".getAllHeaderLines();" + NL + "\t\t            int em_count=0;" + NL + "\t\t            " + NL + "\t\t            String tempStr_";
  protected final String TEXT_172 = "=\"\";" + NL + "\t\t            " + NL + "\t\t\t\t\twhile (em.hasMoreElements()) {" + NL + "\t\t\t\t\t\ttempStr_";
  protected final String TEXT_173 = " = tempStr_";
  protected final String TEXT_174 = " + (String) em.nextElement() + sep_";
  protected final String TEXT_175 = " ;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tlist_";
  protected final String TEXT_176 = ".add(decode_";
  protected final String TEXT_177 = ".decode(tempStr_";
  protected final String TEXT_178 = "));" + NL + "\t        \t}else{" + NL + "\t\t        \tif((\"true\").equals(mailChecked_";
  protected final String TEXT_179 = "[i_";
  protected final String TEXT_180 = "])){   " + NL + "\t\t\t\t\t\tString[] sa_";
  protected final String TEXT_181 = " = msg_";
  protected final String TEXT_182 = ".getHeader(part_";
  protected final String TEXT_183 = ");" + NL + "\t\t\t\t\t\tString tempStr_";
  protected final String TEXT_184 = "=\"\";" + NL + "\t\t\t\t\t\tfor(int i=0;i<sa_";
  protected final String TEXT_185 = ".length;i++){" + NL + "\t\t\t\t\t\t\ttempStr_";
  protected final String TEXT_186 = "=tempStr_";
  protected final String TEXT_187 = "+sa_";
  protected final String TEXT_188 = "[i] + sep_";
  protected final String TEXT_189 = ";" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tlist_";
  protected final String TEXT_190 = ".add(decode_";
  protected final String TEXT_191 = ".decode(tempStr_";
  protected final String TEXT_192 = "));" + NL + "\t\t        \t}else{ " + NL + "\t\t\t           String content_";
  protected final String TEXT_193 = " = msg_";
  protected final String TEXT_194 = ".getHeader(part_";
  protected final String TEXT_195 = ", null);" + NL + "\t\t\t           list_";
  protected final String TEXT_196 = ".add(decode_";
  protected final String TEXT_197 = ".decode(content_";
  protected final String TEXT_198 = "));" + NL + "\t\t           \t}    " + NL + "\t\t        }   " + NL + "\t\t \t}   " + NL + "\t" + NL + "" + NL + "\t" + NL + "\t\t\t//attachment Deal" + NL + "\t\t\tif(msg_";
  protected final String TEXT_199 = ".isMimeType(\"multipart/*\")){" + NL + "\t \t    \tjavax.mail.Multipart mp";
  protected final String TEXT_200 = " = (javax.mail.Multipart) msg_";
  protected final String TEXT_201 = ".getContent();" + NL + "\t \t    \tString attachfileName";
  protected final String TEXT_202 = " = \"\";" + NL + "\t \t    \tString path";
  protected final String TEXT_203 = " = \"\";" + NL + "\t \t    \tjava.io.BufferedOutputStream out";
  protected final String TEXT_204 = " = null;" + NL + "\t \t    \tjava.io.BufferedInputStream in";
  protected final String TEXT_205 = " = null;" + NL + "\t            for (int i = 0; i < mp";
  protected final String TEXT_206 = ".getCount(); i++) {" + NL + "\t                javax.mail.BodyPart mpart";
  protected final String TEXT_207 = " = mp";
  protected final String TEXT_208 = ".getBodyPart(i);" + NL + "\t                String disposition";
  protected final String TEXT_209 = " = mpart";
  protected final String TEXT_210 = ".getDisposition();" + NL + "\t\t\t\t\t";
  protected final String TEXT_211 = "                " + NL + "\t                if (mpart";
  protected final String TEXT_212 = ".getFileName()!=null" + NL + "\t                    && ((disposition";
  protected final String TEXT_213 = " != null && (disposition";
  protected final String TEXT_214 = ".equals(javax.mail.Part.ATTACHMENT) || disposition";
  protected final String TEXT_215 = ".equals(javax.mail.Part.INLINE)))" + NL + "\t\t\t\t\t\t||  disposition";
  protected final String TEXT_216 = "==null)) {\t";
  protected final String TEXT_217 = NL + "\t        \t        attachfileName";
  protected final String TEXT_218 = " = mpart";
  protected final String TEXT_219 = ".getFileName();" + NL + "\t                    attachfileName";
  protected final String TEXT_220 = " = javax.mail.internet.MimeUtility.decodeText(attachfileName";
  protected final String TEXT_221 = ");" + NL + "\t                   " + NL + "\t                    " + NL + "\t\t\t\t\t\tif(!(";
  protected final String TEXT_222 = ").endsWith(\"/\")){" + NL + "\t           \t\t\t\tpath";
  protected final String TEXT_223 = " = ";
  protected final String TEXT_224 = " + \"/\";" + NL + "\t        \t\t\t}else{" + NL + "\t\t\t\t\t\t\tpath";
  protected final String TEXT_225 = " =";
  protected final String TEXT_226 = ";" + NL + "\t\t\t\t\t\t}" + NL + "\t                    path";
  protected final String TEXT_227 = " = path";
  protected final String TEXT_228 = " + attachfileName";
  protected final String TEXT_229 = ";" + NL + "\t                    ";
  protected final String TEXT_230 = NL + "\t\t                    \tlog.info(\"";
  protected final String TEXT_231 = " - Extracted attachment: '\"+attachfileName";
  protected final String TEXT_232 = "+\"'.\");" + NL + "\t                    ";
  protected final String TEXT_233 = NL + "\t                    java.io.File attachFile  = new java.io.File(path";
  protected final String TEXT_234 = ");" + NL + "\t                    out";
  protected final String TEXT_235 = " = new java.io.BufferedOutputStream(new java.io.FileOutputStream(attachFile));" + NL + "\t                    in";
  protected final String TEXT_236 = " = new java.io.BufferedInputStream(mpart";
  protected final String TEXT_237 = ".getInputStream());" + NL + "\t                    int buffer";
  protected final String TEXT_238 = " = 0;" + NL + "\t                    while ((buffer";
  protected final String TEXT_239 = " = in";
  protected final String TEXT_240 = ".read()) != -1) {" + NL + "\t                           out";
  protected final String TEXT_241 = ".write(buffer";
  protected final String TEXT_242 = ");" + NL + "\t                           out";
  protected final String TEXT_243 = ".flush();" + NL + "\t\t\t\t\t\t}   " + NL + "\t                    out";
  protected final String TEXT_244 = ".close();" + NL + "\t                    in";
  protected final String TEXT_245 = ".close();    " + NL + "\t                }" + NL + "\t            }" + NL + "\t\t\t}" + NL + " \t         " + NL + " \t          " + NL + "\t\t\t// for output" + NL + "\t\t\t";
  protected final String TEXT_246 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t" + NL + "\t\t\t\t\t\t\tif(";
  protected final String TEXT_247 = " < list_";
  protected final String TEXT_248 = ".size() && list_";
  protected final String TEXT_249 = ".get(";
  protected final String TEXT_250 = ")!=null){\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_251 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_252 = ".";
  protected final String TEXT_253 = " = (String)list_";
  protected final String TEXT_254 = ".get(";
  protected final String TEXT_255 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_256 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_257 = ".";
  protected final String TEXT_258 = " = ParserUtils.parseTo_Date(list_";
  protected final String TEXT_259 = ".get(";
  protected final String TEXT_260 = "), ";
  protected final String TEXT_261 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_262 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_263 = ".";
  protected final String TEXT_264 = " = list_";
  protected final String TEXT_265 = ".get(";
  protected final String TEXT_266 = ").getBytes();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_267 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_268 = ".";
  protected final String TEXT_269 = " = ParserUtils.parseTo_";
  protected final String TEXT_270 = "(list_";
  protected final String TEXT_271 = ".get(";
  protected final String TEXT_272 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_273 = NL + "\t\t\t\t\t\t\t} else { " + NL + "\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_274 = ".";
  protected final String TEXT_275 = " = ";
  protected final String TEXT_276 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_277 = NL + "\t\t\t\t\t\t\t\thasData_";
  protected final String TEXT_278 = " = true;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_279 = NL + "\t      \t\t\t\t\t\t\t";
  protected final String TEXT_280 = ".";
  protected final String TEXT_281 = " = ";
  protected final String TEXT_282 = ".";
  protected final String TEXT_283 = ";" + NL + "\t\t\t\t \t\t\t\t";
  protected final String TEXT_284 = NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_285 = NL + "\t\t\tcatch (java.lang.Exception e){" + NL + "\t\t\t\t";
  protected final String TEXT_286 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_287 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_288 = NL + "\t\t\t\t//nothing to do, ignore the exception if don't die on error" + NL + "\t\t\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_289 = ": \" + e.getMessage());" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_290 = NL + "\t\tfinally{" + NL + "\t\t\tif(fileInput";
  protected final String TEXT_291 = "!=null)" + NL + "\t\t\t\t\tfileInput";
  protected final String TEXT_292 = ".close();" + NL + "\t\t} " + NL + "\t\t////////////////////////////" + NL + "\t\tif(hasData_";
  protected final String TEXT_293 = "){" + NL + "\t\t";
  protected final String TEXT_294 = NL + "        \t";
  protected final String TEXT_295 = "\t";
  protected final String TEXT_296 = NL + "\ttry{" + NL + "\t\torg.talend.msg.utils.MsgMailUtil msgMailUtil_";
  protected final String TEXT_297 = "=new org.talend.msg.utils.MsgMailUtil(";
  protected final String TEXT_298 = ",";
  protected final String TEXT_299 = ");" + NL + "\t\t";
  protected final String TEXT_300 = NL + "\t\t\tmsgMailUtil_";
  protected final String TEXT_301 = ".activeLog(log,\"";
  protected final String TEXT_302 = "\");" + NL + "\t\t";
  protected final String TEXT_303 = NL + "\t\tmsgMailUtil_";
  protected final String TEXT_304 = ".getAttachments();" + NL + "\t\t";
  protected final String TEXT_305 = NL + "\t\t\t\t\t\tObject value_";
  protected final String TEXT_306 = "_";
  protected final String TEXT_307 = "=msgMailUtil_";
  protected final String TEXT_308 = ".processMessage(\"";
  protected final String TEXT_309 = "\");" + NL + "\t\t\t\t\t\tif(value_";
  protected final String TEXT_310 = "_";
  protected final String TEXT_311 = "!=null){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_312 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_313 = ".";
  protected final String TEXT_314 = " = String.valueOf(value_";
  protected final String TEXT_315 = "_";
  protected final String TEXT_316 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_317 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_318 = ".";
  protected final String TEXT_319 = " = ParserUtils.parseTo_Date((java.util.Date)value_";
  protected final String TEXT_320 = "_";
  protected final String TEXT_321 = ", ";
  protected final String TEXT_322 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_323 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_324 = ".";
  protected final String TEXT_325 = " = value_";
  protected final String TEXT_326 = "_";
  protected final String TEXT_327 = ".getBytes();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_328 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_329 = ".";
  protected final String TEXT_330 = " = value_";
  protected final String TEXT_331 = "_";
  protected final String TEXT_332 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_333 = NL + "\t\t\t\t\t\t\t\tif(value_";
  protected final String TEXT_334 = "_";
  protected final String TEXT_335 = " instanceof Object[]){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_336 = ".";
  protected final String TEXT_337 = " = java.util.Arrays.asList((Object[])value_";
  protected final String TEXT_338 = "_";
  protected final String TEXT_339 = ");" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_340 = ".";
  protected final String TEXT_341 = " = java.util.Arrays.asList(value_";
  protected final String TEXT_342 = "_";
  protected final String TEXT_343 = ");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_344 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_345 = ".";
  protected final String TEXT_346 = " = ParserUtils.parseTo_";
  protected final String TEXT_347 = "(value_";
  protected final String TEXT_348 = "_";
  protected final String TEXT_349 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_350 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_351 = NL + "\t\t\t\t\t\t\thasData_";
  protected final String TEXT_352 = " = true;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_353 = NL + "\t}catch (java.lang.Exception e_";
  protected final String TEXT_354 = "){" + NL + "\t\t";
  protected final String TEXT_355 = NL + "\t\t\tthrow e_";
  protected final String TEXT_356 = ";" + NL + "\t\t\t";
  protected final String TEXT_357 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_358 = " - \" + e_";
  protected final String TEXT_359 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_360 = NL + "\t\t\t//nothing to do, ignore the exception if don't die on error" + NL + "\t\t\tSystem.err.println(\"Exception in component ";
  protected final String TEXT_361 = ": \" + e_";
  protected final String TEXT_362 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_363 = NL + "\t}" + NL + "\tif(hasData_";
  protected final String TEXT_364 = "){" + NL + "\t\t";
  protected final String TEXT_365 = NL + "\t\t";
  protected final String TEXT_366 = NL;

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
	
    stringBuffer.append(TEXT_29);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        // component id
        String cid = node.getUniqueName();
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__")) && node.getComponent().isLog4JEnabled();
        String filename = ElementParameterParser.getValue(node,"__FILENAME__");
        String directory = ElementParameterParser.getValue(node,"__ATTACHMENT_PATH__");
        String mailType = ElementParameterParser.getValue(node,"__MAIL_TYPE__");
        
    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
		
    stringBuffer.append(TEXT_30);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
		if("MIME".equals(mailType)) {
		
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    
			List<Map<String, String>> mailParts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAIL_PARTS__");
		
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
		for (int i=0; i<mailParts.size(); i++) {
			Map<String, String> lineValue = mailParts.get(i);
			
    stringBuffer.append(TEXT_41);
    stringBuffer.append( lineValue.get("MAIL_PART") );
    stringBuffer.append(TEXT_42);
    
		}
		
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    
		for (int i=0; i<mailParts.size(); i++) {
			Map<String, String> lineValue = mailParts.get(i);
			
    stringBuffer.append(TEXT_45);
    stringBuffer.append( lineValue.get("MULTI_VALUE") );
    stringBuffer.append(TEXT_46);
    
		}
		
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
		for (int i=0; i<mailParts.size(); i++) {
			Map<String, String> lineValue = mailParts.get(i);
			if(("").equals(lineValue.get("PART_SEPARATOR"))){
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append("\"\"");
    stringBuffer.append(TEXT_50);
    }else{
    stringBuffer.append(TEXT_51);
    stringBuffer.append( lineValue.get("PART_SEPARATOR") );
    stringBuffer.append(TEXT_52);
    
			}
		}
		
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    //str is sth like : To:"=?ISO8859-1?B?**code**?=" <sb@company.com> , "=?ISO8859-1?B?**code**?=" <sb@company.com>
    stringBuffer.append(TEXT_56);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    
											//both picture and message context in the email body part, TDI-8651
											
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_135);
    
				 				//both attachment and message context in the email,bug TDI-19065
								
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
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
    
			    	// fixed bug TDI-8586,to deal with attachments download
					
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    // TDI-29179 
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
     if(isLog4jEnabled){ 
    stringBuffer.append(TEXT_230);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
     } 
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
    
			List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
			String firstConnName = "";
			if (conns!=null) {//1
				if (conns.size()>0) {//2
				
					IConnection conn = conns.get(0); //the first connection
					firstConnName = conn.getName();			
					if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3
		
						List<IMetadataColumn> columns=metadata.getListColumns();
						int columnSize = columns.size();
						for (int i=0;i<columnSize;i++) {//4
							IMetadataColumn column=columns.get(i);
							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
    stringBuffer.append(TEXT_246);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_250);
    
								if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { //String and Object
								
    stringBuffer.append(TEXT_251);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_255);
    
								} else if(javaType == JavaTypesManager.DATE) { //Date
								
    stringBuffer.append(TEXT_256);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_260);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_261);
    
								} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]
								
    stringBuffer.append(TEXT_262);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_266);
    
								}else  { //other
								
    stringBuffer.append(TEXT_267);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_269);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_272);
    
								}
								
    stringBuffer.append(TEXT_273);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_276);
    
							if(i==0){
							
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    
							}
						} //4
					}//3
		
		
					if (conns.size()>1) {
						for (int i=1;i<conns.size();i++) {
							IConnection conn2 = conns.get(i);
							if ((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
				    			for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_279);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_283);
    
					 			}
							}
						}
					}
				}//2
	
			}//1

		
    stringBuffer.append(TEXT_284);
     if(!dieOnError){ 
    stringBuffer.append(TEXT_285);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    }
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    
		}
		
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    
    	} else {
		
    stringBuffer.append(TEXT_294);
    stringBuffer.append(TEXT_295);
    
	List<Map<String, String>> msgMailParts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MSG_MAIL_PARTS__");
	
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_299);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    
		}
		
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		String firstConnName = "";
		Map<String,String> partsColumnValues=new java.util.HashMap<String,String>();
		if (conns!=null) {//1
			if (conns.size()>0) {//2
				IConnection conn = conns.get(0); //the first connection
				firstConnName = conn.getName();			
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3
					for (int i=0; i<msgMailParts.size(); i++) {
						Map<String, String> lineValue = msgMailParts.get(i);
						partsColumnValues.put(lineValue.get("SCHEMA_COLUMN"),lineValue.get("MAIL_PART"));
					}
					List<IMetadataColumn> columns=metadata.getListColumns();
					int columnSize = columns.size();
					for (int i=0;i<columnSize;i++) {//4
						IMetadataColumn column=columns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						
    stringBuffer.append(TEXT_305);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(partsColumnValues.get(column.getLabel()));
    stringBuffer.append(TEXT_309);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    
							if(javaType == JavaTypesManager.STRING) {
							
    stringBuffer.append(TEXT_312);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    
							} else if(javaType == JavaTypesManager.DATE) { //Date
							
    stringBuffer.append(TEXT_317);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_322);
    
							} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]
							
    stringBuffer.append(TEXT_323);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    
							}else if(javaType == JavaTypesManager.OBJECT){
							
    stringBuffer.append(TEXT_328);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    
							}else if(javaType == JavaTypesManager.LIST){
							
    stringBuffer.append(TEXT_333);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    
							}else  { //other
							
    stringBuffer.append(TEXT_344);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_346);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    
							}
							
    stringBuffer.append(TEXT_350);
    
						if(i==0){
						
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    
						}
					} //4
				}//3
			}//2
		}//1
		
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
     
		if(dieOnError){ 
			
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    
		}else{
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    
			}
			
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    
		}
		
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    
    	}
		
    stringBuffer.append(TEXT_365);
    
	}
}  
 
    stringBuffer.append(TEXT_366);
    return stringBuffer.toString();
  }
}
