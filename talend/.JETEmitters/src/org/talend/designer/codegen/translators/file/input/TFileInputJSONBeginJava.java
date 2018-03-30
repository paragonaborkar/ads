package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;

public class TFileInputJSONBeginJava
{
  protected static String nl;
  public static synchronized TFileInputJSONBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputJSONBeginJava result = new TFileInputJSONBeginJava();
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
  protected final String TEXT_29 = NL + "\t";
  protected final String TEXT_30 = NL + NL + "    int nb_line_";
  protected final String TEXT_31 = " = 0;" + NL + "" + NL + "    class XML_API_";
  protected final String TEXT_32 = "{" + NL + "        public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "            if (node != null && node instanceof org.dom4j.Element) {" + NL + "                org.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "                if(attri != null && (\"true\").equals(attri.getText())){" + NL + "                    return true;" + NL + "                }" + NL + "            }" + NL + "            return false;" + NL + "        }" + NL + "    " + NL + "        public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "            return node == null ? true : false;" + NL + "        }" + NL + "    " + NL + "        public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "            if (node != null) {" + NL + "                return node.getText().length() == 0;" + NL + "            }" + NL + "            return false;" + NL + "        }" + NL + "    }" + NL + "" + NL + "    class ConvertJSONString_";
  protected final String TEXT_33 = "{" + NL + "        final static int Brace = 0 ; // {" + NL + "        final static int Bracket = 1; // [" + NL + "        private int barceType = -1 ;" + NL + "        private String originalJsonString = \"\" ;" + NL + "        private String originalLoopString = \"\" ;" + NL + "        private String jsonString4XML = null;" + NL + "        private String loopString4XML = null;" + NL + "        private String additionRoot = null;" + NL + "        " + NL + "        public void barceType(){" + NL + "" + NL + "            for (int c = 0; c < originalJsonString.length(); ++c) {" + NL + "                if (originalJsonString.charAt(c) == '{') {" + NL + "                    barceType = Brace;" + NL + "                    break;" + NL + "                } else if (originalJsonString.charAt(c) == '[') {" + NL + "                    barceType = Bracket;" + NL + "                    break;" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public void setJsonString (String originalJsonString) {" + NL + "            this.originalJsonString = originalJsonString;" + NL + "        }" + NL + "        " + NL + "        public void setLoopString (String originalLoopString) {" + NL + "            this.originalLoopString = originalLoopString;" + NL + "        }" + NL + "        " + NL + "        public String getJsonString4XML(){" + NL + "            return jsonString4XML;" + NL + "        }" + NL + "        " + NL + "        public String getLoopString4XML(){" + NL + "            if(loopString4XML.length()>1 && loopString4XML.endsWith(\"/\")){" + NL + "                loopString4XML = loopString4XML.substring(0, loopString4XML.length()-1);" + NL + "            }" + NL + "            return loopString4XML;" + NL + "        }" + NL + "    " + NL + "        public void setAdditionRoot (String additionRoot) {" + NL + "            this.additionRoot = additionRoot;" + NL + "        }" + NL + "                    " + NL + "        public String getAdditionRoot (){" + NL + "            return additionRoot;" + NL + "        }" + NL + "                    " + NL + "        " + NL + "        public void generate() {" + NL + "            barceType();" + NL + "            jsonString4XML = originalJsonString;" + NL + "            loopString4XML = originalLoopString;" + NL + "            if (Brace == barceType) {" + NL + "                if (isNeedAddRoot(originalJsonString)) {" + NL + "                    jsonString4XML = \"{ \\\"root\\\": \" + originalJsonString + \" }\";" + NL + "                    loopString4XML = \"root\" + originalLoopString;" + NL + "                    setAdditionRoot(\"root\");" + NL + "                }" + NL + "            } else if (Bracket == barceType) {" + NL + "                jsonString4XML = \"{ \\\"root\\\" : { \\\"object\\\": \"" + NL + "                        + originalJsonString + \" } }\";" + NL + "                loopString4XML = \"root/object\" + originalLoopString;" + NL + "                setAdditionRoot(\"object\");" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public boolean isNeedAddRoot(String originalJsonString) {" + NL + "            boolean isNeedAddRoot = false;" + NL + "            net.sf.json.JSONObject jso = net.sf.json.JSONObject" + NL + "                    .fromObject(originalJsonString);" + NL + "            String jsonKey = \"\";" + NL + "            Object firstObject = null;" + NL + "            if (jso.names().size() == 1) {" + NL + "                jsonKey = jso.names().get(0).toString();" + NL + "                firstObject = jso.get(jsonKey);" + NL + "            }" + NL + "            if (jso.size() > 1" + NL + "                    || (firstObject != null" + NL + "                            && firstObject instanceof net.sf.json.JSONArray && ((net.sf.json.JSONArray) firstObject)" + NL + "                            .size() > 1)) {" + NL + "                isNeedAddRoot = true;" + NL + "            }" + NL + "            return isNeedAddRoot;" + NL + "        }" + NL + "                " + NL + "    }" + NL + "" + NL + "        ConvertJSONString_";
  protected final String TEXT_34 = " cjs_";
  protected final String TEXT_35 = " = new ConvertJSONString_";
  protected final String TEXT_36 = "();" + NL + "        " + NL + "        de.odysseus.staxon.json.JsonXMLConfig config_";
  protected final String TEXT_37 = " = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).build();" + NL + "        de.odysseus.staxon.json.JsonXMLInputFactory jsonXMLInputFactory_";
  protected final String TEXT_38 = " = new de.odysseus.staxon.json.JsonXMLInputFactory(config_";
  protected final String TEXT_39 = ");" + NL + "        javax.xml.stream.XMLOutputFactory xmlOutputFactory_";
  protected final String TEXT_40 = " = javax.xml.stream.XMLOutputFactory.newInstance();" + NL + "        boolean isGetWholeJson_";
  protected final String TEXT_41 = " = false;" + NL;
  protected final String TEXT_42 = NL + "            class OriginalJSONString_";
  protected final String TEXT_43 = " {" + NL + "" + NL + "                String originalJSONString = null;" + NL + "                java.io.ByteArrayInputStream bais = null;" + NL + "                java.io.ByteArrayOutputStream baos = null;" + NL + "                de.odysseus.staxon.json.JsonXMLConfig config = null;" + NL + "                de.odysseus.staxon.json.JsonXMLOutputFactory jxof = null;" + NL + "                " + NL + "                public String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson) throws Exception {" + NL + "" + NL + "                    try {" + NL + "                        bais = new ByteArrayInputStream(xmlString.getBytes(encoding));" + NL + "                        baos = new java.io.ByteArrayOutputStream();" + NL + "                        config = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).autoArray(true).build();" + NL + "                        jxof = new de.odysseus.staxon.json.JsonXMLOutputFactory(config);" + NL + "                        javax.xml.stream.XMLEventReader xmlEventReader = javax.xml.stream.XMLInputFactory.newInstance().createXMLEventReader(bais);" + NL + "                        javax.xml.stream.XMLEventWriter xmLEventWriter = jxof.createXMLEventWriter(baos,encoding);" + NL + "                        xmLEventWriter.add(xmlEventReader);" + NL + "                        xmlEventReader.close();" + NL + "                        xmLEventWriter.close();" + NL + "                        net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(baos.toString());" + NL + "                        net.sf.json.JSONObject originalJsonObject = null;" + NL + "                        if (!json.isNullObject()) {" + NL + "                            if (additionRoot == null) {" + NL + "                                originalJSONString = json.toString();" + NL + "                            } else {" + NL + "                                if (isGetWholeJson) {" + NL + "                                    originalJsonObject = json.getJSONObject(additionRoot);" + NL + "                                    if (!originalJsonObject.isNullObject()) {" + NL + "                                        originalJSONString = originalJsonObject.toString();" + NL + "                                    } " + NL + "                                }else {" + NL + "                                        originalJSONString = json.toString();" + NL + "                                }" + NL + "                            }" + NL + "                        }" + NL + "                    } finally {" + NL + "                        baos.close();" + NL + "                        if(bais!=null){" + NL + "                            bais.close();" + NL + "                        }" + NL + "                    }" + NL + "                    " + NL + "                    return originalJSONString;" + NL + "                }" + NL + "            }" + NL + "            " + NL + "            OriginalJSONString_";
  protected final String TEXT_44 = " originalJSONString_";
  protected final String TEXT_45 = " = new OriginalJSONString_";
  protected final String TEXT_46 = "();";
  protected final String TEXT_47 = "        " + NL + "        " + NL + "        org.dom4j.io.SAXReader reader_";
  protected final String TEXT_48 = " = new org.dom4j.io.SAXReader();" + NL + "        Object filename_";
  protected final String TEXT_49 = " = null;" + NL + "        try {" + NL + "            filename_";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = ";" + NL + "        } catch(java.lang.Exception e_";
  protected final String TEXT_52 = ") {";
  protected final String TEXT_53 = NL + "            \tthrow(e_";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_57 = " - \" + e_";
  protected final String TEXT_58 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_59 = NL + "\t            System.err.println(e_";
  protected final String TEXT_60 = ".getMessage());";
  protected final String TEXT_61 = NL + "        }" + NL + "                " + NL + "        boolean isValidFile_";
  protected final String TEXT_62 = " = true;" + NL + "        org.dom4j.Document doc_";
  protected final String TEXT_63 = " = null;" + NL + "        java.io.BufferedReader br_";
  protected final String TEXT_64 = " = null;" + NL + "        java.lang.StringBuilder jsonBuffer_";
  protected final String TEXT_65 = " =  new java.lang.StringBuilder(\"\");" + NL + "        String jsonStr_";
  protected final String TEXT_66 = " = null;" + NL + "        String xmlStr_";
  protected final String TEXT_67 = " = \"\";" + NL + "        String line_";
  protected final String TEXT_68 = " = null;" + NL + "        " + NL + "        String loopQuery_";
  protected final String TEXT_69 = " =  ";
  protected final String TEXT_70 = " ;" + NL + "        java.io.ByteArrayInputStream bais_";
  protected final String TEXT_71 = " = null;" + NL + "        java.io.ByteArrayOutputStream  baos_";
  protected final String TEXT_72 = " = new java.io.ByteArrayOutputStream();" + NL + "            " + NL + "        try{" + NL + "            if(filename_";
  protected final String TEXT_73 = " instanceof java.io.InputStream){" + NL + "                br_";
  protected final String TEXT_74 = " = new java.io.BufferedReader(new java.io.InputStreamReader((java.io.InputStream)filename_";
  protected final String TEXT_75 = ",";
  protected final String TEXT_76 = "));" + NL + "            }else{";
  protected final String TEXT_77 = NL + "            \t    br_";
  protected final String TEXT_78 = " = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_79 = ")), ";
  protected final String TEXT_80 = "));";
  protected final String TEXT_81 = NL + "\t\t\t\t\tjava.net.URL url_";
  protected final String TEXT_82 = " = new java.net.URL(";
  protected final String TEXT_83 = ");" + NL + "\t\t\t\t\tjava.net.URLConnection urlConn_";
  protected final String TEXT_84 = " = url_";
  protected final String TEXT_85 = ".openConnection();" + NL + "\t\t\t\t\tbr_";
  protected final String TEXT_86 = " = new java.io.BufferedReader( new java.io.InputStreamReader(urlConn_";
  protected final String TEXT_87 = ".getInputStream(),";
  protected final String TEXT_88 = "));";
  protected final String TEXT_89 = NL + "            }" + NL + "            while ((line_";
  protected final String TEXT_90 = " = br_";
  protected final String TEXT_91 = ".readLine()) != null){" + NL + "                jsonBuffer_";
  protected final String TEXT_92 = ".append(line_";
  protected final String TEXT_93 = ");" + NL + "            }" + NL + "            jsonStr_";
  protected final String TEXT_94 = " = jsonBuffer_";
  protected final String TEXT_95 = ".toString();" + NL + "            cjs_";
  protected final String TEXT_96 = ".setJsonString(jsonStr_";
  protected final String TEXT_97 = ");" + NL + "            cjs_";
  protected final String TEXT_98 = ".setLoopString(loopQuery_";
  protected final String TEXT_99 = ");" + NL + "            cjs_";
  protected final String TEXT_100 = ".generate();" + NL + "            jsonStr_";
  protected final String TEXT_101 = " = cjs_";
  protected final String TEXT_102 = ".getJsonString4XML();" + NL + "            loopQuery_";
  protected final String TEXT_103 = " = cjs_";
  protected final String TEXT_104 = ".getLoopString4XML();" + NL + "            bais_";
  protected final String TEXT_105 = " = new ByteArrayInputStream(jsonStr_";
  protected final String TEXT_106 = ".getBytes(";
  protected final String TEXT_107 = "));" + NL + "            javax.xml.stream.XMLEventReader xmlEventReader_";
  protected final String TEXT_108 = " = jsonXMLInputFactory_";
  protected final String TEXT_109 = ".createXMLEventReader(bais_";
  protected final String TEXT_110 = ");" + NL + "            javax.xml.stream.XMLEventWriter xmLEventWriter_";
  protected final String TEXT_111 = " = xmlOutputFactory_";
  protected final String TEXT_112 = ".createXMLEventWriter(baos_";
  protected final String TEXT_113 = ",";
  protected final String TEXT_114 = ");" + NL + "            xmLEventWriter_";
  protected final String TEXT_115 = ".add(xmlEventReader_";
  protected final String TEXT_116 = ");" + NL + "            //convert json string to xml" + NL + "            xmlStr_";
  protected final String TEXT_117 = " = baos_";
  protected final String TEXT_118 = ".toString();  " + NL + "            xmLEventWriter_";
  protected final String TEXT_119 = ".close();" + NL + "            xmlEventReader_";
  protected final String TEXT_120 = ".close();" + NL + "            doc_";
  protected final String TEXT_121 = "= reader_";
  protected final String TEXT_122 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_123 = "));" + NL + "        }catch(java.lang.Exception e_";
  protected final String TEXT_124 = "){";
  protected final String TEXT_125 = NL + "                throw(e_";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = NL + "\t\t\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_129 = " - \" + e_";
  protected final String TEXT_130 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_131 = NL + "                    System.err.println( e_";
  protected final String TEXT_132 = ".getMessage());" + NL + "                    isValidFile_";
  protected final String TEXT_133 = " = false;";
  protected final String TEXT_134 = NL + "        } finally {" + NL + "            if(br_";
  protected final String TEXT_135 = "!=null) {" + NL + "                br_";
  protected final String TEXT_136 = ".close();" + NL + "            }" + NL + "            baos_";
  protected final String TEXT_137 = ".close();" + NL + "            if(bais_";
  protected final String TEXT_138 = "!=null){" + NL + "                bais_";
  protected final String TEXT_139 = ".close();" + NL + "            }" + NL + "        }" + NL + "        if(isValidFile_";
  protected final String TEXT_140 = "){" + NL + "    " + NL + "            org.dom4j.XPath x_";
  protected final String TEXT_141 = " = doc_";
  protected final String TEXT_142 = ".createXPath(loopQuery_";
  protected final String TEXT_143 = "); " + NL + "            java.util.HashMap<String,String> xmlNameSpaceMap_";
  protected final String TEXT_144 = " = new java.util.HashMap<String, String>();" + NL + "            x_";
  protected final String TEXT_145 = " = doc_";
  protected final String TEXT_146 = ".createXPath(loopQuery_";
  protected final String TEXT_147 = "); " + NL + "            x_";
  protected final String TEXT_148 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_149 = "); " + NL + "            java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_150 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_151 = ".selectNodes(doc_";
  protected final String TEXT_152 = ");  " + NL + "            XML_API_";
  protected final String TEXT_153 = " xml_api_";
  protected final String TEXT_154 = " = new XML_API_";
  protected final String TEXT_155 = "();" + NL + "            String str_";
  protected final String TEXT_156 = " = \"\";" + NL + "            org.dom4j.Node node_";
  protected final String TEXT_157 = " = null;" + NL + "    " + NL + "            //init all mapping xpaths";
  protected final String TEXT_158 = NL + "                org.dom4j.XPath xTmp";
  protected final String TEXT_159 = "_";
  protected final String TEXT_160 = " = org.dom4j.DocumentHelper.createXPath(";
  protected final String TEXT_161 = ");" + NL + "                xTmp";
  protected final String TEXT_162 = "_";
  protected final String TEXT_163 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_164 = ");";
  protected final String TEXT_165 = NL + NL + "            for (org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_166 = ": nodeList_";
  protected final String TEXT_167 = ") {" + NL + "                nb_line_";
  protected final String TEXT_168 = "++;";
  protected final String TEXT_169 = NL + "    ";
  protected final String TEXT_170 = " = null;            ";
  protected final String TEXT_171 = NL + "                    boolean whetherReject_";
  protected final String TEXT_172 = " = false;";
  protected final String TEXT_173 = NL + "                    ";
  protected final String TEXT_174 = " = new ";
  protected final String TEXT_175 = "Struct();" + NL + "                    try{";
  protected final String TEXT_176 = NL + "                                isGetWholeJson_";
  protected final String TEXT_177 = "  = true;";
  protected final String TEXT_178 = NL + "                        Object obj";
  protected final String TEXT_179 = "_";
  protected final String TEXT_180 = " = xTmp";
  protected final String TEXT_181 = "_";
  protected final String TEXT_182 = ".evaluate(temp_";
  protected final String TEXT_183 = ");" + NL + "                        if(obj";
  protected final String TEXT_184 = "_";
  protected final String TEXT_185 = " == null) {" + NL + "                            node_";
  protected final String TEXT_186 = " = null;";
  protected final String TEXT_187 = NL + "                               str_";
  protected final String TEXT_188 = " = null;";
  protected final String TEXT_189 = NL + "                               str_";
  protected final String TEXT_190 = " = \"\";";
  protected final String TEXT_191 = NL + "                        } else if(obj";
  protected final String TEXT_192 = "_";
  protected final String TEXT_193 = " instanceof org.dom4j.Node) {" + NL + "                            node_";
  protected final String TEXT_194 = " = (org.dom4j.Node)obj";
  protected final String TEXT_195 = "_";
  protected final String TEXT_196 = ";";
  protected final String TEXT_197 = NL + "                                str_";
  protected final String TEXT_198 = " = originalJSONString_";
  protected final String TEXT_199 = ".getOriginalJSONString(node_";
  protected final String TEXT_200 = ".asXML(),cjs_";
  protected final String TEXT_201 = ".getAdditionRoot(),";
  protected final String TEXT_202 = ",isGetWholeJson_";
  protected final String TEXT_203 = ");" + NL + "                                isGetWholeJson_";
  protected final String TEXT_204 = " = false;";
  protected final String TEXT_205 = NL + "                                str_";
  protected final String TEXT_206 = " = org.jaxen.function.StringFunction.evaluate(node_";
  protected final String TEXT_207 = ",org.jaxen.dom4j.DocumentNavigator.getInstance());";
  protected final String TEXT_208 = NL + "                        } else if(obj";
  protected final String TEXT_209 = "_";
  protected final String TEXT_210 = " instanceof String || obj";
  protected final String TEXT_211 = "_";
  protected final String TEXT_212 = " instanceof Number){" + NL + "                            node_";
  protected final String TEXT_213 = " = temp_";
  protected final String TEXT_214 = ";" + NL + "                            str_";
  protected final String TEXT_215 = " = String.valueOf(obj";
  protected final String TEXT_216 = "_";
  protected final String TEXT_217 = ");" + NL + "                        } else if(obj";
  protected final String TEXT_218 = "_";
  protected final String TEXT_219 = " instanceof java.util.List){" + NL + "                            java.util.List<org.dom4j.Node> nodes_";
  protected final String TEXT_220 = " = (java.util.List<org.dom4j.Node>)obj";
  protected final String TEXT_221 = "_";
  protected final String TEXT_222 = ";" + NL + "                            node_";
  protected final String TEXT_223 = " = nodes_";
  protected final String TEXT_224 = ".size()>0 ? nodes_";
  protected final String TEXT_225 = ".get(0) : null;";
  protected final String TEXT_226 = NL + "                                if(node_";
  protected final String TEXT_227 = "==null){" + NL + "                                    str_";
  protected final String TEXT_228 = " = null;" + NL + "                                }else{" + NL + "                                    str_";
  protected final String TEXT_229 = " = originalJSONString_";
  protected final String TEXT_230 = ".getOriginalJSONString(node_";
  protected final String TEXT_231 = ".asXML(),cjs_";
  protected final String TEXT_232 = ".getAdditionRoot(),";
  protected final String TEXT_233 = ",isGetWholeJson_";
  protected final String TEXT_234 = ");" + NL + "                                }" + NL + "                                isGetWholeJson_";
  protected final String TEXT_235 = " = false;";
  protected final String TEXT_236 = NL + "                                str_";
  protected final String TEXT_237 = " = node_";
  protected final String TEXT_238 = "==null?\"\":org.jaxen.function.StringFunction.evaluate(node_";
  protected final String TEXT_239 = ",org.jaxen.dom4j.DocumentNavigator.getInstance());";
  protected final String TEXT_240 = NL + "                        }";
  protected final String TEXT_241 = NL + "                                        ";
  protected final String TEXT_242 = ".";
  protected final String TEXT_243 = " = str_";
  protected final String TEXT_244 = ";";
  protected final String TEXT_245 = NL + "                                            if(xml_api_";
  protected final String TEXT_246 = ".isDefNull(node_";
  protected final String TEXT_247 = ")){";
  protected final String TEXT_248 = NL + "                                                    ";
  protected final String TEXT_249 = ".";
  protected final String TEXT_250 = " =null;" + NL + "                                            }else if(xml_api_";
  protected final String TEXT_251 = ".isEmpty(node_";
  protected final String TEXT_252 = ")){";
  protected final String TEXT_253 = NL + "                                                ";
  protected final String TEXT_254 = ".";
  protected final String TEXT_255 = " =\"\";" + NL + "                                            }else if(xml_api_";
  protected final String TEXT_256 = ".isMissing(node_";
  protected final String TEXT_257 = " )){ ";
  protected final String TEXT_258 = NL + "                                                ";
  protected final String TEXT_259 = ".";
  protected final String TEXT_260 = " =";
  protected final String TEXT_261 = ";" + NL + "                                            }else{";
  protected final String TEXT_262 = NL + "                                            if(xml_api_";
  protected final String TEXT_263 = ".isEmpty(node_";
  protected final String TEXT_264 = ")){";
  protected final String TEXT_265 = NL + "                                                ";
  protected final String TEXT_266 = ".";
  protected final String TEXT_267 = " =\"\";" + NL + "                                            }else if(xml_api_";
  protected final String TEXT_268 = ".isMissing(node_";
  protected final String TEXT_269 = " )){ ";
  protected final String TEXT_270 = NL + "                                                ";
  protected final String TEXT_271 = ".";
  protected final String TEXT_272 = " =";
  protected final String TEXT_273 = ";" + NL + "                                            }else{";
  protected final String TEXT_274 = "  " + NL + "                                            if(xml_api_";
  protected final String TEXT_275 = ".isDefNull(node_";
  protected final String TEXT_276 = ")){";
  protected final String TEXT_277 = NL + "                                                ";
  protected final String TEXT_278 = ".";
  protected final String TEXT_279 = " =null;" + NL + "                                            }else if(xml_api_";
  protected final String TEXT_280 = ".isEmpty(node_";
  protected final String TEXT_281 = ") || xml_api_";
  protected final String TEXT_282 = ".isMissing(node_";
  protected final String TEXT_283 = ")){";
  protected final String TEXT_284 = NL + "                                                ";
  protected final String TEXT_285 = ".";
  protected final String TEXT_286 = "=";
  protected final String TEXT_287 = ";" + NL + "                                            }else{";
  protected final String TEXT_288 = NL + "                                            if(xml_api_";
  protected final String TEXT_289 = ".isMissing(node_";
  protected final String TEXT_290 = ") || xml_api_";
  protected final String TEXT_291 = ".isEmpty(node_";
  protected final String TEXT_292 = ")){";
  protected final String TEXT_293 = NL + "                                                ";
  protected final String TEXT_294 = ".";
  protected final String TEXT_295 = " =";
  protected final String TEXT_296 = ";" + NL + "                                            }else{";
  protected final String TEXT_297 = NL + "                                        ";
  protected final String TEXT_298 = ".";
  protected final String TEXT_299 = " = str_";
  protected final String TEXT_300 = ";";
  protected final String TEXT_301 = NL + "                                            ";
  protected final String TEXT_302 = ".";
  protected final String TEXT_303 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_304 = ", ";
  protected final String TEXT_305 = ",false);";
  protected final String TEXT_306 = NL + "                                            ";
  protected final String TEXT_307 = ".";
  protected final String TEXT_308 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_309 = ", ";
  protected final String TEXT_310 = ");";
  protected final String TEXT_311 = "                          ";
  protected final String TEXT_312 = NL + "                                        ";
  protected final String TEXT_313 = ".";
  protected final String TEXT_314 = " = str_";
  protected final String TEXT_315 = ".getBytes(";
  protected final String TEXT_316 = ");";
  protected final String TEXT_317 = NL + "                                        ";
  protected final String TEXT_318 = ".";
  protected final String TEXT_319 = " = ParserUtils.parseTo_";
  protected final String TEXT_320 = "(ParserUtils.parseTo_Number(str_";
  protected final String TEXT_321 = ", ";
  protected final String TEXT_322 = ", ";
  protected final String TEXT_323 = "));";
  protected final String TEXT_324 = NL + "                                        ";
  protected final String TEXT_325 = ".";
  protected final String TEXT_326 = " = ParserUtils.parseTo_";
  protected final String TEXT_327 = "(str_";
  protected final String TEXT_328 = ");";
  protected final String TEXT_329 = NL + "                                            }";
  protected final String TEXT_330 = NL + "                        ";
  protected final String TEXT_331 = " = null; ";
  protected final String TEXT_332 = NL + "            " + NL + "                } catch (java.lang.Exception e_";
  protected final String TEXT_333 = ") {" + NL + "                    whetherReject_";
  protected final String TEXT_334 = " = true;";
  protected final String TEXT_335 = NL + "                        throw(e_";
  protected final String TEXT_336 = ");";
  protected final String TEXT_337 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_338 = " - \" + e_";
  protected final String TEXT_339 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_340 = NL + "                            ";
  protected final String TEXT_341 = " = new ";
  protected final String TEXT_342 = "Struct();";
  protected final String TEXT_343 = NL + "                                ";
  protected final String TEXT_344 = ".";
  protected final String TEXT_345 = " = ";
  protected final String TEXT_346 = ".";
  protected final String TEXT_347 = ";";
  protected final String TEXT_348 = NL + "                            ";
  protected final String TEXT_349 = ".errorMessage = e_";
  protected final String TEXT_350 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_351 = ";";
  protected final String TEXT_352 = NL + "                            ";
  protected final String TEXT_353 = " = null;";
  protected final String TEXT_354 = NL + "                            System.err.println(e_";
  protected final String TEXT_355 = ".getMessage());";
  protected final String TEXT_356 = NL + "                            ";
  protected final String TEXT_357 = " = null;";
  protected final String TEXT_358 = NL + "                            ";
  protected final String TEXT_359 = ".errorMessage = e_";
  protected final String TEXT_360 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_361 = ";";
  protected final String TEXT_362 = NL + "                }";
  protected final String TEXT_363 = "if(!whetherReject_";
  protected final String TEXT_364 = ") { ";
  protected final String TEXT_365 = "      " + NL + "                                 if(";
  protected final String TEXT_366 = " == null){ ";
  protected final String TEXT_367 = NL + "                                     ";
  protected final String TEXT_368 = " = new ";
  protected final String TEXT_369 = "Struct();" + NL + "                                 }";
  protected final String TEXT_370 = NL + "                                    ";
  protected final String TEXT_371 = ".";
  protected final String TEXT_372 = " = ";
  protected final String TEXT_373 = ".";
  protected final String TEXT_374 = ";                 ";
  protected final String TEXT_375 = " } ";
  protected final String TEXT_376 = NL + "\t";
  protected final String TEXT_377 = NL + "class JsonPathCache_";
  protected final String TEXT_378 = " {" + NL + "\tfinal java.util.Map<String,com.jayway.jsonpath.JsonPath> jsonPathString2compiledJsonPath = new java.util.HashMap<String,com.jayway.jsonpath.JsonPath>();" + NL + "\t" + NL + "\tpublic com.jayway.jsonpath.JsonPath getCompiledJsonPath(String jsonPath) {" + NL + "\t\tif(jsonPathString2compiledJsonPath.containsKey(jsonPath)) {" + NL + "\t\t\treturn jsonPathString2compiledJsonPath.get(jsonPath);" + NL + "\t\t} else {" + NL + "\t\t\tcom.jayway.jsonpath.JsonPath compiledLoopPath = com.jayway.jsonpath.JsonPath.compile(jsonPath);" + NL + "\t\t\tjsonPathString2compiledJsonPath.put(jsonPath,compiledLoopPath);" + NL + "\t\t\treturn compiledLoopPath;" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL + "" + NL + "int nb_line_";
  protected final String TEXT_379 = " = 0;" + NL + "" + NL + "JsonPathCache_";
  protected final String TEXT_380 = " jsonPathCache_";
  protected final String TEXT_381 = " = new JsonPathCache_";
  protected final String TEXT_382 = "();" + NL + "" + NL + "String loopPath_";
  protected final String TEXT_383 = " = ";
  protected final String TEXT_384 = ";" + NL + "java.util.List<Object> resultset_";
  protected final String TEXT_385 = " = new java.util.ArrayList<Object>();" + NL + "" + NL + "java.io.InputStream is_";
  protected final String TEXT_386 = " = null;" + NL + "com.jayway.jsonpath.ParseContext parseContext_";
  protected final String TEXT_387 = " = com.jayway.jsonpath.JsonPath.using(com.jayway.jsonpath.Configuration.defaultConfiguration());" + NL + "try {" + NL + "\t";
  protected final String TEXT_388 = NL + "\tis_";
  protected final String TEXT_389 = " = new java.io.FileInputStream(";
  protected final String TEXT_390 = ");" + NL + "\t";
  protected final String TEXT_391 = NL + "\tjava.net.URL url_";
  protected final String TEXT_392 = " = new java.net.URL(";
  protected final String TEXT_393 = ");" + NL + "\tjava.net.URLConnection urlConn_";
  protected final String TEXT_394 = " = url_";
  protected final String TEXT_395 = ".openConnection();" + NL + "\tis_";
  protected final String TEXT_396 = " = urlConn_";
  protected final String TEXT_397 = ".getInputStream();" + NL + "\t";
  protected final String TEXT_398 = NL + "\tcom.jayway.jsonpath.ReadContext document_";
  protected final String TEXT_399 = " = parseContext_";
  protected final String TEXT_400 = ".parse(is_";
  protected final String TEXT_401 = ",";
  protected final String TEXT_402 = ");" + NL + "\tcom.jayway.jsonpath.JsonPath compiledLoopPath_";
  protected final String TEXT_403 = " = jsonPathCache_";
  protected final String TEXT_404 = ".getCompiledJsonPath(loopPath_";
  protected final String TEXT_405 = ");" + NL + "\tObject result_";
  protected final String TEXT_406 = " = document_";
  protected final String TEXT_407 = ".read(compiledLoopPath_";
  protected final String TEXT_408 = ",net.minidev.json.JSONObject.class);" + NL + "\tif (result_";
  protected final String TEXT_409 = " instanceof net.minidev.json.JSONArray) {" + NL + "\t\tresultset_";
  protected final String TEXT_410 = " = (net.minidev.json.JSONArray) result_";
  protected final String TEXT_411 = ";" + NL + "\t} else {" + NL + "\t\tresultset_";
  protected final String TEXT_412 = ".add(result_";
  protected final String TEXT_413 = ");" + NL + "\t}" + NL + "} catch (java.lang.Exception e_";
  protected final String TEXT_414 = ") {";
  protected final String TEXT_415 = NL + "\tthrow(e_";
  protected final String TEXT_416 = ");";
  protected final String TEXT_417 = NL + "\tlog.error(\"";
  protected final String TEXT_418 = " - \" + e_";
  protected final String TEXT_419 = ".getMessage());" + NL + "\t";
  protected final String TEXT_420 = NL + "\tSystem.err.println(e_";
  protected final String TEXT_421 = ".getMessage());";
  protected final String TEXT_422 = NL + "} finally {" + NL + "\tif(is_";
  protected final String TEXT_423 = " != null) {" + NL + "\t\tis_";
  protected final String TEXT_424 = ".close();" + NL + "\t}" + NL + "}" + NL + "" + NL + "String jsonPath_";
  protected final String TEXT_425 = " = null;" + NL + "com.jayway.jsonpath.JsonPath compiledJsonPath_";
  protected final String TEXT_426 = " = null;" + NL + "" + NL + "Object value_";
  protected final String TEXT_427 = " = null;";
  protected final String TEXT_428 = NL + "\tlog.info(\"";
  protected final String TEXT_429 = " - Retrieving records from data.\");";
  protected final String TEXT_430 = NL + "for(Object row_";
  protected final String TEXT_431 = " : resultset_";
  protected final String TEXT_432 = ") {" + NL + "\tnb_line_";
  protected final String TEXT_433 = "++;";
  protected final String TEXT_434 = NL + "\t\t\t";
  protected final String TEXT_435 = " = null;\t\t\t";
  protected final String TEXT_436 = NL + "\tboolean whetherReject_";
  protected final String TEXT_437 = " = false;" + NL + "\t";
  protected final String TEXT_438 = " = new ";
  protected final String TEXT_439 = "Struct();" + NL + "\t" + NL + "\ttry{";
  protected final String TEXT_440 = NL + "\t\t\t\tjsonPath_";
  protected final String TEXT_441 = " = ";
  protected final String TEXT_442 = ";" + NL + "\t\t\t\tcompiledJsonPath_";
  protected final String TEXT_443 = " = jsonPathCache_";
  protected final String TEXT_444 = ".getCompiledJsonPath(jsonPath_";
  protected final String TEXT_445 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tvalue_";
  protected final String TEXT_446 = " = compiledJsonPath_";
  protected final String TEXT_447 = ".read(row_";
  protected final String TEXT_448 = ");";
  protected final String TEXT_449 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_450 = ".";
  protected final String TEXT_451 = " = value_";
  protected final String TEXT_452 = " == null ? ";
  protected final String TEXT_453 = NL;
  protected final String TEXT_454 = NL + "\t\t";
  protected final String TEXT_455 = NL + "\t\t";
  protected final String TEXT_456 = NL + " : value_";
  protected final String TEXT_457 = ".toString();";
  protected final String TEXT_458 = NL + "\t\t\t\t\t\tif(value_";
  protected final String TEXT_459 = " != null && !value_";
  protected final String TEXT_460 = ".toString().isEmpty()) {";
  protected final String TEXT_461 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_462 = ".";
  protected final String TEXT_463 = " = value_";
  protected final String TEXT_464 = ".toString();";
  protected final String TEXT_465 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_466 = ".";
  protected final String TEXT_467 = " = ParserUtils.parseTo_Date(value_";
  protected final String TEXT_468 = ".toString(), ";
  protected final String TEXT_469 = ");";
  protected final String TEXT_470 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_471 = ".";
  protected final String TEXT_472 = " = ParserUtils.parseTo_";
  protected final String TEXT_473 = "(ParserUtils.parseTo_Number(value_";
  protected final String TEXT_474 = ".toString(), ";
  protected final String TEXT_475 = ", ";
  protected final String TEXT_476 = "));";
  protected final String TEXT_477 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_478 = ".";
  protected final String TEXT_479 = " = value_";
  protected final String TEXT_480 = ".toString().getBytes(";
  protected final String TEXT_481 = ");";
  protected final String TEXT_482 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_483 = ".";
  protected final String TEXT_484 = " = ParserUtils.parseTo_";
  protected final String TEXT_485 = "(value_";
  protected final String TEXT_486 = ".toString());";
  protected final String TEXT_487 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_488 = ".";
  protected final String TEXT_489 = " = ";
  protected final String TEXT_490 = NL;
  protected final String TEXT_491 = NL + "\t\t";
  protected final String TEXT_492 = NL + "\t\t";
  protected final String TEXT_493 = NL + ";" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_494 = NL + "\t\t\t\t} catch (com.jayway.jsonpath.PathNotFoundException e_";
  protected final String TEXT_495 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_496 = ".";
  protected final String TEXT_497 = " = ";
  protected final String TEXT_498 = NL;
  protected final String TEXT_499 = NL + "\t\t";
  protected final String TEXT_500 = NL + "\t\t";
  protected final String TEXT_501 = NL + ";" + NL + "\t\t\t\t}\t\t\t\t";
  protected final String TEXT_502 = " ";
  protected final String TEXT_503 = NL + "        ";
  protected final String TEXT_504 = " = null; ";
  protected final String TEXT_505 = NL + "    } catch (java.lang.Exception e_";
  protected final String TEXT_506 = ") {" + NL + "        whetherReject_";
  protected final String TEXT_507 = " = true;";
  protected final String TEXT_508 = NL + "        throw(e_";
  protected final String TEXT_509 = ");";
  protected final String TEXT_510 = NL + "                ";
  protected final String TEXT_511 = " = new ";
  protected final String TEXT_512 = "Struct();";
  protected final String TEXT_513 = NL + "               \t\t";
  protected final String TEXT_514 = ".";
  protected final String TEXT_515 = " = ";
  protected final String TEXT_516 = ".";
  protected final String TEXT_517 = ";";
  protected final String TEXT_518 = NL + "                ";
  protected final String TEXT_519 = ".errorMessage = e_";
  protected final String TEXT_520 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_521 = ";";
  protected final String TEXT_522 = NL + "                ";
  protected final String TEXT_523 = " = null;";
  protected final String TEXT_524 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_525 = " - \" + e_";
  protected final String TEXT_526 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_527 = NL + "                System.err.println(e_";
  protected final String TEXT_528 = ".getMessage());";
  protected final String TEXT_529 = NL + "                ";
  protected final String TEXT_530 = " = null;";
  protected final String TEXT_531 = NL + "                ";
  protected final String TEXT_532 = ".errorMessage = e_";
  protected final String TEXT_533 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_534 = ";";
  protected final String TEXT_535 = NL + "    }" + NL + "//}";
  protected final String TEXT_536 = NL + "\t";
  protected final String TEXT_537 = NL + "  class JSONUtil_";
  protected final String TEXT_538 = "{" + NL + "      public int getData(String query,javax.script.Invocable invocableEngine,java.util.List<org.json.simple.JSONArray> jsonResultList,int recordMaxSize){" + NL + "          try{" + NL + "              //only 2 types: String/Boolean" + NL + "              String resultObj = invocableEngine.invokeFunction(\"jsonPath\",query).toString();" + NL + "              if(!\"false\".equals(resultObj)){" + NL + "\t              org.json.simple.JSONArray resultArray= (org.json.simple.JSONArray)org.json.simple.JSONValue.parse(resultObj);" + NL + "\t              jsonResultList.add(resultArray);" + NL + "\t              if(recordMaxSize != -1 && recordMaxSize != resultArray.size()){" + NL + "\t\t             //just give an error, don't stop" + NL + "\t\t\t\t\t";
  protected final String TEXT_539 = NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_540 = " - The Json resource datas maybe have some problems, please make sure the data structure with the same fields.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_541 = NL + "\t\t              System.err.println(\"The Json resource datas maybe have some problems, please make sure the data structure with the same fields.\");" + NL + "\t               }" + NL + "\t               recordMaxSize = Math.max(recordMaxSize, resultArray.size());" + NL + "               }else{" + NL + "\t\t\t\t\t";
  protected final String TEXT_542 = NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_543 = " - Can't find any data with JSONPath \" + query);" + NL + "\t\t\t\t\t";
  protected final String TEXT_544 = NL + "\t               System.err.println(\"Can't find any data with JSONPath \" + query);" + NL + "\t               //add null to take a place in List(buffer)" + NL + "\t               jsonResultList.add(null); " + NL + "               }" + NL + "          }catch(java.lang.Exception e){" + NL + "\t\t\t\t";
  protected final String TEXT_545 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_546 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_547 = NL + "              e.printStackTrace();" + NL + "          }" + NL + "          return recordMaxSize;" + NL + "      }" + NL;
  protected final String TEXT_548 = NL + "\t                   void setRowValue_";
  protected final String TEXT_549 = "(";
  protected final String TEXT_550 = "Struct ";
  protected final String TEXT_551 = ", java.util.List<org.json.simple.JSONArray> JSONResultList_";
  protected final String TEXT_552 = ", int nbResultArray_";
  protected final String TEXT_553 = ") throws java.io.UnsupportedEncodingException{";
  protected final String TEXT_554 = NL + "\t\t\t\t\t\t\t        if(JSONResultList_";
  protected final String TEXT_555 = ".get(";
  protected final String TEXT_556 = ") != null && nbResultArray_";
  protected final String TEXT_557 = "<JSONResultList_";
  protected final String TEXT_558 = ".get(";
  protected final String TEXT_559 = ").size() && JSONResultList_";
  protected final String TEXT_560 = ".get(";
  protected final String TEXT_561 = ").get(nbResultArray_";
  protected final String TEXT_562 = ")!=null){";
  protected final String TEXT_563 = "\t\t" + NL + "\t\t\t                                ";
  protected final String TEXT_564 = ".";
  protected final String TEXT_565 = " = JSONResultList_";
  protected final String TEXT_566 = ".get(";
  protected final String TEXT_567 = ").get(nbResultArray_";
  protected final String TEXT_568 = ").toString();";
  protected final String TEXT_569 = "\t\t\t\t\t" + NL + "\t\t\t                                ";
  protected final String TEXT_570 = ".";
  protected final String TEXT_571 = " = ParserUtils.parseTo_Date(JSONResultList_";
  protected final String TEXT_572 = ".get(";
  protected final String TEXT_573 = ").get(nbResultArray_";
  protected final String TEXT_574 = ").toString(), ";
  protected final String TEXT_575 = ");\t\t\t\t";
  protected final String TEXT_576 = NL + "\t\t\t                                ";
  protected final String TEXT_577 = ".";
  protected final String TEXT_578 = " = ParserUtils.parseTo_";
  protected final String TEXT_579 = "(ParserUtils.parseTo_Number(JSONResultList_";
  protected final String TEXT_580 = ".get(";
  protected final String TEXT_581 = ").get(nbResultArray_";
  protected final String TEXT_582 = ").toString(), ";
  protected final String TEXT_583 = ", ";
  protected final String TEXT_584 = "));";
  protected final String TEXT_585 = "\t\t\t\t\t\t\t" + NL + "\t\t\t                                ";
  protected final String TEXT_586 = ".";
  protected final String TEXT_587 = " = JSONResultList_";
  protected final String TEXT_588 = ".get(";
  protected final String TEXT_589 = ").get(nbResultArray_";
  protected final String TEXT_590 = ").toString().getBytes(";
  protected final String TEXT_591 = ");";
  protected final String TEXT_592 = NL + "\t\t\t                                ";
  protected final String TEXT_593 = ".";
  protected final String TEXT_594 = " = ParserUtils.parseTo_";
  protected final String TEXT_595 = "(JSONResultList_";
  protected final String TEXT_596 = ".get(";
  protected final String TEXT_597 = ").get(nbResultArray_";
  protected final String TEXT_598 = ").toString());";
  protected final String TEXT_599 = NL + "\t\t\t\t\t\t\t        }else{" + NL;
  protected final String TEXT_600 = NL + "\t\t\t                                throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_601 = "' in '";
  protected final String TEXT_602 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_603 = NL + "\t\t                                    ";
  protected final String TEXT_604 = ".";
  protected final String TEXT_605 = " = ";
  protected final String TEXT_606 = ";" + NL + "\t\t";
  protected final String TEXT_607 = NL + "\t\t                             }";
  protected final String TEXT_608 = NL + "\t\t\t             }";
  protected final String TEXT_609 = NL + "                    }";
  protected final String TEXT_610 = NL + "  }" + NL + "int nb_line_";
  protected final String TEXT_611 = " = 0;" + NL + "java.lang.Object jsonText_";
  protected final String TEXT_612 = " = null;" + NL + "JSONUtil_";
  protected final String TEXT_613 = " jsonUtil_";
  protected final String TEXT_614 = "=new JSONUtil_";
  protected final String TEXT_615 = "();" + NL + "java.util.List<org.json.simple.JSONArray> JSONResultList_";
  protected final String TEXT_616 = " = new java.util.ArrayList<org.json.simple.JSONArray>();" + NL + "int recordMaxSize_";
  protected final String TEXT_617 = " = -1;" + NL + "" + NL + "//init js json engine" + NL + "javax.script.ScriptEngineManager scriptEngineMgr_";
  protected final String TEXT_618 = " = new javax.script.ScriptEngineManager();" + NL + "javax.script.ScriptEngine jsEngine_";
  protected final String TEXT_619 = " = scriptEngineMgr_";
  protected final String TEXT_620 = ".getEngineByName(\"JavaScript\");" + NL + "if (jsEngine_";
  protected final String TEXT_621 = " == null) {" + NL + "\t";
  protected final String TEXT_622 = NL + "\t\tlog.warn(\"";
  protected final String TEXT_623 = " - No script engine found for JavaScript\");" + NL + "\t";
  protected final String TEXT_624 = NL + "    System.err.println(\"No script engine found for JavaScript\");" + NL + "} else {" + NL + "    java.net.URL jsonjsUrl_";
  protected final String TEXT_625 = " = com.jsonpath.test.ReadJar.class.getResource(\"json.js\");" + NL + "    if(jsonjsUrl_";
  protected final String TEXT_626 = "!=null) {" + NL + "    \tjsEngine_";
  protected final String TEXT_627 = ".eval(new java.io.BufferedReader(new java.io.InputStreamReader(jsonjsUrl_";
  protected final String TEXT_628 = ".openStream())));" + NL + "    }" + NL + "    " + NL + "    java.net.URL jsonpathjsUrl_";
  protected final String TEXT_629 = " = com.jsonpath.test.ReadJar.class.getResource(\"jsonpath.js\");" + NL + "    if(jsonpathjsUrl_";
  protected final String TEXT_630 = "!=null) {" + NL + "\t\tjsEngine_";
  protected final String TEXT_631 = ".eval(new java.io.BufferedReader(new java.io.InputStreamReader(jsonpathjsUrl_";
  protected final String TEXT_632 = ".openStream())));" + NL + "\t}" + NL;
  protected final String TEXT_633 = NL + "\tjava.io.BufferedReader fr_";
  protected final String TEXT_634 = " = null;";
  protected final String TEXT_635 = NL + "\tjava.io.InputStreamReader fr_";
  protected final String TEXT_636 = " = null;";
  protected final String TEXT_637 = NL + "\ttry{" + NL + "\t";
  protected final String TEXT_638 = NL + "\t\tfr_";
  protected final String TEXT_639 = " = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(";
  protected final String TEXT_640 = "),";
  protected final String TEXT_641 = "));" + NL + "\t";
  protected final String TEXT_642 = NL + "\t\tjava.net.URL url_";
  protected final String TEXT_643 = " = new java.net.URL(";
  protected final String TEXT_644 = ");" + NL + "\t\tjava.net.URLConnection urlConn_";
  protected final String TEXT_645 = " = url_";
  protected final String TEXT_646 = ".openConnection();" + NL + "\t\tfr_";
  protected final String TEXT_647 = " = new java.io.InputStreamReader(urlConn_";
  protected final String TEXT_648 = ".getInputStream(),";
  protected final String TEXT_649 = ");" + NL + "\t";
  protected final String TEXT_650 = NL + "\t\tjsonText_";
  protected final String TEXT_651 = " = org.json.simple.JSONValue.parse(fr_";
  protected final String TEXT_652 = ");" + NL + "\t\tif(jsonText_";
  protected final String TEXT_653 = " == null) {" + NL + "\t\t\tthrow new RuntimeException(\"fail to parse the json file : \" + ";
  protected final String TEXT_654 = " ";
  protected final String TEXT_655 = " ";
  protected final String TEXT_656 = " ";
  protected final String TEXT_657 = " ";
  protected final String TEXT_658 = ");" + NL + "\t\t}" + NL + "\t} catch(java.lang.Exception e_";
  protected final String TEXT_659 = ") {" + NL + "\t";
  protected final String TEXT_660 = NL + "\t\tthrow e_";
  protected final String TEXT_661 = ";" + NL + "\t";
  protected final String TEXT_662 = NL + "\t\t";
  protected final String TEXT_663 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_664 = " - \" + e_";
  protected final String TEXT_665 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_666 = NL + " \t\tSystem.err.println(e_";
  protected final String TEXT_667 = ".getMessage());" + NL + "\t";
  protected final String TEXT_668 = NL + "\t} finally {" + NL + "\t\tif(fr_";
  protected final String TEXT_669 = " != null ) {" + NL + "\t\t\tfr_";
  protected final String TEXT_670 = ".close();" + NL + "\t\t}" + NL + "    }" + NL + "" + NL + "\tif(jsonText_";
  protected final String TEXT_671 = "!=null) {" + NL + "\t\tjsEngine_";
  protected final String TEXT_672 = ".eval(\"var obj=\"+jsonText_";
  protected final String TEXT_673 = ".toString());" + NL + "" + NL + "\t\tjavax.script.Invocable invocableEngine_";
  protected final String TEXT_674 = " = (javax.script.Invocable)jsEngine_";
  protected final String TEXT_675 = ";" + NL;
  protected final String TEXT_676 = NL + NL + "recordMaxSize_";
  protected final String TEXT_677 = "=jsonUtil_";
  protected final String TEXT_678 = ".getData(";
  protected final String TEXT_679 = ",invocableEngine_";
  protected final String TEXT_680 = ",JSONResultList_";
  protected final String TEXT_681 = ",recordMaxSize_";
  protected final String TEXT_682 = ");" + NL;
  protected final String TEXT_683 = NL + "\t}" + NL + "}";
  protected final String TEXT_684 = NL + "    \tlog.info(\"";
  protected final String TEXT_685 = " - Retrieving records from data.\");";
  protected final String TEXT_686 = NL + "\tfor(int nbResultArray_";
  protected final String TEXT_687 = " = 0; nbResultArray_";
  protected final String TEXT_688 = " < recordMaxSize_";
  protected final String TEXT_689 = "; nbResultArray_";
  protected final String TEXT_690 = "++){" + NL + "\t" + NL + "\t\tnb_line_";
  protected final String TEXT_691 = "++;";
  protected final String TEXT_692 = NL + "\t\t\t\t\t";
  protected final String TEXT_693 = " = null;\t\t\t";
  protected final String TEXT_694 = NL + "                \tboolean whetherReject_";
  protected final String TEXT_695 = " = false;" + NL + "                \t";
  protected final String TEXT_696 = " = new ";
  protected final String TEXT_697 = "Struct();" + NL + "                \ttry{";
  protected final String TEXT_698 = NL + "                            jsonUtil_";
  protected final String TEXT_699 = ".setRowValue_";
  protected final String TEXT_700 = "(";
  protected final String TEXT_701 = ",JSONResultList_";
  protected final String TEXT_702 = ",nbResultArray_";
  protected final String TEXT_703 = ");";
  protected final String TEXT_704 = " ";
  protected final String TEXT_705 = NL + "                            ";
  protected final String TEXT_706 = " = null; ";
  protected final String TEXT_707 = NL + "                    } catch (java.lang.Exception e) {" + NL + "                        whetherReject_";
  protected final String TEXT_708 = " = true;";
  protected final String TEXT_709 = NL + "                            throw(e);";
  protected final String TEXT_710 = NL + "\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_711 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_712 = NL + "                                ";
  protected final String TEXT_713 = " = new ";
  protected final String TEXT_714 = "Struct();";
  protected final String TEXT_715 = NL + "                                    ";
  protected final String TEXT_716 = ".";
  protected final String TEXT_717 = " = ";
  protected final String TEXT_718 = ".";
  protected final String TEXT_719 = ";";
  protected final String TEXT_720 = NL + "                                ";
  protected final String TEXT_721 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_722 = ";";
  protected final String TEXT_723 = NL + "                                ";
  protected final String TEXT_724 = " = null;";
  protected final String TEXT_725 = NL + "                                System.err.println(e.getMessage());";
  protected final String TEXT_726 = NL + "                                ";
  protected final String TEXT_727 = " = null;";
  protected final String TEXT_728 = NL + "\t\t\t\t                ";
  protected final String TEXT_729 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_730 = ";";
  protected final String TEXT_731 = NL + "                    }";
  protected final String TEXT_732 = NL;

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
	
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

String cid = node.getUniqueName();

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;

String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String useUrl = ElementParameterParser.getValue(node, "__USEURL__");
boolean isUseUrl = "true".equals(useUrl);
String urlpath = ElementParameterParser.getValue(node, "__URLPATH__");

String readBy = ElementParameterParser.getValue(node, "__READ_BY__");

if("XPATH".equals(readBy)){

    stringBuffer.append(TEXT_29);
    
List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPINGXPATH__");
String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__"); 

String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
        String nodeChecked = null;
        boolean hasNodeCheck = false;
        for(int i = 0 ;i<mapping.size();i++){
            nodeChecked = mapping.get(i).get("NODECHECK");
            if("true".equals(nodeChecked)){
                hasNodeCheck = true;
                break;
            }
        }
        if(hasNodeCheck){

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
        }

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
			if (dieOnError) {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    			
			}else{

    stringBuffer.append(TEXT_55);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
			}

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(loopQuery );
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
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_76);
    
				if(!isUseUrl){//read from a file

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_80);
    
				}else{ //read from internet

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(urlpath );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_88);
    
				}

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(encoding);
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
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
            if (dieOnError) {

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
            }else{

    stringBuffer.append(TEXT_127);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
     
            }

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
            for (int i=0;i<mapping.size();i++) {
                String query = mapping.get(i).get("QUERY");

    stringBuffer.append(TEXT_158);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    
            }

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
log4jFileUtil.debugRetriveData(node);

List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
String firstConnName = "";
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        List<IMetadataColumn> columns=metadata.getListColumns();
        if (conns!=null) {
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
            for (int i=0;i<conns.size();i++) {
                IConnection connTemp = conns.get(i);
                if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_169);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_170);
    
                }
            }
            if (conns.size()>0) { // S_if_a_0_0     
                IConnection conn = conns.get(0);
                firstConnName = conn.getName();
                if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // add for reject

    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_175);
    
