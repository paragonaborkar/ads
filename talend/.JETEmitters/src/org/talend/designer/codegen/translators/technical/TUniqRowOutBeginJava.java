package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;

public class TUniqRowOutBeginJava
{
  protected static String nl;
  public static synchronized TUniqRowOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniqRowOutBeginJava result = new TUniqRowOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "//////////////////////////" + NL + "int nb_";
  protected final String TEXT_3 = " = 0;" + NL + "" + NL + "int bufferSize_";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL + "\tlog.info(\"";
  protected final String TEXT_7 = " - Start to process the data from datasource.\");";
  protected final String TEXT_8 = NL + "class rowStruct_";
  protected final String TEXT_9 = " extends ";
  protected final String TEXT_10 = "Struct {" + NL + "" + NL + "    int id_";
  protected final String TEXT_11 = ";" + NL + "" + NL + "    @Override" + NL + "    public void readData(ObjectInputStream dis) {" + NL + "        super.readData(dis);" + NL + "        try {" + NL + "\t\t\tthis.id_";
  protected final String TEXT_12 = " = dis.readInt();" + NL + "        } catch (IOException e) {" + NL + "\t\t\tthrow new RuntimeException(e);" + NL + "        }" + NL + "    }" + NL + "" + NL + "    @Override" + NL + "    public String toString() {" + NL + "        return \"{\" + super.toString() + \"\\t\" + id_";
  protected final String TEXT_13 = " + \"}\";" + NL + "    }" + NL + "" + NL + "    @Override" + NL + "    public void writeData(ObjectOutputStream dos) {" + NL + "        super.writeData(dos);" + NL + "        try {" + NL + "\t\t\t// Integer" + NL + "\t\t\tdos.writeInt(this.id_";
  protected final String TEXT_14 = ");" + NL + "" + NL + "        } catch (IOException e) {" + NL + "\t\t\tthrow new RuntimeException(e);" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public boolean duplicateTo(rowStruct_";
  protected final String TEXT_15 = " other) {" + NL;
  protected final String TEXT_16 = NL + "\t\tif (this.";
  protected final String TEXT_17 = " == null) {" + NL + "\t\t\tif (other.";
  protected final String TEXT_18 = " != null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (other.";
  protected final String TEXT_19 = " == null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t} else {" + NL + "\t\t\t    if (!this.";
  protected final String TEXT_20 = ".equals(other.";
  protected final String TEXT_21 = ")) {" + NL + "\t\t\t        return false;" + NL + "\t\t\t    }" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t\tif(this.";
  protected final String TEXT_23 = " != other.";
  protected final String TEXT_24 = "){" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\t\t";
  protected final String TEXT_25 = NL + "\t\tif (this.";
  protected final String TEXT_26 = " == null) {" + NL + "\t\t\tif (other.";
  protected final String TEXT_27 = " != null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (other.";
  protected final String TEXT_28 = " == null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t} else {" + NL + "\t\t\t    if (Math.abs(this.";
  protected final String TEXT_29 = " - other.";
  protected final String TEXT_30 = ") > 0.00000001) {" + NL + "\t\t\t        return false;" + NL + "\t\t\t    }" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_31 = NL + "\t\tif(Math.abs(this.";
  protected final String TEXT_32 = " - other.";
  protected final String TEXT_33 = ") > 0.00000001) {" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\t\t";
  protected final String TEXT_34 = NL + "\t\tif (this.";
  protected final String TEXT_35 = " == null) {" + NL + "\t\t\tif (other.";
  protected final String TEXT_36 = " != null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (other.";
  protected final String TEXT_37 = " == null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t} else {" + NL + "\t\t\t    if(this.";
  protected final String TEXT_38 = " && !other.";
  protected final String TEXT_39 = "){" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}else if(!this.";
  protected final String TEXT_40 = " && other.";
  protected final String TEXT_41 = "){" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\tif(this.";
  protected final String TEXT_43 = " && !other.";
  protected final String TEXT_44 = "){" + NL + "\t\t\treturn false;" + NL + "\t\t}else if(!this.";
  protected final String TEXT_45 = " && other.";
  protected final String TEXT_46 = "){" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\tif (this.";
  protected final String TEXT_48 = " == null) {" + NL + "\t\t\tif (other.";
  protected final String TEXT_49 = " != null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (other.";
  protected final String TEXT_50 = " == null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t} else {" + NL + "\t\t\t\tString this_";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = " = String.valueOf(this.";
  protected final String TEXT_53 = ");" + NL + "\t\t\t\tString other_";
  protected final String TEXT_54 = "_";
  protected final String TEXT_55 = " = String.valueOf(other.";
  protected final String TEXT_56 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t    if(!this_";
  protected final String TEXT_57 = "_";
  protected final String TEXT_58 = ".equals";
  protected final String TEXT_59 = "(other_";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = ")){" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\tif (this.";
  protected final String TEXT_63 = " == null) {" + NL + "\t\t\tif (other.";
  protected final String TEXT_64 = " != null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (other.";
  protected final String TEXT_65 = " == null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t} else {" + NL + "\t\t\t    if(!this.";
  protected final String TEXT_66 = ".equals(other.";
  protected final String TEXT_67 = ")){" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_68 = NL + "\t\tif (this.";
  protected final String TEXT_69 = " == null) {" + NL + "\t\t\tif (other.";
  protected final String TEXT_70 = " != null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (other.";
  protected final String TEXT_71 = " == null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t} else {" + NL + "\t\t\t    if (!this.";
  protected final String TEXT_72 = ".equals(other.";
  protected final String TEXT_73 = ")) {" + NL + "\t\t\t        return false;" + NL + "\t\t\t    }" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_74 = NL + "\t\tif (this.";
  protected final String TEXT_75 = " == null) {" + NL + "\t\t\tif (other.";
  protected final String TEXT_76 = " != null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (other.";
  protected final String TEXT_77 = " == null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t} else {" + NL + "\t\t\t\tString this_";
  protected final String TEXT_78 = "_";
  protected final String TEXT_79 = " = String.valueOf(this.";
  protected final String TEXT_80 = ");" + NL + "\t\t\t\tString other_";
  protected final String TEXT_81 = "_";
  protected final String TEXT_82 = " = String.valueOf(other.";
  protected final String TEXT_83 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t    if(!this_";
  protected final String TEXT_84 = "_";
  protected final String TEXT_85 = ".equals";
  protected final String TEXT_86 = "(other_";
  protected final String TEXT_87 = "_";
  protected final String TEXT_88 = ")){" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_89 = NL + "\t\tif (this.";
  protected final String TEXT_90 = " == null) {" + NL + "\t\t\tif (other.";
  protected final String TEXT_91 = " != null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (other.";
  protected final String TEXT_92 = " == null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t} else {" + NL + "\t\t\t    if(!this.";
  protected final String TEXT_93 = ".equals";
  protected final String TEXT_94 = "(other.";
  protected final String TEXT_95 = ")){" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_96 = NL + "\t\tif (this.";
  protected final String TEXT_97 = " == null) {" + NL + "\t\t\tif (other.";
  protected final String TEXT_98 = " != null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (other.";
  protected final String TEXT_99 = " == null) {" + NL + "\t\t\t    return false;" + NL + "\t\t\t} else {" + NL + "\t\t\t\tString this_";
  protected final String TEXT_100 = "_";
  protected final String TEXT_101 = " = String.valueOf(this.";
  protected final String TEXT_102 = ");" + NL + "\t\t\t\tString other_";
  protected final String TEXT_103 = "_";
  protected final String TEXT_104 = " = String.valueOf(other.";
  protected final String TEXT_105 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t    if(!this_";
  protected final String TEXT_106 = "_";
  protected final String TEXT_107 = ".equals";
  protected final String TEXT_108 = "(other_";
  protected final String TEXT_109 = "_";
  protected final String TEXT_110 = ")){" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_111 = NL + NL + "        return true;" + NL + "    }" + NL + "" + NL + "}" + NL + "" + NL + "// comparator for first sort" + NL + "class Comparator_1_";
  protected final String TEXT_112 = " implements Comparator<rowStruct_";
  protected final String TEXT_113 = "> {" + NL + "" + NL + "    public int compare(rowStruct_";
  protected final String TEXT_114 = " arg0, rowStruct_";
  protected final String TEXT_115 = " arg1) {" + NL + "\t\tint compare = 0;";
  protected final String TEXT_116 = NL + "\t\tif (arg0.";
  protected final String TEXT_117 = " == null) {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_118 = " != null) {" + NL + "\t\t\t    return -1;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_119 = " == null) {" + NL + "\t\t\t    return 1;" + NL + "\t\t\t} else {" + NL + "\t\t\t\tcompare = arg0.";
  protected final String TEXT_120 = ".compareTo(arg1.";
  protected final String TEXT_121 = ");" + NL + "\t\t\t    if (compare != 0) {" + NL + "\t\t\t        return compare;" + NL + "\t\t\t    }" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_122 = NL + "\t\tif(arg0.";
  protected final String TEXT_123 = " > arg1.";
  protected final String TEXT_124 = "){" + NL + "\t\t\treturn 1;" + NL + "\t\t}else if(arg0.";
  protected final String TEXT_125 = " < arg1.";
  protected final String TEXT_126 = "){" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\t\t";
  protected final String TEXT_127 = NL + "\t\tif (arg0.";
  protected final String TEXT_128 = " == null) {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_129 = " != null) {" + NL + "\t\t\t    return -1;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_130 = " == null) {" + NL + "\t\t\t    return 1;" + NL + "\t\t\t} else {" + NL + "\t\t\t    if (Math.abs(arg0.";
  protected final String TEXT_131 = " - arg1.";
  protected final String TEXT_132 = ") > 0.00000001) {" + NL + "\t\t\t        if(arg0.";
  protected final String TEXT_133 = " > arg1.";
  protected final String TEXT_134 = "){" + NL + "\t\t\t        \treturn 1;" + NL + "\t\t\t        }else{" + NL + "\t\t\t        \treturn -1;" + NL + "\t\t\t        }" + NL + "\t\t\t    }" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_135 = NL + "\t\tif(Math.abs(arg0.";
  protected final String TEXT_136 = " - arg1.";
  protected final String TEXT_137 = ") > 0.00000001) {" + NL + "\t\t\tif(arg0.";
  protected final String TEXT_138 = " > arg1.";
  protected final String TEXT_139 = "){" + NL + "\t\t\t\treturn 1;" + NL + "\t\t\t}else{" + NL + "\t\t\t\treturn -1;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t\t";
  protected final String TEXT_140 = NL + "\t\tif (arg0.";
  protected final String TEXT_141 = " == null) {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_142 = " != null) {" + NL + "\t\t\t    return -1;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_143 = " == null) {" + NL + "\t\t\t    return 1;" + NL + "\t\t\t} else {" + NL + "\t\t\t    if(arg0.";
  protected final String TEXT_144 = " && !arg1.";
  protected final String TEXT_145 = "){" + NL + "\t\t\t\t\treturn 1;" + NL + "\t\t\t\t}else if(!arg0.";
  protected final String TEXT_146 = " && arg1.";
  protected final String TEXT_147 = "){" + NL + "\t\t\t\t\treturn -1;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t\t";
  protected final String TEXT_148 = NL + "\t\tif(arg0.";
  protected final String TEXT_149 = " && !arg1.";
  protected final String TEXT_150 = "){" + NL + "\t\t\treturn 1;" + NL + "\t\t}else if(!arg0.";
  protected final String TEXT_151 = " && arg1.";
  protected final String TEXT_152 = "){" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_153 = NL + "\t\tif (arg0.";
  protected final String TEXT_154 = " == null) {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_155 = " != null) {" + NL + "\t\t\t    return -1;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_156 = " == null) {" + NL + "\t\t\t    return 1;" + NL + "\t\t\t} else {" + NL + "\t\t\t\tString arg0_";
  protected final String TEXT_157 = "_";
  protected final String TEXT_158 = " = String.valueOf(arg0.";
  protected final String TEXT_159 = ");" + NL + "\t\t\t\tString arg1_";
  protected final String TEXT_160 = "_";
  protected final String TEXT_161 = " = String.valueOf(arg1.";
  protected final String TEXT_162 = ");" + NL + "\t\t\t\tcompare = arg0_";
  protected final String TEXT_163 = "_";
  protected final String TEXT_164 = ".compareTo";
  protected final String TEXT_165 = "(arg1_";
  protected final String TEXT_166 = "_";
  protected final String TEXT_167 = ");" + NL + "\t\t\t    if(compare != 0){" + NL + "\t\t\t\t\treturn compare;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_168 = NL + "\t\tif (arg0.";
  protected final String TEXT_169 = " == null) {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_170 = " != null) {" + NL + "\t\t\t    return -1;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_171 = " == null) {" + NL + "\t\t\t    return 1;" + NL + "\t\t\t} else {" + NL + "\t\t\t\tcompare = arg0.";
  protected final String TEXT_172 = ".compareTo(arg1.";
  protected final String TEXT_173 = ");" + NL + "\t\t\t    if (compare != 0) {" + NL + "\t\t\t        return compare;" + NL + "\t\t\t    }" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_174 = NL + "\t\tif (arg0.";
  protected final String TEXT_175 = " == null) {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_176 = " != null) {" + NL + "\t\t\t    return -1;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_177 = " == null) {" + NL + "\t\t\t    return 1;" + NL + "\t\t\t} else {" + NL + "\t\t\t    compare = arg0.";
  protected final String TEXT_178 = ".compareTo(arg1.";
  protected final String TEXT_179 = ");" + NL + "\t\t\t    if (compare != 0) {" + NL + "\t\t\t        return compare;" + NL + "\t\t\t    }" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_180 = NL + "\t\tif (arg0.";
  protected final String TEXT_181 = " == null) {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_182 = " != null) {" + NL + "\t\t\t    return -1;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_183 = " == null) {" + NL + "\t\t\t    return 1;" + NL + "\t\t\t} else {" + NL + "\t\t\t\tString arg0_";
  protected final String TEXT_184 = "_";
  protected final String TEXT_185 = " = String.valueOf(arg0.";
  protected final String TEXT_186 = ");" + NL + "\t\t\t\tString arg1_";
  protected final String TEXT_187 = "_";
  protected final String TEXT_188 = " = String.valueOf(arg1.";
  protected final String TEXT_189 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t    compare = arg0_";
  protected final String TEXT_190 = "_";
  protected final String TEXT_191 = ".compareTo";
  protected final String TEXT_192 = "(arg1_";
  protected final String TEXT_193 = "_";
  protected final String TEXT_194 = ");" + NL + "\t\t\t    if(compare != 0){" + NL + "\t\t\t\t\treturn compare;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_195 = NL + "\t\tif (arg0.";
  protected final String TEXT_196 = " == null) {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_197 = " != null) {" + NL + "\t\t\t    return -1;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_198 = " == null) {" + NL + "\t\t\t    return 1;" + NL + "\t\t\t} else {" + NL + "\t\t\t    compare = arg0.";
  protected final String TEXT_199 = ".compareTo";
  protected final String TEXT_200 = "(arg1.";
  protected final String TEXT_201 = ");" + NL + "\t\t\t    if (compare != 0) {" + NL + "\t\t\t        return compare;" + NL + "\t\t\t    }" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_202 = NL + "\t\tif (arg0.";
  protected final String TEXT_203 = " == null) {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_204 = " != null) {" + NL + "\t\t\t    return -1;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tif (arg1.";
  protected final String TEXT_205 = " == null) {" + NL + "\t\t\t    return 1;" + NL + "\t\t\t} else {" + NL + "\t\t\t\tString arg0_";
  protected final String TEXT_206 = "_";
  protected final String TEXT_207 = " = String.valueOf(arg0.";
  protected final String TEXT_208 = ");" + NL + "\t\t\t\tString arg1_";
  protected final String TEXT_209 = "_";
  protected final String TEXT_210 = " = String.valueOf(arg1.";
  protected final String TEXT_211 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t    compare = arg0_";
  protected final String TEXT_212 = "_";
  protected final String TEXT_213 = ".compareTo";
  protected final String TEXT_214 = "(arg1_";
  protected final String TEXT_215 = "_";
  protected final String TEXT_216 = ");" + NL + "\t\t\t    if(compare != 0){" + NL + "\t\t\t\t\treturn compare;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "        }" + NL + "\t\t\t";
  protected final String TEXT_217 = NL + NL + "        return arg0.id_";
  protected final String TEXT_218 = " - arg1.id_";
  protected final String TEXT_219 = ";" + NL + "    }" + NL + "" + NL + "}" + NL + "" + NL + "int bufferSize_1_";
  protected final String TEXT_220 = " = bufferSize_";
  protected final String TEXT_221 = ";" + NL + "" + NL + "rowStruct_";
  protected final String TEXT_222 = "[] buffer_1_";
  protected final String TEXT_223 = " = new rowStruct_";
  protected final String TEXT_224 = "[bufferSize_1_";
  protected final String TEXT_225 = "];" + NL + "" + NL + "for(int i_";
  protected final String TEXT_226 = " = 0; i_";
  protected final String TEXT_227 = " < buffer_1_";
  protected final String TEXT_228 = ".length; i_";
  protected final String TEXT_229 = "++){" + NL + "\tbuffer_1_";
  protected final String TEXT_230 = "[i_";
  protected final String TEXT_231 = "] = new rowStruct_";
  protected final String TEXT_232 = "();" + NL + "}" + NL + "" + NL + "int rowsInBuffer_1_";
  protected final String TEXT_233 = " = 0;" + NL + "" + NL + "Comparator<rowStruct_";
  protected final String TEXT_234 = "> comparator_1_";
  protected final String TEXT_235 = " = new Comparator_1_";
  protected final String TEXT_236 = "();" + NL + "" + NL + "java.util.ArrayList<java.io.File> files_1_";
  protected final String TEXT_237 = " = new java.util.ArrayList<java.io.File>();" + NL + "" + NL + "String workDirectory_";
  protected final String TEXT_238 = " = ";
  protected final String TEXT_239 = ";" + NL;
  protected final String TEXT_240 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String directory = ElementParameterParser.getValue(node, "__TEMP_DIRECTORY__");
String buffer = ElementParameterParser.getValue(node, "__BUFFER_SIZE__");
final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String bufferSize = "1000000";
if(("S").equals(buffer)){
	bufferSize = "500000";
}else if(("B").equals(buffer)){
	bufferSize = "2000000";
} else if(("M").equals(buffer)){
	bufferSize = "1000000";
} else {
	bufferSize = buffer;
}

if (("").equals(directory)) { 
	directory=ElementParameterParser.getValue(node.getProcess(), "__COMP_DEFAULT_FILE_DIR__") + "/temp"; 
} 
String cid = ElementParameterParser.getValue(node, "__CID__");

String connName = "";
if (node.getIncomingConnections().size()==1) {
	IConnection conn = node.getIncomingConnections().get(0);
	connName = conn.getName();
}

///////////////
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0) && !("").equals(connName)) {//HSS_____0
    IMetadataTable metadata = metadatas.get(0);
    List<IMetadataColumn> columnList = metadata.getListColumns();
    List<Map<String, String>> keyColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__UNIQUE_KEY__");
	List<IMetadataColumn> uniqueColumnList = new java.util.ArrayList<IMetadataColumn>();
	List<Boolean> uniqueColumnCaseFlagList = new java.util.ArrayList<Boolean>();
	for(int i = 0; i < keyColumns.size(); i++){
		Map<String, String> keyColumn = keyColumns.get(i);
		if(("true").equals(keyColumn.get("KEY_ATTRIBUTE"))){
			uniqueColumnList.add(columnList.get(i));
			uniqueColumnCaseFlagList.add(!("true").equals(keyColumn.get("CASE_SENSITIVE")));
		}
	}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(bufferSize );
    stringBuffer.append(TEXT_5);
    
if (isLog4jEnabled) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
	
	for(int i = 0; i < uniqueColumnList.size(); i++){//HSS_____0_____2
		IMetadataColumn keyColumn = uniqueColumnList.get(i);
		Boolean flag = uniqueColumnCaseFlagList.get(i);
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(keyColumn.getTalendType());
		boolean nullable = keyColumn.isNullable();
		
		if(javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.CHARACTER 
					|| javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.INTEGER 
					|| javaType == JavaTypesManager.LONG){//HSS_____0_____2_____1
			if(nullable){
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_21);
    
			}else{
			
    stringBuffer.append(TEXT_22);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_24);
    
			}
		}else if(javaType == JavaTypesManager.FLOAT || javaType == JavaTypesManager.DOUBLE){//HSS_____0_____2_____1
			if(nullable){
			
    stringBuffer.append(TEXT_25);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_30);
    
			}else{
			
    stringBuffer.append(TEXT_31);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_33);
    
			}
		}else if(javaType == JavaTypesManager.BOOLEAN){//HSS_____0_____2_____1
			if(nullable){
				
    stringBuffer.append(TEXT_34);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_41);
    
			}else{
				
    stringBuffer.append(TEXT_42);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_46);
    
			}
		}else if(javaType == JavaTypesManager.BYTE_ARRAY){//HSS_____0_____2_____1
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append((flag ? "IgnoreCase" : "") );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    
		}else if(javaType == JavaTypesManager.DATE){//HSS_____0_____2_____1
			
    stringBuffer.append(TEXT_62);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_67);
    
		}else if(javaType == JavaTypesManager.BIGDECIMAL){//HSS_____0_____2_____1
			
    stringBuffer.append(TEXT_68);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_73);
    
		}else if(javaType == JavaTypesManager.OBJECT){//HSS_____0_____2_____1
			
    stringBuffer.append(TEXT_74);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append((flag ? "IgnoreCase" : "") );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    
		}else if(javaType == JavaTypesManager.STRING){//HSS_____0_____2_____1
			
    stringBuffer.append(TEXT_89);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_93);
    stringBuffer.append((flag ? "IgnoreCase" : "") );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_95);
    
		}else if(javaType == JavaTypesManager.LIST){//HSS_____0_____2_____1
			
    stringBuffer.append(TEXT_96);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append((flag ? "IgnoreCase" : "") );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    
		}//HSS_____0_____2_____1
		
	}//HSS_____0_____2
	

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    
	
	for(int i = 0; i < uniqueColumnList.size(); i++){//HSS_____0_____3
		IMetadataColumn keyColumn = uniqueColumnList.get(i);
		Boolean flag = uniqueColumnCaseFlagList.get(i);
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(keyColumn.getTalendType());
		boolean nullable = keyColumn.isNullable();
		
		if(javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.CHARACTER 
					|| javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.INTEGER 
					|| javaType == JavaTypesManager.LONG){//HSS_____0_____3_____1
			if(nullable){
			
    stringBuffer.append(TEXT_116);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_121);
    
			}else{
			
    stringBuffer.append(TEXT_122);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_126);
    
			}
		}else if(javaType == JavaTypesManager.FLOAT || javaType == JavaTypesManager.DOUBLE){//HSS_____0_____3_____1
			if(nullable){
			
    stringBuffer.append(TEXT_127);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_134);
    
			}else{
			
    stringBuffer.append(TEXT_135);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_139);
    
			}
		}else if(javaType == JavaTypesManager.BOOLEAN){//HSS_____0_____3_____1
			if(nullable){
				
    stringBuffer.append(TEXT_140);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_147);
    
			}else{
				
    stringBuffer.append(TEXT_148);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_152);
    
			}
		}else if(javaType == JavaTypesManager.BYTE_ARRAY){//HSS_____0_____3_____1
			
    stringBuffer.append(TEXT_153);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append((flag ? "IgnoreCase" : "") );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    
		}else if(javaType == JavaTypesManager.DATE){//HSS_____0_____3_____1
			
    stringBuffer.append(TEXT_168);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_173);
    
		}else if(javaType == JavaTypesManager.BIGDECIMAL){//HSS_____0_____3_____1
			
    stringBuffer.append(TEXT_174);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_179);
    
		}else if(javaType == JavaTypesManager.OBJECT){//HSS_____0_____3_____1
			
    stringBuffer.append(TEXT_180);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append((flag ? "IgnoreCase" : "") );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    
		}else if(javaType == JavaTypesManager.STRING){//HSS_____0_____3_____1
			
    stringBuffer.append(TEXT_195);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_199);
    stringBuffer.append((flag ? "IgnoreCase" : "") );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_201);
    
		}else if(javaType == JavaTypesManager.LIST){//HSS_____0_____3_____1
			
    stringBuffer.append(TEXT_202);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append((flag ? "IgnoreCase" : "") );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(keyColumn.getLabel() );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    
		}//HSS_____0_____3_____1
		
	}//HSS_____0_____3
	

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
    stringBuffer.append(directory );
    stringBuffer.append(TEXT_239);
    
}//HSS_____0

    stringBuffer.append(TEXT_240);
    return stringBuffer.toString();
  }
}
