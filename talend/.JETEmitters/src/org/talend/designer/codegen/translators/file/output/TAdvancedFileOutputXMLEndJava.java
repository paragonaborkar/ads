package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaType;

/**
 * add by xzhang
 */
public class TAdvancedFileOutputXMLEndJava {

  protected static String nl;
  public static synchronized TAdvancedFileOutputXMLEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAdvancedFileOutputXMLEndJava result = new TAdvancedFileOutputXMLEndJava();
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
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = NL;
  protected final String TEXT_33 = NL + NL + "\t\t";
  protected final String TEXT_34 = "_";
  protected final String TEXT_35 = NL + "\t\t";
  protected final String TEXT_36 = NL + NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_37 = "_c_";
  protected final String TEXT_38 = " = ";
  protected final String TEXT_39 = ".addElement(\"xsd:complexType\");" + NL + "\t\t";
  protected final String TEXT_40 = NL + NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_41 = "_s_";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = ".addElement(\"xsd:sequence\");" + NL + "\t\t";
  protected final String TEXT_44 = NL + NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_45 = "_";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = ".addElement(\"xsd:element\");" + NL + "\t\t";
  protected final String TEXT_48 = NL;
  protected final String TEXT_49 = NL + "\t\tnameToElement_";
  protected final String TEXT_50 = ".get(\"";
  protected final String TEXT_51 = "\")";
  protected final String TEXT_52 = NL + "\t\t((org.dom4j.Element)(nameToElement_";
  protected final String TEXT_53 = ".get(\"";
  protected final String TEXT_54 = "\")))";
  protected final String TEXT_55 = NL + "\t\tnameToElement_";
  protected final String TEXT_56 = ".put(\"";
  protected final String TEXT_57 = "_c\",";
  protected final String TEXT_58 = ".addElement(\"xsd:complexType\"));";
  protected final String TEXT_59 = NL + "\t\tnameToElement_";
  protected final String TEXT_60 = ".put(\"";
  protected final String TEXT_61 = "_s\",";
  protected final String TEXT_62 = ".addElement(\"xsd:sequence\"));";
  protected final String TEXT_63 = NL + "\t\tnameToElement_";
  protected final String TEXT_64 = ".put(\"";
  protected final String TEXT_65 = "\",";
  protected final String TEXT_66 = ".addElement(\"xsd:element\"));";
  protected final String TEXT_67 = NL + "\t\tnameToElement_";
  protected final String TEXT_68 = ".put(\"root_xsd\",root_xsd_";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL;
  protected final String TEXT_71 = NL + "\t\t\tclass TalendXMLGenerateTool_";
  protected final String TEXT_72 = "_";
  protected final String TEXT_73 = " {";
  protected final String TEXT_74 = NL + "\t\t\t}";
  protected final String TEXT_75 = NL + "\t\t\t\tpublic void generateDocument_";
  protected final String TEXT_76 = "() throws java.lang.Exception{";
  protected final String TEXT_77 = NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void generateDocument_";
  protected final String TEXT_78 = "() throws java.lang.Exception{";
  protected final String TEXT_79 = NL + "\t\t\tTalendXMLGenerateTool_";
  protected final String TEXT_80 = "_";
  protected final String TEXT_81 = " talendXMLGenerateTool_";
  protected final String TEXT_82 = "_";
  protected final String TEXT_83 = " = new TalendXMLGenerateTool_";
  protected final String TEXT_84 = "_";
  protected final String TEXT_85 = "();";
  protected final String TEXT_86 = NL + "\t\t\t\t\ttalendXMLGenerateTool_";
  protected final String TEXT_87 = "_";
  protected final String TEXT_88 = ".generateDocument_";
  protected final String TEXT_89 = "();";
  protected final String TEXT_90 = NL;
  protected final String TEXT_91 = NL + "\t\t";
  protected final String TEXT_92 = ".addAttribute(\"name\",\"";
  protected final String TEXT_93 = "\");" + NL + "\t\t";
  protected final String TEXT_94 = ".addAttribute(\"nillable\",\"true\");";
  protected final String TEXT_95 = NL + "\t\t";
  protected final String TEXT_96 = ".addAttribute(\"minOccurs\",\"0\");" + NL + "\t\t";
  protected final String TEXT_97 = ".addAttribute(\"maxOccurs\",\"unbounded\");";
  protected final String TEXT_98 = NL + "\t\t";
  protected final String TEXT_99 = ".addElement(\"xsd:attribute\").addAttribute(\"name\",\"";
  protected final String TEXT_100 = "\");";
  protected final String TEXT_101 = NL;
  protected final String TEXT_102 = NL + "\t\tout_xsd_";
  protected final String TEXT_103 = ".write(\"";
  protected final String TEXT_104 = "  <xsd:complexType>\");" + NL + "\t\tout_xsd_";
  protected final String TEXT_105 = ".newLine();" + NL + "\t\tout_xsd_";
  protected final String TEXT_106 = ".write(\"";
  protected final String TEXT_107 = "    <xsd:sequence>\");" + NL + "\t\tout_xsd_";
  protected final String TEXT_108 = ".newLine();";
  protected final String TEXT_109 = NL + "\t\tout_xsd_";
  protected final String TEXT_110 = ".write(\"";
  protected final String TEXT_111 = "    </xsd:sequence>\");" + NL + "\t\tout_xsd_";
  protected final String TEXT_112 = ".newLine();";
  protected final String TEXT_113 = NL + "\t\tout_xsd_";
  protected final String TEXT_114 = ".write(\"";
  protected final String TEXT_115 = "  </xsd:complexType>\");" + NL + "\t\tout_xsd_";
  protected final String TEXT_116 = ".newLine();";
  protected final String TEXT_117 = NL + "\t\tout_xsd_";
  protected final String TEXT_118 = ".write(\"";
  protected final String TEXT_119 = "</xsd:element>\");" + NL + "\t\tout_xsd_";
  protected final String TEXT_120 = ".newLine();";
  protected final String TEXT_121 = NL + "\t\tout_xsd_";
  protected final String TEXT_122 = ".write(\"";
  protected final String TEXT_123 = "<xsd:element name=\\\"";
  protected final String TEXT_124 = "\\\" nillable=\\\"true\\\" \"+";
  protected final String TEXT_125 = NL + "\t\t\"minOccurs=\\\"0\\\" maxOccurs=\\\"unbounded\\\"\"+";
  protected final String TEXT_126 = NL + "\t\t\">\");" + NL + "\t\tout_xsd_";
  protected final String TEXT_127 = ".newLine();";
  protected final String TEXT_128 = NL + "\t\tout_xsd_";
  protected final String TEXT_129 = ".write(\"";
  protected final String TEXT_130 = "<xsd:attribute name= \\\"";
  protected final String TEXT_131 = "\\\"/>\");" + NL + "\t\tout_xsd_";
  protected final String TEXT_132 = ".newLine();";
  protected final String TEXT_133 = NL;
  protected final String TEXT_134 = NL + "\t\tnameToElement_";
  protected final String TEXT_135 = ".clear();";
  protected final String TEXT_136 = NL + "if(currentRowCount_";
  protected final String TEXT_137 = " > 0){";
  protected final String TEXT_138 = NL + "\tjava.io.OutputStream stream_";
  protected final String TEXT_139 = " = ";
  protected final String TEXT_140 = ";";
  protected final String TEXT_141 = NL + "\tjava.io.FileOutputStream stream_";
  protected final String TEXT_142 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_143 = " + currentFileCount_";
  protected final String TEXT_144 = " + suffix_";
  protected final String TEXT_145 = ");";
  protected final String TEXT_146 = NL + "\tjava.io.FileOutputStream stream_";
  protected final String TEXT_147 = " = new java.io.FileOutputStream(fileName_";
  protected final String TEXT_148 = ");";
  protected final String TEXT_149 = "    " + NL + "\torg.dom4j.io.XMLWriter output_";
  protected final String TEXT_150 = " = new org.dom4j.io.XMLWriter(stream_";
  protected final String TEXT_151 = ", format_";
  protected final String TEXT_152 = ");" + NL + "\tif(doc_";
  protected final String TEXT_153 = ".getRootElement()!=null){";
  protected final String TEXT_154 = NL + "\t\tdoc_";
  protected final String TEXT_155 = ".getRootElement().addAttribute(\"xsi:noNamespaceSchemaLocation\", file_";
  protected final String TEXT_156 = ".substring(file_";
  protected final String TEXT_157 = ".lastIndexOf(\"/\")+1)+\".xsd\");" + NL + "    \tdoc_";
  protected final String TEXT_158 = ".getRootElement().addNamespace(\"xsi\", \"http://www.w3.org/2001/XMLSchema-instance\");";
  protected final String TEXT_159 = "  " + NL + "    \tnestXMLTool_";
  protected final String TEXT_160 = ".replaceDefaultNameSpace(doc_";
  protected final String TEXT_161 = ".getRootElement());";
  protected final String TEXT_162 = NL + "    \tnestXMLTool_";
  protected final String TEXT_163 = ".removeEmptyElement(doc_";
  protected final String TEXT_164 = ".getRootElement());";
  protected final String TEXT_165 = NL + "    \toutput_";
  protected final String TEXT_166 = ".write(doc_";
  protected final String TEXT_167 = ");" + NL + "    }";
  protected final String TEXT_168 = NL + "    output_";
  protected final String TEXT_169 = ".close();";
  protected final String TEXT_170 = NL + "\toutput_";
  protected final String TEXT_171 = ".flush();" + NL + "\toutput_";
  protected final String TEXT_172 = " = null;";
  protected final String TEXT_173 = NL + "\tif (preUnNullMaxIndex_";
  protected final String TEXT_174 = " >= 0) {" + NL + "        // output all buffer" + NL + "        for (int j_";
  protected final String TEXT_175 = " = 0; j_";
  protected final String TEXT_176 = " <= preUnNullMaxIndex_";
  protected final String TEXT_177 = "; j_";
  protected final String TEXT_178 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_179 = "[j_";
  protected final String TEXT_180 = "] != null)" + NL + "                out_";
  protected final String TEXT_181 = ".write(startTabs_";
  protected final String TEXT_182 = "[j_";
  protected final String TEXT_183 = "]);" + NL + "        }" + NL + "" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_184 = " < preNewTabIndex_";
  protected final String TEXT_185 = " ) {" + NL + "\t\t\tfor (int i_";
  protected final String TEXT_186 = " = preNewTabIndex_";
  protected final String TEXT_187 = " - 1; i_";
  protected final String TEXT_188 = " >= 0; i_";
  protected final String TEXT_189 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_190 = "[i_";
  protected final String TEXT_191 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_192 = ".write(endTabs_";
  protected final String TEXT_193 = "[i_";
  protected final String TEXT_194 = "]);" + NL + "            \t}" + NL + "            \t";
  protected final String TEXT_195 = "out_";
  protected final String TEXT_196 = ".newLine(); ";
  protected final String TEXT_197 = NL + "                out_";
  protected final String TEXT_198 = ".write(endTabStrs_";
  protected final String TEXT_199 = ".get(i_";
  protected final String TEXT_200 = "));" + NL + "            }" + NL + "        } else {" + NL + "            for (int i_";
  protected final String TEXT_201 = " = preUnNullMaxIndex_";
  protected final String TEXT_202 = "; i_";
  protected final String TEXT_203 = " >= 0; i_";
  protected final String TEXT_204 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_205 = "[i_";
  protected final String TEXT_206 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_207 = ".write(endTabs_";
  protected final String TEXT_208 = "[i_";
  protected final String TEXT_209 = "]);" + NL + "            \t}" + NL + "            \t";
  protected final String TEXT_210 = "out_";
  protected final String TEXT_211 = ".newLine(); ";
  protected final String TEXT_212 = NL + "                out_";
  protected final String TEXT_213 = ".write(endTabStrs_";
  protected final String TEXT_214 = ".get(i_";
  protected final String TEXT_215 = "));" + NL + "            }" + NL + "        }" + NL + "    }";
  protected final String TEXT_216 = NL + "\tif(nb_line_";
  protected final String TEXT_217 = " > 0){" + NL + "\t\tfor (int i_";
  protected final String TEXT_218 = " = endTabStrs_";
  protected final String TEXT_219 = ".size() - 1; i_";
  protected final String TEXT_220 = " >= 0; i_";
  protected final String TEXT_221 = "--) {" + NL + "        \tif(endTabs_";
  protected final String TEXT_222 = "[i_";
  protected final String TEXT_223 = "]!=null){" + NL + "        \t\tout_";
  protected final String TEXT_224 = ".write(endTabs_";
  protected final String TEXT_225 = "[i_";
  protected final String TEXT_226 = "]);" + NL + "        \t}" + NL + "        \t";
  protected final String TEXT_227 = "out_";
  protected final String TEXT_228 = ".newLine(); ";
  protected final String TEXT_229 = NL + "\t        out_";
  protected final String TEXT_230 = ".write(endTabStrs_";
  protected final String TEXT_231 = ".get(i_";
  protected final String TEXT_232 = "));" + NL + "\t    }" + NL + "    }";
  protected final String TEXT_233 = NL + "\tout_";
  protected final String TEXT_234 = ".close();";
  protected final String TEXT_235 = NL + "\tout_";
  protected final String TEXT_236 = ".flush();" + NL + "\toutWriter_";
  protected final String TEXT_237 = ".flush();" + NL + "\tout_";
  protected final String TEXT_238 = " = null;";
  protected final String TEXT_239 = NL + "}";
  protected final String TEXT_240 = NL + "globalMap.put(\"";
  protected final String TEXT_241 = "_NB_LINE\",nb_line_";
  protected final String TEXT_242 = ");";
  protected final String TEXT_243 = NL + "\torg.dom4j.Document doc_xsd_";
  protected final String TEXT_244 = "  = org.dom4j.DocumentHelper.createDocument();" + NL + "\t" + NL + "\torg.dom4j.Element root_xsd_";
  protected final String TEXT_245 = " = doc_xsd_";
  protected final String TEXT_246 = ".addElement(\"xsd:schema\");" + NL + "    root_xsd_";
  protected final String TEXT_247 = ".addNamespace(\"xsd\", \"http://www.w3.org/2001/XMLSchema\");";
  protected final String TEXT_248 = NL + "\tjava.io.FileOutputStream stream_xsd_";
  protected final String TEXT_249 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_250 = "+\".xsd\");" + NL + "    org.dom4j.io.XMLWriter output_xsd_";
  protected final String TEXT_251 = " = new org.dom4j.io.XMLWriter(stream_xsd_";
  protected final String TEXT_252 = ", format_";
  protected final String TEXT_253 = ");" + NL + "    output_xsd_";
  protected final String TEXT_254 = ".write(doc_xsd_";
  protected final String TEXT_255 = " );" + NL + "    output_xsd_";
  protected final String TEXT_256 = ".close();" + NL + "    nameToElement_";
  protected final String TEXT_257 = ".clear();";
  protected final String TEXT_258 = NL + "\tjava.io.BufferedWriter out_xsd_";
  protected final String TEXT_259 = " = new java.io.BufferedWriter(" + NL + "\t\tnew java.io.OutputStreamWriter(new java.io.FileOutputStream(file_";
  protected final String TEXT_260 = "+\".xsd\"), ";
  protected final String TEXT_261 = "));" + NL + "\tout_xsd_";
  protected final String TEXT_262 = ".write(\"<xsd:schema xmlns:xsd=\\\"http://www.w3.org/2001/XMLSchema\\\">\");" + NL + "\tout_xsd_";
  protected final String TEXT_263 = ".newLine();";
  protected final String TEXT_264 = NL + "\tout_xsd_";
  protected final String TEXT_265 = ".write(\"</xsd:schema>\");" + NL + "\tout_xsd_";
  protected final String TEXT_266 = ".close();";
  protected final String TEXT_267 = NL;
  protected final String TEXT_268 = NL + " \tif((nb_line_";
  protected final String TEXT_269 = " == 0) && !alreadyExistsFile_";
  protected final String TEXT_270 = "){" + NL + "   \t\tcreateFile";
  protected final String TEXT_271 = ".delete();" + NL + " \t}";
  protected final String TEXT_272 = NL;