                    for (int i=0;i<mapping.size();i++) { // S_for_a_1_0
                        String query = mapping.get(i).get("QUERY");
                        String nodeCheck = mapping.get(i).get("NODECHECK");
                        if("true".equals(nodeCheck) && query!=null){
                            if((".").equals(query.substring(1,query.length()-1)) && ("/").equals(loopQuery.substring(1,loopQuery.length()-1))){

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    
                            }
                        }

    stringBuffer.append(TEXT_178);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
                            if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    
                            }else{

    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    
                            }

    stringBuffer.append(TEXT_191);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
                            if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    
                            }else{

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    
                            }

    stringBuffer.append(TEXT_208);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    
                            if(("true").equals(nodeCheck)){

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
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    
                            }else{

    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    
                            }

    stringBuffer.append(TEXT_240);
    
                        for(IMetadataColumn column:columns) {  // S_for_0_1
                            if (mapping.get(i).get("SCHEMA_COLUMN")!=null) { // S_if_0_2
                                if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) { // S_if_0_3
                                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                                    String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                                    
                                    boolean isNotSetDefault = false;
                                    String defaultValue=column.getDefault();
                                    if(defaultValue!=null){
                                        isNotSetDefault = defaultValue.length()==0;
                                    }else{
                                        isNotSetDefault=true;
                                    }
                                    
                                    if("true".equals(nodeCheck)){

    stringBuffer.append(TEXT_241);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    
                                        continue;
                                    }
                                    if(javaType == JavaTypesManager.STRING){
                                        if(column.isNullable()){

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_261);
    
                                        }else{ // column.isNullable()

    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_273);
    
                                        }
                                    }else{ // other type
                                        if(column.isNullable()){

    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_287);
    
                                        }else{ // column.isNullable()

    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_296);
    
                                        }
                                    }
                                
                                    if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_297);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    
                                    } else if (javaType == JavaTypesManager.DATE) {
                                        if(checkDate) {

    stringBuffer.append(TEXT_301);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_305);
      
                                        } else {

    stringBuffer.append(TEXT_306);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_310);
                                          
                                        }
                                    } else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_311);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_316);
    
                                    } else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_317);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_319);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_322);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_323);
    
                                    } else {

    stringBuffer.append(TEXT_324);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_326);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    
                                    }

    stringBuffer.append(TEXT_329);
    
                                } //S_if_1_2
                            } // S_if_1_1
                        } // S_for_1_0
                    } // S_for_a_0_1

    
                    if(rejectConnName.equals(firstConnName)) {

    stringBuffer.append(TEXT_330);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_331);
    
                    }

    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    
                    if (dieOnError) {

    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    
                    } else {
						if(isLog4jEnabled){
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    }
                        if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
    

    stringBuffer.append(TEXT_340);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_342);
    
                            for(IMetadataColumn column : metadata.getListColumns()) {

    stringBuffer.append(TEXT_343);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_345);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_347);
    
                            }

    stringBuffer.append(TEXT_348);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_353);
    
                        } else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_357);
    
                        } else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_358);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_361);
    
                        }
                    }

    stringBuffer.append(TEXT_362);
    
                } //if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))
            } // S_if_a_1_1

                if (conns.size()>0) {   
                    boolean isFirstEnter = true;
                    for (int i=0;i<conns.size();i++) {
                        IConnection tmpconn = conns.get(i);
                        if ((tmpconn.getName().compareTo(firstConnName)!=0)&&(tmpconn.getName().compareTo(rejectConnName)!=0)&&(tmpconn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

     
                            if(isFirstEnter) {
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
     isFirstEnter = false; } 

    stringBuffer.append(TEXT_365);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_369);
    
                                for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_370);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_374);
    
                                }
                            }
                        }

     if(!isFirstEnter) {
    stringBuffer.append(TEXT_375);
     
                    }
                }

        }// if(conn!=null)
        
    }// if (metadata!=null)
}//if ((metadatas!=null)&&(metadatas.size()>0))

    
}else if("JSONPATH".equals(readBy)) {

    stringBuffer.append(TEXT_376);
    
List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING_JSONPATH__");
List< ? extends IConnection> conns = NodeUtil.getOutgoingConnections(node, IConnectionCategory.DATA);
String firstConnName = "";
List<IMetadataTable> metadatas = node.getMetadataList();

String loopPath = ElementParameterParser.getValue(node, "__JSON_LOOP_QUERY__");

    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(loopPath);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    if(!isUseUrl){//read from a file
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_390);
    }else{ //read from internet
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(urlpath );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_397);
    }
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(encoding );
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
    