    static class XMLNode {

        // table parameter of component
        public String name = null;

        public String path = null;

        public String type = null;

        public String column = null;
        
        public String defaultValue = null;
        
        public int order = 0;
        
        public boolean hasDefaultValue = false;

        // special node
        public int special = 0; // 1 is subtree root, 2 is subtree root parent, 4 is main

        // column
        public IMetadataColumn relatedColumn = null;

        public List<IMetadataColumn> childrenColumnList = new ArrayList<IMetadataColumn>();

        // tree variable
        public XMLNode parent = null;

        public List<XMLNode> attributes = new LinkedList<XMLNode>();

        public List<XMLNode> namespaces = new LinkedList<XMLNode>();

        public List<XMLNode> elements = new LinkedList<XMLNode>(); // the main element is the last element

        public XMLNode(String path, String type, XMLNode parent, String column, String value, int order) {
        	this.order = order;
            this.path = path;
            this.parent = parent;
            this.type = type;
            this.column = column;
            this.defaultValue = value;
            if (type.equals("ELEMENT")) {
                this.name = path.substring(path.lastIndexOf("/") + 1);
            } else {
                this.name = path;
            }
        }
        
        public boolean isMainNode(){
            return 4 == (special & 4);
        }
        
        public boolean isSubTreeRoot(){
            return 1 == (special & 1);
        }
        
        public boolean isSubTreeParent(){
            return 2 == (special & 2);
        }
    
        public int getNodeInsertIndex(){
        	int insertIndex =0;
        	if(5==(special & 5)){//group and loop main node
        		if(parent!=null && parent.elements!=null){
            		for(XMLNode tmpNode: parent.elements){
            			if(order <= tmpNode.order){
            				break;
            			}
            			insertIndex++;
            		}
        		}
        	}
        	return insertIndex;
        }
        
        public List<XMLNode> getNextSiblings(){
            List<XMLNode> result = new ArrayList<XMLNode>();
            if(parent!=null && parent.elements!=null){
                for(XMLNode tmpNode: parent.elements){
                    if(order < tmpNode.order){
                        result.add(tmpNode);
                    }
                }
            }
            return result;
        }
        
        public int getCurrGroupPos(){
        	int currPos =0;
        	if(5==(special & 5)){//group and loop main node
    			XMLNode tmpNode = parent;
    			while(tmpNode!=null && (5==(tmpNode.special & 5))){
    				currPos++;
    				tmpNode = tmpNode.parent;
    			}
        	}
        	return currPos;
        }
    }

    
    // return [0] is root(XMLNode), [1] is groups(List<XMLNode>), [2] loop(XMLNode)
    public Object[] getTree(List<Map<String, String>> rootTable, List<Map<String, String>> groupTable,
            List<Map<String, String>> loopTable, List<IMetadataColumn> colList) {
        List<List<Map<String, String>>> tables = new ArrayList<List<Map<String, String>>>();
        tables.add(rootTable);
        tables.add(groupTable);
        tables.add(loopTable);

        XMLNode root = null;
        List<XMLNode> mains = new ArrayList<XMLNode>();
        List<XMLNode> groups = new ArrayList<XMLNode>();
        XMLNode loop = null;

        XMLNode tmpParent = null;
        XMLNode tmpMainNode = null;
        if (loopTable == null || loopTable.size() == 0) {
            return null;
        }
        int index =0;
        int currOrder = 0;
        String mainPath = loopTable.get(0).get("PATH");
        for (List<Map<String, String>> tmpTable : tables) {
            tmpParent = tmpMainNode;
            for (Map<String, String> tmpMap : tmpTable) {
            	index++;
            	if(tmpMap.get("ORDER")!=null && !"".equals(tmpMap.get("ORDER").trim())){
            		currOrder = Integer.parseInt(tmpMap.get("ORDER"));
            	}else{
            		currOrder = index;
            	}
                XMLNode tmpNew = null;
                if (tmpMap.get("ATTRIBUTE").equals("attri")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "ATTRIBUTE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                    tmpParent.attributes.add(tmpNew);
                } else if (tmpMap.get("ATTRIBUTE").equals("ns")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "NAMESPACE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                    tmpParent.namespaces.add(tmpNew);
                } else {
                    if (tmpParent == null) {
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
//                        tmpNew.special |= 1;
                        root = tmpNew;
                        mains.add(root);
                    } else {
                        String tmpParentPath = tmpMap.get("PATH").substring(0, tmpMap.get("PATH").lastIndexOf("/"));
                        while (tmpParent != null && !tmpParentPath.equals(tmpParent.path)) {
                            tmpParent = tmpParent.parent;
                        }
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                        tmpParent.elements.add(tmpNew);
                        if (tmpMap.get("ATTRIBUTE").equals("main")) {
                            if (tmpTable == groupTable) {
                                tmpNew.special |= 1;
                                tmpParent.special |= 2;
                                groups.add(tmpNew);
                            } else if (tmpTable == loopTable) {
                                tmpNew.special |= 1;
                                tmpParent.special |= 2;
                                loop = tmpNew;
                            }else if (tmpTable == rootTable){
                                mains.add(tmpNew);
                            }
                        }
                    }
                    if (tmpMap.get("ATTRIBUTE").equals("main")) {
                        tmpMainNode = tmpNew;
                        tmpNew.special |= 4;
                    }
                    tmpParent = tmpNew;
                }
                setIMetadataColumn(tmpNew, colList);
                setDefaultValues(tmpNew);//add by wliu
            }
        }
        return new Object[] { mains, groups, loop };
    }
    