if(dieOnError){

    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_416);
    
} else {
	if(isLog4jEnabled){
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    }
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    
}

    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    }
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    
	log4jFileUtil.debugRetriveData(node);
	
	if ((metadatas==null) || (metadatas.isEmpty())) {
		return stringBuffer.toString();
	}
	
	IMetadataTable metadata = metadatas.get(0);
	
	if (metadata==null) {
		return stringBuffer.toString();
	}
	
	if (conns==null || conns.isEmpty()) {
		return stringBuffer.toString(); 
	}
	
	List<IMetadataColumn> columns=metadata.getListColumns();
	
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
    for (int i=0;i<conns.size();i++) {
		IConnection connTemp = conns.get(i);
		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_434);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_435);
    
		}
	}
	
	IConnection conn = conns.get(0);
	firstConnName = conn.getName();
	
	if(!conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		return stringBuffer.toString();
	}

    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_437);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_438);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_439);
    
		for (int i=0;i<mapping.size();i++) {
			for(IMetadataColumn column:columns) {
				String schemaColumn = mapping.get(i).get("SCHEMA_COLUMN");
				if(schemaColumn==null || !column.getLabel().equals(schemaColumn)) {
					continue;
				}
				
				String jsonPath = mapping.get(i).get("QUERY");
				
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				
			 	String defaultValue = column.getDefault();
        		boolean isNotSetDefault = (defaultValue == null || defaultValue.trim().length()==0);

    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(jsonPath);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    
        			if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_449);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(TEXT_453);
    
	if(column.isNullable()) {

    stringBuffer.append(TEXT_454);
    stringBuffer.append(isNotSetDefault? null: defaultValue);
    
	} else {

    stringBuffer.append(TEXT_455);
    stringBuffer.append(isNotSetDefault ? JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate) : defaultValue);
    
	}

    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    
					} else {

    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    
					if(javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_461);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    
					} else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_465);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_469);
    
        			} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) {

    stringBuffer.append(TEXT_470);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_471);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_472);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_475);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_476);
    
        			} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_477);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_481);
    
        			} else {

    stringBuffer.append(TEXT_482);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    
        			}

    stringBuffer.append(TEXT_487);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_488);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(TEXT_490);
    
	if(column.isNullable()) {

    stringBuffer.append(TEXT_491);
    stringBuffer.append(isNotSetDefault? null: defaultValue);
    
	} else {

    stringBuffer.append(TEXT_492);
    stringBuffer.append(isNotSetDefault ? JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate) : defaultValue);
    
	}

    stringBuffer.append(TEXT_493);
    
        			}

    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_497);
    stringBuffer.append(TEXT_498);
    
	if(column.isNullable()) {

    stringBuffer.append(TEXT_499);
    stringBuffer.append(isNotSetDefault? null: defaultValue);
    
	} else {

    stringBuffer.append(TEXT_500);
    stringBuffer.append(isNotSetDefault ? JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate) : defaultValue);
    
	}

    stringBuffer.append(TEXT_501);
    
			}
		}
		
		if(rejectConnName.equals(firstConnName)) {

    stringBuffer.append(TEXT_502);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_504);
    
    	}

    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    
    	if (dieOnError) {

    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    
    	} else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_510);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_511);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_512);
    
                for(IMetadataColumn column : metadata.getListColumns()) {

    stringBuffer.append(TEXT_513);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_515);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_517);
    
            	}

    stringBuffer.append(TEXT_518);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_523);
    
            } else if(("").equals(rejectConnName)){
            	if(isLog4jEnabled){
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    }

    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_530);
    
            }else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_531);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_534);
    
            }
        }

    stringBuffer.append(TEXT_535);
    
} else {

    stringBuffer.append(TEXT_536);
    
List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
List< ? extends IConnection> conns = NodeUtil.getOutgoingConnections(node, IConnectionCategory.DATA);
String firstConnName = "";
List<IMetadataTable> metadatas = node.getMetadataList();

    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    }
    stringBuffer.append(TEXT_541);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    }
    stringBuffer.append(TEXT_544);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    }
    stringBuffer.append(TEXT_547);
    
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		List<IMetadataColumn> columns=metadata.getListColumns();
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				for (int i=0;i<mapping.size();i++) {
    				if(i % 100 == 0){

    stringBuffer.append(TEXT_548);
    stringBuffer.append((i/100) );
    stringBuffer.append(TEXT_549);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_550);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    
    				}

    
                        for(IMetadataColumn column:columns) {
                            if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
                                if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
    								String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
    								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    								String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    		
                                        if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_563);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_564);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    		
                                        } else if(javaType == JavaTypesManager.DATE) {						

    stringBuffer.append(TEXT_569);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_570);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_575);
    		
                                        }else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_576);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_578);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_583);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_584);
    
                                        } else if(javaType == JavaTypesManager.BYTE_ARRAY) { 

    stringBuffer.append(TEXT_585);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_586);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_591);
    
                                        } else {

    stringBuffer.append(TEXT_592);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_594);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    
                                        }

    stringBuffer.append(TEXT_599);
    
                                        String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
                                        if(defaultValue == null) {

    stringBuffer.append(TEXT_600);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_601);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_602);
    
                                        } else {

    stringBuffer.append(TEXT_603);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_604);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_605);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_606);
    
                                        }

    stringBuffer.append(TEXT_607);
    

                                }
                            }
					   }
    				if((i + 1) % 100 == 0){

    stringBuffer.append(TEXT_608);
    
    				}
				} // for (int i=0)
  				if(mapping.size() > 0 && mapping.size() % 100 > 0){

    stringBuffer.append(TEXT_609);
    
 				 }
			}

		}

	}
}

    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    }
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    if(!isUseUrl){//read from a file
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    }else{ //read from internet
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_636);
    }
    stringBuffer.append(TEXT_637);
    if(!isUseUrl){//read from a file
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_640);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_641);
    }else{ //read from internet
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_643);
    stringBuffer.append(urlpath );
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_648);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_649);
    }
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    if(!isUseUrl) {
    stringBuffer.append(TEXT_654);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_655);
    } else {
    stringBuffer.append(TEXT_656);
    stringBuffer.append(urlpath );
    stringBuffer.append(TEXT_657);
    }
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_659);
    if (dieOnError) {
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_661);
    } else {
    stringBuffer.append(TEXT_662);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    }
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    }
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_675);
    
	for(Map<String,String> path:mapping){
		String column = path.get("SCHEMA_COLUMN");
		String query = path.get("QUERY");

    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    
	}

    stringBuffer.append(TEXT_683);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_685);
    }
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    
log4jFileUtil.debugRetriveData(node);