    private void setDefaultValues(XMLNode node){
    	if(node.defaultValue != null && !"".equals(node.defaultValue)){
    		XMLNode tmp = node;
    		while(tmp !=null){
    			tmp.hasDefaultValue = true;
    			if(tmp.isMainNode()){
    				break;
    			}
    			tmp = tmp.parent;
    		}
    	}
    }

    private void setIMetadataColumn(XMLNode node, List<IMetadataColumn> colList) {
        String value = null;
        JavaType javaType = null;
        if (node.column != null && node.column.length() > 0) {
            for (IMetadataColumn column : colList) {
                if (column.getLabel().equals(node.column)) {
                    node.relatedColumn = column;
                    XMLNode tmp = node;
                    while (tmp != null) {
                        if (!tmp.childrenColumnList.contains(column)) {
                            tmp.childrenColumnList.add(column);
                        }
                        if(tmp.isMainNode()){
                            break;
                        }
                        tmp = tmp.parent;
                    }
                }
            }
        }
    }

    public List<XMLNode> getGroupByNodeList(XMLNode group) {
        List<XMLNode> list = new ArrayList<XMLNode>();
        for (XMLNode attri : group.attributes) {
            if (attri.column != null && attri.column.length() != 0) {
                list.add(attri);
            }
        }
        if (group.relatedColumn != null) {
            list.add(group);
        } else {
            for (XMLNode element : group.elements) {
                if (!element.isMainNode()) {
                    list.addAll(getGroupByNodeList(element));
                }
            }
        }
        return list;
    }

    public XMLNode removeEmptyElement(XMLNode root) {
        List<XMLNode> removeNodes = new LinkedList<XMLNode>();
        for (XMLNode attri : root.attributes) {
            if ((attri.column == null || attri.column.length() == 0) && 
            		(attri.defaultValue == null || "".equals(attri.defaultValue)) ) {
                attri.parent = null;
                removeNodes.add(attri);
            }
        }
        root.attributes.removeAll(removeNodes);

        removeNodes.clear();
        for (XMLNode ns : root.namespaces) {
            if ( (ns.column == null || ns.column.length() == 0)
            		&& (ns.defaultValue == null || "".equals(ns.defaultValue)) ) {
                ns.parent = null;
                removeNodes.add(ns);
            }
        }
        root.namespaces.removeAll(removeNodes);

        removeNodes.clear();
        for (XMLNode child : root.elements) {
            removeNodes.add(removeEmptyElement(child));
        }
        root.elements.removeAll(removeNodes);

        if (root.attributes.size() == 0 && root.namespaces.size() == 0 && root.elements.size() == 0
                && (root.column == null || root.column.length() == 0)
                && (root.defaultValue == null || "".equals(root.defaultValue)) ) {
            return root;
        } else {
            return null;
        }
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
	
    stringBuffer.append(TEXT_30);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();

    stringBuffer.append(TEXT_31);
    
abstract class TouchXMLNode {
    protected String cid = null;
    
    abstract void getXMLNode(String currEleName);
    
    abstract void getXMLElement(String currEleName);
    
    abstract void putCurrentComplexTypeElement(String currEleName);
    
    abstract void putCurrentSequenceElement(String currEleName);
    
    abstract void putCurrentElement(String currEleName,String parent);
    
    abstract void putRootElement();
}

    stringBuffer.append(TEXT_32);
    
//get mean reference
//put mean declare,assign action
class ReferenceTouchXMLNode extends TouchXMLNode {

	void getXMLNode(String currEleName) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
	}
	
	void getXMLElement(String currEleName) {
		getXMLNode(currEleName);
	}
	
	void putCurrentComplexTypeElement(String currEleName) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    getXMLNode(currEleName);
    stringBuffer.append(TEXT_39);
    
	}
	