if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		List<IMetadataColumn> columns=metadata.getListColumns();
		if (conns!=null) {
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
            for (int i=0;i<conns.size();i++) {
				IConnection connTemp = conns.get(i);
				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_692);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_693);
    
				}
    		}
			if (conns.size()>0) { // conns.size()>0	
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // add for DATA

    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_695);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_696);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_697);
    
            			for (int i=0;i<mapping.size();i++) {
            				if(i % 100 == 0){

    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
    stringBuffer.append( (i/100) );
    stringBuffer.append(TEXT_700);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_703);
    
    				        }
            			}// for
 						if(rejectConnName.equals(firstConnName)) {

    stringBuffer.append(TEXT_704);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_706);
    
                        }

    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    
                        if (dieOnError) {

    stringBuffer.append(TEXT_709);
    
                        } else {
							if(isLog4jEnabled){
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    }
                            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_712);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_713);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_714);
    
                                for(IMetadataColumn column : metadata.getListColumns()) {

    stringBuffer.append(TEXT_715);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_717);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_719);
    
                            	}

    stringBuffer.append(TEXT_720);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_721);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_722);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_724);
    
                            } else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_725);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_727);
    
                            }else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_728);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_729);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_730);
    
                            }
                        }

    stringBuffer.append(TEXT_731);
    
                }// end for DATA
			}// conns.size()>0
		} // if(conns!=null)
	} // if (metadata!=null)
} // if ((metadatas!=null)&&(metadatas.size()>0))

    
}

    stringBuffer.append(TEXT_732);
    return stringBuffer.toString();
  }
}