	void putCurrentSequenceElement(String currEleName) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    getXMLNode(currEleName + "_c");
    stringBuffer.append(TEXT_43);
    
	}
	
	void putCurrentElement(String currEleName,String parent) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    getXMLNode(parent);
    stringBuffer.append(TEXT_47);
    
	}
	
	void putRootElement() {
		//do nothing
	}
}

    stringBuffer.append(TEXT_48);
    
class MappingTouchXMLNode extends TouchXMLNode {

	void getXMLNode(String currEleName) {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_51);
    
	}
	
	void getXMLElement(String currEleName) {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_54);
    
	}
	
	void putCurrentComplexTypeElement(String currEleName) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_57);
    getXMLNode(currEleName);
    stringBuffer.append(TEXT_58);
    
	}
	
	void putCurrentSequenceElement(String currEleName) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_61);
    getXMLNode(currEleName + "_c");
    stringBuffer.append(TEXT_62);
    
	}
	
	void putCurrentElement(String currEleName,String parent) {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_65);
    getXMLNode(parent);
    stringBuffer.append(TEXT_66);
    
	}
	
	void putRootElement() {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
	}
}

    stringBuffer.append(TEXT_70);
    
//65535 limit
class BigMethodHelper {
	protected String cid = null;
	protected boolean isOptimizeCodeForXMLNode = false;
	protected int xmlNodeOptNum = 100;
	protected int index = -1;
	
	protected String generateId = "";
	
	public BigMethodHelper() {
		initIsOptimizeCodeForXMLNode();
	}
	
	public void setGenerateId(String generateId) {
		this.generateId = generateId; 
	}
	
	public void resetIndex() {
		index = -1;
	}
	
	public TouchXMLNode getTouchXMLNode() {
		if(isOptimizeCodeForXMLNode) {
			return new MappingTouchXMLNode();
		}
		return new ReferenceTouchXMLNode();
	}
	
	public void initIsOptimizeCodeForXMLNode(){
		String xmlNodeOptNumStr = ElementParameterParser.getValue(node, "__XMLNODE_OPT_NUM__");
		if(xmlNodeOptNumStr!=null && !"".equals(xmlNodeOptNumStr) && !"\"\"".equals(xmlNodeOptNumStr)){
			xmlNodeOptNum  = Integer.parseInt(xmlNodeOptNumStr);
		}
		
        List<Map<String, String>> rootTable =
        	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
        List<Map<String, String>> groupTable =
        	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
        List<Map<String, String>> loopTable =
        	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
        
        int elementNumber = getElementNumber(rootTable) + getElementNumber(groupTable) + getElementNumber(loopTable);
        if(elementNumber > xmlNodeOptNum) {
			isOptimizeCodeForXMLNode = true;
        }
	}
	
	private int getElementNumber(List<Map<String, String>> nodeTable) {
		if(nodeTable == null) {
			return 0;
		}
		
		int result = 0;
		for(Map<String,String> node : nodeTable) {
			if(node == null) {
				continue;
			}
			
			if("attri".equals(node.get("ATTRIBUTE")) || "ns".equals(node.get("ATTRIBUTE"))) {
				continue;
			}
			
			result++;
		}
		
		return result;
	}
	
	public void generateClassNameWithRBlock() {
		if (this.isOptimizeCodeForXMLNode) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    
		}
	}
	
	public void generateLeftBlock() {
		if (this.isOptimizeCodeForXMLNode) {

    stringBuffer.append(TEXT_74);
    
		}
	}
	
	public void generateMethod() {
		if(isOptimizeCodeForXMLNode) {
			if(index == -1) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append((index+1)/xmlNodeOptNum);
    stringBuffer.append(TEXT_76);
    
			} else if((index+1)%xmlNodeOptNum==0){

    stringBuffer.append(TEXT_77);
    stringBuffer.append((index+1)/xmlNodeOptNum);
    stringBuffer.append(TEXT_78);
    
			}
			index++;
		}
	}
	
	public void generateMethodCall() {
		if (this.isOptimizeCodeForXMLNode) {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    
			int count = index + 1;
			for(int i = 0; i < count; i++) {
				if(i%xmlNodeOptNum==0){

    stringBuffer.append(TEXT_86);
    stringBuffer.append(generateId);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(i/xmlNodeOptNum);
    stringBuffer.append(TEXT_89);
    
				}
			}
		}
	}
	
}

    stringBuffer.append(TEXT_90);
    
// ------------------- *** Dom4j generation mode start *** ------------------- //
class XSDToolByDom4j{
    String cid = null;
    
	//opt for big xml config tree
	BigMethodHelper bigMethodHelper = null;
	TouchXMLNode touchXMLNode = null;
	
	public XSDToolByDom4j() {
		bigMethodHelper = new BigMethodHelper();
		touchXMLNode = bigMethodHelper.getTouchXMLNode();
	}
	
	public void generateXSD(String parent, String currEleName, XMLNode root){
		if(!("ELEMENT").equals(root.type)){
			return;
		}
		
		bigMethodHelper.setGenerateId(currEleName);
		//start the class
		bigMethodHelper.generateClassNameWithRBlock();
		
		bigMethodHelper.resetIndex();
		
		generateMainCode(parent,currEleName,root);
		
		//end the last method
		bigMethodHelper.generateLeftBlock();
		
		//end the class
		bigMethodHelper.generateLeftBlock();
		
		bigMethodHelper.generateMethodCall();
	}
	
    public void generateMainCode(String parent, String currEleName, XMLNode root){
    	if(("ELEMENT").equals(root.type)){
    		bigMethodHelper.generateMethod();
    		
    		createElement(parent,currEleName,root);
			
			if(root.elements!=null && root.elements.size()>0
			  || root.attributes!=null && root.attributes.size()>0){
			  
				touchXMLNode.putCurrentComplexTypeElement(currEleName);
				touchXMLNode.putCurrentSequenceElement(currEleName);
				
        		int index = 0;
        		for(XMLNode child:root.elements){
        			generateMainCode(currEleName+"_s", currEleName+"_"+index++, child);
        		}
        		
        		for(XMLNode attri:root.attributes){
        			createAttribute(currEleName+"_c",attri);
        		}
			}
    	}
    }
    
    private void createElement(String parent, String currEleName, XMLNode node){
    	touchXMLNode.putCurrentElement(currEleName,parent);

    stringBuffer.append(TEXT_91);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_93);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_94);
    
		if(node.parent != null){

    stringBuffer.append(TEXT_95);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_96);
    touchXMLNode.getXMLElement(currEleName);
    stringBuffer.append(TEXT_97);
    
		}
    }
    
    private void createAttribute(String parent, XMLNode node){

    stringBuffer.append(TEXT_98);
    touchXMLNode.getXMLNode(parent);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_100);
    
    }
}
// ------------------- *** Dom4j generation mode end *** ------------------- //

    stringBuffer.append(TEXT_101);
    
// ------------------- *** Null generation mode start *** ------------------- //
class XSDToolByNull{
	String cid = null;
    public void generateXSD(String emptyspace, XMLNode root){
    	if(("ELEMENT").equals(root.type)){
    		createElement(emptyspace, root);
			
			if(root.elements!=null && root.elements.size()>0
			  || root.attributes!=null && root.attributes.size()>0){

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
				XMLNode mainNode = null;
        		for(XMLNode child:root.elements){
        			if( 1==(child.special & 4)){
        				mainNode = child;
        			}else{
        				generateXSD(emptyspace+"      ", child);
        			}
        		}
        		if(mainNode!= null){
        			generateXSD(emptyspace+"      ", mainNode);
        		}

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
        		for(XMLNode attri:root.attributes){
        			createAttribute(emptyspace+"    ",attri);
        		}

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
			}

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
    	}
    }
    
    private void createElement(String emptyspace, XMLNode node){

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_124);
    
		if(node.parent != null){

    stringBuffer.append(TEXT_125);
    
		}

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
    }
    
    private void createAttribute(String emptyspace, XMLNode node){

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(emptyspace);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
    }
}

    stringBuffer.append(TEXT_133);
    
// ------------------- *** Common code start *** ------------------- //
String allowEmpty = ElementParameterParser.getValue(node, "__CREATE_EMPTY_ELEMENT__");
String outputAsXSD = ElementParameterParser.getValue(node, "__OUTPUT_AS_XSD__");
List<Map<String, String>> rootTable = 
	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
List<Map<String, String>> groupTable = 
	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
List<Map<String, String>> loopTable = 
	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");

String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
String cid = node.getUniqueName();
String cid_original = cid;
cid = cid_original.replace("tAdvancedFileOutputXML","tAFOX");

boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));
boolean isCompact = ("true").equals(ElementParameterParser.getValue(node, "__PRETTY_COMPACT__"));

//*****************add for the feature:8873 to support output steam *****************
boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
//*******************add for feature:8873 end ****************

boolean isMerge= ("true").equals(ElementParameterParser.getValue(node, "__MERGE__"));
if(isMerge){
    mode = "Dom4j";
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	if("Dom4j".equals(mode)){

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
	}
	
	String split = ElementParameterParser.getValue(node, "__SPLIT__");
	if(!useStream && ("true").equals(split)){

    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    
	}
	if(("Dom4j").equals(mode)){
		if(useStream){

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_140);
    
		}else{
			if(("true").equals(split)){

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    
			}else{

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
			}
		}

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    
		if(!useStream && ("true").equals(outputAsXSD)){

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
		}

    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

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
    
		if(!useStream){

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
		}else{

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
		}

    
	}else if(("Null").equals(mode)){
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    if(isCompact==false){
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    }
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    if(isCompact==false){
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    }
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
		}else{
			if(loopTable.size()>0){

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    if(isCompact==false){
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    }
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    
			}
		}
		
		if(!useStream){

    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    
		}else{

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    
		}
	}
	if(!useStream && ("true").equals(split)){

    stringBuffer.append(TEXT_239);
    
	}

    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid_original );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    
log4jFileUtil.setCid(cid);
log4jFileUtil.writeDataFinishInfo(node);

// ------------------- *** xsd output code start *** ------------------- //
	if(!useStream && ("true").equals(outputAsXSD)){ // add a new prerequisite:useStream to ignore generating the xsd file

        // change tables to a tree 
		Object[] treeObjs = getTree(rootTable, groupTable, loopTable, metadatas.get(0).getListColumns());
    	List<XMLNode> mainList = (ArrayList<XMLNode>)treeObjs[0];
        XMLNode root = mainList.get(0);
        
		boolean isAppend = "true".equals(ElementParameterParser.getValue(node, "__MERGE__")); 
        if(!"true".equals(allowEmpty) && !(groupTable.size()>0 && isAppend)){
        	removeEmptyElement(root);
        }

		if(("Dom4j").equals(mode)){

    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    
	XSDToolByDom4j xsdTool = new XSDToolByDom4j();
	xsdTool.cid = cid;
	xsdTool.touchXMLNode.cid = cid;
	xsdTool.bigMethodHelper.cid = cid;
	xsdTool.touchXMLNode.putRootElement();
	xsdTool.generateXSD("root_xsd","ele_xsd",root);

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
    
		}else if(("Null").equals(mode)){

    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    
	XSDToolByNull xsdTool = new XSDToolByNull();
	xsdTool.cid=cid;
	xsdTool.generateXSD("  ",root);

    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    
		}
    }
}

    stringBuffer.append(TEXT_267);
    if(!useStream && isDeleteEmptyFile){
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    }
    stringBuffer.append(TEXT_272);
    return stringBuffer.toString();
  }
}
